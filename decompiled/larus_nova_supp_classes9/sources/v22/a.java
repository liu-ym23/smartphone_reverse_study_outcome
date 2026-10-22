package v22;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.JvmStatic;
import r52.a1;
import r52.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final Boolean a = null;
    public static final Boolean b = null;

    static {
        a = (Boolean) w.a.getValue();
        b = (Boolean) a1.a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L13;
        m r1 = r0.getRoom();
        if (r1 == null) goto L13;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L13;
        RoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L13;
        if (r3.isEnablePinHighlight() != true) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        return false;
    L16:
        if (a.booleanValue() == false) goto L20;
        return true;
    L20:
        return false;
    L13:
        r4 = false;
        goto L14
    }
}
