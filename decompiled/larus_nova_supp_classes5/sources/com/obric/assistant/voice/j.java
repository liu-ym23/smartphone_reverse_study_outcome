package com.obric.assistant.voice;

import android.content.ComponentName;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j implements lha.g {
    public final /* synthetic */ ObricVoiceServiceImpl a;

    @Override // lha.g
    public final void onTaskCreated(int r1, ComponentName r2) {
    }

    public j(ObricVoiceServiceImpl r1) {
        this.a = r1;
    }

    @Override // lha.g
    public final void onChange(ComponentName r5, ComponentName r6) {
        FLogger r0 = FLogger.a;
        r0.i(this.a.b, "onChange fromTopActivity: " + r5 + ", toTopActivity: " + r6);
        String r1 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getClassName();
    L7:
        if (Intrinsics.areEqual(r7, this.a.c) == false) goto L9;
        r0.i(this.a.b, "go to fingerprint, disable the voice wakeup");
        this.a.i(true);
        return;
    L9:
        if (r5 == null) goto L12;
        r1 = r5.getClassName();
    L12:
        if (Intrinsics.areEqual(r1, this.a.c) == false) goto L16;
        r0.i(this.a.b, "not in fingerprint, enable the voice wakeup");
        this.a.i(false);
        return;
    L16:
        return;
    L5:
        r7 = null;
        goto L7
    }
}
