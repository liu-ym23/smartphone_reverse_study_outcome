package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.universalwidget.utils.ListDiffUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.GiftIconElementInfo;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatClickType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.UpdateLayoutType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.i30;
import com.bytedance.android.livesdk.config.wb0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
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
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.p2;
import zg1.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v extends lh0.b {
    public final String d;
    public HashMap<String, tf0.d> e;
    public nh0.l f;
    public final Lazy g;
    public final Lazy h;
    public final HashMap<String, Boolean> i;
    public final HashMap<String, Boolean> j;
    public Disposable k;
    public final CompositeDisposable l;
    public int m;
    public List<? extends tf0.e> n;
    public List<? extends tf0.e> o;
    public List<? extends tf0.e> p;
    public int q;
    public boolean r;
    public List<? extends tf0.e> s;
    public List<? extends tf0.e> t;
    public final CompositeDisposable u;
    public final a0 v;
    public final z w;
    public String x;
    public final HashMap<String, Boolean> y;
    public final ih0.b z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            v r0 = this.a;
            v.i(r0, (Map) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ v a;

        public b(v r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            v r0 = this.a;
            v.i(r0, (Map) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ v a;

        public c(v r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            v r0 = this.a;
            r0.getClass();
            HashMap r1 = new HashMap();
            Iterator<T> r9 = ((List) r8).iterator();
            boolean r2 = false;
        L4:
            if (r9.hasNext() == false) goto L14;
            tf0.e r3 = (tf0.e) r9.next();
            if ((r3 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
            MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r3;
            String r5 = r4.k.a.getMInteractIdStr();
            if (r5 != null) goto L10;
            r5 = "";
        L10:
            boolean r6 = ch0.f.a(r4.k);
            if ((!Intrinsics.areEqual(r0.i.get(r5), Boolean.valueOf(r6))) == false) goto L13;
            r2 = true;
        L13:
            r1.put(r5, Boolean.valueOf(r6));
            goto L4
        L14:
            r0.i.clear();
            r0.i.putAll(r1);
            if (r2 == true) goto L17;
            return;
        L17:
            if (((Number) i30.a.getValue()).longValue() > 0) goto L26;
            r0.n();
            return;
        }
    }

    public final void n() {
        JsonArray r0 = new JsonArray();
        Iterator<Map.Entry<String, Boolean>> r1 = this.i.entrySet().iterator();
        boolean r3 = false;
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r4 = r1.next();
        String r5 = r4.getKey();
        boolean r6 = r4.getValue().booleanValue();
        if ((!Intrinsics.areEqual(this.j.get(r5), Boolean.valueOf(r6))) == false) goto L8;
        this.j.put(r5, Boolean.valueOf(r6));
        r3 = true;
    L8:
        JsonObject r7 = new JsonObject();
        r7.addProperty("linkmic_id_str", r5);
        r7.addProperty("is_speaking", Boolean.valueOf(r6));
        r0.add(r7);
        goto L4
    L9:
        if (r3 == false) goto L15;
        JsonObject r2 = new JsonObject();
        r2.add("sei_infos", r0);
        this.z.Dk("seat", "seat_frequent", r2, false);
        this.j.clear();
        this.j.putAll(this.i);
        return;
    }

    public final MultiLinkDynamicWidgetNew o() {
        ih0.b r0 = this.z;
        if (r0 == null) goto L7;
        return (MultiLinkDynamicWidgetNew) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew");
    }

    @Override // lh0.b
    public final void d() {
        super.d();
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        x00.a r1 = r0.getThemeManager(je0.d.D(), this.c);
    L6:
        if (r1 == null) goto L14;
        a0 r2 = this.v;
        IRoom r3 = je0.d.e(this.c);
        if (r3 != null) goto L10;
    L12:
        int r4 = 3;
    L13:
        r1.f(r2, r4);
        goto L14
    L10:
        if (r3.isLiveTypeAudio() != true) goto L12;
        r4 = 2;
    L14:
        this.l.clear();
        this.u.clear();
        hd0.c.f().e(this.w);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean j(List<? extends tf0.e> r8) {
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
        IRoom r11 = com.bytedance.android.live.core.utils.a0.o(this.c);
        if (r11 == null) goto L20;
        String r12 = r11.getOwnerUserIdString();
    L21:
        boolean r13 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r10, r12);
        if ((!Intrinsics.areEqual(this.y.get(r5), Boolean.valueOf(r13))) == false) goto L4;
        this.y.put(r5, Boolean.valueOf(r13));
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

    public final void k(nh0.l r6) {
        if (r6.getType() != SeatUpdateType.UPDATE_BY_UID) goto L37;
        List<tf0.d> r0 = r6.c;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if ((((tf0.d) r3) instanceof nh0.m) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        List r4 = CollectionsKt.toMutableList(r1);
        List<tf0.d> r5 = r6.c;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if ((((tf0.d) r9) instanceof nh0.i) == false) goto L12;
        r7.add(r9);
        goto L12
    L16:
        List r10 = CollectionsKt.toMutableList(r7);
        if ((!r4.isEmpty()) == false) goto L22;
        this.f = new nh0.l(r6.a, r6.getType(), r4);
        sh0.i0 r11 = sh0.j0.a(this.c);
        if (r11 == null) goto L22;
        r11.d0(sh0.n.b, this.f);
    L22:
        if ((!r10.isEmpty()) == false) goto L38;
        sh0.i0 r12 = sh0.j0.a(this.c);
        if (r12 == null) goto L39;
        r12.d0(sh0.n.b, new nh0.l(r6.a, r6.getType(), r10));
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void l(int r6) {
        this.l.clear();
        com.bytedance.android.live.liveinteract.plantform.datamerge.b r1 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L7;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(this.c);
        if (r2 == null) goto L15;
        BehaviorSubject<List<tf0.e>> r3 = r2.el();
    L17:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == true) goto L19;
        if (r3 == null) goto L51;
        Disposable r7 = r3.subscribe(new c(this));
        if (r7 == null) goto L51;
        RxUtilKt.c(r7, this.l);
    L51:
        i30 r8 = i30.a;
        if (((Number) r8.getValue()).longValue() <= 0) goto L59;
        Disposable r4 = this.k;
        if (r4 == null) goto L57;
        r4.dispose();
    L57:
        Disposable r9 = Observable.interval(0, ((Long) r8.getValue()).longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this));
        RxUtilKt.c(r9, this.l);
        this.k = r9;
        return;
    L59:
        return;
    L19:
        if (r6 != 15) goto L21;
    L30:
        LinkUserDataMergeContext r10 = LinkUserDataMergeContext.a.a(LinkUserDataMergeContext.Companion, this.c);
        if (r10 == null) goto L35;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r11 = r10.getLinkRoomFightDataMergeCenter();
        if (r11 == null) goto L35;
        com.bytedance.android.live.liveinteract.plantform.datamerge.b r12 = (com.bytedance.android.live.liveinteract.plantform.datamerge.b) r11.getValue();
    L37:
        if ((r12 instanceof eh0.b) == false) goto L40;
        r1 = r12;
    L40:
        eh0.b r5 = (eh0.b) r1;
        if (r5 == null) goto L51;
        BehaviorSubject<Map<String, Boolean>> r13 = r5.o();
        if (r13 == null) goto L51;
        Disposable r14 = r13.subscribe(new a(this));
        if (r14 == null) goto L51;
        RxUtilKt.c(r14, this.l);
    L35:
        r12 = null;
        goto L37
    L21:
        if (aj0.b.c(r6) == true) goto L30;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r15 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.c);
        if (r15 == null) goto L51;
        BehaviorSubject<Map<String, Boolean>> r16 = r15.j1();
        if (r16 == null) goto L51;
        Disposable r17 = r16.subscribe(new b(this));
        if (r17 == null) goto L51;
        RxUtilKt.c(r17, this.l);
    L15:
        r3 = null;
        goto L17
    L7:
        tf0.o r18 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.e();
        if ((r18 instanceof BaseMultiLinkWindowManager) == true) goto L10;
        r18 = null;
    L10:
        BaseMultiLinkWindowManager r19 = (BaseMultiLinkWindowManager) r18;
        if (r19 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r20 = r19.h;
        if (r20 == null) goto L15;
        r3 = r20.b;
        goto L17
    }

    public final void m(List<? extends tf0.e> r24) {
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
        boolean r14 = j(r2);
        int r15 = ListDiffUtils.a;
        if (ListDiffUtils.c(this.n, r2) == false) goto L27;
        if (r14 == true) goto L27;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same guest list return");
    L47:
        boolean r16 = j(r24);
        if (ListDiffUtils.c(this.o, r24) == false) goto L52;
        if (r16 == true) goto L52;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same seat list return");
        return;
    L52:
        this.o = r24;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a(null, 3) == true) goto L60;
        MultiLinkDynamicWidgetNew r17 = o();
        nh0.f r18 = new nh0.f("seat", null, r24, null, null, null, false, 246);
        int r19 = MultiLinkDynamicWidgetNew.A;
        r17.wq(r18, false);
        return;
    L60:
        return;
    L27:
        this.n = r2;
        if (((Boolean) wb0.a.getValue()).booleanValue() == false) goto L30;
        if (r4 == false) goto L47;
    L30:
        MultiLinkDynamicWidgetNew r110 = o();
        IRoom r20 = com.bytedance.android.live.core.utils.a0.o(this.c);
        if (r20 == null) goto L33;
        String r21 = r20.getOwnerUserIdString();
    L35:
        if (MultiLinkLoadWidgetUtils.j() == false) goto L45;
        MiddlewareRoomContext r22 = o3.c(this.c);
        if (r22 == null) goto L41;
        com.bytedance.live.datacontext.n r23 = r22.isRoomVisible();
        if (r23 == null) goto L41;
        Boolean r25 = (Boolean) r23.getValue();
    L43:
        if (Intrinsics.areEqual(r25, Boolean.FALSE) == false) goto L45;
        boolean r26 = true;
    L46:
        nh0.f r111 = new nh0.f("guest_list", null, r24, null, null, r21, r26, 54);
        int r27 = MultiLinkDynamicWidgetNew.A;
        r110.wq(r111, false);
    L41:
        r25 = null;
    L45:
        r26 = false;
        goto L46
    L33:
        r21 = null;
        goto L35
    }

    public static final void f(v r10, List r11) {
        r10.getClass();
        int r0 = ListDiffUtils.a;
        if (ListDiffUtils.a(r10.s, r11) == true) goto L6;
        r10.s = r11;
        MultiLinkDynamicWidgetNew r12 = r10.o();
        nh0.f r9 = new nh0.f("fanticket", null, r11, null, null, null, false, 246);
        int r13 = MultiLinkDynamicWidgetNew.A;
        r12.wq(r9, false);
        return;
    }

    public static final void g(v r11, List r12) {
        r11.getClass();
        int r0 = ListDiffUtils.a;
        List<? extends tf0.e> r1 = r11.t;
        Intrinsics.checkNotNullParameter(r12, "itemData");
        boolean r2 = false;
        if (r1 != null) goto L6;
    L37:
        if (r2 == true) goto L40;
        r11.c.put("data_multi_lick_dynamic_event_change", new nh0.f("avatar_event", null, r12, null, null, null, false, 246));
        r11.t = r12;
        return;
    L40:
        return;
    L6:
        if (Intrinsics.areEqual(r1, r12) == false) goto L9;
    L36:
        r2 = true;
        goto L37
    L9:
        if (r1.size() != r12.size()) goto L37;
        if (r1.isEmpty() == true) goto L36;
        tf0.e r3 = (tf0.e) ListProtector.get(r1, 0);
        tf0.e r4 = (tf0.e) ListProtector.get(r12, 0);
        boolean r5 = r3 instanceof MultiLinkGuestViewBinder.a;
        if (r5 == false) goto L17;
    L19:
        if (r5 == true) goto L21;
    L23:
        if (r5 == false) goto L36;
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L36;
        MultiLinkGuestViewBinder.a r6 = (MultiLinkGuestViewBinder.a) r4;
        Object r7 = ((MultiLinkGuestViewBinder.a) r3).k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION");
        Object r8 = null;
        if ((r7 instanceof com.bytedance.android.live.liveinteract.hamlet.model.l) == true) goto L29;
        r7 = null;
    L29:
        com.bytedance.android.live.liveinteract.hamlet.model.l r9 = (com.bytedance.android.live.liveinteract.hamlet.model.l) r7;
        Object r10 = r6.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION");
        if ((r10 instanceof com.bytedance.android.live.liveinteract.hamlet.model.l) == false) goto L34;
        r8 = r10;
    L34:
        if (Intrinsics.areEqual(r9, (com.bytedance.android.live.liveinteract.hamlet.model.l) r8) == true) goto L36;
    L21:
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == true) goto L23;
    L17:
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L19;
        goto L19
    }

    public static final void h(v r26, List r27) {
        r26.getClass();
        InteractiveSongContext.a r1 = InteractiveSongContext.Companion;
        InteractiveSongContext r2 = r1.getContext();
        if (r2 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r3 = r2.getSingingGuestId();
        if (r3 == null) goto L8;
        String r4 = (String) r3.getValue();
        if (r4 == null) goto L8;
    L9:
        InteractiveSongContext r5 = r1.getContext();
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isShowPlayer();
        if (r6 == null) goto L16;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L16;
        boolean r8 = r7.booleanValue();
    L17:
        int r9 = ListDiffUtils.a;
        List<? extends tf0.e> r10 = r26.p;
        int r11 = r26.q;
        Integer r12 = je0.d.h();
        if (r12 == null) goto L20;
        int r13 = r12.intValue();
    L22:
        if (ListDiffUtils.b(r10, r11, r27, r13) == true) goto L24;
    L27:
        r26.p = r27;
        r26.x = r4;
        Integer r14 = je0.d.h();
        if (r14 == null) goto L30;
        int r15 = r14.intValue();
    L31:
        r26.q = r15;
        InteractiveSongContext r16 = r1.getContext();
        if (r16 == null) goto L38;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.isShowPlayer();
        if (r17 == null) goto L38;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L38;
        boolean r19 = r18.booleanValue();
    L39:
        r26.r = r19;
        Integer r20 = je0.d.h();
        if (r20 == null) goto L42;
        int r110 = r20.intValue();
    L43:
        nh0.f r21 = (nh0.f) r26.c.get("data_multi_link_dynamic_layout_info_change", new nh0.f(null, null, null, null, null, null, false, 255));
        if (r21 == null) goto L46;
        sf0.b r22 = r21.e;
    L48:
        if ((r22 instanceof sf0.b) == true) goto L50;
        r22 = null;
    L50:
        if (r22 == null) goto L53;
        List<Integer> r23 = r22.b;
        if (r23 == null) goto L53;
    L54:
        List<Integer> r111 = r23;
        z5 r24 = com.bytedance.android.live.ktv.common.util.a.c().getLinkerDetail();
        if (r24 == null) goto L57;
        List r112 = r24.getFeatureList();
    L58:
        nh0.e r25 = new nh0.e(0, r110, null, 0, 0, null, r111, r112, 61);
        MultiLinkDynamicWidgetNew r113 = r26.o();
        nh0.f r114 = new nh0.f("order_sing_visual", r25, r27, null, null, null, false, 244);
        int r0 = MultiLinkDynamicWidgetNew.A;
        r113.wq(r114, false);
        return;
    L57:
        r112 = null;
    L53:
        r23 = CollectionsKt.emptyList();
        goto L54
    L46:
        r22 = null;
        goto L48
    L42:
        r110 = 0;
    L38:
        r19 = false;
        goto L39
    L30:
        r15 = 0;
        goto L31
    L24:
        if ((!Intrinsics.areEqual(r26.x, r4)) == true) goto L27;
        if (r26.r != r8) goto L27;
        return;
    L20:
        r13 = 0;
    L16:
        r8 = false;
    L8:
        r4 = "";
        goto L9
    }

    public static final void i(v r6, Map r7) {
        r6.getClass();
        HashMap r0 = new HashMap();
        Iterator r8 = r7.entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r8.next();
        String r3 = (String) r2.getKey();
        boolean r4 = ((Boolean) r2.getValue()).booleanValue();
        if ((!Intrinsics.areEqual(r6.i.get(r3), Boolean.valueOf(r4))) == false) goto L8;
        r1 = true;
    L8:
        r0.put(r3, Boolean.valueOf(r4));
        goto L4
    L9:
        r6.i.clear();
        r6.i.putAll(r0);
        if (r1 == true) goto L12;
        return;
    L12:
        if (((Number) i30.a.getValue()).longValue() > 0) goto L19;
        r6.n();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [tf0.d] */
    /* JADX WARN: Type inference failed for: r8v15, types: [nh0.m] */
    /* JADX WARN: Type inference failed for: r8v19, types: [tf0.d] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.Object, tf0.d] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [tf0.d] */
    /* JADX WARN: Type inference failed for: r8v6, types: [tf0.d] */
    /* JADX WARN: Type inference failed for: r8v9, types: [tf0.d] */
    public final void p(ih0.f r27, ih0.h r28) {
        Intrinsics.checkNotNullParameter(r27, "updateStatus");
        Intrinsics.checkNotNullParameter(r28, "updateCallback");
        JsonObject r4 = r27.d;
        if (r4 != null) goto L5;
        return;
    L5:
        String r9 = "";
        switch(r.a[r27.getType().ordinal()]) {
            case 1: goto L237;
            case 2: goto L234;
            case 3: goto L189;
            case 4: goto L180;
            case 5: goto L171;
            case 6: goto L50;
            case 7: goto L365;
            default: goto L359;
        };
    L234:
        nh0.d r0 = (nh0.d) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r27.d, nh0.d.class);
        sh0.i0 r3 = sh0.j0.a(this.c);
        if (r3 == null) goto L359;
        r3.d0(sh0.q.b, r0);
        goto L359
    L237:
        String r5 = r27.c;
        JsonObject r6 = r27.d;
        Intrinsics.checkNotNullParameter(r5, "bizId");
        if (r6 != null) goto L363;
    L305:
        nh0.l r1 = null;
    L306:
        if (r1 != null) goto L308;
        return;
    L308:
        if (r1.getType() != SeatUpdateType.UPDATE_BY_UID) goto L310;
        boolean r7 = true;
    L311:
        if (r7 == false) goto L313;
        nh0.l r8 = r1;
    L314:
        if (r8 == null) goto L341;
        List<tf0.d> r10 = r8.c;
        if (r10 == null) goto L341;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L319:
        if (r12.hasNext() == false) goto L323;
        Object r13 = r12.next();
        if ((((tf0.d) r13) instanceof nh0.i) == false) goto L319;
        r11.add(r13);
        goto L319
    L323:
        Iterator r14 = r11.iterator();
    L325:
        if (r14.hasNext() == false) goto L341;
        tf0.d r15 = (tf0.d) r14.next();
        ALogger.w(this.d, "记录随机数据" + r15.c() + "---" + r15);
        if (this.e != null) goto L337;
        this.e = new HashMap();
        LinkUserDataMergeContext.a r16 = LinkUserDataMergeContext.Companion;
        if (r16 == null) goto L337;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r17 = LinkUserDataMergeContext.a.b(r16, this.c);
        if (r17 == null) goto L337;
        BehaviorSubject<List<ch0.e>> r18 = r17.f();
        if (r18 == null) goto L337;
        Disposable r19 = r18.subscribe(new w(this));
        if (r19 == null) goto L337;
        this.a.add(r19);
    L337:
        HashMap<String, tf0.d> r20 = this.e;
        if (r20 == null) goto L325;
        r20.put(r15.c(), r15);
    L341:
        if (b().isLiveTypeAudio() == false) goto L350;
        LinkUserDataMergeContext r21 = LinkUserDataMergeContext.a.a(LinkUserDataMergeContext.Companion, this.c);
        if (r21 == null) goto L349;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d> r22 = r21.getDynamicHandler();
        if (r22 == null) goto L349;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r23 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d) r22.getValue();
        if (r23 == null) goto L349;
        r23.d(r1);
    L349:
        k(r1);
        goto L359
    L350:
        LinkUserDataMergeContext r24 = LinkUserDataMergeContext.a.a(LinkUserDataMergeContext.Companion, this.c);
        if (r24 == null) goto L357;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d> r25 = r24.getDynamicHandler();
        if (r25 == null) goto L357;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r26 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d) r25.getValue();
        if (r26 == null) goto L357;
        r26.d(r1);
    L357:
        k(r1);
        goto L359
    L313:
        r8 = null;
        goto L314
    L310:
        r7 = false;
        goto L311
    L363:
        ArrayList r110 = new ArrayList();     // Catch: Exception -> L303
        if (r6.has("type") == false) goto L246;
        String r111 = r6.get("type").getAsString();     // Catch: Exception -> L303
        Locale r112 = Locale.ROOT;     // Catch: Exception -> L303
        if (r111 == null) goto L245;
        SeatUpdateType r113 = SeatUpdateType.valueOf(r111.toUpperCase(r112));     // Catch: Exception -> L303
    L248:
        if (r6.has("items") == false) goto L250;
        JsonArray r29 = r6.getAsJsonArray("items");     // Catch: Exception -> L303
    L252:
        if (r113 != SeatUpdateType.RESET) goto L262;
        if (r29 == null) goto L301;
        Iterator r2 = r29.iterator();     // Catch: Exception -> L303
    L256:
        if (r2.hasNext() == false) goto L301;
        String r30 = ((JsonElement) r2.next()).getAsString();     // Catch: Exception -> L303
        tf0.d r31 = new tf0.d(0);     // Catch: Exception -> L303
        Locale r114 = Locale.ROOT;     // Catch: Exception -> L303
        if (r30 == null) goto L261;
        r31.f(SeatItemId.valueOf(r30.toUpperCase(r114)));     // Catch: Exception -> L303
        r110.add(r31);     // Catch: Exception -> L303
        goto L256
    L261:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L303
    L301:
        r1 = new nh0.l(r5, r113, r110);     // Catch: Exception -> L303
        goto L306
    L262:
        if (r29 == null) goto L301;
        Iterator r32 = r29.iterator();     // Catch: Exception -> L303
    L265:
        if (r32.hasNext() == false) goto L301;
        JsonObject r115 = ((JsonElement) r32.next()).getAsJsonObject();     // Catch: Exception -> L303
        if (r115.has("item_id") == false) goto L273;
        String r116 = r115.get("item_id").getAsString();     // Catch: Exception -> L303
        Locale r33 = Locale.ROOT;     // Catch: Exception -> L303
        if (r116 == null) goto L272;
        SeatItemId r34 = SeatItemId.valueOf(r116.toUpperCase(r33));     // Catch: Exception -> L303
    L275:
        switch(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.d.a[r34.ordinal()]) {
            case 1: goto L297;
            case 2: goto L296;
            case 3: goto L295;
            case 4: goto L294;
            case 5: goto L278;
            case 6: goto L277;
            default: goto L276;
        };     // Catch: Exception -> L303
    L276:
        ?? r35 = 0;
    L298:
        if (r35 == 0) goto L265;
        r35.f(r34);     // Catch: Exception -> L303
        r110.add(r35);     // Catch: Exception -> L303
        goto L265
    L277:
        ALogger.i("wentipaicha", String.valueOf(r115));     // Catch: Exception -> L303
        r35 = (tf0.d) GsonHelper.getDefault().fromJson(r115, nh0.i.class);     // Catch: Exception -> L303
        goto L298
    L278:
        r35 = (nh0.m) GsonHelper.getDefault().fromJson(r115, nh0.m.class);     // Catch: Exception -> L303
        JsonElement r117 = r115.get("play_type");     // Catch: Exception -> L303
        if (r117 == null) goto L284;
        String r118 = r117.getAsString();     // Catch: Exception -> L303
        if (r118 == null) goto L284;
        String r119 = r118.toUpperCase(Locale.ROOT);     // Catch: Exception -> L303
        if (r119 == null) goto L284;
    L286:
        if (r119.length() <= 0) goto L288;
        boolean r120 = true;
    L289:
        if (r120 == false) goto L291;
        PlayType r121 = PlayType.valueOf(r119);     // Catch: Exception -> L303
    L292:
        if (r35 == 0) goto L298;
        r35.o(r121);     // Catch: Exception -> L303
        goto L298
    L291:
        r121 = PlayType.UNKNOWN;     // Catch: Exception -> L303
        goto L292
    L288:
        r120 = false;
    L284:
        r119 = "";
        goto L286
    L294:
        r35 = (tf0.d) GsonHelper.getDefault().fromJson(r115, nh0.c.class);     // Catch: Exception -> L303
        goto L298
    L295:
        r35 = (tf0.d) GsonHelper.getDefault().fromJson(r115, nh0.q.class);     // Catch: Exception -> L303
        goto L298
    L296:
        r35 = (tf0.d) GsonHelper.getDefault().fromJson(r115, GiftIconElementInfo.class);     // Catch: Exception -> L303
        goto L298
    L297:
        r35 = (tf0.d) GsonHelper.getDefault().fromJson(r115, nh0.t.class);     // Catch: Exception -> L303
        goto L298
    L272:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L303
    L273:
        r34 = SeatItemId.UNKNOWN;     // Catch: Exception -> L303
        goto L275
    L250:
        r29 = null;
        goto L252
    L245:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L303
    L246:
        r113 = SeatUpdateType.UNKNOWN;     // Catch: Exception -> L303
    L303:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToSeatExtraObject: " + r6, e);
    L359:
        a(r28, null);
        return;
    L365:
        ALogger.i(this.d, "ITEM_LOAD_DURATION " + r27.d);     // Catch: Exception -> L47
        tf0.f r36 = (tf0.f) new GsonBuilder().create().fromJson(r27.d, tf0.f.class);     // Catch: Exception -> L47
        com.bytedance.live.datacontext.n r37 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.c, null, 2).x();     // Catch: Exception -> L47
        if (r37 == null) goto L12;
        Object r38 = r37.getValue();     // Catch: Exception -> L47
    L14:
        if ((r38 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L16;
        r38 = null;
    L16:
        MultiSceneEnterRoomStatisticsUtils r39 = (MultiSceneEnterRoomStatisticsUtils) r38;     // Catch: Exception -> L47
        if (r39 == null) goto L19;
        r39.handleDynamicViewLoadDuration(r36);     // Catch: Exception -> L47
    L19:
        tf0.m r40 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.b();     // Catch: Exception -> L47
        if (r40 == null) goto L23;
        r40.a(r36);     // Catch: Exception -> L47
    L23:
        if ((r36 instanceof tf0.f) == true) goto L25;
        r36 = null;
    L25:
        boolean r41 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;     // Catch: Exception -> L47
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(Integer.valueOf(this.m), 0, 6) == false) goto L359;
        if (r36 == null) goto L29;
        String r42 = r36.a();     // Catch: Exception -> L47
    L31:
        if (Intrinsics.areEqual(r42, LoadDurationItemId.RENDER_LYNX_GUEST_SEAT_LIST.getValue()) == false) goto L359;
        long r43 = 0;
        if (MultiLinkLoadWidgetUtils.i() == false) goto L35;
        long r44 = vm2.h.W().smoothEnterPostTime();     // Catch: Exception -> L47
    L37:
        if (r44 <= 0) goto L42;
        Scheduler r45 = AndroidSchedulers.mainThread();     // Catch: Exception -> L47
        s r46 = new s(this);     // Catch: Exception -> L47
        if (MultiLinkLoadWidgetUtils.i() == false) goto L41;
        r43 = vm2.h.W().smoothEnterPostTime();     // Catch: Exception -> L47
    L41:
        r45.scheduleDirect(r46, r43, TimeUnit.MILLISECONDS);     // Catch: Exception -> L47
    L45:
        this.c.put("cmd_voice_chat_room_show_background", new p2("observeWindowDraw_immediately"));     // Catch: Exception -> L47
        this.j.clear();     // Catch: Exception -> L47
        n();     // Catch: Exception -> L47
        goto L359
    L42:
        DataCenter r47 = this.c;     // Catch: Exception -> L47
        Boolean r48 = Boolean.TRUE;     // Catch: Exception -> L47
        r47.put("cmd_multi_enter_room_remove_view_mock", r48);     // Catch: Exception -> L47
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L45;
        this.c.put("cmd_multi_enter_room_lynx_micseat_remove_view_mock", r48);     // Catch: Exception -> L47
        goto L45
    L35:
        r44 = 0;
        goto L37
    L29:
        r42 = null;
        goto L31
    L12:
        r38 = null;
    L47:
        e = move-exception;
        ALogger.e(this.d, "dynamicHandleLoadDuration gson failed!", e);
        e(r28, "dynamicHandleLoadDuration gson failed!");
        goto L359
    L50:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.b0.d() == null) goto L52;
        tf0.o r49 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.d();
    L54:
        if ((r49 instanceof BaseMultiLinkWindowManager) == true) goto L56;
        r49 = null;
    L56:
        BaseMultiLinkWindowManager r50 = (BaseMultiLinkWindowManager) r49;
        if (r50 == null) goto L359;
        Intrinsics.checkNotNullParameter(r27, "updateStatus");
        JsonObject r51 = r27.d;
        if (r51 == null) goto L359;
        int r122 = r51.get("seat_index").getAsInt();     // Catch: Exception -> L79
        int r123 = r51.get("click_type").getAsInt();     // Catch: Exception -> L79
        JsonElement r52 = r51.get("thx_to_userId");     // Catch: Exception -> L79
        if (r52 == null) goto L67;
        String r53 = r52.getAsString();     // Catch: Exception -> L79
        if (r53 == null) goto L67;
        String r124 = r53;
    L68:
        JsonElement r54 = r51.get("friend");     // Catch: Exception -> L79
        if (r54 == null) goto L72;
        String r55 = r54.getAsString();     // Catch: Exception -> L79
        if (r55 == null) goto L72;
    L73:
        User r125 = (User) JsonUtil.parseObject(r55, User.class);     // Catch: Exception -> L79
        JsonElement r56 = r51.get("in_room");     // Catch: Exception -> L79
        if (r56 == null) goto L76;
        boolean r126 = r56.getAsBoolean();     // Catch: Exception -> L79
    L77:
        nh0.k r57 = new nh0.k(r122, r123, r124, r125, r126);     // Catch: Exception -> L79
    L81:
        if (r57 == null) goto L359;
        int r58 = r57.a;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r59 = r50.h;
        if (r59 == null) goto L359;
        BehaviorSubject<List<tf0.e>> r60 = r59.b;
        if (r60 == null) goto L359;
        List r61 = (List) r60.getValue();
        if (r61 == null) goto L359;
        tf0.e r62 = (tf0.e) ListProtector.get(r61, r58);
        if (r62 == null) goto L359;
        int r63 = r57.b;
        if (r63 != SeatClickType.GuestItem.getType()) goto L100;
        if ((r62 instanceof MultiLinkGuestViewBinder.a) == true) goto L96;
        r62 = null;
    L96:
        MultiLinkGuestViewBinder.a r65 = (MultiLinkGuestViewBinder.a) r62;
        if (r65 == null) goto L359;
        r50.w1(r65);
        goto L359
    L100:
        if (r63 != SeatClickType.EmptyItem.getType()) goto L124;
        if ((r62 instanceof MultiLinkNormalEmptyViewBinder.a) == true) goto L104;
        tf0.e r66 = null;
    L105:
        MultiLinkNormalEmptyViewBinder.a r67 = (MultiLinkNormalEmptyViewBinder.a) r66;
        if (r67 == null) goto L109;
        r50.d2(r67);
    L109:
        if ((r62 instanceof MultiLinkFoldButtonViewBinder.a) == true) goto L111;
        tf0.e r68 = null;
    L112:
        MultiLinkFoldButtonViewBinder.a r69 = (MultiLinkFoldButtonViewBinder.a) r68;
        if (r69 == null) goto L118;
        MultiLinkNormalEmptyViewBinder.a r70 = r69.p;
        if (r70 == null) goto L118;
        r50.d2(r70);
    L118:
        if ((r62 instanceof MultiLinkPreOnlineViewBinder.a) == true) goto L120;
        r62 = null;
    L120:
        MultiLinkPreOnlineViewBinder.a r71 = (MultiLinkPreOnlineViewBinder.a) r62;
        if (r71 == null) goto L359;
        r50.V3(r71);
        goto L359
    L111:
        r68 = r62;
        goto L112
    L104:
        r66 = r62;
        goto L105
    L124:
        if (r63 != SeatClickType.Fanticket.getType()) goto L132;
        if ((r62 instanceof MultiLinkGuestViewBinder.a) == true) goto L128;
        r62 = null;
    L128:
        MultiLinkGuestViewBinder.a r72 = (MultiLinkGuestViewBinder.a) r62;
        if (r72 == null) goto L359;
        r50.e4(r72);
        goto L359
    L132:
        if (r63 != SeatClickType.SelfDisciplineRecord.getType()) goto L146;
        if ((r62 instanceof MultiLinkGuestViewBinder.a) == true) goto L136;
        r62 = null;
    L136:
        MultiLinkGuestViewBinder.a r73 = (MultiLinkGuestViewBinder.a) r62;
        if (r73 == null) goto L359;
        ILinkPlayerInfoBridge r74 = r73.k.a;
        if (r74 == null) goto L359;
        IBaseUser r75 = r74.getUser();
        if (r75 == null) goto L359;
        String r76 = r75.getIdString();
        if (r76 == null) goto L359;
        int r77 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.d.a;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.d.a(r50.x, r76);
        goto L359
    L146:
        if (r63 != SeatClickType.SpecialItem.getType()) goto L154;
        if ((r62 instanceof MultiLinkSpecialViewBinder.a) == true) goto L150;
        r62 = null;
    L150:
        MultiLinkSpecialViewBinder.a r78 = (MultiLinkSpecialViewBinder.a) r62;
        if (r78 == null) goto L359;
        r50.Q3(r78);
        goto L359
    L154:
        if (r63 != SeatClickType.FantiketThank.getType()) goto L159;
        String r127 = r57.c;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r79 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r79 == null) goto L359;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.c.a(r79, new QuickInteractTask(null, null, 0, r127, null, null, 0, null, false, null, null, null, null, 8183), "quick_thank");
        goto L359
    L159:
        if (r63 != SeatClickType.FastInviteFriend.getType()) goto L359;
        User r80 = r57.d;
        r50.E5(new ch0.b(r80, r57.e));
        int r81 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.a;
        if (r80 == null) goto L166;
        String r82 = r80.getIdString();
        if (r82 == null) goto L166;
        r9 = r82;
    L166:
        if (r80 == null) goto L168;
        boolean r83 = r80.isSubscriber();
    L169:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.e(false, r9, "seat", r83);
        goto L359
    L168:
        r83 = false;
        goto L169
    L76:
        r126 = false;
    L72:
        r55 = "";
    L67:
        r124 = "";
    L79:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToSeatClickExtraObject: " + r51, e);
        r57 = null;
        goto L81
    L52:
        r49 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.c();
        goto L54
    L171:
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L359;
        new LinkedHashMap();
        Map<Integer, List<Integer>> r84 = ((nh0.h) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4, nh0.h.class)).a();
        ALogger.d(this.d, "dynamicUpdateUIFeature, current ui_layout: " + je0.d.h() + " offset_config: " + r84.get(je0.d.h()));
        ((Map) this.h.getValue()).clear();
        ((Map) this.h.getValue()).putAll(r84);
        sh0.b r85 = sh0.b.b;
        sh0.c r86 = new sh0.c();
        sh0.i0 r87 = sh0.j0.a(this.c);
        if (r87 == null) goto L176;
        r87.d0(r85, r86);
    L176:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L178;
        RxBusAbility.INSTANCE.getRxBus(je0.d.k(this.c)).post(new r0());
        goto L359
    L178:
        xs2.b.a().post(new r0());
        goto L359
    L180:
        if (((Boolean) h30.a.getValue()).booleanValue() == true) goto L359;
        new LinkedHashMap();
        Map<String, LayoutConfigModel> r88 = ((nh0.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4, nh0.g.class)).a();
        ((Map) this.g.getValue()).clear();
        ((Map) this.g.getValue()).putAll(r88);
        sh0.b r89 = sh0.b.b;
        sh0.c r90 = new sh0.c();
        sh0.i0 r91 = sh0.j0.a(this.c);
        if (r91 == null) goto L185;
        r91.d0(r89, r90);
    L185:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L187;
        RxBusAbility.INSTANCE.getRxBus(je0.d.k(this.c)).post(new r0());
        goto L359
    L187:
        xs2.b.a().post(new r0());
        goto L359
    L189:
        if (((Boolean) h30.a.getValue()).booleanValue() == true) goto L359;
        String r92 = r4.get("type").getAsString();     // Catch: Exception -> L202
        Locale r93 = Locale.ROOT;     // Catch: Exception -> L202
        if (r92 == null) goto L201;
        UpdateLayoutType r94 = UpdateLayoutType.valueOf(r92.toUpperCase(r93));     // Catch: Exception -> L202
        JsonElement r95 = r4.get("extra");     // Catch: Exception -> L202
        if (r95 != null) goto L195;
    L204:
        nh0.s r96 = null;
    L205:
        ALogger.i(this.d, "UPDATE_LAYOUT_CONFIG updateConfigObject=" + r96);
        if (r96 == null) goto L359;
        if (r96.getType() != UpdateLayoutType.UPDATE) goto L222;
        sh0.i0 r97 = sh0.j0.a(this.c);
        if (r97 == null) goto L213;
        r97.b("dynamicLayoutConfig", r96);
    L213:
        Integer r98 = je0.d.h();
        if (r98 == null) goto L218;
        int r99 = r98.intValue();
        MultiLinkDynamicContext r100 = MultiLinkDynamicContext.Companion.getContext(null);
        if (r100 == null) goto L218;
        r100.setPreLayoutConfigState(new nh0.p(je0.d.f(), r99));
    L218:
        ArrayList r101 = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(r96.c)});
        sh0.f0 r102 = sh0.f0.b;
        sh0.g0 r103 = new sh0.g0(new zj0.c.b(je0.d.f(), r96.b), r101);
        sh0.i0 r104 = sh0.j0.a(this.c);
        if (r104 == null) goto L359;
        r104.d0(r102, r103);
        goto L359
    L222:
        if (r96.getType() != UpdateLayoutType.RESET) goto L359;
        sh0.i0 r105 = sh0.j0.a(this.c);
        if (r105 == null) goto L226;
        r105.b("dynamicLayoutConfig", null);
    L226:
        MultiLinkDynamicContext r106 = MultiLinkDynamicContext.Companion.getContext(null);
        if (r106 == null) goto L229;
        nh0.p r107 = r106.getPreLayoutConfigState();
    L230:
        if (r107 == null) goto L359;
        sh0.f0 r108 = sh0.f0.b;
        sh0.g0 r109 = new sh0.g0(new zj0.c.b(r107.a, r107.b), null);
        sh0.i0 r128 = sh0.j0.a(this.c);
        if (r128 == null) goto L359;
        r128.d0(r108, r109);
        goto L359
    L229:
        r107 = null;
        goto L230
    L195:
        if (r94 != UpdateLayoutType.UPDATE) goto L198;
        JsonObject r129 = r95.getAsJsonObject();     // Catch: Exception -> L202
        r96 = new nh0.s(r94, r129.get("ui_layout").getAsInt(), r129.get("play_mode").getAsInt());     // Catch: Exception -> L202
        goto L205
    L198:
        if (r94 != UpdateLayoutType.RESET) goto L204;
        r96 = new nh0.s(r94, 0, 0);     // Catch: Exception -> L202
        goto L205
    L201:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L202
    L202:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToTrackerExtraObject: " + r4, e);
        goto L204
    }

    public v(Context r2, final DataCenter r3, ih0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "service");
        super(r2, r3);
        this.z = r4;
        this.d = "MicSeatDynamicHandler-".concat(PbRequest.SwitchType.ROOM);
        this.g = LazyKt.lazy(new MicSeatDynamicHandler$_lynxLayoutConfigOffsetMap$2(r3));
        this.h = LazyKt.lazy(new MicSeatDynamicHandler$_lynxUIFeatureConfigOffsetMap$2(r3));
        this.i = new HashMap();
        this.j = new HashMap();
        this.l = new CompositeDisposable();
        this.u = new CompositeDisposable();
        this.v = new a0(this, r3);
        this.w = new z(this);
        this.x = "";
        this.y = new HashMap();
    }
}
