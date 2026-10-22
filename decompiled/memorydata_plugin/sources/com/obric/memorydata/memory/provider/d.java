package com.obric.memorydata.memory.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/provider/MemoryReviewEntryQueryPolicy;", "", "<init>", "()V", "resolve", "", "isDebugBuild", "debugCollectionEnabled", "Lkotlin/Function0;", "isRecorderProcessCaller", "reviewEntryEnabled", "onDebugCollectionReadFailed", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10362a = null;

    static {
        f10362a = new d();
    }

    private d() {
    }

    public final boolean a(boolean r3, Function0<Boolean> r4, Function0<Boolean> r5, Function0<Boolean> r6, Function0<Unit> r7) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "debugCollectionEnabled");
        Intrinsics.checkNotNullParameter(r8, "isRecorderProcessCaller");
        Intrinsics.checkNotNullParameter(r9, "reviewEntryEnabled");
        Intrinsics.checkNotNullParameter(r10, "onDebugCollectionReadFailed");
        if (r3 == true) goto L29;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L23;
        return true;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
        return false;
    L26:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L29:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        Object r13 = Result.m1421constructorimpl(r2.invoke());     // Catch: Throwable -> L6
    L9:
        if (Result.m1424exceptionOrNullimpl(r13) == null) goto L17;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L13
        Result.m1421constructorimpl(r10.invoke());     // Catch: Throwable -> L13
    L15:
        r13 = false;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L19;
        r11 = true;
    L6:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
