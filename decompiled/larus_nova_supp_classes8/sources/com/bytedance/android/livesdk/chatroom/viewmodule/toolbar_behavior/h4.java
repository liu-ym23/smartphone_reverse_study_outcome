package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.PaidLiveApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.config.fd1;
import com.bytedance.android.livesdk.config.hd1;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidProductData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a {
    public static final /* synthetic */ int j = 0;
    public final String a;
    public DataCenter b;
    public Room c;
    public boolean d;
    public CompositeDisposable e;
    public final String f;
    public final String g;
    public final Context h;
    public final boolean i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Ref.LongRef c;

        public b(h4 r1, int r2, Ref.LongRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Response r8 = (Response) r7;
            if (r8 == null) goto L5;
            TicketData r0 = (TicketData) ((BaseResponse) r8).data;
        L6:
            if (r0 == null) goto L28;
            int r1 = this.b;
            int r2 = h4.j;
            if (r1 != 0) goto L15;
            DataCenter r9 = this.a.b;
            if (r9 == null) goto L12;
            r9.put("data_paid_live_sell_ticket_id", "");
        L12:
            DataCenter r10 = this.a.b;
            if (r10 == null) goto L29;
            r10.put("data_paid_live_sell_ticket_owner_id", "");
            return;
        L29:
            return;
        L15:
            TicketData r11 = (TicketData) ((BaseResponse) r8).data;
            if (r11.getTicketId() > 0) goto L18;
            return;
        L18:
            if (r11.getTicketId() == this.c.element) goto L20;
            return;
        L20:
            if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L24;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.a.b);
            boolean r12 = tb1.c.a;
            h4 r13 = this.a;
            ToolbarBroadcastFunction r3 = ToolbarBroadcastFunction.PAID_LIVE_TICKET;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(r13.b);
            r4.g = false;
            r4.i = false;
            r4.n = false;
            r4.m = false;
            r4.k = false;
            r4.l = false;
            r4.j = false;
            r4.o = false;
            r4.h = true;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r4.p = r3;
            DataCenter r14 = r13.b;
            if (r14 == null) goto L24;
            r14.put("data_live_mini_app_commerce_status", r4);
        L24:
            DataCenter r15 = this.a.b;
            if (r15 == null) goto L33;
            r15.put("data_paid_live_sell_ticket_id", String.valueOf(this.c.element));
            return;
        L33:
            return;
        L28:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ALogger.e("bindTicketError", (Throwable) r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final String c() {
        Room r0 = this.c;
        if (r0 == null) goto L23;
        if (r0 == null) goto L8;
        PaidLiveData r1 = r0.getPaidLiveData();
        if (r1 == null) goto L8;
        PaidProductData r2 = r1.getPaidProductData();
    L9:
        if (r2 == null) goto L23;
        Room r3 = this.c;
        if (r3 == null) goto L28;
        PaidLiveData r4 = r3.getPaidLiveData();
        if (r4 == null) goto L29;
        PaidProductData r5 = r4.getPaidProductData();
        if (r5 == null) goto L30;
        PaidProductData.ToolBar r6 = r5.toolBar;
        if (r6 == null) goto L31;
        String r7 = r6.sixJumpUrl;
        if (r7 != null) goto L22;
        return "";
    L22:
        return r7;
    L31:
        return "";
    L30:
        return "";
    L29:
        return "";
    L28:
        return "";
    L8:
        r2 = null;
    L23:
        String r8 = hd1.a.getValue().a();
        if (r8 != null) goto L27;
        return "";
    L27:
        return r8;
    }

    public final String d() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getAnchorPaidReplayRight();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return "1";
    L9:
        return "0";
    }

    public final void f() {
        DataCenter r0 = this.b;
        if (r0 == null) goto L46;
        com.bytedance.android.livesdk.vscore_api.paidlive.b r1 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r0).J0();
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        LiveMode r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r2.getAnchorPaidLiveCreateRights();
        if (r4 == null) goto L9;
        List r5 = (List) r4.getValue();
    L10:
        String r6 = r1.k(r5);
        fd1 r7 = fd1.a;
        if (r7.getValue().booleanValue() == false) goto L13;
        String r8 = c();
    L34:
        Uri.Builder r9 = UriProtector.parse(r8).buildUpon().appendQueryParameter("enter_from_merge", "room_more").appendQueryParameter("enter_method", "more_page").appendQueryParameter("list_type", "live").appendQueryParameter("paid_live_create_rights", r6).appendQueryParameter("replay_right", d());
        Room r10 = this.c;
        if (r10 == null) goto L37;
        r3 = r10.getStreamType();
    L37:
        int r11 = com.bytedance.android.live.core.utils.h1.a;
        Uri.Builder r12 = r9.appendQueryParameter("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
        if (r7.getValue().booleanValue() == false) goto L40;
        String r13 = "2";
    L41:
        Uri.Builder r14 = r12.appendQueryParameter("ticket_explain_manage_version", r13);
        if (TextUtils.isEmpty((CharSequence) r0.get("data_paid_live_sell_ticket_id", "")) == true) goto L44;
        r14.appendQueryParameter("ticket_id", (String) r0.get("data_paid_live_sell_ticket_id", ""));
    L44:
        jc1.k.n(ILiveActionHandler.class).handle(this.h, r14.toString());
        ALogger.i("ToolbarPaidLiveTicketAnchorBehavior", "openFromMoreDialog: " + r14.toString());
        return;
    L40:
        r13 = "1";
        goto L41
    L13:
        Room r15 = this.c;
        if (r15 == null) goto L31;
        PaidLiveData r16 = r15.getPaidLiveData();
        if (r16 == null) goto L18;
        PaidProductData r17 = r16.getPaidProductData();
    L19:
        if (r17 == null) goto L31;
        Room r18 = this.c;
        if (r18 == null) goto L33;
        PaidLiveData r19 = r18.getPaidLiveData();
        if (r19 == null) goto L33;
        PaidProductData r20 = r19.getPaidProductData();
        if (r20 == null) goto L33;
        PaidProductData.ToolBar r21 = r20.toolBar;
        if (r21 == null) goto L33;
        r8 = r21.sixJumpUrl;
        if (r8 != null) goto L34;
    L33:
        r8 = "";
        goto L34
    L18:
        r17 = null;
    L31:
        r8 = hd1.a.getValue().b();
        if (r8 != null) goto L34;
    L9:
        r5 = null;
        goto L10
    }

    public final void g() {
        DataCenter r0 = this.b;
        if (r0 == null) goto L22;
        com.bytedance.android.livesdk.vscore_api.paidlive.b r1 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r0).J0();
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        LiveMode r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r2.getAnchorPaidLiveCreateRights();
        if (r4 == null) goto L9;
        List r5 = (List) r4.getValue();
    L10:
        Uri.Builder r6 = UriProtector.parse(c()).buildUpon().appendQueryParameter("enter_from_merge", "room_bottom").appendQueryParameter("list_type", "live").appendQueryParameter("paid_live_create_rights", r1.k(r5)).appendQueryParameter("replay_right", d());
        Room r7 = this.c;
        if (r7 == null) goto L13;
        r3 = r7.getStreamType();
    L13:
        int r8 = com.bytedance.android.live.core.utils.h1.a;
        Uri.Builder r9 = r6.appendQueryParameter("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
        if (fd1.a.getValue().booleanValue() == false) goto L16;
        String r10 = "2";
    L17:
        Uri.Builder r11 = r9.appendQueryParameter("ticket_explain_manage_version", r10);
        if (TextUtils.isEmpty((CharSequence) r0.get("data_paid_live_sell_ticket_id", "")) == true) goto L20;
        r11.appendQueryParameter("ticket_id", (String) r0.get("data_paid_live_sell_ticket_id", ""));
    L20:
        jc1.k.n(ILiveActionHandler.class).handle(this.h, r11.toString());
        ALogger.i("ToolbarPaidLiveTicketAnchorBehavior", "openFromToolbar: " + r11.toString());
        return;
    L16:
        r10 = "1";
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r8) {
        Disposable r9 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        DataCenter r10 = this.b;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c = r10;
        if (r10 == null) goto L5;
        r10.observeForever("data_live_mini_app_commerce_status", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b.a);
    L5:
        Disposable r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        LiveMode r1 = null;
        if (r0 == null) goto L8;
        r0.dispose();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a = null;
    L8:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a = jc1.k.n(IBrowserService.class).registerJsEventSubscriber("onLiveIntroduceTicketChosen").observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.f(r10), com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.g.a);
        if (this.i == true) goto L44;
        DataCenter r11 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c;
        if (r11 == null) goto L13;
        String r12 = (String) r11.get("data_paid_live_sell_ticket_owner_id", "");
    L14:
        DataCenter r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c;
        if (r2 == null) goto L17;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r2);
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L28;
        if (r3 == null) goto L24;
        User r4 = r3.getOwner();
        if (r4 == null) goto L24;
        String r5 = r4.getIdString();
    L26:
        if (TextUtils.equals(r5, r12) == false) goto L28;
        boolean r13 = true;
    L29:
        Pair[] r6 = new Pair[4];
        r6[0] = TuplesKt.to("enter_from_merge", "live_room");
        if (r3 == null) goto L32;
        r1 = r3.getStreamType();
    L32:
        int r7 = com.bytedance.android.live.core.utils.h1.a;
        r6[1] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r1));
        if (r13 == false) goto L35;
        String r14 = "1";
    L36:
        r6[2] = TuplesKt.to("is_creator_anchor", r14);
        RoomContext r15 = RoomContext.a.c(RoomContext.Companion, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c, 0, 2);
        if (r15 == null) goto L42;
        com.bytedance.live.datacontext.m r16 = r15.getAnchorPaidLiveCreateRights();
        if (r16 == null) goto L42;
        Object r17 = (List) r16.getValue();
        if (r17 == null) goto L42;
    L43:
        r6[3] = TuplesKt.to("carry_ticket_authorization_level_v2", r17.toString());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_carry_ticket_sale_bottom_icon_show", MapsKt.mutableMapOf(r6), new Object[]{Room.class, am2.x.class});
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a();
        return;
    L42:
        r17 = new ArrayList();
        goto L43
    L35:
        r14 = "0";
    L24:
        r5 = null;
    L28:
        r13 = false;
        goto L29
    L17:
        r3 = null;
        goto L19
    L13:
        r12 = null;
        goto L14
    L44:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a();
    }

    public final void e(String r9) {
        DataCenter r0 = this.b;
        LiveMode r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("data_paid_live_sell_ticket_owner_id", "");
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        Room r3 = this.c;
        if (r3 == null) goto L13;
        User r4 = r3.getOwner();
        if (r4 == null) goto L13;
        String r5 = r4.getIdString();
    L15:
        if (TextUtils.equals(r5, r2) == false) goto L17;
        boolean r6 = true;
    L18:
        Pair[] r7 = new Pair[4];
        r7[0] = TuplesKt.to("enter_from_merge", "live_room");
        Room r8 = this.c;
        if (r8 == null) goto L21;
        r1 = r8.getStreamType();
    L21:
        int r10 = com.bytedance.android.live.core.utils.h1.a;
        r7[1] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r1));
        if (r6 == false) goto L24;
        String r11 = "1";
    L25:
        r7[2] = TuplesKt.to("is_creator_anchor", r11);
        RoomContext r12 = RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
        if (r12 == null) goto L31;
        com.bytedance.live.datacontext.m r13 = r12.getAnchorPaidLiveCreateRights();
        if (r13 == null) goto L31;
        Object r14 = (List) r13.getValue();
        if (r14 == null) goto L31;
    L32:
        r7[3] = TuplesKt.to("carry_ticket_authorization_level_v2", r14.toString());
        com.bytedance.android.livesdk.log.u.l().sendLog(r9, MapsKt.mutableMapOf(r7), new Object[]{Room.class, am2.x.class});
        return;
    L31:
        r14 = new ArrayList();
        goto L32
    L24:
        r11 = "0";
    L13:
        r5 = null;
    L17:
        r6 = false;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        if (r15 != null) goto L4;
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.b);
        boolean r16 = tb1.c.a;
        Integer r0 = null;
        ToolbarBroadcastFunction r1 = null;
        r0 = null;
        r0 = null;
        if (this.i == true) goto L9;
        Room r17 = this.c;
        if (r17 != null) goto L52;
    L65:
        g();
    L66:
        e("livesdk_paidlive_carry_ticket_sale_bottom_icon_click");
        e("livesdk_anchor_paidcontent_icon_click");
    L67:
        IBrowserService r18 = jc1.k.f(IBrowserService.class);
        if (r18 == null) goto L78;
        Observable r19 = r18.registerJsEventSubscriber(this.f);
        if (r19 == null) goto L78;
        Observable r110 = r19.observeOn(AndroidSchedulers.mainThread());
        if (r110 == null) goto L78;
        Disposable r111 = RxUtilKt.n(r110, new ToolbarPaidLiveTicketAnchorBehavior$registerTicketPopUpState$1(this));
        if (r111 == null) goto L78;
        CompositeDisposable r2 = this.e;
        if (r2 == null) goto L78;
        r2.add(r111);
    L78:
        IBrowserService r112 = jc1.k.f(IBrowserService.class);
        if (r112 == null) goto L90;
        Observable r113 = r112.registerJsEventSubscriber(this.g);
        if (r113 == null) goto L91;
        Observable r114 = r113.observeOn(AndroidSchedulers.mainThread());
        if (r114 == null) goto L92;
        Disposable r115 = RxUtilKt.n(r114, new ToolbarPaidLiveTicketAnchorBehavior$registerTicketPopUpState$3(this));
        if (r115 == null) goto L93;
        CompositeDisposable r3 = this.e;
        if (r3 == null) goto L94;
        r3.add(r115);
        return;
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L52:
        if (r17.isPaidRoom() != true) goto L65;
        Room r116 = this.c;
        if (r116 == null) goto L60;
        PaidLiveData r117 = r116.getPaidLiveData();
        if (r117 == null) goto L60;
        PaidProductData r118 = r117.getPaidProductData();
        if (r118 == null) goto L60;
        r0 = r118.bringProductFlag;
    L60:
        if (r0 != null) goto L63;
    L64:
        com.bytedance.android.livesdk.widget.x0.b r119 = new com.bytedance.android.livesdk.widget.x0.b(this.h, 4);
        r119.a.l = false;
        r119.m(2131921193);
        r119.l(2131921192);
        r119.j(0, this.h.getString(2131916251), new i4(this));
        r119.i(1, 2131915442, j4.a);
        r119.n();
        goto L66
    L63:
        if (r0.intValue() == 1) goto L65;
    L9:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L67;
        Room r120 = this.c;
        if (r120 == null) goto L13;
        long r4 = r120.id;
    L14:
        long r7 = r4;
        ToolbarBroadcastFunction r10 = ToolbarBroadcastFunction.PAID_LIVE_TICKET;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L19;
        BottomToolbarViewModel.a r121 = BottomToolbarViewModel.Companion;
        DataCenter r5 = this.b;
        r121.getClass();
        BottomToolbarViewModel r6 = BottomToolbarViewModel.a.a(r5);
        if (r6 == null) goto L47;
        r6.openChangeDialog(this.h, r7, r10, new k4(this));
    L47:
        e("livesdk_paidlive_carry_ticket_sale_more_icon_click");
        e("livesdk_anchor_paidcontent_icon_click");
        return;
    L19:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r8 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.b);
        if (r8.h() != 1) goto L24;
        r1 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
    L22:
        ToolbarBroadcastFunction r9 = r1;
        if (r9 == null) goto L46;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.d(this.h, r8, r7, r9, r10, new ToolbarPaidLiveTicketAnchorBehavior$showReplaceDialog$2(this), new ToolbarPaidLiveTicketAnchorBehavior$showReplaceDialog$3(this), new ToolbarPaidLiveTicketAnchorBehavior$showReplaceDialog$4(this));
        e("livesdk_paidlive_carry_ticket_sale_pop_show");
        goto L47
    L46:
        f();
        goto L47
    L24:
        if (r8.f() != 1) goto L27;
        r1 = ToolbarBroadcastFunction.MINI_APP;
        goto L22
    L27:
        if (r8.b() != 1) goto L30;
        r1 = ToolbarBroadcastFunction.COMMERCE;
        goto L22
    L30:
        if (r8.c() != 1) goto L33;
        r1 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L22
    L33:
        if (r8.j() != 1) goto L36;
        r1 = ToolbarBroadcastFunction.WELFARE;
        goto L22
    L36:
        if (r8.d() != 1) goto L39;
        r1 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        goto L22
    L39:
        if (r8.e() != 1) goto L42;
        r1 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L22
    L42:
        if (r8.g() != 1) goto L22;
        r1 = ToolbarBroadcastFunction.MINI_GAME;
        goto L22
    L13:
        r4 = 0;
        goto L14
    L4:
        if (com.bytedance.android.livesdk.utils.f1.a(r15.getId()) == false) goto L6;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r3) {
        DataCenter r4 = this.b;
        if (r4 == null) goto L5;
        r4.put("data_paid_live_sell_ticket_id", "");
    L5:
        DataCenter r5 = this.b;
        if (r5 == null) goto L9;
        r5.put("data_paid_live_sell_ticket_owner_id", "");
        return;
    }

    public h4(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
        this.i = r3;
        this.a = "ToolbarPaidLiveTicketAnchorBehavior";
        this.f = "onEntProductionPagePopupStateChange";
        this.g = "onEntProductionPageClose";
    }

    public static final void b(h4 r7, String r8) {
        DataCenter r0 = r7.b;
        LiveMode r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("data_paid_live_sell_ticket_owner_id", "");
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        Room r3 = r7.c;
        if (r3 == null) goto L13;
        User r4 = r3.getOwner();
        if (r4 == null) goto L13;
        String r5 = r4.getIdString();
    L15:
        if (TextUtils.equals(r5, r2) == false) goto L17;
        boolean r6 = true;
    L18:
        Pair[] r9 = new Pair[5];
        r9[0] = TuplesKt.to("click_type", r8);
        r9[1] = TuplesKt.to("enter_from_merge", "live_room");
        Room r10 = r7.c;
        if (r10 == null) goto L21;
        r1 = r10.getStreamType();
    L21:
        int r11 = com.bytedance.android.live.core.utils.h1.a;
        r9[2] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r1));
        if (r6 == false) goto L24;
        String r12 = "1";
    L25:
        r9[3] = TuplesKt.to("is_creator_anchor", r12);
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, r7.b, 0, 2);
        if (r13 == null) goto L31;
        com.bytedance.live.datacontext.m r14 = r13.getAnchorPaidLiveCreateRights();
        if (r14 == null) goto L31;
        Object r15 = (List) r14.getValue();
        if (r15 == null) goto L31;
    L32:
        r9[4] = TuplesKt.to("carry_ticket_authorization_level_v2", r15.toString());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_carry_ticket_sale_pop_click", MapsKt.mutableMapOf(r9), new Object[]{Room.class, am2.x.class});
        return;
    L31:
        r15 = new ArrayList();
        goto L32
    L24:
        r12 = "0";
    L13:
        r5 = null;
    L17:
        r6 = false;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        CompositeDisposable r4 = this.e;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        this.e = null;
        this.d = false;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L15;
        Disposable r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        if (r3 == null) goto L10;
        r3.removeObserver(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b.a);
    L10:
        Disposable r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        if (r5 == null) goto L13;
        r5.dispose();
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a = null;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b = null;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a
    public final void a(Long r10, int r11) {
        Ref.LongRef r0 = new Ref.LongRef();
        long r1 = 0;
        if (r10 == null) goto L5;
        long r3 = r10.longValue();
    L6:
        r0.element = r3;
        Room r4 = this.c;
        if (r4 == null) goto L9;
        long r5 = r4.id;
    L11:
        if (r5 <= 0) goto L31;
        if (r11 != 0) goto L22;
        if (r10 != null) goto L22;
        DataCenter r12 = this.b;
        if (r12 == null) goto L19;
        String r13 = (String) r12.get("data_paid_live_sell_ticket_id", "0");
        if (r13 == null) goto L19;
        long r6 = CastLongProtector.parseLong(r13);
    L20:
        r0.element = r6;
    L19:
        r6 = 0;
    L22:
        if (r0.element > 0) goto L24;
        return;
    L24:
        com.bytedance.android.livesdk.service.l.d().getClass();
        PaidLiveApi r7 = (PaidLiveApi) com.bytedance.android.live.network.c.b().e(PaidLiveApi.class);
        Room r14 = this.c;
        if (r14 == null) goto L27;
        r1 = r14.id;
    L27:
        Disposable r15 = r7.bindTicket(r1, r0.element, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r11, r0), c.a);
        CompositeDisposable r16 = this.e;
        if (r16 == null) goto L32;
        r16.add(r15);
        return;
    L32:
        return;
    L31:
        return;
    L9:
        r5 = 0;
        goto L11
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        this.b = r3;
        this.e = new CompositeDisposable();
        this.c = (Room) r3.get("data_room", null);
        Disposable r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        Intrinsics.checkNotNullParameter(this, "callback");
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b != null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b = this;
    L9:
        if (this.i == false) goto L12;
        e("livesdk_paidlive_carry_ticket_sale_more_icon_show");
        return;
    }
}
