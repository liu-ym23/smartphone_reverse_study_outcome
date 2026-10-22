package com.larus.bmhome.clarification;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final h a = null;
    public static final Map<String, LinkedHashSet<String>> b = null;
    public static final Map<String, LinkedHashSet<String>> c = null;

    public h() {
    }

    static {
        a = new h();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
    }

    public static LinkedHashSet d(String r5) {
        String r0 = AccountService.a.getUserId();
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = "anonymous";
    L6:
        if (Intrinsics.areEqual(r5, "consumed_identifiers") == false) goto L9;
        Map<String, LinkedHashSet<String>> r1 = b;
    L11:
        LinkedHashSet<String> r2 = r1.get(r0);
        if (r2 != null) goto L24;
        String[] r6 = Keva.getRepo("auto_route_clarification_".concat(r0), 0).getStringArray(r5, new String[0]);
        if (r6 != null) goto L16;
        r6 = new String[0];
    L16:
        List r7 = ArraysKt.filterNotNull(r6);
        ArrayList r3 = new ArrayList();
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r4 = r8.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L18;
        r3.add(r4);
        goto L18
    L22:
        r2 = new LinkedHashSet(CollectionsKt.takeLast(r3, 200));
        r1.put(r0, r2);
    L24:
        return r2;
    L9:
        if (Intrinsics.areEqual(r5, "discarded_answer_identifiers") == false) goto L26;
        r1 = c;
        goto L11
    L26:
        throw new IllegalStateException("Unsupported AutoRoute clarification store key: ".concat(r5).toString());
    }

    public final synchronized boolean c(Collection<String> r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "identifiers");     // Catch: Throwable -> L6
        boolean r3 = b("discarded_answer_identifiers", r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(Collection<String> r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "identifiers");     // Catch: Throwable -> L6
        a("consumed_identifiers", r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void a(String r3, Collection r4) {
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L11;
        return;
    L11:
        LinkedHashSet r6 = d(r3);
        r6.addAll(r0);
    L13:
        if (r6.size() <= 200) goto L18;
        Iterator r2 = r6.iterator();
        if (r2.hasNext() == false) goto L18;
        r2.next();
        r2.remove();
    L18:
        String r7 = AccountService.a.getUserId();
        if (StringsKt.isBlank(r7) == false) goto L21;
        r7 = "anonymous";
    L21:
        Keva.getRepo("auto_route_clarification_".concat(r7), 0).storeStringArray(r3, (String[]) r6.toArray(new String[0]));
    }

    public static boolean b(String r4, Collection r5) {
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        if ((true ^ StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L12;
        return false;
    L12:
        if (r0.isEmpty() == true) goto L20;
        Iterator r7 = r0.iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        String r2 = (String) r7.next();
        if (d(r4).contains(r2) == false) goto L16;
        return true;
    L20:
        return false;
    }
}
