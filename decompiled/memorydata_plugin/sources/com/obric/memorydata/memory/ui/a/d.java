package com.obric.memorydata.memory.ui.a;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.memorydata.memory.ui.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T extends d<T>> implements com.obric.memorydata.memory.ui.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0518d f10565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0518d f10566b = null;
    public static final AbstractC0518d c = null;
    public static final AbstractC0518d d = null;
    public static final AbstractC0518d e = null;
    public static final AbstractC0518d f = null;
    public static final AbstractC0518d g = null;
    public static final AbstractC0518d h = null;
    public static final AbstractC0518d i = null;
    public static final AbstractC0518d j = null;
    public static final AbstractC0518d k = null;
    public static final AbstractC0518d l = null;
    public static final AbstractC0518d m = null;
    public static final AbstractC0518d n = null;
    float o;
    float p;
    boolean q;
    final Object r;
    final e s;
    boolean t;
    float u;
    float v;
    private long w;
    private float x;
    private final ArrayList<b> y;
    private final ArrayList<c> z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f10569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f10570b;

        a() {
        }
    }

    public interface b {
        void onAnimationEnd(d r1, boolean r2, float r3, float r4);
    }

    public interface c {
        void a(d r1, float r2, float r3);
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.a.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC0518d extends e<View> {
        private AbstractC0518d(String r1) {
            super(r1);
        }

        /* synthetic */ AbstractC0518d(String r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    static {
        final String r1 = "translationX";
        f10565a = new AnonymousClass1(r1);
        final String r2 = "translationY";
        f10566b = new AnonymousClass8(r2);
        final String r3 = "translationZ";
        c = new AnonymousClass9(r3);
        final String r4 = "scaleX";
        d = new AnonymousClass10(r4);
        final String r5 = "scaleY";
        e = new AnonymousClass11(r5);
        final String r6 = Key.ROTATION;
        f = new AnonymousClass12(r6);
        final String r7 = "rotationX";
        g = new AnonymousClass13(r7);
        final String r8 = "rotationY";
        h = new AnonymousClass14(r8);
        final String r9 = "x";
        i = new AnonymousClass15(r9);
        final String r10 = "y";
        j = new AnonymousClass2(r10);
        final String r11 = "z";
        k = new AnonymousClass3(r11);
        final String r12 = "alpha";
        l = new AnonymousClass4(r12);
        final String r13 = "scrollX";
        m = new AnonymousClass5(r13);
        final String r14 = "scrollY";
        n = new AnonymousClass6(r14);
    }

    d(final f r3) {
        this.o = 0.0f;
        this.p = Float.MAX_VALUE;
        this.q = false;
        this.t = false;
        this.u = Float.MAX_VALUE;
        this.v = -Float.MAX_VALUE;
        this.w = 0;
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.r = null;
        final String r1 = "FloatValueHolder";
        this.s = new AnonymousClass7(this, r1, r3);
        this.x = 1.0f;
    }

    private static <T> void a(ArrayList<T> r2) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r2.get(r0) != null) goto L7;
        r2.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private static <T> void a(ArrayList<T> r1, T r2) {
        int r3 = r1.indexOf(r2);
        if (r3 < 0) goto L6;
        r1.set(r3, null);
        return;
    }

    private void a(boolean r5) {
        int r0 = 0;
        this.t = false;
        com.obric.memorydata.memory.ui.a.a.a().a(this);
        this.w = 0;
        this.q = false;
    L4:
        if (r0 >= this.y.size()) goto L9;
        if (this.y.get(r0) == null) goto L8;
        ((b) ZeusTransformUtils.preCheckCast(this.y.get(r0), b.class, "com.obric.memorydata.plugin")).onAnimationEnd(this, r5, this.p, this.o);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        a(this.y);
    }

    private void d() {
        if (this.t == true) goto L14;
        this.t = true;
        if (this.q == true) goto L7;
        this.p = e();
    L7:
        float r0 = this.p;
        if (r0 > this.u) goto L13;
        if (r0 < this.v) goto L13;
        com.obric.memorydata.memory.ui.a.a.a().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    private float e() {
        return this.s.a(this.r);
    }

    public T a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (this.y.contains(r4) == true) goto L5;
        this.y.add(r4);
    L5:
        return this;
    }

    public void a() {
        if (this.t == true) goto L6;
        d();
        return;
    }

    void a(float r4) {
        this.s.a(this.r, r4);
        int r5 = 0;
    L4:
        if (r5 >= this.z.size()) goto L9;
        if (this.z.get(r5) == null) goto L8;
        ((c) ZeusTransformUtils.preCheckCast(this.z.get(r5), c.class, "com.obric.memorydata.plugin")).a(this, this.p, this.o);
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        a(this.z);
    }

    abstract boolean a(float r1, float r2);

    @Override // com.obric.memorydata.memory.ui.a.a.b
    public boolean a(long r5) {
        long r0 = this.w;
        if (r0 != 0) goto L6;
        this.w = r5;
        a(this.p);
        return false;
    L6:
        this.w = r5;
        boolean r6 = b(r5 - r0);
        float r7 = Math.min(this.p, this.u);
        this.p = r7;
        float r8 = Math.max(r7, this.v);
        this.p = r8;
        a(r8);
        if (r6 == false) goto L9;
        a(false);
    L9:
        return r6;
    }

    public void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        a(this.y, r4);
    }

    public boolean b() {
        return this.t;
    }

    abstract boolean b(long r1);

    float c() {
        return this.x * 0.75f;
    }
}
