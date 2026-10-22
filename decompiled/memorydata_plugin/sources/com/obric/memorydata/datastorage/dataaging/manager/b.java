package com.obric.memorydata.datastorage.dataaging.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\u0006"}, d2 = {"executeAgingRun", "", "tableAgingActions", "", "Lkotlin/Function0;", "cleanupConsumedRetractions", "app_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final void a(List<? extends Function0<Unit>> r3, Function0<Unit> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "tableAgingActions");
        Intrinsics.checkNotNullParameter(r6, "cleanupConsumedRetractions");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((Function0) ZeusTransformUtils.preCheckCast(r7.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L4
    L6:
        r6.invoke();
    }
}
