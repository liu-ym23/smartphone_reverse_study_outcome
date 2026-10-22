package d1;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.obric.cae.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f6745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f6746e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f6747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f6748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6749c;

    static {
        f6746e = new Object();
    }

    public a(Context r8) {
        this.f6749c = r8.getApplicationContext();
        this.f6748b = new HashSet();
        this.f6747a = new HashMap();
    }

    public static a c(Context r8) {
        if (f6745d != null) goto L15;
        Object r10 = f6746e;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6745d != null) goto L9;
        f6745d = new a(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return f6745d;
    }

    public final void a(Bundle r8) {
        String r10 = this.f6749c.getString(R.string.androidx_startup);
        if (r8 != null) goto L22;
        return;
    L22:
        HashSet r11 = new HashSet();     // Catch: ClassNotFoundException -> L18
        Iterator<String> r12 = r8.keySet().iterator();     // Catch: ClassNotFoundException -> L18
    L5:
        boolean r13 = r12.hasNext();     // Catch: ClassNotFoundException -> L18
        HashSet r14 = this.f6748b;
        if (r13 == false) goto L13;
        String r15 = r12.next();     // Catch: ClassNotFoundException -> L18
        if (r10.equals(r8.getString(r15, null)) == false) goto L5;
        Class<?> r16 = Class.forName(r15);     // Catch: ClassNotFoundException -> L18
        if (b.class.isAssignableFrom(r16) == false) goto L5;
        r14.add(r16);     // Catch: ClassNotFoundException -> L18
        goto L5
    L13:
        Iterator r17 = r14.iterator();     // Catch: ClassNotFoundException -> L18
    L14:
        if (r17.hasNext() == false) goto L32;
        b((Class) r17.next(), r11);     // Catch: ClassNotFoundException -> L18
        goto L14
    L32:
        return;
    L18:
        e = move-exception;
        throw new c(e);
    }

    public final Object b(Class r8, HashSet r10) {
        if (e1.a.a() == false) goto L7;
        Trace.beginSection(r8.getSimpleName());     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Trace.endSection();
        throw th;
    L7:
        if (r10.contains(r8) == true) goto L30;
        HashMap r11 = this.f6747a;
        if (r11.containsKey(r8) == true) goto L26;
        r10.add(r8);     // Catch: Throwable -> L31
        b r12 = (b) r8.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L20
        List<Class<? extends b<?>>> r13 = r12.a();     // Catch: Throwable -> L20
        if (r13.isEmpty() == true) goto L22;
        Iterator<Class<? extends b<?>>> r14 = r13.iterator();     // Catch: Throwable -> L20
    L16:
        if (r14.hasNext() == false) goto L22;
        Class<? extends b<?>> r15 = r14.next();     // Catch: Throwable -> L20
        if (r11.containsKey(r15) == true) goto L16;
        b(r15, r10);     // Catch: Throwable -> L20
    L22:
        Object r16 = r12.b(this.f6749c);     // Catch: Throwable -> L20
        r10.remove(r8);     // Catch: Throwable -> L20
        r11.put(r8, r16);     // Catch: Throwable -> L20
    L27:
        Trace.endSection();
        return r16;
    L20:
        th = move-exception;
        throw new c(th);     // Catch: Throwable -> L31
    L26:
        r16 = r11.get(r8);     // Catch: Throwable -> L31
        goto L27
    L30:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r8.getName()}));     // Catch: Throwable -> L31
    }
}
