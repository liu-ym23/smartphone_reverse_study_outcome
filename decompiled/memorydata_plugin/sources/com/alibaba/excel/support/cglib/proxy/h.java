package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.cglib.core.CodeGenerationException;
import com.alibaba.excel.support.cglib.core.ae;
import com.alibaba.excel.support.cglib.core.af;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.aj;
import com.alibaba.excel.support.cglib.core.ak;
import com.alibaba.excel.support.cglib.core.u;
import com.alibaba.excel.support.cglib.core.w;
import com.alibaba.excel.support.cglib.core.x;
import com.alibaba.excel.support.cglib.core.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.alibaba.excel.support.cglib.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.alibaba.excel.support.cglib.core.a.b f440b = null;
    private static final b c = null;
    private static final aa d = null;
    private static final aa e = null;
    private static final aa f = null;
    private static final aa g = null;
    private static final aa h = null;
    private static final aa i = null;
    private static final aa j = null;
    private static final ag k = null;
    private static final ag l = null;
    private static final ag m = null;
    private static final ag n = null;
    private static final ag o = null;
    private static final ag p = null;
    private static final ag q = null;
    private static final ag r = null;
    private static final ag s = null;
    private static final ag t = null;
    private static final ag u = null;
    private static final ag v = null;
    private static final ag w = null;
    private c A;
    private com.alibaba.excel.support.cglib.proxy.b[] B;
    private aa[] C;
    private boolean D;
    private boolean E;
    private Class F;
    private Class[] G;
    private Object[] H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Long f441J;
    private boolean K;
    private a x;
    private Object y;
    private Class[] z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f453b;
        private final Class[] c;
        private final Constructor d;

        public a(Class r2, Class[] r3, boolean r4) {
            this.f452a = r2;
            this.f453b = h.a(r2, "CGLIB$SET_THREAD_CALLBACKS");     // Catch: NoSuchMethodException -> L10
            if (r4 == false) goto L7;
            Constructor r5 = null;
            this.c = null;     // Catch: NoSuchMethodException -> L10
        L6:
            this.d = r5;     // Catch: NoSuchMethodException -> L10
            return;
        L7:
            this.c = r3;     // Catch: NoSuchMethodException -> L10
            r5 = ae.a(r2, r3);     // Catch: NoSuchMethodException -> L10
        L10:
            e = move-exception;
            throw new CodeGenerationException(e);
        }

        private void a(com.alibaba.excel.support.cglib.proxy.b[] r4) {
            this.f453b.invoke(this.f452a, new Object[]{r4});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L7
            return;
        L7:
            e = move-exception;
            throw new CodeGenerationException(e);
        L4:
            e = move-exception;
            throw new CodeGenerationException(e.getTargetException());
        }

        public Object a(Class[] r2, Object[] r3, com.alibaba.excel.support.cglib.proxy.b[] r4) {
            a(r4);
            Class[] r0 = this.c;     // Catch: Throwable -> L14
            if (r0 != r2) goto L6;
        L11:
            Object r5 = ae.a(this.d, r3);     // Catch: Throwable -> L14
            a(null);
            return r5;
        L6:
            if (Arrays.equals(r0, r2) == true) goto L11;
            Object r6 = ae.a(this.f452a, r2, r3);     // Catch: Throwable -> L14
            a(null);
            return r6;
        L14:
            th = move-exception;
            a(null);
            throw th;
        }
    }

    public interface b {
        Object a(String r1, String[] r2, ak<c> r3, aa[] r4, boolean r5, boolean r6, Long r7);
    }

    static {
        f439a = new AnonymousClass1();
        f440b = new com.alibaba.excel.support.cglib.core.a.b(h.class.getName());
        c = (b) ZeusTransformUtils.preCheckCast(com.alibaba.excel.support.cglib.core.s.a(b.class, com.alibaba.excel.support.cglib.core.s.c, null), b.class, "com.obric.memorydata.plugin");
        d = ai.d("Object");
        e = ai.d("com.alibaba.excel.support.cglib.proxy.Factory");
        f = ai.d("IllegalStateException");
        g = ai.d("IllegalArgumentException");
        h = ai.d("ThreadLocal");
        aa r0 = ai.d("com.alibaba.excel.support.cglib.proxy.Callback");
        i = r0;
        aa r1 = aa.getType(com.alibaba.excel.support.cglib.proxy.b[].class);
        j = r1;
        k = ai.e("");
        l = new ag("CGLIB$SET_THREAD_CALLBACKS", aa.f300a, new aa[]{r1});
        m = new ag("CGLIB$SET_STATIC_CALLBACKS", aa.f300a, new aa[]{r1});
        n = new ag("newInstance", com.alibaba.excel.support.cglib.core.i.o, new aa[]{r1});
        o = new ag("newInstance", com.alibaba.excel.support.cglib.core.i.o, new aa[]{com.alibaba.excel.support.cglib.core.i.m, com.alibaba.excel.support.cglib.core.i.l, r1});
        p = new ag("newInstance", com.alibaba.excel.support.cglib.core.i.o, new aa[]{r0});
        q = new ag("setCallback", aa.f300a, new aa[]{aa.f, r0});
        r = new ag("getCallback", r0, new aa[]{aa.f});
        s = new ag("setCallbacks", aa.f300a, new aa[]{r1});
        t = new ag("getCallbacks", r1, new aa[0]);
        u = ai.c("Object get()");
        v = ai.c("void set(Object)");
        w = ai.c("void CGLIB$BIND_CALLBACKS(Object)");
    }

    public h() {
        super(f440b);
        this.I = true;
        this.K = true;
    }

    private aa a(com.alibaba.excel.support.cglib.core.g r1) {
        a r0 = this.x;
        if (r0 != null) goto L7;
        return r1.f().f();
    L7:
        return aa.getType(r0.f452a);
    }

    private ag a(ag r3, int r4) {
        return new ag("CGLIB$" + r3.a() + "$" + r4, r3.b());
    }

    static /* synthetic */ ag a(h r0, ag r1, int r2) {
        return r0.a(r1, r2);
    }

    static /* synthetic */ String a(int r0) {
        return b(r0);
    }

    static /* synthetic */ Method a(Class r0, String r1) {
        return b(r0, r1);
    }

    private void a(com.alibaba.excel.support.cglib.core.d r3) {
        Constructor r2 = Object.class.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L5
        w r4 = (w) ZeusTransformUtils.preCheckCast(x.a().a(r2), w.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.cglib.core.g r5 = com.alibaba.excel.support.cglib.core.o.a(r3, r4, 1);
        r5.u();
        r5.k();
        r5.e(r4.c());
        r5.w();
        r5.g();
        return;
    L5:
        e = move-exception;
        throw new IllegalStateException("Object should have default constructor ", e);
    }

    private void a(com.alibaba.excel.support.cglib.core.d r8, List r9) {
        Iterator r10 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).iterator();
        boolean r2 = false;
    L4:
        if (r10.hasNext() == false) goto L24;
        w r3 = (w) ZeusTransformUtils.preCheckCast(r10.next(), w.class, "com.obric.memorydata.plugin");
        if (this.x == null) goto L10;
        if ("()V".equals(r3.c().b()) == false) goto L4;
    L10:
        com.alibaba.excel.support.cglib.core.g r6 = com.alibaba.excel.support.cglib.core.o.a(r8, r3, 1);
        r6.u();
        r6.k();
        r6.v();
        ag r4 = r3.c();
        if (r2 == false) goto L13;
    L16:
        r2 = true;
    L17:
        r6.e(r4);
        if (this.x != null) goto L22;
        r6.c(w);
        if (this.K == true) goto L22;
        r6.u();
        r6.b(1);
        r6.c("CGLIB$CONSTRUCTED");
    L22:
        r6.w();
        r6.g();
        goto L4
    L13:
        if (r4.b().equals("()V") == true) goto L16;
        r2 = false;
        goto L17
    L24:
        if (this.E == true) goto L31;
        if (r2 == false) goto L27;
        return;
    L27:
        if (this.H == null) goto L30;
        return;
    L30:
        throw new IllegalArgumentException("Superclass has no null constructors but no arguments were given");
    }

    private void a(com.alibaba.excel.support.cglib.core.d r17, List r18, List r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        d[] r8 = e.a(this.C);
        HashMap r9 = new HashMap();
        final HashMap r4 = new HashMap();
        final HashMap r3 = new HashMap();
        final Map r5 = com.alibaba.excel.support.cglib.core.h.a(r1);
        HashMap r6 = new HashMap();
        Iterator r10 = r1.iterator();
        if (r2 == null) goto L5;
        Iterator r7 = r2.iterator();
    L7:
        if (r10.hasNext() == false) goto L28;
        w r12 = (w) ZeusTransformUtils.preCheckCast(r10.next(), w.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        Method r13 = (Method) ZeusTransformUtils.preCheckCast(r7.next(), Method.class, "com.obric.memorydata.plugin");
    L12:
        int r14 = this.A.a(r13);
        if (r14 >= this.C.length) goto L27;
        if (r13 == null) goto L16;
        int r15 = r13.getModifiers();
    L17:
        r3.put(r12, Integer.valueOf(r15));
        r4.put(r12, Integer.valueOf(r14));
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9.get(r8[r14]), List.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L20;
        d r16 = r8[r14];
        ArrayList r110 = new ArrayList(r1.size());
        r9.put(r16, r110);
        r11 = r110;
    L20:
        r11.add(r12);
        if (ai.g(r13.getModifiers()) == false) goto L7;
        Set r111 = (Set) ZeusTransformUtils.preCheckCast(r6.get(r13.getDeclaringClass()), Set.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L25;
        r111 = new HashSet();
        r6.put(r13.getDeclaringClass(), r111);
    L25:
        r111.add(r12.c());
        goto L7
    L16:
        r15 = r12.b();
        goto L17
    L27:
        throw new IllegalArgumentException("Callback filter returned an index that is too large: " + r14);
    L11:
        r13 = null;
        goto L12
    L28:
        final Map r20 = new com.alibaba.excel.support.cglib.proxy.a(r6, f()).a();
        HashSet r112 = new HashSet();
        com.alibaba.excel.support.cglib.core.g r113 = r17.c();
        aa r21 = h;
        r113.d(r21);
        r113.k();
        r113.d(r21, k);
        r113.c("CGLIB$THREAD_CALLBACKS");
        d.a r114 = new AnonymousClass6(this, r3, r4, r5, r20);
        int r22 = 0;
    L30:
        if (r22 >= this.C.length) goto L45;
        d r23 = r8[r22];
        if (r112.contains(r23) == true) goto L44;
        r112.add(r23);
        List r24 = (List) ZeusTransformUtils.preCheckCast(r9.get(r23), List.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L44;
        r23.a(r17, r114, r24);     // Catch: Exception -> L38 RuntimeException -> L41
        r23.a(r113, r114, r24);     // Catch: Exception -> L38 RuntimeException -> L41
    L41:
        e = move-exception;
        throw e;
    L38:
        e = move-exception;
        throw new CodeGenerationException(e);
    L44:
        r22 = r22 + 1;
        goto L30
    L45:
        r113.w();
        r113.g();
        return;
    L5:
        r7 = null;
        goto L7
    }

    private void a(com.alibaba.excel.support.cglib.core.d r4, int[] r5) {
        final com.alibaba.excel.support.cglib.core.g r6 = r4.a(1, r, null);
        r6.u();
        r6.c(w);
        r6.u();
        r6.c(0);
        r6.a(r5, new AnonymousClass3(this, r6));
        r6.w();
        r6.g();
    }

    private void a(com.alibaba.excel.support.cglib.core.g r2, int r3) {
        r2.u();
        r2.b(b(r3));
        r2.k();
        com.alibaba.excel.support.asm.q r1 = r2.D();
        r2.d(r1);
        r2.i();
        r2.u();
        r2.c(w);
        r2.u();
        r2.b(b(r3));
        r2.e(r1);
    }

    static /* synthetic */ void a(h r0, com.alibaba.excel.support.cglib.core.g r1, int r2) {
        r0.a(r1, r2);
    }

    public static void a(Class r0, com.alibaba.excel.support.cglib.proxy.b[] r1) {
        b(r0, r1);
    }

    private static void a(Class r3, com.alibaba.excel.support.cglib.proxy.b[] r4, String r5) {
        b(r3, r5).invoke(null, new Object[]{r4});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L7 NoSuchMethodException -> L10
        return;
    L7:
        e = move-exception;
        throw new CodeGenerationException(e);
    L4:
        e = move-exception;
        throw new CodeGenerationException(e);
    L11:
        throw new IllegalArgumentException(r3 + " is not an enhanced class");
    }

    private static void a(Class r4, Class[] r5, List r6, List r7, Set r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        ae.a(r4, r9);
        if (r10 == null) goto L5;
        List r0 = r10;
    L6:
        if (r5 == null) goto L14;
        int r1 = 0;
    L9:
        if (r1 >= r5.length) goto L14;
        if (r5[r1] == i.class) goto L13;
        ae.a(r5[r1], r0);
    L13:
        r1 = r1 + 1;
    L14:
        if (r10 == null) goto L18;
        if (r11 == null) goto L17;
        r11.addAll(y.a(r10));
    L17:
        r9.addAll(r10);
    L18:
        com.alibaba.excel.support.cglib.core.h.a(r9, new af(8));
        com.alibaba.excel.support.cglib.core.h.a(r9, new aj(r4, true));
        com.alibaba.excel.support.cglib.core.h.a(r9, new com.alibaba.excel.support.cglib.core.n());
        com.alibaba.excel.support.cglib.core.h.a(r9, new af(16));
        return;
    L5:
        r0 = r9;
        goto L6
    }

    static /* synthetic */ aa[] a(h r0) {
        return r0.C;
    }

    private static String b(int r2) {
        return "CGLIB$CALLBACK_" + r2;
    }

    private static Method b(Class r3, String r4) {
        return r3.getDeclaredMethod(r4, new Class[]{com.alibaba.excel.support.cglib.proxy.b[].class});
    }

    private void b(com.alibaba.excel.support.cglib.core.d r4) {
        com.alibaba.excel.support.cglib.core.g r5 = r4.a(1, s, null);
        r5.u();
        int r0 = 0;
        r5.c(0);
    L4:
        if (r0 >= this.C.length) goto L6;
        r5.l();
        r5.d(r0);
        r5.f(this.C[r0]);
        r5.c(b(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r5.w();
        r5.g();
    }

    private void b(com.alibaba.excel.support.cglib.core.d r5, List r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        final com.alibaba.excel.support.cglib.core.g r8 = r5.a(1, o, null);
        final aa r0 = a(r8);
        r8.c(2);
        ag r1 = l;
        r8.a(r0, r1, false);
        r8.d(r0);
        r8.k();
        r8.c(0);
        com.alibaba.excel.support.cglib.core.o.a(r8, r7, new AnonymousClass5(this, r8, r0));
        r8.r();
        r8.a(r0, r1, false);
        r8.w();
        r8.g();
    }

    private void b(com.alibaba.excel.support.cglib.core.d r4, int[] r5) {
        final com.alibaba.excel.support.cglib.core.g r6 = r4.a(1, q, null);
        r6.c(0);
        r6.a(r5, new AnonymousClass4(this, r6));
        r6.w();
        r6.g();
    }

    private void b(com.alibaba.excel.support.cglib.core.g r3) {
        aa r2 = a(r3);
        r3.d(r2);
        r3.k();
        r3.c(r2);
        r3.r();
        r3.a(r2, l, false);
        r3.w();
        r3.g();
    }

    private static void b(Class r1, com.alibaba.excel.support.cglib.proxy.b[] r2) {
        a(r1, r2, "CGLIB$SET_THREAD_CALLBACKS");
    }

    static /* synthetic */ boolean b(h r0) {
        return r0.K;
    }

    private void c(com.alibaba.excel.support.cglib.core.d r4) {
        com.alibaba.excel.support.cglib.core.g r5 = r4.a(1, t, null);
        r5.u();
        r5.c(w);
        r5.u();
        r5.b(this.C.length);
        r5.b(i);
        int r0 = 0;
    L4:
        if (r0 >= this.C.length) goto L6;
        r5.k();
        r5.b(r0);
        r5.u();
        r5.b(b(r0));
        r5.B();
        r0 = r0 + 1;
        goto L4
    L6:
        r5.w();
        r5.g();
    }

    private void d(com.alibaba.excel.support.cglib.core.d r4) {
        com.alibaba.excel.support.cglib.core.g r5 = r4.a(1, n, null);
        aa r0 = a(r5);
        r5.c(0);
        r5.a(r0, l, false);
        b(r5);
    }

    private Object e(Class r3) {
        b(r3, this.B);
        Class[] r1 = this.G;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        Object r2 = ae.a(r3, r1, this.H);     // Catch: Throwable -> L11
        b(r3, null);
        return r2;
    L8:
        Object r4 = ae.b(r3);     // Catch: Throwable -> L11
        b(r3, null);
        return r4;
    L11:
        th = move-exception;
        b(r3, null);
        throw th;
    }

    private void e(com.alibaba.excel.support.cglib.core.d r4) {
        com.alibaba.excel.support.cglib.core.g r5 = r4.a(1, p, null);
        int r0 = this.C.length;
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L6;
        r5.a(f, "More than one callback object required");
        goto L7
    L6:
        r5.b(1);
        r5.b(i);
        r5.k();
        r5.b(0);
        r5.c(0);
        r5.B();
        r5.a(a(r5), l, false);
    L7:
        b(r5);
    }

    private void f(com.alibaba.excel.support.cglib.core.d r3) {
        com.alibaba.excel.support.cglib.core.g r2 = r3.a(9, l, null);
        r2.b("CGLIB$THREAD_CALLBACKS");
        r2.c(0);
        r2.b(h, v);
        r2.w();
        r2.g();
    }

    static /* synthetic */ aa g() {
        return g;
    }

    private void g(com.alibaba.excel.support.cglib.core.d r3) {
        com.alibaba.excel.support.cglib.core.g r2 = r3.a(9, m, null);
        r2.c(0);
        r2.c("CGLIB$STATIC_CALLBACKS");
        r2.w();
        r2.g();
    }

    private void h() {
        if (this.C != null) goto L6;
        this.C = e.a(this.B, false);
        this.D = true;
    L6:
        if (this.A == null) goto L8;
        return;
    L8:
        if (this.C.length > 1) goto L11;
        this.A = f439a;
        return;
    L11:
        throw new IllegalStateException("Multiple callback types possible but no filter specified");
    }

    private void h(com.alibaba.excel.support.cglib.core.d r6) {
        com.alibaba.excel.support.cglib.core.g r7 = r6.a(26, w, null);
        u r0 = r7.E();
        r7.c(0);
        r7.F();
        r7.a(r0);
        com.alibaba.excel.support.asm.q r1 = r7.D();
        r7.b(r0);
        r7.b("CGLIB$BOUND");
        r7.c(154, r1);
        r7.b(r0);
        r7.b(1);
        r7.c("CGLIB$BOUND");
        r7.b("CGLIB$THREAD_CALLBACKS");
        r7.b(h, u);
        r7.k();
        com.alibaba.excel.support.asm.q r2 = r7.D();
        r7.d(r2);
        r7.i();
        r7.b("CGLIB$STATIC_CALLBACKS");
        r7.k();
        r7.d(r2);
        r7.i();
        r7.b(r1);
        r7.e(r2);
        r7.f(j);
        r7.b(r0);
        r7.q();
        int r3 = this.C.length - 1;
    L3:
        if (r3 < 0) goto L7;
        if (r3 == 0) goto L6;
        r7.l();
    L6:
        r7.d(r3);
        r7.f(this.C[r3]);
        r7.c(b(r3));
        r3 = r3 - 1;
        goto L3
    L7:
        r7.e(r1);
        r7.w();
        r7.g();
    }

    private void i() {
        boolean r0 = this.E;
        com.alibaba.excel.support.cglib.proxy.b[] r1 = this.B;
        int r2 = 0;
        if (r1 != null) goto L5;
        boolean r3 = true;
    L7:
        if ((r3 ^ r0) == true) goto L9;
        if (r0 == false) goto L21;
        if (this.C != null) goto L21;
        throw new IllegalStateException("Callback types are required");
    L21:
        if (this.D == false) goto L23;
        this.C = null;
    L23:
        if (r1 == null) goto L38;
        aa[] r4 = this.C;
        if (r4 == null) goto L38;
        if (r1.length != r4.length) goto L37;
        aa[] r5 = e.a(r1);
        int r6 = 0;
    L30:
        if (r6 >= r5.length) goto L41;
        if (r5[r6].equals(this.C[r6]) == false) goto L35;
        r6 = r6 + 1;
        goto L30
    L35:
        throw new IllegalStateException("Callback " + r5[r6] + " is not assignable to " + this.C[r6]);
    L41:
        if (this.z == null) goto L53;
    L42:
        Class[] r7 = this.z;
        if (r2 >= r7.length) goto L59;
        if (r7[r2] == null) goto L52;
        if (r7[r2].isInterface() == false) goto L50;
        r2 = r2 + 1;
        goto L42
    L50:
        throw new IllegalStateException(this.z[r2] + " is not an interface");
    L52:
        throw new IllegalStateException("Interfaces cannot be null");
    L59:
        return;
    L53:
        return;
    L37:
        throw new IllegalStateException("Lengths of callback and callback types array must be the same");
    L38:
        if (r1 == null) goto L41;
        this.C = e.a(r1);
        goto L41
    L9:
        if (r0 == false) goto L13;
        throw new IllegalStateException("createClass does not accept callbacks");
    L13:
        throw new IllegalStateException("Callbacks are required");
    L5:
        r3 = false;
        goto L7
    }

    private Object j() {
        h();
        b r0 = c;
        Class r1 = this.F;
        ak<c> r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getName();
    L6:
        String[] r4 = ae.a(this.z);
        if (this.A == f439a) goto L10;
        r2 = new ak(this.A);
    L10:
        Object r5 = r0.a(r3, r4, r2, this.C, this.I, this.K, this.f441J);
        this.y = r5;
        return super.d(r5);
    L5:
        r3 = null;
        goto L6
    }

    private int[] k() {
        int[] r0 = new int[this.C.length];
        int r1 = 0;
    L4:
        if (r1 >= this.C.length) goto L6;
        r0[r1] = r1;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public Class a(com.alibaba.excel.support.cglib.core.a.C0050a r3) {
        i();
        Class r0 = this.F;
        if (r0 == null) goto L5;
    L4:
        a(r0.getName());
    L9:
        return super.a(r3);
    L5:
        Class[] r1 = this.z;
        if (r1 == null) goto L9;
        r0 = r1[ae.b(r1)];
        goto L4
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public ClassLoader a() {
        Class r0 = this.F;
        if (r0 != null) goto L5;
        Class[] r1 = this.z;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1[0].getClassLoader();
    L5:
        return r0.getClassLoader();
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public Object a(Class r2) {
        if (this.E == false) goto L6;
        return r2;
    L6:
        return e(r2);
    }

    @Override // com.alibaba.excel.support.cglib.core.e
    public void a(com.alibaba.excel.support.asm.f r14) {
        Class<Object> r0 = this.F;
        if (r0 != null) goto L6;
        r0 = Object.class;
    L6:
        if (ai.a(r0.getModifiers()) == true) goto L36;
        ArrayList r1 = new ArrayList(Arrays.asList(r0.getDeclaredConstructors()));
        a(r0, r1);
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        final HashSet r4 = new HashSet();
        a(r0, this.z, r2, r3, r4);
        List r5 = com.alibaba.excel.support.cglib.core.h.b(r2, new AnonymousClass2(this, r4));
        com.alibaba.excel.support.cglib.core.d r11 = new com.alibaba.excel.support.cglib.core.d(r14);
        a r15 = this.x;
        int r12 = 0;
        String r7 = d();
        if (r15 != null) goto L14;
        aa r8 = aa.getType(r0);
        if (this.I == false) goto L12;
        aa[] r16 = ai.a(ai.a(this.z), e);
    L13:
        r11.a(52, 1, r7, r8, r16, "<generated>");
    L15:
        List r17 = com.alibaba.excel.support.cglib.core.h.b(r1, x.a());
        r11.a(2, "CGLIB$BOUND", aa.f301b, null);
        r11.a(9, "CGLIB$FACTORY_DATA", d, null);
        if (this.K == true) goto L18;
        r11.a(2, "CGLIB$CONSTRUCTED", aa.f301b, null);
    L18:
        r11.a(26, "CGLIB$THREAD_CALLBACKS", h, null);
        r11.a(26, "CGLIB$STATIC_CALLBACKS", j, null);
        if (this.f441J == null) goto L22;
        r11.a(26, "serialVersionUID", aa.h, this.f441J);
    L22:
        if (r12 >= this.C.length) goto L24;
        r11.a(2, b(r12), this.C[r12], null);
        r12 = r12 + 1;
        goto L22
    L24:
        r11.a(10, "CGLIB$CALLBACK_FILTER", d, null);
        if (this.x != null) goto L27;
        a(r11, r5, r2);
        a(r11, r17);
    L28:
        f(r11);
        g(r11);
        h(r11);
        if (this.I == false) goto L31;
    L32:
        int[] r6 = k();
        d(r11);
        e(r11);
        b(r11, r17);
        a(r11, r6);
        b(r11, r6);
        c(r11);
        b(r11);
    L33:
        r11.h();
        return;
    L31:
        if (this.x == null) goto L33;
    L27:
        a(r11);
        goto L28
    L12:
        r16 = ai.a(this.z);
        goto L13
    L14:
        r11.a(52, 1, r7, null, new aa[]{e}, "<generated>");
        goto L15
    L36:
        throw new IllegalArgumentException("Cannot subclass final class " + r0.getName());
    }

    public void a(c r3) {
        this.A = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public void a(Class r2, List r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.support.cglib.core.h.a(r1, new aj(r2, true));
        if (r1.size() == 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("No visible constructors in " + r2);
    }

    public void a(boolean r1) {
        this.I = r1;
    }

    public void a(Class[] r1) {
        this.z = r1;
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public Object b(Class r4) {
        Class[] r0 = this.G;
        if (r0 != null) goto L5;
        r0 = com.alibaba.excel.support.cglib.core.i.i;
    L5:
        a r1 = new a(r4, r0, this.E);
        r4.getField("CGLIB$FACTORY_DATA").set(null, r1);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L12
        Field r5 = r4.getDeclaredField("CGLIB$CALLBACK_FILTER");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L12
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L12
        r5.set(null, this.A);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L12
    L8:
        return new WeakReference(r1);
    L9:
        e = move-exception;
        throw new CodeGenerationException(e);
    L12:
        e = move-exception;
        throw new CodeGenerationException(e);
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public Object b(Object r3) {
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (this.E == true) goto L5;
        Class[] r0 = this.G;
        Object[] r1 = this.H;
        if (r0 != null) goto L10;
        r0 = com.alibaba.excel.support.cglib.core.i.i;
        r1 = null;
    L10:
        return r4.a(r0, r1, this.B);
    L5:
        return r4.f452a;
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public ProtectionDomain b() {
        Class r0 = this.F;
        if (r0 != null) goto L5;
        Class[] r1 = this.z;
        if (r1 != null) goto L9;
        return null;
    L9:
        return ae.a(r1[0]);
    L5:
        return ae.a(r0);
    }

    public void b(Class[] r2) {
        if (r2 != null) goto L4;
    L8:
        this.C = e.a(r2);
        return;
    L4:
        if (r2.length != 0) goto L8;
        throw new IllegalArgumentException("Array cannot be empty");
    }

    public Class c() {
        this.E = true;
        return (Class) ZeusTransformUtils.preCheckCast(j(), Class.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.support.cglib.core.a
    public Object c(Object r3) {
        if (ZeusTransformUtils.instanceOf(this.y, b.class) == false) goto L7;
        return (a) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.memorydata.plugin")).get(), a.class, "com.obric.memorydata.plugin");
    L7:
        return super.c(r3);
    }

    public void d(Class r3) {
        if (r3 != null) goto L4;
    L6:
        if (r3 != null) goto L8;
    L10:
        this.F = r3;
    L11:
        c(r3);
        return;
    L8:
        if (r3.equals(Object.class) == false) goto L10;
        this.F = null;
        return;
    L4:
        if (r3.isInterface() == false) goto L6;
        a(new Class[]{r3});
        goto L11
    }
}
