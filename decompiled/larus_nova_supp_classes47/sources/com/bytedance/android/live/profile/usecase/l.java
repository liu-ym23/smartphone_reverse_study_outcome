package com.bytedance.android.live.profile.usecase;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.ConsumerCentreInfo;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileConstant;
import com.bytedance.android.live.base.model.user.ShopEntrance;
import com.bytedance.android.live.base.model.user.ShopHeaderInfo;
import com.bytedance.android.live.base.model.user.WindowHeaderInfo;
import com.bytedance.android.live.base.model.user.k0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.AnchorFansGroupUtil;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rs0.o0;
import rs0.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements ut0.c {
    public final q a;
    public final ps0.b b;
    public final IRoom c;
    public final DataCenter d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final com.bytedance.android.live.profile.usecase.a j;

    public static final class a {
    }

    static {
    }

    public final NewProfileUser j() {
        return this.j.getTargetUser();
    }

    public final JSONObject k() {
        JSONObject r0 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        String r2 = "";
        if (r1 == null) goto L8;
        Map r3 = r1.getMap();
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("enter_from_merge");
        if (r4 == null) goto L8;
    L9:
        r0.put("room_id", String.valueOf(this.j.getRoom().getId()));
        r0.put("author_id", String.valueOf(this.j.getRoom().getOwnerUserIdStr()));
        r0.put("chnid", r4);
        com.bytedance.android.livesdk.log.filter.o r5 = j0.l().c(IRoom.class);
        if (r5 == null) goto L17;
        Map r6 = r5.getMap();
        if (r6 == null) goto L17;
        String r7 = (String) r6.get("request_id");
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        r0.put("request_id", r2);
        r0.put("cid", am2.n.f().c());
        if (StringsKt.startsWith$default(r4, "ad_", false, 2, null) == false) goto L20;
    L27:
        String r8 = DataType.TRUE;
    L28:
        r0.put("is_from_ad", r8);
        return r0;
    L20:
        if (Intrinsics.areEqual(r4, "topview") == true) goto L27;
        if (Intrinsics.areEqual(am2.n.f().d, "effective_ad") == true) goto L27;
        if (Intrinsics.areEqual(am2.n.f().d, "dou_plus") == true) goto L27;
        r8 = DataType.FALSE;
    L8:
        r4 = "";
        goto L9
    }

    @Override // ut0.c
    public final boolean showJumpLinkAnchorButton() {
        return j().canJumpToLiveRoom();
    }

    @Override // ut0.c
    public final void a(DialogFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        DressSuitInfo r0 = j().getDressSuitInfo();
        if (r0 == null) goto L5;
        String r1 = r0.getSchema();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (r1 != null) goto L10;
        return;
    L10:
        u6 r2 = new u6(r1);
        u6 r3 = r2.d("url");
        su0.a r4 = yt0.c.g();
        if (r4 == null) goto L14;
        String r6 = String.valueOf(r4.pf());
        if (r6 == null) goto L14;
    L15:
        r3.b("live_scene", r6);
        String r7 = r2.toString();
        n(r5.getActivity(), r7);
        return;
    L14:
        r6 = DataType.FALSE;
        goto L15
    L17:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // ut0.c
    public final void b(Context r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (((Boolean) o0.a.getValue()).booleanValue() == false) goto L7;
        int r0 = AnchorFansGroupUtil.a;
        AnchorFansGroupUtil.IMManagePageState r1 = AnchorFansGroupUtil.IMManagePageState.STATE_UNKNOWN;
    L7:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r3, "aweme://im/FansGroup/MasterState?biz_line=3&check_source=4&biz_scene=anchor_profile_card&enter_method=fan_group_manage&enter_from=live_room&panel_height_bias=0.75&float_mode=1&need_float_mode=1&&force_loading_time=1");
    }

    @Override // ut0.c
    public final void c(DialogFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ConsumerCentreInfo r0 = j().getConsumerCentreInfo();
        if (r0 == null) goto L5;
        String r1 = r0.getSchema();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        n(r3.getActivity(), r1);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // ut0.c
    public final void f(Context r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (((Boolean) o0.a.getValue()).booleanValue() == false) goto L7;
        int r0 = AnchorFansGroupUtil.a;
        AnchorFansGroupUtil.IMManagePageState r1 = AnchorFansGroupUtil.IMManagePageState.STATE_UNKNOWN;
    L7:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r3, "aweme://im/public_group_create?biz_line=3&check_source=4&enter_chat_on_create=0&biz_scene=anchor_profile_card&enter_method=profile_card&enter_from=live_room&height_bias=0.75&float_mode=1");
    }

    @Override // ut0.c
    public final void g(Context r19) {
        Intrinsics.checkNotNullParameter(r19, "context");
        NewProfileUser r1 = j();
        boolean r2 = this.a.b;
        HashMap r9 = new HashMap(4);
        if (((Number) rs0.a.a.getValue()).intValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L16;
        String r4 = am2.n.f().c();
        String r6 = am2.n.f().d();
        if (r4 != null) goto L10;
    L12:
        if (r6 == null) goto L16;
        if (r2.a(r6) != true) goto L16;
        r9.put("live_ad_log_extra", r6);
        goto L16
    L10:
        if (r2.a(r4) != true) goto L12;
        r9.put("live_ad_creative_id", r4);
    L16:
        DataCenter r5 = this.d;
        String r7 = "";
        if (r5 == null) goto L22;
        String r8 = (String) r5.get("log_enter_live_source");
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        r9.put("log_enter_live_source", r8);
    L23:
        BaseProfileInfo r10 = r1.baseProfileInfo;
        if (r10 == null) goto L27;
        String r12 = r10.secUid;
        if (r12 == null) goto L27;
    L28:
        r9.put("sec_user_id", r12);
        r9.put("room_id", String.valueOf(this.b.getId()));
        r9.put("anchor_id", this.b.getOwnerUserIdStr().toString());
        com.bytedance.android.livesdk.log.filter.o r13 = j0.l().c(x.class);
        DataCenter r14 = this.d;
        long r15 = 0;
        if (r14 == null) goto L33;
        Long r16 = (Long) r14.get("live_matrix_id", 0L);
        if (r16 == null) goto L33;
        r15 = r16.longValue();
    L33:
        r9.put("last_room_live_matrix_id", String.valueOf(r15));
        UserProfileEvent r17 = this.j.getUserProfileEvent();
        if (r17 == null) goto L36;
        String r18 = r17.getClickUserPosition();
    L38:
        if (Intrinsics.areEqual(r18, "related_room") == false) goto L50;
        UserProfileEvent r20 = this.j.getUserProfileEvent();
        if (r20 == null) goto L43;
        String r22 = r20.getClickUserPosition();
        if (r22 == null) goto L43;
    L44:
        r9.put("enter_method", r22);
        UserProfileEvent r23 = this.j.getUserProfileEvent();
        if (r23 == null) goto L48;
        String r24 = r23.getClickUserPosition();
        if (r24 == null) goto L48;
    L49:
        r9.put("enter_from_merge", r24);
    L58:
        qs0.e r25 = os0.b.c().getIHostCommerceServiceLive();
        if (r25 == null) goto L61;
        JSONObject r26 = r25.i();
    L62:
        if (r26 == null) goto L67;
        if (r26.optInt(this.e) != 1) goto L67;
        String r27 = "ecom_live";
    L70:
        r9.put("tpsa_biz_scene", r27);
        if (r26 == null) goto L138;
        Object r28 = r26.opt(this.f);
        if ((r28 instanceof ArrayList) == true) goto L76;
        r28 = null;
    L76:
        ArrayList r29 = (ArrayList) r28;
        Object r110 = r26.opt(this.g);
        if ((r110 instanceof ArrayList) == true) goto L79;
        r110 = null;
    L79:
        ArrayList r111 = (ArrayList) r110;
        String r30 = r26.optString(this.h);
        ArrayList r112 = new ArrayList();
        if (r30.length() <= 0) goto L82;
        boolean r113 = true;
    L83:
        if (r113 == false) goto L86;
        r112.add(r30);
    L86:
        if (r29 == null) goto L107;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r29.iterator();
    L89:
        if (r115.hasNext() == false) goto L99;
        Object r32 = r115.next();
        if (r29.size() > 0) goto L93;
    L95:
        boolean r33 = false;
    L96:
        if (r33 == false) goto L89;
        r114.add(r32);
        goto L89
    L93:
        if ((ListProtector.get(r29, 0) instanceof String) == false) goto L95;
        r33 = true;
        goto L96
    L99:
        Iterator r34 = r114.iterator();
    L101:
        if (r34.hasNext() == false) goto L107;
        Object r35 = r34.next();
        if (r35 == null) goto L106;
        r112.add((String) r35);
        goto L101
    L106:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L107:
        if (r111 == null) goto L127;
        ArrayList r36 = new ArrayList();
        Iterator r37 = r111.iterator();
    L110:
        if (r37.hasNext() == false) goto L119;
        Object r38 = r37.next();
        if (r111.size() > 0) goto L114;
    L116:
        boolean r116 = false;
    L117:
        if (r116 == false) goto L110;
        r36.add(r38);
        goto L110
    L114:
        if ((ListProtector.get(r111, 0) instanceof String) == false) goto L116;
        r116 = true;
        goto L117
    L119:
        Iterator r39 = r36.iterator();
    L121:
        if (r39.hasNext() == false) goto L127;
        Object r40 = r39.next();
        if (r40 == null) goto L126;
        r112.add((String) r40);
        goto L121
    L126:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L127:
        Intrinsics.checkNotNullParameter(r112, "$this$toStringStrip");
        Iterator r42 = r112.iterator();
        if (r42.hasNext() == true) goto L130;
        String r43 = "";
    L137:
        if (r43 == null) goto L138;
    L139:
        r9.put("tpsa_biz_product_id", r43);
        String r44 = DataType.TRUE;
        r9.put("tpsa_version", DataType.TRUE);
        r9.put("tpsa_live_guide_store", k().toString());
        com.bytedance.android.livesdk.log.filter.o r45 = j0.l().c(x.class);
        String r46 = l("enter_from_merge", r45);
        String r47 = l("enter_method", r45);
        JSONObject r48 = new JSONObject();     // Catch: Exception -> L187
        r48.put("live_enter_from_merge", r46);     // Catch: Exception -> L187
        r48.put("live_enter_method", r47);     // Catch: Exception -> L187
        DataCenter r49 = this.d;     // Catch: Exception -> L187
        if (r49 == null) goto L144;
        String r50 = (String) r49.get("log_action_type", "");     // Catch: Exception -> L187
        if (r50 == null) goto L144;
    L145:
        r48.put("live_action_type", r50);     // Catch: Exception -> L187
        DataCenter r52 = this.d;     // Catch: Exception -> L187
        if (r52 == null) goto L148;
        String r53 = (String) r52.get("data_aweme_id", "");     // Catch: Exception -> L187
    L149:
        r48.put("live_video_id", r53);     // Catch: Exception -> L187
        IMiddlewareUserService r54 = jc1.k.f(IMiddlewareUserService.class);     // Catch: Exception -> L187
        if (r54 == null) goto L155;
        com.bytedance.android.livesdk.user.e r55 = r54.user();     // Catch: Exception -> L187
        if (r55 == null) goto L155;
        String r56 = r55.n();     // Catch: Exception -> L187
        if (r56 == null) goto L155;
    L156:
        r48.put("live_user_id", r56);     // Catch: Exception -> L187
        IRoom r57 = this.j.getLiveRoom();     // Catch: Exception -> L187
        if (r57 == null) goto L168;
        String r58 = r57.getOwnerUserIdString();     // Catch: Exception -> L187
        if (r58 != null) goto L161;
        r58 = "";
    L161:
        r48.put("live_anchor_id", r58);     // Catch: Exception -> L187
        String r59 = r57.getRequestId();     // Catch: Exception -> L187
        if (r59 != null) goto L164;
        r59 = "";
    L164:
        r48.put("live_request_id", r59);     // Catch: Exception -> L187
        String r60 = r57.getIdStr();     // Catch: Exception -> L187
        if (r60 != null) goto L167;
        r60 = "";
    L167:
        r48.put("live_room_id", r60);     // Catch: Exception -> L187
    L168:
        NewProfileUser r62 = this.j.getTargetUser();     // Catch: Exception -> L187
        if (r62 == null) goto L174;
        BaseProfileInfo r63 = r62.baseProfileInfo;     // Catch: Exception -> L187
        if (r63 == null) goto L174;
        String r64 = r63.getIdStr();     // Catch: Exception -> L187
        if (r64 == null) goto L174;
    L175:
        DataCenter r65 = this.d;     // Catch: Exception -> L187
        if (r65 == null) goto L180;
        IRoom r66 = gb2.a.e(r65);     // Catch: Exception -> L187
        if (r66 == null) goto L180;
        String r67 = r66.getOwnerUserIdString();     // Catch: Exception -> L187
    L182:
        if (Intrinsics.areEqual(r64, r67) == true) goto L185;
        r44 = DataType.FALSE;
    L185:
        r48.put("live_is_anchor", r44);     // Catch: Exception -> L187
        r48.put("live_profile_user_id", r64);     // Catch: Exception -> L187
        r7 = r48.toString();     // Catch: Exception -> L187
    L180:
        r67 = null;
    L174:
        r64 = "";
    L155:
        r56 = "";
        goto L156
    L148:
        r53 = null;
    L144:
        r50 = "";
    L189:
        if (r2.a(r7) == true) goto L192;
        r7 = null;
    L192:
        if (r7 == null) goto L194;
        r9.put("live_im_log_params", r7);
    L194:
        BaseProfileInfo r68 = r1.baseProfileInfo;
        if (r68 == null) goto L228;
        IBaseLiveActionHandler r69 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r69 == null) goto L229;
        String r70 = r68.getIdStr();
        IRoom r72 = this.c;
        k0 r73 = r68.saasBaseInfo;
        if (r73 == null) goto L201;
        String r74 = r73.hostNickName;
    L202:
        if (r73 == null) goto L204;
        Long r117 = Long.valueOf(r73.xiguaUid);
    L205:
        k0 r75 = r68.saasBaseInfo;
        if (r75 == null) goto L209;
        Map r76 = r75.extra;
        if (r76 == null) goto L209;
    L210:
        String r77 = r74;
        Long r78 = r117;
        r69.openUserProfile(r19, r70, r72, r77, r78, r76, r9);
        return;
    L209:
        r76 = MapsKt.emptyMap();
        goto L210
    L204:
        r117 = null;
        goto L205
    L201:
        r74 = null;
        goto L202
    L229:
        return;
    L228:
        return;
    L130:
        StringBuilder r79 = new StringBuilder();
    L131:
        Object r80 = r42.next();
        if (r80 != r112) goto L134;
        r80 = "(this Collection)";
    L134:
        r79.append(r80);
        if (r42.hasNext() == false) goto L136;
        r79.append(',');
        goto L131
    L136:
        r43 = r79.toString();
        goto L137
    L82:
        r113 = false;
    L138:
        r43 = "";
    L67:
        if (os0.b.c().isShelfInfoNotNull() == false) goto L69;
        r27 = "mp_live";
        goto L70
    L69:
        r27 = "";
        goto L70
    L61:
        r26 = null;
    L48:
        r24 = "";
    L43:
        r22 = "";
        goto L44
    L50:
        if (r13 != null) goto L52;
    L54:
        if (r13 == null) goto L58;
        if (r13.getMap().containsKey("enter_method") == false) goto L58;
        r9.put("enter_method", l("enter_method", r13));
        goto L58
    L52:
        if (r13.getMap().containsKey("enter_from_merge") == false) goto L54;
        r9.put("enter_from_merge", l("enter_from_merge", r13));
        goto L54
    L36:
        r18 = null;
    L27:
        r12 = "";
        goto L28
    L22:
        r9.put("log_enter_live_source", this.i);
        goto L23
    L5:
        r3 = false;
        goto L6
    }

    @Override // ut0.c
    public final void h(FragmentActivity r10) {
        u r0 = u.a;
        String r1 = (String) ((Map) r0.getValue()).get("high_score_song_list_schema");
        if (r1 != null) goto L5;
        r1 = "sslocal://webcast_lynxview?type=popup&gravity=bottom&rate_height=484&hide_loading=0&show_error=1&radius=12/";
    L5:
        u6 r2 = new u6(r1);
        String r3 = (String) ((Map) r0.getValue()).get("high_score_song_list_url");
        if (r3 != null) goto L8;
        r3 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/high_score_song_list/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=linkmiccharge";
    L8:
        r2.b("url", r3);
        u6 r4 = r2.d("url");
        IBaseUser r5 = jc1.k.n(IMiddlewareUserService.class).user().b();
        r4.b("query_user_name", this.j.getTargetUser().getDisplayName());
        r4.b("query_user_id", this.j.getTargetUser().baseProfileInfo.getIdStr());
        r4.b("self_user_id", r5.getIdString());
        boolean r6 = os0.b.c().getIKtvService().isInKtvState(1);
        boolean r7 = os0.b.c().getIKtvService().isInKtvState(8);
        if (r6 == false) goto L11;
        int r8 = 0;
    L14:
        r4.b("ktv_midi_record_scene", String.valueOf(r8));
        r4.b("request_page", "user_card");
        com.bytedance.android.livesdk.chatroom.o r9 = os0.b.a();
        if (r9 == null) goto L23;
        com.bytedance.live.datacontext.m r12 = r9.getRoom();
        if (r12 == null) goto L23;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L23;
        String r14 = String.valueOf(r13.getLiveRoomMode());
        if (r14 == null) goto L23;
        r4.b("live_room_mode", r14);
    L23:
        IBaseUser r15 = this.b.getOwner();
        if (r15 == null) goto L27;
        String r16 = r15.getIdString();
        if (r16 == null) goto L27;
    L28:
        r4.b("anchor_id", r16);
        qs0.h r17 = os0.b.c().getInteractLogUtils();
        if (r17 == null) goto L33;
        String r18 = r17.getCurrentPlayModes();
        if (r18 == null) goto L33;
        r4.b("play_mode", r18);
    L33:
        com.bytedance.android.livesdk.chatroom.o r19 = os0.b.a();
        String r20 = null;
        if (r19 == null) goto L38;
        com.bytedance.live.datacontext.m r22 = r19.getRoom();
        if (r22 == null) goto L38;
        IRoom r23 = (IRoom) r22.getValue();
    L39:
        LinkedHashMap r24 = new LinkedHashMap();
        if (r23 == null) goto L42;
        Long r25 = Long.valueOf(r23.getId());
    L43:
        r24.put("room_id", String.valueOf(r25));
        if (r23 == null) goto L46;
        r20 = r23.getOwnerUserIdString();
    L46:
        r24.put("anchor_id", String.valueOf(r20));
        mv0.k.d r26 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r26 == null) goto L50;
        String r27 = String.valueOf(r26.l());
        if (r27 == null) goto L50;
    L51:
        r24.put("user_cnt", r27);
        r24.put("action_from", "start");
        r24.put("function_type", os0.b.c().getIInteractService().getCurrentFunctionType());
        if (r23 != null) goto L54;
    L56:
        String r28 = "video_live";
    L57:
        r24.put("live_type", r28);
        Iterator r29 = r24.entrySet().iterator();
    L59:
        if (r29.hasNext() == false) goto L61;
        Map.Entry r30 = (Map.Entry) r29.next();
        r4.b((String) r30.getKey(), (String) r30.getValue());
        goto L59
    L61:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r10, r2.c().toString());
        return;
    L54:
        if (r23.isLiveTypeAudio() != true) goto L56;
        r28 = "voice_live";
    L50:
        r27 = DataType.FALSE;
        goto L51
    L42:
        r25 = null;
    L38:
        r23 = null;
    L27:
        r16 = "";
        goto L28
    L11:
        if (r7 == false) goto L13;
        r8 = 1;
        goto L14
    L13:
        r8 = 2;
        goto L14
    }

    public l(String r2, com.bytedance.android.live.profile.usecase.a r3) {
        Intrinsics.checkNotNullParameter(r2, "mFromSource");
        Intrinsics.checkNotNullParameter(r3, "profileViewModel");
        this.i = r2;
        this.j = r3;
        this.a = r3.getPageTypeUseCase();
        this.b = r3.getRoom();
        this.c = r3.getLiveRoom();
        this.d = r3.getRoomDataCenter();
        this.e = "live_is_shopping";
        this.f = "live_show_products";
        this.g = "live_click_products";
        this.h = "live_explain_product";
    }

    public static String l(String r1, com.bytedance.android.livesdk.log.filter.o r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        String r3 = (String) r2.getMap().get(r1);
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    public static void n(Context r3, String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        IBaseLiveActionHandler r0 = jc1.k.f(IBaseLiveActionHandler.class);
        Uri r1 = UriProtector.parse(r4);
        if (r0 != null) goto L7;
    L9:
        jc1.k.n(IMiddlewareHostAction.class).handleSchema(r3, r4, new Bundle());
        return;
    L7:
        if (r0.canHandle(r1) == false) goto L9;
        r0.handle(r3, r1);
    }

    @Override // ut0.c
    public final void i(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "from");
        NewProfileUser r0 = j();
        Intrinsics.checkNotNullParameter(r0, "user");
        EcomInfo r1 = r0.ecomInfo;
        String r2 = "";
        if (r1 != null) goto L5;
    L14:
        EcomInfo r3 = r0.ecomInfo;
        if (r3 != null) goto L17;
    L24:
        m(r5, r2, r6);
        return;
    L17:
        if (r3.getEcomType() != ProfileConstant.ProfileType.WINDOW.getType()) goto L24;
        EcomInfo r4 = r0.ecomInfo;
        if (r4 == null) goto L24;
        WindowHeaderInfo r7 = r4.getWindowHeaderInfo();
        if (r7 == null) goto L24;
        String r8 = r7.getWindowUrl();
        if (r8 == null) goto L24;
    L13:
        r2 = r8;
        goto L24
    L5:
        if (r1.getEcomType() != ProfileConstant.ProfileType.SHOP.getType()) goto L14;
        EcomInfo r9 = r0.ecomInfo;
        if (r9 == null) goto L24;
        ShopHeaderInfo r10 = r9.getShopHeaderInfo();
        if (r10 == null) goto L24;
        r8 = r10.getStoreUrl();
        if (r8 != null) goto L13;
        goto L13
    }

    @Override // ut0.c
    public final void d(Context r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "from");
        NewProfileUser r0 = j();
        Intrinsics.checkNotNullParameter(r0, "user");
        String r2 = "";
        if (r5 != 1) goto L9;
        ShopEntrance r7 = r0.shopEntrance;
        if (r7 == null) goto L15;
        String r8 = r7.shopUrl;
        if (r8 == null) goto L15;
    L14:
        r2 = r8;
    L15:
        m(r4, r2, r6);
        return;
    L9:
        ShopEntrance r9 = r0.shopEntrance;
        if (r9 == null) goto L15;
        r8 = r9.windowUrl;
        if (r8 != null) goto L14;
        goto L14
    }

    @Override // ut0.c
    public final void e(FragmentActivity r20, String r22, IBaseUser r23) {
        Intrinsics.checkNotNullParameter(r22, "mEnterLiveSource");
        Intrinsics.checkNotNullParameter(r23, "user");
        mv0.k.e r2 = os0.b.c().getIInteractService().getVideoTalkService();
        if (r2 == null) goto L5;
        Pair<Boolean, Long> r3 = r2.k(r23.getIdString());
    L6:
        String r12 = "last_room_live_matrix_id";
        if (r3 != null) goto L9;
        String r4 = "sourceJumpToOtherNewProfileJumpUseCase2";
    L48:
        Bundle r10 = new Bundle();
        r10.putString("enter_from", "live_detail");
        r10.putString("source", "right_anchor");
        String r17 = r12;
        r10.putLong("from_room_id", this.b.getId());
        r10.putString("superior_page_from", r22);
        String r1 = r23.getIdString();
        if (r1 != null) goto L51;
        r1 = DataType.FALSE;
    L51:
        r10.putString("anchor_id", r1);
        r10.putInt("back_source", 2);
        UserProfileEvent r5 = this.j.getUserProfileEvent();
        if (r5 == null) goto L54;
        String r6 = r5.getClickUserPosition();
    L56:
        if (Intrinsics.areEqual(r6, "related_room") == false) goto L70;
        UserProfileEvent r7 = this.j.getUserProfileEvent();
        if (r7 == null) goto L61;
        String r8 = r7.getClickUserPosition();
        if (r8 == null) goto L61;
    L62:
        r10.putString("enter_method", r8);
        UserProfileEvent r9 = this.j.getUserProfileEvent();
        if (r9 == null) goto L68;
        String r13 = r9.getClickUserPosition();
        if (r13 == null) goto L68;
        String r14 = r13;
    L69:
        r10.putString("enter_from_merge", r14);
    L78:
        DataCenter r15 = this.d;
        if (r15 == null) goto L83;
        Long r16 = (Long) r15.get("live_matrix_id", 0L);
        if (r16 == null) goto L83;
        long r18 = r16.longValue();
    L84:
        r10.putString(r17, String.valueOf(r18));
        os0.b.c().getBackToRoomDataUtils().a();
        xs2.b r19 = xs2.b.a();
        JumpToOtherRoomEvent r24 = new JumpToOtherRoomEvent(r23.getLiveRoomId(), "live_detail", r10);
        r24.source = r4;
        Unit r25 = Unit.INSTANCE;
        r19.post(r24);
        return;
    L83:
        r18 = 0;
    L68:
        r14 = "personal_card";
    L61:
        r8 = "personal_card";
        goto L62
    L70:
        UserProfileEvent r26 = this.j.getUserProfileEvent();
        if (r26 == null) goto L76;
        String r27 = r26.enterMethod;
        if (r27 == null) goto L76;
        String r110 = r27;
    L77:
        r10.putString("enter_method", r110);
        r10.putString("enter_from_merge", "live_detail");
    L76:
        r110 = "personal_card";
        goto L77
    L54:
        r6 = null;
        goto L56
    L9:
        if (((Boolean) r3.getFirst()).booleanValue() != true) goto L46;
        Long r28 = (Long) r3.getSecond();
        if (r28 == null) goto L86;
        r28.longValue();
        Bundle r111 = new Bundle();
        r111.putString("enter_from", "live_detail");
        r111.putString("source", "right_anchor");
        r111.putLong("from_room_id", this.b.getId());
        r111.putString("superior_page_from", r22);
        r111.putInt("back_source", 2);
        UserProfileEvent r29 = this.j.getUserProfileEvent();
        if (r29 == null) goto L15;
        String r30 = r29.getClickUserPosition();
    L17:
        if (Intrinsics.areEqual(r30, "related_room") == false) goto L31;
        UserProfileEvent r32 = this.j.getUserProfileEvent();
        if (r32 == null) goto L22;
        String r33 = r32.getClickUserPosition();
        if (r33 == null) goto L22;
    L23:
        r111.putString("enter_method", r33);
        UserProfileEvent r34 = this.j.getUserProfileEvent();
        if (r34 == null) goto L29;
        String r35 = r34.getClickUserPosition();
        if (r35 == null) goto L29;
        String r112 = r35;
    L30:
        r111.putString("enter_from_merge", r112);
    L39:
        DataCenter r36 = this.d;
        if (r36 == null) goto L44;
        Long r37 = (Long) r36.get("live_matrix_id", 0L);
        if (r37 == null) goto L44;
        long r38 = r37.longValue();
    L45:
        r111.putString("last_room_live_matrix_id", String.valueOf(r38));
        os0.b.c().getBackToRoomDataUtils().a();
        xs2.b r39 = xs2.b.a();
        JumpToOtherRoomEvent r40 = new JumpToOtherRoomEvent(r28.longValue(), "live_detail", r111);
        r40.source = "sourceJumpToOtherNewProfileJumpUseCase2";
        Unit r42 = Unit.INSTANCE;
        r39.post(r40);
        return;
    L44:
        r38 = 0;
    L29:
        r112 = "personal_card";
    L22:
        r33 = "personal_card";
        goto L23
    L31:
        UserProfileEvent r43 = this.j.getUserProfileEvent();
        if (r43 == null) goto L37;
        String r44 = r43.enterMethod;
        if (r44 == null) goto L37;
        String r113 = r44;
    L38:
        r111.putString("enter_method", r113);
        r111.putString("enter_from_merge", "live_detail");
    L37:
        r113 = "personal_card";
        goto L38
    L15:
        r30 = null;
        goto L17
    L86:
        return;
    L46:
        r12 = "last_room_live_matrix_id";
        r4 = "sourceJumpToOtherNewProfileJumpUseCase2";
        goto L48
    L5:
        r3 = null;
        goto L6
    }

    public final void m(Context r6, String r7, String r8) {
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r9 = null;
    L47:
        if (r9 != null) goto L49;
        return;
    L49:
        n(r6, r9);
        return;
    L8:
        Uri.Builder r10 = UriProtector.parse(r7).buildUpon();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        String r2 = "";
        if (r1 == null) goto L17;
        String r3 = (String) r1.getMap().get("enter_from_merge");
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        String r4 = (String) r1.getMap().get("enter_method");
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r10.appendQueryParameter("store_source_page", r3);
        r10.appendQueryParameter("store_source_method", r4);
    L17:
        r10.appendQueryParameter("pre_room_id", String.valueOf(this.b.getId()));
        r10.appendQueryParameter("store_group_type", "live");
        r10.appendQueryParameter("entrance_location", r8);
        Uri r12 = r10.build();
        String r5 = UriProtector.getQueryParameter(r12, "entrance_info");
        if (r5 != null) goto L21;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L22
    L51:
    L24:
        IMiddlewareUserService r14 = jc1.k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L30;
        com.bytedance.android.livesdk.user.e r15 = r14.user();
        if (r15 == null) goto L30;
        String r16 = r15.n();
        if (r16 == null) goto L30;
    L31:
        r13.put("uid", r16);
        r13.put("room_id", String.valueOf(this.j.getRoom().getId()));
        com.bytedance.android.livesdk.log.filter.o r17 = j0.l().c(IRoom.class);
        if (r17 == null) goto L37;
        Map r18 = r17.getMap();
        if (r18 == null) goto L37;
        String r19 = (String) r18.get("request_id");
        if (r19 == null) goto L37;
    L38:
        r13.put("request_id", r19);
        com.bytedance.android.livesdk.log.filter.o r20 = j0.l().c(x.class);
        if (r20 == null) goto L46;
        Map r22 = r20.getMap();
        if (r22 == null) goto L46;
        String r23 = (String) r22.get("enter_from_merge");
        if (r23 == null) goto L46;
        r2 = r23;
    L46:
        r13.put("chnid", r2);
        r13.put("live_guide_store", k().toString());
        r9 = i2.e(r12, "entrance_info").buildUpon().appendQueryParameter("entrance_info", r13.toString()).build().toString();
    L37:
        r19 = "";
    L30:
        r16 = DataType.FALSE;
        goto L31
    L21:
        r13 = new JSONObject(r5);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ALogger.e(NewProfileInfoViewModel.TAG, "generate shop schema error: " + e.getMessage());
        r13 = new JSONObject();
        goto L24
    L5:
        r0 = false;
        goto L6
    }
}
