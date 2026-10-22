package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.t;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.u;
import com.bytedance.android.livesdk.message.model.wd;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.d2;
import r52.y3;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/PortraitZDanmakuPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/PortraitZDanmakuPresenter$IView;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "IView", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitZDanmakuPresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l, Observer<KVData> {
    public f32.g e;
    public final l f;
    public final Boolean g;
    public boolean h;
    public int i;
    public final CompositeDisposable j;
    public final int k;
    public final LinkedHashSet<com.bytedance.android.livesdk.interactivity.zdanmaku.i> l;
    public e m;
    public final u n;
    public final b o;
    public final p p;
    public final m q;
    public final a r;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/PortraitZDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void JH(int r1, boolean r2);

        int PV(p0 r1);

        int U();

        void Vb();

        void X(Object r1, boolean r2);

        /* synthetic */ Context getContext();

        IRoom getRoom();

        boolean isInCarnival();

        void wT();
    }

    public static final class a extends cc2.p<cc2.l> {
        public final Set<cc2.l> f;
        public final Set<cc2.l> g;

        @Override // cc2.p
        public final Set<cc2.l> b() {
            return this.g;
        }

        @Override // cc2.p
        public final Set<cc2.l> c() {
            return this.f;
        }

        public a(k r4) {
            super(true, r4);
            this.f = SetsKt.emptySet();
            this.g = SetsKt.setOf(new cc2.l[]{cc2.l.a.c, cc2.l.b.c, cc2.l.c.c});
        }
    }

    public static final class b extends mc2.a {
        public final /* synthetic */ PortraitZDanmakuPresenter d;

        @Override // r22.a
        public final boolean c(com.bytedance.android.livesdk.interactivity.zdanmaku.k r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.k r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            if (this.d.g.booleanValue() == true) goto L6;
            return false;
        L6:
            if (r4.a.isSelfAndMock() == false) goto L11;
            if (this.d.e.a == false) goto L11;
            return false;
        L11:
            return !this.d.e.c;
        }

        @Override // r22.a
        public final void i(com.bytedance.android.livesdk.interactivity.zdanmaku.k r2) {
            Intrinsics.checkNotNullParameter(r2, "danmaku");
            com.bytedance.android.livesdk.interactivity.utils.j.a("drop admin danmaku");
        }

        public b(PortraitZDanmakuPresenter r1, c r2) {
            this.d = r1;
            super(r2);
        }
    }

    public static final class c implements r22.b<com.bytedance.android.livesdk.interactivity.zdanmaku.k> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.k) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public c(PortraitZDanmakuPresenter r1) {
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public d(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            q22.d r3 = (q22.d) r2;
            PortraitZDanmakuPresenter r0 = this.a;
            if (r3 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.q.a(r3);
        }
    }

    public static final class e extends dmc.e {
        public final /* synthetic */ PortraitZDanmakuPresenter d;

        public final void onMessage(tlc.d r2) {
            this.d.onMessage(r2);
        }

        public e(PortraitZDanmakuPresenter r1, Set r2, Set r3) {
            this.d = r1;
            super(r2, r3, 4);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public f(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 == null) goto L8;
            PortraitZDanmakuPresenter r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 == null) goto L9;
            r1.JH(r4.a, r0.h);
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public g(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (ok1.d.a() == false) goto L13;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L14;
            PortraitZDanmakuPresenter r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 == null) goto L15;
            r1.JH(r5, r0.h);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public h(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (ok1.d.a() == false) goto L13;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L14;
            PortraitZDanmakuPresenter r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 == null) goto L15;
            r1.JH(r5, r0.h);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public i(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 == null) goto L10;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L11;
            PortraitZDanmakuPresenter r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 == null) goto L12;
            r1.JH(r5, r0.h);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public j(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L13;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L14;
            PortraitZDanmakuPresenter r0 = this.a;
            IView r1 = ((q46.b) r0).a;
            if (r1 == null) goto L15;
            r1.JH(r5, r0.h);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class k implements cc2.n<cc2.l> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public k(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.l r1, Boolean r2) {
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L6;
            r3.Vb();
            return;
        }

        @Override // cc2.n
        public final void b(cc2.l r1, Boolean r2) {
            IView r3 = ((q46.b) this.a).a;
            if (r3 == null) goto L6;
            r3.wT();
            return;
        }
    }

    public static final class l implements h32.d<f32.g> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        public l(PortraitZDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f32.f r2) {
            f32.g r3 = (f32.g) r2;
            Intrinsics.checkNotNullParameter(r3, "newConfig");
            this.a.e = r3;
        }
    }

    public static final class m extends t {
        public final /* synthetic */ PortraitZDanmakuPresenter d;

        @Override // r22.a
        public final boolean c(q22.d r2) {
            Intrinsics.checkNotNullParameter(r2, "danmaku");
            if (this.d.g.booleanValue() == true) goto L6;
            return false;
        L6:
            return !this.d.e.c;
        }

        @Override // r22.a
        public final void i(q22.d r2) {
            Intrinsics.checkNotNullParameter(r2, "danmaku");
            com.bytedance.android.livesdk.interactivity.utils.j.a("drop normal danmaku");
        }

        public m(PortraitZDanmakuPresenter r1, n r2) {
            this.d = r1;
            super(r2);
        }
    }

    public static final class n implements r22.b<q22.d> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.k) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public n(PortraitZDanmakuPresenter r1) {
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

    public static final class o implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            if (this.a.l.size() >= 2) goto L9;
            IView r0 = ((q46.b) this.a).a;
            if (r0 != null) goto L7;
            return true;
        L7:
            if (r0.isInCarnival() == true) goto L9;
            return true;
        L9:
            return false;
        }

        public o(PortraitZDanmakuPresenter r1) {
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

    public static final class p extends mc2.b {
        public final /* synthetic */ PortraitZDanmakuPresenter d;

        @Override // r22.a
        public final boolean c(com.bytedance.android.livesdk.interactivity.zdanmaku.j r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.j r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            if (this.d.g.booleanValue() == true) goto L6;
            return false;
        L6:
            if (r4.a.isSelfAndMock() == false) goto L11;
            if (this.d.e.a == false) goto L11;
            return false;
        L11:
            return !this.d.e.b;
        }

        @Override // r22.a
        public final void i(com.bytedance.android.livesdk.interactivity.zdanmaku.j r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.j r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            com.bytedance.android.livesdk.interactivity.utils.j.a("drop privilege danmaku");
            DanmakuMonitor.d(3, Long.valueOf(r4.a.getMessageId()));
        }

        public p(PortraitZDanmakuPresenter r1, q r2) {
            this.d = r1;
            super(r2);
        }
    }

    public static final class q implements r22.b<com.bytedance.android.livesdk.interactivity.zdanmaku.j> {
        public final /* synthetic */ PortraitZDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.k) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public q(PortraitZDanmakuPresenter r1) {
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

    public static final class r implements qb2.e {
        public final /* synthetic */ PortraitZDanmakuPresenter a;
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
            h4 r5 = this.b;
            if ((r5 instanceof h4) == false) goto L6;
            this.a.o.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.k(r5));
            return;
        L6:
            if ((r5 instanceof s3) == false) goto L10;
            this.a.p.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.j((s3) r5));
            DanmakuMonitor.d(1, Long.valueOf(this.b.getMessageId()));
            return;
        }

        public r(PortraitZDanmakuPresenter r1, p0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void detachView() {
        this.r.d();
        super.detachView();
        DataCenter r0 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        dmc.a r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        e r2 = this.m;
        int r3 = com.bytedance.android.livesdk.interactivity.common.utils.j.a;
        if (r1 != null) goto L9;
    L11:
        this.n.d();
        this.p.d();
        this.o.d();
        this.q.d();
        this.l.clear();
        this.n.d();
        this.o.getClass();
        this.p.getClass();
        this.q.getClass();
        DanmakuMonitor.c(true);
        this.j.clear();
        return;
    L9:
        if ((r1 instanceof dmc.a) == false) goto L11;
        r1.o(r2);
        ALogger.i("LiveMessageTracer", "removeReplayMessageListener");
        goto L11
    }

    public PortraitZDanmakuPresenter() {
        this.e = new f32.g(true, true, true);
        this.f = new l(this);
        this.g = (Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue();
        this.i = s1.f(220.0f);
        this.j = new CompositeDisposable();
        this.k = 5;
        this.l = new LinkedHashSet();
        this.n = new u(new o(this));
        this.o = new b(this, new c(this));
        this.p = new p(this, new q(this));
        this.q = new m(this, new n(this));
        this.r = new a(new k(this));
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r5) {
        super.c0(r5);
        this.n.getClass();
        this.o.getClass();
        this.p.getClass();
        this.q.getClass();
        d r0 = new d(this);
        Disposable r6 = xs2.b.a().b(q22.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(r0);
        if (r6 == null) goto L5;
        this.j.add(r6);
    L5:
        dmc.a r7 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d;
        DataCenter r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r1 != null) goto L8;
    L15:
        if (r7 == null) goto L17;
        r7.addMessageListener("WebcastScreenChatMessage", this);
    L17:
        DataCenter r2 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r2 == null) goto L21;
        r2.observeForever("data_keyboard_status_douyin", this);
    L21:
        if (this.g.booleanValue() == false) goto L34;
        com.bytedance.android.livesdk.interactivity.api.h r3 = com.bytedance.android.livesdk.interactivity.api.i.b(r2, 1);
        if (r3 == null) goto L34;
        com.bytedance.live.datacontext.j<h32.a> r4 = r3.getDegradeManager();
        if (r4 == null) goto L34;
        h32.a r8 = (h32.a) r4.getValue();
        if (r8 == null) goto L34;
        h32.c<f32.g> r9 = r8.f();
        if (r9 == null) goto L34;
        Disposable r10 = g32.b.a(r9, this.f);
        if (r10 == null) goto L34;
        RxUtilKt.c(r10, this.j);
    L34:
        if (((Boolean) d2.a.getValue()).booleanValue() == false) goto L50;
        if (r2 == null) goto L37;
        r2.observe("cmd_pk_state_change", this);
    L37:
        if (r2 == null) goto L39;
        r2.observe("cmd_normal_gift_layout_bottom_margin_update", this, true);
    L39:
        if (r2 == null) goto L41;
        r2.observe("cmd_change_interactivity_component_visibility", this);
    L41:
        IView r11 = ((q46.b) this).a;
        if (r11 == null) goto L44;
        r11.JH(this.i, this.h);
    L44:
        if (r7 == null) goto L46;
        r7.addMessageListener("WebcastPrivilegeScreenChatMessage", this);
    L46:
        this.h = false;
        InteractionWidgetsPosContext r13 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, r2, 0, 2);
        if (r13 == null) goto L51;
        this.j.add(r13.getAudioGiftTrayPos().a().subscribe(new f(this)));
        this.j.add(r13.getMultiPkGiftTrayPos().a().subscribe(new g(this)));
        this.j.add(r13.getRevenuePkGiftTrayPos().a().subscribe(new h(this)));
        this.j.add(r13.getEqualVideoTalkGiftTrayPos().a().subscribe(new i(this)));
        this.j.add(r13.getVideoChorusGiftTrayPos().a().subscribe(new j(this)));
        return;
    L51:
        return;
    L50:
        return;
    L8:
        if (a0.k(r1) != true) goto L15;
        e r14 = new e(this, SetsKt.emptySet(), SetsKt.setOf("WebcastScreenChatMessage"));
        this.m = r14;
        int r15 = com.bytedance.android.livesdk.interactivity.common.utils.j.a;
        if (r7 == null) goto L17;
        if ((r7 instanceof dmc.a) == false) goto L17;
        r7.C(r14);
        ALogger.i("LiveMessageTracer", "addReplayMessageListener");
        goto L17
    }

    public final void h0(p0 r10) {
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L5;
        int r1 = r0.PV(r10);
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        tb2.d r2 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.b.a(r10, r1);
        Iterator<tb2.c> r3 = r2.a.iterator();
    L10:
        if (r3.hasNext() == false) goto L33;
        tb2.c r4 = r3.next();
        ITextPieceImage r5 = r4.getImageValue();
        if (r5 == null) goto L10;
        if (r5.getScalingRate() == 0.0f) goto L10;
        float r6 = r1;
        if (((int) (r5.getScalingRate() * r6)) <= r1) goto L18;
        int r7 = r1;
    L20:
        if (r5.getWidth() != 0) goto L22;
    L24:
        r5.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r5.setHeight(r7);
    L26:
        if ((r10 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.a0) == false) goto L10;
        if (r10.getDefaultContent().length() <= 0) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == false) goto L10;
        r5.setEnableTextWhenFailed(true);
        r4.setText(r10.getDefaultContent());
        goto L10
    L30:
        r8 = false;
        goto L31
    L22:
        if (r5.getHeight() == 0) goto L24;
        r5.setWidth((int) ((r5.getWidth() / r5.getHeight()) * r7));
        r5.setHeight(r7);
        goto L26
    L18:
        r7 = (int) (r6 * r5.getScalingRate());
        goto L20
    L33:
        qb2.c.b(r2, new r(this, r10), null, 20);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L74;
        String r0 = r6.getKey();
        boolean r2 = false;
        switch(r0.hashCode()) {
            case -2034855137: goto L40;
            case -1540323875: goto L26;
            case -826138222: goto L15;
            case 294674590: goto L9;
            default: goto L75;
        };
    L75:
        return;
    L9:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L64;
        Boolean r7 = (Boolean) r6.getData();
        if (r7 == null) goto L76;
        boolean r8 = r7.booleanValue();
        this.r.e(cc2.l.b.c, r8);
        return;
    L76:
        return;
    L64:
        return;
    L15:
        if (r0.equals("cmd_change_interactivity_component_visibility") == false) goto L66;
        Object r9 = r6.getData();
        if ((r9 instanceof cc2.e) == true) goto L19;
        r9 = null;
    L19:
        cc2.e r10 = (cc2.e) r9;
        if (r10 == null) goto L67;
        cc2.f r11 = r10.b(cc2.l.class);
        if (r11 == null) goto L77;
        this.r.e(r11.a, r11.b);
        return;
    L77:
        return;
    L67:
        return;
    L66:
        return;
    L26:
        if (r0.equals("cmd_pk_state_change") == false) goto L69;
        z0 r13 = (z0) r6.getData();
        if (r13 == null) goto L78;
        int r14 = r13.a;
        if (r14 == 0) goto L35;
        if (r14 != 1) goto L36;
        this.h = false;
    L36:
        IView r15 = ((q46.b) this).a;
        if (r15 == null) goto L70;
        r15.JH(this.i, this.h);
        return;
    L70:
        return;
    L35:
        this.h = true;
        goto L36
    L78:
        return;
    L69:
        return;
    L40:
        if (r0.equals("cmd_normal_gift_layout_bottom_margin_update") == false) goto L72;
        wd r16 = (wd) r6.getData();
        if (r16 == null) goto L79;
        DataCenter r1 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r1 != null) goto L48;
        return;
    L48:
        if (PadConfigUtils.c() == false) goto L62;
    L58:
        int r17 = r16.a;
        this.i = r17;
        IView r3 = ((q46.b) this).a;
        if (r3 == null) goto L73;
        r3.JH(r17, this.h);
        return;
    L73:
        return;
    L62:
        ((Boolean) r1.get("data_is_anchor", Boolean.FALSE)).booleanValue();     // Catch: Exception -> L51
    L52:
        DataCenter r4 = ((com.bytedance.android.livesdk.chatroom.presenter.n) this).c;
        if (r4 == null) goto L56;
        r2 = v.a(((Number) r4.get("data_link_state", 0)).intValue(), 4);
    L56:
        if (r2 == false) goto L58;
        return;
    L79:
        return;
    L72:
        return;
    }

    public final void onMessage(tlc.d r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L63;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L64;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isEnableLandscapeChat() != true) goto L74;
        long r3 = System.currentTimeMillis();
        PSRoomStatValueNode r4 = PSRoomStatValueNode.PortraitDanmakuReceiveCount;
        z32.f.c(r4);
        if ((r8 instanceof p0) == false) goto L27;
        p0 r5 = (p0) r8;
        if (r5.getSelfFakeRichContent() == null) goto L20;
        h0(r5);
        return;
    L20:
        if (r5.getRichTextContent() == null) goto L27;
        if (((q46.b) this).a.getRoom() != null) goto L24;
        return;
    L24:
        h0(r5);
        return;
    L27:
        if ((r8 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L29;
        tlc.d r6 = null;
    L30:
        s3 r7 = (com.bytedance.android.live.base.model.message.t) r6;
        if (r7 != null) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(r7.getMessageMethod(), "WebcastPrivilegeScreenChatMessage") == false) goto L40;
        s3 r9 = r7;
        if (TextUtils.isEmpty(r9.getContent()) == true) goto L38;
        r9.setDanmakuReceiveTime(r3);
        this.p.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.j(r9));
        z32.f.c(PSRoomStatValueNode.PaidDanmakuReceiveCount);
    L38:
        DanmakuMonitor.d(1, Long.valueOf(r9.getMessageId()));
        return;
    L40:
        if (Intrinsics.areEqual(r7.getMessageMethod(), "WebcastScreenChatMessage") == false) goto L67;
        h4 r10 = (h4) r8;
        if (TextUtils.isEmpty(r10.getChatContent()) == false) goto L44;
        return;
    L44:
        if (r10.isOfficialDanmaku() == false) goto L61;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r11 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r10);
        if (r11 != null) goto L48;
        return;
    L48:
        if (TextUtils.isEmpty(r11.getChatContent()) == false) goto L51;
        return;
    L51:
        if (((q46.b) this).a.isInCarnival() == true) goto L53;
    L55:
        PSRoomStatValueNode r13 = PSRoomStatValueNode.PortraitDanmakuShowCount;
        z32.f.c(r13);
        boolean r14 = r11.a();
        if (r11.isSelfSendFake() == false) goto L59;
        if (r14 == false) goto L70;
        this.n.a(new q72.e(r11));
        z32.f.c(r13);
        return;
    L70:
        return;
    L59:
        if (r14 == false) goto L72;
        this.n.a(new q72.e(r11));
        z32.f.c(r4);
        return;
    L72:
        return;
    L53:
        if (r11.a() == true) goto L55;
        return;
    L61:
        r10.setDanmakuReceiveTime(r3);
        this.o.a(new com.bytedance.android.livesdk.interactivity.zdanmaku.k(r10));
        return;
    L67:
        return;
    L29:
        r6 = r8;
        goto L30
    L74:
        return;
    L64:
        return;
    }
}
