package com.bytedance.android.livesdk.interactivity.asr;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final Queue<byte[]> a;
    public final Queue<Long> b;
    public byte[] c;
    public final int d;

    public final void a() {
    L7:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("clear error", e);
        return;
    L3:
        if ((!this.a.isEmpty()) == false) goto L5;
        ((LinkedList) this.a).clear();     // Catch: Exception -> L7
        ((LinkedList) this.b).clear();     // Catch: Exception -> L7
    L5:
        this.c = null;     // Catch: Exception -> L7
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("AudioDataCollector clear");     // Catch: Exception -> L7
    }

    public d(int r1) {
        this.d = r1;
        this.a = new LinkedList();
        this.b = new LinkedList();
    }
}
