package com.bytedance.android.live.liveinteract.linkcast;

import am2.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.content.ContextCompat;
import ca0.v;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.model.InteractiveScreenCastCloseResponse;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.r01;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.c9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tf0.o;
import uf2.d0;
import uf2.m1;
import vlc.l;
import zg1.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkCastAnchorWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lrj0/e;", "Lca0/v;", "Lvlc/l;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkCastAnchorWidget extends MiddlewareRoomWidget implements rj0.e, v, l {
    public static final /* synthetic */ int p = 0;
    public boolean a;
    public String b;
    public Bitmap c;
    public final CompositeDisposable d;
    public boolean e;
    public boolean f;
    public boolean g;
    public LinkScreenCastType h;
    public String i;
    public String j;
    public com.bytedance.android.live.liveinteract.linkpanel.model.b k;
    public wf0.a l;
    public long m;
    public final hg6.g n;
    public final IRoom o;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkCastAnchorWidget a;

        public b(LinkCastAnchorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IMiddlewareBroadcastService r0 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.minimizeCast();     // Catch: Throwable -> L7
        L5:
            ALogger.i("LinkCastAnchorWidget", "onProgramHide");     // Catch: Throwable -> L7
            LinkCastAnchorWidget r1 = this.a;     // Catch: Throwable -> L7
            int r2 = LinkCastAnchorWidget.p;     // Catch: Throwable -> L7
            r1.yq(false);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkCastAnchorWidget a;

        public c(LinkCastAnchorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IMiddlewareBroadcastService r0 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            IMiddlewareBroadcastService.b.a(r0);     // Catch: Throwable -> L7
        L5:
            ALogger.i("LinkCastAnchorWidget", "onProgramShow");     // Catch: Throwable -> L7
            LinkCastAnchorWidget r1 = this.a;     // Catch: Throwable -> L7
            int r2 = LinkCastAnchorWidget.p;     // Catch: Throwable -> L7
            r1.yq(true);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkCastAnchorWidget a;
        public final /* synthetic */ LinkScreenCastType b;
        public final /* synthetic */ long c;

        public d(LinkCastAnchorWidget r1, LinkScreenCastType r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r15) {
            Response r16 = (Response) r15;
            int r0 = com.bytedance.android.live.liveinteract.linkcast.d.a;
            int r1 = this.b.getTypeValue();
            String r2 = this.a.j;
            Integer r3 = je0.d.h();
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = r3.intValue();
        L6:
            com.bytedance.android.live.liveinteract.linkpanel.model.b r6 = (com.bytedance.android.live.liveinteract.linkpanel.model.b) r16.data;
            if (r6 == null) goto L9;
            r4 = (int) r6.getTargetUiLayout();
        L9:
            long r7 = this.c;
            String r11 = r16.logId;
            Intrinsics.checkNotNullParameter(r2, "programName");
            Intrinsics.checkNotNullParameter(r11, "logId");
            JSONObject r12 = new JSONObject();
            r12.put("program_type", String.valueOf(r1));
            r12.put("program_name", r2);
            r12.put("current_ui_layout", String.valueOf(r5));
            r12.put("target_ui_layout", String.valueOf(r4));
            long r8 = 0;
            if (r7 <= 0) goto L12;
            r8 = System.currentTimeMillis() - r7;
        L12:
            nd0.c r9 = nd0.c.a;
            LinkMonitorData r10 = LinkMonitorData.StartLinkCastData;
            nd0.c.s(r9, r10, null, r8, r11, r12, 98);
            LinkCastAnchorWidget r13 = this.a;
            com.bytedance.android.live.liveinteract.linkpanel.model.b r17 = (com.bytedance.android.live.liveinteract.linkpanel.model.b) r16.data;
            r13.k = r17;
            if (r17 == null) goto L15;
            Integer r18 = Integer.valueOf((int) r17.getTargetUiLayout());
        L17:
            if (Intrinsics.areEqual(r18, je0.d.h()) == false) goto L19;
            this.a.wq();
            return;
        L19:
            this.a.g = true;
            return;
        L15:
            r18 = null;
            goto L17
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LinkCastAnchorWidget a;
        public final /* synthetic */ LinkScreenCastType b;
        public final /* synthetic */ long c;

        public e(LinkCastAnchorWidget r1, LinkScreenCastType r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Throwable r5 = (Throwable) r9;
            int r10 = i.a;
            LinkScreenCastType r11 = this.a.h;
            Intrinsics.checkNotNullParameter(r11, "linkCastType");
            int r12 = h.c[r11.ordinal()];
            if (r12 != 1) goto L5;
            k.n(IMiddlewareInteractGameService.class).notifyStartLinkCastResult(false, null, 0);
        L9:
            LinkCastAnchorWidget r13 = this.a;
            r13.e = false;
            r13.f = false;
            String r14 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r5);
            if (r14 != null) goto L12;
            r14 = s1.B(2131918690);
        L12:
            f2.c(r14, 0);
            int r15 = com.bytedance.android.live.liveinteract.linkcast.d.a;
            int r16 = this.b.getTypeValue();
            String r0 = this.a.j;
            long r1 = this.c;
            Intrinsics.checkNotNullParameter(r0, "programName");
            Intrinsics.checkNotNullParameter(r5, "throwable");
            JSONObject r6 = new JSONObject();
            r6.put("program_type", String.valueOf(r16));
            r6.put("program_name", r0);
            long r3 = 0;
            if (r1 <= 0) goto L15;
            r3 = System.currentTimeMillis() - r1;
        L15:
            nd0.c.r(nd0.c.a, LinkMonitorData.StartLinkCastData, null, r3, r5, r6, 34);
            return;
        L5:
            if (r12 != 2) goto L9;
            ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).notifyMiniAppStartLinkCastResult(false, null, 0);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkCastAnchorWidget a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LinkScreenCastType c;
        public final /* synthetic */ long d;

        public f(LinkCastAnchorWidget r1, String r2, LinkScreenCastType r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r20) {
            Response r1 = (Response) r20;
            int r2 = com.bytedance.android.live.liveinteract.linkcast.d.a;
            String r3 = this.b;
            int r4 = this.c.getTypeValue();
            String r5 = this.a.j;
            Integer r6 = je0.d.h();
            if (r6 == null) goto L5;
            int r7 = r6.intValue();
        L6:
            InteractiveScreenCastCloseResponse r8 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r8 == null) goto L9;
            int r9 = (int) r8.getTargetUiLayout();
        L10:
            long r10 = this.d;
            String r11 = r1.logId;
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r5, "programName");
            Intrinsics.checkNotNullParameter(r11, "logId");
            JSONObject r14 = new JSONObject();
            r14.put("source", r3);
            r14.put("program_type", String.valueOf(r4));
            r14.put("program_name", r5);
            r14.put("current_ui_layout", String.valueOf(r7));
            r14.put("target_ui_layout", String.valueOf(r9));
            long r12 = 0;
            if (r10 <= 0) goto L13;
            r12 = System.currentTimeMillis() - r10;
        L13:
            nd0.c.s(nd0.c.a, LinkMonitorData.StopLinkCastData, null, r12, r11, r14, 98);
            InteractiveScreenCastCloseResponse r13 = (InteractiveScreenCastCloseResponse) r1.data;
            String r15 = null;
            if (r13 == null) goto L16;
            Integer r16 = Integer.valueOf((int) r13.getTargetUiLayout());
        L17:
            boolean r17 = true;
            if (Intrinsics.areEqual(r16, je0.d.h()) == false) goto L62;
            InteractiveScreenCastCloseResponse r18 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r18 == null) goto L22;
            int r19 = (int) r18.getTargetUiLayout();
        L24:
            if (r19 == 2) goto L61;
            InteractiveScreenCastCloseResponse r21 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r21 == null) goto L28;
            int r22 = (int) r21.getTargetUiLayout();
        L30:
            if (e0.a(r22) == true) goto L61;
            InteractiveScreenCastCloseResponse r23 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r23 == null) goto L34;
            String r24 = r23.getRtcExtInfo();
        L35:
            if (r24 != null) goto L37;
        L40:
            boolean r25 = true;
        L41:
            if (r25 == true) goto L47;
            hg6.g r26 = this.a.n;
            InteractiveScreenCastCloseResponse r27 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r27 == null) goto L45;
            String r28 = r27.getRtcExtInfo();
        L46:
            r26.c(r28);
            goto L47
        L45:
            r28 = null;
        L47:
            InteractiveScreenCastCloseResponse r29 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r29 == null) goto L50;
            String r30 = r29.getLiveCoreExtInfo();
        L51:
            if (r30 != null) goto L53;
        L56:
            if (r17 == true) goto L61;
            hg6.g r31 = this.a.n;
            InteractiveScreenCastCloseResponse r32 = (InteractiveScreenCastCloseResponse) r1.data;
            if (r32 == null) goto L60;
            r15 = r32.getLiveCoreExtInfo();
        L60:
            r31.J(r15);
            goto L61
        L53:
            if (r30.length() == 0) goto L56;
            r17 = false;
            goto L56
        L50:
            r30 = null;
            goto L51
        L37:
            if (r24.length() == 0) goto L40;
            r25 = false;
            goto L41
        L34:
            r24 = null;
            goto L35
        L28:
            r22 = 0;
        L61:
            this.a.xq(this.b, false);
            return;
        L22:
            r19 = 0;
            goto L24
        L62:
            this.a.g = true;
            return;
        L16:
            r16 = null;
            goto L17
        L9:
            r9 = 0;
            goto L10
        L5:
            r7 = 0;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LinkCastAnchorWidget a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LinkScreenCastType c;
        public final /* synthetic */ long d;

        public g(LinkCastAnchorWidget r1, String r2, LinkScreenCastType r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            Throwable r5 = (Throwable) r9;
            int r10 = i.a;
            i.a.c(this.a.h, false, this.b, false);
            this.a.e = true;
            f2.c(r5.getMessage(), 0);
            f2.b(2131918686, 0);
            int r11 = com.bytedance.android.live.liveinteract.linkcast.d.a;
            String r12 = this.b;
            int r0 = this.c.getTypeValue();
            String r1 = this.a.j;
            long r2 = this.d;
            Intrinsics.checkNotNullParameter(r12, "source");
            Intrinsics.checkNotNullParameter(r1, "programName");
            Intrinsics.checkNotNullParameter(r5, "throwable");
            JSONObject r6 = new JSONObject();
            r6.put("source", r12);
            r6.put("program_type", String.valueOf(r0));
            r6.put("program_name", r1);
            long r3 = 0;
            if (r2 <= 0) goto L5;
            r3 = System.currentTimeMillis() - r2;
        L5:
            long r4 = r3;
            nd0.c.r(nd0.c.a, LinkMonitorData.StopLinkCastData, null, r4, r5, r6, 34);
        }
    }

    static {
    }

    @Override // rj0.e
    public final boolean G7() {
        throw null;
    }

    @Override // rj0.e
    public final void Yg() {
        throw null;
    }

    @Override // rj0.e
    public final boolean isLinkCasting() {
        throw null;
    }

    public final void onEnterRoom() {
    }

    public final void onExitRoom() {
        this.a = true;
    }

    @Override // rj0.e
    public final t Hk() {
        wf0.a r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a != null) goto L10;
        r0.a = new t();
    L10:
        return r0.a;
    }

    @Override // rj0.e
    public final void Jj() {
        wf0.a r0 = this.l;
        if (r0 == null) goto L9;
        qz.a r1 = r0.a();
        if ((r1 instanceof wf0.d) == true) goto L7;
        r1 = null;
    L7:
        wf0.d r2 = (wf0.d) r1;
        return;
    }

    @Override // rj0.e
    public final boolean isSupportLinkCastMiniApp() {
        return ((Boolean) vm2.d.o7.getValue(null, vm2.d.a[427(0x1ab, float:5.98E-43)])).booleanValue();
    }

    @Override // rj0.e
    public final void onProgramFrameErr() {
        ne(this.h, this.i, "onProgramFrameErr", false);
    }

    @Override // rj0.e
    public final void onProgramStop() {
        ne(this.h, this.i, "onProgramStop", false);
    }

    public final void wq() {
        ALogger.i("LinkCastAnchorWidget", "realStartLinkCast");
        this.m = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.linkcast.g.a r1 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        String r2 = this.i;
        String r3 = this.j;
        int r4 = this.h.getTypeValue();
        String r5 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "openSource");
        HashMap r6 = new HashMap();
        m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r7 == null) goto L9;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L9;
        if (r8.isLiveTypeAudio() != true) goto L9;
        String r9 = "voice_live";
    L10:
        r6.put("live_type", r9);
        TalkRoomLogUtils.B0(r6, null, null, 6);
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        r6.put("content_id", r2);
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r6.put("content_name", r3);
        r6.put("source", com.bytedance.android.live.liveinteract.linkcast.g.a.b(r4));
        r6.put("open_source", r5);
        LinkScreenCastType r10 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        if (r4 != r10.getTypeValue()) goto L19;
        r6.put("_param_for_special", "micro_app");
    L19:
        j0.l().sendLog("livesdk_anchor_game_screen_share_success", r6, new Object[]{IRoom.class, x.class});
        wf0.a r11 = this.l;
        if (r11 == null) goto L80;
        Context r12 = ((Widget) this).context;
        hg6.g r13 = this.n;
        LinkScreenCastType r14 = this.h;
        String r15 = this.j;
        String r16 = this.i;
        Bitmap r17 = this.c;
        Function2<Integer, Integer, Unit> r18 = new LinkCastAnchorWidget$realStartLinkCast$1(this);
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "rtcManager");
        Intrinsics.checkNotNullParameter(r14, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r15, "programName");
        Intrinsics.checkNotNullParameter(r16, "appId");
        Intrinsics.checkNotNullParameter(r18, "updateParam");
        LinkScreenCastType r19 = LinkScreenCastType.CAST_TYPE_GAME;
        if (r14 == r19) goto L25;
        if (r14 != r10) goto L80;
    L25:
        if (r11.a != null) goto L27;
        r11.a = new t();
    L27:
        t r20 = r11.a;
        if (r20 == null) goto L69;
        r20.a = r14.getTypeValue();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r20.b = r16;
        if (r14 != r19) goto L38;
        if (r17 == null) goto L33;
        Canvas r0 = new Canvas(r17);
    L34:
        if (r0 == null) goto L38;
        r0.drawColor(ContextCompat.getColor(r12, 2131107984));
        goto L38
    L33:
        r0 = null;
    L38:
        r20.c = r12;
        r11.a();
        r20.getClass();
        rj0.k.m2.getClass();
        rj0.k r21 = rj0.k.a.a();
        if (r21 == null) goto L41;
        o r22 = r21.windowManager();
    L42:
        rj0.k r23 = rj0.k.a.a();
        if (r23 == null) goto L45;
        zj0.d r24 = r23.U1();
    L47:
        if ((r22 instanceof CommonMultiLinkWindowManager) == true) goto L49;
    L63:
        t.b r25 = wf0.b.c();
        if (r25 == null) goto L66;
        Unit r26 = Unit.INSTANCE;
    L67:
        r20.d = r25;
        goto L69
    L66:
        r25 = null;
        goto L67
    L49:
        if ((r24 instanceof zj0.d) == true) goto L51;
        r24 = null;
    L51:
        if (r24 == null) goto L63;
        if (r24.b != 7) goto L63;
        int r27 = r20.a;
        ((CommonMultiLinkWindowManager) r22).getClass();
        IInteractService r28 = (IInteractService) k.f(IInteractService.class);
        if (r28 == null) goto L61;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r29 = r28.getLinkUserInfoCenter();
        if (r29 == null) goto L61;
        List<T> r30 = r29.getOnlineUserList();
        if (r30 == 0) goto L61;
        int r31 = r30.size();
    L62:
        r20.d = wf0.b.j(r31, r27);
    L61:
        r31 = 0;
        goto L62
    L45:
        r24 = null;
        goto L47
    L41:
        r22 = null;
    L69:
        if (wf0.b.e() == true) goto L76;
        qz.a r32 = r11.a();
        if ((r32 instanceof wf0.d) == true) goto L74;
        r32 = null;
    L74:
        if (((wf0.d) r32) == null) goto L76;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "rtcManager");
        Intrinsics.checkNotNullParameter(r14, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r15, "programName");
        Intrinsics.checkNotNullParameter(r18, "updateParam");
        new WeakReference(r12);
        new WeakReference(r13);
    L76:
        IMiddlewareBroadcastService r33 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
        if (r11.a != null) goto L79;
        r11.a = new t();
    L79:
        r33.startCast(r11.a);
    L80:
        yq(true);
        int r34 = com.bytedance.android.live.liveinteract.linkcast.b.a[this.h.ordinal()];
        if (r34 != 1) goto L83;
        f2.b(2131918688, 0);
        return;
    L83:
        if (r34 == 2) goto L87;
        f2.b(2131918691, 0);
        return;
    L87:
        return;
    L9:
        r9 = "video_live";
        goto L10
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new AnonymousClass1(this));
    L7:
        Pair r2 = com.bytedance.live.datacontext.d.a(LinkCastAnchorWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((LinkCastAnchorDataContext) r2.getFirst(), vf0.a.class);
        this.d.add((Disposable) r2.getSecond());
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L8;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L8;
        r1.c(new C03031(this));
    L8:
        if (this.e == false) goto L11;
        xq("closeRoom", false);
    L11:
        if (this.a == false) goto L13;
        wf0.b.a();
    L13:
        this.d.clear();
        this.l = null;
        this.a = false;
        k.n(IRoomStateService.class).unregistRoomStateListner(this);
    }

    @Override // rj0.e
    public final void onProgramHide() {
        i0.c().post(new b(this));
    }

    @Override // rj0.e
    public final void onProgramShow() {
        i0.c().post(new c(this));
    }

    @Override // rj0.e
    public final void kh(t.b r13) {
        wf0.a r0 = this.l;
        if (r0 == null) goto L25;
        qz.a r1 = r0.a();
        if ((r1 instanceof wf0.c) == true) goto L8;
        r1 = null;
    L8:
        if (((wf0.c) r1) == null) goto L26;
        int r2 = wf0.c.a;
        float r3 = 0.0f;
        if (r13 == null) goto L12;
        float r4 = r13.a;
    L13:
        if (r13 == null) goto L15;
        float r5 = r13.b;
    L16:
        if (r13 == null) goto L18;
        float r6 = r13.c;
    L19:
        if (r13 == null) goto L21;
        r3 = r13.d;
    L21:
        float r7 = r6 / s1.y();
        float r8 = r3 / s1.w();
        float r9 = (r4 / s1.y()) + r7;
        float r10 = (r5 / s1.w()) + r8;
        ALogger.e("MultiFloatDynamicCastStream", "getLittleWindowDescription ;; littleWindowLeft == " + r7 + " ;;  littleWindowTop == " + r8 + " ;; littleWindowRight == " + r9 + " ;; littleWindowBottom == " + r10);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r11 = ILiveWrappedLivePusher.a.b();
        if (r11 == null) goto L27;
        r11.newVideoMixerDescription(r7, r8, r9, r10, 0, 32);
        return;
    L27:
        return;
    L18:
        r6 = 0.0f;
        goto L19
    L15:
        r5 = 0.0f;
        goto L16
    L12:
        r4 = 0.0f;
        goto L13
    L26:
        return;
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof ILinkmicProfitMessage) == false) goto L24;
        ILinkmicProfitMessage r5 = (ILinkmicProfitMessage) r4;
        int r0 = r5.getMsgType();
        s0 r2 = null;
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_InteractiveScreenCastOpen.getValue()) goto L17;
        c9 r6 = r5.getInteractScreenCastInfoOpenContent();
        if (r6 == null) goto L11;
        r2 = r6.getScreenCastInfo();
    L11:
        LinkCastAnchorDataContext r7 = LinkCastAnchorDataContext.Companion.getContext();
        if (r7 == null) goto L25;
        n<s0> r8 = r7.getMLinkCastInfo();
        if (r8 == null) goto L26;
        r8.setValue(r2);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_InteractiveScreenCastClose.getValue()) goto L28;
        LinkCastAnchorDataContext r9 = LinkCastAnchorDataContext.Companion.getContext();
        if (r9 == null) goto L29;
        n<s0> r10 = r9.getMLinkCastInfo();
        if (r10 == null) goto L30;
        r10.setValue(null);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public final void yq(boolean r3) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L9;
        r1.b(new m0(r3));
        return;
    L9:
        return;
    }

    public LinkCastAnchorWidget(hg6.g r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcManager");
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        this.n = r2;
        this.o = r3;
        this.b = "";
        this.d = new CompositeDisposable();
        this.h = LinkScreenCastType.CAST_TYPE_UNKNOWN;
        this.i = "";
        this.j = "";
        this.l = new wf0.a();
    }

    public final void xq(String r19, boolean r20) {
        long r2 = System.currentTimeMillis() - this.m;
        com.bytedance.android.live.liveinteract.linkcast.g.a r4 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        String r5 = this.i;
        String r6 = this.j;
        int r7 = this.h.getTypeValue();
        r4.getClass();
        HashMap r8 = new HashMap();
        m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r9 == null) goto L9;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L9;
        if (r10.isLiveTypeAudio() != true) goto L9;
        String r11 = "voice_live";
    L10:
        r8.put("live_type", r11);
        qz.a r12 = null;
        TalkRoomLogUtils.B0(r8, null, null, 6);
        String r13 = "";
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r8.put("content_id", r5);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r8.put("content_name", r6);
        r8.put("source", com.bytedance.android.live.liveinteract.linkcast.g.a.b(r7));
        r8.put("duration", String.valueOf(r2));
        j0.l().sendLog("livesdk_anchor_game_screen_share_duration", r8, new Object[]{IRoom.class, x.class});
        this.m = 0;
        int r3 = com.bytedance.android.live.liveinteract.linkcast.d.a;
        int r14 = this.h.getTypeValue();
        String r15 = this.j;
        ei6.a r16 = this.n.V0();
        if (r16 == null) goto L26;
        fi6.a r17 = r16.g();
        if (r17 == null) goto L26;
        MixStreamType r18 = r17.U;
        if (r18 == null) goto L26;
        String r21 = r18.name();
        if (r21 == null) goto L26;
        r13 = r21;
    L26:
        Intrinsics.checkNotNullParameter(r15, "programName");
        Intrinsics.checkNotNullParameter(r13, "mixType");
        JSONObject r110 = new JSONObject();
        r110.put("program_type", String.valueOf(r14));
        r110.put("program_name", r15);
        r110.put("mix_type", r13);
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastRealStop, r110, 0, null, false, 28);
        wf0.a r22 = this.l;
        if (r22 == null) goto L38;
        LinkScreenCastType r23 = this.h;
        Intrinsics.checkNotNullParameter(r23, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r19, "source");
        if (wf0.b.e() == true) goto L37;
        qz.a r24 = r22.a();
        if ((r24 instanceof wf0.d) == false) goto L35;
        r12 = r24;
    L35:
        if (((wf0.d) r12) == null) goto L37;
        Intrinsics.checkNotNullParameter(r23, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r19, "source");
    L37:
        IMiddlewareBroadcastService.b.b((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class));
        int r25 = i.a;
        i.a.c(r23, true, r19, false);
    L38:
        yq(false);
        if (r20 == true) goto L42;
        f2.b(2131918687, 0);
        return;
    L42:
        return;
    L9:
        r11 = "video_live";
        goto L10
    }

    @Override // rj0.e
    public final void logMiniAppShareIconClick(String r5, String r6, boolean r7) {
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        HashMap r0 = new HashMap();
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        if (r2.isLiveTypeAudio() != true) goto L9;
        String r3 = "voice_live";
    L10:
        r0.put("live_type", r3);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r0.put("content_id", r5);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r0.put("content_name", r6);
        r0.put("source", "program");
        if (r7 == false) goto L19;
        String r8 = "cancel";
    L20:
        r0.put("button_type", r8);
        j0.l().sendLog("livesdk_game_screen_share_icon_click", r0, new Object[]{IRoom.class});
        return;
    L19:
        r8 = "share";
    L9:
        r3 = "video_live";
        goto L10
    }

    @Override // rj0.e
    public final void logMiniAppShareIconShow(String r5, String r6, boolean r7) {
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        HashMap r0 = new HashMap();
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        if (r2.isLiveTypeAudio() != true) goto L9;
        String r3 = "voice_live";
    L10:
        r0.put("live_type", r3);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r0.put("content_id", r5);
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r0.put("content_name", r6);
        r0.put("source", "program");
        if (r7 == false) goto L19;
        String r8 = "cancel";
    L20:
        r0.put("button_type", r8);
        j0.l().sendLog("livesdk_game_screen_share_icon_show", r0, new Object[]{IRoom.class});
        return;
    L19:
        r8 = "share";
    L9:
        r3 = "video_live";
        goto L10
    }

    @Override // rj0.e
    public final void ne(LinkScreenCastType r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r12, "source");
        if (this.e == true) goto L5;
        return;
    L5:
        ALogger.i("LinkCastAnchorWidget", "stopLinkCast");
        this.g = false;
        this.e = false;
        this.f = false;
        if (r13 == false) goto L8;
    L12:
        xq(r12, r13);
        return;
    L8:
        if (this.a == true) goto L12;
        long r7 = System.currentTimeMillis();
        ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).stopLinkCast(this.o.getRoomId(), r11, r10.getTypeValue()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r12, r10, r7), new g(this, r12, r10, r7));
    }

    @Override // rj0.e
    public final void ll(LinkScreenCastType r7, String r8, int r9, int r10, Bitmap r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r7, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r8, "appId");
        Intrinsics.checkNotNullParameter(r13, "openSource");
        if (this.e == false) goto L5;
        return;
    L5:
        ALogger.i("LinkCastAnchorWidget", "startLinkCast");
        k.n(IRoomStateService.class).registRoomStateListner(this);
        j r14 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getLiveStream();
        if (r14 == null) goto L8;
        com.bytedance.android.live.pushstream.d r15 = (com.bytedance.android.live.pushstream.d) r14.getValue();
    L9:
        if (r15 == null) goto L15;
        d0 r16 = r15.getLiveCore();
        if (r16 == null) goto L15;
        uf2.x r17 = r16.l();
        if (r17 == null) goto L15;
        m1.b r18 = r17.q();
    L16:
        wf0.a r19 = this.l;
        if (r19 == null) goto L30;
        if (r18 == null) goto L20;
        r18.getLeft();
    L20:
        if (r18 == null) goto L22;
        r18.getTop();
    L22:
        if (r18 == null) goto L24;
        r18.getRight();
    L24:
        if (r18 == null) goto L26;
        r18.getBottom();
    L26:
        qz.a r20 = r19.a();
        if ((r20 instanceof wf0.d) == true) goto L29;
        r20 = null;
    L29:
        wf0.d r21 = (wf0.d) r20;
    L30:
        this.g = false;
        this.e = true;
        this.c = r11;
        this.b = r13;
        this.h = r7;
        LinkCastAnchorDataContext r22 = LinkCastAnchorDataContext.Companion.getContext();
        if (r22 == null) goto L35;
        n<LinkScreenCastType> r23 = r22.getMCurrentScreenType();
        if (r23 == null) goto L35;
        r23.setValue(r7);
    L35:
        this.i = r8;
        int r24 = i.a;
        com.bytedance.android.live.liveinteract.linkcast.c r25 = i.a.a(this.h, r8);
        if (r25 == null) goto L39;
        String r26 = r25.c;
        if (r26 == null) goto L39;
    L40:
        this.j = r26;
        long r110 = System.currentTimeMillis();
        LinkAnchorApi r0 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r1 = this.o.getRoomId();
        int r4 = r7.getTypeValue();
        Map r27 = (Map) ((Map) vm2.d.l3.getValue(null, vm2.d.a[217(0xd9, float:3.04E-43)])).get(String.valueOf(Integer.valueOf(r7.getTypeValue())));
        if (r27 == null) goto L45;
        r01 r28 = (r01) r27.get("profile");
        if (r28 == null) goto L45;
        int r29 = r28.a();
    L46:
        this.d.add(r0.startLinkCast(r1, r8, r4, r29).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r7, r110), new e(this, r7, r110)));
        return;
    L45:
        r29 = LinkScreenCastProfile.SCREEN_CAST_PROFILE_15FPS.ordinal();
    L39:
        r26 = "";
    L15:
        r18 = null;
        goto L16
    L8:
        r15 = null;
        goto L9
    }
}
