package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {CommonConsts.COUNT_TYPE, "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class q {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class a<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f17487a;

        a(Ref.IntRef r1) {
            this.f17487a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r2, Continuation<? super Unit> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f17487a.element++;
            int r1 = this.f17487a.element;
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class b<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f17488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f17489b;

        b(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3, Ref.IntRef r4) {
            this.f17488a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            this.f17489b = r4;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__CountKt$count$4$emit$1.class) == false) goto L7;
            FlowKt__CountKt$count$4$emit$1 r0 = (FlowKt__CountKt$count$4$emit$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__CountKt$count$4$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            b<T> this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L21;
            this.f17489b.element++;
            int r5 = this.f17489b.element;
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            Function2<T, Continuation<? super Boolean>, Object> r10 = this.f17488a;
            r0.L$0 = this;
            r0.label = 1;
            r9 = r10.invoke(r6, r0);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new FlowKt__CountKt$count$4$emit$1(this, r8);
            goto L8
        }
    }

    public static final <T> Object a(i<? extends T> r6, Continuation<? super Integer> r7) {
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__CountKt$count$1.class) == false) goto L7;
        FlowKt__CountKt$count$1 r0 = (FlowKt__CountKt$count$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__CountKt$count$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.IntRef r11 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L19:
        return Boxing.boxInt(r11.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.IntRef r12 = new Ref.IntRef();
        j<? super T> r1 = (j) ZeusTransformUtils.preCheckCast(new a(r12), j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r12;
        r0.label = 1;
        if (r8.collect(r1, r0) != r2) goto L17;
        return r2;
    L17:
        r11 = r12;
    L7:
        r0 = new FlowKt__CountKt$count$1(r9);
        goto L8
    }

    public static final <T> Object a(i<? extends T> r5, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r6, Continuation<? super Integer> r7) {
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FlowKt__CountKt$count$3.class) == false) goto L7;
        FlowKt__CountKt$count$3 r0 = (FlowKt__CountKt$count$3) ZeusTransformUtils.preCheckCast(r10, FlowKt__CountKt$count$3.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.IntRef r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L19:
        return Boxing.boxInt(r12.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Ref.IntRef r13 = new Ref.IntRef();
        j<? super T> r14 = (j) ZeusTransformUtils.preCheckCast(new b(r9, r13), j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r13;
        r0.label = 1;
        if (r8.collect(r14, r0) != r2) goto L17;
        return r2;
    L17:
        r12 = r13;
    L7:
        r0 = new FlowKt__CountKt$count$3(r10);
        goto L8
    }
}
