package com.larus.voicecall.impl.component.bottom.more_btn;

import com.larus.voicecall.impl.scene.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ k a;
    public final /* synthetic */ m b;
    public final /* synthetic */ int c;

    public /* synthetic */ i(k r1, m r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        k r0 = this.a;
        m r1 = this.b;
        int r2 = this.c;
        com.larus.voicecall.impl.component.scene.a r3 = r0.k();
        if (r3 == null) goto L5;
        r3.R3(m.a(r1, 0, Integer.valueOf(r2), 27), r2);
    L5:
        Function1<c, Unit> r4 = r0.a.a();
        if (r4 == null) goto L8;
        r4.invoke(new MoreBtnSceneState(r0.a));
    L8:
        r0.f = null;
        return Unit.INSTANCE;
    }
}
