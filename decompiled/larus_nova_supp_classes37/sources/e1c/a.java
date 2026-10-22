package e1c;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements o1c.b {
    public final Map<Class<o1c.c<?, ?>>, Set<Object>> a;
    public final Map<Class<o1c.c<?, ?>>, Set<Object>> b;

    public a() {
        this.a = new HashMap();
        this.b = new HashMap();
    }

    @Override // o1c.b
    public final void b(o1c.c r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.remove(r3.getClass());
        Map<Class<o1c.c<?, ?>>, Set<Object>> r2 = this.b;
        HashMap r4 = (HashMap) r2;
        r4.remove(r3.getClass());
    }

    @Override // o1c.b
    public final void a(o1c.c r4, Collection r5) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter(r5, "cache");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        if (r1.get(r4.getClass()) != null) goto L5;
        Map<Class<o1c.c<?, ?>>, Set<Object>> r2 = this.a;
        HashMap r3 = (HashMap) r2;
        r3.put(r4.getClass(), new HashSet());
    L5:
        Map<Class<o1c.c<?, ?>>, Set<Object>> r6 = this.a;
        HashMap r7 = (HashMap) r6;
        Set r8 = (Set) r7.get(r4.getClass());
        if (r8 == null) goto L9;
        r8.addAll(r5);
        return;
    }

    @Override // o1c.b
    public final boolean c(o1c.c<?, ?> r6, Collection<? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "task");
        Intrinsics.checkNotNullParameter(r7, "cache");
        Map<Class<o1c.c<?, ?>>, Set<Object>> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        if (r1.get(r6.getClass()) != null) goto L5;
        Map<Class<o1c.c<?, ?>>, Set<Object>> r2 = this.b;
        HashMap r3 = (HashMap) r2;
        r3.put(r6.getClass(), new HashSet());
    L5:
        Iterator<T> r4 = r7.iterator();
    L6:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L15;
        Object r8 = r4.next();
        Map<Class<o1c.c<?, ?>>, Set<Object>> r9 = this.b;
        HashMap r10 = (HashMap) r9;
        Set r11 = (Set) r10.get(r6.getClass());
        if (r11 == null) goto L13;
        if (r11.contains(r8) != true) goto L13;
        r5 = true;
    L13:
        if (r5 == false) goto L6;
        r5 = true;
    L15:
        Map<Class<o1c.c<?, ?>>, Set<Object>> r12 = this.b;
        HashMap r13 = (HashMap) r12;
        Set r14 = (Set) r13.get(r6.getClass());
        if (r14 == null) goto L18;
        r14.addAll(r7);
    L18:
        return r5;
    }

    @Override // o1c.b
    public final boolean d(o1c.c<?, ?> r5, Collection<? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "task");
        Intrinsics.checkNotNullParameter(r6, "cache");
        Iterator<T> r7 = r6.iterator();
    L3:
        boolean r1 = false;
        if (r7.hasNext() == false) goto L12;
        Object r0 = r7.next();
        Map<Class<o1c.c<?, ?>>, Set<Object>> r2 = this.a;
        HashMap r3 = (HashMap) r2;
        Set r4 = (Set) r3.get(r5.getClass());
        if (r4 == null) goto L10;
        if (r4.contains(r0) != true) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L3;
        return true;
    L12:
        return false;
    }
}
