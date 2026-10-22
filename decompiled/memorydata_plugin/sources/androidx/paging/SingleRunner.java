package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/paging/SingleRunner;", "", "cancelPreviousInEqualPriority", "", "(Z)V", "holder", "Landroidx/paging/SingleRunner$Holder;", "runInIsolation", "", "priority", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CancelIsolatedRunnerException", "Companion", "Holder", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SingleRunner {
    public static final Companion Companion = null;
    public static final int DEFAULT_PRIORITY = 0;
    private final Holder holder;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public CancelIsolatedRunnerException(SingleRunner r2) {
            Intrinsics.checkNotNullParameter(r2, "runner");
            this.runner = r2;
        }

        public final SingleRunner getRunner() {
            return this.runner;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/paging/SingleRunner$Companion;", "", "()V", "DEFAULT_PRIORITY", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/paging/SingleRunner$Holder;", "", "singleRunner", "Landroidx/paging/SingleRunner;", "cancelPreviousInEqualPriority", "", "(Landroidx/paging/SingleRunner;Z)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "previous", "Lkotlinx/coroutines/Job;", "previousPriority", "", "onFinish", "", "job", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEnqueue", "priority", "(ILkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Holder {
        private final boolean cancelPreviousInEqualPriority;
        private final a mutex;
        private bx previous;
        private int previousPriority;
        private final SingleRunner singleRunner;

        public Holder(SingleRunner r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "singleRunner");
            this.singleRunner = r2;
            this.cancelPreviousInEqualPriority = r3;
            this.mutex = c.a(false, 1, null);
        }

        public final Object onFinish(bx r7, Continuation<? super Unit> r8) {
            bx r9 = (bx) ZeusTransformUtils.wrapperContextForParams(r7, bx.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, SingleRunner$Holder$onFinish$1.class) == false) goto L7;
            SingleRunner$Holder$onFinish$1 r0 = (SingleRunner$Holder$onFinish$1) ZeusTransformUtils.preCheckCast(r10, SingleRunner$Holder$onFinish$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r0.L$2, a.class, "com.obric.memorydata.plugin");
            r9 = (bx) ZeusTransformUtils.preCheckCast(r0.L$1, bx.class, "com.obric.memorydata.plugin");
            Holder r1 = (Holder) ZeusTransformUtils.preCheckCast(r0.L$0, Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            a r12 = r6;
            Holder this = r1;
        L26:
        L23:
            th = move-exception;
            r12.b(null);
            throw th;
        L18:
            if (r9 != this.previous) goto L20;
            this.previous = null;     // Catch: Throwable -> L23
        L20:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
            r12.b(null);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r11);
            r12 = this.mutex;
            r0.L$0 = this;
            r0.L$1 = r9;
            r0.L$2 = r12;
            r0.label = 1;
            if (r12.a(null, r0) != r2) goto L26;
            return r2;
        L7:
            r0 = new SingleRunner$Holder$onFinish$1(this, r10);
            goto L8
        }

        public final Object tryEnqueue(int r10, bx r11, Continuation<? super Boolean> r12) {
            bx r13 = (bx) ZeusTransformUtils.wrapperContextForParams(r11, bx.class, "com.obric.memorydata.plugin");
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r14, SingleRunner$Holder$tryEnqueue$1.class) == false) goto L7;
            SingleRunner$Holder$tryEnqueue$1 r1 = (SingleRunner$Holder$tryEnqueue$1) ZeusTransformUtils.preCheckCast(r14, SingleRunner$Holder$tryEnqueue$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            Object r15 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            boolean r7 = true;
            if (r4 == 0) goto L20;
            if (r4 == 1) goto L19;
            if (r4 != 2) goto L18;
            int r9 = r1.I$0;
            a r16 = (a) ZeusTransformUtils.preCheckCast(r1.L$2, a.class, "com.obric.memorydata.plugin");
            r13 = (bx) ZeusTransformUtils.preCheckCast(r1.L$1, bx.class, "com.obric.memorydata.plugin");
            Holder r0 = (Holder) ZeusTransformUtils.preCheckCast(r1.L$0, Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        L41:
            a r17 = r16;
            r10 = r9;
            Holder this = r0;
        L42:
            this.previous = r13;     // Catch: Throwable -> L47
            this.previousPriority = r10;     // Catch: Throwable -> L47
        L43:
            r16 = r17;
            Boolean r18 = Boxing.boxBoolean(r7);     // Catch: Throwable -> L15
            r16.b(null);
            return r18;
        L47:
            th = th;
            r16 = r17;
        L49:
            r16.b(null);
            throw th;
        L15:
            th = th;
            goto L49
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            r10 = r1.I$0;
            a r19 = (a) ZeusTransformUtils.preCheckCast(r1.L$2, a.class, "com.obric.memorydata.plugin");
            r13 = (bx) ZeusTransformUtils.preCheckCast(r1.L$1, bx.class, "com.obric.memorydata.plugin");
            Holder r2 = (Holder) ZeusTransformUtils.preCheckCast(r1.L$0, Holder.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
            r17 = r19;
            this = r2;
        L51:
            bx r5 = this.previous;     // Catch: Throwable -> L47
            if (r5 != null) goto L26;
        L34:
            if (r5 == null) goto L36;
            r5.a((CancellationException) ZeusTransformUtils.preCheckCast(new CancelIsolatedRunnerException(this.singleRunner), CancellationException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L47
        L36:
            if (r5 == null) goto L42;
            r1.L$0 = this;     // Catch: Throwable -> L47
            r1.L$1 = r13;     // Catch: Throwable -> L47
            r1.L$2 = r17;     // Catch: Throwable -> L47
            r1.I$0 = r10;     // Catch: Throwable -> L47
            r1.label = 2;     // Catch: Throwable -> L47
            if (r5.a_(r1) != r3) goto L40;
            return r3;
        L40:
            r0 = this;
            r9 = r10;
            r16 = r17;
            goto L41
        L26:
            if (r5.a() == false) goto L34;
            int r6 = this.previousPriority;     // Catch: Throwable -> L47
            if (r6 < r10) goto L34;
            if (r6 == r10) goto L31;
        L33:
            r7 = false;
            goto L43
        L31:
            if (this.cancelPreviousInEqualPriority == false) goto L33;
        L20:
            ResultKt.throwOnFailure(r15);
            r17 = this.mutex;
            r1.L$0 = this;
            r1.L$1 = r13;
            r1.L$2 = r17;
            r1.I$0 = r10;
            r1.label = 1;
            if (r17.a(null, r1) != r3) goto L51;
            return r3;
        L7:
            r1 = new SingleRunner$Holder$tryEnqueue$1(this, r14);
            goto L8
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SingleRunner", f = "SingleRunner.kt", i = {0}, l = {49}, m = "runInIsolation", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleRunner this$0;

        AnonymousClass1(SingleRunner r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runInIsolation(0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", i = {0, 1}, l = {53, 59, 61, 61}, m = "invokeSuspend", n = {"myJob", "myJob"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ int $priority;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SingleRunner this$0;

        AnonymousClass2(SingleRunner r3, int r4, Function1<? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass2> r6) {
            Function1<Continuation<? super Unit>, Object> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$priority = r4;
            this.$block = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$priority, this.$block, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.paging.SingleRunner$runInIsolation$2, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.paging.SingleRunner$runInIsolation$2, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v19, types: [androidx.paging.SingleRunner$Holder] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.bx] */
        /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.bx] */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            ?? r2 = 4;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L9;
            Throwable r10 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            throw r10;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r11);
        L38:
            return Unit.INSTANCE;
        L12:
            bx r3 = (bx) ZeusTransformUtils.preCheckCast(this.L$0, bx.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
            r1 = r3;
        L29:
            ?? r12 = SingleRunner.access$getHolder$p(this.this$0);
            r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 3;
            AnonymousClass2 this = r12.onFinish(r1, r2);
            if (this != r0) goto L38;
            return r0;
        L17:
            bx r4 = (bx) ZeusTransformUtils.preCheckCast(this.L$0, bx.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            bx r5 = r4;
        L25:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L38;
            Function1<Continuation<? super Unit>, Object> r13 = this.$block;     // Catch: Throwable -> L15
            this.L$0 = r5;     // Catch: Throwable -> L15
            this.label = 2;     // Catch: Throwable -> L15
            r1 = r5;
            if (r13.invoke(this) != r0) goto L29;
            return r0;
        L18:
            ResultKt.throwOnFailure(r11);
            CoroutineContext.Element r14 = ((al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin")).getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
            if (r14 == null) goto L40;
            bx r15 = (bx) ZeusTransformUtils.preCheckCast(r14, bx.class, "com.obric.memorydata.plugin");
            Holder r6 = SingleRunner.access$getHolder$p(this.this$0);
            int r7 = this.$priority;
            Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r15;
            this.label = 1;
            Object r9 = r6.tryEnqueue(r7, r15, r8);
            if (r9 != r0) goto L23;
            return r0;
        L23:
            r5 = r15;
            r11 = r9;
            goto L25
        L40:
            throw new IllegalStateException("Internal error. coroutineScope should've created a job.".toString());
        L15:
            th = move-exception;
            ?? r16 = SingleRunner.access$getHolder$p(this.this$0);
            Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = th;
            this.label = r2;
            if (r16.onFinish(r1, r17) != r0) goto L36;
            return r0;
        L36:
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SingleRunner() {
        this(false, 1, null);
    }

    public SingleRunner(boolean r2) {
        this.holder = new Holder(this, r2);
    }

    public /* synthetic */ SingleRunner(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    public static final /* synthetic */ Holder access$getHolder$p(SingleRunner r0) {
        return r0.holder;
    }

    public static /* synthetic */ Object runInIsolation$default(SingleRunner r1, int r2, Function1 r3, Continuation r4, int r5, Object r6) {
        Function1<? super Continuation<? super Unit>, ? extends Object> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return r1.runInIsolation(r2, r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.paging.SingleRunner, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final Object runInIsolation(int r6, Function1<? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        SingleRunner r5 = (SingleRunner) ZeusTransformUtils.preCheckCast(r0.L$0, SingleRunner.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: CancelIsolatedRunnerException -> L20
        SingleRunner this = r5;
    L26:
    L24:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
        Function2 r12 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r6, r9, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: CancelIsolatedRunnerException -> L20
        r0.L$0 = this;     // Catch: CancelIsolatedRunnerException -> L20
        r0.label = 1;     // Catch: CancelIsolatedRunnerException -> L20
        Object r13 = am.a(r12, r0);     // Catch: CancelIsolatedRunnerException -> L20
        this = r13;
        if (r13 != r2) goto L26;
        return r2;
    L20:
        e = move-exception;
        if (e.getRunner() == this) goto L24;
        throw e;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }
}
