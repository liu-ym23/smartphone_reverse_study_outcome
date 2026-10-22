package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public d(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r3, xwb.d r4, String r5, OfficeWebView r6) {
        String r7 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        MmEndWindowWebHelper r8 = this.a;
        r8.getClass();
        if (r7 == null) goto L9;
        String r9 = new JSONObject(r7).optString("userId");
        Intrinsics.checkNotNull(r9);
        if (StringsKt.isBlank(r9) == false) goto L7;
        int r10 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "onOpenProfile", "userId is blank", r8.f());
        return;
    L7:
        int r11 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "onOpenProfile", "onOpenProfile userId = " + r9, r8.f());
        r8.e.j(r9);
        return;
    }
}
