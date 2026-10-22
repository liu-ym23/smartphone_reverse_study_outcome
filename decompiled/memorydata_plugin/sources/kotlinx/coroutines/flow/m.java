package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\n\u001a6\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class m {
    public static final <T> Object a(j<? super T> r2, kotlinx.coroutines.channels.y<? extends T> r3, Continuation<? super Unit> r4) {
        Object r5 = b((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), true, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object a(j r2, kotlinx.coroutines.channels.y r3, boolean r4, Continuation r5) {
        return b((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> kotlinx.coroutines.channels.y<T> a(i<? extends T> r2, kotlinx.coroutines.al r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.al r5 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.flow.internal.e.a(r4).a(r5);
    }

    public static final <T> i<T> a(kotlinx.coroutines.channels.y<? extends T> r10) {
        return (i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), false, null, 0, null, 28, null), i.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00de -> B:14:0x006f). Please report as a decompilation issue!!! */
    private static final <T> Object b(j<? super T> r9, kotlinx.coroutines.channels.y<? extends T> r10, boolean r11, Continuation<? super Unit> r12) {
        j r13 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r14 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, FlowKt__ChannelsKt$emitAllImpl$1.class) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r0 = (FlowKt__ChannelsKt$emitAllImpl$1) ZeusTransformUtils.preCheckCast(r15, FlowKt__ChannelsKt$emitAllImpl$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r11 = r0.Z$0;
        kotlinx.coroutines.channels.k r17 = (kotlinx.coroutines.channels.k) ZeusTransformUtils.preCheckCast(r0.L$2, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r14 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        j r4 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
        ?? r5 = r4;
    L14:
        kotlinx.coroutines.channels.k r18 = r17;
        ?? r19 = r5;
    L22:
        r0.L$0 = r19;     // Catch: Throwable -> L35
        r0.L$1 = r14;     // Catch: Throwable -> L35
        r0.L$2 = r18;     // Catch: Throwable -> L35
        r0.Z$0 = r11;     // Catch: Throwable -> L35
        r0.label = 1;     // Catch: Throwable -> L35
        Object r6 = r18.a(r0);     // Catch: Throwable -> L35
        if (r6 != r2) goto L25;
        return r2;
    L25:
        ?? r7 = r19;
        r17 = r18;
        r16 = r6;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
        Object r110 = r17.a();     // Catch: Throwable -> L35
        r0.L$0 = r7;     // Catch: Throwable -> L35
        r0.L$1 = r14;     // Catch: Throwable -> L35
        r0.L$2 = r17;     // Catch: Throwable -> L35
        r0.Z$0 = r11;     // Catch: Throwable -> L35
        r0.label = 2;     // Catch: Throwable -> L35
        Object r111 = r7.emit(r110, r0);     // Catch: Throwable -> L35
        r5 = r7;
        if (r111 != r2) goto L14;
        return r2;
    L31:
        if (r11 == false) goto L34;
        kotlinx.coroutines.channels.o.a(r14, null);
    L34:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r11 = r0.Z$0;
        r17 = (kotlinx.coroutines.channels.k) ZeusTransformUtils.preCheckCast(r0.L$2, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r14 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
        r7 = r8;
        goto L27
    L20:
        ResultKt.throwOnFailure(r16);
        k.a(r13);
        r18 = r14.l();     // Catch: Throwable -> L35
        r19 = r13;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r11 == false) goto L40;
        kotlinx.coroutines.channels.o.a(r14, th);
    L40:
        throw th;
    L7:
        r0 = new FlowKt__ChannelsKt$emitAllImpl$1(r15);
        goto L8
    }

    public static final <T> i<T> b(kotlinx.coroutines.channels.y<? extends T> r10) {
        return (i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.channels.y) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"), true, null, 0, null, 28, null), i.class, "com.obric.memorydata.plugin");
    }
}
