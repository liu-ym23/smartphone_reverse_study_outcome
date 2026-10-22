package com.obric.assistant.chat.component.bottom.core;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ ObricChatInputComponent a;

    public /* synthetic */ g(ObricChatInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ObricChatInputComponent r0 = this.a;
        if (((Boolean) r2).booleanValue() == true) goto L5;
    L9:
        boolean r3 = false;
    L10:
        r0.H = r3;
        return Unit.INSTANCE;
    L5:
        if (r0.F <= 0) goto L9;
        if (ObricChatInputComponent.Q3((RecyclerView) r0.B.getValue()) == false) goto L9;
        r3 = true;
        goto L10
    }
}
