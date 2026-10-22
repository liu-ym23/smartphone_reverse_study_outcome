package l3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new b());
        b = LazyKt.lazy(new c());
    }

    public static ConcurrentHashMap a() {
        return (ConcurrentHashMap) b.getValue();
    }

    public static boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        CopyOnWriteArrayList r10 = (CopyOnWriteArrayList) a().get(r1);
        d(r10);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r10.isEmpty()) != true) goto L7;
        return true;
    }

    public static void c(a r10) {
        Intrinsics.checkNotNullParameter(r10, "aiBridgeEvent");
        if (r10.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        long r1 = System.currentTimeMillis();
        ConcurrentSkipListSet r11 = new ConcurrentSkipListSet();
        Iterator r12 = ((CopyOnWriteArrayList) a.getValue()).iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        a r13 = (a) r12.next();
        if (Math.abs(r1 - r13.c) <= 10000) goto L10;
        r11.add(r13);
        goto L10
    L14:
        Iterator r14 = r11.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        a r15 = (a) r14.next();
        ((CopyOnWriteArrayList) a.getValue()).remove(r15);
        goto L16
    L18:
        ((CopyOnWriteArrayList) a.getValue()).add(r10);
        CopyOnWriteArrayList r16 = (CopyOnWriteArrayList) a().get(r10.a);
        d(r16);
        if (r16 == null) goto L24;
        Iterator r17 = r16.iterator();
    L22:
        if (r17.hasNext() == false) goto L32;
        ((e) r17.next()).a(r10);
        goto L22
    L32:
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void d(CopyOnWriteArrayList r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator r1 = r10.iterator();
    L5:
        boolean r11 = true;
        if (r1.hasNext() == false) goto L14;
        Object r12 = r1.next();
        if (((e) r12).e.get() == null) goto L11;
        r11 = false;
    L11:
        if (r11 == false) goto L5;
        r0.add(r12);
        goto L5
    L14:
        if ((!r0.isEmpty()) == false) goto L22;
        r10.removeAll(CollectionsKt.toSet(r0));
        return;
    }

    public static void e(e r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "subscriber");
        Intrinsics.checkNotNullParameter(r11, "eventName");
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) a().get(r11);
        if (r0 != null) goto L6;
        r0 = new CopyOnWriteArrayList();
        a().put(r11, r0);
    L21:
        d(r0);
        r0.add(r10);
        a().put(r11, r0);
        Iterator r1 = ((CopyOnWriteArrayList) a.getValue()).iterator();
    L23:
        if (r1.hasNext() == false) goto L29;
        a r12 = (a) r1.next();
        if (Intrinsics.areEqual(r12.a, r11) == false) goto L23;
        if (r10.c >= r12.c) goto L23;
        Intrinsics.checkNotNull(r12);
        r10.a(r12);
        goto L23
    L29:
        return;
    L6:
        if (r0.contains(r10) == false) goto L21;
        Iterator r13 = r0.iterator();
    L8:
        String r14 = null;
        if (r13.hasNext() == false) goto L13;
        Object r15 = r13.next();
        if (Intrinsics.areEqual(((e) r15).a, r10.a) == false) goto L8;
    L14:
        e r16 = (e) r15;
        if (r16 == null) goto L18;
        r14 = r16.d;
    L18:
        if (Intrinsics.areEqual(r14, r10.d) == true) goto L20;
        com.bytedance.ai.applet.base.log.a.c("AIBridgeEventCenter", "tag is different. remove old subscriber");
        r0.remove(r16);
        goto L21
    L20:
        return;
    L13:
        r15 = null;
        goto L14
    }
}
