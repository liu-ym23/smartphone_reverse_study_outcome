package av1;

import am2.e;
import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.enterprocess.IInteractionBizInterceptor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.log.filter.f;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.n;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IInteractionBizInterceptor {
    public static l32.a a;
    public static final c b = null;

    public static final class a implements ILiveCallback<JSONObject> {
        public final /* synthetic */ Context a;

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
        }

        public a(Context r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r8) {
            JSONObject r9 = (JSONObject) r8;
            o r10 = u.l().c(e.class);
            String r1 = null;
            if ((r10 instanceof f) == true) goto L5;
            r10 = null;
        L5:
            f r11 = (f) r10;
            if (r11 != null) goto L9;
            return;
        L9:
            monitor-enter(f.class);
        L21:
            th = move-exception;
            throw th;
        L11:
            if (r11.c == true) goto L13;
        L18:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(f.class);
            return;
        L13:
            if (TextUtils.isEmpty(null) == true) goto L18;
            if (TextUtils.isEmpty(null) == false) goto L17;
            r1 = "完成点赞任务！返回任务页查看奖励";
        L17:
            String r2 = rm3.c.a;     // Catch: Throwable -> L21
            rm3.c.e(this.a, r1, 0, true, false);     // Catch: Throwable -> L21
            u.l().d("tobsdk_livesdk_task_complete_toast", new Object[]{e.class, x.class, Room.class});     // Catch: Throwable -> L21
            r11.c = false;     // Catch: Throwable -> L21
            goto L18
        }
    }

    public c() {
    }

    static {
        b = new c();
    }

    public final void processContinueAfterWidgetLoaded() {
        om2.a r0 = om2.a.e;
        if (k.n(IUserService.class).user().isLogin() == false) goto L5;
        r0.a();
        return;
    L5:
        Disposable r1 = om2.a.c;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        com.bytedance.android.livesdk.user.f r2 = k.n(IUserService.class).user();
        om2.a.c = r2.m().observeOn(AndroidSchedulers.mainThread()).subscribe(new om2.b(r2));
    }

    public final void doDiggActionWithToken(Context r11) {
        o r0 = u.l().c(e.class);
        if ((r0 instanceof f) == true) goto L5;
        r0 = null;
    L5:
        f r1 = (f) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        monitor-enter(f.class);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (r1.c == true) goto L13;
    L15:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(f.class);
        return;
    L13:
        if (TextUtils.isEmpty(null) == true) goto L15;
        String r6 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L18
        IHostAction r2 = k.f(IHostAction.class);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L18
        r2.doActionWithToken(null, r6, null, null, new a(r11));     // Catch: Throwable -> L18
        goto L15
    }

    public final void processPrepareWidget(Context r3, WidgetManager r4, MiddlewareRoomContext r5) {
        Intrinsics.checkNotNullParameter(r4, "widgetManager");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        if (k.n(IUserService.class).user().isLogin() == false) goto L8;
        if (TextUtils.isEmpty(k.n(IUserService.class).user().n()) == true) goto L8;
        IUserService r0 = k.f(IUserService.class);
        Intrinsics.checkNotNull(r0);
        r0.showAuthOrDailyToast(true);
    L8:
        if (k.n(IUserService.class).user().isLogin() == true) goto L19;
        if (r3 != null) goto L11;
        return;
    L11:
        if (a != null) goto L15;
        IEnterGuideService r1 = k.f(IEnterGuideService.class);
        if (r1 == null) goto L15;
        a = r1.createAuthActionRoutine();
    L15:
        l32.a r2 = a;
        if (r2 == null) goto L21;
        r2.a(r3, r4, r5);
        return;
    L21:
        return;
    }

    public final void processFetchRoomState(Room r17, Bundle r18, DataCenter r19, HashMap<String, String> r20, HashMap<String, String> r21, com.bytedance.android.livesdk.commerce.a r22, Boolean[] r23) {
        Intrinsics.checkNotNullParameter(r20, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r21, "outAdLiveParams");
        Intrinsics.checkNotNullParameter(r23, "isSpecialAdRef");
        if (r17 == null) goto L20;
        if (r18 == null) goto L6;
        r18.putInt("EXTRA_INT_BUSINESS_SHOW_WINDMILL", r17.getBusinessLive());
    L6:
        if (r18 == null) goto L12;
        RoomAuthStatus r8 = r17.getMRoomAuthStatus();
        if (r8 == null) goto L10;
        long r9 = r8.getCommerceCard();
    L11:
        r18.putLong("EXTRA_LONG_COMMERCE_CARD", r9);
        goto L12
    L10:
        r9 = 0;
    L12:
        IMiddlewareRoomService r10 = k.f(IMiddlewareRoomService.class);
        if (r10 == null) goto L20;
        ILiveOntologyInfoManager r11 = r10.getLiveOntologyRecord();
        if (r11 == null) goto L20;
        boolean r12 = r11.isFirstRoom(r17.getRoomId());
        if (r18 == null) goto L20;
        r18.putBoolean("EXTRA_IS_FIRST_ROOM", r12);
    L20:
        if (r19 == null) goto L109;
        String r0 = (String) r19.get("data_enter_ecom_live_params", "");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r0) == false) goto L24;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L36
    L25:
        Iterator<String> r13 = r1.keys();     // Catch: JSONException -> L36
        boolean r14 = false;
    L101:
    L34:
        e = e;
    L38:
        ALogger.e("[build_room_state]", e);
    L39:
        if (r14 == true) goto L45;
        if (r17 == null) goto L45;
        String r2 = qd1.a.a(r17);
        if (TextUtils.isEmpty(r2) == true) goto L45;
        r20.put("enter_request", r2);
    L45:
        if (((Boolean) LiveConfigSettingKeys.DISABLE_OLD_LIVE_AD_PARAMS.getValue()).booleanValue() == true) goto L109;
        String r3 = (String) r19.get("data_enter_ad_live_params", "");     // Catch: JSONException -> L55
        if (TextUtils.isEmpty(r3) == false) goto L49;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L55
    L50:
        Iterator<String> r15 = r4.keys();     // Catch: JSONException -> L55
    L51:
        if (r15.hasNext() == false) goto L109;
        String r16 = r15.next();     // Catch: JSONException -> L55
        r20.put(r16, r4.optString(r16));     // Catch: JSONException -> L55
        goto L51
    L49:
        r4 = new JSONObject(r3);     // Catch: JSONException -> L55
    L55:
        e = move-exception;
        ALogger.e("[build_room_state]", e);
        goto L109
    L28:
        if (r13.hasNext() == false) goto L39;
        String r110 = r13.next();     // Catch: JSONException -> L34
        String r111 = r1.optString(r110);     // Catch: JSONException -> L34
        if (TextUtils.equals(r110, "enter_request") == false) goto L101;
        if (TextUtils.isEmpty(r111) == true) goto L101;
        r14 = true;
        goto L101
    L24:
        r1 = new JSONObject(r0);     // Catch: JSONException -> L36
    L36:
        e = e;
        r14 = false;
    L109:
        String r5 = r20.get("enter_request");     // Catch: JSONException -> L61
        if (r2.a(r5) == false) goto L63;
        JSONObject r7 = new JSONObject(r5);     // Catch: JSONException -> L61
        r7.put("is_need_block_coupon", "true");     // Catch: JSONException -> L61
        r20.put("enter_request", r7.toString());     // Catch: JSONException -> L61
    L63:
        if (r17 == null) goto L89;
        Map r6 = com.bytedance.android.livesdk.preview.u.a;
        Intrinsics.checkNotNullParameter(r17, "room");
        HashMap r24 = new HashMap();
        String r25 = r17.adRawString;     // Catch: JSONException -> L74
        if (TextUtils.isEmpty(r25) == false) goto L68;
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L74
    L69:
        Iterator<String> r27 = r26.keys();     // Catch: JSONException -> L74
    L70:
        if (r27.hasNext() == false) goto L76;
        String r28 = r27.next();     // Catch: JSONException -> L74
        r24.put(r28, r26.optString(r28));     // Catch: JSONException -> L74
    L76:
        if (r19 != null) goto L107;
    L88:
        r21.putAll(r24);
        goto L89
    L107:
        String r29 = (String) r19.get("data_enter_ad_live_params", "");     // Catch: JSONException -> L86
        if (TextUtils.isEmpty(r29) == false) goto L80;
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L86
    L81:
        Iterator<String> r31 = r30.keys();     // Catch: JSONException -> L86
    L82:
        if (r31.hasNext() == false) goto L88;
        String r32 = r31.next();     // Catch: JSONException -> L86
        r24.put(r32, r30.optString(r32));     // Catch: JSONException -> L86
        goto L82
    L80:
        r30 = new JSONObject(r29);     // Catch: JSONException -> L86
    L86:
        e = move-exception;
        ALogger.e("[build_room_state_from_outer]", e);
        goto L88
    L68:
        Intrinsics.checkNotNull(r25);     // Catch: JSONException -> L74
        r26 = new JSONObject(r25);     // Catch: JSONException -> L74
    L74:
        e = move-exception;
        ALogger.e("[build_room_state_from_inner]", e);
    L89:
        if (r19 == null) goto L93;
        Boolean r33 = (Boolean) r19.get("live_special_ad", Boolean.FALSE);
        if (r33 == null) goto L93;
        boolean r34 = r33.booleanValue();
    L94:
        r23[0] = Boolean.valueOf(r34);
        Map<? extends String, ? extends String> r35 = n.b();
        if (r35 == null) goto L120;
        if (r22 == null) goto L121;
        r22.a.putAll(r35);
        return;
    L121:
        return;
    L120:
        return;
    L93:
        r34 = false;
    L61:
        e = move-exception;
        ALogger.e("CouponDialogWidget", "In fetchRoomState() ", e);
        goto L63
    }
}
