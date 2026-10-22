package com.bytedance.android.live.room.discovery.drawer.processor;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements a {
    public final b a;

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final String identifier() {
        return "SingleRoomFrequencyProcessor";
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final boolean b() {
        if (this.a.b().a() == true) goto L5;
        RoomContext r0 = this.a.b().q;
        if (r0 == null) goto L16;
        m r1 = r0.getMoreLiveShowMarqueeShown();
        if (r1 != null) goto L12;
        return false;
    L12:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L18;
    L6:
        return true;
    L18:
        return false;
    L16:
        return false;
    L5:
        if (((Number) this.a.b().k.getValue()).intValue() <= this.a.b().l) goto L6;
        return false;
    }

    public h(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.a
    public final void c(MarqueeType r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeType");
        if (r2 != MarqueeType.SHOW) goto L10;
        RoomContext r3 = this.a.b().q;
        if (r3 == null) goto L11;
        m r4 = r3.getMoreLiveShowMarqueeShown();
        if (r4 == null) goto L12;
        r4.setValue(Boolean.TRUE);
        return;
    L12:
        return;
    L11:
        return;
    }
}
