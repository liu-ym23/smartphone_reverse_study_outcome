package ev0;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public final PriorityQueue<PanelInfo> b;
    public final List<ev0.b> c;
    public final List<ev0.a> d;
    public HybridDialog e;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((PanelInfo) r2).f), Integer.valueOf(((PanelInfo) r1).f));
        }
    }

    public static final class b {
    }

    static {
    }

    public final void e() {
        StringBuilder r0 = new StringBuilder("showNextPanel start currentPanel.state=");
        PanelInfo r1 = this.b.peek();
        HybridDialog r2 = null;
        if (r1 == null) goto L7;
        PropertyOwner r3 = r1.b;
        if (r3 == null) goto L7;
        PanelInfo.State r4 = (PanelInfo.State) r3.a;
    L8:
        r0.append(r4);
        a(r0.toString());
        PanelInfo r5 = this.b.peek();
        if (r5 != null) goto L12;
        return;
    L12:
        if (((PanelInfo.State) r5.b.a) != PanelInfo.State.WAITING) goto L42;
        a("checkMutexStrategy");
        List<ev0.b> r6 = this.c;
        if ((r6 instanceof Collection) == true) goto L16;
    L18:
        Iterator r7 = ((ArrayList) r6).iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        if (((ev0.b) r7.next()).c(r5) == true) goto L20;
        boolean r8 = false;
    L25:
        if (r8 == false) goto L43;
        r5.a(PanelInfo.State.READY, null);
        a("showNextPanel showHybridDialog");
        StringBuilder r9 = new StringBuilder("showHybridDialog start curState=");
        PropertyOwner r10 = r5.b;
        if (r10 == null) goto L29;
        PanelInfo.State r12 = (PanelInfo.State) r10.a;
    L30:
        r9.append(r12);
        a(r9.toString());
        Map r13 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("panel_info", String.valueOf(r5))});
        if (x40.h.a().booleanValue() == false) goto L33;
        com.bytedance.android.livesdk.chatroom.monitor.d r14 = new com.bytedance.android.livesdk.chatroom.monitor.d();
        r14.c = r5.d;
        r14.d("OPEN_CONTAINER_START");
    L34:
        IBrowserService r15 = k.f(IBrowserService.class);
        if (r15 == null) goto L37;
        r2 = r15.showHybridDialog(r5.getContext(), r5.d, new h(r5, r14, this, r13), r5.e, null);
    L37:
        this.e = r2;
        return;
    L33:
        r14 = null;
        goto L34
    L29:
        r12 = null;
        goto L30
    L43:
        return;
    L24:
        r8 = true;
        goto L25
    L16:
        if (((ArrayList) r6).isEmpty() == false) goto L18;
    L42:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public c() {
        this.a = new CompositeDisposable();
        this.b = new PriorityQueue(11, new a());
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public static void a(String r1) {
        ALogger.i("TaskPanelManager", r1);
    }

    public static String c(Uri r4) {
        if (r4 != null) goto L28;
    L25:
        return "";
    L28:
        Intrinsics.checkNotNullParameter(r4, "baseUri");     // Catch: Exception -> L27
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L27
        if (r4.isHierarchical() == false) goto L9;
        Iterator r1 = UriProtector.getQueryParameterNames(r4).iterator();     // Catch: Exception -> L27
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) r1.next();     // Catch: Exception -> L27
        String r3 = UriProtector.getQueryParameter(r4, r2);     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L27
        r0.put(r2, r3);     // Catch: Exception -> L27
    L9:
        Intrinsics.checkNotNullParameter("url", "key");     // Catch: Exception -> L27
        Object r5 = r0.get("url");     // Catch: Exception -> L27
        if ((r5 instanceof x0) == false) goto L13;
        x0 r6 = (x0) r5;     // Catch: Exception -> L27
    L20:
        if (r6 == null) goto L25;
        Uri r7 = r6.c();     // Catch: Exception -> L27
        if (r7 == null) goto L25;
        String r8 = r7.getPath();     // Catch: Exception -> L27
        if (r8 == null) goto L25;
        return r8;
    L13:
        if ((r5 instanceof String) == false) goto L18;
        int r9 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Exception -> L27
        Uri r10 = com.bytedance.revenue.platform.api.core.e.a((String) r5);     // Catch: Exception -> L27
        if (r10.isHierarchical() == false) goto L17;
        r6 = new x0(r10);     // Catch: Exception -> L27
    L19:
        r0.put("url", r6);     // Catch: Exception -> L27
        goto L20
    L17:
        r6 = new x0(Uri.EMPTY);     // Catch: Exception -> L27
        goto L19
    L18:
        int r12 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Exception -> L27
        r6 = new x0(Uri.EMPTY);     // Catch: Exception -> L27
        goto L19
    }

    public static void d(String r1, Map r2) {
        int r0 = LiveTaskPanelTraceMonitor.a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), r1, r2);
    }

    public final void b(Context r20, Uri r22, Bundle r23, com.bytedance.android.live.profit.taskcenter.b r24) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r22, "uri");
        Intrinsics.checkNotNullParameter(r23, "bundle");
        Intrinsics.checkNotNullParameter(r24, "callBack");
        if (this.a.isDisposed() == false) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r22, "uri");
        String r3 = UriProtector.getQueryParameter(r22, "priority_level");
        Dialog r9 = null;
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(CastIntegerProtector.parseInt(r3));
    L9:
        boolean r10 = true;
        if (r4 == null) goto L12;
        int r12 = r4.intValue();
    L13:
        a("addPanel uri=" + r22 + " priority=" + r12);
        Intrinsics.checkNotNullParameter(r22, "uri");
        String r1 = UriProtector.getQueryParameter(r22, "scene");
        if (r1 != null) goto L16;
        String r13 = "";
    L17:
        String r2 = UriProtector.getQueryParameter(r22, "daily_limit");
        if (r2 == null) goto L20;
        int r14 = CastIntegerProtector.parseInt(r2);
    L21:
        String r5 = UriProtector.getQueryParameter(r22, "lifetime_limit");
        if (r5 == null) goto L24;
        int r15 = CastIntegerProtector.parseInt(r5);
    L25:
        String r6 = UriProtector.getQueryParameter(r22, "activity_id");
        if (r6 != null) goto L28;
        String r16 = "";
    L29:
        String r7 = UriProtector.getQueryParameter(r22, "min_interval");
        if (r7 == null) goto L32;
        int r17 = CastIntegerProtector.parseInt(r7);
    L33:
        fv0.a r8 = new fv0.a(r13, r14, r15, r16, r17);
        a("checkFrequencyStrategy");
        List<ev0.a> r18 = this.d;
        if ((r18 instanceof Collection) == true) goto L36;
    L38:
        Iterator r19 = ((ArrayList) r18).iterator();
    L40:
        if (r19.hasNext() == false) goto L44;
        if (((ev0.a) r19.next()).b(r8) == true) goto L40;
        boolean r25 = false;
    L45:
        Boolean r26 = Boolean.valueOf(r25);
        if (r26.booleanValue() == true) goto L49;
        r26 = null;
    L49:
        if (r26 == null) goto L60;
        r26.booleanValue();
        PanelInfo r110 = new PanelInfo(r20, r22, r23, r12, r8, r24);
        d(LiveTaskPanelTraceMonitor.Step.CREATE_PANEL_INFO.getStep(), MapsKt.mapOf(TuplesKt.to("panel_info", r110.toString())));
        a("observePanelState curState=" + ((PanelInfo.State) r110.b.a));
        Map r27 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cur_state", r110.b.a), TuplesKt.to("panel_info", r110.toString())});
        d(LiveTaskPanelTraceMonitor.Step.OBSERVE_PANEL_STATE.getStep(), r27);
        RxUtilKt.c(r110.b.subscribe(new g(this, r110, r27)), this.a);
        if (r12 != 10) goto L58;
        PanelInfo r28 = this.b.peek();
        if (r28 == null) goto L59;
        PanelInfo.State r29 = PanelInfo.State.DISMISSED;
        HybridDialog r30 = this.e;
        if (r30 == null) goto L57;
        r9 = r30.getDialog();
    L57:
        r28.a(r29, r9);
    L59:
        e();
    L61:
        int r32 = hv0.a.a;
        String r33 = c(r22);
        int r34 = this.b.size();
        HashMap r35 = hv0.a.a();
        r35.put("path", r33);
        r35.put("priority", String.valueOf(r12));
        if (r10 == false) goto L64;
        String r36 = DataType.TRUE;
    L65:
        r35.put("is_frequency_pass", r36);
        r35.put("queue_size", String.valueOf(r34));
        n r37 = new n();
        Map<String, String> r38 = r37.a;
        Intrinsics.checkNotNullParameter(r38, "map");
        Intrinsics.checkNotNullParameter(r35, "map");
        r38.putAll(r35);
        m r39 = new m();
        r39.b(LogCommon.ROOM);
        r39.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r37.b).addAll(r39.a);
        cy0.e.a.getClass();
        j r40 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r42 = com.bytedance.android.scope.m.b(r40).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r42);
        ((i) ((f80.a) r42)).w3("livesdk_task_add_panel", r37.a, r37.b);
        return;
    L64:
        r36 = DataType.FALSE;
        goto L65
    L58:
        this.b.add(r110);
        goto L59
    L60:
        a("checkFrequency false");
        r10 = false;
    L44:
        r25 = true;
        goto L45
    L36:
        if (((ArrayList) r18).isEmpty() == false) goto L38;
    L32:
        r17 = 0;
        goto L33
    L28:
        r16 = r6;
        goto L29
    L24:
        r15 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r13 = r1;
        goto L17
    L12:
        r12 = 1;
        goto L13
    L8:
        r4 = null;
        goto L9
    }
}
