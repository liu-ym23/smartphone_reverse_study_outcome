package th0;

import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements BannerWidget.a {
    public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;
    public final /* synthetic */ g1 b;

    @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
    public final boolean a() {
        return true;
    }

    public d(MultiLinkVideoBaseGuestLinkWidget r1, g1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
    public final void b(boolean r10, Map<String, String> r11) {
        g1 r0 = this.b;
        IRoom r1 = this.a.getMRoom();
        MultiLinkVideoBaseGuestLinkWidget r12 = this.a;
        String r2 = r12.x.a;
        int r3 = r12.y;
        boolean r4 = r12.Pq();
        xf6.b r13 = this.a.Tq();
        if (r13 == null) goto L7;
        vf6.a r14 = r13.a9();
        if (r14 == null) goto L7;
        int r5 = r14.c;
    L8:
        TalkRoomLogUtils.f0(r0, r1, r2, r3, r4, r5, r10, je0.d.Z(), this.a.A);
        return;
    L7:
        r5 = 200;
        goto L8
    }
}
