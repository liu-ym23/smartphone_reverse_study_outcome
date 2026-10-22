package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ h(j r1, String r2, k r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r5) {
        j r0 = this.a;
        String r1 = this.b;
        Function1 r2 = this.c;
        com.larus.bmhome.taskskill.service.k r6 = (com.larus.bmhome.taskskill.service.k) r5;
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof com.larus.bmhome.taskskill.service.k.h) == false) goto L5;
        r0.e = null;
        r0.c(r1, false);
    L5:
        r2.invoke(r6);
        return Unit.INSTANCE;
    }
}
