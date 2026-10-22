package com.larus.voicecall.impl.component.denoise.snr;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends a {
    public final Function1<a, Unit> a;
    public final String b;

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final String a() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "transTo");
        super(r2);
        this.a = r2;
        this.b = "SNRAsrState";
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void e(boolean r5, boolean r6, boolean r7) {
        FLogger.a.i(this.b, "onUIStateChange isListeningState=" + r5 + " isMute=" + r6 + "  isDenoiseSwitchOpen=" + r7);
        if (r5 == true) goto L6;
        Function1<a, Unit> r8 = this.a;
        r8.invoke(new c(r8));
        return;
    }
}
