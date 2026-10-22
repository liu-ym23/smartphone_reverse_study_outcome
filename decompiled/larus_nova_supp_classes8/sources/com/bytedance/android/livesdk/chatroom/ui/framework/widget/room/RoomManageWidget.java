package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.EnterRoomAuthCompactManager;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.o;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.f11;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.g4;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.message.model.sk;
import com.bytedance.android.livesdk.message.model.yj;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/RoomManageWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/f;", "Lcom/bytedance/android/livesdk/chatroom/view/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomManageWidget extends MiddlewareRoomWidget implements f, com.bytedance.android.livesdk.chatroom.view.b, Observer<KVData>, vlc.l {
    public static final /* synthetic */ int l = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public AnchorPauseTipsView c;
    public View d;
    public gl0.d e;
    public boolean f;
    public boolean g;
    public com.bytedance.android.livesdk.chatroom.presenter.g h;
    public EnterRoomAuthCompactManager i;
    public m00.f j;
    public final CompositeDisposable k;

    public static final class a {
    }

    static {
    }

    public void Bq(ControlMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public void Cq(ControlMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public void Eq(String r2) {
        Intrinsics.checkNotNullParameter("control_message_action_end", "end_type");
    }

    public void Fq(String r1, String r2) {
        Intrinsics.checkNotNullParameter("control_message_room_banned", "end_type");
    }

    public void Gq() {
    }

    public void Jq() {
    }

    public void Kq() {
    }

    public void Lq() {
    }

    public void Mq() {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public void yq(kj r2) {
        Intrinsics.checkNotNullParameter(r2, "remindMessage");
    }

    public void zq() {
    }

    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.common.AnchorPauseTipsView] */
    /* JADX WARN: Type inference failed for: r0v23 */
    public void Aq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 == null) goto L5;
        ?? r1 = r0.J7();
    L6:
        this.c = r1;
        boolean r2 = false;
        if (r1 == 0) goto L9;
        int r3 = (int) UIUtils.dip2Px(r1.getContext(), 96.0f);
        UIUtils.updateLayout(r1.b, r3, r3);
        r1.T5(2131251822, 0.0f, false);
    L9:
        IPullStreamService r4 = jc1.k.f(IPullStreamService.class);
        if (r4 == null) goto L12;
        gl0.d r5 = r4.getLiveStatusErrorView(getContext(), LivePlayerScene.INSTANCE.getINNER_DRAW());
    L13:
        this.e = r5;
        if (r5 == null) goto L16;
        View r6 = r5.getView();
    L17:
        this.d = r6;
        if (r6 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r7 = this.b;
        if (r7 == null) goto L22;
        FrameLayout r8 = r7.va();
    L23:
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(-1, -1);
        if (r8 == null) goto L26;
        r8.addView(r6, r9);
        goto L26
    L22:
        r8 = null;
    L26:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.a;
        if (r10 != null) goto L29;
    L30:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r11 = this.a;
        if (r11 != null) goto L33;
    L35:
        if (r2 == true) goto L37;
    L45:
        UIUtils.setViewVisibility(this.d, 8);
        return;
    L37:
        if (this.e == null) goto L45;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L45;
        VideoViewParams r13 = (VideoViewParams) r12.get("live_render_view_params", null);
        if (r13 == null) goto L45;
        gl0.d r14 = this.e;
        if (r14 == null) goto L45;
        r14.n1(r13.a, r13.b, r13.c);
        goto L45
    L33:
        if (r11.V9() != true) goto L35;
    L34:
        r2 = true;
        goto L35
    L29:
        if (r10.dg() == true) goto L34;
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L5:
        r1 = 0;
        goto L6
    }

    public final FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public final Room getRoom() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    public final m00.f wq() {
        if (this.j != null) goto L24;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        z00.k r1 = null;
        if (r0 == null) goto L22;
        Fragment r2 = r0.getFragment();
        if (r2 == null) goto L22;
        Room r3 = getRoom();
        if (r3 != null) goto L13;
        return null;
    L13:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L18;
        g00.c r4 = (g00.c) com.bytedance.android.scope.m.e.d(f00.a.b, g00.c.class);
        if (r4 == null) goto L17;
        r1 = r4.a(r2, r3);
    L17:
        this.j = r1;
        goto L24
    L18:
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 == null) goto L21;
        r1 = r5.createCoverController(r2, r3);
    L21:
        this.j = r1;
    L22:
        return null;
    L24:
        return this.j;
    }

    public final com.bytedance.android.live.room.h.b xq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(r0, "$this$getStatusListener");
        com.bytedance.android.live.room.h.b r1 = r0.uq();
        if ((r1 instanceof com.bytedance.android.live.room.h.b) == true) goto L8;
        return null;
    L8:
        return r1;
    L9:
        return null;
    }

    public RoomManageWidget() {
        this.k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        Aq();
        runWithRoomEntered(new AnonymousClass1(this));
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if ((r0 instanceof RoomContext) == true) goto L5;
        r0 = null;
    L5:
        RoomContext r1 = (RoomContext) r0;
        if (r1 != null) goto L8;
    L10:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L13;
        LiveMode r3 = r2.getLiveMode();
    L14:
        Room r4 = getRoom();
        if (r3 == LiveMode.AUDIO) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.L0;
        boolean r6 = true;
        if (r4 != null) goto L19;
    L20:
        if (r4 != null) goto L22;
    L24:
        r6 = false;
    L25:
        Boolean r7 = Boolean.valueOf(r6);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r7);
        goto L26
    L22:
        if (r4.highlight != true) goto L24;
    L19:
        if (r4.getReplay() == true) goto L25;
    L26:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L29;
        r8.observeForever("cmd_widget_loaded", this);
    L29:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L32;
        r9.observe("live_render_view_params", this);
    L32:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L37;
        vlc.d r11 = (vlc.d) r10.get("data_message_manager", null);
        if (r11 == null) goto L37;
        r11.addMessageListener(MessageType.REMIND.getIntType(), this);
        r11.addMessageListener(MessageType.COVER_MESSAGE.getIntType(), this);
        r11.addMessageListener(MessageType.MEMBER.getIntType(), this);
        r11.addMessageListener(MessageType.ROOM_CHALLENGE_MESSAGE.getIntType(), this);
    L37:
        h70.b r12 = getComponentContext();
        if (r12 == null) goto L43;
        IAbilityCenter r13 = r12.a();
        if (r13 == null) goto L44;
        r13.registerAbility(f.class, this);
        return;
    L44:
        return;
    L43:
        return;
    L13:
        r3 = null;
        goto L14
    L8:
        if (((Number) r1.getMediaReviewStatus().getValue()).intValue() != 4) goto L10;
        r1.getMediaReviewStatus().setValue(5);
        goto L10
    }

    public void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        Gq();
        Jq();
        this.k.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(this);
    L7:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.removeObserver(this);
    L10:
        com.bytedance.android.livesdk.chatroom.presenter.g r3 = this.h;
        if (r3 == null) goto L16;
        vlc.d r4 = r3.c;
        if (r4 == null) goto L15;
        r4.removeMessageListener(r3);
    L15:
        r3.a = null;
    L16:
        this.h = null;
        this.i = null;
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L21;
        IAbilityCenter r6 = r5.a();
        if (r6 == null) goto L21;
        r6.unregisterAbility(f.class);
    L21:
        this.a = null;
        this.b = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.view.b
    public final void Ft(ControlMessage r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.hq();
    L6:
        if (r2 == true) goto L8;
        return;
    L8:
        Room r3 = getRoom();
        if (r3 != null) goto L11;
        return;
    L11:
        long r4 = r9.getAction();
        ControlMessage.Companion.getClass();
        if (ControlMessage.access$getACTION_END$cp() != r4) goto L15;
        Eq("control_message_action_end");
        Nq(r9);
        h1 r5 = new h1(7);
        r5.c = r3;
        xs2.b.a().post(r5);
    L35:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("WebcastControlMessage: " + r9.getMessageId());
        return;
    L15:
        if (ControlMessage.access$getACTION_ROOM_BANNED$cp() != r4) goto L30;
        h1 r7 = new h1(7);
        r7.c = r3;
        xs2.b.a().post(r7);
        if (r3.isMediaRoom() == false) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.a;
        if (r8 == null) goto L21;
        boolean r10 = r8.dg();
    L22:
        if (r10 == true) goto L25;
        r1 = true;
        goto L25
    L21:
        r10 = false;
    L25:
        if (StringUtils.isEmpty(r9.getTips()) == true) goto L28;
        if (r1 == true) goto L28;
        f2.c(r9.getTips(), 1);
    L28:
        Fq("control_message_room_banned", r9.getTips());
        goto L35
    L30:
        if (ControlMessage.access$getACTION_PAUSE$cp() != r4) goto L33;
        Bq(r9);
        Nq(r9);
        goto L35
    L33:
        if (ControlMessage.access$getACTION_RESUME$cp() != r4) goto L35;
        Cq(r9);
        Nq(r9);
        goto L35
    L5:
        r2 = false;
        goto L6
    }

    public final void Nq(ControlMessage r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        xs2.b.a().post(new zg1.h("roomStatus", "msg's action is " + r6.getAction() + ", time is " + System.currentTimeMillis() + ", id is " + r6.getMessageId()));
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L45;
        boolean r1 = true;
        if (r0.hq() != true) goto L51;
        if (r6 == null) goto L9;
        String r2 = r6.getKey();
    L10:
        if (r2 == null) goto L52;
        int r3 = r2.hashCode();
        if (r3 == (-1882223254)) goto L26;
        if (r3 == (-1836833765)) goto L18;
        return;
    L18:
        if (r2.equals("cmd_widget_loaded") == true) goto L20;
        return;
    L20:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r6) == true) goto L22;
        return;
    L22:
        if (this.g == true) goto L24;
        com.bytedance.android.livesdk.chatroom.presenter.g r7 = new com.bytedance.android.livesdk.chatroom.presenter.g(((Widget) this).dataCenter);
        this.h = r7;
        r7.a(this);
        this.g = true;
    L24:
        Kq();
        Lq();
        Mq();
        return;
    L26:
        if (r2.equals("live_render_view_params") == false) goto L49;
        VideoViewParams r8 = (VideoViewParams) r6.getData();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.a;
        if (r4 != null) goto L30;
    L31:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = this.a;
        if (r9 != null) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == false) goto L54;
        if (r8 == null) goto L55;
        gl0.d r10 = this.e;
        if (r10 == null) goto L50;
        r10.n1(r8.a, r8.b, r8.c);
        return;
    L50:
        return;
    L55:
        return;
    L54:
        return;
    L34:
        if (r9.V9() != true) goto L36;
    L30:
        if (r4.dg() == true) goto L37;
    L49:
        return;
    L52:
        return;
    L9:
        r2 = null;
        goto L10
    L51:
        return;
    }

    public final void onMessage(tlc.d r12) {
        long r1 = 0;
        String r3 = null;
        o r4 = null;
        r4 = null;
        if ((r12 instanceof kj) == false) goto L104;
        kj r13 = (kj) r12;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L7;
        boolean r2 = r0.hq();
    L8:
        if (r2 == false) goto L160;
        Room r5 = getRoom();
        if (r5 == null) goto L161;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L162;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = this.a;
        if (r7 == null) goto L163;
        g4 r8 = g4.a;
        if (((f11) r8.getValue()).e() == false) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.h.a(r13);
    L22:
        int r9 = r13.s();
        if (r9 != 2) goto L25;
    L100:
        yq(r13);
        LayerEventDispatcher r10 = o70.c.a(Integer.valueOf(r6.hashCode()));
        if (r10 == null) goto L150;
        r10.b(new yn1.e(r13));
        return;
    L150:
        return;
    L25:
        if (r9 == 3) goto L81;
        if (r9 == 4) goto L46;
        if (r9 != 5) goto L31;
        m00.f r11 = wq();
        if (r11 == null) goto L145;
        r11.a(r13, r7.getLiveMode());
        return;
    L145:
        return;
    L31:
        if (r9 == 15) goto L100;
        if (r9 == 16) goto L81;
        switch(r9) {
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L36;
            default: goto L164;
        };
    L36:
        Intrinsics.checkNotNullParameter(r13, "remindMessage");
        return;
    L37:
        MiddlewareRoomContext r14 = getMiddlewareRoomContext();
        if (r14 == null) goto L142;
        com.bytedance.live.datacontext.m r15 = r14.getMediaReviewStatus();
        if (r15 == null) goto L143;
        r15.setValue(6);
        return;
    L143:
        return;
    L142:
        return;
    L164:
        return;
    L46:
        if (r13.E() != null) goto L49;
        return;
    L49:
        if (com.bytedance.android.livesdk.chatroom.game.e.a(getRoom(), getMiddlewareRoomContext()) == false) goto L137;
        h70.b r16 = getComponentContext();
        if (r16 == null) goto L55;
        IAbilityCenter r17 = r16.a();
        if (r17 == null) goto L55;
        r4 = (o) r17.getAbility(o.class);
    L55:
        if (r4 == null) goto L137;
        if (r4.Qa(xq(), r13) != true) goto L137;
        return;
    L137:
    L72:
        e = move-exception;
        ALogger.e("RoomManageWidget", "handleLimitTimeShied: " + e.getMessage());
    L74:
        Context r18 = getContext();
        c9.b r19 = new c9.b();
        r19.a = r18;
        r19.b = 1;
        r19.c = 2131565738;
        r19.d = s1.m(2131251277);
        r19.e = sb2.a.h(r13.noticeTitle, "", false).toString();
        r19.f = sb2.a.h(r13.E(), "", false).toString();
        r19.p = false;
        r19.q = false;
        String r110 = s1.B(2131923740);
        m r20 = m.a;
        r19.h = r110;
        r19.i = r20;
        c9 r111 = new c9(r19.a, r19);
        if (DialogLancet.shouldBlockDialogShow(r111) == false) goto L139;
        DialogLancet.handleBlockedDialogShow(r111);
    L79:
        u.l().b("livesdk_feedback_alert_show");
        return;
    L139:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L136
    L78:
        DialogLancet.beforeDialogShow(r111);
        r111.show();
        DialogLancet.afterDialogShow(r111);
        goto L79
    L60:
        if (((f11) r8.getValue()).d() == false) goto L74;
        if (r13.version < 2) goto L74;
        if (TextUtils.isEmpty(r13.popupWindowUrl) == true) goto L74;
        Uri.Builder r21 = UriProtector.parse(r13.popupWindowUrl).buildUpon();     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r13.popupWindowExtra) == true) goto L68;
        r21.appendQueryParameter("mega_object", r13.popupWindowExtra);     // Catch: Exception -> L72
    L68:
        ILiveActionHandler r22 = jc1.k.f(ILiveActionHandler.class);     // Catch: Exception -> L72
        if (r22 == null) goto L147;
        r22.handle(getContext(), r21.build().toString());     // Catch: Exception -> L72
        return;
    L147:
        return;
    L81:
        if (this.f == false) goto L83;
    L90:
        LayerEventDispatcher r23 = o70.c.a(Integer.valueOf(r6.hashCode()));
        if (r23 == null) goto L93;
        r23.b(new yn1.e(r13));
    L93:
        r5.setMosaicStatus(0);
        IRoomOthersData r24 = r5.getRoomOthers();
        if (r24 == null) goto L96;
        r24.setMV(0L);
    L96:
        com.bytedance.android.live.room.h.b r25 = xq();
        if (r25 == null) goto L99;
        r25.a(r13);
    L99:
        jc1.k.n(IExternalBrowserService.class).enqueueEvent("illegal_live_deblock", new JSONObject());
        return;
    L83:
        if (r5.isLiveTypeAudio() == false) goto L85;
        UIUtils.setViewVisibility(this.c, 8);
    L89:
        Iq(false, "live illegal deblock from RemindMessage.");
        goto L90
    L85:
        gl0.d r26 = this.e;
        if (r26 == null) goto L88;
        r26.setIllegalStatus(false);
    L88:
        UIUtils.setViewVisibility(this.d, 8);
        goto L89
    L163:
        return;
    L162:
        return;
    L161:
        return;
    L160:
        return;
    L7:
        r2 = false;
        goto L8
    L104:
        if ((r12 instanceof sk) == false) goto L109;
        sk r112 = (sk) r12;
        m00.f r27 = wq();
        if (r27 == null) goto L152;
        r27.d(r112);
        return;
    L152:
        return;
    L109:
        if ((r12 instanceof MemberMessage) == false) goto L131;
        MemberMessage r113 = (MemberMessage) r12;
        Room r28 = getRoom();
        if (r28 == null) goto L114;
        r1 = r28.id;
    L114:
        if (r113.isCurrentRoom(r1) == false) goto L168;
        ((Widget) this).dataCenter.put("data_member_message", r113);
        if (r113.getUser() == null) goto L154;
        o0.a r29 = o0.a;
        User r30 = r113.getUser();
        if (r30 == null) goto L121;
        r3 = r30.getIdStr();
    L121:
        String r31 = TTLiveSDKContext.getHostService().h().n();
        r29.getClass();
        if (o0.a.a(r3, r31) == false) goto L169;
        long r32 = r113.getAction();
        if (7 != r32) goto L128;
        xs2.b.a().post(new h1(11));
        return;
    L128:
        if (11 != r32) goto L156;
        zq();
        return;
    L156:
        return;
    L169:
        return;
    L154:
        return;
    L168:
        return;
    L131:
        if ((r12 instanceof yj) == false) goto L158;
        yj r114 = (yj) r12;
        Room r33 = getRoom();
        if (r33 == null) goto L159;
        r33.setLiveHashTagInfo(r114.G());
        return;
    L159:
        return;
    }

    public final void Iq(boolean r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("event_name", "anchor_pause_tips_status");
        if (r4 == false) goto L5;
        String r6 = "show";
    L6:
        r0.put("view_status", r6);
        r0.put("reason", r5);
        b0.o().b("ttlive_room", r0);
        return;
    L5:
        r6 = "hide";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.f
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onActivityResult(r2, r3, r4);
        m00.f r0 = this.j;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
