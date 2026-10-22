package bp1;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public static o b(DataCenter r3) {
        return k.n(IRoomContextService.class).getRoomDataContext(r3, 0);
    }

    public static com.bytedance.android.livesdk.chatroom.k a(DataCenter r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return k.n(IRoomContextService.class).getBottomToolbarService(r2, 0);
    }
}
