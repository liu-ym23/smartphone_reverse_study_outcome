package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import android.content.Context;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.c3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.m;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.q4;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class CarnivalDanmakuPresenter extends n<IView> implements l {
    public final fc2.a e;
    public final int f;
    public int g;
    public int h;
    public final CompositeDisposable i;
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> j;
    public final Queue<q72.d> k;
    public com.bytedance.android.livesdk.interactivity.api.barrage.data.c l;
    public Disposable m;
    public Disposable n;
    public final Lazy o;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.e p;
    public final m q;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.f r;
    public final com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.n s;
    public final f t;
    public final e u;
    public final BarrageWidgetContext v;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/CarnivalDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void K0();

        void Q7();

        int U();

        void X(Object r1, boolean r2);

        void gd(int r1);

        /* synthetic */ Context getContext();

        int getFontSize();

        int wa();

        void x0();
    }

    public static final class a implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.f) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public a(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, r4.isSelfSendFake());
            return;
        }
    }

    public static final class b implements r22.b<q72.c> {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.f) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public b(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(q72.c r3) {
            q72.c r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, true);
            return;
        }
    }

    public static final class c implements r22.b<q72.d> {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.f) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public c(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(q72.d r3) {
            q72.d r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, false);
            return;
        }
    }

    public static final class d implements r22.b<q72.c> {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        @Override // r22.b
        public final boolean a() {
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L5;
            int r1 = r0.U();
        L7:
            if (r1 >= this.a.f) goto L10;
            return true;
        L10:
            return false;
        L5:
            r1 = 0;
            goto L7
        }

        public d(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        @Override // r22.b
        public final void b(q72.c r3) {
            q72.c r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.X(r4, true);
            return;
        }
    }

    public static final class e implements jc1.h {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        public final /* synthetic */ void d(long r1) {
        }

        public e(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void a(long r3) {
            EpisodeInteractivityTracer.b("carnival onPlayResume currentTimeInSecond=" + r3);
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L6;
            r4.x0();
            return;
        }

        public final void b(long r3) {
            EpisodeInteractivityTracer.b("carnival onPlayPause currentTimeInSecond=" + r3);
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L6;
            r4.Q7();
            return;
        }

        public final void c(long r3) {
            EpisodeInteractivityTracer.b("carnival onSeekStart currentTimeInSecond=" + r3);
            this.a.i0();
        }

        public final void e(long r3) {
            EpisodeInteractivityTracer.b("carnival onSeekSuccess currentTimeInSecond=" + r3);
        }

        public final void f(long r3) {
            EpisodeInteractivityTracer.b("carnival onBackToLatestStart currentTimeInSecond=" + r3);
            this.a.i0();
        }

        public final void g(boolean r3) {
            EpisodeInteractivityTracer.b("carnival onMessageFetchModeSwitch seek=" + r3);
            this.a.u0(false);
            this.a.r0(r3);
        }

        public final void h(long r3) {
            EpisodeInteractivityTracer.b("carnival onBackToLatestSuccess currentTimeInSecond=" + r3);
        }
    }

    public static final class f implements jc1.h {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        public final /* synthetic */ void d(long r1) {
        }

        public f(CarnivalDanmakuPresenter r1) {
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
            if (r3 == false) goto L7;
            this.a.u0(true);
            IView r4 = ((q46.b) this.a).a;
            if (r4 == null) goto L9;
            r4.K0();
            return;
        L9:
            return;
        L7:
            this.a.r0(false);
        }

        public final void h(long r1) {
            EpisodeInteractivityTracer.b("match first show back to latest success");
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        public g(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            CarnivalDanmakuPresenter r0 = this.a;
            r0.getClass();
            o22.b.a("onShowRedPacketEggEvent");
            Queue<o22.e> r1 = r0.l0();
            r1.add((o22.e) r3);
            if (r0.l0().size() <= 2) goto L6;
            r0.l0().poll();
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuPresenter a;

        public h(CarnivalDanmakuPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((o22.f) r1).a == true) goto L6;
            this.a.l0().clear();
            return;
        }
    }

    public final Queue<o22.e> l0() {
        return (Queue) this.o.getValue();
    }

    public final void i0() {
        ((LinkedList) this.j).clear();
        k0().d();
        this.r.d();
        this.q.d();
        this.s.d();
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L6;
        r0.K0();
        return;
    }

    public final void j0() {
        this.q.d();
        this.s.d();
        ((LinkedList) this.k).clear();
        k0().d();
        this.r.d();
        ((LinkedList) this.j).clear();
        l0().clear();
    }

    public final o m0() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return IRoomContextService.a.a(r0, ((n) this).c, 0, 2);
    }

    public final boolean n0() {
        BarrageWidgetContext r0 = this.v;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j<o22.d> r1 = r0.getDanmakuCarnivalManager();
        if (r1 == null) goto L11;
        o22.d r2 = (o22.d) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.a() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public final void s0() {
        if (this.e.controlEnable.booleanValue() == false) goto L8;
        if (((LinkedList) k0().c).size() <= this.e.danmakuShooterThreshold) goto L8;
        return;
    L8:
        if (k0().f().a() == true) goto L10;
        return;
    L10:
        if ((!this.j.isEmpty()) == false) goto L30;
        BarrageWidgetContext r0 = this.v;
        if (r0 == null) goto L24;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r1 = r0.getChatCarnivalStylePicker();
        if (r1 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.utils.f r2 = (com.bytedance.android.livesdk.interactivity.utils.f) r1.getValue();
        if (r2 == null) goto L24;
        long r3 = RangesKt.random(new LongRange(0, r2.b), Random.Default);
        Iterator<Long> r4 = r2.a.iterator();
        int r5 = 0;
    L19:
        if (r4.hasNext() == false) goto L24;
        if (r3 <= r4.next().longValue()) goto L25;
        r5 = r5 + 1;
    L25:
        k0().a(new q72.b((com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ListProtector.remove(this.j, 0), r5));
        return;
    L24:
        r5 = 0;
        goto L25
    }

    public final void t0() {
        if (this.e.controlEnable.booleanValue() == false) goto L8;
        if (this.q.c.size() <= this.e.danmakuShooterThreshold) goto L8;
        return;
    L8:
        if (this.q.f().a() == true) goto L10;
        return;
    L10:
        if ((!this.k.isEmpty()) == false) goto L16;
        q72.d r0 = (q72.d) ((LinkedList) this.k).poll();
        if (r0 == null) goto L17;
        this.q.a(r0);
        return;
    L17:
        return;
    }

    public void detachView() {
        super.detachView();
        o r0 = m0();
        if (r0 == null) goto L5;
        Boolean r1 = r0.isVSRoom();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L15;
        int r2 = a1.a;
        if (a1.a.a().d() == false) goto L15;
        EpisodeInteractivityTracer.b("unregister first show listener");
        if (a1.a.a().d() == false) goto L13;
        jc1.h r3 = this.u;
    L14:
        jc1.b.b(r3);
        goto L15
    L13:
        r3 = this.t;
    L15:
        u0(true);
        j0();
        this.q.d();
        this.s.d();
        k0().d();
        this.r.d();
        this.i.clear();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public void q0() {
        o r0 = m0();
        if (r0 == null) goto L5;
        Boolean r1 = r0.isVSRoom();
    L6:
        boolean r2 = false;
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L25;
        int r3 = a1.a;
        if (a1.a.a().d() == false) goto L25;
        EpisodeInteractivityTracer.b("register first show listener");
        if (a1.a.a().d() == false) goto L13;
        jc1.h r4 = this.u;
    L14:
        jc1.b.a(r4);
        r0(com.bytedance.android.livesdk.interactivity.common.utils.f.a(((n) this).c));
        o r5 = m0();
        if (r5 != null) goto L17;
    L20:
        r2 = true;
    L21:
        if (r2 == true) goto L27;
        IView r6 = ((q46.b) this).a;
        if (r6 == null) goto L28;
        r6.Q7();
        return;
    L28:
        return;
    L27:
        return;
    L17:
        if (r5.isVSFirstShow() != true) goto L20;
        if (com.bytedance.android.livesdk.interactivity.common.utils.f.c(((n) this).c) == false) goto L21;
    L13:
        r4 = this.t;
    L25:
        r0(false);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.e k0() {
        return this.p;
    }

    public CarnivalDanmakuPresenter(BarrageWidgetContext r3) {
        this.v = r3;
        this.e = (fc2.a) ec2.k.a.getValue();
        this.f = 10;
        this.g = 7;
        this.i = new CompositeDisposable();
        this.j = new LinkedList();
        this.k = new LinkedList();
        this.o = LazyKt.lazy(CarnivalDanmakuPresenter$redPacketEventList$2.INSTANCE);
        this.p = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.e(new a(this), r3);
        this.q = new m(new c(this), r3);
        this.r = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.f(new b(this), r3);
        this.s = new com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.n(new d(this), r3);
        this.t = new f(this);
        this.u = new e(this);
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        h0((IView) r1);
    }

    public void g0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        Intrinsics.checkNotNullParameter(r3, "chatMessage");
        if (this.e.controlEnable.booleanValue() == true) goto L5;
        ((LinkedList) this.j).add(r3);
        return;
    L5:
        if (((LinkedList) this.j).size() < this.e.messageListSizeThreshold) goto L7;
        return;
    L7:
        if (r3.isSelfSendFake() == false) goto L9;
        ListProtector.add(this.j, 0, r3);
        return;
    L9:
        ((LinkedList) this.j).add(r3);
    }

    public final void h0(IView r1) {
        super.c0(r1);
        this.q.getClass();
        this.s.getClass();
        k0().getClass();
        this.r.getClass();
    }

    public final void o0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        int r0 = this.h + 1;
        this.h = r0;
        if (CarnivalDanmakuWidget.A == false) goto L28;
        if (r0 < this.g) goto L28;
        BarrageWidgetContext r1 = this.v;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r2 = r1.getChatCarnivalStylePicker();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.utils.f r3 = (com.bytedance.android.livesdk.interactivity.utils.f) r2.getValue();
        if (r3 == null) goto L15;
        int r4 = r3.b();
    L16:
        this.r.a(new q72.c(r4));
        this.h = 0;
        BarrageWidgetContext r5 = this.v;
        if (r5 == null) goto L23;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r6 = r5.getChatCarnivalStylePicker();
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.utils.f r7 = (com.bytedance.android.livesdk.interactivity.utils.f) r6.getValue();
        if (r7 == null) goto L23;
        int r8 = r7.a();
    L24:
        this.g = r8;
        IView r9 = ((q46.b) this).a;
        if (r9 == null) goto L28;
        r9.gd(r8);
    L23:
        r8 = this.g;
    L15:
        r4 = 0;
    L28:
        if ((r13 instanceof b0) == false) goto L59;
        b0 r14 = (b0) r13;
        IView r10 = ((q46.b) this).a;
        if (r10 == null) goto L72;
        int r11 = r10.getFontSize();
        tb2.d r15 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.b.a(r14, r11);
        int r16 = r10.wa();
        Iterator<tb2.c> r17 = r15.a.iterator();
    L34:
        if (r17.hasNext() == false) goto L57;
        tb2.c r18 = r17.next();
        ITextPieceImage r19 = r18.getImageValue();
        if (r19 == null) goto L34;
        if (r19.getScalingRate() == 0.0f) goto L34;
        float r20 = r11;
        if (((int) (r19.getScalingRate() * r20)) <= (r16 - s1.f(4.0f))) goto L42;
        int r21 = r16 - s1.f(4.0f);
    L44:
        if (r19.getWidth() != 0) goto L46;
    L48:
        r19.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r19.setHeight(r21);
    L50:
        if (r14.getDefaultContent().length() <= 0) goto L52;
        boolean r23 = true;
    L53:
        if (r23 == false) goto L34;
        r19.setEnableTextWhenFailed(true);
        if ((!Intrinsics.areEqual(q4.a.getValue(), Boolean.TRUE)) == false) goto L34;
        r18.setText(r14.getDefaultContent());
        goto L34
    L52:
        r23 = false;
        goto L53
    L46:
        if (r19.getHeight() == 0) goto L48;
        r19.setWidth((int) ((r19.getWidth() / r19.getHeight()) * r21));
        r19.setHeight(r21);
        goto L50
    L42:
        r21 = (int) (r20 * r19.getScalingRate());
        goto L44
    L57:
        qb2.c.b(r15, new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.a(this, r14), null, 16);
        return;
    L72:
        return;
    L59:
        g0(r13);
        s0();
    }

    public void onMessage(tlc.d r15) {
        boolean r1 = true;
        if ((r15 instanceof t) == false) goto L8;
        t r0 = (t) r15;
        if (Intrinsics.areEqual(r0.getMessageMethod(), "WebcastChatMessage") == false) goto L8;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        o0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r0));
        com.bytedance.android.livesdk.interactivity.utils.e.f.getClass();
        com.bytedance.android.livesdk.interactivity.utils.e.a++;
        return;
    L8:
        if ((r15 instanceof c3) == true) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(((c3) r15).getMessageMethod(), "WebcastCarnivalMessage") == false) goto L145;
        Context r2 = null;
        if ((r15 instanceof u) == true) goto L14;
        r15 = null;
    L14:
        u r16 = (u) r15;
        if (r16 == null) goto L147;
        BarrageWidgetContext r3 = this.v;
        if (r3 == null) goto L24;
        com.bytedance.live.datacontext.j<o22.d> r4 = r3.getDanmakuCarnivalManager();
        if (r4 == null) goto L24;
        o22.d r5 = (o22.d) r4.getValue();
        if (r5 == null) goto L24;
        Long r6 = Long.valueOf(r5.e());
    L25:
        long r7 = r16.getSeqId();
        if (r6 == null) goto L31;
        if (r7 != r6.longValue()) goto L31;
    L36:
        int r8 = this.h + 1;
        this.h = r8;
        int r9 = -1;
        if (CarnivalDanmakuWidget.A == true) goto L39;
    L79:
        long r10 = r16.getDanmakuStyleType();
        BarrageWidgetContext r11 = this.v;
        if (r11 == null) goto L92;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r13 = r11.getGeneralCarnivalSyncModel();
        if (r13 == null) goto L92;
        GeneralCarnivalDataSyncModel r14 = (GeneralCarnivalDataSyncModel) r13.getValue();
        if (r14 == null) goto L92;
        dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r17 = r14.getCarnivalMessage();
        if (r17 == null) goto L92;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.k r18 = r17.c();
        if (r18 == null) goto L92;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r19 = r18.a();
        if (r19 == null) goto L92;
        Map<Integer, com.bytedance.android.livesdk.interactivity.api.barrage.data.b> r20 = r19.t();
    L93:
        if (r20 == null) goto L118;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.b r21 = r20.get(Integer.valueOf((int) r10));
        if (r21 == null) goto L118;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.a> r23 = r21.a();
        if (r23 == null) goto L118;
        BarrageWidgetContext r24 = this.v;
        if (r24 == null) goto L118;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r25 = r24.getChatCarnivalStylePicker();
        if (r25 == null) goto L118;
        if (((com.bytedance.android.livesdk.interactivity.utils.f) r25.getValue()) == null) goto L118;
        Intrinsics.checkNotNullParameter(r23, "skinList");
        if (r23.isEmpty() == true) goto L118;
        ArrayList r26 = new ArrayList();
        int r27 = r23.size();
        long r110 = 0;
        int r28 = 0;
    L108:
        if (r28 >= r27) goto L110;
        r110 = r110 + ((com.bytedance.android.livesdk.interactivity.api.barrage.data.a) ListProtector.get(r23, r28)).d();
        r26.add(Long.valueOf(r110));
        r28 = r28 + 1;
        goto L108
    L110:
        long r29 = RangesKt.random(new LongRange(0, r110), Random.Default);
        Iterator r30 = r26.iterator();
        int r31 = 0;
    L112:
        if (r30.hasNext() == false) goto L117;
        if (r29 <= ((Number) r30.next()).longValue()) goto L115;
        r31 = r31 + 1;
        goto L112
    L115:
        com.bytedance.android.livesdk.interactivity.api.barrage.data.a r33 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.a) ListProtector.get(r23, r31);
    L120:
        if (r16.getSpecialMark() != 0) goto L123;
        r1 = false;
    L123:
        if (r1 == false) goto L125;
        r9 = 0;
    L125:
        com.bytedance.android.live.base.model.message.d r34 = r16.getText();
        IView r35 = ((q46.b) this).a;
        if (r35 == null) goto L128;
        r2 = r35.getContext();
    L128:
        q72.d r36 = new q72.d(r33, r34, r2);
        r36.b = r9;
        r36.a = r16.getCarnivalPriority();
        if (this.e.controlEnable.booleanValue() == true) goto L131;
        ((LinkedList) this.k).add(r36);
    L134:
        t0();
        return;
    L131:
        if (((LinkedList) this.k).size() >= this.e.messageListSizeThreshold) goto L134;
        ((LinkedList) this.k).add(r36);
        goto L134
    L117:
        r33 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.a) ListProtector.get(r23, 0);
    L118:
        r33 = null;
    L92:
        r20 = null;
        goto L93
    L39:
        if (r8 < this.g) goto L79;
        o22.e r37 = l0().poll();
        if (r37 == null) goto L45;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.c r38 = this.l;
        if (r38 == null) goto L45;
        com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.n r39 = this.s;
        q72.c r40 = new q72.c(-1);
        DanmakuType r111 = DanmakuType.RedPacketEgg;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r40.a = r111;
        r40.g = r38;
        r40.h = r37.a;
        JsonObject r41 = r37.b;
        if (r41 != null) goto L49;
        HashMap r43 = null;
    L57:
        r40.i = r43;
        Unit r44 = Unit.INSTANCE;
        r39.a(r40);
        o22.b.a("shoot red packet egg");
        boolean r45 = true;
    L58:
        if (r45 == true) goto L68;
        BarrageWidgetContext r46 = this.v;
        if (r46 == null) goto L66;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r47 = r46.getChatCarnivalStylePicker();
        if (r47 == null) goto L66;
        com.bytedance.android.livesdk.interactivity.utils.f r48 = (com.bytedance.android.livesdk.interactivity.utils.f) r47.getValue();
        if (r48 == null) goto L66;
        int r49 = r48.b();
    L67:
        this.s.a(new q72.c(r49));
    L66:
        r49 = 0;
    L68:
        this.h = 0;
        BarrageWidgetContext r50 = this.v;
        if (r50 == null) goto L75;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.utils.f> r51 = r50.getChatCarnivalStylePicker();
        if (r51 == null) goto L75;
        com.bytedance.android.livesdk.interactivity.utils.f r53 = (com.bytedance.android.livesdk.interactivity.utils.f) r51.getValue();
        if (r53 == null) goto L75;
        int r54 = r53.a();
    L76:
        this.g = r54;
        IView r55 = ((q46.b) this).a;
        if (r55 == null) goto L79;
        r55.gd(r54);
    L75:
        r54 = this.g;
        goto L76
    L49:
        r43 = new HashMap();
        Iterator r56 = r41.entrySet().iterator();     // Catch: Exception -> L55
    L52:
        if (r56.hasNext() == false) goto L57;
        Map.Entry r112 = (Map.Entry) r56.next();     // Catch: Exception -> L55
        r43.put(r112.getKey(), ((JsonElement) r112.getValue()).getAsString());     // Catch: Exception -> L55
    L55:
        e = move-exception;
        int r113 = o22.b.a;
        Intrinsics.checkNotNullParameter("transform eventParams error", "info");
        ALogger.e("transform eventParams error", e);
    L45:
        r45 = false;
    L31:
        if (((Boolean) ec2.m.a.getValue()).booleanValue() == false) goto L146;
        if (r6 == null) goto L34;
        long r57 = r6.longValue();
    L35:
        r16.setSeqId(r57);
        goto L36
    L34:
        r57 = 0;
        goto L35
    L146:
        return;
    L24:
        r6 = null;
        goto L25
    L147:
        return;
    }

    public final void p0(com.bytedance.android.livesdk.interactivity.zdanmaku.i r2) {
        Intrinsics.checkNotNullParameter(r2, "danmaku");
        if (n0() == false) goto L5;
        this.s.k();
        this.q.k();
        t0();
        return;
    L5:
        this.r.k();
        k0().k();
        s0();
    }

    public final void r0(boolean r6) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L63;
        o r1 = IRoomContextService.a.a(r0, ((n) this).c, 0, 2);
        if (r1 != null) goto L8;
        return;
    L8:
        if (r6 == true) goto L10;
    L14:
        com.bytedance.live.datacontext.j r7 = r1.getMessageManager();
        if (r7 == null) goto L17;
        vlc.d r8 = (vlc.d) r7.getValue();
    L18:
        ((n) this).d = r8;
        if (r8 == null) goto L25;
        if (n0() == false) goto L23;
        ((n) this).d.addMessageListener("WebcastCarnivalMessage", this);
        goto L25
    L23:
        ((n) this).d.addMessageListener("WebcastChatMessage", this);
    L25:
        if (n0() == false) goto L52;
        BarrageWidgetContext r9 = this.v;
        if (r9 == null) goto L33;
        com.bytedance.live.datacontext.j<o22.d> r10 = r9.getDanmakuCarnivalManager();
        if (r10 == null) goto L33;
        o22.d r11 = (o22.d) r10.getValue();
        if (r11 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r13 = r11.c();
    L35:
        if ((r13 instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.j) == true) goto L37;
        r13 = null;
    L37:
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r14 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.j) r13;
        if (r14 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.l r15 = r14.B();
        if (r15 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.h r16 = r15.a();
        if (r16 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.c r17 = r16.b();
    L45:
        this.l = r17;
        if (r17 == null) goto L48;
        boolean r18 = true;
    L49:
        o22.b.a("registerMessageListener hasRedPacket=" + r18);
        if (r18 == false) goto L52;
        this.m = xs2.b.a().b(o22.e.class).subscribe(new g(this));
        this.n = xs2.b.a().b(o22.f.class).subscribe(new h(this));
        goto L52
    L48:
        r18 = false;
    L44:
        r17 = null;
    L33:
        r13 = null;
    L52:
        com.bytedance.android.livesdk.interactivity.utils.e r19 = com.bytedance.android.livesdk.interactivity.utils.e.f;
        Function1<com.bytedance.android.livesdk.interactivity.utils.e, Unit> r2 = new CarnivalDanmakuPresenter$registerMessageListener$3(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r2, "action");
        ec2.l r3 = ec2.l.a;
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L56;
        r2.invoke(r19);
    L56:
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L65;
        Disposable r20 = com.bytedance.android.livesdk.interactivity.utils.e.c;
        if (r20 == null) goto L61;
        r20.dispose();
    L61:
        com.bytedance.android.livesdk.interactivity.utils.e.c = null;
        com.bytedance.android.livesdk.interactivity.utils.e.a = 0;
        com.bytedance.android.livesdk.interactivity.utils.e.b = 0;
        com.bytedance.android.livesdk.interactivity.utils.e.c = Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.interactivity.utils.d.a);
        return;
    L65:
        return;
    L17:
        r8 = null;
        goto L18
    L10:
        if (((Boolean) l42.a.f.getValue()).booleanValue() == true) goto L14;
        com.bytedance.live.datacontext.j r21 = r1.K1();
        if (r21 == null) goto L17;
        r8 = (vlc.d) r21.getValue();
        goto L18
    }

    public final void u0(boolean r3) {
        vlc.d r0 = ((n) this).d;
        if (r0 == null) goto L5;
        r0.removeMessageListener("WebcastCarnivalMessage", this);
    L5:
        vlc.d r1 = ((n) this).d;
        if (r1 == null) goto L8;
        r1.removeMessageListener("WebcastChatMessage", this);
    L8:
        Disposable r2 = this.m;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.m = null;
        Disposable r4 = this.n;
        if (r4 == null) goto L14;
        r4.dispose();
    L14:
        this.n = null;
        if (r3 == false) goto L18;
        j0();
        return;
    }
}
