package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f12515h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12518c;
    public float d;
    public float e;
    public final Paint f;
    public float g;

    static {
        int r5 = 0;
        float r10 = 0.0f;
        float r11 = 0.0f;
        f12515h = new m(r5, r10, r11, 0.0f, 0.0f);
    }

    public m(int r5, float r10, float r11, float r12, float r13, Paint r14, float r15) {
        Intrinsics.checkNotNullParameter(r14, "paint");
        this.f12516a = r5;
        this.f12517b = r10;
        this.f12518c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    public static final m b(es.a r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        int r5 = r10.d;
        float r11 = r10.f16860c;
        m r12 = new m(r5, r11, r10.f16858a, r10.f16859b, r10.e);
        if (r11 <= 0.0f) goto L5;
        r12.f.setMaskFilter(new BlurMaskFilter(r12.f12517b, BlurMaskFilter.Blur.NORMAL));
    L6:
        return r12;
    L5:
        r12.f.setMaskFilter(null);
        goto L6
    }

    public final m a() {
        int r5 = this.f12516a;
        float r10 = this.f12517b;
        float r11 = this.f12518c;
        float r12 = this.d;
        float r13 = this.e;
        Paint r14 = this.f;
        Paint r15 = new Paint(r14);
        r15.set(r14);
        Unit r16 = Unit.INSTANCE;
        return new m(r5, r10, r11, r12, r13, r15, this.g);
    }

    public final void c(m r5) {
        if (r5 == null) goto L11;
        this.f12516a = r5.f12516a;
        this.f12518c = r5.f12518c;
        this.d = r5.d;
        this.e = r5.e;
        float r10 = this.f12517b;
        float r11 = r5.f12517b;
        if (r10 == r11) goto L15;
        this.f12517b = r11;
        Paint r12 = this.f;
        if (r11 <= 0.0f) goto L10;
        r12.setMaskFilter(new BlurMaskFilter(this.f12517b, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        r12.setMaskFilter(null);
        return;
    L15:
        return;
    L11:
        this.f12516a = 0;
        this.f12517b = 0.0f;
        this.f12518c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.g = 0.0f;
        this.f.setMaskFilter(null);
    }

    public final void d(es.a r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f12516a = r5.d;
        this.f12518c = r5.f16858a;
        this.d = r5.f16859b;
        this.e = r5.e;
        float r10 = this.f12517b;
        float r11 = r5.f16860c;
        if (r10 == r11) goto L11;
        this.f12517b = r11;
        Paint r12 = this.f;
        if (r11 <= 0.0f) goto L8;
        r12.setMaskFilter(new BlurMaskFilter(this.f12517b, BlurMaskFilter.Blur.NORMAL));
        return;
    L8:
        r12.setMaskFilter(null);
        return;
    }

    public final boolean e() {
        if (this.f12518c == 0.0f) goto L5;
    L11:
        return true;
    L5:
        if (this.d != 0.0f) goto L11;
        if (this.f12517b != 0.0f) goto L11;
        if (this.e != 0.0f) goto L11;
        return false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        Class<?> r10 = null;
    L9:
        if (Intrinsics.areEqual(m.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L31;
        m r11 = (m) r5;
        if (this.f12516a == r11.f12516a) goto L16;
        return false;
    L16:
        if (this.f12517b == r11.f12517b) goto L18;
    L29:
        return false;
    L18:
        if (this.f12518c != r11.f12518c) goto L29;
        if (this.d != r11.d) goto L29;
        if (this.e != r11.e) goto L29;
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (this.g != r11.g) goto L29;
        return true;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
    L7:
        r10 = r5.getClass();
        goto L9
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f12516a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f12517b, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f12518c, r10, 31);
        int r12 = androidx.constraintlayout.motion.widget.a.b(this.d, r11, 31);
        int r13 = androidx.constraintlayout.motion.widget.a.b(this.e, r12, 31);
        int r14 = (this.f.hashCode() + r13) * 31;
        return Float.hashCode(this.g) + r14;
    }

    public final String toString() {
        return "Shadow(color=" + this.f12516a + ", radius=" + this.f12517b + ", offsetX=" + this.f12518c + ", offsetY=" + this.d + ", spread=" + this.e + ", paint=" + this.f + ", cornerRadius=" + this.g + ')';
    }

    public /* synthetic */ m(int r10, float r11, float r12, float r13, float r14) {
        this(r10, r11, r12, r13, r14, new Paint(1), 0.0f);
    }
}
