package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ a c;

    public /* synthetic */ z5(CoreInputComponent r1, Ref.ObjectRef r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        CoreInputComponent r0 = this.a;
        Ref.ObjectRef r1 = this.b;
        a r2 = this.c;
        String r7 = (String) r6;
        int r3 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r7, "endMethodParams");
        int r4 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("[streamVoiceMixInputEndBlock] invoke, endMethodParams = " + r7);
        r0.G2 = true;
        r0.C6();
        r1.element = r7;
        a.C0054a.a(r2, 1);
        return Unit.INSTANCE;
    }
}
