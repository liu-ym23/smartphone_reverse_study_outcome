package com.larus.bmhome.chat.component.bottom.voice;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 implements c {
    public final c0 a;
    public final ViewGroup b;
    public VoiceMixInputPanel c;

    public final VoiceMixInputPanel e() {
        VoiceMixInputPanel r0 = this.c;
        if (r0 == null) goto L7;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("panel");
        goto L7
    L8:
        return r0;
    L7:
        return null;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void c() {
        VoiceMixInputPanel r0 = e();
        if (r0 == null) goto L7;
        TextView r1 = (TextView) r0.findViewById(2131363432);
        if (r1 == null) goto L7;
        e1.o(r1);
    L7:
        c0 r2 = this.a;
        if (r2 == null) goto L10;
        r2.c = false;
    L10:
        VoiceMixInputPanel r3 = e();
        if (r3 == null) goto L14;
        e1.o(r3);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void d() {
        VoiceMixInputPanel r0 = e();
        if (r0 == null) goto L7;
        TextView r1 = (TextView) r0.findViewById(2131363432);
        if (r1 == null) goto L7;
        e1.x(r1);
    L7:
        c0 r2 = this.a;
        if (r2 == null) goto L10;
        r2.c = true;
        r2.d = false;
    L10:
        VoiceMixInputPanel r3 = e();
        if (r3 == null) goto L14;
        e1.x(r3);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void a(int r5) {
        ViewGroup r0 = this.b;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        int r2 = 0;
        int r6 = RangesKt.coerceAtLeast(r5, 0);
        c0 r3 = this.a;
        if (r3 == null) goto L9;
        r2 = r3.e;
    L9:
        r1.height = RangesKt.coerceAtMost(r6, r2);
        r0.setLayoutParams(r1);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void b(boolean r2) {
        c0 r0 = this.a;
        if (r0 == null) goto L5;
        r0.d = r2;
    L5:
        c();
    }

    public final void f(b r8) {
        Intrinsics.checkNotNullParameter(r8, "dependency");
        if (this.b != null) goto L5;
        return;
    L5:
        int r1 = d0.d;
        d0.a.a("VoiceMixInputUIController: initController");
        e1.x(this.b);
        c0 r2 = this.a;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r8, "dependency");
        ChatConstraintLayout r0 = r2.a;
        if (r0 == null) goto L10;
        r0.setInterruptBottomPaddingUpdate(new b0(r8, r2));
    L10:
        Function1<? super Integer, Unit> r3 = new e0(this);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.f = r3;
    L11:
        VoiceMixInputPanel r4 = null;
        VoiceMixInputPanel r5 = new VoiceMixInputPanel(r8.getActivity(), null, 6, 0);
        e1.o(r5);
        this.c = r5;
        this.b.addView(r5, new FrameLayout.LayoutParams(-1, -1));
        de8.c r6 = r8.f1();
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L28;
        de8.c r9 = r8.f1();
        if (r9 == null) goto L29;
        Integer r10 = r9.m();
        if (r10 == null) goto L30;
        int r11 = r10.intValue();
        ViewGroup r12 = this.b;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setColors(new int[]{0, r11, r11, r11, r11, r11, r11, r11, r11, r11});
        r12.setBackground(r13);
        VoiceMixInputPanel r14 = this.c;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("panel");
    L26:
        r4.setImmersiveMode(r11);
        return;
    L25:
        r4 = r14;
        goto L26
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L14:
        if (r6.C() != true) goto L16;
        r7 = true;
        goto L17
    }

    public j0(c0 r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }
}
