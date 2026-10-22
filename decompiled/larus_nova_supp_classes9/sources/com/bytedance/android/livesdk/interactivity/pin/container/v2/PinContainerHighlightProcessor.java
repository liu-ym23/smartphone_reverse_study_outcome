package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.highlight.container.HighlightPsId;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z;
import com.bytedance.android.livesdk.interactivity.pin.business.qa.PinAnswerProcessor;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.PinContainerAppLogger;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.wrds.syncdata.HighlightContainerSyncModel;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.CarouselInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightContainerSyncData;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import j70.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import zg1.j2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class PinContainerHighlightProcessor extends p32.e implements g42.c, l {
    public final String f;
    public final List<g42.f> g;
    public final Map<Integer, g42.f> h;
    public final Map<String, a> i;
    public final Map<String, HighlightItem> j;
    public final Map<Integer, g42.f> k;
    public final Map<PinType, List<g42.d>> l;
    public final CompositeDisposable m;
    public final Map<String, Disposable> n;
    public final f o;
    public final BehaviorSubject<List<HighlightItem>> p;
    public final BehaviorSubject q;
    public final int r;
    public final c s;

    public static final class a {
        public boolean a;
        public final HighlightItem b;
        public final long c;

        public a(HighlightItem r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "highlightItem");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PinContainerHighlightProcessor a;
        public final /* synthetic */ HighlightItem b;

        public b(PinContainerHighlightProcessor r1, HighlightItem r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            PinContainerHighlightProcessor r8 = this.a;
            HighlightItem r0 = this.b;
            if (com.bytedance.android.livesdk.interactivity.common.utils.h.b(r8.y()) == false) goto L5;
            r8.z(r0, "over_time");
        L5:
            String r1 = r8.c(r0);
            g42.f r2 = r8.m(r0);
            if (r2 == null) goto L10;
            com.bytedance.android.livesdk.wrds.syncdata.highlight.b r3 = r2.q(r0);
            if (r3 == null) goto L10;
            boolean r4 = r3.isReviewing();
        L11:
            o32.a.a("itemTimeout type=" + r0.getDataType() + " key=" + r1 + " isReviewing=" + r4);
            if (r4 == false) goto L17;
            a r5 = (a) ((LinkedHashMap) r8.i).get(r1);
            if (r5 == null) goto L17;
            r5.a = true;
        L17:
            if (r8.j.remove(r1) == null) goto L25;
            Map<String, HighlightItem> r9 = r8.j;
            ArrayList r10 = new ArrayList(r9.size());
            Iterator r11 = ((LinkedHashMap) r9).entrySet().iterator();
        L20:
            if (r11.hasNext() == false) goto L22;
            r10.add((HighlightItem) ((Map.Entry) r11.next()).getValue());
            goto L20
        L22:
            r8.A(r10);
            return;
        L25:
            return;
        L10:
            r4 = false;
            goto L11
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PinContainerHighlightProcessor a;

        public c(PinContainerHighlightProcessor r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KVData r3 = (KVData) r2;
            if (r3 == null) goto L5;
            Object r4 = r3.getData();
        L7:
            if ((r4 instanceof j2) == false) goto L10;
            this.a.C((j2) r4);
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PinContainerHighlightProcessor a;

        public d(PinContainerHighlightProcessor r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v24, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void accept(Object r21) {
            HighlightContainerSyncData r0 = (HighlightContainerSyncData) r21;
            PinContainerHighlightProcessor r2 = this.a;
            r2.getClass();
            o32.a.a("wrds data updated");
            boolean r3 = com.bytedance.android.livesdk.interactivity.common.utils.h.b(r2.y());
            if (r0 == null) goto L22;
            List r5 = r0.getHighlightItems();
            if (r5 == null) goto L22;
            ?? r6 = new ArrayList();
            Iterator<T> r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L23;
            T r8 = r7.next();
            HighlightItem r9 = (HighlightItem) r8;
            boolean r10 = r2.x(r9);
            boolean r14 = true;
            if (p6.b() < r9.getEndTime()) goto L12;
            boolean r11 = true;
        L13:
            if (r10 == false) goto L16;
            if (r11 == false) goto L16;
            o32.a.a("receive timeout item key=" + r2.c(r9));
        L16:
            if (r10 == false) goto L19;
            if (r11 == true) goto L19;
        L20:
            if (r14 == false) goto L8;
            r6.add(r8);
        L19:
            r14 = false;
            goto L20
        L12:
            r11 = false;
        L23:
            ((LinkedHashMap) r2.j).clear();
            if (r3 == false) goto L66;
            Iterator<T> r1 = ((Iterable) r6).iterator();
        L27:
            if (r1.hasNext() == false) goto L59;
            HighlightItem r4 = (HighlightItem) r1.next();
            String r13 = r2.c(r4);
            r2.j.put(r13, r4);
            a r15 = r2.i.remove(r13);
            if (r15 == null) goto L27;
            HighlightItem r16 = r15.b;
            g42.f r17 = r2.m(r16);
            if (r17 == null) goto L33;
            r17.p(r16);
        L33:
            g42.f r18 = r2.m(r16);
            com.bytedance.android.livesdk.wrds.syncdata.highlight.b r19 = null;
            if (r18 == null) goto L36;
            PinType r110 = r18.f();
        L37:
            if (r18 == null) goto L39;
            r19 = r18.q(r16);
        L39:
            List<g42.d> r111 = r2.g(r110);
            if (r19 == null) goto L42;
            long r112 = r19.getMessageId();
        L43:
            if (r19 == null) goto L46;
            String r20 = r19.getCommentContent();
            if (r20 == null) goto L46;
        L47:
            String r113 = r20;
            if (r19 == null) goto L50;
            long r114 = r19.getReviewingTime();
        L52:
            if (r114 <= 0) goto L58;
            int r23 = PinContainerAppLogger.a;
            PinContainerAppLogger.h(r16, r110, r112, r2.y(), System.currentTimeMillis() - r114, r111);
            int r24 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
            LiveMonitor.a r25 = InteractivityMonitor.a(InteractivityMonitor.Event.PinReview, r2.w(), String.valueOf(r112));
            r25.l(0);
            r25.m("pin review success");
            if (r110 != null) goto L56;
            PinType r26 = PinType.Unknown;
        L57:
            r25.e("pin_type", r26.getDesc());
            r25.h(System.currentTimeMillis() - r114);
            r25.a().report();
            goto L58
        L56:
            r26 = r110;
        L58:
            PinContainerAppLogger.i(r16, r110, r112, r113, r2.y(), r111);
            goto L27
        L50:
            r114 = 0;
        L46:
            r20 = BuildConfig.FLAVOR;
            goto L47
        L42:
            r112 = 0;
            goto L43
        L36:
            r110 = null;
            goto L37
        L59:
            Iterator<T> r27 = ((LinkedHashMap) r2.i).entrySet().iterator();
        L61:
            if (r27.hasNext() == false) goto L65;
            Map.Entry r28 = (Map.Entry) r27.next();
            if (((a) r28.getValue()).a == true) goto L61;
            r2.j.put((String) r28.getKey(), ((a) r28.getValue()).b);
            goto L61
        L65:
            ArrayList r29 = new ArrayList(((LinkedHashMap) r2.j).values());
        L85:
            ((HashMap) r2.n).clear();
            r2.m.clear();
            Iterator<T> r30 = r29.iterator();
        L87:
            if (r30.hasNext() == false) goto L89;
            r2.t((HighlightItem) r30.next());
            goto L87
        L89:
            r2.A(r29);
            return;
        L66:
            if (r0 == null) goto L73;
            CarouselInfo r31 = r0.getCarouselInfo();
            if (r31 == null) goto L73;
            List r33 = r31.getItemGroup();
            if (r33 == null) goto L73;
            Set r34 = CollectionsKt.toSet(r33);
            if (r34 == null) goto L73;
        L74:
            ArrayList r35 = new ArrayList();
            Iterator<T> r36 = ((Iterable) r6).iterator();
        L76:
            if (r36.hasNext() == false) goto L80;
            T r37 = r36.next();
            if (r34.contains(Long.valueOf(((HighlightItem) r37).getItemId())) == false) goto L76;
            r35.add(r37);
            goto L76
        L80:
            Iterator r38 = r35.iterator();
        L82:
            if (r38.hasNext() == false) goto L84;
            HighlightItem r39 = (HighlightItem) r38.next();
            r2.j.put(r2.c(r39), r39);
            goto L82
        L84:
            r29 = r35;
        L73:
            r34 = SetsKt.emptySet();
        L22:
            r6 = CollectionsKt.emptyList();
            goto L23
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PinContainerHighlightProcessor a;

        public e(PinContainerHighlightProcessor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            this.a.p().z(this.a);
        }
    }

    public static final class f implements o {
        public final /* synthetic */ PinContainerHighlightProcessor a;

        public static final class a implements w70.a<h70.b> {
            public final /* synthetic */ f a;

            public a(f r1) {
                this.a = r1;
            }

            public final Widget a(h70.b r2) {
                Intrinsics.checkNotNullParameter(r2, "layerContext");
                return new PinWidget(this.a.a);
            }
        }

        public final /* synthetic */ Object[] a() {
            return null;
        }

        public final Class<? extends Widget> c() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final /* synthetic */ boolean g() {
            return true;
        }

        public final boolean h() {
            return true;
        }

        public final boolean i() {
            return false;
        }

        public final w70.a<? extends h70.b> j() {
            return new a(this);
        }

        public f(PinContainerHighlightProcessor r1) {
            this.a = r1;
        }

        public final ViewGroup e(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            View r3 = this.a.p().f(2131567139);
            if (r3 == null) goto L7;
            return (ViewGroup) r3;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void B() {
        RxUtilKt.c(Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)), this.e);
    }

    public PinContainerHighlightProcessor() {
        super(BuildConfig.FLAVOR);
        this.f = HighlightPsId.Pin.getKey();
        this.g = new ArrayList();
        this.h = new HashMap();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new HashMap();
        this.l = new EnumMap(PinType.class);
        this.m = new CompositeDisposable();
        this.n = new HashMap();
        this.o = new f(this);
        BehaviorSubject<List<HighlightItem>> r0 = BehaviorSubject.create();
        this.p = r0;
        this.q = r0;
        this.r = UtilityKotlinExtentionsKt.i(124);
        this.s = new c(this);
    }

    @Override // p32.d
    public final boolean canShow() {
        return !this.i.isEmpty();
    }

    @Override // g42.c
    public final String getCurrentUserId() {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L10;
        IUser r2 = r1.b();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "0";
    }

    public List<g42.f> u() {
        ArrayList r0 = new ArrayList();
        z.a r1 = z.a;
        DataCenter r2 = getDataCenter();
        r1.getClass();
        if (z.a.a(r2) == true) goto L5;
        r0.add(new com.bytedance.android.livesdk.interactivity.pin.business.comment.i());
    L5:
        r0.add(new PinAnswerProcessor());
        r0.add(new n92.g());
        r0.add(new m92.g());
        r0.add(new l92.j());
        r0.add(new k92.a());
        return r0;
    }

    @Override // g42.c
    public final long e() {
        dc2.c<HighlightContainerSyncData> r0 = v();
        if (r0 == null) goto L9;
        HighlightContainerSyncData r1 = r0.c();
        if (r1 == null) goto L9;
        CarouselInfo r2 = r1.getCarouselInfo();
        if (r2 == null) goto L9;
        return r2.getTime();
    L9:
        return 15000;
    }

    @Override // g42.c
    public Context getContext() {
        return p().getContext();
    }

    @Override // g42.c
    public final DataCenter getDataCenter() {
        return p().getDataCenter();
    }

    @Override // g42.c
    public final RoomContext getDataContext() {
        return p().getDataContext();
    }

    @Override // p32.e, p32.d
    public final void onDestroy() {
        super.onDestroy();
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(InteractivityMessageType.AnswerReview.getMessageIntType(), this);
    L9:
        DataCenter r3 = getDataCenter();
        if (r3 == null) goto L12;
        r3.removeObserver("cmd_portrait_row_3_load", this.s);
    L12:
        Iterator r4 = ((ArrayList) this.g).iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((g42.f) r4.next()).onDestroy();
        goto L14
    L16:
        ((ArrayList) this.g).clear();
        ((HashMap) this.h).clear();
        ((HashMap) this.k).clear();
        ((LinkedHashMap) this.i).clear();
        ((LinkedHashMap) this.j).clear();
        ((EnumMap) this.l).clear();
        ((HashMap) this.n).clear();
        this.m.clear();
    }

    public final dc2.c<HighlightContainerSyncData> v() {
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getHighlightSyncModel();
        if (r1 == null) goto L9;
        HighlightContainerSyncModel r2 = (HighlightContainerSyncModel) r1.getValue();
        if (r2 == null) goto L9;
        return r2.getHighlightContainerInfo();
    L9:
        return null;
    }

    public final Room w() {
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        return (Room) r1.getValue();
    L7:
        return null;
    }

    public final boolean y() {
        return com.bytedance.android.live.core.utils.z.e(getDataCenter(), false);
    }

    @Override // p32.a, p32.d
    public String getId() {
        return this.f;
    }

    @Override // g42.c
    public final BehaviorSubject k() {
        return this.q;
    }

    @Override // g42.c
    public final Map<String, HighlightItem> o() {
        return this.j;
    }

    @Override // p32.e
    public o q() {
        return this.o;
    }

    public final void A(List<HighlightItem> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        o32.a.a("updateDisplayingItems. num=" + r3.size());
        this.p.onNext(r3);
        if (r3.isEmpty() == false) goto L6;
        B();
        return;
    }

    public final void C(j2 r3) {
        if ((r3 instanceof j2) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.a, Boolean.TRUE) == false) goto L16;
        int r4 = r3.b - UtilityKotlinExtentionsKt.i(16);
        Element<?> r1 = this.d;
        if (r1 == null) goto L9;
        v70.c r2 = r1.h();
    L10:
        v70.a r0 = (v70.a) new WeakReference(r2).get();
        if (r4 <= this.r) goto L17;
        if (r0 == null) goto L18;
        r0.b(-3, r4, -3, -3);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r2 = null;
        goto L10
    }

    @Override // g42.c
    public final void a(g42.g r3) {
        Intrinsics.checkNotNullParameter(r3, "pinWidget");
        o32.a.a("onPinWidgetLoaded");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g42.f) r0.next()).a(r3);
        goto L4
    }

    @Override // p32.d
    public final boolean b(HighlightItem r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if (x(r7) == true) goto L5;
        return false;
    L5:
        if (p6.b() < r7.getEndTime()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    @Override // g42.c
    public final String c(HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Map<Integer, g42.f> r0 = this.h;
        HashMap r1 = (HashMap) r0;
        g42.f r2 = (g42.f) r1.get(Integer.valueOf(r3.getDataType()));
        if (r2 == null) goto L7;
        String r4 = r2.c(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return String.valueOf(r3.hashCode());
    }

    @Override // g42.c
    public final void d(g42.g r3) {
        Intrinsics.checkNotNullParameter(r3, "pinWidget");
        o32.a.a("onPinWidgetUnload");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g42.f) r0.next()).d(r3);
        goto L4
    }

    @Override // g42.c
    public final List<g42.d> g(PinType r4) {
        if (r4 == null) goto L4;
        ArrayList r0 = new ArrayList();
        PinType r1 = PinType.All;
        if (r4 == r1) goto L10;
        List r2 = (List) ((EnumMap) this.l).get(r1);
        if (r2 == null) goto L10;
        r0.addAll(r2);
    L10:
        List r5 = (List) ((EnumMap) this.l).get(r4);
        if (r5 == null) goto L13;
        r0.addAll(r5);
    L13:
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    @Override // p32.d
    public final void h(p32.c r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r4, "container");
        this.a = r4;
        Iterator<T> r5 = u().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        g42.f r0 = (g42.f) r5.next();
        ((ArrayList) this.g).add(r0);
        Map<Integer, g42.f> r1 = this.h;
        HashMap r2 = (HashMap) r1;
        r2.put(Integer.valueOf(r0.f().getDataType()), r0);
        Integer r3 = r0.k();
        if (r3 == null) goto L4;
        int r6 = r3.intValue();
        Map<Integer, g42.f> r7 = this.k;
        HashMap r8 = (HashMap) r7;
        r8.put(Integer.valueOf(r6), r0);
        goto L4
    L8:
        Iterator r9 = ((ArrayList) this.g).iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        ((g42.f) r9.next()).e(this);
        goto L10
    L12:
        dc2.c<HighlightContainerSyncData> r10 = v();
        if (r10 == null) goto L19;
        Observable<HighlightContainerSyncData> r11 = r10.d;
        if (r11 == null) goto L19;
        Disposable r13 = r11.subscribe(new d(this));
        if (r13 == null) goto L19;
        RxUtilKt.c(r13, this.e);
    L19:
        r(g42.h.class, new PinContainerHighlightProcessor$onCreate$2(this));
        r(g42.l.class, new PinContainerHighlightProcessor$onCreate$3(this));
        n(PinType.All, new com.bytedance.android.livesdk.interactivity.pin.container.v2.d(this));
        DataCenter r14 = getDataCenter();
        if (r14 == null) goto L22;
        r14.observe("cmd_portrait_row_3_load", this.s, true);
    L22:
        RoomContext r15 = getDataContext();
        if (r15 == null) goto L34;
        com.bytedance.live.datacontext.j r16 = r15.getMessageManager();
        if (r16 == null) goto L35;
        r16.c(new PinContainerHighlightProcessor$onCreate$4(this));
        return;
    L35:
        return;
    }

    @Override // g42.c
    public final boolean i(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        String r3 = c(r2);
        return this.i.containsKey(r3);
    }

    @Override // p32.e, p32.d
    public final void l(p32.b r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        super.l(r2);
        DataCenter r3 = getDataCenter();
        if (r3 == null) goto L5;
        j2 r4 = (j2) r3.get("cmd_portrait_row_3_load");
    L6:
        C(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // g42.c
    public final g42.f m(HighlightItem r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Map<Integer, g42.f> r0 = this.h;
        HashMap r1 = (HashMap) r0;
        return (g42.f) r1.get(Integer.valueOf(r2.getDataType()));
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof com.bytedance.android.livesdk.interactivity.api.message.model.a) == false) goto L30;
        com.bytedance.android.livesdk.interactivity.api.message.model.a r11 = (com.bytedance.android.livesdk.interactivity.api.message.model.a) r10;
        if (r11.T() != 1) goto L31;
        g42.f r0 = (g42.f) ((HashMap) this.k).get(Integer.valueOf(r11.Q()));
        if (r0 != null) goto L9;
        return;
    L9:
        PinType r1 = r0.f();
        long r2 = r11.H();
        String r4 = r0.l(r11);
        o32.a.a("review failed. pinType=" + r1 + " uniqueKey=" + r4 + " commentId=" + r2);
        a r5 = (a) ((LinkedHashMap) this.i).get(r4);
        if (r5 == null) goto L16;
        long r6 = r5.c;
        int r7 = com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.a.a;
        LiveMonitor.a r3 = InteractivityMonitor.a(InteractivityMonitor.Event.PinReview, w(), String.valueOf(r2));
        r3.l(-1);
        r3.m("pin review failed");
        if (r1 != null) goto L14;
        r1 = PinType.Unknown;
    L14:
        r3.e("pin_type", r1.getDesc());
        r3.h(System.currentTimeMillis() - r6);
        r3.a().report();
    L16:
        if (this.i.remove(r4) == null) goto L27;
        o32.a.a("removeReviewItem. key=" + r4);
        if (this.j.remove(r4) == null) goto L27;
        Disposable r8 = (Disposable) ((HashMap) this.n).remove(r4);
        if (r8 == null) goto L22;
        this.m.remove(r8);
    L22:
        Map<String, HighlightItem> r9 = this.j;
        ArrayList r13 = new ArrayList(r9.size());
        Iterator r14 = ((LinkedHashMap) r9).entrySet().iterator();
    L24:
        if (r14.hasNext() == false) goto L26;
        r13.add((HighlightItem) ((Map.Entry) r14.next()).getValue());
        goto L24
    L26:
        A(r13);
    L27:
        r0.h(r11);
        return;
    L31:
        return;
    }

    public final void t(HighlightItem r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        g42.f r0 = m(r9);
        if (r0 != null) goto L5;
        return;
    L5:
        Long r1 = r0.m(r9);
        if (r1 == null) goto L15;
        long r2 = r1.longValue();
        String r3 = r0.c(r9);
        PinType r4 = r0.f();
        if (r2 > 0) goto L10;
        o32.a.a("no need to countdown. duration=" + r2 + " type=" + r4 + " uniqueKey=" + r3);
        return;
    L10:
        o32.a.a("start countdown. item can display " + r2 + " ms. type=" + r4 + " uniqueKey=" + r3);
        Disposable r10 = Observable.timer(r2, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r9));
        Disposable r5 = (Disposable) ((HashMap) this.n).put(r3, r10);
        if (r5 == null) goto L13;
        this.m.remove(r5);
    L13:
        this.m.add(r10);
        return;
    }

    public final boolean x(HighlightItem r3) {
        Map<Integer, g42.f> r0 = this.h;
        HashMap r1 = (HashMap) r0;
        g42.f r2 = (g42.f) r1.get(Integer.valueOf(r3.getDataType()));
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.b(r3) != true) goto L7;
        return true;
    }

    @Override // g42.c
    public final void n(PinType r3, g42.d r4) {
        Intrinsics.checkNotNullParameter(r3, "pinType");
        Intrinsics.checkNotNullParameter(r4, "injector");
        List r0 = (List) ((EnumMap) this.l).get(r3);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        ((EnumMap) this.l).put(r3, r0);
    L5:
        r0.add(r4);
    }

    public void s(g42.f r5, HighlightItem r6) {
        Intrinsics.checkNotNullParameter(r5, "processor");
        Intrinsics.checkNotNullParameter(r6, "item");
        long r0 = System.currentTimeMillis();
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r2 = r5.q(r6);
        if (r2 != null) goto L5;
    L10:
        String r7 = r5.c(r6);
        this.i.put(r7, new a(r6, r0));
        o32.a.a("addReviewingItem key=" + r7);
        t(r6);
        this.j.put(r7, r6);
        Map<String, HighlightItem> r8 = this.j;
        ArrayList r9 = new ArrayList(r8.size());
        Iterator r10 = ((LinkedHashMap) r8).entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r9.add((HighlightItem) ((Map.Entry) r10.next()).getValue());
        goto L12
    L14:
        A(r9);
        return;
    L5:
        if ((r2 instanceof com.bytedance.android.livesdk.wrds.syncdata.highlight.a) == true) goto L7;
        r2 = null;
    L7:
        com.bytedance.android.livesdk.wrds.syncdata.highlight.a r3 = (com.bytedance.android.livesdk.wrds.syncdata.highlight.a) r2;
        if (r3 == null) goto L10;
        r3.setReviewing(true);
        r3.setReviewingTime(r0);
        goto L10
    }

    public final void z(HighlightItem r13, String r14) {
        g42.f r0 = m(r13);
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r1 = null;
        if (r0 == null) goto L5;
        PinType r4 = r0.f();
    L6:
        if (r0 == null) goto L8;
        r1 = r0.q(r13);
    L8:
        if (r1 == null) goto L10;
        long r2 = r1.getMessageId();
    L11:
        long r5 = r2;
        if (r1 == null) goto L15;
        String r3 = r1.getCommentContent();
        if (r3 == null) goto L15;
    L16:
        String r7 = r3;
        int r6 = PinContainerAppLogger.a;
        PinContainerAppLogger.f(r13, r4, r5, r7, y(), r14, g(r4));
        return;
    L15:
        r3 = BuildConfig.FLAVOR;
        goto L16
    L10:
        r2 = 0;
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
