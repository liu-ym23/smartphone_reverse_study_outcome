package com.obric.assistant.window.component;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u000206H\u0016J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u00020%H\u0016J\n\u0010;\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010<\u001a\u0002062\u0006\u0010=\u001a\u0002022\u0006\u0010>\u001a\u000202H\u0016J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\b\u0010A\u001a\u000206H\u0002J\b\u0010B\u001a\u000206H\u0002J\b\u0010C\u001a\u000202H\u0002J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u000202H\u0002J\b\u0010F\u001a\u000206H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b)\u0010**\u0004\b'\u0010(R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b.\u0010**\u0004\b-\u0010(R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020605X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/assistant/window/component/ObricWindowBottomBlurComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/window/ability/IWindowBottomBlurAbility;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "obricIntercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getObricIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "obricIntercomAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "expandState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "backdropWindowBlurViewDelegate", "Lkotlin/Lazy;", "Lcom/obric/assistant/view/ObricChatBottomBlurView;", "backdropWindowBlurView", "getBackdropWindowBlurView$delegate", "(Lcom/obric/assistant/window/component/ObricWindowBottomBlurComponent;)Ljava/lang/Object;", "getBackdropWindowBlurView", "()Lcom/obric/assistant/view/ObricChatBottomBlurView;", "backdropViewBlurViewDelegate", "backdropViewBlurView", "getBackdropViewBlurView$delegate", "getBackdropViewBlurView", "monitorStateJob", "Lkotlinx/coroutines/Job;", "currentBottomMenuHeight", "", "currentImeBottom", "chatWindowStateCallback", "Lkotlin/Function1;", "", "onCreate", "onDestroy", "onParentViewCreated", "getWindowBottomBlurView", "getInitializedWindowBottomBlurViewOrNull", "onUpdateBottomMenuHeight", "curHeight", "normalHeight", "addWindowBlurView", "addViewBlurView", "removeWindowBlurView", "removeViewBlurView", "getWindowBlurViewHeight", "updateImeBottom", "imeBottom", "updateWindowBlurViewHeight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowBottomBlurComponent extends ComponentFeature implements IObserveToken, xha.f {
    public static final /* synthetic */ int t = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final StateFlowImpl m;
    public final Lazy<com.obric.assistant.view.n> n;
    public final Lazy<com.obric.assistant.view.n> o;
    public Job p;
    public int q;
    public int r;
    public final g s;

    public static final class a {
    }

    public static final class b implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class c implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    static {
    }

    public final void B2() {
        FLogger.a.i("ObricWindowBottomBlurComponent", "onParentViewCreated");
        this.m.setValue(IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState());
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionActivityExpandState(this, this.s);
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricWindowBottomBlurComponent$onParentViewCreated$1(this, null), 3, null);
    }

    @Override // xha.f
    public final com.obric.assistant.view.n Bu() {
        if (this.n.isInitialized() == true) goto L7;
        return null;
    L7:
        return F2();
    }

    public final com.obric.assistant.view.n F2() {
        return (com.obric.assistant.view.n) this.n.getValue();
    }

    public final void N2() {
        if (this.o.isInitialized() == true) goto L6;
        return;
    L6:
        if (((com.obric.assistant.view.n) this.o.getValue()).getParent() == null) goto L9;
        FLogger.a.i("ObricWindowBottomBlurComponent", "remove backdropViewBlurView");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricWindowBottomBlurComponent$removeViewBlurView$1(this, null), 2, null);
        return;
    }

    public final void P2() {
        if (this.n.isInitialized() == true) goto L6;
        return;
    L6:
        if (F2().getParent() == null) goto L9;
        FLogger.a.i("ObricWindowBottomBlurComponent", "remove backdropWindowBlurView");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricWindowBottomBlurComponent$removeWindowBlurView$1(this, null), 2, null);
        return;
    }

    public final void X2() {
        if (this.n.isInitialized() == true) goto L6;
        return;
    L6:
        if (F2().getParent() != null) goto L8;
        return;
    L8:
        if (F2().getLayoutParams() == null) goto L20;
        int r0 = L2();
        com.obric.assistant.view.n r1 = F2();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L18;
        if (r2.height == r0) goto L15;
        r2.height = r0;
    L15:
        r1.setLayoutParams(r2);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void onCreate() {
        FLogger.a.i("ObricWindowBottomBlurComponent", "onCreate");
    }

    public final void onDestroy() {
        FLogger.a.i("ObricWindowBottomBlurComponent", "onDestroy");
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionActivityExpandState(this);
        if (this.n.isInitialized() == false) goto L8;
        F2().setOnImeBottomChangedListener(null);
    L8:
        P2();
        N2();
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.window.component.g] */
    public ObricWindowBottomBlurComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.j = LazyKt.lazy(new com.obric.assistant.window.component.b(this));
        this.k = LazyKt.lazy(new com.obric.assistant.window.component.c(this));
        this.l = LazyKt.lazy(new d(this));
        this.m = j1.a(AssistantActivityExpandState.INVISIBLE);
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
        this.s = new g(this);
    }

    @Override // xha.f
    public final com.obric.assistant.view.n FG() {
        return F2();
    }

    public final int L2() {
        int r0 = F2().getBlurHeight();
        if (this.r <= 0) goto L5;
        int r1 = 0;
    L7:
        return r0 + r1;
    L5:
        r1 = this.q;
        goto L7
    }

    public final void U2(int r3) {
        int r4 = RangesKt.coerceAtLeast(r3, 0);
        if (this.r != r4) goto L5;
        return;
    L5:
        this.r = r4;
        FLogger.a.i("ObricWindowBottomBlurComponent", "updateImeBottom, currentImeBottom = " + this.r);
        X2();
    }

    @Override // xha.f
    public final void L(int r2, int r3) {
        if (r3 <= 0) goto L5;
        int r4 = RangesKt.coerceIn(r2, 0, r3);
    L7:
        if (this.q != r4) goto L9;
        return;
    L9:
        this.q = r4;
        X2();
        return;
    L5:
        r4 = RangesKt.coerceAtLeast(r2, 0);
        goto L7
    }
}
