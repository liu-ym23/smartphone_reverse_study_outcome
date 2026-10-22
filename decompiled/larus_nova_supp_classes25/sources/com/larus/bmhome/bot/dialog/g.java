package com.larus.bmhome.bot.dialog;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ g(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function0 r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        int r1 = BotAvatarViewerDialog.y;
        if (r4 == false) goto L6;
        r0.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
