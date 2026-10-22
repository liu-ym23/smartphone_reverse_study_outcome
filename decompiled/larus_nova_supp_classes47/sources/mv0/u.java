package mv0;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends qs0.a<IMicRoomService> implements qs0.s {
    public u() {
        super(jc1.k.n(IMicRoomService.class));
    }

    @Override // qs0.s
    public final boolean isLoyalAudience() {
        return ((IMicRoomService) this.a).isLoyalAudience();
    }

    @Override // qs0.s
    public final boolean isMicRoom(IRoom r2) {
        return ((IMicRoomService) this.a).isMicRoom(r2);
    }
}
