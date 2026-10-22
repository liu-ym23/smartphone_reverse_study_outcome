package com.ss.android.lark.inline.ai.ui;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.InlineAIPanelController$handleStatusBar$1$1", f = "InlineAIPanelController.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
final class InlineAIPanelController$handleStatusBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Integer> $lastColor;
    final /* synthetic */ wlb.f $statusBar;
    int label;
    final /* synthetic */ InlineAIPanelController this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Ref.ObjectRef<Integer> a;
        public final /* synthetic */ wlb.f b;
        public final /* synthetic */ InlineAIPanelController c;

        public a(Ref.ObjectRef<Integer> r1, wlb.f r2, InlineAIPanelController r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (((Boolean) r3).booleanValue() == false) goto L5;
            Ref.ObjectRef<Integer> r5 = this.a;
            r5.element = Boxing.boxInt(this.b.a());
            this.b.b(UDColorUtils.getAlphaColor(this.c.a.getActivity(), 2131100562, 0.4f));
        L10:
            return Unit.INSTANCE;
        L5:
            Integer r6 = (Integer) this.a.element;
            if (r6 == null) goto L8;
            this.b.b(r6.intValue());
        L8:
            this.a.element = null;
            goto L10
        }
    }

    public InlineAIPanelController$handleStatusBar$1$1(InlineAIPanelController r1, Ref.ObjectRef<Integer> r2, wlb.f r3, Continuation<? super InlineAIPanelController$handleStatusBar$1$1> r4) {
        this.this$0 = r1;
        this.$lastColor = r2;
        this.$statusBar = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InlineAIPanelController$handleStatusBar$1$1(this.this$0, this.$lastColor, this.$statusBar, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        InlineAIPanelController r8 = this.this$0;
        StateFlowImpl r2 = r8.U;
        a r3 = new a(this.$lastColor, this.$statusBar, r8);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
