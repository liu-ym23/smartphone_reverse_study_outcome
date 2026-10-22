package nh0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final /* synthetic */ int i = 0;
    public final String a;
    public final e b;
    public final List<ILinkPlayerInfoBridge> c;
    public final List<tf0.e> d;
    public final sf0.b e;
    public final JsonObject f;
    public final String g;
    public final boolean h;

    public static final class a {
        @JvmStatic
        public static int a(ch0.e r3) {
            Intrinsics.checkNotNullParameter(r3, "mergeData");
            cg6.a r0 = null;
            if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r3, null) == false) goto L22;
            IMultiLinkInternalService r1 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
            if (r1 == null) goto L8;
            r0 = r1.getMultiLinkComponentService(null, com.bytedance.android.live.liveinteract.api.utils.m.i());
        L8:
            if (r0 == null) goto L13;
            hg6.g r2 = r0.getRtcManager();
            if (r2 == null) goto L13;
            if (r2.A() != true) goto L13;
        L19:
            if (r3.a.getLinkType() == 3) goto L26;
        L21:
            return 1;
        L26:
            return 3;
        L13:
            ch0.j r4 = r3.c;
            if (r4 == null) goto L19;
            if (r4.c != 3) goto L21;
            return 3;
        L22:
            return 2;
        }

        @JvmStatic
        public static JsonObject b(ILinkPlayerInfoBridge r11) {
            Intrinsics.checkNotNullParameter(r11, "linkPlayerInfo");
            JsonObject r0 = new JsonObject();
            IBaseUser r1 = r11.getUser();
            Boolean r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getIdString();
        L6:
            r0.addProperty("id_str", r3);
            IBaseUser r4 = r11.getUser();
            if (r4 == null) goto L9;
            Long r5 = Long.valueOf(r4.getShortId());
        L10:
            r0.addProperty("short_id", r5);
            IBaseUser r6 = r11.getUser();
            if (r6 == null) goto L13;
            Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
            String r7 = r6.getCastSecUid();
        L14:
            r0.addProperty("sec_uid", r7);
            IBaseUser r8 = r11.getUser();
            if (r8 == null) goto L17;
            String r9 = r8.getRealNickName();
        L18:
            r0.addProperty("nickname", r9);
            IBaseUser r10 = r11.getUser();
            if (r10 == null) goto L21;
            Boolean r12 = Boolean.valueOf(r10.isAnonymous());
        L22:
            r0.addProperty("is_anonymous", r12);
            IBaseUser r13 = r11.getUser();
            if (r13 == null) goto L25;
            String r14 = r13.getSignature();
        L26:
            r0.addProperty("signature", r14);
            IBaseUser r15 = r11.getUser();
            if (r15 == null) goto L31;
            py.k r16 = r15.getAvatarThumbKt();
            if (r16 == null) goto L31;
            List r17 = r16.getUrls();
        L33:
            if (r17 == null) goto L35;
            int r18 = r17.size();
        L36:
            String r19 = "";
            if (r18 <= 0) goto L43;
            if (r17 == null) goto L41;
            String r20 = (String) ListProtector.get(r17, 0);
            if (r20 == null) goto L41;
        L42:
            r0.addProperty("avatar", r20);
        L41:
            r20 = "";
        L43:
            IBaseUser r21 = r11.getUser();
            if (r21 == null) goto L48;
            py.k r22 = r21.getAvatarMedium();
            if (r22 == null) goto L48;
            List r23 = r22.getUrls();
        L49:
            if (r23 == null) goto L51;
            int r24 = r23.size();
        L52:
            if (r24 <= 0) goto L58;
            if (r23 == null) goto L56;
            String r25 = (String) ListProtector.get(r23, 0);
            if (r25 == null) goto L56;
        L57:
            r0.addProperty("avatar_medium", r25);
        L56:
            r25 = "";
        L58:
            IBaseUser r26 = r11.getUser();
            if (r26 == null) goto L63;
            py.k r27 = r26.getAvatarLarge();
            if (r27 == null) goto L63;
            List r28 = r27.getUrls();
        L64:
            if (r28 == null) goto L66;
            int r29 = r28.size();
        L67:
            if (r29 <= 0) goto L73;
            if (r28 == null) goto L71;
            String r30 = (String) ListProtector.get(r28, 0);
            if (r30 == null) goto L71;
        L72:
            r0.addProperty("avatar_large", r30);
        L71:
            r30 = "";
        L73:
            JsonObject r31 = new JsonObject();
            r31.addProperty("link_type", Integer.valueOf(r11.getLinkType()));
            r31.addProperty("silence_status", Integer.valueOf(r11.getSilenceStatus()));
            r31.addProperty("linkmic_id_str", r11.getInteractId());
            r31.addProperty("is_enlarged", Boolean.valueOf(r11.isEnlarged()));
            r31.addProperty("user_position", Integer.valueOf(r11.getUserPosition()));
            InteractiveSongContext r32 = InteractiveSongContext.Companion.getContext();
            if (r32 == null) goto L84;
            ConcurrentHashMap<String, pf0.a> r33 = r32.getGuestListInteractiveSongInfo();
            if (r33 == null) goto L84;
            IBaseUser r34 = r11.getUser();
            if (r34 == null) goto L80;
            String r35 = r34.getIdString();
        L81:
            pf0.a r36 = r33.get(r35);
            if (r36 == null) goto L84;
            int r37 = r36.b;
        L85:
            r31.addProperty("golden_mic_count", Integer.valueOf(r37));
            r31.addProperty("fan_ticket_str", r11.getFanTicketDisplayStr());
            if (r11.getSilenceStatus() == 0) goto L88;
            boolean r38 = true;
        L89:
            r31.addProperty("is_mute", Boolean.valueOf(r38));
            IBaseUser r39 = r11.getUser();
            if (r39 == null) goto L94;
            py.t r40 = r39.getUserAttr();
            if (r40 == null) goto L94;
            boolean r41 = r40.isAdmin();
        L95:
            r31.addProperty("is_admin", Boolean.valueOf(r41));
            r31.addProperty("expected_leave_time", Long.valueOf(r11.getExpectLeaveTime()));
            r31.addProperty("join_channel_time", Long.valueOf(r11.getJoinChannelTime()));
            r31.addProperty("paid_count", Long.valueOf(r11.getPaidCount()));
            kd1.b r42 = r11.getMicDress();
            if (r42 == null) goto L104;
            kd1.c r43 = r42.getVoiceWave();
            if (r43 == null) goto L104;
            py.k r44 = r43.getMediumImg();
            if (r44 == null) goto L104;
            List r45 = r44.getUrls();
            if (r45 == null) goto L104;
            String r46 = (String) CollectionsKt.firstOrNull(r45);
        L105:
            r31.addProperty("mic_dress", r46);
            r31.addProperty("self_discipline_duration", Long.valueOf(r11.getSelfDisciplineDuration()));
            r31.addProperty("self_discipline_target_duration", Long.valueOf(r11.getSelfDisciplineTargetDuration()));
            r31.add("user", r0);
            kd1.b r47 = r11.getMicDress();
            if (r47 == null) goto L117;
            kd1.c r48 = r47.getVoiceWave();
            if (r48 == null) goto L117;
            py.k r49 = r48.getMediumImg();
            if (r49 == null) goto L117;
            List r50 = r49.getUrls();
            if (r50 == null) goto L117;
            String r51 = (String) ListProtector.get(r50, 0);
            if (r51 == null) goto L117;
            r19 = r51;
        L117:
            r31.addProperty("mic_dress", r19);
            if (tc0.c.h().o != null) goto L120;
        L130:
            g0 r52 = r11.getMicPosTagInfo();
            if (r52 == null) goto L139;
            JsonObject r53 = new JsonObject();
            r53.addProperty("tag_name", r52.getPositionTagName());
            r53.addProperty("text_color_value", r52.getTextColor());
            r53.addProperty("bg_color_value", r52.getBgColor());
            r53.addProperty("tag_type_id", Long.valueOf(r52.getTagTypeId()));
            py.k r54 = r52.getBgColorImg();
            if (r54 == null) goto L137;
            List r55 = r54.getUrls();
            if (r55 == null) goto L137;
            String r56 = (String) CollectionsKt.firstOrNull(r55);
        L138:
            r53.addProperty("bg_color_img", r56);
            r53.addProperty("open_tag_desc_page", Boolean.valueOf(r52.getOpenTagDescPage()));
            r53.addProperty("schema", r52.getSchema());
            r31.add("tag_info", r53);
        L137:
            r56 = null;
        L139:
            JsonObject r57 = new JsonObject();
            JsonObject r58 = new JsonObject();
            r58.addProperty("themed_competition_role", Integer.valueOf(r11.getThemedCompetitionRole()));
            r58.addProperty("chorus_guest_status", Long.valueOf(r11.getChorusGuestStatus()));
            r58.addProperty("ai_guest_type", Integer.valueOf(r11.getAiGuestType()));
            r58.addProperty("is_mic_hidden", Boolean.valueOf(r11.isMicHidden()));
            r58.addProperty("expected_leave_time", Long.valueOf(r11.getExpectLeaveTime()));
            r58.addProperty("fanTicket", Long.valueOf(r11.getFanTicket()));
            r58.addProperty("origin_link_type", Long.valueOf(r11.getOriginLinkType()));
            r58.addProperty("join_channel_time", Long.valueOf(r11.getJoinChannelTime()));
            r58.addProperty("client_version", Long.valueOf(r11.getClientVersion()));
            if (MultiLinkLoadWidgetUtils.k() == false) goto L153;
            JsonObject r59 = new JsonObject();
            Linkmic2DAvatar r60 = r11.getLinkmic2DAvatar();
            if (r60 == null) goto L148;
            py.k r61 = r60.getImage();
            if (r61 == null) goto L148;
            List r62 = r61.getUrls();
            if (r62 == null) goto L148;
            String r63 = (String) CollectionsKt.firstOrNull(r62);
        L149:
            r59.addProperty("image", r63);
            Linkmic2DAvatar r65 = r11.getLinkmic2DAvatar();
            if (r65 == null) goto L152;
            r2 = r65.getEnableAvatar();
        L152:
            r59.addProperty("enable_avatar", r2);
            r58.add("linkmic_2d_avatar", r59);
        L148:
            r63 = null;
        L153:
            r57.add("linkmic_audience_content", r58);
            r31.add("content", r57);
            r31.addProperty("mc_status", Long.valueOf(r11.getMcStatus()));
            r31.addProperty("ai_guest_type", Integer.valueOf(r11.getAiGuestType()));
            r31.addProperty("is_mic_hidden", Boolean.valueOf(r11.isMicHidden()));
            return r31;
        L120:
            if (r11.getOtherRoomInfo() == null) goto L122;
            Map.Entry<Long, g2> r66 = r11.getOtherRoomInfo();
        L127:
            JsonObject r67 = new JsonObject();
            if (r66 == null) goto L130;
            r67.addProperty("anchor_id", r66.getValue().getAnchorIdString());
            r67.addProperty("anchor_id_str", r66.getValue().getAnchorIdString());
            r67.addProperty("is_anchor_background", Long.valueOf(r66.getValue().isGuestAnchorBackground()));
            r67.addProperty("room_link_silence_status", Integer.valueOf(r66.getValue().getRoomLinkSilenceStatus()));
            r67.addProperty("room_id", r66.getKey());
            r67.addProperty("room_id_str", String.valueOf(r66.getKey().longValue()));
            r67.addProperty("live_room_mode", Long.valueOf(r66.getValue().getLiveRoomMode()));
            r31.add("other_linker_content", r67);
            goto L130
        L122:
            tc0.c r68 = tc0.c.h();
            IBaseUser r69 = r11.getUser();
            if (r69 == null) goto L125;
            String r70 = r69.getIdString();
        L126:
            r66 = r68.g(r70);
            goto L127
        L125:
            r70 = null;
        L104:
            r46 = null;
        L94:
            r41 = false;
            goto L95
        L88:
            r38 = false;
            goto L89
        L80:
            r35 = null;
        L84:
            r37 = 0;
            goto L85
        L66:
            r29 = 0;
        L63:
            r28 = null;
            goto L64
        L51:
            r24 = 0;
        L48:
            r23 = null;
            goto L49
        L35:
            r18 = 0;
        L31:
            r17 = null;
            goto L33
        L25:
            r14 = null;
            goto L26
        L21:
            r12 = null;
            goto L22
        L17:
            r9 = null;
            goto L18
        L13:
            r7 = null;
            goto L14
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public f() {
        this(null, null, null, null, null, null, false, 255);
    }

    public final JsonObject a() {
        String r1 = this.a;
        Object r4 = null;
        switch(r1.hashCode()) {
            case -1753865563: goto L203;
            case -1161996417: goto L103;
            case -582258636: goto L76;
            case -160687137: goto L30;
            case 3526149: goto L22;
            case 177093645: goto L6;
            default: goto L312;
        };
    L312:
        JsonObject r2 = this.f;
        if (r2 == null) goto L315;
        return r2;
    L315:
        return null;
    L6:
        if (r1.equals("linkmic") == false) goto L312;
        if (this.b == null) goto L315;
        JsonObject r3 = new JsonObject();
        r3.addProperty("scene", Integer.valueOf(this.b.a));
        r3.addProperty("ui_layout", Integer.valueOf(this.b.b));
        r3.addProperty("from_scene", Integer.valueOf(this.b.d));
        r3.addProperty("from_ui_layout", Integer.valueOf(this.b.e));
        JsonArray r5 = new JsonArray();
        Iterator<T> r6 = this.b.c.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r5.add(Integer.valueOf(((Number) r6.next()).intValue()));
        goto L11
    L13:
        r3.add("play_mode", r5);
        JsonArray r7 = new JsonArray();
        List<Integer> r8 = this.b.f;
        if (r8 == null) goto L19;
        Iterator<T> r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        r7.add(Integer.valueOf(((Number) r9.next()).intValue()));
    L19:
        r3.add("from_play_mode", r7);
        return r3;
    L22:
        if (r1.equals("seat") == false) goto L312;
        if (this.c != null) goto L28;
        if (this.d == null) goto L315;
    L28:
        return b();
    L30:
        if (r1.equals("fanticket") == false) goto L312;
        if (this.d == null) goto L315;
        JsonObject r10 = new JsonObject();
        List<tf0.e> r11 = this.d;
        if (r11 == null) goto L74;
        Iterator<T> r12 = r11.iterator();
        int r13 = 0;
    L37:
        if (r12.hasNext() == false) goto L74;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        tf0.e r16 = (tf0.e) r14;
        if ((r16 instanceof MultiLinkGuestViewBinder.a) == false) goto L73;
        JsonObject r17 = new JsonObject();
        MultiLinkGuestViewBinder.a r18 = (MultiLinkGuestViewBinder.a) r16;
        r17.addProperty("fan_ticket_str", r18.k.a.getFanTicketDisplayStr());
        r17.addProperty("fanticket", Long.valueOf(r18.k.a.getFanTicket()));
        Object r19 = r18.k.d.get("EXT_KEY_QUICK_INTERACT_MESSAGE");
        if ((r19 instanceof QuickInteractTask) == true) goto L46;
        r19 = null;
    L46:
        QuickInteractTask r20 = (QuickInteractTask) r19;
        if (r20 == null) goto L52;
        com.bytedance.android.live.liveinteract.plantform.model.l r21 = r20.m;
        if (r21 == null) goto L52;
        r17.add("quick_interact", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r21).getAsJsonObject());
    L52:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L54;
        r18.k.d.remove("EXT_KEY_QUICK_INTERACT_MESSAGE");
    L54:
        Object r110 = r18.k.d.get("EXT_KEY_QUICK_INTERACT_TASK");
        if ((r110 instanceof QuickInteractTask) == true) goto L57;
        r110 = null;
    L57:
        QuickInteractTask r111 = (QuickInteractTask) r110;
        if (r111 == null) goto L67;
        com.bytedance.android.live.liveinteract.plantform.model.l r112 = r111.m;
        if (r112 == null) goto L67;
        if (r111.getType() != 0) goto L65;
        r17.add("quick_interact", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r112).getAsJsonObject());
    L65:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(null, 0, 7) == false) goto L67;
        r18.k.d.remove("EXT_KEY_QUICK_INTERACT_TASK");
    L67:
        IBaseUser r22 = r18.k.a.getUser();
        if (r22 == null) goto L70;
        String r23 = r22.getIdString();
    L71:
        if (r23 == null) goto L73;
        r10.add(r23, r17);
        goto L73
    L70:
        r23 = null;
    L73:
        r13 = r15;
    L74:
        return r10;
    L76:
        if (r1.equals("avatar_event") == false) goto L312;
        List<tf0.e> r24 = this.d;
        if (r24 == null) goto L99;
        tf0.e r25 = (tf0.e) CollectionsKt.firstOrNull(r24);
        if ((r25 instanceof MultiLinkGuestViewBinder.a) == true) goto L82;
        r25 = null;
    L82:
        MultiLinkGuestViewBinder.a r26 = (MultiLinkGuestViewBinder.a) r25;
        if (r26 == null) goto L85;
        ch0.e r27 = r26.k;
    L86:
        if (r27 == null) goto L90;
        Map<String, Object> r28 = r27.d;
        if (r28 == null) goto L90;
        Object r29 = r28.get("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION");
    L92:
        if ((r29 instanceof com.bytedance.android.live.liveinteract.hamlet.model.l) == false) goto L95;
        r4 = r29;
    L95:
        com.bytedance.android.live.liveinteract.hamlet.model.l r30 = (com.bytedance.android.live.liveinteract.hamlet.model.l) r4;
        JsonObject r31 = new JsonObject();
        if (r30 == null) goto L98;
        r31.addProperty("type", "avatar_chest_position");
        JsonObject r32 = new JsonObject();
        r32.addProperty("x", r30.a());
        r32.addProperty("y", r30.b());
        Unit r33 = Unit.INSTANCE;
        r31.add("data", r32);
    L98:
        return r31;
    L90:
        r29 = null;
        goto L92
    L85:
        r27 = null;
        goto L86
    L99:
        JsonObject r34 = this.f;
        if (r34 == null) goto L315;
        return r34;
    L103:
        if (r1.equals("order_sing_visual") == false) goto L312;
        if (this.d == null) goto L315;
        JsonObject r35 = new JsonObject();
        new JsonArray();
        e r36 = this.b;
        if (r36 == null) goto L111;
        List<Long> r37 = r36.h;
        if (r37 == null) goto L111;
        boolean r38 = r37.contains(4L);
    L112:
        if (r38 == true) goto L124;
        CustomizeStreamContext r39 = CustomizeStreamContext.Companion.getContext();
        if (r39 == null) goto L120;
        com.bytedance.live.datacontext.m<Boolean> r40 = r39.getCustomizeStreamStarted();
        if (r40 == null) goto L120;
        Boolean r41 = (Boolean) r40.getValue();
        if (r41 == null) goto L120;
        boolean r42 = r41.booleanValue();
    L121:
        if (r42 == true) goto L124;
        boolean r43 = false;
    L125:
        List<tf0.e> r44 = this.d;
        if (r44 == null) goto L200;
        Iterator<T> r45 = r44.iterator();
        int r46 = 0;
    L129:
        if (r45.hasNext() == false) goto L200;
        Object r113 = r45.next();
        int r114 = r46 + 1;
        if (r46 >= 0) goto L133;
        CollectionsKt.throwIndexOverflow();
    L133:
        tf0.e r115 = (tf0.e) r113;
        boolean r47 = r115 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a;
        if (r47 == true) goto L143;
        e r116 = this.b;
        if (r116 == null) goto L142;
        if (r116.b != 30) goto L142;
        if ((r115 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L143;
    L142:
        r46 = r114;
    L143:
        e r48 = this.b;
        if (r48 != null) goto L146;
    L153:
        if (r47 == true) goto L155;
        r115 = null;
    L155:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r117 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r115;
        if (r117 == null) goto L158;
        ch0.e r49 = r117.k;
    L159:
        r35.addProperty("is_visual", Boolean.valueOf(!r43));
        InteractiveSongContext.a r50 = InteractiveSongContext.Companion;
        e r51 = this.b;
        if (r51 == null) goto L162;
        int r52 = r51.b;
    L164:
        if (InteractiveSongContext.a.d(r50, r49, r52, false, 4) == false) goto L167;
        if (r43 == true) goto L167;
        int r53 = 2;
    L186:
        r35.addProperty("visual_type", Integer.valueOf(r53));
        if (r49 == null) goto L198;
        ILinkPlayerInfoBridge r54 = r49.a;
        if (r54 == null) goto L198;
        Linkmic2DAvatar r55 = r54.getLinkmic2DAvatar();
        if (r55 == null) goto L198;
        py.k r56 = r55.getImage();
        if (r56 == null) goto L198;
        List r57 = r56.getUrls();
        if (r57 == null) goto L198;
        String r58 = (String) CollectionsKt.firstOrNull(r57);
        if (r58 == null) goto L198;
    L199:
        r35.addProperty("avatar_2d_url", r58);
    L201:
        return r35;
    L198:
        r58 = "";
    L167:
        if (r49 == null) goto L173;
        ILinkPlayerInfoBridge r59 = r49.a;
        if (r59 == null) goto L173;
        Linkmic2DAvatar r60 = r59.getLinkmic2DAvatar();
        if (r60 == null) goto L173;
        Boolean r61 = r60.getEnableAvatar();
    L175:
        if (Intrinsics.areEqual(r61, Boolean.TRUE) == false) goto L181;
        Linkmic2DAvatar r62 = r49.a.getLinkmic2DAvatar();
        if (r62 == null) goto L179;
        r4 = r62.getImage();
    L179:
        if (r4 == null) goto L181;
        boolean r63 = true;
    L182:
        if (r63 == false) goto L185;
        if (r43 == true) goto L185;
        r53 = 1;
    L185:
        r53 = 0;
    L181:
        r63 = false;
    L173:
        r61 = null;
        goto L175
    L162:
        r52 = 0;
    L158:
        r49 = null;
        goto L159
    L146:
        if (r48.b != 30) goto L153;
        if ((r115 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L150;
        r115 = null;
    L150:
        MultiLinkAudioFirstUserViewBinder.a r118 = (MultiLinkAudioFirstUserViewBinder.a) r115;
        if (r118 == null) goto L158;
        r49 = r118.k;
    L200:
        r35.addProperty("is_visual", Boolean.FALSE);
    L120:
        r42 = false;
    L124:
        r43 = true;
    L111:
        r38 = false;
        goto L112
    L203:
        if (r1.equals("guest_list") == false) goto L312;
        if (this.d == null) goto L315;
        JsonObject r65 = new JsonObject();
        JsonArray r66 = new JsonArray();
        List<tf0.e> r67 = this.d;
        if (r67 == null) goto L310;
        Iterator<T> r68 = r67.iterator();
        int r69 = 0;
    L210:
        if (r68.hasNext() == false) goto L310;
        Object r119 = r68.next();
        int r120 = r69 + 1;
        if (r69 >= 0) goto L214;
        CollectionsKt.throwIndexOverflow();
    L214:
        tf0.e r121 = (tf0.e) r119;
        if ((r121 instanceof MultiLinkGuestViewBinder.a) == false) goto L309;
        MultiLinkGuestViewBinder.a r122 = (MultiLinkGuestViewBinder.a) r121;
        JsonObject r123 = a.b(r122.k.a);
        ch0.e r124 = r122.k;
        MultiLinkFrequencyOptConfig r125 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        boolean r126 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r124, this.g);
        IMultiLinkInternalService r127 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r127 == null) goto L219;
        cg6.a r70 = r127.getMultiLinkComponentService(null, com.bytedance.android.live.liveinteract.api.utils.m.i());
    L220:
        if (r126 == false) goto L236;
        int r128 = 3;
        if (r70 == null) goto L227;
        hg6.g r71 = r70.getRtcManager();
        if (r71 == null) goto L227;
        if (r71.A() != true) goto L227;
    L233:
        if (r124.a.getLinkType() == 3) goto L237;
    L235:
        r128 = 1;
    L237:
        r123.addProperty("user_position", Integer.valueOf(r69));
        if (this.h == true) goto L240;
        r123.addProperty("link_type", Integer.valueOf(r128));
    L240:
        if (r124 == null) goto L303;
        boolean r72 = r124.a.isBackground();
        ILinkPlayerInfoBridge r73 = r124.a;
        if (r73.getSilenceStatus() == 0) goto L245;
        boolean r129 = true;
    L246:
        String r130 = this.g;
        if (r130 != null) goto L254;
        com.bytedance.live.datacontext.m r131 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r131 == null) goto L253;
        IRoom r132 = (IRoom) r131.getValue();
        if (r132 == null) goto L253;
        r130 = r132.getOwnerUserIdString();
    L253:
        r130 = null;
    L254:
        IBaseUser r133 = r73.getUser();
        if (r133 == null) goto L257;
        String r134 = r133.getIdString();
    L258:
        boolean r135 = Intrinsics.areEqual(r134, r130);
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L265;
        rj0.l r136 = rj0.l.a.a();
        if (r136 != null) goto L263;
    L270:
        boolean r137 = false;
    L272:
        if (je0.d.D() == true) goto L293;
        if (r137 == true) goto L293;
        if (r72 == true) goto L277;
        LayerBackgroundStatus r74 = LayerBackgroundStatus.Normal;
    L301:
        if (r74 != LayerBackgroundStatus.Leave) goto L303;
        boolean r75 = true;
    L304:
        r123.addProperty("is_afk", Boolean.valueOf(r75));
        if (r121.j == false) goto L307;
        int r76 = 1;
    L308:
        r123.addProperty("visible", Integer.valueOf(r76));
        r66.add(r123);
        goto L309
    L307:
        r76 = 2;
        goto L308
    L277:
        if (r73.getSilenceStatus() == 0) goto L285;
        IBaseUser r77 = r73.getUser();
        if (r77 == null) goto L281;
        String r78 = r77.getIdString();
    L283:
        if ((!Intrinsics.areEqual(r78, je0.d.b0())) == false) goto L285;
        boolean r79 = true;
    L286:
        if (r79 == true) goto L290;
        if (r135 == true) goto L290;
        r74 = LayerBackgroundStatus.Audio;
    L290:
        r74 = LayerBackgroundStatus.Leave;
        goto L301
    L281:
        r78 = null;
    L285:
        r79 = false;
    L293:
        if (r73.isSelfBackground() == true) goto L295;
        r74 = LayerBackgroundStatus.Normal;
        goto L301
    L295:
        if (r129 == true) goto L299;
        if (r135 == true) goto L299;
        r74 = LayerBackgroundStatus.Audio;
    L299:
        r74 = LayerBackgroundStatus.Leave;
        goto L301
    L263:
        if (r136.isEngineOn() != true) goto L270;
    L269:
        r137 = true;
        goto L272
    L265:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r138 = IVoiceChatAdminService.a.a();
        if (r138 == null) goto L270;
        if (r138.isEngineOn() != true) goto L270;
    L257:
        r134 = null;
        goto L258
    L245:
        r129 = false;
    L303:
        r75 = false;
    L227:
        ch0.j r80 = r124.c;
        if (r80 == null) goto L233;
        if (r80.c != 3) goto L235;
    L236:
        r128 = 2;
        goto L237
    L219:
        r70 = null;
    L309:
        r69 = r120;
    L310:
        r65.add("guest_list", r66);
        return r65;
    }

    public final JsonObject b() {
        JsonObject r0 = new JsonObject();
        JsonArray r1 = new JsonArray();
        List<ILinkPlayerInfoBridge> r2 = this.c;
        if (r2 == null) goto L20;
        Iterator<T> r3 = r2.iterator();
        int r10 = 0;
    L6:
        if (r3.hasNext() == false) goto L20;
        Object r11 = r3.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ILinkPlayerInfoBridge r13 = (ILinkPlayerInfoBridge) r11;
        int r14 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.b(r13.getInteractId()) == false) goto L13;
    L15:
        int r15 = 0;
    L16:
        JsonObject r16 = new JsonObject();
        r16.addProperty("position", Integer.valueOf(r10));
        r16.addProperty("type", Integer.valueOf(r15));
        r16.addProperty("name", r13.getActiveName());
        r16.addProperty("status", Integer.valueOf(r13.getStats()));
        if (r15 != 1) goto L19;
        r16.add("list_user", a.b(r13));
    L19:
        r1.add(r16);
        r10 = r12;
        goto L6
    L13:
        if (r13.getUser() == null) goto L15;
        r15 = 1;
    L20:
        List<tf0.e> r4 = this.d;
        if (r4 == null) goto L63;
        Iterator<T> r5 = r4.iterator();
        int r17 = 0;
    L24:
        if (r5.hasNext() == false) goto L63;
        Object r18 = r5.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        tf0.e r110 = (tf0.e) r18;
        JsonObject r111 = new JsonObject();
        r111.addProperty("position", Integer.valueOf(r17));
        String r112 = "";
        if ((r110 instanceof MultiLinkGuestViewBinder.a) == false) goto L44;
        ILinkPlayerInfoBridge r113 = ((MultiLinkGuestViewBinder.a) r110).k.a;
        r111.addProperty("name", r113.getActiveName());
        r111.addProperty("status", Integer.valueOf(r113.getStats()));
        r111.add("list_user", a.b(r113));
        kd1.b r114 = r113.getMicDress();
        if (r114 == null) goto L42;
        kd1.c r115 = r114.getVoiceWave();
        if (r115 == null) goto L42;
        py.k r116 = r115.getMediumImg();
        if (r116 == null) goto L42;
        List r117 = r116.getUrls();
        if (r117 == null) goto L42;
        String r118 = (String) ListProtector.get(r117, 0);
        if (r118 == null) goto L42;
        r112 = r118;
    L42:
        r111.addProperty("voice_wave", r112);
    L60:
        int r119 = 1;
    L62:
        r111.addProperty("type", Integer.valueOf(r119));
        r1.add(r111);
        r17 = r19;
        goto L24
    L44:
        if ((r110 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L53;
        LinkmicPositionItem r120 = ((MultiLinkNormalEmptyViewBinder.a) r110).c();
        if (r120 == null) goto L51;
        String r121 = r120.getActiveName();
        if (r121 == null) goto L51;
        r112 = r121;
    L51:
        r111.addProperty("name", r112);
    L61:
        r119 = 0;
        goto L62
    L53:
        if ((r110 instanceof MultiLinkSpecialViewBinder.a) == false) goto L56;
        r111.addProperty("status", Integer.valueOf(((MultiLinkSpecialViewBinder.a) r110).l));
        goto L61
    L56:
        if ((r110 instanceof MultiLinkPaidViewBinder.a) == false) goto L61;
        ILinkPlayerInfoBridge r122 = ((MultiLinkPaidViewBinder.a) r110).k;
        if (r122 == null) goto L61;
        r111.addProperty("name", r122.getActiveName());
        r111.addProperty("status", Integer.valueOf(r122.getStats()));
        r111.add("list_user", a.b(r122));
    L63:
        r0.add("seat_list", r1);
        return r0;
    }

    public /* synthetic */ f(String r12, e r13, List r14, sf0.b r15, JsonObject r16, String r17, boolean r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r19 & 2) == 0) goto L9;
        e r4 = null;
    L11:
        if ((r19 & 8) == 0) goto L13;
        List r6 = null;
    L15:
        if ((r19 & 16) == 0) goto L17;
        sf0.b r7 = null;
    L19:
        if ((r19 & 32) == 0) goto L21;
        JsonObject r8 = null;
    L23:
        if ((r19 & 64) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r19 & 128) == 0) goto L29;
        boolean r10 = false;
    L30:
        this(r3, r4, null, r6, r7, r8, r9, r10);
        return;
    L29:
        r10 = r18;
        goto L30
    L25:
        r9 = r17;
        goto L27
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(String r2, e r3, List<? extends ILinkPlayerInfoBridge> r4, List<? extends tf0.e> r5, sf0.b r6, JsonObject r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
