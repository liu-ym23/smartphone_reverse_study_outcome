package com.obric.capabilitykit;

import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import wia.v;
import yia.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class p {
    public static final p a = null;
    public static ConcurrentHashMap<String, Integer> b;
    public static final Lazy c = null;

    static {
        a = new p();
        c = LazyKt.lazy(b.a);
    }

    public p() {
    }

    public final synchronized void b() {
        monitor-enter(this);
        int r0 = a.a;     // Catch: Throwable -> L57
        if (a.a(AppHost.Companion.getApplication().getApplicationContext()) == MemoryServiceStatus.AVAILABLE) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L57
        r1.i("EntityHistoryManager", "restoreHistoryEntityProcess start");     // Catch: Throwable -> L57
        List r2 = ((v) c.getValue()).f();     // Catch: Throwable -> L57
        if (r2.isEmpty() == false) goto L12;
        r1.i("EntityHistoryManager", "restoreHistoryEntityProcess entityHistoryList is empty");     // Catch: Throwable -> L57
        b = null;     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L12:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L57
    L14:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();     // Catch: Throwable -> L57
        String r6 = ((wia.w) r5).b;     // Catch: Throwable -> L57
        Object r7 = r3.get(r6);     // Catch: Throwable -> L57
        if (r7 != null) goto L18;
        r7 = new ArrayList();     // Catch: Throwable -> L57
        r3.put(r6, r7);     // Catch: Throwable -> L57
    L18:
        ((List) r7).add(r5);     // Catch: Throwable -> L57
        goto L14
    L19:
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r10 = new ConcurrentHashMap();     // Catch: Throwable -> L57
        Iterator r11 = r3.entrySet().iterator();     // Catch: Throwable -> L57
    L21:
        if (r11.hasNext() == false) goto L34;
        List r12 = (List) ((Map.Entry) r11.next()).getValue();     // Catch: Throwable -> L57
        wia.w r13 = (wia.w) CollectionsKt.last(r12);     // Catch: Throwable -> L57
        String r14 = r13.b + '_' + r13.d + '_' + r13.e.b();     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r15 = b;     // Catch: Throwable -> L57
        if (r15 == null) goto L26;
        Integer r16 = r15.get(r14);     // Catch: Throwable -> L57
        if (r16 == null) goto L26;
    L27:
        int r17 = r16.intValue();     // Catch: Throwable -> L57
        if (r17 >= 20) goto L30;
        r10.put(r14, Integer.valueOf(r17 + 1));     // Catch: Throwable -> L57
        r8.add(r13);     // Catch: Throwable -> L57
    L32:
        if (r12.size() <= 1) goto L21;
        r9.addAll(CollectionsKt.dropLast(r12, 1));     // Catch: Throwable -> L57
        goto L21
    L30:
        r9.add(r13);     // Catch: Throwable -> L57
    L26:
        r16 = 0;     // Catch: Throwable -> L57
        goto L27
    L34:
        b = r10;     // Catch: Throwable -> L57
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));     // Catch: Throwable -> L57
        Iterator r19 = r9.iterator();     // Catch: Throwable -> L57
    L36:
        if (r19.hasNext() == false) goto L38;
        r18.add(Long.valueOf(((wia.w) r19.next()).a));     // Catch: Throwable -> L57
        goto L36
    L38:
        ((v) c.getValue()).d(r18);     // Catch: Throwable -> L57
        LinkedHashMap r20 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator r21 = r8.iterator();     // Catch: Throwable -> L57
    L40:
        if (r21.hasNext() == false) goto L45;
        Object r22 = r21.next();     // Catch: Throwable -> L57
        m r23 = ((wia.w) r22).e;     // Catch: Throwable -> L57
        Object r24 = r20.get(r23);     // Catch: Throwable -> L57
        if (r24 != null) goto L44;
        r24 = new ArrayList();     // Catch: Throwable -> L57
        r20.put(r23, r24);     // Catch: Throwable -> L57
    L44:
        ((List) r24).add(r22);     // Catch: Throwable -> L57
        goto L40
    L45:
        Iterator r25 = r20.entrySet().iterator();     // Catch: Throwable -> L57
    L47:
        if (r25.hasNext() == false) goto L55;
        Map.Entry r26 = (Map.Entry) r25.next();     // Catch: Throwable -> L57
        m r27 = (m) r26.getKey();     // Catch: Throwable -> L57
        List r28 = (List) r26.getValue();     // Catch: Throwable -> L57
        int r29 = r27.ordinal();     // Catch: Throwable -> L57
        if (r29 != 0) goto L50;
        c(r28);     // Catch: Throwable -> L57
        goto L47
    L50:
        if (r29 != 1) goto L47;
        a(r28);     // Catch: Throwable -> L57
        goto L47
    L55:
        monitor-exit(this);
        return;
    L57:
        th = move-exception;
        throw th;
    }

    public static void a(List r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        Integer r2 = Integer.valueOf(((wia.w) r1).d);
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        Iterator r7 = r0.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) r7.next();
        int r8 = ((Number) r4.getKey()).intValue();
        List r9 = (List) r4.getValue();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r10.add(((wia.w) r11.next()).b);
        goto L14
    L16:
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkDelete " + q.b(r10));
        EntityProvider.INSTANCE.bulkDelete(r10, r8);
        goto L11
    }

    public static void c(List r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        wia.w r2 = (wia.w) r8.next();
        r0.add(AppEntity.CREATOR.fromJsonKeepTimeStamp(r2.c));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logger.INSTANCE.e("EntityHistoryManager", "handleBulkIndex parseAppEntityError", e);
        r1.add(Long.valueOf(r2.a));
        goto L4
    L10:
        ((v) c.getValue()).d(r1);
        Logger.INSTANCE.i("EntityHistoryManager", "handleBulkIndex " + q.b(q.a(r0)));
        EntityProvider.bulkIndexInner$capabilitykit_release$default(EntityProvider.INSTANCE, r0, null, 2, null);
    }
}
