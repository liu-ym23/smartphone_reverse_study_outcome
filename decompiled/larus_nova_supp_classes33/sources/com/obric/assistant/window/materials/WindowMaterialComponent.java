package com.obric.assistant.window.materials;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import bia.e;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.util.f2;
import com.obric.oui.material.OMaterialHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import va8.m;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000200H\u0016J\b\u0010A\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020?H\u0002J\b\u0010E\u001a\u00020?H\u0002J\b\u0010F\u001a\u00020?H\u0002J\b\u0010G\u001a\u00020?H\u0002J\b\u0010H\u001a\u00020?H\u0002J\b\u0010I\u001a\u00020?H\u0002J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0019R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b9\u0010\u0019R\u001b\u0010;\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b<\u00102¨\u0006M"}, d2 = {"Lcom/obric/assistant/window/materials/WindowMaterialComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/chat/material/IObricWindowMaterialAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "inputAreaHostContainer", "getInputAreaHostContainer", "inputContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInputContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "suggestActionContainer", "Landroid/view/View;", "getSuggestActionContainer", "()Landroid/view/View;", "titleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "titleAbility$delegate", "ttsContainer", "getTtsContainer", "ttsContainer$delegate", "inputAreaContainerBg", "getInputAreaContainerBg", "inputAreaContainerBg$delegate", "onViewCreated", "", "view", "onResume", "shouldApplyMaterial", "", "setupViews", "setupInput", "setupTitleBar", "setupInputAreaContainer", "disableInputMaterialShadowClip", "setupSuggestActionContainer", "getChatInputReplyBackground", "Landroid/graphics/drawable/Drawable;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowMaterialComponent extends BaseContentWidget implements raa.a {
    public static final /* synthetic */ int v = 0;
    public int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;

    public static final class a {
    }

    public static final class b implements Function0<m> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(m.class));
        }
    }

    public static final class c implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class d implements Function0<ry8.b> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ry8.b.class));
        }
    }

    static {
    }

    public final void onResume() {
        FLogger r0 = FLogger.a;
        r0.i("WindowChatInputComponent", "onResume " + hashCode());
        if (s1a.a.e(this) == false) goto L9;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (OMaterialHelper.j(r1) == false) goto L9;
        if (OMaterialHelper.f() < 3) goto L9;
        boolean r2 = true;
    L10:
        r0.i("WindowChatInputComponent", "shouldApplyMaterial, " + r2);
        o r3 = (o) this.r.getValue();
        ConstraintLayout r4 = null;
        if (r3 == null) goto L13;
        com.larus.bmhome.chat.component.bottom.core.a r5 = r3.Uv();
    L14:
        if (r5 == null) goto L16;
        r4 = r5.h();
    L16:
        ConstraintLayout r6 = f2.a(r4);
        if (r6 == null) goto L23;
        if (r2 == false) goto L20;
        Drawable r7 = new ColorDrawable(0);
    L21:
        r6.setBackground(r7);
        return;
    L20:
        r7 = AppCompatResources.getDrawable(getContext(), 2131243302);
        goto L21
    L23:
        return;
    L13:
        r5 = null;
    L9:
        r2 = false;
        goto L10
    }

    public WindowMaterialComponent() {
        this.m = 2131365588;
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new bia.a(this));
        this.p = LazyKt.lazy(new bia.b(this));
        this.q = LazyKt.lazy(new bia.c(this));
        this.r = LazyKt.lazy(new c(this));
        this.s = LazyKt.lazy(new d(this));
        this.t = LazyKt.lazy(new bia.d(this));
        this.u = LazyKt.lazy(new e(this));
    }

    public final Drawable HD() {
        if (IWindowContextKt.isWindowContext(getContext()) == true) goto L17;
        o r0 = (o) this.r.getValue();
        if (r0 == null) goto L8;
        com.larus.bmhome.chat.component.bottom.core.a r1 = r0.Uv();
    L9:
        if (r1 == null) goto L11;
        ConstraintLayout r2 = r1.h();
    L13:
        if ((r2 instanceof ShadowLayout) == false) goto L16;
        return null;
    L16:
        return ContextCompat.getDrawable(getContext(), 2131240018);
    L11:
        r2 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    L17:
        return new ColorDrawable(0);
    }

    public final int U2() {
        return this.m;
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r6, "view");
        FLogger r7 = FLogger.a;
        r7.i("WindowChatInputComponent", "onViewCreated");
        r7.i("WindowChatInputComponent", "setupMaterials, isWindowHost = " + s1a.a.e(this));
        if (s1a.a.e(this) == false) goto L85;
        StringBuilder r1 = new StringBuilder("setupInputAreaContainer, inputContainer = ");
        o r2 = (o) this.r.getValue();
        View r3 = null;
        if (r2 == null) goto L7;
        com.larus.bmhome.chat.component.bottom.core.a r4 = r2.Uv();
    L8:
        if (r4 == null) goto L10;
        ConstraintLayout r5 = r4.h();
    L11:
        r1.append(f2.a(r5));
        r7.i("WindowChatInputComponent", r1.toString());
        View r8 = (ViewGroup) this.p.getValue();
        if (r8 != null) goto L14;
        r8 = (FrameLayout) this.q.getValue();
    L14:
        o r9 = (o) this.r.getValue();
        if (r9 == null) goto L17;
        com.larus.bmhome.chat.component.bottom.core.a r10 = r9.Uv();
    L18:
        if (r10 == null) goto L20;
        ConstraintLayout r11 = r10.h();
    L21:
        View r12 = f2.a(r11);
    L23:
        if (r12 == null) goto L36;
        if ((r12 instanceof ViewGroup) == false) goto L27;
        ViewGroup r13 = (ViewGroup) r12;
    L28:
        if (r13 == null) goto L30;
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
    L30:
        if (r12 == r8) goto L36;
        ConstraintLayout r14 = r12.getParent();
        if ((r14 instanceof View) == true) goto L34;
        r12 = null;
        goto L23
    L34:
        r12 = (View) r14;
        goto L23
    L27:
        r13 = null;
    L36:
        o r15 = (o) this.r.getValue();
        if (r15 == null) goto L39;
        com.larus.bmhome.chat.component.bottom.core.a r16 = r15.Uv();
    L40:
        if (r16 == null) goto L42;
        ConstraintLayout r17 = r16.h();
    L43:
        ConstraintLayout r18 = f2.a(r17);
        if (r18 == null) goto L46;
        r18.addView((View) this.u.getValue(), 0);
    L46:
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("setupSuggestActionContainer, suggestActionContainer = ");
        o r21 = (o) this.r.getValue();
        if (r21 == null) goto L49;
        com.larus.bmhome.chat.component.bottom.core.a r22 = r21.Uv();
    L50:
        if (r22 == null) goto L52;
        View r23 = r22.c();
    L53:
        r20.append(r23);
        r19.i("WindowChatInputComponent", r20.toString());
        o r24 = (o) this.r.getValue();
        if (r24 == null) goto L56;
        com.larus.bmhome.chat.component.bottom.core.a r25 = r24.Uv();
    L57:
        if (r25 == null) goto L59;
        View r26 = r25.c();
    L60:
        if (r26 == null) goto L74;
        Drawable r27 = r26.getBackground();
        if (r27 == null) goto L74;
        if ((r27 instanceof GradientDrawable) == false) goto L66;
        ((GradientDrawable) r27).setColor(0);
        goto L74
    L66:
        o r28 = (o) this.r.getValue();
        if (r28 == null) goto L69;
        com.larus.bmhome.chat.component.bottom.core.a r29 = r28.Uv();
    L70:
        if (r29 == null) goto L72;
        r3 = r29.c();
    L72:
        if (r3 == null) goto L74;
        r3.setBackground(new ColorDrawable(0));
        goto L74
    L69:
        r29 = null;
    L74:
        ViewGroup r30 = (ViewGroup) this.t.getValue();
        if (r30 == null) goto L86;
        r30.setClipChildren(false);
        r30.setClipToPadding(false);
        return;
    L86:
        return;
    L59:
        r26 = null;
        goto L60
    L56:
        r25 = null;
        goto L57
    L52:
        r23 = null;
        goto L53
    L49:
        r22 = null;
        goto L50
    L42:
        r17 = null;
        goto L43
    L39:
        r16 = null;
        goto L40
    L20:
        r11 = null;
        goto L21
    L17:
        r10 = null;
        goto L18
    L10:
        r5 = null;
        goto L11
    L7:
        r4 = null;
        goto L8
    }
}
