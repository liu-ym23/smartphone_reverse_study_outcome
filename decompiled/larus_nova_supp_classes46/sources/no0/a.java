package no0;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r2, Map r3) {
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(r3);
        Unit r4 = Unit.INSTANCE;
        r0.e(r2, r1, new Object[0]);
    }

    public static void c(int r5, int r6, int r7) {
        Room r2 = null;
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r2 = (Room) r1.getValue();
    L7:
        if (r2 == null) goto L9;
        r3 = r2.getRoomId();
    L9:
        if (r2 == null) goto L12;
        String r4 = r2.getAnchorId();
        if (r4 == null) goto L12;
    L13:
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("anchor_id", r4);
        r8.put("room_id", String.valueOf(r3));
        r8.put("from_source", String.valueOf(r5));
        r8.put("identifier", String.valueOf(r6));
        r8.put("role", String.valueOf(r7));
        a("mp_handle_entrance_msg", r8);
        return;
    L12:
        r4 = "";
        goto L13
    }

    public static void b(String r7, String r8, String r9, JSONObject r10, String r11) {
        Object r0 = "0";
        Intrinsics.checkNotNullParameter(r7, "entranceType");
        Intrinsics.checkNotNullParameter(r8, "stage");
        Intrinsics.checkNotNullParameter(r9, "stageDesc");
        Intrinsics.checkNotNullParameter(r11, "pageType");
        Room r4 = null;
        long r5 = 0;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L7;
        m r3 = r2.getRoom();
        if (r3 == null) goto L7;
        r4 = (Room) r3.getValue();
    L7:
        if (r4 == null) goto L9;
        r5 = r4.getRoomId();
    L9:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("_param_for_special", "micro_app");
        r6.put("room_id", String.valueOf(r5));
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L19
        IUserService r13 = k.f(IUserService.class);     // Catch: Throwable -> L19
        if (r13 == null) goto L16;
        f r14 = r13.user();     // Catch: Throwable -> L19
        if (r14 == null) goto L16;
        String r15 = r14.n();     // Catch: Throwable -> L19
        if (r15 == null) goto L16;
    L17:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r16) == true) goto L25;
        r0 = r16;
    L25:
        r6.put("anchor_id", ((String) r0).toString());
        r6.put("entrance_type", r7);
        r6.put("stage", r8);
        r6.put("stage_desc", r9);
        if (r10 == null) goto L29;
        String r17 = r10.toString();
        if (r17 == null) goto L29;
    L30:
        r6.put("stage_extra", r17);
        r6.put("page_type", r11);
        a("mp_live_choose_page_monitor", r6);
        return;
    L29:
        r17 = "";
    L16:
        r15 = "0";
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public static void d(int r5, int r6, int r7, String r8, String r9) {
        Room r2 = null;
        long r3 = 0;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r2 = (Room) r1.getValue();
    L7:
        if (r2 == null) goto L9;
        r3 = r2.getRoomId();
    L9:
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("roomid", String.valueOf(r3));
        r4.put("role", String.valueOf(r5));
        r4.put("live_status", String.valueOf(r6));
        r4.put("page", String.valueOf(r7));
        r4.put("errNo", r8);
        if (r9 != null) goto L12;
        r9 = "";
    L12:
        r4.put("errMsg", r9);
        a("mp_mount_page_show", r4);
    }

    public static void e(String r8, String r9, String r10, String r11, long r12) {
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
        f r13 = r7.user();
        if (r13 == null) goto L21;
        r1 = r13.n();
    L21:
        if ((!StringsKt.isBlank(r6)) == true) goto L23;
    L25:
        boolean r14 = false;
    L26:
        boolean r15 = k.n(ILiveRoomService.class).inLivingRoom();
        if (r14 == false) goto L31;
        if (r15 == false) goto L30;
        r4 = 1;
        goto L31
    L30:
        r4 = 2;
    L31:
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("fromSource", String.valueOf(r4));
        r16.put("anchorId", r6);
        r16.put("roomid", String.valueOf(r2));
        if (r8 != null) goto L34;
        r8 = "";
    L34:
        r16.put("path", r8);
        r16.put("errNo", r9);
        if (r10 != null) goto L37;
        r10 = "";
    L37:
        r16.put("errMsg", r10);
        if (r11 != null) goto L40;
        r11 = "";
    L40:
        r16.put("app_id", r11);
        r16.put("duration", String.valueOf(r12));
        a("mp_live_req_result", r16);
        if (r14 == false) goto L44;
        a("mp_live_anchor_req_result", r16);
        return;
    L44:
        return;
    L23:
        if (Intrinsics.areEqual(r6, r1) == false) goto L25;
        r14 = true;
    L14:
        r6 = "";
    L7:
        r5 = null;
        goto L8
    }
}
