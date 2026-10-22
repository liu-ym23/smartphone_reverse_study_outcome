package com.obric.memorydata.personalcontext.external;

import android.content.ContentResolver;
import android.content.Context;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010J\u001c\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010\u0018\u001a\u00020\u0010J\u0014\u0010\u0019\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001bJ\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010J\u001c\u0010\u001e\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\u0006\u0010\u0018\u001a\u00020\u0010RP\u0010\u0006\u001aB\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n \t* \u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bRP\u0010\f\u001aB\u0012\f\u0012\n \t*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n \t* \u0012\f\u0012\n \t*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \t*\u0004\u0018\u00010\n0\n\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pendingUpdateEntityIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lcom/obric/memorydata/personalcontext/external/EntityId;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "pendingUpdateEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "deleteUpdateEntityIds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "refreshRunnable", "Ljava/lang/Runnable;", "addUpdateEntity", "", "entityId", "type", "addUpdateEntities", "entityIds", "", "entities", "addDeleteEntity", "addDeleteEntities", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap.KeySetView<com.obric.memorydata.personalcontext.external.a, Boolean> f12141b;
    private final ConcurrentHashMap.KeySetView<AppEntity, Boolean> c;
    private final ConcurrentHashMap<Integer, Set<String>> d;
    private final Runnable e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater$Companion;", "", "<init>", "()V", "TAG", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12140a = new a(null);
    }

    public i(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f12141b = ConcurrentHashMap.newKeySet();
        this.c = ConcurrentHashMap.newKeySet();
        this.d = new ConcurrentHashMap();
        this.e = new $$Lambda$i$11vRWwUuSMmzqxYuiPZwd6e0QIg(this, r4);
    }

    private static final void a(i r8, Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView<com.obric.memorydata.personalcontext.external.a, Boolean> r0 = r8.f12141b;
        Intrinsics.checkNotNullExpressionValue(r0, "pendingUpdateEntityIds");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
        ConcurrentHashMap.KeySetView<com.obric.memorydata.personalcontext.external.a, Boolean> r1 = r8.f12141b;
        Intrinsics.checkNotNullExpressionValue(r1, "pendingUpdateEntityIds");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        Object r5 = r4.next();
        Integer r6 = Integer.valueOf(((com.obric.memorydata.personalcontext.external.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.personalcontext.external.a.class, "com.obric.memorydata.plugin")).getType());
        Object r7 = r3.get(r6);
        if (r7 != null) goto L10;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r3.put(r6, r7);
    L10:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L6
    L11:
        r8.f12141b.clear();
        List<? extends AppEntity> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = r3.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L23;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13.getValue(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        r15.add(((com.obric.memorydata.personalcontext.external.a) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.memorydata.personalcontext.external.a.class, "com.obric.memorydata.plugin")).a());
        goto L16
    L18:
        List<String> r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        h r18 = (h) ZeusTransformUtils.preCheckCast(g.f12138a.b().get(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue())), h.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L13;
        ContentResolver r19 = r10.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r19, "getContentResolver(...)");
        r11.addAll((Collection) ZeusTransformUtils.preCheckCast(r18.a(r19, r17), Collection.class, "com.obric.memorydata.plugin"));
        goto L13
    L23:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
        e.f12121a.a(r11);
    L25:
        Iterator r20 = ((Map) ZeusTransformUtils.preCheckCast(r8.d, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L27:
        if (r20.hasNext() == false) goto L31;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r22 = ((Number) ZeusTransformUtils.preCheckCast(r21.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Set r23 = (Set) ZeusTransformUtils.preCheckCast(r21.getValue(), Set.class, "com.obric.memorydata.plugin");
        List<String> r24 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin"));
        r23.clear();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        e.f12121a.a(r24, r22);
        goto L27
    L31:
        ConcurrentHashMap.KeySetView<AppEntity, Boolean> r25 = r8.c;
        Intrinsics.checkNotNullExpressionValue(r25, "pendingUpdateEntities");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L49;
        ConcurrentHashMap.KeySetView<AppEntity, Boolean> r26 = r8.c;
        Intrinsics.checkNotNullExpressionValue(r26, "pendingUpdateEntities");
        List<? extends AppEntity> r27 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin"));
        r8.c.clear();
        e.f12121a.a(r27);
        return;
    }

    public static /* synthetic */ void lambda$11vRWwUuSMmzqxYuiPZwd6e0QIg(i r0, Context r1) {
        a(r0, r1);
    }

    public final void a(List<? extends AppEntity> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "entities");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        this.c.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        f.f12127a.a().removeCallbacks(this.e);
        f.f12127a.a().postDelay(0, this.e);
    }

    public final void a(List<String> r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "entityIds");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        ConcurrentHashMap.KeySetView<com.obric.memorydata.personalcontext.external.a, Boolean> r0 = this.f12141b;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r2.add(new com.obric.memorydata.personalcontext.external.a((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), r7));
        goto L7
    L9:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        f.f12127a.a().removeCallbacks(this.e);
        f.f12127a.a().postDelay(0, this.e);
    }

    public final void b(List<String> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entityIds");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        ConcurrentMap r0 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.d, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Integer r8 = Integer.valueOf(r6);
        Object r2 = r0.get(r8);
        if (r2 != null) goto L11;
        r2 = (Set) ZeusTransformUtils.preCheckCast(ConcurrentHashMap.newKeySet(), Set.class, "com.obric.memorydata.plugin");
        Object r9 = r0.putIfAbsent(r8, r2);
        if (r9 == null) goto L11;
        r2 = r9;
    L11:
        ((Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin")).addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        f.f12127a.a().removeCallbacks(this.e);
        f.f12127a.a().postDelay(0, this.e);
    }
}
