package com.obric.memorydata.utils;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"runInUIThread", "", "action", "Lkotlin/Function0;", "postInUIThread", "singleThreadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "singleThreadScope", "Lkotlinx/coroutines/CoroutineScope;", "getSingleThreadScope", "()Lkotlinx/coroutines/CoroutineScope;", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.ah f13245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.al f13246b = null;

    static {
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$j$M1_eoRdIq2wYtdmWIthArEoXdUg.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor(...)");
        kotlinx.coroutines.ah r1 = (kotlinx.coroutines.ah) ZeusTransformUtils.preCheckCast(bo.a(r0), kotlinx.coroutines.ah.class, "com.obric.memorydata.plugin");
        f13245a = r1;
        f13246b = kotlinx.coroutines.am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(r1, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "MemoryData-SingleCoroutineThread");
        r0.setDaemon(true);
        return r0;
    }

    public static final kotlinx.coroutines.al a() {
        return f13246b;
    }

    public static final void a(Function0<Unit> r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "action");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new $$Lambda$j$HBwN6QNm794AbyhV4jlWvZuStQ(r3));
    }

    public static final void b(Function0<Unit> r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "action");
        new Handler(Looper.getMainLooper()).post(new $$Lambda$j$eics_uEN6T9jjkFajl12k3a4(r3));
    }

    private static final void c(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final void d(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    /* JADX INFO: renamed from: lambda$-HBwN6QNm794AbyhV4jlWvZuStQ, reason: not valid java name */
    public static /* synthetic */ void m1249lambda$HBwN6QNm794AbyhV4jlWvZuStQ(Function0 r0) {
        c(r0);
    }

    public static /* synthetic */ Thread lambda$M1_eoRdIq2wYtdmWIthArEoXdUg(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$ei-cs_uEN6T9jjkFajl12k-3-a4, reason: not valid java name */
    public static /* synthetic */ void m1250lambda$eics_uEN6T9jjkFajl12k3a4(Function0 r0) {
        d(r0);
    }
}
