package com.bytedance.android.live.impl.processor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.strategy.api.CombbineFactorInfo;
import com.bytedance.android.live.strategy.api.CombineBaseInfo;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseFactorProcessor {
    public final String a;
    public List<CombineInfo> b;
    public final ma0.a c;
    public final List<sb1.a> d;
    public final Map<String, Long> e;
    public final Map<String, Long> f;
    public final na0.a g;
    public final Map<String, Object> h;
    public final Lazy i;
    public final Lazy j;
    public volatile boolean k;
    public final Map<String, List<CombineInfo>> l;

    public abstract LiveData f(CombineInfo r1, LiveData r2);

    public BaseFactorProcessor() {
        this.a = "BaseFactorProcessor";
        this.c = new ma0.a();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new na0.a();
        new ConcurrentHashMap();
        this.h = new LinkedHashMap();
        this.i = LazyKt.lazy(BaseFactorProcessor$updateReportEnable$2.INSTANCE);
        this.j = LazyKt.lazy(BaseFactorProcessor$logOnlyInDebug$2.INSTANCE);
        this.l = new LinkedHashMap();
    }

    public final boolean a() {
        if (v.a() == false) goto L5;
        return true;
    L5:
        if (v.a() == false) goto L7;
        return false;
    L7:
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L14;
        return false;
    L14:
        return true;
    }

    public final Object b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chName");
        Object r0 = com.bytedance.android.live.impl.a.a(r4);
        if (a() == false) goto L5;
        ALogger.i("strategy_tag", "curent character " + r4 + " is " + r0);
    L5:
        return r0;
    }

    public final void e(List<CombineInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "combineInfos");
        this.b = r2;
        ((LinkedHashMap) this.e).clear();
        ((LinkedHashMap) this.f).clear();
        ((LinkedHashMap) this.h).clear();
        ((LinkedHashMap) this.l).clear();
        StrategyTeaLogHelper.a.clear();
        List<sb1.a> r3 = this.d;
        ArrayList r4 = (ArrayList) r3;
        if (r4.contains(this.g) == true) goto L5;
        List<sb1.a> r5 = this.d;
        ArrayList r6 = (ArrayList) r5;
        r6.add(this.g);
    L5:
        this.k = true;
    }

    public void update(String r9, StrategyMutableLiveData<Object> r11, Map<String, Object> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "faName");
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r12, "characterCache");
        if (r11.getValue() != null) goto L5;
        return;
    L5:
        Object r4 = r11.getValue();
        Intrinsics.checkNotNull(r4);
        StrategyMutableLiveData r14 = c(r9, null, r4, r11, r12, r13);
        if (r14 == null) goto L9;
        r14.getValue();
        return;
    }

    public final void g(String r4, String r5, Object r6, StrategyMutableLiveData<Object> r7, boolean r8) {
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r8 == true) goto L8;
        Object r1 = r7.getValue();
    L9:
        if (r1 != null) goto L11;
    L13:
        if (r8 == false) goto L16;
        this.h.put(r4 + '|' + r5, r6);
    L16:
        if (r7.hasActiveObservers() == true) goto L18;
        return;
    L18:
        if (a() == false) goto L20;
        ALogger.i(this.a, "update log send faName:" + r4 + ",combineId:" + r5);
    L20:
        ConcurrentHashMap<String, Map<String, String>> r9 = StrategyTeaLogHelper.a;
        Intrinsics.checkNotNullParameter(r4, "faName");
        Intrinsics.checkNotNullParameter(r5, "strategyId");
        Map<String, String> r11 = StrategyTeaLogHelper.a.get(r4 + '|' + r5);
        if (r11 != null) goto L23;
        return;
    L23:
        if (StrategyTeaLogHelper.c(r11, r4) == false) goto L38;
        IRoomContextService r12 = k.f(IRoomContextService.class);
        Class r13 = null;
        if (r12 == null) goto L31;
        o r14 = IRoomContextService.a.a(r12, null, 0, 3);
        if (r14 == null) goto L31;
        r13 = r14.Q2();
    L31:
        if (((Boolean) StrategyTeaLogHelper.f.getValue()).booleanValue() == false) goto L33;
        j0.l().o("livesdk_live_strategy_info", r11, new Object[]{r13});
        return;
    L33:
        j0.l().sendLog("livesdk_live_strategy_info", r11, new Object[]{r13});
        return;
    L38:
        return;
    L11:
        if (Intrinsics.areEqual(r1, r6) == false) goto L13;
        return;
    L8:
        r1 = ((LinkedHashMap) this.h).get(r4 + '|' + r5);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized StrategyMutableLiveData c(final String r28, final String r29, final Object r31, final StrategyMutableLiveData r32, final Map r33, final boolean r34) {
        String r0 = r28;
        StrategyMutableLiveData r13 = r32;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r0, "faName");     // Catch: Throwable -> L196
        Intrinsics.checkNotNullParameter(r13, "data");     // Catch: Throwable -> L196
        Intrinsics.checkNotNullParameter(r33, "characterCache");     // Catch: Throwable -> L196
        Boolean r11 = null;
        if (this.k == false) goto L194;
        final long r16 = System.currentTimeMillis();     // Catch: Throwable -> L196
        StrategyMutableLiveData r12 = new ArrayList();     // Catch: Exception -> L188 Throwable -> L196
        final Ref.ObjectRef r9 = new Ref.ObjectRef();     // Catch: Exception -> L188 Throwable -> L196
        r9.element = null;     // Catch: Exception -> L188 Throwable -> L196
        if (this.l.containsKey(r0) == false) goto L10;
        r9.element = (List) ((LinkedHashMap) this.l).get(r0);     // Catch: Exception -> L188 Throwable -> L196
    L38:
        List r1 = (List) r9.element;     // Catch: Exception -> L188 Throwable -> L196
        if (r1 != null) goto L200;
    L181:
        String r14 = r0;
        StrategyMutableLiveData r15 = r13;
        if (a() == false) goto L185;
        ALogger.i("strategy_tag", "No strategy data or op matches " + r14 + ' ');     // Catch: Throwable -> L196
    L185:
        r15.setValue(r31);     // Catch: Throwable -> L196
        monitor-exit(this);
        return r15;
    L200:
        Iterator r21 = r1.iterator();     // Catch: Exception -> L178 Throwable -> L196
    L42:
        if (r21.hasNext() == false) goto L181;
        final CombineInfo r8 = (CombineInfo) r21.next();     // Catch: Exception -> L178 Throwable -> L196
        ma0.a r2 = this.c;     // Catch: Exception -> L178 Throwable -> L196
        String r3 = r8.getCombineOp();     // Catch: Exception -> L178 Throwable -> L196
        if (r3 != null) goto L46;
        r3 = "";
    L46:
        r2.getClass();     // Catch: Exception -> L178 Throwable -> L196
        String r7 = ma0.a.a(r3);     // Catch: Exception -> L178 Throwable -> L196
        if (r7 != null) goto L208;
        r9 = r9;
        final StrategyMutableLiveData r25 = r12;
    L204:
        List<CombineInfo> r4 = this.b;     // Catch: Exception -> L176 Throwable -> L196
        if (r4 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L50 Throwable -> L196
    L57:
        String r5 = String.valueOf(r4.indexOf(r8));     // Catch: Exception -> L176 Throwable -> L196
        CombineBaseInfo r6 = r8.getCombineBaseInfo();     // Catch: Exception -> L176 Throwable -> L196
        if (r6 == null) goto L61;
        Integer r17 = r6.getCurrentStrategyState();     // Catch: Exception -> L50 Throwable -> L196
    L62:
        if (r17 == 0) goto L67;
        if (r17.intValue() != 3) goto L67;
        String r18 = r28;
        r32 = r32;
        r9 = r9;
        CombineBaseInfo r19 = r8.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r19 == null) goto L122;
        Object r22 = r19.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L123:
        StrategyMutableLiveData r110 = r25;
        if (CollectionsKt.contains(r110, r22) == true) goto L173;
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == true) goto L128;
        this.f.remove(r5);     // Catch: Exception -> L174 Throwable -> L196
        ConcurrentHashMap<String, Map<String, String>> r23 = StrategyTeaLogHelper.a;     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r24 = r8.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r24 == null) goto L171;
        String r26 = r24.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
        if (r26 == null) goto L171;
    L172:
        StrategyTeaLogHelper.d(r18, r26);     // Catch: Exception -> L174 Throwable -> L196
    L171:
        r26 = "";
        goto L172
    L128:
        if (r8.getTotalDuration() == null) goto L166;
        Integer r27 = r8.getTotalDuration();     // Catch: Exception -> L174 Throwable -> L196
        if (r27 != null) goto L133;
    L136:
        if (((LinkedHashMap) this.f).get(r5) != null) goto L138;
        this.f.put(r5, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L174 Throwable -> L196
        goto L173
    L138:
        long r35 = System.currentTimeMillis();     // Catch: Exception -> L174 Throwable -> L196
        Object r36 = ((LinkedHashMap) this.f).get(r5);     // Catch: Exception -> L174 Throwable -> L196
        Intrinsics.checkNotNull(r36);     // Catch: Exception -> L174 Throwable -> L196
        long r37 = r35 - ((Number) r36).longValue();     // Catch: Exception -> L174 Throwable -> L196
        Integer r38 = r8.getTotalDuration();     // Catch: Exception -> L174 Throwable -> L196
        if (r38 == null) goto L141;
        int r39 = r38.intValue() * 1000;     // Catch: Exception -> L174 Throwable -> L196
    L143:
        if (r37 < r39) goto L173;
        List r41 = (List) r9.element;     // Catch: Exception -> L174 Throwable -> L196
        if (r41 == null) goto L165;
        Iterator r42 = r41.iterator();     // Catch: Exception -> L174 Throwable -> L196
    L148:
        if (r42.hasNext() == false) goto L165;
        CombineInfo r43 = (CombineInfo) r42.next();     // Catch: Exception -> L174 Throwable -> L196
        List<CombineInfo> r44 = this.b;     // Catch: Exception -> L174 Throwable -> L196
        if (r44 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L174 Throwable -> L196
    L152:
        String r45 = String.valueOf(r44.indexOf(r43));     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r46 = r43.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r46 == null) goto L155;
        Object r111 = r46.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L156:
        CombineBaseInfo r47 = r8.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r47 == null) goto L159;
        Object r48 = r47.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
    L161:
        if (Intrinsics.areEqual(r111, r48) == false) goto L148;
        if ((!Intrinsics.areEqual(r45, r5)) == false) goto L148;
        this.f.remove(r45);     // Catch: Exception -> L174 Throwable -> L196
        goto L148
    L159:
        r48 = r11;
        goto L161
    L155:
        r111 = r11;
    L165:
        d(r8, r31, r28, r34, r32, true, r110);     // Catch: Exception -> L174 Throwable -> L196
        goto L173
    L141:
        r39 = 0;
        goto L143
    L133:
        if (r27.intValue() != 0) goto L136;
    L166:
        d(r8, r31, r28, r34, r32, true, r110);     // Catch: Exception -> L174 Throwable -> L196
    L173:
        r0 = r18;
        r11 = r11;
        StrategyMutableLiveData r210 = r110;
        r13 = r32;
        r12 = r210;
        goto L42
    L122:
        r22 = r11;
    L174:
        e = e;
    L180:
        Object r49 = r31;
    L190:
        ALogger.i("strategy_tag", e.getMessage());     // Catch: Throwable -> L196
        r12.setValue(r49);     // Catch: Throwable -> L196
        monitor-exit(this);
        return r12;
    L67:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L112;
        if (r8.getTotalDuration() == null) goto L107;
        Integer r51 = r8.getTotalDuration();     // Catch: Exception -> L176 Throwable -> L196
        if (r51 != null) goto L74;
    L77:
        if (((LinkedHashMap) this.e).get(r5) != null) goto L80;
        this.e.put(r5, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L50 Throwable -> L196
        r18 = r28;
    L118:
        r110 = r25;
        goto L173
    L80:
        long r52 = System.currentTimeMillis();     // Catch: Exception -> L176 Throwable -> L196
        Object r53 = ((LinkedHashMap) this.e).get(r5);     // Catch: Exception -> L176 Throwable -> L196
        Intrinsics.checkNotNull(r53);     // Catch: Exception -> L176 Throwable -> L196
        long r54 = r52 - ((Number) r53).longValue();     // Catch: Exception -> L176 Throwable -> L196
        Integer r55 = r8.getTotalDuration();     // Catch: Exception -> L176 Throwable -> L196
        if (r55 != null) goto L83;
        int r56 = 0;
    L86:
        if (r54 >= r56) goto L88;
        r18 = r28;
        goto L118
    L88:
        List r57 = (List) r9.element;     // Catch: Exception -> L176 Throwable -> L196
        if (r57 == null) goto L102;
        Iterator r58 = r57.iterator();     // Catch: Exception -> L50 Throwable -> L196
    L91:
        if (r58.hasNext() == false) goto L102;
        CombineInfo r59 = (CombineInfo) r58.next();     // Catch: Exception -> L50 Throwable -> L196
        List<CombineInfo> r61 = this.b;     // Catch: Exception -> L50 Throwable -> L196
        if (r61 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L50 Throwable -> L196
    L96:
        String r62 = String.valueOf(r61.indexOf(r59));     // Catch: Exception -> L50 Throwable -> L196
        if ((!Intrinsics.areEqual(r62, r5)) == false) goto L91;
        this.e.remove(r62);     // Catch: Exception -> L50 Throwable -> L196
    L50:
        e = e;
        r49 = r31;
        r12 = r32;
    L102:
        d(r8, r31, r28, r34, r32, false, r25);     // Catch: Exception -> L176 Throwable -> L196
        monitor-exit(this);
        return r32;
    L83:
        r56 = r55.intValue() * 1000;
        goto L86
    L74:
        if (r51.intValue() != 0) goto L77;
    L107:
        r12 = r32;
        d(r8, r31, r28, r34, r32, false, r25);     // Catch: Exception -> L174 Throwable -> L196
        monitor-exit(this);
        return r12;
    L112:
        this.e.remove(r5);     // Catch: Exception -> L174 Throwable -> L196
        ConcurrentHashMap<String, Map<String, String>> r63 = StrategyTeaLogHelper.a;     // Catch: Exception -> L174 Throwable -> L196
        CombineBaseInfo r64 = r8.getCombineBaseInfo();     // Catch: Exception -> L174 Throwable -> L196
        if (r64 == null) goto L116;
        String r65 = r64.getCombineInfoId();     // Catch: Exception -> L174 Throwable -> L196
        if (r65 == null) goto L116;
    L117:
        r18 = r28;
        StrategyTeaLogHelper.d(r18, r65);     // Catch: Exception -> L174 Throwable -> L196
    L116:
        r65 = "";
        goto L117
    L61:
        r17 = r11;
    L176:
        e = e;
        r12 = r32;
        goto L180
    L208:
        ma0.a r66 = this.c;     // Catch: Exception -> L50 Throwable -> L196
        r9 = r9;
        r25 = r12;
        Function1<String, Boolean> r67 = new BaseFactorProcessor$handle$$inlined$forEach$lambda$1(r8, this, r33, r29, r31, r28, r34, r32, r16, r25, r9);     // Catch: Exception -> L50 Throwable -> L196
        r66.getClass();     // Catch: Exception -> L50 Throwable -> L196
        r11 = Boolean.valueOf(ma0.a.b(r7, r67));     // Catch: Exception -> L50 Throwable -> L196
    L178:
        e = e;
        r12 = r13;
        goto L180
    L10:
        List<CombineInfo> r68 = this.b;     // Catch: Exception -> L188 Throwable -> L196
        if (r68 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("combineInfos");     // Catch: Exception -> L188 Throwable -> L196
    L13:
        if (r68 == null) goto L34;
        ArrayList r69 = new ArrayList();     // Catch: Exception -> L188 Throwable -> L196
        Iterator<T> r71 = r68.iterator();     // Catch: Exception -> L188 Throwable -> L196
    L16:
        if (r71.hasNext() == false) goto L33;
        Object r72 = r71.next();     // Catch: Exception -> L188 Throwable -> L196
        CombineInfo r73 = (CombineInfo) r72;     // Catch: Exception -> L188 Throwable -> L196
        if (r73 == null) goto L30;
        CopyOnWriteArrayList r74 = r73.getFaList();     // Catch: Exception -> L188 Throwable -> L196
        if (r74 == null) goto L30;
        if (r74.isEmpty() == true) goto L30;
        Iterator r75 = r74.iterator();     // Catch: Exception -> L188 Throwable -> L196
    L26:
        if (r75.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((CombbineFactorInfo) r75.next()).getFaName(), r0) == false) goto L26;
        boolean r76 = true;
    L31:
        if (r76 == false) goto L16;
        r69.add(r72);     // Catch: Exception -> L188 Throwable -> L196
    L30:
        r76 = false;
        goto L31
    L33:
        List<CombineInfo> r77 = CollectionsKt.sortedWith(r69, new a());     // Catch: Exception -> L188 Throwable -> L196
    L35:
        r9.element = r77;     // Catch: Exception -> L188 Throwable -> L196
        List<CombineInfo> r78 = r77;     // Catch: Exception -> L188 Throwable -> L196
        if (r78 == null) goto L38;
        this.l.put(r0, r78);     // Catch: Exception -> L188 Throwable -> L196
        goto L38
    L34:
        r77 = null;
    L188:
        e = e;
        r12 = r13;
        r49 = r31;
        goto L190
    L194:
        monitor-exit(this);
        return null;
    L196:
        th = move-exception;
        throw th;
    }

    public final void d(CombineInfo r9, Object r11, String r12, boolean r13, StrategyMutableLiveData r14, boolean r15, List r16) {
        int r0 = com.bytedance.android.live.impl.b.a;
        CopyOnWriteArrayList r1 = r9.getFaList();
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        CombbineFactorInfo r3 = (CombbineFactorInfo) r2.next();
        if (Intrinsics.areEqual(r3.getFaName(), r12) == false) goto L6;
        Object r4 = r3.getFaValue();
    L13:
        Object r17 = com.bytedance.android.live.impl.b.a(r4, r11);
        LinkedHashMap r5 = new LinkedHashMap();
        CombineBaseInfo r6 = r9.getCombineBaseInfo();
        String r7 = "";
        if (r6 == null) goto L17;
        String r8 = r6.getCombineInfoId();
        if (r8 == null) goto L17;
    L18:
        r5.put("combine_info_id", r8);
        String r18 = r9.getCombineId();
        if (r18 != null) goto L21;
        r18 = "";
    L21:
        r5.put("detail_combine_id", r18);
        if (r12 != null) goto L24;
        String r19 = "";
    L25:
        r5.put("fa_name", r19);
        if (r17 == null) goto L29;
        String r21 = r17.toString();
        if (r21 == null) goto L29;
    L30:
        r5.put("fa_value", r21);
        CombineBaseInfo r22 = r9.getCombineBaseInfo();
        if (r22 == null) goto L36;
        Integer r23 = r22.getCurrentStrategyState();
        if (r23 == null) goto L36;
        String r24 = String.valueOf(r23.intValue());
        if (r24 == null) goto L36;
    L37:
        r5.put("combine_info_type", r24);
        r5.put("use_sp_cache", String.valueOf(r13));
        Integer r110 = r9.getPriority();
        if (r110 == null) goto L41;
        String r111 = String.valueOf(r110.intValue());
        if (r111 == null) goto L41;
    L42:
        r5.put("priority", r111);
        if (r15 == true) goto L69;
        ConcurrentHashMap<String, Map<String, String>> r112 = StrategyTeaLogHelper.a;
        CombineBaseInfo r113 = r9.getCombineBaseInfo();
        if (r113 == null) goto L48;
        String r114 = r113.getCombineInfoId();
        if (r114 == null) goto L48;
    L49:
        StrategyTeaLogHelper.a(r12, r114, r5);
        CombineBaseInfo r115 = r9.getCombineBaseInfo();
        if (r115 == null) goto L55;
        String r116 = r115.getCombineInfoId();
        if (r116 == null) goto L55;
        String r25 = r116;
    L56:
        if (r17 == null) goto L68;
        if (r14 == null) goto L66;
        g(r12, r25, r17, r14, r15);
        r14.setValue(r17);
        f(r9, r14);
        if (a() == false) goto L97;
        StringBuilder r117 = new StringBuilder();
        r117.append(r12);
        r117.append(" is shot by ");
        String r26 = r9.getCombineId();
        if (r26 == null) goto L64;
        r7 = r26;
    L64:
        r117.append(r7);
        r117.append(",faValue: ");
        r117.append(r17);
        ALogger.i("strategy_tag", r117.toString());
        return;
    L97:
        return;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L68:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L55:
        r25 = "";
    L48:
        r114 = "";
        goto L49
    L69:
        ConcurrentHashMap<String, Map<String, String>> r27 = StrategyTeaLogHelper.a;
        CombineBaseInfo r28 = r9.getCombineBaseInfo();
        if (r28 == null) goto L73;
        String r29 = r28.getCombineInfoId();
        if (r29 == null) goto L73;
    L74:
        StrategyTeaLogHelper.f(r12, r29, r5);
        CombineBaseInfo r31 = r9.getCombineBaseInfo();
        if (r31 == null) goto L78;
        String r32 = r31.getCombineInfoId();
        if (r32 == null) goto L78;
    L79:
        ((ArrayList) r16).add(r32);
        CombineBaseInfo r33 = r9.getCombineBaseInfo();
        if (r33 == null) goto L85;
        String r34 = r33.getCombineInfoId();
        if (r34 == null) goto L85;
        String r35 = r34;
    L86:
        if (r17 == null) goto L93;
        if (r14 == null) goto L91;
        g(r12, r35, r17, r14, r15);
        return;
    L91:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.strategy.api.StrategyMutableLiveData<kotlin.Any>");
    L93:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L85:
        r35 = "";
    L78:
        r32 = "";
    L73:
        r29 = "";
    L41:
        r111 = "";
    L36:
        r24 = "-1";
    L29:
        r21 = "";
        goto L30
    L24:
        r19 = r12;
    L17:
        r8 = "";
        goto L18
    L11:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L12:
        r4 = null;
        goto L13
    }
}
