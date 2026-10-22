package com.bytedance.android.live.search.impl.search;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements TextWatcher {
    public final /* synthetic */ LiveSearchResultFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    public l(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        Intrinsics.checkNotNullParameter(r4, "s");
        LiveSearchResultFragment r0 = this.a;
        String r5 = r4.toString();
        if (r0.q == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        View r1 = r0.n;
        if (r1 == null) goto L15;
        if (r1.getVisibility() != 8) goto L15;
        View r2 = r0.n;
        if (r2 == null) goto L24;
        r2.setVisibility(0);
    L24:
        if (TextUtils.equals(r0.o, r5) == true) goto L36;
        r0.o = r5.toString();
        if (TextUtils.isEmpty(r5) == false) goto L30;
        r0.W90();
        return;
    L30:
        if (r0.m == 1) goto L37;
        r0.X90();
        return;
    L37:
        return;
    L36:
        return;
    L15:
        if (TextUtils.isEmpty(r5) == false) goto L24;
        View r3 = r0.n;
        if (r3 == null) goto L24;
        if (r3.getVisibility() != 0) goto L24;
        View r6 = r0.n;
        if (r6 == null) goto L24;
        r6.setVisibility(8);
        goto L24
    }
}
