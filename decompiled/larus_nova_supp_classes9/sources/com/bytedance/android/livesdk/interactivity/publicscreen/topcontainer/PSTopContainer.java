package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BizAdMsgPanelViewManager;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ShowFinishType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.g0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.DanmakuCarnivalTrayManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import f52.i;
import f52.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pm1.h;
import r52.j2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSTopContainer implements f52.b {
    public f52.c a;
    public boolean b;
    public final Map<String, f52.d> c;
    public final Map<f52.f, FrameLayout> d;
    public final Map<String, Disposable> e;
    public final Map<String, a> f;
    public final Lazy g;
    public final List<f52.e> h;
    public Disposable i;
    public final Lazy j;
    public final long k;
    public long l;
    public final c m;
    public final Context n;
    public final Map<f52.c, AbsPSHighlightComp> o;
    public final FrameLayout p;
    public final DataCenter q;

    public static final class a {
        public final f52.c a;
        public final long b;

        public a(f52.c r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PSTopContainer a;
        public final /* synthetic */ f52.c b;

        public b(PSTopContainer r1, f52.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.g(this.b) == false) goto L7;
            PSTopContainer r0 = this.a;
            f52.c r1 = r0.a;
            if (r1 == null) goto L11;
            r1.e(this.b, r0);
            return;
        L11:
            return;
        L7:
            Map<String, a> r2 = this.a.f;
            HashMap r3 = (HashMap) r2;
            a r4 = (a) r3.remove(this.b.getId());
            if (r4 == null) goto L13;
            this.a.w(r4);
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

    public static final class c implements Runnable {
        public final /* synthetic */ PSTopContainer a;

        public final void a() {
            long r0 = this.a.l - System.currentTimeMillis();
            if (r0 > 0) goto L5;
            PSTopContainer r1 = this.a;
            String r2 = PSTopContainer.m(this.a.a) + " timeout, force stop. maxShowDuration=" + this.a.k;
            r1.getClass();
            i.a(r2);
            PSTopContainer r3 = this.a;
            r3.l = -1;
            r3.l(null, true);
            return;
        L5:
            this.a.n().postDelayed(this, r0);
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

        public c(PSTopContainer r1) {
            this.a = r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PSTopContainer a;
        public final /* synthetic */ f52.c b;

        public d(PSTopContainer r1, f52.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PSTopContainer a;

        public e(PSTopContainer r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b r4 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b) r3;
            PSTopContainer r5 = this.a;
            String r0 = "receive ForceStopCurViewEvent. curView=" + PSTopContainer.m(this.a.a);
            r5.getClass();
            i.a(r0);
            this.a.l(null, true);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PSTopContainer a;
        public final /* synthetic */ f52.c b;

        public f(PSTopContainer r1, f52.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            Map<String, Disposable> r5 = this.a.e;
            HashMap r6 = (HashMap) r5;
            if (((Disposable) r6.remove(this.b.getId())) == null) goto L6;
            this.a.t(this.b, ShowFinishType.TIMEOUT);
            return;
        }
    }

    public final Handler n() {
        return (Handler) this.g.getValue();
    }

    @Override // f52.b
    public final o getRoomContext() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return IRoomContextService.a.a(r0, this.q, 0, 2);
    }

    @Override // f52.b
    public final void onCreate() {
        if (this.b == false) goto L5;
        return;
    L5:
        i.a("onCreate");
        this.b = true;
        this.i = xs2.b.a().b(com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.b.class).subscribe(new e(this));
        ArrayList r1 = new ArrayList();
        o r2 = getRoomContext();
        if (r2 == null) goto L10;
        m r3 = r2.getRoom();
        if (r3 == null) goto L10;
        IRoom r4 = (IRoom) r3.getValue();
    L11:
        boolean r5 = false;
        if (PublicScreenABHelper.a(r4) == true) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
        r1.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.b());
    L19:
        o r7 = getRoomContext();
        if (r7 == null) goto L24;
        m r8 = r7.getRoom();
        if (r8 == null) goto L24;
        IRoom r9 = (IRoom) r8.getValue();
    L26:
        if (PublicScreenABHelper.a(r9) == true) goto L28;
    L30:
        if (r5 == false) goto L32;
        r1.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.d());
    L32:
        r1.add(new DanmakuCarnivalTrayManager());
        nu2.a r10 = (nu2.a) h.d.c(nu2.a.class);
        if (r10 == null) goto L35;
        Object r11 = r10.getLikeEggTopViewManager(getContext(), this.q);
    L37:
        if ((r11 instanceof f52.d) == true) goto L39;
        r11 = null;
    L39:
        f52.d r13 = (f52.d) r11;
        if (r13 == null) goto L43;
        r1.add(r13);
    L43:
        if (((xs1.e) com.bytedance.android.livesdk.chatroom.setting.a.a.getValue()).b() == false) goto L53;
        dq1.c r14 = pm1.f.k();
        if (r14 == null) goto L47;
        BizAdMsgPanelViewManager r15 = r14.g(this.q, getContext(), this.p);
    L49:
        if ((r15 instanceof f52.d) == true) goto L51;
        r15 = null;
    L51:
        if (r15 == null) goto L53;
        r1.add(r15);
        goto L53
    L47:
        r15 = null;
    L53:
        r1.add(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.e());
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(this.q, 1);
        if (r0 == null) goto L58;
        n<ViewGroup> r16 = r0.getMatchTrayRootView();
        if (r16 == null) goto L58;
        ViewGroup r17 = (ViewGroup) r16.getValue();
    L59:
        if (r17 == null) goto L61;
        r1.add(new qa2.k(r17));
    L63:
        if (v.a() == false) goto L65;
        r1.add(new sa2.b());
    L65:
        Iterator r18 = r1.iterator();
    L67:
        if (r18.hasNext() == false) goto L69;
        e((f52.d) r18.next());
        goto L67
    L69:
        return;
    L61:
        SafetyGuard.a(null, null, "matchTrayRootView is null");
    L58:
        r17 = null;
        goto L59
    L35:
        r11 = null;
        goto L37
    L28:
        if (PublicScreenABHelper.C == false) goto L30;
        r5 = true;
    L24:
        r9 = null;
        goto L26
    L14:
        if (PublicScreenABHelper.C == true) goto L16;
        r6 = true;
    L10:
        r4 = null;
        goto L11
    }

    @Override // f52.b
    public final void onDestroy() {
        if (this.b == true) goto L5;
        return;
    L5:
        i.a("onDestroy");
        this.b = false;
        Disposable r0 = this.i;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        f52.c r1 = this.a;
        if (r1 == null) goto L11;
        h(r1, r1.b(this, null));
        q(r1, ShowFinishType.DESTROY);
        this.a = null;
    L11:
        Iterator r2 = ((HashMap) this.c).entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        ((f52.d) ((Map.Entry) r2.next()).getValue()).onUnload();
        goto L13
    L15:
        ((HashMap) this.c).clear();
        n().removeCallbacksAndMessages(null);
        ((HashMap) this.f).clear();
        ((ArrayList) this.h).clear();
        this.p.removeAllViews();
        ((HashMap) this.d).clear();
        Iterator r3 = ((HashMap) this.e).entrySet().iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        ((Disposable) ((Map.Entry) r3.next()).getValue()).dispose();
        goto L17
    L19:
        ((HashMap) this.e).clear();
        ((LinkedHashMap) this.o).clear();
    }

    @Override // f52.b
    public Context getContext() {
        return this.n;
    }

    @Override // f52.b
    public final DataCenter getDataCenter() {
        return this.q;
    }

    @Override // f52.b
    public final ViewGroup getRoot() {
        return this.p;
    }

    public static String m(f52.c r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        return "id=" + r2.getId() + " type=" + r2.getType();
    }

    public static void p(String r1) {
        int r0 = i.a;
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.e("PSTopContainer", r1);
    }

    @Override // f52.b
    public final void a(j r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.b(this, r3));
    }

    @Override // f52.b
    public final View c(f52.c r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        View r0 = LayoutInflater.from(getContext()).inflate(2131567498, o(r5.getType()), this.b);
        if ((!Intrinsics.areEqual(this.a, r5)) == false) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        return r0;
    }

    @Override // f52.b
    public final void d(f52.c r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if (this.b == false) goto L26;
        f52.c r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getId();
    L9:
        if ((!Intrinsics.areEqual(r2, r6.getId())) == false) goto L16;
        StringBuilder r3 = new StringBuilder("notifyShowFinish failed. curId=");
        f52.c r4 = this.a;
        if (r4 == null) goto L13;
        r1 = r4.getId();
    L13:
        r3.append(r1);
        r3.append(". viewId=");
        r3.append(r6.getId());
        p(r3.toString());
        return;
    L16:
        if (r6.getEndTimestamp() <= 0) goto L18;
        return;
    L18:
        if (r6.getDuration() <= 0) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L24;
        n().post(new d(this, r6));
        return;
    L24:
        t(r6, ShowFinishType.NORMAL);
        return;
    L7:
        r2 = null;
        goto L9
    }

    @Override // f52.b
    public final void e(f52.d r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (this.b == true) goto L7;
        p("register view manger " + r3.getId() + " after destroy");
        return;
    L7:
        if (((HashMap) this.c).containsKey(r3.getId()) == false) goto L10;
        p("register view manager " + r3.getId() + " twice");
        return;
    L10:
        ((HashMap) this.c).put(r3.getId(), r3);
        r3.j(this);
    }

    @Override // f52.b
    public final void f(f52.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b == true) goto L7;
        p("register show listener after destroy");
        return;
    L7:
        if (((ArrayList) this.h).contains(r2) == true) goto L10;
        ((ArrayList) this.h).add(r2);
        return;
    }

    public final boolean g(f52.c r5) {
        f52.c r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r0.getType(), r5.getType()) == true) goto L7;
        return false;
    L7:
        if (r0.g() == true) goto L9;
        return false;
    L9:
        if (r5.g() == true) goto L11;
        return false;
    L11:
        if (r0.j(r5) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final void j(f52.c r9) {
        z.a r0 = z.a;
        DataCenter r1 = this.q;
        r0.getClass();
        if (z.a.a(r1) == false) goto L16;
        IPublicScreenService r2 = (IPublicScreenService) k.f(IPublicScreenService.class);
        if (r2 == null) goto L18;
        String r3 = r9.getId();
        HighlightAreaPriorityConfig r4 = r9.c();
        long r5 = 100;
        if (r4 == null) goto L9;
        long r6 = r4.getShowPriority();
    L10:
        HighlightAreaPriorityConfig r7 = r9.c();
        if (r7 == null) goto L13;
        r5 = r7.getLocationPriority();
    L13:
        AbsPSHighlightComp r8 = r2.createFastHighlightComp(r3, new PSHighlightType.b(r6, r5), getContext(), this.q, new PSTopContainer$doShow$1(this, r9));
        if (r8 == null) goto L19;
        this.o.put(r9, r8);
        r8.q();
        return;
    L19:
        return;
    L9:
        r6 = 100;
        goto L10
    L18:
        return;
    L16:
        s(r9);
    }

    public final void k(f52.c r3) {
        i.a("forceShow " + m(r3) + ". cur " + m(this.a));
        l(r3, false);
        j(r3);
    }

    public final FrameLayout o(f52.f r5) {
        FrameLayout r0 = (FrameLayout) ((HashMap) this.d).get(r5);
        if (r0 != null) goto L6;
        FrameLayout r1 = new FrameLayout(this.p.getContext());
        this.p.addView(r1, new ViewGroup.LayoutParams(-1, -1));
        ((HashMap) this.d).put(r5, r1);
        i.a("create wrap view for " + r5);
        return r1;
    L6:
        return r0;
    }

    public final void s(f52.c r7) {
        i.a("do show " + m(r7));
        this.a = r7;
        UtilityKotlinExtentionsKt.w(o(r7.getType()));
        Iterator r0 = ((ArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f52.e) r0.next()).g(r7);
        goto L4
    L6:
        r7.h(this);
        if (this.l > 0) goto L9;
        this.l = System.currentTimeMillis() + this.k;
        n().postDelayed(this.m, this.k);
    L11:
        if (r7.getEndTimestamp() <= 0) goto L17;
        long r1 = r7.getEndTimestamp() - System.currentTimeMillis();
        if (r1 > 0) goto L15;
        t(r7, ShowFinishType.TIMEOUT);
        return;
    L15:
        v(r7, r1);
        return;
    L17:
        if (r7.getDuration() <= 0) goto L23;
        v(r7, ((long) r7.getDuration()) * 1000);
        return;
    L23:
        return;
    L9:
        this.l = System.currentTimeMillis() + this.k;
        goto L11
    }

    public final void u(a r3) {
        i.a("queue " + m(r3.a));
        ((PriorityQueue) this.j.getValue()).add(r3);
    }

    public final void w(a r8) {
        f52.c r0 = r8.a;
        i.a("tryShow " + m(r0) + ". cur: " + m(this.a));
        f52.c r1 = this.a;
        if (r1 == null) goto L31;
        int r2 = r0.getType().getPriority() - r1.getType().getPriority();
        if (r2 <= 0) goto L14;
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.a[r0.d().ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L42;
        SafetyGuard.a(null, null, "priority higher. discard");
        return;
    L42:
        return;
    L12:
        k(r0);
        return;
    L13:
        u(r8);
        return;
    L14:
        if (r2 != 0) goto L23;
        int r4 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.b[r0.k().ordinal()];
        if (r4 == 1) goto L22;
        if (r4 == 2) goto L21;
        if (r4 != 3) goto L43;
        i.a("priority equal. discard");
        r0.a(DiscardReason.CONFLICT);
        return;
    L43:
        return;
    L21:
        k(r0);
        return;
    L22:
        u(r8);
        return;
    L23:
        int r5 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.c[r0.f().ordinal()];
        if (r5 == 1) goto L30;
        if (r5 == 2) goto L29;
        if (r5 != 3) goto L44;
        SafetyGuard.a(null, null, "priority lower. interrupt");
        return;
    L44:
        return;
    L29:
        i.a("priority lower. discard");
        r0.a(DiscardReason.CONFLICT);
        return;
    L30:
        u(r8);
        return;
    L31:
        j(r0);
    }

    public PSTopContainer(FrameLayout r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.p = r5;
        this.q = r6;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = LazyKt.lazy(PSTopContainer$mainHandler$2.INSTANCE);
        this.h = new ArrayList();
        this.j = LazyKt.lazy(PSTopContainer$showQueue$2.INSTANCE);
        g0.a.getClass();
        this.k = ((long) RangesKt.coerceAtLeast(((g0) j2.a.getValue()).b(), 1)) * 1000;
        this.l = -1;
        this.m = new c(this);
        this.n = r5.getContext();
        this.o = new LinkedHashMap();
    }

    public final void h(f52.c r3, CleanStrategy r4) {
        f52.f r5 = r3.getType();
        FrameLayout r0 = (FrameLayout) ((HashMap) this.d).get(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        int r6 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.a.d[r4.ordinal()];
        if (r6 != 2) goto L8;
        r0.removeAllViews();
    L12:
        UtilityKotlinExtentionsKt.t(r0);
        return;
    L8:
        if (r6 != 3) goto L12;
        ((HashMap) this.d).remove(r5);
        r0.removeAllViews();
        this.p.removeView(r0);
        goto L12
    }

    public final void l(f52.c r4, boolean r5) {
        f52.c r0 = this.a;
        if (r0 == null) goto L8;
        Map<String, Disposable> r1 = this.e;
        HashMap r2 = (HashMap) r1;
        Disposable r3 = (Disposable) r2.remove(r0.getId());
        if (r3 == null) goto L7;
        r3.dispose();
    L7:
        h(r0, r0.b(this, r4));
        this.a = null;
        q(r0, ShowFinishType.INTERRUPT);
    L8:
        if (r5 == false) goto L11;
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.c(this));
        return;
    }

    public final void q(f52.c r3, ShowFinishType r4) {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f52.e) r0.next()).d(r3, r4);
        goto L4
    }

    public final void r(f52.c r3, ShowFinishType r4) {
        this.o.remove(r3);
        i.a("onShowFinish " + m(r3) + " finishType=" + r4);
        h(r3, r3.i(this));
        this.a = null;
        q(r3, r4);
        n().post(new com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.c(this));
    }

    public final void t(f52.c r3, ShowFinishType r4) {
        z.a r0 = z.a;
        DataCenter r1 = this.q;
        r0.getClass();
        if (z.a.a(r1) == false) goto L7;
        AbsPSHighlightComp r5 = (AbsPSHighlightComp) ((LinkedHashMap) this.o).get(r3);
        if (r5 == null) goto L9;
        r5.p("finish_type", r4);
        r5.b();
        return;
    L9:
        return;
    L7:
        r(r3, r4);
    }

    public final void v(f52.c r4, long r5) {
        i.a("start countdown " + r5 + "ms. " + m(r4));
        Disposable r0 = (Disposable) ((HashMap) this.e).get(r4.getId());
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ((HashMap) this.e).put(r4.getId(), Observable.timer(r5, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r4)));
    }

    @Override // f52.b
    public final void b(f52.c r3, View r4, ViewGroup.LayoutParams r5) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.b == true) goto L5;
        return;
    L5:
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L8;
        r0 = null;
    L8:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L11;
        r1.removeView(r4);
    L11:
        FrameLayout r2 = o(r3.getType());
        if (r5 == null) goto L14;
        r2.addView(r4, r5);
    L16:
        if ((!Intrinsics.areEqual(r3, this.a)) == false) goto L19;
        UtilityKotlinExtentionsKt.t(r2);
        return;
    L19:
        return;
    L14:
        r2.addView(r4);
        goto L16
    }

    public final void i(f52.c r4, long r5, long r7) {
        i.a("delay show. delayMillis=" + r7 + ' ' + m(r4));
        ((HashMap) this.f).put(r4.getId(), new a(r4, r5));
        n().postDelayed(new b(this, r4), r7);
    }
}
