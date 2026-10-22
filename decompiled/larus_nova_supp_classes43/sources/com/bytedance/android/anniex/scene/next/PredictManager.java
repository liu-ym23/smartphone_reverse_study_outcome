package com.bytedance.android.anniex.scene.next;

import android.os.Build;
import android.os.Message;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.handler.idle.TaskStatus;
import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.next.task.RepeatSceneTaskGenerator;
import com.bytedance.android.anniex.scene.next.task.SceneInfoTaskGenerator;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PredictManager {
    public static String a;
    public static String b;
    public static boolean c;
    public static long d;
    public static boolean e;
    public static g f;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static String k;

    public static final class a implements va.c {
        public a() {
        }

        @Override // va.c
        public final void a(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            if (r10.what != 7) goto L16;
            Object r11 = r10.obj;
            if ((r11 instanceof g) == false) goto L14;
            String r0 = PredictManager.a;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.next.SceneSwitchInput");
            final g r12 = (g) r11;
            int r1 = za.b.a;
            za.b.a("PredictManager", new PredictManager$processSceneSwitch$1(r12));
            String r13 = PredictManager.a;
            PredictManager.b = r13;
            String r14 = r12.a;
            PredictManager.a = r14;
            if (r13 == null) goto L10;
            Lazy r15 = Evaluator.a;
            Intrinsics.checkNotNullParameter(r13, "previousSceneId");
            Intrinsics.checkNotNullParameter(r14, "actualValue");
            Evaluator.a(r13, r14, PredictElementType.SceneId, new Evaluator$evaluateSceneSwitchOutcome$1((d) Evaluator.a.getValue()));
        L10:
            if (((Boolean) SwitchCenter.U.getValue()).booleanValue() == false) goto L12;
            PredictManager.b(CollectionsKt.toList((List) PredictManager.h.getValue()), r12, r12.a, PredictElementType.SceneId);
        L13:
            Evaluator.b();
            goto L14
        L12:
            PredictManager.b(CollectionsKt.toList((List) PredictManager.g.getValue()), r12, r12.a, PredictElementType.SceneId);
        L14:
            PredictManager.e = false;
            PredictManager.d = System.currentTimeMillis();
            return;
        }

        @Override // va.c
        public final void b(Message r15) {
            Intrinsics.checkNotNullParameter(r15, MessageIndication.MESSAGE_TYPE_MSG);
            if (r15.what != 9) goto L44;
            Object r16 = r15.obj;
            if ((r16 instanceof f) == false) goto L45;
            String r0 = PredictManager.a;
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.android.anniex.scene.next.SceneRepeatInput");
            final f r17 = (f) r16;
            int r1 = za.b.a;
            za.b.a("PredictManager", new PredictManager$processSceneRepeat$1(r17));
            if (r17.b == false) goto L39;
            String r10 = PredictManager.k;
            if (r10 != null) goto L11;
        L15:
            Double r11 = r17.d;
            if (r11 != null) goto L18;
            return;
        L18:
            if (Intrinsics.areEqual(r11, 0.0d) == true) goto L48;
            PredictManager.k = r17.a;
            int r12 = Evaluator.g + 1;
            Evaluator.g = r12;
            if ((r12 % ((Number) SwitchCenter.Y.getValue()).intValue()) != 0) goto L38;
            e r13 = (e) Evaluator.b.getValue();
            Map r14 = MapsKt.toMap(r13.a);
            ((ConcurrentHashMap) r13.a).clear();
            Iterator r18 = r14.entrySet().iterator();
        L24:
            if (r18.hasNext() == false) goto L38;
            Map.Entry r19 = (Map.Entry) r18.next();
            String r20 = (String) r19.getKey();
            e.a r21 = (e.a) r19.getValue();
            int r22 = r21.b;
            if (r22 <= 0) goto L28;
            double r23 = ((double) r21.f) / ((double) r22);
        L29:
            int r24 = r21.a;
            if (r24 <= 0) goto L32;
            double r25 = ((double) r21.e) / ((double) r24);
        L33:
            int r26 = r21.d;
            if (r26 <= 0) goto L36;
            double r110 = ((double) r21.f) / ((double) r26);
        L37:
            Lazy r27 = SceneConnectCenter.a;
            JSONObject r28 = new JSONObject();
            r28.put("strategy", r20);
            JSONObject r29 = new JSONObject();
            r29.put("recall", r23);
            r29.put("accuracy", r25);
            r29.put("precision", r110);
            Unit r30 = Unit.INSTANCE;
            SceneConnectCenter.d(r28, r29);
            goto L24
        L36:
            r110 = 0.0d;
            goto L37
        L32:
            r25 = 0.0d;
            goto L33
        L28:
            r23 = 0.0d;
        L38:
            PredictManager.b(CollectionsKt.toList((List) PredictManager.i.getValue()), r17, r17.a, PredictElementType.SceneRepeat);
            return;
        L48:
            return;
        L11:
            if (Intrinsics.areEqual(r10, r17.a) == true) goto L15;
            za.b.a("PredictManager", PredictManager$processSceneRepeat$2.INSTANCE);
            String r31 = PredictManager.k;
            if (r31 == null) goto L15;
            Lazy r32 = Evaluator.a;
            Intrinsics.checkNotNullParameter(r31, "previousSceneId");
            Evaluator.a(r31, Boolean.FALSE, PredictElementType.SceneRepeat, new Evaluator$evaluateSceneRepeatOutcome$1((e) Evaluator.b.getValue()));
            goto L15
        L39:
            za.b.a("PredictManager", PredictManager$processSceneRepeat$4.INSTANCE);
            PredictManager.k = null;
            Lazy r33 = Evaluator.a;
            String r111 = r17.a;
            Intrinsics.checkNotNullParameter(r111, "previousSceneId");
            Evaluator.a(r111, Boolean.TRUE, PredictElementType.SceneRepeat, new Evaluator$evaluateSceneRepeatOutcome$1((e) Evaluator.b.getValue()));
            return;
        L45:
            return;
        }

        @Override // va.c
        public final void c(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            if (r10.what != 8) goto L23;
            Object r11 = r10.obj;
            if ((r11 instanceof String) == false) goto L29;
            Lazy r0 = Evaluator.a;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
            String r12 = (String) r11;
            Intrinsics.checkNotNullParameter(r12, "sceneId");
            if (Build.VERSION.SDK_INT < 26) goto L30;
            com.bytedance.android.anniex.scene.handler.idle.h r1 = com.bytedance.android.anniex.scene.handler.idle.h.a;
            monitor-enter(r1);
            Intrinsics.checkNotNullParameter(r12, "taskGroup");     // Catch: Throwable -> L20
            Iterator<com.bytedance.android.anniex.scene.handler.idle.c<?>> r13 = com.bytedance.android.anniex.scene.handler.idle.h.b.iterator();     // Catch: Throwable -> L20
        L12:
            if (r13.hasNext() == false) goto L18;
            com.bytedance.android.anniex.scene.handler.idle.c<?> r14 = r13.next();     // Catch: Throwable -> L20
            if (Intrinsics.areEqual(r14.c, r12) == false) goto L12;
            r13.remove();     // Catch: Throwable -> L20
            com.bytedance.android.anniex.scene.handler.idle.h.c.remove(r14.a);     // Catch: Throwable -> L20
            com.bytedance.android.anniex.scene.handler.idle.h.b(r14, TaskStatus.TIMEOUT);     // Catch: Throwable -> L20
            monitor-exit(r1);
            return;
        L18:
            monitor-exit(r1);
            return;
        L20:
            th = move-exception;
            throw th;
        L30:
            return;
        L29:
            return;
        }
    }

    static {
        g = LazyKt.lazy(PredictManager$sceneSwitchStrategyList$2.INSTANCE);
        h = LazyKt.lazy(PredictManager$sceneFuzzyStrategyList$2.INSTANCE);
        i = LazyKt.lazy(PredictManager$sceneRepeatStrategyList$2.INSTANCE);
        j = LazyKt.lazy(PredictManager$taskProviderMap$2.INSTANCE);
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (c == false) goto L7;
        return;
    L7:
        if (((Boolean) SwitchCenter.Z.getValue()).booleanValue() == false) goto L9;
        com.bytedance.android.anniex.scene.next.strategy.f r0 = new com.bytedance.android.anniex.scene.next.strategy.f();
        ((List) g.getValue()).add(r0);
        com.bytedance.android.anniex.scene.next.strategy.c r1 = new com.bytedance.android.anniex.scene.next.strategy.c();
        ((List) h.getValue()).add(r1);
        com.bytedance.android.anniex.scene.next.strategy.d r10 = new com.bytedance.android.anniex.scene.next.strategy.d();
        ((List) i.getValue()).add(r10);
        PredictElementType r11 = PredictElementType.SceneId;
        SceneInfoTaskGenerator r12 = new SceneInfoTaskGenerator();
        Intrinsics.checkNotNullParameter(r11, "predictElementType");
        Intrinsics.checkNotNullParameter(r12, "provider");
        Lazy r13 = j;
        ((ConcurrentHashMap) r13.getValue()).put(r11, r12);
        PredictElementType r14 = PredictElementType.SceneRepeat;
        RepeatSceneTaskGenerator r15 = new RepeatSceneTaskGenerator();
        Intrinsics.checkNotNullParameter(r14, "predictElementType");
        Intrinsics.checkNotNullParameter(r15, "provider");
        ((ConcurrentHashMap) r13.getValue()).put(r14, r15);
    L9:
        va.a.C0207a r16 = va.a.g;
        r16.a().a();
        va.a r17 = r16.a();
        a r18 = new a();
        Intrinsics.checkNotNullParameter(r18, "predictHandlerAPI");
        r17.f = r18;
        c = true;
    }

    public static void c(f r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        if (((Boolean) SwitchCenter.V.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) SwitchCenter.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (r10.b == false) goto L14;
        Double r0 = r10.c;
        if (r0 == null) goto L14;
        if (r0.doubleValue() >= ((Number) SwitchCenter.W.getValue()).longValue()) goto L14;
        return;
    L14:
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.f("PredictManager", "调度重复场景预测任务: sceneId：" + r10.a + ", rate：" + r10.d + ", duration:" + r10.c, null, 12);
        a();
        long r11 = ((Number) SwitchCenter.X.getValue()).longValue();
        va.a.C0207a r12 = va.a.g;
        va.a.b r13 = r12.a().b;
        if (r13 == null) goto L17;
        r13.removeMessages(9);
    L17:
        va.a.b r14 = r12.a().b;
        if (r14 == null) goto L22;
        Message r15 = new Message();
        r15.what = 9;
        r15.obj = r10;
        r14.sendMessageDelayed(r15, r11);
        return;
    }

    public static void b(List r12, com.bytedance.android.anniex.scene.next.a r13, String r14, PredictElementType r15) {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r16 = r12.iterator();
    L4:
        if (r16.hasNext() == false) goto L44;
        wa.b r10 = (wa.b) r16.next();
        List r11 = r10.a(r13);
        if (r11 == null) goto L11;
        r0.put(r10.getName(), new h(r10.b(), r11));
        PredictElementType r17 = r10.b();
        Object r18 = r1.get(r17);
        if (r18 != null) goto L10;
        r18 = new LinkedHashSet();
        r1.put(r17, r18);
    L10:
        ((Set) r18).addAll(r11);
    L12:
        List r19 = r11;
        if (r19 != null) goto L15;
    L18:
        boolean r20 = true;
    L19:
        if (r20 == false) goto L21;
        r0.put(r10.getName(), new h(r10.b(), CollectionsKt.emptyList()));
    L21:
        Lazy r21 = Evaluator.a;
        String r22 = r10.getName();
        Intrinsics.checkNotNullParameter(r22, "strategyName");
        Intrinsics.checkNotNullParameter(r15, "elementType");
        int r110 = Evaluator.b.a[r15.ordinal()];
        if (r110 == 1) goto L32;
        if (r110 != 2) goto L39;
        e r23 = (e) Evaluator.b.getValue();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r22, "strategyName");
        ConcurrentHashMap r24 = (ConcurrentHashMap) r23.a;
        Object r25 = r24.get(r22);
        if (r25 != null) goto L31;
        r25 = new e.a(0);
        Object r26 = r24.putIfAbsent(r22, r25);
        if (r26 == null) goto L31;
        r25 = r26;
    L31:
        ((e.a) r25).c++;
    L39:
        HybridLogger r27 = HybridLogger.a;
        StringBuilder r28 = new StringBuilder("Client AI Strategy: ");
        r28.append(r10.getName());
        r28.append(" 预测结果数: ");
        if (r11 == null) goto L42;
        Integer r29 = Integer.valueOf(r11.size());
    L43:
        r28.append(r29);
        HybridLogger.m("PredictManager", r28.toString(), null, null, 12);
        goto L4
    L42:
        r29 = null;
        goto L43
    L32:
        d r30 = (d) Evaluator.a.getValue();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r22, "strategyName");
        ConcurrentHashMap r31 = (ConcurrentHashMap) r30.a;
        Object r32 = r31.get(r22);
        if (r32 != null) goto L38;
        r32 = new d.a(0);
        Object r33 = r31.putIfAbsent(r22, r32);
        if (r33 == null) goto L38;
        r32 = r33;
    L38:
        ((d.a) r32).a++;
        goto L39
    L15:
        if (r19.isEmpty() == true) goto L18;
        r20 = false;
        goto L19
    L11:
        r11 = null;
        goto L12
    L44:
        Iterator r111 = r1.entrySet().iterator();
    L46:
        if (r111.hasNext() == false) goto L53;
        Map.Entry r112 = (Map.Entry) r111.next();
        PredictElementType r34 = (PredictElementType) r112.getKey();
        Set r113 = (Set) r112.getValue();
        Object r35 = ((ConcurrentHashMap) j.getValue()).get(r34);
        if ((r35 instanceof wa.e) == false) goto L50;
        wa.e r36 = (wa.e) r35;
    L51:
        if (r36 == null) goto L46;
        r36.a(r34, r14, CollectionsKt.toList(r113));
        goto L46
    L50:
        r36 = null;
        goto L51
    L53:
        Lazy r114 = Evaluator.a;
        Intrinsics.checkNotNullParameter(r15, "type");
        Intrinsics.checkNotNullParameter(r14, "currentSceneId");
        Intrinsics.checkNotNullParameter(r0, "predictionsByStrategy");
        int r115 = Evaluator.b.a[r15.ordinal()];
        if (r115 == 1) goto L58;
        if (r115 != 2) goto L69;
        Evaluator.d.put(r14, r0);
        return;
    L69:
        return;
    L58:
        Evaluator.c.put(r14, r0);
    }
}
