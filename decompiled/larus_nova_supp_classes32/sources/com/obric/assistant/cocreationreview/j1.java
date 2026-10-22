package com.obric.assistant.cocreationreview;

import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j1 implements Function0 {
    public final /* synthetic */ CocreationReviewActivity a;
    public final /* synthetic */ a b;
    public final /* synthetic */ Vote c;

    public /* synthetic */ j1(CocreationReviewActivity r1, a r2, Vote r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        CocreationReviewActivity r0 = this.a;
        a r1 = this.b;
        Vote r2 = this.c;
        Set<String> r3 = CocreationReviewActivity.P1;
        r0.D2(r1, r2);
        return Unit.INSTANCE;
    }
}
