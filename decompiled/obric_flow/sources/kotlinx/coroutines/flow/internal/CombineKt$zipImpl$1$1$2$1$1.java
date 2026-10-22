package kotlinx.coroutines.flow.internal;

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
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {126, 129, 129}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,140:1\n516#2:141\n14#3:142\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n126#1:141\n129#1:142\n*E\n"})
final class CombineKt$zipImpl$1$1$2$1$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.t $collectJob;
    final /* synthetic */ kotlinx.coroutines.channels.w $second;
    final /* synthetic */ kotlinx.coroutines.flow.h $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    final /* synthetic */ Object $value;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$2$1$1(kotlinx.coroutines.channels.w r5, kotlinx.coroutines.flow.h r10, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r11, Object r12, kotlinx.coroutines.t r13, Continuation<? super CombineKt$zipImpl$1$1$2$1$1> r14) {
        this.$second = r5;
        this.$this_unsafeFlow = r10;
        this.$transform = r11;
        this.$value = r12;
        this.$collectJob = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CombineKt$zipImpl$1$1$2$1$1(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, this.$collectJob, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(Unit r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        kotlinx.coroutines.flow.h r12 = (kotlinx.coroutines.flow.h) this.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        this.L$0 = null;
        this.label = 3;
        if (r12.emit(r10, this) != r5) goto L31;
        return r5;
    L11:
        ResultKt.throwOnFailure(r10);
        Object r13 = ((kotlinx.coroutines.channels.n) r10).f18815a;
    L15:
        kotlinx.coroutines.t r14 = this.$collectJob;
        if ((r13 instanceof kotlinx.coroutines.channels.m) == false) goto L21;
        Throwable r15 = kotlinx.coroutines.channels.n.a(r13);
        if (r15 == null) goto L20;
        throw r15;
    L20:
        throw new AbortFlowException(r14);
    L21:
        r12 = this.$this_unsafeFlow;
        Function3<Object, Object, Continuation<Object>, Object> r16 = this.$transform;
        Object r17 = this.$value;
        if (r13 != b.f18863b) goto L24;
        r13 = null;
    L24:
        this.L$0 = r12;
        this.label = 2;
        r10 = r16.invoke(r17, r13, this);
        if (r10 != r5) goto L27;
        return r5;
    L12:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.channels.w r18 = this.$second;
        this.label = 1;
        r13 = r18.a(this);
        if (r13 != r5) goto L15;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Unit r5, Continuation<? super Unit> r10) {
        return ((CombineKt$zipImpl$1$1$2$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
