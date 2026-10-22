package qg0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends ig0.b {
    @Override // ig0.b, jg0.c
    public final int o() {
        MicSeatScene r0 = this.b;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131566580;
    L5:
        if (r1 != 2) goto L7;
        return 2131566593;
    L7:
        if (r1 != 3) goto L9;
        return 2131566608;
    L9:
        if (r1 != 4) goto L11;
        return 2131566604;
    L11:
        if (r1 != 5) goto L22;
        return 2131566611;
    L22:
        return 2131566593;
    }

    @Override // ig0.b, jg0.c
    public final String p() {
        MicSeatScene r0 = this.b;
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonGuestAnimLayer.name();
    L17:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonEnlargeStageAnimLayer.name();
    L18:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonHamletAnimLayer.name();
    L19:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonGuestAnimLayer.name();
    L15:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonCPositionAnimLayer.name();
    }

    public b(hg0.a r7, SeatAnimEngineWrapper r8, MicSeatScene r9, xg0.a r10) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "linkSeatAbilityProvider");
        super(r7, 5, r8, r9, r10);
    }
}
