package com.larus.audio.call.tracer;

import com.larus.audio.call.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RealtimeCallTimer {
    public final ArrayList<Long> a;
    public final ArrayList<Integer> b;
    public final ArrayList<Integer> c;
    public final ArrayList<Long> d;
    public final boolean e;

    public final void a() {
        if (this.e == true) goto L5;
        return;
    L5:
        com.larus.audio.call.util.c.a(new RealtimeCallTimer$saveToFile$1(this, null));
    }

    public RealtimeCallTimer() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = f.c().appContext().e();
    }
}
