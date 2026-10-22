package com.bytedance.android.livesdk.coupon;

import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponBenefitType;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/CouponDialogWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "<init>", "()V", "a", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CouponDialogWidget extends RoomWidget {
    public static final /* synthetic */ int e = 0;
    public Disposable b;
    public Boolean c;
    public final Lazy d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CouponDialogWidget a;

        public b(CouponDialogWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L8;
            CouponDialogWidget r3 = this.a;
            int r0 = CouponDialogWidget.e;
            r3.wq();
            Disposable r4 = this.a.b;
            if (r4 == null) goto L9;
            r4.dispose();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final void onDestroy() {
        this.c = null;
        at1.c r0 = (at1.c) this.d.getValue();
        com.bytedance.android.livesdk.coupon.a<?> r1 = r0.b;
        if (r1 == null) goto L5;
        r1.j();
    L5:
        Disposable r2 = r0.c;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        super.onDestroy();
    }

    public final void wq() {
        at1.c r0 = (at1.c) this.d.getValue();
        Long r2 = (Long) r0.d.b.get("data_room_id", 0L);
        IMiddlewareLiveService r5 = k.f(IMiddlewareLiveService.class);
        if (r5 == null) goto L5;
        ILiveOntologyInfoManager r6 = r5.getLiveOntologyRecord();
    L7:
        if (r6 == null) goto L9;
        boolean r3 = r6.isFirstRoom(r2.longValue());
    L11:
        if ((!r3) == true) goto L45;
        at1.a r4 = r0.d;
        Map r9 = (Map) LiveConfigSettingKeys.LIVE_SAAS_COUPON_PRIORITY.getValue();
        if (r9 != null) goto L16;
        r9 = new LinkedHashMap();
    L16:
        int r10 = bt1.b.q;
        Intrinsics.checkNotNullParameter(r4, "couponContext");
        Intrinsics.checkNotNullParameter(r9, "map");
        int r13 = CouponBenefitType.COUPON_BENEFIT_TYPE_AD_QCPX_EXPANSION_COUPON.getValue();
        int r14 = com.bytedance.android.livesdk.coupon.a.f;
        Integer r15 = (Integer) r9.get("expand_coupon");
        if (r15 == null) goto L19;
        int r16 = r15.intValue();
    L20:
        bt1.b r12 = new bt1.b(r4, r13, r16);
        ArrayList r17 = new ArrayList();
        r17.add(r12);
        int r18 = et1.e.i;
        Intrinsics.checkNotNullParameter(r4, "couponContext");
        Intrinsics.checkNotNullParameter(r9, "map");
        int r19 = CouponBenefitType.COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON.getValue();
        Integer r7 = (Integer) r9.get("full_refund_coupon");
        if (r7 == null) goto L23;
        int r8 = r7.intValue();
    L24:
        r17.add(new et1.e(r4, r19, r8));
        int r11 = zs1.g.j;
        Intrinsics.checkNotNullParameter(r4, "couponContext");
        Intrinsics.checkNotNullParameter(r9, "map");
        int r110 = CouponBenefitType.COUPON_BENEFIT_TYPE_UG_COUPON.getValue();
        Integer r20 = (Integer) r9.get("balance_coupon");
        if (r20 == null) goto L27;
        int r21 = r20.intValue();
    L28:
        r17.add(new zs1.g(r4, r110, r21));
        if (r17.size() <= 1) goto L31;
        CollectionsKt.sortWith(r17, new at1.b());
    L31:
        r0.a = r17;
        int r22 = com.bytedance.android.livesdk.coupon.jsb.b.a;
        DataCenter r23 = r4.b;
        bt1.b.C0010b r24 = r12.g;
        Intrinsics.checkNotNullParameter(r23, "dataCenter");
        Intrinsics.checkNotNullParameter(r24, "iExpandCouponJsb");
        IBrowserService r25 = k.f(IBrowserService.class);
        if (r25 == null) goto L36;
        Observable r26 = r25.registerExternalMethodFactory(new com.bytedance.android.livesdk.coupon.jsb.a(r23, r24));
        if (r26 == null) goto L36;
        Disposable r27 = r26.subscribe();
    L37:
        r0.c = r27;
        List<com.bytedance.android.livesdk.coupon.a<?>> r28 = r0.a;
        if (r28 == null) goto L45;
        Iterator r29 = ((ArrayList) r28).iterator();
    L41:
        if (r29.hasNext() == false) goto L45;
        com.bytedance.android.livesdk.coupon.a<?> r30 = (com.bytedance.android.livesdk.coupon.a) r29.next();
        if (r30.c() == false) goto L41;
        r0.b = r30;
        boolean r1 = true;
    L47:
        if (r1 == false) goto L49;
        this.c = Boolean.FALSE;
        com.bytedance.android.livesdk.log.c.a(false, "CouponDialogWidget", "发出消息: 需要释放短触区", "null");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.g(2));
        return;
    L49:
        Long r31 = (Long) ((Widget) this).dataCenter.get("data_room_id", 0L);
        IMiddlewareLiveService r111 = k.f(IMiddlewareLiveService.class);
        if (r111 == null) goto L52;
        ILiveOntologyInfoManager r112 = r111.getLiveOntologyRecord();
    L53:
        if (r112 == null) goto L55;
        boolean r32 = r112.isFirstRoom(r31.longValue());
    L56:
        Room r33 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        Bundle r113 = new Bundle();
        r113.putString("room_id", String.valueOf(r31.longValue()));
        r113.putBoolean("is_portrait", ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue());
        r113.putBoolean("is_inner", !r32);
        if (r33 == null) goto L59;
        String r34 = r33.getOwnerUserIdString();
    L60:
        r113.putString("anchor_open_id", String.valueOf(r34));
        n0 r35 = u.l().c(x.class);
        if ((r35 instanceof n0) == true) goto L63;
        n0 r114 = null;
    L64:
        n0 r36 = r114;
        if (r36 == null) goto L72;
        Map r37 = ((com.bytedance.android.livesdk.log.filter.a) r36).b;
        if (r37 == null) goto L72;
        String r38 = (String) r37.get("enter_from_merge");
        if (r38 == null) goto L72;
        r113.putString("enter_from", r38);
    L72:
        if (r32 == true) goto L91;
        if (r33 == null) goto L87;
        String r39 = qd1.a.a(r33);
        r39.getClass();
        r113.putString("enter_request", r39);
    L87:
        IHostCommerceServiceLive r40 = k.f(IHostCommerceServiceLive.class);
        if (r40 == null) goto L97;
        r40.tryShowSaasCouponDialog(((Widget) this).context, r113, new CouponDialogWidget$handleOnCreateByShopping$3(this));
        return;
    L97:
        return;
    L91:
        String r41 = (String) ((Widget) this).dataCenter.get("data_enter_ecom_live_params", "");     // Catch: JSONException -> L83
        if (TextUtils.isEmpty(r41) == true) goto L81;
        JSONObject r42 = new JSONObject(r41);     // Catch: JSONException -> L83
        JSONObject r115 = r42.optJSONObject("enter_request");     // Catch: JSONException -> L83
        if (r115 == null) goto L80;
        String r116 = r115.toString();     // Catch: JSONException -> L83
        if (r116 == null) goto L80;
        r113.putString("enter_request", r116);     // Catch: JSONException -> L83
    L80:
        r113.putString("card_type", r42.optString("card_type"));     // Catch: JSONException -> L83
        r113.putBoolean("first_coupon_popup_skip_frequency", r42.optBoolean("first_coupon_popup_skip_frequency"));     // Catch: JSONException -> L83
        r113.putString("enter_from_event", r42.optString("enter_from", ""));     // Catch: JSONException -> L83
        r113.putString("previous_page", r42.optString("previous_page", ""));     // Catch: JSONException -> L83
        r113.putLong("is_from_ug", r42.optLong("is_from_ug", 0));     // Catch: JSONException -> L83
        r113.putString("saas_coupon_popup_key", r42.optString("saas_coupon_popup_key", ""));     // Catch: JSONException -> L83
        r113.putInt("saas_coupon_popup_has_applied", r42.optInt("saas_coupon_popup_has_applied", 0));     // Catch: JSONException -> L83
    L81:
        r113.putString("ecom_live_params", r41);     // Catch: JSONException -> L83
    L83:
        e = move-exception;
        int r43 = com.bytedance.android.livesdk.log.c.a;
        com.bytedance.android.livesdk.log.c.a(true, "CouponDialogWidget", "query coupon error", "build ecom params error" + e.getMessage());
        goto L87
    L63:
        r114 = r35;
        goto L64
    L59:
        r34 = null;
        goto L60
    L55:
        r32 = false;
        goto L56
    L52:
        r112 = null;
    L36:
        r27 = null;
        goto L37
    L27:
        r21 = 0;
        goto L28
    L23:
        r8 = 0;
        goto L24
    L19:
        r16 = 0;
    L45:
        r1 = false;
        goto L47
    L9:
        r3 = false;
        goto L11
    L5:
        r6 = null;
        goto L7
    }

    public CouponDialogWidget() {
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CouponDialogWidget$couponManager$2(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.RoomWidget
    public final void onCreate() {
        super.onCreate();
        RoomContext r0 = this.a;
        if (r0 == null) goto L21;
        m r1 = r0.isLiveRoomPreview();
        if (r1 == null) goto L21;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L21;
        RoomContext r2 = this.a;
        if (r2 == null) goto L19;
        m r3 = r2.isLiveRoomPreview();
        if (r3 == null) goto L19;
        Observable r4 = r3.a();
        if (r4 == null) goto L19;
        Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L19;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(AutoDispose.bind(this));
        if (r6 == null) goto L19;
        Disposable r7 = r6.subscribe(new b(this));
    L20:
        this.b = r7;
        return;
    L19:
        r7 = null;
    L21:
        wq();
    }
}
