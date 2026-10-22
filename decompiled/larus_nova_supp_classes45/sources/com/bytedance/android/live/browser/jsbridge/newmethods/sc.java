package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.ShowAnchorColumnPosterDialogResultModel;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.ve;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showAnchorColumnPosterDialog")
public final class sc extends w20.n6<ve, ShowAnchorColumnPosterDialogResultModel> {
    public sc() {
    }

    public final void invoke(Object r11, CallContext r12) {
        ve r13 = (ve) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        String r1 = r13.c();
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        String r2 = r13.b();
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        String r5 = r13.a();
        if (r5 != null) goto L13;
        String r6 = "";
    L14:
        String r7 = r13.g();
        if (r7 != null) goto L17;
        String r8 = "";
    L18:
        String r9 = r13.f();
        if (r9 != null) goto L21;
        String r14 = "";
    L22:
        String r15 = r13.e();
        if (r15 != null) goto L25;
        String r16 = "";
    L26:
        String r17 = r13.d();
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        AnchorColumnPosterInfo r0 = new AnchorColumnPosterInfo(r3, r4, r6, r8, r14, r16, r17);
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L34;
        f00.a.C0230a r18 = f00.a.b;
        g00.c r19 = (g00.c) com.bytedance.android.scope.m.e.d(r18, g00.c.class);
        if (r19 == null) goto L35;
        r19.openPosterGenerateDialog(r12.getContext(), r0);
    L35:
        finishWithSuccess();
        return;
    L34:
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).openPosterGenerateDialog(r12.getContext(), r0);
        goto L35
    L25:
        r16 = r15;
        goto L26
    L21:
        r14 = r9;
        goto L22
    L17:
        r8 = r7;
        goto L18
    L13:
        r6 = r5;
        goto L14
    L9:
        r4 = r2;
        goto L10
    L5:
        r3 = r1;
        goto L6
    }
}
