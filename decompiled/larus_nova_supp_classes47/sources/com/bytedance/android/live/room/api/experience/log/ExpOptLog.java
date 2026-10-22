package com.bytedance.android.live.room.api.experience.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l61.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ExpOptLog {
    public static final Lazy a = null;
    public static final Set<b> b = null;
    public static final ExpOptLog c = null;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((LivePerfBizLevel) r1).getLevel()), Integer.valueOf(((LivePerfBizLevel) r2).getLevel()));
        }
    }

    public ExpOptLog() {
    }

    public static StringBuilder c() {
        return (StringBuilder) a.getValue();
    }

    static {
        c = new ExpOptLog();
        a = LazyKt.lazy(ExpOptLog$traceBuilder$2.INSTANCE);
        b = new LinkedHashSet();
    }

    public static void b(DataCenter r13) {
        if (r13 == null) goto L5;
        IRoom r14 = a0.n(r13);
        if (r14 == null) goto L5;
    L6:
        Set<b> r0 = b;
        if ((!r0.isEmpty()) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L30;
        c.getClass();
        c().append("------以下业务场景响应了性能等级更新------\n");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        LivePerfBizLevel r4 = ((b) r3).getLevel();
        Object r5 = r1.get(r4);
        if (r5 != null) goto L17;
        r5 = new ArrayList();
        r1.put(r4, r5);
    L17:
        ((List) r5).add(r3);
        goto L13
    L18:
        SortedMap r6 = MapsKt.toSortedMap(r1, new a());
        if (r6 == null) goto L31;
        Iterator r7 = r6.entrySet().iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        Map.Entry r8 = (Map.Entry) r7.next();
        c.getClass();
        c().append(((LivePerfBizLevel) r8.getKey()).name() + 65306 + CollectionsKt.joinToString$default((Iterable) r8.getValue(), null, null, null, 0, null, ExpOptLog$endTrace$5$1.INSTANCE, 31, null) + "\n");
        goto L22
    L24:
        Unit r9 = Unit.INSTANCE;
        c.getClass();
        c().append("------ end ------");
        String r10 = c().toString();
        int r12 = e.m;
        e.a r15 = e.b.a("exp_opt_change", "live_exp_opt");
        r15.c = "webcast_client_community";
        r15.h = 0;
        r15.i = "";
        r15.e = r14.getIdStr();
        r15.g = k.n(IMiddlewareUserService.class).user().n();
        r15.f = r14.getAnchorId();
        e r16 = r15.a();
        JSONObject r17 = new JSONObject();
        r17.put("perf_change_log", r10);
        TraceMonitor.h(r16, r17);
        SimpleAlogArgsBuilder r18 = new SimpleAlogArgsBuilder();
        r18.c(r10);
        d(r18.b());
        b.clear();
        StringsKt.clear(c());
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r14 = a0.a;
        goto L6
    }

    @JvmStatic
    public static final void d(com.bytedance.android.live.room.api.base.alog.a r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Throwable r0 = r2.b;
        if (r0 == null) goto L5;
        ALogger.e("LiveExpOptLog", r2.a, r0);
        return;
    L5:
        ALogger.i("LiveExpOptLog", r2.a);
        Unit r3 = Unit.INSTANCE;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        ALogger.i("LiveExpOptLog", r3);
        c().append(r3 + "\n");
    }
}
