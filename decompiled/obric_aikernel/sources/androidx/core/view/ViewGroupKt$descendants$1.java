package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {119, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
@SourceDebugExtension({"SMAP\nViewGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewGroup.kt\nandroidx/core/view/ViewGroupKt$descendants$1\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,175:1\n55#2,4:176\n*S KotlinDebug\n*F\n+ 1 ViewGroup.kt\nandroidx/core/view/ViewGroupKt$descendants$1\n*L\n118#1:176,4\n*E\n"})
final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ViewGroupKt$descendants$1(ViewGroup r10, Continuation<? super ViewGroupKt$descendants$1> r11) {
        this.$this_descendants = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ViewGroupKt$descendants$1 r12 = new ViewGroupKt$descendants$1(this.$this_descendants, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super View> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super View> r10, Continuation<? super Unit> r11) {
        return ((ViewGroupKt$descendants$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008a -> B:22:0x008c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0091 -> B:24:0x0093). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        int r13 = this.I$1;
        int r14 = this.I$0;
        ViewGroup r15 = (ViewGroup) this.L$1;
        SequenceScope r16 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        SequenceScope r17 = r16;
        ViewGroup r18 = r15;
        int r19 = r13;
        ViewGroup r20 = r18;
    L24:
        r14 = r14 + 1;
    L11:
        if (r14 >= r19) goto L26;
        View r21 = r20.getChildAt(r14);
        Intrinsics.checkNotNullExpressionValue(r21, "getChildAt(index)");
        this.L$0 = r17;
        this.L$1 = r20;
        this.L$2 = r21;
        this.I$0 = r14;
        this.I$1 = r19;
        this.label = 1;
        if (r17.yield(r21, this) != r11) goto L15;
        return r11;
    L15:
        ViewGroup r22 = r20;
        r13 = r19;
        View r23 = r21;
    L17:
        if ((r23 instanceof ViewGroup) == false) goto L23;
        Sequence<View> r24 = ViewGroupKt.getDescendants((ViewGroup) r23);
        this.L$0 = r17;
        this.L$1 = r22;
        this.L$2 = null;
        this.I$0 = r14;
        this.I$1 = r13;
        this.label = 2;
        if (r17.yieldAll(r24, this) != r11) goto L21;
        return r11;
    L21:
        r15 = r22;
        r16 = r17;
        goto L22
    L23:
        r19 = r13;
        r20 = r22;
        goto L24
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r13 = this.I$1;
        r14 = this.I$0;
        r23 = (View) this.L$2;
        r22 = (ViewGroup) this.L$1;
        SequenceScope r25 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        r17 = r25;
        goto L17
    L10:
        ResultKt.throwOnFailure(r10);
        r17 = (SequenceScope) this.L$0;
        r20 = this.$this_descendants;
        r14 = 0;
        r19 = r20.getChildCount();
        goto L11
    }
}
