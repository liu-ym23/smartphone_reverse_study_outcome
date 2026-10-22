package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public k(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r3, xwb.d r4, String r5, OfficeWebView r6) {
        String r7 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r7 == null) goto L6;
        MmSummaryWebHelper r8 = this.a;
        JSONObject r9 = new JSONObject(r7);
        String r10 = r9.optString("eventName", "");
        String r11 = r9.optString("eventParams", "");
        lvb.a.a(r8.d, "[common_send_track_event] eventName=" + r10);
        MmSummaryWebHelper.a r12 = r8.b;
        Intrinsics.checkNotNull(r10);
        r12.b(r10, new JSONObject(r11));
        return;
    }
}
