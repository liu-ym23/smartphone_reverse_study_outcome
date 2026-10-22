package odb;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregatingv2impl.statistics.metrics.FeatureGatingMetricsTracker;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ ArrayList<a> a;

    public f(ArrayList<a> r1) {
        this.a = r1;
    }

    public final void a() {
        FeatureGatingMetricsTracker r1 = FeatureGatingMetricsTracker.a;
        ArrayList<a> r2 = this.a;
        ArrayList r3 = null;
        Log.i("FeatureGatingMetricsTracker", "reportSlardar start");     // Catch: Exception -> L41
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L41
        Iterator<T> r5 = r2.iterator();     // Catch: Exception -> L41
    L5:
        if (r5.hasNext() == false) goto L9;
        Object r6 = r5.next();     // Catch: Exception -> L41
        if (((a) r6).f == false) goto L5;
        r4.add(r6);     // Catch: Exception -> L41
        goto L5
    L9:
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Exception -> L41
        Iterator r8 = r4.iterator();     // Catch: Exception -> L41
    L11:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();     // Catch: Exception -> L41
        String r10 = ((a) r9).a;     // Catch: Exception -> L41
        Object r11 = r7.get(r10);     // Catch: Exception -> L41
        if (r11 != null) goto L15;
        r11 = new ArrayList();     // Catch: Exception -> L41
        r7.put(r10, r11);     // Catch: Exception -> L41
    L15:
        ((List) r11).add(r9);     // Catch: Exception -> L41
        goto L11
    L16:
        LinkedHashMap r12 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));     // Catch: Exception -> L41
        Iterator r13 = r7.entrySet().iterator();     // Catch: Exception -> L41
    L18:
        if (r13.hasNext() == false) goto L20;
        Object r14 = r13.next();     // Catch: Exception -> L41
        r12.put(((Map.Entry) r14).getKey(), CollectionsKt.sortedWith((List) ((Map.Entry) r14).getValue(), new c()));     // Catch: Exception -> L41
        goto L18
    L20:
        Iterator r15 = r12.entrySet().iterator();     // Catch: Exception -> L41
    L22:
        if (r15.hasNext() == false) goto L39;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Exception -> L41
        String r17 = (String) r16.getKey();     // Catch: Exception -> L41
        List r18 = (List) r16.getValue();     // Catch: Exception -> L41
        FeatureGatingMetricsTracker r19 = FeatureGatingMetricsTracker.a;     // Catch: Exception -> L41
        double r20 = FeatureGatingMetricsTracker.a(r18);     // Catch: Exception -> L41
        mdb.a r21 = FeatureGatingMetricsTracker.e;     // Catch: Exception -> L41
        if (r21 == null) goto L32;
        mdb.a.C0258a r22 = r21.slidingWindow;     // Catch: Exception -> L41
        if (r22 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("slidingWindow");     // Catch: Exception -> L41
        r22 = null;
    L29:
        if (r22 == null) goto L32;
        int r23 = r22.a();     // Catch: Exception -> L41
    L34:
        if (r20 <= r23) goto L22;
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L37
        r24.put("key", r17);     // Catch: Exception -> L37
        r24.put("pageName", ((a) CollectionsKt.first(r18)).e);     // Catch: Exception -> L37
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L37
        r25.put("qps", r20);     // Catch: Exception -> L37
        ApmAgent.monitorEvent("fg_qps_beyond_threshold_v2", r24, r25, null);     // Catch: Exception -> L37
        Log.w("FeatureGatingMetricsTracker", "fg called beyond threshold, key: " + r17 + ", qps: " + r20 + ", topActivity: " + ((a) CollectionsKt.first(r18)).e);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        Log.e("FeatureGatingMetricsTracker", "reportSlardar failed, e: " + e);     // Catch: Exception -> L41
    L32:
        r23 = 200;
        goto L34
    L39:
        Log.i("FeatureGatingMetricsTracker", "reportSlardar success");     // Catch: Exception -> L41
    L43:
        FeatureGatingMetricsTracker r26 = FeatureGatingMetricsTracker.a;
        ArrayList<a> r27 = this.a;
        Log.i("FeatureGatingMetricsTracker", "reportTeaDetail start");
        Iterator<a> r28 = r27.iterator();
    L44:
        int r29 = 0;
        if (r28.hasNext() == false) goto L70;
        a r30 = r28.next();
        Iterator<b> r31 = FeatureGatingMetricsTracker.c.iterator();
    L48:
        if (r31.hasNext() == false) goto L59;
        b r32 = r31.next();
        b r33 = r32;
        if (Intrinsics.areEqual(r33.c(), r30.a) == true) goto L52;
    L56:
        boolean r34 = false;
    L57:
        if (r34 == false) goto L48;
    L60:
        b r35 = r32;
        if (r35 != null) goto L62;
        b r36 = new b();
        r36.h(r30.a);
        r36.f(CollectionsKt.mutableListOf(new Double[]{Double.valueOf((r30.c - r30.b) / ((double) 1000000))}));
        r36.g(CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(r30.d.getValue())}));
        r36.i(r30.f);
        r36.j(r30.e);
        FeatureGatingMetricsTracker.c.add(r36);
        goto L44
    L62:
        List<Double> r37 = r35.a();
        if (r37 != null) goto L65;
        r37 = new ArrayList();
        r35.f(r37);
    L65:
        List<Integer> r38 = r35.b();
        if (r38 != null) goto L68;
        r38 = new ArrayList();
        r35.g(r38);
    L68:
        r37.add(Double.valueOf((r30.c - r30.b) / ((double) 1000000)));
        r38.add(Integer.valueOf(r30.d.getValue()));
        goto L44
    L52:
        if (r33.e() != r30.f) goto L56;
        if (Intrinsics.areEqual(r33.d(), r30.e) == false) goto L56;
        r34 = true;
        goto L57
    L59:
        r32 = null;
        goto L60
    L70:
        StringBuilder r39 = new StringBuilder("reportTeaDetail size: ");
        ArrayList<b> r40 = FeatureGatingMetricsTracker.c;
        r39.append(r40.size());
        Log.d("FeatureGatingMetricsTracker", r39.toString());
        long r41 = System.currentTimeMillis();
        if (FeatureGatingMetricsTracker.d != 0) goto L76;
        if ((!r40.isEmpty()) == false) goto L76;
        FeatureGatingMetricsTracker.d = r41;
    L76:
        if (r40.isEmpty() == true) goto L97;
        Iterator<b> r42 = r40.iterator();
        int r43 = 0;
    L80:
        if (r42.hasNext() == false) goto L85;
        List<Double> r44 = r42.next().a();
        if (r44 != null) goto L84;
        r44 = CollectionsKt.emptyList();
    L84:
        r43 = r43 + r44.size();
        goto L80
    L85:
        mdb.a r45 = FeatureGatingMetricsTracker.e;
        if (r45 == null) goto L88;
        int r46 = r45.b();
    L89:
        if (r43 < r46) goto L91;
        Log.d("FeatureGatingMetricsTracker", "shouldFlushTeaDetail by count, totalItemCount: " + r43);
    L96:
        boolean r47 = true;
    L98:
        if (r47 == true) goto L156;
    L127:
        FeatureGatingMetricsTracker r48 = FeatureGatingMetricsTracker.a;
        ArrayList<a> r49 = this.a;
        Log.i("FeatureGatingMetricsTracker", "reportTeaQPS start");     // Catch: Exception -> L136
        ArrayList r50 = new ArrayList();     // Catch: Exception -> L136
        Iterator<T> r51 = r49.iterator();     // Catch: Exception -> L136
    L130:
        if (r51.hasNext() == false) goto L134;
        Object r52 = r51.next();     // Catch: Exception -> L136
        if (((a) r52).f == false) goto L130;
        r50.add(r52);     // Catch: Exception -> L136
        goto L130
    L134:
        double r53 = FeatureGatingMetricsTracker.a(CollectionsKt.toList(CollectionsKt.sortedWith(r50, new d())));     // Catch: Exception -> L136
        double r54 = FeatureGatingMetricsTracker.a(CollectionsKt.toList(CollectionsKt.sortedWith(r49, new e())));     // Catch: Exception -> L136
        JSONObject r55 = new JSONObject();     // Catch: Exception -> L136
        r55.put("page_name", ((a) CollectionsKt.last(r49)).e);     // Catch: Exception -> L136
        r55.put("biz_qps", r53);     // Catch: Exception -> L136
        r55.put("infra_qps", r54);     // Catch: Exception -> L136
        FeatureGatingModule.getDependency().sendEvent("fg_qps_track", r55);     // Catch: Exception -> L136
        Log.i("FeatureGatingMetricsTracker", "reportTeaQPS success");     // Catch: Exception -> L136
        return;
    L136:
        e = move-exception;
        Log.e("FeatureGatingMetricsTracker", "reportTeaQPS failed, e: " + e);
        return;
    L156:
        Log.i("FeatureGatingMetricsTracker", "reportTeaDetail real start");     // Catch: Throwable -> L119 Exception -> L121
        ArrayList<b> r56 = FeatureGatingMetricsTracker.c;     // Catch: Throwable -> L119 Exception -> L121
        ArrayList r57 = new ArrayList(r56);     // Catch: Throwable -> L119 Exception -> L121
        r56.clear();     // Catch: Throwable -> L115 Exception -> L117
        ArrayList r58 = new ArrayList();     // Catch: Throwable -> L115 Exception -> L117
    L103:
        if (r29 >= r57.size()) goto L113;
        r58.add(r57.get(r29));     // Catch: Throwable -> L115 Exception -> L117
        int r59 = r58.size();     // Catch: Throwable -> L115 Exception -> L117
        mdb.a r60 = FeatureGatingMetricsTracker.e;     // Catch: Throwable -> L115 Exception -> L117
        if (r60 == null) goto L107;
        int r61 = r60.c();     // Catch: Throwable -> L115 Exception -> L117
    L108:
        if (r59 < r61) goto L110;
    L111:
        PersistentResource.PersistentResourceAdapter.a.getClass();     // Catch: Throwable -> L115 Exception -> L117
        String r62 = PersistentResource.PersistentResourceAdapter.b.toJson(r58);     // Catch: Throwable -> L115 Exception -> L117
        JSONObject r63 = new JSONObject();     // Catch: Throwable -> L115 Exception -> L117
        r63.put("fg_params", r62);     // Catch: Throwable -> L115 Exception -> L117
        FeatureGatingModule.getDependency().sendEvent("fg_performence_track", r63);     // Catch: Throwable -> L115 Exception -> L117
        r58.clear();     // Catch: Throwable -> L115 Exception -> L117
    L112:
        r29 = r29 + 1;     // Catch: Throwable -> L115 Exception -> L117
        goto L103
    L110:
        if (r29 != (r57.size() - 1)) goto L112;
    L107:
        r61 = 100;
        goto L108
    L113:
        Log.i("FeatureGatingMetricsTracker", "reportTeaDetail success");     // Catch: Throwable -> L115 Exception -> L117
        FeatureGatingMetricsTracker.d = 0;     // Catch: Throwable -> L115 Exception -> L117
        FeatureGatingMetricsTracker.c.clear();
    L126:
        r57.clear();
        goto L127
    L117:
        Exception e = e;
    L148:
        Log.e("FeatureGatingMetricsTracker", "reportTeaDetail failed, e: " + e);     // Catch: Throwable -> L139
        FeatureGatingMetricsTracker.c.clear();
        if (r57 == null) goto L127;
    L139:
        th = th;
        r3 = r57;
    L141:
        r57 = r3;
    L142:
        FeatureGatingMetricsTracker.c.clear();
        if (r57 == null) goto L145;
        r57.clear();
    L145:
        throw th;
    L115:
        th = th;
        goto L142
    L121:
        e = move-exception;
        e = e;
        r57 = null;
    L119:
        th = th;
        goto L141
    L91:
        long r64 = FeatureGatingMetricsTracker.d;
        if (r64 <= 0) goto L97;
        if ((r41 - r64) < 30000) goto L97;
        Log.d("FeatureGatingMetricsTracker", "shouldFlushTeaDetail by time, intervalMs: 30000");
        goto L96
    L88:
        r46 = ChameleonWebViewClient.DEFAULT_SAFE_TIME;
    L97:
        r47 = false;
    L41:
        e = move-exception;
        Log.e("FeatureGatingMetricsTracker", "reportSlardar failed, err: " + e);
        goto L43
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
