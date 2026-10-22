package el0;

import am2.x;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.r;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import dl0.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static long a;
    public static final /* synthetic */ int b = 0;

    public static String e() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        return "anchor";
    L11:
        if (k.n(IUserService.class).user().c() == false) goto L14;
        return "user";
    L14:
        return "guest";
    }

    public static String f() {
        if (k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().getPkId() != 0) goto L5;
        long r0 = a;
    L7:
        return String.valueOf(r0);
    L5:
        r0 = k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().getPkId();
        goto L7
    }

    static {
    }

    public static void a(TextView r2) {
        if (r2 == null) goto L9;
        int r0 = r2.getPaddingStart() + r2.getPaddingEnd();
        r2.measure(0, 0);
        int r1 = r2.getMeasuredWidth() + r0;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L6;
        r3.width = r1;
        Unit r4 = Unit.INSTANCE;
    L7:
        r2.setLayoutParams(r3);
        r2.setBackgroundResource(2131248855);
        return;
    L6:
        r3 = null;
        goto L7
    }

    @JvmStatic
    public static final void i(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L12;
        r5.put("anchor_id", r2.getOwnerUserIdString());
        r5.put("room_id", String.valueOf(r2.id));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void k(Map r1) {
        j(r1, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
    }

    public static void m(Map r1) {
        l(r1, ((IInteractService) k.n(IInteractService.class)).getCurrentScene());
    }

    @JvmStatic
    public static final void o(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        List r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L17;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L17;
        List r6 = r3.b;
        if (r6 == null) goto L17;
        if (r6.contains(1) == false) goto L15;
        r4 = r6;
    L15:
        if (r4 == null) goto L17;
        String r7 = "video_friend";
    L18:
        r5.put("play_type", r7);
        return;
    L17:
        r7 = "";
        goto L18
    }

    @JvmStatic
    public static final void p(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "logMap");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 != null) goto L11;
        return;
    L11:
        if (d0.e(r3.b) == false) goto L13;
        r5.put("seat_fit_status", "on");
        return;
    L13:
        r5.put("seat_fit_status", "off");
        return;
    L17:
        return;
    L16:
        return;
    }

    @JvmStatic
    public static final void g(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", r6);
        r0.put("play_mode", w.a());
        int r8 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        l(r0, r8);
        j(r0, Integer.valueOf(r8));
        o(r0);
        p(r0);
        Intrinsics.checkNotNullParameter(r0, "logMap");
        r0.put("guest_connection_type", "live_chat");
        r0.put("user_id", k.n(IUserService.class).user().n());
        r0.put("user_type", e());
        if (r7 == null) goto L18;
        String r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L14;
        m r2 = r1.getRoom();
        if (r2 == null) goto L14;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L14;
        User r4 = r3.getOwner();
        if (r4 == null) goto L14;
        r5 = r4.getIdStr();
    L14:
        if (Intrinsics.areEqual(r7, r5) == false) goto L16;
        String r9 = "anchor";
    L17:
        r0.put("mute_user_type", r9);
        goto L18
    L16:
        r9 = "guest";
    L18:
        n(r0, Integer.valueOf(r8));
        u.l().sendLog("livesdk_guest_connection_mute_cancel", r0, new Object[]{x.class, Room.class});
    }

    @JvmStatic
    public static final void j(Map<String, String> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (r4 != null) goto L5;
    L14:
        r3.put("function_type", "");
        r3.put("function_type2", "");
        return;
    L5:
        if (r4.intValue() == 0) goto L14;
        r4.intValue();
        if (r4.intValue() == 1) goto L9;
        String r5 = "radio";
    L13:
        r3.put("function_type", r5);
        r3.put("function_type2", r5);
        return;
    L9:
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L11;
        r5 = "new_audience";
        goto L13
    L11:
        r5 = "audience";
        goto L13
    }

    @JvmStatic
    public static final void l(Map<String, String> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (r4 != 1) goto L5;
    L10:
        r3.put("live_type", "video_live");
        return;
    L5:
        if (r4 == 4) goto L10;
        if (r4 != 8) goto L13;
        r3.put("live_type", "video_live");
        return;
    }

    @JvmStatic
    public static final void n(Map<String, String> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        if (r4 != null) goto L6;
    L8:
        String r1 = "";
    L9:
        r3.put("pk_id", r1);
        if (r4 != null) goto L13;
    L15:
        String r5 = "0";
    L16:
        r3.put("is_in_pk", r5);
        return;
    L13:
        if (r4.intValue() != 1) goto L15;
        r5 = "1";
        goto L16
    L6:
        if (r4.intValue() != 1) goto L8;
        r1 = f();
        goto L9
    }

    public static void q(Map r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "logMap");
        Intrinsics.checkNotNullParameter(r8, "songList");
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder();
        Iterator r9 = r8.iterator();
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L12;
        Object r3 = r9.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KtvMusic r5 = (KtvMusic) r3;
        if (r2 <= 0) goto L11;
        r0.append(",");
        r1.append(",");
    L11:
        r0.append(r5.getMId());
        r1.append(r5.getMTitle());
        r2 = r4;
        goto L4
    L12:
        r7.put("song_id", r0.toString());
        r7.put("song_name", r1.toString());
    }

    @JvmStatic
    public static final void h(String r5, Integer r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("request_page", r5);
        r0.put("play_mode", w.a());
        int r8 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        l(r0, r8);
        j(r0, Integer.valueOf(r8));
        p(r0);
        Intrinsics.checkNotNullParameter(r0, "logMap");
        r0.put("guest_connection_type", "live_chat");
        r0.put("user_id", k.n(IUserService.class).user().n());
        r0.put("user_type", e());
        if (r6 == null) goto L5;
        r0.put("link_cnt", String.valueOf(r6.intValue()));
    L5:
        if (r7 == null) goto L20;
        String r4 = null;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L16;
        m r10 = r9.getRoom();
        if (r10 == null) goto L16;
        Room r11 = (Room) r10.getValue();
        if (r11 == null) goto L16;
        User r12 = r11.getOwner();
        if (r12 == null) goto L16;
        r4 = r12.getIdStr();
    L16:
        if (Intrinsics.areEqual(r7, r4) == false) goto L18;
        String r13 = "anchor";
    L19:
        r0.put("mute_user_type", r13);
        goto L20
    L18:
        r13 = "guest";
    L20:
        o(r0);
        n(r0, Integer.valueOf(r8));
        u.l().sendLog("livesdk_guest_connection_mute", r0, new Object[]{x.class, Room.class});
    }

    public static void b(r r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "emoji");
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r7 = "anchor";
    L6:
        r0.put("user_type", r7);
        r0.put("user_id", k.n(IUserService.class).user().n());
        r0.put("request_page", r6);
        if (r3.isRandomEmoji == false) goto L9;
        String r8 = "random";
    L10:
        r0.put("emoji_type", r8);
        r0.put("emoji_id", String.valueOf(r3.emojiId));
        r0.put("emoji_name", r3.emojiName);
        r0.put("emoji_status", String.valueOf(r3.emojiStatus));
        if (r5 == false) goto L13;
        String r9 = "self";
    L14:
        r0.put("interact_type", r9);
        if (r3.isDigitAvatarEmoji() == false) goto L17;
        String r10 = "1";
    L18:
        r0.put("is_avatar_emoji", r10);
        u.l().sendLog("livesdk_chat_emoji_click", r0, new Object[]{x.class, Room.class});
        return;
    L17:
        r10 = "0";
        goto L18
    L13:
        r9 = "others";
        goto L14
    L9:
        r8 = "normal";
        goto L10
    L5:
        r7 = "guest";
        goto L6
    }

    public static void c(boolean r2, String r3, r r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        Intrinsics.checkNotNullParameter(r4, "emoji");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == false) goto L5;
        String r6 = "anchor";
    L6:
        r0.put("user_type", r6);
        r0.put("user_id", k.n(IUserService.class).user().n());
        r0.put("request_page", r3);
        o(r0);
        if (r4.isRandomEmoji == false) goto L9;
        String r7 = "random";
    L10:
        r0.put("emoji_type", r7);
        r0.put("emoji_id", String.valueOf(r4.emojiId));
        r0.put("emoji_name", r4.emojiName);
        r0.put("emoji_status", String.valueOf(r4.emojiStatus));
        if (r5 == false) goto L13;
        String r8 = "self";
    L14:
        r0.put("interact_type", r8);
        if (r4.isDigitAvatarEmoji() == false) goto L17;
        String r9 = "1";
    L18:
        r0.put("is_avatar_emoji", r9);
        u.l().sendLog("livesdk_chat_emoji_show", r0, new Object[]{x.class, Room.class});
        return;
    L17:
        r9 = "0";
        goto L18
    L13:
        r8 = "others";
        goto L14
    L9:
        r7 = "normal";
        goto L10
    L5:
        r6 = "guest";
        goto L6
    }

    @JvmStatic
    public static final void d(boolean r4, String r5, int r6, r r7, String r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r7, "emoji");
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = "anchor";
        if (r4 == false) goto L5;
        Object r10 = "anchor";
    L6:
        r0.put("user_type", r10);
        r0.put("user_id", k.n(IUserService.class).user().n());
        r0.put("request_page", r5);
        l(r0, r6);
        j(r0, Integer.valueOf(r6));
        o(r0);
        if (r7.isRandomEmoji == false) goto L9;
        String r11 = "random";
    L10:
        r0.put("emoji_type", r11);
        r0.put("emoji_id", String.valueOf(r7.emojiId));
        String r12 = r7.emojiName;
        if (r12 == null) goto L14;
        r0.put("emoji_name", r12);
    L14:
        if (r7.isInteractEmoji() == false) goto L16;
        String r13 = "others";
    L17:
        r0.put("interact_type", r13);
        String r14 = "0";
        if (r7.isSoundEmoji() == false) goto L20;
        Object r15 = "1";
    L21:
        r0.put("is_voice", r15);
        if (r8 == null) goto L29;
        r0.put("to_user_id", r8);
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L27;
        r1 = "guest";
    L27:
        r0.put("to_user_type", r1);
    L29:
        if (r7.isDigitAvatarEmoji() == false) goto L31;
        r14 = "1";
    L31:
        r0.put("is_avatar_emoji", r14);
        r0.put("channel_id", String.valueOf(p.a().getChannelId()));
        r0.put("pk_id", f());
        r0.put("is_in_pk", "1");
        r0.put("voice_mode", "head");
        u.l().sendLog("livesdk_chat_emoji_send", r0, new Object[]{x.class, Room.class});
        return;
    L20:
        r15 = "0";
        goto L21
    L16:
        r13 = "self";
        goto L17
    L9:
        r11 = "normal";
        goto L10
    L5:
        r10 = "guest";
        goto L6
    }
}
