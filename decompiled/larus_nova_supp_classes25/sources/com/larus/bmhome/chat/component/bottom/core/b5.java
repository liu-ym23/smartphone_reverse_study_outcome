package com.larus.bmhome.chat.component.bottom.core;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b5 implements Function0 {
    public final /* synthetic */ CharSequence a;
    public final /* synthetic */ CoreInputComponent b;

    public /* synthetic */ b5(CharSequence r1, CoreInputComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        CharSequence r0 = this.a;
        CoreInputComponent r1 = this.b;
        int r2 = CoreInputComponent.d3;
        FLogger.a.i("CoreInputComponent", "do setHint " + r0);
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r3 = r1.W4();
        if (r3 == null) goto L5;
        r3.M5(r0);
    L5:
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r4 = r1.W4();
        if (r4 == null) goto L9;
        r4.requestLayout();
    L9:
        return Unit.INSTANCE;
    }
}
