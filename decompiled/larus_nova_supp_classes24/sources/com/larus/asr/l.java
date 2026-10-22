package com.larus.asr;

import com.larus.asr.session.SamiCallAsrSession;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ SamiCallAsrSession a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Map c;

    public /* synthetic */ l(SamiCallAsrSession r1, Function1 r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SamiCallAsrSession r0 = this.a;
        Function1<? super String, Unit> r1 = this.b;
        Map<String, Object> r2 = this.c;
        Set r3 = ChatBottomSpeakerComponent.F2;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }
}
