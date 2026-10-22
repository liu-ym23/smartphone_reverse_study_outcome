package iv1;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static q a(DataCenter r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return k.n(IRoomContextService.class).getRoomDslService(r2, 0);
    }
}
