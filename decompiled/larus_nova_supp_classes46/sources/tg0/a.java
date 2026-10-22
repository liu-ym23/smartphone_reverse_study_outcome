package tg0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.MultiLinkThemedCompetitionBusinessLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends MultiLinkThemedCompetitionBusinessLayer {
    @Override // jg0.b
    public final int b() {
        return 2131567509;
    }

    @Override // jg0.b
    public final String c() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonThemedCompetitionBusinessLayer.name();
    }

    public a(MultiLinkAudioCommonGuestMicSeatBasicLayer r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "basicLayer");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
    }
}
