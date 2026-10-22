package com.larus.asr.session.component;

import com.larus.asr.x5;
import com.obric.assistant.spi.actionbar.ObricActionBarTrackServiceDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ObricAsrPreComponent implements n0 {
    public final f0 a;
    public final boolean b;

    @Override // com.larus.asr.session.component.n0
    public final void c(Integer r7) {
        if (this.b == true) goto L6;
        return;
    L6:
        if (x5.c().a() == true) goto L8;
        return;
    L8:
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        boolean r1 = false;
        if (r0 != null) goto L11;
    L13:
        if (r1 == false) goto L19;
        if (r7 == null) goto L19;
        if (r7.intValue() == 0) goto L19;
        this.a.q = true;
        return;
    L19:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricAsrPreComponent$onBeforeEngineStart$1(null), 3, null);
        return;
    L11:
        if (r0.t() != true) goto L13;
        r1 = true;
        goto L13
    }

    public ObricAsrPreComponent(f0 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "asrContext");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.larus.asr.session.component.n0
    public final void a(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "params");
        ObricActionBarTrackServiceDelegate.b.n(r2, r3);
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(b0 r2, com.larus.asr.session.i r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "complete");
        r3.invoke(c0.b.a);
    }
}
