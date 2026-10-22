package k10;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r9, String r11, String r12, String r13, long r14) {
        String r1 = null;
        long r2 = 0;
        int r4 = 3;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r3 = r0.getRoom();
        if (r3 == null) goto L7;
        Room r5 = (Room) r3.getValue();
    L8:
        if (r5 == null) goto L11;
        r2 = r5.getRoomId();
    L11:
        if (r5 == null) goto L14;
        String r6 = r5.getAnchorId();
        if (r6 == null) goto L14;
    L15:
        IUserService r7 = k.f(IUserService.class);
        if (r7 == null) goto L21;
        f r8 = r7.user();
        if (r8 == null) goto L21;
        r1 = r8.n();
    L21:
        if ((!StringsKt.isBlank(r6)) == true) goto L23;
    L25:
        boolean r15 = false;
    L26:
        boolean r16 = k.n(ILiveRoomService.class).inLivingRoom();
        if (r15 == false) goto L31;
        if (r16 == false) goto L30;
        r4 = 1;
        goto L31
    L30:
        r4 = 2;
    L31:
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("from_source", String.valueOf(r4));
        r17.put("anchor_id", r6);
        r17.put("room_id", String.valueOf(r2));
        if (r9 != null) goto L34;
        r9 = "";
    L34:
        r17.put("path", r9);
        r17.put("err_no", r11);
        if (r12 != null) goto L37;
        r12 = "";
    L37:
        r17.put("err_msg", r12);
        if (r13 != null) goto L40;
        r13 = "";
    L40:
        r17.put(OpenPlatformBaseDebugger.APP_ID, r13);
        r17.put("duration", String.valueOf(r14));
        g r18 = u.l();
        LinkedHashMap r19 = new LinkedHashMap();
        r19.putAll(r17);
        Unit r110 = Unit.INSTANCE;
        r18.e("mp_live_req_result", r19, new Object[0]);
        return;
    L23:
        if (Intrinsics.areEqual(r6, r1) == false) goto L25;
        r15 = true;
    L14:
        r6 = "";
    L7:
        r5 = null;
        goto L8
    }
}
