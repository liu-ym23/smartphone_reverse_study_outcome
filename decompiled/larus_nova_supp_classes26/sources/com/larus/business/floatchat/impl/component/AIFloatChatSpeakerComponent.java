package com.larus.business.floatchat.impl.component;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.asr.view.ChatSpeaker;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0015H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0017\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\u0013H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatSpeakerComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/business/floatchat/api/ability/IAIFloatChatSpeakerAbility;", "<init>", "()V", "chatFragmentCoreAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentCoreAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentCoreAbility$delegate", "Lkotlin/Lazy;", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "movedToOverlay", "", "overlayParent", "Landroid/view/ViewGroup;", "observedInputView", "Landroid/view/View;", "observedOverlayParent", "overlayLocation", "", "inputLocation", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "moveChatSpeakerToOverlayIfNeeded", "", "onFragmentViewDestroyed", "onDestroy", "applyOverlayClipPolicy", "speaker", "resolveOverlayParent", "bindInputLayoutListener", "bindOverlayLayoutListener", "targetParent", "clearLayoutListeners", "updateSpeakerBottomMargin", "calculateSpeakerBottomMargin", "", "(Landroid/view/ViewGroup;)Ljava/lang/Integer;", "createOverlayLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatSpeakerComponent extends Component implements ew8.c {
    public final Lazy l;
    public final Lazy m;
    public boolean n;
    public ViewGroup o;
    public View p;
    public ViewGroup q;
    public final int[] r;
    public final int[] s;
    public final h0 t;

    public static final class a implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
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

    public static final class b implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public final void A2() {
        View r0 = this.p;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.t);
    L5:
        this.p = null;
        ViewGroup r1 = this.q;
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(this.t);
    L8:
        this.q = null;
        this.n = false;
        this.o = null;
    }

    public final void N2() {
        if (this.n == true) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.m.getValue();
        if (r0 == null) goto L30;
        ChatSpeaker r1 = r0.jM();
        if (r1 == null) goto L32;
        ViewGroup r2 = this.o;
        ViewGroup.MarginLayoutParams r3 = null;
        if (r2 != null) goto L18;
        ViewParent r4 = r1.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L15;
        r2 = (ViewGroup) r4;
    L16:
        if (r2 != null) goto L18;
        return;
    L15:
        r2 = null;
    L18:
        Integer r5 = F2(r2);
        if (r5 == null) goto L31;
        int r6 = r5.intValue();
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r3 = (ViewGroup.MarginLayoutParams) r7;
    L23:
        if (r3 != null) goto L26;
        return;
    L26:
        if (r3.bottomMargin == r6) goto L28;
        r3.bottomMargin = r6;
        r1.setLayoutParams(r3);
    L28:
        r1.bringToFront();
        return;
    L31:
        return;
    L32:
        return;
    }

    public final void onDestroy() {
        View r0 = this.p;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.t);
    L5:
        this.p = null;
        ViewGroup r1 = this.q;
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(this.t);
    L8:
        this.q = null;
    }

    @Override // ew8.c
    public final void wH() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.m.getValue();
        if (r0 == null) goto L58;
        ChatSpeaker r1 = r0.jM();
        if (r1 == null) goto L59;
        ViewGroup r2 = this.o;
        ViewGroup r3 = null;
        if (r2 != null) goto L24;
        ViewParent r4 = r1.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L13;
        r2 = (ViewGroup) r4;
    L14:
        if (r2 == null) goto L16;
        ViewParent r5 = r2.getParent();
    L18:
        if ((r5 instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r5;
    L21:
        if (r6 == null) goto L24;
        r2 = r6;
        goto L24
    L20:
        r6 = null;
        goto L21
    L16:
        r5 = null;
        goto L18
    L13:
        r2 = null;
    L24:
        if (r2 != null) goto L26;
        return;
    L26:
        ViewParent r7 = r1.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L29;
        r3 = (ViewGroup) r7;
    L29:
        r1.setClipChildren(true);
        r1.setClipToPadding(true);
        if (r3 == r2) goto L35;
        if (r3 == null) goto L33;
        r3.removeView(r1);
    L33:
        r2.addView(r1, L2(r2));
    L37:
        this.o = r2;
        this.n = true;
        va8.m r8 = (va8.m) this.l.getValue();
        if (r8 == null) goto L50;
        va8.l r9 = r8.iX();
        if (r9 == null) goto L50;
        FrameLayout r10 = r9.getInput();
        if (r10 == null) goto L50;
        View r11 = this.p;
        if (r11 == r10) goto L50;
        if (r11 == null) goto L49;
        r11.removeOnLayoutChangeListener(this.t);
    L49:
        this.p = r10;
        r10.addOnLayoutChangeListener(this.t);
    L50:
        ViewGroup r12 = this.q;
        if (r12 == r2) goto L56;
        if (r12 == null) goto L55;
        r12.removeOnLayoutChangeListener(this.t);
    L55:
        this.q = r2;
        r2.addOnLayoutChangeListener(this.t);
    L56:
        N2();
        r1.post(new g0(this));
        r1.bringToFront();
        return;
    L35:
        if (this.n == true) goto L37;
        r1.setLayoutParams(L2(r2));
        goto L37
    L59:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.business.floatchat.impl.component.h0] */
    public AIFloatChatSpeakerComponent() {
        this.l = LazyKt.lazy(new a(this));
        this.m = LazyKt.lazy(new b(this));
        this.r = new int[2];
        this.s = new int[2];
        this.t = new h0(this);
    }

    public final Integer F2(ViewGroup r4) {
        va8.m r0 = (va8.m) this.l.getValue();
        if (r0 == null) goto L21;
        va8.l r1 = r0.iX();
        if (r1 == null) goto L23;
        FrameLayout r2 = r1.getInput();
        if (r2 != null) goto L10;
        return null;
    L10:
        if (r4.isAttachedToWindow() == true) goto L12;
        return null;
    L12:
        if (r2.isAttachedToWindow() == true) goto L15;
        return null;
    L15:
        if (r4.getHeight() > 0) goto L17;
        return null;
    L17:
        if (r2.getHeight() <= 0) goto L28;
        r4.getLocationOnScreen(this.r);
        r2.getLocationOnScreen(this.s);
        return Integer.valueOf(RangesKt.coerceAtLeast((this.r[1] + r4.getHeight()) - (this.s[1] + r2.getHeight()), 0));
    L28:
        return null;
    L23:
        return null;
    L21:
        return null;
    }

    public final ViewGroup.LayoutParams L2(ViewGroup r6) {
        Integer r0 = F2(r6);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L7:
        if ((r6 instanceof FrameLayout) == false) goto L10;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -2, 80);
        r7.bottomMargin = r1;
        return r7;
    L10:
        if ((r6 instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(-1, -2);
        r8.startToStart = 0;
        r8.endToEnd = 0;
        r8.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r8).bottomMargin = r1;
        return r8;
    L12:
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-1, -2);
        r9.bottomMargin = r1;
        return r9;
    L5:
        r1 = 0;
        goto L7
    }
}
