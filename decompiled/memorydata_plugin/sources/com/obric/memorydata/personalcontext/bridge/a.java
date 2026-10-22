package com.obric.memorydata.personalcontext.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u001a*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001aP\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\r2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00100\rH\u0000\u001a2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a>\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"ALARM_FULL_CONTENT_COLUMN", "", "semanticOrphanRawDbIds", "", "", "liveRawDbIds", "", "indexedRawDbIds", "deleteSemanticOrphanIndexes", "", "vectorIdsByRawDbId", "", "deleteVector", "Lkotlin/Function1;", "", "deleteIndexRecords", "", "vectorIdsToDeleteAfterAlarmFullContentBuild", "buildSucceeded", "oldVectorIds", "newVectorIds", "deleteAlarmFullContentVectors", "vectorIds", "deleteAuxiliary", "personal_context_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final int a(Map<Long, ? extends List<Long>> r7, Function1<? super Long, Boolean> r8, Function1<? super List<Long>, Unit> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "vectorIdsByRawDbId");
        Intrinsics.checkNotNullParameter(r11, "deleteVector");
        Intrinsics.checkNotNullParameter(r12, "deleteIndexRecords");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r13 = r10.entrySet().iterator();
    L3:
        boolean r3 = true;
        if (r13.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
    L10:
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.invoke(r5.next()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L12;
        r3 = false;
    L16:
        if (r3 == false) goto L3;
        r0.put(r2.getKey(), r2.getValue());
        goto L3
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L18:
        List r14 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        r12.invoke(r14);
    L22:
        return r14.size();
    }

    public static final List<Long> a(Set<Long> r5, List<Long> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "liveRawDbIds");
        Intrinsics.checkNotNullParameter(r8, "indexedRawDbIds");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r2 = r10.next();
        if (r7.contains(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue())) == true) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final List<Long> a(boolean r2, List<Long> r3, List<Long> r4) {
        List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "oldVectorIds");
        Intrinsics.checkNotNullParameter(r6, "newVectorIds");
        if (r2 == false) goto L6;
        return r5;
    L6:
        return r6;
    }

    public static final boolean a(List<Long> r5, Function1<? super Long, Boolean> r6, Function1<? super Long, Unit> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "vectorIds");
        Intrinsics.checkNotNullParameter(r9, "deleteVector");
        Intrinsics.checkNotNullParameter(r10, "deleteAuxiliary");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(Long.valueOf(r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r10.invoke(Long.valueOf(r2));
        goto L4
    L7:
        return false;
    L10:
        return true;
    }
}
