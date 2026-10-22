package com.larus.audio.asr;

import com.larus.audio.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z {
    public final Function1<b, Unit> a;
    public final Function4<String, String, Long, Integer, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(Function1<? super b, Unit> r1, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
