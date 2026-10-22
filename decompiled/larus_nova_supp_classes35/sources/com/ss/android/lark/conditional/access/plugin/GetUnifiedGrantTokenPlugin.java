package com.ss.android.lark.conditional.access.plugin;

import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.ss.android.lark.active.user.bridge.g;
import com.ss.android.lark.active.user.bridge.r;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import i18.c;
import io.reactivex.Observable;
import j18.f;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/conditional/access/plugin/GetUnifiedGrantTokenPlugin;", "Lcom/larksuite/framework/apiplugin/AutoRegisterLKPlugin;", "<init>", "()V", "getUnifiedGrantToken", BuildConfig.FLAVOR, "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "lkBridgeContext", "Lcom/larksuite/framework/apiplugin/LKBridgeContext;", "request", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/ss/android/lark/conditional/access/plugin/GetUnifiedGrantTokenResponseModel;", "onRelease", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUnifiedGrantTokenPlugin extends i18.b {
    public static final a Companion = null;
    public static final String TAG = "SecurityPolicy_GetUnifiedGrantTokenPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onRelease() {
        ScsLogger.d(TAG, "onRelease()");
    }

    public GetUnifiedGrantTokenPlugin() {
    }

    @LKPluginFunction(async = true, eventName = {"getUnifiedGrantToken"})
    public final void getUnifiedGrantToken(LKEvent r3, c r4, LKBaseRequestModel r5, final f<GetUnifiedGrantTokenResponseModel> r6) {
        Intrinsics.checkNotNullParameter(r3, "lkEvent");
        if (w4c.c.a().g0() == true) goto L8;
        ScsLogger.d(TAG, "getUnifiedGrantToken() switch is off");
        if (r6 == null) goto L23;
        r6.callback(new GetUnifiedGrantTokenResponseModel());
        return;
    L23:
        return;
    L8:
        ScsLogger.d(TAG, "getUnifiedGrantToken() switch is on");
        final String r7 = ((xzb.a) ApiUtils.getApi(xzb.a.class)).getUserId();
        g r8 = (g) k.a(LarkContext.getApplication(), g.class);
        int r0 = r.c;
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(com.ss.android.lark.conditional.access.plugin.a.class, "value");
        com.ss.android.lark.active.user.bridge.a r9 = r8.a(new r(r7, com.ss.android.lark.conditional.access.plugin.a.class)).c();
        if ((r9 instanceof com.ss.android.lark.active.user.bridge.a) == false) goto L16;
        StringBuilder r10 = new StringBuilder("invoke rust err,uid:");
        r10.append(r7);
        r10.append(" err:");
        Throwable r11 = r9.d;
        if (r11 == null) goto L13;
        String r12 = r11.getMessage();
    L14:
        r10.append(r12);
        ScsLogger.c(TAG, r10.toString());
        return;
    L13:
        r12 = null;
        goto L14
    L16:
        if ((r9 instanceof com.ss.android.lark.active.user.bridge.c) == false) goto L22;
        Observable r13 = (Observable) ((com.ss.android.lark.active.user.bridge.b) ((com.ss.android.lark.active.user.bridge.c) r9)).c;
        if (r13 == null) goto L25;
        t.a(r13, new AnonymousClass1(r6), new AnonymousClass2(r7), new AnonymousClass3(r7));
        return;
    L25:
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
