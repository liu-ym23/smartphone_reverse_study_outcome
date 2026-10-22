package com.obric.memorydata.personalcontext.realcontext;

import com.obric.capability.schedulekit.JobResultWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/personalcontext/realcontext/SimCardIntentDispatchBridge;", "", "timeoutMillis", "", "dispatch", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "<init>", "(JLkotlin/jvm/functions/Function1;Ljava/util/concurrent/ThreadPoolExecutor;)V", "Lkotlin/jvm/functions/Function1;", "awaitResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Continuation<? super JobResultWrapper>, Object> f12267b;
    private final ThreadPoolExecutor c;

    public e(long r3, Function1<? super Continuation<? super JobResultWrapper>, ? extends Object> r5, ThreadPoolExecutor r6) {
        Function1<Continuation<? super JobResultWrapper>, Object> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "dispatch");
        Intrinsics.checkNotNullParameter(r6, "executor");
        this.f12266a = r3;
        this.f12267b = r7;
        this.c = r6;
    }

    public static final /* synthetic */ Function1 a(e r0) {
        return r0.f12267b;
    }

    private static final JobResultWrapper b(e r3) {
        return (JobResultWrapper) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new SimCardIntentDispatchBridge$awaitResult$future$1$1(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), JobResultWrapper.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ JobResultWrapper lambda$Aau01llRn8AaOF9YukVl8PutdI8(e r0) {
        return b(r0);
    }

    public final JobResultWrapper a() {
        JobResultWrapper r0 = null;
        Future r1 = this.c.submit(new $$Lambda$e$Aau01llRn8AaOF9YukVl8PutdI8(this));     // Catch: Throwable -> L10
        r0 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r1.get(this.f12266a, TimeUnit.MILLISECONDS), JobResultWrapper.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L7 TimeoutException -> L8 Throwable -> L10
    L11:
        goto L9
    L7:
        r1.cancel(true);     // Catch: Throwable -> L10
        Thread.currentThread().interrupt();     // Catch: Throwable -> L10
    L8:
        r1.cancel(true);     // Catch: Throwable -> L10
    L9:
        return r0;
    }
}
