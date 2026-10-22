package com.larus.dora.impl.settings.voiceprint;

import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.util.PacificInterfaceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements p0 {
    public final /* synthetic */ VoicePrintManagementActivity a;

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.dora.impl.settings.voiceprint.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.dora.impl.util.p0] */
    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        final VoicePrintManagementActivity r0 = this.a;
        int r1 = VoicePrintManagementActivity.l;
        r0.getClass();
        Function1<? super Boolean, Unit> r2 = PacificInterfaceManager.a;
        final String r3 = r0.h;
        final ?? r4 = new h(r0);
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, "callback");
        String r5 = PacificInterfaceManager.f(r3);
        if (r5 == null) goto L6;
        r3 = r5;
    L6:
        g49.d.d("PacificInterfaceManager", "deleteVoicePrint start");
        IVoiceEnrollService.a.getClass();
        IVoiceEnrollService r6 = IVoiceEnrollService.a.a();
        if (r6 == null) goto L10;
        r6.j(r3, new com.larus.dora.impl.util.p0(r3, r4));
        return;
    }

    public j(VoicePrintManagementActivity r1) {
        this.a = r1;
    }
}
