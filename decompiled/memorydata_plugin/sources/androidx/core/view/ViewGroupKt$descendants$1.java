package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {IdlErrors.E_RejectInferDeviceOverheat, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ViewGroupKt$descendants$1(ViewGroup r3, Continuation<? super ViewGroupKt$descendants$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_descendants = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        ViewGroupKt$descendants$1 r0 = new ViewGroupKt$descendants$1(this.$this_descendants, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(SequenceScope<? super View> r3, Continuation<? super Unit> r4) {
        return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super View> r3, Continuation<? super Unit> r4) {
        return ((ViewGroupKt$descendants$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ViewGroupKt$descendants$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00b5 -> B:22:0x00b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00bc -> B:24:0x00be). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r5 = this.I$0;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.L$1, ViewGroup.class, "com.obric.memorydata.plugin");
        SequenceScope r7 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L22:
        SequenceScope r13 = r7;
        ViewGroup r10 = r6;
        int r8 = r2;
        ViewGroup r3 = r10;
    L24:
        r5 = r5 + 1;
    L11:
        if (r5 >= r8) goto L26;
        View r9 = r3.getChildAt(r5);
        this.L$0 = r13;
        this.L$1 = r3;
        this.L$2 = r9;
        this.I$0 = r5;
        this.I$1 = r8;
        this.label = 1;
        if (r13.yield(r9, this) != r0) goto L15;
        return r0;
    L15:
        ViewGroup r11 = r3;
        r2 = r8;
        View r14 = r9;
    L17:
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.class) == false) goto L23;
        Sequence<View> r15 = ViewGroupKt.getDescendants((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.L$0 = r13;
        this.L$1 = r11;
        this.L$2 = null;
        this.I$0 = r5;
        this.I$1 = r2;
        this.label = 2;
        if (r13.yieldAll(r15, this) != r0) goto L21;
        return r0;
    L21:
        r6 = r11;
        r7 = r13;
        goto L22
    L23:
        r8 = r2;
        r3 = r11;
        goto L24
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$1;
        r5 = this.I$0;
        r14 = (View) ZeusTransformUtils.preCheckCast(this.L$2, View.class, "com.obric.memorydata.plugin");
        r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.L$1, ViewGroup.class, "com.obric.memorydata.plugin");
        SequenceScope r16 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        r13 = r16;
        goto L17
    L10:
        ResultKt.throwOnFailure(r12);
        r13 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
        r3 = this.$this_descendants;
        r5 = 0;
        r8 = r3.getChildCount();
        goto L11
    }
}
