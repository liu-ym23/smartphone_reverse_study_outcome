package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements vlc.l {
    public jk0.b a;
    public vlc.d b;
    public long c;
    public Long d;
    public boolean e;
    public final DataCenter f;

    public d(DataCenter r3) {
        this.f = r3;
        this.c = System.currentTimeMillis();
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof cj) == false) goto L30;
        StringBuilder r0 = new StringBuilder("[RadioMessageComponent] message.msgType:");
        cj r7 = (cj) r6;
        r0.append(r7.msgType);
        ALogger.i("RadioStageContainerWidget", r0.toString());
        Integer r1 = r7.msgType;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.intValue() != 1) goto L31;
        cj.f r8 = r7.metaContent;
        StringBuilder r2 = new StringBuilder("[RadioMessageComponent] meta content:");
        Long r3 = null;
        if (r8 == null) goto L12;
        Boolean r4 = r8.isActivate;
    L13:
        r2.append(r4);
        ALogger.i("RadioStageContainerWidget", r2.toString());
        if (r8 == null) goto L16;
        Boolean r5 = r8.isActivate;
    L18:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L22;
        this.c = System.currentTimeMillis();
        this.e = true;
        jk0.b r9 = this.a;
        if (r9 == null) goto L26;
        r9.onStart();
    L26:
        if (r8 == null) goto L28;
        r3 = Long.valueOf(r8.giftId);
    L28:
        this.d = r3;
        return;
    L22:
        jk0.b r10 = this.a;
        if (r10 == null) goto L25;
        r10.onStop();
    L25:
        this.e = false;
        goto L26
    L16:
        r5 = null;
        goto L18
    L12:
        r4 = null;
        goto L13
    L31:
        return;
    }
}
