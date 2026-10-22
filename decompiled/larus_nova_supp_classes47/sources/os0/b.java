package os0;

import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.v;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static o a() {
        return k.n(IRoomContextService.class).getRoomDataContext(null, 0);
    }

    public static final ILiveProfileProxyService c() {
        return (ILiveProfileProxyService) k.n(ILiveProfileProxyService.class);
    }

    public static v b(DataCenter r3) {
        return k.n(IRoomContextService.class).getRoomProfileService(r3, 0);
    }
}
