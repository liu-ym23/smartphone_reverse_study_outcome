package com.larus.asr;

import android.view.View;
import android.view.ViewGroup;
import com.larus.asr.view.ChatSpeaker;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class n1 implements Function1 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.IntRef c;

    public /* synthetic */ n1(ChatBottomSpeakerComponent r1, Ref.IntRef r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r11) {
        ChatBottomSpeakerComponent r0 = this.a;
        Ref.IntRef r1 = this.b;
        Ref.IntRef r2 = this.c;
        boolean r12 = ((Boolean) r11).booleanValue();
        Set r3 = ChatBottomSpeakerComponent.F2;
        FLogger.a.i("ChatBottomSpeakerComponent", "onBlurVisibilityChanged: " + r12);
        ChatSpeaker r4 = r0.a4();
        if (r4 == null) goto L83;
        boolean r5 = true;
        int r6 = 0;
        ViewGroup.MarginLayoutParams r7 = null;
        if (r12 == false) goto L24;
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L11:
        if (r9 == null) goto L13;
        int r10 = r9.bottomMargin;
    L14:
        Integer r13 = Integer.valueOf(r10);
        if (r13.intValue() <= 0) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == true) goto L21;
        r13 = null;
    L21:
        if (r13 == null) goto L24;
        r1.element = r13.intValue();
        goto L24
    L17:
        r14 = false;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L10:
        r9 = null;
    L24:
        if (r1.element == (-1)) goto L84;
        ViewGroup.LayoutParams r15 = r4.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L30:
        if (r16 == null) goto L36;
        if (r12 == false) goto L33;
        int r17 = 0;
    L34:
        r16.bottomMargin = r17;
        r4.setLayoutParams(r16);
        goto L36
    L33:
        r17 = r1.element;
    L36:
        if (com.larus.platform.service.z2.a.enableAsrInputViewMarginFix() == true) goto L82;
        ChatSpeaker r19 = r0.a4();
        if (r19 == null) goto L40;
        Object r20 = r19.getParent();
    L42:
        if ((r20 instanceof View) == false) goto L44;
        View r21 = (View) r20;
    L45:
        if (r21 == null) goto L86;
        View r22 = r21.findViewById(2131375324);
        if (r22 == null) goto L86;
        if (r12 == false) goto L67;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L53;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
    L54:
        if (r24 == null) goto L56;
        int r25 = r24.bottomMargin;
    L57:
        Integer r26 = Integer.valueOf(r25);
        if (r26.intValue() > 0) goto L61;
        r5 = false;
    L61:
        if (r5 == true) goto L64;
        r26 = null;
    L64:
        if (r26 == null) goto L67;
        r2.element = r26.intValue();
        goto L67
    L56:
        r25 = 0;
        goto L57
    L53:
        r24 = null;
    L67:
        if (r2.element == (-1)) goto L85;
        ViewGroup.LayoutParams r27 = r22.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L72;
        r7 = (ViewGroup.MarginLayoutParams) r27;
    L72:
        if (r7 == null) goto L77;
        if (r12 == false) goto L75;
        int r29 = 0;
    L76:
        r7.bottomMargin = r29;
        r22.setLayoutParams(r7);
        goto L77
    L75:
        r29 = r2.element;
    L77:
        if (r12 == false) goto L79;
        r6 = r2.element;
    L79:
        r22.setPadding(r22.getPaddingLeft(), r22.getPaddingTop(), r22.getPaddingRight(), r6);
        goto L82
    L85:
        return Unit.INSTANCE;
    L86:
        return Unit.INSTANCE;
    L44:
        r21 = null;
        goto L45
    L40:
        r20 = null;
    L82:
        return Unit.INSTANCE;
    L29:
        r16 = null;
        goto L30
    L84:
        return Unit.INSTANCE;
    L83:
        return Unit.INSTANCE;
    }
}
