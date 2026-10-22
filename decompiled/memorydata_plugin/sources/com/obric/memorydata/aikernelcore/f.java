package com.obric.memorydata.aikernelcore;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0000¨\u0006\u000b"}, d2 = {"notifyPackageUpdateListenersSafely", "", "listeners", "", "Lcom/obric/memorydata/aikernelcore/PackageUpdateListener;", "packageNames", "", "", "onFailure", "Lkotlin/Function1;", "", "aikernel_core_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    public static final void a(Iterable<? extends e> r3, Set<String> r4, Function1<? super Throwable, Unit> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listeners");
        Intrinsics.checkNotNullParameter(r7, "packageNames");
        Intrinsics.checkNotNullParameter(r8, "onFailure");
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9.next(), e.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r0.onPackagesUpdated(r7);     // Catch: Throwable -> L8
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r1);
        if (r10 == null) goto L4;
        r8.invoke(r10);
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
