package com.larus.asr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.utils.CubicBezierInterpolator;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u001f\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\rH\u0014J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0010J\b\u00101\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020\r2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\nH\u0014J8\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00102\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\b\u0010<\u001a\u00020\nH\u0014J\b\u0010=\u001a\u00020\nH\u0014J\b\u0010>\u001a\u00020\nH\u0014J\b\u0010?\u001a\u00020\nH\u0014J\b\u0010@\u001a\u00020\nH\u0014J\u0012\u0010A\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u000109H\u0014J\b\u0010C\u001a\u00020\rH\u0016J\u001c\u0010D\u001a\u00020\u00102\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010E\u001a\u00020\rH\u0014J\b\u0010F\u001a\u0004\u0018\u00010GR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RE\u0010\u0018\u001a-\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006H"}, d2 = {"Lcom/larus/asr/view/OChatSpeaker;", "Lcom/larus/asr/view/ChatSpeaker;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onAttachedToWindow", "", "onVisibilityChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "getOnVisibilityChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "shouldCancelCallback", "Lkotlin/Pair;", "", "xy", "getShouldCancelCallback", "setShouldCancelCallback", "value", "Lcom/obric/assistant/ability/audio/ChatSpeakerResCallback;", "resCallback", "getResCallback", "()Lcom/obric/assistant/ability/audio/ChatSpeakerResCallback;", "setResCallback", "(Lcom/obric/assistant/ability/audio/ChatSpeakerResCallback;)V", "initSpeakerBlurMode", "isImmerse", "bgColor", "(ZLjava/lang/Integer;)V", "initAudioVisualizer", "setAudioData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "changeChatStyle", "chatWindowStyle", "showAudioRealStartVisAnim", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "switchStatus", "toCancel", "tipsOnRecord", "", "fromVisibleChange", "globalTouchPos", "getShadowRes", "getNormalRes", "getCancelRes", "getTipsColor", "getTipsCancelColor", "getNormalTips", "tips", "disableAudioVisAnimStepByStep", "shouldCancel", "showAudioVisAnim", "getAudioVisualizer", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OChatSpeaker extends ChatSpeaker {
    public Function1<? super Boolean, Unit> U;
    public Function1<? super Pair<Float, Float>, Boolean> V;
    public maa.b W;

    public final void b6() {
        setStepAudioVisAnim(false);
    }

    public final void r7(boolean r1, Integer r2) {
    }

    public final void G8() {
        maa.b r0 = this.W;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        super.G8();
        return;
    L10:
        return;
    L5:
        if (r0.B0() != true) goto L7;
        r1 = true;
        goto L7
    }

    public int getCancelRes() {
        maa.b r0 = this.W;
        if (r0 == null) goto L6;
        return r0.k0();
    L6:
        return super.getCancelRes();
    }

    public int getNormalRes() {
        maa.b r0 = this.W;
        if (r0 == null) goto L6;
        return r0.T0();
    L6:
        return super.getNormalRes();
    }

    public int getShadowRes() {
        maa.b r0 = this.W;
        if (r0 == null) goto L6;
        return r0.Z1();
    L6:
        return super.getShadowRes();
    }

    public int getTipsCancelColor() {
        maa.b r0 = this.W;
        if (r0 == null) goto L6;
        return r0.v0();
    L6:
        return super.getTipsCancelColor();
    }

    public int getTipsColor() {
        maa.b r0 = this.W;
        if (r0 == null) goto L6;
        return r0.g1();
    L6:
        return super.getTipsColor();
    }

    public final void E8() {
        LarusWidgetSpeakerBinding r0 = getBinding();
        if (r0 == null) goto L9;
        FrameLayout r1 = r0.b;
        if (r1 == null) goto L9;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L9;
        r2.setDuration(120);
        r2.alpha(1.0f);
        r2.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r2.start();
    L9:
        LarusWidgetSpeakerBinding r3 = getBinding();
        if (r3 == null) goto L12;
        BlurCircleWithAmplitude r4 = r3.f;
    L13:
        J7(r4);
        return;
    L12:
        r4 = null;
        goto L13
    }

    public final iga.a getAudioVisualizer() {
        LarusWidgetSpeakerBinding r0 = getBinding();
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.b;
        if (r1 == null) goto L7;
        View r2 = r1.getChildAt(0);
    L9:
        if ((r2 instanceof iga.a) == true) goto L11;
        return null;
    L11:
        return (iga.a) r2;
    L7:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l7() {
        super.l7();
        IObricChatUIService r0 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r0 == null) goto L5;
        View r1 = r0.v(getContext());
    L6:
        if (r1 == null) goto L18;
        LarusWidgetSpeakerBinding r2 = getBinding();
        if (r2 == null) goto L12;
        FrameLayout r3 = r2.b;
        if (r3 == null) goto L12;
        r3.removeAllViews();
    L12:
        LarusWidgetSpeakerBinding r4 = getBinding();
        if (r4 == null) goto L19;
        FrameLayout r5 = r4.b;
        if (r5 == null) goto L20;
        r5.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Function1<Boolean, Unit> getOnVisibilityChangeCallback() {
        return this.U;
    }

    public final maa.b getResCallback() {
        return this.W;
    }

    public final Function1<Pair<Float, Float>, Boolean> getShouldCancelCallback() {
        return this.V;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public OChatSpeaker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void c9(boolean r6) {
        LarusWidgetSpeakerBinding r0 = getBinding();
        if (r0 == null) goto L20;
        FrameLayout r1 = r0.b;
        if (getUseSubscribedColor() == false) goto L7;
        int r2 = v19.c.b(2130970557, null, 2131238624);
    L8:
        r1.setBackgroundResource(r2);
        int r3 = 0;
        AudioVisualizerOpt r4 = r0.b.getChildAt(0);
        if ((r4 instanceof AudioVisualizerOpt) == false) goto L18;
        AudioVisualizerOpt r5 = r4;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
        if (r6 == false) goto L13;
        int r9 = i5.b();
    L14:
        r8.leftMargin = r9;
        if (r6 == false) goto L17;
        r3 = i5.b();
    L17:
        r8.rightMargin = r3;
        r5.setLayoutParams(r8);
        goto L18
    L13:
        r9 = 0;
    L18:
        r0.e.setBackgroundResource(getShadowRes());
        r0.p.setTextColor(getTipsColor());
        return;
    L7:
        r2 = getNormalRes();
        goto L8
    }

    public final boolean i8(Pair<Float, Float> r2) {
        Intrinsics.checkNotNullParameter(r2, "xy");
        Function1<? super Pair<Float, Float>, Boolean> r0 = this.V;
        if (r0 == null) goto L8;
        Boolean r1 = (Boolean) r0.invoke(r2);
        if (r1 == null) goto L8;
        return r1.booleanValue();
    L8:
        return super.i8(r2);
    }

    public final String s6(String r2) {
        maa.b r0 = this.W;
        if (r0 == null) goto L7;
        String r1 = r0.Z(r2);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return super.s6(r2);
    }

    public final void setOnVisibilityChangeCallback(Function1<? super Boolean, Unit> r1) {
        this.U = r1;
    }

    public final void setResCallback(maa.b r2) {
        this.W = r2;
        if (r2 == null) goto L10;
        LarusWidgetSpeakerBinding r0 = getBinding();
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.b;
    L8:
        r2.J0(r1);
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void setShouldCancelCallback(Function1<? super Pair<Float, Float>, Boolean> r1) {
        this.V = r1;
    }

    public OChatSpeaker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final void d8(CoroutineScope r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "it");
        super.d8(r2, r3);
        LarusWidgetSpeakerBinding r4 = getBinding();
        if (r4 == null) goto L7;
        FrameLayout r5 = r4.b;
        if (r5 == null) goto L7;
        View r6 = r5.getChildAt(0);
    L9:
        if ((r6 instanceof iga.a) == false) goto L12;
        ((iga.a) r6).setAudioData(r3);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "changedView");
        boolean r1 = false;
        if (r10.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        ChatSpeaker.N8(this, false, null, true, null, 10);
    L8:
        super.onVisibilityChanged(r10, r11);
        if (Intrinsics.areEqual(r10, this) == false) goto L20;
        Function1<? super Boolean, Unit> r12 = this.U;
        if (r12 != null) goto L13;
    L17:
        iga.a r13 = getAudioVisualizer();
        if (r13 == null) goto L20;
        r13.a();
        goto L20
    L13:
        if (r10.getVisibility() != 0) goto L15;
        boolean r14 = true;
    L16:
        r12.invoke(Boolean.valueOf(r14));
        goto L17
    L15:
        r14 = false;
    L20:
        maa.b r15 = this.W;
        if (r15 != null) goto L23;
        return;
    L23:
        if (getVisibility() != 0) goto L25;
        r1 = true;
    L25:
        r15.l(r1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public OChatSpeaker(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void H8(boolean r1, String r2, boolean r3, Pair<Float, Float> r4) {
        super.H8(r1, r2, r3, r4);
        LarusWidgetSpeakerBinding r5 = getBinding();
        if (r5 == null) goto L7;
        ImageView r6 = r5.e;
        if (r6 == null) goto L7;
        r6.setBackgroundResource(getShadowRes());
    L7:
        LarusWidgetSpeakerBinding r7 = getBinding();
        if (r7 == null) goto L14;
        ImageView r8 = r7.d;
        if (r8 == null) goto L14;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L14;
        r9.height = i5.i();
    L14:
        maa.b r10 = this.W;
        if (r10 == null) goto L21;
        LarusWidgetSpeakerBinding r11 = getBinding();
        if (r11 == null) goto L19;
        FrameLayout r12 = r11.b;
    L20:
        r10.r0(r12, r1);
        goto L21
    L19:
        r12 = null;
    L21:
        maa.b r13 = this.W;
        if (r13 != null) goto L24;
        return;
    L24:
        if (r13.X0(r1) == false) goto L35;
        LarusWidgetSpeakerBinding r14 = getBinding();
        if (r14 == null) goto L30;
        TextView r15 = r14.p;
        if (r15 == null) goto L30;
        com.larus.utils.e1.o(r15);
    L30:
        LarusWidgetSpeakerBinding r16 = getBinding();
        if (r16 == null) goto L47;
        ImageView r17 = r16.e;
        if (r17 == null) goto L48;
        com.larus.utils.e1.o(r17);
        return;
    L48:
        return;
    L47:
        return;
    L35:
        LarusWidgetSpeakerBinding r19 = getBinding();
        if (r19 == null) goto L40;
        TextView r20 = r19.p;
        if (r20 == null) goto L40;
        com.larus.utils.e1.x(r20);
    L40:
        LarusWidgetSpeakerBinding r21 = getBinding();
        if (r21 == null) goto L50;
        ImageView r22 = r21.e;
        if (r22 == null) goto L51;
        com.larus.utils.e1.x(r22);
        return;
    L51:
        return;
    }
}
