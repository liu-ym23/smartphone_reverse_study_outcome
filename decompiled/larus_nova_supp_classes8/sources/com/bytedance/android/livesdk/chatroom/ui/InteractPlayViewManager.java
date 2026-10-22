package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.AlignModeType;
import com.bytedance.android.livesdk.config.RenderViewScaleType;
import com.bytedance.android.livesdk.config.cb0;
import com.bytedance.android.livesdk.config.ex0;
import com.bytedance.android.livesdk.config.fx0;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.hb0;
import com.bytedance.android.livesdk.config.xj0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class InteractPlayViewManager implements IInteractPlayView {
    public static final /* synthetic */ int B = 0;
    public final Context A;
    public int a;
    public int b;
    public long c;
    public final CompositeDisposable d;
    public int e;
    public int f;
    public int g;
    public int h;
    public LivePlayerView i;
    public IRoom j;
    public final Lazy k;
    public long l;
    public cy0.a m;
    public final int n;
    public JSONObject o;
    public int p;
    public int q;
    public boolean r;
    public String s;
    public ClientUIInfo t;
    public boolean u;
    public final boolean v;
    public final boolean w;
    public boolean x;
    public ParseSeiData y;
    public final DataCenter z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ InteractPlayViewManager a;

        public a(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            Object r0 = null;
            if (r5 == null) goto L5;
            String r1 = r5.getKey();
        L7:
            if (Intrinsics.areEqual(r1, "cmd_interact_player_view_height_change") == false) goto L18;
            Object r6 = r5.getData();
            if ((r6 instanceof Integer) == false) goto L12;
            r0 = r6;
        L12:
            Integer r2 = (Integer) r0;
            if (r2 != null) goto L15;
            return;
        L15:
            if (r2.intValue() == 0) goto L20;
            this.a.e = 0;
            return;
        L20:
            return;
        L18:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ InteractPlayViewManager a;

        public b(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.livesdk.chatroom.utils.a2.p(this.a.e) == false) goto L7;
        L8:
            IRenderView r0 = null;
            if (r5 == null) goto L11;
            String r1 = r5.getKey();
        L13:
            if (Intrinsics.areEqual(r1, "cmd_interact_player_view_diff_height") == false) goto L34;
            Object r6 = r5.getData();
            if ((r6 instanceof Integer) == true) goto L17;
            r6 = null;
        L17:
            Integer r7 = (Integer) r6;
            if (r7 == null) goto L35;
            int r8 = r7.intValue();
            LivePlayerView r2 = this.a.i;
            if (r2 == null) goto L22;
            IRenderView r3 = r2.getRenderView();
        L24:
            if ((r3 instanceof View) == false) goto L27;
            r0 = r3;
        L27:
            View r9 = (View) r0;
            if (r9 == null) goto L30;
            r9.setTranslationY(-r8);
        L30:
            ALogger.w("InteractPlayViewManager", "init ;; (mLivePlayView?.renderView as? View)?.translationY == " + (-r8));
            return;
        L22:
            r3 = null;
            goto L24
        L35:
            return;
        L34:
            return;
        L11:
            r1 = null;
            goto L13
        L7:
            if (com.bytedance.android.livesdk.chatroom.utils.a2.n(this.a.e, 0) == true) goto L8;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ InteractPlayViewManager a;

        public c(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            m81.a r10 = (m81.a) r9;
            InteractPlayViewManager r0 = this.a;
            r0.r = true;
            JSONObject r11 = InteractPlayViewManager.c(r0.s);
            LivePlayerView r4 = r0.i;
            if (r11 == null) goto L9;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r11.has("app_data") == false) goto L11;
            String r12 = JSONObjectProtectorUtils.getString(r11, "app_data");
            JSONObject r1 = new JSONObject(new Regex("\\\\").replace(r12, ""));
            JSONObject r3 = r1.optJSONObject("canvas");
            InteractPlayViewManager.l(r0, r1.optInt("ver"), r1.optInt("ui_layout"), r3, r4, r0.j, null, 32);
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ InteractPlayViewManager a;

        public e(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            zg1.r0 r6 = (zg1.r0) r5;
            InteractPlayViewManager r7 = this.a;
            LivePlayerView r0 = r7.i;
            if (r0 == null) goto L6;
            r7.i(r7.s, r0, r7.j, true);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ InteractPlayViewManager a;

        public g(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            zg1.v1 r7 = (zg1.v1) r6;
            long r0 = r7.a;
            IRoom r2 = this.a.j;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r0 != r2.getRoomId()) goto L9;
            InteractPlayViewManager.b(this.a, r7.c);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ InteractPlayViewManager a;

        public i(InteractPlayViewManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            final IRoom r16 = (IRoom) ((KVData) r15).getData();
            if (r16 == null) goto L13;
            long r1 = r16.getRoomId();
            Objects.toString(this.a.d);
            IRoomModuleService r0 = jc1.k.f(IRoomModuleService.class);
            if (r0 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.room.backend.g r2 = r0.getLiveRoomBackendUtils();
            if (r2 == null) goto L12;
            com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r2, r1, null, com.bytedance.android.live.liveinteract.plantform.model.w0.class, InteractPlayViewManager$9$1.INSTANCE, null, new InteractPlayViewManager$9$2(this, r16), null, null, this.a.d, false, true, 2640);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class j {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/chatroom/ui/InteractPlayViewManager$k", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class k extends TypeToken<ClientUIInfo> {
        public k() {
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ InteractPlayViewManager a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ LivePlayerView c;

        public l(InteractPlayViewManager r1, IRoom r2, LivePlayerView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DataCenter r0 = this.a.z;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.put("fold_container_width", Integer.valueOf(this.c.getRenderView().getWidth()));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class m implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ InteractPlayViewManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ LivePlayerView e;
        public final /* synthetic */ IRoom f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;

        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            com.bytedance.android.live.core.utils.f2.g();
        }

        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r10, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r11) {
            Intrinsics.checkNotNullParameter(r10, "request");
            Intrinsics.checkNotNullParameter(r11, "response");
            InteractPlayViewManager.a(this.a, r11.a, this.b, this.c, this.d, this.e, this.g, this.h, this.i);
        }

        public m(InteractPlayViewManager r1, int r2, int r3, JSONObject r4, LivePlayerView r5, IRoom r6, int r7, int r8, int r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ InteractPlayViewManager a;
        public final /* synthetic */ IRoom b;

        public n(InteractPlayViewManager r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            zg1.r0 r6 = (zg1.r0) r5;
            ALogger.d("InteractPlayViewManager", "InteractPlayViewRefreshEvent subscribe " + this.a);
            InteractPlayViewManager r7 = this.a;
            LivePlayerView r0 = r7.i;
            if (r0 == null) goto L6;
            r7.i(r7.s, r0, this.b, true);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public static boolean f(int r1, int r2) {
        if (r1 == 3) goto L5;
    L7:
        return false;
    L5:
        if (r2 != 25) goto L7;
        return true;
    }

    public final void resetSeiVersion() {
        this.e = 0;
    }

    public final void resizePlayView(int r1, int r2, JSONObject r3, LivePlayerView r4, Context r5, IRoom r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Intrinsics.checkNotNullParameter(r5, "context");
    }

    public final boolean e() {
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L25:
        return false;
    L5:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == true) goto L7;
    L11:
        int r0 = this.b;
        if (r0 != 3) goto L14;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == false) goto L25;
        if (this.a != 0) goto L25;
        return true;
    L14:
        if (r0 == 4) goto L20;
        if (r0 == 0) goto L20;
        if (r0 == 2) goto L20;
        r1 = false;
        goto L21
    L7:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L11;
        if (this.b != 0) goto L11;
        return true;
    }

    public final void h() {
        if (m() == false) goto L6;
        return;
    L6:
        if (this.e == 0) goto L56;
        View r3 = null;
        if (jc1.k.n(IInteractService.class).isPCLandscape(this.e, 0) == false) goto L30;
        LivePlayerView r0 = this.i;
        if (r0 == null) goto L27;
        IRenderView r4 = r0.getRenderView();
        if ((r4 instanceof View) == true) goto L14;
        r4 = null;
    L14:
        View r5 = (View) r4;
        if (r5 == null) goto L17;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L19:
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L27;
        View r1 = r0.getRenderView();
        if ((r1 instanceof View) == false) goto L24;
        r3 = r1;
    L24:
        View r7 = r3;
        if (r7 == null) goto L27;
        r7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        goto L27
    L17:
        r6 = null;
    L27:
        DataCenter r2 = this.z;
        if (r2 == null) goto L54;
        r2.put("cmd_pc_landscape_close_dynamic_1v6", Boolean.TRUE);
    L54:
        this.e = 0;
        return;
    L30:
        LivePlayerView r8 = this.i;
        if (r8 == null) goto L54;
        IRenderView r9 = r8.getRenderView();
        if ((r9 instanceof View) == true) goto L35;
        r9 = null;
    L35:
        View r10 = (View) r9;
        if (r10 == null) goto L38;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L40:
        if ((r11 instanceof FrameLayout.LayoutParams) == false) goto L54;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        r12.gravity = 17;
        Unit r13 = Unit.INSTANCE;
        r8.setLayoutParams(r12);
        r8.getRenderView().setScaleType(2);
        View r14 = r8.getRenderView();
        if ((r14 instanceof View) == true) goto L44;
        r14 = null;
    L44:
        View r15 = r14;
        if (r15 == null) goto L47;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -1);
        r16.gravity = 17;
        Unit r17 = Unit.INSTANCE;
        r15.setLayoutParams(r16);
    L47:
        View r18 = r8.getRenderView();
        if ((r18 instanceof View) == false) goto L51;
        r3 = r18;
    L51:
        View r19 = r3;
        if (r19 == null) goto L54;
        r19.requestLayout();
        goto L54
    L38:
        r11 = null;
        goto L40
    }

    public final boolean m() {
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 != null) goto L5;
    L14:
        return false;
    L5:
        if (r0.shouldUseNewLivePlayerLayout() != true) goto L14;
        int r1 = this.b;
        if (r1 != 2) goto L9;
        return true;
    L9:
        if (r1 != 3) goto L11;
        return true;
    L11:
        if (r1 == 4) goto L18;
        if (r1 != 0) goto L14;
        return true;
    L18:
        return true;
    }

    public final int getFeedViewDesiredTopSpaceHeight() {
        return this.a;
    }

    public static JSONObject c(String r3) {
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r3) == false) goto L24;
        JSONObject r4 = LiveSeiUtil.c(r3);     // Catch: JSONException -> L16
        if (r4.has("info") == true) goto L7;
        return r4;
    L7:
        if (r4.has("source") == true) goto L9;
        return r4;
    L9:
        if (TextUtils.equals(r4.optString("source"), "zego") == false) goto L22;
        Object r5 = r4.get("info");     // Catch: JSONException -> L16
        if (r5 == null) goto L14;
        return (JSONObject) r5;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L16
    L22:
        return r4;
    L16:
        e = move-exception;
        ALogger.e("InteractPlayViewManager", "error message: " + e);
        return null;
    L24:
        return null;
    }

    public static Pair d(LivePlayerView r2) {
        if (r2 == null) goto L14;
        ILivePlayerClient r3 = r2.getClient();
        if (r3 == null) goto L14;
        IRoomEventHub r4 = r3.getEventHub();
        if (r4 == null) goto L14;
        MutableLiveData r5 = r4.getVideoSizeChanged();
        if (r5 == null) goto L14;
        Pair r6 = (Pair) r5.getValue();
        if (r6 == null) goto L14;
        return new Pair(r6.getFirst(), r6.getSecond());
    L14:
        return new Pair(0, 0);
    }

    public final void g(LivePlayerView r7) {
        Intrinsics.checkNotNullParameter(r7, "livePlayerView");
        if (m() == false) goto L6;
        return;
    L6:
        if (this.e == 0) goto L52;
        ALogger.w("InteractPlayViewManager", "reSetPlayView ;; lastVersion == " + this.e);
        View r3 = null;
        if (jc1.k.n(IInteractService.class).isPCLandscape(this.e, 0) == false) goto L28;
        IRenderView r0 = r7.getRenderView();
        if ((r0 instanceof View) == true) goto L12;
        r0 = null;
    L12:
        View r1 = (View) r0;
        if (r1 == null) goto L15;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L17:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L25;
        View r8 = r7.getRenderView();
        if ((r8 instanceof View) == false) goto L22;
        r3 = r8;
    L22:
        View r4 = r3;
        if (r4 == null) goto L25;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L25:
        DataCenter r9 = this.z;
        if (r9 == null) goto L50;
        r9.put("cmd_pc_landscape_close_dynamic_1v6", Boolean.TRUE);
    L50:
        boolean r10 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.m, false);
        this.e = 0;
        return;
    L15:
        r2 = null;
        goto L17
    L28:
        IRenderView r5 = r7.getRenderView();
        if ((r5 instanceof View) == true) goto L31;
        r5 = null;
    L31:
        View r6 = (View) r5;
        if (r6 == null) goto L34;
        ViewGroup.LayoutParams r11 = r6.getLayoutParams();
    L36:
        if ((r11 instanceof FrameLayout.LayoutParams) == false) goto L50;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        r12.gravity = 17;
        Unit r13 = Unit.INSTANCE;
        r7.setLayoutParams(r12);
        r7.getRenderView().setScaleType(2);
        View r14 = r7.getRenderView();
        if ((r14 instanceof View) == true) goto L40;
        r14 = null;
    L40:
        View r15 = r14;
        if (r15 == null) goto L43;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -1);
        r16.gravity = 17;
        r15.setLayoutParams(r16);
    L43:
        View r17 = r7.getRenderView();
        if ((r17 instanceof View) == false) goto L47;
        r3 = r17;
    L47:
        View r18 = r3;
        if (r18 == null) goto L50;
        r18.requestLayout();
        goto L50
    L34:
        r11 = null;
        goto L36
    }

    public final void setFeedViewDesiredTopSpaceHeight(int r1) {
        this.a = r1;
    }

    public final void updateRoom(IRoom r4) {
        this.j = r4;
        if (this.x == false) goto L5;
        return;
    L5:
        if (this.v == false) goto L14;
        if (r4 == null) goto L15;
        StringBuilder r0 = new StringBuilder();
        r0.append(r4.getIdStr());
        r0.append('_');
        if (this.z != null) goto L10;
        String r1 = "feed";
    L11:
        r0.append(r1);
        String r2 = r0.toString();
        ALogger.d("InteractPlayViewManager", "updateRoom, register InteractPlayViewRefreshEvent, uniqueId = " + r2);
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(r2).b(zg1.r0.class).subscribe(new n(this, r4), o.a), this.d);
        this.x = true;
        return;
    L10:
        r1 = "room";
        goto L11
    L15:
        return;
    }

    public InteractPlayViewManager(DataCenter r6, Context r7) {
        Intrinsics.checkNotNullParameter(r7, "mContext");
        this.z = r6;
        this.A = r7;
        this.a = com.bytedance.android.live.core.utils.s1.A();
        this.k = LazyKt.lazy(InteractPlayViewManager$revSeiOpt$2.INSTANCE);
        this.n = 15000;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L5;
        int r8 = com.bytedance.android.live.core.utils.s1.x();
    L9:
        this.p = r8;
        this.q = -1;
        this.s = "";
        boolean r9 = true;
        this.u = true;
        if (m() == false) goto L12;
    L38:
        this.v = MultiLinkLoadWidgetUtils.g();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L41;
    L43:
        r9 = false;
    L44:
        this.w = r9;
        return;
    L41:
        if (vm2.h.W().clearRxBus() == false) goto L43;
    L12:
        if (ex0.a.getValue().booleanValue() == false) goto L17;
        if (r6 == null) goto L17;
        DataCenter r0 = r6.observe("cmd_interact_player_view_height_change", new a(this));
        if (r0 == null) goto L17;
        r0.observe("cmd_interact_player_view_diff_height", new b(this));
    L17:
        CompositeDisposable r1 = new CompositeDisposable();
        this.d = r1;
        if (r6 == null) goto L22;
        RxUtilKt.c(xs2.b.a().b(m81.a.class).subscribe(new c(this), d.a), r1);
        if (MultiLinkLoadWidgetUtils.g() == true) goto L22;
        RxUtilKt.c(xs2.b.a().b(zg1.r0.class).subscribe(new e(this), f.a), r1);
    L22:
        RxUtilKt.c(xs2.b.a().b(zg1.v1.class).subscribe(new g(this), h.a), r1);
        Map r10 = (Map) com.bytedance.android.livesdk.j2.a.getValue();
        JSONObject r2 = new JSONObject();
        Iterator r11 = r10.entrySet().iterator();
    L24:
        if (r11.hasNext() == false) goto L28;
        Map.Entry r3 = (Map.Entry) r11.next();     // Catch: Exception -> L27
        r2.put(String.valueOf(((Number) r3.getKey()).intValue()), GsonHelper.get().toJson(r3.getValue()).toString());     // Catch: Exception -> L27
        goto L24
    L28:
        com.bytedance.android.livesdk.log.b0 r12 = com.bytedance.android.livesdk.log.b0.o();
        String r4 = r2.toString();
        r12.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_link", r4);
        if (MultiLinkLoadWidgetUtils.l() == true) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r13 == false) goto L38;
        DataCenter r14 = this.z;
        if (r14 == null) goto L38;
        r14.observe("data_room_preload", new i(this));
        goto L38
    L31:
        if (vm2.h.W().enablePreAdjustRenderView() == false) goto L33;
        r13 = true;
        goto L34
    L5:
        if ((r7 instanceof Activity) == true) goto L7;
        r7 = null;
    L7:
        r8 = com.bytedance.android.livesdk.chatroom.utils.a2.e((Activity) r7);
        goto L9
    }

    public static final void b(InteractPlayViewManager r3, ClientUIInfo r4) {
        r3.getClass();
        if (h30.a.getValue().booleanValue() == false) goto L10;
        r3.t = r4;
        r3.u = false;
        LivePlayerView r5 = r3.i;
        if (r5 == null) goto L9;
        r3.i(r3.s, r5, r3.j, true);
        return;
    L9:
        return;
    }

    public final ILivePlayerClient getPreviewClient(IRenderView r3, long r4) {
        if (r3 == null) goto L5;
        ViewParent r5 = r3.getParent();
    L7:
        if ((r5 instanceof LivePlayerView) == true) goto L9;
        r5 = null;
    L9:
        LivePlayerView r6 = (LivePlayerView) r5;
        if (r6 == null) goto L15;
        ILivePlayerClient r7 = r6.getClient();
        if (r7 == null) goto L15;
        return r7;
    L15:
        IMiddlewareLiveService r8 = TTLiveServiceMiddleware.getLiveService();
        if (r8 == null) goto L22;
        ILivePlayerService r9 = r8.livePlayerService();
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.createClient(LivePlayerConfig.Companion.buildWith(ILivePlayerScene.Companion.preview(), r4));
    L22:
        return null;
    L5:
        r5 = null;
        goto L7
    }

    public final ParseSeiData getParseSeiDataBySei(String r25, JSONObject r26, JSONObject r27) {
        Intrinsics.checkNotNullParameter(r25, "sei");
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L6;
        if (r26 == null) goto L6;
        JSONObject r6 = r26;
    L7:
        ParseSeiData r7 = null;
        if (r6 != null) goto L68;
    L66:
        this.y = r7;
        return r7;
    L68:
    L64:
        e = move-exception;
        ALogger.e("InteractPlayViewManager", "error message: " + e);
        goto L66
    L10:
        if (r6.has("app_data") == false) goto L53;
        String r3 = new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r6, "app_data"), "");     // Catch: JSONException -> L64
        if (Intrinsics.areEqual(r3, "") == true) goto L66;
        if (Intrinsics.areEqual(r3, " ") == true) goto L66;
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L20;
        if (r27 == null) goto L20;
        JSONObject r0 = r27;
    L21:
        JSONObject r12 = r0.optJSONObject("canvas");     // Catch: JSONException -> L64
        int r4 = r0.optInt("ver");     // Catch: JSONException -> L64
        int r11 = r0.optInt("ui_layout");     // Catch: JSONException -> L64
        int r15 = r0.optInt("sub_scene");     // Catch: JSONException -> L64
        String r1 = r0.optString("channel_id");     // Catch: JSONException -> L64
        if (r1 == null) goto L26;
        Long r2 = StringsKt.toLongOrNull(r1);     // Catch: JSONException -> L64
        if (r2 == null) goto L26;
        long r13 = r2.longValue();     // Catch: JSONException -> L64
    L27:
        IRoom r5 = this.j;     // Catch: JSONException -> L64
        if (r5 == null) goto L30;
        Long r8 = Long.valueOf(r5.getRoomId());     // Catch: JSONException -> L64
    L31:
        boolean r10 = jc1.k.n(IInteractService.class).isRoomFightUILayout(r11);     // Catch: JSONException -> L64
        if (cb0.a.getValue().booleanValue() == false) goto L40;
        if (r10 == false) goto L40;
        if (r8 != null) goto L37;
    L38:
        ALogger.d("InteractPlayViewManager", "sei channel id wrong " + r13 + " room " + r8);     // Catch: JSONException -> L64
        return this.y;
    L37:
        if (r13 != r8.longValue()) goto L38;
    L40:
        long r9 = this.c;     // Catch: JSONException -> L64
        if (r9 != 0) goto L43;
    L46:
        this.c = r13;     // Catch: JSONException -> L64
        if (r12 != null) goto L49;
        ParseSeiData r14 = new ParseSeiData(r4, r15, r11, null, 0, false, null, 0, 248, null);     // Catch: JSONException -> L64
    L50:
        r7 = r14;
        goto L53
    L49:
        r14 = new ParseSeiData(r4, r15, r11, r12, 0, false, null, 0, 240, null);     // Catch: JSONException -> L64
        goto L50
    L43:
        if (r9 == r13) goto L46;
        if (r4 == 0) goto L46;
        r4 = 0;
        goto L46
    L30:
        r8 = null;
    L26:
        r13 = 0;
    L20:
        r0 = new JSONObject(r3);     // Catch: JSONException -> L64
    L53:
        if (TextUtils.equals(r6.optString(r4), "TTLiveSDK_Android") == false) goto L55;
    L60:
        LivePlayerView r16 = this.i;     // Catch: JSONException -> L64
        if (r16 == null) goto L66;
        g(r16);     // Catch: JSONException -> L64
        goto L66
    L55:
        if (TextUtils.equals(r6.optString(r4), "TTLiveSDK_IOS") == true) goto L60;
        LiveSeiUtil r17 = LiveSeiUtil.i;     // Catch: JSONException -> L64
        String r18 = r6.optString(r4);     // Catch: JSONException -> L64
        r17.getClass();     // Catch: JSONException -> L64
        if (LiveSeiUtil.d(r18) == true) goto L60;
        if (TextUtils.equals(r6.optString("source"), "TTLiveSDK_Windows") == false) goto L66;
    L6:
        r6 = c(r25);
        goto L7
    }

    public final void updateRenderViewLPGravityIfNeed(IRenderView r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        ViewGroup.LayoutParams r0 = null;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
    L7:
        if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r0 = r1;
    L10:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r5 == r2.gravity) goto L17;
        ALogger.i("pc_audio_casting_tag", "updateRenderViewLPGravityIfNeed ;; gravity == " + r5 + " ;; layoutParams.gravity == " + r2.gravity + " ;; source == " + r6);
        r2.gravity = r5;
        r4.setLayoutParams(r2);
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void i(String r21, LivePlayerView r22, IRoom r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r21, "sei");
        Intrinsics.checkNotNullParameter(r22, "livePlayerView");
        if (m() == false) goto L6;
        return;
    L6:
        if (StringsKt.contains$default(r21, "\\\"ui_layout\\\":27", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r21, "\\\"ui_layout\\\":28", false, 2, null) == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        IRoom r7 = this.j;
        if (r7 == null) goto L28;
        if (r7.isLiveTypeAudio() != true) goto L28;
        IRoom r8 = this.j;
        if (r8 == null) goto L22;
        IRoomBasisData r9 = r8.getBasisRoomData();
        if (r9 == null) goto L22;
        Boolean r10 = r9.isCustomizeAudioRoom();
    L24:
        if ((!Intrinsics.areEqual(r10, Boolean.TRUE)) == false) goto L28;
        if (r3 == true) goto L28;
    L38:
        boolean r4 = false;
    L40:
        if (r4 == true) goto L42;
        return;
    L42:
        this.s = r21;
        this.i = r22;
        JSONObject r5 = c(r21);
        if (r5 == null) goto L103;
    L99:
        e = move-exception;
        ALogger.e("InteractPlayViewManager", "error message: " + e);
        return;
    L45:
        if (r5.has("app_data") == false) goto L97;
        JSONObject r6 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r5, "app_data"), ""));     // Catch: JSONException -> L99
        JSONObject r11 = r6.optJSONObject("canvas");     // Catch: JSONException -> L99
        int r12 = r6.optInt("ver");     // Catch: JSONException -> L99
        int r13 = r6.optInt("ui_layout");     // Catch: JSONException -> L99
        if (this.t == null) goto L49;
    L55:
        Map r1 = (Map) com.bytedance.android.livesdk.j2.a.getValue();     // Catch: JSONException -> L99
        if (r11 != null) goto L59;
        TalkRoomBusinessFullLinkMonitor.a.getClass();     // Catch: JSONException -> L99
        Intrinsics.checkNotNullParameter(r21, "seiString");     // Catch: JSONException -> L99
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L99
        r15.put("sei", r21);     // Catch: JSONException -> L99
        nd0.c.o(nd0.c.a, LinkMonitorData.SeiCanvasIsNullMonitorData, r15, 0, null, false, 28);     // Catch: JSONException -> L99
    L59:
        if (r12 >= 8) goto L70;
        if (f(r12, r13) == true) goto L70;
        if (r12 == 3) goto L65;
    L67:
        boolean r0 = false;
    L68:
        if (r0 == true) goto L70;
    L74:
        g(r22);     // Catch: JSONException -> L99
        return;
    L65:
        if (r13 != 27) goto L67;
        r0 = true;
    L70:
        if (r1.containsKey(Integer.valueOf(r12)) == true) goto L76;
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r12, r13) == false) goto L74;
    L76:
        if (hb0.a.getValue().booleanValue() == true) goto L78;
    L80:
        boolean r2 = false;
    L82:
        if (this.e != r12) goto L94;
        if (r2 == true) goto L94;
        if (r24 == true) goto L94;
        if (FoldScreenUtils.f() == false) goto L92;
        if (FoldScreenUtils.a() == this.q) goto L92;
        this.q = FoldScreenUtils.a();     // Catch: JSONException -> L99
        l(this, r12, r13, r11, r22, r23, null, 32);     // Catch: JSONException -> L99
        boolean r14 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: JSONException -> L99
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.m, true);     // Catch: JSONException -> L99
    L92:
        if (this.r == false) goto L105;
        this.r = false;     // Catch: JSONException -> L99
        boolean r16 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: JSONException -> L99
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.m, true);     // Catch: JSONException -> L99
        return;
    L105:
        return;
    L94:
        this.e = r12;     // Catch: JSONException -> L99
        this.q = FoldScreenUtils.a();     // Catch: JSONException -> L99
        l(this, r12, r13, r11, r22, r23, null, 32);     // Catch: JSONException -> L99
        this.l = System.currentTimeMillis();     // Catch: JSONException -> L99
        if (jc1.k.n(IInteractService.class).isPCLandscape(r12, 0) == true) goto L107;
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: JSONException -> L99
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.m, true);     // Catch: JSONException -> L99
        return;
    L107:
        return;
    L78:
        if ((System.currentTimeMillis() - this.l) <= this.n) goto L80;
        r2 = true;
        goto L82
    L49:
        if (r6.has("ui_feature_list") == false) goto L55;
        if (this.u == false) goto L55;
        if (h30.a.getValue().booleanValue() == false) goto L55;
        this.u = false;     // Catch: JSONException -> L99
        JSONArray r18 = JSONObjectProtectorUtils.getJSONArray(r6, "ui_feature_list");     // Catch: JSONException -> L99
        JSONObject r19 = new JSONObject();     // Catch: JSONException -> L99
        r19.put("ui_feature_list", r18);     // Catch: JSONException -> L99
        this.t = (ClientUIInfo) GsonProtectorUtils.fromJson(GsonHelper.get(), r19.toString(), new k().getType());     // Catch: JSONException -> L99
        goto L55
    L97:
        g(r22);     // Catch: JSONException -> L99
        return;
    L103:
        return;
    L22:
        r10 = null;
    L28:
        if (StringsKt.contains$default(r21, "TTLiveSDK_Android", false, 2, null) == false) goto L30;
    L39:
        r4 = true;
        goto L40
    L30:
        if (StringsKt.contains$default(r21, "TTLiveSDK_IOS", false, 2, null) == true) goto L39;
        if (StringsKt.contains$default(r21, "TTLiveSDK_Windows", false, 2, null) == true) goto L39;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.d(r21) == true) goto L39;
        if (StringsKt.contains$default(r21, "app_data", false, 2, null) == false) goto L38;
    L10:
        if (StringsKt.contains$default(r21, "show_player", false, 2, null) == false) goto L12;
        r3 = true;
        goto L13
    }

    public final void j(com.bytedance.android.livesdk.config.l8 r19, int r20, JSONObject r21, LivePlayerView r22, IRoom r23) {
        if (m() == false) goto L5;
        return;
    L5:
        this.e = r20;
        int r5 = com.bytedance.android.live.core.utils.s1.z();
        int r7 = 640;
        int r8 = 360;
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L34;
        StringBuilder r6 = new StringBuilder("canvas.width == ");
        if (r21 == null) goto L10;
        Integer r13 = Integer.valueOf(r21.optInt("width"));
    L11:
        r6.append(r13);
        r6.append(" ;; canvas.height == ");
        if (r21 == null) goto L14;
        Integer r14 = Integer.valueOf(r21.optInt("height"));
    L15:
        r6.append(r14);
        r6.append(" ;; seiVersion == ");
        r6.append(r20);
        ALogger.w("InteractPlayViewManager", r6.toString());
        if (r21 != null) goto L18;
    L19:
        if (r21 != null) goto L21;
    L23:
        if (r21 != null) goto L25;
    L26:
        if (r21 != null) goto L28;
    L30:
        if (r21 == null) goto L32;
        r7 = r21.optInt("height");
    L32:
        if (r21 == null) goto L38;
        r8 = r21.optInt("width");
    L38:
        if (r19 == null) goto L456;
        if (r23 == null) goto L457;
        IStreamUrlExtra r2 = r23.getStreamUrlExtraSafely();
        if (r2 == null) goto L458;
        int r3 = r2.getWidth();
        IStreamUrlExtra r9 = r23.getStreamUrlExtraSafely();
        if (r9 == null) goto L45;
        Integer r10 = Integer.valueOf(r9.getHeight());
    L46:
        int r11 = r10.intValue();
        if ((r22 instanceof View) == true) goto L49;
        LivePlayerView r12 = null;
    L51:
        if (r12 == null) goto L53;
        r12.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L53:
        IRenderView r15 = r22.getRenderView();
        if ((r15 instanceof View) == true) goto L56;
        r15 = null;
    L56:
        View r16 = (View) r15;
        if (r16 == null) goto L59;
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L59:
        IRenderView r17 = r22.getRenderView();
        if ((r17 instanceof View) == true) goto L62;
        r17 = null;
    L62:
        View r18 = (View) r17;
        if (r18 == null) goto L66;
        r18.setTranslationY(0.0f);
    L66:
        if ((r22.getRenderView() instanceof SurfaceView) == true) goto L68;
    L70:
        boolean r110 = false;
    L72:
        if (xj0.a.getValue().getPreviewSurfaceRender() == false) goto L74;
        if (r110 == false) goto L74;
    L81:
        if (FoldScreenUtils.f() == false) goto L106;
        if (FoldScreenUtils.a() != 0) goto L106;
        if (r20 == 9) goto L86;
        if (r20 != 11) goto L106;
    L86:
        r22.setScaleType(0);
        IRenderView r4 = r22.getRenderView();
        if ((r4 instanceof View) == true) goto L89;
        r4 = null;
    L89:
        View r24 = (View) r4;
        if (r24 == null) goto L92;
        r24.post(new l(this, r23, r22));
    L92:
        IRenderView r25 = r22.getRenderView();
        if ((r25 instanceof View) == true) goto L95;
        r25 = null;
    L95:
        View r26 = (View) r25;
        if (r26 == null) goto L98;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
    L100:
        if ((r27 instanceof FrameLayout.LayoutParams) == true) goto L102;
        r27 = null;
    L102:
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r27;
        if (r28 == null) goto L341;
        r28.gravity = 1;
        Unit r29 = Unit.INSTANCE;
    L341:
        StringBuilder r30 = new StringBuilder("after resize ;; renderView.topMargin == ");
        IRenderView r31 = r22.getRenderView();
        if ((r31 instanceof View) == true) goto L344;
        r31 = null;
    L344:
        View r32 = (View) r31;
        if (r32 == null) goto L347;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
    L349:
        if ((r33 instanceof FrameLayout.LayoutParams) == true) goto L351;
        r33 = null;
    L351:
        FrameLayout.LayoutParams r34 = (FrameLayout.LayoutParams) r33;
        if (r34 == null) goto L354;
        Integer r35 = Integer.valueOf(r34.topMargin);
    L355:
        r30.append(r35);
        r30.append("  ;;  renderView.scaleType == ");
        r30.append(r22.getRenderView().getScaleType());
        r30.append(" ;; renderView.gravity == ");
        ViewGroup.LayoutParams r36 = r22.getRenderView().getLayoutParams();
        if ((r36 instanceof FrameLayout.LayoutParams) == true) goto L358;
        r36 = null;
    L358:
        FrameLayout.LayoutParams r37 = (FrameLayout.LayoutParams) r36;
        if (r37 == null) goto L361;
        Integer r38 = Integer.valueOf(r37.gravity);
    L362:
        r30.append(r38);
        r30.append(" ;; seiVersion ==  ");
        r30.append(r20);
        ALogger.w("InteractPlayViewManager", r30.toString());
        IRenderView r1 = r22.getRenderView();
        if ((r1 instanceof View) == true) goto L365;
        r1 = null;
    L365:
        View r39 = (View) r1;
        if (r39 == null) goto L369;
        r39.requestLayout();
        Unit r40 = Unit.INSTANCE;
    L369:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L428;
        if (this.b != 0) goto L428;
        LivePlayerView r41 = this.i;
        if (r41 == null) goto L377;
        ViewParent r42 = r41.getParent();
        if (r42 == null) goto L377;
        ViewParent r43 = r42.getParent();
    L379:
        if ((r43 instanceof FrameLayout) == true) goto L381;
        r43 = null;
    L381:
        FrameLayout r44 = (FrameLayout) r43;
        if (r44 == null) goto L384;
        r44.post(new o6(this));
    L384:
        int r45 = this.e;
        if (r45 != 10) goto L387;
    L388:
        LivePlayerView r46 = this.i;
        if (r46 == null) goto L391;
        Object r47 = r46.getParent();
    L393:
        if ((r47 instanceof View) == true) goto L395;
        r47 = null;
    L395:
        View r48 = (View) r47;
        if (r48 == null) goto L398;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
    L400:
        if ((r49 instanceof FrameLayout.LayoutParams) == true) goto L402;
        r49 = null;
    L402:
        FrameLayout.LayoutParams r50 = (FrameLayout.LayoutParams) r49;
        if (r50 == null) goto L405;
        Integer r51 = Integer.valueOf(r50.rightMargin);
    L406:
        if (r51 != null) goto L409;
    L410:
        LivePlayerView r52 = this.i;
        if (r52 == null) goto L413;
        Object r53 = r52.getParent();
    L415:
        if ((r53 instanceof View) == true) goto L417;
        r53 = null;
    L417:
        View r54 = (View) r53;
        if (r54 == null) goto L420;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
    L422:
        if ((r55 instanceof FrameLayout.LayoutParams) == true) goto L424;
        r55 = null;
    L424:
        FrameLayout.LayoutParams r56 = (FrameLayout.LayoutParams) r55;
        if (r56 == null) goto L428;
        r56.rightMargin = 0;
        goto L428
    L420:
        r55 = null;
        goto L422
    L413:
        r53 = null;
        goto L415
    L409:
        if (r51.intValue() == 0) goto L428;
    L405:
        r51 = null;
        goto L406
    L398:
        r49 = null;
        goto L400
    L391:
        r47 = null;
        goto L393
    L387:
        if (r45 != 28) goto L428;
    L377:
        r43 = null;
    L428:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == true) goto L430;
    L453:
        Unit r57 = Unit.INSTANCE;
        return;
    L430:
        if (com.bytedance.android.livesdk.chatroom.utils.a2.p(this.e) == true) goto L434;
        int r58 = 0;
        if (com.bytedance.android.livesdk.chatroom.utils.a2.n(this.e, 0) == false) goto L453;
    L435:
        DataCenter r59 = this.z;
        if (r59 == null) goto L440;
        Integer r60 = (Integer) r59.get("cmd_interact_player_view_diff_height", Integer.valueOf(r58));
        if (r60 == null) goto L440;
        int r111 = r60.intValue();
    L441:
        LivePlayerView r61 = this.i;
        if (r61 == null) goto L444;
        IRenderView r62 = r61.getRenderView();
    L446:
        if ((r62 instanceof View) == true) goto L448;
        IRenderView r63 = null;
    L449:
        View r64 = (View) r63;
        if (r64 == null) goto L452;
        r64.setTranslationY(-r111);
    L452:
        ALogger.w("InteractPlayViewManager", "adjustRenderViewParentHeight ;; (mLivePlayView?.renderView as? View)?.translationY == " + (-r111));
        goto L453
    L448:
        r63 = r62;
        goto L449
    L444:
        r62 = null;
    L440:
        r111 = 0;
        goto L441
    L434:
        r58 = 0;
        goto L435
    L361:
        r38 = null;
        goto L362
    L354:
        r35 = null;
        goto L355
    L347:
        r33 = null;
        goto L349
    L98:
        r27 = null;
    L106:
        if (fx0.a.getValue().booleanValue() == false) goto L132;
        if (r20 == 9) goto L113;
        if (r20 == 11) goto L113;
        if (r20 == 13) goto L113;
        if (r20 != 16) goto L132;
    L113:
        if ((r11 * r5) <= (this.p * r3)) goto L132;
        if (FoldScreenUtils.e() == false) goto L117;
    L118:
        r22.setScaleType(0);
        IRenderView r65 = r22.getRenderView();
        if ((r65 instanceof View) == true) goto L121;
        r65 = null;
    L121:
        View r66 = (View) r65;
        if (r66 == null) goto L124;
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();
    L126:
        if ((r67 instanceof FrameLayout.LayoutParams) == true) goto L128;
        r67 = null;
    L128:
        FrameLayout.LayoutParams r68 = (FrameLayout.LayoutParams) r67;
        if (r68 == null) goto L341;
        r68.gravity = 1;
        Unit r69 = Unit.INSTANCE;
        goto L341
    L124:
        r67 = null;
        goto L126
    L117:
        if (PadConfigUtils.c() == true) goto L118;
    L132:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L144;
        if (com.bytedance.android.livesdk.chatroom.utils.a2.p(r20) == false) goto L137;
        r22.getRenderView().setScaleType(2);
        goto L144
    L137:
        if (com.bytedance.android.livesdk.chatroom.utils.a2.n(r20, 0) == false) goto L140;
        r22.getRenderView().setScaleType(2);
        goto L144
    L140:
        if (com.bytedance.android.livesdk.chatroom.utils.a2.j(r20) == false) goto L142;
        r22.getRenderView().setScaleType(3);
        goto L144
    L142:
        r22.getRenderView().setScaleType(2);
    L144:
        if (r19.f() != RenderViewScaleType.WIDTH_ALIGN.getValue()) goto L266;
        int r70 = (int) (((r5 - com.bytedance.android.live.core.utils.s1.f(r19.d())) - com.bytedance.android.live.core.utils.s1.f(r19.e())) / r19.c().b());
        this.f = r70;
        this.g = (int) (((r70 * 1.0f) / r8) * r7);
        IRenderView r71 = r22.getRenderView();
        if ((r71 instanceof View) == true) goto L148;
        r71 = null;
    L148:
        View r72 = (View) r71;
        if (r72 == null) goto L153;
        ViewGroup.LayoutParams r73 = r72.getLayoutParams();
        if (r73 == null) goto L153;
        r73.width = this.f;
        r73.height = this.g;
        Unit r75 = Unit.INSTANCE;
    L153:
        IRenderView r76 = r22.getRenderView();
        if ((r76 instanceof View) == true) goto L156;
        r76 = null;
    L156:
        View r77 = (View) r76;
        if (r77 == null) goto L159;
        ViewGroup.LayoutParams r78 = r77.getLayoutParams();
    L161:
        if ((r78 instanceof FrameLayout.LayoutParams) == true) goto L163;
        r78 = null;
    L163:
        FrameLayout.LayoutParams r79 = (FrameLayout.LayoutParams) r78;
        if (r79 == null) goto L167;
        r79.gravity = 8388611;
        r79.leftMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r19.d()) - ((this.f * 1.0f) * r19.c().c()));
        Unit r80 = Unit.INSTANCE;
    L167:
        if (this.g <= this.p) goto L169;
        int r81 = r19.a().a();
    L171:
        if (r81 != AlignModeType.TOP_ALIGN.getValue()) goto L190;
        IRenderView r82 = r22.getRenderView();
        if ((r82 instanceof View) == true) goto L175;
        r82 = null;
    L175:
        View r83 = (View) r82;
        if (r83 == null) goto L178;
        ViewGroup.LayoutParams r84 = r83.getLayoutParams();
    L180:
        if ((r84 instanceof FrameLayout.LayoutParams) == true) goto L182;
        r84 = null;
    L182:
        FrameLayout.LayoutParams r85 = (FrameLayout.LayoutParams) r84;
        if (r85 == null) goto L222;
        r85.gravity = 48;
        this.h = (int) (com.bytedance.android.live.core.utils.s1.f(r19.h()) - ((this.g * 1.0f) * r19.c().d()));
        if (e() == false) goto L187;
        r85.topMargin = this.h + StatusBarUtil.getStatusBarHeight(this.A);
    L188:
        com.bytedance.android.live.core.utils.s1.f(r19.h());
        r19.c().d();
        goto L222
    L187:
        r85.topMargin = this.h;
    L222:
        IRenderView r86 = r22.getRenderView();
        if ((r86 instanceof View) == true) goto L225;
        r86 = null;
    L225:
        View r87 = (View) r86;
        if (r87 == null) goto L228;
        int r88 = r87.getTop();
    L229:
        IRenderView r112 = r22.getRenderView();
        if ((r112 instanceof View) == true) goto L232;
        r112 = null;
    L232:
        View r113 = (View) r112;
        if (r113 == null) goto L235;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
    L237:
        if ((r114 instanceof FrameLayout.LayoutParams) == true) goto L239;
        r114 = null;
    L239:
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        if (r115 == null) goto L242;
        int r116 = r115.topMargin;
    L244:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L266;
        int r117 = this.b;
        if (r117 != 3) goto L248;
    L253:
        boolean r89 = true;
    L254:
        if (r89 == true) goto L256;
        if (r117 != 0) goto L266;
    L256:
        if (r116 < 0) goto L266;
        if (r88 == r116) goto L266;
        IRenderView r90 = r22.getRenderView();
        if ((r90 instanceof View) == true) goto L261;
        r90 = null;
    L261:
        View r91 = (View) r90;
        if (r91 == null) goto L264;
        r91.setTop(r116);
    L264:
        ALogger.w("InteractPlayViewManager", "resizePlayView ;; showFrom == " + this.b + " ;; topMargin == " + r116 + " ;; top == " + r88);
        goto L266
    L248:
        if (r117 == 4) goto L253;
        if (r117 == 0) goto L253;
        if (r117 == 2) goto L253;
        r89 = false;
        goto L254
    L242:
        r116 = 0;
        goto L244
    L235:
        r114 = null;
        goto L237
    L228:
        r88 = 0;
        goto L229
    L178:
        r84 = null;
        goto L180
    L190:
        if (r81 != AlignModeType.VERTICAL_CENTER_ALIGN.getValue()) goto L208;
        IRenderView r92 = r22.getRenderView();
        if ((r92 instanceof View) == true) goto L194;
        r92 = null;
    L194:
        View r93 = (View) r92;
        if (r93 == null) goto L197;
        ViewGroup.LayoutParams r94 = r93.getLayoutParams();
    L199:
        if ((r94 instanceof FrameLayout.LayoutParams) == true) goto L201;
        r94 = null;
    L201:
        FrameLayout.LayoutParams r95 = (FrameLayout.LayoutParams) r94;
        if (r95 == null) goto L222;
        r95.gravity = 16;
        if (e() == false) goto L206;
        r95.topMargin = StatusBarUtil.getStatusBarHeight(this.A);
    L206:
        this.h = (this.p - this.g) / 2;
        Unit r96 = Unit.INSTANCE;
        goto L222
    L197:
        r94 = null;
        goto L199
    L208:
        if (r81 != AlignModeType.BOTTOM_ALIGN.getValue()) goto L222;
        IRenderView r97 = r22.getRenderView();
        if ((r97 instanceof View) == true) goto L212;
        r97 = null;
    L212:
        View r98 = (View) r97;
        if (r98 == null) goto L215;
        ViewGroup.LayoutParams r99 = r98.getLayoutParams();
    L217:
        if ((r99 instanceof FrameLayout.LayoutParams) == true) goto L219;
        r99 = null;
    L219:
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) r99;
        if (r100 == null) goto L222;
        r100.gravity = 80;
        int r118 = (int) (com.bytedance.android.live.core.utils.s1.f(r19.b()) - ((this.g * 1.0f) * ((1 - r19.c().d()) - r19.c().a())));
        r100.bottomMargin = r118;
        this.h = (this.p - this.g) - r118;
        Unit r101 = Unit.INSTANCE;
        goto L222
    L215:
        r99 = null;
        goto L217
    L169:
        r81 = r19.g().a();
        goto L171
    L159:
        r78 = null;
    L266:
        if (r19.f() != RenderViewScaleType.HEIGHT_ALIGN.getValue()) goto L341;
        int r102 = (int) (((this.p - com.bytedance.android.live.core.utils.s1.f(r19.h())) - com.bytedance.android.live.core.utils.s1.f(r19.b())) / r19.c().a());
        this.g = r102;
        this.f = (int) (((r102 * 1.0f) / r7) * r8);
        IRenderView r103 = r22.getRenderView();
        if ((r103 instanceof View) == true) goto L270;
        r103 = null;
    L270:
        View r104 = (View) r103;
        if (r104 == null) goto L275;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L275;
        r105.width = this.f;
        r105.height = this.g;
        Unit r106 = Unit.INSTANCE;
    L275:
        IRenderView r107 = r22.getRenderView();
        if ((r107 instanceof View) == true) goto L278;
        r107 = null;
    L278:
        View r108 = (View) r107;
        if (r108 == null) goto L281;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L283:
        if ((r109 instanceof FrameLayout.LayoutParams) == true) goto L285;
        r109 = null;
    L285:
        FrameLayout.LayoutParams r119 = (FrameLayout.LayoutParams) r109;
        if (r119 == null) goto L293;
        r119.gravity = 48;
        this.h = (int) (com.bytedance.android.live.core.utils.s1.f(r19.h()) - ((this.g * 1.0f) * r19.c().d()));
        if (e() == false) goto L290;
        r119.topMargin = this.h + StatusBarUtil.getStatusBarHeight(this.A);
    L291:
        Unit r120 = Unit.INSTANCE;
        goto L293
    L290:
        r119.topMargin = this.h;
    L293:
        if (this.f <= r5) goto L295;
        int r121 = r19.a().a();
    L297:
        if (r121 != AlignModeType.LEFT_ALIGN.getValue()) goto L312;
        IRenderView r122 = r22.getRenderView();
        if ((r122 instanceof View) == true) goto L301;
        r122 = null;
    L301:
        View r123 = (View) r122;
        if (r123 == null) goto L304;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
    L306:
        if ((r124 instanceof FrameLayout.LayoutParams) == true) goto L308;
        r124 = null;
    L308:
        FrameLayout.LayoutParams r125 = (FrameLayout.LayoutParams) r124;
        if (r125 == null) goto L341;
        r125.gravity = 8388611;
        r125.leftMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r19.d()) - ((this.f * 1.0f) * r19.c().c()));
        Unit r126 = Unit.INSTANCE;
        goto L341
    L304:
        r124 = null;
        goto L306
    L312:
        if (r121 != AlignModeType.HORIZONTAL_CENTER_ALIGN.getValue()) goto L327;
        IRenderView r127 = r22.getRenderView();
        if ((r127 instanceof View) == true) goto L316;
        r127 = null;
    L316:
        View r128 = (View) r127;
        if (r128 == null) goto L319;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
    L321:
        if ((r129 instanceof FrameLayout.LayoutParams) == true) goto L323;
        r129 = null;
    L323:
        FrameLayout.LayoutParams r130 = (FrameLayout.LayoutParams) r129;
        if (r130 == null) goto L341;
        r130.gravity = 1;
        int r131 = (r5 - this.f) / 2;
        Unit r132 = Unit.INSTANCE;
        goto L341
    L319:
        r129 = null;
        goto L321
    L327:
        if (r121 != AlignModeType.RIGHT_ALIGN.getValue()) goto L341;
        IRenderView r133 = r22.getRenderView();
        if ((r133 instanceof View) == true) goto L331;
        r133 = null;
    L331:
        View r134 = (View) r133;
        if (r134 == null) goto L334;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
    L336:
        if ((r135 instanceof FrameLayout.LayoutParams) == true) goto L338;
        r135 = null;
    L338:
        FrameLayout.LayoutParams r136 = (FrameLayout.LayoutParams) r135;
        if (r136 == null) goto L341;
        r136.gravity = 8388613;
        r136.rightMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r19.e()) - ((this.f * 1.0f) * ((1 - r19.c().c()) - r19.c().b())));
        Unit r137 = Unit.INSTANCE;
        goto L341
    L334:
        r135 = null;
        goto L336
    L295:
        r121 = r19.g().a();
        goto L297
    L281:
        r109 = null;
    L74:
        IRenderView r138 = r22.getRenderView();
        if ((r138 instanceof View) == true) goto L77;
        r138 = null;
    L77:
        View r139 = (View) r138;
        if (r139 == null) goto L81;
        r139.setTranslationX(0.0f);
        goto L81
    L68:
        if (Intrinsics.areEqual(LivePlayerScene.INSTANCE.getFEED_PREVIEW(), r22.getClient().context().getUseScene()) == false) goto L70;
        r110 = true;
        goto L72
    L49:
        r12 = r22;
        goto L51
    L45:
        r10 = null;
        goto L46
    L458:
        return;
    L457:
        return;
    L456:
        return;
    L28:
        if (r21.optInt("width") != 0) goto L30;
    L25:
        if (r21.optInt("height") == 0) goto L38;
    L21:
        if (r21.optInt("width") != 64) goto L23;
        return;
    L18:
        if (r21.optInt("height") != 64) goto L19;
        return;
    L14:
        r14 = null;
        goto L15
    L10:
        r13 = null;
        goto L11
    L34:
        if (r21 == null) goto L36;
        r7 = r21.optInt("height");
    L36:
        if (r21 == null) goto L38;
        r8 = r21.optInt("width");
        goto L38
    }

    public final void k(int r25, int r26, JSONObject r27, LivePlayerView r28, IRoom r29) {
        if (m() == false) goto L5;
        return;
    L5:
        Integer r1 = null;
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r25, r26) == false) goto L73;
        Object r0 = r28.getParent();
        if ((r0 instanceof View) == true) goto L10;
        r0 = null;
    L10:
        View r2 = (View) r0;
        if (r2 == null) goto L22;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L22;
        Integer r4 = Integer.valueOf(r3.width);
        if (r4.intValue() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L22;
    L29:
        if (r4 == null) goto L31;
        int r6 = r4.intValue();
    L32:
        int r7 = r6;
        Object r8 = r28.getParent();
        if ((r8 instanceof View) == true) goto L35;
        r8 = null;
    L35:
        View r9 = (View) r8;
        if (r9 == null) goto L49;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L49;
        Integer r11 = Integer.valueOf(r10.height);
        if (r11.intValue() <= 0) goto L42;
        boolean r12 = true;
    L43:
        if (r12 == true) goto L46;
        r11 = null;
    L46:
        if (r11 == null) goto L49;
        r1 = r11;
    L55:
        if (r1 == null) goto L57;
        int r13 = r1.intValue();
    L58:
        int r14 = r13;
        DataCenter r15 = this.z;
        if (r15 == null) goto L63;
        Boolean r16 = (Boolean) r15.get("status_bar_is_visible", Boolean.TRUE);
        if (r16 == null) goto L63;
        boolean r17 = r16.booleanValue();
    L64:
        Pair r18 = jc1.k.n(IInteractService.class).getSizeForXScreenAdjust(r25, r26, r7, r14);
        Triple r19 = new Triple(r18.getFirst(), r18.getSecond(), "InteractPlayViewManager#resizePlayView");
        IInteractService r110 = jc1.k.n(IInteractService.class);
        if (this.b == 0) goto L67;
        boolean r111 = true;
    L68:
        pn0.i r20 = new pn0.i(false);
        ClientUIInfo r21 = this.t;
        DataCenter r22 = this.z;
        p6 r23 = new p6(this, r25, r26, r27, r28, r29, r7, r14);
        if (r29 == null) goto L71;
        long r24 = r29.getId();
    L72:
        r110.getLayoutConfigFromGecko(r25, r26, r111, r17, 0, r20, false, r19, r21, r22, r23, r24);
        return;
    L71:
        r24 = 0;
        goto L72
    L67:
        r111 = false;
    L63:
        r17 = true;
        goto L64
    L57:
        r13 = this.p;
        goto L58
    L42:
        r12 = false;
    L49:
        Object r30 = r28.getParent();
        if ((r30 instanceof View) == true) goto L52;
        r30 = null;
    L52:
        View r31 = (View) r30;
        if (r31 == null) goto L55;
        r1 = Integer.valueOf(r31.getHeight());
        goto L55
    L31:
        r6 = com.bytedance.android.live.core.utils.s1.z();
        goto L32
    L17:
        r5 = false;
    L22:
        Object r32 = r28.getParent();
        if ((r32 instanceof View) == true) goto L25;
        r32 = null;
    L25:
        View r33 = (View) r32;
        if (r33 == null) goto L28;
        r4 = Integer.valueOf(r33.getWidth());
        goto L29
    L28:
        r4 = null;
        goto L29
    L73:
        com.bytedance.android.livesdk.config.l8 r34 = (com.bytedance.android.livesdk.config.l8) ((Map) com.bytedance.android.livesdk.j2.a.getValue()).get(Integer.valueOf(r25));
        if (r29 == null) goto L76;
        IRoom r35 = (IRoom) jm2.a.e((vh7.c) r29);
    L77:
        j(r34, r25, r27, r28, r35);
        return;
    L76:
        r35 = null;
        goto L77
    }

    public final void resizeRenderViewBeforeFirstFrame(String r10, LivePlayerView r11, IRoom r12, int r13, ParseSeiData r14) {
        Intrinsics.checkNotNullParameter(r10, "sei");
        Intrinsics.checkNotNullParameter(r11, "livePlayerView");
        Intrinsics.checkNotNullParameter(r14, "parseSeiData");
        this.b = r13;
        if (m() == false) goto L6;
        return;
    L6:
        if (r14.getSeiVersion() >= 8) goto L24;
        if (f(r14.getSeiVersion(), r14.getSeiUiLayout()) == true) goto L24;
        int r0 = r14.getSeiVersion();
        int r1 = r14.getSeiUiLayout();
        boolean r3 = true;
        if (r0 == 3) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L24;
        int r4 = r14.getSeiVersion();
        int r5 = r14.getSeiUiLayout();
        if (r4 == 3) goto L19;
    L21:
        r3 = false;
    L22:
        if (r3 == true) goto L24;
        return;
    L19:
        if (r5 != 28) goto L21;
    L12:
        if (r1 != 27) goto L14;
        r2 = true;
    L24:
        if (this.e == r14.getSeiVersion()) goto L32;
        i(r10, r11, r12, false);
        IRenderView r6 = r11.getRenderView();
        IRenderView r15 = r11.getRenderView();
        if (r12 == null) goto L28;
        long r16 = r12.getRoomId();
    L29:
        savePreviewPlayerRenderViewLayoutParams(r6, "live_multi_video_scene_render_view_params", getPreviewClient(r15, r16), r13, r14.getSeiVersion());
        return;
    L28:
        r16 = 0;
        goto L29
    }

    public final void savePreviewPlayerRenderViewLayoutParams(IRenderView r4, String r5, ILivePlayerClient r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "key");
        if (tb1.c.a == true) goto L5;
        return;
    L5:
        if (r7 != 3) goto L7;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == false) goto L78;
        boolean r10 = r4 instanceof View;
        ViewGroup.LayoutParams r11 = null;
        if (r10 == true) goto L18;
        IRenderView r0 = null;
    L19:
        View r1 = (View) r0;
        if (r1 == null) goto L22;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L24:
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L27;
        r2 = null;
    L27:
        if (((FrameLayout.LayoutParams) r2) == null) goto L46;
        if (r6 == null) goto L42;
        ILivePlayerSharedDataManager r3 = r6.sharedDataManager();
        if (r3 == null) goto L42;
        if (r10 == true) goto L33;
        r4 = null;
    L33:
        View r12 = (View) r4;
        if (r12 == null) goto L36;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
    L38:
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L41;
        r11 = r13;
    L41:
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r11;
        Intrinsics.checkNotNull(r14);
        r3.putSharedData(r5, r14);
        goto L42
    L36:
        r13 = null;
    L42:
        if (r6 == null) goto L79;
        ILivePlayerSharedDataManager r15 = r6.sharedDataManager();
        if (r15 == null) goto L80;
        r15.putSharedData("is_hot_soon", Boolean.FALSE);
        return;
    L80:
        return;
    L79:
        return;
    L46:
        if (r10 == true) goto L48;
        IRenderView r16 = null;
    L49:
        View r17 = (View) r16;
        if (r17 == null) goto L52;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L54:
        if ((r18 instanceof RelativeLayout.LayoutParams) == true) goto L57;
        r18 = null;
    L57:
        if (((RelativeLayout.LayoutParams) r18) == null) goto L82;
        if (r6 == null) goto L72;
        ILivePlayerSharedDataManager r19 = r6.sharedDataManager();
        if (r19 == null) goto L72;
        if (r10 == true) goto L63;
        r4 = null;
    L63:
        View r20 = (View) r4;
        if (r20 == null) goto L66;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
    L68:
        if ((r21 instanceof RelativeLayout.LayoutParams) == false) goto L71;
        r11 = r21;
    L71:
        RelativeLayout.LayoutParams r22 = (RelativeLayout.LayoutParams) r11;
        Intrinsics.checkNotNull(r22);
        r19.putSharedData(r5, r22);
        goto L72
    L66:
        r21 = null;
    L72:
        if (r6 == null) goto L83;
        ILivePlayerSharedDataManager r23 = r6.sharedDataManager();
        if (r23 == null) goto L84;
        r23.putSharedData("is_hot_soon", Boolean.TRUE);
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L52:
        r18 = null;
        goto L54
    L48:
        r16 = r4;
        goto L49
    L22:
        r2 = null;
        goto L24
    L18:
        r0 = r4;
        goto L19
    L78:
        return;
    L7:
        if (r7 == 4) goto L13;
        if (r7 == 0) goto L13;
        if (r7 == 2) goto L13;
        r9 = false;
        goto L14
    }

    public final void resizeLinkPlayView(int r7, JSONObject r8, LivePlayerView r9, Context r10, IRoom r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        Intrinsics.checkNotNullParameter(r10, "context");
        this.b = r12;
        if (m() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.config.l8 r1 = (com.bytedance.android.livesdk.config.l8) ((Map) com.bytedance.android.livesdk.j2.a.getValue()).get(Integer.valueOf(r7));
        if (r7 < 8) goto L22;
        if (r1 == null) goto L23;
        if (r9 == null) goto L10;
        j(r1, r7, r8, r9, r11);
    L10:
        IRenderView r13 = null;
        if (r9 == null) goto L13;
        IRenderView r2 = r9.getRenderView();
    L15:
        if (r9 == null) goto L17;
        r13 = r9.getRenderView();
    L17:
        if (r11 == null) goto L19;
        long r14 = r11.getRoomId();
    L20:
        savePreviewPlayerRenderViewLayoutParams(r2, "live_multi_video_scene_render_view_params", getPreviewClient(r13, r14), r12, r7);
        return;
    L19:
        r14 = 0;
        goto L20
    L13:
        r2 = null;
        goto L15
    L23:
        return;
    }

    public final void resizePlayView(int r21, JSONObject r22, IRenderView r23, Context r24, IRoom r25, int r26) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        Intrinsics.checkNotNullParameter(r23, "renderView");
        Intrinsics.checkNotNullParameter(r24, "context");
        this.b = r26;
        if (m() == false) goto L5;
        return;
    L5:
        Map r2 = (Map) com.bytedance.android.livesdk.j2.a.getValue();
        com.bytedance.android.livesdk.config.l8 r7 = (com.bytedance.android.livesdk.config.l8) r2.get(Integer.valueOf(r21));
        if (r21 >= 8) goto L8;
        return;
    L8:
        if (r2.containsKey(Integer.valueOf(r21)) == false) goto L258;
        int r3 = com.bytedance.android.live.core.utils.s1.y();
        if (r7 != null) goto L12;
        return;
    L12:
        if (com.bytedance.android.live.liveinteract.api.utils.c.a() == false) goto L26;
        ALogger.w("InteractPlayViewManager", "canvas.width == " + r22.optInt("width") + " ;; canvas.height == " + r22.optInt("height") + " ;; seiVersion == " + r21);
        if (r22.optInt("height") != 64) goto L16;
        return;
    L16:
        if (r22.optInt("width") != 64) goto L19;
        return;
    L19:
        if (r22.optInt("height") != 0) goto L21;
    L24:
        int r8 = 640;
        int r0 = 360;
    L27:
        Object r9 = r23.getParent();
        if ((r9 instanceof View) == true) goto L30;
        r9 = null;
    L30:
        View r10 = (View) r9;
        if (r10 == null) goto L33;
        r10.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    L33:
        boolean r11 = r23 instanceof View;
        if (r11 == true) goto L36;
        IRenderView r12 = null;
    L37:
        View r13 = (View) r12;
        if (r13 == null) goto L40;
        r13.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    L40:
        if (r11 == true) goto L42;
        IRenderView r14 = null;
    L43:
        View r15 = (View) r14;
        if (r15 == null) goto L47;
        r15.setTranslationY(0.0f);
    L47:
        if (xj0.a.getValue().getPreviewSurfaceRender() == true) goto L49;
    L50:
        if (r11 == true) goto L52;
        IRenderView r16 = null;
    L53:
        View r17 = (View) r16;
        if (r17 == null) goto L57;
        r17.setTranslationX(0.0f);
    L57:
        if (FoldScreenUtils.f() == false) goto L77;
        if (FoldScreenUtils.a() != 0) goto L77;
        if (r21 == 9) goto L62;
        if (r21 != 11) goto L77;
    L62:
        r23.setScaleType(0);
        if (r11 == true) goto L65;
        IRenderView r1 = null;
    L66:
        View r4 = (View) r1;
        if (r4 == null) goto L69;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L71:
        if ((r5 instanceof RelativeLayout.LayoutParams) == true) goto L73;
        r5 = null;
    L73:
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r5;
        if (r6 == null) goto L231;
        r6.addRule(14);
    L231:
        ViewGroup.LayoutParams r18 = r23.getLayoutParams();
        if ((r18 instanceof RelativeLayout.LayoutParams) == true) goto L234;
        r18 = null;
    L234:
        RelativeLayout.LayoutParams r19 = (RelativeLayout.LayoutParams) r18;
        if (r19 == null) goto L244;
        ViewGroup.LayoutParams r20 = r23.getLayoutParams();
        if ((r20 instanceof RelativeLayout.LayoutParams) == true) goto L239;
        r20 = null;
    L239:
        RelativeLayout.LayoutParams r27 = (RelativeLayout.LayoutParams) r20;
        if (r27 == null) goto L242;
        int r110 = r27.topMargin;
    L243:
        r19.topMargin = Math.abs(r110);
        r23.setLayoutParams(r19);
        goto L244
    L242:
        r110 = 0;
    L244:
        if (r11 == true) goto L246;
        IRenderView r111 = null;
    L247:
        View r112 = (View) r111;
        if (r112 == null) goto L251;
        r112.requestLayout();
    L251:
        if (r25 == null) goto L253;
        long r28 = r25.getRoomId();
    L254:
        savePreviewPlayerRenderViewLayoutParams(r23, "live_multi_video_scene_render_view_params", getPreviewClient(r23, r28), r26, r21);
        return;
    L253:
        r28 = 0;
        goto L254
    L246:
        r111 = r23;
        goto L247
    L69:
        r5 = null;
        goto L71
    L65:
        r1 = r23;
    L77:
        if (r7.f() != RenderViewScaleType.WIDTH_ALIGN.getValue()) goto L156;
        int r113 = (int) (((r3 - com.bytedance.android.live.core.utils.s1.f(r7.d())) - com.bytedance.android.live.core.utils.s1.f(r7.e())) / r7.c().b());
        this.f = r113;
        this.g = (int) (((r113 * 1.0f) / r0) * r8);
        if (r11 == true) goto L81;
        IRenderView r114 = null;
    L82:
        View r115 = (View) r114;
        if (r115 == null) goto L87;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L87;
        r116.width = this.f;
        r116.height = this.g;
    L87:
        if (r11 == true) goto L89;
        IRenderView r117 = null;
    L90:
        View r118 = (View) r117;
        if (r118 == null) goto L93;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L95:
        if ((r119 instanceof RelativeLayout.LayoutParams) == true) goto L97;
        r119 = null;
    L97:
        RelativeLayout.LayoutParams r120 = (RelativeLayout.LayoutParams) r119;
        if (r120 == null) goto L101;
        r120.addRule(9);
        r120.leftMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r7.d()) - ((this.f * 1.0f) * r7.c().c()));
    L101:
        if (this.g <= this.p) goto L103;
        int r121 = r7.a().a();
    L105:
        if (r121 != AlignModeType.TOP_ALIGN.getValue()) goto L123;
        if (r11 == true) goto L108;
        IRenderView r122 = null;
    L109:
        View r123 = (View) r122;
        if (r123 == null) goto L112;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
    L114:
        if ((r124 instanceof RelativeLayout.LayoutParams) == true) goto L116;
        r124 = null;
    L116:
        RelativeLayout.LayoutParams r125 = (RelativeLayout.LayoutParams) r124;
        if (r125 == null) goto L156;
        r125.addRule(10);
        this.h = (int) (com.bytedance.android.live.core.utils.s1.f(r7.h()) - ((this.g * 1.0f) * r7.c().d()));
        if (e() == false) goto L121;
        r125.topMargin = this.h + StatusBarUtil.getStatusBarHeight(r24);
        goto L156
    L121:
        r125.topMargin = this.h;
        goto L156
    L112:
        r124 = null;
        goto L114
    L108:
        r122 = r23;
        goto L109
    L123:
        if (r121 != AlignModeType.VERTICAL_CENTER_ALIGN.getValue()) goto L141;
        if (r11 == true) goto L126;
        IRenderView r126 = null;
    L127:
        View r127 = (View) r126;
        if (r127 == null) goto L130;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
    L132:
        if ((r128 instanceof RelativeLayout.LayoutParams) == true) goto L134;
        r128 = null;
    L134:
        RelativeLayout.LayoutParams r129 = (RelativeLayout.LayoutParams) r128;
        if (r129 == null) goto L156;
        r129.addRule(15);
        if (e() == false) goto L139;
        r129.topMargin = StatusBarUtil.getStatusBarHeight(r24);
    L139:
        this.h = (this.p - this.g) / 2;
        goto L156
    L130:
        r128 = null;
        goto L132
    L126:
        r126 = r23;
        goto L127
    L141:
        if (r121 != AlignModeType.BOTTOM_ALIGN.getValue()) goto L156;
        if (r11 == true) goto L144;
        IRenderView r130 = null;
    L145:
        View r131 = (View) r130;
        if (r131 == null) goto L148;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
    L150:
        if ((r132 instanceof RelativeLayout.LayoutParams) == true) goto L152;
        r132 = null;
    L152:
        RelativeLayout.LayoutParams r133 = (RelativeLayout.LayoutParams) r132;
        if (r133 == null) goto L156;
        r133.addRule(12);
        int r134 = (int) (com.bytedance.android.live.core.utils.s1.f(r7.b()) - ((this.g * 1.0f) * ((1 - r7.c().d()) - r7.c().a())));
        r133.bottomMargin = r134;
        this.h = (this.p - this.g) - r134;
        goto L156
    L148:
        r132 = null;
        goto L150
    L144:
        r130 = r23;
        goto L145
    L103:
        r121 = r7.g().a();
        goto L105
    L93:
        r119 = null;
        goto L95
    L89:
        r117 = r23;
        goto L90
    L81:
        r114 = r23;
    L156:
        if (r7.f() != RenderViewScaleType.HEIGHT_ALIGN.getValue()) goto L231;
        int r135 = (int) (((this.p - com.bytedance.android.live.core.utils.s1.f(r7.h())) - com.bytedance.android.live.core.utils.s1.f(r7.b())) / r7.c().a());
        this.g = r135;
        this.f = (int) (((r135 * 1.0f) / r8) * r0);
        if (r11 == true) goto L160;
        IRenderView r29 = null;
    L161:
        View r30 = (View) r29;
        if (r30 == null) goto L166;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L166;
        r31.width = this.f;
        r31.height = this.g;
    L166:
        if (r11 == true) goto L168;
        IRenderView r32 = null;
    L169:
        View r33 = (View) r32;
        if (r33 == null) goto L172;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
    L174:
        if ((r34 instanceof RelativeLayout.LayoutParams) == true) goto L176;
        r34 = null;
    L176:
        RelativeLayout.LayoutParams r35 = (RelativeLayout.LayoutParams) r34;
        if (r35 == null) goto L183;
        r35.addRule(12);
        this.h = (int) (com.bytedance.android.live.core.utils.s1.f(r7.h()) - ((this.g * 1.0f) * r7.c().d()));
        if (e() == false) goto L181;
        r35.topMargin = this.h + StatusBarUtil.getStatusBarHeight(r24);
        goto L183
    L181:
        r35.topMargin = this.h;
    L183:
        if (this.f <= r3) goto L185;
        int r36 = r7.a().a();
    L187:
        if (r36 != AlignModeType.LEFT_ALIGN.getValue()) goto L202;
        if (r11 == true) goto L190;
        IRenderView r37 = null;
    L191:
        View r38 = (View) r37;
        if (r38 == null) goto L194;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
    L196:
        if ((r39 instanceof RelativeLayout.LayoutParams) == true) goto L198;
        r39 = null;
    L198:
        RelativeLayout.LayoutParams r40 = (RelativeLayout.LayoutParams) r39;
        if (r40 == null) goto L231;
        r40.addRule(9);
        r40.leftMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r7.d()) - ((this.f * 1.0f) * r7.c().c()));
        goto L231
    L194:
        r39 = null;
        goto L196
    L190:
        r37 = r23;
        goto L191
    L202:
        if (r36 != AlignModeType.HORIZONTAL_CENTER_ALIGN.getValue()) goto L217;
        if (r11 == true) goto L205;
        IRenderView r41 = null;
    L206:
        View r42 = (View) r41;
        if (r42 == null) goto L209;
        ViewGroup.LayoutParams r43 = r42.getLayoutParams();
    L211:
        if ((r43 instanceof RelativeLayout.LayoutParams) == true) goto L213;
        r43 = null;
    L213:
        RelativeLayout.LayoutParams r44 = (RelativeLayout.LayoutParams) r43;
        if (r44 == null) goto L231;
        r44.addRule(14);
        int r45 = (r3 - this.f) / 2;
        goto L231
    L209:
        r43 = null;
        goto L211
    L205:
        r41 = r23;
        goto L206
    L217:
        if (r36 != AlignModeType.RIGHT_ALIGN.getValue()) goto L231;
        if (r11 == true) goto L220;
        IRenderView r46 = null;
    L221:
        View r47 = (View) r46;
        if (r47 == null) goto L224;
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
    L226:
        if ((r48 instanceof RelativeLayout.LayoutParams) == true) goto L228;
        r48 = null;
    L228:
        RelativeLayout.LayoutParams r49 = (RelativeLayout.LayoutParams) r48;
        if (r49 == null) goto L231;
        r49.addRule(11);
        r49.rightMargin = (int) (com.bytedance.android.live.core.utils.s1.f(r7.e()) - ((this.f * 1.0f) * ((1 - r7.c().c()) - r7.c().b())));
        goto L231
    L224:
        r48 = null;
        goto L226
    L220:
        r46 = r23;
        goto L221
    L185:
        r36 = r7.g().a();
        goto L187
    L172:
        r34 = null;
        goto L174
    L168:
        r32 = r23;
        goto L169
    L160:
        r29 = r23;
        goto L161
    L52:
        r16 = r23;
        goto L53
    L49:
        if ((r23 instanceof SurfaceView) == true) goto L57;
    L42:
        r14 = r23;
        goto L43
    L36:
        r12 = r23;
        goto L37
    L21:
        if (r22.optInt("width") == 0) goto L24;
        r8 = r22.optInt("height");
        r0 = r22.optInt("width");
        goto L27
    L26:
        r8 = r22.optInt("height");
        r0 = r22.optInt("width");
        goto L27
    }

    public final void resizeRenderViewByLastSei(JSONObject r13, IRenderView r14, IRoom r15, int r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        this.b = r16;
        if (m() == false) goto L5;
        return;
    L5:
        Map r0 = (Map) com.bytedance.android.livesdk.j2.a.getValue();
        if (r17 >= 8) goto L10;
        if (f(r17, r18) == true) goto L10;
        return;
    L10:
        if (r0.containsKey(Integer.valueOf(r17)) == true) goto L15;
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r17, r18) == true) goto L15;
        return;
    L15:
        ViewParent r1 = null;
        if (r14 == null) goto L18;
        ViewParent r2 = r14.getParent();
    L20:
        if ((r2 instanceof LivePlayerView) == false) goto L23;
        r1 = r2;
    L23:
        LivePlayerView r4 = (LivePlayerView) r1;
        if (r4 == null) goto L27;
        l(this, r17, r18, r13, r4, r15, null, 32);
    L27:
        if (r15 == null) goto L29;
        long r3 = r15.getRoomId();
    L30:
        savePreviewPlayerRenderViewLayoutParams(r14, "live_multi_video_scene_render_view_params", getPreviewClient(r14, r3), r16, r17);
        return;
    L29:
        r3 = 0;
        goto L30
    L18:
        r2 = null;
        goto L20
    }

    public static /* synthetic */ void l(InteractPlayViewManager r7, int r8, int r9, JSONObject r10, LivePlayerView r11, IRoom r12, Map r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        JSONObject r4 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        IRoom r6 = null;
    L10:
        r7.k(r8, r9, r4, r11, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }

    public final void resizePlayView(int r12, int r13, JSONObject r14, LivePlayerView r15, Context r16, IRoom r17, int r18, Map<String, ? extends Object> r19) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        Intrinsics.checkNotNullParameter(r16, "context");
        this.b = r18;
        if (m() == false) goto L5;
        return;
    L5:
        Map r0 = (Map) com.bytedance.android.livesdk.j2.a.getValue();
        if (r12 >= 8) goto L23;
        if (f(r12, r13) == true) goto L23;
        boolean r1 = true;
        if (r12 == 3) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == true) goto L23;
        if (r12 == 3) goto L18;
    L20:
        r1 = false;
    L21:
        if (r1 == true) goto L23;
        return;
    L18:
        if (r13 != 28) goto L20;
    L12:
        if (r13 != 27) goto L14;
        r6 = true;
    L23:
        if (r0.containsKey(Integer.valueOf(r12)) == false) goto L25;
    L26:
        if (r15 == null) goto L28;
        l(this, r12, r13, r14, r15, null, r19, 16);
    L28:
        IRenderView r2 = null;
        if (r15 == null) goto L31;
        IRenderView r3 = r15.getRenderView();
    L33:
        if (r15 == null) goto L35;
        r2 = r15.getRenderView();
    L35:
        if (r17 == null) goto L37;
        long r4 = r17.getRoomId();
    L38:
        savePreviewPlayerRenderViewLayoutParams(r3, "live_multi_video_scene_render_view_params", getPreviewClient(r2, r4), r18, r12);
        return;
    L37:
        r4 = 0;
        goto L38
    L31:
        r3 = null;
        goto L33
    L25:
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r12, r13) == true) goto L26;
    }

    public final void resizePlayViewForNewLinkFeedView(AnchorModeParseSeiData r5, int r6, LivePlayerView r7, Context r8, IRoom r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.b = r10;
        if (m() == false) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
        return;
    L7:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.getSeiScene() != 20) goto L57;
        DataCenter r13 = this.z;
        if (r13 == null) goto L15;
        Boolean r14 = (Boolean) r13.get("status_bar_is_visible", Boolean.TRUE);
        if (r14 == null) goto L15;
        boolean r15 = r14.booleanValue();
    L16:
        Pair r16 = jc1.k.n(IInteractService.class).getNewLinkSizeForXScreenAdjust(r6, r11, r12);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r17 = jc1.k.n(IInteractService.class).getLayoutConfigBySei(r5.getAppData(), r15, r16, d(r7));
        if (r17 != null) goto L19;
        return;
    L19:
        r7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        IRenderView r18 = r7.getRenderView();
        View r1 = null;
        if ((r18 instanceof View) == true) goto L22;
        r18 = null;
    L22:
        View r19 = (View) r18;
        if (r19 == null) goto L25;
        r19.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L25:
        IRenderView r20 = r7.getRenderView();
        if ((r20 instanceof View) == true) goto L28;
        r20 = null;
    L28:
        View r21 = (View) r20;
        if (r21 == null) goto L32;
        r21.setTranslationY(0.0f);
    L32:
        if (jc1.k.n(IInteractService.class).needAdjustScreen(r10, r11, r12) == false) goto L34;
        int r22 = ((Number) r16.getFirst()).intValue();
        int r23 = ((Number) r16.getSecond()).intValue();
    L35:
        pn0.f r24 = r17.b().d;
        Intrinsics.checkNotNull(r24);
        float r25 = (r11 - r22) / 2.0f;
        float r0 = (r12 - r23) / 2.0f;
        IRenderView r110 = r7.getRenderView();
        if ((r110 instanceof View) == true) goto L38;
        r110 = null;
    L38:
        View r111 = (View) r110;
        if (r111 == null) goto L41;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L43:
        if ((r112 instanceof FrameLayout.LayoutParams) == true) goto L45;
        r112 = null;
    L45:
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112;
        if (r113 == null) goto L48;
        r113.gravity = 8388659;
        pn0.f.a r26 = r24.b;
        r113.width = r26.c;
        r113.height = r26.d;
        r113.leftMargin = r26.a + ((int) r25);
        r113.topMargin = r26.b + ((int) r0);
        ALogger.e("InteractPlayViewManager", "[resizePlayViewForNewLinkFeedView] call : containerSize[" + r11 + ", " + r12 + "], adjustSize[" + r22 + ", " + r23 + "], adjustOffset[" + r25 + ", " + r0 + "], layoutParams[" + r113.leftMargin + ", " + r113.topMargin + ", " + r113.width + ", " + r113.height + ']');
    L48:
        View r27 = r7.getRenderView();
        if ((r27 instanceof View) == false) goto L52;
        r1 = r27;
    L52:
        View r2 = r1;
        if (r2 == null) goto L58;
        r2.requestLayout();
        return;
    L58:
        return;
    L41:
        r112 = null;
        goto L43
    L34:
        r22 = r11;
        r23 = r12;
    L15:
        r15 = true;
        goto L16
    }

    public static final void a(InteractPlayViewManager r6, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r7, int r8, int r9, JSONObject r10, LivePlayerView r11, int r12, int r13, int r14) {
        r6.b = r14;
        if (r6.m() == true) goto L61;
        r6.e = r8;
        r6.o = r10;
        View r15 = null;
        if ((r11 instanceof View) == true) goto L8;
        LivePlayerView r16 = null;
    L10:
        if (r16 == null) goto L12;
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L12:
        IRenderView r17 = r11.getRenderView();
        if ((r17 instanceof View) == true) goto L15;
        r17 = null;
    L15:
        View r18 = (View) r17;
        if (r18 == null) goto L18;
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L18:
        IRenderView r19 = r11.getRenderView();
        if ((r19 instanceof View) == true) goto L21;
        r19 = null;
    L21:
        View r20 = (View) r19;
        if (r20 == null) goto L25;
        r20.setTranslationY(0.0f);
    L25:
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r8, r9) == true) goto L27;
    L29:
        int r110 = r12;
        int r21 = r13;
    L30:
        Integer r22 = jc1.k.n(IInteractService.class).adapterPlayerAlignModeIfNeed(r8, r9);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r23 = r7.b();
        if (r22 == null) goto L35;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m.a r24 = r23.c();
        if (r24 == null) goto L35;
        r24.g(r22.intValue());
    L35:
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L38;
        pn0.f r25 = r0.getLayoutConfigResult(r23, r110, r21, "InteractPlayViewManager#resizeCommonLinkPlayViewV2 with adjustScreen", d(r11));
    L39:
        r23.d = r25;
        Intrinsics.checkNotNull(r25);
        float r26 = (r12 - r110) / 2.0f;
        float r1 = (r13 - r21) / 2.0f;
        IRenderView r27 = r11.getRenderView();
        if ((r27 instanceof View) == true) goto L42;
        r27 = null;
    L42:
        View r28 = (View) r27;
        if (r28 == null) goto L45;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
    L47:
        if ((r29 instanceof FrameLayout.LayoutParams) == true) goto L49;
        r29 = null;
    L49:
        FrameLayout.LayoutParams r30 = (FrameLayout.LayoutParams) r29;
        if (r30 == null) goto L52;
        r30.gravity = 8388659;
        pn0.f.a r31 = r25.b;
        r30.width = r31.c;
        r30.height = r31.d;
        r30.leftMargin = r31.a + ((int) r26);
        r30.topMargin = r31.b + ((int) r1);
        ALogger.e("InteractPlayViewManager", "[resizeCommonLinkPlayView] call resizeCommonLinkPlayViewV2, containerSize[" + r12 + ", " + r13 + "], adjustSize[" + r110 + ", " + r21 + "], adjustOffset[" + r26 + ", " + r1 + "], layoutParams[" + r30.leftMargin + ", " + r30.topMargin + ", " + r30.width + ", " + r30.height + ']');
    L52:
        View r32 = r11.getRenderView();
        if ((r32 instanceof View) == false) goto L56;
        r15 = r32;
    L56:
        View r111 = r15;
        if (r111 == null) goto L60;
        r111.requestLayout();
        return;
    L60:
        return;
    L45:
        r29 = null;
        goto L47
    L38:
        r25 = null;
        goto L39
    L27:
        if (jc1.k.n(IInteractService.class).needAdjustScreen(r14, r12, r13) == false) goto L29;
        Pair r33 = jc1.k.n(IInteractService.class).getSizeForXScreenAdjust(r8, r9, r12, r13);
        r110 = ((Number) r33.getFirst()).intValue();
        r21 = ((Number) r33.getSecond()).intValue();
        goto L30
    L8:
        r16 = r11;
        goto L10
    }

    public final void resizePlayViewForCommonFeedView(int r26, int r27, JSONObject r28, LivePlayerView r29, Context r30, IRoom r31, int r32, int r33, int r34, Map<String, ? extends Object> r35, ClientUIInfo r36) {
        Intrinsics.checkNotNullParameter(r28, "canvas");
        Intrinsics.checkNotNullParameter(r30, "context");
        this.b = r32;
        if (m() == false) goto L5;
        return;
    L5:
        if (r29 != null) goto L8;
        return;
    L8:
        if (jc1.k.n(IInteractService.class).isSupportedCommonUILayoutBySei(r26, r27) == false) goto L29;
        DataCenter r0 = this.z;
        if (r0 == null) goto L14;
        Boolean r1 = (Boolean) r0.get("status_bar_is_visible", Boolean.TRUE);
        if (r1 == null) goto L14;
        boolean r15 = r1.booleanValue();
    L15:
        Pair r2 = jc1.k.n(IInteractService.class).getSizeForXScreenAdjust(r26, r27, r33, r34);
        Triple r14 = new Triple(r2.getFirst(), r2.getSecond(), "InteractPlayViewManager#resizePlayViewForCommonFeedView");
        ClientUIInfo r3 = this.t;
        if (r3 != null) goto L18;
        ClientUIInfo r20 = r36;
    L19:
        IInteractService r11 = jc1.k.n(IInteractService.class);
        if (r32 == 0) goto L22;
        boolean r16 = true;
    L23:
        DataCenter r6 = this.z;
        m r22 = new m(this, r26, r27, r28, r29, r31, r33, r34, r32);
        if (r31 == null) goto L26;
        long r4 = r31.getId();
    L27:
        boolean r17 = r16;
        r11.getLayoutConfigFromGecko(r26, r27, r17, r15, 0, null, false, r14, r20, r6, r22, r4);
        return;
    L26:
        r4 = 0;
        goto L27
    L22:
        r16 = false;
        goto L23
    L18:
        r20 = r3;
    L14:
        r15 = true;
        goto L15
    }
}
