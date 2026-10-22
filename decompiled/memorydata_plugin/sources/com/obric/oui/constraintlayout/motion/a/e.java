package com.obric.oui.constraintlayout.motion.a;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13664b;
    public int c;
    public int d;
    public int e;

    public e() {
    }

    public int a() {
        return this.d - this.f13664b;
    }

    public void a(View r2) {
        this.f13664b = r2.getLeft();
        this.c = r2.getTop();
        this.d = r2.getRight();
        this.e = r2.getBottom();
        this.f13663a = r2.getRotation();
    }

    public int b() {
        return this.e - this.c;
    }
}
