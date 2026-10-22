package com.larus.common.account.douyin;

import android.app.Activity;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.account.douyin.network.DouyinAuthNetHelper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import n38.q;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static volatile long a;
    public static q b;
    public static boolean c;

    public static final class a implements DouyinAuthNetHelper.c {
        public final /* synthetic */ Authorization.Response a;
        public final /* synthetic */ q b;
        public final /* synthetic */ String c;

        @Override // com.larus.common.account.douyin.network.DouyinAuthNetHelper.c
        public final void onResult(boolean r11) {
            FLogger.a.i("DouyinAuthHelper", "onResult:" + r11 + ", errorCode:" + ((BaseResp) this.a).errorCode + ", errorMsg:" + ((BaseResp) this.a).errorMsg + ", permissions:" + this.a.grantedPermissions);
            q r3 = this.b;
            if (r3 == null) goto L6;
            Integer r5 = Integer.valueOf(((BaseResp) this.a).errorCode);
            Authorization.Response r0 = this.a;
            r3.a(r11, r5, ((BaseResp) r0).errorMsg, r0.authCode, this.c, r0.grantedPermissions);
            return;
        }

        public a(Authorization.Response r1, q r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = -1;
    }

    public static void a(Authorization.Response r7) {
        Intrinsics.checkNotNullParameter(r7, "resp");
        if (r7.state != null) goto L15;
        c = true;
        EnsureManager.ensureNotReachHere(new Exception("state_is_null"), "DouyinAuthHelper");
        return;
    L15:
        JSONObject r0 = new JSONObject(r7.state);     // Catch: JSONException -> L12
        if (a == r0.optLong("latest_auth_start_time")) goto L10;
        return;
    L10:
        FLogger.a.i("DouyinAuthHelper", "authExchangeToken triggered, hasNullStateBefore: " + c);
        c = false;
        String r1 = r0.optString("original_state");
        r7.state = r1;
        q r2 = b;
        b = null;
        a = -1;
        DouyinAuthNetHelper r3 = DouyinAuthNetHelper.a;
        DouyinAuthNetHelper.a(r7, new a(r7, r2, r1));
        return;
    L12:
        e = move-exception;
        FLogger.a.e("DouyinAuthHelper", "wrapped state format error", e);
    }

    public static boolean b(String r9, String r10, String r11, q r12) {
        Intrinsics.checkNotNullParameter(r9, "clientKey");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "state");
        long r0 = System.currentTimeMillis();
        boolean r6 = false;
        if (a <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L13:
        a = r0;
        b = r12;
        DouYinOpenConfig r13 = com.bytedance.sdk.open.douyin.a.getConfig();
        if (r13 == null) goto L16;
        String r14 = r13.clientKey;
    L18:
        if (Intrinsics.areEqual(r14, r9) == true) goto L20;
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r9));
    L20:
        JSONObject r15 = new JSONObject();
        r15.put("original_state", r11);
        r15.put("latest_auth_start_time", r0);
        HashSet r16 = new HashSet();
        r16.add(r10);
        Request r17 = new Request.Builder().setScopes(r16).setState(r15.toString()).setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity").build();
        Activity r18 = AppHost.a.a().getCurrentActivity();
        if (r18 == null) goto L29;
        IDouYin2Service r110 = AuthorizeFramework.getService(IDouYin2Service.class);
        if (r110 != null) goto L25;
    L27:
        if (r6 == true) goto L29;
        a = -1;
        b = null;
        goto L29
    L25:
        if (r110.authorize(r18, r17, null) != true) goto L27;
        r6 = true;
    L29:
        return r6;
    L16:
        r14 = null;
        goto L18
    L8:
        if ((r0 - a) >= 1000) goto L13;
        FLogger.a.i("DouyinAuthHelper", "onResult:false, errorCode:null, errorMsg:another_auth_task_is_just_in_progress, permissions:" + r10);
        if (r12 == null) goto L12;
        q.a.a(r12);
    L12:
        return false;
    L5:
        r2 = false;
        goto L6
    }
}
