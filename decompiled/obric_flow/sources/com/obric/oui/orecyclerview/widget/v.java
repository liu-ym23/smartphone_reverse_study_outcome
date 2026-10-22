package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f13920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f13922c;

    public v(s r5) {
        this.f13921b = Integer.MIN_VALUE;
        this.f13922c = new Rect();
        this.f13920a = r5;
    }

    public abstract int a(View r5);

    public abstract int b(View r5);

    public abstract int c(View r5);

    public abstract int d(View r5);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public final int k() {
        if (Integer.MIN_VALUE != this.f13921b) goto L6;
        return 0;
    L6:
        return j() - this.f13921b;
    }

    public abstract int l(View r5);

    public abstract int m(View r5);

    public abstract void n(int r5);
}
