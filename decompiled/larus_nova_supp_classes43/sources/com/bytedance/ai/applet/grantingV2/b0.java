package com.bytedance.ai.applet.grantingV2;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 implements Function2<Boolean, String, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

    public b0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11) {
        boolean r12 = ((Boolean) r10).booleanValue();
        String r13 = (String) r11;
        if (this.a.isActive() == false) goto L9;
        if (r13 != null) goto L7;
        com.bytedance.ai.utils.g.a.i("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus callback: " + r12);
        this.a.resumeWith(Result.constructor-impl(Boolean.valueOf(r12)));
        goto L9
    L7:
        com.bytedance.ai.utils.g.a.e("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus callback error: ".concat(r13));
        kotlinx.coroutines.i<Boolean> r14 = this.a;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.constructor-impl(Boolean.FALSE));
    L9:
        return Unit.INSTANCE;
    }
}
