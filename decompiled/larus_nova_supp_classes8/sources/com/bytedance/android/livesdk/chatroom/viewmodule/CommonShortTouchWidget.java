package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.HideMode;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.activity.ShortTouchDataSource;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.n5;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.api.ShortTouchRetrofitApi;
import com.bytedance.android.livesdk.chatroom.utils.z3;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.BubbleComponent;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconTemplate;
import com.bytedance.android.livesdk.message.model.fl;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.ShortTouchResponseData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.backend.BackendTaskConfigSwitch;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonElement;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/CommonShortTouchWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lvlc/l;", "", "Lzg1/v;", "event", "", "onEvent", "<init>", "()V", "a", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonShortTouchWidget extends LiveWidget implements vlc.l {
    public IShortTermIconFramework a;
    public IShortTermIndicatorManager b;
    public boolean c;
    public final HashMap<Integer, com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f> d;
    public Disposable e;
    public com.bytedance.android.livesdk.chatroom.utils.t f;
    public com.bytedance.android.livesdk.chatroom.monitor.f g;
    public long h;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.c;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ShortTouchRequestInfo(enterSource=" + this.a + ", params=" + this.b + ", actionSource=" + this.c + ")";
        }

        public a(String r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.c {
        public final /* synthetic */ CommonShortTouchWidget a;

        public b(CommonShortTouchWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f.c
        public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r3) {
            Intrinsics.checkNotNullParameter(r3, "iconModel");
            this.a.d.put(Integer.valueOf(r3.q.type), r3);
            r3.i = null;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommonShortTouchWidget a;

        public c(CommonShortTouchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            if (r6 == null) goto L11;
            CommonShortTouchWidget r0 = this.a;
            ShortTouchResponseData r1 = (ShortTouchResponseData) ((BaseResponse) r6).data;
            Extra r7 = ((BaseResponse) r6).extra;
            if (r7 == null) goto L8;
            long r2 = r7.now;
        L9:
            CommonShortTouchWidget.wq(r0, r1, r2);
            return;
        L8:
            r2 = 0;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CommonShortTouchWidget a;

        public d(CommonShortTouchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            CommonShortTouchWidget r0 = this.a;
            int r1 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
            String r2 = null;
            if (r7 == null) goto L5;
            String r3 = r7.getMessage();
        L6:
            r0.Iq(r1, r3, null, ShortTouchDataSource.API);
            com.bytedance.android.livesdk.chatroom.utils.t r4 = this.a.f;
            if (r4 == null) goto L12;
            StringBuilder r5 = new StringBuilder("query short touch error,exception is ");
            if (r7 == null) goto L11;
            r2 = r7.getMessage();
        L11:
            r5.append(r2);
            String r8 = r5.toString();
            int r9 = com.bytedance.android.livesdk.chatroom.utils.t.e;
            r4.b(r8, -1);
        L12:
            CommonShortTouchWidget r10 = this.a;
            StringBuilder r11 = new StringBuilder("exception: ");
            if (r7 != null) goto L15;
            String r12 = "null";
        L16:
            r11.append(r12);
            r10.Fq("query short touch error", r11.toString());
            return;
        L15:
            r12 = r7.getMessage();
            goto L16
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CommonShortTouchWidget a;

        public e(CommonShortTouchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CommonShortTouchWidget r0 = this.a;
            r0.onEvent((zg1.v) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CommonShortTouchWidget a;

        public f(CommonShortTouchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            CommonShortTouchWidget r0 = this.a;
            ((com.bytedance.android.livesdk.test.c) r4).getClass();
            CommonShortTouchWidget.wq(r0, null, System.currentTimeMillis());
        }
    }

    public final String getSpm() {
        return "a100.a100.a113";
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        boolean r0 = false;
        this.c = false;
        Boolean r3 = null;
        IRoom r1 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r1 == null) goto L5;
        long r2 = r1.getRoomId();
    L6:
        this.h = r2;
        com.bytedance.android.livesdk.chatroom.r r4 = z51.a.c(((Widget) this).dataCenter, r2);
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.j r5 = r4.B();
        if (r5 == null) goto L11;
        Object r6 = r5.getValue();
    L13:
        if ((r6 instanceof IShortTermIconFramework) == true) goto L15;
        r6 = null;
    L15:
        this.a = (IShortTermIconFramework) r6;
        com.bytedance.android.livesdk.chatroom.r r7 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r7 == null) goto L20;
        com.bytedance.live.datacontext.j r8 = r7.D();
        if (r8 == null) goto L20;
        Object r9 = r8.getValue();
    L22:
        if ((r9 instanceof IShortTermIndicatorManager) == true) goto L24;
        r9 = null;
    L24:
        this.b = (IShortTermIndicatorManager) r9;
        this.f = new com.bytedance.android.livesdk.chatroom.utils.t("a100.a100.a113", "CommonShortTouchWidget");
        long r10 = this.h;
        int r11 = com.bytedance.android.livesdk.chatroom.monitor.a.a;
        if (((Boolean) LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue()).booleanValue() == false) goto L27;
        com.bytedance.android.livesdk.chatroom.monitor.f r12 = new com.bytedance.android.livesdk.chatroom.monitor.f(r10, 1);
    L28:
        this.g = r12;
        if (r12 == null) goto L31;
        r12.d("ST_WIDGET_ONCREATE");
    L31:
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.v.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new e(this));
        vlc.d r13 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r13 == null) goto L34;
        r13.addMessageListener(MessageType.SHORT_TOUCH_AREA_MESSAGE.getIntType(), this);
    L34:
        com.bytedance.android.livesdk.chatroom.o r14 = com.bytedance.android.livesdk.chatroom.utils.o3.j(((Widget) this).dataCenter);
        if (((Boolean) LiveInfraSettingKeys.LIVE_SHORT_TOUCH_ANCHOR_PARAMS_ENABLE.getValue()).booleanValue() == true) goto L37;
    L39:
        boolean r15 = false;
    L40:
        if (r15 == false) goto L42;
        String r16 = r14.J1();
    L43:
        String r17 = "";
        if (r15 == false) goto L51;
        JsonElement r18 = r14.p2();
        if (r18 == null) goto L63;
        String r19 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r18);
        if (r19 == null) goto L63;
    L50:
        r17 = r19;
    L63:
        final a r20 = new a(r16, r17, ((Boolean) ((Widget) this).dataCenter.get("data_short_touch_action_source_params", Boolean.FALSE)).booleanValue() ? 1 : 0);
        ALogger.i("CommonShortTouchWidget", "params =" + r20);
        com.bytedance.android.livesdk.chatroom.monitor.f r21 = this.g;
        if (r21 == null) goto L66;
        r21.d("FETCH_ST_DATA_START");
    L66:
        um0.a r22 = om0.c.i();
        if (r22 == null) goto L70;
        final ShortTouchRetrofitApi r23 = (ShortTouchRetrofitApi) r22.getService(ShortTouchRetrofitApi.class);
        if (r23 == null) goto L70;
    L71:
        int r24 = com.bytedance.android.livesdk.test.e.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L74;
    L76:
        if (r0 == false) goto L78;
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.test.c.class).as(autoDispose())).subscribe(new f(this));
    L97:
        com.bytedance.android.livesdk.chatroom.r r25 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r25 == null) goto L103;
        com.bytedance.live.datacontext.n r26 = r25.v();
        if (r26 == null) goto L104;
        r26.setValue(Boolean.TRUE);
        return;
    L104:
        return;
    L103:
        return;
    L78:
        a50.a r27 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r27 != null) goto L81;
    L96:
        Cq(r23, r20);
        goto L97
    L81:
        if (r27.m() != true) goto L96;
        com.bytedance.android.livesdk.chatroom.r r28 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r28 == null) goto L88;
        com.bytedance.live.datacontext.n r29 = r28.v();
        if (r29 == null) goto L88;
        r3 = (Boolean) r29.getValue();
    L88:
        if ((!Intrinsics.areEqual(r3, Boolean.TRUE)) == false) goto L96;
        if (com.bytedance.android.livesdk.config.b0.a == true) goto L96;
        IRoomModuleService r30 = jc1.k.f(IRoomModuleService.class);
        if (r30 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.room.backend.g r31 = r30.getLiveRoomBackendUtils();
        if (r31 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r31, ((Number) ((Widget) this).dataCenter.get("data_room_id", 0L)).longValue(), null, ShortTouchResponseData.class, new AnonymousClass3(this, r23, r20), null, new AnonymousClass4(this, r23, r20), null, this, null, false, false, 3664);
        goto L97
    L74:
        if (((Boolean) n5.a.getValue()).booleanValue() == false) goto L76;
        r0 = true;
    L70:
        r23 = (ShortTouchRetrofitApi) com.bytedance.android.live.network.c.b().e(ShortTouchRetrofitApi.class);
        goto L71
    L51:
        com.bytedance.android.livesdk.chatroom.r r32 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r32 == null) goto L54;
        r19 = r32.L(((Widget) this).dataCenter);
    L55:
        r17 = (String) ((Widget) this).dataCenter.get("data_short_touch_params", "");
        if (r19 == null) goto L63;
        if (r19.length() <= 0) goto L60;
        boolean r33 = true;
    L61:
        if (r33 != true) goto L63;
    L60:
        r33 = false;
        goto L61
    L54:
        r19 = null;
        goto L55
    L42:
        r16 = (String) ((Widget) this).dataCenter.get("data_live_room_enter_source", null);
        goto L43
    L37:
        if (Intrinsics.areEqual(r14.isAnchor(), Boolean.TRUE) == false) goto L39;
        r15 = true;
        goto L40
    L27:
        r12 = null;
    L20:
        r9 = null;
    L11:
        r6 = null;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public CommonShortTouchWidget() {
        this.d = new HashMap();
    }

    public final void onDestroy() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L5;
        ((Widget) this).dataCenter.put("data_common_short_touch_exist_info", null);
    L6:
        Disposable r0 = this.e;
        if (r0 == null) goto L9;
        r0.dispose();
    L9:
        vlc.d r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r1 == null) goto L12;
        r1.removeMessageListener(this);
    L12:
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f> r2 = this.d.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r2.next().requestDispose();
        goto L14
    L16:
        this.d.clear();
        this.a = null;
        this.b = null;
        this.g = null;
        super.onDestroy();
        return;
    L5:
        DataCenter r3 = ((Widget) this).dataCenter;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.o r4 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.o();
        ArrayList r5 = new ArrayList();
        r4.a = r5;
        r5.addAll(this.d.keySet());
        Unit r6 = Unit.INSTANCE;
        r3.put("data_common_short_touch_exist_info", r4);
        goto L6
    }

    public final void onPause() {
        super.onPause();
        IShortTermIconFramework r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public final void onResume() {
        super.onResume();
        IShortTermIconFramework r0 = this.a;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final String Bq(String r18) {
        JSONObject r4 = null;
        Object r2 = ((Widget) this).dataCenter.get("hourly_arrived_live_info", null);
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        IMiddlewareHostBusiness r5 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r5 == null) goto L8;
        String r6 = r5.getCurrentUserAddress(jc1.a.b().getApplicationContext(), null, -1);
    L10:
        if (r6 == null) goto L50;
        JSONArray r7 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(r6), "address_list");
        int r8 = 0;
        if (r7 == null) goto L14;
        int r9 = r7.length();
    L15:
        JSONObject r10 = null;
    L16:
        if (r8 >= r9) goto L49;
        if (r7 == null) goto L19;
        JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r7, r8);
    L20:
        if (r11 == null) goto L22;
        Object r12 = JSONObjectProtectorUtils.getString(r11, "biz_code");
    L24:
        if (Intrinsics.areEqual(r12, "xiaodian.supermarket_pop") == false) goto L48;
        r10 = new JSONObject();
        if (r11 == null) goto L28;
        JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(r11, "address");
    L29:
        r10.put("address", r13);
        if (r3 == null) goto L48;
        if ((!Intrinsics.areEqual(r3, "")) == false) goto L48;
        JSONObject r14 = new JSONObject(r3);
        String r15 = r14.optString("receive_address_id");
        int r16 = r14.optInt("address_type");
        String r17 = r14.optString("store_id");
        if (r14.has("store_id") == false) goto L39;
        if (com.bytedance.android.livesdk.utils.r2.a(r17) == false) goto L39;
        r10.put("store_id", r17);
    L39:
        if (r14.has("receive_address_id") == false) goto L48;
        if (com.bytedance.android.livesdk.utils.r2.a(r15) == false) goto L48;
        JSONObject r19 = r10.optJSONObject("address");
        if (r19 == null) goto L45;
        r19.put("id", r15);
    L45:
        JSONObject r20 = r10.optJSONObject("address");
        if (r20 == null) goto L48;
        r20.put("address_type", r16);
        goto L48
    L28:
        r13 = r4;
    L48:
        r8 = r8 + 1;
        r4 = null;
        goto L16
    L22:
        r12 = r4;
        goto L24
    L19:
        r11 = r4;
        goto L20
    L49:
        Object r21 = r10;
    L51:
        if (r21 != null) goto L54;
        return r18;
    L54:
        if (r18 == null) goto L59;
        if ((!Intrinsics.areEqual(r18, "")) == false) goto L59;
        return new JSONObject(r18).put("hourly_arrived_address_info", r21).toString();
    L59:
        return new JSONObject().put("hourly_arrived_address_info", r21).toString();
    L14:
        r9 = 0;
        goto L15
    L50:
        r21 = null;
        goto L51
    L8:
        r6 = null;
        goto L10
    }

    public final void onEvent(zg1.v r11) {
        com.bytedance.android.livesdk.chatroom.utils.t r0 = this.f;
        Integer r1 = null;
        if (r0 == null) goto L5;
        int r2 = com.bytedance.android.livesdk.chatroom.utils.t.e;
        r0.c("on event", null);
    L5:
        Fq("receive short touch event", JsonUtil.toJSONString(r11));
        if (r11 == null) goto L8;
        r1 = Integer.valueOf(r11.a);
    L8:
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L16;
    L20:
        if (r1 != null) goto L23;
    L27:
        if (r1 != null) goto L30;
        return;
    L30:
        if (r1.intValue() != 3) goto L50;
        int r3 = r11.b;
        com.bytedance.android.live.base.model.n r12 = r11.c;
        if (r12 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r4 = this.d.get(Integer.valueOf(r3));
        if (r4 == null) goto L51;
        Intrinsics.checkNotNullParameter(r12, "shortTouchArea");
        CommonIconTemplate r5 = r4.g;
        if (r5 == null) goto L52;
        BubbleComponent r6 = r4.l;
        if (r6 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.view.k r7 = r6.b;
        if (r7 == null) goto L43;
        r7.b();
    L43:
        BubbleComponent r8 = new BubbleComponent(r4.getContext(), r5, r12.bubbleParams, r12.type, r12.timeStamp, r4.r);
        r4.l = r8;
        r8.a();
        return;
    L52:
        return;
    L51:
        return;
    L54:
        return;
    L50:
        return;
    L23:
        if (r1.intValue() != 1) goto L27;
        int r13 = r11.b;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r14 = this.d.get(Integer.valueOf(r13));
        if (r14 == null) goto L48;
        r14.j();
        return;
    L48:
        return;
    L16:
        if (r1.intValue() != 2) goto L20;
        int r15 = r11.b;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r16 = this.d.get(Integer.valueOf(r15));
        if (r16 == null) goto L46;
        r16.activateIcon();
        return;
    L46:
        return;
    L11:
        if (r1.intValue() != 0) goto L13;
        Aq(r11.b, ShortTouchDataSource.JSB);
    }

    public final void onMessage(tlc.d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.utils.t r0 = this.f;
        if (r0 == null) goto L7;
        int r2 = com.bytedance.android.livesdk.chatroom.utils.t.e;
        r0.c("onMessage", null);
    L7:
        fl r6 = (fl) r5;
        com.bytedance.android.live.base.model.n r1 = r6.G();
        com.bytedance.android.live.base.model.n r3 = r6.G();
        if (r3 == null) goto L10;
        long r4 = r3.timeStamp;
    L11:
        Gq(r1, r4, null);
        if (zq(r1) == false) goto L24;
        Integer r7 = r6.E();
        if (r7 != null) goto L17;
    L22:
        if (r1 == null) goto L27;
        yq(r1);
        xq(r1);
    L27:
        Map r8 = ((BaseMessage) r6).messageExtra;
        if (r8 == null) goto L31;
        String r9 = (String) r8.get("source");
        if (r9 == null) goto L31;
    L32:
        int r10 = ActivityMonitor.ActivityStatusCode.SUCCESS.getCode();
        if (TextUtils.equals(r9, String.valueOf(1)) == false) goto L35;
        ShortTouchDataSource r11 = ShortTouchDataSource.JSB;
    L36:
        Iq(r10, "", r1, r11);
        return;
    L35:
        r11 = ShortTouchDataSource.MESSAGE;
    L31:
        r9 = "";
        goto L32
    L17:
        if (r7.intValue() != 2) goto L22;
        if (r1 == null) goto L20;
        int r12 = r1.type;
    L21:
        Aq(r12, ShortTouchDataSource.MESSAGE);
        goto L27
    L20:
        r12 = 0;
        goto L21
    L24:
        com.bytedance.android.livesdk.chatroom.utils.t r13 = this.f;
        if (r13 == null) goto L27;
        int r14 = com.bytedance.android.livesdk.chatroom.utils.t.e;
        r13.b("onMessage,ShortTouchAreaInfo is error", -1);
        goto L27
    L10:
        r4 = 0;
        goto L11
    }

    public final void xq(com.bytedance.android.live.base.model.n r5) {
        if (r5.hideMode != HideMode.HorizontalHide.getValue()) goto L10;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        if (gb2.a.c(r0, true) == true) goto L10;
        return;
    L10:
        if (this.d.get(Integer.valueOf(r5.type)) == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r1 = this.d.get(Integer.valueOf(r5.type));
        if (r1 == null) goto L30;
        r1.k(r5);
        return;
    L30:
        return;
    L12:
        if (r5.loadType != 1) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r2 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.p(r5, ((Widget) this).dataCenter);
    L15:
        r2.i = new b(this);
        IShortTermIconFramework r3 = this.a;
        if (r3 == null) goto L18;
        r3.load(r2, Integer.valueOf(r5.type));
    L18:
        com.bytedance.android.livesdk.chatroom.monitor.f r6 = this.g;
        if (r6 == null) goto L27;
        r6.d("STI_FRAMEWORK_LOAD");
        if (r6.i != 1) goto L28;
        r6.g();
        return;
    L28:
        return;
    L27:
        return;
    L14:
        r2 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f(r5, ((Widget) this).dataCenter, 0);
        goto L15
    }

    public final void yq(com.bytedance.android.live.base.model.n r7) {
        int r0 = r7.priority;
        int r8 = r7.type;
        IShortTermIndicatorManager r1 = this.b;
        if (r1 == null) goto L9;
        ShortTermIndicatorConfig r2 = new ShortTermIndicatorConfig();
        r2.setElements(new HashMap());
        Map r3 = r2.getElements();
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r8);
        ShortTermIndicatorConfig.Element r5 = new ShortTermIndicatorConfig.Element();
        r5.setType(r8);
        r5.setPriority(r0);
        Unit r9 = Unit.INSTANCE;
        r3.put(r4, r5);
    L7:
        Unit r10 = Unit.INSTANCE;
        r1.config(r2);
        return;
    }

    public final boolean zq(com.bytedance.android.live.base.model.n r8) {
        if (r8 != null) goto L6;
        Fq("check ShortTouchAreaInfo error", "info is null");
        return false;
    L6:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getRoom();
        IRoomAuthStatus r3 = null;
        if (r2 == null) goto L11;
        IRoom r4 = (IRoom) r2.getValue();
        if (r4 == null) goto L11;
        IRoomAuthStatus r5 = r4.getRoomAuthStatus();
    L13:
        if ((r5 instanceof RoomAuthStatus) == false) goto L16;
        r3 = r5;
    L16:
        RoomAuthStatus r6 = (RoomAuthStatus) r3;
        if (r6 != null) goto L19;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L32;
        Fq("check ShortTouchAreaInfo error", "filter by room auth");
        return false;
    L32:
        if (r8.enhancedTouch == 0) goto L38;
        if (((Boolean) LiveInfraSettingKeys.LIVE_DISABLE_ENHANCED_SHORT_TOUCH.getValue()).booleanValue() == false) goto L38;
        Fq("check ShortTouchAreaInfo error", "filter by setting");
        return false;
    L38:
        if (ShortTermIndicatorConfig.ElementType.Companion.getByTypeId(r8.type) == null) goto L41;
        Fq("check ShortTouchAreaInfo error", "unsupported type: " + r8.type);
        return false;
    L41:
        int r9 = r8.showType;
        if (r9 == 1) goto L55;
        if (r9 == 0) goto L55;
        int r10 = r8.minSdkVersion;
        if (r10 == 0) goto L54;
        com.bytedance.android.livesdk.chatroom.r r11 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r11 == null) goto L50;
        int r12 = r11.z();
    L51:
        if (r10 <= r12) goto L54;
        Fq("check ShortTouchAreaInfo error", "unsupported minSdkVersion: " + r8.minSdkVersion);
        return false;
    L50:
        r12 = 0;
    L54:
        return true;
    L55:
        Fq("check ShortTouchAreaInfo error", "unsupported showType: " + r8.showType);
        return false;
    L19:
        if (r8.enhancedTouch != 0) goto L23;
        if (r6.enableShortTouch() == true) goto L23;
    L26:
        r7 = false;
    L23:
        if (r8.enhancedTouch == 0) goto L27;
        if (r6.enableEnhancedTouch() == true) goto L27;
    L11:
        r5 = null;
        goto L13
    }

    public final void Aq(int r8, ShortTouchDataSource r9) {
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r0 = this.d.get(Integer.valueOf(r8));
        if (r0 == null) goto L5;
        r0.moveToState(2);
    L5:
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.f r1 = this.d.get(Integer.valueOf(r8));
        if (r1 == null) goto L23;
        com.bytedance.android.live.base.model.n r2 = r1.q;
        if (r2 == null) goto L23;
        int r3 = z3.a;
        String r4 = String.valueOf(r2.type);
        String r5 = String.valueOf(r2.priority);
        com.bytedance.android.live.base.model.q r6 = r2.shortTouchInfo;
        if (r6 == null) goto L12;
        String r7 = r6.loadUrl;
    L13:
        Intrinsics.checkNotNullParameter(r9, "shortTouchDataSource");
        Pair[] r10 = new Pair[4];
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r10[0] = TuplesKt.to("icon_type", r4);
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        r10[1] = TuplesKt.to("icon_order", r5);
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r10[2] = TuplesKt.to("url", r7);
        r10[3] = TuplesKt.to("short_touch_data_from", r9.getSource());
        Map r11 = MapsKt.mutableMapOf(r10);
        com.bytedance.android.livesdk.log.j0.l().sendLog("short_touch_icon_destroy", r11, new Object[]{IRoom.class, am2.x.class});
        goto L23
    L12:
        r7 = null;
    L23:
        this.d.remove(Integer.valueOf(r8));
    }

    public final void Cq(ShortTouchRetrofitApi r13, a r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.config.b0.a == true) goto L23;
        IRoomModuleService r0 = jc1.k.f(IRoomModuleService.class);
        if (r0 == null) goto L23;
        if (r0.getLiveRoomBackendMonitor() == null) goto L23;
        String r1 = String.valueOf(((Number) ((Widget) this).dataCenter.get("data_room_id", 0L)).longValue());
        com.bytedance.android.livesdk.chatroom.r r4 = z51.a.c(((Widget) this).dataCenter, this.h);
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.n r5 = r4.v();
        if (r5 == null) goto L17;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L17;
        boolean r7 = r6.booleanValue();
    L18:
        Intrinsics.checkNotNullParameter(r1, "roomId");
        if (((BackendTaskConfigSwitch) LiveInfraSettingKeys.LIVE_BACKEND_TASK_CONFIG.getValue()).canUseBackendTask() == false) goto L23;
        JSONObject r11 = new JSONObject();
        BaseMonitor.add(r11, "stack_trace", com.bytedance.android.livesdk.chatroom.room.backend.i.l());
        BaseMonitor.add(r11, "room_id", r1);
        BaseMonitor.add(r11, "has_init", r7);
        LiveTracingMonitor.e("ttlive_short_touch_backend_fail", LiveTracingMonitor.EventModule.SHORT_TOUCH, LiveTracingMonitor.EventType.SERVER_API_CALL, null, null, r11);
    L17:
        r7 = false;
    L23:
        if (((Boolean) LiveInfraSettingKeys.LIVE_ADD_ADDRESS_INFO_IN_SHORT_TOUCH_REQUEST_ENABLE.getValue()).booleanValue() == true) goto L38;
        String r2 = r14.b;
    L29:
        long r3 = ((Number) ((Widget) this).dataCenter.get("data_room_id", 0L)).longValue();
        String r8 = r14.a;
        if (r8 != null) goto L32;
        String r9 = "";
    L33:
        if (r2 != null) goto L35;
        String r10 = "";
    L36:
        this.e = r13.queryShortTouchInfo(r3, r9, r10, r14.c).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        return;
    L35:
        r10 = r2;
        goto L36
    L32:
        r9 = r8;
        goto L33
    L38:
        r2 = Bq(r14.b);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        SafetyGuard.a(null, e, "short touch obtain address error");
        r2 = r14.b;
        goto L29
    }

    public final void Eq(com.bytedance.android.live.base.model.n r4, long r5) {
        Gq(r4, r5, (com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.o) ((Widget) this).dataCenter.get("data_common_short_touch_exist_info", null));
        if (zq(r4) == false) goto L5;
        Intrinsics.checkNotNull(r4);
        yq(r4);
        xq(r4);
    L8:
        Iq(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), "", r4, ShortTouchDataSource.API);
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.utils.t r6 = this.f;
        if (r6 == null) goto L8;
        int r7 = com.bytedance.android.livesdk.chatroom.utils.t.e;
        r6.b("/room/short_touch/,ShortTouchAreaInfo is error", -1);
        goto L8
    }

    public final void Fq(String r3, String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.put("event_name", r3);     // Catch: Throwable -> L4
        r1.put("event_info", r4);     // Catch: Throwable -> L4
        com.bytedance.android.livesdk.log.b0.o().k("ttlive_short_touch", r1);     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        r6.printStackTrace();
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static void Gq(com.bytedance.android.live.base.model.n r0, long r1, com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.o r3) {
        if (r0 == null) goto L4;
        r0.timeStamp = r1;
    L4:
        Integer r2 = null;
        if (r3 == null) goto L7;
        List<Integer> r4 = r3.a;
    L8:
        if (r4 == null) goto L19;
        List<Integer> r5 = r3.a;
        if (r0 == null) goto L13;
        r2 = Integer.valueOf(r0.type);
    L13:
        if (((ArrayList) r5).contains(r2) == false) goto L20;
        if (r0 == null) goto L21;
        com.bytedance.android.live.base.model.q r6 = r0.shortTouchInfo;
        if (r6 == null) goto L22;
        r6.a = false;
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public static final void wq(CommonShortTouchWidget r5, ShortTouchResponseData r6, long r7) {
        com.bytedance.android.livesdk.chatroom.monitor.f r0 = r5.g;
        if (r0 == null) goto L5;
        r0.d("FETCH_ST_DATA_END");
    L5:
        if (r6 != null) goto L10;
        com.bytedance.android.livesdk.chatroom.utils.t r8 = r5.f;
        if (r8 == null) goto L9;
        r8.b("query short touch error", 100);
    L9:
        r5.Fq("query short touch error", "invalid response");
        return;
    L10:
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.livesdk.chatroom.utils.o3.f().I2();
        if (r1 == null) goto L18;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L18;
        long r3 = r2.longValue();
        if (r3 <= 0) goto L18;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_backend_short_touch_monitor", MapsKt.mapOf(TuplesKt.to("user_time_from_enter", String.valueOf(System.currentTimeMillis() - r3))), new Object[]{Room.class, am2.x.class});
    L18:
        if (CollectionUtils.isEmpty(r6.shortTouchAreas) == false) goto L22;
        com.bytedance.android.livesdk.chatroom.utils.t r9 = r5.f;
        if (r9 == null) goto L45;
        int r10 = com.bytedance.android.livesdk.chatroom.utils.t.e;
        r9.b("返回内容为空,短触不展示", -1);
        return;
    L45:
        return;
    L22:
        Iterator r4 = r6.shortTouchAreas.iterator();
    L24:
        if (r4.hasNext() == false) goto L28;
        com.bytedance.android.live.base.model.n r11 = (com.bytedance.android.live.base.model.n) r4.next();
        if (r11.enhancedTouch == 0) goto L24;
        r5.Eq(r11, r7);
        goto L24
    L28:
        Iterator r12 = r6.shortTouchAreas.iterator();
    L30:
        if (r12.hasNext() == false) goto L47;
        com.bytedance.android.live.base.model.n r13 = (com.bytedance.android.live.base.model.n) r12.next();
        if (r13.enhancedTouch != 0) goto L30;
        r5.Eq(r13, r7);
        goto L30
    }

    public final void Iq(int r11, String r12, com.bytedance.android.live.base.model.n r13, ShortTouchDataSource r14) {
        if (r13 == null) goto L7;
        com.bytedance.android.live.base.model.q r1 = r13.shortTouchInfo;
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.containerType);
    L9:
        if (r2 != null) goto L12;
    L14:
        if (r2 != null) goto L17;
    L19:
        ActivityHybridMonitor.ContainerType r3 = ActivityHybridMonitor.ContainerType.OTHER;
    L20:
        int r4 = z3.a;
        if (r13 == null) goto L23;
        String r5 = String.valueOf(r13.type);
    L24:
        if (r13 == null) goto L26;
        String r6 = String.valueOf(r13.priority);
    L27:
        if (r13 == null) goto L31;
        com.bytedance.android.live.base.model.q r7 = r13.shortTouchInfo;
        if (r7 == null) goto L31;
        String r8 = r7.loadUrl;
    L32:
        Intrinsics.checkNotNullParameter(r14, "shortTouchDataSource");
        Pair[] r9 = new Pair[4];
        String r10 = "";
        if (r5 != null) goto L35;
        r5 = "";
    L35:
        r9[0] = TuplesKt.to("icon_type", r5);
        if (r6 != null) goto L38;
        r6 = "";
    L38:
        r9[1] = TuplesKt.to("icon_order", r6);
        if (r8 != null) goto L41;
        r8 = "";
    L41:
        r9[2] = TuplesKt.to("url", r8);
        r9[3] = TuplesKt.to("short_touch_data_from", r14.getSource());
        com.bytedance.android.livesdk.log.j0.l().sendLog("short_touch_icon_create", MapsKt.mutableMapOf(r9), new Object[]{IRoom.class, am2.x.class});
        int r15 = com.bytedance.android.livesdk.chatroom.utils.a.a;
        if (r13 == null) goto L44;
        Integer r16 = Integer.valueOf(r13.type);
    L45:
        String r17 = String.valueOf(this.h);
        if (r13 == null) goto L50;
        com.bytedance.android.live.base.model.q r18 = r13.shortTouchInfo;
        if (r18 == null) goto L50;
        String r19 = r18.loadUrl;
    L51:
        Intrinsics.checkNotNullParameter(r14, "source");
        if (ActivityMonitor.a() == false) goto L74;
        JSONObject r20 = new JSONObject();
        r20.put("url", r19);
        r20.put("room_id", r17);
        r20.put("biz_id", r16);
        r20.put("msg", r12);
        com.bytedance.android.livesdk.log.filter.o r110 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r110 == null) goto L59;
        Map r21 = r110.getMap();
        if (r21 == null) goto L59;
        String r22 = (String) r21.get("enter_method");
        if (r22 == null) goto L59;
    L61:
        if (r110 == null) goto L68;
        Map r111 = r110.getMap();
        if (r111 == null) goto L68;
        String r112 = (String) r111.get("enter_from_merge");
        if (r112 == null) goto L68;
        r10 = r112;
    L68:
        JSONObject r113 = new JSONObject();
        r113.put("status_code", r11);
        if (r3 == null) goto L71;
        String r114 = r3.getType();
    L72:
        r113.put("category_1", r114);
        r113.put("category_2", r14.getSource());
        r113.put("enter_method", r22);
        r113.put("enter_from_merge", r10);
        r113.put("short_touch_type", r16);
        ActivityMonitor.c("ttlive_activity_short_touch_receive_data", r113, null, r20);
        return;
    L71:
        r114 = null;
    L59:
        r22 = "";
        goto L61
    L74:
        return;
    L50:
        r19 = null;
        goto L51
    L44:
        r16 = null;
    L31:
        r8 = null;
        goto L32
    L26:
        r6 = null;
        goto L27
    L23:
        r5 = null;
        goto L24
    L17:
        if (r2.intValue() != 2) goto L19;
        r3 = ActivityHybridMonitor.ContainerType.WEB;
        goto L20
    L12:
        if (r2.intValue() != 1) goto L14;
        r3 = ActivityHybridMonitor.ContainerType.LYNX;
    L7:
        r2 = null;
        goto L9
    }
}
