package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livehostapi.business.IHostMarketing;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.event.AnchorFansGroupPopEvent;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.permission.mapping.ToolbarButtonAuthKeyMapping;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.Panel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogManagerService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.ManageRoomButtonHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.ToolbarAnchorWelfareBehavior;
import com.bytedance.android.livesdk.config.aa;
import com.bytedance.android.livesdk.config.ah;
import com.bytedance.android.livesdk.config.c11;
import com.bytedance.android.livesdk.config.cd0;
import com.bytedance.android.livesdk.config.db;
import com.bytedance.android.livesdk.config.dd0;
import com.bytedance.android.livesdk.config.dw;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.android.livesdk.config.fa0;
import com.bytedance.android.livesdk.config.gc;
import com.bytedance.android.livesdk.config.nc;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.android.livesdk.config.vg;
import com.bytedance.android.livesdk.config.vu;
import com.bytedance.android.livesdk.config.vy;
import com.bytedance.android.livesdk.config.xh;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.message.model.CornerReachMessage;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.room.compatibility.commerce.ToolbarCommerceAnchorInMoreBehavior;
import com.bytedance.android.livesdk.room.compatibility.commerce.ToolbarCommerceAudienceInMoreBehavior;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class AbsToolbarMoreBehavior extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d implements Observer<KVData>, vlc.l, ILiveRecordService.RecordStatusChangeListener {
    public static final Map<ToolbarButton, Integer> K = null;
    public final x0 A;
    public Disposable B;
    public com.bytedance.android.livesdk.utils.c C;
    public final boolean D;
    public com.bytedance.android.livesdk.room.placeholder.behavior.o E;
    public boolean F;
    public AudienceMoreDialogManagerService G;
    public boolean H;
    public com.bytedance.android.livesdk.utils.v0 I;
    public String J;
    public final List<ToolbarButton> b;
    public final Set<ToolbarButton> c;
    public final List<ToolbarButton> d;
    public final List<ToolbarButton> e;
    public final List<ExtendedToolbarButton> f;
    public DataCenter g;
    public Dialog h;
    public long i;
    public View j;
    public View k;
    public final Context l;
    public boolean m;
    public View n;
    public CompositeDisposable o;
    public vlc.d p;
    public Room q;
    public boolean r;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b s;
    public o4 t;
    public ToolbarTransformWidgetBehavior u;
    public ToolbarGroupPurchaseWidgetBehavior v;
    public h2 w;
    public ToolbarAnchorWelfareBehavior x;
    public LiveMode y;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b z;

    public class a implements js0.b {
        public final /* synthetic */ AbsToolbarMoreBehavior a;

        public a(AbsToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onSuccess(String r3) {
            AbsToolbarMoreBehavior r4 = this.a;
            if (r4.z != null) goto L5;
            int r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.b.a;
            r4.z = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.b.a(ToolbarButton.ROOM_INTRO);
        L5:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.a.g).k(ToolbarButton.ROOM_INTRO, this.a.z);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d
    public final int a() {
        return 2131392581;
    }

    static {
        HashMap r0 = new HashMap();
        K = r0;
        r0.put(ToolbarButton.BGM, 3001);
        r0.put(ToolbarButton.FNA_GROUP, 3002);
        r0.put(ToolbarButton.FAN_GROUP_MANAGE, 3002);
        r0.put(ToolbarButton.COMMENT, 3003);
        r0.put(ToolbarButton.ADVANCE_ANNOUNCEMENT, 3007);
        r0.put(ToolbarButton.BROADCAST_INFO, 3051);
        r0.put(ToolbarButton.SHARE, 3053);
        r0.put(ToolbarButton.RECORD, 3056);
        r0.put(ToolbarButton.PUBLIC_SCREEN_SELECTED_MESSAGE, 3057);
        r0.put(ToolbarButton.PUBLIC_SCREEN_CONFIG, 3058);
        r0.put(ToolbarButton.BROADCAST_PAUSE, 3059);
        r0.put(ToolbarButton.ADD_PICTURE, 3071);
        r0.put(ToolbarButton.BROADCAST_ADMIN, 3103);
        r0.put(ToolbarButton.STABLE_MODE, 3060);
        r0.put(ToolbarButton.MANAGE, 3104);
        r0.put(ToolbarButton.ANCHOR_CHAT_CHANNEL, 3061);
        r0.put(ToolbarButton.PUBLIC_SCREEN_AI_HELPER, 3062);
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 i() {
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g);
    }

    public final com.bytedance.android.livesdk.room.placeholder.behavior.o j() {
        if (this.E != null) goto L6;
        this.E = new com.bytedance.android.livesdk.room.placeholder.behavior.o();
    L6:
        return this.E;
    }

    public final void n() {
        Room r0 = this.q;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        if (tb1.c.a == true) goto L16;
        return;
    L16:
        if (this.s != null) goto L18;
        this.s = new ToolbarCommerceAnchorInMoreBehavior(this.l);
    L18:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).k(ToolbarButton.COMMERCE_MORE, this.s);
        return;
    L6:
        if (r0.isHasCommerceGoods() == false) goto L8;
    L11:
        r1 = true;
        goto L12
    L8:
        if (r0.getBaseOwner() == null) goto L12;
        if (r0.getBaseOwner().isWithCommercePermission() == false) goto L12;
        goto L11
    }

    public final void o() {
        String r1 = "";
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L96;
        Object r0 = this.k;
        if ((r0 instanceof RedDotView) == false) goto L82;
        RedDotView r2 = (RedDotView) r0;
        if (r2.getRedDot() == null) goto L82;
        int r6 = com.bytedance.android.livesdk.reddot.b.a;
        RedDotDelegate r7 = r2.getRedDot();
        Intrinsics.checkNotNullParameter(r7, "redDotDelegate");
        TreeSet r8 = r7.c;
        if (r8 == null) goto L13;
        r8.clear();
    L13:
        Iterator r9 = ((HashSet) this.c).iterator();
    L15:
        if (r9.hasNext() == false) goto L34;
        final ToolbarButton r10 = (ToolbarButton) r9.next();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r11 = i().t(r10);
        Map<ExtendedToolbarButton, View> r12 = i().c;
        ExtendedToolbarButton.h.getClass();
        View r13 = (View) ((HashMap) r12).get(ExtendedToolbarButton.a.a(r10));
        if (r13 != null) goto L19;
    L21:
        boolean r14 = true;
    L22:
        if (r11 == null) goto L15;
        if (r14 == false) goto L15;
        if (r11.h7() != null) goto L27;
        ALogger.i("ToolbarMoreBehavior", "not find red dot in ToolbarButton." + r10.name());
        goto L15
    L27:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == true) goto L29;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(r11.h7(), new l(this, r10)));
        goto L15
    L29:
        if (r10.name().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L15;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(r11.h7(), new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.a(this, r10)));
        goto L15
    L19:
        if (r13.getVisibility() != 8) goto L21;
        r14 = false;
        goto L22
    L34:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L39;
        if (com.bytedance.android.livesdk.model.b.c() == false) goto L39;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.t, null));
    L39:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L44;
        if (com.bytedance.android.livesdk.utils.v5.b().getString("live_collect_game_and_should_show_hot_dot", "").length() <= 2) goto L44;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.b, null));
    L44:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L49;
        if (vy.a.getValue().getEnabled() == false) goto L49;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.v, null));
    L49:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L54;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.f.b(RoomContext.getShared(this.g), this.q) == false) goto L54;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.i, null));
    L54:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == false) goto L61;
        if (x6.d() == false) goto L61;
        if (this.D == true) goto L61;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.x, null));
    L61:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == true) goto L63;
    L73:
        Room r3 = this.q;
        if (r3 == null) goto L82;
        if (r3.getRoomAuthStatus() == null) goto L82;
        if (this.q.getRoomAuthStatus().isEnableRoomWidget() == false) goto L82;
        if (aa.a.getValue().booleanValue() == false) goto L82;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.z, null));
        goto L82
    L63:
        if (this.D == false) goto L73;
        if (tb1.c.a == false) goto L73;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.g).n(ToolbarButton.COMMERCE) == false) goto L73;
        if (jc1.k.f(IHostMarketing.class) == null) goto L73;
        if (jc1.k.f(IHostMarketing.class).canInstallShoppingFakeIcon() == false) goto L73;
        com.bytedance.android.livesdk.reddot.b.a(r2.getRedDot(), com.bytedance.android.livesdk.reddot.b.b(up2.a.A, null));
    L82:
        Object r4 = this.k;
        if ((r4 instanceof RedDotView) == false) goto L85;
        boolean r5 = ((RedDotView) r4).j();
    L86:
        if (r5 == true) goto L93;
        DataCenter r15 = this.g;
        if (r15 != null) goto L90;
    L92:
        l(8);
        return;
    L90:
        if (((Integer) r15.get("data_live_im_entrance_folded_unread", 0)).intValue() <= 0) goto L92;
    L93:
        l(0);
        return;
    L85:
        r5 = false;
        goto L86
    L96:
        if (nc.a.getValue().booleanValue() == false) goto L101;
        this.k.setBackgroundResource(2131249474);
        ViewGroup.LayoutParams r16 = this.k.getLayoutParams();
        if (r16 == null) goto L101;
        r16.height = com.bytedance.android.live.core.utils.s1.f(8.0f);
        r16.width = com.bytedance.android.live.core.utils.s1.f(8.0f);
        this.k.setLayoutParams(r16);
    L101:
        boolean r17 = dw.a.getValue().booleanValue();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == true) goto L104;
    L111:
        Iterator r18 = ((HashSet) this.c).iterator();
        boolean r19 = false;
    L113:
        if (r18.hasNext() == false) goto L125;
        ToolbarButton r110 = (ToolbarButton) r18.next();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r111 = i().t(r110);
        Map<ExtendedToolbarButton, View> r112 = i().c;
        ExtendedToolbarButton.h.getClass();
        View r113 = (View) ((HashMap) r112).get(ExtendedToolbarButton.a.a(r110));
        if (r113 != null) goto L117;
    L119:
        boolean r114 = true;
    L120:
        if (r111 == null) goto L113;
        if (r114 == false) goto L113;
        r19 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4.c.a.d(r110.extended(), i());
        if (r19 == false) goto L113;
        ALogger.d("toolbar-red-dot", r110.name() + " red dot sync more button");
        goto L125
    L117:
        if (r113.getVisibility() != 8) goto L119;
        r114 = false;
    L125:
        va1.b r20 = va1.b.a.a;
        IBroadcastService r115 = (IBroadcastService) r20.a(IBroadcastService.class);
        if (this.m == false) goto L132;
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L132;
        if (r115 == null) goto L132;
        r115.getBroadcastDotManager();
    L132:
        if (this.m == true) goto L148;
        if (r17 == true) goto L135;
    L139:
        Context r21 = this.l;
        Object[] r22 = new Object[1];
        if (r19 == false) goto L142;
        r1 = r21.getString(2131919536);
    L142:
        r22[0] = r1;
        String r23 = r21.getString(2131919535, r22);
        if (r19 == false) goto L145;
        l(0);
    L146:
        com.bytedance.android.livesdk.r3.a(this.n, r23);
        return;
    L145:
        l(8);
        goto L146
    L135:
        if (this.i < 0) goto L139;
        if (ah.a.getValue().booleanValue() == true) goto L139;
        r19 = true;
        goto L139
    L148:
        ((IBroadcastService) r20.a(IBroadcastService.class)).getBroadcastDotManager();
        String.valueOf(24);
        new WeakReference(this);
        throw null;
    L104:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == false) goto L109;
        long r24 = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        this.i = r24;
        if (r24 < 0) goto L108;
        l(0);
        goto L109
    L108:
        l(8);
    L109:
        if (r17 == true) goto L111;
    }

    public final void p() {
        if (this.m == false) goto L6;
    L14:
        o();
        return;
    L6:
        if (((Boolean) this.g.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L14;
        List<ToolbarButton> r0 = this.b;
        ToolbarButton r1 = ToolbarButton.MESSAGE_BOX;
        ((ArrayList) r0).remove(r1);
        if (jc1.k.f(IUserService.class).user().isLogin() == false) goto L14;
        List<ToolbarButton> r2 = this.b;
        ArrayList r3 = (ArrayList) r2;
        int r4 = r3.indexOf(ToolbarButton.RECHARGE_RECORD);
        if (r4 < 0) goto L13;
        ListProtector.add(this.b, r4, r1);
        goto L14
    L13:
        ((ArrayList) this.b).add(r1);
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (this.m == true) goto L5;
        return false;
    L5:
        if (ah.a.getValue().booleanValue() == false) goto L10;
        o();
        return false;
    L10:
        return false;
    }

    public static void b(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r8) {
        if (this.n != null) goto L6;
        return;
    L6:
        if ((r8 instanceof pp1.c) == false) goto L20;
        if (ev1.p.c(this.g) == false) goto L10;
        return;
    L10:
        pp1.c r0 = (pp1.c) r8;
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = this.g;
        r1.getClass();
        RoomContext r3 = RoomContext.a.a(r2, 0);
        if (r3 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0 r4 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0) r3.getToolbarBubbleManager().getValue();
        if (r4 == null) goto L20;
        if (this.l == null) goto L20;
        if (this.n == null) goto L20;
        r4.addBubble(r0, r0.k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.g, this.l, this.n), new x(this));
    L20:
        if ((r8 instanceof pp1.j) == false) goto L31;
        if (tb1.c.a == true) goto L24;
    L29:
        o();
        goto L31
    L24:
        if (((pp1.j) r8).a == false) goto L26;
        char r5 = 0;
    L27:
        if (r5 != 0) goto L29;
        l(0);
        goto L31
    L26:
        r5 = '\b';
    L31:
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c2) == false) goto L35;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c2) r8).getClass();
        return;
    L35:
        if ((r8 instanceof pp1.g) == false) goto L40;
        com.bytedance.android.livesdk.utils.c2 r9 = this.h;
        if ((r9 instanceof com.bytedance.android.livesdk.utils.c2) == false) goto L41;
        r9.A();
        return;
    L41:
        return;
    }

    public final boolean g(Boolean r3) {
        if (tb1.c.c == false) goto L6;
        return false;
    L6:
        if (this.m == false) goto L8;
        return false;
    L8:
        if (this.q != null) goto L10;
        return false;
    L10:
        if (this.F == false) goto L13;
        return false;
    L13:
        if (ea0.a.getValue().booleanValue() == true) goto L16;
        return false;
    L16:
        if ((this.h instanceof com.bytedance.android.livesdk.utils.c2) == false) goto L18;
    L19:
        return true;
    L18:
        if (r3.booleanValue() == true) goto L19;
        return false;
    }

    public void k(KVData r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        if ("cmd_toolbar_click_filter".equals(r18.getKey()) == false) goto L7;
    L155:
        o();
        return;
    L7:
        if ("data_has_interact_more".equals(r18.getKey()) == true) goto L155;
        if ("data_interact_dot_show".equals(r18.getKey()) == true) goto L155;
        if ("data_live_im_entrance_folded_unread".equals(r18.getKey()) == true) goto L155;
        if ("cmd_toolbar_click_update_red_dot".equals(r18.getKey()) == true) goto L155;
        if ("data_user_in_room".equals(r18.getKey()) == false) goto L46;
        IUser r1 = (IUser) r18.getData();
        if (this.m == true) goto L44;
        if (r1 == null) goto L44;
        if (r1.getUserAttr() == null) goto L44;
        if (r1.getUserAttr().isAdmin() == false) goto L25;
        LiveRoomPermission.Companion r2 = LiveRoomPermission.D;
        List r4 = r1.getUserAttr().getAdminPrivileges();
        r2.getClass();
        List r3 = LiveRoomPermission.Companion.b(r4, -1);
    L26:
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r6 = this.g;
        r5.getClass();
        RoomContext r7 = RoomContext.a.a(r6, 0);
        if (r7 != null) goto L29;
        return;
    L29:
        RoomPermissionContext r8 = (RoomPermissionContext) r7.getPermissionContext().getValue();
        RoomPermissionContext.a r9 = RoomPermissionContext.Companion;
        DataCenter r10 = this.g;
        r9.getClass();
        if (RoomPermissionContext.a.b(r10) == false) goto L33;
        r8.getCurrentPermissions().setValue(r3);
        ManageRoomButtonHelper r11 = ManageRoomButtonHelper.b;
        DataCenter r12 = this.g;
        boolean r13 = r1.getUserAttr().isAdmin();
        Set<ToolbarButton> r14 = this.c;
        Room r15 = this.q;
        r11.getClass();
        ManageRoomButtonHelper.e(r12, r13, r14, r3, r15);
        goto L44
    L33:
        if (r1.getUserAttr().isAdmin() == false) goto L35;
        ((HashSet) this.c).add(ToolbarButton.MANAGE);
    L36:
        List r16 = r1.getUserAttr().getAdminPrivileges();
        if (r16 == null) goto L42;
        if (r16.contains(2) == false) goto L42;
        Set<ToolbarButton> r17 = this.c;
        ToolbarButton r19 = ToolbarButton.PROMPT;
        ((HashSet) r17).add(r19);
        this.t = new o4();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).p(r19.extended(), this.t);
    L42:
        if (this.t == null) goto L44;
        Set<ToolbarButton> r20 = this.c;
        ToolbarButton r21 = ToolbarButton.PROMPT;
        ((HashSet) r20).remove(r21);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).f(r21.extended(), this.t);
        this.t = null;
        goto L44
    L35:
        ((HashSet) this.c).remove(ToolbarButton.MANAGE);
        goto L36
    L25:
        r3 = Collections.emptyList();
    L44:
        o();
        return;
    L46:
        if ("cmd_dismiss_dialog_end".equals(r18.getKey()) == false) goto L48;
    L152:
        Dialog r22 = this.h;
        if (r22 == null) goto L171;
        b(r22);
        return;
    L171:
        return;
    L48:
        if ("cmd_dismiss_anchor_more_dialog".equals(r18.getKey()) == true) goto L152;
        boolean r23 = false;
        if ("data_live_mini_app_commerce_status".equals(r18.getKey()) == false) goto L118;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L55;
        return;
    L55:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r24 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r18.getData();
        if (r24 != null) goto L58;
        return;
    L58:
        if (r24.b() == 0) goto L60;
    L63:
        boolean r25 = false;
    L64:
        if (r25 == true) goto L66;
        ((HashSet) this.c).remove(ToolbarButton.COMMERCE_MORE);
    L67:
        boolean r26 = tb1.c.a;
        if (r26 == true) goto L70;
    L86:
        if (r26 == true) goto L88;
    L95:
        int r27 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(this.y) == false) goto L104;
        if (r24.f == true) goto L100;
    L102:
        ((HashSet) this.c).remove(ToolbarButton.GROUP_PURCHASE_MORE);
        goto L104
    L100:
        if (r24.o == true) goto L102;
        ((HashSet) this.c).add(ToolbarButton.GROUP_PURCHASE_MORE);
    L104:
        if (yt2.b.a().booleanValue() == true) goto L106;
        return;
    L106:
        if (r24.i() != 0) goto L108;
        ((HashSet) this.c).remove(ToolbarButton.WELFARE_FOLD);
        return;
    L108:
        LiveMode r28 = this.y;
        if (r28 != LiveMode.VIDEO) goto L111;
    L116:
        ((HashSet) this.c).add(ToolbarButton.WELFARE_FOLD);
        return;
    L111:
        if (r28 == LiveMode.AUDIO) goto L116;
        if (r28 == LiveMode.SCREEN_RECORD) goto L116;
        if (r28 == LiveMode.MEDIA) goto L116;
        return;
    L88:
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(this.y) == false) goto L95;
        if (r24.e == true) goto L92;
    L94:
        ((HashSet) this.c).remove(ToolbarButton.TRANSFORM_WIDGET_MORE);
        goto L95
    L92:
        if (r24.n == true) goto L94;
        ((HashSet) this.c).add(ToolbarButton.TRANSFORM_WIDGET_MORE);
        goto L95
    L70:
        if (r24.c() == 0) goto L72;
    L75:
        if (r23 == true) goto L77;
        ((HashSet) this.c).remove(ToolbarButton.GAME_PROMOTE_MORE);
        goto L86
    L77:
        Logger.d("game-promote", "tryInitGamePromoteMoreBehavior");
        if (this.m == false) goto L85;
        if (r26 == false) goto L85;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r29 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) this.g.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
        boolean r30 = r29.c;
        boolean r31 = r29.l;
        Logger.d("game-promote", "有电商权限=" + r29.b + " , 有商品=" + r29.k);
        Logger.d("game-promote", "有游戏推广权限=" + r30 + " , 有游戏=" + r31);
        if (r30 == true) goto L85;
        Logger.d("game-promote", "无权限，返回");
    L85:
        ((HashSet) this.c).add(ToolbarButton.GAME_PROMOTE_MORE);
        goto L86
    L72:
        if (r24.c == false) goto L75;
        r23 = true;
        goto L75
    L66:
        n();
        ((HashSet) this.c).add(ToolbarButton.COMMERCE_MORE);
        goto L67
    L60:
        if (r24.b == false) goto L63;
        r25 = true;
        goto L64
    L118:
        if ("cmd_anchor_fans_group_tip".equals(r18.getKey()) == false) goto L129;
        AnchorFansGroupPopEvent r32 = (AnchorFansGroupPopEvent) r18.getData();
        if (r32 == null) goto L164;
        x0 r33 = this.A;
        Spannable r34 = r32.getContent();
        String r35 = r32.getSchema();
        Map r36 = r32.getExtra();
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "content");
        Intrinsics.checkNotNullParameter(r35, "scheme");
        Intrinsics.checkNotNullParameter(r36, "extraMap");
        View r110 = r33.k;
        if (r110 == null) goto L173;
        View r111 = LayoutInflater.from(r33.n).inflate(2131566794, null);
        ((TextView) r111.findViewById(2131390392)).setText(r34);
        r111.setOnClickListener(new a1(r33, r35, r36));
        yo2.e r37 = r33.h;
        if (r37 == null) goto L127;
        r37.d();
    L127:
        r33.h = null;
        yo2.e r112 = new yo2.e(r33.n);
        ((yo2.d) r112).d = r111;
        ((yo2.d) r112).e = 0;
        ((yo2.d) r112).m = 5;
        ((yo2.d) r112).n = true;
        ((yo2.d) r112).l = true;
        r112.a();
        r33.h = r112;
        Intrinsics.checkNotNull(r112);
        r112.i(r110, 1, 1, com.bytedance.android.live.core.utils.s1.f(42), com.bytedance.android.live.core.utils.s1.f(-4));
        x0.a("livesdk_fan_group_pop_show", r36);
        return;
    L173:
        return;
    L164:
        return;
    L129:
        if ("cmd_show_aud_backtrack_finished_popup".equals(r18.getKey()) == false) goto L135;
        x0 r38 = this.A;
        View r113 = r38.b();
        if (r113 == null) goto L174;
        View r39 = LayoutInflater.from(r38.n).inflate(2131567604, null);
        yo2.e r40 = new yo2.e(r38.n);
        ((yo2.d) r40).d = r39;
        ((yo2.d) r40).e = 0;
        ((yo2.d) r40).m = 5;
        ((yo2.d) r40).n = true;
        ((yo2.d) r40).l = true;
        r40.a();
        r38.d = r40;
        Intrinsics.checkNotNull(r40);
        r40.i(r113, 1, 1, com.bytedance.android.live.core.utils.s1.f(80), 0);
        return;
    L174:
        return;
    L135:
        if ("data_hide_screen".equals(r18.getKey()) == false) goto L138;
        return;
    L138:
        if ("DATA_AUDIENCE_COMMERCE_MORE_SHOW".equals(r18.getKey()) == false) goto L144;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L142;
        return;
    L142:
        UtilityKotlinExtentionsKt.c(this.c, ToolbarButton.COMMERCE_MORE, ((Boolean) r18.getData(Boolean.FALSE)).booleanValue());
        return;
    L144:
        if ("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW".equals(r18.getKey()) == false) goto L150;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L148;
        return;
    L148:
        UtilityKotlinExtentionsKt.c(this.c, ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE, ((Boolean) r18.getData(Boolean.FALSE)).booleanValue());
        return;
    L150:
        if ("cmd_toolbar_star_graph_visible".equals(r18.getKey()) == false) goto L169;
        boolean r41 = ((Boolean) r18.getData(Boolean.FALSE)).booleanValue();
        ALogger.i("ToolbarMoreBehavior", "CMD_TOOLBAR_STAR_GRAPH_VISIBLE=" + r41);
        UtilityKotlinExtentionsKt.c(this.c, ToolbarButton.STAR_GRAPH, r41);
        return;
    }

    public final void l(int r4) {
        if (this.k != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.core.utils.z.h(this.g) == false) goto L10;
        ALogger.d("toolbar-red-dot", "media hide forever");
        this.k.setVisibility(8);
        return;
    L10:
        if (this.r == false) goto L13;
        ALogger.d("toolbar-red-dot", "mHideRedDot is true");
        this.k.setVisibility(8);
        return;
    L13:
        this.k.setVisibility(r4);
    }

    public final void onChange(ILiveRecordService.RecordStatus r2) {
        if (r2 != ILiveRecordService.RecordStatus.RECORDING) goto L6;
        this.r = true;
        l(8);
        return;
    L6:
        if (this.r == false) goto L10;
        this.r = false;
        o();
        return;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        k((KVData) r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r19) {
        if (fa0.a.getValue().booleanValue() == false) goto L15;
        com.bytedance.android.livesdk.utils.v0 r2 = this.I;
        if (r2 == null) goto L15;
        if (r19 != null) goto L9;
    L10:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        ALogger.d("ToolbarMoreBehavior", "double click return");
        return;
    L9:
        if (r2.a == false) goto L10;
        r2.a = false;
        r19.postDelayed(r2.b, 500);
        r1 = true;
    L15:
        Object r3 = this.k;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new c0()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("AbsToolbarMoreBehavior");
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == true) goto L20;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == true) goto L20;
    L22:
        Iterator r4 = ((ArrayList) i().I(Panel.MORE)).iterator();
    L24:
        if (r4.hasNext() == false) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2 r5 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2) r4.next();
        UtilityKotlinExtentionsKt.c(this.c, r5.b, r5.b());
        goto L24
    L27:
        if (this.m == true) goto L29;
    L33:
        Set<ToolbarButton> r6 = this.c;
        List<ToolbarButton> r7 = this.d;
        Intrinsics.checkNotNullParameter(r6, "originals");
        Intrinsics.checkNotNullParameter(r7, "target");
        ArrayList r8 = (ArrayList) r7;
        r8.clear();
        HashSet r9 = new HashSet(r6);
        Iterator<ToolbarButton> r10 = mp1.a.a.a().iterator();
    L35:
        if (r10.hasNext() == false) goto L39;
        ToolbarButton r11 = r10.next();
        if (r9.remove(r11) == false) goto L35;
        r8.add(r11);
        goto L35
    L39:
        r8.addAll(r9);
        List<ToolbarButton> r12 = this.d;
        String r13 = "";
        if (this.G == null) goto L45;
        if (dd0.a.getValue().booleanValue() == false) goto L45;
    L74:
        AudienceMoreDialogManagerService r14 = this.G;
        if (r14 == null) goto L86;
        String r15 = this.J;
        Context r16 = r14.g;
        if ((r16 instanceof Activity) == true) goto L79;
    L81:
        MorePanelDynamicControllerViewModel.Companion r17 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r18 = r14.f;
        r17.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d r110 = MorePanelDynamicControllerViewModel.Companion.a(r18);
        if (r110 == null) goto L84;
        r110.checkDataBeforeShowDialog(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.c(r14, r15));
    L85:
        this.J = null;
    L117:
        h(false, 0);
        Room r20 = this.q;
        Boolean r111 = Boolean.FALSE;
        if (g(r111) == false) goto L124;
        boolean r112 = this.m;
        int r113 = com.bytedance.android.livesdk.config.setting.t.a;
        if ((!r112) == true) goto L124;
        long r114 = r20.getId();
        this.F = true;
        com.bytedance.android.livesdk.service.l.d().getClass();
        this.o.add(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).fetchTempStateAreaData(r114).compose(RxUtil.rxSchedulerHelper()).map(new u(this)).subscribe(new v(this), new w(this)));
    L124:
        x0 r21 = this.A;
        View r115 = this.k;
        View r116 = this.j;
        Set<ToolbarButton> r117 = this.c;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r117, "buttons");
        if (r115 == null) goto L214;
        RoomContext.a r118 = RoomContext.Companion;
        RoomContext r119 = RoomContext.a.c(r118, null, 0, 3);
        if (r119 == null) goto L215;
        boolean r120 = ((Boolean) r119.isAnchor().getValue()).booleanValue();
        Room r121 = (Room) r119.getRoom().getValue();
        DataCenter r22 = r21.l;
        HashMap r23 = new HashMap();
        String r24 = "1";
        if (r120 == true) goto L133;
        if (r22 != null) goto L157;
    L178:
        if (r120 == true) goto L180;
    L182:
        uj r25 = uj.a;
        if (r25.getValue() != null) goto L185;
    L187:
        r21.j = true;
        return;
    L185:
        if (r25.getValue().showChallenge == false) goto L187;
        HashMap r26 = new HashMap();
        r26.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r26.put("entrance_type", "tool_panel");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_challenge_show", r26, new Object[0]);
        goto L187
    L180:
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L182;
        HashMap r27 = new HashMap();
        r27.put("_param_live_platform", "live");
        r27.put("room_id", String.valueOf(r121.id));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_mission_entrance_show", r27, new Object[0]);
        goto L182
    L157:
        if (((Boolean) r22.get("data_more_dialog_is_show_interact_more", r111)).booleanValue() == false) goto L159;
        Object r28 = "1";
    L160:
        r23.put("is_connection_button", r28);
        if (r116 != null) goto L163;
    L165:
        boolean r29 = false;
    L166:
        if (r29 == false) goto L168;
        Object r30 = "1";
    L169:
        r23.put("is_game_button", r30);
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r22).isPaidLive() == false) goto L172;
        Object r31 = "1";
    L173:
        r23.put("is_paidlive", r31);
        r23.put("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r22).J0().q(r22));
        if (r115.getVisibility() != 0) goto L176;
        Object r32 = "1";
    L177:
        r23.put("if_with_notification", r32);
        r23.put("room_live_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        r23.put("more_function_location", r22.get("key_report_more_btn_click_location", "1"));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_more_function_button", r23, new Object[]{new am2.x(), Room.class});
        goto L178
    L176:
        r32 = "0";
        goto L177
    L172:
        r31 = "0";
        goto L173
    L168:
        r30 = "0";
        goto L169
    L163:
        if (r116.getVisibility() != 0) goto L165;
        r29 = true;
        goto L166
    L159:
        r28 = "0";
        goto L160
    L133:
        if (r115.getVisibility() != 0) goto L135;
        String r33 = "red_dot";
    L136:
        r23.put("notice_type", r33);
        RoomContext r34 = RoomContext.a.c(r118, null, 0, 3);
        if (r34 == null) goto L151;
        if (r34.isBroadcastMedia() == false) goto L151;
        if (((Number) r34.getMediaReviewStatus().getValue()).intValue() >= 5) goto L146;
        r24 = "0";
    L146:
        r23.put("live_status", r24);
        if (((LiveMode) r34.getLiveMode().getValue()) != LiveMode.MEDIA) goto L149;
        r13 = "media";
    L149:
        r23.put("live_type", r13);
    L151:
        if (r115.getVisibility() != 0) goto L153;
        String r35 = "yes";
    L154:
        r23.put("spot_click", r35);
        com.bytedance.android.livesdk.log.g r36 = com.bytedance.android.livesdk.log.u.l();
        am2.x r37 = new am2.x();
        r37.b = "live_take_detail";
        r37.a = "live_take";
        r36.sendLog("anchor_more_function_click", r23, new Object[]{r37, new am2.z(), Room.class});
        goto L178
    L153:
        r35 = "no";
        goto L154
    L135:
        r33 = "";
        goto L136
    L215:
        return;
    L214:
        return;
    L84:
        r14.i(r15);
        goto L85
    L79:
        if (((Activity) r16).isFinishing() == false) goto L81;
    L86:
        boolean r38 = this.m;
        if (r38 == true) goto L105;
        int r39 = com.bytedance.android.livesdk.config.setting.t.a;
        boolean r40 = !r38;
        if (r40 == true) goto L91;
    L93:
        if (r40 == false) goto L96;
        int r41 = 2;
    L99:
        LiveTracingMonitor.EventModule r42 = LiveTracingMonitor.EventModule.common;
        JSONObject r122 = new JSONObject();
        r122.put("status_code", r41);     // Catch: JSONException -> L189
    L194:
        r122.put("category_1", "live");     // Catch: JSONException -> L190
    L103:
        LiveMonitor r43 = new LiveMonitor();
        r43.mCategory = r122;
        r43.mEventModule = r42;
        r43.mServiceName = "click_show_more_panel_when_is_null";
        r43.mExtraLog = null;
        r43.mMetrics = null;
        LiveMonitor.access$002(r43, false);
        LiveMonitor.access$102(r43, false);
        LiveMonitor.access$202(r43, true);
        LiveMonitor.access$302(r43, false);
        LiveMonitor.access$402(r43, false);
        r43.report();
        goto L105
    L96:
        if (this.H == false) goto L98;
        r41 = 3;
        goto L99
    L98:
        r41 = 0;
        goto L99
    L91:
        if (this.H == false) goto L93;
        r41 = 1;
    L105:
        if (((HashSet) this.c).isEmpty() == true) goto L117;
        Dialog r44 = this.h;
        if (r44 != null) goto L109;
    L113:
        x0 r45 = this.A;
        yo2.e r46 = r45.e;
        if (r46 == null) goto L116;
        r46.d();
    L116:
        r45.e = null;
        goto L117
    L109:
        if (DialogLancet.shouldBlockDialogShow(r44) == false) goto L196;
        DialogLancet.handleBlockedDialogShow(r44);
        goto L113
    L196:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L191
    L112:
        DialogLancet.beforeDialogShow(r44);
        r44.show();
        DialogLancet.afterDialogShow(r44);
    L45:
        if (cd0.a.getValue().booleanValue() == false) goto L74;
        if (RoomContext.getShared(this.g) == null) goto L74;
        if (RoomContext.getShared(this.g).getNewRoomAuthViewModel() == null) goto L74;
        if (RoomContext.getShared(this.g).getNewRoomAuthViewModel().getValue() == null) goto L74;
        DataCenter r47 = this.g;
        int r48 = lk1.b.a;
        lk1.c.i2.getClass();
        lk1.c r49 = lk1.c.a.a(r47);
        Iterator r50 = ((ArrayList) r12).iterator();
    L56:
        if (r50.hasNext() == false) goto L74;
        ToolbarButton r51 = (ToolbarButton) r50.next();
        String r52 = (String) ((Map) ToolbarButtonAuthKeyMapping.a.getValue()).get(r51);
        if (TextUtils.isEmpty(r52) == false) goto L60;
        r52 = "";
    L60:
        mk1.a r53 = r49.getComponentStatusByConfig(r52, mk1.c.c);
        if (r53 == null) goto L56;
        if (r53.b() == true) goto L64;
        if (r53.a != 3) goto L68;
        boolean r54 = true;
    L69:
        if (r54 == false) goto L56;
        String r55 = r53.b;
        if (r55 != null) goto L73;
        r55 = "";
    L73:
        i().a(r51, r55);
        goto L56
    L68:
        r54 = false;
        goto L69
    L64:
        r50.remove();
        goto L56
    L29:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L33;
        BottomToolbarViewModel.a r56 = BottomToolbarViewModel.Companion;
        DataCenter r57 = this.g;
        r56.getClass();
        BottomToolbarViewModel r58 = BottomToolbarViewModel.a.a(r57);
        if (r58 == null) goto L33;
        List<ToolbarButton> r59 = r58.getFoldButtons(Boolean.valueOf(this.m));
        ((HashSet) this.c).remove(ToolbarButton.COMMERCE_MORE);
        ((HashSet) this.c).remove(ToolbarButton.GAME_PROMOTE_MORE);
        ((HashSet) this.c).remove(ToolbarButton.TRANSFORM_WIDGET_MORE);
        ((HashSet) this.c).remove(ToolbarButton.WELFARE_FOLD);
        ((HashSet) this.c).remove(ToolbarButton.GROUP_PURCHASE_MORE);
        ((HashSet) this.c).remove(ToolbarButton.TICKET_SALE_ANCHOR_MORE);
        this.c.addAll(r59);
    L20:
        if ((r3 instanceof RedDotView) == false) goto L22;
        ((RedDotView) r3).l();
        o();
        goto L22
    }

    public void onMessage(tlc.d r24) {
        boolean r3 = true;
        if ((r24 instanceof com.bytedance.android.livesdk.message.model.k) == false) goto L71;
        com.bytedance.android.livesdk.message.model.k.a r1 = ((com.bytedance.android.livesdk.message.model.k) r24).E();
        if (c11.a.getValue().booleanValue() == false) goto L7;
        ManageRoomButtonHelper r2 = ManageRoomButtonHelper.b;
        DataCenter r4 = this.g;
        r2.getClass();
        ManageRoomButtonHelper.c(r4, r1);
        return;
    L7:
        ManageRoomButtonHelper r5 = ManageRoomButtonHelper.b;
        DataCenter r6 = this.g;
        int r7 = r1.c();
        int r8 = r1.b();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        RoomPermissionContext.Companion.getClass();
        RoomPermissionContext r9 = RoomPermissionContext.a.f(r6);
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r10 = LiveRoomPermission.Companion.a(r7);
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r11 == null) goto L12;
        com.bytedance.live.datacontext.m r12 = r11.getUser();
        if (r12 == null) goto L12;
        User r13 = (User) r12.getValue();
    L14:
        if (r9 == null) goto L69;
        if (r10 == null) goto L69;
        if (r13 == null) goto L69;
        List r14 = CollectionsKt.toMutableList((Collection) r9.getCurrentPermissions().getValue());
        if (r13.getUserAttr() != null) goto L21;
        r13.setUserAttr(new UserAttr());
    L21:
        py.t r15 = r13.getUserAttr();
        if (r15 == null) goto L27;
        List r16 = r15.getAdminPrivileges();
        if (r16 == null) goto L27;
        List r17 = CollectionsKt.toMutableList(r16);
        if (r17 == null) goto L27;
    L28:
        if (r8 != 1) goto L32;
        r14.add(r10);
        if (r17.contains(Integer.valueOf(r7)) == true) goto L34;
        r17.add(Integer.valueOf(r7));
    L34:
        r9.getCurrentPermissions().setValue(r14);
        py.t r18 = r13.getUserAttr();
        if (r18 == null) goto L37;
        r18.setAdminPrivileges(r17);
    L37:
        if (r8 != 1) goto L62;
        List r19 = CollectionsKt.listOf(r10);
        if ((r19 instanceof Collection) == true) goto L41;
    L43:
        Iterator r20 = r19.iterator();
    L45:
        if (r20.hasNext() == false) goto L57;
        LiveRoomPermission r21 = (LiveRoomPermission) r20.next();
        LiveRoomPermission.D.getClass();
        if (Intrinsics.areEqual(r21, LiveRoomPermission.m) == false) goto L49;
    L54:
        boolean r22 = true;
    L55:
        if (r22 == false) goto L45;
    L58:
        if (r3 == false) goto L62;
        com.bytedance.android.livesdk.sharedpref.e r23 = new com.bytedance.android.livesdk.sharedpref.e("refine_permission_bubble_for_admin", Boolean.FALSE);
        if (((Boolean) r23.getValue()).booleanValue() == true) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r25 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r6);
        ToolbarButton r26 = ToolbarButton.MORE;
        int r27 = pp1.c.o;
        r25.b(r26, pp1.c.a.a("新获得的特权功能可在这里查看"));
        com.bytedance.android.livesdk.sharedpref.f.d(r23, Boolean.TRUE);
        goto L62
    L49:
        if (Intrinsics.areEqual(r21, LiveRoomPermission.n) == true) goto L54;
        if (Intrinsics.areEqual(r21, LiveRoomPermission.o) == true) goto L54;
        r22 = false;
    L57:
        r3 = false;
        goto L58
    L41:
        if (r19.isEmpty() == false) goto L43;
    L62:
        LiveRoomPermission.D.getClass();
        if (Intrinsics.areEqual(r10, LiveRoomPermission.j) == false) goto L66;
        ManageRoomButtonHelper.b();
        return;
    L66:
        if (Intrinsics.areEqual(r10, LiveRoomPermission.z) == false) goto L68;
        ManageRoomButtonHelper.b();
        return;
    L68:
        jc1.k.n(IUserService.class).user().f(r13.getUserAttr());
        r6.put("data_user_in_room", r13);
        RoomContext r28 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        Intrinsics.checkNotNull(r28);
        r28.getUser().setValue(r13);
        ALogger.i("LiveRoomPermission", "update to " + CollectionsKt.joinToString$default(r14, null, null, null, 0, null, null, 63, null));
        return;
    L32:
        if (r8 != 2) goto L34;
        r14.remove(r10);
        r17.remove(Integer.valueOf(r7));
        ManageRoomButtonHelper.d(r7, r17, r14);
        ManageRoomButtonHelper.a();
    L27:
        r17 = new ArrayList();
    L69:
        ALogger.w("LiveRoomPermission", "null, ctx: " + r9 + ", permission: " + r7 + ", user: " + r13);
        return;
    L12:
        r13 = null;
        goto L14
    L71:
        if ((r24 instanceof CornerReachMessage) == false) goto L78;
        if (r24.getIntType() != MessageType.CORNER_REACH_MESSAGE.getIntType()) goto L78;
        CornerReachMessage r29 = (CornerReachMessage) r24;
        if (r29.getElemType() == TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L78;
        h(true, r29.getDuration());
        return;
    L78:
        if ((r24 instanceof TempStateAreaReachMessage) == false) goto L97;
        if (r24.getIntType() != MessageType.TEMP_STATE_AREA_MESSAGE.getIntType()) goto L97;
        TempStateAreaReachMessage r30 = (TempStateAreaReachMessage) r24;
        if (r30.H() != null) goto L85;
        return;
    L85:
        if (g(Boolean.FALSE) == true) goto L88;
        return;
    L88:
        if (r30.getStatus() != TempStateAreaReachMessage.Status.ADD.getValue()) goto L91;
        ExtendedToolbarButton.c r31 = m(r30.H().b(), r30.H().c(), r30.H().a(), String.valueOf(r30.getItemId()), r30.G(), r30.E());
        DataCenter r32 = this.g;
        long r33 = r30.G();
        Context r34 = this.l;
        boolean r35 = this.D;
        long r36 = r30.getItemId();
        long r110 = r30.E();
        String r111 = r30.H().c();
        r30.H().getClass();
        j().a(r31, new com.bytedance.android.livesdk.room.placeholder.behavior.p(r32, r33, r34, r35, r36, r110, r111));
        this.h.K(r31);
        return;
    L91:
        if (r30.getStatus() != TempStateAreaReachMessage.Status.DELETE.getValue()) goto L94;
        this.h.f0(String.valueOf(r30.getItemId()));
        j().c(r30.getItemId());
        return;
    L94:
        if (r30.getStatus() != TempStateAreaReachMessage.Status.UPDATE.getValue()) goto L127;
        this.h.N(r30.getItemId(), r30.H().b(), r30.H().c(), r30.H().a());
        return;
    L127:
        return;
    L97:
        if ((r24 instanceof com.bytedance.android.livesdk.message.model.m) == false) goto L129;
        com.bytedance.android.livesdk.message.model.m r37 = (com.bytedance.android.livesdk.message.model.m) r24;
        if (r37.E() != null) goto L101;
        return;
    L101:
        ItemBubbleInfo r38 = r37.E();
        if (r38 != null) goto L104;
        return;
    L104:
        if (r38.getShowItemId().equals(String.valueOf(24)) == false) goto L131;
        x0 r39 = this.A;
        View r40 = r39.b();
        if (r40 == null) goto L136;
        IBroadcastService r41 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r41 == null) goto L132;
        nz.h r42 = r41.getBroadcastBubbleManager();
        if (r42 == null) goto L133;
        r42.a(r39.n, r40, r38, BubblePosition.Top);
        return;
    L133:
        return;
    L132:
        return;
    L136:
        return;
    L131:
        return;
    }

    public AbsToolbarMoreBehavior(Context r3, DataCenter r4) {
        this.b = new ArrayList();
        this.c = new HashSet();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.i = -1;
        this.r = false;
        this.D = false;
        this.F = false;
        this.H = false;
        this.J = null;
        this.l = r3;
        this.g = r4;
        if (r4 == null) goto L5;
        this.D = ((Boolean) r4.get("data_is_portrait", Boolean.FALSE)).booleanValue();
    L5:
        this.A = new x0(r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void R9(View r7, DataCenter r8) {
        IAbilityCenter r9 = (IAbilityCenter) r8.get("data_session_ablity_center", null);
        if (r9 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.service.l.d().e().removeRecordStatsChangeListener(this);
    L8:
        x0 r10 = this.A;
        yo2.e r1 = r10.c;
        if (r1 == null) goto L11;
        r1.d();
    L11:
        r10.c = null;
        yo2.e r2 = r10.b;
        if (r2 == null) goto L14;
        r2.d();
    L14:
        r10.b = null;
        r10.i = true;
        r10.j = false;
        r10.k = null;
        r10.l = null;
        r10.m.clear();
        r10.m = new CompositeDisposable();
        AudienceMoreDialogManagerService r11 = this.G;
        if (r11 == null) goto L24;
        CommonStandardBottomDialog r3 = r11.c;     // Catch: Exception -> L20
        if (r3 == null) goto L22;
        AudienceMoreDialogManagerService.a(r3);     // Catch: Exception -> L20
    L22:
        r11.d.dispose();
        r11.e().b();
        this.G = null;
    L20:
        e = move-exception;
        ALogger.i(r11.f(), "dimiss error: " + e.toString());
    L24:
        if (this.h == null) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.g.a;
        long r4 = ((Long) r12.getValue()).longValue();
        b(this.h);
        com.bytedance.android.livesdk.sharedpref.f.d(r12, Long.valueOf(r4));
    L26:
        r8.removeObserver(this);
        CompositeDisposable r13 = this.o;
        if (r13 == null) goto L29;
        r13.clear();
    L29:
        vlc.d r14 = this.p;
        if (r14 == null) goto L33;
        r14.removeMessageListener(this);
    L33:
        if (this.m == false) goto L41;
        LiveMode r15 = this.y;
        if (r15 != LiveMode.VIDEO) goto L37;
    L40:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).d(ToolbarButton.COMMERCE, this.s);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).d(ToolbarButton.GAME_PROMOTE, null);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).d(ToolbarButton.TRANSFORM_WIDGET_MORE, this.u);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).d(ToolbarButton.GROUP_PURCHASE_MORE, this.v);
        goto L41
    L37:
        if (r15 == LiveMode.AUDIO) goto L40;
        if (r15 == LiveMode.SCREEN_RECORD) goto L40;
    L41:
        j().b();
        com.bytedance.android.livesdk.utils.c2 r16 = this.h;
        if ((r16 instanceof com.bytedance.android.livesdk.utils.c2) == false) goto L44;
        r16.onUnload();
    L44:
        this.J = null;
        this.H = true;
        return;
    L5:
        if (r9.getAbility(ISessionRecordService.class) == null) goto L7;
        r9.getAbility(ISessionRecordService.class).removeRecordStatsChangeListener(this);
        goto L8
    }

    public final void h(boolean r6, long r7) {
        if (this.j != null) goto L5;
        return;
    L5:
        if (this.m == false) goto L7;
        return;
    L7:
        if (ea0.a.getValue().booleanValue() == true) goto L10;
        return;
    L10:
        if (g(Boolean.TRUE) == true) goto L13;
        return;
    L13:
        if (this.o != null) goto L15;
        this.o = new CompositeDisposable();
    L15:
        if (r6 == false) goto L28;
        com.bytedance.android.livesdk.utils.c r8 = this.C;
        if (r8 == null) goto L28;
        if (r8.a() == false) goto L21;
        return;
    L21:
        Disposable r9 = this.B;
        if (r9 != null) goto L24;
    L26:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_more_function_game_show", new HashMap(), new Object[]{new am2.x(), Room.class});
    L27:
        ((ArrayList) this.C.a).add(Long.valueOf(System.currentTimeMillis()));
        this.j.post(new y(this));
        Disposable r10 = Single.just(0).delay(r7, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new z(this), new a0());
        this.B = r10;
        this.o.add(r10);
        return;
    L24:
        if (r9.isDisposed() == true) goto L26;
        this.o.remove(this.B);
    L28:
        this.j.post(new b0(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void p4(View r14, final DataCenter r15) {
        super.p4(r14, r15);
        this.H = false;
        this.g = r15;
        this.y = (LiveMode) r15.get("data_live_mode", LiveMode.VIDEO);
        this.n = r14;
        ToolbarLoadTimeStatsVM.openAction(new b(this, r15));
        this.I = new com.bytedance.android.livesdk.utils.v0();
        this.k = r14.findViewById(2131392581);
        Boolean r1 = Boolean.FALSE;
        boolean r2 = ((Boolean) r15.get("data_is_anchor", r1)).booleanValue();
        this.m = r2;
        int r3 = com.bytedance.android.livesdk.config.setting.t.a;
        if ((!r2) == false) goto L5;
        AudienceMoreDialogManagerService r4 = new AudienceMoreDialogManagerService(r15, this.l);
        this.G = r4;
        r4.h();
    L12:
        View r5 = this.k;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.a(this.m) == true) goto L17;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == true) goto L17;
    L23:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == false) goto L25;
        this.i = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
    L25:
        this.j = r14.findViewById(2131392504);
        vu r6 = vu.a;
        this.C = new com.bytedance.android.livesdk.utils.c(r6.getValue().b(), r6.getValue().a());
        this.E = new com.bytedance.android.livesdk.room.placeholder.behavior.o();
        x0 r7 = this.A;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r14, "itemView");
        Intrinsics.checkNotNullParameter(r15, "dataCenter");
        r7.k = r14;
        r7.l = r15;
        this.g = r15;
        Dialog r16 = this.h;
        if (r16 == null) goto L28;
        ((com.bytedance.android.livesdk.utils.y1) r16).setDataCenter(r15);
    L28:
        this.o = new CompositeDisposable();
        Room r8 = (Room) r15.get("data_room");
        this.q = (Room) r15.get("data_room", null);
        r15.observe("cmd_toolbar_click_filter", this);
        r15.observe("cmd_dismiss_anchor_more_dialog", this);
        r15.observe("cmd_show_aud_backtrack_finished_popup", this);
        r15.observe("data_hide_screen", this);
        r15.observe("cmd_toolbar_star_graph_visible", this);
        r15.observe("cmd_toolbar_click_update_red_dot", this);
        this.o.add(xs2.b.a().b(ToolbarClearScreenEvent.class).subscribe(new o(this)));
        if (this.o != null) goto L31;
        this.o = new CompositeDisposable();
    L31:
        CompositeDisposable r17 = this.o;
        if (r17 == null) goto L35;
        r17.add(xs2.b.a().b(zg1.b2.class).subscribe(new r(this)));
    L35:
        if (this.o != null) goto L37;
        this.o = new CompositeDisposable();
    L37:
        CompositeDisposable r18 = this.o;
        if (r18 == null) goto L40;
        r18.add(RxBusAbility.INSTANCE.getRxBus(this.g).b(pt2.a.class).subscribe(new s(this)));
    L40:
        List<ToolbarButton> r19 = new ArrayList();
        if (this.m == false) goto L43;
        com.bytedance.android.livesdk.service.l.d().getClass();
        r19 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v) com.bytedance.android.livesdk.service.k.b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v.class)).a(r15);
    L44:
        this.c.addAll(r19);
        if (((HashSet) this.c).contains(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == false) goto L48;
        r15.put("data_dou_plus_share_entry_enable", r1);
    L48:
        if (this.m == true) goto L55;
        com.bytedance.android.livesdk.service.l.d().f().f();
        com.bytedance.android.livesdk.service.l.d().f().c(this.f, this.D);
        vlc.d r110 = (vlc.d) this.g.get("data_message_manager", null);
        this.p = r110;
        if (r110 == null) goto L54;
        r110.addMessageListener(MessageType.CORNER_REACH_MESSAGE.getIntType(), this);
        this.p.addMessageListener(MessageType.TEMP_STATE_AREA_MESSAGE.getIntType(), this);
        if (UserSetting.a() == false) goto L54;
        this.p.addMessageListener(MessageType.ADMIN_PRIVILEGE_CHANGE.getIntType(), this);
    L54:
        this.g.observe("data_is_portrait", this);
    L59:
        if (tb1.c.a == false) goto L61;
    L63:
        this.o.add(xs2.b.a().b(zg1.g3.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(this), RxUtil.getNoOpThrowable()));
        this.o.add(xs2.b.a().b(com.bytedance.android.livesdk.commerce.i.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this), RxUtil.getNoOpThrowable()));
    L64:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4 r111 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4.c.a;
        ArrayList r9 = new ArrayList(((HashSet) this.c).size());
        Iterator r10 = ((HashSet) this.c).iterator();
    L66:
        if (r10.hasNext() == false) goto L68;
        r9.add(((ToolbarButton) r10.next()).name());
        goto L66
    L68:
        r111.f(r9);
        p();
        this.o.add(((com.bytedance.android.live.core.utils.rxutils.autodispose.v) ((IUserService) jc1.k.f(IUserService.class)).user().m().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new e(this)));
        boolean r112 = this.m;
        String r11 = "1";
        if (r112 == true) goto L71;
    L133:
        if (r112 == false) goto L135;
    L159:
        this.r = false;
        IAbilityCenter r113 = (IAbilityCenter) r15.get("data_session_ablity_center", null);
        if (r113 != null) goto L162;
    L164:
        com.bytedance.android.livesdk.service.l.d().e().addRecordStatsChangeListener(this);
    L166:
        if (this.m == true) goto L168;
    L207:
        r15.observe("data_live_mini_app_commerce_status", this, true);
        r15.observe("data_has_interact_more", this);
        r15.observe("data_interact_dot_show", this);
        if (UserSetting.b() == false) goto L212;
        com.bytedance.android.live.user.api.a r114 = com.bytedance.android.live.user.api.b.a(r15);
        if (r114 == null) goto L213;
        this.o.add(r114.getCurrentPermissions().subscribe(new d(this)));
    L213:
        r15.observe("cmd_anchor_backtrack_tip", this);
        r15.observe("cmd_anchor_fans_group_tip", this);
        if (this.m == true) goto L228;
        if (ux.a.getValue().booleanValue() == false) goto L228;
        this.g.observe("DATA_AUDIENCE_COMMERCE_MORE_SHOW", this);
        this.g.observe("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", this);
        DataCenter r115 = this.g;
        Boolean r12 = Boolean.FALSE;
        if (((Boolean) r115.get("DATA_AUDIENCE_COMMERCE_MORE_SHOW", r12)).booleanValue() == false) goto L222;
        ((HashSet) this.c).add(ToolbarButton.COMMERCE_MORE);
    L222:
        if (this.s != null) goto L224;
        this.s = new ToolbarCommerceAudienceInMoreBehavior(this.l);
    L224:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).k(ToolbarButton.COMMERCE_MORE, this.s);
        if (((Boolean) this.g.get("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", r12)).booleanValue() == false) goto L228;
        ((HashSet) this.c).add(ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE);
    L228:
        if (this.m == true) goto L236;
        if (r8 == null) goto L236;
        if (this.D == false) goto L236;
        if (r8.isNeedCornerMarkReach() == false) goto L236;
        h(true, r8.getCornerMarkShowDuration());
        r8.setCornerMarkReach(false);
    L236:
        HashMap r116 = new HashMap();
        if (this.m == false) goto L239;
        String r117 = SourceType.ANCHOR;
    L240:
        r116.put("user_type", r117);
        if (ev1.p.e(this.g) == false) goto L244;
        r11 = "3";
    L246:
        r116.put("more_function_location", r11);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_show_more_function_button", r116, new Object[]{Room.class, am2.x.class});
        return;
    L244:
        if (ev1.p.f(this.g) == false) goto L246;
        r11 = "4";
        goto L246
    L239:
        r117 = "user";
        goto L240
    L212:
        r15.observe("data_user_in_room", this);
        goto L213
    L168:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L171;
        n();
    L171:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L185;
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(this.y) == true) goto L175;
    L178:
        int r118 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(this.y) == false) goto L185;
        if (this.v != null) goto L183;
        this.v = new ToolbarGroupPurchaseWidgetBehavior(true);
    L183:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).k(ToolbarButton.GROUP_PURCHASE_MORE, this.v);
        goto L185
    L175:
        if (this.u != null) goto L177;
        this.u = new ToolbarTransformWidgetBehavior(this.l, true, r15);
    L177:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).k(ToolbarButton.TRANSFORM_WIDGET_MORE, this.u);
    L185:
        if (yt2.b.a().booleanValue() == false) goto L195;
        if (this.m == false) goto L195;
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L195;
        if (this.x != null) goto L193;
        this.x = new ToolbarAnchorWelfareBehavior(true);
    L193:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).k(ToolbarButton.WELFARE_FOLD, this.x);
    L195:
        if (this.y == LiveMode.VIDEO) goto L197;
    L202:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a(this)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        Room r119 = this.q;
        if (r119 == null) goto L207;
        if (r119.isMediaRoom() == false) goto L207;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).p(ToolbarButton.ROOM_NOTICE.extended(), new t4(this.q));
        goto L207
    L197:
        if (db.a.getValue().getLive_anchor_clarity_open() == false) goto L202;
        if (this.w != null) goto L201;
        this.w = new h2();
    L201:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).p(ToolbarButton.IN_ROOM_RESOLUTION.extended(), this.w);
        goto L202
    L162:
        if (r113.getAbility(ISessionRecordService.class) == null) goto L164;
        ((ISessionRecordService) r113.getAbility(ISessionRecordService.class)).addRecordStatsChangeListener(this);
        goto L166
    L135:
        if (com.bytedance.android.livesdk.chatroom.record.u.f(false, r8) == false) goto L140;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.l.getValue()).booleanValue() == false) goto L159;
        this.o.add(((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new c(this)));
        goto L159
    L140:
        if (com.bytedance.android.livesdk.floatview.p.c() == false) goto L159;
        String r120 = com.bytedance.android.livesdk.chatroom.utils.c4.a;
        boolean r121 = tb1.c.a;
        if (r121 == true) goto L145;
    L151:
        boolean r13 = false;
    L152:
        if (r13 == true) goto L159;
        List r20 = com.bytedance.android.livesdk.slideuptip.k.a;
        if (r121 == false) goto L159;
        if (com.bytedance.android.livesdk.slideuptip.k.d() == false) goto L159;
        SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext()).f(com.bytedance.android.livesdk.slideuptip.k.c, true);
        goto L159
    L145:
        if (com.bytedance.android.livesdk.chatroom.utils.c4.a() == false) goto L151;
        if ((!SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext()).f(com.bytedance.android.livesdk.chatroom.utils.c4.a, true)) == true) goto L149;
    L150:
        r13 = true;
        goto L152
    L149:
        if (com.bytedance.android.livesdk.chatroom.utils.c4.b != 2) goto L151;
    L71:
        if ((this.l instanceof FragmentActivity) == false) goto L133;
        Boolean r122 = Boolean.FALSE;
        if (((Boolean) r15.get("data_room_audio_comment_anchor_show", r122)).booleanValue() == false) goto L80;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.h0.getValue()).booleanValue() == true) goto L80;
        if (com.bytedance.android.livesdk.interactivity.service.model.b.a(this.q.getRoomAuthStatus()) == true) goto L80;
        this.o.add(((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new f(this)));
    L116:
        this.o.add(((SingleSubscribeProxy) Single.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new j(this)));
        if (((Boolean) com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a.getValue()).booleanValue() == false) goto L120;
        this.o.add(xs2.b.a().b(l22.g.class).subscribe(new k(this)));
    L120:
        if (tb1.c.a == false) goto L159;
        String r123 = ((IUserService) jc1.k.f(IUserService.class)).user().b().getCastSecUid();
        if (((Long) com.bytedance.android.livesdk.utils.c1.h(r123).getValue()).longValue() < 1) goto L132;
        CompositeDisposable r21 = this.o;
        JSONObject r22 = ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).getClientDouPlusPopupSettings();
        int r124 = 5;
        if (r22 != null) goto L126;
        int r23 = 5;
    L127:
        long r125 = r23;
        TimeUnit r24 = TimeUnit.MINUTES;
        r21.add(((SingleSubscribeProxy) Single.timer(r125, r24).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new m(this)));
        CompositeDisposable r25 = this.o;
        JSONObject r126 = ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).getClientDouPlusPopupSettings();
        if (r126 == null) goto L131;
        r124 = r126.optInt("douplus_live_bubble_delay_mins", 5);
    L131:
        r25.add(((SingleSubscribeProxy) Single.timer(r124, r24).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new n(this)));
        goto L132
    L126:
        r23 = r22.optInt("douplus_live_bubble_coupon_delay_mins", 5);
    L132:
        com.bytedance.android.livesdk.sharedpref.f.d(com.bytedance.android.livesdk.utils.c1.h(r123), Long.valueOf(((Long) com.bytedance.android.livesdk.utils.c1.h(r123).getValue()).longValue() + 1));
    L80:
        if (vg.a.getValue().booleanValue() == false) goto L89;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.f2.getValue()).booleanValue() == true) goto L89;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.k2.getValue()).booleanValue() == true) goto L89;
        if (this.q.getStreamType() != LiveMode.AUDIO) goto L89;
        this.o.add(((SingleSubscribeProxy) Single.timer(180, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new g(this)));
    L89:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.g2.getValue()).booleanValue() == false) goto L91;
    L93:
        int r26 = com.bytedance.android.livesdk.utils.m3.a;
        if (com.bytedance.android.livesdk.utils.m3.a(this.y) == true) goto L96;
    L102:
        boolean r27 = false;
    L103:
        if (r27 == false) goto L105;
    L115:
        this.o.add(((SingleSubscribeProxy) Single.timer(120, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new i(this)));
        goto L116
    L105:
        if (com.bytedance.android.livesdk.utils.m3.b(this.y) == true) goto L107;
    L113:
        boolean r127 = false;
    L114:
        if (r127 == false) goto L116;
    L107:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.h2.getValue(), r122) == false) goto L113;
        if (xh.a.getValue().booleanValue() == false) goto L111;
    L112:
        r127 = true;
        goto L114
    L111:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.j2.getValue()).booleanValue() == false) goto L113;
    L96:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.h2.getValue(), r122) == false) goto L102;
        if (xh.a.getValue().booleanValue() == false) goto L100;
    L101:
        r27 = true;
        goto L103
    L100:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.j2.getValue()).booleanValue() == false) goto L102;
    L91:
        if ("1".equals(this.q.getAnchorAbValue("admin_pin_ab_group")) == false) goto L93;
        this.o.add(((SingleSubscribeProxy) Single.timer(90, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind((FragmentActivity) this.l))).subscribe(new h(this)));
        goto L116
    L61:
        if (this.m == false) goto L63;
    L55:
        vlc.d r128 = (vlc.d) this.g.get("data_message_manager", null);
        this.p = r128;
        if (r128 == null) goto L59;
        r128.addMessageListener(MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType(), this);
        goto L59
    L43:
        com.bytedance.android.livesdk.service.l.d().f().e(r15, r19);
    L17:
        if ((r5 instanceof RedDotView) == false) goto L23;
        if (this.m == false) goto L21;
        ((RedDotView) r5).m(new com.bytedance.android.livesdk.reddot.a("anchor_more", -1, 3, 0, -1), null, null, null);
        goto L23
    L21:
        ((RedDotView) r5).m(up2.a.d, null, null, null);
        goto L23
    L5:
        if (r2 == true) goto L7;
    L9:
        boolean r28 = false;
    L10:
        if (r28 == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.b r29 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.b(r15, this.l);
        this.G = r29;
        r29.h();
        goto L12
    L7:
        if (((Boolean) gc.a.getValue()).booleanValue() == false) goto L9;
        r28 = true;
        goto L10
    }

    public static ExtendedToolbarButton.c m(String r2, String r3, String r4, String r5, long r6, long r8) {
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        ExtendedToolbarButton.c r7 = new ExtendedToolbarButton.c(r0, r3, false, r5);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.l = r4;
        r7.a = r6;
        r7.n = r6;
        r7.m = r8;
        r7.i = 2131252414;
        return r7;
    }
}
