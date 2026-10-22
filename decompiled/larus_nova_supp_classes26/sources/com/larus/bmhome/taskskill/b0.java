package com.larus.bmhome.taskskill;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import ld8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b0 implements Function1 {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ SkillComponent b;

    public /* synthetic */ b0(Ref.IntRef r1, SkillComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Ref.IntRef r0 = this.a;
        SkillComponent r1 = this.b;
        int r5 = ((Integer) r4).intValue();
        Regex r2 = SkillComponent.F2;
        int r6 = -r5;
        int r3 = r6 - r0.element;
        if (r3 == 0) goto L9;
        n r7 = (n) r1.D.getValue();
        if (r7 == null) goto L7;
        r7.e2(r3);
    L7:
        r0.element = r6;
    L9:
        return Unit.INSTANCE;
    }
}
