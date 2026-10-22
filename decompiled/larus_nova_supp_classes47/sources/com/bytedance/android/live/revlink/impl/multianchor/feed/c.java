package com.bytedance.android.live.revlink.impl.multianchor.feed;

import android.content.Context;
import android.os.MessageQueue;
import android.widget.FrameLayout;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.MultiDynamicContextFeedImpl;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a1;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.o0;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.q0;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.r0;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarManager;
import com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.FeedMultiBridgePresenter;
import com.bytedance.android.live.revlink.impl.multianchor.feed.player.FeedMultiPlayer;
import com.bytedance.android.live.revlink.impl.multianchor.feed.widget.FeedMultiWidget;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import iq2.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k31.h;
import k31.p;
import kc0.d;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import qc0.f;
import u01.k;
import u01.l;
import u01.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends FrameLayout implements f {
    public final z21.a a;
    public final k31.f b;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.player.b c;
    public final FeedMultiPlayer d;
    public final FeedMultiWidget e;
    public boolean f;
    public Integer g;
    public Integer h;
    public Integer i;
    public Integer j;
    public final e41.a k;
    public qc0.a l;
    public final d m;

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            c r0 = this.a;
            e r1 = vh6.c.b(er2.b.class).getKtvComponentFeedViewService();
            if (r1 == null) goto L5;
            iq2.d r2 = r1.a();
        L6:
            r0.l = r2;
            c r3 = this.a;
            qc0.a r4 = r3.l;
            if (r4 == null) goto L11;
            r4.setAttachParent(r3, new FrameLayout.LayoutParams(-1, -2));
            return false;
        L11:
            return false;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ c a;

        public static final class a implements ttc.c {
            public final /* synthetic */ MutableLiveData a;
            public final /* synthetic */ Observer b;

            public a(MutableLiveData r1, C0140b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void cancel() {
                MutableLiveData r0 = this.a;
                if (r0 == null) goto L6;
                r0.removeObserver(this.b);
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.feed.c$b$b, reason: collision with other inner class name */
        public static final class C0140b<T> implements Observer {
            public final /* synthetic */ ObservableEmitter a;

            public C0140b(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                ObservableEmitter r0 = this.a;
                r0.onNext((pc0.d) r2);
            }
        }

        public b(c r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<pc0.d> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            FeedMultiWidget r0 = this.a.e;
            if (r0 == null) goto L7;
            com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r1 = r0.c;
            if (r1 == null) goto L7;
            MutableLiveData<pc0.d> r2 = r1.h;
        L8:
            C0140b r3 = new C0140b(r4);
            r4.setCancellable(new a(r2, r3));
            if (r2 == null) goto L12;
            r2.observeForever(r3);
            return;
        L12:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public final void a(m r1) {
    }

    public final void b() {
    }

    public final void c() {
    }

    public String getFeedViewName() {
        return "RevMultiAnchorFeedView";
    }

    public qc0.c getIPkFeedView() {
        return null;
    }

    public final void onOnlineListChanged() {
    }

    public List<String> getImCacheTags() {
        ArrayList r0 = new ArrayList();
        int r1 = v21.a.c;
        r0.add("FeedMultiLinkTimeCacheUnit");
        return r0;
    }

    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return new ArrayList();
    }

    public final Observable<pc0.d> observeFeedViewExposeData() {
        return Observable.create(new b(this));
    }

    public final void onViewHolderPause() {
        FeedMultiWidget r0 = this.e;
        if (r0 == null) goto L9;
        r0.k = false;
        r0.g();
        if (t41.a.m.a() == false) goto L7;
        y21.a r1 = r0.b.d;
        r1.a.a();
        r1.b.a();
        r1.d.a();
        r1.c.a();
    L7:
        jy0.b.c("FeedMultiWidget", "onPause", null, 4);
        return;
    }

    public final void onViewHolderResume() {
        FeedMultiWidget r0 = this.e;
        if (r0 == null) goto L8;
        jy0.b.c("FeedMultiWidget", "onResume", null, 4);
        r0.k = true;
        r0.e();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r1 = r0.b.b;
        r1.b(r1.n);
        FeedMultiBreakThroughBarManager r2 = r0.f;
        if (r2 == null) goto L9;
        r2.d();
        return;
    L9:
        return;
    }

    public final void onViewHolderSelected() {
        if (this.f == false) goto L5;
        return;
    L5:
        FeedMultiWidget r0 = this.e;
        if (r0 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r2 = r0.b.b;
        r2.b = true;
        mx0.a r3 = r2.q.c;
        if (r3 == null) goto L10;
        r2.d(r3);
    L10:
        r2.b(r2.n);
        FeedMultiBreakThroughBarManager r4 = r0.f;
        if (r4 == null) goto L15;
        r4.f = true;
        if (r4.e() == true) goto L15;
        r4.d();
    L15:
        jy0.b.c("FeedMultiWidget", "onSelect", null, 4);
        r0.j = true;
        r0.e();
    L16:
        this.f = true;
    }

    public final void onViewHolderUnSelected() {
        if (this.f == true) goto L5;
        return;
    L5:
        FeedMultiWidget r0 = this.e;
        if (r0 == null) goto L25;
        IMProgressBarLayout r2 = r0.e.e.b;
        if (r2 == null) goto L10;
        r2.setVisibility(4);
    L10:
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r3 = r0.b;
        y21.a r4 = r3.d;
        r4.a.a();
        r4.b.a();
        r4.c.a();
        r4.d.a();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r5 = r3.b;
        r5.b = false;
        if (r5.q.c != null) goto L13;
    L16:
        r5.a.clear();
        FeedMultiBreakThroughBarManager r6 = r0.f;
        if (r6 == null) goto L21;
        r6.f = false;
        if (r6.e() == true) goto L21;
        r6.c();
    L21:
        r0.j = false;
        if (((Boolean) r0.m.getValue()).booleanValue() == true) goto L24;
        r0.g();
    L24:
        jy0.b.c("FeedMultiWidget", "onUnSelect", null, 4);
        goto L25
    L13:
        if (r5.d == false) goto L16;
        r5.d = false;
    L25:
        this.f = false;
    }

    public final void reset() {
        FeedMultiPlayer r0 = this.d;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r3 = r0.e;
        r3.b = null;
        r3.c = null;
        r3.d = null;
        k31.a r4 = r3.e;
        r4.a = null;
        r4.b = null;
        r0.b();
        r0.c = false;
    L5:
        FeedMultiWidget r1 = this.e;
        if (r1 == null) goto L35;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r5 = r1.c;
        if (r5 == null) goto L12;
        MutableLiveData<pc0.d> r6 = r5.h;
        if (r6 == null) goto L12;
        r6.setValue(new pc0.d(0, 29));
    L12:
        r1.d.h.removeObserver(r1.o);
        IMProgressBarLayout r7 = r1.e.e.b;
        if (r7 == null) goto L15;
        r7.setVisibility(4);
    L15:
        r1.e.o = null;
        FeedMultiBreakThroughBarManager r8 = r1.f;
        if (r8 == null) goto L18;
        r8.c();
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r9 = r1.d;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r10 = r9.E;
        y21.a r12 = r10.d;
        r12.f = null;
        r12.g = null;
        r12.h = null;
        r10.b.j = null;
        FeedMultiBridgePresenter r13 = r9.a;
        r13.b = null;
        r13.a = false;
        if (r13.f.c != null) goto L21;
    L24:
        r13.f.d.removeObserver(r13.e);
        Disposable r2 = r9.q;
        if (r2 == null) goto L27;
        r2.dispose();
    L27:
        r9.i();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r14 = r1.b;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r15 = r14.b;
        r15.q.b.removeObserver(r15.k);
        r15.q.d.removeObserver(r15.l);
        y21.a r16 = r14.d;
        r16.a.a();
        r16.b.a();
        r16.d.a();
        r16.c.a();
        r1.g();
        MultiDynamicContextFeedImpl r17 = r1.g;
        if (r17 == null) goto L30;
        r17.c.clear();
        r17.e.f = null;
        r17.f.e = null;
    L30:
        r1.g = null;
        r1.e.m = null;
        r1.l = null;
        d r18 = r1.r;
        if (r18 == null) goto L35;
        MediatorLiveData r19 = r18.getPlayerEvent();
        if (r19 == null) goto L35;
        r19.removeObserver(r1.n);
        goto L35
    L21:
        if (r13.c == false) goto L24;
        r13.d.clear();
        r13.c = false;
    L35:
        this.k.a();
        qc0.a r20 = this.l;
        if (r20 == null) goto L39;
        r20.reset();
        return;
    }

    public qc0.b getIMultiFeedView() {
        return this.e;
    }

    public qc0.a getKtvComponentFeedView() {
        return this.l;
    }

    public final void d(l r3) {
        Intrinsics.checkNotNullParameter(r3, "hub");
        z21.a r0 = this.a;
        r0.c = new mx0.a(r3);
        r0.d.postValue(Unit.INSTANCE);
    }

    public final void e(k r2) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        Intrinsics.checkNotNullParameter(r2, "caller");
    }

    public final void f(k31.f r24) {
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r2 = this.c;
        boolean r5 = true;
        if (r2 == null) goto L92;
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        r2.b = r24;
        if (r2.i == false) goto L7;
        r2.f = r2.b();
    L8:
        k31.f r8 = r2.b;
        if (r8 == null) goto L92;
        IRoom r9 = r2.g.a;
        if (r9 == null) goto L81;
        ILiveMode r10 = r9.getStreamType();
        if (r10 == null) goto L81;
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.a r12 = r2.f;
        if (r12.b == 0) goto L81;
        if (r12.c == 0) goto L81;
        int r13 = n11.a.a;
        p0 r14 = r8.b;
        if (r14 == null) goto L24;
        List r15 = r14.e();
    L25:
        if (r15 == null) goto L27;
        int r16 = r15.size();
    L28:
        if (r16 < 2) goto L32;
        com.bytedance.android.live.revlink.impl.multianchor.transfer.e r17 = r2.a.a(r10, r2.f.a);
        if (r17 == null) goto L32;
        StringBuilder r18 = new StringBuilder("inner ");
        boolean r19 = r2.f.a;
        DeviceType r110 = rc0.b.a();
        DeviceType r111 = DeviceType.NORMAL_MOBILE;
        if (r110 != r111) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == false) goto L39;
        boolean r113 = false;
    L40:
        r18.append(k31.l.b(new k31.k(r113, s1.A())));
        r18.append("  context:  ");
        r18.append(r2.g.getContext());
        r18.append("   ");
        r18.append(r2.f.a);
        jy0.b.c("xuzr", r18.toString(), null, 4);
        com.bytedance.android.livesdk.revenue.service.room.c r20 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r20 == null) goto L45;
        com.bytedance.android.livesdk.revenue.room.a r22 = r20.getRoomContext();
        if (r22 == null) goto L45;
        IRoomBase r23 = r22.getCommonRoom();
    L46:
        IRoom r25 = (IRoom) r23;
        if (r25 == null) goto L49;
        LiveMode r26 = r25.getStreamType();
    L51:
        if (r26 != LiveMode.SCREEN_RECORD) goto L53;
        boolean r114 = true;
    L54:
        String r27 = r8.c;
        if (r27 == null) goto L57;
        boolean r115 = StringsKt.contains$default(r27, "mock_game_uid", false, 2, null);
    L58:
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.a r28 = r2.f;
        int r116 = r28.b;
        int r117 = r28.c;
        boolean r29 = r28.a;
        if (rc0.b.a() != r111) goto L61;
        boolean r3 = true;
    L62:
        if (r3 == false) goto L64;
        boolean r4 = false;
    L65:
        k31.k r6 = new k31.k(r4, s1.A());
        k31.a r7 = r2.e;
        p0 r30 = r8.b;
        if (r30 == null) goto L70;
        m0 r32 = r30.f();
        if (r32 == null) goto L70;
        int r33 = r32.c();
    L72:
        if (r33 != UILayout.FULL.ordinal()) goto L80;
        p0 r118 = r8.b;
        if (r118 == null) goto L80;
        m0 r119 = r118.f();
        if (r119 == null) goto L80;
        if (r119.e() != 1) goto L80;
        r33 = UILayout.FULL_RECORD.ordinal();
    L80:
        k31.c r34 = r17.b(new l31.a(r116, r117, true, null, r8, null, r6, r7, r33, r115), true, Boolean.TRUE, r114);
    L82:
        if (r34 == null) goto L84;
        h r35 = r34.a(r8);
    L85:
        if (r35 == null) goto L90;
        n0 r36 = r8.a;
        if (r36 != null) goto L89;
        h r120 = r35;
    L91:
        r2.c = r35;
        r2.d = r120;
        goto L92
    L89:
        r120 = new h((int) ((r35.a * r36.b()) / r36.f()), (int) ((r35.b * r36.a()) / r36.e()), ((int) ((r35.b * r36.d()) / r36.e())) + r35.c, ((int) ((r35.a * r36.c()) / r36.f())) + r35.d, GravityDef.LEFT_TOP);
        goto L91
    L90:
        r120 = null;
        goto L91
    L84:
        r35 = null;
    L70:
        r33 = 0;
        goto L72
    L64:
        r4 = p.c(r29, p.b(r2.g.getContext()), false);
        goto L65
    L61:
        r3 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r26 = null;
    L45:
        r23 = null;
        goto L46
    L39:
        r113 = p.c(r19, p.b(r2.g.getContext()), false);
        goto L40
    L36:
        r112 = false;
    L32:
        r34 = null;
        goto L82
    L27:
        r16 = 0;
        goto L28
    L24:
        r15 = null;
    L81:
        r34 = null;
        goto L82
    L7:
        r2.f = r2.a();
    L92:
        d r37 = this.m;
        if (r37 != null) goto L95;
    L96:
        FeedMultiPlayer r38 = this.d;
        if (r38 == null) goto L99;
        r38.a();
    L99:
        FeedMultiWidget r39 = this.e;
        if (r39 == null) goto L290;
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r40 = r39.b;
        p0 r42 = r24.b;
        long r43 = r24.a();
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r44 = r40.b;
        if (r42 == null) goto L149;
        r44.getClass();
        m0 r45 = r42.f();
        if (r45 == null) goto L149;
        if (r45.c() != UILayout.FULL.ordinal()) goto L149;
        r44.c = r43;
        if (r44.e != null) goto L111;
        r44.e = r42;
    L145:
        boolean r46 = true;
    L146:
        if (r46 == false) goto L152;
        r44.b(r44.n);
    L152:
        FeedMultiWindowManager r47 = r39.e;
        r47.getClass();
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        r47.l = r24;
        Iterator<com.bytedance.android.live.revlink.impl.multianchor.feed.b> r48 = r47.g.iterator();
    L154:
        if (r48.hasNext() == false) goto L158;
        com.bytedance.android.live.revlink.impl.multianchor.feed.b r49 = r48.next();
        if (Intrinsics.areEqual(r49.getParent(), r47.p) == false) goto L154;
        r47.p.removeView(r49);
        goto L154
    L158:
        r47.g.clear();
        p0 r50 = r24.b;
        if (r50 == null) goto L202;
        m0 r52 = r50.f();
        if (r52 == null) goto L202;
        if (r52.c() != UILayout.FULL.ordinal()) goto L202;
        p0 r53 = r24.b;
        if (r53 == null) goto L240;
        List r54 = r53.e();
        if (r54 == null) goto L240;
        p0 r55 = r24.b;
        if (r55 == null) goto L174;
        m0 r56 = r55.f();
        if (r56 == null) goto L174;
        String r57 = r56.b();
    L175:
        Iterator r58 = r54.iterator();
    L177:
        if (r58.hasNext() == false) goto L202;
        RevSeiRegion r59 = (RevSeiRegion) r58.next();
        if ((Intrinsics.areEqual(r59.getInteractId(), r57) ^ r5) == false) goto L200;
        ArrayList<com.bytedance.android.live.revlink.impl.multianchor.feed.b> r60 = r47.g;
        com.bytedance.android.live.revlink.impl.multianchor.feed.b r121 = new com.bytedance.android.live.revlink.impl.multianchor.feed.b(r47.b, r59.getInteractId(), r47.h);
        h r122 = r47.q.c;
        if (r122 == null) goto L198;
        FrameLayout.LayoutParams r123 = new FrameLayout.LayoutParams((int) (((double) r122.a) * r59.getWidth()), (int) (((double) r122.b) * r59.getHeight()));
        r123.gravity = 51;
        Iterator r124 = r58;
        r123.leftMargin = (int) (((double) r122.d) + (((double) r122.a) * r59.getX()));
        r123.topMargin = (int) (((double) r122.b) * r59.getY());
        r47.p.addView(r121, r123);
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r62 = r47.r.b.f;
        if (r62 == null) goto L199;
        List r63 = (List) r62.getValue();
        if (r63 == null) goto L199;
        ArrayList r64 = new ArrayList();
        Iterator r65 = r63.iterator();
    L188:
        if (r65.hasNext() == false) goto L193;
        Object r125 = r65.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.link.model.p) r125).getLinkMicIdStr(), r59.getInteractId()) == false) goto L188;
        r64.add(r125);
        goto L188
    L193:
        if ((!r64.isEmpty()) == true) goto L196;
        r64 = null;
    L196:
        if (r64 == null) goto L199;
        com.bytedance.android.livesdk.link.model.p r66 = (com.bytedance.android.livesdk.link.model.p) ListProtector.get(r64, 0);
    L199:
        r60.add(r121);
    L201:
        r58 = r124;
        r5 = true;
        goto L177
    L198:
        r124 = r58;
        goto L199
    L200:
        r124 = r58;
    L174:
        r57 = null;
    L240:
        MultiDynamicContextFeedImpl r67 = r39.g;
        if (r67 == null) goto L261;
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        a1 r68 = r67.e;
        r68.getClass();
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        RevSeiFrame.a r69 = RevSeiFrame.G;
        String r70 = r24.c;
        if (r70 != null) goto L245;
        r70 = "";
    L245:
        int r72 = 0;
        RevSeiFrame r73 = RevSeiFrame.a.a(r69, r70, false, 6);
        Pair r74 = (Pair) r68.l.invoke();
        int r75 = ((Number) r74.component1()).intValue();
        int r76 = ((Number) r74.component2()).intValue();
        List r126 = (List) r68.j.a.getValue();
        if (r126 == null) goto L248;
        int r127 = f31.l.e(r126);
    L249:
        if (r126 == null) goto L251;
        r72 = f31.l.a(r126);
    L251:
        JSONObject r128 = new JSONObject();
        r128.put("screen_width", s1.y());
        r128.put("screen_height", s1.w());
        r128.put("container_width", r127);
        r128.put("container_height", r72);
        r128.put("player_width", r75);
        r128.put("player_height", r76);
        JSONObject r77 = new JSONObject();
        r77.put("app_data", r73.d());
        r77.put("sei_raw", r73.C);
        r77.put("extra_data", r128);
        r68.a.setValue(r77.toString());
        o0 r78 = r67.f;
        r78.getClass();
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        String r79 = String.valueOf(r24.a());
        if ((!Intrinsics.areEqual(r79, (String) r78.b.getValue())) == false) goto L255;
        r78.b.setValue(r79);
    L255:
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), "sei") == true) goto L261;
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.d() == false) goto L260;
        com.bytedance.revenue.platform.api.core.rx.l r80 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r82 = Observable.just(r24).map(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.p0(r78));
        int r83 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r82.observeOn(Schedulers.single()).subscribe(new q0(r78), r0.a), r78.a);
        goto L261
    L260:
        r78.c.setValue(r78.j(r24));
        goto L261
    L248:
        r127 = 0;
    L261:
        MultiDynamicManager r84 = r39.h;
        if (r84 == null) goto L269;
        Intrinsics.checkNotNullParameter(r24, "seiCache");
        if ((!Intrinsics.areEqual(r84.w, com.bytedance.android.live.revlink.impl.multianchor.dynamic.h.a.b)) == true) goto L269;
        y41.f r85 = y41.f.N;
        r85.getClass();
        if (((Boolean) y41.f.D.getValue(r85, y41.f.a[28])).booleanValue() == false) goto L269;
        r84.p();
    L269:
        FeedMultiBreakThroughBarManager r86 = r39.f;
        if (r86 == null) goto L291;
        Intrinsics.checkNotNullParameter(r24, "seiAppData");
        r86.a = r24;
        if (r86.e() == false) goto L292;
        r86.d();
        return;
    L292:
        return;
    L291:
        return;
    L202:
        IRoom r87 = r47.h;
        if (r87 == null) goto L216;
        if (r87.isThirdParty() != true) goto L216;
        IRoom r88 = r47.h;
        if (r88 != null) goto L209;
    L210:
        IRoom r89 = r47.h;
        if (r89 == null) goto L216;
        if (r89.getVRType() != 2) goto L216;
    L237:
        boolean r90 = false;
    L239:
        r47.i = r90;
        r47.d();
        goto L240
    L209:
        if (r88.getVRType() == 1) goto L237;
    L216:
        if (d51.c.A0.b() == false) goto L238;
        k31.f r92 = r47.l;
        if (r92 == null) goto L238;
        p0 r93 = r92.b;
        if (r93 == null) goto L238;
        String r94 = r93.c();
        if (r94 == null) goto L238;
        if (r94.length() <= 0) goto L226;
        boolean r95 = true;
    L228:
        if (r95 != true) goto L238;
        k31.f r96 = r47.l;
        if (r96 == null) goto L234;
        p0 r97 = r96.b;
        if (r97 == null) goto L234;
        String r98 = r97.c();
    L236:
        if ((!Intrinsics.areEqual(r98, "null")) == false) goto L238;
    L234:
        r98 = null;
        goto L236
    L226:
        r95 = false;
    L238:
        r90 = true;
        goto L239
    L111:
        if (r42.e() == null) goto L145;
        p0 r99 = r44.e;
        if (r99 == null) goto L115;
        List r100 = r99.e();
    L116:
        if (r100 == null) goto L145;
        List r101 = r42.e();
        if (r101 == null) goto L120;
        Integer r102 = Integer.valueOf(r101.size());
    L121:
        int r103 = r102.intValue();
        p0 r104 = r44.e;
        if (r104 == null) goto L145;
        List r105 = r104.e();
        if (r105 == null) goto L145;
        if (r103 != r105.size()) goto L145;
        List r106 = r42.e();
        if (r106 == null) goto L144;
        int r107 = r106.size();
        int r108 = 0;
    L131:
        if (r108 >= r107) goto L144;
        String r109 = ((RevSeiRegion) ListProtector.get(r106, r108)).getInteractId();
        p0 r129 = r44.e;
        if (r129 == null) goto L139;
        List r130 = r129.e();
        if (r130 == null) goto L139;
        RevSeiRegion r131 = (RevSeiRegion) ListProtector.get(r130, r108);
        if (r131 == null) goto L139;
        String r132 = r131.getInteractId();
    L141:
        if ((!Intrinsics.areEqual(r109, r132)) == true) goto L145;
        r108 = r108 + 1;
    L139:
        r132 = null;
    L144:
        r46 = false;
        goto L146
    L120:
        r102 = null;
        goto L121
    L115:
        r100 = null;
    L149:
        if (r44.c == r43) goto L152;
        r44.c = r43;
        r44.b(r44.n);
        goto L152
    L290:
        return;
    L95:
        if (r37.getInnerMovePlayer() == false) goto L99;
        goto L96
    }

    public final void monitorLayouts(String r5) {
        FeedMultiPlayer r0 = this.d;
        if (r0 == null) goto L11;
        if (r5 == null) goto L12;
        AbsLivePlayerView r1 = r0.d();
        if (r1 == null) goto L13;
        ((rc0.d) r0.a.getValue()).b(new hs0.b(MultiPlayerScene.PREVIEW_FEED_FULL_SCREEN, r1, r5));
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void onSeiUpdatedRaw(String r9) {
        k31.f r0 = this.b;
        r0.getClass();
        boolean r1 = false;
        if (r9 == null) goto L67;
        int r2 = m31.c.a;
        Intrinsics.checkNotNullParameter(r9, "seiString");
        com.bytedance.android.live.revlink.impl.settings.live.c r3 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r3.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.t.getValue(r3, com.bytedance.android.live.revlink.impl.settings.live.c.a[18])).booleanValue() == true) goto L8;
    L34:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L67;
        JSONObject r5 = LiveSeiUtil.a(r9);
        if (r5.has("info") == false) goto L50;
        if (r5.has("source") == false) goto L50;
        if (Intrinsics.areEqual(r5.optString("source"), "zego") == false) goto L50;
        Object r6 = r5.get("info");
        if (r6 == null) goto L48;
        r5 = (JSONObject) r6;
        goto L50
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");
    L50:
        if (r5.has("live_crop") == false) goto L57;
        int r7 = n0.a;
        n0 r8 = n0.a.a(JSONObjectProtectorUtils.getJSONObject(r5, "live_crop"));
        if (r8 == null) goto L57;
        if (r8.g() != true) goto L57;
        r0.a = r8;
    L57:
        if (r5.has("app_data") == false) goto L67;
        JSONObject r10 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r5, "app_data"), ""));
        if (r10.has("ver") == false) goto L67;
        if (r10.optInt("ver") != 6) goto L64;
        boolean r12 = true;
    L65:
        if (r12 == false) goto L67;
        r0.b = com.bytedance.android.live.revlink.impl.utils.h.a(r10);
        r0.c = r9;
        r1 = true;
        goto L67
    L64:
        r12 = false;
        goto L65
    L8:
        if ((!StringsKt.isBlank(r9)) == false) goto L35;
        int r13 = r9.length() - 1;
        int r14 = 0;
        boolean r15 = false;
    L10:
        if (r14 > r13) goto L25;
        if (r15 == true) goto L13;
        int r16 = r14;
    L15:
        if (Intrinsics.compare(r9.charAt(r16), 32) > 0) goto L17;
        boolean r17 = true;
    L18:
        if (r15 == false) goto L19;
        if (r17 == false) goto L25;
        r13 = r13 - 1;
        goto L10
    L19:
        if (r17 == false) goto L20;
        r14 = r14 + 1;
        goto L10
    L20:
        r15 = true;
        goto L10
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = r13;
    L25:
        String r18 = r9.subSequence(r14, r13 + 1).toString();
        if (StringsKt.startsWith$default(r18, "{", false, 2, null) == false) goto L31;
        if (StringsKt.endsWith$default(r18, "}", false, 2, null) == true) goto L34;
    L31:
        if (StringsKt.startsWith$default(r18, "[", false, 2, null) == false) goto L35;
        if (StringsKt.endsWith$default(r18, "]", false, 2, null) == true) goto L34;
    L35:
        r4 = false;
    L67:
        if (r1 == false) goto L80;
        f(this.b);
        return;
    }

    public final void putImCacheContent(Map<String, ? extends RevImCacheUnit> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        FeedMultiWidget r1 = this.e;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNullParameter(r4, "map");
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c r2 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "map");
        int r0 = v21.a.c;
        RevImCacheUnit r5 = (RevImCacheUnit) ((HashMap) r4).get("FeedMultiLinkTimeCacheUnit");
        if (r5 == null) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.a r3 = r2.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "cache");
        if ((r5 instanceof v21.a) == true) goto L9;
        return;
    L9:
        if ((r3.r.getState() instanceof x21.d.C0344d) == true) goto L11;
        return;
    L11:
        if (r3.i != null) goto L22;
        Long r6 = ((v21.a) r5).a;
        r3.i = r6;
        if (r6 == null) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.feed.machine.d r7 = r3.j;
        if (r7 == null) goto L24;
        r7.e(r6.longValue());
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L19:
        return;
    }

    public final void sendMessage(List<? extends yh6.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgList");
        Intrinsics.checkNotNullParameter(r2, "msgList");
    }

    public void setJsBridgeMap(Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        FeedMultiWidget r1 = this.e;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.i.putAll(r4);
        MultiDynamicContextFeedImpl r5 = r1.g;
        if (r5 == null) goto L9;
        HashMap<String, com.bytedance.ies.web.jsbridge2.f.b> r2 = r1.i;
        Intrinsics.checkNotNullParameter(r2, "map");
        r5.c.putAll(r2);
        return;
    L9:
        return;
    }

    public void setLivePlayerView(Object r5) {
        FeedMultiPlayer r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof IRenderView) == true) goto L7;
        r5 = null;
    L7:
        r0.b = (IRenderView) r5;
        d r6 = r0.f;
        if (r6 != null) goto L10;
    L13:
        r0.a();
        return;
    L10:
        if (r6.getInnerMovePlayer() == true) goto L13;
        t41.a r7 = t41.a.m;
        r7.getClass();
        if (((Boolean) t41.a.l.getValue(r7, t41.a.a[10])).booleanValue() == false) goto L13;
    }

    public final void updateRoom(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, "room");
        z21.a r1 = this.a;
        r1.a = r4;
        r1.b.setValue(Unit.INSTANCE);
        qc0.a r2 = this.l;
        if (r2 == null) goto L5;
        r2.updateRoom(r4);
    L5:
        FeedMultiWidget r3 = this.e;
        if (r3 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "room");
        r3.l = r4;
        MultiDynamicManager r5 = r3.h;
        if (r5 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "room");
        r5.k = r4;
        r5.p();
    L10:
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r6 = r3.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "room");
        r6.t = r4;
        r3.e.h = r4;
        FeedMultiBreakThroughBarManager r7 = r3.f;
        if (r7 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "room");
        r7.e = r4;
        r7.d();
        return;
    L15:
        return;
    }

    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    public c(Context r7, int r8, d r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.m = r9;
        z21.a r0 = new z21.a(r7, this);
        this.a = r0;
        this.b = new k31.f();
        e41.a r10 = new e41.a();
        this.k = r10;
        boolean r1 = vh6.c.b(vr2.b.class).xd(r8);
        t41.a r2 = t41.a.m;
        r2.getClass();
        if (((Boolean) t41.a.h.getValue(r2, t41.a.a[6])).booleanValue() == true) goto L7;
        if (((Boolean) vh6.c.b(wh6.a.class).getClientABValue(q41.a.a)).booleanValue() == true) goto L7;
    L8:
        if (r1 == true) goto L10;
    L14:
        FeedMultiPlayer r12 = this.d;
        if (r12 == null) goto L17;
        r12.c = true;
    L17:
        FeedMultiWidget r13 = this.e;
        if (r13 == null) goto L20;
        Intrinsics.checkNotNullParameter(r10, "initHandler");
        r13.a = r10;
    L20:
        FeedMultiWidget r14 = this.e;
        if (r14 == null) goto L23;
        r14.h();
    L23:
        r10.c(new a(this));
        return;
    L10:
        if (PadConfigUtils.a() == true) goto L14;
        if (FoldScreenUtils.f() == true) goto L14;
    L13:
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r15 = new com.bytedance.android.live.revlink.impl.multianchor.feed.player.b(r0, this, r1, r9);
        this.c = r15;
        this.d = new FeedMultiPlayer(r15, r9);
        this.e = new FeedMultiWidget(r0, r15, r1, r9);
    L7:
        if (vh6.c.b(vr2.b.class).N7(r8) == true) goto L13;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        Integer r6 = this.g;
        if (r6 != null) goto L6;
    L22:
        f(this.b);
        this.g = Integer.valueOf(r2);
        this.i = Integer.valueOf(r4);
        this.h = Integer.valueOf(r3);
        this.j = Integer.valueOf(r5);
        return;
    L6:
        if (r6.intValue() != r2) goto L22;
        Integer r7 = this.i;
        if (r7 == null) goto L22;
        if (r7.intValue() != r4) goto L22;
        Integer r8 = this.h;
        if (r8 == null) goto L22;
        if (r8.intValue() != r3) goto L22;
        Integer r9 = this.j;
        if (r9 == null) goto L22;
        if (r9.intValue() != r5) goto L22;
    }
}
