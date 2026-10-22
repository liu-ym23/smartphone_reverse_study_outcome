package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9803c;
    public float d;

    public e(float r5, float r10, float r11, float r12) {
        this.f9801a = r5;
        this.f9802b = r10;
        this.f9803c = r11;
        this.d = r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[");
        r5.append(this.f9801a);
        r5.append(" ");
        r5.append(this.f9802b);
        r5.append(" ");
        r5.append(this.f9803c);
        r5.append(" ");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.d, "]");
    }

    public e(e r5) {
        this.f9801a = r5.f9801a;
        this.f9802b = r5.f9802b;
        this.f9803c = r5.f9803c;
        this.d = r5.d;
    }
}
