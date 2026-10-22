package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<kotlinx.coroutines.l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.w<p1<Object>> $result;
    final /* synthetic */ c<Object> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    @SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
    static final class a<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<g1<T>> f10433c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.l0 f10434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.w<p1<T>> f10435h;

        a(Ref.ObjectRef<g1<T>> r10, kotlinx.coroutines.l0 r11, kotlinx.coroutines.w<p1<T>> r12) {
            this.f10433c = r10;
            this.f10434g = r11;
            this.f10435h = r12;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.flow.g1, kotlinx.coroutines.flow.p1] */
        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            g1<T> r12 = this.f10433c.element;
            if (r12 == null) goto L5;
            r12.setValue(r10);
            Unit r13 = Unit.INSTANCE;
        L6:
            if (r13 != null) goto L9;
            kotlinx.coroutines.l0 r14 = this.f10434g;
            Ref.ObjectRef<g1<T>> r15 = this.f10433c;
            kotlinx.coroutines.w<p1<T>> r16 = this.f10435h;
            ?? r17 = (T) q1.a(r10);
            r16.K(new h1(r17, y1.i(r14.getCoroutineContext())));
            r15.element = r17;
        L9:
            return Unit.INSTANCE;
        L5:
            r13 = null;
            goto L6
        }
    }

    FlowKt__ShareKt$launchSharingDeferred$1(c<Object> r10, kotlinx.coroutines.w<p1<Object>> r11, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> r12) {
        this.$upstream = r10;
        this.$result = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__ShareKt$launchSharingDeferred$1 r12 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.l0 r10, Continuation<? super Unit> r11) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, kotlin.Unit] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
    L15:
        FlowKt__ShareKt$launchSharingDeferred$1 this = Unit.INSTANCE;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.l0 r13 = (kotlinx.coroutines.l0) this.L$0;
        Ref.ObjectRef r14 = new Ref.ObjectRef();     // Catch: Throwable -> L7
        c<Object> r15 = this.$upstream;     // Catch: Throwable -> L7
        a r16 = new a(r14, r13, this.$result);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r15.a(r16, this) != r11) goto L15;
        return r11;
    L7:
        th = move-exception;
        this.$result.G(th);
        throw th;
    }
}
