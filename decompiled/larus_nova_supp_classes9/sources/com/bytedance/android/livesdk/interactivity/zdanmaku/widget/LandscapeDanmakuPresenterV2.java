package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.message.z0;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.IEnterAnimService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.utils.DanmakuStateHelper;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.t;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.u;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.x;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.Colorful;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.PrivilegeDanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.y;
import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.b0;
import r52.d2;
import r52.h0;
import r52.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeDanmakuPresenterV2;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeDanmakuPresenterV2$IView;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "IView", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeDanmakuPresenterV2 extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l, Observer<KVData> {
    public final u A;
    public final mc2.a B;
    public final mc2.b C;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.o D;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a E;
    public final t F;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.g G;
    public int e;
    public final LinkedHashSet<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f;
    public final LinkedHashSet<com.bytedance.android.livesdk.interactivity.zdanmaku.i> g;
    public final LinkedHashSet<com.bytedance.android.livesdk.interactivity.zdanmaku.i> h;
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.p i;
    public final CompositeDisposable j;
    public final List<n22.b> k;
    public int l;
    public long m;
    public long n;
    public int o;
    public long p;
    public long q;
    public long r;
    public float s;
    public final IRoom t;
    public boolean u;
    public final l v;
    public final m w;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.i x;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h y;
    public final x z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeDanmakuPresenterV2$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void K0();

        int N20();

        void Q7();

        int U();

        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m WT();

        void X(Object r1, boolean r2);

        p22.p fR();

        /* synthetic */ Context getContext();

        boolean isEnableLandscapeChat();

        boolean isInCarnival();

        boolean isScreenPortrait();

        void startDanmaku();

        void stopDanmaku();

        boolean vV();

        void x0();

        int x60();
    }

    public static final class a implements r22.b<com.bytedance.android.livesdk.interactivity.zdanmaku.k> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public a(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.zdanmaku.k r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.k r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class b implements r22.b<BusinessConfigure> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public b(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(BusinessConfigure r3) {
            BusinessConfigure r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class c implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L6:
            LandscapeDanmakuPresenterV2 r2 = this.a;
            if (r1 < r2.e) goto L9;
            return false;
        L9:
            if (r2.g.size() >= this.a.i.c()) goto L13;
            return true;
        L13:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        public c(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class d implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public d(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class e implements com.bytedance.android.livesdk.interactivity.api.d {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // com.bytedance.android.livesdk.interactivity.api.d
        public final IHeatChangeController.DanmakuHeat a() {
            IView r0 = ((q46.b) this.a).a;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r2 = r0.WT();
        L7:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.d) == false) goto L16;
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L11;
            r1 = r3.WT();
        L11:
            if (r1 == null) goto L14;
            return r1.a();
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.IDanmakuHeatController");
        L16:
            return IHeatChangeController.DanmakuHeat.MEDIUM;
        L5:
            r2 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.d
        public final boolean d() {
            IView r0 = ((q46.b) this.a).a;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r2 = r0.WT();
        L7:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.d) == false) goto L15;
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L11;
            r1 = r3.WT();
        L11:
            if (r1 == null) goto L14;
            return r1.d();
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.IDanmakuHeatController");
        L15:
            return false;
        L5:
            r2 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.d
        public final boolean e() {
            IView r0 = ((q46.b) this.a).a;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r2 = r0.WT();
        L7:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.d) == false) goto L15;
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L11;
            r1 = r3.WT();
        L11:
            if (r1 == null) goto L14;
            return r1.e();
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.IDanmakuHeatController");
        L15:
            return false;
        L5:
            r2 = null;
            goto L7
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.d
        public final int f() {
            IView r0 = ((q46.b) this.a).a;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r2 = r0.WT();
        L7:
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.d) == false) goto L15;
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L11;
            r1 = r3.WT();
        L11:
            if (r1 == null) goto L14;
            return r1.f();
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.IDanmakuHeatController");
        L15:
            IView r4 = ((q46.b) this.a).a;
            if (r4 != null) goto L18;
            return 0;
        L18:
            return r4.N20();
        L5:
            r2 = null;
            goto L7
        }

        public e(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }
    }

    public static final class f implements r22.b<q22.a> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L6:
            LandscapeDanmakuPresenterV2 r2 = this.a;
            if (r1 < r2.e) goto L9;
            return false;
        L9:
            if (r2.f.size() >= this.a.i.b()) goto L17;
            IView r3 = ((q46.b) this.a).a;
            if (r3 != null) goto L13;
        L14:
            return true;
        L13:
            if (r3.isInCarnival() != true) goto L14;
            return false;
        L17:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        public f(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(q22.a r3) {
            q22.a r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        public g(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            q22.a r5 = (q22.a) r4;
            LandscapeDanmakuPresenterV2 r0 = this.a;
            r0.getClass();
            r5.b = System.currentTimeMillis();
            IView r1 = ((q46.b) r0).a;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.isEnableLandscapeChat() != true) goto L16;
            IView r2 = ((q46.b) r0).a;
            if (r2 != null) goto L10;
            return;
        L10:
            if (r2.vV() != true) goto L17;
            z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
            r0.D.a(r5);
            return;
        L17:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        public h(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            q22.d r5 = (q22.d) r4;
            LandscapeDanmakuPresenterV2 r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.isEnableLandscapeChat() == true) goto L7;
            return;
        L7:
            if (((q46.b) r0).a.isInCarnival() == true) goto L13;
            z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
            r0.F.a(r5);
            return;
        }
    }

    public static final class i implements r22.b<q22.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public i(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(q22.d r3) {
            q22.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4.a, false);
            return;
        }
    }

    public static final class j implements r22.b<com.bytedance.android.livesdk.interactivity.zdanmaku.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public j(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.zdanmaku.d r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class k implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            if (this.a.h.size() >= 2) goto L9;
            IView r0 = ((q46.b) this.a).a;
            if (r0 != null) goto L7;
            return true;
        L7:
            if (r0.isInCarnival() == true) goto L9;
            return true;
        L9:
            return false;
        }

        public k(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, true);
            return;
        }
    }

    public static final class l implements jc1.h {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        public final /* synthetic */ void d(long r1) {
        }

        public l(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        public final void a(long r3) {
            EpisodeInteractivityTracer.b("first show play resume, ts: " + r3 + ", resume all danmaku");
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L6;
            r4.x0();
            return;
        }

        public final void b(long r3) {
            EpisodeInteractivityTracer.b("first show play pause, ts: " + r3 + ", stop all danmaku");
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L6;
            r4.Q7();
            return;
        }

        public final void c(long r3) {
            EpisodeInteractivityTracer.b("first show seek start, ts: " + r3 + ", clear all danmaku");
            this.a.h0();
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L6;
            r4.K0();
            return;
        }

        public final void e(long r3) {
            EpisodeInteractivityTracer.b("first show seek success, ts: " + r3);
        }

        public final void f(long r1) {
            EpisodeInteractivityTracer.b("first show back to latest, clear all danmaku");
            IView r2 = ((q46.b) this.a).a;
            if (r2 == null) goto L6;
            r2.K0();
            return;
        }

        public final void g(boolean r3) {
            EpisodeInteractivityTracer.b("on message fetch mode switch, seek: " + r3);
            if (r3 == false) goto L8;
            LandscapeDanmakuPresenterV2 r4 = this.a;
            vlc.d r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r4).d;
            if (r0 == null) goto L7;
            r0.removeMessageListener(r4);
        L7:
            r4.m0(true);
            return;
        L8:
            LandscapeDanmakuPresenterV2 r5 = this.a;
            vlc.d r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r5).d;
            if (r1 == null) goto L11;
            r1.removeMessageListener(r5);
        L11:
            r5.m0(false);
        }

        public final void h(long r1) {
            EpisodeInteractivityTracer.b("first show back to latest success");
        }
    }

    public static final class m implements jc1.h {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        public final /* synthetic */ void d(long r1) {
        }

        public m(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        public final void a(long r3) {
            EpisodeInteractivityTracer.b("match first show play resume, ts: " + r3 + ", resume all danmaku");
        }

        public final void b(long r3) {
            EpisodeInteractivityTracer.b("match first show play pause, ts: " + r3 + ", stop all danmaku");
        }

        public final void c(long r3) {
            EpisodeInteractivityTracer.b("match first show seek start, ts: " + r3 + ", clear all danmaku");
        }

        public final void e(long r3) {
            EpisodeInteractivityTracer.b("match first show seek success, ts: " + r3);
        }

        public final void f(long r1) {
            EpisodeInteractivityTracer.b("match first show back to latest, clear all danmaku");
        }

        public final void g(boolean r3) {
            EpisodeInteractivityTracer.b("match on message fetch mode switch, seek: " + r3);
            if (r3 == false) goto L10;
            LandscapeDanmakuPresenterV2 r4 = this.a;
            vlc.d r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r4).d;
            if (r0 == null) goto L7;
            r0.removeMessageListener(r4);
        L7:
            IView r5 = ((q46.b) this.a).a;
            if (r5 == null) goto L15;
            r5.K0();
            return;
        L15:
            return;
        L10:
            LandscapeDanmakuPresenterV2 r6 = this.a;
            vlc.d r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) r6).d;
            if (r1 == null) goto L13;
            r1.removeMessageListener(r6);
        L13:
            r6.m0(false);
        }

        public final void h(long r1) {
            EpisodeInteractivityTracer.b("match first show back to latest success");
        }
    }

    public static final class n implements r22.b<com.bytedance.android.livesdk.interactivity.zdanmaku.j> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.e) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public n(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.zdanmaku.j r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.j r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class o implements qb2.e {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;
        public final /* synthetic */ p0 b;

        @Override // qb2.e
        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r3) {
            Intrinsics.checkNotNullParameter(r3, "rendResult");
            SpannableString r4 = r3.a;
            this.b.setRenderSpan(r4);
            z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
            s3 r5 = this.b;
            if ((r5 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.d) == false) goto L6;
            this.a.x.a(r5);
            return;
        L6:
            if ((r5 instanceof s3) == false) goto L9;
            this.a.C.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.j(r5));
            z32.f.c(PSRoomStatValueNode.PaidDanmakuReceiveCount);
            return;
        L9:
            if ((r5 instanceof h4) == false) goto L14;
            this.a.B.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.k((h4) r5));
            return;
        }

        public o(LandscapeDanmakuPresenterV2 r1, p0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class p implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ LandscapeDanmakuPresenterV2 a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L6:
            LandscapeDanmakuPresenterV2 r2 = this.a;
            if (r1 < r2.e) goto L9;
            return false;
        L9:
            if (r2.g.size() >= this.a.i.c()) goto L13;
            return true;
        L13:
            return false;
        L5:
            r1 = 0;
            goto L6
        }

        public p(LandscapeDanmakuPresenterV2 r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public final void detachView() {
        if ((!Intrinsics.areEqual(com.bytedance.android.livesdk.interactivity.utils.i.e, Boolean.TRUE)) == true) goto L24;
        HashMap r0 = (HashMap) com.bytedance.android.livesdk.interactivity.utils.i.d;
        if (r0.isEmpty() == true) goto L24;
        Iterator r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L23;
        Map.Entry r5 = (Map.Entry) r1.next();
        if (((CharSequence) r5.getKey()).length() <= 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L10;
        HashMap r7 = new HashMap();
        r7.put("is_portrait", "1");
        r7.put("msg_type", ((String) r5.getKey()).toString());
        Long r8 = (Long) ((HashMap) com.bytedance.android.livesdk.interactivity.utils.i.a).get(r5.getKey());
        if (r8 == null) goto L19;
        long r9 = r8.longValue();
    L20:
        r7.put("on_msg_cnt", String.valueOf(((Number) r5.getValue()).longValue()));
        r7.put("user_id", com.bytedance.android.livesdk.interactivity.utils.i.f);
        r7.put("room_id", com.bytedance.android.livesdk.interactivity.utils.i.g);
        if (r9 == 0) goto L10;
        r7.put("on_msg_time", String.valueOf((((Number) r5.getValue()).floatValue() * 1.0f) / r9));
        j0.l().sendLog("ttlive_interactivity_danmaku_performance", r7, new Object[0]);
        goto L10
    L19:
        r9 = 0;
        goto L20
    L14:
        r6 = false;
        goto L15
    L23:
        ((HashMap) com.bytedance.android.livesdk.interactivity.utils.i.a).clear();
        com.bytedance.android.livesdk.interactivity.utils.i.b = 0;
        com.bytedance.android.livesdk.interactivity.utils.i.c = BuildConfig.FLAVOR;
        ((HashMap) com.bytedance.android.livesdk.interactivity.utils.i.d).clear();
    L24:
        DataCenter r2 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r2 == null) goto L27;
        r2.removeObserver(this);
    L27:
        super.detachView();
        vlc.d r3 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        if (r3 == null) goto L30;
        r3.removeMessageListener(this);
    L30:
        h0();
        this.x.e.b.removeCallbacksAndMessages(null);
        this.z.getClass();
        this.A.d();
        this.y.getClass();
        com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.o r4 = this.D;
        Disposable r10 = r4.f;
        if (r10 == null) goto L33;
        r10.dispose();
    L33:
        Iterator<Map.Entry<String, Disposable>> r11 = r4.g.entrySet().iterator();
    L35:
        if (r11.hasNext() == false) goto L37;
        r11.next().getValue().dispose();
        goto L35
    L37:
        r4.g.clear();
        com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a r13 = this.E;
        MutableLiveData<Boolean> r14 = r13.d;
        if (r14 == null) goto L40;
        r14.removeObserver(r13.e);
    L40:
        r13.d = null;
        r13.c = null;
        this.C.getClass();
        this.B.getClass();
        this.F.getClass();
        this.j.clear();
        EpisodeInteractivityTracer.b("unregister first show listener");
        jc1.b.b(this.v);
        EpisodeInteractivityTracer.b("unregister match first show listener");
        jc1.b.b(this.w);
        if (this.r > 0) goto L43;
    L53:
        DanmakuMonitor.c(false);
        return;
    L43:
        if (this.s <= 0) goto L53;
        InteractivityMonitor.Event r15 = InteractivityMonitor.Event.DanmakuShowLatency;
        IRoomContextService r16 = jc1.k.f(IRoomContextService.class);
        if (r16 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.o r17 = IRoomContextService.a.a(r16, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r17 == null) goto L51;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L51;
        IRoom r19 = (IRoom) r18.getValue();
    L52:
        long r20 = (long) ((this.s / this.r) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        int r21 = InteractivityMonitor.a;
        Intrinsics.checkNotNullParameter(r15, "event");
        LiveMonitor.a r23 = InteractivityMonitor.a(r15, r19, null);
        r23.j(r20);
        r23.a().report();
    L51:
        r19 = null;
        goto L52
    }

    public final void h0() {
        this.x.d();
        this.z.d();
        this.y.d();
        this.A.d();
        this.D.d();
        this.C.d();
        this.B.d();
        this.F.d();
        this.g.clear();
        this.f.clear();
        this.h.clear();
    }

    public final void i0() {
        g r1 = new g(this);
        Disposable r0 = xs2.b.a().b(q22.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(r1);
        if (r0 == null) goto L5;
        this.j.add(r0);
    L5:
        h r2 = new h(this);
        Disposable r3 = xs2.b.a().b(q22.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(r2);
        if (r3 == null) goto L8;
        this.j.add(r3);
    L8:
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.o r5 = IRoomContextService.a.a(r4, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r5 == null) goto L14;
        if (r5.isVSFirstShow() != true) goto L14;
    L24:
        EpisodeInteractivityTracer.b("register first show listener");
        jc1.b.a(this.v);
        m0(com.bytedance.android.livesdk.interactivity.common.utils.f.a(((com.bytedance.android.livesdk.chatroom.presenter.n) this).c));
        return;
    L14:
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r7 = IRoomContextService.a.a(r6, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r7 == null) goto L19;
        Boolean r8 = r7.isVSRoom();
    L21:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L25;
        int r9 = a1.a;
        if (a1.a.a().d() == true) goto L24;
    L25:
        m0(false);
        return;
    L19:
        r8 = null;
        goto L21
    }

    public LandscapeDanmakuPresenterV2() {
        this.e = 5;
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = (com.bytedance.android.livesdk.interactivity.api.settings.config.p) b0.a.getValue();
        this.j = new CompositeDisposable();
        this.k = new ArrayList();
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L10:
        this.t = r3;
        this.u = true;
        this.v = new l(this);
        this.w = new m(this);
        this.x = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.i(new d(this), new e(this));
        this.y = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h(new c(this));
        this.z = new x(new p(this));
        this.A = new u(new k(this));
        this.B = new mc2.a(new a(this));
        this.C = new mc2.b(new n(this));
        this.D = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.o(new f(this));
        this.E = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a(new b(this));
        this.F = new t(new i(this));
        this.G = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.g(new j(this));
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r10) {
        super.c0(r10);
        MutableLiveData<Boolean> r1 = null;
        if ((!Intrinsics.areEqual(com.bytedance.android.livesdk.interactivity.utils.i.e, Boolean.TRUE)) == true) goto L25;
        ((HashMap) com.bytedance.android.livesdk.interactivity.utils.i.a).clear();
        com.bytedance.android.livesdk.interactivity.utils.i.b = 0;
        com.bytedance.android.livesdk.interactivity.utils.i.c = BuildConfig.FLAVOR;
        ((HashMap) com.bytedance.android.livesdk.interactivity.utils.i.d).clear();
        IMiddlewareUserService r11 = jc1.k.f(IMiddlewareUserService.class);
        String r4 = "0";
        if (r11 == null) goto L11;
        com.bytedance.android.livesdk.user.e r13 = r11.user();
        if (r13 == null) goto L11;
        String r14 = r13.n();
        if (r14 == null) goto L11;
    L12:
        com.bytedance.android.livesdk.interactivity.utils.i.f = r14;
        IRoomContextService r15 = jc1.k.f(IRoomContextService.class);
        if (r15 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.o r16 = IRoomContextService.a.a(r15, null, 0, 3);
        if (r16 == null) goto L24;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L24;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L24;
        String r19 = String.valueOf(r18.getRoomId());
        if (r19 == null) goto L24;
        r4 = r19;
    L24:
        com.bytedance.android.livesdk.interactivity.utils.i.g = r4;
    L11:
        r14 = "0";
    L25:
        DanmakuStateHelper r110 = this.x.e;
        r110.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r5 = q.i();
        if (r5 == null) goto L31;
        com.bytedance.live.datacontext.m<? extends PublicScreenHeatState> r6 = r5.getMessageHeat();
        if (r6 == null) goto L31;
        PublicScreenHeatState r7 = (PublicScreenHeatState) r6.getValue();
        if (r7 == null) goto L31;
    L32:
        int r8 = b62.a.a[r7.ordinal()];
        if (r8 == 1) goto L71;
        if (r8 == 2) goto L53;
        com.bytedance.android.livesdk.interactivity.api.h r9 = q.g();
        if (r9 == null) goto L44;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r20 = r9.getBarrageContext();
        if (r20 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r21 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r20.getValue();
        if (r21 == null) goto L44;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> r23 = r21.getWaitMessageState();
        if (r23 == null) goto L44;
        r23.setValue(new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a(0, 0.2f));
    L44:
        com.bytedance.android.livesdk.interactivity.api.h r24 = q.g();
        if (r24 == null) goto L89;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r25 = r24.getBarrageContext();
        if (r25 == null) goto L89;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r26 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r25.getValue();
        if (r26 == null) goto L89;
        com.bytedance.live.datacontext.m<Integer> r27 = r26.getWaitDanmakuCountEnum();
        if (r27 == null) goto L89;
        r27.setValue(1);
    L89:
        r110.b.sendEmptyMessageDelayed(DanmakuStateHelper.Companion.HandlerMessage.UPDATE_COMMENT_MESSAGE_STATE.ordinal(), r110.a.a);
        this.z.getClass();
        this.y.getClass();
        this.A.getClass();
        this.D.getClass();
        com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a r111 = this.E;
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        r111.getClass();
        IRoomContextService r28 = jc1.k.f(IRoomContextService.class);
        if (r28 == null) goto L98;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r28, r0, 0, 2);
        if (r2 == null) goto L98;
        r111.c = r2.R1();
        com.bytedance.live.datacontext.m r3 = r2.B1();
        if (r3 == null) goto L97;
        r1 = (MutableLiveData) r3.getValue();
    L97:
        r111.d = r1;
    L98:
        this.C.getClass();
        this.B.getClass();
        this.F.getClass();
        i0();
        return;
    L53:
        com.bytedance.android.livesdk.interactivity.api.h r29 = q.g();
        if (r29 == null) goto L62;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r30 = r29.getBarrageContext();
        if (r30 == null) goto L62;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r31 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r30.getValue();
        if (r31 == null) goto L62;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> r33 = r31.getWaitMessageState();
        if (r33 == null) goto L62;
        r33.setValue(new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a(0, 0.4f));
    L62:
        com.bytedance.android.livesdk.interactivity.api.h r34 = q.g();
        if (r34 == null) goto L89;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r35 = r34.getBarrageContext();
        if (r35 == null) goto L89;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r36 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r35.getValue();
        if (r36 == null) goto L89;
        com.bytedance.live.datacontext.m<Integer> r37 = r36.getWaitDanmakuCountEnum();
        if (r37 == null) goto L89;
        r37.setValue(2);
        goto L89
    L71:
        com.bytedance.android.livesdk.interactivity.api.h r38 = q.g();
        if (r38 == null) goto L80;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r39 = r38.getBarrageContext();
        if (r39 == null) goto L80;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r40 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r39.getValue();
        if (r40 == null) goto L80;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> r41 = r40.getWaitMessageState();
        if (r41 == null) goto L80;
        r41.setValue(new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a(0, 0.4f));
    L80:
        com.bytedance.android.livesdk.interactivity.api.h r43 = q.g();
        if (r43 == null) goto L89;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r44 = r43.getBarrageContext();
        if (r44 == null) goto L89;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r45 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r44.getValue();
        if (r45 == null) goto L89;
        com.bytedance.live.datacontext.m<Integer> r46 = r45.getWaitDanmakuCountEnum();
        if (r46 == null) goto L89;
        r46.setValue(0);
    L31:
        r7 = PublicScreenHeatState.DEFAULT;
        goto L32
    }

    public final void j0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        IView r0 = ((q46.b) this).a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEnableLandscapeChat() == true) goto L10;
        return;
    L10:
        if (this.u == true) goto L15;
        if (com.bytedance.android.livesdk.interactivity.utils.b.d(r6) == false) goto L15;
        return;
    L15:
        if (((q46.b) this).a.isInCarnival() == true) goto L17;
    L19:
        PSRoomStatValueNode r1 = PSRoomStatValueNode.LandscapeDanmakuReceiveCount;
        z32.f.c(r1);
        o1 r2 = r6.getLandscapeAreaCommon();
        if (r2 != null) goto L22;
    L24:
        boolean r3 = false;
    L25:
        boolean r4 = r6.a();
        if (r6.isSelfSendFake() == false) goto L38;
        if (r4 == false) goto L29;
        this.A.a(new q72.e(r6));
        z32.f.c(r1);
        return;
    L29:
        if (r3 == false) goto L32;
        this.z.a(new q72.f(r6));
        z32.f.c(r1);
        return;
    L32:
        if ((r6 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.b0) == false) goto L34;
        n0((p0) r6);
        return;
    L34:
        IView r5 = ((q46.b) this).a;
        if (r5 == null) goto L54;
        r5.X(r6, true);
        return;
    L54:
        return;
    L38:
        if (r4 == false) goto L40;
        this.A.a(new q72.e(r6));
        z32.f.c(r1);
        return;
    L40:
        if (r3 == false) goto L43;
        this.z.a(new q72.f(r6));
        z32.f.c(r1);
        return;
    L43:
        if (r6.f() == false) goto L46;
        this.y.a(r6);
        z32.f.c(r1);
        return;
    L46:
        if ((r6 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.b0) == false) goto L49;
        n0((p0) r6);
        return;
    L49:
        this.x.a(r6);
        z32.f.c(r1);
        return;
    L22:
        if (r2.isShowHead() != true) goto L24;
        r3 = true;
        goto L25
    L17:
        if (r6.a() == true) goto L19;
    }

    public final void k0(com.bytedance.android.livesdk.interactivity.zdanmaku.i r4) {
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (r4.getType() != DanmakuType.Gift) goto L6;
        this.f.remove(r4);
    L18:
        this.D.k();
        this.E.l();
        this.z.k();
        this.A.k();
        this.C.k();
        this.B.k();
        this.F.k();
        this.x.k();
        this.y.k();
        return;
    L6:
        if (r4.getType() != DanmakuType.Official) goto L8;
        this.h.remove(r4);
        goto L18
    L8:
        nf6.a r0 = Colorful.Single;
        nf6.a r1 = r4.b().e(Colorful.class);
        if (r1 == null) goto L13;
        r0 = r1;
    L13:
        if (((Colorful) r0) != Colorful.Multi) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        this.g.remove(r4);
        goto L18
    L15:
        r2 = false;
        goto L16
    }

    public final void l0(com.bytedance.android.livesdk.interactivity.zdanmaku.i r14) {
        Intrinsics.checkNotNullParameter(r14, "danmaku");
        if (r14.getType() != DanmakuType.Gift) goto L6;
        this.f.add(r14);
    L19:
        if (r14.getType() != DanmakuType.Talent) goto L22;
        j0 r0 = j0.l();
        HashMap r1 = new HashMap();
        r1.put("comment_id", String.valueOf(r14.h().a));
        r1.put("vs_comment_type", "star");
        Unit r5 = Unit.INSTANCE;
        r0.sendLog("livesdk_vs_comment_show", r1, new Object[]{new am2.x(), IRoom.class});
    L22:
        if (r14.getType() != DanmakuType.Official) goto L27;
        dq1.c r2 = pm1.f.k();
        if (r2 == null) goto L27;
        r2.h("activity_ad_show", "official_danmu", null, null);
    L27:
        if (r14.getType() != DanmakuType.Business) goto L48;
        tc2.a r3 = (tc2.a) r14.b().e(tc2.a.class);
        Pair[] r4 = new Pair[3];
        String r7 = BuildConfig.FLAVOR;
        if (r3 == null) goto L32;
        String r8 = r3.a;
        if (r8 == null) goto L32;
    L33:
        r4[0] = TuplesKt.to("business_id", r8);
        if (r3 == null) goto L37;
        String r6 = r3.b;
        if (r6 == null) goto L37;
    L38:
        r4[1] = TuplesKt.to("resource_id", r6);
        if (r3 == null) goto L44;
        String r9 = r3.c;
        if (r9 == null) goto L44;
        r7 = r9;
    L44:
        r4[2] = TuplesKt.to("resource_scene", r7);
        Map r10 = MapsKt.mapOf(r4);
        dq1.c r11 = pm1.f.k();
        if (r11 == null) goto L48;
        r11.h("activity_ad_show", "comment_screen", null, r10);
    L37:
        r6 = BuildConfig.FLAVOR;
    L32:
        r8 = BuildConfig.FLAVOR;
    L48:
        if (r14.getType() != DanmakuType.NotifyEffect) goto L57;
        y r13 = (y) r14.b().e(y.class);
        if (r13 == null) goto L57;
        h3 r15 = r13.a;
        if (r15 == null) goto L57;
        IEnterAnimService r16 = (IEnterAnimService) jc1.k.f(IEnterAnimService.class);
        if (r16 == null) goto L57;
        r16.logCommonEnterShowEvent(r15);
    L57:
        long r17 = System.currentTimeMillis();
        com.bytedance.android.livesdk.interactivity.zdanmaku.binder.m r18 = (com.bytedance.android.livesdk.interactivity.zdanmaku.binder.m) r14.b().e(com.bytedance.android.livesdk.interactivity.zdanmaku.binder.m.class);
        if (r18 == null) goto L68;
        if (r18.isSelfSendFake() == true) goto L68;
        if (r18.c() == 0) goto L68;
        if (r18.isSendReview() == false) goto L66;
        this.l++;
        this.m += r18.getReceiveTime() - r18.c();
        this.n += r17 - r18.getReceiveTime();
        goto L68
    L66:
        this.o++;
        this.p += r18.getReceiveTime() - r18.c();
        this.q += r17 - r18.getReceiveTime();
    L68:
        if (r14.g().a <= 0) goto L71;
        z32.e.a(PSRealtimeIndicatorNode.LandscapeDanmakuDispatchAndShowDelay, System.currentTimeMillis() - r14.g().a);
    L71:
        if (r14.g().b <= 0) goto L74;
        long r19 = System.currentTimeMillis() - r14.g().b;
        this.r++;
        this.s += r19 / IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
    L74:
        if (r14.g().c <= 0) goto L81;
        long r20 = System.currentTimeMillis() - r14.g().c;
        z32.e.a(PSRealtimeIndicatorNode.LandscapeDanmakuShowDelay, r20);
        int r21 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.c.a[r14.getType().ordinal()];
        if (r21 == 1) goto L80;
        if (r21 != 2) goto L81;
        z32.e.a(PSRealtimeIndicatorNode.LandscapeGiftDanmakuShowDelay, r20);
        goto L81
    L80:
        z32.e.a(PSRealtimeIndicatorNode.LandscapeChatDanmakuShowDelay, r20);
    L81:
        z32.f.c(PSRoomStatValueNode.LandscapeDanmakuShowCount);
        if (((PrivilegeDanmakuType) r14.b().e(PrivilegeDanmakuType.class)) == null) goto L85;
        z32.f.c(PSRoomStatValueNode.PaidDanmakuShowCount);
        return;
    L85:
        return;
    L6:
        if (r14.getType() != DanmakuType.Official) goto L8;
        this.h.add(r14);
        goto L19
    L8:
        nf6.a r23 = Colorful.Single;
        nf6.a r24 = r14.b().e(Colorful.class);
        if (r24 == null) goto L13;
        r23 = r24;
    L13:
        if (((Colorful) r23) != Colorful.Multi) goto L15;
        boolean r25 = true;
    L16:
        if (r25 == false) goto L19;
        this.g.add(r14);
        goto L19
    L15:
        r25 = false;
        goto L16
    }

    public final void m0(boolean r6) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r1 == null) goto L27;
        if (r6 == false) goto L11;
        EpisodeInteractivityTracer.b("register seek message manager");
        com.bytedance.live.datacontext.j r7 = r1.K1();
        if (r7 == null) goto L14;
        vlc.d r8 = (vlc.d) r7.getValue();
    L15:
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d = r8;
        if (r8 == null) goto L26;
        r8.addMessageListener("WebcastGameCPUserDownloadMessage", this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastChatMessage", this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastRoomMessage", this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastAudioChatMessage", this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastEmojiChatMessage", this);
        if (((Boolean) d2.a.getValue()).booleanValue() == false) goto L21;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastPrivilegeScreenChatMessage", this);
    L21:
        if (((Boolean) com.bytedance.android.livesdk.chatroom.setting.j.c.getValue()).booleanValue() == false) goto L23;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastScreenChatMessage", this);
    L23:
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastNotifyEffectMessage", this);
        return;
    L26:
        return;
    L14:
        r8 = null;
        goto L15
    L11:
        EpisodeInteractivityTracer.b("register realtime message manager");
        com.bytedance.live.datacontext.j r9 = r1.getMessageManager();
        if (r9 == null) goto L14;
        r8 = (vlc.d) r9.getValue();
        goto L15
    L27:
        return;
    }

    public final void n0(p0 r11) {
        IView r0 = ((q46.b) this).a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.fR().e.a;
        tb2.d r2 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.b.a(r11, r1);
        int r3 = r0.x60();
        Iterator<tb2.c> r4 = r2.a.iterator();
    L7:
        if (r4.hasNext() == false) goto L30;
        tb2.c r5 = r4.next();
        ITextPieceImage r6 = r5.getImageValue();
        if (r6 == null) goto L7;
        if (r6.getScalingRate() == 0.0f) goto L7;
        float r7 = r1;
        if (((int) (r6.getScalingRate() * r7)) <= (r3 - s1.f(4.0f))) goto L15;
        int r8 = r3 - s1.f(4.0f);
    L17:
        if (r6.getWidth() != 0) goto L19;
    L21:
        r6.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r6.setHeight(r8);
    L23:
        if ((r11 instanceof a0) == false) goto L7;
        if (r11.getDefaultContent().length() <= 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L7;
        r6.setEnableTextWhenFailed(true);
        r5.setText(r11.getDefaultContent());
        goto L7
    L27:
        r9 = false;
        goto L28
    L19:
        if (r6.getHeight() == 0) goto L21;
        r6.setWidth((int) ((r6.getWidth() / r6.getHeight()) * r8));
        r6.setHeight(r8);
        goto L23
    L15:
        r8 = (int) (r7 * r6.getScalingRate());
        goto L17
    L30:
        qb2.c.b(r2, new o(this, r11), null, 16);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L13;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-1836833765)) goto L9;
        return;
    L9:
        if (r5.equals("cmd_widget_loaded") == false) goto L12;
        i0();
        return;
    L12:
        return;
    }

    public final void onMessage(tlc.d r13) {
        h4 r1 = null;
        if ((r13 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        r13 = null;
    L5:
        h4 r14 = (com.bytedance.android.live.base.model.message.t) r13;
        if (r14 != null) goto L8;
        return;
    L8:
        Map<String, Long> r0 = com.bytedance.android.livesdk.interactivity.utils.i.a;
        String r2 = r14.getMessageMethod();
        if (r2 != null) goto L11;
        r2 = BuildConfig.FLAVOR;
    L11:
        Boolean r3 = com.bytedance.android.livesdk.interactivity.utils.i.e;
        Boolean r4 = Boolean.TRUE;
        boolean r6 = true;
        if ((!Intrinsics.areEqual(r3, r4)) == false) goto L15;
    L21:
        String r5 = r14.getMessageMethod();
        long r8 = 1;
        if (r5 == null) goto L164;
        switch(r5.hashCode()) {
            case -1367943111: goto L156;
            case -1142270555: goto L135;
            case 41447196: goto L122;
            case 166407042: goto L94;
            case 561258746: goto L78;
            case 1163169388: goto L70;
            case 1906410492: goto L49;
            case 2129329488: goto L28;
            default: goto L164;
        };
    L28:
        if (r5.equals("WebcastScreenChatMessage") == false) goto L164;
        h4 r15 = r14;
        if (TextUtils.isEmpty(r15.getChatContent()) == true) goto L164;
        IView r7 = ((q46.b) this).a;
        if (r7 == null) goto L164;
        if (r7.isEnableLandscapeChat() != true) goto L164;
        if (((q46.b) this).a.isInCarnival() == false) goto L42;
        if (r15.isOfficialDanmaku() == false) goto L164;
    L42:
        if (r15.isOfficialDanmaku() == false) goto L45;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        j0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r15));
        goto L164
    L45:
        if (r15.getRichText() == null) goto L47;
        n0(r15);
        goto L164
    L47:
        this.B.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.k(r15));
        z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
        goto L164
    L49:
        if (r5.equals("WebcastEmojiChatMessage") == false) goto L164;
        if (q0(r14) == false) goto L53;
        return;
    L53:
        v0 r16 = (v0) r14;
        if (r16.getEmojiContent() == null) goto L164;
        IView r9 = ((q46.b) this).a;
        if (r9 == null) goto L164;
        if (r9.isEnableLandscapeChat() != true) goto L164;
        if (((q46.b) this).a.isInCarnival() == true) goto L164;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        h4 r17 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r16);
        if ((r17 instanceof a0) == false) goto L66;
        r1 = r17;
    L66:
        a0 r10 = (a0) r1;
        if (r10 == null) goto L164;
        n0(r10);
        goto L164
    L70:
        if (r5.equals("WebcastAudioChatMessage") == false) goto L164;
        if (q0(r14) == false) goto L74;
        return;
    L74:
        r r18 = (r) r14;
        if (TextUtils.isEmpty(r18.getChatContent()) == true) goto L164;
        k0 r11 = vh7.f.c(k0.class);
        r11.setContent(r18.getChatContent());
        r11.setMessageMethod("WebcastChatMessage");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        j0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r11));
        goto L164
    L78:
        if (r5.equals("WebcastNotifyEffectMessage") == false) goto L164;
        h3 r19 = (h3) r14;
        if (r19.O() == false) goto L164;
        IView r20 = ((q46.b) this).a;
        if (r20 == null) goto L164;
        if (r20.isEnableLandscapeChat() != true) goto L164;
        if (((q46.b) this).a.isInCarnival() == true) goto L164;
        z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
        Function1<com.bytedance.android.livesdk.interactivity.zdanmaku.d, Unit> r21 = new LandscapeDanmakuPresenterV2$onNotifyEffectMessage$1(this);
        IView r110 = ((q46.b) this).a;
        if (r110 == null) goto L91;
        Context r111 = r110.getContext();
    L92:
        new com.bytedance.android.livesdk.interactivity.zdanmaku.d(r19, r21, r111, com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c));
        goto L164
    L91:
        r111 = null;
        goto L92
    L94:
        if (r5.equals("WebcastGameCPUserDownloadMessage") == false) goto L164;
        IView r23 = ((q46.b) this).a;
        if (r23 == null) goto L100;
        if (r23.isScreenPortrait() != true) goto L100;
        return;
    L100:
        if ((r14 instanceof z0) == true) goto L102;
        return;
    L102:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.k) o0.a.getValue()).a() == 0) goto L182;
        z0 r112 = (z0) r14;
        if (r112.getDownloadCount() < 1) goto L183;
        IView r24 = ((q46.b) this).a;
        if (r24 == null) goto L164;
        if (r24.isEnableLandscapeChat() != true) goto L164;
        if (((q46.b) this).a.isInCarnival() == true) goto L164;
        if (((int) r112.getDownloadCount()) != 1) goto L116;
        String r113 = r112.h() + ' ' + r112.X0() + r112.getGameName();
    L117:
        if (r113 != null) goto L119;
        r113 = BuildConfig.FLAVOR;
    L119:
        String[] r25 = {"#FFFFFF"};
        Intrinsics.checkNotNullParameter(r25, "arr");
        n22.d r114 = new n22.d(r113, 2131250678, 2131250677, r25);
        z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
        this.F.a(new q22.d(r114));
        goto L164
    L116:
        r113 = s1.C(2131916759, new Object[]{r112.h(), IESUIUtils.getDisplayCount(r112.getDownloadCount(), "w"), r112.X0(), r112.getGameName()});
        goto L117
    L183:
        return;
    L182:
        return;
    L122:
        if (r5.equals("WebcastChatMessage") == false) goto L164;
        if ((r14 instanceof k0) == false) goto L127;
        r1 = r14;
    L127:
        k0 r26 = (k0) r1;
        if (r26 == null) goto L131;
        r26.setDanmakuReceiveTime(System.currentTimeMillis());
    L131:
        if (q0(r14) == false) goto L133;
        return;
    L133:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        j0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r14));
        goto L164
    L135:
        if (r5.equals("WebcastPrivilegeScreenChatMessage") == false) goto L164;
        s3 r115 = (s3) r14;
        if (TextUtils.isEmpty(r115.getContent()) == true) goto L154;
        IView r27 = ((q46.b) this).a;
        if (r27 == null) goto L154;
        if (r27.isEnableLandscapeChat() != true) goto L154;
        if (((q46.b) this).a.isInCarnival() == true) goto L154;
        if (r115.isLocalInsertMsgOld() == false) goto L151;
        if (r115.getSelfFakeRichContent() == null) goto L151;
        n0(r115);
    L151:
        if (r115.getRichText() == null) goto L153;
        n0(r115);
        goto L154
    L153:
        z32.f.c(PSRoomStatValueNode.LandscapeDanmakuReceiveCount);
        z32.f.c(PSRoomStatValueNode.PaidDanmakuReceiveCount);
        this.C.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.j(r115));
    L154:
        DanmakuMonitor.d(1, Long.valueOf(r115.getMessageId()));
        goto L164
    L156:
        if (r5.equals("WebcastRoomMessage") == false) goto L164;
        if (q0(r14) == false) goto L160;
        return;
    L160:
        c4 r116 = (c4) r14;
        if (r116.getSupprotLandscape() == false) goto L164;
        k0 r28 = vh7.f.c(k0.class);
        r28.setContent(r116.getContent());
        r28.setMessageMethod("WebcastChatMessage");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        j0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r28));
    L164:
        if ((!Intrinsics.areEqual(r3, r4)) == false) goto L167;
        return;
    L167:
        if (com.bytedance.android.livesdk.interactivity.utils.i.c.length() == 0) goto L170;
        r6 = false;
    L170:
        if (r6 == true) goto L185;
        long r29 = System.nanoTime() - com.bytedance.android.livesdk.interactivity.utils.i.b;
        Map<String, Long> r117 = com.bytedance.android.livesdk.interactivity.utils.i.d;
        String r30 = com.bytedance.android.livesdk.interactivity.utils.i.c;
        HashMap r118 = (HashMap) r117;
        Long r31 = (Long) r118.get(r30);
        if (r31 == null) goto L175;
        long r33 = r31.longValue();
    L176:
        r118.put(r30, Long.valueOf(r33));
        Map<String, Long> r119 = com.bytedance.android.livesdk.interactivity.utils.i.a;
        String r34 = com.bytedance.android.livesdk.interactivity.utils.i.c;
        HashMap r120 = (HashMap) r119;
        Long r35 = (Long) r120.get(r34);
        if (r35 == null) goto L179;
        r8 = r35.longValue();
    L179:
        r120.put(r34, Long.valueOf(r8));
        com.bytedance.android.livesdk.interactivity.utils.i.b = 0;
        com.bytedance.android.livesdk.interactivity.utils.i.c = BuildConfig.FLAVOR;
        return;
    L175:
        r33 = r29 + 0;
        goto L176
    L185:
        return;
    L15:
        if (r2.length() != 0) goto L17;
        boolean r36 = true;
    L18:
        if (r36 == true) goto L21;
        com.bytedance.android.livesdk.interactivity.utils.i.b = System.nanoTime();
        com.bytedance.android.livesdk.interactivity.utils.i.c = r2;
        goto L21
    L17:
        r36 = false;
        goto L18
    }

    public final void p0(boolean r6) {
        if (((Boolean) h0.a.getValue()).booleanValue() == false) goto L18;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c, 0, 2);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isVSRoom();
    L11:
        if ((!Intrinsics.areEqual(r2, Boolean.TRUE)) == false) goto L24;
        this.u = r6;
        Iterator<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r7 = this.x.c.iterator();
    L14:
        if (r7.hasNext() == false) goto L25;
        if (com.bytedance.android.livesdk.interactivity.utils.b.d(r7.next()) == false) goto L14;
        r7.remove();
        goto L14
    L25:
        return;
    L24:
        return;
    L9:
        r2 = null;
        goto L11
    }

    public final boolean q0(com.bytedance.android.live.base.model.message.t r4) {
        Iterator r0 = ((ArrayList) this.k).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        n22.b r1 = (n22.b) r0.next();
        if (r1.a() == false) goto L4;
        com.bytedance.android.livesdk.interactivity.utils.j.a("intercept by [" + r1.getName() + "], type is " + r4.getMessageMethod() + ", msg id is " + r4.getMessageId());
        return true;
    L9:
        return false;
    }

    public final void o0(BarrageSettingArea r6, BarrageSettingFont r7) {
        if (r6 != BarrageSettingArea.FULL) goto L16;
        if (r7 == null) goto L11;
        int r8 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.c.b[r7.ordinal()];
        if (r8 == 1) goto L14;
        if (r8 == 2) goto L13;
        if (r8 != 3) goto L11;
        this.e = 15;
        return;
    L13:
        this.e = 6;
        return;
    L14:
        this.e = 5;
        return;
    L11:
        this.e = 6;
        return;
    L16:
        if (r6 != BarrageSettingArea.HALF) goto L28;
        if (r7 == null) goto L23;
        int r9 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.c.c[r7.ordinal()];
        if (r9 == 1) goto L26;
        if (r9 == 2) goto L25;
        if (r9 != 3) goto L23;
        this.e = 7;
        return;
    L25:
        this.e = 5;
        return;
    L26:
        this.e = 3;
        return;
    L23:
        this.e = 5;
        return;
    L28:
        if (r6 != BarrageSettingArea.TOP) goto L39;
        this.e = 2;
        return;
    }
}
