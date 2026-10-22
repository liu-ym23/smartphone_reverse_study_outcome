package w82;

import am2.n;
import am2.q;
import am2.x;
import am2.y;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.i;
import e92.m;
import hy.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(Map r4) {
        r4.put("from_media", "1");
        r4.put("invitee_list", "mutual_follow");
        r4.put("connection_type", "manual_link");
        MediaLinkContext r0 = MediaLinkContext.Companion.getContext();
        if (r0 == null) goto L11;
        i<a> r1 = r0.getLogParams();
        if (r1 == null) goto L11;
        a r2 = (a) r1.getValue();
        if (r2 == null) goto L11;
        String r3 = r2.a;
        if (r3 == null) goto L11;
        r4.put("request_id", r3);
    L11:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r5 == null) goto L21;
        e r6 = r5.Np();
        if (r6 == null) goto L22;
        List r7 = r6.getOnlineUserList();
        if (r7 == null) goto L23;
        int r8 = r7.size();
        r4.put("anchor_connect_status", String.valueOf(r8));
        if (r8 <= 1) goto L24;
        r4.put("connection_sub_type", "manual_link");
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @JvmStatic
    public static final void e(fy.e r3, Room r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "targetRoom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("invitee_id", r4.getOwnerUserIdString());
        r0.put("invitee_status", "0");
        r0.put("channel_id", String.valueOf(m.b()));
        if (r3.d != 13) goto L5;
        r0.put("source", "bigevent");
    L5:
        c(r0);
        u.l().sendLog("livesdk_connection_invite", r0, new Object[]{Room.class});
    }

    @JvmStatic
    public static final void a(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "inviteUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("inviter_id", r3.toString());
        r0.put("selection", r2);
        r0.put("channel_id", String.valueOf(r4));
        c(r0);
        u.l().sendLog("livesdk_connection_invited", r0, new Object[]{Room.class});
    }

    public static void b(String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "userID");
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        HashMap r0 = new HashMap();
        if (m.f() == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_anchor", r1);
        r0.put("to_user_id", r7.toString());
        r0.put("connection_type", "manual_link");
        r0.put("request_page", r8);
        if (r9 == false) goto L9;
        String r10 = "livesdk_follow";
    L10:
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L17;
        i r13 = r11.isAnchor();
        if (r13 == null) goto L17;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L17;
        String r14 = "anchor_to_anchor";
    L18:
        g r3 = u.l();
        FollowLog r5 = new FollowLog(1);
        r5.e = FollowLog.Scene.MULTI_ANCHOR;
        r5.g = r14;
        r5.h = "0";
        r3.sendLog(r10, r0, new Object[]{Room.class, r5, x.class, am2.u.class, y.class, n.f(), q.class});
        return;
    L17:
        r14 = "audience_to_anchor";
        goto L18
    L9:
        r10 = "livesdk_unfollow";
        goto L10
    L5:
        r1 = "0";
        goto L6
    }

    @JvmStatic
    public static final void d(long r3, long r5, int r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("connection_time", String.valueOf((System.currentTimeMillis() - r3) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        r0.put("connection_anchor_cnt", String.valueOf(r7));
        r0.put("channel_id", String.valueOf(r5));
        r0.put("from_media", "1");
        g r4 = u.l();
        x r6 = new x();
        r6.a = "live";
        r6.e = "other";
        r4.sendLog("livesdk_connection_over", r0, new Object[]{r6, Room.class});
    }
}
