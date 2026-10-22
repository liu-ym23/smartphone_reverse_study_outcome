package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {414, TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    ViewKt$allViews$1(View r10, Continuation<? super ViewKt$allViews$1> r11) {
        this.$this_allViews = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ViewKt$allViews$1 r12 = new ViewKt$allViews$1(this.$this_allViews, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super View> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super View> r10, Continuation<? super Unit> r11) {
        return ((ViewKt$allViews$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        SequenceScope r13 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        View r14 = this.$this_allViews;
        if ((r14 instanceof ViewGroup) == false) goto L19;
        Sequence<View> r15 = ViewGroupKt.getDescendants((ViewGroup) r14);
        this.L$0 = null;
        this.label = 2;
        if (r13.yieldAll(r15, this) != r11) goto L19;
        return r11;
    L10:
        ResultKt.throwOnFailure(r10);
        r13 = (SequenceScope) this.L$0;
        View r16 = this.$this_allViews;
        this.L$0 = r13;
        this.label = 1;
        if (r13.yield(r16, this) != r11) goto L13;
        return r11;
    }
}
