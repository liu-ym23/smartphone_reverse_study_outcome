package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Runnable {
    public final /* synthetic */ LiveStickerDownloadHelper a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.l.b b;

    public i(LiveStickerDownloadHelper r1, com.bytedance.android.live.effect.api.l.b r2, Sticker r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.effect.api.l.b r0 = this.b;     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        r0.b();     // Catch: Throwable -> L10
    L5:
        Iterator r1 = ((ArrayList) this.a.b).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L18;
        ((com.bytedance.android.live.effect.api.l.b) r1.next()).b();     // Catch: Throwable -> L10
        goto L6
    L18:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
