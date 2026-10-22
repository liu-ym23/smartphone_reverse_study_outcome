package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BB\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0010R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class av<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f17431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<j<? super T>, Continuation<? super Unit>, Object> f17432b;

    public av(j<? super T> r3, Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Function2<j<? super T>, Continuation<? super Unit>, Object> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        this.f17431a = r5;
        this.f17432b = r6;
    }

    public final Object a(Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, SubscribedFlowCollector$onSubscription$1.class) == false) goto L7;
        SubscribedFlowCollector$onSubscription$1 r1 = (SubscribedFlowCollector$onSubscription$1) ZeusTransformUtils.preCheckCast(r11, SubscribedFlowCollector$onSubscription$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SafeCollector r9 = (SafeCollector) ZeusTransformUtils.preCheckCast(r1.L$1, SafeCollector.class, "com.obric.memorydata.plugin");
        av<T> r5 = (av) ZeusTransformUtils.preCheckCast(r1.L$0, av.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L18
    L25:
        r9.releaseIntercepted();
        if (ZeusTransformUtils.instanceOf(r5.f17431a, av.class) == false) goto L33;
        av r13 = (av) ZeusTransformUtils.preCheckCast(r5.f17431a, av.class, "com.obric.memorydata.plugin");
        r1.L$0 = null;
        r1.L$1 = null;
        r1.label = 2;
        if (r13.a(r1) != r3) goto L31;
        return r3;
    L33:
        return Unit.INSTANCE;
    L18:
        Throwable th = th;
    L36:
        r9.releaseIntercepted();
        throw th;
    L20:
        ResultKt.throwOnFailure(r12);
        SafeCollector r14 = new SafeCollector(this.f17431a, r1.getContext());
        Function2<j<? super T>, Continuation<? super Unit>, Object> r6 = this.f17432b;     // Catch: Throwable -> L34
        r1.L$0 = this;     // Catch: Throwable -> L34
        r1.L$1 = r14;     // Catch: Throwable -> L34
        r1.label = 1;     // Catch: Throwable -> L34
        if (r6.invoke(r14, r1) != r3) goto L24;
        return r3;
    L24:
        r5 = this;
        r9 = r14;
    L34:
        th = move-exception;
        th = th;
        r9 = r14;
    L7:
        r1 = new SubscribedFlowCollector$onSubscription$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.j
    public Object emit(T r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return this.f17431a.emit(r3, r5);
    }
}
