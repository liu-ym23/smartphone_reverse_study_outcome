package com.larus.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c1 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ View f;

    public /* synthetic */ c1(View r1, int r2, int r3, int r4, int r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        int r4 = this.e;
        View r5 = this.f;
        Rect r6 = new Rect();
        r0.getHitRect(r6);
        r6.left -= r1;
        r6.top -= r2;
        r6.right += r3;
        r6.bottom += r4;
        r5.setTouchDelegate(new TouchDelegate(r6, r0));
    }
}
