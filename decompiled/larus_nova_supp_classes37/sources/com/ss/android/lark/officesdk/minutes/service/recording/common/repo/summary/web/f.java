package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public f(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        String r5 = (String) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        lvb.a.e(this.a.d, "[common_fish_bone_content_update] data=" + r5);
        if (r5 == null) goto L8;
        MmSummaryWebHelper r6 = this.a;
        if (new JSONObject(r5).optBoolean("hasContent", false) == false) goto L9;
        r6.b.j();
        return;
    L9:
        return;
    }
}
