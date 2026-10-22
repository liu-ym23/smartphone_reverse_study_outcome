package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001aH\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001aH\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0013\"\u0002H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0016\u001a!\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u0018\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001a\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001b\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001c\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u001d\u001a\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001e\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001f\u001a1\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0 ¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"callbackFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "flow", "Lkotlinx/coroutines/flow/FlowCollector;", "flowOf", EventBody.KEY_VALUE, "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "asFlow", "Lkotlin/Function0;", "", "", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class l {

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a implements kotlinx.coroutines.flow.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LongRange f17472a;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Long> r8, Continuation<? super Unit> r9) {
            kotlinx.coroutines.flow.j r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r11, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1) ZeusTransformUtils.preCheckCast(r11, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
            r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r12);
        L16:
            if (r7.hasNext() == false) goto L21;
            Long r13 = Boxing.boxLong(((LongIterator) ZeusTransformUtils.preCheckCast(r7, LongIterator.class, "com.obric.memorydata.plugin")).nextLong());
            r0.L$0 = r10;
            r0.L$1 = r7;
            r0.label = 1;
            if (r10.emit(r13, r0) != r2) goto L16;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r12);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f17472a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1(this, r11);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f17473a;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r7, Continuation<? super Unit> r8) {
            kotlinx.coroutines.flow.j r9 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r11);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            kotlinx.coroutines.flow.j r12 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            kotlinx.coroutines.flow.j r13 = r12;
        L19:
            r0.L$0 = null;
            r0.label = 2;
            if (r13.emit(r11, r0) != r2) goto L23;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Function1 r6 = this.f17473a;
            r0.L$0 = r9;
            r0.label = 1;
            InlineMarker.mark(6);
            r11 = r6.invoke(r0);
            InlineMarker.mark(7);
            r13 = r9;
            if (r11 != r2) goto L19;
            return r2;
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1(this, r10);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f17474a;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r6, Continuation<? super Unit> r7) {
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator<T> r5 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
            r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L16:
            if (r5.hasNext() == false) goto L21;
            T r11 = r5.next();
            r0.L$0 = r8;
            r0.L$1 = r5;
            r0.label = 1;
            if (r8.emit(r11, r0) != r2) goto L16;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r5 = this.f17474a.iterator();
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1(this, r9);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f17475a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r6, Continuation<? super Unit> r7) {
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.j r12 = r11;
        L16:
            if (r5.hasNext() == false) goto L21;
            Object r13 = r5.next();
            r0.L$0 = r12;
            r0.L$1 = r5;
            r0.label = 1;
            if (r12.emit(r13, r0) != r2) goto L16;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r5 = this.f17475a;
            r12 = r8;
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1(this, r9);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class e<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Sequence f17476a;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r6, Continuation<? super Unit> r7) {
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator<T> r5 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
            r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L16:
            if (r5.hasNext() == false) goto L21;
            T r11 = r5.next();
            r0.L$0 = r8;
            r0.L$1 = r5;
            r0.label = 1;
            if (r8.emit(r11, r0) != r2) goto L16;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r5 = this.f17476a.iterator();
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1(this, r9);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class f<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f17477a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008c -> B:19:0x008f). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r9, Continuation<? super Unit> r10) {
            kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1) ZeusTransformUtils.preCheckCast(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            int r8 = r0.I$1;
            int r14 = r0.I$0;
            Object[] r4 = (Object[]) ZeusTransformUtils.preCheckCast(r0.L$1, Object[].class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            ?? r15 = r1;
        L19:
            r14 = r14 + 1;
            ?? r16 = r15;
        L15:
            if (r14 >= r8) goto L21;
            Object r5 = r4[r14];
            r0.L$0 = r16;
            r0.L$1 = r4;
            r0.I$0 = r14;
            r0.I$1 = r8;
            r0.label = 1;
            Object r6 = r16.emit(r5, r0);
            r15 = r16;
            if (r6 != r2) goto L19;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Object[] r18 = this.f17477a;
            r4 = r18;
            r8 = r18.length;
            r16 = r11;
            r14 = 0;
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1(this, r12);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class g implements kotlinx.coroutines.flow.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f17478a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0090 -> B:19:0x0093). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Integer> r9, Continuation<? super Unit> r10) {
            kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1) ZeusTransformUtils.preCheckCast(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            int r8 = r0.I$1;
            int r14 = r0.I$0;
            int[] r4 = (int[]) ZeusTransformUtils.preCheckCast(r0.L$1, int[].class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            kotlinx.coroutines.flow.j r15 = r1;
        L19:
            r14 = r14 + 1;
        L15:
            if (r14 >= r8) goto L21;
            Integer r5 = Boxing.boxInt(r4[r14]);
            r0.L$0 = r15;
            r0.L$1 = r4;
            r0.I$0 = r14;
            r0.I$1 = r8;
            r0.label = 1;
            if (r15.emit(r5, r0) != r2) goto L19;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            int[] r17 = this.f17478a;
            r4 = r17;
            r8 = r17.length;
            r15 = r11;
            r14 = 0;
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1(this, r12);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class h implements kotlinx.coroutines.flow.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f17479a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0090 -> B:19:0x0093). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Long> r9, Continuation<? super Unit> r10) {
            kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1) ZeusTransformUtils.preCheckCast(r12, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            int r8 = r0.I$1;
            int r14 = r0.I$0;
            long[] r4 = (long[]) ZeusTransformUtils.preCheckCast(r0.L$1, long[].class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            kotlinx.coroutines.flow.j r15 = r1;
        L19:
            r14 = r14 + 1;
        L15:
            if (r14 >= r8) goto L21;
            Long r5 = Boxing.boxLong(r4[r14]);
            r0.L$0 = r15;
            r0.L$1 = r4;
            r0.I$0 = r14;
            r0.I$1 = r8;
            r0.label = 1;
            if (r15.emit(r5, r0) != r2) goto L19;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            long[] r17 = this.f17479a;
            r4 = r17;
            r8 = r17.length;
            r15 = r11;
            r14 = 0;
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1(this, r12);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class i implements kotlinx.coroutines.flow.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntRange f17480a;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Integer> r6, Continuation<? super Unit> r7) {
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1.class) == false) goto L7;
            FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 r0 = (FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
            r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L16:
            if (r5.hasNext() == false) goto L21;
            Integer r11 = Boxing.boxInt(((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
            r0.L$0 = r8;
            r0.L$1 = r5;
            r0.label = 1;
            if (r8.emit(r11, r0) != r2) goto L16;
            return r2;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f17480a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            r0 = new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1(this, r9);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class j<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f17481a;

        public j(Object[] r1) {
            this.f17481a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0092 -> B:20:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r9, Continuation<? super Unit> r10) {
            kotlinx.coroutines.flow.j r11 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r0 = (FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r12, FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            int r8 = r0.I$1;
            int r14 = r0.I$0;
            kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            j<T> r1 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r15 = r0;
            ?? r5 = r4;
        L20:
            FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r7 = r15;
            int r16 = r14 + 1;
            j<T> r17 = r1;
            FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r6 = r7;
            ?? r18 = r5;
        L15:
            if (r16 >= r8) goto L22;
            Object r19 = r17.f17481a[r16];
            r6.L$0 = r17;
            r6.L$1 = r18;
            r6.I$0 = r16;
            r6.I$1 = r8;
            r6.label = 1;
            if (r18.emit(r19, r6) != r2) goto L19;
            return r2;
        L19:
            FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r20 = r6;
            r1 = r17;
            r14 = r16;
            r15 = r20;
            r5 = r18;
            goto L20
        L22:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
            Continuation r110 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r16 = 0;
            r17 = this;
            r8 = this.f17481a.length;
            r6 = r0;
            r18 = r11;
        L7:
            r0 = new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1(this, r12);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class k<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f17482a;

        public k(Object r1) {
            this.f17482a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super T> r3, Continuation<? super Unit> r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = r5.emit(this.f17482a, r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a() {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.flow.h.f17442a, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(T r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new k(r2), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(Function2<? super kotlinx.coroutines.flow.j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new ah((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(T... r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new j(r2), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> kotlinx.coroutines.flow.i<T> b(Function2<? super kotlinx.coroutines.channels.w<? super T>, ? super Continuation<? super Unit>, ? extends Object> r9) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.flow.b((Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }
}
