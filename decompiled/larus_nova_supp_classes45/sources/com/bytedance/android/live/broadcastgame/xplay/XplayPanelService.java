package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.aa0;
import com.bytedance.android.livesdk.config.m51;
import com.bytedance.android.livesdk.config.r50;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayPanelService implements com.bytedance.android.scope.o, com.bytedance.android.live.broadcastgame.xplay.e {
    public static final /* synthetic */ int s = 0;
    public String a;
    public XplayApi.j b;
    public final PublishSubject<Integer> c;
    public final com.bytedance.android.live.broadcastgame.opengame.message.d0 d;
    public View e;
    public View f;
    public final Observable<Unit> g;
    public final g h;
    public XplayMoreDialog i;
    public HybridDialog j;
    public final CompositeDisposable k;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p l;
    public final XplayInternalContext m;
    public final IXplayCoreService n;
    public final com.bytedance.android.live.broadcastgame.xplay.container.a o;
    public final g0 p;
    public final k20.e q;
    public final XplayMonitorSession r;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.XplayPanelService$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/broadcastgame/xplay/IXplayCoreService$State;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<IXplayCoreService.State, Unit> {
        public AnonymousClass1(XplayPanelService r8) {
            super(1, r8, XplayPanelService.class, "onXplayStateChanged", "onXplayStateChanged(Lcom/bytedance/android/live/broadcastgame/xplay/IXplayCoreService$State;)V", 0);
        }

        public final void invoke(IXplayCoreService.State r6) {
            Intrinsics.checkNotNullParameter(r6, "p1");
            XplayPanelService r0 = (XplayPanelService) ((CallableReference) this).receiver;
            int r1 = XplayPanelService.s;
            r0.getClass();
            int r7 = u0.c[r6.ordinal()];
            if (r7 != 1) goto L5;
            XplayLog.c("XplayPanelService", "configuring Xplay container");
            View r8 = r0.n.K();
            Intrinsics.checkNotNull(r8);
            r0.e = r8;
            if (r8 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("hostXplayView");
        L33:
            ViewGroup r9 = UtilityKotlinExtentionsKt.p(r8);
            if (r9 == null) goto L39;
            View r2 = r0.e;
            if (r2 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("hostXplayView");
        L38:
            r9.removeView(r2);
        L39:
            LiveViewStub r11 = r0.h.a.findViewById(2131393398);
            View r3 = r0.e;
            if (r3 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("hostXplayView");
        L42:
            r11.a(r3);
            return;
        L5:
            if (r7 != 2) goto L7;
            XplayLog.c("XplayPanelService", "switch to guide view");
            View r12 = r0.n.Y();
            Intrinsics.checkNotNull(r12);
            r0.f = r12;
            View r13 = r0.e;
            if (r13 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("hostXplayView");
        L26:
            View r4 = r0.f;
            if (r4 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("guideXplayView");
        L29:
            XplayPanelService.i(r13, r4);
            return;
        L7:
            if (r7 != 3) goto L9;
            XplayLog.c("XplayPanelService", "switch to host view");
            View r14 = r0.n.K();
            Intrinsics.checkNotNull(r14);
            r0.e = r14;
            View r15 = r0.f;
            if (r15 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("guideXplayView");
        L19:
            View r5 = r0.e;
            if (r5 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("hostXplayView");
        L22:
            XplayPanelService.i(r15, r5);
            return;
        L9:
            if (r7 != 6) goto L49;
            View r16 = r0.n.K();
            if (r16 == null) goto L44;
            ViewGroup r17 = UtilityKotlinExtentionsKt.p(r16);
            if (r17 == null) goto L45;
            r17.removeView(r16);
            return;
        L45:
            return;
        L44:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((IXplayCoreService.State) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayPanelService$GameLaunchSource;", "", "", "source", "J", "getSource", "()J", "Panel", "Scan", "GamePromote", "Invite", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GameLaunchSource extends Enum<GameLaunchSource> {
        public static final GameLaunchSource GamePromote = null;
        public static final GameLaunchSource Invite = null;
        public static final GameLaunchSource Panel = null;
        public static final GameLaunchSource Scan = null;
        public static final /* synthetic */ GameLaunchSource[] a = null;
        private final long source;

        static {
            GameLaunchSource r1 = new GameLaunchSource("Panel", 0, 1);
            Panel = r1;
            GameLaunchSource r2 = new GameLaunchSource("Scan", 1, 2);
            Scan = r2;
            GameLaunchSource r3 = new GameLaunchSource("GamePromote", 2, 3);
            GamePromote = r3;
            GameLaunchSource r4 = new GameLaunchSource("Invite", 3, 9);
            Invite = r4;
            a = new GameLaunchSource[]{r1, r2, r3, r4};
        }

        public static GameLaunchSource valueOf(String r1) {
            return (GameLaunchSource) r27.a.a(GameLaunchSource.class, r1);
        }

        public static GameLaunchSource[] values() {
            return (GameLaunchSource[]) a.clone();
        }

        public final long getSource() {
            return this.source;
        }

        public GameLaunchSource(String r1, int r2, long r3) {
            super(r1, r2);
            this.source = r3;
        }
    }

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = XplayLog.a;
            XplayLog.b("XplayPanelService", "error occurred in Xplay state handler: " + r4);
            if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
            return;
        L5:
            throw r4;
        }
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            Integer r3 = (Integer) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.intValue() != 2) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;

        public c(XplayPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            this.a.q.a("button click");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;

        public d(XplayPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Map<String, String> r0 = this.a.p.a;
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_icon_click", r0, new Object[]{Room.class});
            this.a.j((String) r7);
            Map<String, String> r8 = this.a.p.a;
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_page_show", r8, new Object[]{Room.class});
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;

        public e(XplayPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Unit r2 = (Unit) r1;
            this.a.n.I();
        }
    }

    public static final class f {
    }

    public static final class g {
        public final ViewGroup a;
        public final View b;
        public final ProgressBar c;
        public final TextView d;
        public final ViewGroup e;
        public final TextView f;
        public final TextView g;
        public final TextView h;
        public final Lazy i;
        public int j;
        public final ViewGroup k;
        public final Observer<Integer> l;

        public final void a(int r7) {
            this.j = r7;
            TextView r0 = this.d;
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            r0.setText(String.format(com.bytedance.android.live.core.utils.s1.B(2131923540), Arrays.copyOf(new Object[]{Integer.valueOf(r7)}, 1)));
            this.c.setProgress(r7);
        }

        public g(ViewGroup r5, PublishSubject r6, com.bytedance.android.live.broadcastgame.api.xplay.l r7) {
            Intrinsics.checkNotNullParameter(r5, "newPanel");
            Intrinsics.checkNotNullParameter(r6, "onClick");
            Intrinsics.checkNotNullParameter(r7, "xplayGameItem");
            this.k = r5;
            this.l = r6;
            ViewGroup r8 = (ViewGroup) r5.findViewById(2131393396);
            if (r8 != null) goto L9;
            View r9 = LayoutInflater.from(r5.getContext()).inflate(2131568049, r5, false);
            r5.addView(r9);
            if (r9 == null) goto L8;
            r8 = (ViewGroup) r9;
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        L9:
            this.a = r8;
            View r11 = r8.findViewById(2131393394);
            this.b = r11;
            this.c = (ProgressBar) r11.findViewById(2131393392);
            this.d = (TextView) r11.findViewById(2131393393);
            HSImageView r0 = (HSImageView) r11.findViewById(2131393390);
            TextView r12 = (TextView) r11.findViewById(2131393391);
            ViewGroup r13 = (ViewGroup) r8.findViewById(2131393378);
            this.e = r13;
            this.f = (TextView) r13.findViewById(2131393377);
            TextView r1 = (TextView) r13.findViewById(2131393395);
            this.g = r1;
            TextView r14 = (TextView) r13.findViewById(2131393375);
            this.h = r14;
            this.i = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new XplayPanelService$PanelViewHolder$loadFailPrefix$2(this));
            r1.setOnClickListener(new s0(this));
            r14.setOnClickListener(new t0(this));
            com.bytedance.android.livesdk.chatroom.utils.a1.s(r0, r7.e);
            r12.setText(r7.c);
        }
    }

    public static final class h<T> implements Predicate {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final boolean test(Object r2) {
            Integer r3 = (Integer) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.intValue() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    public static final class i<T, R> implements Function {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Integer) r2, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;

        public j(XplayPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.api.openplatform.f) r7).b, "from_panel") == false) goto L16;
            XplayPanelService r8 = this.a;
            r8.getClass();
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
            if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L8;
            com.bytedance.android.livesdk.user.f r1 = jc1.k.n(IUserService.class).user();     // Catch: Throwable -> L11
            Context r2 = r8.l.getContext();     // Catch: Throwable -> L11
            com.bytedance.android.livesdk.user.l.a r3 = new com.bytedance.android.livesdk.user.l.a();     // Catch: Throwable -> L11
            r3.a = com.bytedance.android.live.core.utils.s1.B(2131915990);     // Catch: Throwable -> L11
            r3.d = "open_platform";     // Catch: Throwable -> L11
            r3.c = -1;     // Catch: Throwable -> L11
            Disposable r9 = r1.login(r2, new com.bytedance.android.livesdk.user.l(r3)).subscribe(new y0(r8), z0.a);     // Catch: Throwable -> L11
        L9:
            Result.constructor-impl(r9);     // Catch: Throwable -> L11
            return;
        L8:
            Map<String, String> r4 = r8.p.a;     // Catch: Throwable -> L11
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_icon_click", r4, new Object[]{Room.class});     // Catch: Throwable -> L11
            r8.j(null);     // Catch: Throwable -> L11
            Map<String, String> r11 = r8.p.a;     // Catch: Throwable -> L11
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_anchor_function_page_show", r11, new Object[]{Room.class});     // Catch: Throwable -> L11
            r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;

        public k(XplayPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "XplayPanelService", "on registerShowPanelEvent Error");
            this.a.h();
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ XplayPanelService a;
        public final /* synthetic */ long b;

        public l(XplayPanelService r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r11) {
            Throwable r12 = (Throwable) r11;
            Intrinsics.checkNotNullParameter(r12, "t");
            if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r12) != 4014033) goto L5;
        L7:
            boolean r7 = false;
        L8:
            com.bytedance.android.live.broadcastgame.xplay.q r0 = com.bytedance.android.live.broadcastgame.xplay.q.a.b(com.bytedance.android.live.broadcastgame.xplay.q.c, XplayErrorCode.REQUEST_APP_START_FAILED, null, null, r12, 6);
            if ((r12 instanceof CustomApiServerException) == true) goto L11;
            Throwable r2 = null;
        L12:
            CustomApiServerException r3 = (CustomApiServerException) r2;
            String r4 = "";
            if (r3 == null) goto L16;
            String r5 = r3.getPrompt();
            if (r5 == null) goto L16;
        L17:
            XplayException r1 = new XplayException(r0, r7, r5);
            XplayMonitorSession r6 = this.a.r;
            long r8 = System.currentTimeMillis() - this.b;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r12, "throwable");
            int r9 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r12);
            String r13 = com.bytedance.android.livesdk.utils.o1.a(r12);
            if (r13 == null) goto L21;
            r4 = r13;
        L21:
            r6.g(0, r9, r4);
            if (r6.e.f != XplayScene.TalkRoom) goto L29;
            IInteractService r14 = jc1.k.f(IInteractService.class);
            if (r14 == null) goto L29;
            com.bytedance.android.live.liveinteract.utils.l r15 = r14.getLinkMicGameFullLinkMonitor();
            if (r15 == null) goto L29;
            com.bytedance.android.live.liveinteract.utils.l.a.b(r15, LinkMonitorData.OpenApiAppStart, r8, r12);
        L29:
            return Single.error(r1);
        L16:
            r5 = "";
            goto L17
        L11:
            r2 = r12;
            goto L12
        L5:
            if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r12) == 4014047) goto L7;
            r7 = true;
            goto L8
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;
        public final /* synthetic */ long b;

        public m(XplayPanelService r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            BaseResponse r8 = (BaseResponse) r7;
            this.a.m.getPushStreamType().setValue(Integer.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.v) r8.data).a()));
            this.a.m.getOpenXplayStartId().setValue(((com.bytedance.android.live.broadcastgame.opengame.network.v) r8.data).b());
            int r0 = InteractGameLocalStatusUtils.a;
            String r1 = ((com.bytedance.android.live.broadcastgame.opengame.network.v) r8.data).b();
            Intrinsics.checkNotNullParameter(r1, "startId");
            InteractGameLocalStatusUtils.c("start_id", r1);
            InteractGameLocalStatusUtils.c("open_conn_id", String.valueOf(this.a.d.a));
            XplayMonitorSession r2 = this.a.r;
            long r3 = System.currentTimeMillis() - this.b;
            String r9 = r8.logId;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r9, "logId");
            r2.g(1, 0, "");
            if (r2.e.f != XplayScene.TalkRoom) goto L9;
            IInteractService r4 = jc1.k.f(IInteractService.class);
            if (r4 == null) goto L9;
            com.bytedance.android.live.liveinteract.utils.l r5 = r4.getLinkMicGameFullLinkMonitor();
            if (r5 == null) goto L9;
            com.bytedance.android.live.liveinteract.utils.l.a.c(r5, LinkMonitorData.OpenApiAppStart, r3, r9);
        L9:
            InteractGameContext r11 = InteractGameContext.Companion.getContext();
            if (r11 == null) goto L15;
            com.bytedance.live.datacontext.m<Boolean> r12 = r11.isXPlayGameSessionRunning();
            if (r12 == null) goto L16;
            r12.setValue(Boolean.TRUE);
            return;
        L16:
            return;
        }
    }

    public static final class n<T, R> implements Function {
        public final /* synthetic */ XplayPanelService a;
        public final /* synthetic */ long b;

        public n(XplayPanelService r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r13) {
            Throwable r14 = (Throwable) r13;
            Intrinsics.checkNotNullParameter(r14, "it");
            com.bytedance.android.live.broadcastgame.xplay.q r7 = com.bytedance.android.live.broadcastgame.xplay.q.a.b(com.bytedance.android.live.broadcastgame.xplay.q.c, XplayErrorCode.REQUEST_APP_TOKEN_FAILED, null, null, r14, 6);
            XplayMonitorSession r0 = this.a.r;
            long r1 = System.currentTimeMillis() - this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r14, "throwable");
            if (r0.e.f != XplayScene.TalkRoom) goto L10;
            IInteractService r2 = jc1.k.f(IInteractService.class);
            if (r2 == null) goto L10;
            com.bytedance.android.live.liveinteract.utils.l r3 = r2.getLinkMicGameFullLinkMonitor();
            if (r3 == null) goto L10;
            com.bytedance.android.live.liveinteract.utils.l.a.b(r3, LinkMonitorData.OpenApiRequestToken, r1, r14);
        L10:
            return Single.error(new XplayException(r7, false, null, 6, null));
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ XplayPanelService a;
        public final /* synthetic */ long b;

        public o(XplayPanelService r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            XplayPanelService r0 = this.a;
            r0.a = ((XplayApi.d) r7.data).b();
            XplayPanelService r1 = this.a;
            r1.b = ((XplayApi.d) r7.data).a();
            IXplayCoreService r2 = this.a.n;
            XplayApi.j r3 = ((XplayApi.d) r7.data).a();
            if (r3 == null) goto L7;
            XplayApi.k r4 = r3.b();
            if (r4 == null) goto L7;
            String r5 = r4.b();
        L8:
            r2.setRtcExtInfo(r5);
            XplayMonitorSession r8 = this.a.r;
            long r9 = System.currentTimeMillis() - this.b;
            String r11 = r7.logId;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r11, "logId");
            if (r8.e.f != XplayScene.TalkRoom) goto L16;
            IInteractService r12 = jc1.k.f(IInteractService.class);
            if (r12 == null) goto L17;
            com.bytedance.android.live.liveinteract.utils.l r13 = r12.getLinkMicGameFullLinkMonitor();
            if (r13 == null) goto L18;
            com.bytedance.android.live.liveinteract.utils.l.a.c(r13, LinkMonitorData.OpenApiRequestToken, r9, r11);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class p<V> implements Callable {
        public final /* synthetic */ XplayPanelService a;

        public p(XplayPanelService r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final CompletableSource call() {
            final XplayPanelService r0 = this.a;
            int r1 = XplayPanelService.s;
            r0.getClass();
            final Ref.ObjectRef r2 = new Ref.ObjectRef();
            r2.element = null;
            IXplayCoreService.State r3 = r0.n.getState();
            int r4 = u0.b[r3.ordinal()];
            if (r4 == 1) goto L16;
            if (r4 != 2) goto L7;
        L11:
            Disposable r5 = (Disposable) r2.element;
            if (r5 == null) goto L18;
            r5.dispose();
        L18:
            return Completable.complete();
        L7:
            if (r4 == 3) goto L11;
            if (r4 == 4) goto L11;
            return Completable.error(new XplayException(com.bytedance.android.live.broadcastgame.xplay.q.a.b(com.bytedance.android.live.broadcastgame.xplay.q.c, XplayErrorCode.GAME_LOADED_FAILED, -1, String.valueOf(r3), null, 8), false, null, 6, null));
        L16:
            return q1.b(r0.n(IXplayCoreService.State.Running), new XplayPanelService$runGameActual$1(r0, r2));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public final class q implements Consumer {
        public final /* synthetic */ Function1 a;

        public q(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class r<T> implements Predicate {
        public final /* synthetic */ IXplayCoreService.State a;

        public r(IXplayCoreService.State r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            IXplayCoreService.State r3 = (IXplayCoreService.State) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3 != this.a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class s<T, R> implements Function {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final Object apply(Object r2) {
            XplayException r3 = (XplayException) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.error(r3);
        }
    }

    public static final class t<T, R> implements Function {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Serializable) r2, "it");
            return Completable.complete();
        }
    }

    static {
    }

    public final void onStart() {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final Completable J() {
        return Completable.defer(new p(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final Completable c() {
        if (this.a.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        long r3 = System.currentTimeMillis();
        Lazy r1 = LiveOpenGameClient.d;
        XplayApi r5 = (XplayApi) LiveOpenGameClient.a.a().a(XplayApi.class);
        com.bytedance.android.live.broadcastgame.api.xplay.p r2 = this.l;
        String r6 = r2.h.b;
        long r7 = r2.b;
        boolean r9 = r2.d;
        com.bytedance.android.live.broadcastgame.api.xplay.s r4 = r2.j;
        if (r4 != null) goto L12;
    L14:
        boolean r11 = false;
    L16:
        return RxUtilKt.i(r5.getToken(r6, r7, r9, r11).onErrorResumeNext(new n(this, r3))).doOnSuccess(new o(this, r3)).ignoreElement();
    L12:
        if (r4.f != true) goto L14;
        r11 = true;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final Completable g() {
        final ViewGroup r0 = this.h.a;
        Function0<Completable> r1 = new XplayPanelService$loadGame$1(this, r0);
        PublishSubject<Unit> r2 = q1.a;
        Intrinsics.checkNotNullParameter(r0, "view");
        Intrinsics.checkNotNullParameter(r1, "supplier");
        return Completable.create(new XplayUtilsKt$completableDeferUntilMeasured$1(r1, r0));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.xplay.XplayMoreDialog, java.lang.Object] */
    public final void onStop() {
        this.c.onComplete();
        ?? r0 = this.i;
        if (r0 == 0) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.i = null;
        this.k.dispose();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final Completable d() {
        long r0 = System.currentTimeMillis();
        Lazy r2 = LiveOpenGameClient.d;
        AnchorGameNetApi r3 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        com.bytedance.android.live.broadcastgame.api.xplay.p r4 = this.l;
        long r5 = r4.b;
        String r6 = r4.h.b;
        long r7 = GameLaunchSource.Panel.getSource();
        JSONObject r8 = new JSONObject();
        r8.put(OpenPlatformBaseDebugger.APP_ID, this.l.h.b);
        r8.put("room_id", this.l.b);
        r8.put("schema", this.l.h.f);
        r8.put("business_type", this.l.h.g);
        r8.put("developer", this.l.h.h);
        r8.put("seq", this.d.b.getAndIncrement());
        r8.put("time_stamp", System.currentTimeMillis());
        r8.put("conn_id", this.d.a);
        r8.put("is_debug_unity", this.l.h.k);
        if (((XplayScene) this.m.getCurrentScene().getValue()) != XplayScene.RevenueLink) goto L5;
        r8.put("enter_from", "revenue_interact");
    L5:
        Unit r9 = Unit.INSTANCE;
        String r11 = r8.toString();
        JSONObject r12 = new JSONObject();
        r12.put("unity_version", this.l.h.j);
        r12.put("is_debug_unity", this.l.h.k);
        return RxUtilKt.i(r3.sendAppStart(r5, r6, r7, r11, false, "", "", r12.toString()).singleOrError().onErrorResumeNext(new l(this, r0))).doOnSuccess(new m(this, r0)).ignoreElement();
    }

    public final void h() {
        RxUtilKt.c(RxUtilKt.h(xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class)).subscribe(new j(this), new k(this)), this.k);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final Observable<Unit> f() {
        return this.g;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final XplayApi.j getRtcInfo() {
        return this.b;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final void a(com.bytedance.android.live.broadcastgame.xplay.e.a r14) {
        Intrinsics.checkNotNullParameter(r14, "state");
        g r0 = this.h;
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r14 instanceof com.bytedance.android.live.broadcastgame.xplay.e.a.c) == false) goto L9;
        r0.b.setVisibility(0);
        r0.e.setVisibility(8);
        r0.a((int) Math.floor(((double) ((com.bytedance.android.live.broadcastgame.xplay.e.a.c) r14).a) * 100.0d));
        return;
    L9:
        if (Intrinsics.areEqual(r14, com.bytedance.android.live.broadcastgame.xplay.e.a.b.a) == false) goto L12;
        r0.c.setProgress(100);
        r0.b.setVisibility(8);
        r0.e.setVisibility(8);
        return;
    L12:
        if ((r14 instanceof com.bytedance.android.live.broadcastgame.xplay.e.a.C0102a) == false) goto L39;
        r0.b.setVisibility(8);
        r0.e.setVisibility(0);
        com.bytedance.android.live.broadcastgame.xplay.e.a.C0102a r15 = (com.bytedance.android.live.broadcastgame.xplay.e.a.C0102a) r14;
        Throwable r1 = r15.a;
        TextView r4 = r0.f;
        if ((r1 instanceof XplayException) == false) goto L24;
        XplayException r5 = (XplayException) r1;
        String r7 = r5.getUserHint();
        if (r7.length() <= 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L22;
        r7 = null;
    L22:
        if (r7 != null) goto L25;
        r7 = ((String) r0.i.getValue()) + " [" + r5.getCode() + ']';
    L25:
        r4.setText(r7);
        Throwable r6 = r15.a;
        if ((r6 instanceof XplayException) == true) goto L28;
    L31:
        r0.g.setVisibility(0);
        r0.h.setVisibility(8);
    L32:
        Throwable r16 = r15.a;
        if ((r16 instanceof XplayException) == true) goto L35;
        k(new XplayException(com.bytedance.android.live.broadcastgame.xplay.q.a.c(com.bytedance.android.live.broadcastgame.xplay.q.c, null, r1, 3), true, null, 4, null));
        return;
    L35:
        k((XplayException) r16);
        return;
    L28:
        if (((XplayException) r6).getRetryable() == true) goto L31;
        r0.g.setVisibility(8);
        r0.h.setVisibility(0);
        goto L32
    L18:
        r8 = false;
        goto L19
    L24:
        r7 = (String) r0.i.getValue();
        goto L25
    }

    public final void j(String r13) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L27;
        if (r0.isTalkRoomLoaded() == true) goto L27;
        String r1 = ((m51) r50.a.getValue()).e();
        if (r1 != null) goto L9;
        r1 = "sslocal://webcast_lynxview/?url=https%3A%2F%2Flf-normal-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fmicro_game%2Flynx%2Funiversal%2Fmicro_game_lynx_universal_webcast%2Fpages%2Fplay_joystick%2Ftemplate.js&use_xbridge3=1&use_bullet_container=1&disable_swipe=0&width_percent=100&height_percent=70&mix_container_type=annie&containerKey=annie_x_live&engine_type=new&pad_adapter=width_percent&bdhm_bid=ies_game_hybrid&pad_use_phone_size=1&hide_status_bar=1&pid=play_joystick&type=popup&gravity=bottom&enable_prefetch=1&force_show_top=1&landscape_custom_gravity=0&margin_right=0&margin_bottom=0";
    L9:
        u6 r2 = new u6(r1);
        r2.b(OpenPlatformBaseDebugger.APP_ID, this.l.h.b);
        r2.b("room_id", String.valueOf(this.l.b));
        r2.b("unity_version", this.l.h.j);
        r2.b("game_name", this.l.h.c);
        if (r13 == null) goto L25;
        String r3 = Uri.decode(r13);
        u6 r14 = r2.d(LiveSlardarConstants.EXTRA_KEY_URL);
        Object[] r4 = StringsKt.split$default(r3, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
        if (r4 == null) goto L24;
        String[] r5 = (String[]) r4;
        int r6 = r5.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L25;
        Object[] r8 = StringsKt.split$default(r5[r7], new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
        if (r8 == null) goto L22;
        String[] r9 = (String[]) r8;
        if (r9.length != 2) goto L20;
        r14.b(r9[0], r9[1]);
    L20:
        r7 = r7 + 1;
        goto L14
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L25:
        Uri r15 = r2.c();
        this.j = ((IBaseBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(this.l.getContext(), r15, null);
        return;
    L27:
        if (this.i != null) goto L29;
        XplayMoreDialog r16 = new XplayMoreDialog(this.l.getContext(), this.l, this.m, new XplayPanelService$showMoreDialog$1(this));
        this.i = r16;
        Unit r11 = Unit.INSTANCE;
        this.i = r16;
    L29:
        XplayMoreDialog r17 = this.i;
        if (r17 != null) goto L32;
        return;
    L32:
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r17);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
    }

    public final void k(XplayException r12) {
        Throwable r0 = r12.getCause();
        int r1 = 0;
        if (r0 != null) goto L5;
    L6:
        Throwable r2 = r12.getCause();
        if (r2 != null) goto L9;
    L36:
        int r3 = r12.getCode();
        if (r3 != 2001) goto L39;
        final Pair r4 = TuplesKt.to(2131923514, com.bytedance.android.live.core.utils.s1.B(2131923523));
    L58:
        q1.h(this.l, ((Number) r4.getFirst()).intValue(), (String) r4.getSecond(), r12.getRetryable(), new XplayPanelService$showStartFailedDialog$2(this, r4));
        return;
    L39:
        if (r3 != 2005) goto L41;
    L56:
        r4 = TuplesKt.to(2131923534, com.bytedance.android.live.core.utils.s1.B(2131923524));
        goto L58
    L41:
        if (r3 != 2007) goto L43;
        r4 = TuplesKt.to(2131923515, com.bytedance.android.live.core.utils.s1.B(2131923525));
        goto L58
    L43:
        if (r3 == 2011) goto L56;
        if (r3 != 2024) goto L47;
        r4 = TuplesKt.to(2131923519, com.bytedance.android.live.core.utils.s1.B(2131923529));
        goto L58
    L47:
        if (r3 == 2099) goto L53;
        switch(r3) {
            case 2016: goto L52;
            case 2017: goto L51;
            case 2018: goto L50;
            default: goto L49;
        };
    L49:
        r4 = TuplesKt.to(2131923513, com.bytedance.android.live.core.utils.s1.C(2131923522, new Object[]{String.valueOf(r12.getCode())}));
        goto L58
    L50:
        r4 = TuplesKt.to(2131923518, com.bytedance.android.live.core.utils.s1.B(2131923528));
        goto L58
    L51:
        r4 = TuplesKt.to(2131923517, com.bytedance.android.live.core.utils.s1.B(2131923527));
        goto L58
    L52:
        r4 = TuplesKt.to(2131923516, com.bytedance.android.live.core.utils.s1.B(2131923526));
        goto L58
    L53:
        r4 = TuplesKt.to(2131923515, com.bytedance.android.live.core.utils.s1.B(2131923530));
        goto L58
    L9:
        if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r2) != 4014047) goto L36;
    L10:
        Throwable r5 = r12.getCause();
        if ((r5 instanceof CustomApiServerException) == true) goto L13;
        r5 = null;
    L13:
        CustomApiServerException r6 = (CustomApiServerException) r5;
        if (r6 == null) goto L36;
        if (r6.getErrorCode() != 4014033) goto L27;
        JsonElement r13 = GsonProtectorUtils.parse(GsonHelper.parser(), r6.getExtra());
        if (r13 == null) goto L25;
        JsonObject r14 = r13.getAsJsonObject();
        if (r14 == null) goto L25;
        JsonElement r15 = r14.get("control_content_msg");
        if (r15 == null) goto L25;
        String r16 = r15.getAsString();
        if (r16 == null) goto L25;
    L26:
        final com.bytedance.android.livesdk.wrds.interact.a.b r17 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonProtectorUtils.fromJson(GsonHelper.get(), GsonProtectorUtils.parse(GsonHelper.parser(), r16).getAsJsonObject(), com.bytedance.android.livesdk.wrds.interact.a.b.class);
        r17.a = null;
        UtilityKotlinExtentionsKt.s(0, false, false, new XplayPanelService$showAppStartControlDialog$1(this, r17), 7);
        return;
    L25:
        r16 = "";
        goto L26
    L27:
        JsonElement r18 = GsonProtectorUtils.parse(GsonHelper.parser(), r6.getExtra());
        if (r18 == null) goto L34;
        JsonObject r19 = r18.getAsJsonObject();
        if (r19 == null) goto L34;
        JsonElement r110 = r19.get("shark_code");
        if (r110 == null) goto L34;
        r1 = r110.getAsInt();
    L34:
        TTLiveSDK.hostService().verify().showCaptcha(jc1.k.n(IHostApp.class).getCurrentActivity(), r1, new x0(this));
        return;
    L5:
        if (com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r0) == 4014033) goto L10;
        goto L6
    }

    public final Completable n(IXplayCoreService.State r3) {
        return Observable.merge(this.n.N().filter(new r(r3)), this.n.getOnError().flatMap(s.a)).take(1).flatMapCompletable(t.a);
    }

    public static void i(View r3, View r4) {
        ViewGroup r0 = UtilityKotlinExtentionsKt.p(r3);
        if (r0 == null) goto L5;
        int r1 = r0.indexOfChild(r3);
    L6:
        if (r0 == null) goto L8;
        r0.removeViewInLayout(r3);
    L8:
        r4.setId(r3.getId());
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 == null) goto L12;
        if (r0 == null) goto L15;
        r0.addView(r4, r1, r5);
        return;
    L15:
        return;
    L12:
        if (r0 == null) goto L17;
        r0.addView(r4, r1);
        return;
    L17:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.e
    public final void handleAnchorPanelJSBInvoke(String r7, JsonObject r8, Function1<? super JsonObject, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "method");
        Intrinsics.checkNotNullParameter(r8, "param");
        String r3 = null;
        boolean r4 = false;
        switch(r7.hashCode()) {
            case 595377332: goto L75;
            case 1019240161: goto L58;
            case 1111778759: goto L20;
            case 1967609240: goto L17;
            case 1991156014: goto L6;
            default: goto L116;
        };
    L116:
        return;
    L6:
        if (r7.equals("clickSwitchButton") == false) goto L102;
        HybridDialog r11 = this.j;
        if (r11 != null) goto L98;
    L15:
        xs2.b.a().post(new b30.l(CollectionsKt.emptyList()));
        return;
    L98:
        r11.dismiss();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L15;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L15
    L102:
        return;
    L17:
        if (r7.equals("clickExitButton") == false) goto L104;
        com.bytedance.android.livesdk.widget.x0.b r13 = new com.bytedance.android.livesdk.widget.x0.b(this.l.getContext(), 4);
        r13.l(2131923535);
        r13.i(1, 2131920876, v0.a);
        r13.i(0, 2131920877, new w0(this));
        r13.k(0, true);
        r13.n();
        return;
    L104:
        return;
    L20:
        if (r7.equals("operateSettings") == false) goto L106;
        JsonElement r14 = r8.get("item");
        if (r14 == null) goto L107;
        String r15 = r14.getAsString();
        if (r15 == null) goto L108;
        JsonElement r16 = r8.get("action");
        if (r16 == null) goto L28;
        r3 = r16.getAsString();
    L28:
        boolean r17 = Intrinsics.areEqual("open", r3);
        int r0 = r15.hashCode();
        if (r0 == (-1367751899)) goto L45;
        if (r0 == 2139985715) goto L34;
    L49:
        HybridDialog r18 = this.j;
        if (r18 == null) goto L109;
        r18.dismiss();     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L110;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L110:
        return;
    L109:
        return;
    L34:
        if (r15.equals("float_window") == false) goto L49;
        if (r17 == false) goto L40;
        com.bytedance.live.datacontext.m<Boolean> r21 = this.m.getShowFloatWindow();
        Boolean r22 = Boolean.TRUE;
        r21.setValue(r22);
        XplayExternalContext r23 = XplayExternalContext.Companion.getContext();
        if (r23 == null) goto L39;
        r23.getClearScreen().setValue(r22);
    L39:
        f2.c("悬浮窗已开启", 0);
        goto L49
    L40:
        com.bytedance.live.datacontext.m<Boolean> r24 = this.m.getShowFloatWindow();
        Boolean r25 = Boolean.FALSE;
        r24.setValue(r25);
        XplayExternalContext r26 = XplayExternalContext.Companion.getContext();
        if (r26 == null) goto L43;
        r26.getClearScreen().setValue(r25);
    L43:
        f2.c("悬浮窗已关闭，恢复直播间展示", 0);
        goto L49
    L45:
        if (r15.equals(NewBroadcastMonitor.STAGE.CAMERA) == false) goto L49;
        this.m.getOpenCapture().setValue(Boolean.valueOf(r17));
        if (r9 == null) goto L49;
        JsonObject r27 = new JsonObject();
        r27.addProperty("success", Boolean.TRUE);
        r27.addProperty("current_status", Boolean.valueOf(r17));
        Unit r28 = Unit.INSTANCE;
        Unit r29 = (Unit) r9.invoke(r27);
        goto L49
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L58:
        if (r7.equals("openLynxDetailPage") == false) goto L112;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L71
        JsonElement r32 = r8.get("extra");     // Catch: Throwable -> L71
        if (r32 == null) goto L63;
        String r33 = r32.getAsString();     // Catch: Throwable -> L71
        if (r33 == null) goto L63;
    L64:
        AnchorGameContext.Companion.getClass();     // Catch: Throwable -> L71
        AnchorGameContext r34 = AnchorGameContext.a.a();     // Catch: Throwable -> L71
        if (r34 == null) goto L69;
        com.bytedance.live.datacontext.n<String> r35 = r34.getLynxDetailExtra();     // Catch: Throwable -> L71
        if (r35 == null) goto L69;
        r35.setValue(r33);     // Catch: Throwable -> L71
    L69:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        xs2.b.a().post(new a2(Long.valueOf(this.l.h.d), null, null, 6));
        return;
    L63:
        r33 = "";
    L71:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L112:
        return;
    L75:
        if (r7.equals("getPanelSettingStatus") == false) goto L114;
        if (r9 == null) goto L115;
        JsonObject r37 = new JsonObject();
        r37.addProperty("camera_status", (Boolean) this.m.getOpenCapture().getValue());
        XplayExternalContext r38 = XplayExternalContext.Companion.getContext();
        if (r38 == null) goto L84;
        com.bytedance.live.datacontext.m<Boolean> r39 = r38.getClearScreen();
        if (r39 == null) goto L84;
        if (((Boolean) r39.getValue()).booleanValue() != true) goto L84;
        boolean r41 = true;
    L85:
        r37.addProperty("float_window_status", Boolean.valueOf(r41));
        Boolean r42 = Boolean.TRUE;
        r37.addProperty("show_switch_button", r42);
        if (this.l.d == true) goto L88;
    L94:
        r37.addProperty("show_camera_button", Boolean.valueOf(r4));
        r37.addProperty("is_casting", r42);
        Unit r43 = Unit.INSTANCE;
        Unit r44 = (Unit) r9.invoke(r37);
        return;
    L88:
        if (((Boolean) aa0.a.getValue()).booleanValue() == false) goto L94;
        com.bytedance.android.live.broadcastgame.api.xplay.s r1 = this.l.j;
        if (r1 != null) goto L92;
    L93:
        r4 = true;
        goto L94
    L92:
        if (r1.h == true) goto L94;
    L84:
        r41 = false;
        goto L85
    L115:
        return;
    }

    public XplayPanelService(com.bytedance.android.live.broadcastgame.api.xplay.p r2, XplayInternalContext r3, IXplayCoreService r4, com.bytedance.android.live.broadcastgame.xplay.container.a r5, g0 r6, k20.e r7, XplayMonitorSession r8) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r4, "xplayCoreService");
        Intrinsics.checkNotNullParameter(r5, "interactPlayContainerService");
        Intrinsics.checkNotNullParameter(r6, "xplayLogService");
        Intrinsics.checkNotNullParameter(r7, "xplayTerminateService");
        Intrinsics.checkNotNullParameter(r8, "xplayMonitorSession");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.a = "";
        PublishSubject<Integer> r9 = PublishSubject.create();
        this.c = r9;
        this.d = new com.bytedance.android.live.broadcastgame.opengame.message.d0();
        this.g = r9.filter(h.a).map(i.a);
        this.h = new g(r5.c(), r9, r2.h);
        CompositeDisposable r11 = new CompositeDisposable();
        this.k = r11;
        r4.N().subscribe(new q(new AnonymousClass1(this)), a.a);
        r9.filter(b.a).subscribe(new c(this));
        XplayExternalContext r12 = XplayExternalContext.Companion.getContext();
        if (r12 == null) goto L11;
        com.bytedance.live.datacontext.k<String> r13 = r12.getOpenGameMoreDialog();
        if (r13 == null) goto L11;
        PublishSubject r14 = r13.onEvent();
        if (r14 == null) goto L11;
        Disposable r15 = r14.subscribe(new d(this));
        if (r15 == null) goto L11;
        RxUtilKt.c(r15, r11);
    L11:
        RxUtilKt.c(r3.getShowKeyBoard().onEvent().subscribe(new e(this)), r11);
        h();
    }
}
