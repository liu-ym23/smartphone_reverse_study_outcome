package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f5014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f5015b = null;

    static {
        LazyKt.lazy(ArgusMonitor$teaReporter$2.f5006a);
        f5014a = LazyKt.lazy(ArgusMonitor$aspectLimitRemainCounter$2.f5002a);
        f5015b = LazyKt.lazy(ArgusMonitor$threadExecutor$2.f5007a);
    }

    public static String a(ArrayList r5, int r10) {
        if (r5.size() >= r10) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L18;
        List r11 = CollectionsKt.toList(r5);
        if (r11 == null) goto L18;
        Iterator r12 = r11.iterator();
        String r13 = "";
    L11:
        if (r12.hasNext() == false) goto L14;
        Pair r14 = (Pair) r12.next();
        r13 = r13 + "key=" + ((String) r14.component1()) + ',' + ((String) r14.component2()) + Typography.greater;
        goto L11
    L14:
        if (r13.length() > 0) goto L16;
        return r13;
    L16:
        return StringsKt.dropLast(r13, 1);
    L18:
        return null;
    }

    public static String b(JSONObject r5) {
        final StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L4
        td.b.d(r5, new ArgusMonitor$transformJsonToString$1$1(r10));     // Catch: Exception -> L4
        return StringsKt.dropLast(r10.toString(), 1);
    L4:
        e = move-exception;
        return androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("append error: "));
    }

    public static JSONObject c(ConcurrentHashMap r10) {
        JSONObject r5 = new JSONObject();
        Iterator r11 = MapsKt.toMap(r10).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        long[] r14 = (long[]) r12.getValue();
        if (r14.length != 2) goto L4;
        long r15 = r14[1] - r14[0];
        if (r15 < 0) goto L4;
        c.a(Long.valueOf(r15), r13, r5);
        goto L4
    L10:
        return r5;
    }

    public static void d(final com.bytedance.ies.argus.bean.a r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (((ArgusReportPlatform) r5.g.f23297a) == ArgusReportPlatform.d) goto L6;
        Function0<Unit> r10 = new ArgusMonitor$asyncReportAspect$1(r5);
        ((ThreadPoolExecutor) f5015b.getValue()).submit(new com.bytedance.android.anniex.monitor.b(3, r10));
        return;
    }
}
