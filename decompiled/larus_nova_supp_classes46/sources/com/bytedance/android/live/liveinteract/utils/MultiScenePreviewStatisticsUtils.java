package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.LinkPreviewMonitorData;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.util.StatisticsItem;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiScenePreviewStatisticsUtils implements IMultiScenePreviewStatistics {
    public static final /* synthetic */ int w = 0;
    public final ArrayList<Integer> a;
    public final Map<String, Long> b;
    public IRoom c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o;
    public long p;
    public boolean q;
    public final Map<String, BehaviorSubject<Long>> r;
    public final List<BehaviorSubject<Long>> s;
    public final List<BehaviorSubject<Long>> t;
    public final HashMap<String, StatisticsItem> u;
    public final long v;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ CompositeDisposable a;
        public final /* synthetic */ MultiScenePreviewStatisticsUtils b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function0 e;

        public b(CompositeDisposable r1, MultiScenePreviewStatisticsUtils r2, List r3, String r4, Function0 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object apply(Object r9) {
            Object[] r10 = (Object[]) r9;
            Intrinsics.checkNotNullParameter(r10, "args");
            final ArrayList r0 = new ArrayList();
            int r1 = r10.length;
            boolean r2 = false;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L12;
            Object r4 = r10[r3];
            if ((r4 instanceof Long) == true) goto L7;
            r4 = null;
        L7:
            Long r5 = (Long) r4;
            if (r5 == null) goto L10;
            r0.add(r5);
        L10:
            r3 = r3 + 1;
            goto L3
        L12:
            if (r0.isEmpty() == true) goto L23;
            Iterator r11 = r0.iterator();
        L16:
            if (r11.hasNext() == false) goto L23;
            if (((Number) r11.next()).longValue() != 0) goto L20;
            boolean r6 = true;
        L21:
            if (r6 == false) goto L16;
        L24:
            if (r2 == false) goto L27;
            this.b.uploadUILoadEnd(this.d, this.e, new MultiScenePreviewStatisticsUtils$startObserveUIElementLoadEnd$$inlined$let$lambda$1$1(this, r0));
            this.a.clear();
        L27:
            return Unit.INSTANCE;
        L20:
            r6 = false;
        L23:
            r2 = true;
            goto L24
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
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

    static {
    }

    public final void startObservePlayModeElementLoadEnd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
    }

    public MultiScenePreviewStatisticsUtils() {
        this(0);
    }

    public static boolean d() {
        return ((Boolean) vm2.d.C.getValue(null, vm2.d.a[26])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) vm2.d.B.getValue(null, vm2.d.a[25])).booleanValue();
    }

    public final void clearUploadUIData() {
        if (d() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.u.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((StatisticsItem) r0.next()).getDiposable().clear();
        goto L7
    L9:
        Iterator<T> r1 = this.r.values().iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        ((BehaviorSubject) r1.next()).onNext(0L);
        goto L11
    }

    public final void onViewHolderUnSelected() {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L22:
        clearUploadUIData();
        return;
    L10:
        if (this.n == false) goto L22;
        if (this.q == true) goto L22;
        if (a("background_Load") == 0) goto L22;
        if (a("lynx_guest_seat_list") == 0) goto L22;
        StringBuilder r1 = new StringBuilder("roomId=");
        IRoom r2 = this.c;
        if (r2 == null) goto L20;
        Long r3 = Long.valueOf(r2.getId());
    L21:
        r1.append(r3);
        r1.append(", onViewHolderUnSelected uploadPreloadFirstFrameLog");
        ALogger.i("livesdk_audience_preview_loading_statistics", r1.toString());
        uploadUILoadEnd("link_mic", AnonymousClass1.INSTANCE, new AnonymousClass2(this));
        goto L22
    L20:
        r3 = null;
        goto L21
    L5:
        if (vm2.h.W().preloadLeaveFeedViewUpdateFirstFrameOpt() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void startObserveLoadEnd() {
        if (d() == true) goto L5;
        return;
    L5:
        IRoom r0 = this.c;
        Long r1 = null;
        if (r0 == null) goto L8;
        Map r2 = r0.getLinkMap();
    L9:
        boolean r3 = false;
        if (r2 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L74;
        Iterator<T> r5 = this.a.iterator();
    L19:
        if (r5.hasNext() == false) goto L27;
        int r6 = ((Number) r5.next()).intValue();
        IRoom r7 = this.c;
        if (r7 == null) goto L19;
        Map r8 = r7.getLinkMap();
        if (r8 == null) goto L19;
        if (r8.containsKey(String.valueOf(r6)) != true) goto L19;
        boolean r9 = true;
    L28:
        if (r9 == false) goto L76;
        StringBuilder r10 = new StringBuilder("roomId=");
        IRoom r11 = this.c;
        if (r11 == null) goto L33;
        r1 = Long.valueOf(r11.getId());
    L33:
        r10.append(r1);
        r10.append(", startObserveLoadEnd");
        ALogger.i("livesdk_audience_preview_loading_statistics", r10.toString());
        BehaviorSubject<Long> r12 = this.r.get("start");
        if (r12 == null) goto L36;
        r12.onNext(Long.valueOf(System.currentTimeMillis()));
    L36:
        System.currentTimeMillis();
        startObserveBaseElementLoadEnd("link_mic");
        this.k = true;
        IRoom r13 = this.c;
        if (r13 == null) goto L43;
        Map r14 = r13.getLinkMap();
        if (r14 == null) goto L43;
        if (r14.containsKey(String.valueOf(9)) != true) goto L43;
        boolean r15 = true;
    L44:
        if (r15 == false) goto L75;
        IRoom r16 = this.c;
        if (r16 == null) goto L52;
        Map r17 = r16.getLinkMap();
        if (r17 == null) goto L52;
        if (r17.containsKey(String.valueOf(9)) != true) goto L52;
        boolean r18 = true;
    L53:
        if (r18 == false) goto L61;
        IRoom r19 = this.c;
        if (r19 == null) goto L61;
        z5 r20 = r19.getLinkerDetail();
        if (r20 == null) goto L61;
        if (r20.getUiLayout() != 61) goto L61;
        r3 = true;
    L61:
        if (r3 == false) goto L63;
        String r21 = "chorus";
    L64:
        startObserveKtvElementLoadEnd(r21);
        return;
    L63:
        r21 = "ktv";
    L52:
        r18 = false;
        goto L53
    L75:
        return;
    L43:
        r15 = false;
        goto L44
    L76:
        return;
    L27:
        r9 = false;
        goto L28
    L74:
        return;
    L12:
        if (r2.isEmpty() == true) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = null;
        goto L9
    }

    public MultiScenePreviewStatisticsUtils(long r18) {
        this.v = r18;
        this.a = CollectionsKt.arrayListOf(new Integer[]{9, 5, 12, 16, 8});
        this.b = new LinkedHashMap();
        this.g = 1;
        this.o = "";
        this.r = MapsKt.mapOf(new Pair[]{TuplesKt.to("bind", BehaviorSubject.createDefault(0L)), TuplesKt.to("start", BehaviorSubject.createDefault(0L)), TuplesKt.to("first_sei_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("feed_view_selected", BehaviorSubject.createDefault(0L)), TuplesKt.to("feed_view_loaded", BehaviorSubject.createDefault(0L)), TuplesKt.to("player_first_frame", BehaviorSubject.createDefault(0L)), TuplesKt.to("background_Load", BehaviorSubject.createDefault(0L)), TuplesKt.to("empty_seat_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("guest_seat_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("list_v2_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("hybriyd_main_did_mount", BehaviorSubject.createDefault(0L)), TuplesKt.to("hybriyd_render_did_mount", BehaviorSubject.createDefault(0L)), TuplesKt.to("lynx_empty_seat_list", BehaviorSubject.createDefault(0L)), TuplesKt.to("lynx_guest_seat_list", BehaviorSubject.createDefault(0L)), TuplesKt.to("lynx_receive_linkmic_info", BehaviorSubject.createDefault(0L)), TuplesKt.to("bytelink_data_receive", BehaviorSubject.createDefault(0L)), TuplesKt.to("midi_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("mv_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("lyric_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("container_load", BehaviorSubject.createDefault(0L))});
        this.s = CollectionsKt.listOf(new BehaviorSubject[]{b("start"), b("first_sei_load"), b("feed_view_selected"), b("feed_view_loaded"), b("player_first_frame"), b("background_Load"), b("list_v2_time"), b("lynx_guest_seat_list")});
        List<BehaviorSubject<Long>> r2 = CollectionsKt.listOf(new BehaviorSubject[]{b("start"), b("first_sei_load"), b("feed_view_loaded"), b("player_first_frame"), b("background_Load"), b("list_v2_time"), b("guest_seat_load")});
        this.t = r2;
        HashMap<String, StatisticsItem> r3 = new HashMap();
        r3.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("link_mic", new StatisticsItem("link_mic", r2, new CompositeDisposable())), TuplesKt.to("ktv", new StatisticsItem("ktv", CollectionsKt.listOf(new BehaviorSubject[]{b("start"), b("guest_seat_load"), b("midi_load"), b("mv_load"), b("lyric_load"), b("container_load")}), new CompositeDisposable())), TuplesKt.to("chorus", new StatisticsItem("chorus", CollectionsKt.listOf(new BehaviorSubject[]{b("start"), b("empty_seat_load"), b("guest_seat_load"), b("background_Load"), b("midi_load"), b("lyric_load"), b("container_load")}), new CompositeDisposable()))}));
        Unit r1 = Unit.INSTANCE;
        this.u = r3;
    }

    public final long a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "subElement");
        BehaviorSubject<Long> r4 = this.r.get(r3);
        if (r4 == null) goto L7;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L7;
        return r5.longValue();
    L7:
        return 0;
    }

    public final BehaviorSubject<Long> b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "subElement");
        BehaviorSubject<Long> r4 = this.r.get(r3);
        if (r4 != null) goto L6;
        r4 = BehaviorSubject.createDefault(0L);
    L6:
        return r4;
    }

    public final long checkDurationValid(long r1) {
        return IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, r1);
    }

    public final void handleDynamicViewLoadDuration(Object r6) {
        Intrinsics.checkNotNullParameter(r6, "durationInfo");
        if ((r6 instanceof tf0.f) == true) goto L5;
        r6 = null;
    L5:
        tf0.f r7 = (tf0.f) r6;
        if (r7 != null) goto L9;
        return;
    L9:
        if (d5.c(r7.c()) <= System.currentTimeMillis()) goto L11;
        long r0 = System.currentTimeMillis();
    L12:
        String r8 = r7.a();
        if (Intrinsics.areEqual(r8, LoadDurationItemId.CHORUS_EMPTY_SEAT_LIST.getValue()) == false) goto L16;
        recordSubElementShow("empty_seat_load", r0);
        return;
    L16:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.CHORUS_GUEST_SEAT_LIST.getValue()) == false) goto L19;
        recordSubElementShow("guest_seat_load", r0);
        return;
    L19:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.TEAM_FIGHT_SCORE_BAR.getValue()) == false) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.HYBRIYD_MAIN_DID_MOUNT.getValue()) == false) goto L25;
        recordSubElementShow("hybriyd_main_did_mount", r0);
        return;
    L25:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.HYBRIYD_RENDER_DID_MOUNT.getValue()) == false) goto L28;
        recordSubElementShow("hybriyd_render_did_mount", r0);
        return;
    L28:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.RENDER_LYNX_EMPTY_SEAT_LIST.getValue()) == false) goto L31;
        recordSubElementShow("lynx_empty_seat_list", r0);
        return;
    L31:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.RENDER_LYNX_GUEST_SEAT_LIST.getValue()) == false) goto L34;
        recordSubElementShow("lynx_guest_seat_list", r0);
        return;
    L34:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.JSB_RECEIVE_USER_LIST.getValue()) == false) goto L37;
        recordSubElementShow("jsb_receive_guest_list", r0);
        return;
    L37:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.RENDER_LYNX_SETUP_DRAW_END.getValue()) == false) goto L40;
        ALogger.e("livesdk_audience_preview_loading_statistics", "setup_draw_end_duration: " + r0);
        return;
    L40:
        if (Intrinsics.areEqual(r8, LoadDurationItemId.RENDER_LYNX_UPDATE_DRAW_END.getValue()) == false) goto L51;
        ALogger.e("livesdk_audience_preview_loading_statistics", "update_draw_end_duration: " + r0);
        return;
    L51:
        return;
    L11:
        r0 = d5.c(r7.c());
        goto L12
    }

    public final void startObserveBaseElementLoadEnd(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        StatisticsItem r0 = this.u.get(r3);
        if (r0 == null) goto L9;
        List<BehaviorSubject<Long>> r1 = r0.getConcernList();
        if (r1 == null) goto L10;
        startObserveUIElementLoadEnd(r3, r1, C03091.INSTANCE);
        return;
    L10:
        return;
    }

    public final void startObserveKtvElementLoadEnd(String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (c() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4, "chorus") == false) goto L8;
        recordSubElementShow("list_v2_time", -1);
        recordSubElementShow("midi_load", -1);
    L8:
        StatisticsItem r0 = this.u.get(r4);
        if (r0 == null) goto L15;
        List<BehaviorSubject<Long>> r1 = r0.getConcernList();
        if (r1 == null) goto L16;
        startObserveUIElementLoadEnd(r4, r1, new C03101(this));
        return;
    L16:
        return;
    }

    public static void e(IRoom r3, Map r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isLiveTypeAudio() == false) goto L6;
        String r0 = "voice_live";
    L7:
        r4.put("live_type", r0);
        z5 r1 = r3.getLinkerDetail();
        String r2 = "";
        if (r1 == null) goto L11;
        String r5 = r1.getFunctionType2();
        if (r5 == null) goto L11;
    L12:
        r4.put("function_type", r5);
        z5 r6 = r3.getLinkerDetail();
        if (r6 == null) goto L18;
        String r7 = r6.getFunctionType2();
        if (r7 == null) goto L18;
        r2 = r7;
    L18:
        r4.put("function_type2", r2);
        return;
    L11:
        r5 = "";
        goto L12
    L6:
        r0 = "video_live";
        goto L7
    }

    public final void recordSubElementShow(String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "subElement");
        if (c() == true) goto L6;
        return;
    L6:
        if (a(r6) == 0) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r6, "first_sei_load") == false) goto L11;
    L22:
        StringBuilder r0 = new StringBuilder("roomId=");
        IRoom r2 = this.c;
        if (r2 == null) goto L25;
        Long r3 = Long.valueOf(r2.getId());
    L26:
        r0.append(r3);
        r0.append(", recordSubElementShow subElement=");
        r0.append(r6);
        r0.append(", time=");
        r0.append(r7);
        ALogger.i("livesdk_audience_preview_loading_statistics", r0.toString());
    L27:
        BehaviorSubject<Long> r1 = this.r.get(r6);
        if (r1 == null) goto L30;
        r1.onNext(Long.valueOf(r7));
    L30:
        a(r6);
        a("start");
        ALogger.d("livesdk_audience_preview_loading_statistics", "recordSubElementShow: subElement = " + r6 + " , use " + (a(r6) - a("start")) + "ms");
        return;
    L25:
        r3 = null;
        goto L26
    L11:
        if (Intrinsics.areEqual(r6, "feed_view_selected") == true) goto L22;
        if (Intrinsics.areEqual(r6, "feed_view_loaded") == true) goto L22;
        if (Intrinsics.areEqual(r6, "player_first_frame") == true) goto L22;
        if (Intrinsics.areEqual(r6, "background_Load") == true) goto L22;
        if (Intrinsics.areEqual(r6, "lynx_guest_seat_list") == true) goto L22;
        if (Intrinsics.areEqual(r6, "jsb_receive_guest_list") == false) goto L27;
        goto L22
    }

    public final void startObserveUIElementLoadEnd(String r10, List<BehaviorSubject<Long>> r11, Function0<? extends Map<String, String>> r12) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "subElementList");
        Intrinsics.checkNotNullParameter(r12, "getExtraParamsAction");
        StatisticsItem r0 = this.u.get(r10);
        if (r0 == null) goto L10;
        CompositeDisposable r1 = r0.getDiposable();
        if (r1 == null) goto L11;
        r1.clear();
        Disposable r13 = Observable.combineLatest(r11, new b(r1, this, r11, r10, r12)).subscribe(c.a, d.a);
        if (r13 == null) goto L12;
        RxUtilKt.c(r13, r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void updateIsPreload(boolean r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r6, "loadFrom");
        StringBuilder r0 = new StringBuilder("roomId=");
        IRoom r1 = this.c;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getId());
    L6:
        r0.append(r2);
        r0.append(", updateIsPreload old=");
        r0.append(this.n);
        r0.append(", new=");
        r0.append(r4);
        r0.append(", from=");
        r0.append(r5);
        ALogger.i("livesdk_audience_preview_loading_statistics", r0.toString());
        this.n = r4;
        if (Intrinsics.areEqual(r5, "init") == false) goto L9;
        this.o = r6;
    L9:
        recordSubElementShow("bytelink_data_receive", System.currentTimeMillis());
        if (r4 == false) goto L13;
        this.p = System.currentTimeMillis();
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void updateTalkRoomCommonParams(int r3, int r4, int r5) {
        this.g = r3;
        this.h = r4;
        this.i = r5;
        boolean r6 = vm2.d.d0().c();
        StringBuilder r7 = new StringBuilder("roomId=");
        IRoom r8 = this.c;
        if (r8 == null) goto L5;
        Long r9 = Long.valueOf(r8.getId());
    L6:
        r7.append(r9);
        r7.append(", updateTypeStatisticsConfig, curIsLynxSeatView = ");
        r7.append(r6);
        r7.append(", oldIsLynxSeatView=");
        r7.append(this.j);
        ALogger.i("livesdk_audience_preview_loading_statistics", r7.toString());
        if (Intrinsics.areEqual(this.j, Boolean.valueOf(r6)) == true) goto L22;
        this.j = Boolean.valueOf(r6);
        if (r6 == false) goto L20;
        StatisticsItem r10 = this.u.get("link_mic");
        if (r10 == null) goto L16;
        CompositeDisposable r11 = r10.getDiposable();
        if (r11 == null) goto L16;
        r11.clear();
    L16:
        this.u.put("link_mic", new StatisticsItem("link_mic", this.s, new CompositeDisposable()));
        if (this.k == false) goto L21;
        startObserveBaseElementLoadEnd("link_mic");
        this.k = false;
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    L5:
        r9 = null;
        goto L6
    }

    public final void uploadUILoadEnd(String r50, Function0<? extends Map<String, String>> r51, Function0<Long> r52) {
        Intrinsics.checkNotNullParameter(r50, "type");
        Intrinsics.checkNotNullParameter(r51, "getExtraParamsAction");
        Intrinsics.checkNotNullParameter(r52, "getMaxTimeAction");
        if (d() == true) goto L5;
        return;
    L5:
        LinkedHashMap r2 = new LinkedHashMap();
        e(this.c, r2);
        IRoom r5 = this.c;
        if (r5 == null) goto L17;
        r2.put("room_id", String.valueOf(r5.getId()));
        IBaseUser r6 = r5.getOwner();
        if (r6 == null) goto L10;
        String r7 = r6.getIdString();
    L11:
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r2.put("anchor_id", r7);
        String r8 = jc1.k.n(IMiddlewareUserService.class).user().n();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r2.put("current_user_id", r8);
        goto L17
    L10:
        r7 = null;
    L17:
        r2.put("sei_version", String.valueOf(this.g));
        r2.put("scene", String.valueOf(this.h));
        r2.put("ui_layout", String.valueOf(this.i));
        long r9 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("feed_view_loaded") - a("start"));
        if ((a("first_sei_load") - a("feed_view_selected")) <= 0) goto L20;
        long r12 = a("first_sei_load") - a("feed_view_selected");
    L21:
        long r13 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, r12);
        if ((a("player_first_frame") - a("feed_view_selected")) <= 0) goto L24;
        long r3 = a("player_first_frame") - a("feed_view_selected");
    L25:
        long r4 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, r3);
        long r10 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("background_Load") - a("start"));
        long r1 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("empty_seat_load") - a("start"));
        long r14 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("list_v2_time") - a("start"));
        long r15 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("guest_seat_load") - a("start"));
        if (a("bind") == 0) goto L28;
        long r16 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("start") - a("bind"));
    L29:
        long r35 = r16;
        String r17 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("hybriyd_main_did_mount") - a("start")));
        String r18 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("hybriyd_render_did_mount") - a("start")));
        String r19 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("lynx_empty_seat_list") - a("start")));
        String r11 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("lynx_guest_seat_list") - a("start")));
        Iterator r20 = CollectionsKt.arrayListOf(new Long[]{Long.valueOf(r9), Long.valueOf(r13), Long.valueOf(r4), Long.valueOf(r10), Long.valueOf(r1), Long.valueOf(r14), Long.valueOf(r15)}).iterator();
        if (r20.hasNext() == false) goto L123;
        long r43 = ((Number) r20.next()).longValue();
    L33:
        if (r20.hasNext() == false) goto L38;
        long r45 = ((Number) r20.next()).longValue();
        if (r43 >= r45) goto L33;
        r43 = r45;
        goto L33
    L38:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L40;
    L42:
        boolean r21 = false;
    L43:
        if (r21 == true) goto L45;
        long r44 = r13;
        String r22 = "background_Load";
        String r110 = "start";
        String r23 = r19;
        if (this.n == true) goto L53;
    L55:
        boolean r111 = false;
    L56:
        String r112 = "1";
        if (r111 == true) goto L60;
        r112 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, ((Number) r52.invoke()).longValue() - a(r110)));
    L60:
        f2.g();
        r2.put("duration", r112);
        r2.put("bind_duration", String.valueOf(r35));
        r2.put("first_sei_load_duration", String.valueOf(r44));
        r2.put("feed_view_load_duration", String.valueOf(r9));
        r2.put("player_first_frame_duration", String.valueOf(r4));
        r2.put("render_background_duration", String.valueOf(r10));
        r2.put("render_cliped_background_duration", String.valueOf(r10));
        r2.put("empty_seat_load_duration", String.valueOf(r1));
        r2.put("first_user_list_duration", String.valueOf(r14));
        r2.put("guest_seat_load_duration", String.valueOf(r15));
        r2.put("hybriyd_main_did_mount", r17);
        r2.put("hybriyd_render_did_mount", r18);
        r2.put("lynx_empty_seat_list", r23);
        r2.put("lynx_guest_seat_list", r11);
        if (this.n == false) goto L63;
        Object r24 = "1";
    L64:
        r2.put("is_preload", r24);
        if (r111 == false) goto L67;
        Object r25 = "1";
    L68:
        r2.put("is_preload_finish", r25);
        if (this.n == false) goto L79;
        String r26 = r110;
        String r27 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a(r26) - this.p));
        if ((a("first_sei_load") - this.p) <= 0) goto L73;
        long r28 = a("first_sei_load") - this.p;
    L74:
        long r29 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, r28);
        if ((a("player_first_frame") - this.p) <= 0) goto L77;
        long r30 = a("player_first_frame") - this.p;
    L78:
        long r31 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, r30);
        long r32 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a(r22) - this.p);
        Object r210 = "0";
        Object r211 = "is_preload";
        long r113 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("empty_seat_load") - this.p);
        long r114 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("list_v2_time") - this.p);
        long r115 = IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("guest_seat_load") - this.p);
        String r33 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("hybriyd_main_did_mount") - this.p));
        String r34 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("hybriyd_render_did_mount") - this.p));
        String r36 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("lynx_empty_seat_list") - this.p));
        String r116 = String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("lynx_guest_seat_list") - this.p));
        String r117 = String.valueOf(Math.max(r32, CastLongProtector.parseLong(r116)));
        r2.put("real_enter_room_duration", r27);
        r2.put("bytelink_data_receive_duration", String.valueOf(IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, a("bytelink_data_receive") - a(r26))));
        r2.put("real_duration", r117);
        r2.put("real_first_sei_load_duration", String.valueOf(r29));
        r2.put("real_player_first_frame_duration", String.valueOf(r31));
        r2.put("real_render_background_duration", String.valueOf(r32));
        r2.put("real_empty_seat_load_duration", String.valueOf(r113));
        r2.put("real_first_user_list_duration", String.valueOf(r114));
        r2.put("real_guest_seat_load_duration", String.valueOf(r115));
        r2.put("real_hybrid_main_did_mount_duration", r33);
        r2.put("real_hybrid_render_did_mount_duration", r34);
        r2.put("real_render_lynx_empty_seat_list_duration", r36);
        r2.put("real_render_lynx_guest_seat_list_duration", r116);
    L80:
        r2.putAll((Map) r51.invoke());
        r2.put("multi_link_mode_type", r50);
        String r37 = this.d;
        if (r37 != null) goto L83;
        r37 = "";
    L83:
        r2.put("enter_from_merge", r37);
        String r38 = this.e;
        if (r38 != null) goto L86;
        String r39 = "";
    L87:
        r2.put("enter_method", r39);
        r2.put("feed_type", String.valueOf(this.f));
        if (Intrinsics.areEqual(this.j, Boolean.TRUE) == false) goto L90;
        Object r40 = "1";
    L91:
        r2.put("is_lynx", r40);
        r2.put("ui_layout", String.valueOf(this.i));
        if (this.l == false) goto L94;
        Object r41 = "1";
    L95:
        r2.put("root_widget_reuse", r41);
        if (this.m == false) goto L98;
        Object r118 = "1";
    L99:
        r2.put("render_widget_reuse", r118);
        if (this.f != 5) goto L102;
        r2.put("enter_from_merge", "search");
    L102:
        r2.put("step", "talk_room_feed_view_ui_first_frame");
        r2.put("load_from", this.o);
        if (((Number) vm2.h.E5.getValue(null, vm2.h.a[341(0x155, float:4.78E-43)])).longValue() <= 0) goto L105;
        r2.toString();
        f2.g();
    L105:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_preview_loading_duration", r2, new Object[]{IRoom.class});
        if (Intrinsics.areEqual(r50, "link_mic") == false) goto L108;
        this.q = true;
    L108:
        StringBuilder r42 = new StringBuilder("roomId=");
        IRoom r46 = this.c;
        if (r46 == null) goto L111;
        Long r47 = Long.valueOf(r46.getId());
    L112:
        r42.append(r47);
        r42.append(", upload livesdk_audience_preview_loading_duration, isPreload=");
        r42.append((String) r2.get(r211));
        r42.append(", isPreloadFinish=");
        r42.append((String) r2.get("is_preload_finish"));
        r42.append(", loadFrom=");
        r42.append(this.o);
        ALogger.i("livesdk_audience_preview_loading_statistics", r42.toString());
        JSONObject r48 = new JSONObject();
        Iterator r49 = r2.entrySet().iterator();
    L114:
        if (r49.hasNext() == false) goto L116;
        Map.Entry r53 = (Map.Entry) r49.next();
        x.a(r48, (String) r53.getKey(), r53.getValue());
        goto L114
    L116:
        int r54 = this.h;
        LinkPreviewMonitorData r55 = new LinkPreviewMonitorData();
        r55.setServiceName("ttlive_chat_room_business_logic_sampling");
        r55.setEventType("business_api_name");
        r55.setEventTypeValue("talk_room_feed_view_ui_first_frame");
        r55.setScene(r54);
        IRoom r56 = this.c;
        if (r56 == null) goto L119;
        boolean r57 = r56.isLiveTypeAudio();
    L120:
        r55.setLiveTypeAudio(r57);
        r55.setExtra(r48);
        ALogger.d("livesdk_audience_preview_loading_statistics", "extra=" + r48);
        ((IInteractService) jc1.k.n(IInteractService.class)).monitor(r55);
        return;
    L119:
        r57 = false;
        goto L120
    L111:
        r47 = null;
        goto L112
    L98:
        r118 = r210;
        goto L99
    L94:
        r41 = r210;
        goto L95
    L90:
        r40 = r210;
        goto L91
    L86:
        r39 = r38;
        goto L87
    L77:
        r30 = 0;
        goto L78
    L73:
        r28 = 0;
        goto L74
    L79:
        r210 = "0";
        r211 = "is_preload";
        goto L80
    L67:
        r25 = "0";
        goto L68
    L63:
        r24 = "0";
        goto L64
    L53:
        if (IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, ((Number) r52.invoke()).longValue() - a(r110)) > 0) goto L55;
    L54:
        r111 = true;
        goto L56
    L45:
        if (this.n == false) goto L49;
        r44 = r13;
        r22 = "background_Load";
        r23 = r19;
        r110 = "start";
        if (IMultiScenePreviewStatistics.DefaultImpls.checkDurationValid(this, Math.max(a(r22), a("lynx_guest_seat_list")) - a(r110)) > 0) goto L55;
    L49:
        r44 = r13;
        r22 = "background_Load";
        r110 = "start";
        r23 = r19;
        goto L55
    L40:
        if (vm2.h.W().preloadFinishUploadOpt() == false) goto L42;
        r21 = true;
        goto L43
    L123:
        throw new NoSuchElementException();
    L28:
        r16 = -1;
        goto L29
    L24:
        r3 = 0;
        goto L25
    L20:
        r12 = 0;
        goto L21
    }

    public final void init(IRoom r1, String r2, String r3, int r4, long r5) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        BehaviorSubject<Long> r6 = this.r.get("bind");
        if (r6 == null) goto L6;
        r6.onNext(Long.valueOf(r5));
        return;
    }

    public final void recordAudiencePreviewStayDuration(String r6, IRoom r7, boolean r8, int r9, int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r6, "viewName");
        if (c() == true) goto L6;
        return;
    L6:
        if (this.b.containsKey(r6) == false) goto L8;
        return;
    L8:
        this.b.put(r6, Long.valueOf(System.currentTimeMillis()));
        ALogger.d("livesdk_audience_preview_loading_statistics", "recordAudiencePreviewStayDuration: " + r6 + " ;; cost == " + (System.currentTimeMillis() - this.v));
        LinkedHashMap r13 = new LinkedHashMap();
        e(r7, r13);
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        r13.put("enter_from_merge", r11);
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        r13.put("enter_method", r12);
        r13.put("duration", String.valueOf(System.currentTimeMillis() - this.v));
        if (r8 == false) goto L17;
        String r14 = "click";
    L18:
        r13.put("leave_way", r14);
        if (r9 == 3) goto L21;
    L23:
        String r15 = "0";
    L24:
        r13.put("is_mv", r15);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_preview_stay_duration", r13, new Object[]{IRoom.class});
        return;
    L21:
        if (r10 != 9) goto L23;
        r15 = "1";
        goto L24
    L17:
        r14 = "slide";
        goto L18
    }
}
