package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.content.res.Resources;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public b(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r9, xwb.d r10, String r11, OfficeWebView r12) {
        String r13 = (String) r9;
        Intrinsics.checkNotNullParameter(r10, "callback");
        MmEndWindowWebHelper r14 = this.a;
        r14.getClass();
        if (r13 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        int r15 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "getAvatarInfo", "data is empty", r14.f());
        r10.a(Status.FAILURE, "{\"error\":\"data is empty\"}");
    L24:
        Integer r16 = null;
    L25:
        if (r16 == null) goto L28;
        BuildersKt.launch$default(r14.c, null, null, new MmEndWindowWebHelper$getAvatarInfo$1(r14, r16.intValue(), r10, null), 3, null);
        return;
    L28:
        return;
    L12:
        Gson r1 = e0.a;
        if (((x) e0.a(r13, x.class)) == null) goto L23;
        float r17 = 0;
        OfficeWebView r18 = r14.g;
        if (r18 == null) goto L17;
        float r19 = r18.getScale();
    L18:
        int r20 = (int) (r17 * r19);
        int r110 = UIHelper.dp2px(32.0f);
        if (r20 < r110) goto L22;
        r110 = r20;
    L22:
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "getAvatarInfo", "originSize=0, webScale=" + r20 + ", avatarSize=" + r110, r14.f());
        r16 = Integer.valueOf(r110);
        goto L25
    L17:
        Resources r111 = r14.d.getContext().getResources();
        r19 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).density;
        goto L18
    L23:
        int r21 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "getAvatarInfo", "avatarSize is null", r14.f());
        r10.a(Status.FAILURE, "{\"error\":\"avatarSize is null\"}");
        goto L24
    L5:
        if (r13.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
