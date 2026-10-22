package com.larus.business.floatchat.impl.component;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.business.floatchat.impl.TouchDelegateFrameLayout;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003*\u000236\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020#H\u0016J\u0010\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000209H\u0016J\u0010\u0010?\u001a\u0002092\u0006\u0010:\u001a\u00020#H\u0002J\b\u0010@\u001a\u000209H\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010%2\u0006\u0010:\u001a\u00020#H\u0002J\u0010\u0010B\u001a\u0002092\u0006\u0010:\u001a\u00020#H\u0002J\u0010\u0010C\u001a\u0002092\u0006\u0010:\u001a\u00020#H\u0002J\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\u0010\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020\u0006H\u0002J\b\u0010K\u001a\u000209H\u0002J\u0010\u0010L\u001a\u0002092\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u000209H\u0002J\b\u0010Q\u001a\u000209H\u0002J\u000f\u0010R\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010SR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107R\u0016\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IConversationChangeListener;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "conversationCoreAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationCoreAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationCoreAbility$delegate", "Lkotlin/Lazy;", "floatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "floatChatFoldCoreAbility$delegate", "chatMessageShareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatMessageShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatMessageShareAbility$delegate", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "disclaimerView", "Landroid/widget/TextView;", "topHandleContainer", "Landroid/view/View;", "topHandleTouchDelegateAncestor", "Lcom/larus/business/floatchat/impl/TouchDelegateFrameLayout;", "topHandle", "topShadow", "topShareCancelButton", "selectModeTitleContainer", "selectModeTitle", "currentWindowState", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "isSelectMode", "", "useLegacyTitleBar", "getUseLegacyTitleBar", "()Z", "selectModeCallback", "com/larus/business/floatchat/impl/component/AIFloatChatTitleComponent$selectModeCallback$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatTitleComponent$selectModeCallback$1;", "windowStateChangeListener", "com/larus/business/floatchat/impl/component/AIFloatChatTitleComponent$windowStateChangeListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatTitleComponent$windowStateChangeListener$1;", "onViewCreated", "", "view", "onConversationIdChanged", "convId", "", "onFragmentViewDestroyed", "initTopHandle", "clearTopHandleTouchDelegate", "findTouchDelegateAncestor", "initSelectModeTitle", "initDisclaimer", "updateTitle", "state", "updateDragProgress", "progress", "", "updateTopHandleContainerHeight", "height", "updateDisclaimer", "updateDisclaimerByProgress", "lerpTopHandleContainerHeight", "refreshTitleStatus", "selectMode", "showSelectModeTitle", "hideSelectModeTitle", "getDisclaimerResId", "()Ljava/lang/Integer;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatTitleComponent extends BaseContentWidget implements va8.z {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public final a B;
    public final e C;
    public int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public TextView r;
    public View s;
    public TouchDelegateFrameLayout t;
    public View u;
    public View v;
    public TextView w;
    public View x;
    public TextView y;
    public FloatChatWindowState z;

    public static final class a implements hca.e {
        public final /* synthetic */ AIFloatChatTitleComponent a;

        public a(AIFloatChatTitleComponent r1) {
            this.a = r1;
        }

        public final void onSelectModeChanged(boolean r3) {
            AIFloatChatTitleComponent r0 = this.a;
            if (r0.A == r3) goto L20;
            r0.A = r3;
            if (r3 == false) goto L8;
            r0.h3();
            return;
        L8:
            TextView r4 = r0.w;
            if (r4 == null) goto L11;
            e1.o(r4);
        L11:
            View r5 = r0.x;
            if (r5 == null) goto L14;
            e1.o(r5);
        L14:
            TextView r6 = r0.r;
            if (r6 == null) goto L17;
            r6.bringToFront();
        L17:
            r0.p3(r0.z);
            return;
        }
    }

    public static final class b implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class c implements Function0<va8.k> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    public static final class e implements va8.i {
        public final /* synthetic */ AIFloatChatTitleComponent a;

        public e(AIFloatChatTitleComponent r1) {
            this.a = r1;
        }

        public final void LS(float r6) {
            AIFloatChatTitleComponent r0 = this.a;
            if (r0.A == true) goto L18;
            float r7 = RangesKt.coerceIn(r6, 0.0f, 1.0f);
            r0.z3(MathKt.roundToInt(i5.c() + ((((Number) i5.L.getValue()).intValue() - i5.c()) * r7)));
            TextView r2 = r0.r;
            if (r2 != null) goto L9;
            return;
        L9:
            if (r0.A == false) goto L12;
            r2.setVisibility(8);
            r2.setAlpha(0.0f);
            return;
        L12:
            if (r7 > 0.0f) goto L14;
            r2.setVisibility(8);
            r2.setAlpha(0.0f);
            return;
        L14:
            r2.setAlpha(r7);
            r2.setVisibility(0);
            return;
        }

        public final void am(va8.h r3) {
            Intrinsics.checkNotNullParameter(r3, "snapshot");
            AIFloatChatTitleComponent r0 = this.a;
            FloatChatWindowState r4 = r3.a;
            int r1 = AIFloatChatTitleComponent.D;
            r0.p3(r4);
        }
    }

    public final void A2() {
        va8.a0 r0 = (va8.a0) this.n.getValue();
        if (r0 == null) goto L5;
        r0.KM(this);
    L5:
        va8.k r1 = (va8.k) this.o.getValue();
        if (r1 == null) goto L8;
        r1.z40(this.C);
    L8:
        IChatMessageShareAbility r2 = (IChatMessageShareAbility) this.p.getValue();
        if (r2 == null) goto L11;
        r2.cG(this.B);
    L11:
        Y2();
        this.r = null;
        this.s = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
    }

    public final void Y2() {
        View r0 = this.s;
        TouchDelegateFrameLayout r1 = this.t;
        if (r0 == null) goto L26;
        if (r1 == null) goto L26;
        int r3 = com.larus.utils.v0.a;
        Intrinsics.checkNotNullParameter(r0, "target");
        Intrinsics.checkNotNullParameter(r1, "ancestor");
        com.larus.utils.v0.b r4 = r1.getTouchDelegate();
        if ((r4 instanceof com.larus.utils.v0.b) == false) goto L8;
        com.larus.utils.v0.b r5 = r4;
    L9:
        if (r5 == null) goto L26;
        Intrinsics.checkNotNullParameter(r0, "delegateView");
        int r6 = 0;
    L13:
        if (r6 >= ((LinkedList) r5.a).size()) goto L24;
        com.larus.utils.v0.a r7 = (com.larus.utils.v0.a) ListProtector.get(r5.a, r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "view");
        if (r7.c != r0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L19;
        r6 = r6 + 1;
        goto L13
    L19:
        ListProtector.remove(r5.a, r6);
        if (r5.b != r7) goto L13;
        r5.b = null;
        goto L13
    L17:
        r8 = false;
        goto L18
    L24:
        if (r5.a.isEmpty() == false) goto L26;
        r1.setTouchDelegate(null);
        goto L26
    L8:
        r5 = null;
    L26:
        this.t = null;
    }

    public final void h3() {
        z3(((Number) i5.X.getValue()).intValue());
        TextView r0 = this.r;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
        r0.setAlpha(0.0f);
    L5:
        TextView r1 = this.w;
        if (r1 == null) goto L8;
        e1.x(r1);
    L8:
        TextView r2 = this.y;
        if (r2 == null) goto L11;
        r2.setText(2131900874);
    L11:
        View r3 = this.s;
        if (r3 == null) goto L14;
        r3.bringToFront();
    L14:
        View r4 = this.x;
        if (r4 == null) goto L18;
        e1.x(r4);
        r4.bringToFront();
        return;
    }

    public final void m3() {
        TextView r0 = this.r;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.A == false) goto L10;
        r0.setVisibility(8);
        r0.setAlpha(0.0f);
        return;
    L10:
        if (this.z != FloatChatWindowState.Expanded) goto L74;
        com.larus.platform.model.chat.q r1 = (com.larus.platform.model.chat.q) this.q.getValue();
        boolean r4 = true;
        if (r1 != null) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L74;
        com.larus.platform.model.chat.q r3 = (com.larus.platform.model.chat.q) this.q.getValue();
        if (r3 != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L74;
        va8.a0 r6 = (va8.a0) this.n.getValue();
        if (r6 == null) goto L38;
        wc9.e r7 = r6.h();
        if (r7 == null) goto L38;
        String r8 = r7.a;
        if (r8 == null) goto L38;
        if (r8.length() <= 0) goto L35;
        boolean r9 = true;
    L36:
        if (r9 == false) goto L38;
    L39:
        wc9.e r10 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r10 == null) goto L42;
        String r11 = r10.a;
    L43:
        boolean r12 = Intrinsics.areEqual(r8, r11);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L46
        Object r14 = Result.constructor-impl(s1a.d.a(this).a(de8.c.class));     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r14) == false) goto L51;
        r14 = null;
    L51:
        de8.c r15 = (de8.c) r14;
        if (r15 != null) goto L54;
    L56:
        r4 = false;
    L57:
        com.larus.platform.service.n0 r16 = com.larus.platform.service.n0.a;
        if (r16.b() == false) goto L62;
        if (r4 == false) goto L62;
        Integer r17 = 2131905529;
    L75:
        if (r17 != null) goto L77;
        r0.setVisibility(8);
        r0.setAlpha(0.0f);
        r0.setText(null);
        return;
    L77:
        r0.setText(getContext().getString(r17.intValue()));
        r0.setAlpha(1.0f);
        r0.setVisibility(0);
        return;
    L62:
        if (r16.b() == false) goto L66;
        if (r12 == false) goto L66;
        r17 = 2131905539;
    L66:
        if (r16.b() == false) goto L68;
        r17 = 2131905543;
        goto L75
    L68:
        if (r12 == false) goto L71;
        r17 = 2131907201;
        goto L75
    L71:
        if (AppHost.a.isOversea() == false) goto L73;
        r17 = 2131908280;
        goto L75
    L73:
        r17 = 2131908279;
        goto L75
    L54:
        if (r15.w() != true) goto L56;
    L46:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L42:
        r11 = null;
        goto L43
    L35:
        r9 = false;
    L38:
        r8 = null;
        goto L39
    L21:
        if (r3.a() != 0) goto L23;
        r5 = true;
        goto L24
    L14:
        if (r1.b() != true) goto L16;
        r2 = true;
    L74:
        r17 = null;
        goto L75
    }

    public AIFloatChatTitleComponent() {
        this.m = 2131365588;
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
        this.q = LazyKt.lazy(new k0());
        this.z = FloatChatWindowState.Collapsed;
        this.B = new a(this);
        this.C = new e(this);
    }

    public final int U2() {
        return this.m;
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    public final void k2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "convId");
        TextView r3 = this.r;
        if (r3 == null) goto L6;
        r3.post(new i0(this));
        return;
    }

    public final void onViewCreated(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Y2();
        View r0 = r10.findViewById(2131389157);
        this.s = r0;
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        r0.setBackground(null);
    L5:
        View r2 = this.s;
        if (r2 == null) goto L8;
        e1.x(r2);
    L8:
        ViewParent r3 = r10.getParent();
    L9:
        if (r3 == null) goto L14;
        if ((r3 instanceof TouchDelegateFrameLayout) == true) goto L12;
        r3 = r3.getParent();
        goto L9
    L12:
        TouchDelegateFrameLayout r4 = (TouchDelegateFrameLayout) r3;
    L15:
        this.t = r4;
        boolean r5 = false;
        if (r4 == null) goto L23;
        View r6 = this.s;
        if (r6 == null) goto L23;
        int r7 = com.larus.utils.v0.a;
        Intrinsics.checkNotNullParameter(r6, "target");
        Intrinsics.checkNotNullParameter(r4, "ancestor");
        Rect r8 = new Rect(c7.b(0), c7.b(12), c7.b(0), c7.b(18));
        com.larus.utils.v0.b r9 = r4.getTouchDelegate();
        Intrinsics.checkNotNullParameter(r6, "delegateView");
        Intrinsics.checkNotNullParameter(r8, "mExpandBounds");
        Intrinsics.checkNotNullParameter(r4, "coordinateAncestor");
        com.larus.utils.v0.a r11 = new com.larus.utils.v0.a(new Rect(), r8, r6, r4);
        if ((r9 instanceof com.larus.utils.v0.b) == false) goto L22;
        r9.a(r11);
        goto L23
    L22:
        com.larus.utils.v0.b r12 = new com.larus.utils.v0.b(r4);
        r4.setTouchDelegate(r12);
        r12.a(r11);
    L23:
        View r13 = r10.findViewById(2131389156);
        this.u = r13;
        if (r13 == null) goto L26;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L28:
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L30;
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
    L31:
        if (r15 == null) goto L33;
        r15.height = i5.Y();
    L33:
        if (r15 == null) goto L35;
        r15.width = i5.W();
    L35:
        View r16 = this.u;
        if (r16 == null) goto L38;
        r16.setLayoutParams(r15);
    L38:
        View r17 = this.u;
        if (r17 == null) goto L41;
        e1.x(r17);
    L41:
        View r18 = r10.findViewById(2131389223);
        this.v = r18;
        if (r18 == null) goto L44;
        r18.setBackground(null);
    L44:
        View r19 = this.v;
        if (r19 == null) goto L48;
        e1.o(r19);
    L48:
        if ((!z2.a.r1()) == true) goto L50;
        return;
    L50:
        TextView r20 = (TextView) r10.findViewById(2131362395);
        this.r = r20;
        if (r20 == null) goto L53;
        r20.bringToFront();
    L53:
        TextView r21 = this.r;
        if (r21 == null) goto L56;
        ViewParent r22 = r21.getParent();
    L58:
        if ((r22 instanceof ViewGroup) == false) goto L60;
        r1 = (ViewGroup) r22;
    L60:
        if (r1 == null) goto L62;
        r1.invalidate();
    L62:
        TextView r23 = (TextView) r10.findViewById(2131389224);
        r23.setOnClickListener(new j0(this));
        this.w = r23;
        this.x = r10.findViewById(2131372935);
        this.y = (TextView) r10.findViewById(2131372934);
        va8.a0 r110 = (va8.a0) this.n.getValue();
        if (r110 == null) goto L65;
        r110.FM(this);
    L65:
        va8.k r111 = (va8.k) this.o.getValue();
        if (r111 == null) goto L68;
        r111.xf(this.C);
    L68:
        IChatMessageShareAbility r112 = (IChatMessageShareAbility) this.p.getValue();
        if (r112 == null) goto L71;
        r112.kN(this.B);
    L71:
        IChatMessageShareAbility r113 = (IChatMessageShareAbility) this.p.getValue();
        if (r113 != null) goto L74;
    L76:
        this.A = r5;
        va8.k r114 = (va8.k) this.o.getValue();
        if (r114 == null) goto L80;
        FloatChatWindowState r115 = r114.getWindowState();
        if (r115 == null) goto L80;
    L81:
        p3(r115);
        return;
    L80:
        r115 = FloatChatWindowState.Collapsed;
        goto L81
    L74:
        if (r113.H1() != true) goto L76;
        r5 = true;
        goto L76
    L56:
        r22 = null;
        goto L58
    L30:
        r15 = null;
        goto L31
    L26:
        r14 = null;
        goto L28
    L14:
        r4 = null;
        goto L15
    }

    public final void p3(FloatChatWindowState r2) {
        this.z = r2;
        if (this.A == false) goto L7;
        h3();
        return;
    L7:
        if (r2 != FloatChatWindowState.Expanded) goto L9;
        int r3 = ((Number) i5.L.getValue()).intValue();
    L10:
        z3(r3);
        m3();
        return;
    L9:
        r3 = i5.c();
        goto L10
    }

    public final void z3(int r4) {
        View r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.height != r4) goto L11;
        return;
    L11:
        r1.height = r4;
        r0.setLayoutParams(r1);
    }
}
