package com.obric.assistant.settings.voiceprint;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ ObricVoicePrintManagementActivity a;

    public /* synthetic */ b(ObricVoicePrintManagementActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Activity, com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity] */
    public final Object invoke() {
        ?? r0 = this.a;
        int r1 = ObricVoicePrintManagementActivity.q;
        r0.U1(false, true);
        if (r0.isFinishing() == true) goto L8;
        if (r0.isDestroyed() == true) goto L8;
        r0.finish();
    L8:
        return Unit.INSTANCE;
    }
}
