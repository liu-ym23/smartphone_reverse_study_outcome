package com.bytedance.android.live.openplatform.impl.minigameaudience.applog;

import am2.t;
import am2.x;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.CandyToolbarContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.event.s;
import com.bytedance.android.livesdk.log.filter.h0;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import fr0.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/applog/AudienceMiniGameAppLogContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameAppLogContextService extends OpenPlatformContextService {
    public final String a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AudienceMiniGameAppLogContextService a;

        public a(AudienceMiniGameAppLogContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            AudienceMiniGameAppLogContextService r0 = this.a;
            r0.getClass();
            String r9 = ((s) r8).a;
            int r1 = r9.hashCode();
            if (r1 == 3529469) goto L11;
            if (r1 == 94750088) goto L8;
            return;
        L8:
            if (r9.equals("click") == false) goto L14;
            r0.h("mp_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("location", "room_comment_line")}));
            return;
        L14:
            return;
        L11:
            if (r9.equals("show") == false) goto L16;
            r0.h("mp_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("location", "room_comment_line")}));
            return;
        }
    }

    public final HashMap<String, String> f() {
        h0 r0 = u.l().c(t.class);
        if ((r0 instanceof h0) == false) goto L7;
        t r1 = r0.c;
        if (r1 == null) goto L7;
        String r2 = r1.f;
    L8:
        if (r2 != null) goto L15;
    L14:
        return null;
    L15:
        JSONObject r3 = new JSONObject(r2);     // Catch: JSONException -> L12
        HashMap<String, String> r4 = new HashMap();
        r4.put("search_keyword", r3.optString("search_keyword", ""));
        r4.put("search_result_id", r3.optString("search_result_id", ""));
        r4.put("search_id", r3.optString("search_id", ""));
        return r4;
    L12:
        e = move-exception;
        int r5 = qo0.a.a;
        qo0.a.c(this.a, "getSearchPrams JSONException:" + e.getMessage());
    L7:
        r2 = null;
        goto L8
    }

    public final HashMap<String, String> g() {
        b.a r0 = ((CandyToolbarContextService) getOpenPlatformContext().getService(CandyToolbarContextService.class)).b;
        HashMap<String, String> r1 = new HashMap();
        if (r0 == null) goto L15;
        String r2 = r0.d();
        if (r2 == null) goto L15;
        JSONObject r3 = new JSONObject(r2).optJSONObject("track");     // Catch: JSONException -> L13
        if (r3 == null) goto L15;
        Iterator<String> r4 = r3.keys();     // Catch: JSONException -> L13
    L10:
        if (r4.hasNext() == false) goto L15;
        String r5 = r4.next();     // Catch: JSONException -> L13
        r1.put(r5, r3.optString(r5));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        int r6 = qo0.a.a;
        qo0.a.c(this.a, "add taskInfo.extra JSONException:" + e.getMessage());
    L15:
        return r1;
    }

    public AudienceMiniGameAppLogContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "AudienceMiniGameAppLogContextServic";
        Disposable r3 = xs2.b.a().b(s.class).subscribe(new a(this));
        if (r3 == null) goto L6;
        autoDispose(r3);
        return;
    }

    public final void h(String r13, HashMap<String, String> r14) {
        Intrinsics.checkNotNullParameter(r13, "event");
        int r1 = qo0.a.a;
        qo0.a.c(this.a, "Audience event: " + r13 + ", extra:" + String.valueOf(r14));
        g r2 = u.l();
        HashMap r3 = new HashMap();
        HashMap r4 = new HashMap();
        r4.put("_param_for_special", "micro_game");
        int r5 = n.a;
        n.d(getOpenPlatformContext().getRoom(), r4);
        String r6 = n.c();
        if (r6 == null) goto L5;
        String r7 = (String) r4.put("live_enter_from_merge", r6);
    L5:
        r4.put("launch_from", "live");
        r4.put("scene", LaunchParamConstant$Scene.b);
        r4.put("ad_id", am2.n.f().a());
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, getOpenPlatformContext().getDataCenter(), 0, 2);
        Unit r9 = null;
        if (r8 == null) goto L10;
        i r10 = r8.getLiveMode();
        if (r10 == null) goto L10;
        LiveMode r11 = (LiveMode) r10.getValue();
    L11:
        int r12 = h1.a;
        r4.put("live_type", i1.a(r11));
        DataCenter r15 = getOpenPlatformContext().getDataCenter();
        if (r15 == null) goto L14;
        Boolean r16 = (Boolean) r15.get("enter_from_dou_plus", Boolean.FALSE);
    L16:
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == false) goto L18;
        r4.put("if_dou", "1");
    L19:
        String r17 = n.a();
        if ((!StringsKt.isBlank(r17)) == true) goto L23;
        r17 = null;
    L23:
        String r18 = "natural";
        if (r17 != null) goto L26;
        r17 = "natural";
    L26:
        r4.put("is_other_channel", r17);
        String r19 = n.a();
        if ((!StringsKt.isBlank(r19)) == true) goto L30;
        r19 = null;
    L30:
        if (r19 == null) goto L33;
        r18 = r19;
    L33:
        r4.put("is_ad_channel", r18);
        r4.put("user_type", "audience");
        r4.put("is_anchor", "0");
        HashMap<String, String> r20 = f();
        if (r20 == null) goto L36;
        r4.putAll(r20);
    L36:
        r3.putAll(r4);
        r3.putAll(n.b());
        b.a r21 = ((CandyToolbarContextService) getOpenPlatformContext().getService(CandyToolbarContextService.class)).b;
        String r22 = "";
        if (r21 == null) goto L40;
        String r23 = r21.a();
        if (r23 == null) goto L40;
    L41:
        r3.put("mp_id", r23);
        if (r21 == null) goto L45;
        String r24 = r21.h();
        if (r24 == null) goto L45;
    L46:
        r3.put("mp_name", r24);
        if (r21 == null) goto L49;
        Integer r25 = Integer.valueOf(r21.e());
    L51:
        if (r25 != null) goto L54;
    L56:
        if (r25 != null) goto L59;
    L61:
        if (r21 == null) goto L64;
        String r26 = r21.i();
        if (r26 == null) goto L64;
    L65:
        r3.put("task_id", r26);
        if (r21 == null) goto L83;
        String r27 = r21.b();
        if (r27 == null) goto L83;
        if (r27.length() <= 0) goto L72;
        boolean r28 = true;
    L73:
        if (r28 == true) goto L75;
    L77:
        boolean r29 = false;
    L78:
        if (r29 == true) goto L81;
        r27 = null;
    L81:
        if (r27 == null) goto L83;
        r3.put("click_id_nature", r27);
        goto L83
    L75:
        if (r3.containsKey("clickid") == true) goto L77;
        r29 = true;
        goto L78
    L72:
        r28 = false;
    L83:
        r3.putAll(g());
        if (r14 == null) goto L86;
        r3.putAll(r14);
    L86:
        Unit r30 = Unit.INSTANCE;
        r2.e(r13, r3, new Object[]{Room.class, x.class});
        Intrinsics.checkNotNullParameter(r13, "event");
        switch(r13.hashCode()) {
            case -1915581525: goto L102;
            case -199867270: goto L99;
            case 123482092: goto L96;
            case 1229502249: goto L93;
            case 1251382297: goto L90;
            default: goto L105;
        };
    L90:
        if (r13.equals("mp_show") == false) goto L105;
    L100:
        r22 = "othershow";
        goto L105
    L93:
        if (r13.equals("mp_live_card_close_click") == false) goto L105;
        r22 = "close";
        goto L105
    L96:
        if (r13.equals("mp_click") == false) goto L105;
    L103:
        r22 = "otherclick";
        goto L105
    L99:
        if (r13.equals("mp_game_detail_show") == false) goto L105;
    L102:
        if (r13.equals("mp_game_detail_click") == true) goto L103;
    L105:
        if (r22.length() != 0) goto L107;
        boolean r110 = true;
    L108:
        if (r110 == true) goto L145;
        String r111 = am2.n.f().c();
        if (r111 != null) goto L112;
    L115:
        boolean r112 = true;
    L116:
        if (r112 == true) goto L146;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L140
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L140
        Room r0 = getOpenPlatformContext().getRoom();     // Catch: Throwable -> L140
        if (r0 == null) goto L122;
        r114.put("room_id", r0.getIdStr());     // Catch: Throwable -> L140
        r114.put("anchor_id", r0.getOwnerUserIdString());     // Catch: Throwable -> L140
    L122:
        if (r14 == null) goto L128;
        String r31 = r14.get("location");     // Catch: Throwable -> L140
        if (r31 == null) goto L128;
        if (StringsKt.contains$default(r31, "live_link", false, 2, null) != true) goto L128;
        r114.put("icon_type", "mp_game");     // Catch: Throwable -> L140
        String r115 = "icon";
    L135:
        ILiveDouPlusService r32 = k.f(ILiveDouPlusService.class);     // Catch: Throwable -> L140
        if (r32 == null) goto L138;
        HashMap r33 = new HashMap();     // Catch: Throwable -> L140
        r33.put("value", am2.n.f().c());     // Catch: Throwable -> L140
        r33.put("log_extra", am2.n.f().d());     // Catch: Throwable -> L140
        r33.put("ad_extra_data", r114.toString());     // Catch: Throwable -> L140
        r33.put("refer", r115);     // Catch: Throwable -> L140
        r32.logEvent(true, "live_ad", r22, r33);     // Catch: Throwable -> L140
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L140
    L138:
        Result.constructor-impl(r9);     // Catch: Throwable -> L140
        return;
    L128:
        if (r14 == null) goto L134;
        String r116 = r14.get("location");     // Catch: Throwable -> L140
        if (r116 == null) goto L134;
        if (StringsKt.contains$default(r116, "live_card", false, 2, null) != true) goto L134;
        r115 = "card";
    L134:
        r115 = "landing_page";
    L140:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L146:
        return;
    L112:
        if (r111.length() == 0) goto L115;
        r112 = false;
        goto L116
    L145:
        return;
    L107:
        r110 = false;
    L64:
        r26 = "";
        goto L65
    L59:
        if (r25.intValue() != 2) goto L61;
        r3.put("game_type", "game_station");
        goto L61
    L54:
        if (r25.intValue() != 1) goto L56;
        r3.put("game_type", "micro_game");
        goto L61
    L49:
        r25 = null;
    L45:
        r24 = "";
    L40:
        r23 = "";
        goto L41
    L18:
        r4.put("if_dou", "0");
        goto L19
    L14:
        r16 = null;
    L10:
        r11 = null;
        goto L11
    }
}
