package com.bytedance.android.anniex.base.service;

import android.system.ErrnoException;
import android.util.Log;
import b3.o;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.geckox.AppSettingsManager$IGeckoAppSettings;
import com.bytedance.geckox.listener.GeckoUpdateListener$GeckoParams;
import com.bytedance.geckox.logger.DefaultLogger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.logger.Logger;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.XDynamicType;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.lang.model.element.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3130a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3131b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3132c = false;

    public static void A(Set r5, Modifier... r10) {
        int r11 = r10.length;
        boolean r12 = false;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L9;
        if (r5.contains(r10[r13]) == false) goto L7;
        r14 = r14 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L9:
        if (r14 != 1) goto L11;
        r12 = true;
    L11:
        r(r12, "modifiers %s must contain one of %s", new Object[]{r5, Arrays.toString(r10)});
    }

    public static long B(LinkedList r5, StringBuilder r10) {
        Iterator r11 = r5.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        d6.f r13 = (d6.f) r11.next();
        r10.append(r13.toString());
        r10.append('\n');
        long r14 = r13.f16609b;
        if (r12 >= r14) goto L4;
        r12 = r14;
        goto L4
    L8:
        return r12;
    }

    public static void C(long[] r25, LinkedList r26, long r27) {
        int r5 = 1;
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L168;
        long r10 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        long r11 = r25[r25.length - 1] & 8796093022207L;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= r25.length) goto L18;
        if ((r25[r12] & 8796093022207L) < r11) goto L18;
        r12 = r12 + 1;
    L18:
        LinkedList r13 = new LinkedList();
        int r14 = 0;
        int r15 = 0;
    L20:
        if (r12 >= r25.length) goto L70;
        long r16 = r25[r12];
        if (r10 != r16) goto L25;
    L23:
        long r17 = r10;
    L69:
        r12 = r12 + r5;
        r10 = r17;
        goto L20
    L25:
        if (z(r16) == true) goto L27;
    L29:
        if (r15 != 0) goto L34;
        if (u(r16) <= 1048000) goto L23;
        Log.i("SceneMethodsInfo", String.format("s2 pass this method[%s], isIn [%b] ", new Object[]{Integer.valueOf(u(r16)), Boolean.valueOf(z(r16))}));
        goto L23
    L34:
        if (z(r16) == true) goto L36;
        int r18 = u(r16);
        if (r13.isEmpty() == true) goto L66;
        Long r19 = (Long) r13.pop();
        long r110 = r19.longValue();
        r14 = r14 - 1;
        LinkedList r20 = new LinkedList();
        r20.push(r19);
    L43:
        int r21 = u(r110);
        if (r21 == r18) goto L51;
        if (r13.isEmpty() == true) goto L51;
        if (j.f3887a == false) goto L50;
        mh.e.v("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r21), Integer.valueOf(r18)});
    L50:
        Long r22 = (Long) r13.pop();
        r110 = r22.longValue();
        r14 = r14 - 1;
        r20.push(r22);
    L51:
        if (r21 == r18) goto L54;
        if (r21 != 1048574) goto L54;
        boolean r23 = j.f3887a;
        r13.addAll(r20);
        r14 = r14 + r13.size();
        r5 = 1;
    L39:
        r17 = 0;
    L54:
        long r111 = MethodCollector.getDiffTime() + (r16 & 8796093022207L);
    L56:
        if (r20.size() == 0) goto L64;
        long r24 = MethodCollector.getDiffTime() + (((Long) r20.pop()).longValue() & 8796093022207L);
        long r112 = r111 - r24;
        if (r112 < 0) goto L60;
        p(r26, new d6.f(r18, (int) r112, r14, r24));
        goto L56
    L60:
        if (j.f3887a == false) goto L62;
        Log.e("TraceDataUtils", String.format("[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r112)}));
    L62:
        r13.clear();
        r26.clear();
        return;
    L64:
        r17 = 0;
    L65:
        r5 = 1;
        goto L69
    L66:
        r17 = 0;
        if (j.f3887a == false) goto L65;
        mh.e.v("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r18)});
        goto L65
    L36:
        if (u(r16) != MethodCollector.METHOD_ID_DISPATCH) goto L38;
        r13.clear();
        r14 = 0;
    L38:
        r14 = r14 + r5;
        r13.push(Long.valueOf(r16));
        goto L39
    L27:
        if (1048574 != u(r16)) goto L29;
        r15 = r5;
        goto L29
    L70:
        Log.i("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r13.size());
    L72:
        if (r13.isEmpty() == true) goto L81;
        long r28 = ((Long) r13.pop()).longValue();
        int r113 = u(r28);
        boolean r29 = z(r28);
        long r210 = MethodCollector.getDiffTime() + (r28 & 8796093022207L);
        if (j.f3887a == false) goto L76;
        mh.e.v("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r113), Boolean.valueOf(r29), Long.valueOf(r210), Long.valueOf(r27), Integer.valueOf(r13.size())});
    L76:
        if (r29 == false) goto L78;
        p(r26, new d6.f(r113, (int) (r27 - r210), r13.size(), r210));
        goto L72
    L78:
        if (j.f3887a == false) goto L72;
        Log.e("TraceDataUtils", String.format("[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r113)}));
        goto L72
    L81:
        wg.a r30 = null;
        wg.a r31 = new wg.a(null, null);
        ListIterator r32 = r26.listIterator(0);
        int r33 = 0;
    L83:
        if (r32.hasNext() == false) goto L119;
        wg.a r34 = new wg.a((d6.f) r32.next(), r30);
        d6.f r35 = r34.f22860a;
        r33 = r33 + 1;
        if (r30 != null) goto L93;
        if (r35 != null) goto L88;
        int r36 = 0;
    L89:
        if (r36 == 0) goto L93;
        if (j.f3887a == false) goto L120;
        Log.e("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!");
    L120:
        r26.clear();
        LinkedList r37 = new LinkedList();
    L121:
        if (r31 == null) goto L169;
        d6.f r38 = r31.f22860a;
        if (r38 == null) goto L125;
        r26.add(r38);
    L125:
        LinkedList r39 = r31.f22862c;
        if (r39.isEmpty() == true) goto L131;
        int r40 = r39.size() - 1;
    L128:
        if (r40 < 0) goto L131;
        r37.add(r39.get(r40));
        r40 = r40 - 1;
    L131:
        r31 = (wg.a) r37.pollLast();
        goto L121
    L169:
        return;
    L88:
        r36 = r35.d;
    L93:
        if (r35 != null) goto L95;
        int r41 = 0;
    L96:
        if (r30 == null) goto L117;
        if (r41 == 0) goto L117;
        d6.f r42 = r30.f22860a;
        if (r42 != null) goto L102;
        int r43 = 0;
    L103:
        if (r43 < r41) goto L116;
    L104:
        if (r30 == null) goto L111;
        d6.f r44 = r30.f22860a;
        if (r44 != null) goto L108;
        int r45 = 0;
    L109:
        if (r45 <= r41) goto L111;
        r30 = r30.f22861b;
        goto L104
    L108:
        r45 = r44.d;
    L111:
        if (r30 == null) goto L83;
        wg.a r46 = r30.f22861b;
        if (r46 == null) goto L118;
        r34.f22861b = r46;
        r30.f22861b.f22862c.addFirst(r34);
    L118:
        r30 = r34;
        goto L83
    L116:
        r30.f22862c.addFirst(r34);
        goto L118
    L102:
        r43 = r42.d;
    L117:
        r31.f22862c.addFirst(r34);
        goto L118
    L95:
        r41 = r35.d;
        goto L96
    L119:
        Log.i("SceneMethodsInfo", String.format("[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r33)}));
        goto L120
    L10:
        r11 = Long.MAX_VALUE;
        goto L11
    }

    public static void D(LinkedList r10, m.b r11) {
        int r12 = r10.size();
        int r5 = 1;
    L4:
        if (r12 <= 30) goto L15;
        ListIterator r13 = r10.listIterator(r10.size());
    L7:
        if (r13.hasPrevious() == false) goto L13;
        if (((d6.f) r13.previous()).f16609b >= (r5 * 5)) goto L7;
        r13.remove();
        r12 = r12 - 1;
        if (r12 > 30) goto L7;
        return;
    L13:
        r12 = r10.size();
        r5 = r5 + 1;
        if (60 >= r5) goto L4;
    L15:
        int r14 = r10.size();
        if (r14 > 30) goto L18;
        return;
    L18:
        if (j.f3887a == false) goto L20;
        mh.e.v("EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r14), 30, r10});
    L20:
        ListIterator r15 = r10.listIterator(Math.min(r14, 30));
    L22:
        if (r15.hasNext() == false) goto L35;
        r15.next();
        r15.remove();
        goto L22
    }

    public static LinkedHashSet E(Set r5, Set r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        r11.addAll(r5);
        r11.addAll(r10);
        return r11;
    }

    public static long a(String r5, String r10, HashMap r11) {
        Object r12 = r11.get(r5);
        Long r13 = null;
        if ((r12 instanceof Long) == false) goto L5;
        Long r14 = (Long) r12;
    L6:
        Object r15 = r11.get(r10);
        if ((r15 instanceof Long) == false) goto L9;
        r13 = (Long) r15;
    L9:
        if (r14 == null) goto L14;
        if (r13 == null) goto L14;
        return r13.longValue() - r14.longValue();
    L14:
        Log.e("TimelineTracker", "getDurationFromMap: " + r14 + ", " + r13 + ", " + r11);
        return 0;
    L5:
        r14 = null;
        goto L6
    }

    public static final Long b(o r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "startKey");
        Intrinsics.checkNotNullParameter(r12, "endKey");
        long r5 = r10.d(r12);
        Long r13 = Long.valueOf(r5);
        if (r5 > 0) goto L6;
        r13 = null;
    L6:
        if (r13 == null) goto L14;
        long r14 = r13.longValue();
        long r15 = r10.d(r11);
        Long r16 = Long.valueOf(r15);
        if (r15 > 0) goto L11;
        r16 = null;
    L11:
        if (r16 == null) goto L14;
        return Long.valueOf(r14 - r16.longValue());
    L14:
        return null;
    }

    public static final Object c(IDLXDynamic r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        XDynamicType r10 = r5.getType();
        switch(le.a.f19600a[r10.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L9:
        return r5.asByteArray();
    L11:
        return r5.asArray();
    L13:
        return r5.asMap();
    L15:
        return Integer.valueOf(r5.asInt());
    L17:
        return Long.valueOf(r5.asLong());
    L19:
        return Boolean.valueOf(r5.asBoolean());
    L21:
        return Double.valueOf(r5.asDouble());
    L23:
        return r5.asString();
    }

    public static Pair d(long r5, String r10, long r11, String r12) {
        if (r11 != 0) goto L10;
        ConcurrentHashMap r13 = com.bytedance.geckox.utils.a.f4787a;
        List r14 = (List) r13.get(r10);
        if (r14 != null) goto L8;
        r14 = new ArrayList();
        r13.put(r10, r14);
    L8:
        if (r14.contains(r12) == true) goto L11;
        r14.add(r12);
    L11:
        ConcurrentHashMap r15 = va.b.f22564a;
        com.bytedance.geckox.c r16 = com.bytedance.geckox.b.f4736a;
        Pair r17 = new Pair(Boolean.FALSE, 0L);
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L16
        Iterator r19 = pa.b.f21323a.iterator();     // Catch: Throwable -> L16
    L14:
        if (r19.hasNext() == false) goto L18;
        pa.a r20 = (pa.a) r19.next();     // Catch: Throwable -> L16
        new GeckoUpdateListener$GeckoParams(r10, r12, r5);     // Catch: Throwable -> L16
        r20.getClass();     // Catch: Throwable -> L16
        goto L14
    L18:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L21:
        com.bytedance.iesgurd.meta.f.c(r10, r12);
        AppSettingsManager$IGeckoAppSettings r21 = com.bytedance.geckox.b.f4736a.a();
        if (r21 == null) goto L24;
        r21.getConfig();
    L24:
        Iterator r22 = com.bytedance.iesgurd.a.f6593a.entrySet().iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        ((com.bytedance.iesgurd.b) ((Map.Entry) r22.next()).getValue()).getClass();
        goto L26
    L28:
        return r17;
    L16:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    L10:
        com.bytedance.geckox.utils.a.b(r10, r12);
        goto L11
    }

    public static JSONObject e(id.c r10, id.a r11) {
        Intrinsics.checkNotNullParameter(r10, "timeStampMap");
        Intrinsics.checkNotNullParameter(r11, "durationMap");
        JSONObject r5 = new JSONObject();
        td.b.f(r5, r11.f852b);
        r5.put("tti_time", r5.optLong("tti"));
        r5.put("lynx_tti_time", r5.optLong("lynx_tti"));
        long r12 = r10.d("draw_end");
        Long r13 = Long.valueOf(r12);
        Long r14 = null;
        if (r12 > 0) goto L6;
        r13 = null;
    L6:
        if (r13 == null) goto L8;
        r5.put("draw_end", r13.longValue());
    L8:
        long r15 = r10.d("update_draw_end");
        Long r16 = Long.valueOf(r15);
        if (r15 <= 0) goto L11;
        r14 = r16;
    L11:
        if (r14 == null) goto L13;
        r5.put("update_draw_end", r14.longValue());
    L13:
        return r5;
    }

    public static JSONObject f(String r5, String r10, Long r11, String r12, Pair r13) {
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L5
        r15.put("access_key", r5);     // Catch: Throwable -> L5
        r15.put(LynxMonitorService.KEY_CHANNEL, r10);     // Catch: Throwable -> L5
        if (r11 != null) goto L7;
        String r16 = "0";
    L8:
        r15.put("id", r16);     // Catch: Throwable -> L5
        r15.put("type", r12);     // Catch: Throwable -> L5
        r15.put("is_blacklist", ((Boolean) r13.getFirst()).booleanValue() ? 1 : 0);     // Catch: Throwable -> L5
        if (((Number) r13.getSecond()).longValue() <= 0) goto L11;
        r15.put("dur_expire_clean_to_access", String.valueOf(((Number) r13.getSecond()).longValue()));     // Catch: Throwable -> L5
    L11:
        r15.put("cold_start_finish", gf.a.f17089b.get());     // Catch: Throwable -> L5
        PrepareMeta r17 = com.bytedance.iesgurd.meta.f.a(r5, r10);     // Catch: Throwable -> L5
        if (r17 == null) goto L14;
        r15.put("prepare_id", r17.getVersion());     // Catch: Throwable -> L5
        r15.put("prepare_block_type", r17.getBlockType());     // Catch: Throwable -> L5
        r15.put("prepare_updating", Intrinsics.areEqual(hf.f.f17318b, r5 + '_' + r10));     // Catch: Throwable -> L5
    L14:
        return r15;
    L7:
        r16 = String.valueOf(r11.longValue());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Throwable r19 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        r19.getClass();
        CopyOnWriteArrayList r20 = GeckoLogger.f4756a;
        if (r20.size() != 0) goto L18;
        GeckoLogger.f4757b.a("gecko-debug-tag", "resource access occurs exception", r19);
        return null;
    L18:
        Iterator r21 = r20.iterator();
    L20:
        if (r21.hasNext() == false) goto L27;
        ((DefaultLogger) ((Logger) r21.next())).a("gecko-debug-tag", "resource access occurs exception", r19);
        goto L20
    L27:
        return null;
    }

    public static v0.e g() {
        return (v0.e) v0.e.f.getValue();
    }

    public static void h(Closeable r5) {
        if (r5 == null) goto L8;
        r5.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void i(IOException r5) {
        Throwable r10 = r5.getCause();
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof ErrnoException) == false) goto L22;
        ErrnoException r11 = (ErrnoException) r10;
        io.reactivex.exceptions.a.i("find errnor " + r11.errno);
        int r12 = r11.errno;
        if (r12 != 2) goto L10;
    L20:
        f3130a = r12;
        return;
    L10:
        if (r12 == 28) goto L20;
        if (r12 != 23) goto L14;
    L16:
        f3130a = r12;
        if (f3131b == true) goto L23;
        f3131b = true;
        NativeTools.k().A();
        return;
    L23:
        return;
    L14:
        if (r12 == 24) goto L16;
        return;
    }

    public static void j(String r10) {
        Object[] r11 = {r10, new e9.a(493), new e9.a(-1), new e9.a(-1)};
        int r5 = e9.b.f16793a;
        e9.b.b(Class.forName("android.os.FileUtils"), "setPermissions", e9.b.c(r11)).invoke(null, e9.b.d(r11));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("JavaCalls", "Meet exception when call Method 'setPermissions' in android.os.FileUtils", e);
    }

    public static void k(String r5, String r10, Long r11, String r12) {
        System.currentTimeMillis();
        ((Executor) com.bytedance.geckox.utils.c.d.getValue()).execute(new com.bytedance.apm.e(r5, r10, r11, r12));
    }

    public static void l(Map r10, id.c r11, id.a r12) {
        Intrinsics.checkNotNullParameter(r11, "timeStampMap");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        if (r10 == null) goto L44;
        HashMap r5 = null;
        if (r10.get(LynxMonitorService.KEY_METRICS) != null) goto L11;
        Object r13 = r10.get(LynxMonitorService.KEY_METRICS);
        if ((r13 instanceof HashMap) == false) goto L9;
        HashMap r14 = (HashMap) r13;
    L10:
        if (r14 != null) goto L11;
    L16:
        if (r10.get("ssr_metrics") != null) goto L22;
        Object r15 = r10.get("ssr_metrics");
        if ((r15 instanceof HashMap) == false) goto L20;
        HashMap r16 = (HashMap) r15;
    L21:
        if (r16 != null) goto L22;
    L27:
        if (r10.get(LynxMonitorService.KEY_SETUP_TIMING) != null) goto L33;
        Object r17 = r10.get(LynxMonitorService.KEY_SETUP_TIMING);
        if ((r17 instanceof HashMap) == false) goto L31;
        HashMap r18 = (HashMap) r17;
    L32:
        if (r18 != null) goto L33;
    L35:
        if (r10.get("ssr_render_page_timing") != null) goto L40;
        Object r19 = r10.get("ssr_render_page_timing");
        if ((r19 instanceof HashMap) == false) goto L39;
        r5 = (HashMap) r19;
    L39:
        if (r5 != null) goto L40;
        return;
    L40:
        Object r20 = r10.get("ssr_render_page_timing");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r21 = (HashMap) r20;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        JSONObject r22 = new JSONObject(r21);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r22, "jsonObject");
        td.b.f(r11.f852b, r22);
        r12.a("render_page_ssr", Long.valueOf(a("render_page_start_ssr", "render_page_end_ssr", r21)));
        r12.a("layout_ssr", Long.valueOf(a("layout_start_ssr", "layout_end_ssr", r21)));
        r12.a("create_vdom_ssr", Long.valueOf(a("create_vdom_start_ssr", "create_vdom_end_ssr", r21)));
        r12.a("dispatch_ssr", Long.valueOf(a("dispatch_start_ssr", "dispatch_end_ssr", r21)));
        r12.a("ui_operation_flush_ssr", Long.valueOf(a("ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr", r21)));
        r12.a("decode_ssr", Long.valueOf(a("decode_start_ssr", "decode_end_ssr", r21)));
        return;
    L31:
        r18 = null;
    L33:
        Object r23 = r10.get(LynxMonitorService.KEY_SETUP_TIMING);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r24 = (HashMap) r23;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        JSONObject r25 = new JSONObject(r24);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r25, "jsonObject");
        td.b.f(r11.f852b, r25);
        r12.a("create_lynx", Long.valueOf(a("create_lynx_start", "create_lynx_end", r24)));
        r12.a("load_core", Long.valueOf(a("load_core_start", "load_core_end", r24)));
        r12.a("decode", Long.valueOf(a("decode_start", "decode_end", r24)));
        r12.a("lepus_execute", Long.valueOf(a("lepus_excute_start", "lepus_excute_end", r24)));
        r12.a("create_vdom", Long.valueOf(a("create_vdom_start", "create_vdom_end", r24)));
        r12.a("dispatch", Long.valueOf(a("dispatch_start", "dispatch_end", r24)));
        r12.a("layout", Long.valueOf(a("layout_start", "layout_end", r24)));
        r12.a("ui_operation_flush", Long.valueOf(a("ui_operation_flush_start", "ui_operation_flush_end", r24)));
        r12.a("load_app", Long.valueOf(a("load_app_start", "load_app_end", r24)));
        r12.a("load_template", Long.valueOf(a("load_template_start", "load_template_end", r24)));
        goto L35
    L20:
        r16 = null;
    L22:
        Object r26 = r10.get("ssr_metrics");
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r27 = (HashMap) r26;
        Iterator r28 = r27.keySet().iterator();
    L24:
        if (r28.hasNext() == false) goto L27;
        String r29 = (String) r28.next();
        Object r30 = r27.get(r29);
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r29, (Long) r30);
        goto L24
    L9:
        r14 = null;
    L11:
        Object r31 = r10.get(LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r32 = (HashMap) r31;
        Iterator r33 = r32.keySet().iterator();
    L13:
        if (r33.hasNext() == false) goto L16;
        String r34 = (String) r33.next();
        Object r35 = r32.get(r34);
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r34, (Long) r35);
        goto L13
    }

    public static void m(Map r5, Map r10, id.c r11, id.a r12) {
        Intrinsics.checkNotNullParameter(r11, "timeStampMap");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        if (r5 != null) goto L5;
    L15:
        if (r10 == null) goto L21;
        Long r13 = (Long) r10.get("draw_end");
        if (r13 == null) goto L22;
        r11.a("update_draw_end", Long.valueOf(r13.longValue()));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r5.get(LynxMonitorService.KEY_METRICS) != null) goto L11;
        Object r14 = r5.get(LynxMonitorService.KEY_METRICS);
        if ((r14 instanceof HashMap) == false) goto L9;
        HashMap r15 = (HashMap) r14;
    L10:
        if (r15 == null) goto L15;
    L9:
        r15 = null;
    L11:
        Object r16 = r5.get(LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r17 = (HashMap) r16;
        Iterator r18 = r17.keySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        String r19 = (String) r18.next();
        Object r20 = r17.get(r19);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r19, (Long) r20);
        goto L13
    }

    public static boolean n() {
        int r5 = f3130a;
        if (r5 != 28) goto L5;
        return true;
    L5:
        if (r5 != 2) goto L7;
        return true;
    L7:
        if (f3132c == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static String o(String[] r5) {
        StringBuilder r10 = new StringBuilder(400);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(r5[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public static void p(LinkedList r5, d6.f r10) {
        if (j.f3887a == false) goto L6;
        Log.v("TraceDataUtils", "method:" + r10);
    L6:
        if (r5.isEmpty() == true) goto L8;
        d6.f r11 = (d6.f) r5.peek();
    L9:
        if (r11 != null) goto L11;
    L20:
        r5.push(r10);
        return;
    L11:
        if (r11.f16608a != r10.f16608a) goto L20;
        int r12 = r11.d;
        int r13 = r10.d;
        if (r12 != r13) goto L20;
        if (r13 == 0) goto L20;
        int r14 = r10.f16609b;
        if (r14 != 5000) goto L18;
        r14 = r11.f16609b;
    L18:
        r10.f16609b = r14;
        r11.e++;
        r11.f16609b = (int) (r11.f16609b + ((long) r14));
        return;
    L8:
        r11 = null;
        goto L9
    }

    public static void q(Map r5, Map r10, id.c r11, id.a r12) {
        Intrinsics.checkNotNullParameter(r11, "timeStampMap");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        HashMap r13 = null;
        if (r5 == null) goto L16;
        if (r5.get(LynxMonitorService.KEY_METRICS) != null) goto L11;
        Object r14 = r5.get(LynxMonitorService.KEY_METRICS);
        if ((r14 instanceof HashMap) == false) goto L9;
        HashMap r15 = (HashMap) r14;
    L10:
        if (r15 == null) goto L16;
    L9:
        r15 = null;
    L11:
        Object r16 = r5.get(LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r17 = (HashMap) r16;
        Iterator r18 = r17.keySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L16;
        String r19 = (String) r18.next();
        Object r20 = r17.get(r19);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r19, (Long) r20);
    L16:
        if ((r10 instanceof HashMap) == false) goto L18;
        r13 = (HashMap) r10;
    L18:
        if (r13 == null) goto L27;
        Iterator r21 = r13.keySet().iterator();
    L21:
        if (r21.hasNext() == false) goto L23;
        String r22 = (String) r21.next();
        Object r23 = r13.get(r22);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Long");
        r11.a(r22, (Long) r23);
        goto L21
    L23:
        r12.a("create_vdom", Long.valueOf(a("create_vdom_start", "create_vdom_end", r13)));
        r12.a("dispatch", Long.valueOf(a("dispatch_start", "dispatch_end", r13)));
        r12.a("layout", Long.valueOf(a("layout_start", "layout_end", r13)));
        r12.a("ui_operation_flush", Long.valueOf(a("ui_operation_flush_start", "ui_operation_flush_end", r13)));
        return;
    }

    public static void r(boolean r5, String r10, Object... r11) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r10, r11));
    }

    public static void s(Object r5, String r10, Object... r11) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(String.format(r10, r11));
    }

    public static void t(boolean r5, String r10, Object... r11) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r10, r11));
    }

    public static int u(long r5) {
        return (int) ((r5 >> 43) & 1048575);
    }

    public static String v(LinkedList r10, long r11) {
        StringBuilder r5 = new StringBuilder();
        long r12 = (long) (r11 * 0.3f);
        LinkedList r13 = new LinkedList();
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        d6.f r15 = (d6.f) r14.next();
        if (r15.f16609b < r12) goto L4;
        r13.add(r15);
        goto L4
    L8:
        Collections.sort(r13, new org.threeten.bp.format.c(4));
        if (r13.isEmpty() == false) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r13.add((d6.f) r10.get(0));
    L18:
        Iterator r16 = r13.iterator();
        if (r16.hasNext() == false) goto L22;
        r5.append(((d6.f) r16.next()).f16608a + "\n");
    L22:
        return r5.toString();
    L14:
        if (r13.size() <= 1) goto L18;
        if (((d6.f) r13.peek()).f16608a != 1048574) goto L18;
        r13.removeFirst();
        goto L18
    }

    public static void w(Object... r5) {
        JSONObject r10 = new JSONObject();
        int r11 = r5.length;
        if ((r11 % 2) != 0) goto L13;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        r10.put(String.valueOf(r5[r12]), String.valueOf(r5[r12 + 1]));     // Catch: JSONException -> L8
        r12 = r12 + 2;
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        Log.i("<monitor><flow>", o(new String[]{r10.toString()}));
        return;
    L13:
        throw new IllegalArgumentException();
    }

    public static List x(Collection r5) {
        return Collections.unmodifiableList(new ArrayList(r5));
    }

    public static Set y(Collection r5) {
        return Collections.unmodifiableSet(new LinkedHashSet(r5));
    }

    public static boolean z(long r5) {
        if (((r5 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }
}
