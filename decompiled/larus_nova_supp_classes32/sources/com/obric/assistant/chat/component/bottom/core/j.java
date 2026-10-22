package com.obric.assistant.chat.component.bottom.core;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j implements Function2 {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ ObricChatInputComponent b;
    public final /* synthetic */ ChatConstraintLayout c;

    public /* synthetic */ j(Function2 r1, ObricChatInputComponent r2, ChatConstraintLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8, Object r9) {
        Function2 r0 = this.a;
        ObricChatInputComponent r1 = this.b;
        ChatConstraintLayout r2 = this.c;
        int r10 = ((Integer) r8).intValue();
        String r11 = (String) r9;
        int r3 = ObricChatInputComponent.L0;
        Intrinsics.checkNotNullParameter(r11, "source");
        if (((Boolean) r0.invoke(Integer.valueOf(r10), r11)).booleanValue() == true) goto L28;
        FLogger r4 = FLogger.a;
        r4.i("ConfigCoreInputComponent", "interruptBottomPaddingUpdate, bottomPadding: " + r10 + ", source: " + r11);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "chatRoot");
        r4.i("ConfigCoreInputComponent", "updateInputBottomMargin, bottomPadding: " + r10 + ", isWindowHost: " + s1a.a.e(r1));
        if (s1a.a.e(r1) == true) goto L8;
        r4.i("ConfigCoreInputComponent", "updateInputBottomMargin, is not window");
    L26:
        String r12 = "ObricChatInputComponent#" + r11;
        int r13 = r2.getPaddingStart();
        int r5 = r2.getPaddingTop();
        int r6 = r2.getPaddingEnd();
        r4.i("updatePaddingRelative", "view:" + r2.getClass().getSimpleName() + ",source:" + r12 + ",start:" + r13 + ",top:" + r5 + ",end:" + r6 + ",bottom:0");
        r2.setPaddingRelative(r13, r5, r6, 0);
        goto L28
    L8:
        int r14 = RangesKt.coerceAtLeast(r10, 56);
        FrameLayout r7 = r1.X2();
        if (r7 != null) goto L11;
    L25:
        r1.p4(r14);
        goto L26
    L11:
        if ((r7.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.LayoutParams r15 = r7.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L16:
        if (r16 == null) goto L18;
        int r17 = r16.bottomMargin;
    L19:
        if (r17 == r14) goto L25;
        ViewGroup.LayoutParams r18 = r7.getLayoutParams();
        if (r18 == null) goto L24;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.bottomMargin = r14;
        r7.setLayoutParams(r19);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        r17 = 0;
        goto L19
    L15:
        r16 = null;
    L28:
        return Boolean.TRUE;
    }
}
