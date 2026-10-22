package nk;

import android.content.Context;
import android.util.Pair;
import com.bytedance.ies.bullet.service.webkit.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sj.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f20269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static t9.a f20270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f20271c = null;
    public static final HashMap d = null;

    static {
        f20271c = new HashMap();
        d = new HashMap();
    }

    public static b a(String r10) {
        HashMap r5 = d;
        Map r11 = (Map) r5.get(r10);
        if (r11 == null) goto L5;
    L15:
        b r12 = (b) r11.get(sk.a.class);
        if (r12 == null) goto L19;
        return r12;
    L19:
        monitor-enter(b.class);
        b r13 = (b) r11.get(sk.a.class);     // Catch: Throwable -> L24
        if (r13 == null) goto L26;
        monitor-exit(b.class);     // Catch: Throwable -> L24
        return r13;
    L26:
        e r14 = new e();     // Catch: Throwable -> L24
        new LinkedHashSet();     // Catch: Throwable -> L24
        new LinkedHashSet();     // Catch: Throwable -> L24
        new LinkedHashSet();     // Catch: Throwable -> L24
        new HashMap();     // Catch: Throwable -> L24
        new HashSet();     // Catch: Throwable -> L24
        List r15 = (List) f20271c.get(r10);     // Catch: Throwable -> L24
        if (r15 != null) goto L31;
        monitor-exit(b.class);     // Catch: Throwable -> L24
        return null;
    L31:
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L24
    L33:
        if (r16.hasNext() == false) goto L42;
        Pair r17 = (Pair) r16.next();     // Catch: Throwable -> L24
        if (((Class) r17.first).equals(sk.a.class) == false) goto L33;
        com.bytedance.ies.bullet.service.webkit.b r18 = (com.bytedance.ies.bullet.service.webkit.b) r17.second;     // Catch: Throwable -> L24
        r18.getClass();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, "builder");     // Catch: Throwable -> L24
        c r19 = r18.f6154a;     // Catch: Throwable -> L24
        r19.getClass();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(bd.b.class, "clazz");     // Catch: Throwable -> L24
        tc.c r20 = tc.c.f22119c;     // Catch: Throwable -> L24
        if (tc.c.f22119c.a(bd.b.class, r19.f22117a) == null) goto L33;
        throw new ClassCastException();     // Catch: Throwable -> L24
    L42:
        b r21 = new b();     // Catch: Throwable -> L24
        r11.put(sk.a.class, r21);     // Catch: Throwable -> L24
        monitor-exit(b.class);     // Catch: Throwable -> L24
        return r21;
    L24:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(b.class);
        r11 = (Map) r5.get(r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        r11 = new Hashtable();     // Catch: Throwable -> L9
        r5.put(r10, r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
