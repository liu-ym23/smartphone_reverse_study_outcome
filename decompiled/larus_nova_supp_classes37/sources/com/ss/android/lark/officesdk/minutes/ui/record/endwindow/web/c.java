package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.content.res.Resources;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public c(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r11, xwb.d r12, String r13, OfficeWebView r14) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        MmEndWindowWebHelper r3 = this.a;
        r3.getClass();
        Gson r15 = e0.a;
        MmGetAvatarBase64Param r1 = (MmGetAvatarBase64Param) e0.a((String) r11, MmGetAvatarBase64Param.class);
        if (r1 == null) goto L7;
        boolean r16 = true;
        if (r1.isValid() != true) goto L7;
    L8:
        if (r16 == true) goto L10;
        r12.a(Status.FAILURE, "{\"error\":\"invalid param\"}");
        return;
    L10:
        float r17 = r1.getSize();
        OfficeWebView r18 = r3.g;
        if (r18 == null) goto L13;
        float r19 = r18.getScale();
    L14:
        BuildersKt.launch$default(r3.c, null, null, new MmEndWindowWebHelper$onGetAvatarBase64$1(r1, (int) (r17 * r19), r3, r12, null), 3, null);
        return;
    L13:
        Resources r110 = r3.d.getContext().getResources();
        r19 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).density;
    L7:
        r16 = false;
        goto L8
    }
}
