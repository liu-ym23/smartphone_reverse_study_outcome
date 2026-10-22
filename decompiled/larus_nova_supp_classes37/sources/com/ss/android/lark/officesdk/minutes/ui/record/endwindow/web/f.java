package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public f(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r7, xwb.d r8, String r9, OfficeWebView r10) {
        String r11 = (String) r7;
        Intrinsics.checkNotNullParameter(r8, "callback");
        MmEndWindowWebHelper r12 = this.a;
        r12.getClass();
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "onGetDoubaoUserInfo", "data=" + r11, r12.f());
        Gson r14 = e0.a;
        MmGetDoubaoUserInfoParam r15 = (MmGetDoubaoUserInfoParam) e0.a(r11, MmGetDoubaoUserInfoParam.class);
        if (r15 == null) goto L7;
        boolean r0 = true;
        if (r15.isValid() != true) goto L7;
    L8:
        if (r0 == true) goto L10;
        r8.a(Status.FAILURE, "{\"error\":\"invalid param\"}");
        return;
    L10:
        BuildersKt.launch$default(r12.c, null, null, new MmEndWindowWebHelper$onGetDoubaoUserInfo$1(r12, r15, r8, null), 3, null);
        return;
    L7:
        r0 = false;
        goto L8
    }
}
