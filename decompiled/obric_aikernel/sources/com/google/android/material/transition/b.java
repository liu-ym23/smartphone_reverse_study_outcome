package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.material.transition.a f4133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.android.material.transition.a f4134b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.android.material.transition.a f4135c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.android.material.transition.a f4136d = null;

    class a implements com.google.android.material.transition.a {
        a() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float r10, float r11, float r12, float r13) {
            return com.google.android.material.transition.c.a(255, l.m(0, 255, r11, r12, r10));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.b$b, reason: collision with other inner class name */
    class C0089b implements com.google.android.material.transition.a {
        C0089b() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float r10, float r11, float r12, float r13) {
            return com.google.android.material.transition.c.b(l.m(255, 0, r11, r12, r10), 255);
        }
    }

    class c implements com.google.android.material.transition.a {
        c() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float r10, float r11, float r12, float r13) {
            return com.google.android.material.transition.c.b(l.m(255, 0, r11, r12, r10), l.m(0, 255, r11, r12, r10));
        }
    }

    class d implements com.google.android.material.transition.a {
        d() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float r10, float r11, float r12, float r13) {
            float r14 = ((r12 - r11) * r13) + r11;
            return com.google.android.material.transition.c.b(l.m(255, 0, r11, r14, r10), l.m(0, 255, r14, r12, r10));
        }
    }

    static {
        f4133a = new a();
        f4134b = new C0089b();
        f4135c = new c();
        f4136d = new d();
    }

    static com.google.android.material.transition.a a(int r10, boolean r11) {
        if (r10 != 0) goto L4;
        if (r11 == false) goto L22;
        return f4133a;
    L22:
        return f4134b;
    L4:
        if (r10 != 1) goto L6;
        if (r11 == false) goto L18;
        return f4134b;
    L18:
        return f4133a;
    L6:
        if (r10 == 2) goto L14;
        if (r10 != 3) goto L12;
        return f4136d;
    L12:
        throw new IllegalArgumentException("Invalid fade mode: " + r10);
    L14:
        return f4135c;
    }
}
