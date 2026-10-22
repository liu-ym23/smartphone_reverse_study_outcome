package com.obric.memorydata.personalcontext.util;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006J&\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R,\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/SyncEntityDeleteDataManager;", "", "<init>", "()V", "needDeleteIds", "", "", "", "", "existIds", "setNeedDeleteIds", "", "deleteIds", "", "type", ObricMemoryConstants.KEY_PACKAGE_NAME, "setExistIds", "ids", "deleteEntity", "deleteEntityByPackageName", "clearSyncDeleteData", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f12378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Map<Integer, Set<String>>> f12379b = null;
    private static final Map<String, Map<Integer, Set<String>>> c = null;

    static {
        f12378a = new j();
        f12379b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private j() {
    }

    private final void b(String r1) {
        c.remove(r1);
        f12379b.remove(r1);
    }

    private static final List c(List r9, int r10, String r11) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        return IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r3, r10, r11, null, 8, null);
    }

    public static /* synthetic */ List lambda$7pCNu9SWRUS4NaLNlVICBb5dQFo(List r0, int r1, String r2) {
        return c(r0, r1, r2);
    }

    public final synchronized void a() {
        monitor-enter(this);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(f12379b.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(f12379b.get(r1), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L5;
        if ((!r2.isEmpty()) == false) goto L5;
        f12378a.a(r1);     // Catch: Throwable -> L14
        goto L5
    L11:
        b();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(final String r17) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L40
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityDataSyncUtil", "deleteEntityIdsByPackageName, packageName: " + r17, false, 4, null);     // Catch: Throwable -> L40
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(f12379b.get(r17), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r1 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r1.isEmpty() == false) goto L13;
        b(r17);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L13:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r1.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L40
    L15:
        if (r2.hasNext() == false) goto L37;
        final int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L40
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r3)), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r4 == null) goto L15;
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(c.get(r17), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r6 == null) goto L23;
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r3)), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r7 == null) goto L23;
    L24:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L40
    L26:
        if (r10.hasNext() == false) goto L30;
        Object r11 = r10.next();     // Catch: Throwable -> L40
        if ((!r7.contains((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"))) == false) goto L26;
        r9.add(r11);     // Catch: Throwable -> L40
        goto L26
    L30:
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityDataSyncUtil", "deleteEntityIdsByPackageName, packageName: " + r17 + ", entityType: " + r3 + ", deleteIds size: " + r5.size(), false, 4, null);     // Catch: Throwable -> L40
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L40
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), EntityManager.INSTANCE.getDeleteBatchSize(r3)), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L40
    L34:
        if (r13.hasNext() == false) goto L36;
        final List r14 = (List) ZeusTransformUtils.preCheckCast(r13.next(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        com.obric.memorydata.sdk.d.a(new $$Lambda$j$7pCNu9SWRUS4NaLNlVICBb5dQFo(r14, r3, r17));     // Catch: Throwable -> L40
        goto L34
    L36:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityDataSyncUtil", "deleteEntityIdsByPackageName, packageName: " + r17 + ", entityType: " + r3 + ", deleteIds size: " + r5.size() + ", cost: " + (System.currentTimeMillis() - r12) + " ms", false, 4, null);     // Catch: Throwable -> L40
    L23:
        r7 = SetsKt.emptySet();     // Catch: Throwable -> L40
        goto L24
    L37:
        b(r17);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L40:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(List<String> r5, int r6, String r7) {
        monitor-enter(this);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L22
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Map<String, Map<Integer, Set<String>>> r2 = f12379b;     // Catch: Throwable -> L22
        Map<Integer, Set<String>> r3 = r2.get(r7);     // Catch: Throwable -> L22
        if (r3 != null) goto L16;
        r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r2.put(r7, r3);     // Catch: Throwable -> L22
    L16:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Integer r10 = Integer.valueOf(r6);     // Catch: Throwable -> L22
        Object r4 = r9.get(r10);     // Catch: Throwable -> L22
        if (r4 != null) goto L19;
        r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r9.put(r10, r4);     // Catch: Throwable -> L22
    L19:
        ((Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        f12379b.clear();     // Catch: Throwable -> L6
        c.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(List<String> r5, int r6, String r7) {
        monitor-enter(this);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L22
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Map<String, Map<Integer, Set<String>>> r2 = c;     // Catch: Throwable -> L22
        Map<Integer, Set<String>> r3 = r2.get(r7);     // Catch: Throwable -> L22
        if (r3 != null) goto L16;
        r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r2.put(r7, r3);     // Catch: Throwable -> L22
    L16:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Integer r10 = Integer.valueOf(r6);     // Catch: Throwable -> L22
        Object r4 = r9.get(r10);     // Catch: Throwable -> L22
        if (r4 != null) goto L19;
        r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r9.put(r10, r4);     // Catch: Throwable -> L22
    L19:
        ((Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
    L22:
        th = move-exception;
        throw th;
    }
}
