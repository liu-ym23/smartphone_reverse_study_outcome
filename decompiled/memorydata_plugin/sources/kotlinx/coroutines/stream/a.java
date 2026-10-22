package kotlinx.coroutines.stream;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096@¢\u0006\u0002\u0010\fR\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Ljava/util/stream/Stream;", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class a<T> implements i<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17646b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Stream<T> f17647a;
    private volatile /* synthetic */ int consumed$volatile;

    static {
        f17646b = AtomicIntegerFieldUpdater.newUpdater(a.class, "consumed$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater a() {
        return f17646b;
    }

    @Override // kotlinx.coroutines.flow.i
    public Object collect(j<? super T> r8, Continuation<? super Unit> r9) {
        j r10 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, StreamFlow$collect$1.class) == false) goto L7;
        StreamFlow$collect$1 r0 = (StreamFlow$collect$1) ZeusTransformUtils.preCheckCast(r11, StreamFlow$collect$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Iterator<T> r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$2, Iterator.class, "com.obric.memorydata.plugin");
        j r13 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
        a<T> r1 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        j r14 = r13;
        a<T> r15 = r1;
    L39:
    L29:
        Throwable th = th;
    L33:
        r15.f17647a.close();
        throw th;
    L23:
        if (r7.hasNext() == false) goto L27;
        T r4 = r7.next();     // Catch: Throwable -> L29
        r0.L$0 = r15;     // Catch: Throwable -> L29
        r0.L$1 = r14;     // Catch: Throwable -> L29
        r0.L$2 = r7;     // Catch: Throwable -> L29
        r0.label = 1;     // Catch: Throwable -> L29
        if (r14.emit(r4, r0) != r2) goto L39;
        return r2;
    L27:
        r15.f17647a.close();
        return Unit.INSTANCE;
    L14:
        th = th;
        r15 = r1;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        if (a().compareAndSet(this, 0, 1) == false) goto L36;
        r15 = this;
        r7 = this.f17647a.iterator();     // Catch: Throwable -> L31
        r14 = r10;
    L31:
        th = move-exception;
        r15 = this;
        th = th;
        goto L33
    L36:
        throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
    L7:
        r0 = new StreamFlow$collect$1(this, r11);
        goto L8
    }
}
