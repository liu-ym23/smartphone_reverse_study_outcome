package com.bytedance.android.livesdk.chatroom.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateEvent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateIntent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.broadcast.api.framework.service.ILiveRoomStatusService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.jf;
import com.bytedance.android.livesdk.config.m6;
import com.bytedance.android.livesdk.config.tq0;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/BroadcastPauseStateWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BroadcastPauseStateWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public boolean a;
    public LiveMode b;
    public AnchorPauseTipsView c;
    public final CompositeDisposable d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BroadcastPauseStateWidget a;

        public a(BroadcastPauseStateWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            if (this.a.wq() == false) goto L6;
            ((Widget) this.a).dataCenter.put("cmd_broadcast_game_live_recover_error", Boolean.TRUE);
            return;
        L6:
            ILiveRoomStatusService r14 = (ILiveRoomStatusService) va1.b.a.a.a(ILiveRoomStatusService.class);
            if (LiveRoomStatesAndAVResourceUtils.c() == true) goto L9;
        L17:
            BroadcastPauseStateWidget r15 = this.a;
            r15.getClass();
            zg1.m r0 = new zg1.m();
            r0.a = 3;
            ((Widget) r15).dataCenter.put("data_broadcast_pause_state", r0);
            ((Widget) this.a).containerView.setVisibility(8);
            ILinkServiceExternal r16 = jc1.k.f(ILinkServiceExternal.class);
            if (r16 == null) goto L20;
            r16.notifyPauseStatus(3);
        L20:
            HashMap r17 = new HashMap();
            r17.put("is_anchor", "1");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_recover_button_click", r17, new Object[]{am2.x.class, Room.class});
            HashMap r18 = new HashMap();
            r18.put("is_anchor", "1");
            r18.put("over_type", "recover");
            this.a.getClass();
            r18.put("duration", String.valueOf(0));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_suspend_over", r18, new Object[]{am2.x.class, Room.class});
            return;
        L9:
            if (this.a.b != LiveMode.SCREEN_RECORD) goto L17;
            if (r14 == null) goto L17;
            boolean r19 = r14.requestRoomStateUpdate(new zz.b(LiveRoomStateUpdateIntent.RESUME, LiveRoomStateUpdateEvent.User, "BroadcastPauseStateWidget.onLoad", "BroadcastPauseStateWidget", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("event_name", "BroadcastPauseEvent")})));
            BroadcastPauseStateWidget r1 = this.a;
            if (r19 == false) goto L16;
            ((Widget) r1).containerView.setVisibility(8);
            ILinkServiceExternal r110 = jc1.k.f(ILinkServiceExternal.class);
            if (r110 == null) goto L20;
            r110.notifyPauseStatus(3);
            goto L20
        L16:
            r1.getClass();
            goto L20
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BroadcastPauseStateWidget a;

        public b(BroadcastPauseStateWidget r1) {
            this.a = r1;
        }

        public final void a() {
            BroadcastPauseStateWidget r0 = this.a;
            if (r0.a == true) goto L28;
            ConstraintLayout r1 = r0.c;
            if (r1 == null) goto L30;
            Object r2 = null;
            if (r1 == null) goto L10;
            ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        L11:
            if (r3 == null) goto L27;
            FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (r5 == null) goto L21;
            Object r6 = r5.get("cmd_data_interact_public_screen_height_change", null);
            if ((r6 instanceof i32.a) == false) goto L18;
            r2 = r6;
        L18:
            i32.a r7 = (i32.a) r2;
            if (r7 == null) goto L21;
            int r8 = r7.b + r7.a;
        L22:
            r4.bottomMargin = (r8 - com.bytedance.android.live.core.utils.s1.f(74)) / 2;
            r4.rightMargin = com.bytedance.android.live.core.utils.s1.f(jc1.k.n(IInteractService.class).getVideoTalkService().m());
            ConstraintLayout r9 = this.a.c;
            if (r9 == null) goto L29;
            r9.setLayoutParams(r4);
            return;
        L29:
            return;
        L21:
            r8 = 0;
            goto L22
        L27:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L10:
            r3 = null;
            goto L11
        L30:
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

    public int getLayoutId() {
        return 2131565279;
    }

    public String getSpm() {
        return "a100.a100.a180";
    }

    public static void xq() {
        HashMap r0 = new HashMap();
        r0.put("is_anchor", "1");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_recover_button_show", r0, new Object[]{am2.x.class, Room.class});
    }

    public final void Aq() {
        Integer r0 = (Integer) ((Widget) this).dataCenter.get("data_screen_orientation", 1);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() == 1) goto L8;
        return;
    L8:
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L13;
        r1.post(new b(this));
        return;
    }

    public final boolean wq() {
        Integer r0 = (Integer) ((Widget) this).dataCenter.get("cmd_broadcast_game_live_intercept_state", 0);
        if (r0 != null) goto L6;
    L7:
        return true;
    L6:
        if (r0.intValue() != 0) goto L7;
        return false;
    }

    public final void yq() {
        if (((m6) tq0.a.getValue()).a() == true) goto L6;
        return;
    L6:
        if (this.a == true) goto L8;
        return;
    L8:
        String r1 = com.bytedance.android.live.core.utils.s1.B(2131915408);
        String r3 = com.bytedance.android.live.core.utils.s1.B(2131915412);
        Integer r4 = (Integer) ((Widget) this).dataCenter.get("cmd_broadcast_game_live_intercept_state", 0);
        if (wq() == false) goto L25;
        if (r4 != null) goto L13;
    L15:
        if (r4 != null) goto L18;
    L20:
        if (r4 == null) goto L25;
        if (r4.intValue() != 4) goto L25;
        r1 = com.bytedance.android.live.core.utils.s1.B(2131915408);
        r3 = com.bytedance.android.live.core.utils.s1.B(2131915412);
        goto L25
    L18:
        if (r4.intValue() != 3) goto L20;
        r1 = com.bytedance.android.live.core.utils.s1.B(2131915347);
        r3 = com.bytedance.android.live.core.utils.s1.B(2131915348);
        goto L25
    L13:
        if (r4.intValue() != 1) goto L15;
        r1 = com.bytedance.android.live.core.utils.s1.B(2131915361);
        r3 = com.bytedance.android.live.core.utils.s1.B(2131915362);
    L25:
        ((TextView) ((Widget) this).containerView.findViewById(2131381985)).setText(r1);
        ((TextView) ((Widget) this).containerView.findViewById(2131384059)).setText(r3);
    }

    public final void zq() {
        ((Widget) this).contentView.findViewById(2131381973).setVisibility(0);
        float r0 = UIUtils.getScreenWidth(((Widget) this).context) / UIUtils.getScreenHeight(((Widget) this).context);
        SettingKey<com.bytedance.android.livesdk.config.w0> r2 = h21.c;
        com.bytedance.android.livesdk.config.w0 r3 = (com.bytedance.android.livesdk.config.w0) r2.getValue();
        Integer r4 = (Integer) ((Widget) this).dataCenter.get("data_screen_orientation", 1);
        String r5 = "";
        if (r4 != null) goto L6;
    L10:
        String r6 = r3.c();
        if (r6 == null) goto L14;
    L13:
        r5 = r6;
    L14:
        LiveMode r7 = this.b;
        if (r7 != LiveMode.AUDIO) goto L22;
        Room r1 = (Room) ((Widget) this).dataCenter.get("data_room");
        if (r1 == null) goto L19;
        String r8 = r1.getOwnerUserIdString();
    L20:
        com.bytedance.android.livesdk.chatroom.utils.a1.r(((Widget) this).contentView.findViewById(2131381973), com.bytedance.android.livesdk.model.k.b(jf.a.getValue(), r8), 2131248875);
        return;
    L19:
        r8 = "0";
        goto L20
    L22:
        boolean r9 = this.a;
        if (r9 == false) goto L25;
    L36:
        if (r9 == false) goto L51;
        if (((com.bytedance.android.livesdk.config.w0) r2.getValue()).a() == false) goto L40;
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r5);
        return;
    L40:
        IUserService r10 = jc1.k.n(IUserService.class);
        py.k r11 = r10.user().b().getAvatarMedium();
        if (r11 != null) goto L48;
        String r12 = r10.user().b().getAvatarUrl();
        if (TextUtils.isEmpty(r12) == true) goto L48;
        ArrayList r13 = new ArrayList();
        if (r12 == null) goto L47;
        r13.add(r12);
    L47:
        r11 = new ImageModel(null, r13);
    L48:
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r11, new l3(5, r0, null));
        return;
    L51:
        if (((com.bytedance.android.livesdk.config.w0) r2.getValue()).a() == false) goto L53;
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r5);
        return;
    L53:
        Room r14 = (Room) ((Widget) this).dataCenter.get("data_room");
        if (r14 == null) goto L69;
        User r15 = r14.getOwner();
        if (r15 == null) goto L70;
        py.k r16 = r15._avatarMedium;
        if (r16 != null) goto L62;
        String r17 = r15.getAvatarUrl();
        if (TextUtils.isEmpty(r17) == true) goto L62;
        ArrayList r18 = new ArrayList();
        Intrinsics.checkNotNull(r17);
        r18.add(r17);
        r16 = new ImageModel(null, r18);
    L62:
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r16, new l3(5, r0, null));
        return;
    L70:
        return;
    L69:
        return;
    L25:
        if (r7 != LiveMode.SCREEN_RECORD) goto L27;
    L28:
        Room r19 = (Room) ((Widget) this).dataCenter.get("data_room");
        if (r3.a() == false) goto L31;
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r5);
        return;
    L31:
        if (r19 == null) goto L65;
        py.k r20 = r19.getBackground();
        if (r20 == null) goto L66;
        ImageLoader.bindImage(((Widget) this).contentView.findViewById(2131381973), r20, new l3(5, r0, null));
        return;
    L66:
        return;
    L65:
        return;
    L27:
        if (r7 != LiveMode.THIRD_PARTY) goto L36;
    L6:
        if (r4.intValue() != 0) goto L10;
        r6 = r3.b();
        if (r6 != null) goto L13;
        goto L13
    }

    public BroadcastPauseStateWidget() {
        this.b = LiveMode.VIDEO;
        this.d = new CompositeDisposable();
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ((Widget) this).dataCenter.removeObserver(this);
        ((Widget) this).containerView.setVisibility(0);
        this.d.clear();
    }

    public final void eR(LiveMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.b = r2;
        if (this.a == true) goto L6;
        Aq();
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (((Widget) this).context != null) goto L5;
        return;
    L5:
        if (((Widget) this).isViewValid == false) goto L110;
        String r0 = null;
        if (r10 == null) goto L10;
        String r1 = r10.getKey();
    L12:
        if (Intrinsics.areEqual(r1, "data_broadcast_pause_state") == false) goto L72;
        zg1.m r11 = (zg1.m) r10.getData();
        if (r11 == null) goto L16;
        Integer r2 = Integer.valueOf(r11.a);
    L18:
        if (r2 != null) goto L21;
    L45:
        if (r2 != null) goto L48;
    L60:
        if (r2 != null) goto L63;
    L65:
        if (r2 != null) goto L68;
        return;
    L68:
        if (r2.intValue() == 7) goto L70;
        return;
    L70:
        if (wq() == false) goto L100;
        ((Widget) this).dataCenter.put("cmd_broadcast_game_live_recover_error", Boolean.TRUE);
        return;
    L100:
        return;
    L63:
        if (r2.intValue() != 3) goto L65;
        ((Widget) this).containerView.setVisibility(8);
        xs2.b.a().post(new zg1.h1(31));
        return;
    L48:
        if (r2.intValue() != 2) goto L60;
        yq();
        if (((Widget) this).containerView.getVisibility() == 0) goto L55;
        ((Widget) this).containerView.setVisibility(0);
        ((LinearLayout) ((Widget) this).contentView.findViewById(2131364573)).setVisibility(0);
        AnchorPauseTipsView r3 = this.c;
        if (r3 == null) goto L54;
        r3.setVisibility(8);
    L54:
        zq();
        xq();
    L55:
        r11.getClass();
        if (0 >= 60) goto L58;
        ((TextView) ((Widget) this).contentView.findViewById(2131381976)).setTextColor(((Widget) this).context.getResources().getColor(2131106947));
    L59:
        ((TextView) ((Widget) this).contentView.findViewById(2131381976)).setText(null);
        return;
    L58:
        ((TextView) ((Widget) this).contentView.findViewById(2131381976)).setTextColor(((Widget) this).context.getResources().getColor(2131109391));
        goto L59
    L21:
        if (r2.intValue() != 1) goto L45;
        ((Widget) this).containerView.setVisibility(0);
        if (this.a == false) goto L27;
        yq();
        ((LinearLayout) ((Widget) this).contentView.findViewById(2131364573)).setVisibility(0);
        AnchorPauseTipsView r12 = this.c;
        if (r12 == null) goto L30;
        r12.setVisibility(8);
    L30:
        xs2.b.a().post(new zg1.h1(30));
        zq();
        xq();
        HashMap r13 = new HashMap();
        int r4 = jc1.k.n(IInteractService.class).getLinkMode();
        if (gd0.v.a(r4, 32) == false) goto L33;
    L43:
        r13.put("interact_function", "chat_room");
    L44:
        r13.put("anchor_status", "suspend");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_suspend_reminder_show", r13, new Object[]{am2.x.class, Room.class});
        return;
    L33:
        if (gd0.v.a(r4, 8) == true) goto L43;
        if (gd0.v.a(r4, 2) == false) goto L39;
        r13.put("interact_function", "audience_connect");
        goto L44
    L39:
        if (gd0.v.a(r4, 4) == false) goto L41;
    L42:
        r13.put("interact_function", "anchor_connect");
        goto L44
    L41:
        if (gd0.v.a(r4, 64) == false) goto L44;
    L27:
        Aq();
        ((LinearLayout) ((Widget) this).contentView.findViewById(2131364573)).setVisibility(8);
        AnchorPauseTipsView r14 = this.c;
        if (r14 == null) goto L30;
        r14.setVisibility(0);
        goto L30
    L16:
        r2 = null;
        goto L18
    L72:
        if (r10 == null) goto L75;
        r0 = r10.getKey();
    L75:
        if (Intrinsics.areEqual(r0, "data_keyboard_status") == false) goto L102;
        zg1.m r5 = (zg1.m) ((Widget) this).dataCenter.get("data_broadcast_pause_state");
        if (r5 != null) goto L79;
        return;
    L79:
        if (r5.a == 1) goto L81;
        return;
    L81:
        if (((Widget) this).containerView.getVisibility() == 0) goto L83;
        return;
    L83:
        if (this.a == true) goto L106;
        Boolean r15 = (Boolean) r10.getData();
        if (r15 != null) goto L87;
    L91:
        Aq();
        AnchorPauseTipsView r16 = this.c;
        if (r16 == null) goto L109;
        r16.setVisibility(0);
        return;
    L109:
        return;
    L87:
        if (r15.booleanValue() == false) goto L91;
        AnchorPauseTipsView r17 = this.c;
        if (r17 == null) goto L107;
        r17.setVisibility(8);
        return;
    L107:
        return;
    L106:
        return;
    L102:
        return;
    L10:
        r1 = null;
        goto L12
    }

    public final void onInit(Object[] r3) {
        Boolean r4 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE);
        if (r4 == null) goto L5;
        this.a = r4.booleanValue();
    L5:
        ((Widget) this).containerView.setVisibility(8);
        this.c = (AnchorPauseTipsView) findViewById(2131364574);
    }

    public final void onLoad(Object[] r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        ((Widget) this).dataCenter.observe("data_broadcast_pause_state", this).observe("data_keyboard_status", this);
        ((TextView) ((Widget) this).contentView.findViewById(2131384059)).setOnClickListener(new a(this));
        if (this.a == true) goto L13;
        zg1.m r5 = (zg1.m) ((Widget) this).dataCenter.get("data_broadcast_pause_state");
        if (r5 != null) goto L7;
    L11:
        ((Widget) this).containerView.setVisibility(8);
        goto L13
    L7:
        if (r5.a != 1) goto L11;
        ((Widget) this).containerView.setVisibility(0);
        ((LinearLayout) ((Widget) this).contentView.findViewById(2131364573)).setVisibility(8);
        AnchorPauseTipsView r6 = this.c;
        if (r6 == null) goto L13;
        r6.setVisibility(0);
    L13:
        if (ho1.a.o(getComponentContext()) == false) goto L24;
        h70.b r7 = getComponentContext();
        if (r7 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r8 = ho1.a.c(r7);
        if (r8 == null) goto L26;
        PropertyOwner r9 = r8.getLoadState();
        if (r9 == null) goto L27;
        Disposable r10 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r9, new AnonymousClass2(this));
        if (r10 == null) goto L28;
        RxUtilKt.c(r10, this.d);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }
}
