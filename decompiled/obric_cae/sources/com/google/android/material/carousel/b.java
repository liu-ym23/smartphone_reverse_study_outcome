package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C0049b> f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4523d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f4526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0049b f4527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C0049b f4528e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4529f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4531h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4532i;

        public a(float r8, float r10) {
            this.f4526c = new ArrayList();
            this.f4529f = -1;
            this.f4530g = -1;
            this.f4531h = 0.0f;
            this.f4532i = -1;
            this.f4524a = r8;
            this.f4525b = r10;
        }

        public final void a(float r10, float r11, float r12, boolean r13, boolean r14) {
            float r8 = r12 / 2.0f;
            float r15 = r10 - r8;
            float r16 = r8 + r10;
            float r17 = this.f4525b;
            if (r16 <= r17) goto L5;
            float r18 = Math.abs(r16 - Math.max(r16 - r12, r17));
        L8:
            b(r10, r11, r12, r13, r14, r18);
            return;
        L5:
            r18 = 0.0f;
            if (r15 >= 0.0f) goto L8;
            r18 = Math.abs(r15 - Math.min(r15 + r12, 0.0f));
            goto L8
        }

        public final void b(float r13, float r14, float r15, boolean r16, boolean r17, float r18) {
            if (r15 > 0.0f) goto L5;
            return;
        L5:
            ArrayList r10 = this.f4526c;
            if (r17 == false) goto L17;
            if (r16 == true) goto L16;
            int r8 = this.f4532i;
            if (r8 == (-1)) goto L14;
            if (r8 == 0) goto L14;
            throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
        L14:
            this.f4532i = r10.size();
            goto L17
        L16:
            throw new IllegalArgumentException("Anchor keylines cannot be focal.");
        L17:
            C0049b r11 = new C0049b(Float.MIN_VALUE, r13, r14, r15, r17, r18);
            C0049b r12 = this.f4527d;
            if (r16 == false) goto L33;
            if (r12 != null) goto L22;
            this.f4527d = r11;
            this.f4529f = r10.size();
        L22:
            if (this.f4530g == (-1)) goto L29;
            if ((r10.size() - this.f4530g) <= 1) goto L29;
            throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
        L29:
            if (r15 != this.f4527d.f4536d) goto L32;
            this.f4528e = r11;
            this.f4530g = r10.size();
        L46:
            this.f4531h = r15;
            r10.add(r11);
            return;
        L32:
            throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
        L33:
            if (r12 != null) goto L40;
            if (r15 >= this.f4531h) goto L40;
            throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
        L40:
            if (this.f4528e == null) goto L46;
            if (r15 <= this.f4531h) goto L46;
            throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
        }

        public final void c(float r10, float r11, float r12, int r13, boolean r14) {
            if (r13 > 0) goto L4;
            return;
        L4:
            if (r12 <= 0.0f) goto L11;
            int r8 = 0;
        L7:
            if (r8 >= r13) goto L12;
            a((r8 * r12) + r10, r11, r12, r14, false);
            r8 = r8 + 1;
            goto L7
        L12:
            return;
        }

        public final b d() {
            if (this.f4527d == null) goto L11;
            ArrayList r8 = new ArrayList();
            int r10 = 0;
        L5:
            ArrayList r11 = this.f4526c;
            int r12 = r11.size();
            float r13 = this.f4524a;
            if (r10 >= r12) goto L9;
            C0049b r14 = (C0049b) r11.get(r10);
            r8.add(new C0049b((r10 * r13) + (this.f4527d.f4534b - (this.f4529f * r13)), r14.f4534b, r14.f4535c, r14.f4536d, r14.f4537e, r14.f4538f));
            r10 = r10 + 1;
            goto L5
        L9:
            return new b(r13, r8, this.f4529f, this.f4530g);
        L11:
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    public static final class C0049b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f4537e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4538f;

        public C0049b(float r8, float r10, float r11, float r12, boolean r13, float r14) {
            this.f4533a = r8;
            this.f4534b = r10;
            this.f4535c = r11;
            this.f4536d = r12;
            this.f4537e = r13;
            this.f4538f = r14;
        }
    }

    public b(float r8, ArrayList r10, int r11, int r12) {
        this.f4520a = r8;
        this.f4521b = Collections.unmodifiableList(r10);
        this.f4522c = r11;
        this.f4523d = r12;
    }

    public final C0049b a() {
        return this.f4521b.get(this.f4522c);
    }

    public final C0049b b() {
        return this.f4521b.get(0);
    }

    public final C0049b c() {
        return this.f4521b.get(this.f4523d);
    }

    public final C0049b d() {
        List<C0049b> r8 = this.f4521b;
        return r8.get(r8.size() - 1);
    }
}
