package qg0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends ig0.b {
    @Override // ig0.b, jg0.c
    public final int o() {
        return 2131566581;
    }

    @Override // ig0.b, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonVirtualAvatarAnimLayer.name();
    }

    public c(hg0.a r7, SeatAnimEngineWrapper r8, MicSeatScene r9, xg0.a r10) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "linkSeatAbilityProvider");
        super(r7, 5, r8, r9, r10);
    }
}
