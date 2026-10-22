package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q {
    public static final q h = null;
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final Paint f;
    public float g;

    public static final class a {
        @JvmStatic
        public static q a(com.obric.oui.shadow.b r7, float r8) {
            Intrinsics.checkNotNullParameter(r7, "config");
            q r0 = new q(r7.d, pla.d.h(r7.c, r8), pla.d.h(r7.a, r8), pla.d.h(r7.b, r8), pla.d.h(r7.e, r8));
            if (r0.b <= 0.0f) goto L5;
            r0.f.setMaskFilter(new BlurMaskFilter(r0.b, BlurMaskFilter.Blur.NORMAL));
        L6:
            return r0;
        L5:
            r0.f.setMaskFilter(null);
            goto L6
        }

        @JvmStatic
        public static List b(float r13, List r14, List r15) {
            if (Float.isInfinite(r13) == false) goto L5;
        L7:
            boolean r0 = false;
        L9:
            if (r0 == true) goto L12;
            r13 = 0.0f;
        L12:
            float r16 = RangesKt.coerceIn(r13, 0.0f, 1.0f);
            if (r14 == null) goto L27;
            if (r15 != null) goto L16;
            return r14;
        L16:
            if (r14.size() != r15.size()) goto L29;
            List r17 = r14;
            Iterator r1 = r17.iterator();
            List r18 = r15;
            Iterator r2 = r18.iterator();
            ArrayList r3 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r17, 10), CollectionsKt.collectionSizeOrDefault(r18, 10)));
        L19:
            if (r1.hasNext() == false) goto L24;
            if (r2.hasNext() == false) goto L24;
            Object r19 = r1.next();
            q r110 = (q) r2.next();
            q r111 = (q) r19;
            int r4 = r111.a;
            int r5 = r110.a;
            int r6 = vma.b.a;
            int r7 = (r4 >> 24) & 255;
            int r8 = (r4 >> 16) & 255;
            int r9 = (r4 >> 8) & 255;
            int r10 = r4 & 255;
            int r11 = (int) (r10 + (((r5 & 255) - r10) * r16));
            int r12 = (((((int) (r7 + ((((r5 >> 24) & 255) - r7) * r16))) << 24) | (((int) (r8 + ((((r5 >> 16) & 255) - r8) * r16))) << 16)) | (((int) (r9 + ((((r5 >> 8) & 255) - r9) * r16))) << 8)) | r11;
            float r20 = r111.b;
            float r21 = ((r110.b - r20) * r16) + r20;
            float r22 = r111.c;
            float r23 = ((r110.c - r22) * r16) + r22;
            float r24 = r111.d;
            float r25 = ((r110.d - r24) * r16) + r24;
            float r112 = r111.e;
            r3.add(new q(r12, r21, r23, r25, r112 + ((r110.e - r112) * r16)));
        L24:
            return r3;
        L29:
            return r14;
        L27:
            return r14;
        L5:
            if (Float.isNaN(r13) == true) goto L7;
            r0 = true;
            goto L9
        }
    }

    public final int hashCode() {
        return (((((((((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f.hashCode()) * 31) + Float.floatToIntBits(this.g);
    }

    public final String toString() {
        return "Shadow(color=" + this.a + ", radius=" + this.b + ", offsetX=" + this.c + ", offsetY=" + this.d + ", spread=" + this.e + ", paint=" + this.f + ", cornerRadius=" + this.g + ')';
    }

    static {
        h = new q(0, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final q a() {
        int r1 = this.a;
        float r2 = this.b;
        float r3 = this.c;
        float r4 = this.d;
        float r5 = this.e;
        Paint r6 = new Paint(this.f);
        r6.set(this.f);
        Unit r0 = Unit.INSTANCE;
        return new q(r1, r2, r3, r4, r5, r6, this.g);
    }

    public final boolean e() {
        if (this.c != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return true;
    L8:
        if (this.d != 0.0f) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        if (this.b != 0.0f) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        return true;
    L18:
        if (this.e != 0.0f) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L28;
        return false;
    L28:
        return true;
    L20:
        r3 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final q b(com.obric.oui.shadow.a r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        q r0 = new q(r7.d, r7.c, r7.a, r7.b, r7.e);
        if (r0.b <= 0.0f) goto L5;
        r0.f.setMaskFilter(new BlurMaskFilter(r0.b, BlurMaskFilter.Blur.NORMAL));
    L6:
        return r0;
    L5:
        r0.f.setMaskFilter(null);
        goto L6
    }

    public final void c(com.obric.oui.shadow.a r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        com.obric.oui.shadow.b r5 = r4.b();
        Intrinsics.checkNotNullParameter(r5, "config");
        this.a = r5.d;
        this.c = r5.a;
        this.d = r5.b;
        this.e = r5.e;
        float r0 = this.b;
        float r6 = r5.c;
        if (r0 != r6) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L12;
        this.b = r6;
        if (r6 <= 0.0f) goto L10;
        this.f.setMaskFilter(new BlurMaskFilter(this.b, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        this.f.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(q.class, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L51;
        q r6 = (q) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if (this.b != r6.b) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == true) goto L23;
        return false;
    L23:
        if (this.c != r6.c) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == true) goto L29;
        return false;
    L29:
        if (this.d != r6.d) goto L31;
        boolean r4 = true;
    L32:
        if (r4 == true) goto L35;
        return false;
    L35:
        if (this.e != r6.e) goto L37;
        boolean r7 = true;
    L38:
        if (r7 == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L44;
        return false;
    L44:
        if (this.g != r6.g) goto L46;
        boolean r8 = true;
    L47:
        if (r8 == true) goto L49;
        return false;
    L49:
        return true;
    L46:
        r8 = false;
        goto L47
    L37:
        r7 = false;
        goto L38
    L31:
        r4 = false;
        goto L32
    L25:
        r3 = false;
        goto L26
    L19:
        r1 = false;
        goto L20
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
    L8:
        r2 = r5.getClass();
        goto L10
    }

    public final void update(q r5) {
        boolean r2 = false;
        if (r5 == null) goto L12;
        this.a = r5.a;
        this.c = r5.c;
        this.d = r5.d;
        this.e = r5.e;
        float r3 = this.b;
        float r6 = r5.b;
        if (r3 != r6) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L14;
        this.b = r6;
        if (r6 <= 0.0f) goto L11;
        this.f.setMaskFilter(new BlurMaskFilter(this.b, BlurMaskFilter.Blur.NORMAL));
        return;
    L11:
        this.f.setMaskFilter(null);
        return;
    L14:
        return;
    L12:
        this.a = 0;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.g = 0.0f;
        this.f.setMaskFilter(null);
    }

    public final void d(com.obric.oui.shadow.b r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r3.d;
        this.c = pla.d.h(r3.a, r4);
        this.d = pla.d.h(r3.b, r4);
        this.e = r3.e;
        float r0 = this.b;
        float r5 = r3.c;
        if (r0 != (r5 * r4)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L12;
        float r6 = r5 * r4;
        this.b = r6;
        if (r6 <= 0.0f) goto L10;
        this.f.setMaskFilter(new BlurMaskFilter(this.b, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        this.f.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public /* synthetic */ q(int r9, float r10, float r11, float r12, float r13) {
        this(r9, r10, r11, r12, r13, new Paint(1), 0.0f);
    }

    public q(int r2, float r3, float r4, float r5, float r6, Paint r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "paint");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
