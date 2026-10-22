package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.text.TextUtils;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public q(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r3, xwb.d r4, String r5, OfficeWebView r6) {
        String r7 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r8 = bwb.b.a;
        MmUiLogScene r9 = MmUiLogScene.WEB;
        bwb.b.f(r9, "openWebPage", "data=" + r7 + ", extraStr=" + r5, this.a.f());
        if (r7 == null) goto L9;
        MmEndWindowWebHelper r10 = this.a;
        r10.getClass();
        String r11 = new JSONObject(r7).optString("url");
        if (TextUtils.isEmpty(r11) == false) goto L7;
        bwb.b.d(r9, "openWebPage", "url is null", r10.f());
        return;
    L7:
        bwb.b.f(r9, "openWebPage", "url=" + r11, r10.f());
        w r12 = r10.e;
        Intrinsics.checkNotNull(r11);
        r12.e(r11);
        return;
    }
}
