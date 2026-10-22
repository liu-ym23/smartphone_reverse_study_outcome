package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmAISummaryLayoutData;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public e(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r4, xwb.d r5, String r6, OfficeWebView r7) {
        String r8 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "callback");
        lvb.a.e(this.a.d, "[vc_web_ready]");
        MmSummaryWebHelper r9 = this.a;
        r9.g = true;
        r9.h = false;
        MmAISummaryLayoutData r10 = r9.j;
        if (r10 == null) goto L5;
        lvb.a.e(r9.d, "[flushPendingFishBoneData] flush pending data, timestamp=" + r10.getTimeStamp());
        int r11 = b.a;
        b.b(r9.e, r10);
    L5:
        this.a.b.g();
        MmSummaryWebHelper r12 = this.a;
        if (r12.m == false) goto L8;
        lvb.a.e(r12.d, "[triggerPreRender] already pre-rendered, skip");
        return;
    L8:
        r12.m = true;
        lvb.a.e(r12.d, "[triggerPreRender] trigger pre-render");
        OfficeWebView r13 = r12.e;
        if (r13 == null) goto L13;
        r13.post(new n(r12));
        return;
    }
}
