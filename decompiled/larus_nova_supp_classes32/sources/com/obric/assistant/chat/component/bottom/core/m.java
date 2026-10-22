package com.obric.assistant.chat.component.bottom.core;

import ada.d;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class m implements Function2 {
    public final /* synthetic */ d a;
    public final /* synthetic */ ObricChatInputComponent b;
    public final /* synthetic */ ICoreInputAbility c;

    public /* synthetic */ m(d r1, ObricChatInputComponent r2, ICoreInputAbility r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r5, Object r6) {
        d r0 = this.a;
        ObricChatInputComponent r1 = this.b;
        ICoreInputAbility r2 = this.c;
        int r7 = ((Integer) r5).intValue();
        String r8 = (String) r6;
        int r3 = ObricChatInputComponent.L0;
        Intrinsics.checkNotNullParameter(r8, "clickFrom");
        if (Intrinsics.areEqual(r8, "input_left_icon") == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L16;
        z8.c r9 = r1.M;
        if (r9 == null) goto L14;
        Function2 r10 = r9.a;
        if (r10 == null) goto L14;
        r10.invoke(Integer.valueOf(r7), r8);
    L14:
        r2.zk(r8);
    L16:
        return Unit.INSTANCE;
    L5:
        if (r0.qL(r8) == false) goto L7;
        r4 = true;
        goto L8
    }
}
