package ak0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorBottomToolbar;
import com.bytedance.android.livesdkapi.depend.model.live.IAudienceLinkmicEntranceInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String a = null;

    static {
        a = s1.B(2131914883);
    }

    public static IAudienceLinkmicEntranceInfo a() {
        o r0 = m.i();
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L14;
        IRoomOthersData r3 = r2.getRoomOthers();
        if (r3 == null) goto L14;
        IAnchorBottomToolbar r4 = r3.getAnchorBottomToolbar();
        if (r4 == null) goto L14;
        return r4.getAudienceLinkmicEntrance();
    L14:
        return null;
    }
}
