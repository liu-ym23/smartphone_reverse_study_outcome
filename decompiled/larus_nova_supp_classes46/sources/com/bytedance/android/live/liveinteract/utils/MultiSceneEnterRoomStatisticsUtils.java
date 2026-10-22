package com.bytedance.android.live.liveinteract.utils;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemType;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.PlayModeStatisticsItem;
import com.bytedance.android.livesdkapi.util.StatisticsItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiSceneEnterRoomStatisticsUtils implements IMultiSceneCommonStatistics {
    public static final /* synthetic */ int u = 0;
    public int a;
    public boolean b;
    public long c;
    public final BehaviorSubject<Long> d;
    public final BehaviorSubject<Long> e;
    public final BehaviorSubject<Long> f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public final Map<String, Long> k;
    public DataCenter l;
    public boolean m;
    public boolean n;
    public final List<LinkedHashMap<String, Pair<String, String>>> o;
    public final Map<String, BehaviorSubject<Long>> p;
    public final List<BehaviorSubject<Long>> q;
    public final List<BehaviorSubject<Long>> r;
    public final HashMap<String, StatisticsItem> s;
    public Disposable t;

    public static final class a {
        public static MultiSceneEnterRoomStatisticsUtils a(DataCenter r1, Long r2) {
            com.bytedance.android.livesdk.chatroom.u r3 = com.bytedance.android.live.liveinteract.api.utils.m.f(r1, r2);
            Object r4 = null;
            if (r3 == null) goto L7;
            com.bytedance.live.datacontext.n r5 = r3.x();
            if (r5 == null) goto L7;
            Object r6 = r5.getValue();
        L9:
            if ((r6 instanceof MultiSceneEnterRoomStatisticsUtils) == false) goto L13;
            r4 = r6;
        L13:
            return (MultiSceneEnterRoomStatisticsUtils) r4;
        L7:
            r6 = null;
            goto L9
        }
    }

    public static final class b<T1, T2, T3, T4, T5, R> implements Function5 {
        public final /* synthetic */ MultiSceneEnterRoomStatisticsUtils a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        public b(MultiSceneEnterRoomStatisticsUtils r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r20, Object r21, Object r22, Object r23, Object r24) {
            Long r1 = (Long) r20;
            Long r2 = (Long) r21;
            Long r3 = (Long) r22;
            Long r4 = (Long) r23;
            Long r5 = (Long) r24;
            Intrinsics.checkNotNullParameter(r1, "startRoomTs");
            Intrinsics.checkNotNullParameter(r2, "micSeatLoadTs");
            Intrinsics.checkNotNullParameter(r3, "bgLoadTs");
            Intrinsics.checkNotNullParameter(r4, "playModeLoadStart");
            Intrinsics.checkNotNullParameter(r5, "playModeLoadEnd");
            List r7 = CollectionsKt.listOf(new Long[]{r1, r2, r3, r4, r5});
            Long r16 = 0L;
            if ((r7 instanceof Collection) == true) goto L5;
        L7:
            Iterator r8 = r7.iterator();
        L9:
            if (r8.hasNext() == false) goto L19;
            Long r13 = (Long) r8.next();
            if (r13 != null) goto L14;
        L15:
            boolean r14 = true;
        L17:
            if (r14 == false) goto L9;
            boolean r9 = false;
        L20:
            if (r9 == true) goto L90;
            this.a.e("lynx_container_load_start");
            this.a.e("lynx_container_load");
            List r6 = CollectionsKt.listOf(new Long[]{r1, r2, r3, r4, r5});
            if ((r6 instanceof Collection) == true) goto L25;
        L27:
            Iterator r10 = r6.iterator();
        L29:
            if (r10.hasNext() == false) goto L39;
            Long r11 = (Long) r10.next();
            if (r11 != null) goto L34;
        L36:
            boolean r12 = false;
        L37:
            if (r12 == false) goto L29;
            boolean r15 = false;
        L40:
            if (r15 == false) goto L90;
            MultiSceneEnterRoomStatisticsUtils r17 = this.a;
            int r18 = this.b;
            boolean r19 = this.c;
            if (r17.g() == false) goto L86;
            LinkedHashMap r25 = new LinkedHashMap();
            IInteractService r26 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r26 != null) goto L47;
        L50:
            String r27 = "";
        L51:
            r25.put("play_mode", r27);
            if (r17.a != 1) goto L54;
            String r28 = "click";
        L55:
            r25.put("action_type", r28);
            String r29 = "0";
            if (r19 == false) goto L58;
            String r30 = "1";
        L59:
            r25.put("is_prefetch", r30);
            if (((Boolean) com.bytedance.android.livesdk.chatroom.interact.model.d0.a(r18).getFirst()).booleanValue() == false) goto L62;
            r29 = "1";
        L62:
            r25.put("is_prefetch_ab", r29);
            r25.put("duration", String.valueOf(System.currentTimeMillis() - r17.e("start")));
            r25.put("widget_duration", String.valueOf(r17.e("widget_load") - r17.e("start")));
            r25.put("seat_duration", String.valueOf(r17.e("guest_seat_load") - r17.e("start")));
            r25.put("background_duration", String.valueOf(r17.e("background_Load") - r17.e("start")));
            r25.put("playmode_create_dynamic_widget_start_duration", String.valueOf(r17.e("lynx_container_load_start") - r17.e("start")));
            r25.put("playmode_create_dynamic_widget_end_duration", String.valueOf(r17.e("lynx_container_load") - r17.e("start")));
            r25.put("send_start_event", String.valueOf(r17.e("send_start_event") - r17.e("start")));
            Long r31 = (Long) r17.e.getValue();
            if (r31 != null) goto L65;
            r31 = r16;
        L65:
            r25.put("playmode_start_load_duration", String.valueOf(r31.longValue() - r17.e("start")));
            Long r32 = (Long) r17.f.getValue();
            if (r32 != null) goto L68;
            r32 = r16;
        L68:
            r25.put("playmode_duration", String.valueOf(r32.longValue() - r17.e("start")));
            Long r33 = (Long) r17.d.getValue();
            if (r33 != null) goto L72;
        L73:
            Long r34 = (Long) r17.d.getValue();
            if (r34 == null) goto L77;
            r16 = r34;
        L77:
            r25.put("prefetch_request", String.valueOf(r16.longValue() - r17.e("start")));
        L78:
            r17.b(r25);
            MultiSceneEnterRoomStatisticsUtils.a(r25);
            if (r18 != 7) goto L81;
            r25.put("is_dynamic", "1");
        L85:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_loading_duration", r25, new Object[]{IRoom.class, am2.x.class});
            MultiSceneEnterRoomStatisticsUtils.m(r17, r25, LinkMonitorData.AudiencePlaymodeEnterRoomDuration);
            goto L86
        L81:
            if (r18 != 16) goto L85;
            r25.put("is_dynamic", "1");
            goto L85
        L72:
            if (r33.longValue() == 0) goto L78;
        L58:
            r30 = "0";
            goto L59
        L54:
            r28 = "draw";
            goto L55
        L47:
            if (r26.getTalkRoomLogUtils() == null) goto L50;
            r27 = com.bytedance.android.live.liveinteract.plantform.utils.u0.k(r18);
            if (r27 != null) goto L51;
        L86:
            Disposable r35 = this.a.t;
            if (r35 == null) goto L90;
            r35.dispose();
            goto L90
        L34:
            if (r11.longValue() != 0) goto L36;
            r12 = true;
        L39:
            r15 = true;
            goto L40
        L25:
            if (r6.isEmpty() == false) goto L27;
        L90:
            return Unit.INSTANCE;
        L14:
            if (r13.longValue() != 0) goto L15;
            r14 = false;
        L19:
            r9 = true;
            goto L20
        L5:
            if (r7.isEmpty() == false) goto L7;
            goto L7
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

    public static final class e<T, R> implements Function {
        public final /* synthetic */ CompositeDisposable a;
        public final /* synthetic */ MultiSceneEnterRoomStatisticsUtils b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function0 e;

        public e(CompositeDisposable r1, MultiSceneEnterRoomStatisticsUtils r2, List r3, String r4, Function0 r5) {
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
            if (r3 >= r1) goto L11;
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
        L11:
            r0.toString();
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
            this.b.uploadUILoadEnd(this.d, this.e, new MultiSceneEnterRoomStatisticsUtils$startObserveUIElementLoadEnd$$inlined$let$lambda$1$1(this, r0));
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

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiSceneEnterRoomStatisticsUtils() {
        this.d = BehaviorSubject.createDefault(0L);
        this.e = BehaviorSubject.createDefault(0L);
        this.f = BehaviorSubject.createDefault(0L);
        this.k = new LinkedHashMap();
        List<LinkedHashMap<String, Pair<String, String>>> r3 = CollectionsKt.listOf(new LinkedHashMap[]{MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("p0_widget", new Pair("P0 Widget加载", "p0_widget")), TuplesKt.to("ui_container_mount_duration", new Pair("聊天室Widget加载", "widget_load")), TuplesKt.to("window_manager_load", new Pair("WindowManager加载", "window_manager_load")), TuplesKt.to("data_listener", new Pair("用户数据监听注册", "data_listener")), TuplesKt.to("hybriyd_main_did_constructor", new Pair("主容器Ready", "hybriyd_main_did_constructor")), TuplesKt.to("hybriyd_render_did_constructor", new Pair("渲染容器Ready", "hybriyd_render_did_constructor")), TuplesKt.to("hybriyd_main_did_mount", new Pair("主容器Start", "hybriyd_main_did_mount")), TuplesKt.to("hybriyd_render_did_mount", new Pair("渲染容器Start", "hybriyd_render_did_mount"))}), MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("native_receive_ui_layout", new Pair("Native收到UILayout", "native_receive_ui_layout")), TuplesKt.to("native_send_ui_layout", new Pair("Native派发UILayout", "native_send_ui_layout")), TuplesKt.to("native_receive_layout_config", new Pair("Native布局信息计算完成", "native_receive_layout_config")), TuplesKt.to("first_user_list_duration", new Pair("Native收到嘉宾列表", "list_v2_time")), TuplesKt.to("data_center_receive_guest_list", new Pair("数据中心收到用户数据", "data_center_receive_guest_list"))}), MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("jsb_receive_linkmic_info", new Pair("Lynx收到LinkMicInfo", "jsb_receive_linkmic_info")), TuplesKt.to("lynx_receive_linkmic_info", new Pair("Lynx麦位收到LinkMicInfo", "lynx_receive_linkmic_info")), TuplesKt.to("native_ready_send_layout_info", new Pair("Native准备派发布局信息", "native_ready_send_layout_info")), TuplesKt.to("native_send_layout_info", new Pair("Native派发布局信息", "native_send_layout_info")), TuplesKt.to("jsb_receive_layout_info", new Pair("Lynx收到布局信息", "jsb_receive_layout_info")), TuplesKt.to("lynx_receive_layout_info", new Pair("Lynx麦位收到布局信息", "lynx_receive_layout_info")), TuplesKt.to("lynx_empty_seat_list", new Pair("Lynx空麦位首帧", "lynx_empty_seat_list")), TuplesKt.to("native_ready_send_guest_list", new Pair("Native准备派发嘉宾列表", "native_ready_send_guest_list")), TuplesKt.to("native_send_guest_list", new Pair("Native派发嘉宾列表", "native_send_guest_list")), TuplesKt.to("lynx_listener_user_list_data", new Pair("Lynx开始监听嘉宾列表", "lynx_listener_user_list_data")), TuplesKt.to("jsb_receive_guest_list", new Pair("Lynx收到嘉宾列表", "jsb_receive_guest_list")), TuplesKt.to("lynx_receive_guest_list", new Pair("Lynx麦位收到嘉宾列表", "lynx_receive_guest_list")), TuplesKt.to("lynx_guest_seat_list", new Pair("Lynx有人麦位首帧", "lynx_guest_seat_list"))}), MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("native_micseat_receive_layout_config", new Pair("Native麦位收到布局信息", "native_micseat_receive_layout_config")), TuplesKt.to("empty_seat_list_data", new Pair("Native收到空麦位列表", "empty_seat_list_data")), TuplesKt.to("empty_seat_render", new Pair("Native渲染空麦位", "empty_seat_render")), TuplesKt.to("native_micseat_receive_guest_list", new Pair("Native麦位收到嘉宾列表", "native_micseat_receive_guest_list")), TuplesKt.to("guest_seat_render", new Pair("Native渲染有人麦位", "guest_seat_render"))})});
        this.o = r3;
        Map<String, BehaviorSubject<Long>> r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("start", BehaviorSubject.createDefault(0L)), TuplesKt.to("widget_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("background_Load", BehaviorSubject.createDefault(0L)), TuplesKt.to("list_v2_time", BehaviorSubject.createDefault(0L)), TuplesKt.to("empty_seat_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("guest_seat_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("bytelink_data_receive", BehaviorSubject.createDefault(0L)), TuplesKt.to("preload_widget_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("midi_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("mv_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("lyric_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("container_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("lynx_container_load_start", BehaviorSubject.createDefault(0L)), TuplesKt.to("lynx_container_load", BehaviorSubject.createDefault(0L)), TuplesKt.to("send_start_event", BehaviorSubject.createDefault(0L)), TuplesKt.to("playmode_start", BehaviorSubject.createDefault(0L)), TuplesKt.to("playmode_end", BehaviorSubject.createDefault(0L))});
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Iterator r6 = ((LinkedHashMap) r4.next()).entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        Iterator r19 = r4;
        Object r7 = ((Map.Entry) r6.next()).getKey();
        if (r5.get(r7) != null) goto L12;
        r5.put(r7, BehaviorSubject.createDefault(0L));
    L12:
        r6 = r6;
        r4 = r19;
        goto L7
    L13:
        Unit r1 = Unit.INSTANCE;
        this.p = r5;
        this.q = CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("widget_load"), f("background_Load"), f("lynx_listener_user_list_data"), f("jsb_receive_guest_list"), f("lynx_receive_guest_list"), f("lynx_guest_seat_list"), f("list_v2_time")});
        List<BehaviorSubject<Long>> r2 = CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("widget_load"), f("guest_seat_load"), f("background_Load"), f("hybriyd_main_did_mount"), f("hybriyd_render_did_mount"), f("guest_seat_render")});
        this.r = r2;
        HashMap<String, StatisticsItem> r8 = new HashMap();
        r8.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("link_mic", new StatisticsItem("link_mic", r2, new CompositeDisposable())), TuplesKt.to("ktv", new StatisticsItem("ktv", CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("widget_load"), f("guest_seat_load"), f("midi_load"), f("mv_load"), f("lyric_load"), f("container_load")}), new CompositeDisposable())), TuplesKt.to("chorus", new StatisticsItem("chorus", CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("widget_load"), f("empty_seat_load"), f("guest_seat_load"), f("background_Load"), f("midi_load"), f("lyric_load"), f("container_load")}), new CompositeDisposable())), TuplesKt.to("grouppk", new PlayModeStatisticsItem(7, "grouppk", CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("guest_seat_load"), f("background_Load"), f("playmode_start"), f("playmode_end")}), new CompositeDisposable())), TuplesKt.to("room_grouppk", new PlayModeStatisticsItem(16, "room_grouppk", CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("guest_seat_load"), f("background_Load"), f("playmode_start"), f("playmode_end")}), new CompositeDisposable())), TuplesKt.to("guest_battle", new PlayModeStatisticsItem(5, "guest_battle", CollectionsKt.listOf(new BehaviorSubject[]{f("start"), f("guest_seat_load"), f("background_Load"), f("playmode_start"), f("playmode_end")}), new CompositeDisposable()))}));
        this.s = r8;
    }

    public final long c() {
        return e("start");
    }

    public final long d() {
        DataCenter r0 = this.l;
        if (r0 == null) goto L8;
        Long r1 = (Long) r0.get("data_preload_start_time", 0L);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.longValue();
    L8:
        return 0;
    }

    public final boolean g() {
        return ((Boolean) vm2.d.u.getValue(null, vm2.d.a[18])).booleanValue();
    }

    public final void clearUploadUIData() {
        if (g() == true) goto L5;
        return;
    L5:
        this.n = false;
        Iterator<T> r1 = this.s.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((StatisticsItem) r1.next()).getDiposable().clear();
        goto L7
    L9:
        Iterator<T> r2 = this.p.values().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((BehaviorSubject) r2.next()).onNext(0L);
        goto L11
    L13:
        ((LinkedHashMap) this.k).clear();
        Disposable r3 = this.t;
        if (r3 == null) goto L16;
        r3.dispose();
    L16:
        this.i = false;
        this.j = false;
        this.d.onNext(0L);
        this.e.onNext(0L);
        this.f.onNext(0L);
    }

    public final void h() {
        if (g() == true) goto L5;
        return;
    L5:
        Long r0 = (Long) this.d.getValue();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.longValue() == 0) goto L11;
        return;
    L11:
        this.d.onNext(Long.valueOf(System.currentTimeMillis()));
        Long r1 = (Long) this.d.getValue();
        if (r1 != null) goto L14;
        r1 = 0L;
    L14:
        r1.longValue();
        e("start");
    }

    public static void a(Map r5) {
        ReadOnlyProperty r0 = vm2.d.k;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[9])).booleanValue() == true) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().u2();
        if (r2 == null) goto L8;
        Map r3 = (Map) r2.getValue();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        Iterator r4 = ((List) vm2.d.p.getValue(null, r1[13])).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        String r6 = (String) r4.next();
        String r7 = (String) r3.get(r6);
        if (r7 == null) goto L13;
        r5.put(r6, r7);
        goto L13
    L17:
        return;
    L8:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Map<String, String> r8) {
        Iterator r0 = ((LinkedHashMap) this.k).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r8.put(r1.getKey(), String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, ((Number) r1.getValue()).longValue() - e("start"))));
        goto L4
    }

    public final long checkDurationValid(long r1) {
        return IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r1);
    }

    public final long e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "subElement");
        BehaviorSubject<Long> r4 = this.p.get(r3);
        if (r4 == null) goto L7;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L7;
        return r5.longValue();
    L7:
        return 0;
    }

    public final BehaviorSubject<Long> f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "subElement");
        BehaviorSubject<Long> r4 = this.p.get(r3);
        if (r4 != null) goto L6;
        r4 = BehaviorSubject.createDefault(0L);
    L6:
        return r4;
    }

    public final void handleDynamicViewLoadDuration(Object r7) {
        Intrinsics.checkNotNullParameter(r7, "durationInfo");
        if ((r7 instanceof tf0.f) == true) goto L5;
        Object r0 = null;
    L6:
        tf0.f r1 = (tf0.f) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        long r2 = System.currentTimeMillis();
        if (d5.c(r1.c()) > r2) goto L13;
        r2 = d5.c(r1.c());
    L13:
        Objects.toString(r7);
        if (r1.b() != LoadDurationItemType.LYNX_DYNAMIC_ITEM_TYPE.getValue()) goto L18;
        String r8 = r1.a();
        if (r8 == null) goto L18;
        this.k.put(r8, Long.valueOf(r2));
    L18:
        String r9 = r1.a();
        if (Intrinsics.areEqual(r9, LoadDurationItemId.CHORUS_EMPTY_SEAT_LIST.getValue()) == false) goto L22;
        recordSubElementShow("empty_seat_load", r2);
        return;
    L22:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.CHORUS_GUEST_SEAT_LIST.getValue()) == false) goto L25;
        recordSubElementShow("guest_seat_load", r2);
        return;
    L25:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.TEAM_FIGHT_START_LOAD.getValue()) == false) goto L27;
    L86:
        j(Long.valueOf(r2));
        return;
    L27:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.ROOM_BATTLE_START_LOAD.getValue()) == true) goto L86;
        if (Intrinsics.areEqual(r9, LoadDurationItemId.TEAM_FIGHT_SCORE_BAR.getValue()) == false) goto L32;
    L85:
        recordSubElementShow("playmode_end", r2);
        i(Long.valueOf(r2));
        return;
    L32:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.TEAM_FIGHT_FOREGROUND.getValue()) == true) goto L85;
        if (Intrinsics.areEqual(r9, LoadDurationItemId.HYBRIYD_MAIN_DID_CONSTRUCTOR.getValue()) == false) goto L38;
        recordSubElementShow("hybriyd_main_did_constructor", r2);
        return;
    L38:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.HYBRIYD_RENDER_DID_CONSTRUCTOR.getValue()) == false) goto L41;
        recordSubElementShow("hybriyd_render_did_constructor", r2);
        return;
    L41:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.HYBRIYD_MAIN_DID_MOUNT.getValue()) == false) goto L44;
        recordSubElementShow("hybriyd_main_did_mount", r2);
        return;
    L44:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.HYBRIYD_RENDER_DID_MOUNT.getValue()) == false) goto L47;
        recordSubElementShow("hybriyd_render_did_mount", r2);
        return;
    L47:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.JSB_RECEIVE_LINKMIC_INFO.getValue()) == false) goto L50;
        recordSubElementShow("jsb_receive_linkmic_info", r2);
        return;
    L50:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.JSB_RECEIVE_LAYOUT_INFO.getValue()) == false) goto L53;
        recordSubElementShow("jsb_receive_layout_info", r2);
        return;
    L53:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.JSB_RECEIVE_USER_LIST.getValue()) == false) goto L56;
        recordSubElementShow("jsb_receive_guest_list", r2);
        return;
    L56:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.LYNX_ERCEIVE_LINKMIC_INFO.getValue()) == false) goto L59;
        recordSubElementShow("lynx_receive_linkmic_info", r2);
        return;
    L59:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.LYNX_RECEIVE_LAYOUT_INFO.getValue()) == false) goto L62;
        recordSubElementShow("lynx_receive_layout_info", r2);
        return;
    L62:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.LYNX_RECEIVE_USER_LIST.getValue()) == false) goto L65;
        recordSubElementShow("lynx_receive_guest_list", r2);
        return;
    L65:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_EMPTY_SEAT_LIST.getValue()) == false) goto L68;
        recordSubElementShow("lynx_empty_seat_list", r2);
        return;
    L68:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_GUEST_SEAT_LIST.getValue()) == false) goto L74;
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L72;
        recordSubElementShow("guest_seat_load", r2);
    L72:
        recordSubElementShow("lynx_guest_seat_list", r2);
        return;
    L74:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_RECEIVE_FRAME_INFO.getValue()) == false) goto L77;
        recordSubElementShow("lynx_receive_frame_info", r2);
        return;
    L77:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_LISTENER_USER_LIST_DATA.getValue()) == false) goto L80;
        recordSubElementShow("lynx_listener_user_list_data", r2);
        return;
    L80:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_SETUP_DRAW_END.getValue()) == false) goto L83;
        ALogger.e("livesdk_audience_loading_statistics", "setup_draw_end_duration: " + r2);
        return;
    L83:
        if (Intrinsics.areEqual(r9, LoadDurationItemId.RENDER_LYNX_UPDATE_DRAW_END.getValue()) == false) goto L105;
        ALogger.e("livesdk_audience_loading_statistics", "update_draw_end_duration: " + r2);
        return;
    L105:
        return;
    L5:
        r0 = r7;
        goto L6
    }

    public final void i(Long r7) {
        if (g() == true) goto L5;
        return;
    L5:
        Long r0 = (Long) this.f.getValue();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.longValue() == 0) goto L11;
        return;
    L11:
        BehaviorSubject<Long> r1 = this.f;
        if (r7 == null) goto L14;
        long r4 = r7.longValue();
    L15:
        r1.onNext(Long.valueOf(r4));
        Long r8 = (Long) this.f.getValue();
        if (r8 != null) goto L18;
        r8 = 0L;
    L18:
        r8.longValue();
        e("start");
        return;
    L14:
        r4 = System.currentTimeMillis();
        goto L15
    }

    public final void j(Long r7) {
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(this, "playmode_start", 0, 2, null);
        if (g() == true) goto L5;
        return;
    L5:
        Long r0 = (Long) this.e.getValue();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.longValue() == 0) goto L11;
        return;
    L11:
        BehaviorSubject<Long> r1 = this.e;
        if (r7 == null) goto L14;
        long r4 = r7.longValue();
    L15:
        r1.onNext(Long.valueOf(r4));
        Long r8 = (Long) this.e.getValue();
        if (r8 != null) goto L18;
        r8 = 0L;
    L18:
        r8.longValue();
        e("start");
        return;
    L14:
        r4 = System.currentTimeMillis();
        goto L15
    }

    public final void n(int r5) {
        this.h = r5;
        this.g = vm2.d.d0().c();
        StatisticsItem r6 = this.s.get("link_mic");
        if (r6 == null) goto L7;
        CompositeDisposable r7 = r6.getDiposable();
        if (r7 == null) goto L7;
        r7.clear();
    L7:
        HashMap<String, StatisticsItem> r8 = this.s;
        if (this.g == false) goto L10;
        List<BehaviorSubject<Long>> r2 = this.q;
    L11:
        r8.put("link_mic", new StatisticsItem("link_mic", r2, new CompositeDisposable()));
        return;
    L10:
        r2 = this.r;
        goto L11
    }

    public final void startObserveBaseElementLoadEnd(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        StatisticsItem r0 = this.s.get(r3);
        if (r0 == null) goto L9;
        List<BehaviorSubject<Long>> r1 = r0.getConcernList();
        if (r1 == null) goto L10;
        startObserveUIElementLoadEnd(r3, r1, AnonymousClass1.INSTANCE);
        return;
    L10:
        return;
    }

    public final void startObserveKtvElementLoadEnd(String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (g() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4, "chorus") == false) goto L8;
        recordSubElementShow("midi_load", -1);
    L8:
        StatisticsItem r0 = this.s.get(r4);
        if (r0 == null) goto L15;
        List<BehaviorSubject<Long>> r1 = r0.getConcernList();
        if (r1 == null) goto L16;
        startObserveUIElementLoadEnd(r4, r1, new C03081(this));
        return;
    L16:
        return;
    }

    public final void startObservePlayModeElementLoadEnd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        g();
    }

    public final void k(int r8, boolean r9) {
        if (g() == true) goto L5;
        return;
    L5:
        Disposable r0 = this.t;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.t = Observable.combineLatest(f("start"), f("guest_seat_load"), f("background_Load"), this.e, this.f, new b(this, r8, r9)).subscribe(c.a, d.a);
    }

    public final void l(final int r5, final boolean r6) {
        if (g() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.s.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        Object r1 = r0.next();
        PlayModeStatisticsItem r2 = (StatisticsItem) r1;
        if ((r2 instanceof PlayModeStatisticsItem) == true) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L7;
    L17:
        StatisticsItem r4 = (StatisticsItem) r1;
        if (r4 == null) goto L34;
        String r7 = r4.getType();
        if (r7 == null) goto L36;
        StatisticsItem r8 = this.s.get(r7);
        if (r8 == null) goto L35;
        List<BehaviorSubject<Long>> r9 = r8.getConcernList();
        if (r9 == null) goto L37;
        startObserveUIElementLoadEnd(r7, r9, new MultiSceneEnterRoomStatisticsUtils$startObservePlayModeLoadEndNew$1(this, r5, r6));
        return;
    L37:
        return;
    L35:
        return;
    L36:
        return;
    L34:
        return;
    L11:
        if (r2.getPlaymode() != r5) goto L13;
        r3 = true;
        goto L14
    L16:
        r1 = null;
        goto L17
    }

    public final void recordSubElementShow(String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "subElement");
        if (g() == true) goto L6;
        return;
    L6:
        if (e(r6) == 0) goto L8;
        return;
    L8:
        BehaviorSubject<Long> r0 = this.p.get(r6);
        if (r0 == null) goto L12;
        r0.onNext(Long.valueOf(r7));
    L12:
        if (this.h == 24) goto L14;
        Intrinsics.areEqual(r6, "guest_seat_load");
    L14:
        String r8 = "recordSubElementShow: subElement = " + r6 + " , use " + (e(r6) - e("start")) + "ms";
        Lazy r9 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.l, "livesdk_audience_loading_statistics", r8);
    }

    public static void m(MultiSceneEnterRoomStatisticsUtils r7, Map r8, LinkMonitorData r9) {
        r7.getClass();
        if (((Boolean) vm2.d.A.getValue(null, vm2.d.a[24])).booleanValue() == false) goto L25;
        JSONObject r10 = new JSONObject();
        Iterator r11 = ((LinkedHashMap) r8).entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r11.next();
        x.a(r10, (String) r0.getKey(), r0.getValue());
        goto L7
    L9:
        com.bytedance.android.livesdk.log.filter.o r12 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r12 == null) goto L16;
        Map r1 = r12.getMap();
        if (r1 == null) goto L16;
        if (r1.containsKey("enter_from_merge") != true) goto L16;
        x.a(r10, "enter_from_merge", com.bytedance.android.livesdk.log.l0.a("enter_from_merge", r12));
    L16:
        if (r12 == null) goto L22;
        Map r2 = r12.getMap();
        if (r2 == null) goto L22;
        if (r2.containsKey("enter_method") != true) goto L22;
        x.a(r10, "enter_method", com.bytedance.android.livesdk.log.l0.a("enter_method", r12));
    L22:
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.EnterRoomStatistics, "enterRoom", 0, null, r10, 88);
        nd0.c.o(nd0.c.a, r9, r10, 0, null, false, 28);
        return;
    }

    public final void startObserveUIElementLoadEnd(String r10, List<BehaviorSubject<Long>> r11, Function0<? extends Map<String, String>> r12) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "subElementList");
        Intrinsics.checkNotNullParameter(r12, "getExtraParamsAction");
        StatisticsItem r0 = this.s.get(r10);
        if (r0 == null) goto L10;
        CompositeDisposable r1 = r0.getDiposable();
        if (r1 == null) goto L11;
        r1.clear();
        Disposable r13 = Observable.combineLatest(r11, new e(r1, this, r11, r10, r12)).subscribe(f.a, g.a);
        if (r13 == null) goto L12;
        RxUtilKt.c(r13, r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void uploadUILoadEnd(String r36, Function0<? extends Map<String, String>> r37, Function0<Long> r38) {
        Intrinsics.checkNotNullParameter(r36, "type");
        Intrinsics.checkNotNullParameter(r37, "getExtraParamsAction");
        Intrinsics.checkNotNullParameter(r38, "getMaxTimeAction");
        if (g() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r36, "link_mic") == true) goto L8;
    L21:
        LinkedHashMap r5 = new LinkedHashMap();
        if (this.a != 1) goto L24;
        String r7 = "click";
    L25:
        r5.put("action_type", r7);
        if (this.b == false) goto L28;
        Object r8 = "1";
    L29:
        r5.put("is_smooth_enter", r8);
        if (this.g == false) goto L32;
        Object r9 = "1";
    L33:
        r5.put("is_lynx", r9);
        r5.put("ui_layout", String.valueOf(this.h));
        if (this.i == false) goto L36;
        Object r10 = "1";
    L37:
        r5.put("root_widget_reuse", r10);
        if (this.j == false) goto L40;
        Object r11 = "1";
    L41:
        r5.put("render_widget_reuse", r11);
        r5.put("multi_link_mode_type", r36);
        if (this.m == false) goto L44;
        String r16 = "action_type";
        long r12 = Math.max(e("background_Load"), e("lynx_guest_seat_list"));
    L48:
        long r14 = ((Number) r38.invoke()).longValue();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L51;
    L53:
        boolean r4 = false;
    L55:
        if (r4 == true) goto L57;
        long r20 = r12;
        if (this.m == true) goto L65;
    L67:
        boolean r13 = false;
    L68:
        long r3 = IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r14 - e("start"));
        if (r13 == false) goto L71;
        String r15 = "1";
    L72:
        String r17 = "duration";
        r5.put("duration", r15);
        r5.put("guest_seat_load_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("guest_seat_load") - e("start"))));
        r5.put("empty_seat_load_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("empty_seat_load") - e("start"))));
        if (r13 == false) goto L75;
        String r18 = "1";
    L76:
        r5.put("experience_duration", r18);
        r5.put("render_background_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("background_Load") - e("start"))));
        r5.put("render_cliped_background_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("background_Load") - e("start"))));
        if (this.m == true) goto L79;
    L86:
        String r1 = String.valueOf(r3);
    L87:
        r5.put("interact_duration", r1);
        r5.put("ui_container_mount_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("widget_load") - e("start"))));
        r5.put("hybrid_main_did_mount_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("hybriyd_main_did_mount") - e("start"))));
        String r19 = "hybriyd_render_did_mount";
        r5.put("hybrid_render_did_mount_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("hybriyd_render_did_mount") - e("start"))));
        if (this.m == false) goto L90;
        Object r6 = "1";
    L91:
        r5.put("is_preload", r6);
        if (r13 == false) goto L94;
        Object r21 = "1";
    L95:
        r5.put("is_preload_finish", r21);
        if (this.m == false) goto L120;
        String r22 = String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("start") - d()));
        long r23 = IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("guest_seat_load") - d());
        long r24 = IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("background_Load") - d());
        long r25 = Math.max(r23, r24);
        d();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L100;
    L102:
        boolean r26 = false;
    L103:
        if (r26 == false) goto L112;
        long r27 = d();
        DataCenter r110 = this.l;
        if (r110 == null) goto L109;
        Object r28 = "ui_container_mount_duration";
        Object r29 = "empty_seat_load_duration";
        Long r111 = (Long) r110.get("data_preload_last_enter_time", 0L);
        if (r111 == null) goto L110;
        long r30 = r111.longValue();
    L111:
        r5.put("last_enter_to_preload_start_time", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r27 - r30)));
    L113:
        r5.put("real_enter_room_duration", r22);
        r5.put("real_duration", String.valueOf(r25));
        r5.put("preload_widget_load_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("preload_widget_load") - d())));
        r5.put("bytelink_data_receive_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("bytelink_data_receive") - d())));
        r5.put("real_guest_seat_load_duration", String.valueOf(r23));
        r5.put("real_empty_seat_load_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("empty_seat_load") - d())));
        r5.put("real_render_background_duration", String.valueOf(r24));
        r5.put("real_hybrid_main_did_mount_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e("hybriyd_main_did_mount") - d())));
        r5.put("real_hybrid_render_did_mount_duration", String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e(r19) - d())));
        Iterator<T> r2 = this.o.iterator();
    L115:
        if (r2.hasNext() == false) goto L121;
        Iterator r31 = ((LinkedHashMap) r2.next()).entrySet().iterator();
    L118:
        if (r31.hasNext() == false) goto L115;
        Map.Entry r32 = (Map.Entry) r31.next();
        r5.put("real_" + ((String) r32.getKey()), String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e((String) ((Pair) r32.getValue()).getSecond()) - d())));
    L121:
        Iterator<T> r33 = this.o.iterator();
    L123:
        if (r33.hasNext() == false) goto L128;
        Iterator r34 = ((LinkedHashMap) r33.next()).entrySet().iterator();
    L126:
        if (r34.hasNext() == false) goto L123;
        Map.Entry r35 = (Map.Entry) r34.next();
        r5.put(r35.getKey(), String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, e((String) ((Pair) r35.getValue()).getSecond()) - e("start"))));
        goto L126
    L128:
        String r39 = (String) r5.get(r10);
        String r40 = (String) r5.get("interact_duration");
        f2.g();
        if (vm2.h.S().d() == false) goto L131;
        StringBuilder r41 = new StringBuilder("interact_duration=");
        r41.append((String) r5.get("interact_duration"));
        r41.append(", widget_load_duration=");
        Object r42 = r28;
        r41.append((String) r5.get(r42));
        r41.append(", empty_seat_load_duration=");
        Object r43 = r29;
        r41.append((String) r5.get(r43));
        r41.append(", guest_seat_load_duration=");
        Object r44 = "guest_seat_load_duration";
        r41.append((String) r5.get(r44));
        r41.append(", background_load_duration=");
        Object r45 = "render_background_duration";
        r41.append((String) r5.get(r45));
        f2.c(r41.toString(), 0);
        String r46 = (String) r5.get("interact_duration");
        String r47 = (String) r5.get(r42);
        String r48 = (String) r5.get(r43);
        String r49 = (String) r5.get(r44);
        String r50 = (String) r5.get(r45);
    L132:
        b(r5);
        r5.putAll((Map) r37.invoke());
        a(r5);
        long r112 = ((Number) vm2.h.E5.getValue(null, vm2.h.a[341(0x155, float:4.78E-43)])).longValue();
        if (Intrinsics.areEqual(r36, "link_mic") == true) goto L135;
    L202:
        Object r210 = r45;
        String r113 = r17;
    L203:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_loading_duration", r5, new Object[]{IRoom.class, am2.x.class});
        if (Intrinsics.areEqual(r36, "link_mic") == false) goto L206;
        this.n = true;
    L206:
        m(this, r5, LinkMonitorData.AudienceEnterRoomDurationMonitorData);
        String r51 = (String) r5.get(r44);
        if (r51 == null) goto L209;
        int r52 = CastIntegerProtector.parseInt(r51);
    L210:
        String r53 = (String) r5.get(r210);
        if (r53 == null) goto L213;
        int r54 = CastIntegerProtector.parseInt(r53);
    L214:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        JSONObject r55 = new JSONObject();
        r55.put(r113, r52 - r54);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r56 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r56 == null) goto L227;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r57 = r56;
        String r58 = (String) r57.getMap().get("enter_from_merge");
        String r59 = "";
        if (r58 != null) goto L219;
        r58 = "";
    L219:
        r55.put("enter_from_merge", r58);
        String r60 = (String) r57.getMap().get("enter_method");
        if (r60 != null) goto L222;
        r60 = "";
    L222:
        r55.put("enter_method", r60);
        String r61 = r16;
        String r62 = (String) r57.getMap().get(r61);
        if (r62 == null) goto L226;
        r59 = r62;
    L226:
        r55.put(r61, r59);
    L227:
        nd0.c.o(nd0.c.a, LinkMonitorData.EnterRoomUIBgSeatGapTimeMonitorData, r55, 0, null, false, 28);
        return;
    L213:
        r54 = 0;
        goto L214
    L209:
        r52 = 0;
        goto L210
    L135:
        if (r112 <= 0) goto L202;
        r210 = r45;
        if (r112 != 1) goto L199;
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r115 = r5.entrySet().iterator();
    L140:
        if (r115.hasNext() == false) goto L185;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        String r118 = r17;
        if (Intrinsics.areEqual(r117, r118) == false) goto L144;
    L149:
        boolean r119 = true;
    L150:
        if (r119 == false) goto L152;
    L155:
        boolean r63 = true;
    L156:
        if (r63 == false) goto L158;
    L161:
        boolean r120 = true;
    L163:
        if (this.g == false) goto L168;
        if (r120 == false) goto L166;
    L173:
        boolean r65 = true;
    L174:
        if (r65 == false) goto L176;
    L181:
        boolean r66 = true;
    L182:
        if (r66 == false) goto L184;
        r114.put(r116.getKey(), r116.getValue());
    L184:
        r17 = r118;
        goto L140
    L176:
        if (Intrinsics.areEqual(r117, "interact_duration") == true) goto L181;
        if (Intrinsics.areEqual(r117, "experience_duration") == true) goto L181;
        r66 = false;
        goto L182
    L166:
        if (((LinkedHashMap) ListProtector.get(this.o, 2)).get(r117) != null) goto L173;
    L172:
        r65 = false;
        goto L174
    L168:
        if (r120 == true) goto L173;
        if (((LinkedHashMap) ListProtector.get(this.o, 3)).get(r117) == null) goto L172;
    L158:
        if (((LinkedHashMap) ListProtector.get(this.o, 1)).get(r117) != null) goto L161;
        r120 = false;
        goto L163
    L152:
        if (((LinkedHashMap) ListProtector.get(this.o, 0)).get(r117) != null) goto L155;
        r63 = false;
        goto L156
    L144:
        if (Intrinsics.areEqual(r117, r44) == true) goto L149;
        if (Intrinsics.areEqual(r117, r43) == true) goto L149;
        r119 = false;
        goto L150
    L185:
        r113 = r17;
        LinkedHashMap r67 = new LinkedHashMap();
        Iterator r68 = r114.entrySet().iterator();
    L187:
        if (r68.hasNext() == false) goto L198;
        Map.Entry r69 = (Map.Entry) r68.next();
        String r70 = (String) r69.getKey();
        Iterator<T> r71 = this.o.iterator();
    L190:
        if (r71.hasNext() == false) goto L194;
        Pair r121 = (Pair) ((LinkedHashMap) r71.next()).get(r70);
        if (r121 == null) goto L190;
        String r72 = (String) r121.getFirst();
    L195:
        if (r72 == null) goto L196;
        r67.put(r72, r69.getValue());
        goto L187
    L196:
        r67.put(r69.getKey(), r69.getValue());
        goto L187
    L194:
        r72 = null;
        goto L195
    L198:
        new Handler().postDelayed(new y0(r36, CollectionsKt.joinToString$default(r67.entrySet(), "\n", null, null, 0, null, MultiSceneEnterRoomStatisticsUtils$showDebugToast$formattedString$1.INSTANCE, 30, null)), 3000);
        goto L203
    L199:
        r113 = r17;
        if (r112 != 2) goto L203;
        new Handler().postDelayed(new z0(r36, r5), 3000);
        goto L203
    L131:
        r45 = "render_background_duration";
        r44 = "guest_seat_load_duration";
        r43 = r29;
    L110:
        r30 = 0;
        goto L111
    L109:
        r29 = "empty_seat_load_duration";
        r28 = "ui_container_mount_duration";
        goto L110
    L112:
        r29 = "empty_seat_load_duration";
        r19 = "hybriyd_render_did_mount";
        r28 = "ui_container_mount_duration";
        goto L113
    L100:
        if (vm2.h.W().logPreloadStart() == false) goto L102;
        r26 = true;
        goto L103
    L120:
        r29 = "empty_seat_load_duration";
        r28 = "ui_container_mount_duration";
        goto L121
    L94:
        r21 = "0";
        goto L95
    L90:
        r6 = "0";
        goto L91
    L79:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L81;
    L83:
        boolean r73 = false;
    L84:
        if (r73 == false) goto L86;
        r1 = String.valueOf(r5.get("experience_duration"));
        goto L87
    L81:
        if (vm2.h.W().preloadEnterRoomInteractDurationOpt() == false) goto L83;
        r73 = true;
        goto L84
    L75:
        r18 = String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r20 - e("start")));
        goto L76
    L71:
        r15 = String.valueOf(IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r20 - e("start")));
        goto L72
    L65:
        if (IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, r20 - e("start")) > 0) goto L67;
    L66:
        r13 = true;
        goto L68
    L57:
        if (this.m == false) goto L61;
        r20 = r12;
        if (IMultiSceneCommonStatistics.DefaultImpls.checkDurationValid(this, Math.max(e("background_Load"), e("lynx_guest_seat_list")) - e("start")) > 0) goto L67;
    L61:
        r20 = r12;
        goto L67
    L51:
        if (vm2.h.W().preloadFinishUploadOpt() == false) goto L53;
        r4 = true;
        goto L55
    L44:
        r16 = "action_type";
        if (this.b == false) goto L47;
        r12 = this.c;
        goto L48
    L47:
        r12 = ((Number) r38.invoke()).longValue();
        goto L48
    L40:
        r11 = "0";
        goto L41
    L36:
        r10 = "0";
        goto L37
    L32:
        r9 = "0";
        goto L33
    L28:
        r8 = "0";
        goto L29
    L24:
        r7 = "draw";
        goto L25
    L8:
        if (this.n == false) goto L21;
        StringBuilder r74 = new StringBuilder("uploadUiLoadEnd but already upload type=");
        r74.append(r36);
        r74.append(", dataCenter=");
        DataCenter r75 = this.l;
        if (r75 == null) goto L12;
        Integer r76 = Integer.valueOf(r75.hashCode());
    L13:
        r74.append(r76);
        r74.append(", roomId=");
        DataCenter r77 = this.l;
        if (r77 == null) goto L18;
        IRoom r78 = com.bytedance.android.live.core.utils.a0.o(r77);
        if (r78 == null) goto L18;
        Long r79 = Long.valueOf(r78.getRoomId());
    L19:
        r74.append(r79);
        ALogger.i("livesdk_audience_loading_statistics", r74.toString());
        return;
    L18:
        r79 = null;
        goto L19
    L12:
        r76 = null;
        goto L13
    }
}
