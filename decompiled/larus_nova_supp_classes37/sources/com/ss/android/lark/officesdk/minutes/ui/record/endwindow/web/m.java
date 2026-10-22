package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.Gson;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public m(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r5, xwb.d r6, String r7, OfficeWebView r8) {
        String r9 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "callback");
        MmEndWindowWebHelper r10 = this.a;
        r10.getClass();
        if (r9 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L23;
        int r11 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "onChangeSpeaker", "data is null or blank", r10.f());
        Status r12 = Status.FAILURE;
        Gson r13 = e0.a;
        MmEndWindowChangeSpeakerResponse.Companion.getClass();
        r6.a(r12, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));
        return;
    L23:
        Gson r2 = e0.a;     // Catch: Exception -> L20
        MmEndWindowChangeSpeakerParam r3 = (MmEndWindowChangeSpeakerParam) e0.a(r9, MmEndWindowChangeSpeakerParam.class);     // Catch: Exception -> L20
        if (r3 == null) goto L15;
        MmEndWindowChangeSpeakerOrigin r4 = r3.getOrigin();     // Catch: Exception -> L20
    L16:
        if (r4 != null) goto L18;
        int r0 = bwb.b.a;     // Catch: Exception -> L20
        bwb.b.d(MmUiLogScene.WEB, "onChangeSpeaker", "invalid param: " + r9, r10.f());     // Catch: Exception -> L20
        Status r14 = Status.FAILURE;     // Catch: Exception -> L20
        MmEndWindowChangeSpeakerResponse.Companion.getClass();     // Catch: Exception -> L20
        r6.a(r14, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));     // Catch: Exception -> L20
        return;
    L18:
        int r15 = bwb.b.a;     // Catch: Exception -> L20
        bwb.b.f(MmUiLogScene.WEB, "onChangeSpeaker", "clusterId=" + r3.getOrigin().getClusterId(), r10.f());     // Catch: Exception -> L20
        r10.e.h(r3.getOrigin(), r6);     // Catch: Exception -> L20
        return;
    L15:
        r4 = null;
    L20:
        e = move-exception;
        int r16 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "onChangeSpeaker", "parse data error: " + e.getMessage(), r10.f());
        Status r17 = Status.FAILURE;
        Gson r18 = e0.a;
        MmEndWindowChangeSpeakerResponse.Companion.getClass();
        r6.a(r17, e0.c(MmEndWindowChangeSpeakerResponse.a.a()));
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r1 = false;
        goto L10
    }
}
