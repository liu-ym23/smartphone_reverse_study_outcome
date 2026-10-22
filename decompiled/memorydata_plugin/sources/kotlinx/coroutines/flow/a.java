package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class a<T> implements c<T> {
    public a() {
    }

    public abstract Object a(j<? super T> r1, Continuation<? super Unit> r2);

    @Override // kotlinx.coroutines.flow.i
    public final Object collect(j<? super T> r6, Continuation<? super Unit> r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AbstractFlow$collect$1.class) == false) goto L7;
        AbstractFlow$collect$1 r0 = (AbstractFlow$collect$1) ZeusTransformUtils.preCheckCast(r9, AbstractFlow$collect$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        SafeCollector r5 = (SafeCollector) ZeusTransformUtils.preCheckCast(r0.L$0, SafeCollector.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L23:
        r5.releaseIntercepted();
        return Unit.INSTANCE;
    L14:
        th = th;
    L27:
        r5.releaseIntercepted();
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        SafeCollector r11 = new SafeCollector(r8, r0.getContext());
        j<? super T> r12 = (j) ZeusTransformUtils.preCheckCast(r11, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        r0.L$0 = r11;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        if (a(r12, r0) != r2) goto L22;
        return r2;
    L22:
        r5 = r11;
    L25:
        th = th;
        r5 = r11;
    L7:
        r0 = new AbstractFlow$collect$1(this, r9);
        goto L8
    }
}
