package com.obric.assistant.special_input;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g1 implements Function1 {
    public final /* synthetic */ SpecialInputTaskImpl a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ g1(SpecialInputTaskImpl r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r9) {
        SpecialInputTaskImpl r0 = this.a;
        Function0 r1 = this.b;
        Throwable r10 = (Throwable) r9;
        BuildersKt.launch$default(r0.g, null, null, new SpecialInputTaskImpl$openAssistantInputPanel$3$1(r1, null), 3, null);
        return Unit.INSTANCE;
    }
}
