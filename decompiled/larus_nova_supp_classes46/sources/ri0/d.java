package ri0;

import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameWidget;
import com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    public d(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = (List) r3;
        LinkMicGameWidget r5 = LinkMicGameContext.Companion.a();
        if (r5 == null) goto L8;
        GameRtcRoomController r6 = r5.h;
        if (r6 == null) goto L9;
        r6.n(this.a.X.d(), "remoteLinkedUserMergeDataListObservableChange");
        return;
    L9:
        return;
    }
}
