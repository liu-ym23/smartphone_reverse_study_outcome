package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import android.widget.TextView;
import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h6 implements Function1 {
    public final /* synthetic */ a a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ CoreInputComponent c;
    public final /* synthetic */ EditText d;
    public final /* synthetic */ Ref.IntRef e;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 f;
    public final /* synthetic */ Ref.ObjectRef g;
    public final /* synthetic */ Ref.ObjectRef h;

    public /* synthetic */ h6(a r1, Ref.BooleanRef r2, CoreInputComponent r3, EditText r4, Ref.IntRef r5, com.larus.bmhome.chat.component.bottom.voice.d0 r6, Ref.ObjectRef r7, Ref.ObjectRef r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final Object invoke(Object r10) {
        a r0 = this.a;
        Ref.BooleanRef r1 = this.b;
        CoreInputComponent r2 = this.c;
        EditText r3 = this.d;
        Ref.IntRef r4 = this.e;
        com.larus.bmhome.chat.component.bottom.voice.d0 r5 = this.f;
        Ref.ObjectRef r6 = this.g;
        Ref.ObjectRef r7 = this.h;
        com.larus.bmhome.chat.component.bottom.voice.service.h r11 = (com.larus.bmhome.chat.component.bottom.voice.service.h) r10;
        int r8 = CoreInputComponent.d3;
        if (r11 != null) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r0.DG() == false) goto L8;
    L10:
        CharSequence r9 = r11.a;
        if (r11.b == false) goto L13;
        r2.k4().Yk(r9);
    L15:
        if (r0.DG() == true) goto L18;
        int r12 = RangesKt.coerceAtLeast(r11.a.length() - r4.element, 0);
        com.larus.bmhome.chat.component.bottom.voice.d0.e(r5, r4.element, r12, (String) r6.element, (String) r7.element);
        r2.k4().k0();
    L18:
        return Unit.INSTANCE;
    L13:
        r3.setText(r9, TextView.BufferType.SPANNABLE);
        r3.setSelection(r11.a.length());
        goto L15
    L8:
        if (r1.element == false) goto L10;
        int r13 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("observeTextStream isClickSendButton is true, so clear text");
        r2.k4().p80(true);
        return Unit.INSTANCE;
    }
}
