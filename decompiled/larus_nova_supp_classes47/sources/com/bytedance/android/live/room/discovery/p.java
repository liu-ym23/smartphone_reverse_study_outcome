package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import zg1.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ AnchorPerfMonitorWidget a;

    public p(AnchorPerfMonitorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        c1 r6 = (c1) r5;
        StringBuilder r0 = new StringBuilder("LiveAnchorAudioFocusGetEvent.get:");
        if (r6 == null) goto L5;
        Boolean r1 = Boolean.FALSE;
    L6:
        r0.append(r1);
        ALogger.d("AnchorVolumnOptiTAG", r0.toString());
        kjc.c r2 = new kjc.c();
        if (7 != kjc.a.a()) goto L13;
        kjc.b r3 = r2.a;
        if (r6 == null) goto L11;
        this.a.P = true;
    L11:
        AnchorPerfMonitorWidget.xq(this.a);
        r3.a = Unit.INSTANCE;
        r2.b = true;
    L13:
        if (r2.b == true) goto L18;
        kjc.b r4 = r2.a;
        if (r6 == null) goto L17;
        this.a.L = true;
    L17:
        AnchorPerfMonitorWidget.xq(this.a);
        r4.a = Unit.INSTANCE;
    L18:
        Object r7 = r2.a.a;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
