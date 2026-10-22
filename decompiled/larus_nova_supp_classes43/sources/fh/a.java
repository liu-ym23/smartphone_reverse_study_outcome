package fh;

import am3.c;
import am3.g;
import android.util.Base64;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final List<Function0<Map<Class<?>, c<?>>>> a = null;
    public static volatile boolean b;
    public static final ConcurrentHashMap<Class<?>, c<?>> c = null;
    public static final C0158a d = null;

    /* JADX INFO: renamed from: fh.a$a, reason: collision with other inner class name */
    public static final class C0158a {
        public static final ConcurrentHashMap a() {
            C0158a r0 = a.d;
            if (a.b == true) goto L18;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L6:
            if (a.b == true) goto L12;
            Iterator r1 = ((ArrayList) a.a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r1.hasNext() == false) goto L11;
            Function0 r10 = (Function0) r1.next();     // Catch: Throwable -> L14
            a.c.putAll((Map) r10.invoke());     // Catch: Throwable -> L14
            goto L9
        L11:
            hh.a.a(a.c);     // Catch: Throwable -> L14
            a.b = true;     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);
        L18:
            return a.c;
        }

        public C0158a() {
        }
    }

    public static final class b<T> implements c<T> {
        public final Constructor<T> a;

        public b(Constructor<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "constructor");
            this.a = r10;
        }

        public final T decode(g r10) throws Exception {
            Intrinsics.checkNotNullParameter(r10, "reader");
            return this.a.newInstance(new Object[]{r10});
        }
    }

    static {
        d = new C0158a();
        a = new ArrayList();
        c = new ConcurrentHashMap();
    }

    public static Object a(Class r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Object r0 = C0158a.a().get(r10);
        if ((r0 instanceof c) == true) goto L5;
        r0 = null;
    L5:
        c r1 = (c) r0;
        if (r1 == null) goto L9;
    L18:
        g r12 = new g();
        r12.k(new am3.b(Base64.decode(r11, 0)));     // Catch: Exception -> L23
        if (r1 == null) goto L30;
        return r1.decode(r12);
    L30:
        return null;
    L23:
        e = move-exception;
        e.toString();
        return null;
    L9:
        if (h.class.isAssignableFrom(r10) == true) goto L28;
    L14:
        r1 = null;
    L15:
        if (r1 != null) goto L18;
        r1 = null;
        goto L18
    L28:
        b r13 = new b(r10.getConstructor(new Class[]{g.class}));     // Catch: NoSuchMethodException -> L13
        C0158a.a().put(r10, r13);     // Catch: NoSuchMethodException -> L13
        r1 = r13;
        goto L15
    }
}
