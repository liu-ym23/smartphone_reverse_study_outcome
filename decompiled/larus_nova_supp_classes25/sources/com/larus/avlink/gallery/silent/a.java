package com.larus.avlink.gallery.silent;

import com.larus.utils.logger.FLogger;
import java.util.Timer;
import kotlin.Pair;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements com.larus.avlink.gallery.thumbnail.a {
    public a() {
    }

    @Override // com.larus.avlink.gallery.thumbnail.a
    public final void a(int r6, int r7) {
        if (((Number) SilentSyncManager.g.getFirst()).intValue() == r6) goto L5;
    L8:
        Job r0 = SilentSyncManager.a;
        SilentSyncManager.g = new Pair(Integer.valueOf(r6), Integer.valueOf(r7));
        FLogger r1 = FLogger.a;
        r1.i("SilentSyncManager", "Album state changed: images=" + r6 + ", videos=" + r7);
        if (r6 > 0) goto L15;
        if (r7 > 0) goto L15;
        r1.d("SilentSyncManager", "Album is empty, cancelling auto sync timer");
        Timer r8 = SilentSyncManager.b;
        if (r8 == null) goto L19;
        r8.cancel();
        return;
    L19:
        return;
    L15:
        Job r2 = SilentSyncManager.a;
        if (SilentSyncManager.b() == false) goto L20;
        r1.i("SilentSyncManager", "Album has media content - scheduling auto sync (images=" + r6 + ", videos=" + r7 + ')');
        SilentSyncManager.a("album_state_change");
        return;
    L20:
        return;
    L5:
        if (((Number) SilentSyncManager.g.getSecond()).intValue() != r7) goto L8;
        FLogger.a.d("SilentSyncManager", "Album state unchanged " + r6 + ", " + r7 + ", skipping");
    }
}
