package com.bytedance.android.livesdk.interactivity.medialink.widget;

import am2.x;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.anchorlink.BaseEqualLinkWidget;
import com.bytedance.android.live.anchorlink.utils.MultiChannelOptManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.MultiAnchorLinkmicRtcLiveCoreData;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.config.ka1;
import com.bytedance.android.livesdk.interactivity.medialink.contract.AnchorLinkInitType;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaMultiAnchorStartDialog;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaMultiLinkAnchorMicDialog;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaMultiLinkSelfAnchorMicDialog;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaMuteCheckDialogFragment;
import com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.ui.m;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiEnlargeWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLayoutManagerWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAnchorWindowManager;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAnchorView;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e92.k;
import fy.h;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nc0.r;
import nc0.s;
import uf2.d0;
import uf2.m1;
import uf2.z;
import vlc.l;
import zg1.a1;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaMultiLinkAnchorWidget;", "Lcom/bytedance/android/live/anchorlink/BaseEqualLinkWidget;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAnchorView;", "Lx82/b;", BuildConfig.FLAVOR, "Lvlc/l;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorWidget extends BaseEqualLinkWidget<AnchorLinkUser> implements IMediaMultiLinkAnchorView, x82.b, l {
    public j0 A;
    public k B;
    public MediaMultiAnchorLinkContext C;
    public CommonBottomDialog D;
    public final Rect E;
    public final GestureDetector F;
    public final c G;
    public final b H;
    public final d I;
    public vlc.d J;
    public final v0 K;
    public final e92.l h;
    public final nc0.b i;
    public com.bytedance.android.livesdk.interactivity.medialink.contract.d j;
    public f92.c k;
    public hy.e l;
    public MediaMultiLinkAnchorWindowManager m;
    public com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.a n;
    public long o;
    public Runnable p;
    public int q;
    public boolean r;
    public MediaMultiAnchorStartDialog s;
    public MultiAnchorLinkmicRtcLiveCoreData t;
    public MediaInteractCommentWidget u;
    public MultiChannelOptManager v;
    public final CompositeDisposable w;
    public MediaMultiLayoutManagerWidget x;
    public MediaMultiEnlargeWidget y;
    public m z;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ MediaMultiLinkAnchorWidget a;

        public a(MediaMultiLinkAnchorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            int r5 = e92.d.a;
            if (e92.m.h() != 4) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L8;
            MediaMultiLinkAnchorWidget r7 = this.a;
            r7.getClass();
            int r0 = MediaMultiLinkSelfAnchorMicDialog.b;
            r7.D = MediaMultiLinkSelfAnchorMicDialog.a.a(((Widget) r7).context, ey.c.b());
        L8:
            return true;
        L5:
            r6 = false;
            goto L6
        }
    }

    public static final class b extends ey.d {
        public final /* synthetic */ MediaMultiLinkAnchorWidget a;

        public b(MediaMultiLinkAnchorWidget r1) {
            this.a = r1;
        }

        public final void qe(if r6) {
            Intrinsics.checkNotNullParameter(r6, "linkerMessage");
            Intrinsics.checkNotNullParameter(r6, "linkerMessage");
            LinkerReplyContent r0 = r6.mReply;
            if (r0 == null) goto L32;
            boolean r2 = true;
            if (r0.replyStatus != 1) goto L37;
            MultiChannelInfo r1 = r0.multiChannelInfo;
            if (r1 == null) goto L33;
            ALogger.w("MediaLinkTracer", "MediaMultiAnchorLinkWidget onReceiveReply " + r1);
            if (r1.getUseMultiChannel() == false) goto L34;
            Map r3 = r1.getChannelMap();
            if (r3 != null) goto L14;
        L17:
            if (r2 == true) goto L35;
            MediaMultiAnchorLinkContext r4 = this.a.C;
            if (r4 == null) goto L25;
            LinkerReplyContent r7 = r6.mReply;
            if (r7 == null) goto L23;
            MultiChannelInfo r8 = r7.multiChannelInfo;
        L24:
            MediaMultiAnchorLinkContext.setMultiChannelInfo$default(r4, r8, false, 2, null);
            goto L25
        L23:
            r8 = null;
        L25:
            gy.f r9 = ((BaseEqualLinkWidget) this.a).c;
            if (r9 == null) goto L28;
            Map r5 = r1.getChannelMap();
            Intrinsics.checkNotNull(r5);
            r9.g(r5, "onReceiveReply");
        L28:
            MultiChannelOptManager r10 = this.a.v;
            if (r10 == null) goto L36;
            MultiChannelOptManager.c(r10);
            return;
        L36:
            return;
        L35:
            return;
        L14:
            if (r3.isEmpty() == true) goto L17;
            r2 = false;
            goto L17
        L34:
            return;
        L33:
            return;
        L37:
            return;
        }
    }

    public static final class c extends hy.f.a {
        public final /* synthetic */ MediaMultiLinkAnchorWidget a;

        public c(MediaMultiLinkAnchorWidget r1) {
            this.a = r1;
        }

        public final void d(int r3, List<AnchorLinkUser> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            if ((!r4.isEmpty()) == false) goto L8;
            CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) r4;
            int r6 = r5.size();
            MediaMultiLinkAnchorWidget r0 = this.a;
            if (r6 <= r0.q) goto L9;
            r0.q = r5.size();
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ MediaMultiLinkAnchorWidget a;

        public d(MediaMultiLinkAnchorWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            MultiChannelInfo r4 = (MultiChannelInfo) r3;
            MediaMultiAnchorLinkContext r0 = this.a.C;
            if (r0 == null) goto L6;
            r0.setMultiChannelInfo(r4, true);
            return;
        }
    }

    @Override // x82.b
    public final void D6() {
        Intrinsics.checkNotNullParameter("linkUserUpdate", "reqSrc");
    }

    public final void S2(String r1, Object r2, int r3, int r4) {
    }

    public final int getLayoutId() {
        return 2131566917;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final int getScene() {
        return 17;
    }

    public final String getSpm() {
        return "a100.a100.a199";
    }

    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public final void Bq() {
        MediaMultiAnchorStartDialog r0 = this.s;
        if (r0 != null) goto L5;
    L9:
        hy.e r1 = this.l;
        if (r1 == null) goto L14;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L14;
        int r3 = r2.size();
    L15:
        int r4 = w82.b.a;
        HashMap r5 = new HashMap();
        r5.put("channel_id", String.valueOf(e92.m.b()));
        r5.put("room_status", "connection");
        r5.put("anchor_cnt", String.valueOf(r3));
        r5.put("from_media", "1");
        u.l().sendLog("livesdk_connection_icon_click", r5, new Object[]{Room.class});
        MediaMultiAnchorStartDialog r6 = new MediaMultiAnchorStartDialog();
        this.s = r6;
        p8.a(r6, ((Widget) this).context);
        return;
    L14:
        r3 = 0;
        goto L15
    L5:
        if (r0.isShowing() != true) goto L9;
        MediaMultiAnchorStartDialog r7 = this.s;
        if (r7 == null) goto L9;
        Aq(r7);
        goto L9
    }

    public final String Eq() {
        nc0.b r0 = this.i;
        if (r0 == null) goto L9;
        LiveData r1 = r0.c();
        if (r1 == null) goto L9;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L9;
        String r3 = r2.e;
    L11:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        return r3;
    L13:
        hy.e r4 = this.l;
        if (r4 == null) goto L43;
        List r5 = r4.getOnlineUserList();
        if (r5 == null) goto L44;
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L35;
        Object r7 = r6.next();
        IBaseUser r8 = ((AnchorLinkUser) r7).getUser();
        if (r8 == null) goto L23;
        String r9 = r8.getIdString();
    L24:
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L31;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L31;
        Room r13 = (Room) r11.getValue();
        if (r13 == null) goto L31;
        String r14 = r13.getOwnerUserIdString();
    L33:
        if (Intrinsics.areEqual(r9, r14) == false) goto L19;
    L36:
        AnchorLinkUser r15 = (AnchorLinkUser) r7;
        if (r15 != null) goto L39;
        return null;
    L39:
        return r15.getInteractId();
    L31:
        r14 = null;
        goto L33
    L23:
        r9 = null;
        goto L24
    L35:
        r7 = null;
        goto L36
    L44:
        return null;
    L43:
        return null;
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAnchorView
    public final void ZU() {
        MultiChannelInfo r0 = MediaMultiAnchorLinkContext.Companion.c();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUseMultiChannel() == false) goto L13;
        Map r1 = r0.getChannelMap();
        if (r1 == null) goto L14;
        gy.f r2 = ((BaseEqualLinkWidget) this).c;
        if (r2 == null) goto L15;
        r2.g(r1, "updateMultiChannelMsg");
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // x82.b
    public final void f() {
        gy.f r0 = ((BaseEqualLinkWidget) this).c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineOn() == false) goto L9;
        r0.f();
        return;
    }

    public final void onCreate() {
        if (((Widget) this).widgetCallback != null) goto L5;
        return;
    L5:
        super.onCreate();
        ALogger.e("MediaLinkTracer", "MultiLinkAnchorWidget onCreate");
        Map<Long, String> r2 = null;
        if (this.j != null) goto L12;
        x82.a.t2.getClass();
        x82.a r1 = x82.a.C0295a.a();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r3 = r1.getConnectionContext();
    L11:
        this.j = r3;
        goto L12
    L10:
        r3 = null;
    L12:
        vlc.d r4 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.J = r4;
        if (r4 == null) goto L15;
        r4.addMessageListener(MessageType.LINKER.getIntType(), this);
    L15:
        Pair r5 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        MediaMultiAnchorLinkContext r6 = (MediaMultiAnchorLinkContext) r5.getFirst();
        r6.getConnectionContext().setValue(this.j);
        r6.getService().d(this);
        r6.getCommonService().d(this);
        r6.setLaunchParameters(this.h);
        com.bytedance.live.datacontext.b.a(r6, MediaMultiAnchorLinkContext.class);
        Unit r7 = Unit.INSTANCE;
        this.C = r6;
        this.w.add((Disposable) r5.getSecond());
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.a r8 = new com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.a(this.C);
        r8.g0(this);
        this.n = r8;
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r9 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r9 == null) goto L18;
        hy.e r10 = r9.Np();
    L19:
        if (r10 == null) goto L21;
        r10.i(this.G);
    L22:
        this.l = r10;
        gy.f r11 = ((BaseEqualLinkWidget) this).c;
        Room r13 = ((BaseEqualLinkWidget) this).a;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L25:
        m r14 = new m(r11, r10, r13, ((Widget) this).context);
        gy.f r15 = r14.f;
        if (r15 == null) goto L30;
        s r16 = r15.L();
        if (r16 == null) goto L30;
        r14.d.addAll(r16.b());
    L30:
        ((ArrayList) r14.b).clear();
        this.z = r14;
        this.B = new k(((Widget) this).context);
        MediaMultiAnchorLinkContext r17 = this.C;
        if (r17 == null) goto L46;
        hy.e r18 = this.l;
        if (r18 == null) goto L46;
        enableSubWidgetManager();
        Room r19 = ((BaseEqualLinkWidget) this).a;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L38:
        MediaMultiEnlargeWidget r20 = new MediaMultiEnlargeWidget(r18, r19.getRoomId());
        this.y = r20;
        RecyclableWidgetManager r21 = ((Widget) this).subWidgetManager;
        if ((r21 instanceof RecyclableWidgetManager) == true) goto L41;
        RecyclableWidgetManager r23 = null;
    L42:
        RecyclableWidgetManager r24 = r23;
        if (r24 == null) goto L45;
        r24.h = true;
    L45:
        r21.load(r20);
        r17.getEnlargeService().d(this.y);
        goto L46
    L41:
        r23 = r21;
    L46:
        final MediaMultiLinkAnchorWindowManager r25 = new MediaMultiLinkAnchorWindowManager((FrameLayout) ((Widget) this).contentView.findViewById(2131393289), RoomContext.a.c(RoomContext.Companion, null, 0, 3), ((Widget) this).dataCenter, this.l, ((BaseEqualLinkWidget) this).c, this.y, this.C, this);
        ALogger.i("ttlive_media_anchor_link_wm", "start");
        r25.l = (Room) r25.v.get("data_room", new Room());
        hy.e r26 = r25.w;
        if (r26 == null) goto L49;
        r26.i(r25);
    L49:
        r25.k.add(xs2.b.a().b(h1.class).subscribe(new com.bytedance.android.livesdk.interactivity.medialink.ui.window.c(r25)));
        r25.v.observeForever("DATA_IS_HIDE_INTERACTION", r25);
        r25.j = new MediaMultiAnchorTitleView(r25.t.getContext());
        RoomContext r27 = r25.u;
        if (r27 == null) goto L58;
        com.bytedance.live.datacontext.m r28 = r27.getCleanMode();
        if (r28 == null) goto L58;
        Observable r29 = r28.a();
        if (r29 == null) goto L58;
        Disposable r30 = r29.subscribe(new com.bytedance.android.livesdk.interactivity.medialink.ui.window.d(r25));
        if (r30 == null) goto L58;
        RxUtilKt.c(r30, r25.k);
    L58:
        this.u = new MediaInteractCommentWidget(new MediaMultiLinkAnchorWidget$onCreate$8$1(r25));
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(this.u);
        this.m = r25;
        ALogger.w("MediaLinkTracer", "MultiLinkAnchorWidget onCreate " + this.j);
        hy.e r31 = this.l;
        if (r31 == null) goto L61;
        r31.b(4, "multi_anchor_link_widget_create");
    L61:
        nc0.b r33 = this.i;
        if (r33 == null) goto L64;
        r33.b(17, this.H);
    L64:
        this.o = System.currentTimeMillis();
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r34 = this.j;
        if (r34 == null) goto L90;
        AnchorLinkInitType r35 = r34.a;
        if (r35 != AnchorLinkInitType.REPLY_AGREE_API) goto L69;
    L72:
        boolean r36 = true;
    L73:
        if (r36 == false) goto L75;
    L78:
        boolean r37 = true;
    L79:
        if (r37 != true) goto L90;
        int r38 = w82.b.a;
        LinkedHashMap r39 = new LinkedHashMap();
        MediaLinkContext r40 = MediaLinkContext.Companion.getContext();
        if (r40 == null) goto L88;
        i<w82.a> r41 = r40.getLogParams();
        if (r41 == null) goto L88;
        w82.a r43 = (w82.a) r41.getValue();
        if (r43 == null) goto L88;
        String r44 = String.valueOf(r43.b);
        if (r44 == null) goto L88;
    L89:
        r39.put("invitee_id", r44);
        r39.put("channel_id", String.valueOf(e92.m.b()));
        w82.b.c(r39);
        u.l().sendLog("livesdk_connection_success", r39, new Object[]{Room.class, x.class});
    L88:
        r44 = BuildConfig.FLAVOR;
        goto L89
    L75:
        if (r34.c == true) goto L78;
        r37 = false;
        goto L79
    L69:
        if (r35 == AnchorLinkInitType.REPLY_AGREE_MSG) goto L72;
        r36 = false;
    L90:
        gy.f r45 = ((BaseEqualLinkWidget) this).c;
        if (r45 != null) goto L93;
    L178:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L181;
        r0.put("cmd_update_sticker_visible", Boolean.FALSE);
    L181:
        gy.f r46 = ((BaseEqualLinkWidget) this).c;
        MediaMultiAnchorLinkContext.Companion.a();
        MultiChannelOptManager r47 = new MultiChannelOptManager(r46);
        this.v = r47;
        MutableLiveData r48 = r47.g;
        if (r48 == null) goto L184;
        r48.observeForever(this.I);
    L184:
        MediaMultiAnchorLinkContext r49 = this.C;
        if (r49 == null) goto L236;
        MediaMultiLinkAnchorWindowManager r50 = this.m;
        if (r50 == null) goto L240;
        gy.f r51 = ((BaseEqualLinkWidget) this).c;
        if (r51 == null) goto L241;
        enableSubWidgetManager();
        MediaMultiLayoutManagerWidget r53 = new MediaMultiLayoutManagerWidget(r50, r51);
        this.x = r53;
        RecyclableWidgetManager r54 = ((Widget) this).subWidgetManager;
        if ((r54 instanceof RecyclableWidgetManager) == true) goto L195;
        RecyclableWidgetManager r55 = null;
    L196:
        RecyclableWidgetManager r56 = r55;
        if (r56 == null) goto L199;
        r56.h = true;
    L199:
        r54.load(r53);
        r49.getLayoutService().d(this.x);
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r57 = this.j;
        if (r57 == null) goto L237;
        MultiLiveCoreInfo r58 = r57.f;
        if (r58 == null) goto L238;
        MediaMultiLayoutManagerWidget r59 = this.x;
        if (r59 == null) goto L215;
        MultiRtcInfo r60 = r57.g;
        if (r60 == null) goto L210;
        MultiAnchorLinkmicRtcInfo r61 = r60.mMultiAnchorLinkmicRtcInfo;
        if (r61 == null) goto L210;
        Map<Long, String> r63 = r61.pushStreamModeRTCMap;
    L211:
        MultiAnchorLinkmicLiveCoreInfo r64 = r58.multiAnchorLiveCoreInfo;
        if (r64 == null) goto L214;
        r2 = r64.pushStreamModeLiveCoreMap;
    L214:
        r59.xq(r63, r2, "switch_scene", BuildConfig.FLAVOR);
    L210:
        r63 = null;
    L215:
        MediaMultiLayoutManagerWidget r65 = this.x;
        if (r65 == null) goto L239;
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r66 = this.j;
        if (r66 == null) goto L220;
        long r67 = r66.h;
    L222:
        if (((int) r67) == 1) goto L224;
        UILayout r68 = UILayout.Normal;
    L225:
        r65.j = r68;
        return;
    L224:
        r68 = UILayout.Enlarge;
        goto L225
    L220:
        r67 = UILayout.Normal.ordinal();
        goto L222
    L239:
        return;
    L238:
        return;
    L237:
        return;
    L195:
        r55 = r54;
        goto L196
    L241:
        return;
    L240:
        return;
    L236:
        return;
    L93:
        if (r45.isEngineOn() != true) goto L178;
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(7));
        gy.f r69 = ((BaseEqualLinkWidget) this).c;
        if (r69 == null) goto L98;
        r69.a(InteractMode.MULTI_ANCHOR);
    L98:
        if (this.k != null) goto L100;
        this.k = new f92.c(this.m, ((BaseEqualLinkWidget) this).c, this.l);
    L100:
        f92.c r70 = this.k;
        if (r70 == null) goto L112;
        gy.f r71 = ((BaseEqualLinkWidget) this).c;
        if (r71 == null) goto L106;
        r71.d(r70);
    L106:
        if (r70.e != null) goto L112;
        gy.f r73 = r70.h;
        if (r73 == null) goto L110;
        com.bytedance.android.live.revenuelink.e r74 = r73.P();
    L111:
        r70.e = r74;
        goto L112
    L110:
        r74 = null;
    L112:
        gy.f r75 = ((BaseEqualLinkWidget) this).c;
        if (r75 == null) goto L115;
        r75.m(this);
    L115:
        String r76 = Eq();
        gy.f r77 = ((BaseEqualLinkWidget) this).c;
        if (r77 != null) goto L118;
    L130:
        MediaMultiLinkAnchorWindowManager r78 = this.m;
        if (r78 == null) goto L133;
        r78.x(r76, null, "rtcAlreadyStarted");
    L133:
        StringBuilder r79 = new StringBuilder("onRtcAlreadyStartedOnCreate ");
        MediaMultiAnchorLinkContext.a r80 = MediaMultiAnchorLinkContext.Companion;
        r79.append(r80.c());
        ALogger.i("MediaLinkTracer", r79.toString());
        MultiChannelInfo r81 = r80.c();
        if (r81 != null) goto L136;
    L142:
        StringBuilder r83 = new StringBuilder("rtc removeViewMap ");
        gy.f r84 = ((BaseEqualLinkWidget) this).c;
        if (r84 == null) goto L145;
        s r85 = r84.L();
    L146:
        r83.append(r85);
        ALogger.w("MediaLinkTracer", r83.toString());
        gy.f r86 = ((BaseEqualLinkWidget) this).c;
        if (r86 == null) goto L178;
        s r87 = r86.L();
        if (r87 == null) goto L178;
        Map r88 = r87.c();
        if (r88 == null) goto L178;
        HashMap r89 = (HashMap) r88;
        Iterator r90 = r89.keySet().iterator();
    L154:
        if (r90.hasNext() == false) goto L166;
        String r91 = (String) r90.next();
        Object r93 = r89.get(r91);
        onUserJoined(r91);
        if ((r93 instanceof SurfaceView) == true) goto L157;
        if ((r93 instanceof TextureView) == true) goto L160;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r94 = ILiveWrappedLivePusher.a.b();
        if (r94 == null) goto L164;
        z.a r95 = r94.buildLayerControlLayer(r93);
    L165:
        b4(r91, r95, 0, 0);
        goto L154
    L164:
        r95 = null;
        goto L165
    L160:
        TextureView r96 = (TextureView) r93;
        L0(r91, r96, 0, 0);
        j0(r91, r96, 0, 0);
        goto L154
    L157:
        SurfaceView r97 = (SurfaceView) r93;
        h1(r91, r97, 0, 0);
        y0(r91, r97, 0, 0);
        goto L154
    L166:
        gy.f r98 = ((BaseEqualLinkWidget) this).c;
        if (r98 == null) goto L171;
        s r99 = r98.L();
        if (r99 == null) goto L171;
        List r100 = r99.a();
    L173:
        if (this.j == null) goto L175;
        r100.size();
        r89.size();
    L175:
        Object r101 = CollectionsKt.firstOrNull(r89.values());
        if (r101 == null) goto L178;
        boolean r102 = r101 instanceof TextureView;
    L171:
        r100 = CollectionsKt.emptyList();
        goto L173
    L145:
        r85 = null;
        goto L146
    L136:
        if (r81.getUseMultiChannel() == false) goto L142;
        Map r103 = r81.getChannelMap();
        if (r103 == null) goto L142;
        gy.f r104 = ((BaseEqualLinkWidget) this).c;
        if (r104 == null) goto L142;
        r104.g(r103, "onCreateRtcOn");
        goto L142
    L118:
        if (r77.G() != true) goto L130;
        MediaMultiLinkAnchorWindowManager r105 = this.m;
        if (r105 == null) goto L133;
        v0 r106 = this.K;
        if (r106 == null) goto L128;
        d0 r107 = r106.A();
        if (r107 == null) goto L128;
        z r108 = r107.C();
        if (r108 == null) goto L128;
        z.a r109 = r108.K0();
    L129:
        r105.y(r76, r109, "rtcAlreadyStarted");
    L128:
        r109 = null;
        goto L129
    L21:
        r10 = null;
        goto L22
    L18:
        r10 = null;
        goto L19
    }

    public final void onPause() {
        gy.f r0 = ((BaseEqualLinkWidget) this).c;
        if (r0 == null) goto L5;
        r0.onPause();
    L5:
        gy.f r1 = ((BaseEqualLinkWidget) this).c;
        if (r1 == null) goto L8;
        r1.muteLocalVideo(true);
    L8:
        hy.e r2 = this.l;
        if (r2 == null) goto L11;
        r2.v();
    L11:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void o() {
        String r0 = Eq();
        gy.f r1 = ((BaseEqualLinkWidget) this).c;
        z.a r4 = null;
        if (r1 != null) goto L5;
    L16:
        MediaMultiLinkAnchorWindowManager r2 = this.m;
        if (r2 == null) goto L19;
        r2.x(r0, null, "rtcStartSuccess");
    L19:
        MultiChannelInfo r3 = MediaMultiAnchorLinkContext.Companion.c();
        if (r3 == null) goto L38;
        ALogger.w("MediaLinkTracer", "MultiLinkAnchorWidget onRtcStartSuccess " + r3);
        if (r3.getUseMultiChannel() == true) goto L24;
        return;
    L24:
        if (((Boolean) ka1.a.getValue()).booleanValue() == true) goto L40;
        gy.f r5 = ((BaseEqualLinkWidget) this).c;
        if (r5 != null) goto L28;
    L29:
        Map r6 = r3.getChannelMap();
        if (r6 == null) goto L34;
        gy.f r7 = ((BaseEqualLinkWidget) this).c;
        if (r7 == null) goto L34;
        r7.b(r6);
    L34:
        MultiChannelOptManager r8 = this.v;
        if (r8 == null) goto L42;
        MultiChannelOptManager.c(r8);
        return;
    L42:
        return;
    L28:
        if (r5.g0() != true) goto L29;
        return;
    L40:
        return;
    L38:
        return;
    L5:
        if (r1.G() != true) goto L16;
        MediaMultiLinkAnchorWindowManager r9 = this.m;
        if (r9 == null) goto L19;
        v0 r10 = this.K;
        if (r10 == null) goto L15;
        d0 r11 = r10.A();
        if (r11 == null) goto L15;
        z r13 = r11.C();
        if (r13 == null) goto L15;
        r4 = r13.K0();
    L15:
        r9.y(r0, r4, "rtcStartSuccess");
        goto L19
    }

    public final void onDestroy() {
        super.onDestroy();
        Integer r0 = (Integer) ((Widget) this).dataCenter.get("cmd_stop_live_broadcast");
        if (r0 == null) goto L36;
        int r1 = r0.intValue();
        MediaMultiAnchorLinkContext r5 = this.C;
        if (r5 == null) goto L36;
        com.bytedance.live.datacontext.m<dy.a> r6 = r5.getUnloadSource();
        if (r6 == null) goto L36;
        int r7 = com.bytedance.android.live.pushstream.g.a;
        if (r1 == 1) goto L34;
        if (r1 == 2) goto L33;
        if (r1 == 3) goto L32;
        if (r1 != 6) goto L15;
        String r2 = "push stream error";
    L35:
        r6.setValue(new dy.a.c(r2));
        goto L36
    L15:
        if (r1 == 7) goto L30;
        switch(r1) {
            case 100: goto L29;
            case 101: goto L28;
            case 102: goto L27;
            case 103: goto L26;
            case 104: goto L25;
            case 105: goto L24;
            case 106: goto L23;
            case 107: goto L22;
            case 108: goto L21;
            case 109: goto L20;
            case 110: goto L19;
            case 111: goto L18;
            default: goto L17;
        };
    L17:
        r2 = String.valueOf(r1);
        goto L35
    L18:
        r2 = "anchor pause over time";
        goto L35
    L19:
        r2 = "background over time";
        goto L35
    L20:
        r2 = "receive notice message review rejected";
        goto L35
    L21:
        r2 = "receive notice message emergency end";
        goto L35
    L22:
        r2 = "receive notice message elderly block";
        goto L35
    L23:
        r2 = "receive notice message elderly remind";
        goto L35
    L24:
        r2 = "receive notice message block";
        goto L35
    L25:
        r2 = "receive member message kick out";
        goto L35
    L26:
        r2 = "control message room ban";
        goto L35
    L27:
        r2 = "control message room end";
        goto L35
    L28:
        r2 = "anchor/ping_30003";
        goto L35
    L29:
        r2 = "anchor/ping 30001";
        goto L35
    L30:
        r2 = "pause ping time out";
        goto L35
    L32:
        r2 = "ban by operator";
        goto L35
    L33:
        r2 = " other device enter live";
        goto L35
    L34:
        r2 = "close normal";
    L36:
        StringBuilder r3 = new StringBuilder("MediaMultiLinkAnchorWidget onDestroy channelId:");
        r3.append(MediaMultiAnchorLinkContext.Companion.a());
        r3.append(" rtc:");
        gy.f r8 = ((BaseEqualLinkWidget) this).c;
        if (r8 == null) goto L39;
        Boolean r9 = Boolean.valueOf(r8.isEngineOn());
    L40:
        r3.append(r9);
        ALogger.w("MediaLinkTracer", r3.toString());
        vlc.d r4 = this.J;
        if (r4 == null) goto L43;
        r4.removeMessageListener(this);
    L43:
        nc0.b r10 = this.i;
        if (r10 == null) goto L46;
        r10.a(17, this.H);
    L46:
        m r11 = this.z;
        if (r11 == null) goto L61;
        r11.a.clear();
        ((ArrayList) r11.b).clear();
        MediaMuteCheckDialogFragment r13 = r11.c;
        if (r13 != null) goto L51;
    L60:
        r11.d.clear();
        r11.f = null;
        r11.g = null;
        r11.h = null;
        r11.i = null;
        goto L61
    L51:
        if (r13.isShowing() != true) goto L60;
        MediaMuteCheckDialogFragment r14 = r11.c;
        if (r14 == null) goto L60;
        r14.dismiss();     // Catch: Exception -> L56
    L56:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L60;
        com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L61:
        k r16 = this.B;
        if (r16 == null) goto L71;
        x0 r17 = r16.a;
        if (r17 != null) goto L66;
    L70:
        r16.b.clear();
        r16.d = null;
        goto L71
    L66:
        if (r17.isShowing() != true) goto L70;
        x0 r18 = r16.a;
        if (r18 == null) goto L70;
        k.a(r18);
    L71:
        CommonBottomDialog r19 = this.D;
        if (r19 == null) goto L90;
        Handler r20 = DialogLancet.resolveDialogHandler(r19);
        if (r20 != null) goto L76;
    L78:
        DialogLancet.beforeDialogDismiss(r19);
        r19.dismiss();     // Catch: Throwable -> L81 Exception -> L83
    L87:
        DialogLancet.afterDialogDismiss(r19);
        goto L90
    L81:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r19);
        throw th;
    L83:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L81
        Throwable r21 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L81
        if (r21 == null) goto L87;
        com.bytedance.crash.d.d(r21, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L81
        goto L87
    L76:
        if (Looper.myLooper() == r20.getLooper()) goto L78;
        r20.post(DialogLancet.createDismissRunnable(r19));
    L90:
        MultiChannelOptManager r23 = this.v;
        if (r23 == null) goto L95;
        MutableLiveData r24 = r23.g;
        if (r24 == null) goto L95;
        r24.removeObserver(this.I);
    L95:
        MultiChannelOptManager r25 = this.v;
        if (r25 == null) goto L101;
        gy.f r26 = r25.i;
        if (r26 == null) goto L100;
        r26.e(r25.h);
    L100:
        r25.d.dispose();
    L101:
        hy.e r27 = this.l;
        if (r27 == null) goto L104;
        r27.j();
    L104:
        MediaMultiAnchorStartDialog r28 = this.s;
        if (r28 != null) goto L107;
    L111:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r29 = ILiveWrappedLivePusher.a.b();
        if (r29 == null) goto L124;
        m1.b r30 = r29.newVideoMixerDescription(null);
        if (r30 == null) goto L124;
        r30.i();
        r30.e();
        r30.b();
        r30.c();
        r30.f();
        r30.g();
        v0 r31 = this.K;
        if (r31 == null) goto L124;
        d0 r33 = r31.A();
        if (r33 == null) goto L124;
        z r34 = r33.C();
        if (r34 == null) goto L124;
        z.a r35 = r34.K0();
        if (r35 == null) goto L124;
        r35.b();
    L124:
        gy.f r36 = ((BaseEqualLinkWidget) this).c;
        if (r36 == null) goto L142;
        if (r36.isEngineOn() == false) goto L142;
        r36.j("anchorLinkFinish");
        MultiAnchorLinkmicRtcLiveCoreData r37 = this.t;
        if (r37 == null) goto L142;
        MultiLiveCoreInfo r38 = r37.getMLiveCoreInfo();
        if (r38 == null) goto L142;
        MultiAnchorLinkmicLiveCoreInfo r39 = r38.multiAnchorLiveCoreInfo;
        if (r39 == null) goto L142;
        Map r40 = r39.liveCoreExtInfoMap;
        if (r40 == null) goto L142;
        String r41 = (String) r40.get(0L);
        if (r41 == null) goto L142;
        gy.f r43 = ((BaseEqualLinkWidget) this).c;
        if (r43 == null) goto L142;
        gy.f.a.a(r43, r41);
    L142:
        if (((BaseEqualLinkWidget) this).e == true) goto L144;
        BaseEqualLinkWidget.xq(this, "unusual_leave", false, 6);
    L144:
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.a r44 = this.n;
        if (r44 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L147:
        r44.detachView();
        if (this.r == true) goto L150;
        w82.b.d(this.o, e92.m.b(), this.q);
    L150:
        hy.e r45 = this.l;
        if (r45 == null) goto L153;
        r45.clear(false);
    L153:
        hy.e r46 = this.l;
        if (r46 == null) goto L156;
        r46.h(this.G);
    L156:
        MediaMultiLinkAnchorWindowManager r47 = this.m;
        if (r47 == null) goto L165;
        ALogger.i("ttlive_media_anchor_link_wm", "end");
        Disposable r48 = r47.p;
        if (r48 == null) goto L161;
        r48.dispose();
    L161:
        r47.k.dispose();
        r47.v.removeObserver(r47);
        hy.e r49 = r47.w;
        if (r49 == null) goto L164;
        r49.h(r47);
    L164:
        r47.b.clear();
        r47.t.removeAllViews();
        r47.n.clear();
        u1 r50 = new u1();
        r50.f = 2;
        r47.v.put("cmd_multi_state_change", r50);
    L165:
        DataCenter r51 = ((Widget) this).dataCenter;
        if (r51 == null) goto L168;
        r51.put("cmd_update_sticker_visible", Boolean.TRUE);
    L168:
        RoomContext r53 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r53 == null) goto L173;
        com.bytedance.live.datacontext.k r54 = r53.getAnchorLinkMicFinishEvent();
        if (r54 == null) goto L173;
        r54.post(new zg1.d(17, false, false, 2));
    L173:
        this.w.clear();
        f92.c r55 = this.k;
        if (r55 == null) goto L185;
        com.bytedance.android.live.revenuelink.e r56 = r55.e;
        if (r56 == null) goto L178;
        r56.dispose();
    L178:
        r55.f = false;
        return;
    L185:
        return;
    L107:
        if (r28.isShowing() != true) goto L111;
        MediaMultiAnchorStartDialog r57 = this.s;
        if (r57 == null) goto L111;
        Aq(r57);
        goto L111
    L39:
        r9 = null;
        goto L40
    }

    public final void onResume() {
        super.onResume();
        gy.f r0 = ((BaseEqualLinkWidget) this).c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineOn() != true) goto L11;
        gy.f r1 = ((BaseEqualLinkWidget) this).c;
        if (r1 == null) goto L12;
        r1.muteLocalVideo(false);
        return;
    L12:
        return;
    }

    @Override // x82.b
    public final m getMuteManager() {
        return this.z;
    }

    public final hy.e wq() {
        return this.l;
    }

    @Override // x82.b
    public final MediaMultiLinkAnchorWindowManager yn() {
        return this.m;
    }

    public static void Aq(LiveDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void Cq(String r7) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        MediaMultiAnchorLinkContext.a r0 = MediaMultiAnchorLinkContext.Companion;
        if (r0.a() <= 0) goto L8;
        this.p = null;
        ((BaseEqualLinkWidget) this).e = true;
        ey.i r1 = ((BaseEqualLinkWidget) this).b;
        if (r1 == null) goto L7;
        r1.b(new fy.d(e92.m.b(), 17, r7));
    L7:
        r0.a();
        return;
    L8:
        MediaMultiAnchorLinkContext r2 = this.C;
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.m<dy.a> r3 = r2.getUnloadSource();
        if (r3 == null) goto L13;
        r3.setValue(new dy.a.d(r7));
    L13:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r8 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r8 == null) goto L18;
        r8.K4(256);
        return;
    }

    public final void Z2(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
        Intrinsics.checkNotNullParameter(r2, "finishParams");
    }

    public final void onMessage(tlc.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof if) == false) goto L38;
        if r11 = (if) r10;
        if (r11.getMType() != 7) goto L39;
        hy.e r0 = this.l;
        if (r0 == null) goto L40;
        LinkerLeaveContent r1 = r11.mLeave;
        String r2 = null;
        if (r1 == null) goto L13;
        String r3 = r1.getUserIdStr();
    L14:
        AnchorLinkUser r4 = r0.getGuestInfo(r3, BuildConfig.FLAVOR);
        if (r4 == null) goto L41;
        AnchorLinkUser r5 = jm2.a.d(r4);
        if (r5 == null) goto L37;
        AnchorLinkUser r6 = r5;
        LinkerLeaveContent r13 = r11.mLeave;
        Intrinsics.checkNotNullParameter(r6, "leaveAnchor");
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L42;
        x82.a.t2.getClass();
        x82.a r8 = x82.a.C0295a.a();
        if (r8 != null) goto L23;
    L30:
        o0.a r14 = o0.a;
        User r9 = r6.getMUser();
        if (r9 == null) goto L33;
        r2 = r9.getIdStr();
    L33:
        String r15 = ey.c.b();
        r14.getClass();
        if (o0.a.a(r2, r15) == true) goto L43;
        f2.c(s1.C(2131920253, new Object[]{r7.getNickName()}), 0);
        return;
    L43:
        return;
    L23:
        if (r8.N(ey.c.b()) != true) goto L30;
        if (r13 == null) goto L26;
        Integer r16 = Integer.valueOf(r13.getLeaveSource());
    L28:
        if (r16.intValue() != LinkerLeaveContent.LeaveSource.AnchorLeaveSourceOrganizerKickOut.ordinal()) goto L30;
        return;
    L26:
        r16 = null;
        goto L28
    L42:
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L41:
        return;
    L13:
        r3 = null;
        goto L14
    L40:
        return;
    L39:
        return;
    }

    public final void p2(fi6.a r6) {
        gy.f r0 = ((BaseEqualLinkWidget) this).c;
        if (r0 == null) goto L7;
        d0 r1 = r0.getLiveCore();
        if (r1 == null) goto L7;
        r1.s();
    L7:
        gy.f r2 = ((BaseEqualLinkWidget) this).c;
        if (r2 == null) goto L12;
        d0 r3 = r2.getLiveCore();
        if (r3 == null) goto L12;
        r3.o0();
    L12:
        if (r6 == null) goto L14;
        r6.Z = true;
    L14:
        MediaMultiLinkAnchorWindowManager r4 = this.m;
        gy.f r5 = ((BaseEqualLinkWidget) this).c;
        f92.c r7 = new f92.c(r4, r5, this.l);
        this.k = r7;
        String r8 = null;
        if (r7.e != null) goto L20;
        if (r5 == null) goto L18;
        com.bytedance.android.live.revenuelink.e r9 = r5.P();
    L19:
        r7.e = r9;
        goto L20
    L18:
        r9 = null;
    L20:
        if (r6 == null) goto L22;
        r6.f = this.k;
    L22:
        if (r6 == null) goto L24;
        r6.f(LinkConstant.STREAM_BACKGROUND);
    L24:
        if (r6 == null) goto L32;
        Room r10 = ((BaseEqualLinkWidget) this).a;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L28:
        StreamUrl r11 = r10.getStreamUrl();
        if (r11 == null) goto L31;
        r8 = r11.getRtmpPushUrl();
    L31:
        r6.e = r8;
    L32:
        if (r6 == null) goto L34;
        r6.o(new qi6.g(272, 480, 15, 500));
    L34:
        if (r6 == null) goto L36;
        r6.g(Character.ANCHOR);
    L36:
        if (r6 == null) goto L38;
        r6.d = 19;
    L38:
        if (r6 == null) goto L40;
        r6.n(StreamType.VIDEO);
    L40:
        if (r6 == null) goto L42;
        r6.i(InteractMode.MULTI_ANCHOR);
    L42:
        if (r6 == null) goto L45;
        r6.N = 300;
        return;
    }

    public final void yq(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reqSrc");
        super.yq(r3);
        MultiAnchorLinkmicRtcLiveCoreData r4 = this.t;
        if (r4 == null) goto L16;
        MultiLiveCoreInfo r5 = r4.getMLiveCoreInfo();
        if (r5 == null) goto L17;
        MultiAnchorLinkmicLiveCoreInfo r6 = r5.multiAnchorLiveCoreInfo;
        if (r6 == null) goto L18;
        Map r7 = r6.liveCoreExtInfoMap;
        if (r7 == null) goto L19;
        String r8 = (String) r7.get(0L);
        if (r8 == null) goto L20;
        gy.f r0 = ((BaseEqualLinkWidget) this).c;
        if (r0 == null) goto L21;
        gy.f.a.a(r0, r8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public MediaMultiLinkAnchorWidget(v0 r2, x32.b r3) {
        this.K = r2;
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r4 = null;
        if (r3 == null) goto L5;
        x32.c r5 = r3.a();
    L7:
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.medialink.contract.f) == true) goto L9;
        r5 = null;
    L9:
        com.bytedance.android.livesdk.interactivity.medialink.contract.f r6 = (com.bytedance.android.livesdk.interactivity.medialink.contract.f) r5;
        if (r6 == null) goto L12;
        e92.l r0 = r6.a;
    L13:
        this.h = r0;
        ey.g.a.getClass();
        this.i = ey.g.a.a();
        if (r6 == null) goto L16;
        r4 = r6.b;
    L16:
        this.j = r4;
        this.q = 1;
        this.w = new CompositeDisposable();
        this.E = new Rect();
        this.F = new GestureDetector(((Widget) this).context, new a(this));
        this.G = new c(this);
        this.H = new b(this);
        this.I = new d(this);
        return;
    L12:
        r0 = null;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public final void Pi(h r6, Response<LinkLeaveResult> r7) {
        Intrinsics.checkNotNullParameter(r6, "leaveParams");
        w82.b.d(this.o, MediaMultiAnchorLinkContext.Companion.a(), this.q);
        if (r6.d == false) goto L7;
        hy.e r0 = this.l;
        if (r0 == null) goto L7;
        r0.clear(false);
    L7:
        Runnable r1 = this.p;
        if (r1 == null) goto L10;
        r1.run();
    L10:
        this.p = null;
        this.r = true;
        super.Pi(r6, r7);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAnchorView
    public final void R6(String r5, boolean r6) {
        StringBuilder r0 = new StringBuilder("onAnchorStateChanged ");
        r0.append(r5);
        r0.append(' ');
        if (r6 == false) goto L5;
        String r1 = "foreground";
    L6:
        r0.append(r1);
        ALogger.w("MediaLinkTracer", r0.toString());
        gy.f r2 = ((BaseEqualLinkWidget) this).c;
        if (r2 != null) goto L9;
    L15:
        TextUtils.equals(r5, MediaMultiAnchorLinkContext.Companion.b());
        MediaMultiLinkAnchorWindowManager r3 = this.m;
        if (r3 == null) goto L23;
        Iterator<MediaMultiAnchorWindowV2> r4 = r3.b.iterator();
    L19:
        if (r4.hasNext() == false) goto L29;
        MediaMultiAnchorWindowV2 r7 = r4.next();
        if (TextUtils.equals(r7.getInteractId(), r5) == false) goto L19;
        r7.r(r6, r3.b.size());
        goto L19
    L29:
        return;
    L23:
        return;
    L9:
        if (r2.isEngineOn() == false) goto L15;
        if (r5 == null) goto L15;
        f92.c r8 = this.k;
        if (r8 == null) goto L14;
        Intrinsics.checkNotNullParameter(r5, "interactId");
        r8.a.put(r5, Boolean.valueOf(!r6));
    L14:
        r2.f();
        goto L15
    L5:
        r1 = "background";
        goto L6
    }

    public final void V4(String r3, z.a r4) {
        if (r4 == null) goto L12;
        if (r3 == null) goto L13;
        MediaMultiLinkAnchorWindowManager r0 = this.m;
        if (r0 == null) goto L14;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L9;
        z.a r5 = r1.buildLayerControlLayer(r4);
    L10:
        r0.y(r3, r5, "onFirstFrameRender");
        return;
    L9:
        r5 = null;
        goto L10
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAnchorView
    public final void Yu(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        MediaMultiAnchorLinkContext.a r0 = MediaMultiAnchorLinkContext.Companion;
        if (r0.a() <= 0) goto L5;
        this.p = null;
        BaseEqualLinkWidget.xq(this, r7, r8, 4);
        r0.a();
        return;
    L5:
        MediaMultiAnchorLinkContext r9 = this.C;
        if (r9 == null) goto L10;
        com.bytedance.live.datacontext.m<dy.a> r10 = r9.getUnloadSource();
        if (r10 == null) goto L10;
        r10.setValue(new dy.a.d(r7));
    L10:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r11 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r11 == null) goto L15;
        r11.K4(256);
        return;
    }

    @Override // x82.b
    public final void Z8(String r7, LinkerKickOutContent.KickOutSource r8) {
        Intrinsics.checkNotNullParameter(r7, "uid");
        Intrinsics.checkNotNullParameter("MultiMicPanel", "reqSrc");
        Intrinsics.checkNotNullParameter(r8, "kickOutSource");
        if (e92.m.h() > 2) goto L5;
        ALogger.e("MediaLinkTracer", "drop kick out operation for window count no more than 2");
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        hy.e r1 = this.l;
        AnchorLinkUser r2 = null;
        if (r1 == null) goto L11;
        r2 = r1.getGuestInfo(r7.toString(), null);
    L11:
        if (r2 == null) goto L16;
        IBaseUser r9 = r2.getUser();
        if (r9 == null) goto L16;
        String r10 = r9.getNickName();
        if (r10 == null) goto L16;
    L17:
        String r11 = ((Widget) this).context.getString(2131920315, new Object[]{r10});
        j0 r3 = this.A;
        if (r3 != null) goto L20;
    L40:
        j0.a r4 = new j0.a(((Widget) this).context);
        r4.c = s1.B(2131915442);
        r4.b = f.a;
        r4.e = s1.B(2131920305);
        r4.d = new e(this, r2, r8);
        r4.f = false;
        r4.a = r11;
        Unit r13 = Unit.INSTANCE;
        this.A = r4.c();
        return;
    L20:
        if (r3.isShowing() != true) goto L40;
        j0 r5 = this.A;
        if (r5 == null) goto L40;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L26;
    L28:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L31 Exception -> L33
    L37:
        DialogLancet.afterDialogDismiss(r5);
        goto L40
    L33:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
        Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
        if (r14 == null) goto L37;
        com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L26:
        if (Looper.myLooper() == r6.getLooper()) goto L28;
        r6.post(DialogLancet.createDismissRunnable(r5));
    L16:
        r10 = BuildConfig.FLAVOR;
        goto L17
    L5:
        r0 = true;
        goto L6
    }

    public final void a(View r3, MotionEvent r4) {
        if (r3 == null) goto L16;
        if (r4 == null) goto L20;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L17;
        MediaMultiAnchorWindowV2 r6 = r5.j();
        if (r6 != null) goto L10;
        return;
    L10:
        if (r4.getAction() != 0) goto L13;
        r6.getGlobalVisibleRect(this.E);
    L13:
        if (this.E.contains((int) r4.getRawX(), (int) r4.getRawY()) == false) goto L19;
        this.F.onTouchEvent(r4);
        return;
    L19:
        return;
    L17:
        return;
    L20:
        return;
    }

    public final void e1(String r18, long r19) {
        m r4 = this.z;
        if (r4 == null) goto L9;
        HashSet<String> r5 = r4.d;
        if (r5 == null) goto L8;
        TypeIntrinsics.asMutableCollection(r5).remove(r18);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L9:
        long r6 = 0;
        if (r19 != 0) goto L12;
        String r7 = "rtc_offline_callback_0";
    L125:
        String r13 = r7;
        hy.e r8 = this.l;     // Catch: Exception -> L115
        List r16 = null;
        if (r8 == null) goto L16;
        AnchorLinkUser r9 = r8.g(r18);     // Catch: Exception -> L115
    L17:
        if (r9 == null) goto L19;
        AnchorLinkMicIdInfo r10 = r9.getAnchorLinkMicIdInfo();     // Catch: Exception -> L115
    L20:
        if (r10 == null) goto L52;
        gy.f r11 = ((BaseEqualLinkWidget) this).c;     // Catch: Exception -> L115
        if (r11 == null) goto L27;
        s r14 = r11.L();     // Catch: Exception -> L115
        if (r14 == null) goto L27;
        r r15 = r14.e(r10.mainLinkMicId);     // Catch: Exception -> L115
    L29:
        if (r15 != null) goto L45;
        gy.f r17 = ((BaseEqualLinkWidget) this).c;     // Catch: Exception -> L115
        if (r17 == null) goto L35;
        s r20 = r17.L();     // Catch: Exception -> L115
        if (r20 == null) goto L35;
        r r21 = r20.e(r10.backupLinkMicId);     // Catch: Exception -> L115
    L36:
        if (r21 != null) goto L45;
        StringBuilder r3 = new StringBuilder("important linkMicId all stream leave, stopForwardStream ");     // Catch: Exception -> L115
        gy.f r2 = ((BaseEqualLinkWidget) this).c;     // Catch: Exception -> L115
        if (r2 == null) goto L43;
        s r23 = r2.L();     // Catch: Exception -> L115
        if (r23 == null) goto L43;
        List r24 = r23.a();     // Catch: Exception -> L115
    L44:
        r3.append(r24);     // Catch: Exception -> L115
        r3.append(' ');     // Catch: Exception -> L115
        r3.append(r9.toSimpleString());     // Catch: Exception -> L115
        ALogger.e("MediaLinkRtc", r3.toString());     // Catch: Exception -> L115
    L43:
        r24 = null;
    L35:
        r21 = null;
    L45:
        StringBuilder r0 = new StringBuilder("important linkMicId leave, do not stopForwardStream ");     // Catch: Exception -> L115
        gy.f r25 = ((BaseEqualLinkWidget) this).c;     // Catch: Exception -> L115
        if (r25 == null) goto L50;
        s r26 = r25.L();     // Catch: Exception -> L115
        if (r26 == null) goto L50;
        r16 = r26.a();     // Catch: Exception -> L115
    L50:
        r0.append(r16);     // Catch: Exception -> L115
        r0.append(' ');     // Catch: Exception -> L115
        r0.append(r9.toSimpleString());     // Catch: Exception -> L115
        ALogger.e("MediaLinkRtc", r0.toString());     // Catch: Exception -> L115
        return;
    L27:
        r15 = null;
    L52:
        MediaMultiLinkAnchorWindowManager r27 = this.m;     // Catch: Exception -> L115
        if (r27 == null) goto L55;
        r27.z(r18);     // Catch: Exception -> L115
    L55:
        hy.e r28 = this.l;     // Catch: Exception -> L115
        String r29 = BuildConfig.FLAVOR;
        if (r28 == null) goto L62;
        AnchorLinkUser r1 = r28.getGuestInfo(BuildConfig.FLAVOR, r18);     // Catch: Exception -> L115
        if (r1 == null) goto L62;
        r9 = r1;
    L62:
        if (r9 == null) goto L111;
        x82.a.t2.getClass();     // Catch: Exception -> L115
        x82.a r30 = x82.a.C0295a.a();     // Catch: Exception -> L115
        if (r30 == null) goto L74;
        IBaseUser r31 = r9.getUser();     // Catch: Exception -> L115
        if (r31 == null) goto L72;
        String r33 = r31.getIdString();     // Catch: Exception -> L115
        if (r33 == null) goto L72;
        r29 = r33;
    L72:
        if (r30.N(r29) != true) goto L74;
        Cq("media_anchor_close_live");     // Catch: Exception -> L115
    L87:
        gy.f r34 = ((BaseEqualLinkWidget) this).c;     // Catch: Exception -> L115
        if (r34 == null) goto L94;
        IBaseUser r35 = r9.getUser();     // Catch: Exception -> L115
        if (r35 == null) goto L92;
        long r36 = r35.getLiveRoomId();     // Catch: Exception -> L115
    L93:
        r34.l(r36);     // Catch: Exception -> L115
        goto L94
    L92:
        r36 = 0;
    L94:
        MultiChannelInfo r37 = MediaMultiAnchorLinkContext.Companion.c();     // Catch: Exception -> L115
        if (r37 == null) goto L111;
        if (r37.getUseMultiChannel() == false) goto L111;
        IBaseUser r38 = r9.getUser();     // Catch: Exception -> L115
        if (r38 == null) goto L101;
        Long r39 = Long.valueOf(r38.getLiveRoomId());     // Catch: Exception -> L115
    L102:
        Map r40 = r37.getChannelMap();     // Catch: Exception -> L115
        if (r40 == null) goto L109;
        Map r41 = MapsKt.toMutableMap(r40);     // Catch: Exception -> L115
        if (r41 == null) goto L109;
        if (r39 == null) goto L108;
        r6 = r39.longValue();     // Catch: Exception -> L115
    L108:
        r41.remove(Long.valueOf(r6));     // Catch: Exception -> L115
        Unit r43 = Unit.INSTANCE;     // Catch: Exception -> L115
    L110:
        r37.setChannelMap(r41);     // Catch: Exception -> L115
    L109:
        r41 = null;
        goto L110
    L101:
        r39 = null;
    L74:
        x82.a r44 = x82.a.C0295a.a();     // Catch: Exception -> L115
        if (r44 == null) goto L87;
        ey.k r45 = r44.getLinkOutManager();     // Catch: Exception -> L115
        if (r45 == null) goto L87;
        long r46 = MediaMultiAnchorLinkContext.Companion.a();     // Catch: Exception -> L115
        IBaseUser r47 = r9.getUser();     // Catch: Exception -> L115
        if (r47 == null) goto L81;
        String r110 = r47.getIdString();     // Catch: Exception -> L115
    L82:
        IBaseUser r48 = r9.getUser();     // Catch: Exception -> L115
        if (r48 == null) goto L85;
        Intrinsics.checkNotNullParameter(r48, "$this$secUidExt");     // Catch: Exception -> L115
        String r111 = r48.getCastSecUid();     // Catch: Exception -> L115
    L86:
        r45.a(new fy.g(r46, r110, r111, r13, null, 96));     // Catch: Exception -> L115
        goto L87
    L85:
        r111 = null;
        goto L86
    L81:
        r110 = null;
    L111:
        MultiChannelOptManager r49 = this.v;     // Catch: Exception -> L115
        if (r49 == null) goto L117;
        MultiChannelOptManager.c(r49);     // Catch: Exception -> L115
    L117:
        MediaMultiAnchorStartDialog r50 = this.s;
        if (r50 != null) goto L120;
        return;
    L120:
        if (r50.isShowing() != true) goto L127;
        MediaMultiAnchorStartDialog r51 = this.s;
        if (r51 == null) goto L128;
        Aq(r51);
        return;
    L128:
        return;
    L127:
        return;
    L19:
        r10 = null;
        goto L20
    L16:
        r9 = null;
    L115:
        e = move-exception;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.e("ttlive_anchor", e);
        goto L117
    L12:
        r7 = "rtc_offline_callback_1";
        goto L125
    }

    public final void h3(fy.f r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "joinChannelParams");
        super.h3(r2, r3);
    }

    public final void m2(h r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
        Pi(r1, null);
    }

    public final void pl(fy.f r7, Response<AnchorJoinChannelResult> r8) {
        Intrinsics.checkNotNullParameter(r7, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r8, "response");
        hy.e r0 = this.l;
        if (r0 == null) goto L7;
        List r1 = r0.getOnlineUserList();
        if (r1 == null) goto L7;
        long r2 = r1.size();
    L8:
        this.t = ((AnchorJoinChannelResult) ((BaseResponse) r8).data).getMRtcLiveCoreData();
        AnchorJoinChannelResult r3 = (AnchorJoinChannelResult) ((BaseResponse) r8).data;
        if (r3 == null) goto L23;
        MultiAnchorLinkmicRtcLiveCoreData r4 = r3.getMRtcLiveCoreData();
        if (r4 == null) goto L23;
        MultiAnchorLinkmicRtcInfo r5 = r4.getMRtcInfo().mMultiAnchorLinkmicRtcInfo;
        if (r5 == null) goto L23;
        Map r6 = r5.rtcInfoMap;
        if (r6 == null) goto L23;
        String r9 = (String) r6.get(Long.valueOf(r2));
        if (r9 == null) goto L23;
        MediaMultiAnchorLinkContext r10 = this.C;
        if (r10 == null) goto L23;
        n<String> r11 = r10.getRtcInfo();
        if (r11 == null) goto L23;
        r11.setValue(r9);
    L23:
        MediaMultiLayoutManagerWidget r13 = this.x;
        MultiChannelInfo r14 = null;
        if (r13 == null) goto L41;
        MultiAnchorLinkmicRtcLiveCoreData r15 = this.t;
        String r16 = ((BaseResponse) r8).logId;
        Intrinsics.checkNotNullParameter("joinChannelSuccess", "source");
        Intrinsics.checkNotNullParameter(r16, "logID");
        if (r15 == null) goto L32;
        MultiRtcInfo r17 = r15.getMRtcInfo();
        if (r17 == null) goto L32;
        MultiAnchorLinkmicRtcInfo r18 = r17.mMultiAnchorLinkmicRtcInfo;
        if (r18 == null) goto L32;
        Map<Long, String> r19 = r18.pushStreamModeRTCMap;
    L33:
        if (r15 == null) goto L39;
        MultiLiveCoreInfo r20 = r15.getMLiveCoreInfo();
        if (r20 == null) goto L39;
        MultiAnchorLinkmicLiveCoreInfo r21 = r20.multiAnchorLiveCoreInfo;
        if (r21 == null) goto L39;
        Map<Long, String> r23 = r21.pushStreamModeLiveCoreMap;
    L40:
        r13.xq(r19, r23, "joinChannelSuccess", r16);
    L39:
        r23 = null;
    L32:
        r19 = null;
    L41:
        MediaMultiLayoutManagerWidget r24 = this.x;
        if (r24 == null) goto L52;
        AnchorJoinChannelResult r25 = (AnchorJoinChannelResult) ((BaseResponse) r8).data;
        if (r25 == null) goto L46;
        long r26 = r25.getMMultiDefaultAnchorLayout();
    L48:
        if (((int) r26) == 1) goto L50;
        UILayout r27 = UILayout.Normal;
    L51:
        r24.j = r27;
        goto L52
    L50:
        r27 = UILayout.Enlarge;
        goto L51
    L46:
        r26 = UILayout.Normal.ordinal();
    L52:
        MultiChannelInfo r28 = MediaMultiAnchorLinkContext.Companion.c();
        if (r28 != null) goto L55;
    L77:
        super.pl(r7, r8);
        gy.f r29 = ((BaseEqualLinkWidget) this).c;
        if (r29 == null) goto L93;
        v0 r30 = this.K;
        ey.g.a.getClass();
        nc0.b r31 = ey.g.a.a();
        if (r31 == null) goto L87;
        LiveData r33 = r31.c();
        if (r33 == null) goto L87;
        ey.f r34 = (ey.f) r33.getValue();
        if (r34 == null) goto L87;
        String r35 = r34.f;
        if (r35 == null) goto L87;
    L88:
        e92.l r36 = this.h;
        if (r36 == null) goto L91;
        r14 = r36.f;
    L91:
        r29.c(r30, this, r35, new gy.i(r14, 7));
        return;
    L87:
        r35 = BuildConfig.FLAVOR;
        goto L88
    L93:
        return;
    L55:
        if (r28.getUseMultiChannel() == false) goto L77;
        Map r37 = r28.getChannelMap();
        if (r37 == null) goto L62;
        Room r38 = ((BaseEqualLinkWidget) this).a;
        if (r38 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L61:
        String r39 = (String) r37.get(Long.valueOf(r38.id));
    L64:
        if (TextUtils.isEmpty(r39) == true) goto L77;
        MediaMultiAnchorLinkContext r40 = this.C;
        if (r40 == null) goto L77;
        n<String> r41 = r40.getRtcInfo();
        if (r41 == null) goto L77;
        Map r43 = r28.getChannelMap();
        if (r43 == null) goto L75;
        Room r44 = ((BaseEqualLinkWidget) this).a;
        if (r44 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L74:
        String r45 = (String) r43.get(Long.valueOf(r44.id));
    L76:
        r41.setValue(r45);
        goto L77
    L75:
        r45 = null;
        goto L76
    L62:
        r39 = null;
    L7:
        r2 = 0;
        goto L8
    }

    public final void zq(String r2, dy.a r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        MediaMultiAnchorLinkContext r0 = this.C;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<dy.a> r1 = r0.getUnloadSource();
        if (r1 == null) goto L7;
        r1.setValue(r3);
    L7:
        x82.a.t2.getClass();
        x82.a r4 = x82.a.C0295a.a();
        if (r4 == null) goto L11;
        r4.Mn(r2, r3);
        return;
    }

    public final void S(String r5, int r6, int r7) {
        MediaMultiLinkAnchorWindowManager r0 = this.m;
        if (r0 == null) goto L10;
        Iterator<MediaMultiAnchorWindowV2> r1 = r0.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        MediaMultiAnchorWindowV2 r2 = r1.next();
        if (Intrinsics.areEqual(r2.getInteractId(), r5) == false) goto L6;
        r2.setDebugText(r6 + " x " + r7);
        goto L6
    L16:
        return;
    }

    @Override // x82.b
    public final void ik(String r10, String r11, int r13) {
        Intrinsics.checkNotNullParameter(r10, "uid");
        Intrinsics.checkNotNullParameter(r11, "linkerID");
        if (Intrinsics.areEqual(r10, ey.c.b()) == false) goto L9;
        CommonBottomDialog r14 = this.D;
        if (r14 != null) goto L7;
    L8:
        int r15 = MediaMultiLinkSelfAnchorMicDialog.b;
        this.D = MediaMultiLinkSelfAnchorMicDialog.a.a(((Widget) this).context, r10);
        return;
    L7:
        if (r14.isShowing() != true) goto L8;
        return;
    L9:
        int r2 = MediaMultiLinkAnchorMicDialog.f;
        Context r4 = ((Widget) this).context;
        DataCenter r7 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r10, "uid");
        Intrinsics.checkNotNullParameter(r11, "linkerID");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        MediaMultiLinkAnchorMicDialog r0 = new MediaMultiLinkAnchorMicDialog(r4, r10, r11, r7, r13);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r0);
    L14:
        this.D = r0;
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L14
    }

    @Override // x82.b
    public final void setFollowState(String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter("connection_manage_setting", "source");
        k r2 = this.B;
        if (r2 == null) goto L22;
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter("connection_manage_setting", "source");
        if (r5 == true) goto L18;
        x0 r7 = r2.a;
        if (r7 == null) goto L14;
        if (r7.isShowing() != true) goto L14;
        x0 r8 = r2.a;
        if (r8 == null) goto L14;
        k.a(r8);
    L14:
        if (r2.d == null) goto L24;
        z0 r9 = z0.a();
        Context r0 = r2.d;
        r9.getClass();
        x0.b r10 = z0.b(r0);
        r10.l(2131922752);
        r10.i(0, 2131920806, new e92.g(r2, r4));
        r10.i(1, 2131915442, e92.h.a);
        r2.a = r10.n();
        return;
    L24:
        return;
    L18:
        if (r2.c == true) goto L25;
        r2.c = true;
        RxUtilKt.c(jc1.k.n(IUserService.class).user().h(new com.bytedance.android.livesdk.user.b.b().c(r4).f(j.b(LiveFollowScene.MULTI_ANCHOR_PANEL)).d()).subscribe(new e92.e(r2, r4), new e92.f(r2)), r2.b);
        return;
    L25:
        return;
    }

    public final void L0(String r1, TextureView r2, int r3, int r4) {
        if (r2 == null) goto L7;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L8;
        r5.x(r1, r2, "onFirstFrameTextureView");
        return;
    L8:
        return;
    }

    public final void b4(String r1, z.a r2, int r3, int r4) {
        if (r2 == null) goto L12;
        if (r1 == null) goto L13;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L14;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r6 = ILiveWrappedLivePusher.a.b();
        if (r6 == null) goto L9;
        z.a r7 = r6.buildLayerControlLayer(r2);
    L10:
        r5.y(r1, r7, "onFirstFrame");
        return;
    L9:
        r7 = null;
        goto L10
    L14:
        return;
    L13:
        return;
    }

    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
        if (r2 == null) goto L7;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L8;
        r5.x(r1, r2, "onFirstFrame");
        return;
    L8:
        return;
    }

    public final void j0(String r1, TextureView r2, int r3, int r4) {
        if (r2 == null) goto L7;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L8;
        r5.x(r1, r2, "onFirstFrameRenderTextureView");
        return;
    L8:
        return;
    }

    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
        if (r2 == null) goto L7;
        MediaMultiLinkAnchorWindowManager r5 = this.m;
        if (r5 == null) goto L8;
        r5.x(r1, r2, "onFirstFrameRender");
        return;
    L8:
        return;
    }
}
