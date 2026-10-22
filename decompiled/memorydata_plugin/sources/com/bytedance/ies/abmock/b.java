package com.bytedance.ies.abmock;

import android.app.Application;
import com.bytedance.ies.abmock.datacenter.k;
import com.bytedance.ies.abmock.settings.SettingsKey;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f2659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Float f2660b = null;
    private static final Double c = null;
    private static final Integer d = null;
    private static final Long e = null;
    private static final Boolean f = null;
    private volatile boolean g;
    private volatile k h;
    private volatile Application i;

    static {
        f2660b = Float.valueOf(0.74347335f);
        c = Double.valueOf(0.7434733377752801d);
        d = 2690237;
        e = 992354881878L;
        f = false;
    }

    private b() {
        this.g = false;
    }

    private int a(com.bytedance.ies.abmock.a.a r2) {
        com.bytedance.ies.abmock.a.a r1 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r1.d() == false) goto L7;
        return com.bytedance.ies.abmock.datacenter.b.f2668b;
    L7:
        if (r1.c() == false) goto L11;
        return com.bytedance.ies.abmock.datacenter.b.c;
    L11:
        return com.bytedance.ies.abmock.datacenter.b.f2667a;
    }

    public static b a() {
        if (f2659a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2659a != null) goto L9;
        f2659a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2659a;
    }

    private void a(int r2) {
        a(r2, false);
    }

    private void a(int r2, boolean r3) {
        if (com.bytedance.ies.abmock.datacenter.b.b(r2) == false) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
    L9:
        monitor-enter(this);
        if (r3 == true) goto L14;
    L23:
        th = move-exception;
        throw th;
    L12:
        if (this.g == false) goto L14;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L14:
        if (this.h == null) goto L21;
        com.bytedance.ies.abmock.datacenter.d.a().a(this.h, ConfigurationManager.a().c());     // Catch: Throwable -> L23
        if (ConfigurationManager.a().b() == true) goto L18;
    L20:
        this.g = true;     // Catch: Throwable -> L23
        goto L21
    L18:
        if (this.i == null) goto L20;
        ConfigurationManager.a().c().a(this.i);     // Catch: Throwable -> L23
        goto L20
    L7:
        if (this.g == false) goto L9;
    }

    private void b() {
        a(com.bytedance.ies.abmock.datacenter.b.f2667a, false);
    }

    public static Class j(Class r0) {
        return k(r0).getType();
    }

    public static Field k(Class r8) {
        Field[] r0 = r8.getDeclaredFields();
        int r1 = r0.length;
        Field r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        Field r4 = r0[r3];
        com.bytedance.ies.abmock.a.c r5 = (com.bytedance.ies.abmock.a.c) ZeusTransformUtils.preCheckCast(r4.getAnnotation(com.bytedance.ies.abmock.a.c.class), com.bytedance.ies.abmock.a.c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        if (r5.a() == true) goto L8;
        r2 = r4;
        goto L10
    L8:
        r2 = r4;
    L10:
        r3 = r3 + 1;
    L11:
        if (r2 == null) goto L15;
        r2.setAccessible(true);
        return r2;
    L15:
        throw new RuntimeException("Can not find @Group in " + r8.getName());
    }

    private boolean l(Class r3) {
        if (((SettingsKey) ZeusTransformUtils.preCheckCast(r3.getAnnotation(SettingsKey.class), SettingsKey.class, "com.obric.memorydata.plugin")) == null) goto L6;
        return false;
    L6:
        if (r3.getAnnotation(com.bytedance.ies.abmock.a.d.class) != null) goto L9;
        return true;
    L9:
        return false;
    }

    private <T> T m(Class r2) {
        Field r1 = k(r2);
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (Modifier.isStatic(r1.getModifiers()) == false) goto L8;
        return (T) r1.get(null);
    L8:
        return (T) r1.get(r2.newInstance());
    }

    @Deprecated
    public double a(String r7, double r8, boolean r10, int r11) {
        a(r11);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r7, r8, r10, r11);
    }

    @Deprecated
    public float a(String r1, float r2, boolean r3, int r4) {
        a(r4);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r1, r2, r3, r4);
    }

    public int a(Class r6) {
        int r0 = i(r6);
        a(r0);
        return a(h(r6), ((Integer) ZeusTransformUtils.preCheckCast(m(r6), Integer.class, "com.obric.memorydata.plugin")).intValue(), l(r6), r0);
    }

    @Deprecated
    public int a(String r2, int r3, boolean r4) {
        b();
        return a(r2, r3, r4, com.bytedance.ies.abmock.datacenter.b.f2667a);
    }

    @Deprecated
    public int a(String r1, int r2, boolean r3, int r4) {
        a(r4);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r1, r2, r3, r4);
    }

    @Deprecated
    public long a(String r7, long r8, boolean r10, int r11) {
        a(r11);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r7, r8, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public <T> T a(String r1, boolean r2, int r3) {
        a(r3);
        return (T) com.bytedance.ies.abmock.datacenter.d.a().a(r1, r2, r3);
    }

    @Deprecated
    public <T> T a(String r7, boolean r8, Class r9, int r10) {
        a(r10);
        return (T) a(r7, r8, false, r9, r10);
    }

    @Deprecated
    public <T> T a(String r7, boolean r8, boolean r9, Class r10, int r11) {
        a(r11);
        return (T) com.bytedance.ies.abmock.datacenter.d.a().a(r7, r8, r9, r10, r11);
    }

    @Deprecated
    public String a(String r1, String r2, boolean r3, int r4) {
        a(r4);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r1, r2, r3, r4);
    }

    public void a(k r3, Application r4, Boolean r5) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        this.h = r6;
        this.i = r7;
        if (r5.booleanValue() == true) goto L6;
        a(com.bytedance.ies.abmock.datacenter.b.f2667a, true);
        return;
    }

    @Deprecated
    public boolean a(String r1, boolean r2, boolean r3, int r4) {
        a(r4);
        return com.bytedance.ies.abmock.datacenter.d.a().a(r1, r2, r3, r4);
    }

    public boolean b(Class r6) {
        int r0 = i(r6);
        a(r0);
        return a(h(r6), ((Boolean) ZeusTransformUtils.preCheckCast(m(r6), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), l(r6), r0);
    }

    public String c(Class r6) {
        int r0 = i(r6);
        a(r0);
        return a(h(r6), (String) ZeusTransformUtils.preCheckCast(m(r6), String.class, "com.obric.memorydata.plugin"), l(r6), r0);
    }

    public double d(Class r7) {
        int r5 = i(r7);
        a(r5);
        return a(h(r7), ((Double) ZeusTransformUtils.preCheckCast(m(r7), Double.class, "com.obric.memorydata.plugin")).doubleValue(), l(r7), r5);
    }

    public float e(Class r6) {
        int r0 = i(r6);
        a(r0);
        return a(h(r6), ((Float) ZeusTransformUtils.preCheckCast(m(r6), Float.class, "com.obric.memorydata.plugin")).floatValue(), l(r6), r0);
    }

    public long f(Class r7) {
        int r5 = i(r7);
        a(r5);
        return a(h(r7), ((Long) ZeusTransformUtils.preCheckCast(m(r7), Long.class, "com.obric.memorydata.plugin")).longValue(), l(r7), r5);
    }

    @Deprecated
    public <T> T g(Class r5) {
        int r0 = i(r5);
        a(r0);
        String r1 = h(r5);
        boolean r2 = l(r5);
        Class r6 = j(r5);
        if (r6 != String[].class) goto L7;
        return (T) a(r1, r2, r0);
    L7:
        return (T) a(r1, r2, r6, r0);
    }

    public String h(Class r3) {
        com.bytedance.ies.abmock.a.b r2 = (com.bytedance.ies.abmock.a.b) ZeusTransformUtils.preCheckCast(r3.getAnnotation(com.bytedance.ies.abmock.a.b.class), com.bytedance.ies.abmock.a.b.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        com.bytedance.ies.abmock.a.a r4 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.preCheckCast(r3.getAnnotation(com.bytedance.ies.abmock.a.a.class), com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
        SettingsKey r5 = (SettingsKey) ZeusTransformUtils.preCheckCast(r3.getAnnotation(SettingsKey.class), SettingsKey.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        return r5.a();
    L15:
        throw new RuntimeException("Can not find @ConfigKey or @ABKey or @SettingsKey in " + r3.getName());
    L9:
        return r4.a();
    L5:
        return r2.a();
    }

    public int i(Class r3) {
        com.bytedance.ies.abmock.a.a r4 = (com.bytedance.ies.abmock.a.a) ZeusTransformUtils.preCheckCast(r3.getAnnotation(com.bytedance.ies.abmock.a.a.class), com.bytedance.ies.abmock.a.a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        return a(r4);
    L7:
        return com.bytedance.ies.abmock.datacenter.b.f2667a;
    }
}
