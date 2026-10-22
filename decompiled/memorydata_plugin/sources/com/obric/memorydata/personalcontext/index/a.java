package com.obric.memorydata.personalcontext.index;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.e;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.c;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/index/EntityIndexProgressManager;", "", "<init>", "()V", "TAG", "", "ONE_PAGE_PENDING_TABLE_ITEM_COUNT", "", "ONE_PAGE_RAW_TABLE_ITEM_COUNT", "virtualVideoTypePendingColumns", "", "virtualPhotoTypePendingColumns", "virtualVideFrameTypePendingColumns", "virtualPendingColumnsHandler", "", "Lkotlin/Function1;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getProgress", "Lcom/obric/capabilitykit/entity/IndexProgress;", ObricMemoryConstants.KEY_PACKAGE_NAME, "type", "getProgressInner", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12224b = null;
    private static final Set<String> c = null;
    private static final Set<String> d = null;
    private static final Map<Integer, Function1<d, Set<String>>> e = null;

    static {
        f12223a = new a();
        f12224b = SetsKt.setOf(new String[]{"videoFrames", "ocr", "tags"});
        c = SetsKt.setOf(new String[]{"ocr", "tags"});
        d = SetsKt.setOf(new String[]{"ocr", "tags"});
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to(301, $$Lambda$a$yWNsptazOLY7HOeTzkGXV1QtQ5A.INSTANCE), TuplesKt.to(-304, $$Lambda$a$W6cgM0EAxTWZjTAcFN8HH4DfQ.INSTANCE)});
    }

    private a() {
    }

    private static final Set a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        if (ZeusTransformUtils.instanceOf(r2, hb.class) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(((hb) ZeusTransformUtils.preCheckCast(r2, hb.class, "com.obric.memorydata.plugin")).b(), "VIDEO") == false) goto L11;
        return f12224b;
    L11:
        return c;
    }

    private final IndexProgress b(String r21, int r22) {
        int r1 = r22;
        EntityIndexEngine r2 = s.a();
        IAppEntityRawDbDao<d> r3 = r2.getRawDaoByEntityType(r1);
        int r4 = 0;
        if (r3 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexProgressManager", "getProgressInner rawDao is null, type: " + r1, null, 4, null);
        return new IndexProgress(0, 0);
    L6:
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        e r5 = (e) ZeusTransformUtils.preCheckCast(r2.getEntityIndexImplMap().get(Integer.valueOf(r22)), e.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        Set<String> r7 = r5.getPendingTaskColumns();
    L10:
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        IndexPendingDao r9 = c.f9561a.b(r1);
        long r12 = -1;
    L11:
        int r14 = 200;
        List<cd> r13 = r9.queryUnhandledEntityWithLimit(r1, 200, r12);
        if (r13.isEmpty() == true) goto L13;
        long r15 = ((cd) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r13), cd.class, "com.obric.memorydata.plugin")).a();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r16.iterator();
    L40:
        if (r11.hasNext() == false) goto L42;
        r10.add(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r11.next(), cd.class, "com.obric.memorydata.plugin")).b()));
        goto L40
    L42:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r3.queryByIds((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L44:
        if (r19.hasNext() == false) goto L50;
        Object r110 = r19.next();
        Long r111 = Long.valueOf(((d) ZeusTransformUtils.preCheckCast(r110, d.class, "com.obric.memorydata.plugin")).getId());
        Object r112 = r18.get(r111);
        if (r112 != null) goto L48;
        Object r20 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r18.put(r111, r20);
    L49:
        ((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin")).add(r110);
        goto L44
    L48:
        r20 = r112;
        goto L49
    L50:
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L52:
        if (r23.hasNext() == false) goto L78;
        cd r24 = (cd) ZeusTransformUtils.preCheckCast(r23.next(), cd.class, "com.obric.memorydata.plugin");
        List r25 = (List) ZeusTransformUtils.preCheckCast(r18.get(Long.valueOf(r24.b())), List.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L56;
        d r26 = (d) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r25), d.class, "com.obric.memorydata.plugin");
    L57:
        if (r26 == null) goto L52;
        if (Intrinsics.areEqual(r26.getPackageName(), r21) == false) goto L52;
        if (r7 != null) goto L63;
    L65:
        boolean r113 = false;
    L66:
        if (r113 == true) goto L76;
        Function1 r114 = (Function1) ZeusTransformUtils.preCheckCast(e.get(Integer.valueOf(r22)), Function1.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L74;
        Set r27 = (Set) ZeusTransformUtils.preCheckCast(r114.invoke(r26), Set.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L74;
        if (r27.contains(r24.h()) != true) goto L74;
        boolean r28 = true;
    L75:
        if (r28 == false) goto L52;
    L74:
        r28 = false;
    L76:
        r6.add(r24.b() + '-' + r24.h());
        r8.put(r24.h(), Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r8.getOrDefault(r24.h(), 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));
        goto L52
    L63:
        if (r7.contains(r24.h()) != true) goto L65;
        r113 = true;
        goto L66
    L56:
        r26 = null;
        goto L57
    L78:
        r1 = r22;
        r12 = r15;
        r4 = 0;
        goto L11
    L13:
        int r115 = r6.size();
        int r29 = r4;
        long r116 = -1;
    L14:
        List<T> r30 = r3.queryByPackageNameWithLimit(r21, r14, r116);
        if (r30.isEmpty() == true) goto L16;
        r116 = ((d) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r30), d.class, "com.obric.memorydata.plugin")).getId();
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r31.hasNext() == false) goto L14;
        d r32 = (d) ZeusTransformUtils.preCheckCast(r31.next(), d.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L30;
        int r117 = r7.size();
    L31:
        Function1 r118 = (Function1) ZeusTransformUtils.preCheckCast(e.get(Integer.valueOf(r22)), Function1.class, "com.obric.memorydata.plugin");
        if (r118 == null) goto L36;
        Set r33 = (Set) ZeusTransformUtils.preCheckCast(r118.invoke(r32), Set.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L36;
        int r34 = r33.size();
    L37:
        r29 = r29 + (r117 + r34);
        r14 = 200;
    L36:
        r34 = r4;
        goto L37
    L30:
        r117 = r4;
        goto L31
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexProgressManager", "getProgressInner leftCount: " + r115 + ", rightCount: " + r29 + ", type: " + r1 + ", packageName: " + r21, false, 4, null);
        if (r29 <= 0) goto L20;
        if (r115 <= 0) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexProgressManager", "getProgressInner columnCountMap: " + r8, false, 4, null);
    L20:
        if (r115 <= r29) goto L23;
        r115 = r29;
    L23:
        return new IndexProgress(r115, r29);
    L9:
        r7 = null;
        goto L10
    }

    private static final Set b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        if (ZeusTransformUtils.instanceOf(r1, hr.class) == true) goto L7;
        return null;
    L7:
        return d;
    }

    /* JADX INFO: renamed from: lambda$W6cgM0EAxTWZjTAcFN8HH4-D-fQ, reason: not valid java name */
    public static /* synthetic */ Set m1081lambda$W6cgM0EAxTWZjTAcFN8HH4DfQ(d r0) {
        return b(r0);
    }

    public static /* synthetic */ Set lambda$yWNsptazOLY7HOeTzkGXV1QtQ5A(d r0) {
        return a(r0);
    }

    public final IndexProgress a(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IndexProgress r0 = b(r7, r8);
        if (r8 != 301) goto L6;
        IndexProgress r6 = b(r7, -304);
        IndexProgress r9 = new IndexProgress(r0.getLeft() + r6.getLeft(), r0.getTotal() + r6.getTotal());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexProgressManager", "getProgressInner videoFrameResult: " + r6 + ", sumResult: " + r9, false, 4, null);
        return r9;
    L6:
        return r0;
    }
}
