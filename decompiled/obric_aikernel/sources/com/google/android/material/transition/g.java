package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f4156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f4157b = null;

    class a implements f {
        a() {
        }

        @Override // com.google.android.material.transition.f
        public boolean a(h r10) {
            if (r10.f4161d <= r10.f4163f) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.android.material.transition.f
        public void b(RectF r10, float r11, h r12) {
            r10.bottom -= Math.abs(r12.f4163f - r12.f4161d) * r11;
        }

        @Override // com.google.android.material.transition.f
        public h c(float r10, float r11, float r12, float r13, float r14, float r15, float r16) {
            float r17 = l.l(r13, r15, r11, r12, r10, true);
            float r18 = r17 / r13;
            float r19 = r17 / r15;
            return new h(r18, r19, r17, r14 * r18, r17, r16 * r19);
        }
    }

    class b implements f {
        b() {
        }

        @Override // com.google.android.material.transition.f
        public boolean a(h r10) {
            if (r10.f4160c <= r10.f4162e) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.android.material.transition.f
        public void b(RectF r10, float r11, h r12) {
            float r13 = (Math.abs(r12.f4162e - r12.f4160c) / 2.0f) * r11;
            r10.left += r13;
            r10.right -= r13;
        }

        @Override // com.google.android.material.transition.f
        public h c(float r10, float r11, float r12, float r13, float r14, float r15, float r16) {
            float r17 = l.l(r14, r16, r11, r12, r10, true);
            float r18 = r17 / r14;
            float r19 = r17 / r16;
            return new h(r18, r19, r13 * r18, r17, r15 * r19, r17);
        }
    }

    static {
        f4156a = new a();
        f4157b = new b();
    }

    static f a(int r10, boolean r11, RectF r12, RectF r13) {
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L10;
        return f4157b;
    L10:
        throw new IllegalArgumentException("Invalid fit mode: " + r10);
    L12:
        return f4156a;
    L14:
        if (b(r11, r12, r13) == false) goto L17;
        return f4156a;
    L17:
        return f4157b;
    }

    private static boolean b(boolean r10, RectF r11, RectF r12) {
        float r13 = r11.width();
        float r14 = r11.height();
        float r15 = r12.width();
        float r16 = r12.height();
        float r17 = (r16 * r13) / r15;
        float r18 = (r15 * r14) / r13;
        if (r10 == false) goto L8;
        if (r17 < r14) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (r18 < r16) goto L11;
        return true;
    }
}
