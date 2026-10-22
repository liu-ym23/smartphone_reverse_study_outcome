package kotlinx.coroutines.flow;

import com.bytedance.crash.constants.Constants;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {Constants.UPLOAD_DISASTER_ESCAPE, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<kotlinx.coroutines.l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ f1<Object> $shared;
    final /* synthetic */ m1 $started;
    final /* synthetic */ c<Object> $upstream;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(r11);
            r12.I$0 = ((Number) r10).intValue();
            return r12;
        }

        public final Object invoke(int r10, Continuation<? super Boolean> r11) {
            return ((AnonymousClass1) create(Integer.valueOf(r10), r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer r10, Continuation<? super Boolean> r11) {
            return invoke(r10.intValue(), r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r10);
            if (this.I$0 <= 0) goto L7;
            boolean r11 = true;
        L9:
            return Boxing.boxBoolean(r11);
        L7:
            r11 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $initialValue;
        final /* synthetic */ f1<Object> $shared;
        final /* synthetic */ c<Object> $upstream;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10432a = null;

            static {
                int[] r10 = new int[SharingCommand.values().length];
                r10[SharingCommand.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r10[SharingCommand.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r10[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f10432a = r10;
            }
        }

        AnonymousClass2(c<Object> r10, f1<Object> r11, Object r12, Continuation<? super AnonymousClass2> r13) {
            this.$upstream = r10;
            this.$shared = r11;
            this.$initialValue = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SharingCommand r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SharingCommand r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            SharingCommand r13 = (SharingCommand) this.L$0;
            int r14 = a.f10432a[r13.ordinal()];
            if (r14 != 1) goto L11;
            c<Object> r15 = this.$upstream;
            f1<Object> r16 = this.$shared;
            this.label = 1;
            if (r15.a(r16, this) != r11) goto L21;
            return r11;
        L11:
            if (r14 != 3) goto L21;
            Object r17 = this.$initialValue;
            kotlinx.coroutines.internal.i0 r18 = k1.f10501a;
            f1<Object> r19 = this.$shared;
            if (r17 != r18) goto L16;
            r19.b();
            goto L21
        L16:
            r19.c(r17);
            goto L21
        }
    }

    FlowKt__ShareKt$launchSharing$1(m1 r10, c<Object> r11, f1<Object> r12, Object r13, Continuation<? super FlowKt__ShareKt$launchSharing$1> r14) {
        this.$started = r10;
        this.$upstream = r11;
        this.$shared = r12;
        this.$initialValue = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.l0 r10, Continuation<? super Unit> r11) {
        return ((FlowKt__ShareKt$launchSharing$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L13;
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L11;
        if (r12 == 3) goto L12;
        if (r12 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
    L23:
        c<Object> r13 = this.$upstream;
        f1<Object> r14 = this.$shared;
        this.label = 3;
        if (r13.a(r14, this) != r11) goto L30;
        return r11;
    L30:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r10);
        goto L30
    L13:
        ResultKt.throwOnFailure(r10);
        m1 r15 = this.$started;
        m1.a r16 = m1.f10504a;
        if (r15 != r16.a()) goto L19;
        c<Object> r17 = this.$upstream;
        f1<Object> r18 = this.$shared;
        this.label = 1;
        if (r17.a(r18, this) != r11) goto L30;
        return r11;
    L19:
        if (this.$started != r16.b()) goto L26;
        p1<Integer> r19 = this.$shared.d();
        AnonymousClass1 r20 = new AnonymousClass1(null);
        this.label = 2;
        if (e.q(r19, r20, this) != r11) goto L23;
        return r11;
    L26:
        c r21 = e.k(this.$started.a(this.$shared.d()));
        AnonymousClass2 r22 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, null);
        this.label = 4;
        if (e.g(r21, r22, this) != r11) goto L30;
        return r11;
    }
}
