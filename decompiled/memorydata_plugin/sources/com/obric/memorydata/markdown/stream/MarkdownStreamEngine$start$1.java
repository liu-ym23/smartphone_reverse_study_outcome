package com.obric.memorydata.markdown.stream;

import android.os.SystemClock;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$start$1", f = "MarkdownStreamEngine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2}, l = {55, 58, 64}, m = "invokeSuspend", n = {"channel", "fullContent", "accumulated", "producerJob", "startTs", "channel", "producerJob", "startTs", "channel", "producerJob"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1"})
final class MarkdownStreamEngine$start$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MarkdownStreamEngine this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.MarkdownStreamEngine$start$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$start$1$1", f = "MarkdownStreamEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarkdownStreamEngine this$0;

        AnonymousClass1(MarkdownStreamEngine r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MarkdownStreamEngine.d(this.this$0).a();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.MarkdownStreamEngine$start$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$start$1$2", f = "MarkdownStreamEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MarkdownStreamEngine this$0;

        AnonymousClass2(MarkdownStreamEngine r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MarkdownStreamEngine.d(this.this$0).b();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    MarkdownStreamEngine$start$1(MarkdownStreamEngine r3, Continuation<? super MarkdownStreamEngine$start$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        MarkdownStreamEngine$start$1 r0 = new MarkdownStreamEngine$start$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MarkdownStreamEngine$start$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MarkdownStreamEngine$start$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.bx] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r25) {
        ?? r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        if (r2 == 0) goto L23;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        bx r3 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r4 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L10
    L43:
        bx.a.a(r3, null, 1, null);
        Object r0 = ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");
    L34:
        z.a.a((z) r0, null, 1, null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        long r9 = this.J$0;
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(this.L$1, bx.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r6 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L17 MarkdownStreamEngine.IdleTimeoutException -> L19 CancellationException -> L20
    L33:
        bx.a.a(r5, null, 1, null);
        r0 = ZeusTransformUtils.preCheckCast(r6, z.class, "com.obric.memorydata.plugin");
        goto L34
    L19:
        kotlinx.coroutines.channels.i r7 = r6;
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "idle timeout after " + (SystemClock.elapsedRealtime() - r9) + "ms", null, 4, null);     // Catch: Throwable -> L35
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(MarkdownStreamEngine.c(this.this$0), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        this.L$0 = r7;     // Catch: Throwable -> L35
        this.L$1 = r5;     // Catch: Throwable -> L35
        this.L$2 = null;     // Catch: Throwable -> L35
        this.L$3 = null;     // Catch: Throwable -> L35
        this.label = 3;     // Catch: Throwable -> L35
        if (kotlinx.coroutines.i.a(r8, r10, r11) != r1) goto L42;
        return r1;
    L42:
        r3 = r5;
        r4 = r7;
    L35:
        th = th;
        r1 = r5;
        r2 = r7;
    L50:
        bx.a.a(r1, null, 1, null);
        z.a.a((z) ZeusTransformUtils.preCheckCast(r2, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        throw th;
    L20:
        e = e;
    L48:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "cancelled", false, 4, null);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L17:
        th = th;
        r1 = r5;
        r2 = r6;
        goto L50
    L22:
        long r12 = this.J$0;
        r5 = (bx) ZeusTransformUtils.preCheckCast(this.L$3, bx.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.L$2, StringBuilder.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.L$1, StringBuilder.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r15 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r25);
        r7 = r15;
        long r16 = r12;
        StringBuilder r17 = r13;
        StringBuilder r18 = r14;
    L56:
        MarkdownStreamEngine r19 = this.this$0;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        Continuation r110 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.L$0 = r7;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.L$1 = r5;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.L$2 = null;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.L$3 = null;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.J$0 = r16;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        this.label = 2;     // Catch: Throwable -> L35 MarkdownStreamEngine.IdleTimeoutException -> L37 CancellationException -> L46
        if (MarkdownStreamEngine.a(r19, r7, r18, r17, r16, r110) != r1) goto L32;
        return r1;
    L32:
        r6 = r7;
        goto L33
    L46:
        e = e;
    L38:
        r9 = r16;
        goto L39
    L23:
        ResultKt.throwOnFailure(r25);
        al r20 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r21 = SystemClock.elapsedRealtime();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "start mode=" + MarkdownStreamEngine.a(this.this$0) + ", timeout=" + MarkdownStreamEngine.b(this.this$0) + "ms", false, 4, null);
        kotlinx.coroutines.channels.i r111 = kotlinx.coroutines.channels.l.a(1024, null, null, 6, null);
        StringBuilder r112 = new StringBuilder(4096);
        StringBuilder r113 = new StringBuilder(4096);
        r5 = MarkdownStreamEngine.a(this.this$0, r20, r111, r112);
        CoroutineContext r114 = (CoroutineContext) ZeusTransformUtils.preCheckCast(MarkdownStreamEngine.c(this.this$0), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r22 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r115 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r111;
        this.L$1 = r112;
        this.L$2 = r113;
        this.L$3 = r5;
        this.J$0 = r21;
        this.label = 1;
        if (kotlinx.coroutines.i.a(r114, r22, r115) != r1) goto L26;
        return r1;
    L26:
        r7 = r111;
        r18 = r112;
        r17 = r113;
        r16 = r21;
    L10:
        th = th;
        goto L50
    }
}
