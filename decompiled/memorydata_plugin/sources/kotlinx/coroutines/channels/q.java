package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.bl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aP\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\b0\u000b¢\u0006\u0002\b\fH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\r\u001a2\u0010\u000e\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\u000bH\u0086H¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0012\"\b\b\u0000\u0010\t*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a$\u0010\u0014\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@¢\u0006\u0002\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\t0\u0017\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", ExifInterface.LONGITUDE_EAST, "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class q {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0097 -> B:25:0x009a). Please report as a decompilation issue!!! */
    public static final <E> Object a(y<? extends E> r10, Continuation<? super List<? extends E>> r11) {
        y r12 = (y) ZeusTransformUtils.wrapperContextForParams(r10, y.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__Channels_commonKt$toList$1.class) == false) goto L7;
        ChannelsKt__Channels_commonKt$toList$1 r0 = (ChannelsKt__Channels_commonKt$toList$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__Channels_commonKt$toList$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$3, k.class, "com.obric.memorydata.plugin");
        y r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$2, y.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r0.L$1, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        ?? r7 = r5;
        List r8 = r6;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        r7.add(r15.a());     // Catch: Throwable -> L14
        y r16 = r4;
        ?? r9 = r7;
        List r17 = r8;
    L42:
        r0.L$0 = r17;     // Catch: Throwable -> L32
        r0.L$1 = r9;     // Catch: Throwable -> L32
        r0.L$2 = r16;     // Catch: Throwable -> L32
        r0.L$3 = r15;     // Catch: Throwable -> L32
        r0.label = 1;     // Catch: Throwable -> L32
        Object r18 = r15.a(r0);     // Catch: Throwable -> L32
        if (r18 != r2) goto L24;
        return r2;
    L24:
        r4 = r16;
        r14 = r18;
        r7 = r9;
        r8 = r17;
    L32:
        Throwable th = th;
        r4 = r16;
    L40:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        o.a(r4, th);
        throw th;
    L29:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r4, null);
        return CollectionsKt.build(r8);
    L14:
        th = th;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        List r20 = CollectionsKt.createListBuilder();
        r17 = r20;
        r16 = r12;
        r15 = r12.l();     // Catch: Throwable -> L34
        r9 = r20;
    L34:
        th = move-exception;
        r4 = r12;
        th = th;
    L7:
        r0 = new ChannelsKt__Channels_commonKt$toList$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:25:0x0092). Please report as a decompilation issue!!! */
    public static final <E> Object a(y<? extends E> r8, Function1<? super E, Unit> r9, Continuation<? super Unit> r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r8, y.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__Channels_commonKt$consumeEach$1.class) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$1 r0 = (ChannelsKt__Channels_commonKt$consumeEach$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__Channels_commonKt$consumeEach$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$0, Function1.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L28;
        r4.invoke(r15.a());     // Catch: Throwable -> L14
        Function1 r17 = r4;
    L21:
        r0.L$0 = r17;     // Catch: Throwable -> L14
        r0.L$1 = r16;     // Catch: Throwable -> L14
        r0.L$2 = r15;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r5 = r15.a(r0);     // Catch: Throwable -> L14
        if (r5 != r2) goto L24;
        return r2;
    L24:
        r4 = r17;
        r14 = r5;
        goto L26
    L28:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        o.a(r16, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        InlineMarker.finallyStart(1);
        o.a(r16, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r16 = r11;
        r15 = r11.l();     // Catch: Throwable -> L31
        r17 = r12;
    L31:
        th = move-exception;
        r16 = r11;
        th = th;
    L7:
        r0 = new ChannelsKt__Channels_commonKt$consumeEach$1(r13);
        goto L8
    }

    public static final void a(y<?> r3, Throwable r4) {
        y r5 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        CancellationException r0 = null;
        if (r4 != null) goto L5;
    L9:
        r5.a(r0);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, CancellationException.class) == false) goto L7;
        r0 = (CancellationException) ZeusTransformUtils.preCheckCast(r4, CancellationException.class, "com.obric.memorydata.plugin");
    L7:
        if (r0 != null) goto L9;
        r0 = bl.a("Channel was consumed, consumer had failed", r4);
        goto L9
    }
}
