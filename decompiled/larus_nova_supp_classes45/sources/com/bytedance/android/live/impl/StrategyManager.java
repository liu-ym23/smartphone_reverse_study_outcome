package com.bytedance.android.live.impl;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.impl.monitor.StrategyTracingMonitor;
import com.bytedance.android.live.impl.processor.BaseFactorProcessor;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.impl.timer.TaskManager;
import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombineBaseInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.StrategyInitObserver;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyInitConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.d3;
import j40.e3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StrategyManager {
    public static Strategy a;
    public static final Map<String, BaseFactorProcessor> b = null;
    public static final com.bytedance.android.live.impl.processor.b c = null;
    public static final Map<String, Object> d = null;
    public static final Set<String> e = null;
    public static long f;
    public static long g;
    public static final Set<String> h = null;
    public static final List<StrategyInitObserver> i = null;
    public static volatile boolean j;
    public static volatile boolean k;
    public static volatile boolean l;
    public static volatile boolean m;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final StrategyManager s = null;

    public static final class a<V> implements Callable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            StrategyManager r0 = StrategyManager.s;
            monitor-enter(r0);
            ALogger.i("strategy_tag", "factors scan start");     // Catch: Throwable -> L58
            if (StrategyManager.m == false) goto L8;
            monitor-exit(r0);
            return;
        L8:
            Set<String> r1 = StrategyManager.e;     // Catch: Throwable -> L58
            Strategy r2 = StrategyManager.a;     // Catch: Throwable -> L58
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("strategy");     // Catch: Throwable -> L58
        L11:
            ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r3 = null;
            if (r2 == null) goto L14;
            CopyOnWriteArrayList<CombineInfo> r4 = r2.getCombineStrategys();     // Catch: Throwable -> L58
        L15:
            if (r4 == null) goto L29;
            Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L58
        L18:
            if (r5.hasNext() == false) goto L29;
            CopyOnWriteArrayList r6 = ((CombineInfo) r5.next()).getFaList();     // Catch: Throwable -> L58
            if (r6 == null) goto L18;
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L58
        L23:
            if (r7.hasNext() == false) goto L18;
            CombbineFactorInfo r8 = (CombbineFactorInfo) r7.next();     // Catch: Throwable -> L58
            if (r8 == null) goto L23;
            String r9 = r8.getFaName();     // Catch: Throwable -> L58
            if (r9 == null) goto L23;
            r1.add(r9);     // Catch: Throwable -> L58
        L29:
            Strategy r11 = StrategyManager.a;     // Catch: Throwable -> L58
            if (r11 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("strategy");     // Catch: Throwable -> L58
        L32:
            if (r11 == null) goto L34;
            r3 = r11.getAbInfos();     // Catch: Throwable -> L58
        L34:
            if (r3 == null) goto L55;
            Iterator<Map.Entry<String, CopyOnWriteArrayList<CombineInfo>>> r12 = r3.entrySet().iterator();     // Catch: Throwable -> L58
        L37:
            if (r12.hasNext() == false) goto L55;
            CopyOnWriteArrayList<CombineInfo> r13 = r12.next().getValue();     // Catch: Throwable -> L58
            if (r13 == null) goto L37;
            Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L58
        L42:
            if (r14.hasNext() == false) goto L37;
            CombineInfo r15 = (CombineInfo) r14.next();     // Catch: Throwable -> L58
            if (r15 == null) goto L42;
            CopyOnWriteArrayList r16 = r15.getFaList();     // Catch: Throwable -> L58
            if (r16 == null) goto L42;
            Iterator r17 = r16.iterator();     // Catch: Throwable -> L58
        L49:
            if (r17.hasNext() == false) goto L42;
            CombbineFactorInfo r18 = (CombbineFactorInfo) r17.next();     // Catch: Throwable -> L58
            if (r18 == null) goto L49;
            String r19 = r18.getFaName();     // Catch: Throwable -> L58
            if (r19 == null) goto L49;
            r1.add(r19);     // Catch: Throwable -> L58
        L55:
            StrategyManager.m = true;     // Catch: Throwable -> L58
            monitor-exit(r0);
            return;
        L14:
            r4 = null;
        L58:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            ALogger.i("strategy_tag", "factors scan finish");
        }
    }

    public StrategyManager() {
    }

    public static StrategyInitConfig f() {
        return (StrategyInitConfig) q.getValue();
    }

    static {
        s = new StrategyManager();
        b = new LinkedHashMap();
        c = new com.bytedance.android.live.impl.processor.b();
        d = new ConcurrentHashMap();
        e = new LinkedHashSet();
        f = -1;
        g = -1;
        h = new LinkedHashSet();
        i = new ArrayList();
        l = true;
        n = LazyKt.lazy(StrategyManager$sdkEnable$2.INSTANCE);
        o = LazyKt.lazy(StrategyManager$strategySettingEnable$2.INSTANCE);
        p = LazyKt.lazy(StrategyManager$logOnlyInDebug$2.INSTANCE);
        q = LazyKt.lazy(StrategyManager$initStrategyConfig$2.INSTANCE);
        r = LazyKt.lazy(StrategyManager$whiteFactorList$2.INSTANCE);
    }

    public final void g() {
        if (((Boolean) n.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (j == false) goto L11;
        if (k == true) goto L11;
        return;
    L11:
        if (l == true) goto L13;
        return;
    L13:
        l = false;
        f = System.currentTimeMillis() - k.n(IUtilsCommonService.class).startTimeOfSDKInitTracer();
        g = System.currentTimeMillis();
        int r1 = oa0.a.a;     // Catch: Exception -> L25
        oa0.a.c(new StrategyManager$init$1(this));     // Catch: Exception -> L25
        Iterator r2 = ((ConcurrentHashMap) d).entrySet().iterator();     // Catch: Exception -> L25
    L16:
        if (r2.hasNext() == false) goto L24;
        Object r3 = ((Map.Entry) r2.next()).getValue();     // Catch: Exception -> L25
        if (r3 == null) goto L23;
        if (((StrategyMutableLiveData) r3).hasActiveObservers() == true) goto L16;
        r2.remove();     // Catch: Exception -> L25
        goto L16
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");     // Catch: Exception -> L25
    L24:
        return;
    L25:
        e = move-exception;
        ALogger.w("strategy_tag", e.getMessage(), e);
        j = false;
        Lazy r0 = StrategyTracingMonitor.a;
        StrategyTracingMonitor.a(c(this, -1, 0, String.valueOf(e.getMessage()), 2));
        Iterator r4 = ((ArrayList) i).iterator();
    L28:
        if (r4.hasNext() == false) goto L30;
        ((StrategyInitObserver) r4.next()).onFailed();
        goto L28
    }

    public static boolean b() {
        if (v.a() == false) goto L5;
        return true;
    L5:
        if (v.a() == false) goto L7;
        return false;
    L7:
        if (((Boolean) p.getValue()).booleanValue() == false) goto L14;
        return false;
    L14:
        return true;
    }

    public static final void a(StrategyManager r4, String r5) {
        r4.getClass();
        if (b() == false) goto L5;
        ALogger.i("strategy_tag", "updateCharacter chName " + r5);
    L5:
        Strategy r6 = a;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L8:
        if (r6 == null) goto L10;
        List<String> r7 = r6.getFactorsByChName(r5);
    L11:
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L32;
        List r9 = CollectionsKt.distinct(r7);
        if (r9 == null) goto L46;
        Iterator r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L47;
        String r0 = (String) r11.next();
        ConcurrentHashMap r1 = (ConcurrentHashMap) d;
        if (r1.containsKey(r0) == false) goto L17;
        if (r1.get(r0) == null) goto L17;
        Object r2 = r1.get(r0);
        if (r2 == null) goto L31;
        StrategyMutableLiveData<Object> r3 = (StrategyMutableLiveData) r2;
        Map<String, BaseFactorProcessor> r12 = b;
        if (r12.containsKey(r0) == true) goto L26;
        c.update(r0, r3, r8, k);
        goto L17
    L26:
        BaseFactorProcessor r13 = (BaseFactorProcessor) ((LinkedHashMap) r12).get(r0);
        if (r13 == null) goto L17;
        r13.update(r0, r3, r8, k);
        goto L17
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L47:
        return;
    L46:
        return;
    L32:
        return;
    L10:
        r7 = null;
        goto L11
    }

    public static void i(List r11, boolean r12) {
        if (b() == false) goto L5;
        ALogger.i("strategy_tag", "updateCharacter " + r11);
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        if (r11 == null) goto L17;
        Iterator r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L17;
        String r2 = (String) r13.next();
        Strategy r3 = a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L13:
        if (r3 == null) goto L9;
        List<String> r4 = r3.getFactorsByChName(r2);
        if (r4 == null) goto L9;
        r1.addAll(r4);
    L17:
        List r14 = CollectionsKt.distinct(r1);
        if (r14 == null) goto L43;
        Iterator r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L69;
        String r5 = (String) r15.next();
        ConcurrentHashMap r6 = (ConcurrentHashMap) d;
        if (r6.containsKey(r5) == false) goto L21;
        if (r6.get(r5) == null) goto L21;
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        Object r8 = r6.get(r5);
        if (r8 == null) goto L42;
        r7.element = (StrategyMutableLiveData) r8;
        if (d3.a.getValue().booleanValue() == false) goto L35;
        if (r12 == false) goto L34;
        if (ArraysKt.contains(e3.a.getValue(), r5) == true) goto L35;
    L34:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StrategyManager$updateCharacter$$inlined$forEach$lambda$1(r5, r7, null, r12, r0), 3, null);
    L35:
        Map<String, BaseFactorProcessor> r9 = b;
        if (r9.containsKey(r5) == true) goto L37;
        c.update(r5, (StrategyMutableLiveData) r7.element, (Map) r0.element, k);
        goto L21
    L37:
        BaseFactorProcessor r16 = (BaseFactorProcessor) ((LinkedHashMap) r9).get(r5);
        if (r16 == null) goto L21;
        r16.update(r5, (StrategyMutableLiveData) r7.element, (Map) r0.element, k);
        goto L21
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L69:
        return;
    }

    public final void h(Strategy r12, boolean r13) {
        long r0 = System.currentTimeMillis();
        if (r12 != null) goto L5;
        return;
    L5:
        a = r12;
        if (r13 == true) goto L11;
        int r2 = oa0.a.a;
        Strategy r3 = a;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L10:
        oa0.a.d(r3);
    L11:
        Strategy r4 = a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L14:
        if (r4 == null) goto L16;
        r4.clearCache();
    L16:
        Strategy r5 = a;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L20:
        if (r5 == null) goto L32;
        CopyOnWriteArrayList<CombineInfo> r6 = r5.getCombineStrategys();
        if (r6 == null) goto L32;
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L25:
        if (r7.hasNext() == false) goto L32;
        CombineInfo r9 = (CombineInfo) r7.next();
        CombineBaseInfo r11 = r9.getCombineBaseInfo();
        if (r11 == null) goto L29;
        StringBuilder r14 = new StringBuilder();
        r14.append(r8);
        r14.append("_online");
        r11.setCombineInfoId(r14.toString());
        r8 = r8 + 1;
    L29:
        CombineBaseInfo r15 = r9.getCombineBaseInfo();
        if (r15 == null) goto L25;
        r15.setCurrentStrategyState(1);
    L32:
        Strategy r16 = a;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L36:
        if (r16 == null) goto L40;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r17 = r16.getAbInfos();
        if (r17 == null) goto L40;
        Set<String> r18 = r17.keySet();
    L41:
        if (r18 == null) goto L75;
        Iterator<T> r19 = r18.iterator();
    L44:
        if (r19.hasNext() == false) goto L75;
        String r21 = (String) r19.next();
        Strategy r22 = a;
        if (r22 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L48:
        if (r22 == null) goto L52;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r23 = r22.getAbInfos();
        if (r23 == null) goto L52;
        CopyOnWriteArrayList<CombineInfo> r24 = r23.get(r21);
    L54:
        if (StringsKt.contains$default(r21, "_mock", false, 2, null) == true) goto L55;
        if (r24 == null) goto L44;
        Iterator<T> r25 = r24.iterator();
    L68:
        if (r25.hasNext() == false) goto L44;
        CombineInfo r26 = (CombineInfo) r25.next();
        CombineBaseInfo r110 = r26.getCombineBaseInfo();
        if (r110 == null) goto L72;
        r110.setCombineInfoId(r21);
    L72:
        CombineBaseInfo r27 = r26.getCombineBaseInfo();
        if (r27 == null) goto L68;
        r27.setCurrentStrategyState(2);
        goto L68
    L55:
        if (r24 == null) goto L44;
        Iterator<T> r28 = r24.iterator();
    L58:
        if (r28.hasNext() == false) goto L44;
        CombineInfo r29 = (CombineInfo) r28.next();
        CombineBaseInfo r31 = r29.getCombineBaseInfo();
        if (r31 == null) goto L62;
        r31.setCombineInfoId(r21);
    L62:
        CombineBaseInfo r32 = r29.getCombineBaseInfo();
        if (r32 == null) goto L58;
        r32.setCurrentStrategyState(3);
    L52:
        r24 = null;
    L75:
        Strategy r33 = a;
        if (r33 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L78:
        if (r33 == null) goto L93;
        ConcurrentHashMap<String, CopyOnWriteArrayList<CombineInfo>> r34 = r33.getAbInfos();
        if (r34 == null) goto L93;
        Collection<CopyOnWriteArrayList<CombineInfo>> r35 = r34.values();
        if (r35 == null) goto L93;
        Iterator<T> r36 = r35.iterator();
    L85:
        if (r36.hasNext() == false) goto L93;
        CopyOnWriteArrayList r37 = (CopyOnWriteArrayList) r36.next();
        Strategy r38 = a;
        if (r38 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L89:
        if (r38 == null) goto L85;
        CopyOnWriteArrayList<CombineInfo> r39 = r38.getCombineStrategys();
        if (r39 == null) goto L85;
        r39.addAll(0, r37);
    L93:
        boolean r41 = AotuCharacterHandler.a;
        Strategy r42 = a;
        if (r42 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L96:
        AotuCharacterHandler.b = r42.getChList();
        Strategy r43 = a;
        if (r43 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L99:
        Set r44 = ((LinkedHashMap) b).keySet();
        if (r44 == null) goto L112;
        Iterator r45 = r44.iterator();
    L103:
        if (r45.hasNext() == false) goto L112;
        String r46 = (String) r45.next();
        if (r43 == null) goto L107;
        List<CombineInfo> r47 = r43.getCombineInfosByFaName(r46);
    L108:
        if (r47 == null) goto L103;
        BaseFactorProcessor r48 = (BaseFactorProcessor) ((LinkedHashMap) b).get(r46);
        if (r48 == null) goto L103;
        r48.e(r47);
        goto L103
    L107:
        r47 = null;
    L112:
        com.bytedance.android.live.impl.processor.b r49 = c;
        if (r43 == null) goto L136;
        CopyOnWriteArrayList<CombineInfo> r51 = r43.getCombineStrategys();
        if (r51 == null) goto L136;
        ArrayList r52 = new ArrayList();
        Iterator<T> r53 = r51.iterator();
    L118:
        if (r53.hasNext() == false) goto L137;
        Object r54 = r53.next();
        CombineInfo r55 = (CombineInfo) r54;
        if (r55 == null) goto L133;
        CopyOnWriteArrayList r56 = r55.getFaList();
        if (r56 == null) goto L133;
        if (r56.isEmpty() == true) goto L132;
        Iterator r57 = r56.iterator();
    L128:
        if (r57.hasNext() == false) goto L132;
        if ((!b.containsKey(((CombbineFactorInfo) r57.next()).getFaName())) == true) goto L128;
    L132:
        boolean r58 = true;
    L134:
        if (r58 == false) goto L118;
        r52.add(r54);
    L133:
        r58 = false;
    L137:
        r49.e(r52);
        j = true;
        Lazy r59 = TaskManager.a;
        Strategy r61 = a;
        if (r61 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L140:
        TaskManager.b(r61);
        if (f().getEnableInitOpt() == false) goto L143;
        TaskManager.c(new StrategyManager$initSource$2(this));
        boolean r111 = AotuCharacterHandler.a;
        AotuCharacterHandler.b(new StrategyManager$initSource$3(this), new StrategyManager$initSource$4(this));
    L143:
        long r62 = System.currentTimeMillis() - r0;
        k = r13;
        Lazy r112 = StrategyTracingMonitor.a;
        StrategyTracingMonitor.a(c(this, 0, r62, null, 4));
        Iterator r113 = ((ArrayList) i).iterator();
    L145:
        if (r113.hasNext() == false) goto L148;
        ((StrategyInitObserver) r113.next()).onSuccess(r13);
        goto L145
    L148:
        if (((Boolean) o.getValue()).booleanValue() == false) goto L197;
        Observable.fromCallable(a.a).subscribeOn(Schedulers.io()).subscribe(b.a);
        return;
    L197:
        return;
    L136:
        r52 = new ArrayList();
    L40:
        r18 = null;
        goto L41
    }

    public final Object e(String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r11, "faName");
        Intrinsics.checkNotNullParameter(r12, "anchorId");
        if (((Boolean) n.getValue()).booleanValue() == true) goto L5;
    L30:
        return r13;
    L5:
        if (j == false) goto L30;
        if (f().getEnableInitOpt() == true) goto L10;
        Lazy r0 = TaskManager.a;
        TaskManager.c(new StrategyManager$getFactor$4(this));
        boolean r1 = AotuCharacterHandler.a;
        AotuCharacterHandler.a(new StrategyManager$getFactor$5(this), new StrategyManager$getFactor$6(this));
    L10:
        StrategyMutableLiveData r2 = new StrategyMutableLiveData();
        LinkedHashMap r7 = new LinkedHashMap();
        Map<String, BaseFactorProcessor> r3 = b;
        if (r3.containsKey(r11) == false) goto L15;
        BaseFactorProcessor r4 = (BaseFactorProcessor) ((LinkedHashMap) r3).get(r11);
        if (r4 == null) goto L17;
        r4.c(r11, r12, r13, r2, r7, k);
    L17:
        if (l == false) goto L22;
        if (f().getEnableInitOpt() == true) goto L22;
        g();
    L22:
        if ((!Intrinsics.areEqual(r2.getValue(), r13)) == false) goto L29;
        String[] r14 = (String[]) r.getValue();
        if (r14 == null) goto L29;
        if (ArraysKt.contains(r14, r11) != true) goto L29;
        StrategyTeaLogHelper.e(r11);
    L29:
        return r2.getValue();
    L15:
        c.c(r11, r12, r13, r2, r7, k);
        goto L17
    }

    public final <T> LiveData<T> d(String r12, T r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "faName");
        if (((Boolean) n.getValue()).booleanValue() == true) goto L10;
        ConcurrentHashMap r16 = (ConcurrentHashMap) d;
        Object r17 = r16.get(r12);
        if (r17 != null) goto L67;
        StrategyMutableLiveData r18 = new StrategyMutableLiveData();
        r18.setValue(r13);
        r16.put(r12, r18);
        return r18;
    L67:
        return (LiveData) r17;
    L10:
        if (j == true) goto L21;
        if (f().getEnableStrategyInitCache() == false) goto L17;
        boolean r0 = f().getEnableUseSliceStrategy();
        f = System.currentTimeMillis() - k.n(IUtilsCommonService.class).startTimeOfSDKInitTracer();
        Strategy r1 = oa0.a.a(r0);
        if (r1 == null) goto L17;
        s.h(r1, true);
        ALogger.i("strategy_tag", "Use SP cache");
    L17:
        if (j == true) goto L21;
        ALogger.i("strategy_tag", "strategy disable");
        StrategyMutableLiveData r19 = new StrategyMutableLiveData();
        r19.setValue(r13);
        return r19;
    L21:
        if (f().getEnableInitOpt() == true) goto L23;
        Lazy r2 = TaskManager.a;
        TaskManager.c(new StrategyManager$getFactor$1(this));
        boolean r3 = AotuCharacterHandler.a;
        AotuCharacterHandler.a(new StrategyManager$getFactor$2(this), new StrategyManager$getFactor$3(this));
    L23:
        ConcurrentHashMap r4 = (ConcurrentHashMap) d;
        if (r4.containsKey(r12) == false) goto L31;
        if (r15 == false) goto L31;
        Object r110 = r4.get(r12);
        if (r110 == null) goto L30;
        LiveData<T> r111 = (LiveData) r110;
    L52:
        if (l == true) goto L54;
    L56:
        if (r14 == true) goto L58;
    L64:
        return r111;
    L58:
        if ((!Intrinsics.areEqual(r111, r13)) == false) goto L64;
        String[] r112 = (String[]) r.getValue();
        if (r112 == null) goto L64;
        if (ArraysKt.contains(r112, r12) != true) goto L64;
        StrategyTeaLogHelper.e(r12);
        goto L64
    L54:
        if (f().getEnableInitOpt() == true) goto L56;
        g();
        goto L56
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L31:
        StrategyMutableLiveData r113 = new StrategyMutableLiveData();
        LinkedHashMap r9 = new LinkedHashMap();
        Map<String, BaseFactorProcessor> r5 = b;
        if (r5.containsKey(r12) == false) goto L36;
        BaseFactorProcessor r6 = (BaseFactorProcessor) ((LinkedHashMap) r5).get(r12);
        if (r6 == null) goto L38;
        r6.c(r12, null, r13, r113, r9, k);
    L38:
        if (r4.containsKey(r12) == false) goto L48;
        Object r7 = r4.get(r12);
        if (r7 == null) goto L47;
        ((StrategyMutableLiveData) r7).setValue(r113.getValue());
        Object r114 = r4.get(r12);
        if (r114 == null) goto L45;
        r111 = (LiveData) r114;
        goto L52
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<T>");
    L48:
        r4.put(r12, r113);
        Object r115 = r4.get(r12);
        if (r115 == null) goto L66;
        r111 = (LiveData) r115;
        goto L52
    L66:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<T>");
    L36:
        c.c(r12, null, r13, r113, r9, k);
        goto L38
    }

    public static Map c(StrategyManager r4, int r5, long r6, String r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r6 = -1;
    L5:
        String r0 = "";
        if ((r9 & 4) == 0) goto L8;
        r8 = "";
    L8:
        r4.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        if (r5 != 0) goto L17;
        Strategy r11 = a;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L13:
        String r12 = r11.getId();
        if (r12 == null) goto L17;
        r0 = r12;
    L17:
        r7.put("strategy_id", r0);
        r7.put("init_duration", String.valueOf(System.currentTimeMillis() - k.n(IUtilsCommonService.class).startTimeOfSDKInitTracer()));
        r7.put("init_by_cache", String.valueOf(k));
        r7.put("fetch_result", String.valueOf(oa0.a.a));
        r7.put("init_result", String.valueOf(r5));
        r7.put("fetch_msg", oa0.a.b);
        r7.put("init_msg", r8);
        r7.put("strategy_fetch_time", String.valueOf(oa0.a.c));
        r7.put("json_parse_time", String.valueOf(oa0.a.d));
        r7.put("init_source_time", String.valueOf(r6));
        r7.put("trigger_init_duration", String.valueOf(f));
        if (k == true) goto L20;
        String r13 = String.valueOf(System.currentTimeMillis() - g);
    L21:
        r7.put("init_function_time", r13);
        return r7;
    L20:
        r13 = "-1";
        goto L21
    }
}
