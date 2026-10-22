package com.bytedance.android.livesdk.coupon;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.qi1;
import com.bytedance.android.livesdk.coupon.customview.UgCouponGoodsNewDialog;
import com.bytedance.android.livesdk.coupon.customview.s;
import com.bytedance.android.livesdk.coupon.util.UgCouponNewDialogFrequencyController;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.pj;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class UgCouponWidget extends LiveRecyclableWidget implements l {
    public vlc.d a;
    public Disposable b;
    public Disposable c;
    public b d;
    public boolean e;
    public final a f;
    public long g;
    public final UgCouponNewDialogFrequencyController h;
    public final com.bytedance.android.live.room.l i;

    public class a implements kf1.a {
        public final /* synthetic */ UgCouponWidget a;

        public final String tag() {
            return "UgCouponWidget";
        }

        public final CloseRoomInterceptList config() {
            return CloseRoomInterceptList.UG_COUPON_REMAIN;
        }

        public a(UgCouponWidget r1) {
            this.a = r1;
        }

        public final boolean qa(Runnable r19, boolean r20) {
            if (r20 == false) goto L5;
            return false;
        L5:
            UgCouponWidget r3 = this.a;
            if (r3.e == false) goto L8;
            return false;
        L8:
            b r4 = r3.d;
            if (r4 != null) goto L11;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, ugCouponResponse is null");
        L40:
            boolean r5 = false;
        L42:
            if (r5 == false) goto L73;
            UgCouponWidget r6 = this.a;
            b r7 = r6.d;
            if (r7 == null) goto L72;
            int r9 = r7.windowStyle;
            if (r9 != 1) goto L57;
            b.c r8 = r7.couponData;
            if (r8 == null) goto L72;
            s r10 = new s(((Widget) r6).context, r8, new f(r6, r8, r19));
            r10.setCanceledOnTouchOutside(false);
            if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L81;
            DialogLancet.handleBlockedDialogShow(r10);
        L56:
            r6.e = true;
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.A1;
            com.bytedance.android.livesdk.sharedpref.f.d(r1, Integer.valueOf(((Integer) r1.getValue()).intValue() + 1));
            com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.B1;
            Long r11 = Long.valueOf(System.currentTimeMillis());
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, r11);
            HashMap r12 = new HashMap();
            r12.put("coupon_id", r8.couponId);
            r12.put("coupon_meta_id", r8.couponMetaId);
            u.l().sendLog("tobsdk_livesdk_unused_coupon_pop_show", r12, new Object[]{Room.class, x.class});
            goto L72
        L81:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L74
        L55:
            DialogLancet.beforeDialogShow(r10);
            r10.show();
            DialogLancet.afterDialogShow(r10);
            goto L56
        L57:
            if (r9 != 2) goto L64;
            com.bytedance.android.livesdk.coupon.customview.h r13 = new com.bytedance.android.livesdk.coupon.customview.h(((Widget) r6).context, r7, new g(r6, r7, r19));
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L77;
            DialogLancet.handleBlockedDialogShow(r13);
        L63:
            r6.e = true;
            UgCouponWidget.Cq(r7);
            ((com.bytedance.android.livesdk.coupon.util.b) r6.h.b.getValue()).call();
            goto L72
        L77:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
        L62:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            goto L63
        L64:
            if (r9 != 3) goto L71;
            UgCouponGoodsNewDialog r14 = new UgCouponGoodsNewDialog(((Widget) r6).context, r7, new h(r6, r7, r19));
            if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L79;
            DialogLancet.handleBlockedDialogShow(r14);
        L70:
            r6.e = true;
            UgCouponWidget.Cq(r7);
            ((com.bytedance.android.livesdk.coupon.util.b) r6.h.b.getValue()).call();
            goto L72
        L79:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L76
        L69:
            DialogLancet.beforeDialogShow(r14);
            r14.show();
            DialogLancet.afterDialogShow(r14);
            goto L70
        L71:
            ALogger.w("UgCouponWidget", "showDialog() >>> invalid windowStyle?");
        L72:
            return true;
        L73:
            return false;
        L11:
            int r15 = r4.windowStyle;
            if (y3.l().n(ToolbarButton.COMMERCE) == true) goto L15;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, commerce is not show windowStyle=" + r15);
            goto L40
        L15:
            if (r3.yq(r15) == false) goto L18;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, show count max windowStyle=" + r15);
            goto L40
        L18:
            if (r15 != 1) goto L23;
            b.c r16 = r4.couponData;
            if (r16 != null) goto L22;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon is null windowStyle=" + r15);
            goto L40
        L22:
            long r17 = r16.expireTimestamp;
            long r18 = 0;
        L34:
            long r110 = com.bytedance.android.livesdk.utils.ntp.e.a() / 1000;
            r3.g = r110;
            if (r110 <= r17) goto L37;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon expired, expTime:" + r17 + " curTime:" + r3.g + " windowStyle: " + r15);
            goto L40
        L37:
            long r21 = r3.i.getDuration() / 1000;
            if (r21 >= r18) goto L41;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, watch time not reach minWatchTime: [" + r18 + "s]  currentRoomWatchDuration: [" + r21 + "s]  windowStyle: " + r15);
            goto L40
        L41:
            r5 = true;
            goto L42
        L23:
            if (r15 == 3) goto L27;
            if (r15 == 2) goto L27;
            ALogger.i("UgCouponWidget", "unknown window_style=" + r15);
        L27:
            b.C0114b r22 = r4.retainWindowInfoV2;
            if (r22 != null) goto L30;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, retainWindowInfoV2 is null windowStyle=" + r15);
            goto L40
        L30:
            b.c r111 = r22.couponData;
            if (r111 != null) goto L33;
            ALogger.i("UgCouponWidget", "can not ShowRemainDialog, coupon is null windowStyle=" + r15);
            goto L40
        L33:
            r17 = r111.expireTimestamp;
            r18 = r22.minWatchTime;
            goto L34
        }
    }

    public final void onInit(Object[] r1) {
    }

    public static ILiveOntologyInfoManager zq() {
        IMiddlewareLiveService r0 = k.f(IMiddlewareLiveService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLiveOntologyRecord();
    }

    public final boolean Bq() {
        com.bytedance.android.livesdk.coupon.util.b r0 = (com.bytedance.android.livesdk.coupon.util.b) this.h.b.getValue();
        boolean r2 = false;
        if (r0.a <= 0) goto L18;
        long r4 = com.bytedance.android.livesdk.coupon.util.b.a();
        int r1 = 1 - r0.a;
        Calendar r6 = Calendar.getInstance();
        r6.setTime(new Date(r4));
        r6.add(5, r1);
        long r5 = r6.getTimeInMillis();
        List<Long> r3 = r0.c.a();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r3.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        Object r9 = r8.next();
        if (((Number) r9).longValue() <= r5) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L7;
        r7.add(r9);
        goto L7
    L11:
        r10 = false;
        goto L12
    L15:
        if (r7.size() >= r0.b) goto L18;
        r2 = true;
    L18:
        return !r2;
    }

    public final void onUnload() {
        RoomContext r0 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r0 == null) goto L5;
        ((CopyOnWriteArrayList) r0.getCloseRoomInterceptors().getValue()).remove(this.f);
    L5:
        Disposable r1 = this.b;
        if (r1 != null) goto L8;
    L10:
        Disposable r2 = this.c;
        if (r2 != null) goto L13;
    L15:
        vlc.d r3 = this.a;
        if (r3 == null) goto L18;
        r3.removeMessageListener(this);
    L18:
        this.e = false;
        return;
    L13:
        if (r2.isDisposed() == true) goto L15;
        this.c.dispose();
        goto L15
    L8:
        if (r1.isDisposed() == true) goto L10;
        this.b.dispose();
        goto L10
    }

    public static boolean Aq() {
        long r0 = System.currentTimeMillis();
        long r2 = ((Long) com.bytedance.android.livesdk.sharedpref.b.B1.getValue()).longValue();
        Calendar r4 = Calendar.getInstance();
        Calendar r5 = Calendar.getInstance();
        r4.setTime(new Date(r0));
        r5.setTime(new Date(r2));
        if (r4.get(6) == r5.get(6)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.A1;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, 0);
        return false;
    L10:
        if (((Integer) com.bytedance.android.livesdk.sharedpref.b.A1.getValue()).intValue() >= ((Integer) LiveConfigSettingKeys.UG_COUPON_WINDOW_SHOW_COUNT.getValue()).intValue()) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r4.get(1) != r5.get(1)) goto L7;
        r1 = true;
        goto L8
    }

    public UgCouponWidget(com.bytedance.android.live.room.l r4) {
        this.e = false;
        this.f = new a(this);
        SettingKey<qi1> r1 = LiveConfigSettingKeys.LIVE_UG_COUPON_NEW_DIALOG_CONFIG;
        this.h = new UgCouponNewDialogFrequencyController(((qi1) r1.getValue()).a(), ((qi1) r1.getValue()).b());
        this.i = r4;
    }

    public static void Cq(b r5) {
        b.C0114b r0 = r5.retainWindowInfoV2;
        if (r0 != null) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        int r6 = r5.windowStyle;
        if (r6 != 2) goto L9;
        r1.put("popup_type", "only_coupon");
    L11:
        r1.put("kol_user_tag", r0.kolUserTag);
        u.l().sendLog("tobsdk_livesdk_onefen_buy_popup_show", r1, new Object[]{Room.class, x.class});
        return;
    L9:
        if (r6 != 3) goto L11;
        r1.put("popup_type", "product_coupon");
        goto L11
    }

    public final void Eq(int r9) {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        RoomContext r1 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r1 != null) goto L11;
        return;
    L11:
        if (k.f(IUserService.class).user().isLogin() == true) goto L14;
        ALogger.i("UgCouponWidget", "updateCouponData return, not login");
        return;
    L14:
        SettingKey<List<String>> r2 = LiveConfigSettingKeys.UG_COUPON_ENTRANCE;
        boolean r4 = true;
        if (((List) r2.getValue()).isEmpty() == false) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L21;
        ALogger.i("UgCouponWidget", "updateCouponData return, illegalEntrance");
        return;
    L21:
        RoomContext r5 = RoomContext.getShared(((Widget) this).dataCenter);
        boolean r6 = false;
        if (r5 != null) goto L24;
    L26:
        r4 = false;
    L27:
        if (r4 == false) goto L30;
        ALogger.i("UgCouponWidget", "updateCouponData return, is media room");
        return;
    L30:
        RoomContext r7 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r7 != null) goto L33;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> roomContext is null?");
    L40:
        if (r6 == true) goto L44;
        ALogger.i("UgCouponWidget", "can not ShowRemainDialog, commerce is not show windowType=" + r9);
        return;
    L44:
        if (yq(r9) == false) goto L47;
        ALogger.i("UgCouponWidget", "updateCouponData return, frequencyCheck failed windowType=" + r9);
        return;
    L47:
        this.b = ((CommerceCouponApi) com.bytedance.android.live.network.c.b().e(CommerceCouponApi.class)).getUgCouponData(r9, ((Room) r1.getRoom().getValue()).getId(), zq().getEnterMethod(), zq().getEnterFromMerge()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), new e(this));
        return;
    L33:
        Room r8 = (Room) r7.getRoom().getValue();
        if (r8 != null) goto L36;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> room is null?");
        goto L40
    L36:
        IRoomCart r10 = r8.getRoomCart();
        if (r10 != null) goto L39;
        ALogger.i("UgCouponWidget", "isCommerceRoom() >>> roomCart is null?");
        goto L40
    L39:
        r6 = r10.getContainCart();
        goto L40
    L24:
        if (((Room) r5.getRoom().getValue()).isMediaRoom() == false) goto L26;
    L17:
        r3 = ((List) r2.getValue()).contains(zq().getEnterFromMerge() + "-" + zq().getEnterMethod());
        goto L18
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.b.dispose();
        goto L7
    }

    public final void onLoad(Object[] r3) {
        this.e = false;
        RoomContext r0 = RoomContext.getShared(((Widget) this).dataCenter);
        if (r0 == null) goto L5;
        ((CopyOnWriteArrayList) r0.getCloseRoomInterceptors().getValue()).add(0, this.f);
    L5:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L10;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        this.a = r5;
        if (r5 == null) goto L10;
        r5.addMessageListener(MessageType.RETAIN_POPUP_WINDOW_MESSAGE.getIntType(), this);
    L10:
        Eq(-1);
        this.c = ((v) k.f(IUserService.class).user().m().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(((Widget) this).context))).subscribe(new c(this));
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof pj) == false) goto L6;
        ALogger.i("UgCouponWidget", "receiveRetainMessage");
        Eq(((pj) r3).windowType);
        return;
    }

    public final boolean yq(int r4) {
        if (r4 == (-1)) goto L15;
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L11;
        if (r4 == 3) goto L11;
        return false;
    L11:
        return Bq();
    L13:
        return Aq();
    L15:
        if (Aq() == true) goto L17;
        return false;
    L17:
        if (Bq() == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static void wq(UgCouponWidget r2, b.c r3, String r4) {
        r2.getClass();
        HashMap r5 = new HashMap();
        r5.put("coupon_id", r3.couponId);
        r5.put("coupon_meta_id", r3.couponMetaId);
        r5.put("button_type", r4);
        u.l().sendLog("tobsdk_livesdk_unused_coupon_pop_click", r5, new Object[]{Room.class, x.class});
    }

    public static void xq(UgCouponWidget r4, b r5, String r6) {
        r4.getClass();
        b.C0114b r7 = r5.retainWindowInfoV2;
        if (r7 == null) goto L13;
        HashMap r0 = new HashMap();
        int r8 = r5.windowStyle;
        if (r8 != 2) goto L9;
        r0.put("popup_type", "only_coupon");
    L11:
        r0.put("button_type", r6);
        r0.put("kol_user_tag", r7.kolUserTag);
        u.l().sendLog("tobsdk_livesdk_onefen_buy_popup_click", r0, new Object[]{Room.class, x.class});
        return;
    L9:
        if (r8 != 3) goto L11;
        r0.put("popup_type", "product_coupon");
        goto L11
    }
}
