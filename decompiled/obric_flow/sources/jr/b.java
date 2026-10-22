package jr;

import com.obric.oui.constraintlayout.motion.widget.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gr.m f18431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gr.j f18432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gr.l f18433c;

    public b() {
        gr.m r5 = new gr.m();
        r5.f17166k = false;
        this.f18431a = r5;
        this.f18433c = r5;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.r
    public final float a() {
        return this.f18433c.a();
    }

    public final void b(float r10, float r11, float r12, float r13, float r14, float r15) {
        gr.m r5 = this.f18431a;
        this.f18433c = r5;
        r5.f17167l = r10;
        if (r10 <= r11) goto L5;
        boolean r16 = true;
    L6:
        r5.f17166k = r16;
        if (r16 == false) goto L9;
        r5.d(-r12, r10 - r11, r14, r15, r13);
        return;
    L9:
        r5.d(r12, r11 - r10, r14, r15, r13);
        return;
    L5:
        r16 = false;
        goto L6
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r5) {
        return this.f18433c.getInterpolation(r5);
    }
}
