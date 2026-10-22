package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.an;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ kotlinx.coroutines.selects.m<?> $select;
    int label;
    final /* synthetic */ d<E> this$0;

    BroadcastChannelImpl$registerSelectForSend$2(d<E> r3, Object r4, kotlinx.coroutines.selects.m<?> r5, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> r6) {
        kotlinx.coroutines.selects.m<?> r7 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$element = r4;
        this.$select = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BroadcastChannelImpl$registerSelectForSend$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
    L15:
        boolean r8 = true;
    L23:
        ReentrantLock r3 = d.a(this.this$0);
        d<E> r4 = this.this$0;
        kotlinx.coroutines.selects.m<?> r6 = this.$select;
        Lock r5 = (Lock) ZeusTransformUtils.preCheckCast(r3, Lock.class, "com.obric.memorydata.plugin");
        r5.lock();
    L43:
        th = move-exception;
        r5.unlock();
        throw th;
    L25:
        if (an.a() == true) goto L27;
    L33:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(d.b(r4), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r8 == false) goto L36;
        Object r10 = Unit.INSTANCE;     // Catch: Throwable -> L43
    L37:
        r9.put(r6, r10);     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");     // Catch: Throwable -> L43
        kotlinx.coroutines.selects.l r11 = (kotlinx.coroutines.selects.l) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.selects.l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (((kotlinx.coroutines.selects.l) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.selects.l.class, "com.obric.memorydata.plugin")).b(r4, Unit.INSTANCE) == TrySelectDetailedResult.REREGISTER) goto L40;
        d.b(r4).remove(r6);     // Catch: Throwable -> L43
    L40:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L43
        r5.unlock();
        return Unit.INSTANCE;
    L36:
        r10 = h.b();     // Catch: Throwable -> L43
        goto L37
    L27:
        if (d.b(r4).get(r6) != null) goto L29;
        r2 = true;
    L29:
        if (r2 == true) goto L33;
        throw new AssertionError();     // Catch: Throwable -> L43
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        d<E> r13 = this.this$0;     // Catch: Throwable -> L7
        Object r14 = this.$element;     // Catch: Throwable -> L7
        Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r13.send((E) r14, r15) != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        if (this.this$0.isClosedForSend() == true) goto L19;
    L46:
        throw th;
    L19:
        if (ZeusTransformUtils.instanceOf(th, ClosedSendChannelException.class) == false) goto L21;
    L22:
        r8 = false;
        goto L23
    L21:
        if (this.this$0.n() != th) goto L46;
        goto L22
    }
}
