package com.obric.assistant.chat;

import com.obric.assistant.component.ObricChatPageStateComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import laa.d;
import p1a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class r1 implements Function1 {
    public /* synthetic */ r1() {
    }

    public final Object invoke(Object r2) {
        j r3 = (j) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$widget");
        r3.a(Reflection.getOrCreateKotlinClass(d.class));
        return new ObricChatPageStateComponent();
    }
}
