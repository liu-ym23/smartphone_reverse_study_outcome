package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends jg0.a<MultiLinkNormalEmptyViewBinder.a> {
    @Override // jg0.c
    public final int o() {
        return 2131566589;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioHamletEmptyLargeLayer.name();
    }

    public d(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        Intrinsics.checkNotNullParameter((MultiLinkNormalEmptyViewBinder.a) r1, "itemData");
    }

    @Override // jg0.f
    public final void k(Object r1, int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter((MultiLinkNormalEmptyViewBinder.a) r1, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
    }
}
