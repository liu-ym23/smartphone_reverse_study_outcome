package kotlinx.coroutines.flow;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {210, 214, 215, 221}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ c2 $shared;
    final /* synthetic */ l2 $started;
    final /* synthetic */ g $upstream;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r5) {
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(r10);
            r11.I$0 = ((Number) r5).intValue();
            return r11;
        }

        public final Object invoke(int r5, Continuation<? super Boolean> r10) {
            return ((AnonymousClass1) create(Integer.valueOf(r5), r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (this.I$0 <= 0) goto L7;
            boolean r10 = true;
        L9:
            return Boxing.boxBoolean(r10);
        L7:
            r10 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Integer r5, Continuation<? super Boolean> r10) {
            return invoke(r5.intValue(), r10);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Lkotlinx/coroutines/flow/SharingCommand;", "Lkotlin/ParameterName;", "name", "value"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $initialValue;
        final /* synthetic */ c2 $shared;
        final /* synthetic */ g $upstream;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(g r5, c2 r10, Object r11, Continuation<? super AnonymousClass2> r12) {
            this.$upstream = r5;
            this.$shared = r10;
            this.$initialValue = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SharingCommand r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            SharingCommand r12 = (SharingCommand) this.L$0;
            int r13 = c1.f18833a[r12.ordinal()];
            if (r13 != 1) goto L11;
            g r14 = this.$upstream;
            c2 r15 = this.$shared;
            this.label = 1;
            if (r14.collect(r15, this) != r10) goto L24;
            return r10;
        L11:
            if (r13 == 2) goto L24;
            if (r13 != 3) goto L19;
            Object r16 = this.$initialValue;
            if (r16 != i.f18851a) goto L17;
            this.$shared.d();
            goto L24
        L17:
            Boxing.boxBoolean(this.$shared.a(r16));
            goto L24
        L19:
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SharingCommand r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FlowKt__ShareKt$launchSharing$1(l2 r5, g r10, c2 r11, Object r12, Continuation<? super FlowKt__ShareKt$launchSharing$1> r13) {
        this.$started = r5;
        this.$upstream = r10;
        this.$shared = r11;
        this.$initialValue = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L13;
        if (r11 == 1) goto L12;
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L12;
        if (r11 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
    L23:
        g r12 = this.$upstream;
        c2 r13 = this.$shared;
        this.label = 3;
        if (r12.collect(r13, this) != r5) goto L30;
        return r5;
    L30:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r10);
        goto L30
    L13:
        ResultKt.throwOnFailure(r10);
        l2 r14 = this.$started;
        if (r14 != k2.f18893a) goto L19;
        g r15 = this.$upstream;
        c2 r16 = this.$shared;
        this.label = 1;
        if (r15.collect(r16, this) != r5) goto L30;
        return r5;
    L19:
        if (r14 != k2.f18894b) goto L26;
        kotlinx.coroutines.flow.internal.y r17 = ((kotlinx.coroutines.flow.internal.a) this.$shared).h();
        AnonymousClass1 r18 = new AnonymousClass1(null);
        this.label = 2;
        if (i.l(r17, r18, this) != r5) goto L23;
        return r5;
    L26:
        g r19 = i.h(r14.a(((kotlinx.coroutines.flow.internal.a) this.$shared).h()));
        AnonymousClass2 r20 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, null);
        this.label = 4;
        if (i.f(r19, r20, this) != r5) goto L30;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FlowKt__ShareKt$launchSharing$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
