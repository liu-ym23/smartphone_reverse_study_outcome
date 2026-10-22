package mh0;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.universalwidget.utils.ListDiffUtils;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.config.i30;
import com.bytedance.android.livesdk.config.wb0;
import com.bytedance.android.livesdk.l2;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends lh0.a {
    public final ue0.c A;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d B;
    public final eh0.b C;
    public final eh0.b D;
    public final String e;
    public final Map<String, LayoutConfigModel> f;
    public final Map<Integer, List<Integer>> g;
    public final HashMap<String, Boolean> h;
    public final HashMap<String, Boolean> i;
    public Disposable j;
    public final CompositeDisposable k;
    public int l;
    public List<? extends tf0.e> m;
    public List<? extends tf0.e> n;
    public List<? extends tf0.e> o;
    public int p;
    public List<? extends tf0.e> q;
    public final CompositeDisposable r;
    public IMultiScenePreviewStatistics s;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a t;
    public boolean u;
    public Integer v;
    public String w;
    public final HashMap<String, Boolean> x;
    public final ih0.b y;
    public final int z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            p r0 = this.a;
            p.f(r0, (Map) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            p r0 = this.a;
            p.f(r0, (Map) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ p a;

        public c(p r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            p r0 = this.a;
            p.f(r0, (Map) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ p a;

        public d(p r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            p r0 = this.a;
            r0.getClass();
            Iterator<T> r8 = ((List) r7).iterator();
            boolean r1 = false;
        L4:
            if (r8.hasNext() == false) goto L14;
            tf0.e r2 = (tf0.e) r8.next();
            if ((r2 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
            MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
            String r4 = r3.k.a.getMInteractIdStr();
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            boolean r5 = ch0.f.a(r3.k);
            if ((!Intrinsics.areEqual(r0.h.get(r4), Boolean.valueOf(r5))) == false) goto L13;
            r1 = true;
        L13:
            r0.h.put(r4, Boolean.valueOf(r5));
            goto L4
        L14:
            if (r1 == true) goto L16;
            return;
        L16:
            if (((Number) i30.a.getValue()).longValue() > 0) goto L25;
            r0.m();
            return;
        }
    }

    @Override // lh0.a
    public final void c() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.z) == false) goto L11;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r1 = this.B;
        if (r1 == null) goto L19;
        BehaviorSubject<List<LinkmicPositionItem>> r2 = r1.g();
        if (r2 == null) goto L20;
        Disposable r3 = r2.subscribe(new o(this));
        if (r3 == null) goto L21;
        RxUtilKt.c(r3, this.a);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L11:
        ue0.c r4 = this.A;
        if (r4 == null) goto L23;
        BehaviorSubject<List<LinkmicPositionItem>> r5 = r4.e;
        if (r5 == null) goto L24;
        Disposable r6 = r5.subscribe(new n(this));
        if (r6 == null) goto L25;
        RxUtilKt.c(r6, this.a);
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void m() {
        JsonArray r0 = new JsonArray();
        Iterator<Map.Entry<String, Boolean>> r1 = this.h.entrySet().iterator();
        boolean r2 = false;
        boolean r3 = false;
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r4 = r1.next();
        String r6 = r4.getKey();
        boolean r5 = r4.getValue().booleanValue();
        if ((!Intrinsics.areEqual(this.i.get(r6), Boolean.valueOf(r5))) == false) goto L8;
        this.i.put(r6, Boolean.valueOf(r5));
        r3 = true;
    L8:
        JsonObject r7 = new JsonObject();
        r7.addProperty("linkmic_id_str", r6);
        r7.addProperty("is_speaking", Boolean.valueOf(r5));
        r0.add(r7);
        goto L4
    L9:
        if (r3 == false) goto L71;
        JsonObject r8 = new JsonObject();
        r8.add("sei_infos", r0);
        this.y.Dk("seat", "seat_frequent", r8, false);
        int r9 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        String r10 = null;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.z) == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r11 = this.B;
        if (r11 == null) goto L50;
        BehaviorSubject<List<ch0.e>> r12 = r11.f();
        if (r12 == null) goto L50;
        List r13 = (List) r12.getValue();
        if (r13 == null) goto L50;
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();
        if (((ch0.e) r15).a.isEnlarged() != true) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == false) goto L20;
    L28:
        ch0.e r17 = (ch0.e) r15;
        if (r17 == null) goto L50;
        ILinkPlayerInfoBridge r18 = r17.a;
        if (r18 == null) goto L50;
        r10 = r18.getInteractId();
        goto L50
    L24:
        r16 = false;
        goto L25
    L27:
        r15 = null;
    L50:
        boolean r19 = Intrinsics.areEqual(this.h.get(r10), Boolean.TRUE);
        Integer r20 = this.v;
        if (r20 != null) goto L54;
    L56:
        i(r2, r19);
        this.i.clear();
        this.i.putAll(this.h);
        return;
    L54:
        if (r20.intValue() != 0) goto L56;
        r2 = true;
        goto L56
    L33:
        ue0.c r21 = this.A;
        if (r21 == null) goto L50;
        Iterator<T> r22 = r21.o().iterator();
    L37:
        if (r22.hasNext() == false) goto L44;
        Object r23 = r22.next();
        if (((ch0.e) r23).a.isEnlarged() != true) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == false) goto L37;
    L45:
        ch0.e r25 = (ch0.e) r23;
        if (r25 == null) goto L50;
        ILinkPlayerInfoBridge r26 = r25.a;
        if (r26 == null) goto L50;
        r10 = r26.getInteractId();
        goto L50
    L41:
        r24 = false;
        goto L42
    L44:
        r23 = null;
        goto L45
    }

    public final MultiLinkFeedDynamicWidgetNew n() {
        ih0.b r0 = this.y;
        if (r0 == null) goto L7;
        return (MultiLinkFeedDynamicWidgetNew) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew");
    }

    @Override // lh0.a
    public final void d() {
        super.d();
        if (((Boolean) l2.a.getValue()).booleanValue() == false) goto L7;
        Disposable r0 = this.j;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        this.k.clear();
        this.r.clear();
    }

    public final boolean g(List<? extends tf0.e> r8) {
        Iterator<T> r9 = r8.iterator();
        boolean r1 = false;
    L4:
        if (r9.hasNext() == false) goto L24;
        tf0.e r2 = (tf0.e) r9.next();
        if ((r2 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
        IBaseUser r4 = r3.k.a.getUser();
        if (r4 == null) goto L11;
        String r5 = r4.getIdString();
        if (r5 == null) goto L11;
    L13:
        if (r5.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L4;
        MultiLinkFrequencyOptConfig r7 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        ch0.e r10 = r3.k;
        IRoom r11 = b();
        if (r11 == null) goto L20;
        String r12 = r11.getOwnerUserIdString();
    L21:
        boolean r13 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r10, r12);
        if ((!Intrinsics.areEqual(this.x.get(r5), Boolean.valueOf(r13))) == false) goto L4;
        this.x.put(r5, Boolean.valueOf(r13));
        r1 = true;
        goto L4
    L20:
        r12 = null;
        goto L21
    L15:
        r6 = false;
    L11:
        r5 = "";
        goto L13
    L24:
        return r1;
    }

    public final void h(int r6) {
        this.k.clear();
        int r0 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.z) == true) goto L5;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r7 = this.t;
        if (r7 == null) goto L36;
        BehaviorSubject<List<tf0.e>> r8 = r7.b;
        if (r8 == null) goto L36;
        Disposable r9 = r8.subscribe(new d(this));
        if (r9 == null) goto L36;
        RxUtilKt.c(r9, this.k);
    L36:
        i30 r10 = i30.a;
        if (((Number) r10.getValue()).longValue() <= 0) goto L44;
        Disposable r1 = this.j;
        if (r1 == null) goto L42;
        r1.dispose();
    L42:
        Disposable r11 = Observable.interval(0, ((Long) r10.getValue()).longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
        RxUtilKt.c(r11, this.k);
        this.j = r11;
        return;
    L44:
        return;
    L5:
        if (aj0.b.c(r6) == false) goto L14;
        eh0.b r12 = this.C;
        if (r12 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r13 = r12.o();
        if (r13 == null) goto L36;
        Disposable r14 = r13.subscribe(new a(this));
        if (r14 == null) goto L36;
        RxUtilKt.c(r14, this.k);
        goto L36
    L14:
        if (r6 != 15) goto L22;
        eh0.b r15 = this.D;
        if (r15 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r16 = r15.o();
        if (r16 == null) goto L36;
        Disposable r17 = r16.subscribe(new b(this));
        if (r17 == null) goto L36;
        RxUtilKt.c(r17, this.k);
        goto L36
    L22:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r18 = this.B;
        if (r18 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r19 = r18.j1();
        if (r19 == null) goto L36;
        Disposable r20 = r19.subscribe(new c(this));
        if (r20 == null) goto L36;
        RxUtilKt.c(r20, this.k);
        goto L36
    }

    public final void j(List<? extends tf0.e> r12) {
        int r0 = ListDiffUtils.a;
        if (ListDiffUtils.a(this.q, r12) == true) goto L6;
        this.q = r12;
        n().fg(new nh0.f("fanticket", null, r12, null, null, null, false, 246));
        return;
    }

    public final void k(List<? extends tf0.e> r24) {
        if (r24 != null) goto L5;
        return;
    L5:
        List<? extends tf0.e> r1 = r24;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
        boolean r4 = false;
        int r13 = 0;
    L6:
        String r12 = null;
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        int r6 = r13 + 1;
        if (r13 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Object r7 = (tf0.e) r5;
        if ((r7 instanceof MultiLinkGuestViewBinder.a) == false) goto L20;
        tc0.c r8 = tc0.c.h();
        MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r7;
        IBaseUser r10 = r9.k.a.getUser();
        if (r10 == null) goto L16;
        r12 = r10.getIdString();
    L16:
        Map.Entry<Long, ? extends g2> r11 = r8.g(r12);
        if (r11 == null) goto L19;
        r9.k.a.setOtherRoomInfo(r11);
    L19:
        r4 = true;
    L21:
        r2.add(r7);
        r13 = r6;
        goto L6
    L20:
        r7 = new MultiLinkNormalEmptyViewBinder.a(r13, null, null, false, false, false, false, false, false, 1022);
        goto L21
    L22:
        boolean r14 = g(r2);
        int r15 = ListDiffUtils.a;
        if (ListDiffUtils.c(this.m, r2) == false) goto L27;
        if (r14 == true) goto L27;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same guest list return");
    L41:
        boolean r16 = g(r24);
        if (ListDiffUtils.c(this.n, r24) == false) goto L46;
        if (r16 == true) goto L46;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same seat list return");
        return;
    L46:
        this.n = r24;
        if (r.a(null, 3) == true) goto L60;
        MultiLinkFeedDynamicWidgetNew r17 = n();
        String r18 = "seat";
        nh0.e r19 = null;
        sf0.b r20 = null;
        JsonObject r21 = null;
        String r22 = null;
        if (MultiLinkLoadWidgetUtils.j() == true) goto L51;
    L53:
        boolean r23 = false;
    L54:
        r17.fg(new nh0.f(r18, r19, r24, r20, r21, r22, r23, 118));
        return;
    L51:
        if (this.u == false) goto L53;
        r23 = true;
        goto L54
    L60:
        return;
    L27:
        this.m = r2;
        if (((Boolean) wb0.a.getValue()).booleanValue() == false) goto L30;
        if (r4 == false) goto L41;
    L30:
        MultiLinkFeedDynamicWidgetNew r110 = n();
        String r25 = "guest_list";
        nh0.e r26 = null;
        sf0.b r27 = null;
        JsonObject r28 = null;
        IRoom r29 = b();
        if (r29 == null) goto L33;
        String r30 = r29.getOwnerUserIdString();
    L35:
        if (MultiLinkLoadWidgetUtils.j() == true) goto L37;
    L39:
        boolean r31 = false;
    L40:
        r110.fg(new nh0.f(r25, r26, r24, r27, r28, r30, r31, 54));
        goto L41
    L37:
        if (this.u == false) goto L39;
        r31 = true;
        goto L40
    L33:
        r30 = null;
        goto L35
    }

    public final void l(List<? extends tf0.e> r19) {
        InteractiveSongContext r2 = InteractiveSongContext.Companion.getContext();
        String r3 = "";
        if (r2 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r4 = r2.getSingingGuestId();
        if (r4 == null) goto L8;
        String r5 = (String) r4.getValue();
        if (r5 == null) goto L8;
    L9:
        int r6 = ListDiffUtils.a;
        List<? extends tf0.e> r7 = this.o;
        int r8 = this.p;
        Integer r9 = this.d.a();
        if (r9 == null) goto L12;
        int r10 = r9.intValue();
    L14:
        if (ListDiffUtils.b(r7, r8, r19, r10) == true) goto L16;
    L17:
        this.o = r19;
        this.w = r5;
        Integer r11 = this.d.a();
        if (r11 == null) goto L20;
        int r12 = r11.intValue();
    L21:
        this.p = r12;
        IRoom r13 = this.d.r();     // Catch: Exception -> L53
        if (r13 == null) goto L30;
        z5 r14 = r13.getLinkerDetail();     // Catch: Exception -> L53
        if (r14 == null) goto L30;
        String r15 = r14.getClientUiInfo();     // Catch: Exception -> L53
        if (r15 == null) goto L30;
        r3 = r15;
    L30:
        ClientUIInfo r16 = (ClientUIInfo) GsonHelper.get().fromJson(r3, ClientUIInfo.class);     // Catch: Exception -> L53
        Integer r17 = this.d.a();     // Catch: Exception -> L53
        if (r17 == null) goto L33;
        int r18 = r17.intValue();     // Catch: Exception -> L53
    L35:
        if (r16 == null) goto L37;
        List r20 = r16.getUiFeatureList();     // Catch: Exception -> L53
    L39:
        if ((r20 instanceof ArrayList) == true) goto L41;
        r20 = null;
    L41:
        ArrayList r21 = (ArrayList) r20;     // Catch: Exception -> L53
        if (r21 == null) goto L44;
    L43:
        ArrayList r110 = r21;
        IRoom r22 = this.d.r();     // Catch: Exception -> L53
        if (r22 == null) goto L50;
        z5 r23 = r22.getLinkerDetail();     // Catch: Exception -> L53
        if (r23 == null) goto L50;
        List r111 = r23.getFeatureList();     // Catch: Exception -> L53
    L51:
        n().fg(new nh0.f("order_sing_visual", new nh0.e(0, r18, null, 0, 0, null, r110, r111, 61), r19, null, null, null, false, 244));     // Catch: Exception -> L53
        return;
    L50:
        r111 = null;
        goto L51
    L44:
        r21 = new ArrayList();     // Catch: Exception -> L53
        goto L43
    L37:
        r20 = null;
        goto L39
    L33:
        r18 = 0;
    L53:
        e = move-exception;
        ALogger.e(this.e, "sendOrderSingVisualToLynx " + e.getMessage());
        return;
    L20:
        r12 = 0;
        goto L21
    L16:
        if ((!Intrinsics.areEqual(this.w, r5)) == true) goto L17;
        return;
    L12:
        r10 = 0;
    L8:
        r5 = "";
        goto L9
    }

    public static final void f(p r6, Map r7) {
        r6.getClass();
        HashMap r0 = new HashMap();
        Iterator r8 = r7.entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r8.next();
        String r3 = (String) r2.getKey();
        boolean r4 = ((Boolean) r2.getValue()).booleanValue();
        if ((!Intrinsics.areEqual(r6.h.get(r3), Boolean.valueOf(r4))) == false) goto L8;
        r1 = true;
    L8:
        r0.put(r3, Boolean.valueOf(r4));
        goto L4
    L9:
        r6.h.clear();
        r6.h.putAll(r0);
        if (r1 == true) goto L12;
        return;
    L12:
        if (((Number) i30.a.getValue()).longValue() > 0) goto L19;
        r6.m();
        return;
    }

    public final void i(boolean r4, boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "big_head");
        JsonObject r1 = new JsonObject();
        r1.addProperty("display", Boolean.valueOf(r4));
        r1.addProperty("talking", Boolean.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
        r0.add("data", r1);
        this.y.Dk("avatar", "avatar_event", r0, false);
    }

    public p(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r4, ih0.b r5, int r6, ue0.c r7, com.bytedance.android.live.liveinteract.plantform.datamerge.d r8, eh0.b r9, eh0.b r10) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r4, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "service");
        super(r2, r3, r4);
        this.y = r5;
        this.z = r6;
        this.A = r7;
        this.B = r8;
        this.C = r9;
        this.D = r10;
        this.e = "MicSeatFeedDynamicHandler";
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new HashMap();
        this.i = new HashMap();
        this.k = new CompositeDisposable();
        this.r = new CompositeDisposable();
        this.w = "";
        this.x = new HashMap();
    }
}
