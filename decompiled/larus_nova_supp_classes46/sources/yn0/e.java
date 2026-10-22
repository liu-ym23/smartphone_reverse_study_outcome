package yn0;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements l81.e {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public final void a(DataCenter r5, View r6, Room r7) {
        if ((r7 instanceof Room) == true) goto L5;
        return;
    L5:
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n r1 = r0.getDrawCleanScreenViewModel();
        if (r1 == null) goto L14;
        DrawCleanScreenViewModel r2 = (DrawCleanScreenViewModel) r1.getValue();
        if (r2 == null) goto L15;
        r2.changeRoomViewVisiable(r5, r6, r7);
        return;
    L15:
        return;
    L14:
        return;
    }
}
