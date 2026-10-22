package v4;

import c4.m;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f12724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f12725b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12726c = null;

    public static class a extends c4.b {
        public a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            Class<?> r10 = Class.forName("com.bytedance.applog.et_verify.EventVerify");     // Catch: ClassNotFoundException -> L5
        L6:
            if (r10 == null) goto L8;
            boolean r11 = true;
        L10:
            return Boolean.valueOf(r11);
        L8:
            r11 = false;
        L5:
            r10 = null;
            goto L6
        }
    }

    static {
        f12724a = Collections.singletonList("EventsSenderUtils");
        f12725b = new ConcurrentHashMap();
        f12726c = new a();
    }

    public static d a(String r10) {
        a r8 = f12726c;
        d r11 = null;
        if (((Boolean) r8.b(new Object[0])).booleanValue() == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap r12 = f12725b;
        if (r12.containsKey(r10) == true) goto L25;
        List<String> r13 = f12724a;
        if (((Boolean) r8.b(new Object[0])).booleanValue() == false) goto L22;
        r3.c r14 = r3.b.a(r10);
        if (r14 != null) goto L26;
        r14 = r3.a.f11390a;
    L26:
        Constructor<?> r15 = Class.forName("com.bytedance.applog.et_verify.EventVerify").getConstructor(new Class[]{r3.c.class});     // Catch: Throwable -> L18 Exception -> L21
        r15.setAccessible(true);     // Catch: Throwable -> L18 Exception -> L21
        d r16 = (d) r15.newInstance(new Object[]{r14});     // Catch: Throwable -> L18 Exception -> L21
        if (r16 != null) goto L16;
        m.u().j(r13, "can't find event verify, should compile with ET", new Object[0]);
    L17:
        r11 = r16;
        goto L22
    L16:
        m.u().h(r13, "found event sender: {}", new Object[]{r16});
        goto L17
    L21:
        m.u().j(r13, "can't find event verify, should compile with ET", new Object[0]);
    L18:
        th = move-exception;
        m.u().j(r13, "can't find event verify, should compile with ET", new Object[0]);
        throw th;
    L22:
        r12.put(r10, r11);
        return r11;
    L25:
        return (d) r12.get(r10);
    }

    public static boolean b(String r8) {
        a r10 = f12726c;
        if (((Boolean) r10.b(new Object[0])).booleanValue() == true) goto L5;
        return false;
    L5:
        d r11 = a(r8);
        if (r11 != null) goto L9;
        return false;
    L9:
        return r11.b();
    }
}
