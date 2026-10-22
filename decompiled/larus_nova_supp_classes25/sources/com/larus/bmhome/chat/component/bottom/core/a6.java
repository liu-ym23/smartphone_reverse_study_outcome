package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a6 implements Function1 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ EditText d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ Ref.BooleanRef f;
    public final /* synthetic */ a g;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 h;

    public /* synthetic */ a6(Ref.BooleanRef r1, CoreInputComponent r2, Ref.IntRef r3, EditText r4, Ref.ObjectRef r5, Ref.BooleanRef r6, a r7, com.larus.bmhome.chat.component.bottom.voice.d0 r8) {
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
        Ref.BooleanRef r0 = this.a;
        CoreInputComponent r1 = this.b;
        Ref.IntRef r2 = this.c;
        EditText r3 = this.d;
        Ref.ObjectRef r4 = this.e;
        Ref.BooleanRef r5 = this.f;
        a r6 = this.g;
        com.larus.bmhome.chat.component.bottom.voice.d0 r7 = this.h;
        int r8 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((View) r10, "it");
        r0.element = true;
        r1.G2 = false;
        r2.element = r3.length();
        r4.element = "click_button";
        r5.element = false;
        if (r6.Ef() != 3) goto L5;
        r1.k4().g2(2, true);
        ICoreInputAbility.b.b(r1.k4());
        r1.ra();
    L7:
        return Unit.INSTANCE;
    L5:
        r1.D6(r6, r7, r2.element, (String) r4.element);
        goto L7
    }
}
