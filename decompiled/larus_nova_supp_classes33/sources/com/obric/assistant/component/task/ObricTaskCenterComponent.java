package com.obric.assistant.component.task;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001*\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001JB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0002J\b\u00104\u001a\u00020-H\u0016J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020-H\u0016J\b\u00107\u001a\u00020-H\u0016J\b\u00108\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020 H\u0016J\u000e\u0010<\u001a\u00020/*\u0004\u0018\u000102H\u0002J\b\u0010=\u001a\u00020-H\u0002J\u0012\u0010>\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u0010?\u001a\u00020-H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010A\u001a\u00020-H\u0002J\b\u0010B\u001a\u00020-H\u0002J\b\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020-H\u0002J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020-H\u0002J\b\u0010G\u001a\u00020/H\u0002J\n\u0010H\u001a\u0004\u0018\u00010IH\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006K"}, d2 = {"Lcom/obric/assistant/component/task/ObricTaskCenterComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/ability/IDraggingStateCallback;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "chatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "chatPageStateAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "fullOrHalfScreenCheckJob", "Lkotlinx/coroutines/Job;", "checkBannerJob", "landscapeImeTargetRetryJob", "landscapeImeTargetRetryCount", "", "taskPopupController", "Lcom/obric/assistant/component/task/TaskPanelController;", "taskPopupControllerAnchor", "Landroid/view/View;", "taskPopupMonitorHostView", "taskPopupMonitorView", "taskPopupMonitorLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "taskPopupMonitorAttachStateListener", "com/obric/assistant/component/task/ObricTaskCenterComponent$taskPopupMonitorAttachStateListener$1", "Lcom/obric/assistant/component/task/ObricTaskCenterComponent$taskPopupMonitorAttachStateListener$1;", "onChatStyleChanged", "", "isChatWindow", "", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "onPageStateChange", "onCreate", "onResume", "onStop", "onDestroy", "checkAndHandleBanner", "handleBannerLogic", "onDragIncreasedHeightChanged", "increasedHeight", "canShowTaskBanner", "refreshTaskPopupForCurrentState", "refreshTaskPopupForPageState", "installTaskPopupMonitor", "ensureTaskPopupController", "destroyTaskPopupController", "removeTaskPopupMonitor", "showTaskPopupIfImeGateAllows", "dismissTaskPopupForLandscapeIme", "shouldSuppressTaskPopupForLandscapeIme", "scheduleLandscapeImeTargetRetry", "isLandscapeForTaskPopup", "findTitleContainer", "Landroid/view/ViewGroup;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskCenterComponent extends BaseContentWidget implements IObserveToken, hca.b, laa.a {
    public static final /* synthetic */ int z = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public Job p;
    public Job q;
    public Job r;
    public int s;
    public n t;
    public View u;
    public View v;
    public View w;
    public final com.obric.assistant.component.task.a x;
    public final f y;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(com.obric.assistant.component.task.c r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class e implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class f implements View.OnAttachStateChangeListener {
        public final /* synthetic */ ObricTaskCenterComponent a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public f(ObricTaskCenterComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            ViewCompat.requestApplyInsets(r2);
            ObricTaskCenterComponent r3 = this.a;
            int r0 = ObricTaskCenterComponent.z;
            r3.B3();
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.component.task.ObricTaskCenterComponent$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.task.ObricTaskCenterComponent$onResume$1", f = "ObricTaskCenterComponent.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricTaskCenterComponent this$0;

        public AnonymousClass1(ObricTaskCenterComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L7
        L15:
            ObricTaskCenterComponent r8 = this.this$0;     // Catch: Exception -> L7
            int r3 = ObricTaskCenterComponent.z;     // Catch: Exception -> L7
            laa.d r9 = r8.p3();     // Catch: Exception -> L7
            if (r9 == null) goto L18;
            ObricFloatChatPageState r10 = r9.getPageState();     // Catch: Exception -> L7
        L19:
            FLogger.a.i("ObricTaskCenterComponent", "onResume, currentPageState = " + r10);     // Catch: Exception -> L7
            this.this$0.C3(r10);     // Catch: Exception -> L7
        L23:
            return Unit.INSTANCE;
        L18:
            r10 = null;
            goto L19
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r7);
            this.label = 1;     // Catch: Exception -> L7
            if (DelayKt.delay(1000, this) != r1) goto L15;
            return r1;
        L7:
            e = move-exception;
            FLogger.a.e("ObricTaskCenterComponent", "Error in fullScreenCheckJob: " + e.getMessage(), e);
            goto L23
        }
    }

    static {
    }

    public final void r2(boolean r1) {
    }

    public final void D3() {
        View r0 = this.v;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.x);
    L5:
        this.v = null;
        View r1 = this.w;
        if (r1 == null) goto L8;
        r1.removeOnAttachStateChangeListener(this.y);
    L8:
        View r2 = this.w;
        if (r2 == null) goto L16;
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
    L14:
        if (r4 == null) goto L16;
        r4.removeView(r2);
        goto L16
    L13:
        r4 = null;
    L16:
        this.w = null;
    }

    public final void h3() {
        Job r0 = this.q;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.q = null;
        n r1 = this.t;
        if (r1 == null) goto L9;
        r1.j = false;
        r1.c();
        return;
    }

    public final ViewGroup m3() {
        va8.m r0 = (va8.m) this.m.getValue();
        if (r0 == null) goto L5;
        va8.l r1 = r0.iX();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getTitleContainer();
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        Job r0 = this.p;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.p = null;
        Job r1 = this.q;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.q = null;
        Job r2 = this.r;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.r = null;
        D3();
        n r3 = this.t;
        if (r3 == null) goto L14;
        r3.b();
    L14:
        this.t = null;
        this.u = null;
        laa.d r4 = p3();
        if (r4 == null) goto L17;
        r4.AN(this);
    L17:
        laa.d r5 = p3();
        if (r5 == null) goto L21;
        r5.H30(this);
        return;
    }

    public final void onStop() {
        n r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.k == false) goto L13;
        r0.k = false;
        PopupWindow r1 = r0.g;
        if (r1 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        return;
    L12:
        return;
    }

    public final laa.d p3() {
        return (laa.d) this.o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.component.task.a] */
    public ObricTaskCenterComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new d(this));
        this.o = LazyKt.lazy(new e(this));
        this.x = new com.obric.assistant.component.task.a(this);
        this.y = new f(this);
    }

    public final void B3() {
        laa.d r0 = p3();
        if (r0 == null) goto L5;
        ObricFloatChatPageState r1 = r0.getPageState();
    L6:
        C3(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean E3() {
        if (s1a.a.getActivity(this).getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        this.s = 0;
        Job r1 = this.r;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.r = null;
        return false;
    L13:
        va8.o r2 = (va8.o) this.n.getValue();
        if (r2 == null) goto L18;
        com.larus.bmhome.chat.component.bottom.core.a r3 = r2.Uv();
        if (r3 == null) goto L18;
        TextView r4 = r3.b();
    L19:
        if (r4 == null) goto L21;
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(r4);
    L22:
        if (r4 == null) goto L30;
        if (r5 == null) goto L30;
        this.s = 0;
        Job r6 = this.r;
        if (r6 == null) goto L28;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L28:
        this.r = null;
        return r5.isVisible(WindowInsetsCompat.Type.ime());
    L30:
        Job r7 = this.r;
        if (r7 != null) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == true) goto L42;
        int r9 = this.s;
        if (r9 >= 5) goto L42;
        this.s = r9 + 1;
        this.r = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(s1a.a.getActivity(this)), null, null, new ObricTaskCenterComponent$scheduleLandscapeImeTargetRetry$1(this, null), 3, null);
    L42:
        return false;
    L33:
        if (r7.isActive() != true) goto L35;
        r8 = true;
        goto L36
    L21:
        r5 = null;
    L18:
        r4 = null;
        goto L19
    L5:
        r0 = false;
        goto L7
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        laa.d r0 = p3();
        if (r0 == null) goto L5;
        r0.HU(this);
    L5:
        laa.d r1 = p3();
        if (r1 == null) goto L8;
        r1.Mx(this);
    L8:
        z3();
        B3();
    }

    public final void onResume() {
        z3();
        B3();
        if (this.p != null) goto L6;
        this.p = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public final void z3() {
        ViewGroup r0 = m3();
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.w;
        if (r1 != null) goto L8;
    L15:
        D3();
        View r2 = new View(s1a.a.getActivity(this));
        r2.setClickable(false);
        r2.setFocusable(false);
        r2.setImportantForAccessibility(2);
        this.v = r0;
        this.w = r2;
        r0.addOnLayoutChangeListener(this.x);
        r2.addOnAttachStateChangeListener(this.y);
        ViewCompat.setOnApplyWindowInsetsListener(r2, new com.obric.assistant.component.task.b(this));
        r0.addView(r2, new ViewGroup.LayoutParams(0, 0));
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L20;
        ViewCompat.requestApplyInsets(r2);
        return;
    L20:
        return;
    L8:
        if (r1.getParent() != r0) goto L15;
        if (this.v != r0) goto L15;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L19;
        ViewCompat.requestApplyInsets(r1);
        return;
    }

    public static final void Y2(ObricTaskCenterComponent r4) {
        if (r4.E3() == false) goto L5;
        r4.h3();
        return;
    L5:
        ViewGroup r0 = r4.m3();
        if (r0 != null) goto L8;
        n r5 = null;
    L17:
        if (r5 == null) goto L21;
        r5.j = true;
        r5.c();
        return;
    L21:
        return;
    L8:
        n r1 = r4.t;
        if (r1 != null) goto L11;
    L13:
        if (r1 == null) goto L15;
        r1.b();
    L15:
        r1 = new n(s1a.a.getActivity(r4), r0, s1a.a.getActivity(r4));
        r4.t = r1;
        r4.u = r0;
    L16:
        r5 = r1;
        goto L17
    L11:
        if (r4.u != r0) goto L13;
        goto L13
    }

    public final void C3(ObricFloatChatPageState r8) {
        ObricFloatChatPageData.Companion.getClass();
        if ((r8 instanceof vda.d) == true) goto L9;
        if ((r8 instanceof vda.f) == true) goto L9;
        if ((r8 instanceof vda.e) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L23;
        if (E3() == false) goto L16;
        h3();
        return;
    L16:
        FLogger.a.i("ObricTaskCenterComponent", "checkAndHandleBanner");
        if (m3() == null) goto L37;
        Job r9 = this.q;
        if (r9 == null) goto L21;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L21:
        this.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(s1a.a.getActivity(this)), null, null, new ObricTaskCenterComponent$handleBannerLogic$1(this, null), 3, null);
        return;
    L37:
        return;
    L23:
        if ((r8 instanceof vda.c) == false) goto L32;
        n r10 = this.t;
        if (r10 != null) goto L27;
        return;
    L27:
        if (r10.k == false) goto L43;
        r10.k = false;
        PopupWindow r11 = r10.g;
        if (r11 == null) goto L40;
        PopupWindowLancet.handleDismissBeforeOrigin(r11);
        r11.dismiss();
        return;
    L40:
        return;
    L43:
        return;
    L32:
        n r12 = this.t;
        if (r12 == null) goto L42;
        r12.j = false;
        r12.c();
        return;
    L42:
        return;
    L9:
        if (z2.a.getAppsFrameworkConfig().c == true) goto L11;
        r0 = true;
        goto L12
    }

    public final void t0(int r6) {
        n r0 = this.t;
        if (r0 == null) goto L24;
        TaskPanelView r1 = r0.d;
        if (r1 == null) goto L25;
        int r2 = i5.k0();
        boolean r3 = true;
        if (r6 > (r1.getHeight() + i5.k0())) goto L10;
        if (r2 > r6) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        float r7 = (r6 - i5.k0()) / r1.getHeight();
    L18:
        if (r1.getAlpha() == r7) goto L21;
        r3 = false;
    L21:
        if (r3 == true) goto L26;
        r1.setAlpha(r7);
        return;
    L26:
        return;
    L14:
        if (r6 >= i5.k0()) goto L16;
        r7 = 0.0f;
        goto L18
    L16:
        r7 = 1.0f;
    L10:
        r4 = false;
        goto L11
    L25:
        return;
    }

    public final void x1(ObricFloatChatPageState r4) {
        Intrinsics.checkNotNullParameter(r4, "pageState");
        FLogger.a.i("ObricTaskCenterComponent", "onPageStateChange " + r4);
        C3(r4);
    }
}
