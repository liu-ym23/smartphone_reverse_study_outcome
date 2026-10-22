package to1;

import am2.n;
import am2.x;
import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.log.filter.q;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends z40.a<ActivityTopBannerViewIntent, com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a> {

    /* JADX INFO: renamed from: to1.a$a, reason: collision with other inner class name */
    public static final class C0415a {
    }

    static {
    }

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        t r1 = j0.l().c(x.class);
        String r5 = null;
        String r6 = "";
        if ((r1 instanceof t) == false) goto L19;
        t r2 = r1;
        if (r2.getMap().containsKey("enter_from") == false) goto L7;
        String r3 = (String) r2.getMap().get("enter_from");
    L9:
        if (r2.getMap().containsKey("source") == false) goto L11;
        String r4 = (String) r2.getMap().get("source");
    L12:
        HashMap r7 = new HashMap();
        if (r3 == null) goto L18;
        if (r4 == null) goto L18;
        r r8 = z51.a.c(null, 0);
        if (r8 == null) goto L18;
        r8.dataMapping(r3, r4, r7);
    L18:
        String r9 = (String) r7.get("enter_from_merge");
        String r10 = (String) r7.get("enter_method");
    L20:
        q r11 = j0.l().c(n.class);
        if ((r11 instanceof q) == false) goto L30;
        q r12 = r11;
        if (r12.getMap().containsKey("IESLiveEffectAdTrackExtraServiceKey") == false) goto L25;
        String r13 = (String) r12.getMap().get("IESLiveEffectAdTrackExtraServiceKey");
    L27:
        if (r12.getMap().containsKey("ad_extra_data") == false) goto L29;
        String r14 = (String) r12.getMap().get("ad_extra_data");
    L31:
        DataCenter r15 = ((z40.a) this).b;
        if (r15 == null) goto L34;
        IRoom r16 = (IRoom) r15.get("data_room", null);
    L35:
        DataCenter r17 = ((z40.a) this).b;
        if (r17 == null) goto L40;
        Boolean r18 = (Boolean) r17.get("data_is_anchor", Boolean.FALSE);
        if (r18 == null) goto L40;
        boolean r19 = r18.booleanValue();
    L41:
        JSONObject r20 = r0.put("enter_from_merge", r9).put("enter_method", r10);
        if (r19 == false) goto L44;
        String r21 = "live_take_detail";
    L45:
        JSONObject r22 = r20.put("event_page", r21);
        if (r16 == null) goto L48;
        Long r23 = Long.valueOf(r16.getId());
    L49:
        JSONObject r24 = r22.put("room_id", String.valueOf(r23));
        if (r16 == null) goto L55;
        String r25 = r16.getOwnerUserIdString();
        if (r25 == null) goto L55;
        r6 = r25;
    L55:
        JSONObject r26 = r24.put("anchor_id", r6);
        if (r16 == null) goto L58;
        String r27 = r16.getRequestId();
    L59:
        JSONObject r28 = r26.put("request_id", r27);
        if (r16 == null) goto L62;
        r5 = r16.getLog_pb();
    L62:
        r28.put("log_pb", r5).put("IESLiveEffectAdTrackExtraServiceKey", r13).put("ad_extra_data", r14);
        return r0;
    L58:
        r27 = null;
        goto L59
    L48:
        r23 = null;
        goto L49
    L44:
        r21 = "live_detail";
    L40:
        r19 = false;
        goto L41
    L34:
        r16 = null;
        goto L35
    L29:
        r14 = "";
        goto L31
    L25:
        r13 = "";
        goto L27
    L30:
        r14 = "";
        r13 = r14;
        goto L31
    L11:
        r4 = "";
        goto L12
    L7:
        r3 = "";
        goto L9
    L19:
        r9 = "";
        r10 = r9;
        goto L20
    }

    public a() {
    }

    public final void a(ActivityTopBannerViewIntent r14) {
        Intrinsics.checkNotNullParameter(r14, "input");
        if ((r14 instanceof ActivityTopBannerViewIntent.a) == false) goto L10;
        ActivityTopBannerViewIntent.a r15 = (ActivityTopBannerViewIntent.a) r14;
        h1 r0 = r15.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getExtra() == null) goto L131;
        ALogger.i("tag_banner_TOP", "message = " + r15.a);
        Single.just(r15.a.getExtra()).observeOn(Schedulers.io()).map(c.a).map(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r15));
        return;
    L131:
        return;
    L10:
        boolean r2 = true;
        if ((r14 instanceof ActivityTopBannerViewIntent.c) == false) goto L19;
        int r16 = b.a[((ActivityTopBannerViewIntent.c) r14).a.ordinal()];
        if (r16 == 1) goto L17;
        if (r16 != 2) goto L132;
        JSONObject r17 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("foreground", true);
        r17.put("type", "app");
        r17.put("args", r3);
        Unit r1 = Unit.INSTANCE;
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_appStateChange", r17));
        return;
    L132:
        return;
    L17:
        JSONObject r18 = new JSONObject();
        JSONObject r4 = new JSONObject();
        r4.put("foreground", false);
        r18.put("type", "app");
        r18.put("args", r4);
        Unit r5 = Unit.INSTANCE;
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_appStateChange", r18));
        return;
    L19:
        if ((r14 instanceof ActivityTopBannerViewIntent.f) == false) goto L39;
        ActivityTopBannerViewIntent.f r19 = (ActivityTopBannerViewIntent.f) r14;
        if (r19.a == null) goto L133;
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        IBaseUser.Status r110 = r19.a.getStatus();
        if (r110 == null) goto L37;
        int r111 = b.b[r110.ordinal()];
        if (r111 == 1) goto L31;
        if (r111 == 2) goto L30;
        if (r111 != 3) goto L37;
        String r112 = "3";
    L113:
        r7.put("code", r112);     // Catch: JSONException -> L34
        r6.put("args", r7);     // Catch: JSONException -> L34
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_loginStatus", r6));     // Catch: JSONException -> L34
        return;
    L34:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    L30:
        r112 = "2";
        goto L113
    L31:
        r112 = "1";
    L37:
        throw new NoWhenBranchMatchedException();
    L133:
        return;
    L39:
        if ((r14 instanceof ActivityTopBannerViewIntent.e) == false) goto L52;
        ActivityTopBannerViewIntent.e r113 = (ActivityTopBannerViewIntent.e) r14;
        JSONObject r114 = new JSONObject();
        JSONObject r8 = new JSONObject();
        DataCenter r9 = ((z40.a) this).b;     // Catch: JSONException -> L49
        if (r9 == null) goto L46;
        Boolean r10 = (Boolean) r9.get("data_is_anchor", Boolean.FALSE);     // Catch: JSONException -> L49
        if (r10 == null) goto L46;
        boolean r11 = r10.booleanValue();     // Catch: JSONException -> L49
    L47:
        r8.put("status", i3.a(r11));     // Catch: JSONException -> L49
        r114.put("args", r8);     // Catch: JSONException -> L49
        r114.put("code", 0);     // Catch: JSONException -> L49
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("top_right_banner_status", r114));     // Catch: JSONException -> L49
        return;
    L46:
        r11 = false;
    L49:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    L52:
        if ((r14 instanceof ActivityTopBannerViewIntent.d) == false) goto L130;
        ActivityTopBannerViewIntent.d r115 = (ActivityTopBannerViewIntent.d) r14;
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L106
        o r13 = o3.f();     // Catch: JSONException -> L106
        if (r13 == null) goto L57;
        Boolean r20 = r13.isVSRoom();     // Catch: JSONException -> L106
    L59:
        if (Intrinsics.areEqual(r20, Boolean.TRUE) == false) goto L88;
        Boolean r21 = o3.f().isPortraitInteraction();     // Catch: JSONException -> L106
        if (r21 == null) goto L63;
        boolean r22 = r21.booleanValue();     // Catch: JSONException -> L106
    L64:
        Boolean r116 = o3.f().isVSVerticalStream();     // Catch: JSONException -> L106
        if (r116 == null) goto L67;
        boolean r117 = r116.booleanValue();     // Catch: JSONException -> L106
    L68:
        eq1.b r23 = new eq1.b(r22, r117);     // Catch: JSONException -> L106
        BannerInRoomCollection.BannerInfo r24 = r115.b;     // Catch: JSONException -> L106
        if (r24 == null) goto L88;
        List r25 = r24.getBannerList();     // Catch: JSONException -> L106
        if (r25 == null) goto L88;
        Iterator r26 = r25.iterator();     // Catch: JSONException -> L106
    L74:
        if (r26.hasNext() == false) goto L88;
        b1 r118 = (b1) r26.next();     // Catch: JSONException -> L106
        String r119 = r118.getSchemaUrl();     // Catch: JSONException -> L106
        if (r119 == null) goto L74;
        if (r119.length() <= 0) goto L80;
        boolean r120 = true;
    L81:
        if (r120 == true) goto L84;
        r119 = null;
    L84:
        if (r119 == null) goto L74;
        String r121 = r23.b(r119);     // Catch: JSONException -> L106
        if (r121 == null) goto L74;
        r118.setSchemaUrl(r121);     // Catch: JSONException -> L106
        goto L74
    L80:
        r120 = false;
        goto L81
    L67:
        r117 = false;
        goto L68
    L63:
        r22 = true;
    L88:
        BannerInRoomCollection.BannerInfo r122 = r115.b;     // Catch: JSONException -> L106
        if (r122 == null) goto L91;
        List r123 = r122.getBannerList();     // Catch: JSONException -> L106
    L92:
        r12.put("data", JsonUtil.toJSONString(r123));     // Catch: JSONException -> L106
        r12.put("type", "init");     // Catch: JSONException -> L106
        r12.put("log", c());     // Catch: JSONException -> L106
        o r124 = z51.a.h(null, 3);     // Catch: JSONException -> L106
        if (r124 == null) goto L103;
        m r125 = r124.getRoom();     // Catch: JSONException -> L106
        if (r125 == null) goto L103;
        IRoom r126 = (IRoom) r125.getValue();     // Catch: JSONException -> L106
        if (r126 == null) goto L103;
        IRoomAuthStatus r127 = r126.getRoomAuthStatus();     // Catch: JSONException -> L106
        if (r127 == null) goto L103;
        if (r127.enableBanner() != true) goto L103;
    L104:
        r12.put("enable", r2);     // Catch: JSONException -> L106
        b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_roomStatusChange", r12));     // Catch: JSONException -> L106
        return;
    L103:
        r2 = false;
        goto L104
    L91:
        r123 = null;
        goto L92
    L57:
        r20 = null;
    L106:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->" + e);
        return;
    }
}
