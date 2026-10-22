package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/flow/h;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    final /* synthetic */ g[] $flows;
    final /* synthetic */ Function3<h, Object[], Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", ST.IMPLICIT_ARG_NAME, "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;Lkotlin/Array;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<h, Object[], Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<h, Object[], Continuation<? super Unit>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super h, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super AnonymousClass1> r10) {
            this.$transform = r5;
            super(3, r10);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(h r5, Object[] r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            h r12 = (h) this.L$0;
            Object[] r13 = (Object[]) this.L$1;
            Function3<h, Object[], Continuation<? super Unit>, Object> r14 = this.$transform;
            this.L$0 = null;
            this.label = 1;
            if (r14.invoke(r12, r13, this) != r5) goto L12;
            return r5;
        }

        public final Object invokeSuspend$$forInline(Object r5) {
            h r10 = (h) this.L$0;
            Object[] r11 = (Object[]) this.L$1;
            this.$transform.invoke(r10, r11, this);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(h r5, Object[] r10, Continuation<? super Unit> r11) {
            Intrinsics.needClassReification();
            AnonymousClass1 r12 = new AnonymousClass1(this.$transform, r11);
            r12.L$0 = r5;
            r12.L$1 = r10;
            return r12.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(g[] r5, Function3<? super h, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super FlowKt__ZipKt$combineTransformUnsafe$1> r11) {
        this.$flows = r5;
        this.$transform = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__ZipKt$combineTransformUnsafe$1 r11 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(h r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        h r12 = (h) this.L$0;
        g[] r13 = this.$flows;
        b2 r14 = b2.f18830a;
        Intrinsics.needClassReification();
        AnonymousClass1 r15 = new AnonymousClass1(this.$transform, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.internal.b.a(r13, r14, r15, r12, this) != r5) goto L12;
        return r5;
    }

    public final Object invokeSuspend$$forInline(Object r10) {
        h r11 = (h) this.L$0;
        g[] r5 = this.$flows;
        b2 r12 = b2.f18830a;
        Intrinsics.needClassReification();
        AnonymousClass1 r13 = new AnonymousClass1(this.$transform, null);
        InlineMarker.mark(0);
        kotlinx.coroutines.flow.internal.b.a(r5, r12, r13, r11, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(h r5, Continuation<? super Unit> r10) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
