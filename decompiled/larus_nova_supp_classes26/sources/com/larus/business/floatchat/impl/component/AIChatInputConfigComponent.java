package com.larus.business.floatchat.impl.component;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.business.floatchat.api.AIChatActionBarItemLocation;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020+H\u0016J\b\u0010E\u001a\u00020%H\u0016J\n\u0010F\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020:H\u0016J\b\u0010I\u001a\u00020AH\u0002J\u0010\u0010J\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0016J\u0010\u0010K\u001a\u00020A2\u0006\u0010B\u001a\u00020'H\u0016J\u0018\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020+H\u0016J\u0010\u0010O\u001a\u00020A2\u0006\u0010N\u001a\u00020+H\u0002J\u0010\u0010P\u001a\u00020A2\u0006\u0010N\u001a\u00020+H\u0002J\u0010\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020:H\u0002J\n\u0010S\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010T\u001a\u00020+2\u0006\u0010R\u001a\u00020:H\u0002J.\u0010U\u001a\u00020A2\u0006\u0010R\u001a\u00020:2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u0002032\f\u0010X\u001a\b\u0012\u0004\u0012\u00020A0YH\u0002J\u0018\u0010Z\u001a\u00020A2\u0006\u0010R\u001a\u00020:2\u0006\u0010[\u001a\u000203H\u0002J\u0010\u0010\\\u001a\u00020A2\u0006\u0010R\u001a\u00020:H\u0002J\u0010\u0010]\u001a\u00020A2\u0006\u0010R\u001a\u00020:H\u0002J\u0010\u0010^\u001a\u00020A2\u0006\u0010R\u001a\u00020:H\u0002J\b\u0010_\u001a\u00020AH\u0002J\u001a\u0010`\u001a\u00020A2\u0006\u0010B\u001a\u00020'2\b\u0010a\u001a\u0004\u0018\u00010)H\u0002J\b\u0010b\u001a\u00020+H\u0002J\b\u0010c\u001a\u00020AH\u0002J\b\u0010d\u001a\u00020AH\u0016J\b\u0010e\u001a\u00020AH\u0016J\f\u0010f\u001a\u00020g*\u00020hH\u0002J\u0010\u0010i\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010j\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010k\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\b\u0010l\u001a\u00020+H\u0002J\u0018\u0010m\u001a\u00020A2\u0006\u0010B\u001a\u00020%2\u0006\u0010n\u001a\u00020+H\u0002J\b\u0010o\u001a\u00020AH\u0002J\u0010\u0010p\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010q\u001a\u00020A2\u0006\u0010B\u001a\u00020%H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020/X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006r"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIChatInputConfigComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/business/floatchat/api/ability/IAIChatInputConfigAbility;", "<init>", "()V", "inputCommonAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getInputCommonAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "inputCommonAbility$delegate", "Lkotlin/Lazy;", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "floatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "floatChatFoldCoreAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "creationInputAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationInputAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationInputAbility$delegate", "inputConfig", "Lcom/larus/business/floatchat/api/AIChatInputConfig;", "actionBarConfig", "Lcom/larus/business/floatchat/api/AIChatActionBarConfig;", "actionBarEventScopeId", "", "hasActionBarSnapshot", "", "actionBarSnapshotFilterId", "isActionBarVisible", "actionBarAnimVersion", "", "actionBarAnimator", "Landroid/animation/ValueAnimator;", "actionBarAnimProgress", "", "actionBarExpandedHeight", "actionBarExpandedTopMargin", "actionBarExpandedLayoutHeight", "defaultChatCameraUiAbilityConfig", "Lcom/larus/bmhome/camera/ChatCameraUiAbilityConfig;", "rootView", "Landroid/view/View;", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "applyInputConfig", "", "config", "applyInputBoxConfig", "canShowActionBar", "getCurrentConfig", "getWidgetTheme", "onViewCreated", "view", "configureFullScreenEditContainer", "onConfigChange", "updateActionBar", "setActionBarVisible", "visible", "needAnim", "hideActionBar", "showActionBar", "startShowActionBarAnimation", "actionBarContainer", "findActionBarContainer", "captureExpandedActionBarLayout", "startActionBarLayoutAnimation", "animatorRes", "targetProgress", "onAnimationEnd", "Lkotlin/Function0;", "applyActionBarProgress", "progress", "finishHideActionBar", "finishShowActionBar", "restoreExpandedActionBarLayout", "cancelActionBarAnimator", "applyActionBarConfig", "eventScopeId", "installActionBarSnapshotFilter", "removeActionBarSnapshotFilter", "onFragmentViewDestroyed", "onDestroy", "toAIChatLocation", "Lcom/larus/business/floatchat/api/AIChatActionBarItemLocation;", "Lcom/larus/bmhome/actionbar/model/ActionBarItemLocation;", "applyActionBar", "applyHint", "applySpeakHint", "isInstructionOpen", "applyActionEntrance", "useInputConfig", "applyCameraConfig", "applyBottomMenu", "applyColorMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIChatInputConfigComponent extends BaseContentWidget implements ew8.a {
    public static final /* synthetic */ int H = 0;
    public float A;
    public int B;
    public int C;
    public int D;
    public final zb8.b E;
    public View F;
    public int G;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public AIChatInputConfig s;
    public dw8.d t;
    public String u;
    public boolean v;
    public String w;
    public boolean x;
    public int y;
    public ValueAnimator z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionBarItemLocation.values().length];
            r0[ActionBarItemLocation.PRIMARY_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ActionBarItemLocation.DETAIL_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class c implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<va8.k> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.k.class));
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ AIChatInputConfigComponent a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ float d;
        public final /* synthetic */ Function0<Unit> e;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            AIChatInputConfigComponent r4 = this.a;
            if (r4.y == this.b) goto L5;
            return;
        L5:
            r4.z = null;
            r4.h3(this.c, this.d);
            this.e.invoke();
        }

        public e(AIChatInputConfigComponent r1, int r2, View r3, float r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class f implements wa8.b0 {
        public final /* synthetic */ dw8.g a;
        public final /* synthetic */ AIChatInputConfigComponent b;

        public f(dw8.g r1, AIChatInputConfigComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(ActionBarItemLocation r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "location");
            Intrinsics.checkNotNullParameter(r4, "actionBarKey");
            this.a.a(AIChatInputConfigComponent.Y2(this.b, r3), r4, r5);
        }

        public final void b(ActionBarItemLocation r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "location");
            Intrinsics.checkNotNullParameter(r4, "actionBarKey");
            this.a.b(AIChatInputConfigComponent.Y2(this.b, r3), r4, r5);
        }
    }

    public final void A2() {
        View r0 = this.F;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131362044);
    L6:
        if (r1 == null) goto L8;
        p3();
        C3(r1);
    L8:
        this.B = 0;
        this.C = 0;
        this.D = -2;
        if (this.x == false) goto L11;
        float r2 = 1.0f;
    L12:
        this.A = r2;
        String r3 = this.w;
        if (r3 == null) goto L15;
        com.larus.bmhome.view.actionbar.api.a.b(r3);
    L15:
        this.w = null;
        this.F = null;
        return;
    L11:
        r2 = 0.0f;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void B3() {
        View r0 = this.F;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        ICoreInputAbility r3 = (ICoreInputAbility) this.m.getValue();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.JO() == null) goto L22;
        va8.o r4 = (va8.o) this.n.getValue();
        if (r4 == null) goto L19;
        r4.m1(r2);
    L19:
        FLogger.a.i("AIChatInputConfigComponent", "[configureFullScreenEditContainer] target=" + r2);
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // ew8.a
    public final boolean E2() {
        if (this.x == true) goto L6;
        return false;
    L6:
        if (this.v == false) goto L11;
        if (this.t.a.isEmpty() == true) goto L12;
        return true;
    L12:
        return false;
    L11:
        return this.s.h;
    }

    @Override // ew8.a
    public final String Z0() {
        int r0 = this.s.j;
        if (r0 != 1) goto L5;
        return "light";
    L5:
        if (r0 == 2) goto L7;
        return null;
    L7:
        return "dark";
    }

    public final void onDestroy() {
        String r0 = this.u;
        if (r0 == null) goto L5;
        Map r1 = wa8.c0.a;
        Intrinsics.checkNotNullParameter(r0, "scopeId");
        wa8.c0.a.remove(r0);
    L5:
        this.u = null;
        String r2 = this.w;
        if (r2 == null) goto L8;
        com.larus.bmhome.view.actionbar.api.a.b(r2);
    L8:
        this.w = null;
    }

    public final void p3() {
        this.y++;
        ValueAnimator r0 = this.z;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.z = null;
    }

    public AIChatInputConfigComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new j(this));
        this.q = LazyKt.lazy(new k(this));
        this.r = LazyKt.lazy(new l(this));
        this.s = new AIChatInputConfig(0, null, 0, false, null, 0, null, 4095);
        this.t = new dw8.d(0);
        this.x = true;
        this.A = 1.0f;
        this.D = -2;
        this.E = new zb8.b(11);
        this.G = 2131365588;
    }

    public final int U2() {
        return this.G;
    }

    @Override // ew8.a
    public final AIChatInputConfig getCurrentConfig() {
        return this.s;
    }

    public final void C3(View r4) {
        if (this.B > 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.height = this.D;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        if (r1 == null) goto L11;
        r1.topMargin = this.C;
    L11:
        r4.setLayoutParams(r0);
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // ew8.a
    public final void I8(dw8.d r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.v = true;
        String r0 = this.u;
        if (r0 == null) goto L5;
        Map r2 = wa8.c0.a;
        Intrinsics.checkNotNullParameter(r0, "scopeId");
        wa8.c0.a.remove(r0);
    L5:
        this.t = r5;
        dw8.g r1 = r5.b;
        if (r1 == null) goto L8;
        String r3 = UUID.randomUUID().toString();
        Map r4 = wa8.c0.a;
        Intrinsics.checkNotNull(r3);
        f r6 = new f(r1, this);
        Intrinsics.checkNotNullParameter(r3, "scopeId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        wa8.c0.a.put(r3, r6);
    L9:
        this.u = r3;
        View r7 = this.F;
        if (r7 == null) goto L14;
        r7.post(new com.larus.business.floatchat.impl.component.f(this, r5, r3));
        return;
    L14:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void X2(int r1) {
        this.G = r1;
    }

    @Override // ew8.a
    public final void k8(AIChatInputConfig r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        this.s = r14;
        boolean r0 = z2.a.inputComponentConfig().getAiFloatChatInputConfigEnable();
        boolean r1 = false;
        String r6 = null;
        if (r0 == true) goto L5;
        ICoreInputAbility r7 = (ICoreInputAbility) this.m.getValue();
        if (r7 != null) goto L25;
    L31:
        ICoreInputAbility r8 = (ICoreInputAbility) this.m.getValue();
        if (r8 == null) goto L46;
        String r9 = r14.b;
        if (r9 != null) goto L36;
    L38:
        String r10 = r14.b;
        if (r10 != null) goto L41;
    L44:
        boolean r11 = true;
    L45:
        r8.Uu(r6, r11);
        goto L46
    L41:
        if (StringsKt.isBlank(r10) == true) goto L44;
        r11 = false;
        goto L45
    L36:
        if ((!StringsKt.isBlank(r9)) == false) goto L38;
        r6 = r9;
    L46:
        View r12 = this.F;
        if (r12 == null) goto L50;
        r12.post(new g(this, r14, r12));
    L50:
        va8.o r13 = (va8.o) this.n.getValue();
        if (r13 == null) goto L56;
        String r15 = r14.c;
        if (r15 != null) goto L55;
        r15 = "";
    L55:
        r13.HH(r15);
    L56:
        va8.o r16 = (va8.o) this.n.getValue();
        if (r16 == null) goto L76;
        com.larus.bmhome.instruction.g r17 = (com.larus.bmhome.instruction.g) this.q.getValue();
        if (r17 != null) goto L61;
    L63:
        boolean r18 = false;
    L64:
        if (r18 == true) goto L74;
        ys8.a r19 = (ys8.a) this.r.getValue();
        if (r19 != null) goto L68;
    L70:
        boolean r20 = false;
    L71:
        if (r20 == true) goto L74;
        boolean r21 = false;
    L75:
        r16.d90(!r21, false);
        goto L76
    L68:
        if (r19.z0() != true) goto L70;
        r20 = true;
    L74:
        r21 = true;
        goto L75
    L61:
        if (r17.z0() != true) goto L63;
        r18 = true;
    L76:
        int r22 = r14.d;
        if (r22 == 0) goto L82;
        if (r22 == 1) goto L81;
        if (r22 == 8) goto L82;
    L83:
        if (r0 == false) goto L90;
        rp8.a r2 = new rp8.a(Integer.valueOf(r22), 5);
        t1a.e r23 = s1a.d.a(this).p(Reflection.getOrCreateKotlinClass(rp8.a.class));
        if (r23 == null) goto L87;
        r23.a(new n(r2));
    L93:
        ICoreInputAbility r3 = (ICoreInputAbility) this.m.getValue();
        if (r3 == null) goto L99;
        if (r22 == 8) goto L98;
        if (r22 == 0) goto L98;
        r1 = true;
    L98:
        r3.Dr(r1);
    L99:
        m3(r14);
        va8.k r110 = (va8.k) this.o.getValue();
        if (r110 == null) goto L103;
        r110.IH();
        return;
    L103:
        return;
    L87:
        x1a.b r4 = x1a.a.c;
        if (r4 == null) goto L93;
        r4.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(rp8.a.class).getQualifiedName());
        goto L93
    L90:
        ICoreInputAbility r5 = (ICoreInputAbility) this.m.getValue();
        if (r5 == null) goto L93;
        r5.s20(r22);
        goto L93
    L81:
        r22 = 1;
    L82:
        r22 = 8;
        goto L83
    L25:
        if (r14.f == true) goto L27;
    L29:
        boolean r24 = false;
    L30:
        r7.uq(r24);
        goto L31
    L27:
        if ((!r14.g.isEmpty()) == false) goto L29;
        r24 = true;
        goto L30
    L5:
        if (r14.f == true) goto L7;
    L9:
        boolean r25 = false;
    L10:
        Boolean r111 = Boolean.valueOf(r25);
        String r26 = r14.b;
        if (r26 != null) goto L13;
    L15:
        String r112 = null;
    L16:
        rp8.d r27 = new rp8.d(null, null, r111, r112, 23);
        t1a.e r28 = s1a.d.a(this).p(Reflection.getOrCreateKotlinClass(rp8.d.class));
        if (r28 == null) goto L19;
        r28.a(new o(r27));
        goto L46
    L19:
        x1a.b r29 = x1a.a.c;
        if (r29 == null) goto L46;
        r29.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(rp8.d.class).getQualifiedName());
        goto L46
    L13:
        if ((!StringsKt.isBlank(r26)) == false) goto L15;
        r112 = r26;
        goto L16
    L7:
        if ((!r14.g.isEmpty()) == false) goto L9;
        r25 = true;
        goto L10
    }

    public final void m3(AIChatInputConfig r4) {
        int r5 = r4.j;
        TextView r1 = null;
        if (r5 != 1) goto L5;
        Integer r6 = 2131952434;
    L9:
        va8.o r0 = (va8.o) this.n.getValue();
        if (r0 == null) goto L14;
        va8.b r2 = r0.rX();
        if (r2 == null) goto L14;
        View r3 = r2.b;
    L16:
        if ((r3 instanceof TextView) == false) goto L18;
        r1 = (TextView) r3;
    L18:
        if (r6 == null) goto L22;
        if (r1 == null) goto L23;
        TextViewCompat.setTextAppearance(r1, r6.intValue());
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r3 = null;
        goto L16
    L5:
        if (r5 == 2) goto L7;
        r6 = null;
        goto L9
    L7:
        r6 = 2131952435;
        goto L9
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r4, "view");
        this.F = r4;
        B3();
        zb8.e r0 = (zb8.e) this.p.getValue();
        if (r0 == null) goto L5;
        r0.md(this.E);
    L5:
        m3(this.s);
        r4.post(new com.larus.business.floatchat.impl.component.e(this));
        FLogger.a.i("AIChatInputConfigComponent", "onViewCreated onViewCreated: " + r4);
    }

    public final boolean z3(View r6) {
        int r3 = 0;
        if (this.z == null) goto L5;
    L12:
        boolean r0 = false;
    L14:
        if (this.B <= 0) goto L17;
        if (r0 == true) goto L17;
        return true;
    L17:
        int r1 = Math.max(r6.getHeight(), r6.getMeasuredHeight());
        if (r1 > 0) goto L20;
        return false;
    L20:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        this.B = r1;
        this.D = r7.height;
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L24:
        if (r8 == null) goto L26;
        r3 = r8.topMargin;
    L26:
        this.C = r3;
        this.A = 1.0f;
        return true;
    L23:
        r8 = null;
        goto L24
    L5:
        if (this.A != 1.0f) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L12;
        if (r6.getVisibility() != 0) goto L12;
        r0 = true;
        goto L14
    L7:
        r2 = false;
        goto L8
    }

    public static final AIChatActionBarItemLocation Y2(AIChatInputConfigComponent r0, ActionBarItemLocation r1) {
        r0.getClass();
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return AIChatActionBarItemLocation.DETAIL_PANEL;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return AIChatActionBarItemLocation.PRIMARY_BAR;
    }

    @Override // ew8.a
    public final void I1(boolean r9, boolean r10) {
        if (this.x == r9) goto L5;
        boolean r0 = true;
    L6:
        this.x = r9;
        if (r0 == false) goto L9;
        FLogger.a.i("AIChatInputConfigComponent", "[setActionBarVisible] visible=" + r9 + ", needAnim=" + r10);
    L9:
        if (r0 == false) goto L12;
        if (r10 == false) goto L12;
        boolean r11 = true;
    L13:
        final View r3 = null;
        int r4 = 8;
        if (r9 == false) goto L49;
        View r12 = this.F;
        if (r12 == null) goto L18;
        final View r13 = r12.findViewById(2131362044);
    L19:
        if (r13 != null) goto L22;
        return;
    L22:
        if (r13.getVisibility() != 8) goto L24;
        boolean r1 = true;
    L25:
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) this.q.getValue();
        if (r7 == null) goto L29;
        r7.SF();
    L33:
        if (r13.getVisibility() == 0) goto L36;
        return;
    L36:
        if (z3(r13) == true) goto L43;
        if (r11 == true) goto L39;
        r13.post(new h(this, r13));
        return;
    L39:
        final int r14 = this.y + 1;
        this.y = r14;
        ValueAnimator r2 = this.z;
        if (r2 == null) goto L42;
        r2.cancel();
    L42:
        this.z = null;
        r13.setVisibility(4);
        r13.post(new i(this, r14, r13));
        return;
    L43:
        if (r1 == false) goto L46;
        h3(r13, 0.0f);
    L46:
        if (r11 == true) goto L48;
        p3();
        h3(r13, 1.0f);
        r13.setVisibility(0);
        C3(r13);
        return;
    L48:
        D3(r13, 2130837519, 1.0f, new m(this, r13));
        return;
    L29:
        if (E2() == false) goto L31;
        r4 = 0;
    L31:
        r13.setVisibility(r4);
        goto L33
    L24:
        r1 = false;
        goto L25
    L18:
        r13 = null;
        goto L19
    L49:
        View r15 = this.F;
        if (r15 == null) goto L52;
        r3 = r15.findViewById(2131362044);
    L52:
        if (r3 != null) goto L55;
        return;
    L55:
        if (r3.getVisibility() != 4) goto L61;
        p3();
        if (z3(r3) == false) goto L59;
        h3(r3, 0.0f);
        r3.setVisibility(8);
        C3(r3);
        return;
    L59:
        r3.setVisibility(8);
        return;
    L61:
        if (r3.getVisibility() == 0) goto L64;
        return;
    L64:
        if (z3(r3) == true) goto L66;
        r3.setVisibility(8);
        this.A = 0.0f;
        return;
    L66:
        if (r11 == true) goto L68;
        p3();
        h3(r3, 0.0f);
        r3.setVisibility(8);
        C3(r3);
        return;
    L68:
        D3(r3, 2130837518, 0.0f, new com.larus.business.floatchat.impl.component.a(this, r3));
        return;
    L12:
        r11 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void h3(View r4, float r5) {
        float r6 = RangesKt.coerceIn(r5, 0.0f, 1.0f);
        this.A = r6;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.height = (int) (this.B * r6);
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L8;
        r1.topMargin = (int) (this.C * r6);
    L8:
        r4.setLayoutParams(r0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void D3(final View r9, int r10, float r11, Function0<Unit> r12) {
        final int r4 = this.y + 1;
        this.y = r4;
        ValueAnimator r0 = this.z;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r13 = AnimatorInflater.loadAnimator(r9.getContext(), r10);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.animation.ValueAnimator");
        ValueAnimator r14 = (ValueAnimator) r13;
        r14.setFloatValues(new float[]{this.A, r11});
        r14.addUpdateListener(new com.larus.business.floatchat.impl.component.b(this, r4, r9));
        r14.addListener(new e(this, r4, r9, r11, r12));
        this.z = r14;
        r14.start();
    }
}
