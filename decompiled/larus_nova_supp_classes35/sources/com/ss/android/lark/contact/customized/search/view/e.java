package com.ss.android.lark.contact.customized.search.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnLayoutChangeListener {
    public final /* synthetic */ String a;

    public e(String r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r1 instanceof TextView) == false) goto L5;
        TextView r10 = (TextView) r1;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        CharSequence r11 = TextUtils.ellipsize(this.a, r10.getPaint(), RangesKt.coerceAtLeast((r10.getWidth() - r10.getPaddingLeft()) - r10.getPaddingRight(), 0), TextUtils.TruncateAt.END);
        if (Intrinsics.areEqual(r10.getHint(), r11) == true) goto L12;
        r10.setHint(r11);
        return;
    L12:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
