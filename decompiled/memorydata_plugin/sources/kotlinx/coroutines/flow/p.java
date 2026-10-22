package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000f"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class p {
    public static final <T> i<T> a(i<? extends T> r3) {
        return k.a((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin"), -1, null, 2, null);
    }

    public static final <T> i<T> a(i<? extends T> r10, int r11, BufferOverflow r12) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.memorydata.plugin");
        boolean r13 = true;
        if (r11 < 0) goto L5;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L28;
        if (r11 == (-1)) goto L13;
    L16:
        if (r13 == false) goto L26;
        if (r11 != (-1)) goto L19;
        BufferOverflow r7 = BufferOverflow.DROP_OLDEST;
        int r6 = 0;
    L21:
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.flow.internal.p.class) == false) goto L24;
        return kotlinx.coroutines.flow.internal.p.a.a((kotlinx.coroutines.flow.internal.p) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.internal.p.class, "com.obric.memorydata.plugin"), null, r6, r7, 1, null);
    L24:
        return (i) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.flow.internal.h(r3, null, r6, r7, 2, null), i.class, "com.obric.memorydata.plugin");
    L19:
        r6 = r11;
        r7 = r12;
        goto L21
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L13:
        if (r12 == BufferOverflow.SUSPEND) goto L16;
        r13 = false;
        goto L16
    L28:
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r11).toString());
    L5:
        if (r11 == (-2)) goto L9;
        if (r11 == (-1)) goto L9;
        r4 = false;
        goto L10
    }

    public static /* synthetic */ i a(i r1, int r2, BufferOverflow r3, int r4, Object r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r1, i.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = -2;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = BufferOverflow.SUSPEND;
    L9:
        return k.a(r6, r2, r3);
    }

    public static final <T> i<T> a(i<? extends T> r10, CoroutineContext r11) {
        i<T> r3 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.memorydata.plugin");
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r11, CoroutineContext.class, "com.obric.memorydata.plugin");
        a(r5);
        if (Intrinsics.areEqual(r5, EmptyCoroutineContext.INSTANCE) == false) goto L6;
        return r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.flow.internal.p.class) == false) goto L9;
        return kotlinx.coroutines.flow.internal.p.a.a((kotlinx.coroutines.flow.internal.p) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.internal.p.class, "com.obric.memorydata.plugin"), r5, 0, null, 6, null);
    L9:
        return (i) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.flow.internal.h(r3, r5, 0, null, 12, null), i.class, "com.obric.memorydata.plugin");
    }

    private static final void a(CoroutineContext r3) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (r4.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }
}
