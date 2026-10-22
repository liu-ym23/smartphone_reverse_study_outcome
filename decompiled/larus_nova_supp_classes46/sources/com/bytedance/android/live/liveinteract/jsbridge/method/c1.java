package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.LiveReportAggregateALogResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w20.bb;
import w20.h3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c1 extends h3<bb, LiveReportAggregateALogResultModel> {
    public c1() {
    }

    public final void invoke(Object r4, CallContext r5) {
        bb r6 = (bb) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        List r7 = r6.a();
        if (r7 == null) goto L35;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L35;
        bb.a r9 = (bb.a) r8.next();
        String r0 = r9.a();
        String r1 = r9.c();
        String r10 = r9.b();
        if (TextUtils.isEmpty(r0) == true) goto L34;
        if (TextUtils.isEmpty(r1) == true) goto L34;
        if (TextUtils.isEmpty(r10) == true) goto L34;
        if (r0 == null) goto L6;
        switch(r0.hashCode()) {
            case 3237038: goto L32;
            case 3641990: goto L29;
            case 95458899: goto L26;
            case 96784904: goto L23;
            case 351107458: goto L20;
            default: goto L6;
        };
    L20:
        if (r0.equals("verbose") == false) goto L6;
        ALogger.v(r1, r10);
        goto L6
    L23:
        if (r0.equals("error") == false) goto L6;
        ALogger.e(r1, r10);
        goto L6
    L26:
        if (r0.equals("debug") == false) goto L6;
        ALogger.d(r1, r10);
        goto L6
    L29:
        if (r0.equals("warn") == false) goto L6;
        ALogger.w(r1, r10);
        goto L6
    L32:
        if (r0.equals("info") == false) goto L6;
        ALogger.i(r1, r10);
    L34:
        finishWithFailure();
        return;
    L35:
        LiveReportAggregateALogResultModel r11 = new LiveReportAggregateALogResultModel();
        r11.a(LiveReportAggregateALogResultModel.Code.Success);
        finishWithResult(r11);
    }
}
