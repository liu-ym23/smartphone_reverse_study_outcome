package com.bytedance.ai.applet.grantingV2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 implements Function1<Throwable, Unit> {
    public final /* synthetic */ String a;

    public a0(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Throwable r11 = (Throwable) r10;
        com.bytedance.ai.utils.g.a.w("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus scope canceled for " + this.a);
        return Unit.INSTANCE;
    }
}
