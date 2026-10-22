package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatParamUtils {
    public static String a;
    public static Chat b;
    public static String c;
    public static Chatter d;
    public static String e;
    public static String f;
    public static final Lazy g = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r0[Message.Type.TEXT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r0[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[Message.Type.TEXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r0[Message.Type.IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r0[Message.Type.SYSTEM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r0[Message.Type.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r0[Message.Type.EMAIL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r0[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r0[Message.Type.STICKER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r0[Message.Type.MERGE_FORWARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r0[Message.Type.CALENDAR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r0[Message.Type.CARD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r0[Message.Type.MEDIA.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r0[Message.Type.SHARE_CALENDAR_EVENT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r0[Message.Type.RED_PACKET.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r0[Message.Type.GENERAL_CALENDAR.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r0[Message.Type.VIDEO_CHAT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r0[Message.Type.LOCATION.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r0[Message.Type.COMMERCIALIZED_HONGBAO.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r0[Message.Type.SHARE_USER_CARD.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r0[Message.Type.TODO.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r0[Message.Type.FOLDER.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            a = r0;
        }
    }

    static {
        g = LazyKt.lazy(ChatParamUtils$statistics$2.INSTANCE);
    }

    @Deprecated(message = "not have correct chat in some case", replaceWith = @ReplaceWith(expression = "getChatParamMap", imports = {}))
    @JvmStatic
    public static final Map<String, Object> e() {
        return f(a);
    }

    @JvmStatic
    public static final String c(Chat r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isP2PChat() == false) goto L6;
        return "single";
    L6:
        if (r1.isThread() == false) goto L8;
        return "topic";
    L8:
        return "group";
    }

    @JvmStatic
    public static final String d(Chat r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isMeeting() == false) goto L6;
        return "meeting";
    L6:
        if (r3.is_department() == false) goto L9;
        return "department";
    L9:
        if (r3.isTenant() == false) goto L12;
        return "all_staff";
    L12:
        if (r3.isOnCall() == false) goto L15;
        return "on_call";
    L15:
        if (r3.isCustomerService() == false) goto L18;
        return "customer_service";
    L18:
        if (r3.isThread() == false) goto L20;
        return "topic";
    L20:
        boolean r1 = true;
        if (r3.isGroup() == false) goto L26;
        if (r3.getMemberCount() != 1) goto L26;
        return "to_myself_group";
    L26:
        if (r3.isSoloChat() == false) goto L29;
        return "to_myself_single";
    L29:
        if (r3.isAIChat() == false) goto L31;
        return "single_ai";
    L31:
        Chatter r0 = d;
        if (r0 != null) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == false) goto L40;
        return "single_bot";
    L40:
        if (r3.isP2PChat() == false) goto L42;
        return "single_normal";
    L42:
        return "classic";
    L34:
        if (r0.isBot() != true) goto L36;
        goto L36
    }

    @JvmStatic
    public static final Map<String, Object> f(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r2, a) == false) goto L19;
        Chat r3 = b;
        if (r3 == null) goto L21;
        if (r3 != null) goto L18;
        return null;
    L18:
        return a(r3, c, d);
    L21:
        return null;
    L19:
        return null;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public static Map g(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("msg_id", r3.getId());
        String r1 = r3.getcId();
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0[1] = TuplesKt.to("cid", r1);
        r0[2] = TuplesKt.to("msg_type", k(r3.getType()));
        return MapsKt.mapOf(r0);
    }

    public static Map h(y6b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "absMessageVO");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r3.getId()), TuplesKt.to("cid", r3.getcId()), TuplesKt.to("msg_type", k(r3.getType()))});
    }

    public static Map i(y6b.c r3) {
        Intrinsics.checkNotNullParameter(r3, "chatMessageVO");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r3.c), TuplesKt.to("cid", r3.d), TuplesKt.to("msg_type", k(r3.getType()))});
    }

    public static String k(Message.Type r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(a.a[r1.ordinal()]) {
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L15;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L12;
            case 18: goto L11;
            case 19: goto L10;
            case 20: goto L9;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L6;
            case 24: goto L5;
            default: goto L27;
        };
    L5:
        return "folder";
    L6:
        return "todo";
    L7:
        return "shareUserCard";
    L8:
        return "commercializedHongbao";
    L9:
        return "location";
    L10:
        return "video_chat";
    L11:
        return "generalCalendar";
    L12:
        return "hongbao";
    L13:
        return "shareCalendarEvent";
    L14:
        return "media";
    L15:
        return BrowserDependency.UrlClickType.CARD;
    L16:
        return ChatFromType.CALENDAR;
    L17:
        return "mergeForward";
    L18:
        return "sticker";
    L19:
        return "shareGroupChat";
    L20:
        return "email";
    L21:
        return "audio";
    L22:
        return "system";
    L23:
        return "image";
    L24:
        return "text";
    L25:
        return "file";
    L26:
        return "post";
    L27:
        return "unknown";
    }

    @JvmStatic
    public static final void l(Chatter r3) {
        Intrinsics.checkNotNullParameter(r3, "chatter");
        Chat r0 = b;
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.isP2PChat();
    L6:
        if (r2 == false) goto L14;
        Chat r4 = b;
        if (r4 == null) goto L10;
        String r5 = r4.getP2pChatterId();
    L12:
        if (Intrinsics.areEqual(r5, r3.getId()) == false) goto L14;
        r1 = true;
        goto L14
    L10:
        r5 = null;
    L14:
        if (r1 == false) goto L17;
        d = r3;
        return;
    L17:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @JvmStatic
    public static final Map<String, Object> a(Chat r7, String r8, Chatter r9) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        Pair[] r0 = new Pair[10];
        int r2 = 0;
        r0[0] = TuplesKt.to("chat_id", r7.getId());
        r0[1] = TuplesKt.to("chat_type", c(r7));
        r0[2] = TuplesKt.to("chat_type_detail", d(r7));
        if (r7.isGroup() == false) goto L8;
        if (Intrinsics.areEqual(r8, r7.getOwnerId()) == false) goto L8;
        String r10 = "group_owner";
    L11:
        r0[3] = TuplesKt.to("member_type", r10);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r4 = "true";
        if (r7.isCrossTenant() == true) goto L14;
        Object r1 = "true";
    L15:
        r0[4] = TuplesKt.to("is_inner_group", r1);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.isPublic() == true) goto L19;
        r4 = "false";
    L19:
        r0[5] = TuplesKt.to("is_public_group", r4);
        if (r9 != null) goto L23;
        r9 = d;
    L23:
        if (r7.isP2PChat() == false) goto L29;
        if (r9 == null) goto L29;
        if (r9.isBot() == false) goto L29;
        r2 = 1;
    L32:
        r0[6] = TuplesKt.to("bot_count", Integer.valueOf(r2));
        if (r7.getChatDisplayModeSetting() != ChatDisplayModeSetting.THREAD) goto L35;
        String r11 = "thread";
    L36:
        r0[7] = TuplesKt.to("group_mode", r11);
        String r12 = e;
        if (r12 != null) goto L39;
        r12 = "im_chat_view";
    L39:
        r0[8] = TuplesKt.to("scene", r12);
        String r13 = f;
        if (r13 != null) goto L42;
        r13 = "other";
    L42:
        r0[9] = TuplesKt.to(ChameleonOpenTracker.ParamKey.APP_NAME, r13);
        Map<String, Object> r14 = MapsKt.mutableMapOf(r0);
        if (r7.isAIChat() == false) goto L45;
        r14.put("shadow_id", r7.getP2pChatterId());
    L45:
        return r14;
    L35:
        r11 = "normal";
    L29:
        if (r7.isP2PChat() == true) goto L32;
        r2 = r7.getMemberCount() - r7.getUserCount();
        goto L32
    L14:
        r1 = "false";
    L8:
        if (r7.isAdmin() == false) goto L10;
        r10 = "group_admin";
        goto L11
    L10:
        r10 = "normal_member";
        goto L11
    }

    public static /* synthetic */ Map b(Chat r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return a(r1, r2, null);
    }

    @JvmStatic
    public static final void j(String r3, String r4, Chat r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        boolean r0 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(a, r3) == false) goto L13;
        return;
    L13:
        if (r4.length() != 0) goto L15;
        r0 = true;
    L15:
        if (r0 == true) goto L21;
        a = r3;
        c = r4;
        b = r5;
        e = r6;
        f = r7;
        return;
    L21:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
