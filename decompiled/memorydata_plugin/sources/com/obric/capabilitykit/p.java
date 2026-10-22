package com.obric.capabilitykit;

import android.app.Application;
import android.content.Context;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryServiceChecker;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityHistoryManager;", "", "()V", "ENTITY_MAX_RETRY_TIMES", "", "TAG", "", "dbHelper", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getDbHelper", "()Lcom/obric/capabilitykit/entity/EntityDBHelper;", "dbHelper$delegate", "Lkotlin/Lazy;", "restoreCountMap", "Ljava/util/concurrent/ConcurrentHashMap;", "clearRetryCount", "", "entityId", "entityType", "actionType", "getEntityHistoryDaoRetryKey", "entityHistoryDao", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "handleBulkDelete", "entityHistoryList", "", "handleBulkIndex", "restoreHistoryEntityProcess", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f7600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7601b = "EntityHistoryManager";
    private static final int c = 20;
    private static ConcurrentHashMap<String, Integer> d;
    private static final Lazy e = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7602a = null;

        static {
            m.values();
            int[] r1 = new int[2];
            m r2 = m.d;     // Catch: NoSuchFieldError -> L7
            r1[1] = 1;     // Catch: NoSuchFieldError -> L7
        L11:
            m r3 = m.c;     // Catch: NoSuchFieldError -> L8
            r1[0] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f7602a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7603a = null;

        static {
            f7603a = new b();
        }

        public b() {
            super(0);
        }

        public final n a() {
            n.a r3 = n.f7596b;
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "AppHost.application.applicationContext");
            return r3.a(r0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ n invoke() {
            return a();
        }
    }

    static {
        f7600a = new p();
        e = LazyKt.lazy(b.f7603a);
    }

    private p() {
    }

    private final n a() {
        return (n) ZeusTransformUtils.preCheckCast(e.getValue(), n.class, "com.obric.memorydata.plugin");
    }

    private final String a(o r3) {
        return b(r3.h(), r3.j(), r3.f().b());
    }

    private final void a(List<o> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r1 = r8.next();
        Integer r2 = Integer.valueOf(((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).j());
        Object r3 = r7.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r7.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).add(r1);
        goto L4
    L9:
        Iterator r9 = r7.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r10.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10.getValue(), List.class, "com.obric.memorydata.plugin");
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.add(((o) ZeusTransformUtils.preCheckCast(r13.next(), o.class, "com.obric.memorydata.plugin")).h());
        goto L14
    L16:
        Logger.INSTANCE.i(f7601b, "handleBulkDelete " + q.b(r12));
        EntityProvider.INSTANCE.bulkDelete(r12, r4);
        goto L11
    }

    private final String b(String r1, int r2, String r3) {
        return r1 + '_' + r2 + '_' + r3;
    }

    private final void b(List<o> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        o r3 = (o) ZeusTransformUtils.preCheckCast(r11.next(), o.class, "com.obric.memorydata.plugin");
        r0.add(AppEntity.CREATOR.fromJsonKeepTimeStamp(r3.g()));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logger.INSTANCE.e(f7601b, "handleBulkIndex parseAppEntityError", e);
        r2.add(Long.valueOf(r3.i()));
        goto L4
    L10:
        a().a(r2);
        Logger.INSTANCE.i(f7601b, "handleBulkIndex " + q.b(q.a(r0)));
        EntityProvider.bulkIndexInner$capabilitykit_release$default(EntityProvider.INSTANCE, r0, null, 2, null);
    }

    public final void a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        ConcurrentHashMap<String, Integer> r0 = d;
        if (r0 == null) goto L6;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.remove(b(r2, r3, r4)), Integer.class, "com.obric.memorydata.plugin");
        return;
    }

    public final synchronized void b() {
        monitor-enter(this);
        MemoryServiceChecker r0 = MemoryServiceChecker.INSTANCE;     // Catch: Throwable -> L57
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r1, "AppHost.application.applicationContext");     // Catch: Throwable -> L57
        if (r0.checkEntityProviderAvailable(r1) == MemoryServiceStatus.AVAILABLE) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger r2 = Logger.INSTANCE;     // Catch: Throwable -> L57
        r2.i(f7601b, "restoreHistoryEntityProcess start");     // Catch: Throwable -> L57
        List<o> r3 = a().b();     // Catch: Throwable -> L57
        if (r3.isEmpty() == false) goto L12;
        r2.i(f7601b, "restoreHistoryEntityProcess entityHistoryList is empty");     // Catch: Throwable -> L57
        d = null;     // Catch: Throwable -> L57
        monitor-exit(this);
        return;
    L12:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator<T> r5 = r3.iterator();     // Catch: Throwable -> L57
    L14:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();     // Catch: Throwable -> L57
        String r7 = ((o) ZeusTransformUtils.preCheckCast(r6, o.class, "com.obric.memorydata.plugin")).h();     // Catch: Throwable -> L57
        Object r8 = r4.get(r7);     // Catch: Throwable -> L57
        if (r8 != null) goto L18;
        r8 = new ArrayList();     // Catch: Throwable -> L57
        r4.put(r7, r8);     // Catch: Throwable -> L57
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).add(r6);     // Catch: Throwable -> L57
        goto L14
    L19:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r11 = new ConcurrentHashMap();     // Catch: Throwable -> L57
        Iterator r12 = r4.entrySet().iterator();     // Catch: Throwable -> L57
    L21:
        if (r12.hasNext() == false) goto L34;
        List r13 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        o r14 = (o) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r13), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        String r15 = f7600a.a(r14);     // Catch: Throwable -> L57
        ConcurrentHashMap<String, Integer> r16 = d;     // Catch: Throwable -> L57
        if (r16 == null) goto L26;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.get(r15), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        if (r17 == null) goto L26;
    L27:
        Intrinsics.checkNotNullExpressionValue(r17, "restoreCountMap?.get(retryKey) ?: 0");     // Catch: Throwable -> L57
        int r18 = r17.intValue();     // Catch: Throwable -> L57
        if (r18 >= 20) goto L30;
        r11.put(r15, Integer.valueOf(r18 + 1));     // Catch: Throwable -> L57
        r9.add(r14);     // Catch: Throwable -> L57
    L32:
        if (r13.size() <= 1) goto L21;
        r10.addAll(CollectionsKt.dropLast(r13, 1));     // Catch: Throwable -> L57
        goto L21
    L30:
        r10.add(r14);     // Catch: Throwable -> L57
    L26:
        r17 = 0;     // Catch: Throwable -> L57
        goto L27
    L34:
        d = r11;     // Catch: Throwable -> L57
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L57
        Iterator r20 = r10.iterator();     // Catch: Throwable -> L57
    L36:
        if (r20.hasNext() == false) goto L38;
        r19.add(Long.valueOf(((o) ZeusTransformUtils.preCheckCast(r20.next(), o.class, "com.obric.memorydata.plugin")).i()));     // Catch: Throwable -> L57
        goto L36
    L38:
        a().a(r19);     // Catch: Throwable -> L57
        LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L57
        Iterator r22 = r9.iterator();     // Catch: Throwable -> L57
    L40:
        if (r22.hasNext() == false) goto L45;
        Object r23 = r22.next();     // Catch: Throwable -> L57
        m r24 = ((o) ZeusTransformUtils.preCheckCast(r23, o.class, "com.obric.memorydata.plugin")).f();     // Catch: Throwable -> L57
        Object r25 = r21.get(r24);     // Catch: Throwable -> L57
        if (r25 != null) goto L44;
        r25 = new ArrayList();     // Catch: Throwable -> L57
        r21.put(r24, r25);     // Catch: Throwable -> L57
    L44:
        ((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin")).add(r23);     // Catch: Throwable -> L57
        goto L40
    L45:
        Iterator r26 = r21.entrySet().iterator();     // Catch: Throwable -> L57
    L47:
        if (r26.hasNext() == false) goto L55;
        Map.Entry r27 = (Map.Entry) ZeusTransformUtils.preCheckCast(r26.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        m r28 = (m) ZeusTransformUtils.preCheckCast(r27.getKey(), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        List<o> r29 = (List) ZeusTransformUtils.preCheckCast(r27.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L57
        int r30 = r28.ordinal();     // Catch: Throwable -> L57
        if (r30 != 0) goto L50;
        f7600a.b(r29);     // Catch: Throwable -> L57
        goto L47
    L50:
        if (r30 != 1) goto L47;
        f7600a.a(r29);     // Catch: Throwable -> L57
        goto L47
    L55:
        monitor-exit(this);
        return;
    L57:
        th = move-exception;
        throw th;
    }
}
