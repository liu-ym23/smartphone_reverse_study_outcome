package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.IGameManagerService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudioCommentBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.android.livesdk.config.l40;
import com.bytedance.android.livesdk.config.nc;
import com.bytedance.android.livesdk.config.wi0;
import com.bytedance.android.livesdk.config.z90;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdk.vipim.VipIMManager;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveToolbarMoreDialog extends CommonStandardBottomDialog implements View.OnClickListener, com.bytedance.android.livesdk.utils.y1, Observer<KVData> {
    public static final Map<ToolbarButton, String> Y = null;
    public final ep1.c B;
    public final List<ToolbarButton> C;
    public final List<ExtendedToolbarButton.c> D;
    public Map<ExtendedToolbarButton, View> E;
    public final String F;
    public ViewGroup G;
    public GridLayout H;
    public GridLayout I;
    public TextView J;
    public g3 K;
    public final boolean L;
    public final boolean M;
    public Room N;
    public final List<ToolbarButton> O;
    public final boolean P;
    public DataCenter Q;
    public final CompositeDisposable R;
    public final ToolbarDisableController S;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u0 T;
    public final TreeSet<RedDotDelegate> U;
    public boolean V;
    public long W;
    public final boolean X;

    public LiveToolbarMoreDialog() {
        throw null;
    }

    static {
        HashMap r0 = new HashMap();
        Y = r0;
        r0.put(ToolbarButton.BEAUTY, "BeautyPicker");
        r0.put(ToolbarButton.AV_ADJUST, "AvAdjustPicker");
        r0.put(ToolbarButton.LIVE_MULTI_CAMERA, "LiveMultiCamera");
        r0.put(ToolbarButton.STICKER_NEW, "sticker_head");
        r0.put(ToolbarButton.DECORATION, "sticker");
        r0.put(ToolbarButton.GESTURE_MAGIC, "sticker_gesture");
        r0.put(ToolbarButton.SOUND_EFFECT, "SoundEffect");
        r0.put(ToolbarButton.MULTI_CAMERA, "director_multi");
        r0.put(ToolbarButton.CAMERA_MOVEMENT, "camera_movement");
        r0.put(ToolbarButton.LIVE_PICTURE_PRESENTATION, "PIC_PRESENTATION");
    }

    private boolean b1() {
        zg1.m r0 = (zg1.m) this.Q.get("data_broadcast_pause_state");
        if (r0 == null) goto L9;
        int r1 = r0.a;
        if (r1 != 1) goto L7;
        return true;
    L7:
        if (r1 != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public List<ExtendedToolbarButton> g1() {
        List<ToolbarButton> r0 = this.O;
        List<ToolbarButton> r1 = this.C;
        int r2 = ToolbarDisableController.c;
        if (r0 != null) goto L10;
        if (r1 == null) goto L24;
        List<ToolbarButton> r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L25;
        r4.add(((ToolbarButton) r5.next()).extended());
        goto L7
    L25:
        return r4;
    L24:
        return CollectionsKt.emptyList();
    L10:
        if (r1 != null) goto L15;
        List<ToolbarButton> r6 = r0;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L20;
        r7.add(((ToolbarButton) r8.next()).extended());
    L20:
        return r7;
    L15:
        List r9 = CollectionsKt.plus(r0, r1);
        r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L17:
        if (r10.hasNext() == false) goto L20;
        r7.add(((ToolbarButton) r10.next()).extended());
        goto L17
    }

    public final int getLayoutId() {
        return this.B.a(this.Q);
    }

    public final void onDetachedFromWindow() {
        this.R.clear();
        y3.m(this.Q).b(ToolbarButton.MORE, new pp1.j(false));
        this.K.H(false);
        DataCenter r0 = this.Q;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a1() {
        if (PadConfigUtils.c() == true) goto L9;
        if (this.L == true) goto L9;
        return com.bytedance.android.live.core.utils.s1.y() / 4;
    L9:
        return (int) (UIUtils.dip2Px(getContext(), 375.0f) / 4.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c1() {
        final int r0 = a1();
        final LayoutInflater r1 = LayoutInflater.from(getContext());
        X0(g1());
        if (this.B.c(this.O, this.G, new y0(this, r0, r1)) == true) goto L6;
        e1(r0, r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (c4.b(this.M) == false) goto L20;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.g.a;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, -1L);
        y3.m(this.Q).b(ToolbarButton.MORE, new pp1.j(false));
    L20:
        com.bytedance.android.livesdk.f.d().g("MORE");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.M == true) goto L5;
    L42:
        c1();
        int r0 = z3.a;
        z3.c(this.Q, true);
        return;
    L5:
        if (z90.a.getValue().booleanValue() == false) goto L42;
        if (tb1.c.a == false) goto L42;
        ArrayList r1 = new ArrayList();
        Iterator<ToolbarButton> r2 = this.O.iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        ToolbarButton r3 = r2.next();
        if (r3 == ToolbarButton.ROOM_INTRO) goto L18;
        if (r3 == ToolbarButton.HASH_TAG) goto L18;
        if (r3 != ToolbarButton.LIVE_CONTENT) goto L11;
    L18:
        r1.add(r3);
        goto L11
    L19:
        Iterator<ToolbarButton> r4 = this.O.iterator();
    L21:
        if (r4.hasNext() == false) goto L35;
        ToolbarButton r5 = r4.next();
        if (r5 != ToolbarButton.REN_QI_BAO) goto L28;
        if (((Boolean) this.Q.get("data_ren_qi_bao_button_dismiss", Boolean.FALSE)).booleanValue() == false) goto L28;
        r4.remove();
    L28:
        if (r5 != ToolbarButton.DOU_PLUS_PROMOTE) goto L21;
        if (jc1.k.f(ILiveDouPlusService.class).shouldBlockEcpLiveEntry() == false) goto L21;
        if (((Boolean) this.Q.get("is_type_up_cart", Boolean.FALSE)).booleanValue() == false) goto L21;
        r4.remove();
        goto L21
    L35:
        if (r1.size() > 1) goto L37;
    L39:
        List<ToolbarButton> r6 = this.O;
        ToolbarButton r7 = ToolbarButton.BROADCAST_ADMIN;
        if (r6.contains(r7) == false) goto L42;
        y3.f(this.Q).p(r7.extended(), new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.c2());
        goto L42
    L37:
        if (this.O.contains(ToolbarButton.BROADCAST_INFO) == true) goto L39;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new h1(this, r1)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
        goto L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (getWindow() == null) goto L5;
        Window r0 = getWindow();
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.addFlags(Integer.MIN_VALUE);
        getWindow().setNavigationBarColor(-16777216);
    L5:
        int r1 = z3.a;
        z3.a(this.Q, getWindow());
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L64;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        com.bytedance.android.livesdk.f.d().b("MORE", this);
        String r3 = "tool_panel";
        if (this.O.contains(ToolbarButton.DOU_PLUS_PROMOTE) == false) goto L16;
        com.bytedance.android.livesdk.business.douplus.h r2 = this.K.t(ToolbarButton.DOU_PLUS_PROMOTE);
        if ((r2 instanceof com.bytedance.android.livesdk.business.douplus.h) == false) goto L21;
        r2.onShow();
        Y0(1, "tool_panel", "", "");
    L21:
        if (this.O.contains(ToolbarButton.REN_QI_BAO) == false) goto L29;
        c0.b r4 = this.K.t(ToolbarButton.REN_QI_BAO);
        if ((r4 instanceof q4) == false) goto L29;
        ((q4) r4).onShow();
        if (((Boolean) this.Q.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L27;
        String r5 = "tool_panel";
    L28:
        h1(1, r5, "", "");
        goto L29
    L27:
        r5 = "share_panel";
    L29:
        DataCenter r6 = this.Q;
        if (r6 == null) goto L33;
        r6.observe("cmd_live_toolbarmore_dialog_dismiss", this).observe("data_little_plugin", this).observe("live_cast_screen_connect_status_bg_change", this);
    L33:
        if (this.O.contains(ToolbarButton.DOU_PLUS_PROMOTE) == true) goto L44;
        if (this.O.contains(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == true) goto L44;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L44;
        if (this.M == false) goto L41;
        String r7 = "tool_panel";
    L42:
        Y0(0, r7, "10001", "未知原因");
        goto L44
    L41:
        r7 = "share_panel";
    L44:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L47;
        Y0(0, "share_panel", "10000", "用户未登录");
    L47:
        if (this.O.contains(ToolbarButton.REN_QI_BAO) == true) goto L58;
        if (n5.c(this.Q) == false) goto L58;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L58;
        if (this.M == true) goto L56;
        r3 = "share_panel";
    L56:
        h1(0, r3, "10001", "未知原因");
    L58:
        if (n5.c(this.Q) == true) goto L60;
        return;
    L60:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L67;
        h1(0, "share_panel", "10000", "用户未登录");
        return;
    L67:
        return;
    L16:
        if (this.O.contains(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == false) goto L21;
        com.bytedance.android.livesdk.business.douplus.h r8 = this.K.t(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE);
        if ((r8 instanceof com.bytedance.android.livesdk.business.douplus.h) == false) goto L21;
        r8.onShow();
        Y0(1, "share_panel", "", "");
        goto L21
    L64:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L9:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void W0(LiveToolbarMoreDialog r3) {
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

    public final void X0(List<ExtendedToolbarButton> r4) {
        ALogger.i("LiveToolbarMoreDialog", "isPaused:" + b1());
        if (b1() == false) goto L5;
        this.S.a(this.K, r4, new d1());
        return;
    L5:
        this.S.b(this.K);
    }

    public final boolean Z0(ToolbarButton r7) {
        if (r7 != ToolbarButton.COMMENT) goto L9;
        if (com.bytedance.android.live.core.utils.z.h(this.Q) == true) goto L9;
        return !((Boolean) this.Q.get("data_room_audio_comment_anchor_show", Boolean.FALSE)).booleanValue();
    L9:
        if (r7 != ToolbarButton.AUDIO_COMMENT) goto L13;
        return !((Boolean) this.Q.get("data_room_audio_comment_anchor_show", Boolean.FALSE)).booleanValue();
    L13:
        if (r7 == ToolbarButton.SMALL_WINDOW_ACTION_BUTTON) goto L15;
        ToolbarButton r0 = ToolbarButton.AUDIENCE_RESOLUTION;
        if (r7 != r0) goto L21;
        return !AudienceVideoResolutionManager.x();
    L21:
        if (r7 != ToolbarButton.PLAY_SETTING) goto L26;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.Q).N0(PaidSceneEnum.PAID_ROOM, null) == true) goto L26;
        return true;
    L26:
        if (r7 != ToolbarButton.VOICE_LIVE_THEME) goto L46;
        int r8 = jc1.k.f(IInteractService.class).getCurrentUiLayout();
        if (7 != r8) goto L30;
        return true;
    L30:
        if (25 == r8) goto L66;
        RoomContext.a r9 = RoomContext.Companion;
        DataCenter r1 = this.Q;
        r9.getClass();
        RoomContext r10 = RoomContext.a.a(r1, 0);
        if (r10 != null) goto L35;
    L43:
        return false;
    L35:
        if (r10.getVoiceTalkRoomSubScene().getValue() == null) goto L43;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getVoiceTalkRoomSubScene().getValue()).t().a != 10) goto L39;
        return true;
    L39:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getVoiceTalkRoomSubScene().getValue()).t().a != 9) goto L43;
        if (l40.a.getValue().isAnchorEnable() == true) goto L43;
        return true;
    L66:
        return true;
    L46:
        if (r7 != ToolbarButton.TASK_CENTER) goto L50;
        return !TTLiveSDKContext.getHostService().h().isLogin();
    L50:
        if (r7 == ToolbarButton.REN_QI_BAO) goto L52;
        ILivePlayerClient r2 = LivePlatformPlayerManager.f();
        if (r2 != null) goto L56;
    L63:
        return false;
    L56:
        if (r2.extraRenderController().isUgcRoom() == false) goto L63;
        if (r7 != r0) goto L59;
    L62:
        return true;
    L59:
        if (r7 == ToolbarButton.RECORD) goto L62;
        if (r7 != ToolbarButton.RECORD_COMBINE) goto L63;
    L52:
        return ((Boolean) this.Q.get("data_ren_qi_bao_button_dismiss", Boolean.FALSE)).booleanValue();
    L15:
        return jc1.k.n(IHostAction.class).isGreyMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (r12 != null) goto L5;
    L7:
        if (r12 != null) goto L9;
    L49:
        if (r12 != null) goto L51;
        return;
    L51:
        if (TextUtils.equals(r12.getKey(), "live_cast_screen_connect_status_bg_change") == true) goto L53;
        return;
    L53:
        if ((r12.getData() instanceof Integer) == false) goto L72;
        Map<ExtendedToolbarButton, View> r13 = this.E;
        ToolbarButton r0 = ToolbarButton.CAST_SCREEN;
        View r14 = (View) ((HashMap) r13).get(ExtendedToolbarButton.e(r0));
        if (r14 == null) goto L73;
        View r1 = r14.findViewById(2131374718);
        TextView r15 = (TextView) r14.findViewById(2131380593);
        if (r1 == null) goto L74;
        if (r15 == null) goto L75;
        j1(r0, r1, r15);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L9:
        if (TextUtils.equals(r12.getKey(), "data_little_plugin") == false) goto L49;
        if (isShowing() == false) goto L49;
        if (this.H == null) goto L49;
        View r2 = null;
        Pair r3 = (Pair) r12.getData();     // Catch: Exception -> L17
    L18:
        boolean r4 = true;
        int r5 = this.H.getChildCount() - 1;
    L19:
        if (r5 < 0) goto L27;
        if (this.H.getChildAt(r5) == null) goto L25;
        if ((this.H.getChildAt(r5).getTag() instanceof ExtendedToolbarButton.d) == false) goto L25;
        r2 = this.H.getChildAt(r5).findViewById(2131374798);
    L25:
        r5 = r5 - 1;
    L27:
        if ((r2 instanceof ImageView) == false) goto L49;
        if (r3 == null) goto L30;
    L36:
        if (r3 == null) goto L49;
        if (r3.getSecond() == IGameManagerService.OpenPlatformAppState.OpenPlatformAppStateRunning) goto L42;
        r4 = false;
    L42:
        if (r4 == false) goto L44;
        int r6 = 2131251591;
    L45:
        r2.setBackgroundResource(r6);
        com.bytedance.android.live.broadcastgame.api.model.e r7 = (com.bytedance.android.live.broadcastgame.api.model.e) r3.getFirst();
        if (this.T != null) goto L48;
        this.T = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u0(r4, getContext(), r7, this.Q, this);
    L48:
        this.T.a = r4;
        goto L49
    L44:
        r6 = 2131251590;
        goto L45
    L30:
        if (this.H == null) goto L36;
        if (r2.getParent() == null) goto L36;
        this.H.removeView((ViewGroup) r2.getParent());     // Catch: Exception -> L35
    L17:
        r3 = null;
        goto L18
    L5:
        if (TextUtils.equals(r12.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L7;
        W0(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if ((r10.getTag() instanceof ExtendedToolbarButton.c) == false) goto L6;
        ExtendedToolbarButton r0 = (ExtendedToolbarButton.c) r10.getTag();
    L12:
        if (r0 != null) goto L14;
        return;
    L14:
        if (b1() == true) goto L16;
    L19:
        c0.b r2 = this.K.s(r0);
        if (this.K.x(r0) == false) goto L25;
        String r11 = this.K.u(r0);
        if (TextUtils.isEmpty(r11) == true) goto L73;
        com.bytedance.android.live.core.utils.f2.c(r11, 0);
        return;
    L73:
        return;
    L25:
        if (r2 != null) goto L27;
        return;
    L27:
        if (c4.a(this.M) == false) goto L32;
        Object r3 = r10.findViewById(2131384095);
        if ((r3 instanceof RedDotView) == false) goto L32;
        ((RedDotView) r3).l();
    L32:
        if (c4.b(this.M) == true) goto L34;
    L40:
        r2.onClick(r10);
        b4.c.a.b(r0.f());
        i1(r10.findViewById(2131384095), r0, null);
        if ((r0 instanceof ExtendedToolbarButton.d) == false) goto L44;
        W0(this);
        return;
    L44:
        if ((r2 instanceof ToolbarAnchorBacktrackBehavior) == false) goto L49;
        if (((ToolbarAnchorBacktrackBehavior) r2).d == false) goto L77;
        W0(this);
        return;
    L77:
        return;
    L49:
        if ((r2 instanceof ToolbarAnchorRecordBehavior) == false) goto L54;
        if (((ToolbarAnchorRecordBehavior) r2).e == false) goto L79;
        W0(this);
        return;
    L79:
        return;
    L54:
        if ((r2 instanceof com.bytedance.android.livesdk.room.placeholder.behavior.p) == false) goto L56;
        return;
    L56:
        if ((r0 instanceof ExtendedToolbarButton.b) == false) goto L70;
        ToolbarButton r12 = ((ExtendedToolbarButton.b) r0).i;
        if (r12 == ToolbarButton.REVERSE_CAMERA) goto L70;
        if (r12 == ToolbarButton.REVERSE_MIRROR) goto L70;
        if (r12 == ToolbarButton.AUDIO_TOGGLE) goto L70;
        if ((r2 instanceof ToolbarAudioCommentBehavior) == false) goto L68;
        if (((ToolbarAudioCommentBehavior) r2).d == false) goto L70;
    L68:
        if (this.P == false) goto L70;
    L71:
        W0(this);
        return;
    L70:
        if ((r0 instanceof ExtendedToolbarButton.c) == true) goto L71;
        return;
    L34:
        if (r0.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L40;
        if (this.W <= 0) goto L40;
        Object r4 = r10.findViewById(2131384095);
        if ((r4 instanceof RedDotView) == false) goto L40;
        ((RedDotView) r4).l();
        goto L40
    L16:
        if (this.K.x(r0) == false) goto L19;
        com.bytedance.android.live.core.utils.f2.b(2131915411, 0);
        return;
    L6:
        if ((r10.getTag() instanceof ExtendedToolbarButton.b) == false) goto L9;
        r0 = (ExtendedToolbarButton.b) r10.getTag();
        goto L12
    L9:
        if ((r10.getTag() instanceof ExtendedToolbarButton.d) == false) goto L11;
        r0 = (ExtendedToolbarButton.d) r10.getTag();
        goto L12
    L11:
        r0 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.W = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        ViewGroup r4 = (ViewGroup) findViewById(2131367728);
        this.G = r4;
        if (r4 == null) goto L5;
        r4.setOnClickListener(this);
    L5:
        this.H = (GridLayout) findViewById(2131373902);
        findViewById(2131369197);
        this.I = (GridLayout) findViewById(2131375512);
        this.J = (TextView) findViewById(2131380302);
        getWindow();
        int r5 = com.bytedance.android.livesdk.utils.b1.a;
        com.bytedance.android.livesdk.utils.b1.b(this.X, new e1(this));
    }

    public final void setDataCenter(DataCenter r3) {
        this.Q = r3;
        g3 r4 = y3.f(r3);
        this.K = r4;
        this.E = r4.c;
        this.N = (Room) this.Q.get("data_room", null);
        if (ea0.a.getValue().booleanValue() == true) goto L8;
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r5 = AudienceGameContext.a.a();
        if (r5 == null) goto L9;
        r5.getOpenInteractGameIconShouldShow().a().observeOn(AndroidSchedulers.mainThread()).subscribe(new w0(this));
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1(int r11, LayoutInflater r12) {
        if (this.J != null) goto L5;
    L7:
        TextView r0 = this.J;
        if (r0 == null) goto L10;
        r0.setVisibility(8);
    L10:
        UIUtils.setTopMargin(this.H, 24.0f);
    L11:
        GridLayout r1 = this.H;
        if (r1 == null) goto L14;
        r1.removeAllViews();
    L14:
        Pair r2 = null;
        if (c4.a(this.M) == false) goto L17;
        this.U.clear();
        RedDotHelper.b(this.D, this.K, this.U);
        RedDotHelper.c(this.O, this.K, this.U, new c1(this));
        RedDotHelper.c(this.C, this.K, this.U, null);
    L17:
        Iterator r3 = ((ArrayList) this.D).iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        f1(r11, r12, (ExtendedToolbarButton.c) r3.next(), this.H);
        goto L19
    L21:
        Iterator<ToolbarButton> r4 = this.O.iterator();
    L23:
        if (r4.hasNext() == false) goto L29;
        ToolbarButton r5 = r4.next();
        if (Z0(r5) == true) goto L23;
        f1(r11, r12, ExtendedToolbarButton.e(r5), this.H);
        goto L23
    L29:
        if (CollectionUtils.isEmpty(this.C) == true) goto L35;
        Iterator<ToolbarButton> r6 = this.C.iterator();
    L32:
        if (r6.hasNext() == false) goto L35;
        f1(r11, r12, ExtendedToolbarButton.e(r6.next()), this.I);
    L35:
        if (wi0.a.getValue().intValue() == 0) goto L81;
        DataCenter r7 = this.Q;
        if (r7 == null) goto L90;
        RoomContext.Companion.getClass();
        RoomContext r8 = RoomContext.a.a(r7, 0);
        if (r8 != null) goto L42;
        return;
    L42:
        if (r8.getPermissionContext().getValue() != null) goto L44;
        return;
    L44:
        if (((Boolean) ((RoomPermissionContext) r8.getPermissionContext().getValue()).getShouldRefinePermission().getValue()).booleanValue() == false) goto L84;
        RoomPermissionContext.a r9 = RoomPermissionContext.Companion;
        DataCenter r10 = this.Q;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r13 = LiveRoomPermission.p;
        r9.getClass();
        if (RoomPermissionContext.a.e(r10, r13) == false) goto L91;
        DataCenter r14 = this.Q;
        if (r14 == null) goto L72;
        r14.put("cmd_fetch_little_plugin", Boolean.TRUE);
    L72:
        r2 = (Pair) this.Q.get("data_little_plugin", null);     // Catch: Exception -> L53
    L54:
        if (r2 == null) goto L85;
        com.bytedance.android.live.broadcastgame.api.model.e r15 = (com.bytedance.android.live.broadcastgame.api.model.e) r2.getFirst();
        if (r15 != null) goto L58;
        return;
    L58:
        if (TextUtils.isEmpty(r15.c()) == false) goto L60;
        return;
    L60:
        if (CollectionUtils.isEmpty(r15.a()) == true) goto L88;
        IGameManagerService.OpenPlatformAppState r16 = (IGameManagerService.OpenPlatformAppState) r2.getSecond();
        if (r16 != null) goto L64;
        return;
    L64:
        if (r16 != IGameManagerService.OpenPlatformAppState.OpenPlatformAppStateRunning) goto L66;
        boolean r17 = true;
    L67:
        ExtendedToolbarButton.d r18 = new ExtendedToolbarButton.d(r17, r15.a(), r15.c(), String.valueOf(r15.b()));
        g3 r19 = y3.f(this.Q);
        if (this.T != null) goto L70;
        boolean r20 = r17;
        this.T = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u0(r20, getContext(), r15, this.Q, this);
    L70:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u0 r21 = this.T;
        r21.a = r17;
        r19.p(r18, r21);
        f1(r11, r12, r18, this.H);
        return;
    L66:
        r17 = false;
        goto L67
    L88:
        return;
    L85:
        return;
    L91:
        return;
    L84:
        return;
    L90:
        return;
    L81:
        return;
    L5:
        if (TextUtils.isEmpty(this.F) == true) goto L7;
        this.J.setText(this.F);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i1(final View r12, ExtendedToolbarButton r13, View r14) {
        if (r12 != 0) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r13.f()) == true) goto L98;
        if (r14 == null) goto L100;
        boolean r1 = true;
        com.bytedance.android.livesdk.utils.b1.b(true, new t0(r12));
        if (c4.b(this.M) == false) goto L17;
        if (r13.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L17;
        if ((r12 instanceof RedDotView) == false) goto L17;
        RedDotView r0 = (RedDotView) r12;
        r0.getRedDot().e();
        long r4 = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        this.W = r4;
        if (r4 <= 0) goto L17;
        r0.o();
    L17:
        if ((r13 instanceof ExtendedToolbarButton.b) == false) goto L19;
        ToolbarButton r2 = ((ExtendedToolbarButton.b) r13).i;
    L20:
        if (r2 != null) goto L22;
    L28:
        int r5 = 0;
        if (c4.a(this.M) == false) goto L34;
        if ((r12 instanceof RedDotView) == false) goto L40;
        boolean r3 = ((RedDotView) r12).j();
    L43:
        if (r3 == false) goto L67;
        if (c4.b(this.M) == false) goto L67;
        if (r13.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L67;
        if ((r12 instanceof RedDotView) == false) goto L67;
        this.W = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        ImageModel r7 = (ImageModel) com.bytedance.android.livesdk.sharedpref.g.c.getValue();
        if (this.W < 0) goto L63;
        if (r7 == null) goto L63;
        if (CollectionUtils.isEmpty(r7.getUrls()) == true) goto L63;
        if ((r14 instanceof HSImageView) == false) goto L58;
        ((HSImageView) r14).setImageResource(2131251038);
    L58:
        z3.e(r14);
        RedDotView r15 = (RedDotView) r12;
        r15.setVisibility(8);
        RedDotDelegate r6 = r15.a;
        if (r6 == null) goto L61;
        r6.e();
    L61:
        r15.b = true;
        this.V = true;
    L74:
        if (c4.b(this.M) == false) goto L85;
        if (r13.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L85;
        int r16 = z3.a;
        DataCenter r17 = this.Q;
        if (r3 == true) goto L80;
    L82:
        r1 = false;
    L83:
        z3.d(r17, r1);
        goto L85
    L80:
        if (this.V == false) goto L82;
    L85:
        if ((r13 instanceof ExtendedToolbarButton.c) == false) goto L94;
        ExtendedToolbarButton.c r18 = (ExtendedToolbarButton.c) r13;
        if (r18.r == true) goto L89;
    L91:
        r5 = 8;
    L92:
        r12.setVisibility(r5);
        goto L94
    L89:
        if (h3.a(r18.f()) == true) goto L91;
    L94:
        if (com.bytedance.android.live.core.utils.z.h(this.Q) == false) goto L99;
        r12.setVisibility(8);
        return;
    L99:
        return;
    L63:
        if ((r14 instanceof HSImageView) == false) goto L65;
        ((HSImageView) r14).setImageResource(2131251038);
    L65:
        ((RedDotView) r12).setVisibility(0);
    L67:
        if ((r14 instanceof HSImageView) == false) goto L69;
        ((HSImageView) r14).setImageResource(2131251038);
    L69:
        if (r3 == false) goto L71;
        int r19 = 0;
    L72:
        r12.setVisibility(r19);
        goto L74
    L71:
        r19 = 8;
    L40:
        r3 = false;
        goto L43
    L34:
        if (c4.b(this.M) == true) goto L36;
    L41:
        r3 = b4.c.a.d(r13, this.K);
        goto L43
    L36:
        if (r13.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L41;
        if ((r12 instanceof RedDotView) == false) goto L40;
        r3 = ((RedDotView) r12).j();
        goto L43
    L22:
        if (nc.a.getValue().booleanValue() == false) goto L28;
        if (TextUtils.isEmpty((String) ((HashMap) Y).get(r2)) == true) goto L28;
        IBroadcastService r8 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r8 == null) goto L28;
        r8.getBroadcastDotManager();
        goto L28
    L19:
        r2 = null;
        goto L20
    L100:
        return;
    }

    public final void j1(ToolbarButton r4, View r5, TextView r6) {
        if (this.M == true) goto L20;
        ToolbarButton r0 = ToolbarButton.CAST_SCREEN;
        if (r4.equals(r0) == false) goto L21;
        int r7 = ((Integer) this.Q.get("live_cast_screen_connect_status_bg_change", 0)).intValue();
        if (r7 != 0) goto L9;
        r5.setBackgroundResource(r0.getDrawableFolded());
        r6.setText(r0.getTitleId());
        return;
    L9:
        if (r7 != 1) goto L11;
        r5.setBackgroundResource(2131250184);
        r6.setText(2131915601);
        return;
    L11:
        if (r7 != 2) goto L13;
        r5.setBackgroundResource(2131250185);
        r6.setText(2131915600);
        return;
    L13:
        if (r7 != 3) goto L25;
        r5.setBackgroundResource(2131250183);
        r6.setText(2131915599);
        return;
    L25:
        return;
    L21:
        return;
    }

    private static void Y0(int r2, String r3, String r4, String r5) {
        if (tb1.c.a == false) goto L15;
        JSONObject r0 = new JSONObject();
        r0.put("entrance_type", r3);     // Catch: Exception -> L9
        if (r2 != 0) goto L11;
        r0.put("error_status", r4);     // Catch: Exception -> L9
        r0.put("error_message", r5);     // Catch: Exception -> L9
    L11:
        jc1.k.f(ILiveDouPlusService.class).douPlusMonitor("douplus_live_entry", r2, r0);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void h1(int r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("entrance_type", r3);     // Catch: Exception -> L7
        if (r2 != 0) goto L9;
        r0.put("error_status", r4);     // Catch: Exception -> L7
        r0.put("error_message", r5);     // Catch: Exception -> L7
    L9:
        jc1.k.f(ILiveRenQiBaoService.class).renQiBaoMonitor("renqibao_live_entry", r2, r0);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(int r19, LayoutInflater r20, ExtendedToolbarButton r21, GridLayout r22) {
        c0.b r3 = this.K.s(r21);
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.w2) == true) goto L8;
    L10:
        ExtendedToolbarButton.HighLightMode r4 = ExtendedToolbarButton.HighLightMode.DISABLE;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r21.f = r4;
        if (com.bytedance.android.live.core.utils.z.k(this.Q) == false) goto L13;
    L22:
        int r5 = 2131567625;
    L24:
        if (r21.f().equals(ToolbarButton.ANCHOR_BACKTRACK.name()) == true) goto L28;
        if (r21.f().equals(ToolbarButton.RECORD_COMBINE.name()) == true) goto L28;
    L31:
        if (c4.b(this.M) == false) goto L36;
        if (r21.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L36;
        r5 = 2131567626;
    L36:
        if (r21.f().equals(ToolbarButton.LIVE_IM_ENTRANCE_MORE.name()) == false) goto L38;
        r5 = 2131567873;
    L38:
        View r6 = r20.inflate(r5, r22, false);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.width = r19;
        r6.setLayoutParams(r7);
        final View r8 = r6.findViewById(2131374718);
        final TextView r9 = (TextView) r6.findViewById(2131380593);
        View r10 = r6.findViewById(2131384095);
        View r11 = r6.findViewById(2131362039);
        TextView r12 = (TextView) r6.findViewById(2131374747);
        int r13 = com.bytedance.android.livesdk.utils.b1.a;
        com.bytedance.android.livesdk.utils.b1.b(this.X, new z0(r8, r9));
        if (c4.b(this.M) == false) goto L48;
        if (r21.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L48;
        if (c4.b(this.M) == false) goto L48;
        if ((r10 instanceof RedDotView) == false) goto L48;
        RedDotView r14 = (RedDotView) r10;
        r14.m(new com.bytedance.android.livesdk.reddot.a("more_gift", -1, 2, 4, -1), null, null, Boolean.valueOf(this.M));
    L48:
        if (c4.a(this.M) == false) goto L55;
        if ((r10 instanceof RedDotView) == false) goto L55;
        RedDotDelegate r15 = r21.c;
        if (r15 == null) goto L55;
        ((RedDotView) r10).n(r15, Boolean.FALSE);
    L55:
        if (c4.b(this.M) == true) goto L57;
    L63:
        if (r11 == null) goto L68;
        r11.setAlpha(1.0f);
        if (r21.f != ExtendedToolbarButton.HighLightMode.FALSE) goto L68;
        r11.setAlpha(0.5f);
    L68:
        if ((r21 instanceof ExtendedToolbarButton.b) == false) goto L117;
        ToolbarButton r16 = ((ExtendedToolbarButton.b) r21).i;
        if (com.bytedance.android.live.core.utils.z.k(this.Q) == true) goto L92;
        if (com.bytedance.android.live.core.utils.z.g(this.Q) == true) goto L92;
        if (com.bytedance.android.live.core.utils.z.i(this.Q) == true) goto L92;
        if (com.bytedance.android.live.core.utils.z.j(this.Q) == true) goto L92;
        if (com.bytedance.android.live.core.utils.z.h(this.Q) == true) goto L92;
        if (this.M == true) goto L83;
    L84:
        r8.setBackgroundResource(r16.getDrawableFolded());
    L85:
        IMiddlewareHostApp r17 = jc1.k.f(IMiddlewareHostApp.class);
        CharSequence r18 = com.bytedance.android.live.core.utils.s1.B(r16.getTitleId());
        if (r17 == null) goto L88;
        r18 = r17.replaceBrand(r16.getTitleId());
    L88:
        r9.setText(r18);
        if (TextUtils.isEmpty(r16.getTitleStr()) == true) goto L98;
        r9.setText(r16.getTitleStr());
    L98:
        if (this.M == false) goto L105;
        if (r16.equals(ToolbarButton.TRANSFORM_WIDGET_MORE) == false) goto L105;
        if (tb1.c.a == false) goto L105;
        r8.setBackgroundResource(r16.getBroadcastDrawableFolded());
    L105:
        if (this.M == true) goto L107;
    L111:
        j1(r16, r8, r9);
        if (ToolbarButton.VIP_IM.equals(r16) == false) goto L142;
        Lazy r23 = VipIMManager.f;
        CharSequence r24 = VipIMManager.a.a().b;
        if (TextUtils.isEmpty(r24) == true) goto L142;
        r9.setText(r24);
    L142:
        if ((r3 instanceof c0.a) == false) goto L144;
        c0.a r25 = (c0.a) r3;
        Maybe<String> r26 = r25.getTitle();
        CompositeDisposable r27 = this.R;
        Objects.requireNonNull(r9);
        r27.add(r26.subscribe(new a1(r9)));
        Maybe<Drawable> r28 = r25.getIcon();
        CompositeDisposable r29 = this.R;
        Maybe r30 = r28.observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(r8);
        r29.add(r30.subscribe(new b1(r8)));
    L144:
        i1(r10, r21, r8);
        if (this.K.x(r21) == false) goto L147;
        r8.setAlpha(0.64f);
        r9.setAlpha(0.64f);
        r10.setAlpha(0.0f);
    L147:
        r6.setTag(r21);
        r22.addView(r6);
        ((HashMap) this.E).put(r21, r6);
        this.K.D(r21, r6);
        r6.setOnClickListener(this);
        return;
    L107:
        if (r16.equals(ToolbarButton.GROUP_PURCHASE_MORE) == false) goto L111;
        if (tb1.c.a == false) goto L111;
        r8.setBackgroundResource(r16.getBroadcastDrawableFolded());
        goto L111
    L83:
        if (r16.name().equals(ToolbarButton.BROADCAST_GIFT.name()) == true) goto L85;
    L92:
        if (this.M == true) goto L94;
    L95:
        r8.setBackgroundResource(r16.getBroadcastDrawableFolded());
    L96:
        r9.setText(r16.getBroadcastTitleId());
        goto L98
    L94:
        if (r16.name().equals(ToolbarButton.BROADCAST_GIFT.name()) == true) goto L96;
    L117:
        if ((r21 instanceof ExtendedToolbarButton.d) == false) goto L134;
        ExtendedToolbarButton.d r31 = (ExtendedToolbarButton.d) r21;
        if (CollectionUtils.isEmpty(r31.p) == true) goto L142;
        if (TextUtils.isEmpty(r31.q) == true) goto L142;
        if (r8 == null) goto L142;
        if ((r6 instanceof RelativeLayout) == false) goto L142;
        r8.setBackgroundResource(r31.i);
        this.R.add(com.bytedance.android.livesdk.utils.g3.a((String) ListProtector.get(r31.p, 0)).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new u0()).onErrorComplete().subscribe(new v0(this, r8)));
        r9.setText(r31.q);
        ImageView r32 = new ImageView(r8.getContext());
        if (r31.t == false) goto L129;
        int r33 = 2131251591;
    L130:
        r32.setBackgroundResource(r33);
        LiveViewStub r34 = (LiveViewStub) r6.findViewById(2131374798);
        if (r34 == null) goto L142;
        r34.a(r32);
        goto L142
    L129:
        r33 = 2131251590;
        goto L130
    L134:
        if ((r21 instanceof ExtendedToolbarButton.c) == false) goto L142;
        ExtendedToolbarButton.c r35 = (ExtendedToolbarButton.c) r21;
        r8.setBackgroundResource(r35.i);
        com.bytedance.android.live.core.utils.r2.a(r8, com.bytedance.android.live.core.utils.s1.f(8.0f));
        this.R.add(com.bytedance.android.livesdk.utils.g3.a((String) ListProtector.get(r35.p, 0)).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new f1()).onErrorComplete().subscribe(new g1(this, r8)));
        r9.setText(r35.q);
        if (r12 == null) goto L142;
        if (r35.l.isEmpty() == true) goto L140;
        r12.setVisibility(0);
        r12.setText(r35.l);
        goto L142
    L140:
        r12.setVisibility(8);
        goto L142
    L57:
        if (r21.f().equals(ToolbarButton.BROADCAST_GIFT.name()) == false) goto L63;
        if ((r10 instanceof RedDotView) == false) goto L63;
        RedDotDelegate r110 = r21.c;
        if (r110 == null) goto L63;
        ((RedDotView) r10).n(r110, Boolean.valueOf(this.M));
    L28:
        if (this.M == false) goto L31;
        r5 = 2131567624;
        goto L31
    L13:
        if (com.bytedance.android.live.core.utils.z.g(this.Q) == true) goto L22;
        if (com.bytedance.android.live.core.utils.z.i(this.Q) == true) goto L22;
        if (com.bytedance.android.live.core.utils.z.j(this.Q) == true) goto L22;
        if (com.bytedance.android.live.core.utils.z.h(this.Q) == true) goto L22;
        r5 = 2131567633;
        goto L24
    L8:
        if (this.N.getBaseOwner().isFollowing() == false) goto L10;
    }

    public LiveToolbarMoreDialog(Context r4, List<ToolbarButton> r5, List<ToolbarButton> r6, ep1.c r7, boolean r8) {
        super(r4, r8, false, false);
        this.P = true;
        this.R = new CompositeDisposable();
        this.U = new TreeSet();
        this.V = false;
        this.W = -1;
        this.X = false;
        this.O = r5;
        this.C = r6;
        RoomContext.Companion.getClass();
        RoomContext r9 = RoomContext.a.a(null, 0);
        if (r9 == null) goto L5;
        this.M = ((Boolean) r9.isAnchor().getValue()).booleanValue();
    L5:
        this.L = r8;
        this.B = r7;
        this.F = r7.b();
        this.S = new ToolbarDisableController(r4);
        this.D = new ArrayList();
        this.X = r7 instanceof ep1.b;
    }
}
