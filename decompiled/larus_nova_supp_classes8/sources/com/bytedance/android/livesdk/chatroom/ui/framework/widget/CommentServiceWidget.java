package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.message.n6;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.anchorsetting.AnchorPublicScreenSettingDialog;
import com.bytedance.android.livesdk.interactivity.api.anchorsetting.XiaoAnSettingDialog;
import com.bytedance.android.livesdk.interactivity.api.comment.data.KeyboardViewModel;
import com.bytedance.android.livesdk.interactivity.api.comment.datacontext.CommentContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.PageUIContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.message.model.jl;
import com.bytedance.android.livesdk.message.model.wd;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.message.TextPieceTextImage;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.c3;
import zg1.e3;
import zg1.k3;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/CommentServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "Ljo1/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/interactivity/api/base/a;", "Lzg1/i1;", "event", "", "onEvent", "<init>", "()V", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentServiceWidget extends MiddlewareRoomWidget implements vlc.l, jo1.d, Observer<KVData>, com.bytedance.android.livesdk.interactivity.api.base.a {
    public static final /* synthetic */ int i = 0;
    public final CompositeDisposable a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d d;
    public CommentContext e;
    public AnchorPublicScreenSettingDialog f;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.a g;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n h;

    public static final class a implements n6.a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final TextPieceTextImage a() {
            return new TextPieceTextImage();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CommentServiceWidget a;

        public c(CommentServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.dismissInputDialog();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CommentServiceWidget a;

        public d(CommentServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.livesdk.chatroom.ui.framework.o r6 = (com.bytedance.android.livesdk.chatroom.ui.framework.o) ((h80.c) r5).a();
            if (r6 == null) goto L24;
            CommentServiceWidget r0 = this.a;
            int r1 = CommentServiceWidget.i;
            MiddlewareRoomContext r2 = r0.getMiddlewareRoomContext();
            if ((r2 instanceof RoomContext) == true) goto L7;
            r2 = null;
        L7:
            RoomContext r3 = (RoomContext) r2;
            if (r3 != null) goto L11;
            return;
        L11:
            if (r6.b == false) goto L13;
            return;
        L13:
            if (((Boolean) r3.getCameraMessageShared().getValue()).booleanValue() == true) goto L26;
            DataCenter r7 = ((Widget) r0).dataCenter;
            if (r7 == null) goto L17;
            r7.put("data_room_text_message_presenter", null);
        L17:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = r0.b;
            if (r8 == null) goto L20;
            boolean r9 = r8.o5();
        L21:
            if (r9 == false) goto L27;
            r3.getClearDanmuForCameraChange().setValue(Boolean.TRUE);
            return;
        L27:
            return;
        L20:
            r9 = false;
            goto L21
        L26:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CommentServiceWidget a;

        public e(CommentServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h80.c r3 = (h80.c) r2;
            com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.b(((Widget) this.a).dataCenter, "on Configuration changed");
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ CommentServiceWidget a;

        public f(CommentServiceWidget r1) {
            this.a = r1;
        }

        public final void run() {
            CommentServiceWidget r0 = this.a;
            int r1 = CommentServiceWidget.i;
            MiddlewareRoomContext r2 = r0.getMiddlewareRoomContext();
            if ((r2 instanceof RoomContext) == true) goto L5;
            r2 = null;
        L5:
            RoomContext r3 = (RoomContext) r2;
            if (r3 == null) goto L10;
            com.bytedance.live.datacontext.j r4 = r3.getPageUIContext();
            if (r4 == null) goto L10;
            ViewModel r5 = (ViewModel) r4.getValue();
        L12:
            if ((r5 instanceof PageUIContext) == true) goto L14;
            r5 = null;
        L14:
            PageUIContext r6 = (PageUIContext) r5;
            if (r6 == null) goto L20;
            com.bytedance.live.datacontext.n r7 = r6.getInteractUIInfo();
            if (r7 == null) goto L21;
            r7.setValue(null);
            return;
        L21:
            return;
        L20:
            return;
        L10:
            r5 = null;
            goto L12
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CommentServiceWidget a;
        public final /* synthetic */ zg1.i1 b;

        public g(CommentServiceWidget r1, zg1.i1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (((Widget) this.a).dataCenter == null) goto L12;
            ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);
            Intrinsics.checkNotNull(r0);
            r0.updateKeyboardStatus(this.b.b);
            ((Widget) this.a).dataCenter.put("data_keyboard_status", Boolean.valueOf(this.b.b));
            ((Widget) this.a).dataCenter.put("data_keyboard_status_douyin", Boolean.valueOf(this.b.b));
            DataContext r1 = CommentServiceWidget.xq(this.a);
            if (r1 == null) goto L13;
            Intrinsics.checkNotNullParameter(r1, "$this$getExpRoomServiceExt");
            com.bytedance.android.livesdk.chatroom.r r2 = z51.a.d(r1);
            if (r2 == null) goto L14;
            com.bytedance.live.datacontext.m r3 = r2.D1();
            if (r3 == null) goto L15;
            r3.setValue(Boolean.valueOf(this.b.b));
            return;
        L15:
            return;
        L14:
            return;
        L13:
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

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    static {
        n6.a = a.a;
    }

    public final boolean dg() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.dg();
    }

    @Override // jo1.d
    public final void dismissInputDialog() {
        CommentContext r0 = this.e;
        if (r0 == null) goto L18;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getCommentService();
        if (r1 == null) goto L8;
        t22.b r2 = (t22.b) r1.getValue();
    L9:
        if (r2 == null) goto L19;
        CommentContext r3 = this.e;
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.j r4 = r3.getCommentService();
        if (r4 == null) goto L21;
        t22.b r5 = (t22.b) r4.getValue();
        if (r5 == null) goto L22;
        r5.dismissInputDialog();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final Room getRoom() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    public final int pT() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.d;
        if (r0 == null) goto L6;
        return r0.En();
    L6:
        return s1.w();
    }

    public final boolean xa() {
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(r0, "$this$getRightBottomTetrisInterface");
        Element<?> r1 = r0.w8(d90.d.a.p0);
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.v r2 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.v) r1.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.v.class);
    L8:
        if (r2 != null) goto L12;
        return false;
    L12:
        return r2.m();
    L7:
        r2 = null;
        goto L8
    }

    public CommentServiceWidget() {
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.p(r0, jo1.d.class, this);
    L5:
        this.b = ho1.a.d(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        this.d = ho1.a.i(getComponentContext());
        boolean r1 = dg();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.b;
        RoomContext r3 = null;
        if (r2 == null) goto L8;
        LiveMode r4 = r2.getLiveMode();
    L9:
        PublicScreenStyleHelper.d(r1, r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = this.b;
        if (r5 == null) goto L12;
        Fragment r6 = r5.getFragment();
    L13:
        if (r6 == null) goto L15;
        CommentContext r7 = (CommentContext) com.bytedance.live.datacontext.d.b(r6, null).a(CommentContext.class);
    L16:
        this.e = r7;
        if (r7 == null) goto L28;
        com.bytedance.live.datacontext.n r8 = r7.getInteractionRootView();
        if (r8 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r9 = this.d;
        if (r9 == null) goto L23;
        GestureDetectLayout r10 = r9.oh();
    L25:
        if ((r10 instanceof FrameLayout) == true) goto L27;
        r10 = null;
    L27:
        r8.setValue(r10);
        goto L28
    L23:
        r10 = null;
    L28:
        CommentContext r11 = this.e;
        if (r11 == null) goto L31;
        String r12 = "CommentContext" + ((Widget) this).dataCenter.hashCode();
        int r13 = com.bytedance.live.datacontext.d.a;
        Intrinsics.checkNotNullParameter(r11, "self");
        com.bytedance.live.datacontext.b.a(r11, r12);
    L31:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L34;
        r14.observeForever("cmd_widget_loaded", this);
    L34:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L37;
        r15.observe("data_room_comment_status", this);
    L37:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L40;
        r16.observe("data_promotion_right_card_container_show", this);
    L40:
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L43;
        r17.observe("data_bottom_card_container_show", this);
    L43:
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L46;
        r18.observe("data_bottom_right_state", this);
    L46:
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L50;
        r19.observe("cmd_video_video_bottom_ready", this);
    L50:
        if (dg() == false) goto L54;
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L54;
        r20.observe("cast_game_panel_height_change", this);
    L54:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r21 = this.b;
        boolean r22 = true;
        if (r21 != null) goto L57;
    L58:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r23 = this.b;
        if (r23 != null) goto L61;
    L63:
        r22 = false;
    L64:
        if (r22 == false) goto L68;
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L68;
        r24.observe("cmd_interact_player_view_change", this);
    L68:
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L71;
        r25.observe("cmd_data_interact_public_screen_height_change", this);
    L71:
        DataCenter r26 = ((Widget) this).dataCenter;
        if (r26 == null) goto L74;
        r26.observe("data_special_enter_anim_extra_height", this);
    L74:
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L79;
        vlc.d r28 = (vlc.d) r27.get("data_message_manager", null);
        if (r28 == null) goto L79;
        r28.addMessageListener(MessageType.MEMBER.getWsMethod(), this);
        r28.addMessageListener(MessageType.SKY_EYE_ANCHOR_SET_MESSAGE.getWsMethod(), this);
    L79:
        int r29 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.a, "CommentServiceWidget#observeMessageAndEvent", new CommentServiceWidget$observeMessageAndEvent$2(this));
        runWithRoomEntered(new AnonymousClass3(this));
        com.bytedance.android.livesdk.chatroom.ui.framework.a r30 = ho1.a.c(getComponentContext());
        if (r30 == null) goto L86;
        PropertyOwner r31 = r30.getLoadState();
        if (r31 == null) goto L86;
        Disposable r32 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r31, new AnonymousClass4(this));
        if (r32 == null) goto L86;
        RxUtilKt.c(r32, this.a);
    L86:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r33 = this.b;
        if (r33 == null) goto L93;
        PropertyOwner r34 = r33.Ce();
        if (r34 == null) goto L93;
        Disposable r35 = r34.subscribe(new c(this));
        if (r35 == null) goto L93;
        RxUtilKt.c(r35, this.a);
    L93:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r36 = this.c;
        if (r36 == null) goto L100;
        PropertyOwner r37 = r36.i8();
        if (r37 == null) goto L100;
        Disposable r38 = r37.subscribe(new d(this));
        if (r38 == null) goto L100;
        RxUtilKt.c(r38, this.a);
    L100:
        h70.b r39 = getComponentContext();
        if (r39 == null) goto L103;
        n r40 = ho1.a.e(r39);
    L104:
        if (r40 == null) goto L110;
        PropertyOwner r41 = r40.sa();
        if (r41 == null) goto L110;
        Disposable r42 = r41.subscribe(new e(this));
        if (r42 == null) goto L110;
        RxUtilKt.c(r42, this.a);
    L110:
        RoomContext r43 = getMiddlewareRoomContext();
        if ((r43 instanceof RoomContext) == false) goto L114;
        r3 = r43;
    L114:
        RoomContext r44 = r3;
        if (r44 == null) goto L119;
        com.bytedance.live.datacontext.j r45 = r44.getPageUIContext();
        if (r45 == null) goto L119;
        r45.c(new AnonymousClass8(this));
    L119:
        RxUtilKt.c(Disposables.fromAction(new f(this)), this.a);
        return;
    L103:
        r40 = null;
        goto L104
    L61:
        if (r23.dg() != true) goto L63;
    L57:
        if (r21.V9() == true) goto L64;
    L15:
        r7 = null;
        goto L16
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.q(r0, jo1.d.class);
    L5:
        xs2.b.a().post(new u22.e());
        PublicScreenStyleHelper.n = false;
        PublicScreenStyleHelper.k = 0;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.removeObserver(this);
    L9:
        if (this.a.isDisposed() == true) goto L11;
        this.a.dispose();
        this.a.clear();
    L11:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L16;
        vlc.d r3 = (vlc.d) r2.get("data_message_manager", null);
        if (r3 == null) goto L16;
        r3.removeMessageListener(this);
    L16:
        this.b = null;
        this.d = null;
        this.c = null;
        AnchorPublicScreenSettingDialog r4 = this.f;
        if (r4 != null) goto L31;
    L24:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.a r5 = this.g;
        if (r5 == null) goto L27;
        r5.dismissDialog();
    L27:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n r6 = this.h;
        if (r6 == null) goto L33;
        r6.dismissDialog();
        return;
    L33:
        return;
    L31:
        r4.dismiss();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L24;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L24
    }

    public final com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b zq() {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L8;
        IAbilityCenter r1 = r0.a();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r1.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L8:
        return null;
    }

    public static final void wq(CommentServiceWidget r5) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r5.getComponentContext());
        boolean r1 = true;
        if (r0 != null) goto L5;
    L6:
        if (r0 == null) goto L11;
        if (r0.V9() != true) goto L11;
        return;
    L11:
        if (r5.getRoom() == null) goto L19;
        Room r2 = r5.getRoom();
        if (r2 == null) goto L19;
        if (r2.isMediaRoom() != true) goto L19;
        if (r5.dg() == true) goto L19;
        boolean r3 = true;
    L20:
        Room r4 = r5.getRoom();
        FrameLayout r6 = null;
        if (r4 == null) goto L23;
        RoomAuthStatus r7 = r4.getRoomAuthStatus();
    L24:
        if (r7 == null) goto L33;
        Room r8 = r5.getRoom();
        if (r8 == null) goto L32;
        RoomAuthStatus r9 = r8.getRoomAuthStatus();
        if (r9 == null) goto L32;
        if (r9.getEnableChat() == true) goto L33;
    L32:
        r1 = false;
    L33:
        if (r1 == true) goto L44;
        if (r3 == false) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r10 = r5.d;
        if (r10 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r11 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r10);
    L39:
        if (r11 == null) goto L41;
        r6 = r11.e;
    L41:
        UIUtils.setViewVisibility(r6, 8);
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_comment", "CommentWidget is not load, chat is disabled.");
        return;
    L38:
        r11 = null;
        goto L39
    L45:
        return;
    L44:
        return;
    L23:
        r7 = null;
    L19:
        r3 = false;
        goto L20
    L5:
        if (r0.dg() != true) goto L6;
    }

    public static final /* synthetic */ DataContext xq(CommentServiceWidget r0) {
        return r0.dataContext;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L118;
        View r1 = null;
        Integer r2 = null;
        if (r8 == null) goto L10;
        String r3 = r8.getKey();
    L11:
        if (r3 == null) goto L119;
        int r4 = 0;
        switch(r3.hashCode()) {
            case -1836833765: goto L75;
            case -1477684366: goto L68;
            case -1381247050: goto L65;
            case -1131769173: goto L62;
            case -1130046128: goto L59;
            case -500046878: goto L52;
            case 985679695: goto L49;
            case 1370395648: goto L46;
            case 1871873441: goto L26;
            case 2049358204: goto L17;
            default: goto L120;
        };
    L120:
        return;
    L17:
        if (r3.equals("cmd_video_video_bottom_ready") == false) goto L90;
        k3 r9 = (k3) r8.getData();
        if (r9 == null) goto L21;
        r2 = Integer.valueOf(r9.b);
    L21:
        if (r2 != null) goto L23;
        return;
    L23:
        if (r2.intValue() > 0) goto L92;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.a(((Widget) this).dataCenter, "CMD_VIDEO_BOTTOM_READY");
        return;
    L92:
        return;
    L90:
        return;
    L26:
        if (r3.equals("data_room_comment_status") == false) goto L94;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.b;
        if (r10 == null) goto L30;
        boolean r11 = r10.o5();
    L31:
        if (r11 == false) goto L121;
        Room r12 = getRoom();
        if (r12 == null) goto L95;
        RoomAuthStatus r13 = r12.getRoomAuthStatus();
        if (r13 == null) goto L96;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = this.d;
        if (r5 == null) goto L41;
        r1 = r5.B9();
    L41:
        if (r13.getEnableChat() == true) goto L44;
        r4 = 8;
    L44:
        UIUtils.setViewVisibility(r1, r4);
        return;
    L96:
        return;
    L95:
        return;
    L121:
        return;
    L30:
        r11 = false;
        goto L31
    L94:
        return;
    L46:
        if (r3.equals("cast_game_panel_height_change") == false) goto L98;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.a(((Widget) this).dataCenter, "platform_height_change");
        return;
    L98:
        return;
    L49:
        if (r3.equals("data_bottom_right_state") == false) goto L100;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.c(((Widget) this).dataCenter, "DATA_BOTTOM_RIGHT_MINI_APP_STATE");
        return;
    L100:
        return;
    L52:
        if (r3.equals("data_special_enter_anim_extra_height") == false) goto L102;
        Integer r14 = (Integer) r8.getData();
        if (r14 == null) goto L103;
        int r15 = r14.intValue();
        i32.a r6 = (i32.a) ((Widget) this).dataCenter.get("cmd_data_interact_public_screen_height_change", null);
        if (r6 == null) goto L104;
        Aq(r6, r15);
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L59:
        if (r3.equals("cmd_interact_player_view_change") == false) goto L106;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.c(((Widget) this).dataCenter, "CMD_INTERACT_PLAYER_VIEW_CHANGE");
        return;
    L106:
        return;
    L62:
        if (r3.equals("data_bottom_card_container_show") == false) goto L108;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.a(((Widget) this).dataCenter, "DATA_BOTTOM_CARD_CONTAINER_SHOW");
        return;
    L108:
        return;
    L65:
        if (r3.equals("data_promotion_right_card_container_show") == false) goto L110;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.c(((Widget) this).dataCenter, "DATA_PROMOTION_RIGHT_CARD_CONTAINER_SHOW");
        return;
    L110:
        return;
    L68:
        if (r3.equals("cmd_data_interact_public_screen_height_change") == false) goto L112;
        i32.a r16 = (i32.a) r8.getData();
        if (r16 == null) goto L113;
        Aq(r16, 0);
        if (dg() == false) goto L114;
        ((Widget) this).dataCenter.put("cmd_update_sticker_position", new c3(r16.a + r16.b));
        return;
    L114:
        return;
    L113:
        return;
    L112:
        return;
    L75:
        if (r3.equals("cmd_widget_loaded") == true) goto L77;
        return;
    L77:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r8) == false) goto L117;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r17 = this.b;
        if (r17 == null) goto L81;
        boolean r18 = r17.o5();
    L82:
        if (r18 == false) goto L122;
        e3 r19 = new e3(((Boolean) l42.a.g.getValue()).booleanValue(), 0, "interaction_fragment");
        r19.a = true;
        if (VrUtils.u(((Widget) this).dataCenter, true) == false) goto L87;
        r19.b = true;
    L87:
        xs2.b.a().post(r19);
        return;
    L122:
        return;
    L81:
        r18 = false;
        goto L82
    L117:
        return;
    L119:
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void onEvent(zg1.i1 r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = ho1.a.i(getComponentContext());
        if (r0 == null) goto L7;
        View r1 = r0.getRootView();
        if (r1 == null) goto L7;
        r1.post(new g(this, r9));
    L7:
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r2 = null;
        int r3 = 0;
        if (r9.b == false) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = this.d;
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r5 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r4);
    L13:
        if (r5 == null) goto L33;
        r5.f.setVisibility(0);
        h70.b r6 = getComponentContext();
        if ((r6 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L17;
        r6 = null;
    L17:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        if (r7 == null) goto L24;
        InteractionContext r8 = r7.k;
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.n<View.OnTouchListener> r10 = r8.getInterceptViewTouchListener();
        if (r10 == null) goto L24;
        View.OnTouchListener r11 = (View.OnTouchListener) r10.getValue();
    L25:
        if (r11 == null) goto L33;
        r5.f.setOnTouchListener(r11);
    L24:
        r11 = null;
    L33:
        h70.b r12 = getComponentContext();
        if (r12 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r13 = ho1.a.d(r12);
        if (r13 == null) goto L40;
        Fragment r14 = r13.getFragment();
        if (r14 == null) goto L40;
        KeyboardViewModel r15 = (KeyboardViewModel) ViewModelProviders.of(r14).get(KeyboardViewModel.class);
    L41:
        int r16 = r9.a;
        if (r9.b == false) goto L78;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r17 = ho1.a.d(getComponentContext());
        if (r17 != null) goto L47;
    L48:
        if (r17 != null) goto L50;
    L72:
        int r18 = -(r16 + s1.f(48));
        com.bytedance.android.livesdk.chatroom.ui.framework.d r19 = this.d;
        if (r19 == null) goto L75;
        r2 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r19);
    L75:
        if (r2 != null) goto L78;
        r3 = r18;
        goto L78
    L50:
        if (r17.V9() != true) goto L72;
    L51:
        int r20 = (-r16) - s1.f(4.0f);
        Context r21 = getContext();     // Catch: Exception -> L67
        if (r21 == null) goto L66;
        View r22 = ((Activity) r21).getWindow().getDecorView();     // Catch: Exception -> L67
        if (com.larus.home.impl.utils.c.e == false) goto L59;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L67
        Thread r23 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L67
        if (r23 == com.larus.home.impl.utils.c.a) goto L59;
        com.larus.home.impl.utils.c.a(r23, "getDecorView");     // Catch: Exception -> L67
    L59:
        View r24 = r22.findViewById(R.id.content);     // Catch: Exception -> L67
        Rect r25 = new Rect();     // Catch: Exception -> L67
        r24.getGlobalVisibleRect(r25);     // Catch: Exception -> L67
        int r26 = r25.bottom;     // Catch: Exception -> L67
        Rect r27 = new Rect();     // Catch: Exception -> L67
        com.bytedance.android.livesdk.chatroom.ui.framework.d r28 = ho1.a.i(getComponentContext());     // Catch: Exception -> L67
        if (r28 == null) goto L64;
        GestureDetectLayout r29 = r28.oh();     // Catch: Exception -> L67
        if (r29 == null) goto L64;
        r29.getGlobalVisibleRect(r27);     // Catch: Exception -> L67
    L64:
        r3 = (int) Math.max(r26 - r27.bottom, 0.0d);     // Catch: Exception -> L67
    L69:
        if (r3 <= 0) goto L71;
        ALogger.i("CommentServiceWidget", "getExtraLiveBottomHeight:" + r3);
        r3 = r3 + r20;
        goto L78
    L71:
        r3 = r20;
        goto L78
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L67
    L67:
        e = move-exception;
        ALogger.e("CommentServiceWidget", "getExtraLiveBottomHeight error: " + e);
        goto L69
    L47:
        if (r17.dg() == true) goto L51;
    L78:
        if (r15 == null) goto L83;
        MutableLiveData r30 = r15.getKeyboardData();
        if (r30 == null) goto L83;
        r30.setValue(new KeyboardViewModel.a(r3));
    L83:
        if (((Widget) this).dataCenter == null) goto L89;
        bh1.b r31 = new bh1.b(r3, r9);
        PublicScreenTraceMonitor.m("CommentServiceWidget.transfer@" + r31.hashCode());
        LayerEventDispatcher r32 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));
        if (r32 == null) goto L90;
        r32.b(r31);
        return;
    L90:
        return;
    L89:
        return;
    L40:
        r15 = null;
        goto L41
    L12:
        r5 = null;
        goto L13
    L27:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r33 = this.d;
        if (r33 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r34 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r33);
    L31:
        if (r34 == null) goto L33;
        r34.f.setVisibility(8);
        goto L33
    L30:
        r34 = null;
        goto L31
    }

    public final void onMessage(tlc.d r8) {
        if (r8 == null) goto L5;
        String r0 = r8.getMessageMethod();
        if (r0 == null) goto L5;
    L7:
        if (Intrinsics.areEqual(r0, MessageType.MEMBER.getWsMethod()) == false) goto L64;
        t22.b r1 = null;
        if ((r8 instanceof com.bytedance.android.livesdk.message.model.o0) == true) goto L11;
        tlc.d r2 = null;
    L12:
        com.bytedance.android.livesdk.message.model.o0 r3 = (com.bytedance.android.livesdk.message.model.o0) r2;
        if (r3 == null) goto L21;
        Room r4 = getRoom();
        if (r4 == null) goto L17;
        long r5 = r4.getId();
    L19:
        if (r3.isCurrentRoom(r5) == true) goto L21;
        return;
    L17:
        r5 = 0;
    L21:
        if (r8 == null) goto L62;
        MemberMessage r9 = (MemberMessage) r8;
        User r6 = r9.getUser();
        long r7 = r9.getAction();
        if (r6 == null) goto L73;
        com.bytedance.android.live.base.model.user.o0.a r10 = com.bytedance.android.live.base.model.user.o0.a;
        String r11 = r6.getIdStr();
        String r12 = TTLiveSDKContext.getHostService().h().n();
        r10.getClass();
        if (com.bytedance.android.live.base.model.user.o0.a.a(r11, r12) == true) goto L27;
        return;
    L27:
        if (3 != r7) goto L29;
    L48:
        CommentContext r13 = this.e;
        if (r13 == null) goto L53;
        com.bytedance.live.datacontext.j r14 = r13.getCommentService();
        if (r14 == null) goto L53;
        r1 = (t22.b) r14.getValue();
    L53:
        if (r1 == null) goto L81;
        CommentContext r15 = this.e;
        if (r15 == null) goto L82;
        com.bytedance.live.datacontext.j r16 = r15.getCommentService();
        if (r16 == null) goto L83;
        t22.b r17 = (t22.b) r16.getValue();
        if (r17 == null) goto L84;
        r17.Xp(true);
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    L29:
        if (9 == r7) goto L48;
        if (4 != r7) goto L34;
    L35:
        CommentContext r18 = this.e;
        if (r18 == null) goto L40;
        com.bytedance.live.datacontext.j r19 = r18.getCommentService();
        if (r19 == null) goto L40;
        r1 = (t22.b) r19.getValue();
    L40:
        if (r1 == null) goto L76;
        CommentContext r20 = this.e;
        if (r20 == null) goto L77;
        com.bytedance.live.datacontext.j r21 = r20.getCommentService();
        if (r21 == null) goto L78;
        t22.b r22 = (t22.b) r21.getValue();
        if (r22 == null) goto L79;
        r22.Xp(false);
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L34:
        if (10 == r7) goto L35;
        return;
    L73:
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.MemberMessage");
    L11:
        r2 = r8;
        goto L12
    L64:
        if (Intrinsics.areEqual(r0, MessageType.SKY_EYE_ANCHOR_SET_MESSAGE.getWsMethod()) == false) goto L86;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r23 = ho1.a.d(getComponentContext());
        if (r23 != null) goto L68;
        return;
    L68:
        if (r23.dg() != true) goto L88;
        if (r8 == null) goto L72;
        int r24 = XiaoAnSettingDialog.j;
        XiaoAnSettingDialog.a.b(((Widget) this).dataCenter, getContext(), (jl) r8);
        return;
    L72:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.SkyEyeAnchorSetMessage");
    L88:
        return;
    L86:
        return;
    L5:
        r0 = "";
        goto L7
    }

    public final void Aq(i32.a r9, int r10) {
        int r0 = r9.a - r9.c;
        int r11 = r9.b;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.b;
        if (r1 == null) goto L5;
        LiveMode r2 = r1.getLiveMode();
    L6:
        boolean r4 = true;
        int r5 = 0;
        if (r2 != LiveMode.AUDIO) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L15;
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 != null) goto L14;
    L23:
        wd r7 = new wd();
        int r8 = r0 + r11;
        MiddlewareRoomContext r12 = getMiddlewareRoomContext();
        if ((r12 instanceof RoomContext) == true) goto L26;
        r12 = null;
    L26:
        RoomContext r13 = (RoomContext) r12;
        if (r13 == null) goto L29;
        boolean r14 = r13.isVSRoom();
    L30:
        if (r14 == true) goto L32;
        r8 = r8 + s1.j(2131168680);
    L32:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r15 = this.b;
        if (r15 == null) goto L35;
        boolean r16 = r15.V9();
    L36:
        if (r16 == true) goto L38;
    L70:
        r7.a = (r8 + r5) + r10;
        ((Widget) this).dataCenter.put("cmd_normal_gift_layout_bottom_margin_update", r7);
        return;
    L38:
        if (PadConfigUtils.c() == false) goto L70;
        if (e5.n() == true) goto L70;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L70;
        u1 r18 = (u1) r17.get("cmd_multi_state_change", null);
        if (r18 == null) goto L70;
        if (r18.f == 1) goto L52;
        r4 = false;
    L52:
        int r19 = r18.i;
        Boolean r20 = (Boolean) ((Widget) this).dataCenter.get("cmd_multi_room_pk_state_change", Boolean.FALSE);
        if (r4 == false) goto L60;
        if (r20.booleanValue() == true) goto L60;
        if (r19 != 4) goto L60;
        r5 = s1.f(56.0f);
    L60:
        if (r4 == true) goto L62;
    L65:
        if (r4 == false) goto L70;
        if (r20.booleanValue() == false) goto L70;
        if (r19 < 3) goto L70;
        r5 = s1.f(56.0f);
        goto L70
    L62:
        if (r20.booleanValue() == true) goto L65;
        if (r19 != 3) goto L65;
        r5 = s1.f(12.0f);
        goto L70
    L35:
        r16 = false;
        goto L36
    L29:
        r14 = false;
        goto L30
    L14:
        if (r6.currentUILayoutNeedAdjustCommentHeight(((Widget) this).dataCenter) != true) goto L23;
    L15:
        Room r21 = getRoom();
        if (r21 == null) goto L20;
        Map r22 = r21.getLinkMap();
        if (r22 == null) goto L20;
        boolean r23 = r22.containsKey(String.valueOf(1));
    L21:
        if (r23 == true) goto L23;
        return;
    L20:
        r23 = false;
        goto L21
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static final void yq(CommentServiceWidget r1, Class r2, Consumer r3) {
        r1.getClass();
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r1))).subscribe(r3);
    }
}
