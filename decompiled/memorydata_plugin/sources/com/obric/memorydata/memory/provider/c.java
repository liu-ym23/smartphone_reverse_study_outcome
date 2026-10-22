package com.obric.memorydata.memory.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jr\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/provider/MemoryReviewEntryQueryExecutor;", "", "<init>", "()V", "execute", "", "isPermissionRefused", "Lkotlin/Function0;", "isDebugBuild", "debugCollectionEnabled", "isRecorderProcessCaller", "reviewEntryEnabled", "onDebugCollectionReadFailed", "", "onQueryFailed", "Lkotlin/Function1;", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10361a = null;

    static {
        f10361a = new c();
    }

    private c() {
    }

    public final boolean a(Function0<Boolean> r9, Function0<Boolean> r10, Function0<Boolean> r11, Function0<Boolean> r12, Function0<Boolean> r13, Function0<Unit> r14, Function1<? super Throwable, Unit> r15) {
        Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function0 r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Function1 r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "isPermissionRefused");
        Intrinsics.checkNotNullParameter(r17, "isDebugBuild");
        Intrinsics.checkNotNullParameter(r4, "debugCollectionEnabled");
        Intrinsics.checkNotNullParameter(r5, "isRecorderProcessCaller");
        Intrinsics.checkNotNullParameter(r6, "reviewEntryEnabled");
        Intrinsics.checkNotNullParameter(r7, "onDebugCollectionReadFailed");
        Intrinsics.checkNotNullParameter(r18, "onQueryFailed");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L6
        c r8 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Object r20 = Result.m1421constructorimpl(Boolean.valueOf(d.f10362a.a(((Boolean) ZeusTransformUtils.preCheckCast(r17.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r4, r5, r6, r7)));     // Catch: Throwable -> L6
    L8:
        Throwable r21 = Result.m1424exceptionOrNullimpl(r20);
        if (r21 == null) goto L17;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L13
        r18.invoke(r21);     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        r20 = false;
    L13:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r20, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    L19:
        throw new SecurityException("Permission denied: query memory review entry enabled");
    }
}
