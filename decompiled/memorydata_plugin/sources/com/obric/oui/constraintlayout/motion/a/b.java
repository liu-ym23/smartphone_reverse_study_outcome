package com.obric.oui.constraintlayout.motion.a;

import com.obric.oui.constraintlayout.core.motion.a.k;
import com.obric.oui.constraintlayout.core.motion.a.m;
import com.obric.oui.constraintlayout.core.motion.a.n;
import com.obric.oui.constraintlayout.motion.widget.o;

/* JADX INFO: loaded from: classes5.dex */
public class b extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f13661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f13662b;
    private m c;

    public b() {
        n r0 = new n();
        this.f13661a = r0;
        this.c = r0;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.o
    public float a() {
        return this.c.a();
    }

    public void a(float r8, float r9, float r10, float r11, float r12, float r13) {
        n r0 = this.f13661a;
        this.c = r0;
        r0.a(r8, r9, r10, r11, r12, r13);
    }

    public void a(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.f13662b != null) goto L5;
        this.f13662b = new k();
    L5:
        k r2 = this.f13662b;
        this.c = r2;
        r2.a(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public boolean b() {
        return this.c.b();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return this.c.a(r1);
    }
}
