package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.h f14237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f14238b;
    private int c;

    private v(RecyclerView.h r2) {
        this.c = Integer.MIN_VALUE;
        this.f14238b = new Rect();
        this.f14237a = r2;
    }

    /* synthetic */ v(RecyclerView.h r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static v a(final RecyclerView.h r1) {
        return new AnonymousClass1(r1);
    }

    public static v a(RecyclerView.h r1, int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L8;
        return b(r1);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return a(r1);
    }

    public static v b(final RecyclerView.h r1) {
        return new AnonymousClass2(r1);
    }

    public abstract int a(View r1);

    public void a() {
        this.c = f();
    }

    public abstract void a(int r1);

    public int b() {
        if (Integer.MIN_VALUE != this.c) goto L6;
        return 0;
    L6:
        return f() - this.c;
    }

    public abstract int b(View r1);

    public abstract int c();

    public abstract int c(View r1);

    public abstract int d();

    public abstract int d(View r1);

    public abstract int e();

    public abstract int e(View r1);

    public abstract int f();

    public abstract int f(View r1);

    public abstract int g();

    public abstract int h();

    public abstract int i();
}
