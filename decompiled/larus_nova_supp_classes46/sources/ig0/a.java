package ig0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b {
    @Override // ig0.b
    public final boolean s() {
        return false;
    }

    public a(hg0.a r7, SeatAnimEngineWrapper r8, MicSeatScene r9, xg0.a r10) {
        Intrinsics.checkNotNullParameter(r7, "layerGetter");
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "linkSeatAbilityProvider");
        super(r7, 12, r8, r9, r10);
    }
}
