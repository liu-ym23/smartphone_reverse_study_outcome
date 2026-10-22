package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public p(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        String r5 = (String) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r5 == null) goto L6;
        MmEndWindowWebHelper r6 = this.a;
        r6.getClass();
        JSONObject r7 = new JSONObject(r5);
        String r8 = r7.optString("eventName");
        String r9 = r7.optString("eventParams");
        w r10 = r6.e;
        Intrinsics.checkNotNull(r8);
        r10.b(r8, new JSONObject(r9));
        return;
    }
}
