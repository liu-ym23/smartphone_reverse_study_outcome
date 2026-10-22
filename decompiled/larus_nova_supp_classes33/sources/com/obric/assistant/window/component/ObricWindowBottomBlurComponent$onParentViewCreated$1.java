package com.obric.assistant.window.component;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.window.component.ObricWindowBottomBlurComponent$onParentViewCreated$1", f = "ObricWindowBottomBlurComponent.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class ObricWindowBottomBlurComponent$onParentViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricWindowBottomBlurComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.window.component.ObricWindowBottomBlurComponent$onParentViewCreated$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "", "isChatWindow", "overlayerVisibilityState"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.window.component.ObricWindowBottomBlurComponent$onParentViewCreated$1$1", f = "ObricWindowBottomBlurComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<AssistantActivityExpandState, Boolean, Continuation<? super Pair<? extends AssistantActivityExpandState, ? extends Boolean>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(3, r2);
        }

        public final Object invoke(AssistantActivityExpandState r2, boolean r3, Continuation<? super Pair<? extends AssistantActivityExpandState, Boolean>> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(r4);
            r0.L$0 = r2;
            r0.Z$0 = r3;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((AssistantActivityExpandState) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return TuplesKt.to((AssistantActivityExpandState) this.L$0, Boxing.boxBoolean(this.Z$0));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricWindowBottomBlurComponent a;

        public a(ObricWindowBottomBlurComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            Pair r10 = (Pair) r8;
            AssistantActivityExpandState r11 = (AssistantActivityExpandState) r10.component1();
            boolean r12 = ((Boolean) r10.component2()).booleanValue();
            FLogger r0 = FLogger.a;
            r0.i("ObricWindowBottomBlurComponent", "expandState: " + r11 + ", overlayerVisibilityState: " + r12);
            if (r11 == AssistantActivityExpandState.CHAT_WINDOW) goto L23;
            if (r12 == true) goto L6;
        L8:
            ObricWindowBottomBlurComponent r13 = this.a;
            int r1 = ObricWindowBottomBlurComponent.t;
            r13.P2();
            if (r12 == false) goto L22;
            ObricWindowBottomBlurComponent r14 = this.a;
            if (((BaseComponentFeatureInternal) r14).a.getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L13;
            r0.w("ObricWindowBottomBlurComponent", "addViewBlurView: lifecycle state is not created");
        L49:
            return Unit.INSTANCE;
        L13:
            ViewGroup r15 = (ViewGroup) r14.k.getValue();
            if (r15 != null) goto L16;
            r0.w("ObricWindowBottomBlurComponent", "addViewBlurView: chatRoot is null");
            goto L49
        L16:
            int r2 = r15.indexOfChild((FrameLayout) r14.l.getValue());
            if (r2 != (-1)) goto L19;
            r0.w("ObricWindowBottomBlurComponent", "addViewBlurView: target view index is -1");
            goto L49
        L19:
            com.obric.assistant.view.n r16 = (com.obric.assistant.view.n) r14.o.getValue();
            if (r16.getParent() != null) goto L49;
            r0.i("ObricWindowBottomBlurComponent", "add backdropViewBlurView");
            ViewGroup.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, r16.getBlurHeight());
            ((ConstraintLayout.LayoutParams) r3).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r3).startToStart = 0;
            ((ConstraintLayout.LayoutParams) r3).endToEnd = 0;
            Unit r4 = Unit.INSTANCE;
            r15.addView(r16, r2, r3);
            goto L49
        L22:
            this.a.N2();
            goto L49
        L6:
            if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState() != AssistantActivityExpandState.INVISIBLE) goto L8;
        L23:
            ObricWindowBottomBlurComponent r17 = this.a;
            int r18 = ObricWindowBottomBlurComponent.t;
            if (IWindowContextKt.isWindowContext(r17.getContext()) == true) goto L27;
            r0.i("ObricWindowBottomBlurComponent", "addWindowBlurView: context is not window context");
        L47:
            this.a.N2();
            goto L49
        L27:
            if (((BaseComponentFeatureInternal) r17).a.getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L29;
            r0.w("ObricWindowBottomBlurComponent", "addWindowBlurView: lifecycle state is not created");
            goto L47
        L29:
            ViewGroup r19 = (ViewGroup) r17.k.getValue();
            if (r19 != null) goto L32;
            r0.w("ObricWindowBottomBlurComponent", "addWindowBlurView: chatRoot is null");
            goto L47
        L32:
            ViewParent r5 = r19.getParent();
            if ((r5 instanceof ViewGroup) == false) goto L35;
            ViewGroup r6 = (ViewGroup) r5;
        L36:
            if (r6 != null) goto L38;
            r0.w("ObricWindowBottomBlurComponent", "addWindowBlurView: chatRoot parent is null");
            goto L47
        L38:
            com.obric.assistant.view.n r7 = r17.F2();
            WindowInsetsCompat r20 = ViewCompat.getRootWindowInsets(r19);
            if (r20 == null) goto L43;
            Insets r21 = r20.getInsets(WindowInsetsCompat.Type.ime());
            if (r21 == null) goto L43;
            int r22 = r21.bottom;
        L44:
            r17.U2(r22);
            if (r7.getParent() != null) goto L47;
            r0.i("ObricWindowBottomBlurComponent", "add backdropWindowBlurView, chatRootParent = " + r6 + ", height = " + r17.L2() + ", blurHeight = " + r7.getBlurHeight() + ", currentBottomMenuHeight = " + r17.q + ", currentImeBottom = " + r17.r);
            FrameLayout.LayoutParams r23 = new FrameLayout.LayoutParams(-1, r17.L2());
            r23.gravity = 80;
            Unit r24 = Unit.INSTANCE;
            r6.addView(r7, 0, r23);
        L43:
            r22 = 0;
            goto L44
        L35:
            r6 = null;
            goto L36
        }
    }

    public ObricWindowBottomBlurComponent$onParentViewCreated$1(ObricWindowBottomBlurComponent r1, Continuation<? super ObricWindowBottomBlurComponent$onParentViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricWindowBottomBlurComponent$onParentViewCreated$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ObricWindowBottomBlurComponent r7 = this.this$0;
        StateFlowImpl r2 = r7.m;
        laa.f r8 = (laa.f) r7.i.getValue();
        if (r8 == null) goto L13;
        StateFlowImpl r9 = r8.AD();
        if (r9 == null) goto L13;
    L14:
        v0 r4 = new v0(r2, r9, new AnonymousClass1(null));
        a r10 = new a(this.this$0);
        this.label = 1;
        if (r4.collect(r10, this) != r0) goto L18;
        return r0;
    L13:
        r9 = j1.a(Boxing.boxBoolean(false));
        goto L14
    }
}
