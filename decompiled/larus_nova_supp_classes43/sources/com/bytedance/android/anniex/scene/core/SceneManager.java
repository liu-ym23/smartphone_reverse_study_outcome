package com.bytedance.android.anniex.scene.core;

import android.app.Application;
import android.os.Build;
import android.os.Message;
import android.util.LruCache;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.data.SceneDbManager;
import com.bytedance.android.anniex.scene.handler.idle.IdleSignalCenter;
import com.bytedance.android.anniex.scene.listener.AppPageStackMonitor;
import com.bytedance.android.anniex.scene.next.Evaluator;
import com.bytedance.android.anniex.scene.next.PredictManager;
import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SceneManager {
    public static SceneManager n;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public h d;
    public i e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public boolean k;
    public boolean l;
    public boolean m;

    public static final class a {
        public static SceneManager a() {
            if (SceneManager.n != null) goto L5;
            SceneManager.n = new SceneManager();
        L5:
            SceneManager r0 = SceneManager.n;
            Intrinsics.checkNotNull(r0);
            return r0;
        }
    }

    public static final class b implements va.b {
        public final /* synthetic */ SceneManager a;

        public b(SceneManager r1) {
            this.a = r1;
        }

        @Override // va.b
        public final void a(Message r26) {
            Intrinsics.checkNotNullParameter(r26, MessageIndication.MESSAGE_TYPE_MSG);
            final SceneManager r0 = this.a;
            r0.getClass();
            int r10 = za.b.a;
            za.b.a("AnnieXSceneManager", new SceneManager$receiveAViewSignal$1(r0));
            com.bytedance.android.anniex.scene.core.a r11 = (com.bytedance.android.anniex.scene.core.a) r0.f.getValue();     // Catch: Exception -> L34
            r11.getClass();     // Catch: Exception -> L34
            long r12 = System.currentTimeMillis();     // Catch: Exception -> L34
            long r13 = r11.c;     // Catch: Exception -> L34
            if (r13 > 0) goto L6;
        L8:
            boolean r14 = false;
        L9:
            if (r14 == false) goto L39;
            com.bytedance.android.anniex.scene.core.a r15 = (com.bytedance.android.anniex.scene.core.a) r0.f.getValue();     // Catch: Exception -> L34
            Set r16 = CollectionsKt.toSet(r15.b);     // Catch: Exception -> L34
            int r17 = r15.d;     // Catch: Exception -> L34
            r15.b.clear();     // Catch: Exception -> L34
            r15.d = 0;     // Catch: Exception -> L34
            r15.c = 0;     // Catch: Exception -> L34
            Intrinsics.checkNotNullParameter(r16, "attachEvent");     // Catch: Exception -> L34
            if ((!r16.isEmpty()) == false) goto L40;
            HashSet r18 = CollectionsKt.toHashSet(r16);     // Catch: Exception -> L34
            k r19 = (k) CollectionsKt.firstOrNull(r16);     // Catch: Exception -> L34
            if (r19 == null) goto L15;
            long r20 = r19.b;     // Catch: Exception -> L34
        L16:
            SceneOrigin r110 = SceneOrigin.HYBRID;     // Catch: Exception -> L34
            SceneManager.a();     // Catch: Exception -> L34
            Intrinsics.checkNotNullParameter(r18, "aViewUrls");     // Catch: Exception -> L34
            Intrinsics.checkNotNullParameter(r110, "origin");     // Catch: Exception -> L34
            Intrinsics.checkNotNullParameter("", "attachScene");     // Catch: Exception -> L34
            LinkedHashMap r111 = new LinkedHashMap();     // Catch: Exception -> L34
            if (r16.size() != 1) goto L25;
            k r21 = (k) CollectionsKt.firstOrNull(r16);     // Catch: Exception -> L34
            if (r21 == null) goto L25;
            String r22 = r21.c;     // Catch: Exception -> L34
            if (r22 == null) goto L25;
            String r23 = (String) ((LruCache) r0.j.getValue()).get(r22);     // Catch: Exception -> L34
            if (r23 == null) goto L25;
            Intrinsics.checkNotNullParameter(r23, "clientComponent");     // Catch: Exception -> L34
        L27:
            if (((Boolean) SwitchCenter.e.getValue()).booleanValue() == false) goto L31;
            final long r24 = System.currentTimeMillis();     // Catch: Exception -> L34
            final JSONObject r112 = SceneManager.b();     // Catch: Exception -> L34
            if (r112 == null) goto L31;
            Intrinsics.checkNotNullParameter(r112, "bcmChain");     // Catch: Exception -> L34
            za.b.a("AnnieXSceneManager", new SceneManager$receiveAViewSignal$current$1$2$1(r112, r24));     // Catch: Exception -> L34
            JSONObject r25 = r112;
        L32:
            int r113 = za.a.a;     // Catch: Exception -> L34
            String r114 = CollectionsKt.joinToString$default(r18, ",", null, null, 0, null, SceneFingerprint$Builder$encodeUrls$1.INSTANCE, 30, null);     // Catch: Exception -> L34
            Intrinsics.checkNotNullParameter(r114, "input");     // Catch: Exception -> L34
            h r115 = new h(r114, r18, r20, r110, "", r111);     // Catch: Exception -> L34
            r115.g = r23;     // Catch: Exception -> L34
            r115.h = Integer.valueOf(r17);     // Catch: Exception -> L34
            r115.i = Integer.valueOf(r17);     // Catch: Exception -> L34
            r115.j = r25;     // Catch: Exception -> L34
            r0.e(r115);     // Catch: Exception -> L34
            return;
        L31:
            r25 = null;
        L25:
            r23 = "";
            goto L27
        L15:
            r20 = System.currentTimeMillis();     // Catch: Exception -> L34
            goto L16
        L40:
            return;
        L39:
            return;
        L6:
            if ((r12 - r13) < r11.a) goto L8;
            r14 = true;
        L34:
            e = move-exception;
            HybridLogger r27 = HybridLogger.a;
            HybridLogger.i("AnnieXSceneManager", "receiveAViewSignal error: " + e.getMessage(), null, 12);
        }

        @Override // va.b
        public final void b(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            SceneManager r11 = this.a;
            r11.getClass();
            Application r0 = com.bytedance.ies.bullet.core.h.h.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (AppPageStackMonitor.b != null) goto L7;
            AppPageStackMonitor.b = new AppPageStackMonitor();
        L7:
            AppPageStackMonitor r1 = AppPageStackMonitor.b;
            Intrinsics.checkNotNull(r1);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r0, "application");
            if (r1.a == true) goto L10;
            r0.registerActivityLifecycleCallbacks(r1);
        L10:
            r1.a = true;
            r11.l = true;
        }

        @Override // va.b
        public final void c(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            SceneManager r11 = this.a;
            d r0 = (d) r11.g.getValue();
            r0.getClass();
            long r1 = System.currentTimeMillis();
            long r12 = r0.b;
            if (r12 > 0) goto L5;
        L7:
            boolean r13 = false;
        L8:
            if (r13 == true) goto L20;
            return;
        L20:
            d r14 = (d) r11.g.getValue();     // Catch: Exception -> L17
            if (r14.a.isEmpty() == false) goto L13;
            r14.a.clear();     // Catch: Exception -> L17
            r14.b = 0;     // Catch: Exception -> L17
            com.bytedance.android.anniex.scene.core.c r15 = null;
        L14:
            if (r15 == null) goto L23;
            r11.d(r15);     // Catch: Exception -> L17
            return;
        L23:
            return;
        L13:
            r15 = (com.bytedance.android.anniex.scene.core.c) CollectionsKt.lastOrNull(r14.a);     // Catch: Exception -> L17
            r14.a.clear();     // Catch: Exception -> L17
            r14.b = 0;     // Catch: Exception -> L17
        L17:
            e = move-exception;
            HybridLogger r16 = HybridLogger.a;
            HybridLogger.i("AnnieXSceneManager", "receivePageSignal error: " + e.getMessage(), null, 12);
            return;
        L5:
            if ((r1 - r12) < r0.c) goto L7;
            r13 = true;
            goto L8
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SceneManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(SceneManager r1, String r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((LruCache) this.a.j.getValue()).put(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void a() {
        com.bytedance.android.anniex.assemble.a r0 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r1 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g("default_bid", IAnnieXContextProvider.class);
        if (r1 == null) goto L6;
        r1.l0();
        return;
    }

    public static JSONObject b() {
        com.bytedance.android.anniex.assemble.a r0 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXContextProvider r1 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g("default_bid", IAnnieXContextProvider.class);
        if (r1 == null) goto L5;
        ((Number) SwitchCenter.f.getValue()).intValue();
        ((Boolean) SwitchCenter.g.getValue()).booleanValue();
        return r1.j();
    L5:
        return null;
    }

    public static va.a.b c() {
        return va.a.g.a().b;
    }

    public final void f() {
        if (((Boolean) SwitchCenter.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return;
    L7:
        if (this.k == true) goto L12;
        va.a.C0207a r0 = va.a.g;
        r0.a().a();
        va.a r1 = r0.a();
        b r10 = new b(this);
        Intrinsics.checkNotNullParameter(r10, "nextSceneHandlerAPI");
        r1.d = r10;
        this.k = true;
        return;
    }

    public SceneManager() {
        this.a = LazyKt.lazy(SceneManager$viewEventBuffer$2.INSTANCE);
        this.b = LazyKt.lazy(SceneManager$timeline$2.INSTANCE);
        this.c = LazyKt.lazy(SceneManager$aViewHotMapByScene$2.INSTANCE);
        this.f = LazyKt.lazy(SceneManager$signalBuffer$2.INSTANCE);
        this.g = LazyKt.lazy(SceneManager$pageSignalBuffer$2.INSTANCE);
        this.h = LazyKt.lazy(SceneManager$behaviorModel$2.INSTANCE);
        this.i = LazyKt.lazy(SceneManager$sceneDbHelper$2.INSTANCE);
        this.j = LazyKt.lazy(SceneManager$clientComponentMap$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(final com.bytedance.android.anniex.scene.core.c r21) {
        a();
        LinkedHashSet r11 = new LinkedHashSet();
        long r12 = r21.b;
        SceneOrigin r14 = SceneOrigin.NA_PAGE;
        Intrinsics.checkNotNullParameter(r11, "aViewUrls");
        Intrinsics.checkNotNullParameter(r14, "origin");
        Intrinsics.checkNotNullParameter("", "attachScene");
        LinkedHashMap r16 = new LinkedHashMap();
        String r10 = r21.a;
        Intrinsics.checkNotNullParameter(r10, "eventName");
        int r13 = za.a.a;
        Intrinsics.checkNotNullParameter(r10, "input");
        if (r10 != null) goto L6;
        r10 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, SceneFingerprint$Builder$encodeUrls$1.INSTANCE, 30, null);
        Intrinsics.checkNotNullParameter(r10, "input");
    L6:
        String r1 = r10;
        final h r15 = new h(r1, r11, r12, r14, "", r16);
        r15.g = "";
        r15.h = 0;
        r15.i = 0;
        final com.bytedance.android.anniex.scene.data.b r17 = null;
        r15.j = null;
        this.d = null;
        int r18 = za.b.a;
        final Object[] r19 = null == true ? 1 : 0;
        za.b.a("AnnieXSceneManager", new SceneManager$handleLifecycleResumeEvent$1(r21, r19));
        if (((Boolean) SwitchCenter.c.getValue()).booleanValue() == false) goto L18;
        SceneDbManager r20 = (SceneDbManager) this.i.getValue();
        if (r20 == null) goto L11;
        SceneDbManager.a r22 = SceneDbManager.r;
        r17 = r20.j(r15, null, 0);
    L11:
        if (r17 == null) goto L16;
        SceneConnectCenter.i(r15, r17);
        SceneConnectCenter.j(r15, r17);
        i r23 = new i(r15, r17);
        i r24 = this.e;
        if (r24 == null) goto L15;
        SceneConnectCenter.k(r24.a, r23.a, r24.b);
    L15:
        this.e = r23;
    L16:
        za.b.a("AnnieXSceneManager", new SceneManager$handleLifecycleResumeEvent$3(r15, r17));
        za.b.a("AnnieXSceneManager", new SceneManager$handleLifecycleResumeEvent$4(r17));
        e r25 = (e) this.b.getValue();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r15, "sceneFingerprint");
        r25.a = r1;
        r25.put(r1, r15);
        return;
    }

    public final void e(final h r23) {
        Map r10 = (Map) this.c.getValue();
        if (r10 == null) goto L5;
        HotUrlCache r11 = (HotUrlCache) r10.get("");
    L7:
        if (r11 == null) goto L19;
        monitor-enter(r11);
        HotUrlCache$map$1 r12 = r11.b;     // Catch: Throwable -> L16
        final LinkedHashMap r13 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));     // Catch: Throwable -> L16
        Iterator<T> r14 = r12.entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r14.hasNext() == false) goto L14;
        Object r15 = r14.next();     // Catch: Throwable -> L16
        r13.put(((Map.Entry) r15).getKey(), Double.valueOf(1.0d / (Math.log10(((double) ((Number) ((Map.Entry) r15).getValue()).intValue()) + 1.0d) + 1.0d)));     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r11);
    L20:
        int r16 = za.b.a;
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$1(r13));
        final h r17 = this.d;
        if (r17 == null) goto L98;
        Intrinsics.checkNotNullParameter(r23, "other");
        Set<k> r18 = r17.b;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L24:
        if (r20.hasNext() == false) goto L26;
        r19.add(((k) r20.next()).a);
        goto L24
    L26:
        Set r21 = CollectionsKt.toSet(r19);
        Set<k> r110 = r23.b;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L28:
        if (r112.hasNext() == false) goto L30;
        r111.add(((k) r112.next()).a);
        goto L28
    L30:
        Set r22 = r21;
        Set r113 = CollectionsKt.toSet(r111);
        Set r114 = CollectionsKt.intersect(r22, r113);
        Set r24 = CollectionsKt.union(r22, r113);
        final double r115 = 0.0d;
        if (r24.isEmpty() == false) goto L33;
        final double r116 = 0.0d;
    L34:
        Intrinsics.checkNotNullParameter(r23, "other");
        Map r25 = GroupingKt.eachCount(new f(r17.b));
        LinkedHashMap r117 = new LinkedHashMap(MapsKt.mapCapacity(r25.size()));
        Iterator r26 = r25.entrySet().iterator();
    L36:
        if (r26.hasNext() == false) goto L44;
        Map.Entry r118 = (Map.Entry) r26.next();
        Object r27 = r118.getKey();
        String r28 = (String) r118.getKey();
        int r119 = ((Number) r118.getValue()).intValue();
        if (r13 == null) goto L42;
        Double r29 = (Double) r13.get(r28);
        if (r29 == null) goto L42;
        double r120 = r29.doubleValue();
    L43:
        r117.put(r27, Double.valueOf(r120 * ((double) r119)));
        r26 = r26;
    L42:
        r120 = 1.0d;
        goto L43
    L44:
        Map r30 = GroupingKt.eachCount(new g(r23.b));
        LinkedHashMap r31 = new LinkedHashMap(MapsKt.mapCapacity(r30.size()));
        Iterator r32 = r30.entrySet().iterator();
    L46:
        if (r32.hasNext() == false) goto L54;
        Map.Entry r33 = (Map.Entry) r32.next();
        Object r121 = r33.getKey();
        String r34 = (String) r33.getKey();
        int r35 = ((Number) r33.getValue()).intValue();
        if (r13 == null) goto L52;
        Double r36 = (Double) r13.get(r34);
        if (r36 == null) goto L52;
        double r210 = r36.doubleValue();
    L53:
        r31.put(r121, Double.valueOf(r210 * ((double) r35)));
        r32 = r32;
    L52:
        r210 = 1.0d;
        goto L53
    L54:
        Iterator r37 = r117.entrySet().iterator();
        double r38 = 0.0d;
        double r122 = 0.0d;
    L56:
        if (r37.hasNext() == false) goto L62;
        Map.Entry r39 = (Map.Entry) r37.next();
        String r40 = (String) r39.getKey();
        double r123 = ((Number) r39.getValue()).doubleValue();
        Double r41 = (Double) r31.get(r40);
        if (r41 == null) goto L60;
        double r211 = r41.doubleValue();
    L61:
        r122 = r122 + (r211 * r123);
        r38 = r38 + (r123 * r123);
        goto L56
    L60:
        r211 = 0.0d;
        goto L61
    L62:
        Iterator r42 = r31.values().iterator();
        double r43 = 0.0d;
    L64:
        if (r42.hasNext() == false) goto L67;
        double r124 = ((Number) r42.next()).doubleValue();
        r43 = r43 + (r124 * r124);
        goto L64
    L67:
        if (r38 != 0.0d) goto L69;
        boolean r44 = true;
    L70:
        if (r44 == false) goto L72;
    L78:
        int r45 = za.b.a;
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$2$1(r116, r115));
        if (r116 < ((Number) SwitchCenter.n.getValue()).doubleValue()) goto L81;
    L82:
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$2$2(r17));
        Integer r46 = r17.k;
        if (r46 == null) goto L85;
        int r47 = r46.intValue();
    L86:
        r17.k = Integer.valueOf(r47 + 1);
        Integer r48 = r17.i;
        if (r48 == null) goto L89;
        int r49 = r48.intValue();
    L90:
        Integer r50 = r23.i;
        if (r50 == null) goto L93;
        int r51 = r50.intValue();
    L94:
        r17.i = Integer.valueOf(r49 + r51);
        if (this.m == true) goto L172;
        String r52 = PredictManager.a;
        PredictManager.c(new com.bytedance.android.anniex.scene.next.f(r23.a, false, null, null, null));
        this.m = true;
        return;
    L172:
        return;
    L93:
        r51 = 0;
        goto L94
    L89:
        r49 = 0;
        goto L90
    L85:
        r47 = 0;
        goto L86
    L81:
        if (r115 < ((Number) SwitchCenter.o.getValue()).doubleValue()) goto L98;
    L72:
        if (r43 != 0.0d) goto L74;
        boolean r53 = true;
    L75:
        if (r53 == true) goto L78;
        r115 = r122 / (Math.sqrt(r38) * Math.sqrt(r43));
        goto L78
    L74:
        r53 = false;
        goto L75
    L69:
        r44 = false;
        goto L70
    L33:
        r116 = ((double) r114.size()) / ((double) r24.size());
    L98:
        this.m = false;
        com.bytedance.android.anniex.scene.core.b r54 = (com.bytedance.android.anniex.scene.core.b) this.h.getValue();
        r54.getClass();
        Intrinsics.checkNotNullParameter(r23, "scene");
        String r55 = r23.a;
        Map<String, Integer> r56 = r54.a;
        r56.put(r55, Integer.valueOf(((Number) ((LinkedHashMap) r56).getOrDefault(r55, 0)).intValue() + 1));
        System.out.println("📊 行为模型记录场景：" + r55 + " 次数=" + ((LinkedHashMap) r54.a).get(r55));
        final Ref.ObjectRef r57 = new Ref.ObjectRef();
        long r58 = 0;
        if (((e) this.b.getValue()).size() <= 0) goto L114;
        e r59 = (e) this.b.getValue();
        String r60 = r59.a;
        if (r60 == null) goto L103;
        final h r61 = r59.get(r60);
    L104:
        if (r61 == null) goto L113;
        final long r62 = r23.c - r61.c;
        com.bytedance.android.anniex.scene.core.b r63 = (com.bytedance.android.anniex.scene.core.b) this.h.getValue();
        String r125 = r61.a;
        String r126 = r23.a;
        r63.getClass();
        Intrinsics.checkNotNullParameter(r125, com.bytedance.android.ec.core.event.a.KEY_FROM);
        Intrinsics.checkNotNullParameter(r126, "to");
        LinkedHashMap r64 = (LinkedHashMap) r63.b;
        Object r127 = r64.get(r125);
        if (r127 != null) goto L108;
        r127 = new LinkedHashMap();
        r64.put(r125, r127);
    L108:
        Map r128 = (Map) r127;
        boolean r65 = false;
        r128.put(r126, Integer.valueOf(((Number) r128.getOrDefault(r126, 0)).intValue() + 1));
        System.out.println("🔁 行为模型记录跳转：" + r125 + " → " + r126 + " 次数=" + r128.get(r126));
        SceneDbManager r66 = (SceneDbManager) this.i.getValue();
        if (r66 == null) goto L111;
        com.bytedance.android.anniex.scene.data.b r67 = r66.j(r23, r61, r62);
    L112:
        r57.element = r67;
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$3$1(r61, r23, r62));
    L119:
        com.bytedance.android.anniex.scene.data.b r68 = (com.bytedance.android.anniex.scene.data.b) r57.element;
        if (r68 == null) goto L154;
        SceneConnectCenter.i(r23, r68);
        SceneConnectCenter.j(r23, r68);
        i r69 = new i(r23, r68);
        i r70 = this.e;
        if (r70 == null) goto L124;
        SceneConnectCenter.k(r70.a, r69.a, r70.b);
    L124:
        this.e = r69;
        String r71 = PredictManager.a;
        com.bytedance.android.anniex.scene.next.g r72 = new com.bytedance.android.anniex.scene.next.g(r23.a, r68.c, r68.d);
        Intrinsics.checkNotNullParameter(r72, "input");
        if (((Boolean) SwitchCenter.T.getValue()).booleanValue() == true) goto L127;
    L153:
        PredictManager.c(new com.bytedance.android.anniex.scene.next.f(r23.a, true, Double.valueOf(r68.c), Double.valueOf(((double) r68.b) / ((double) r68.a)), null));
        goto L154
    L127:
        if (((Boolean) SwitchCenter.a.getValue()).booleanValue() == false) goto L153;
        Map<String, Pair<Integer, Double>> r73 = r72.c;
        if (r73 != null) goto L132;
    L133:
        r65 = true;
    L135:
        if (r65 == false) goto L138;
        Lazy r74 = Evaluator.a;
        Intrinsics.checkNotNullParameter(PredictElementType.SceneId, "predictElementType");
        Evaluator.e.e++;
        Evaluator.b();
        goto L153
    L138:
        if (r72.b >= ((Number) SwitchCenter.W.getValue()).longValue()) goto L140;
        Lazy r75 = Evaluator.a;
        Intrinsics.checkNotNullParameter(PredictElementType.SceneId, "predictElementType");
        Evaluator.e.c++;
        Evaluator.b();
        goto L153
    L140:
        HybridLogger r76 = HybridLogger.a;
        HybridLogger.f("PredictManager", "调度预测任务: sceneId" + r72.a + ", avg duration:" + r72.b, null, 12);
        PredictManager.a();
        long r129 = System.currentTimeMillis();
        long r130 = ((Number) SwitchCenter.X.getValue()).longValue();
        if (PredictManager.e == true) goto L152;
        long r131 = r129 - PredictManager.d;
        if (r131 >= r130) goto L146;
        r58 = r130 - r131;
    L146:
        PredictManager.f = r72;
        PredictManager.e = true;
        va.a.C0207a r77 = va.a.g;
        va.a.b r78 = r77.a().b;
        if (r78 == null) goto L149;
        Message r79 = new Message();
        r79.what = 7;
        r79.obj = PredictManager.f;
        r78.sendMessageDelayed(r79, r58);
    L149:
        va.a.b r80 = r77.a().b;
        if (r80 == null) goto L153;
        Message r81 = new Message();
        r81.what = 8;
        r81.obj = PredictManager.b;
        r80.sendMessageDelayed(r81, r130);
        goto L153
    L152:
        Lazy r82 = Evaluator.a;
        Intrinsics.checkNotNullParameter(PredictElementType.SceneId, "predictElementType");
        Evaluator.e.d++;
        Evaluator.b();
        PredictManager.f = r72;
        goto L153
    L132:
        if (r73.isEmpty() == false) goto L135;
    L154:
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$5(r23, this));
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$6(r23, r57));
        za.b.a("AnnieXSceneManager", new SceneManager$handleSceneFingerprint$7(r57));
        e r83 = (e) this.b.getValue();
        r83.getClass();
        Intrinsics.checkNotNullParameter(r23, "sceneFingerprint");
        String r84 = r23.a;
        r83.a = r84;
        r83.put(r84, r23);
        this.d = r23;
        return;
    L111:
        r67 = null;
        goto L112
    L113:
        r65 = false;
        goto L119
    L103:
        r61 = null;
        goto L104
    L114:
        r65 = false;
        SceneDbManager r85 = (SceneDbManager) this.i.getValue();
        if (r85 == null) goto L117;
        SceneDbManager.a r86 = SceneDbManager.r;
        com.bytedance.android.anniex.scene.data.b r87 = r85.j(r23, null, 0);
    L118:
        r57.element = r87;
        goto L119
    L117:
        r87 = null;
    L16:
        th = move-exception;
        throw th;
    L19:
        r13 = null;
        goto L20
    L5:
        r11 = null;
        goto L7
    }

    public final void h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        if (Build.VERSION.SDK_INT < 26) goto L17;
        IdleSignalCenter r0 = IdleSignalCenter.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter("page_switch", "source");     // Catch: Throwable -> L13
        if (((Boolean) SwitchCenter.w.getValue()).booleanValue() == true) goto L10;
        monitor-exit(r0);
        goto L17
    L10:
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L13
        r0.b();     // Catch: Throwable -> L13
        IdleSignalCenter.a r11 = new IdleSignalCenter.a(r1 + 1000);     // Catch: Throwable -> L13
        ((ArrayList) IdleSignalCenter.b).add(r11);     // Catch: Throwable -> L13
        IdleSignalCenter.c.postDelayed(new com.bytedance.android.anniex.scene.handler.idle.a(r11), 1000);     // Catch: Throwable -> L13
        monitor-exit(r0);
    L13:
        th = move-exception;
        throw th;
    L17:
        if (((Boolean) SwitchCenter.a.getValue()).booleanValue() == false) goto L56;
        boolean r12 = false;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r10) == false) goto L39;
        Set r13 = (Set) SwitchCenter.h.getValue();
        if (r13 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L39;
        if (((Boolean) SwitchCenter.c.getValue()).booleanValue() == true) goto L38;
        Set r15 = (Set) SwitchCenter.i.getValue();
        if (r15 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 == false) goto L39;
    L34:
        if (r15.contains(r10) != true) goto L36;
        r16 = true;
    L38:
        r12 = true;
        goto L39
    L23:
        if (r13.contains(r10) != true) goto L25;
        r14 = true;
    L39:
        if (r12 == true) goto L42;
        return;
    L42:
        if (this.k == true) goto L44;
        f();
    L44:
        com.bytedance.android.anniex.scene.core.c r17 = new com.bytedance.android.anniex.scene.core.c(r10, System.currentTimeMillis());
        d r18 = (d) this.g.getValue();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "event");
        if (r18.b != 0) goto L47;
        r18.b = r17.b;
    L47:
        r18.a.add(r17);
        va.a.b r19 = c();
        if (r19 == null) goto L50;
        r19.removeMessages(2);
    L50:
        Message r20 = Message.obtain();
        r20.what = 2;
        r20.obj = r17;
        va.a.b r21 = c();
        if (r21 == null) goto L57;
        r21.sendMessageDelayed(r20, ((Number) SwitchCenter.k.getValue()).longValue());
        return;
    L57:
        return;
    }

    public final void g(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "type");
        if (c() == null) goto L5;
    L7:
        va.a.b r0 = c();
        if (r0 == null) goto L11;
        r0.post(new c(this, r10, r11));
        return;
    L11:
        return;
    L5:
        if (this.k == true) goto L7;
        f();
        goto L7
    }

    public final void i(String r13, String r14) {
        Lazy r0 = SwitchCenter.a;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.k == true) goto L9;
        f();
    L9:
        if (((Boolean) SwitchCenter.c.getValue()).booleanValue() == false) goto L16;
        if (this.l == true) goto L16;
        va.a.b r1 = c();
        if (r1 == null) goto L16;
        Message r10 = new Message();
        r10.what = 3;
        r1.sendMessage(r10);
    L16:
        if (Build.VERSION.SDK_INT >= 24) goto L18;
        return;
    L18:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r13) == true) goto L20;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L64;
        if (r14 != null) goto L31;
        return;
    L31:
        if (((LruCache) this.a.getValue()).get(r13) != null) goto L66;
        String r15 = za.c.a(r14);
        if (r15 == null) goto L67;
        HybridLogger r12 = HybridLogger.a;
        HotUrlCache r16 = null;
        HybridLogger.f("AnnieXSceneManager", "sendViewLoadEvent item: ".concat(r15), null, 12);
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L68;
        final k r17 = new k(r15, System.currentTimeMillis(), r13);
        com.bytedance.android.anniex.scene.core.a r18 = (com.bytedance.android.anniex.scene.core.a) this.f.getValue();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "viewAttachEvent");
        int r19 = za.b.a;
        za.b.a("AnnieXSceneManager", new AViewSignalBuffer$receive$1(r17));
        long r20 = System.currentTimeMillis();
        if (r18.c != 0) goto L39;
        r18.c = r20;
    L39:
        r18.d++;
        r18.b.add(r17);
        Map r21 = (Map) this.c.getValue();
        if (r21 == null) goto L42;
        r16 = (HotUrlCache) r21.get("");
    L42:
        if (r16 == null) goto L50;
        monitor-enter(r16);
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L47
        HotUrlCache$map$1 r22 = r16.b;     // Catch: Throwable -> L47
        r22.put(r15, Integer.valueOf(((Number) r22.getOrDefault(r15, 0)).intValue() + 1));     // Catch: Throwable -> L47
        monitor-exit(r16);
    L47:
        th = move-exception;
        throw th;
    L50:
        d r23 = (d) this.g.getValue();
        r23.a.clear();
        r23.b = 0;
        va.a.b r24 = c();
        if (r24 == null) goto L53;
        r24.removeMessages(2);
    L53:
        va.a.b r25 = c();
        if (r25 == null) goto L56;
        r25.removeMessages(1);
    L56:
        Message r26 = Message.obtain();
        r26.what = 1;
        r26.obj = r17;
        va.a.b r27 = c();
        if (r27 == null) goto L59;
        r27.sendMessageDelayed(r26, ((Number) SwitchCenter.j.getValue()).longValue());
    L59:
        ((LruCache) this.a.getValue()).put(r13, r15);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L64:
        return;
    L20:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r14) == false) goto L27;
        if (Intrinsics.areEqual(r13, "unknown") == true) goto L27;
        if (Intrinsics.areEqual(r14, "null") == true) goto L27;
        r11 = true;
        goto L28
    }
}
