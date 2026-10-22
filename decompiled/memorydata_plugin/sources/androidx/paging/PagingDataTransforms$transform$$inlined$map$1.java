package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagingDataTransforms$transform$$inlined$map$1<R> implements i<PageEvent<R>> {
    final /* synthetic */ i $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2<T> implements j {
        final /* synthetic */ j $this_unsafeFlow;
        final /* synthetic */ Function2 $transform$inlined$1;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.PagingDataTransforms$transform$$inlined$map$1$2", f = "PagingDataTransforms.kt", i = {}, l = {224, 223}, m = "emit", n = {}, s = {})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r3, Continuation r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                this.result = r3;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
            }
        }

        public AnonymousClass2(j r3, Function2 r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.$this_unsafeFlow = r5;
            this.$transform$inlined$1 = r6;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(Object r8, Continuation r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.memorydata.plugin");
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
        L24:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            j r7 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            j r12 = r7;
        L20:
            r0.L$0 = null;
            r0.label = 2;
            if (r12.emit(r11, r0) != r2) goto L24;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            j r13 = this.$this_unsafeFlow;
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            PageEvent r14 = (PageEvent) ZeusTransformUtils.preCheckCast(r8, PageEvent.class, "com.obric.memorydata.plugin");
            Function2 r15 = this.$transform$inlined$1;
            r0.L$0 = r13;
            r0.label = 1;
            Object r16 = r15.invoke(r14, r0);
            if (r16 != r2) goto L19;
            return r2;
        L19:
            r11 = r16;
            r12 = r13;
        L7:
            r0 = new AnonymousClass1(this, r10);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object emit$$forInline(Object r4, Continuation r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            InlineMarker.mark(4);
            new AnonymousClass1(this, r6);
            InlineMarker.mark(5);
            j r0 = this.$this_unsafeFlow;
            PageEvent r7 = (PageEvent) ZeusTransformUtils.preCheckCast(r4, PageEvent.class, "com.obric.memorydata.plugin");
            Object r3 = this.$transform$inlined$1.invoke(r7, r6);
            InlineMarker.mark(0);
            r0.emit(r3, r6);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
    }

    public PagingDataTransforms$transform$$inlined$map$1(i r3, Function2 r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        this.$this_unsafeTransform$inlined = r5;
        this.$transform$inlined = r6;
    }

    @Override // kotlinx.coroutines.flow.i
    public Object collect(j r4, Continuation r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r3 = this.$this_unsafeTransform$inlined.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, this.$transform$inlined), j.class, "com.obric.memorydata.plugin"), r7);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public Object collect$$forInline(j r4, Continuation r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        final Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(4);
        new AnonymousClass1(this, r7);
        InlineMarker.mark(5);
        i r0 = this.$this_unsafeTransform$inlined;
        j r3 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, this.$transform$inlined), j.class, "com.obric.memorydata.plugin");
        InlineMarker.mark(0);
        r0.collect(r3, r7);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
