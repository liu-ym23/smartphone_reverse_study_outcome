package al0;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.i;
import dl0.n;
import dl0.p;
import el0.j;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public d() {
    }

    public static Pair a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        String r2 = "anchor";
    L11:
        return TuplesKt.to("user_type", r2);
    L9:
        r2 = "admin";
        goto L11
    }

    public static boolean b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        if (k.n(IUserService.class).user().c() == true) goto L14;
        return false;
    L14:
        return true;
    }

    static {
    }

    public static void d(boolean r2) {
        HashMap r0 = new HashMap();
        if (r2 == false) goto L5;
        String r3 = "voice_live";
    L6:
        r0.put("live_type", r3);
        r0.put("user_type", "anchor");
        j.j(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        j.n(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        g("livesdk_anchor_audience_connection_invite_more_button_click", r0, new Object[0]);
        return;
    L5:
        r3 = "video_live";
        goto L6
    }

    public static void e(boolean r2) {
        HashMap r0 = new HashMap();
        if (r2 == false) goto L5;
        String r3 = "voice_live";
    L6:
        r0.put("live_type", r3);
        r0.put("user_type", "anchor");
        j.j(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        j.n(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        g("livesdk_anchor_audience_connection_invite_more_button_show", r0, new Object[0]);
        return;
    L5:
        r3 = "video_live";
        goto L6
    }

    public static void g(String r4, Map r5, Object... r6) {
        if (HostEnv.b() == false) goto L5;
    L6:
        u.l().sendLog(r4, r5, new Object[]{Room.class, x.class, r6});
        return;
    L5:
        if (HostEnv.c() == true) goto L6;
    }

    public static void c(boolean r2, long r3, boolean r5, boolean r6, boolean r7) {
        if (b() == false) goto L37;
        HashMap r0 = new HashMap();
        if (r2 == false) goto L7;
        String r4 = "voice_live";
    L8:
        r0.put("live_type", r4);
        j.j(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        r0.put("invitee_id", String.valueOf(r3));
        if (r5 == false) goto L11;
        String r8 = "online";
    L12:
        r0.put("online_status", r8);
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L19;
        i r10 = r9.isAnchor();
        if (r10 == null) goto L19;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L19;
        String r11 = "anchor";
    L20:
        r0.put("user_type", r11);
        String r12 = "0";
        if (r6 == false) goto L23;
        Object r13 = "1";
    L24:
        r0.put("icon_type", r13);
        if (r7 == false) goto L27;
        Object r14 = "1";
    L28:
        r0.put("if_invitee_subscribe", r14);
        r0.put("pk_id", String.valueOf(p.a().getPkId()));
        r0.put("is_in_pk", "1");
        if (n.c() == false) goto L31;
        String r15 = n.d();
    L32:
        r0.put("admin_id", r15);
        if (n.c() == false) goto L35;
        r12 = "1";
    L35:
        r0.put("is_admin", r12);
        g("livesdk_anchor_invitee_show", r0, new Object[0]);
        return;
    L31:
        r15 = "";
        goto L32
    L27:
        r14 = "0";
        goto L28
    L23:
        r13 = "0";
    L19:
        r11 = "admin";
        goto L20
    L11:
        r8 = "offline";
        goto L12
    L7:
        r4 = "video_live";
        goto L8
    }

    public static void f(boolean r3, long r4, boolean r6, String r7, boolean r8, String r9, int r10) {
        if ((r10 & 32) == 0) goto L5;
        r9 = null;
    L5:
        HashMap r11 = new HashMap();
        j.j(r11, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L8;
        r11.put("function_type2", "new_audience");
    L8:
        if (r3 == false) goto L10;
        String r5 = "voice_live";
    L11:
        r11.put("live_type", r5);
        if (r6 == false) goto L14;
        String r12 = "online";
    L15:
        r11.put("online_status", r12);
        r11.put("enter_from", "live_detail");
        r11.put("request_page", r7);
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r13 == null) goto L23;
        i r14 = r13.isAnchor();
        if (r14 == null) goto L23;
        if (((Boolean) r14.getValue()).booleanValue() != true) goto L23;
        String r15 = "anchor";
    L26:
        r11.put("user_type", r15);
        r11.put("invitee_id", String.valueOf(r4));
        String r16 = "1";
        if (TextUtils.isEmpty(r9) == true) goto L29;
        r11.put("is_task", "1");
        Intrinsics.checkNotNull(r9);
        r11.put("activity_name", r9);
    L29:
        j.p(r11);
        if (r8 == false) goto L32;
        Object r17 = "1";
    L33:
        r11.put("if_invitee_subscribe", r17);
        r11.put("pk_id", String.valueOf(p.a().getPkId()));
        r11.put("is_in_pk", "1");
        if (n.c() == false) goto L36;
        String r18 = n.d();
    L37:
        r11.put("admin_id", r18);
        if (n.c() == false) goto L40;
        Object r19 = "1";
    L41:
        r11.put("is_admin", r19);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L45;
        r16 = "0";
    L45:
        r11.put("is_invite_only", r16);
        g("livesdk_anchor_friend_connection_invite", r11, new Object[0]);
        return;
    L40:
        r19 = "0";
        goto L41
    L36:
        r18 = "";
        goto L37
    L32:
        r17 = "0";
    L23:
        if (n.c() == false) goto L25;
        r15 = "admin";
        goto L26
    L25:
        r15 = "link_user";
        goto L26
    L14:
        r12 = "offline";
        goto L15
    L10:
        r5 = "video_live";
        goto L11
    }
}
