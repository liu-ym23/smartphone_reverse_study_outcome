package com.larus.voicecall.impl.plugins;

import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.r;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TtsPlaybackReportPlugin<C extends r> extends com.larus.audio.call.arch.a<C> {
    public final String f;
    public Job g;
    public boolean h;

    public final void b3() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = null;
    }

    public final void e3() {
        super.e3();
        if (com.larus.audio.call.f.f() == false) goto L5;
        final kotlinx.coroutines.flow.i1 r0 = d3a.a.c(getContext()).y();
        Flow<Integer> r1 = kotlinx.coroutines.flow.e.n(new TtsPlaybackReportPlugin$onStart$$inlined$map$1(r0));
    L6:
        CoroutineScope r2 = getContext().r();
        Job r3 = null;
        if (r2 == null) goto L9;
        r3 = BuildersKt.launch$default(r2, null, null, new TtsPlaybackReportPlugin$onStart$1(r1, this, null), 3, null);
    L9:
        this.g = r3;
        FLogger.a.i(this.f, "onStart, uiStateJob started");
        return;
    L5:
        final MutableSharedFlow r4 = d3a.a.c(getContext()).i1();
        r1 = new TtsPlaybackReportPlugin$onStart$$inlined$map$2(r4);
        goto L6
    }

    public final String T2() {
        return this.f;
    }

    public TtsPlaybackReportPlugin(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "TtsPlaybackReportPlugin";
        this.h = true;
    }
}
