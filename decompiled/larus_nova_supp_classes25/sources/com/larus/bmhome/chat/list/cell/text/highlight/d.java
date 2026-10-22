package com.larus.bmhome.chat.list.cell.text.highlight;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import va8.p;
import va8.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ q0 b;
    public final /* synthetic */ p c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ long e;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return !SearchLandingHighlightHelper.a.a(this.a, this.b, this.c, this.d, false, this.e);
    }

    public d(TextView r1, q0 r2, p r3, boolean r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
