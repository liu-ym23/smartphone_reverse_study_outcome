package s32;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r6, int r7, ImageRecognitionEntry r8) {
        HashMap r0 = new HashMap();
        String r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L7;
        m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        Room r3 = (Room) r2.getValue();
    L8:
        IUserService r4 = k.f(IUserService.class);
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.user.f r9 = r4.user();
        if (r9 == null) goto L14;
        r5 = r9.n();
    L14:
        if (r3 == null) goto L17;
        String r10 = r3.getOwnerUserIdString();
        if (r10 == null) goto L17;
    L18:
        r0.put("anchor_id", r10);
        if (r3 == null) goto L22;
        String r11 = String.valueOf(r3.getRoomId());
        if (r11 == null) goto L22;
    L23:
        r0.put("room_id", r11);
        if (r5 != null) goto L27;
        r5 = "0";
    L27:
        r0.put("user_id", r5);
        r0.put("identify_object", String.valueOf(r7));
        r0.put("request_page", r8.getDesc());
        u.l().sendLog(r6, r0, new Object[0]);
        return;
    L22:
        r11 = "0";
    L17:
        r10 = "0";
    L7:
        r3 = null;
        goto L8
    }
}
