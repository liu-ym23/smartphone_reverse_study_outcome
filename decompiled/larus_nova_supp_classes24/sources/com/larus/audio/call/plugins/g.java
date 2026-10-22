package com.larus.audio.call.plugins;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends com.larus.im.service.audio.z0 {
    public final String a;
    public final /* synthetic */ h b;

    public final String g() {
        return this.a;
    }

    public g(h r1) {
        this.b = r1;
        this.a = "RealtimeCallAudioFrameSender#eventListener";
    }

    public final void n(com.larus.im.service.audio.z0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof pf9.z) == false) goto L5;
        h r4 = this.b;
        r4.j = -1;
        r4.k = "";
        return;
    L5:
        boolean r1 = true;
        if ((r3 instanceof pf9.e0) == false) goto L9;
        this.b.i.b(true, "ReplyEnd");
        return;
    L9:
        if ((r3 instanceof pf9.d0) == false) goto L12;
        h r5 = this.b;
        r5.j = SystemClock.elapsedRealtime();
        return;
    L12:
        if ((r3 instanceof pf9.f0) == false) goto L20;
        String r6 = pf9.i.k((pf9.f0) r3);
        if (r6.length() > 0) goto L17;
        r1 = false;
    L17:
        if (r1 == false) goto L26;
        this.b.k = r6;
        return;
    L26:
        return;
    L20:
        if ((r3 instanceof pf9.i0) == false) goto L28;
        this.b.i.b(true, "SceneSwitched");
        return;
    }
}
