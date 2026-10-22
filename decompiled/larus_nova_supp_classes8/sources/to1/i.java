package to1;

import am2.x;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends z40.a<ActivityTopBannerViewIntent, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a> {
    public i() {
    }

    public final void a(ActivityTopBannerViewIntent r36) {
        Intrinsics.checkNotNullParameter(r36, "input");
        if ((r36 instanceof ActivityTopBannerViewIntent.g) == false) goto L176;
        ActivityTopBannerViewIntent.g r1 = (ActivityTopBannerViewIntent.g) r36;
        String r2 = r1.a;
        DataCenter r3 = ((z40.a) this).b;
        if (r3 == null) goto L7;
        IRoom r4 = (IRoom) r3.get("data_room", null);
    L8:
        DataCenter r6 = ((z40.a) this).b;
        if (r6 == null) goto L13;
        Boolean r7 = (Boolean) r6.get("data_is_anchor", Boolean.FALSE);
        if (r7 == null) goto L13;
        boolean r8 = r7.booleanValue();
    L14:
        com.bytedance.android.livesdk.user.e r9 = com.bytedance.android.livesdk.c.a();
        String r12 = "event_belong";
        String r10 = "source";
        if (TextUtils.isEmpty(r2) == false) goto L17;
        String r11 = "request_id";
        String r0 = "enter_from";
        r10 = "source";
        String r13 = "event_page";
        String r5 = "live_interact";
        String r14 = "";
    L60:
        String r28 = r11;
        Uri.Builder r15 = UriProtector.parse(r14).buildUpon().appendQueryParameter("request_page", "top");
        if (r4 == null) goto L66;
        IBaseUser r16 = r4.getOwner();
        if (r16 == null) goto L66;
        String r17 = r16.getIdString();
        if (r17 == null) goto L66;
    L67:
        Uri.Builder r18 = r15.appendQueryParameter("anchor_id", r17);
        String r19 = r9.n();
        if (r19 != null) goto L70;
        r19 = "";
    L70:
        Uri.Builder r20 = r18.appendQueryParameter("user_id", r19);
        if (r4 == null) goto L73;
        Long r110 = Long.valueOf(r4.getRoomLayout());
    L74:
        Uri.Builder r21 = r20.appendQueryParameter("room_layout", String.valueOf(r110)).appendQueryParameter("position", "right");
        String r111 = r1.b;
        if (r111 != null) goto L77;
        r111 = "-1";
    L77:
        Uri.Builder r22 = r21.appendQueryParameter("log_id", r111);
        IMiddlewareMicRoomService r112 = k.f(IMiddlewareMicRoomService.class);
        if (r112 == null) goto L83;
        if (r112.isMicRoom(r4) == false) goto L83;
        r22.appendQueryParameter("room_type", "carousel");
    L83:
        String r23 = r22.toString();
        IRoom r29 = r4;
        DataCenter r24 = ((z40.a) this).b;
        if (TextUtils.isEmpty(r23) == true) goto L141;
        if (r24 == null) goto L141;
        IRoom r25 = (IRoom) r24.get("data_room", null);
        String r26 = r5;
        boolean r27 = ((Boolean) r24.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        t r30 = j0.l().c(x.class);
        if ((r30 instanceof t) == false) goto L97;
        t r31 = r30;
        if (r31.getMap().containsKey(r0) == false) goto L92;
        String r113 = (String) r31.getMap().get(r0);
    L93:
        String r32 = r12;
        String r114 = r10;
        if (r31.getMap().containsKey(r114) == false) goto L96;
        String r33 = (String) r31.getMap().get(r114);
        String r115 = r113;
    L98:
        String r116 = r13;
        u r34 = j0.l().c(IRoom.class);
        if ((r34 instanceof u) == false) goto L127;
        u r35 = r34;
        if (r35.getMap().containsKey("anchor_id") == false) goto L107;
        Object r117 = r35.getMap().get("anchor_id");
        if (r117 == null) goto L107;
        String r210 = r33;
        if ((r117 instanceof String) == false) goto L108;
        String r37 = r117.toString();
    L110:
        if (r35.getMap().containsKey("log_pb") == false) goto L116;
        Object r118 = r35.getMap().get("log_pb");
        if (r118 == null) goto L116;
        String r38 = r37;
        if ((r118 instanceof String) == false) goto L117;
        String r39 = r118.toString();
    L119:
        if (r35.getMap().containsKey(r28) == false) goto L125;
        Object r40 = r35.getMap().get(r28);
        if (r40 == null) goto L125;
        if ((r40 instanceof String) == false) goto L125;
        String r41 = r40.toString();
    L126:
        String r310 = r38;
        String r311 = r41;
        String r42 = r310;
    L128:
        UrlBuilder r119 = new UrlBuilder(r23);
        String r312 = r42;
        if (r25 == null) goto L135;
        r119.addParam("room_id", r25.getId());
        r119.addParam("mode", "live_room");
        if (r25.getOwner() == null) goto L135;
        if (TextUtils.isEmpty(r25.getOwner().getIdString()) == false) goto L135;
        r119.addParam("anchor_id", r25.getOwner().getIdString());
    L135:
        r119.addParam("is_anchor", String.valueOf(r27));
        r119.addParam(r0, r115);
        r119.addParam("source_v3", r210);
        r119.addParam("anchor_id", r312);
        r119.addParam("log_pb", r39);
        r119.addParam(r28, r311);
        if (r27 == false) goto L138;
        String r120 = "live_take_detail";
    L139:
        r119.addParam(r116, r120);
        r119.addParam(r32, r26);
        r23 = r119.build();
        goto L141
    L138:
        r120 = "live_detail";
    L125:
        r41 = "";
    L117:
        r39 = "";
    L116:
        r38 = r37;
    L108:
        r37 = "";
    L107:
        r210 = r33;
        goto L108
    L127:
        r210 = r33;
        r39 = "";
        r42 = r39;
        r311 = r42;
        goto L128
    L96:
        r115 = r113;
        r33 = "";
        goto L98
    L92:
        r113 = "";
        goto L93
    L97:
        r32 = r12;
        r33 = "";
        r115 = r33;
    L141:
        ALogger.i("tag_banner_TOP", "finalUrl=" + r23);
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.i(r2, r23));
        qm0.b r43 = om0.c.g();
        String r44 = "0";
        long r45 = 0;
        if (r43 == null) goto L159;
        LinkedHashMap r46 = new LinkedHashMap();
        if (r29 == null) goto L146;
        r45 = r29.getRoomId();
    L146:
        r46.put("room_id", String.valueOf(r45));
        Object r47 = r1.b;
        if (r47 != null) goto L149;
        r47 = -1;
    L149:
        r46.put("log_id", r47.toString());
        r46.put("position", "right");
        String r48 = r9.n();
        if (r48 != null) goto L152;
        r48 = "";
    L152:
        r46.put("user_id", r48);
        IMiddleWareHostContext r49 = k.f(IMiddleWareHostContext.class);
        if (r49 == null) goto L158;
        String r50 = r49.getServerDeviceId();
        if (r50 == null) goto L158;
        r44 = r50;
    L158:
        r46.put("did", r44);
        Unit r51 = Unit.INSTANCE;
        r43.sendLog("livesdk_live_banner_show_verify", r46, new Object[0]);
        return;
    L159:
        j0 r52 = j0.l();
        LinkedHashMap r53 = new LinkedHashMap();
        if (r29 == null) goto L162;
        r45 = r29.getRoomId();
    L162:
        r53.put("room_id", String.valueOf(r45));
        Object r54 = r1.b;
        if (r54 != null) goto L165;
        r54 = -1;
    L165:
        r53.put("log_id", r54.toString());
        r53.put("position", "right");
        String r55 = r9.n();
        if (r55 != null) goto L168;
        r55 = "";
    L168:
        r53.put("user_id", r55);
        IMiddleWareHostContext r56 = k.f(IMiddleWareHostContext.class);
        if (r56 == null) goto L174;
        String r57 = r56.getServerDeviceId();
        if (r57 == null) goto L174;
        r44 = r57;
    L174:
        r53.put("did", r44);
        Unit r58 = Unit.INSTANCE;
        r52.sendLog("livesdk_live_banner_show_verify", r53, new Object[0]);
        return;
    L73:
        r110 = null;
    L66:
        r17 = "";
        goto L67
    L17:
        t r121 = j0.l().c(x.class);
        if ((r121 instanceof t) == false) goto L28;
        t r122 = r121;
        if (r122.getMap().containsKey("enter_from") == false) goto L22;
        String r211 = String.valueOf(r122.getMap().get("enter_from"));
    L24:
        if (r122.getMap().containsKey("source") == false) goto L26;
        String r123 = String.valueOf(r122.getMap().get("source"));
    L27:
        String r124 = r211;
    L29:
        u r59 = j0.l().c(IRoom.class);
        if ((r59 instanceof u) == false) goto L44;
        u r60 = r59;
        if (r60.getMap().containsKey("anchor_id") == false) goto L34;
        String r212 = String.valueOf(r60.getMap().get("anchor_id"));
    L36:
        if (r60.getMap().containsKey("log_pb") == false) goto L38;
        String r213 = String.valueOf(r60.getMap().get("log_pb"));
    L40:
        if (r60.getMap().containsKey("request_id") == false) goto L42;
        String r61 = String.valueOf(r60.getMap().get("request_id"));
    L43:
        String r125 = r213;
        String r214 = r61;
        String r62 = r212;
    L45:
        UrlBuilder r63 = new UrlBuilder(r2);
        String r313 = r62;
        if (r4 == null) goto L48;
        r63.addParam("room_id", r4.getId());
    L48:
        r63.addParam("mode", "live_room");
        if (r4 == null) goto L55;
        IBaseUser r64 = r4.getOwner();
        if (r64 == null) goto L55;
        String r65 = r64.getIdString();
        if (r65 == null) goto L55;
        r63.addParam("anchor_id", r65);
    L55:
        r63.addParam("is_anchor", String.valueOf(r8));
        r0 = "enter_from";
        r63.addParam(r0, r124);
        r63.addParam("source_v3", r123);
        r63.addParam("anchor_id", r313);
        r63.addParam("log_pb", r125);
        r11 = "request_id";
        r63.addParam(r11, r214);
        if (r8 == false) goto L58;
        String r66 = "live_take_detail";
    L59:
        r13 = "event_page";
        r63.addParam(r13, r66);
        r5 = "live_interact";
        r12 = "event_belong";
        r63.addParam(r12, r5);
        r14 = r63.build();
        goto L60
    L58:
        r66 = "live_detail";
        goto L59
    L42:
        r61 = "";
        goto L43
    L38:
        r213 = "";
        goto L40
    L34:
        r212 = "";
        goto L36
    L44:
        r62 = "";
        r125 = r62;
        r214 = r125;
        goto L45
    L26:
        r123 = "";
        goto L27
    L22:
        r211 = "";
        goto L24
    L28:
        r123 = "";
        r124 = r123;
    L13:
        r8 = false;
        goto L14
    L7:
        r4 = null;
        goto L8
    }
}
