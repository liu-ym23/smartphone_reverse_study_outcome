package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.selects.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0007J\u001f\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J.\u0010\u001d\u001a\u00020\u00162#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00160\u001fH\u0097\u0001J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010#\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010&J'\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160(2\u0006\u0010#\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R$\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/paging/SimpleProducerScopeImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/SimpleProducerScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "scope", "channel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isClosedForSend", "", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "awaitClose", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", IslandSession.REOPEN_VALUE_CLOSE, "cause", "", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleProducerScopeImpl<T> implements SimpleProducerScope<T>, al, z<T> {
    private final /* synthetic */ al $$delegate_0;
    private final z<T> channel;

    /* JADX INFO: renamed from: androidx.paging.SimpleProducerScopeImpl$awaitClose$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SimpleProducerScopeImpl", f = "SimpleChannelFlow.kt", i = {0, 0}, l = {100}, m = "awaitClose", n = {"block", "job"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SimpleProducerScopeImpl<T> this$0;

        AnonymousClass1(SimpleProducerScopeImpl<T> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitClose(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public SimpleProducerScopeImpl(al r3, z<? super T> r4) {
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        z<T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "channel");
        this.channel = r6;
        this.$$delegate_0 = r5;
    }

    @Override // androidx.paging.SimpleProducerScope
    public Object awaitClose(Function0<Unit> r6, Continuation<? super Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r9, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(r0.L$1, bx.class, "com.obric.memorydata.plugin");
        r8 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$0, Function0.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L28
    L24:
        r8.invoke();
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        CoroutineContext.Element r11 = getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        if (r11 == null) goto L27;
        bx r12 = (bx) ZeusTransformUtils.preCheckCast(r11, bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        r0.L$0 = r8;     // Catch: Throwable -> L28
        r0.L$1 = r12;     // Catch: Throwable -> L28
        r0.label = 1;     // Catch: Throwable -> L28
        o r13 = new o(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L28
        r13.e();     // Catch: Throwable -> L28
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r13, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        r12.a((Function1) ZeusTransformUtils.preCheckCast(new SimpleProducerScopeImpl$awaitClose$2$1(r4), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        Object r14 = r13.h();     // Catch: Throwable -> L28
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L28
    L22:
        if (r14 != r2) goto L24;
        return r2;
    L27:
        throw new IllegalStateException("Internal error, context should have a job.".toString());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r8.invoke();
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    @Override // kotlinx.coroutines.channels.z
    public boolean close(Throwable r1) {
        return this.channel.close(r1);
    }

    @Override // androidx.paging.SimpleProducerScope
    public z<T> getChannel() {
        return this.channel;
    }

    @Override // kotlinx.coroutines.al
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // kotlinx.coroutines.channels.z
    public j<T, z<T>> getOnSend() {
        return this.channel.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.z
    public void invokeOnClose(Function1<? super Throwable, Unit> r3) {
        Function1<? super Throwable, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handler");
        this.channel.invokeOnClose(r4);
    }

    @Override // kotlinx.coroutines.channels.z
    public boolean isClosedForSend() {
        return this.channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.z
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T r1) {
        return this.channel.offer(r1);
    }

    @Override // kotlinx.coroutines.channels.z
    public Object send(T r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return this.channel.send(r3, r5);
    }

    @Override // kotlinx.coroutines.channels.z
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo54trySendJP2dKIU(T r1) {
        return this.channel.mo54trySendJP2dKIU(r1);
    }
}
