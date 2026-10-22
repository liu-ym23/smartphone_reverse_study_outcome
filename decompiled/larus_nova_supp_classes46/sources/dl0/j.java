package dl0;

import am2.x;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static void a(IMiddlewareHostSocial.InviteFriendsConfig r10, Room r11, boolean r12, boolean r13) {
        String r0 = jc1.k.n(IUserService.class).user().b().getNickName();
        Intrinsics.checkNotNullParameter(r10, "$this$setupCommonWith");
        Intrinsics.checkNotNullParameter(r0, "inviterNickname");
        r10.setTitlePart1(r0);
        r10.setTitlePart2(s1.B(2131918033));
        Object[] r1 = new Object[1];
        if (r11 == null) goto L8;
        User r2 = r11.getOwner();
        if (r2 == null) goto L8;
        String r3 = r2.getNickName();
        if (r3 == null) goto L8;
    L9:
        r1[0] = r3;
        r10.setSubtitlePart1(s1.C(2131918030, r1));
        r10.setSubtitlePart2(s1.B(2131918031));
        r10.setHint(s1.B(2131918029));
        r10.setJoinBtnTextEnabled(s1.B(2131918027));
        r10.setJoinBtnTextDisabled(s1.B(2131918035));
        r10.setInviteBtnTextEnabled(s1.B(2131919316));
        r10.setInviteBtnTextDisabled(s1.B(2131919321));
        r10.setPanelTitle(s1.B(2131918073));
        r10.setRoom(r11);
        r10.setFunctionType("new_audience");
        LinkedHashMap r4 = new LinkedHashMap();
        u.l().c(x.class).a(r4);
        u.l().c(Room.class).a(r4);
        if (r11 == null) goto L12;
        LiveMode r5 = r11.getStreamType();
    L13:
        int r6 = h1.a;
        r10.setLiveType(i1.a(r5));
        r10.setEnterFrom("live_detail");
        String r7 = (String) r4.get("enter_from_merge");
        String r8 = "";
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r10.setEnterFromMerge(r7);
        String r9 = (String) r4.get("enter_method");
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r10.setEnterMethod(r9);
        String r14 = (String) r4.get("action_type");
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        r10.setActionType(r14);
        String r15 = (String) r4.get("video_id");
        if (r15 != null) goto L25;
        r15 = "";
    L25:
        r10.setVideoId(r15);
        if (r11 == null) goto L28;
        String r16 = r11.getRequestId();
    L29:
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        r10.setRequestId(r16);
        if (r11 == null) goto L34;
        String r17 = r11.getLog_pb();
    L35:
        if (r17 == null) goto L38;
        r8 = r17;
    L38:
        r10.setLogPb(r8);
        String r18 = "anchor";
        if (r13 == false) goto L48;
        RoomContext r19 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r19 == null) goto L47;
        com.bytedance.live.datacontext.i r110 = r19.isAnchor();
        if (r110 == null) goto L47;
        if (((Boolean) r110.getValue()).booleanValue() != true) goto L47;
        String r111 = "anchor";
    L49:
        r10.setUserType(r111);
        if (r12 == false) goto L52;
        IMiddlewareHostSocial.InviteFriendsConfig.RoomType r112 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VOICE_CHAT;
    L53:
        r10.setRoomType(r112);
        Uri.Builder r113 = new Uri.Builder();
        Uri.Builder r114 = r113.scheme("sslocal").authority("webcast_room").appendQueryParameter("enter_from_merge", "chat").appendQueryParameter("enter_method", "live_cover");
        if (r11 == null) goto L56;
        Long r115 = Long.valueOf(r11.id);
    L57:
        Uri.Builder r116 = r114.appendQueryParameter("room_id", String.valueOf(r115)).appendQueryParameter("auto_link_mic", "true").appendQueryParameter("is_strong_reach", "true").appendQueryParameter("from_user_id", jc1.k.n(IUserService.class).user().n());
        RoomContext r117 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r117 == null) goto L65;
        com.bytedance.live.datacontext.i r118 = r117.isAnchor();
        if (r118 == null) goto L65;
        if (((Boolean) r118.getValue()).booleanValue() != true) goto L65;
    L68:
        r116.appendQueryParameter("from_user_type", r18);
        r10.setSchema(r113.build().toString());
        return;
    L65:
        if (n.c() == false) goto L67;
        r18 = "admin";
        goto L68
    L67:
        r18 = "link_user";
        goto L68
    L56:
        r115 = null;
        goto L57
    L52:
        r112 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VIDEO_CHAT;
    L47:
        r111 = "link_user";
        goto L49
    L48:
        r111 = "audience";
        goto L49
    L34:
        r17 = null;
        goto L35
    L28:
        r16 = null;
        goto L29
    L12:
        r5 = null;
    L8:
        r3 = "Unknown";
        goto L9
    }
}
