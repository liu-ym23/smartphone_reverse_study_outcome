package com.larus.asr;

import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class u0 implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u0(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        boolean r1 = this.b;
        Set r2 = ChatBottomSpeakerComponent.F2;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        boolean r3 = false;
    L9:
        return Boolean.valueOf(r3);
    L7:
        r3 = true;
        goto L9
    }
}
