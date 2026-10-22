package u82;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaAnchorLinkUserListFragment;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends t82.d {
    public h(MediaAnchorLinkUserListFragment r1) {
        super(r1);
    }

    @Override // t82.d
    public final void c(int r3) {
        ((ObservableSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).rivalsList(r3, false).as(this.c.S90())).subscribe(new f(this), new g(this));
    }
}
