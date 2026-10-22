package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.model.ConnectPage;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.utils.x1;
import com.bytedance.android.livesdk.config.cr;
import com.bytedance.android.livesdk.config.f11;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.w0;
import com.bytedance.android.livesdk.g4;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdk.live.api.RoomStateApi;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/AudienceRoomManageWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/RoomManageWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceRoomManageWidget extends RoomManageWidget {
    public static final /* synthetic */ int m = 0;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AudienceRoomManageWidget a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ kj c;

        public b(AudienceRoomManageWidget r1, Room r2, kj r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.b.isLiveTypeAudio() == false) goto L10;
            ConstraintLayout r0 = this.a.c;
            if (r0 != null) goto L7;
        L8:
            UIUtils.setViewVisibility(this.a.c, 0);
            return;
        L7:
            if (r0.getVisibility() != 0) goto L8;
            return;
        L10:
            if (this.a.d != null) goto L12;
            return;
        L12:
            if (((f11) g4.a.getValue()).d() == false) goto L20;
            kj r1 = this.c;
            if (r1.version < 2) goto L20;
            if (r1.s() != 2) goto L20;
            AudienceRoomManageWidget r2 = this.a;
            if (r2.e == null) goto L20;
            int r3 = AudienceRoomManageWidget.m;
            r2.Pq();
        L20:
            View r4 = this.a.d;
            if (r4 == null) goto L27;
            r4.setVisibility(0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ zg1.m a;

        public c(zg1.m r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.notifyPauseStatus(this.a.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AudienceRoomManageWidget a;

        public d(AudienceRoomManageWidget r1) {
            this.a = r1;
        }

        public final void a() {
            AudienceRoomManageWidget r0 = this.a;
            int r1 = AudienceRoomManageWidget.m;
            r0.getClass();
            if ((!Intrinsics.areEqual(cr.a.getValue(), Boolean.TRUE)) == true) goto L16;
            Room r2 = r0.getRoom();
            if (r2 == null) goto L14;
            User r3 = r2.getOwner();
            if (r3 == null) goto L17;
            Disposable r4 = ((RoomStateApi) com.bytedance.android.live.network.c.b().e(RoomStateApi.class)).checkUserLiveStatus(r3.getUserId(), "195", null, null, null, null, null, "inner_interval", null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.c(r0, r3.getIdStr()), com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.d.a);
            if (r4 == null) goto L15;
            RxUtilKt.c(r4, r0.k);
            return;
        L15:
            return;
        L17:
            return;
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Gq() {
        gl0.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.setIllegalStatus(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Lq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L23;
        EnterRoomExtra r1 = r0.k3();
        if (r1 == null) goto L27;
        Boolean r2 = (Boolean) ((Widget) this).dataCenter.get("data_connect_page_shown", Boolean.FALSE);
        ConnectPage r3 = r1.getMConnectPage();
        if (r2.booleanValue() == true) goto L24;
        if (r3 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r3.schema) == true) goto L28;
        ((Widget) this).dataCenter.put("data_connect_page_shown", Boolean.TRUE);
        ILiveService r4 = TTLiveService.getLiveService();     // Catch: Throwable -> L18
        if (r4 == null) goto L26;
        r4.handleSchema(getContext(), UriProtector.parse(r3.schema));     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L18:
        th = move-exception;
        ALogger.throwable(6, "enter_room_connect_page", "failed to open uri $uriString", th);
        return;
    L28:
        return;
    L24:
        return;
    L27:
        return;
    }

    public final void Pq() {
        gl0.d r0 = this.e;
        if (r0 == null) goto L5;
        r0.setIllegalStatus(true);
    L5:
        gl0.d r1 = this.e;
        if (r1 == null) goto L9;
        g4 r2 = g4.a;
        r1.G4(((f11) r2.getValue()).c(), ((f11) r2.getValue()).a(), ((f11) r2.getValue()).b());
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Aq() {
        super.Aq();
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        Boolean r2 = (Boolean) r1.get("data_broadcast_pause_state_new", Boolean.FALSE);
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L12:
        if (r0.others == null) goto L32;
        if (r0.getMosaicStatus() != 1) goto L32;
        RoomOthersData r4 = r0.others;
        if (r4 == null) goto L18;
        Long r5 = r4.getMV();
    L19:
        if (r5 == null) goto L32;
        if (r5.longValue() != 2) goto L32;
        if (this.e == null) goto L32;
        if (((f11) g4.a.getValue()).d() == false) goto L32;
        Iq(true, "under mosaic status.");
        if (r0.isLiveTypeAudio() == false) goto L30;
        UIUtils.setViewVisibility(this.c, 0);
        return;
    L30:
        Pq();
        UIUtils.setViewVisibility(this.d, 0);
        return;
    L18:
        r5 = null;
    L32:
        if (r0.getMosaicStatus() == 1) goto L34;
        if (r3 == true) goto L34;
        return;
    L34:
        Iq(true, "under mosaic status.");
        if (r0.isLiveTypeAudio() == false) goto L37;
        UIUtils.setViewVisibility(this.c, 0);
        return;
    L37:
        UIUtils.setViewVisibility(this.d, 0);
        return;
    L10:
        r3 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Kq() {
        Room r0 = getRoom();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getStatus() != 3) goto L12;
        ControlMessage r1 = ag1.c.a(r0.getId());
        vlc.d r2 = n3.e(((Widget) this).dataCenter);
        if (r2 == null) goto L10;
        r.d(r1, PSMessageAction.SYSTEM);
        r2.j(r1, true);
    L10:
        xs2.b.a().post(new zg1.h("roomStatus", "enter api"));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void onDestroy() {
        super.onDestroy();
        if (this.k.isDisposed() == true) goto L6;
        this.k.dispose();
        return;
    }

    public final void onResume() {
        super.onResume();
        int r0 = y.a;
        y.a(((Widget) this).dataCenter, this.k, "tryCheckUserLiveStatus", new d(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void zq() {
        xs2.b.a().post(new h1(45));
    }

    public AudienceRoomManageWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Bq(ControlMessage r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        this.f = true;
        com.bytedance.android.live.room.h.b r2 = xq();
        if (r2 == null) goto L8;
        r2.b(3);
    L8:
        Integer r3 = (Integer) ((Widget) this).dataCenter.get("data_link_state", 0);
        xs2.b.a().post(new h1(30));
        ((Widget) this).dataCenter.put("data_broadcast_pause_state_new", Boolean.TRUE);
        String r5 = null;
        if (v.a(r3.intValue(), 4) == false) goto L11;
    L40:
        ConstraintLayout r1 = this.c;
        if (r1 != null) goto L43;
        return;
    L43:
        if (r1.getVisibility() != 8) goto L60;
        View r4 = this.d;
        if (r4 != null) goto L47;
        return;
    L47:
        if (r4.getVisibility() == 8) goto L49;
        return;
    L49:
        if (r9.getExtraInfo() == null) goto L63;
        o0.b r10 = r9.getExtraInfo();
        if (r10 == null) goto L54;
        r5 = r10.getSource();
    L54:
        if (Intrinsics.areEqual("anchor_pause", r5) == true) goto L56;
        return;
    L56:
        if (((Widget) this).dataCenter == null) goto L65;
        zg1.m r11 = new zg1.m();
        r11.a = 1;
        ((Widget) this).dataCenter.put("data_broadcast_pause_state", r11);
        int r6 = y.a;
        y.a(((Widget) this).dataCenter, this.k, "AudienceRoomManageWidget->onControlActionPause", new c(r11));
        return;
    L65:
        return;
    L63:
        return;
    L60:
        return;
    L11:
        if (v.a(r3.intValue(), 256) == true) goto L40;
        if (v.a(r3.intValue(), 64) == true) goto L40;
        if (((w0) h21.c.getValue()).a() == true) goto L17;
    L26:
        ConstraintLayout r7 = this.c;
        if (r7 == null) goto L31;
        if (r7.getVisibility() == 0) goto L40;
    L31:
        if (r9.getExtraInfo() == null) goto L39;
        o0.b r8 = r9.getExtraInfo();
        if (r8 == null) goto L35;
        String r12 = r8.getSource();
    L37:
        if (Intrinsics.areEqual("anchor_pause", r12) == false) goto L39;
        Rq(true);
        goto L40
    L35:
        r12 = null;
    L39:
        Rq(false);
        goto L40
    L17:
        if (r0.isLiveTypeAudio() == true) goto L26;
        View r13 = this.d;
        if (r13 != null) goto L21;
    L22:
        int r14 = com.bytedance.android.livesdk.chatroom.a.a;
        if (com.bytedance.android.livesdk.chatroom.a.a(this.d, ((Widget) this).dataCenter) == false) goto L40;
        Qq(true);
        goto L40
    L21:
        if (r13.getVisibility() == 0) goto L40;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void Cq(ControlMessage r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        boolean r0 = false;
        this.f = false;
        com.bytedance.android.live.room.h.b r1 = xq();
        if (r1 == null) goto L5;
        r1.b(2);
    L5:
        ((Widget) this).dataCenter.put("data_broadcast_pause_state_new", Boolean.FALSE);
        Room r2 = getRoom();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getMosaicStatus() != 0) goto L24;
        Iq(false, "receive resume control msg.");
        UIUtils.setViewVisibility(this.c, 8);
        UIUtils.setViewVisibility(this.d, 8);
        if (((Widget) this).dataCenter == null) goto L13;
        zg1.m r3 = new zg1.m();
        r3.a = 3;
        ((Widget) this).dataCenter.put("data_broadcast_pause_state", r3);
        int r4 = y.a;
        y.a(((Widget) this).dataCenter, this.k, "AudienceRoomManageWidget->fixActionResume", new com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.a(r3));
    L13:
        Function1<String, Unit> r5 = new AudienceRoomManageWidget$fixActionResume$2(this);
        CommonMessageData r6 = r7.getBaseMessage();
        if (r6 == null) goto L18;
        Text r8 = r6.getDisplayText();
        if (r8 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.r.g.d(r8, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.b(r5));
        return;
    L18:
        Room r9 = getRoom();
        if (r9 != null) goto L21;
    L23:
        r5.invoke(r7.getActionString(r0));
        return;
    L21:
        if (r9.isMediaRoom() != true) goto L23;
        r0 = true;
        goto L23
    L24:
        Iq(true, "receive resume control msg but on mosaic status.");
    }

    public final void Qq(boolean r7) {
        HashMap r0 = new HashMap();
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L5;
        int r2 = r1.getLinkMode();
    L7:
        if (v.a(r2, 32) == false) goto L9;
    L19:
        r0.put("interact_function", "chat_room");
    L21:
        if (r7 == false) goto L23;
        r0.put("anchor_status", "suspend");
    L24:
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r0, new Object[]{x.class, Room.class});
        return;
    L23:
        r0.put("anchor_status", "background");
        goto L24
    L9:
        if (v.a(r2, 8) == true) goto L19;
        if (v.a(r2, 2) == false) goto L15;
        r0.put("interact_function", "audience_connect");
        goto L21
    L15:
        if (v.a(r2, 4) == false) goto L17;
    L18:
        r0.put("interact_function", "anchor_connect");
        goto L21
    L17:
        if (v.a(r2, 64) == false) goto L21;
    L5:
        r2 = 0;
        goto L7
    }

    public final void Rq(boolean r10) {
        ConstraintLayout r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r1 = (Integer) ((Widget) this).dataCenter.get("data_link_state", 0);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L33;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        InteractionWidgetsPosContext r4 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r4 == null) goto L10;
        r3.bottomMargin = ((((Number) r4.getPublicScreenHeight().getValue()).intValue() + ((Number) r4.getPublicScreenBottomMargin().getValue()).intValue()) - s1.f(74)) / 2;
    L10:
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L15;
        rj0.m r6 = r5.getVideoTalkService();
        if (r6 == null) goto L15;
        int r7 = r6.m();
    L16:
        r3.rightMargin = s1.f(r7);
        r0.setLayoutParams(r3);
        if (v.a(r1.intValue(), 8) == false) goto L19;
    L30:
        Qq(r10);
        return;
    L19:
        if (x1.c() == true) goto L30;
        if (x1.a() == true) goto L30;
        if (x1.b() == true) goto L30;
        if (x1.d() == true) goto L30;
        UIUtils.setViewVisibility(r0, 0);
        if (r10 == false) goto L29;
        Iq(true, "receive pause control msg by anchor suspend.");
        goto L30
    L29:
        Iq(true, "receive pause control msg by anchor background.");
    L15:
        r7 = 0;
        goto L16
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomManageWidget
    public final void yq(kj r6) {
        Intrinsics.checkNotNullParameter(r6, "remindMessage");
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r1 = this.b;
        if (r1 == null) goto L8;
        FrameLayout r2 = r1.va();
    L9:
        if (r2 == null) goto L11;
        r2.post(new b(this, r0, r6));
    L11:
        Iq(true, "by live illegal block");
        if (((f11) g4.a.getValue()).d() == true) goto L14;
    L22:
        r0.setMosaicStatus(1);
        com.bytedance.android.live.room.h.b r3 = xq();
        if (r3 == null) goto L25;
        r3.a(r6);
    L25:
        ((Widget) this).dataCenter.put("cmd_force_close_linkin", Boolean.TRUE);
        return;
    L14:
        if (r0.others == null) goto L22;
        if (r6.version < 2) goto L22;
        if (r6.s() != 2) goto L22;
        RoomOthersData r4 = r0.others;
        if (r4 == null) goto L22;
        r4.setMV(2L);
        goto L22
    L8:
        r2 = null;
        goto L9
    }
}
