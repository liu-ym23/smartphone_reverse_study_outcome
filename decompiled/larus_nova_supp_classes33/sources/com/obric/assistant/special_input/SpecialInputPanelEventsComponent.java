package com.obric.assistant.special_input;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u000e*\u0001\u001c\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002'(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0011H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0011@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputPanelEventsComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "Lkotlin/Lazy;", "value", "Lcom/obric/assistant/special_input/SpecialInputPanelEventsComponent$PanelState;", "panelState", "setPanelState", "(Lcom/obric/assistant/special_input/SpecialInputPanelEventsComponent$PanelState;)V", "", "isMatchCallPanelShowCondition", "setMatchCallPanelShowCondition", "(Z)V", "isMatchBgShowCondition", "setMatchBgShowCondition", "chatWindowStateCallback", "Lkotlin/Function1;", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "", "panelStateListener", "com/obric/assistant/special_input/SpecialInputPanelEventsComponent$panelStateListener$2$1", "getPanelStateListener", "()Lcom/obric/assistant/special_input/SpecialInputPanelEventsComponent$panelStateListener$2$1;", "panelStateListener$delegate", "onCreate", "onStart", "onStop", "onDestroy", "notifyPanelStateChanged", "isVisible", "setBgState", "Companion", "PanelState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputPanelEventsComponent extends ComponentFeature implements IObserveToken, LifecycleObserver {
    public static final /* synthetic */ int n = 0;
    public final Lazy h;
    public b i;
    public boolean j;
    public boolean k;
    public final y0 l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final StateInfo c;
        public final boolean d;
        public final boolean e;
        public final Lazy f;
        public final boolean g;
        public final Lazy h;
        public final Lazy i;
        public final Lazy j;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            StateInfo r5 = this.c;
            if (r5 != null) goto L13;
            int r6 = 0;
        L14:
            int r7 = (r4 + r6) * 31;
            if (this.d == false) goto L17;
            int r8 = 1231;
        L18:
            int r9 = (r7 + r8) * 31;
            if (this.e == true) goto L23;
            r1 = 1237;
        L23:
            return r9 + r1;
        L17:
            r8 = 1237;
            goto L18
        L13:
            r6 = r5.hashCode();
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "PanelState(isUIStarted=" + this.a + ", isOpen=" + this.b + ", stateInfo=" + this.c + ", isChatWindow=" + this.d + ", isAssistantVisible=" + this.e + ')';
        }

        public /* synthetic */ b(int r8) {
            boolean r5 = false;
            if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState() != AssistantActivityExpandState.CHAT_WINDOW) goto L5;
            boolean r9 = true;
        L7:
            if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState() == AssistantActivityExpandState.INVISIBLE) goto L9;
            r5 = true;
        L9:
            this(false, false, null, r9, r5);
            return;
        L5:
            r9 = false;
            goto L7
        }

        public b(boolean r1, boolean r2, StateInfo r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = LazyKt.lazy(new b1(this));
            boolean r6 = false;
            if (r3 != null) goto L5;
        L7:
            this.g = r6;
            this.h = LazyKt.lazy(new c1(this));
            this.i = LazyKt.lazy(new d1(this));
            this.j = LazyKt.lazy(new e1(this));
            return;
        L5:
            if (r3.isInIsland() != true) goto L7;
            r6 = true;
            goto L7
        }

        public static b a(b r6, boolean r7, boolean r8, StateInfo r9, boolean r10, boolean r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.a;
        L5:
            boolean r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.b;
        L8:
            boolean r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.c;
        L11:
            StateInfo r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r10 = r6.d;
        L14:
            boolean r4 = r10;
            if ((r12 & 16) == 0) goto L17;
            r11 = r6.e;
        L17:
            r6.getClass();
            return new b(r1, r2, r3, r4, r11);
        }
    }

    public static final class c implements laa.u {
        public final /* synthetic */ SpecialInputPanelEventsComponent a;

        public c(SpecialInputPanelEventsComponent r1) {
            this.a = r1;
        }

        public final void a(final laa.t r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            final SpecialInputPanelEventsComponent r0 = this.a;
            com.larus.utils.t0.e(new f1(r3, r0));
        }
    }

    public static final class d implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    static {
    }

    public final void onDestroy() {
        F2(false);
        FLogger.a.i("SpecialInputPanelEventsComponent", "onDestroy");
        laa.j r0 = (laa.j) this.h.getValue();
        if (r0 == null) goto L5;
        r0.RC((c) this.m.getValue());
    L5:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionActivityExpandState(this);
    }

    public final void onCreate() {
        FLogger.a.i("SpecialInputPanelEventsComponent", "onCreate");
        laa.j r0 = (laa.j) this.h.getValue();
        if (r0 == null) goto L5;
        r0.e00((c) this.m.getValue());
    L5:
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionActivityExpandState(this, this.l);
    }

    public final void onStart() {
        FLogger.a.i("SpecialInputPanelEventsComponent", "onStart");
        L2(b.a(this.i, true, false, null, false, false, 30));
    }

    public final void onStop() {
        FLogger.a.i("SpecialInputPanelEventsComponent", "onStop");
        L2(b.a(this.i, false, false, null, false, false, 30));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.assistant.special_input.y0] */
    public SpecialInputPanelEventsComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = new b(0);
        this.l = new y0(this);
        this.m = LazyKt.lazy(new z0(this));
    }

    public final void F2(boolean r4) {
        if (Build.VERSION.SDK_INT < 31) goto L20;
        int r0 = 0;
        if (r4 == true) goto L7;
    L9:
        boolean r5 = false;
    L10:
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L13;
        Activity r2 = (Activity) r1;
    L14:
        if (r2 == null) goto L22;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L23;
        if (r5 == false) goto L19;
        r0 = com.obric.assistant.common.utils.f.a(12);
    L19:
        r3.setBackgroundBlurRadius(r0);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r2 = null;
        goto L14
    L7:
        if (((BaseComponentFeatureInternal) this).a.getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L9;
        r5 = true;
        goto L10
    L20:
        FLogger.a.w("SpecialInputPanelEventsComponent", "setBgBlur: not support lower os version");
    }

    public final void L2(b r7) {
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputPanelEventsComponent", "update to " + r7);
        this.i = r7;
        final boolean r1 = ((Boolean) r7.i.getValue()).booleanValue();
        if (this.j == r1) goto L5;
        this.j = r1;
        final String r3 = (String) this.i.f.getValue();
        r0.i("SpecialInputPanelEventsComponent", "notifyPanelVisibleStateChanged: isVisible = " + r1 + ", pkgName = " + r3);
        com.larus.utils.t0.a.post(new x0(r1, r3));
    L5:
        boolean r8 = ((Boolean) r7.j.getValue()).booleanValue();
        if (this.k == r8) goto L9;
        this.k = r8;
        F2(r8);
        return;
    }
}
