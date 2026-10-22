package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends a {
    @Override // jg0.b
    public final int b() {
        return 2131567511;
    }

    @Override // jg0.b
    public final String c() {
        return VerticalNitaInflate.Tag.MultiLinkVideoCommonThemedCompetitionBusinessLayer.name();
    }

    public b(MultiLinkCommonGuestMicSeatBasicLayer r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "basicLayer");
        Intrinsics.checkNotNullParameter(r3, "scene");
        super(r2, r3, r4);
    }
}
