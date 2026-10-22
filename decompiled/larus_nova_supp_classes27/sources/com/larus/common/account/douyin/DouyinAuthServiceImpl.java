package com.larus.common.account.douyin;

import android.app.Activity;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.larus.account.base.api.IDouyinAuthService;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.l0;
import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import n38.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/common/account/douyin/DouyinAuthServiceImpl;", "Lcom/larus/account/base/api/IDouyinAuthService;", "<init>", "()V", "startDouyinAuth", "", "clientKey", "", "scope", "state", "isMiniApplication", "callback", "Lcom/larus/account/base/api/IDouyinAuthCallback;", "checkDouyinAuthStatus", "", "Lcom/larus/account/base/api/IDouyinAuthStatusCheckCallback;", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinAuthServiceImpl implements IDouyinAuthService {
    public DouyinAuthServiceImpl() {
    }

    public final void a(String r16, String r17, String r18, l0 r110) {
        Intrinsics.checkNotNullParameter(r16, "clientKey");
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r18, "state");
        Intrinsics.checkNotNullParameter(r110, "callback");
        q r8 = f.b;
        Intrinsics.checkNotNullParameter(r16, "clientKey");
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r18, "state");
        Intrinsics.checkNotNullParameter(r110, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DouyinAuthHelper$checkDouyinAuthStatus$1(r16, r17, r18, r110, null), 2, null);
    }

    public final boolean b(String r9, String r10, String r11, boolean r12, q r13) {
        Intrinsics.checkNotNullParameter(r9, "clientKey");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "state");
        if (r12 == false) goto L31;
        q r14 = f.b;
        Intrinsics.checkNotNullParameter(r9, "clientKey");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "state");
        long r0 = System.currentTimeMillis();
        boolean r15 = false;
        if (f.a <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
    L14:
        f.a = r0;
        f.b = r13;
        DouYinOpenConfig r16 = com.bytedance.sdk.open.douyin.a.getConfig();
        if (r16 == null) goto L17;
        String r17 = r16.clientKey;
    L19:
        if (Intrinsics.areEqual(r17, r9) == true) goto L21;
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r9));
    L21:
        JSONObject r18 = new JSONObject();
        r18.put("original_state", r11);
        r18.put("latest_auth_start_time", r0);
        HashSet r110 = new HashSet();
        r110.add(r10);
        Request r20 = new Request.Builder().setScopes(r110).setState(r18.toString()).setCallerLocalEntry("com.larus.nova.douyinapi.MiniApplicationDouYinEntryActivity").build();
        Activity r111 = AppHost.a.a().getCurrentActivity();
        if (r111 == null) goto L34;
        IDouYin2Service r112 = AuthorizeFramework.getService(IDouYin2Service.class);
        if (r112 != null) goto L26;
    L28:
        if (r15 == true) goto L35;
        f.a = -1;
        f.b = null;
        return r15;
    L35:
        return r15;
    L26:
        if (r112.authorize(r111, r20, null) != true) goto L28;
        r15 = true;
        goto L28
    L34:
        return false;
    L17:
        r17 = null;
        goto L19
    L10:
        if ((r0 - f.a) >= 1000) goto L14;
        FLogger.a.i("DouyinAuthHelper", "onResult:false, errorCode:null, errorMsg:another_auth_task_is_just_in_progress, permissions:" + r10);
        if (r13 == null) goto L32;
        q.a.a(r13);
        return false;
    L32:
        return false;
    L7:
        r2 = false;
        goto L8
    L31:
        return f.b(r9, r10, r11, r13);
    }
}
