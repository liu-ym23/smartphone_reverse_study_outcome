package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final OfficeWebViewAdapter a(OfficeWebView r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r1 = r3.getTag(2131367585);
        if ((r1 instanceof OfficeWebViewAdapter) == false) goto L5;
        OfficeWebViewAdapter r2 = (OfficeWebViewAdapter) r1;
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        OfficeWebViewAdapter r4 = new OfficeWebViewAdapter(r3);
        r3.setTag(2131367585, r4);
        return r4;
    L5:
        r2 = null;
        goto L6
    }
}
