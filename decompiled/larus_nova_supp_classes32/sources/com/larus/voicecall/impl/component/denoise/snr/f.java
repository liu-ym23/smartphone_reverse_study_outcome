package com.larus.voicecall.impl.component.denoise.snr;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends a {
    public final Function1<a, Unit> a;
    public final String b;
    public Job c;

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void c() {
        Job r0 = this.c;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.c = null;
        Function1<a, Unit> r1 = this.a;
        r1.invoke(new b(r1));
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void d() {
        Job r0 = this.c;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.c = null;
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final String a() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super a, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "transTo");
        super(r7);
        this.a = r7;
        this.b = "SNRTimerState";
        Job r0 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SNRTimerState$startTimer$1(this, null), 2, null);
        Job r1 = this.c;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.c = r0;
    }

    @Override // com.larus.voicecall.impl.component.denoise.snr.a
    public final void e(boolean r5, boolean r6, boolean r7) {
        FLogger.a.i(this.b, "onUIStateChange isListeningState=" + r5 + " isMute=" + r6 + "  isDenoiseSwitchOpen=" + r7);
        if (r5 == false) goto L6;
        if (r6 == true) goto L6;
        if (r7 == false) goto L6;
        return;
    L6:
        Job r8 = this.c;
        if (r8 == null) goto L9;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L9:
        this.c = null;
        Function1<a, Unit> r9 = this.a;
        r9.invoke(new c(r9));
    }
}
