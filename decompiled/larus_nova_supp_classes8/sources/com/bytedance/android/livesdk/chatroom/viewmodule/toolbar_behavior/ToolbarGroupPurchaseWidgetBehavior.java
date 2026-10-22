package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.model.ILiveLocalLifeMessage;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.config.c01;
import com.bytedance.android.livesdk.config.d01;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarGroupPurchaseWidgetBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarGroupPurchaseWidgetBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public View a;
    public View b;
    public DataCenter c;
    public RoomContext d;
    public vlc.d e;
    public Room f;
    public Disposable g;
    public boolean h;
    public boolean i;
    public final Map<String, String> j;
    public final boolean k;

    public static final class a {
        public static boolean a(LiveMode r1) {
            if (r1 == LiveMode.VIDEO) goto L5;
        L9:
            return false;
        L5:
            if (tb1.c.g == false) goto L9;
            if (Intrinsics.areEqual(com.bytedance.android.livesdk.config.t3.a.getValue(), Boolean.TRUE) == false) goto L9;
            return true;
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
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.i3.getValue(), Boolean.TRUE);
    }

    public final void b() {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if ((r0 instanceof FragmentActivity) == false) goto L8;
        String r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.b();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        IHostLiveLocalLife r2 = jc1.k.n(IHostLiveLocalLife.class);
        Intrinsics.checkNotNull(r1);
        r2.openUrlByBullet(r0, r1);
        return;
    L7:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_local_life_no_response", this.j, new Object[0]);
        return;
    L8:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_local_life_no_response", this.j, new Object[0]);
    }

    public ToolbarGroupPurchaseWidgetBehavior(boolean r1) {
        this.k = r1;
        this.j = new HashMap();
    }

    public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r6) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L6;
        return;
    L6:
        if (r6.f == true) goto L10;
        c(8);
        return;
    L10:
        if (this.k == false) goto L24;
        if (tb1.c.g == true) goto L14;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L20;
        c(8);
        return;
    L20:
        c(0);
        View r8 = this.a;
        if (r8 == null) goto L31;
        r8.setAlpha(1.0f);
        return;
    L31:
        return;
    L14:
        if (r6.d() != 0) goto L17;
        r7 = true;
        goto L18
    L24:
        if (r6.d() == 1) goto L26;
        c(8);
        return;
    L26:
        c(0);
        View r9 = this.a;
        if (r9 == null) goto L34;
        r9.setAlpha(1.0f);
        return;
    }

    public final void c(int r2) {
        if (r2 == 0) goto L16;
        if (r2 == 8) goto L7;
        return;
    L7:
        if (this.k == false) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.c);
    L11:
        if (this.k == false) goto L13;
        ToolbarButton r0 = ToolbarButton.GROUP_PURCHASE_MORE;
    L14:
        r3.i(r0.extended());
        return;
    L13:
        r0 = ToolbarButton.GROUP_PURCHASE;
        goto L14
    L9:
        r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.c);
        goto L11
    L16:
        if (this.k == false) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.c);
    L20:
        if (this.k == false) goto L22;
        ToolbarButton r1 = ToolbarButton.GROUP_PURCHASE_MORE;
    L23:
        r4.c(r1.extended());
        return;
    L22:
        r1 = ToolbarButton.GROUP_PURCHASE;
        goto L23
    L18:
        r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.c);
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r7) {
        Intrinsics.checkNotNullParameter(r7, "command");
        if ((r7 instanceof pp1.c) == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_promotion_guide_bubble_show", this.j, new Object[0]);
        RoomContext r0 = this.d;
        Context r1 = null;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r0.getToolbarBubbleManager();
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0 r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0) r2.getValue();
    L13:
        View r4 = this.a;
        if (r4 == null) goto L16;
        r1 = r4.getContext();
    L16:
        final View r5 = this.a;
        if (r1 == null) goto L21;
        if (r3 == null) goto L21;
        if (r5 == null) goto L21;
        r3.addBubbleLocal(r7, ((pp1.c) r7).k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.c, r1, r5), new ToolbarGroupPurchaseWidgetBehavior$onCommand$$inlined$lets$lambda$1(r5, this, r7));
    L21:
        String r8 = SimpleDateFormat.getDateInstance().format(new Date(System.currentTimeMillis()));
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.j3;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r8);
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.k3;
        com.bytedance.android.livesdk.sharedpref.f.d(r9, Integer.valueOf(((Number) r9.getValue()).intValue() + 1));
        return;
    L12:
        r3 = null;
        goto L13
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == 919040494) goto L12;
        return;
    L12:
        if (r1.equals("data_live_mini_app_commerce_status") == false) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r7 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r6.getData();
        if (r7 != null) goto L16;
        return;
    L16:
        if (com.bytedance.android.live.core.utils.z.e(this.c, false) == false) goto L18;
        r0 = r7;
    L18:
        if (r0 == null) goto L23;
        a(r0);
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        if (this.k == false) goto L50;
        RoomContext r0 = this.d;
        if (r0 == null) goto L54;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L54;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L54;
        long r3 = r2.getRoomId();
        Context r11 = r10.getContext();
        if (r11 == null) goto L54;
        final ToolbarBroadcastFunction r6 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L18;
        BottomToolbarViewModel.a r4 = BottomToolbarViewModel.Companion;
        DataCenter r5 = this.c;
        r4.getClass();
        BottomToolbarViewModel r7 = BottomToolbarViewModel.a.a(r5);
        if (r7 == null) goto L54;
        r7.openChangeDialog(r11, r3, r6, new h3(this));
        goto L54
    L18:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r8 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.c);
        if (r8.h() != 1) goto L22;
        ToolbarBroadcastFunction r9 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
    L42:
        ToolbarBroadcastFunction r12 = r9;
    L46:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.e(r11, r8, r3, r12, r6, new ToolbarGroupPurchaseWidgetBehavior$showReplaceDialog$2(this), new ToolbarGroupPurchaseWidgetBehavior$showReplaceDialog$3(this, r6));
        goto L54
    L22:
        if (r8.f() != 1) goto L25;
        r9 = ToolbarBroadcastFunction.MINI_APP;
        goto L42
    L25:
        if (r8.b() != 1) goto L28;
        r9 = ToolbarBroadcastFunction.COMMERCE;
        goto L42
    L28:
        if (r8.c() != 1) goto L31;
        r9 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L42
    L31:
        if (r8.j() != 1) goto L34;
        r9 = ToolbarBroadcastFunction.WELFARE;
        goto L42
    L34:
        if (r8.d() != 1) goto L37;
    L45:
        r12 = r6;
        goto L46
    L37:
        if (r8.e() != 1) goto L40;
        r9 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L42
    L40:
        if (r8.g() != 1) goto L43;
        r9 = ToolbarBroadcastFunction.MINI_GAME;
        goto L42
    L43:
        boolean r13 = tb1.c.a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L45;
        throw new IllegalStateException("cant has other button unfold");
    L54:
        if (this.k == false) goto L56;
        com.bytedance.android.livesdk.sharedpref.e r14 = com.bytedance.android.livesdk.sharedpref.b.i3;
        Boolean r15 = Boolean.FALSE;
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r15);
        return;
    L56:
        View r16 = this.b;
        if (r16 == null) goto L59;
        r16.setVisibility(8);
    L59:
        com.bytedance.android.livesdk.sharedpref.e r17 = com.bytedance.android.livesdk.sharedpref.b.l3;
        Boolean r18 = Boolean.FALSE;
        r17.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r17, r18);
        return;
    L50:
        if (this.i == true) goto L52;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_life_groupbuy_icon_click", this.j, new Object[0]);
    L52:
        this.i = false;
        b();
        goto L54
    }

    public final void onMessage(tlc.d r8) {
        boolean r0 = false;
        if (r8 != null) goto L5;
    L41:
        if (r8 != null) goto L43;
        return;
    L43:
        if (com.bytedance.android.live.core.utils.z.e(this.c, false) == true) goto L45;
    L56:
        if (r0 == true) goto L59;
        r8 = null;
    L59:
        if (r8 == null) goto L65;
        ((ILiveLocalLifeMessage) r8).getUpdateType();
        return;
    L65:
        return;
    L45:
        if (3001 != r8.getIntType()) goto L56;
        if ((r8 instanceof ILiveLocalLifeMessage) == false) goto L56;
        Integer r3 = Integer.valueOf(r8.getClass().getField("type").getInt(r8));     // Catch: Throwable -> L50
    L51:
        if (r3 == null) goto L56;
        if (8 != r3.intValue()) goto L56;
        r0 = true;
    L50:
        r3 = null;
        goto L51
    L5:
        if (com.bytedance.android.live.core.utils.z.e(this.c, false) == true) goto L7;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        tlc.d r5 = r8;
    L15:
        if (r5 == null) goto L41;
        if ((r5 instanceof dm) == true) goto L19;
        r5 = null;
    L19:
        dm r6 = (dm) r5;
        if (r6 == null) goto L41;
        if (r6.getComponentType() != 7) goto L41;
        if (r6.getEventType() != 1) goto L31;
        if (r6.getOpType() != 0) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r7 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.c);
        r7.f = true;
        r7.o = true;
        DataCenter r9 = this.c;
        if (r9 == null) goto L41;
        r9.put("data_live_mini_app_commerce_status", r7);
    L31:
        if (r6.getEventType() != 1) goto L35;
        if (r6.getOpType() != 1) goto L35;
    L38:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.c);
        r10.f = true;
        r10.o = false;
        DataCenter r11 = this.c;
        if (r11 == null) goto L41;
        r11.put("data_live_mini_app_commerce_status", r10);
    L35:
        if (r6.getEventType() == 2) goto L38;
        if (r6.getEventType() != 1) goto L41;
    L14:
        r5 = null;
        goto L15
    L7:
        if (r8.getIntType() != MessageType.TOOLBAR_CONTROL_MESSAGE.getIntType()) goto L11;
        if ((r8 instanceof dm) == false) goto L11;
        r4 = true;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.e;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        Disposable r5 = this.g;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isDisposed() == true) goto L14;
        Disposable r6 = this.g;
        if (r6 == null) goto L15;
        r6.dispose();
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        this.c = r7;
        this.d = RoomContext.a.c(RoomContext.Companion, r7, 0, 2);
        boolean r1 = true;
        r7.observe("data_live_mini_app_commerce_status", this, true);
        LifecycleOwner r2 = null;
        vlc.d r0 = (vlc.d) r7.get("data_message_manager", null);
        this.e = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.TOOLBAR_CONTROL_MESSAGE.getIntType(), this);
    L5:
        vlc.d r3 = this.e;
        if (r3 == null) goto L8;
        r3.addMessageListener(3001, this);
    L8:
        Room r8 = com.bytedance.android.live.core.utils.z.o(r7);
        this.f = r8;
        Map<String, String> r4 = this.j;
        if (r8 == null) goto L11;
        Long r9 = Long.valueOf(r8.id);
    L12:
        ((HashMap) r4).put("room_id", String.valueOf(r9));
        Map<String, String> r10 = this.j;
        Room r5 = this.f;
        if (r5 == null) goto L15;
        String r11 = r5.getOwnerUserIdString();
    L16:
        ((HashMap) r10).put("anchor_id", String.valueOf(r11));
        Observable r12 = jc1.k.n(IBrowserService.class).registerJsEventSubscriber("local_life.live.anchor.explanation_card").observeOn(AndroidSchedulers.mainThread());
        DataCenter r13 = this.c;
        if (r13 == null) goto L19;
        r2 = r13.lifecycleOwner;
    L19:
        ((ObservableSubscribeProxy) r12.as(AutoDispose.bind(r2))).subscribe(new g3(this));
        this.a = r6;
        if (this.k == true) goto L28;
        View r14 = r6.findViewById(2131392581);
        this.b = r14;
        if (r14 == null) goto L28;
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.l3.getValue(), Boolean.TRUE) == false) goto L26;
        int r15 = 0;
    L27:
        r14.setVisibility(r15);
        goto L28
    L26:
        r15 = 8;
    L28:
        a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.c));
        Integer r16 = c01.a.getValue();
        if (r16 != null) goto L32;
    L34:
        String r17 = SimpleDateFormat.getDateInstance().format(new Date(System.currentTimeMillis()));
        String r18 = (String) com.bytedance.android.livesdk.sharedpref.b.j3.getValue();
        Integer r19 = (Integer) com.bytedance.android.livesdk.sharedpref.b.k3.getValue();
        if ((!Intrinsics.areEqual(r17, r18)) == true) goto L37;
    L39:
        r1 = false;
    L40:
        if (r1 == false) goto L44;
        this.g = Observable.timer(120, TimeUnit.SECONDS).subscribe(new f3(this), RxUtil.getNoOpThrowable());
    L44:
        if (this.k == true) goto L47;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_life_groupbuy_icon_show", this.j, new Object[0]);
        return;
    L47:
        return;
    L37:
        if (r19.intValue() >= d01.a.getValue().intValue()) goto L39;
    L32:
        if (r16.intValue() != 0) goto L34;
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    }
}
