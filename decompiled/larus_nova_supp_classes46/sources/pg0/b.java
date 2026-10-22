package pg0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b extends e {
    @Override // jg0.c
    public int o() {
        return 2131566595;
    }

    @Override // jg0.c
    public String p() {
        return VerticalNitaInflate.Tag.MultiLinkCommonGuestStatusLayer.name();
    }

    public b(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // pg0.e, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        t((MultiLinkGuestViewBinder.a) r1, r2);
    }

    @Override // pg0.e
    public final void t(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        super.t(r2, r3);
        com.bytedance.android.live.liveinteract.revenue.fight.b r4 = ((IInteractService) k.n(IInteractService.class)).teamFightService();
        if (r4 == null) goto L6;
        r4.F1(this, SceneType.SCENE_VIDEO_TALKROOM);
        return;
    }
}
