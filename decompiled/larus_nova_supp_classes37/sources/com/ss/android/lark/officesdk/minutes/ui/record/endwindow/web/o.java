package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.text.TextUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public o(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r2, xwb.d r3, String r4, OfficeWebView r5) {
        String r6 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (r6 == null) goto L8;
        MmEndWindowWebHelper r7 = this.a;
        r7.getClass();
        String r8 = new JSONObject(r6).optString("toastMsg");
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "showToastFromWeb", "toastMsg=" + r8, r7.f());
        if (TextUtils.isEmpty(r8) == true) goto L9;
        MmRecordingUILaunchMode r10 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
        Intrinsics.checkNotNull(r8);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(r8);
        return;
    L9:
        return;
    }
}
