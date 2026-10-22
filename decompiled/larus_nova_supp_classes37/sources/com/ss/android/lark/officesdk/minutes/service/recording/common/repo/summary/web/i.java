package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmSummaryWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public i(MmSummaryWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r5, xwb.d r6, String r7, OfficeWebView r8) {
        String r9 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r9 == null) goto L18;
        MmSummaryWebHelper r10 = this.a;
        r10.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(new JSONObject(r9).optString("toastMsg"));     // Catch: Throwable -> L7
    L9:
        Throwable r1 = Result.exceptionOrNull-impl(r11);
        if (r1 == null) goto L13;
        lvb.a.b(r10.d, "[showToastFromWeb] parse failed: " + r1);
    L13:
        if (Result.isFailure-impl(r11) == false) goto L15;
        r11 = "";
    L15:
        String r12 = (String) r11;
        lvb.a.e(r10.d, "[showToastFromWeb] toastMsgLength=" + r12.length());
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L18;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(r12);
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        r6.a(Status.SUCCESS, "");
    }
}
