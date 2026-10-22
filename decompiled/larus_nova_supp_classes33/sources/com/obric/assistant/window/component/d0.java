package com.obric.assistant.window.component;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 implements IWindowAnimator {
    public fja.d a;
    public final /* synthetic */ WindowAnimationComponent b;
    public final /* synthetic */ WindowAnimationType c;
    public final /* synthetic */ boolean d;

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void cancel() {
        FLogger.a.i("WindowAnimationComponent", "window chat root cancel " + this.c);
        this.b.n = false;
        fja.d r0 = this.a;
        if (r0 == null) goto L6;
        int r2 = fja.d.d;
        r0.a(false);
        return;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
    public final void start(final Function1<? super Boolean, Unit> r20) {
        Intrinsics.checkNotNullParameter(r20, "onEnd");
        laa.d r0 = (laa.d) this.b.i.getValue();
        if (r0 == null) goto L5;
        ObricFloatChatPageState r1 = r0.getPageState();
    L6:
        FLogger r2 = FLogger.a;
        r2.i("WindowAnimationComponent", "window chat root start " + this.c + ", pageState=" + r1);
        final ViewGroup r3 = (ViewGroup) this.b.m.getValue();
        boolean r4 = false;
        if (r3 != null) goto L10;
        WindowAnimationComponent r5 = this.b;
        r2.w("WindowAnimationComponent", "chatRoot is null");
        r20.invoke(Boolean.TRUE);
        r5.n = false;
        return;
    L10:
        this.b.getClass();
        IAssistantChatWindow r6 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r6 == null) goto L16;
        WindowLayoutInfo r7 = r6.getWindowLayoutInfo();
        if (r7 == null) goto L16;
        boolean r8 = r7.isLandscapeWindowLayout();
    L17:
        float r9 = 0.0f;
        if (r8 == false) goto L21;
        r2.i("WindowAnimationComponent", "window chat root skip landscape slide");
        r3.setAlpha(1.0f);
        r3.setTranslationY(0.0f);
        this.b.n = false;
        r20.invoke(Boolean.TRUE);
        return;
    L21:
        laa.d r10 = (laa.d) this.b.i.getValue();
        if (r10 == null) goto L24;
        final int r11 = r10.mb();
    L26:
        if (this.d == false) goto L28;
        int r12 = 0;
    L29:
        int r13 = r12 + r11;
        r2.i("WindowAnimationComponent", "dismissTranslation is " + r13);
        boolean r14 = this.d;
        if (r14 == false) goto L32;
        float r15 = r13;
    L33:
        if (r14 == true) goto L36;
        r9 = r13;
    L36:
        r3.setAlpha(1.0f);
        r3.setTranslationY(r15);
        final long r16 = SystemClock.elapsedRealtime();
        final Ref.BooleanRef r17 = new Ref.BooleanRef();
        final Ref.BooleanRef r18 = new Ref.BooleanRef();
        com.obric.common.oea.foundation.animation.builder.b.a r19 = com.obric.common.oea.foundation.animation.builder.c.a(r3);
        AnimationProperty$FloatProperty r21 = AnimationProperty$FloatProperty.TRANSLATION_Y;
        Float r22 = Float.valueOf(r15);
        if (this.d == false) goto L48;
        ObricFloatChatPageData.Companion.getClass();
        if ((r1 instanceof vda.a) == true) goto L47;
        if (r1 == null) goto L44;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof com.obric.assistant.data.a) != true) goto L44;
        r4 = true;
    L44:
        if (r4 == true) goto L47;
        r2.i("WindowAnimationComponent", "window chat root show use smooth animation");
        com.obric.common.oea.foundation.animation.spec.spring.b r23 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
    L49:
        com.obric.common.oea.foundation.animation.builder.b.a.c(r19, r21, r22, r9, r23);
        final WindowAnimationType r24 = this.c;
        final boolean r25 = this.d;
        final WindowAnimationComponent r26 = this.b;
        Function3<? super String, Object, Object, Unit> r110 = new b0(r17, r3, r24, r16, r25, r18, r11, r26, this, r20);
        Intrinsics.checkNotNullParameter(r110, "callback");
        r19.d = r110;
        final WindowAnimationType r27 = this.c;
        final WindowAnimationComponent r28 = this.b;
        Function2<? super Boolean, ? super Throwable, Unit> r29 = new c0(r27, r16, r20, r18, r28);
        Intrinsics.checkNotNullParameter(r29, "callback");
        r19.e = r29;
        this.a = com.obric.common.oea.foundation.animation.builder.b.a(r19.a());
        this.b.n = true;
        return;
    L47:
        r2.i("WindowAnimationComponent", "window chat root show use snappy animation");
        r23 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
        goto L49
    L48:
        r23 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
        goto L49
    L32:
        r15 = 0.0f;
        goto L33
    L28:
        r12 = i5.q();
        goto L29
    L24:
        r11 = 0;
    L16:
        r8 = false;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public d0(WindowAnimationComponent r1, WindowAnimationType r2, boolean r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
