package com.larus.audio;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AudioConnectionStateManager$b implements com.larus.platform.api.y {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public final boolean a() {
        return false;
    }

    public AudioConnectionStateManager$b(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onGetId(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "did");
        Intrinsics.checkNotNullParameter(r3, "iid");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("init audio again: did=");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        r6.append(r0);
        r5.i("AudioConnectionStateManager", r6.toString());
        AudioConnectionStateManager r7 = AudioConnectionStateManager.a;
        String r8 = this.a;
        String r1 = this.b;
        r7.getClass();
        AudioConnectionStateManager.b(r8, r1, r2);
        if (z2.a.isFixSamiRequestNoDid() == false) goto L10;
        t0.a(new p());
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
