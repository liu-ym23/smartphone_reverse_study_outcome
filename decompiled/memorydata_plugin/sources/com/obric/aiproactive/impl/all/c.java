package com.obric.aiproactive.impl.all;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032&\u0010\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00070\u0006H\u0000\u001a&\u0010\b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006H\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"bindAllRecommendationsInvalidationSources", "Lcom/obric/aiproactive/impl/all/AllRecommendationsInvalidationRegistration;", "onInvalidated", "Lkotlin/Function0;", "", "sourceBinders", "", "Lkotlin/Function1;", "closeInvalidationSources", "Ljava/lang/Exception;", "Lkotlin/Exception;", "removers", "defaultNextDayBoundaryDelayMs", "", "nowMillis", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    public static final /* synthetic */ long a(long r0) {
        return b(r0);
    }

    public static final a a(Function0<Unit> r5, List<? extends Function1<? super Function0<Unit>, ? extends Function0<Unit>>> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "onInvalidated");
        Intrinsics.checkNotNullParameter(r8, "sourceBinders");
        final List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L16
    L5:
        if (r2.hasNext() == false) goto L11;
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.preCheckCast(r2.next(), Function1.class, "com.obric.memorydata.plugin")).invoke(r7), Function0.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if (r3 == null) goto L5;
        r0.add(r3);     // Catch: Exception -> L16
        goto L5
    L11:
        if (r0.size() != r8.size()) goto L13;
        boolean r9 = true;
    L15:
        return new a(r9, new $$Lambda$c$zKmZlZ0AboEgdJnMweKnZEbxmU(r0));
    L13:
        r9 = false;
    L16:
        e = move-exception;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        e.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r10.next(), Throwable.class, "com.obric.memorydata.plugin"));
        goto L19
    L21:
        throw e;
    }

    private static final List<Exception> a(List<? extends Function0<Unit>> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        ((Function0) ZeusTransformUtils.preCheckCast(r6.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Exception -> L8
        e = null;
    L9:
        if (e == null) goto L4;
        r0.add(e);
    L8:
        e = e;
        goto L9
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private static final long b(long r4) {
        ZoneId r0 = ZoneId.systemDefault();
        return RangesKt.coerceAtLeast(Instant.ofEpochMilli(r4).atZone(r0).toLocalDate().plusDays(1).atStartOfDay(r0).toInstant().toEpochMilli() - r4, 1);
    }

    private static final Unit b(List r4) {
        List<Exception> r5 = a((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
        Exception r0 = (Exception) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r5), Exception.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), 1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r0.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r6.next(), Throwable.class, "com.obric.memorydata.plugin"));
        goto L6
    L8:
        throw r0;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$zKmZlZ0AboEgdJnM-weKnZEbxmU, reason: not valid java name */
    public static /* synthetic */ Unit m221lambda$zKmZlZ0AboEgdJnMweKnZEbxmU(List r0) {
        return b(r0);
    }
}
