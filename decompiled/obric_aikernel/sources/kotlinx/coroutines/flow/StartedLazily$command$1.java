package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
final class StartedLazily$command$1 extends SuspendLambda implements Function2<d<? super SharingCommand>, Continuation<? super Unit>, Object> {
    final /* synthetic */ p1<Integer> $subscriptionCount;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f10454c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d<SharingCommand> f10455g;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.BooleanRef r10, d<? super SharingCommand> r11) {
            this.f10454c = r10;
            this.f10455g = r11;
        }

        public final Object a(int r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof StartedLazily$command$1$1$emit$1) == false) goto L7;
            StartedLazily$command$1$1$emit$1 r12 = (StartedLazily$command$1$1$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            ResultKt.throwOnFailure(r14);
        L22:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            if (r10 <= 0) goto L24;
            Ref.BooleanRef r17 = this.f10454c;
            if (r17.element == true) goto L24;
            r17.element = true;
            d<SharingCommand> r18 = this.f10455g;
            SharingCommand r19 = SharingCommand.START;
            r12.label = 1;
            if (r18.emit(r19, r12) != r15) goto L22;
            return r15;
        L24:
            return Unit.INSTANCE;
        L7:
            r12 = new StartedLazily$command$1$1$emit$1(this, r11);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.d
        public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
            return a(((Number) r10).intValue(), r11);
        }
    }

    StartedLazily$command$1(p1<Integer> r10, Continuation<? super StartedLazily$command$1> r11) {
        this.$subscriptionCount = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        StartedLazily$command$1 r12 = new StartedLazily$command$1(this.$subscriptionCount, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<? super SharingCommand> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super SharingCommand> r10, Continuation<? super Unit> r11) {
        return ((StartedLazily$command$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        d r13 = (d) this.L$0;
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        p1<Integer> r15 = this.$subscriptionCount;
        AnonymousClass1 r16 = new AnonymousClass1(r14, r13);
        this.label = 1;
        if (r15.a(r16, this) != r11) goto L12;
        return r11;
    }
}
