package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats;

import am2.x;
import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.bv0;
import com.bytedance.android.livesdk.config.cv0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import sh6.b;
import sh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0014J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001fR$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\f0+j\b\u0012\u0004\u0012\u00020\f`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030/j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0003`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R0\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030/j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0003`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/stats/ToolbarLoadTimeStatsVM;", "Landroidx/lifecycle/ViewModel;", "Lap1/a;", "", "time", "", "sendToolbarLoadTrackLog", "", "isAnchor", "sendComponentMonitor", "needSampling", "sendStatsMonitor", "", "getShowType", "getStatusString", "getStatus", "getResult", "status", "recordStatus", "tag", "recordTime", "printStatsTime", "onCleared", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "isEnterFinished", "", "id", "recordComponentStart", "recordComponentEnd", "roomInitTime", "J", "toolbarPreShowTime", "roomPartShowTime", "preEnterUsingTime", "roomEnterEndTime", "toolbarStartTime", "toolbarAddViewEndTime", "toolbarStartTrueLoadTime", "toolbarSyncEndTime", "toolbarAllEndTime", "toolbarMoreOnDraw", "p1LoadTime", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "statusList", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "componentLoadTimeMap", "Ljava/util/HashMap;", "componentLoadCostTimeMap", "<init>", "()V", "Companion", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarLoadTimeStatsVM extends ViewModel implements ap1.a {
    public static final a Companion = null;
    public static final String ROOM_ENTER_END = "room_enter_end";
    public static final String ROOM_INIT = "room_init";
    public static final String ROOM_P1_LOAD_START = "room_p1_load_start";
    public static final String START_PART_SHOW = "start_part_show";
    public static final String STATUS_CONTINUE_SHOW = "ContinueShow";
    public static final String STATUS_DIRECT_SHOW = "DirectShow";
    public static final String STATUS_IS_ENTER_ROOM_FINISH_WHEN_LOAD = "EnterFinishWhenLoad";
    public static final String STATUS_PART_SHOW = "PartShow";
    public static final String STATUS_PRE_ENTER_SPLIT = "PreEnterSplit";
    public static final String STATUS_PRE_SHOW_TOOLBAR = "PreShowToolbar";
    public static final String STATUS_ROOM_ENTER_PREPARED = "EnterRoomPrepared";
    public static final String TAG = "ToolbarLoadTimeStats";
    public static final String TOOLBAR_ADD_VIEW_END = "toolbar_add_view_end";
    public static final String TOOLBAR_ALL_LOAD_END = "toolbar_all_load_end";
    public static final String TOOLBAR_MORE_ON_DRAW = "toolbar_more_on_draw";
    public static final String TOOLBAR_PRE_SHOW = "toolbar_pre_show";
    public static final String TOOLBAR_START = "toolbar_start";
    public static final String TOOLBAR_TRUE_LOAD = "toolbar_true_load";
    private final HashMap<Integer, Long> componentLoadCostTimeMap;
    private final HashMap<Integer, Long> componentLoadTimeMap;
    private long p1LoadTime;
    private long preEnterUsingTime;
    private long roomEnterEndTime;
    private long roomInitTime;
    private long roomPartShowTime;
    private final ArrayList<String> statusList;
    private long toolbarAddViewEndTime;
    private long toolbarAllEndTime;
    private long toolbarMoreOnDraw;
    private long toolbarPreShowTime;
    private long toolbarStartTime;
    private long toolbarStartTrueLoadTime;
    private long toolbarSyncEndTime;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM$a$a, reason: collision with other inner class name */
        public static final class C0071a<T> implements Consumer {
            public final /* synthetic */ h80.a a;

            public C0071a(h80.a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                this.a.accept(c.b((b) r2));
            }
        }

        public a() {
        }

        @JvmStatic
        public static int c() {
            return bv0.a.getValue().intValue();
        }

        @JvmStatic
        public static ap1.a b(MiddlewareRoomContext r4) {
            if (r4 == null) goto L8;
            i r0 = r4.isAnchor();
            if (r0 == null) goto L8;
            if (((Boolean) r0.getValue()).booleanValue() != true) goto L8;
        L10:
            return new ToolbarLoadTimeStatsDummy();
        L8:
            if (c() <= 0) goto L10;
            ViewModel r1 = null;
            if (r4 != null) goto L14;
            r4 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        L14:
            if (r4 == null) goto L18;
            j r5 = r4.getToolbarLoadTimeStats();
            if (r5 == null) goto L18;
            ViewModel r6 = (ViewModel) r5.getValue();
        L20:
            if ((r6 instanceof ap1.a) == false) goto L23;
            r1 = r6;
        L23:
            ap1.a r2 = (ap1.a) r1;
            if (r2 == null) goto L26;
            return r2;
        L26:
            return new ToolbarLoadTimeStatsDummy();
        L18:
            r6 = null;
            goto L20
        }

        @JvmStatic
        public static boolean d(Room r1) {
            if (r1 == null) goto L12;
            IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
            if (r0 == null) goto L8;
            e r2 = r0.user();
            if (r2 == null) goto L8;
            String r3 = r2.n();
        L10:
            if (Intrinsics.areEqual(r3, r1.getOwnerUserIdString()) == false) goto L12;
            return true;
        L8:
            r3 = null;
        L12:
            return false;
        }

        @JvmStatic
        public static boolean e(boolean r2) {
            if (r2 == false) goto L6;
            return false;
        L6:
            if (c() < 2) goto L9;
            return true;
        L9:
            return false;
        }

        @JvmStatic
        public static void a(AutoDisposeConverter r1, MiddlewareRoomContext r2, h80.a r3) {
            Intrinsics.checkNotNullParameter(r1, "dispose");
            Intrinsics.checkNotNullParameter(r3, "action");
            if (r2 != null) goto L5;
            return;
        L5:
            Room r0 = (Room) r2.getInteractionDataPreparedForToolbar().getValue();
            if (r0 == null) goto L8;
            r3.accept(r0);
            return;
        L8:
            ((ObservableSubscribeProxy) r2.getInteractionDataPreparedForToolbar().a().as(r1)).subscribe(new C0071a(r3));
        }
    }

    @JvmStatic
    public static final void doWithRoomEnter(AutoDisposeConverter<b<Room>> r1, MiddlewareRoomContext r2, h80.a<IRoom> r3) {
        Companion.getClass();
        a.a(r1, r2, r3);
    }

    @JvmStatic
    public static final ap1.a getInstance(MiddlewareRoomContext r1) {
        Companion.getClass();
        return a.b(r1);
    }

    @JvmStatic
    public static final boolean isAnchor(Room r1) {
        Companion.getClass();
        return a.d(r1);
    }

    @JvmStatic
    public static final boolean needUseNewSyncRoom(boolean r1) {
        Companion.getClass();
        return a.e(r1);
    }

    static {
        Companion = new a();
    }

    private final String getShowType() {
        if (this.statusList.contains(STATUS_PART_SHOW) == false) goto L6;
        return STATUS_PART_SHOW;
    L6:
        if (this.statusList.contains(STATUS_DIRECT_SHOW) == true) goto L11;
        return "UnKnown";
    L11:
        return STATUS_DIRECT_SHOW;
    }

    @JvmStatic
    private static final int getStatsMode() {
        Companion.getClass();
        return a.c();
    }

    private final String getStatusString() {
        StringBuilder r0 = new StringBuilder("status:[");
        Iterator<T> r1 = this.statusList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append((String) r1.next());
        r0.append(", ");
        goto L4
    L6:
        r0.append("]");
        return r0.toString();
    }

    @JvmStatic
    public static final boolean isOpen() {
        Companion.getClass();
        if (a.c() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean needSampling() {
        Integer r0 = cv0.a.getValue();
        if (Random.Default.nextInt(0, 100000) > r0.intValue()) goto L6;
        return true;
    L6:
        return false;
    }

    public ToolbarLoadTimeStatsVM() {
        this.roomInitTime = -1;
        this.toolbarPreShowTime = -1;
        this.roomPartShowTime = -1;
        this.preEnterUsingTime = -1;
        this.roomEnterEndTime = -1;
        this.toolbarStartTime = -1;
        this.toolbarAddViewEndTime = -1;
        this.toolbarStartTrueLoadTime = -1;
        this.toolbarSyncEndTime = -1;
        this.toolbarAllEndTime = -1;
        this.toolbarMoreOnDraw = -1;
        this.p1LoadTime = -1;
        this.statusList = new ArrayList();
        this.componentLoadTimeMap = new HashMap();
        this.componentLoadCostTimeMap = new HashMap();
        if (v.a() == false) goto L6;
        ALogger.d(TAG, "init");
        return;
    }

    public void onCleared() {
        super.onCleared();
        this.statusList.clear();
    }

    private final String getResult(String r29) {
        StringBuilder r1 = new StringBuilder("Room " + r29 + " :\n");
        long r2 = this.roomInitTime;
        long r4 = this.toolbarPreShowTime - r2;
        long r6 = this.roomPartShowTime - r2;
        long r8 = this.preEnterUsingTime - r2;
        long r10 = this.roomEnterEndTime;
        long r12 = r10 - r2;
        long r14 = this.toolbarStartTime;
        long r13 = r14 - r2;
        long r15 = this.toolbarAddViewEndTime - r14;
        long r16 = this.toolbarStartTrueLoadTime;
        long r17 = r16 - r10;
        long r18 = this.p1LoadTime - r10;
        long r19 = this.toolbarMoreOnDraw - r10;
        long r11 = this.toolbarSyncEndTime - r16;
        long r110 = this.toolbarAllEndTime - r16;
        r1.append("toolbarPreShowTime - initTime=" + r4 + ",\n");
        r1.append("roomPartShowTime - initTime=" + r6 + ",\n");
        r1.append("preEnterUsingTime - initTime=" + r8 + ",\n");
        r1.append("roomEnterEndTime - initTime=" + r12 + ",\n");
        r1.append("toolbarStartTime - initTime=" + r13 + ",\n");
        r1.append("toolbarStartTrueLoadTime - initTime=" + (r16 - r2) + ",\n");
        r1.append("toolbarAddViewEndTime - toolbarStartTime=" + r15 + ",\n");
        r1.append("p1LoadTime - roomEnterEndTime=" + r18 + ",\n");
        r1.append("toolbarStartTrueLoadTime - roomEnterEndTime=" + r17 + ",\n");
        r1.append("toolbarMoreOnDraw - roomEnterEndTime=" + r19 + ",\n");
        r1.append("toolbarSyncEndTime - toolbarStartTrueLoadTime=" + r11 + ",\n");
        r1.append("toolbarAllEndTime - toolbarStartTrueLoadTime=" + r110 + " \n");
        r1.append("[");
        Iterator<Map.Entry<Integer, Long>> r3 = this.componentLoadCostTimeMap.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<Integer, Long> r5 = r3.next();
        r1.append(r5.getKey().intValue() + '-' + r5.getValue().longValue() + ", ");
        goto L4
    L6:
        r1.append("]");
        return r1.toString();
    }

    @JvmStatic
    public static final boolean needPostShow(boolean r1) {
        Companion.getClass();
        if (r1 == false) goto L6;
    L8:
        return false;
    L6:
        if (a.c() != 3) goto L8;
        return true;
    }

    @JvmStatic
    public static final void openAction(Function0<Unit> r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "action");
        if (a.c() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r1.invoke();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void sendComponentMonitor(boolean r8) {
        Iterator<Map.Entry<Integer, Long>> r0 = this.componentLoadCostTimeMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Integer, Long> r1 = r0.next();
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("id", String.valueOf(r1.getKey().intValue()));
        r2[1] = TuplesKt.to("cost", String.valueOf(r1.getValue().longValue()));
        if (r8 == false) goto L8;
        String r3 = "1";
    L9:
        r2[2] = TuplesKt.to("isAnchor", r3);
        Map r4 = MapsKt.mapOf(r2);
        j0.l().sendLog("ttlive_toolbar_component_load_time_stats", r4, new Object[]{Room.class, x.class});
        goto L4
    L8:
        r3 = "0";
        goto L9
    }

    private final void sendStatsMonitor(boolean r19) {
        LiveMonitor.a r1 = new LiveMonitor.a("ttlive_toolbar_load_time_stats", LiveTracingMonitor.EventModule.common);
        r1.l(0);
        long r2 = this.roomEnterEndTime;
        long r4 = this.toolbarPreShowTime;
        if (r4 == (-1)) goto L5;
        r1.g("ToolbarPreShowCost", r4 - r2);
        r1.e("ToolbarPreShow", "1");
    L6:
        long r5 = this.preEnterUsingTime;
        if (r5 == (-1)) goto L9;
        r1.g("PreEnterUsingTime", r5 - r2);
        r1.e("PreEnter", "1");
    L10:
        long r6 = this.toolbarStartTime;
        long r9 = r6 - r2;
        long r11 = this.toolbarAddViewEndTime - r6;
        long r7 = this.toolbarStartTrueLoadTime;
        long r13 = r7 - r2;
        long r8 = this.toolbarMoreOnDraw - r2;
        long r3 = this.toolbarSyncEndTime - r7;
        long r10 = this.toolbarAllEndTime - r7;
        String r12 = getShowType();
        r1.g("ToolbarStartCost", r9);
        r1.g("ToolbarAddViewEndCost", r11);
        r1.g("ToolbarLoadAfterEnterEndCost", r13);
        r1.g("ToolbarMoreOnDrawCost", r8);
        r1.g("ToolbarSyncEndCost", r3);
        r1.g("ToolbarAllEndCost", r10);
        if (this.statusList.contains(STATUS_IS_ENTER_ROOM_FINISH_WHEN_LOAD) == false) goto L13;
        String r14 = "1";
    L14:
        r1.e("EnterEndWhenLoad", r14);
        r1.e("ShowType", r12);
        if (r19 == false) goto L17;
        String r15 = "1";
    L18:
        r1.e("IsAnchor", r15);
        Companion.getClass();
        r1.e("StatsMode", String.valueOf(a.c()));
        r1.a().report();
        return;
    L17:
        r15 = "0";
        goto L18
    L13:
        r14 = "0";
        goto L14
    L9:
        r1.e("PreEnter", "0");
        goto L10
    L5:
        r1.e("ToolbarPreShow", "0");
        goto L6
    }

    private final void sendToolbarLoadTrackLog(long r6) {
        ILiveUxTracer r0 = k.f(ILiveUxTracer.class);
        if (r0 == null) goto L5;
        long r3 = r0.getTimeStamp("enter_room", "start");
    L7:
        if (r3 <= 0) goto L10;
        j0.l().sendLog("ttlive_toolbar_time_stats_log", MapsKt.mapOf(new Pair[]{TuplesKt.to(ROOM_INIT, String.valueOf(r3)), TuplesKt.to(TOOLBAR_TRUE_LOAD, String.valueOf(r6))}), new Object[]{Room.class, x.class});
        return;
    L10:
        return;
    L5:
        r3 = 0;
        goto L7
    }

    @Override // ap1.a
    public boolean isEnterFinished(o r5) {
        IRoom r3 = null;
        o r6 = IRoomContextService.a.a(k.n(IRoomContextService.class), null, 0, 3);
        if (r6 == null) goto L7;
        n r7 = r6.getInteractionDataPrepared();
        if (r7 == null) goto L7;
        r3 = (IRoom) r7.getValue();
    L7:
        if (r3 == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // ap1.a
    public void printStatsTime(boolean r3) {
        if (v.a() == false) goto L6;
        ALogger.i(TAG, getResult(getStatusString()));
    L6:
        if (needSampling() == false) goto L8;
    L9:
        sendStatsMonitor(r3);
        sendComponentMonitor(r3);
        return;
    L8:
        if (v.a() == true) goto L9;
    }

    @Override // ap1.a
    public void recordComponentEnd(int r7) {
        Long r0 = this.componentLoadTimeMap.get(Integer.valueOf(r7));
        if (r0 == null) goto L6;
        long r1 = SystemClock.uptimeMillis();
        this.componentLoadCostTimeMap.put(Integer.valueOf(r7), Long.valueOf(r1 - r0.longValue()));
        recordTime(TOOLBAR_ALL_LOAD_END);
        return;
    }

    @Override // ap1.a
    public void recordComponentStart(int r4) {
        long r0 = SystemClock.uptimeMillis();
        this.componentLoadTimeMap.put(Integer.valueOf(r4), Long.valueOf(r0));
    }

    @Override // ap1.a
    public void recordStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.statusList.add(r2);
    }

    @Override // ap1.a
    public void recordTime(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        long r0 = SystemClock.uptimeMillis();
        if (v.a() == false) goto L6;
        ALogger.i(TAG, r5 + ": " + r0);
    L6:
        switch(r5.hashCode()) {
            case -1740411043: goto L42;
            case -1350265757: goto L39;
            case -1067717132: goto L36;
            case -120942504: goto L33;
            case 415562035: goto L30;
            case 531641636: goto L27;
            case 790362256: goto L24;
            case 903797804: goto L21;
            case 1031866110: goto L18;
            case 1371368827: goto L15;
            case 1564273310: goto L12;
            case 2136552611: goto L9;
            default: goto L68;
        };
    L68:
        return;
    L9:
        if (r5.equals(ROOM_P1_LOAD_START) == false) goto L45;
        this.p1LoadTime = r0;
        return;
    L45:
        return;
    L12:
        if (r5.equals(TOOLBAR_START) == false) goto L47;
        this.toolbarStartTime = r0;
        return;
    L47:
        return;
    L15:
        if (r5.equals("toolbar_sync_end") == false) goto L49;
        this.toolbarSyncEndTime = r0;
        return;
    L49:
        return;
    L18:
        if (r5.equals(TOOLBAR_MORE_ON_DRAW) == false) goto L51;
        this.toolbarMoreOnDraw = r0;
        return;
    L51:
        return;
    L21:
        if (r5.equals(START_PART_SHOW) == false) goto L53;
        this.roomPartShowTime = r0;
        return;
    L53:
        return;
    L24:
        if (r5.equals(ROOM_ENTER_END) == false) goto L55;
        this.roomEnterEndTime = r0;
        return;
    L55:
        return;
    L27:
        if (r5.equals(TOOLBAR_ALL_LOAD_END) == false) goto L57;
        this.toolbarAllEndTime = r0;
        return;
    L57:
        return;
    L30:
        if (r5.equals(TOOLBAR_TRUE_LOAD) == false) goto L59;
        this.toolbarStartTrueLoadTime = r0;
        sendToolbarLoadTrackLog(r0);
        return;
    L59:
        return;
    L33:
        if (r5.equals("pre_enter_end") == false) goto L61;
        this.preEnterUsingTime = r0;
        recordStatus(STATUS_PRE_ENTER_SPLIT);
        return;
    L61:
        return;
    L36:
        if (r5.equals(ROOM_INIT) == false) goto L63;
        this.roomInitTime = r0;
        return;
    L63:
        return;
    L39:
        if (r5.equals(TOOLBAR_ADD_VIEW_END) == false) goto L65;
        this.toolbarAddViewEndTime = r0;
        return;
    L65:
        return;
    L42:
        if (r5.equals(TOOLBAR_PRE_SHOW) == false) goto L67;
        this.toolbarPreShowTime = r0;
        recordStatus(STATUS_PRE_SHOW_TOOLBAR);
        return;
    }
}
