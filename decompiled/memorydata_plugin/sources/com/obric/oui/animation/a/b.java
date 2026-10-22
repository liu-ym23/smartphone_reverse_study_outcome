package com.obric.oui.animation.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.oui.animation.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T extends b<T>> implements com.obric.oui.animation.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f13293b = null;
    public static final d c = null;
    public static final d d = null;
    public static final d e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;
    public static final d k = null;
    public static final d l = null;
    public static final d m = null;
    public static final d n = null;
    float o;
    float p;
    boolean q;
    final Object r;
    final com.obric.oui.animation.a.c s;
    boolean t;
    float u;
    float v;
    private long w;
    private float x;
    private final ArrayList<InterfaceC0726b> y;
    private final ArrayList<c> z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f13294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f13295b;

        a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0726b {
        void a(b r1, boolean r2, float r3, float r4);
    }

    public interface c {
        void onAnimationUpdate(b r1, float r2, float r3);
    }

    public static abstract class d extends com.obric.oui.animation.a.c<View> {
        private d(String r1) {
            super(r1);
        }

        /* synthetic */ d(String r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    static {
        final String r1 = "translationX";
        f13292a = new AnonymousClass1(r1);
        final String r2 = "translationY";
        f13293b = new AnonymousClass7(r2);
        final String r3 = "translationZ";
        c = new AnonymousClass8(r3);
        final String r4 = "scaleX";
        d = new AnonymousClass9(r4);
        final String r5 = "scaleY";
        e = new AnonymousClass10(r5);
        final String r6 = Key.ROTATION;
        f = new AnonymousClass11(r6);
        final String r7 = "rotationX";
        g = new AnonymousClass12(r7);
        final String r8 = "rotationY";
        h = new AnonymousClass13(r8);
        final String r9 = "x";
        i = new AnonymousClass14(r9);
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

    <K> b(K r3, com.obric.oui.animation.a.c<K> r4) {
        this.o = 0.0f;
        this.p = Float.MAX_VALUE;
        this.q = false;
        this.t = false;
        this.u = Float.MAX_VALUE;
        this.v = -Float.MAX_VALUE;
        this.w = 0;
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.r = r3;
        this.s = r4;
        if (r4 != f) goto L5;
    L18:
        float r5 = 0.1f;
    L19:
        this.x = r5;
        return;
    L5:
        if (r4 == g) goto L18;
        if (r4 == h) goto L18;
        if (r4 != l) goto L13;
    L11:
        this.x = 0.00390625f;
        return;
    L13:
        if (r4 == d) goto L11;
        if (r4 == e) goto L11;
        r5 = 1.0f;
        goto L19
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
        com.obric.oui.animation.a.a.a().a(this);
        this.w = 0;
        this.q = false;
    L4:
        if (r0 >= this.y.size()) goto L9;
        if (this.y.get(r0) == null) goto L8;
        ((InterfaceC0726b) ZeusTransformUtils.preCheckCast(this.y.get(r0), InterfaceC0726b.class, "com.obric.memorydata.plugin")).a(this, r5, this.p, this.o);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        a(this.y);
    }

    private void e() {
        if (this.t == true) goto L14;
        this.t = true;
        if (this.q == true) goto L7;
        this.p = f();
    L7:
        float r0 = this.p;
        if (r0 > this.u) goto L13;
        if (r0 < this.v) goto L13;
        com.obric.oui.animation.a.a.a().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    private float f() {
        return this.s.a(this.r);
    }

    public T a(float r1) {
        this.p = r1;
        this.q = true;
        return this;
    }

    public T a(InterfaceC0726b r3) {
        InterfaceC0726b r4 = (InterfaceC0726b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0726b.class, "com.obric.memorydata.plugin");
        if (this.y.contains(r4) == true) goto L5;
        this.y.add(r4);
    L5:
        return this;
    }

    public T a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        if (c() == true) goto L9;
        if (this.z.contains(r4) == true) goto L7;
        this.z.add(r4);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void a() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        Log.e("DynamicAnimation", "Current Thread Id + " + Thread.currentThread().getId() + " Main Thread Id + " + Looper.getMainLooper().getThread().getId());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L5:
        if (this.t == true) goto L10;
        e();
        return;
    }

    abstract boolean a(float r1, float r2);

    @Override // com.obric.oui.animation.a.a.b
    public boolean a(long r5) {
        long r0 = this.w;
        if (r0 != 0) goto L6;
        this.w = r5;
        e(this.p);
        return false;
    L6:
        this.w = r5;
        boolean r6 = b(r5 - r0);
        float r7 = Math.min(this.p, this.u);
        this.p = r7;
        float r8 = Math.max(r7, this.v);
        this.p = r8;
        e(r8);
        if (r6 == false) goto L9;
        a(false);
    L9:
        return r6;
    }

    public T b(float r1) {
        this.o = r1;
        return this;
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.t == false) goto L10;
        a(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public void b(InterfaceC0726b r3) {
        InterfaceC0726b r4 = (InterfaceC0726b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0726b.class, "com.obric.memorydata.plugin");
        a(this.y, r4);
    }

    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        a(this.z, r4);
    }

    abstract boolean b(long r1);

    public T c(float r1) {
        this.u = r1;
        return this;
    }

    public boolean c() {
        return this.t;
    }

    float d() {
        return this.x * 0.75f;
    }

    public T d(float r1) {
        this.v = r1;
        return this;
    }

    void e(float r4) {
        this.s.a(this.r, r4);
        int r5 = 0;
    L4:
        if (r5 >= this.z.size()) goto L9;
        if (this.z.get(r5) == null) goto L8;
        ((c) ZeusTransformUtils.preCheckCast(this.z.get(r5), c.class, "com.obric.memorydata.plugin")).onAnimationUpdate(this, this.p, this.o);
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        a(this.z);
    }
}
