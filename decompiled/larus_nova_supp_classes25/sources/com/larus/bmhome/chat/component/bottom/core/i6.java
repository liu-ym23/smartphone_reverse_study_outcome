package com.larus.bmhome.chat.component.bottom.core;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ LarusWidgetInputBinding b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ a e;
    public final /* synthetic */ Ref.ObjectRef f;

    public /* synthetic */ i6(CoreInputComponent r1, LarusWidgetInputBinding r2, Ref.BooleanRef r3, Ref.BooleanRef r4, a r5, Ref.ObjectRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r14) {
        CoreInputComponent r0 = this.a;
        LarusWidgetInputBinding r1 = this.b;
        Ref.BooleanRef r2 = this.c;
        Ref.BooleanRef r3 = this.d;
        a r4 = this.e;
        Ref.ObjectRef r5 = this.f;
        MotionEvent r15 = (MotionEvent) r14;
        int r6 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r15, "it");
        if (r15.getAction() != 0) goto L73;
        View r7 = r0.F2().findViewById(2131367924);
        Rect r8 = new Rect();
        r1.t.getGlobalVisibleRect(r8);
        boolean r9 = false;
        if (r8.contains((int) r15.getRawX(), (int) r15.getRawY()) == true) goto L8;
    L13:
        boolean r10 = false;
    L14:
        if (r7 == null) goto L23;
        Rect r11 = new Rect();
        r7.getGlobalVisibleRect(r11);
        if (r11.contains((int) r15.getRawX(), (int) r15.getRawY()) == false) goto L23;
        if (r7.getVisibility() != 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L23;
        boolean r13 = true;
    L24:
        Rect r16 = new Rect();
        r1.m.getGlobalVisibleRect(r16);
        if (r16.contains((int) r15.getRawX(), (int) r15.getRawY()) == true) goto L27;
    L32:
        boolean r17 = false;
    L33:
        Rect r18 = new Rect();
        r1.k.getGlobalVisibleRect(r18);
        if (r18.contains((int) r15.getRawX(), (int) r15.getRawY()) == true) goto L36;
    L41:
        boolean r19 = false;
    L42:
        if (r19 == false) goto L45;
        if (r10 == true) goto L45;
        boolean r110 = true;
    L46:
        if (r17 == false) goto L50;
        if (r10 == true) goto L50;
        if (r110 == true) goto L50;
        boolean r111 = true;
    L51:
        if (r10 == false) goto L53;
        r2.element = true;
        r0.k4().k0();
        r0.k4().p0();
        r1.t.performClick();
    L53:
        if (r110 == false) goto L55;
        r1.k.performClick();
    L55:
        if (r111 == false) goto L57;
        r1.m.performClick();
    L57:
        if (r110 == true) goto L64;
        if (r10 == true) goto L65;
        if (r111 == true) goto L65;
        if (r4.Ef() != 2) goto L64;
    L65:
        r3.element = r9;
        if (r10 == false) goto L68;
        String r112 = "send_button_click";
    L71:
        r5.element = r112;
        r4.ql(!r10, r9);
        goto L73
    L68:
        if (r13 == false) goto L70;
        r112 = "stop_icon_click";
        goto L71
    L70:
        r112 = "click_screen";
    L64:
        r9 = true;
    L50:
        r111 = false;
    L45:
        r110 = false;
        goto L46
    L36:
        if (r1.k.getVisibility() != 0) goto L38;
        boolean r113 = true;
    L39:
        if (r113 == false) goto L41;
        r19 = true;
        goto L42
    L38:
        r113 = false;
        goto L39
    L27:
        if (r1.m.getVisibility() != 0) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == false) goto L32;
        r17 = true;
        goto L33
    L29:
        r114 = false;
        goto L30
    L20:
        r12 = false;
    L23:
        r13 = false;
        goto L24
    L8:
        if (r1.t.getVisibility() != 0) goto L10;
        boolean r20 = true;
    L11:
        if (r20 == false) goto L13;
        r10 = true;
        goto L14
    L10:
        r20 = false;
    L73:
        return Boolean.TRUE;
    }
}
