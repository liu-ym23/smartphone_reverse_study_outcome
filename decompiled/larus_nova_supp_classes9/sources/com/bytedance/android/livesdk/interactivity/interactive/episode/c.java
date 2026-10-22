package com.bytedance.android.livesdk.interactivity.interactive.episode;

import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Runnable {
    public final /* synthetic */ EpisodeInteractiveDialog a;
    public final /* synthetic */ KVData b;

    public c(EpisodeInteractiveDialog r1, KVData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KVData r0 = this.b;     // Catch: Throwable -> L11
        if (r0 == null) goto L14;
        String r1 = r0.getKey();     // Catch: Throwable -> L11
        if (r1.hashCode() == 364236116) goto L8;
        return;
    L8:
        if (r1.equals("data_live_screen_orientation_change") == false) goto L19;
        EpisodeInteractiveDialog r2 = this.a;     // Catch: Throwable -> L11
        int r3 = EpisodeInteractiveDialog.l;     // Catch: Throwable -> L11
        r2.b();     // Catch: Throwable -> L11
        return;
    L19:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
