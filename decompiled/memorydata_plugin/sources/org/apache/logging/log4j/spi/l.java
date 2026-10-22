package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Properties;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Integer f17907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.apache.logging.log4j.c f17908b = null;
    private final Integer c;
    private final String d;
    private final Class<? extends g> e;
    private final String f;
    private final Class<? extends n> g;
    private final String h;
    private final URL i;
    private final WeakReference<ClassLoader> j;

    static {
        f17907a = -1;
        f17908b = StatusLogger.getLogger();
    }

    public l(Properties r1, URL r2, ClassLoader r3) {
        this.i = r2;
        this.j = new WeakReference(r3);
        String r4 = r1.getProperty("FactoryPriority");
        if (r4 != null) goto L5;
        Integer r5 = f17907a;
    L6:
        this.c = r5;
        this.d = r1.getProperty("LoggerContextFactory");
        this.f = r1.getProperty("ThreadContextMap");
        this.e = null;
        this.g = null;
        this.h = null;
        return;
    L5:
        r5 = Integer.valueOf(r4);
        goto L6
    }

    public String a() {
        return this.h;
    }

    public Integer b() {
        return this.c;
    }

    public String c() {
        Class<? extends g> r0 = this.e;
        if (r0 == null) goto L7;
        return r0.getName();
    L7:
        return this.d;
    }

    public Class<? extends g> d() {
        Class<? extends g> r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.d != null) goto L8;
        return null;
    L8:
        ClassLoader r1 = (ClassLoader) ZeusTransformUtils.preCheckCast(this.j.get(), ClassLoader.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L18;
        return null;
    L18:
        Class<?> r2 = r1.loadClass(this.d);     // Catch: Exception -> L15
        if (g.class.isAssignableFrom(r2) == false) goto L17;
        return r2.asSubclass(g.class);
    L17:
        return null;
    L15:
        e = move-exception;
        f17908b.error("Unable to create class {} specified in {}", this.d, this.i.toString(), e);
        goto L17
    }

    public String e() {
        Class<? extends n> r0 = this.g;
        if (r0 == null) goto L7;
        return r0.getName();
    L7:
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L42:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L42;
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin");
        Integer r2 = this.c;
        if (r2 == null) goto L16;
        if (r2.equals(r6.c) == false) goto L17;
    L18:
        String r3 = this.d;
        if (r3 == null) goto L24;
        if (r3.equals(r6.d) == false) goto L25;
    L26:
        Class<? extends g> r4 = this.e;
        if (r4 == null) goto L32;
        if (r4.equals(r6.e) == false) goto L33;
    L34:
        String r7 = this.h;
        if (r7 == null) goto L38;
        return r7.equals(r6.h);
    L38:
        if (r6.h != null) goto L41;
        return true;
    L41:
        return false;
    L33:
        return false;
    L32:
        if (r6.e == null) goto L34;
    L25:
        return false;
    L24:
        if (r6.d == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.c == null) goto L18;
        goto L17
    }

    public Class<? extends n> f() {
        Class<? extends n> r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f != null) goto L8;
        return null;
    L8:
        ClassLoader r1 = (ClassLoader) ZeusTransformUtils.preCheckCast(this.j.get(), ClassLoader.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L18;
        return null;
    L18:
        Class<?> r2 = r1.loadClass(this.f);     // Catch: Exception -> L15
        if (n.class.isAssignableFrom(r2) == false) goto L17;
        return r2.asSubclass(n.class);
    L17:
        return null;
    L15:
        e = move-exception;
        f17908b.error("Unable to create class {} specified in {}", this.f, this.i.toString(), e);
        goto L17
    }

    public URL g() {
        return this.i;
    }

    public int hashCode() {
        Integer r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Class<? extends g> r7 = this.e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.h;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Provider[");
        String r2 = ", ";
        if (f17907a.equals(this.c) == true) goto L6;
        r0.append("priority=").append(this.c).append(", ");
    L6:
        if (this.f == null) goto L9;
        r0.append("threadContextMap=").append(this.f).append(", ");
    L12:
        if (this.d == null) goto L16;
        StringBuilder r1 = r0.append("className=").append(this.d);
    L14:
        r1.append(r2);
    L19:
        if (this.i == null) goto L21;
        r0.append("url=").append(this.i);
    L21:
        WeakReference<ClassLoader> r4 = this.j;
        if (r4 == null) goto L27;
        ClassLoader r5 = (ClassLoader) ZeusTransformUtils.preCheckCast(r4.get(), ClassLoader.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L27;
        r0.append(", classLoader=").append(r5);
    L28:
        r0.append("]");
        return r0.toString();
    L27:
        r0.append(", classLoader=null(not reachable)");
        goto L28
    L16:
        if (this.e == null) goto L19;
        r1 = r0.append("class=");
        r2 = this.e.getName();
        goto L14
    L9:
        if (this.g == null) goto L12;
        r0.append("threadContextMapClass=").append(this.g.getName());
        goto L12
    }
}
