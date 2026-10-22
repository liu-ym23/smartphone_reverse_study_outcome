package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends com.google.android.material.circularreveal.b.a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a implements TypeEvaluator<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TypeEvaluator<d> f3844a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f3845b;

        static {
            f3844a = new a();
        }

        public a() {
            this.f3845b = new d(null);
        }

        public d a(float r5, d r6, d r7) {
            this.f3845b.a(com.google.android.material.f.a.a(r6.f3848a, r7.f3848a, r5), com.google.android.material.f.a.a(r6.f3849b, r7.f3849b, r5), com.google.android.material.f.a.a(r6.c, r7.c, r5));
            return this.f3845b;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ d evaluate(float r3, d r4, d r5) {
            return a(r3, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin"));
        }
    }

    public static class b extends Property<c, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, d> f3846a = null;

        static {
            f3846a = new b("circularReveal");
        }

        private b(String r2) {
            super(d.class, r2);
        }

        public d a(c r2) {
            return ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).getRevealInfo();
        }

        public void a(c r2, d r3) {
            ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).setRevealInfo(r3);
        }

        @Override // android.util.Property
        public /* synthetic */ d get(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.util.Property
        public /* synthetic */ void set(c r3, d r4) {
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    public static class C0183c extends Property<c, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f3847a = null;

        static {
            f3847a = new C0183c("circularRevealScrimColor");
        }

        private C0183c(String r2) {
            super(Integer.class, r2);
        }

        public Integer a(c r2) {
            return Integer.valueOf(((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).getCircularRevealScrimColor());
        }

        public void a(c r2, Integer r3) {
            ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).setCircularRevealScrimColor(r3.intValue());
        }

        @Override // android.util.Property
        public /* synthetic */ Integer get(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.util.Property
        public /* synthetic */ void set(c r3, Integer r4) {
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"));
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3849b;
        public float c;

        private d() {
        }

        public d(float r1, float r2, float r3) {
            this.f3848a = r1;
            this.f3849b = r2;
            this.c = r3;
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }

        public d(d r3) {
            this(r3.f3848a, r3.f3849b, r3.c);
        }

        public void a(float r1, float r2, float r3) {
            this.f3848a = r1;
            this.f3849b = r2;
            this.c = r3;
        }

        public void a(d r3) {
            a(r3.f3848a, r3.f3849b, r3.c);
        }

        public boolean a() {
            if (this.c != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable r1);

    void setCircularRevealScrimColor(int r1);

    void setRevealInfo(d r1);
}
