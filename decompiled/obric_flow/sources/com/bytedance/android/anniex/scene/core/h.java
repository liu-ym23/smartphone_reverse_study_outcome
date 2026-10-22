package com.bytedance.android.anniex.scene.core;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f3396a;

    public h(j r5, Looper r10) {
        this.f3396a = r5;
        super(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public final void handleMessage(Message r28) {
        Intrinsics.checkNotNullParameter(r28, "msg");
        int r5 = r28.what;
        if (r5 != 1) goto L5;
        Integer r10 = 0;
        final j r11 = this.f3396a;
        r11.getClass();
        Function0<String> r12 = new SceneManager$receiveAViewSignal$1(r11);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r12, "message");
        com.lynx.tasm.utils.g.f(3, r12);
        a r13 = (a) r11.f.getValue();
        r13.getClass();
        long r14 = System.currentTimeMillis();
        long r15 = r13.f3382c;
        if (r15 > 0) goto L43;
        return;
    L43:
        if ((r14 - r15) < r13.f3380a) goto L164;
        a r16 = (a) r11.f.getValue();
        Set r17 = CollectionsKt.toSet(r16.f3381b);
        int r18 = r16.d;
        r16.f3381b.clear();
        r16.d = 0;
        r16.f3382c = 0;
        Intrinsics.checkNotNullParameter(r17, "attachEvent");
        if (r17.isEmpty() == true) goto L165;
        HashSet r19 = CollectionsKt.F(r17);
        k r20 = (k) CollectionsKt.firstOrNull(r17);
        if (r20 == null) goto L49;
        long r110 = r20.f3411b;
    L50:
        SceneOrigin r21 = SceneOrigin.f3377a;
        j.a();
        Intrinsics.checkNotNullParameter(r19, "aViewUrls");
        Intrinsics.checkNotNullParameter(r21, "origin");
        Intrinsics.checkNotNullParameter("", "attachScene");
        new LinkedHashMap();
        if (r17.size() != 1) goto L60;
        SceneOrigin r22 = r21;
        k r23 = (k) CollectionsKt.firstOrNull(r17);
        if (r23 == null) goto L59;
        String r24 = r23.f3412c;
        if (r24 == null) goto L59;
        String r25 = (String) ((LruCache) r11.f3406j.getValue()).get(r24);
        if (r25 == null) goto L59;
        Intrinsics.checkNotNullParameter(r25, "clientComponent");
    L62:
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.d.getValue()).booleanValue() == false) goto L64;
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("default_bid", "bid");
        Intrinsics.checkNotNullParameter(p3.c.class, "clazz");
        com.bytedance.android.anniex.base.service.c.a(p3.c.class, "default_bid");
    L64:
        String r26 = CollectionsKt.q(r19, ",", null, null, 0, null, SceneFingerprint$Builder$encodeUrls$1.f3351a, 30);
        Intrinsics.checkNotNullParameter(r26, "input");
        final f r27 = new f(r26, r19, r110, r22);
        r27.e = r25;
        r27.f = Integer.valueOf(r18);
        Map r29 = (Map) r11.f3403c.getValue();
        if (r29 != null) goto L67;
    L71:
        Function0<String> r30 = new SceneManager$handleSceneFingerprint$1();
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r30, "message");
        com.lynx.tasm.utils.g.f(3, r30);
        f r31 = r11.d;
        if (r31 == null) goto L119;
        Intrinsics.checkNotNullParameter(r27, "other");
        HashSet r32 = r31.f3392b;
        ArrayList r33 = new ArrayList(CollectionsKt.h(r32));
        Iterator r34 = r32.iterator();
    L75:
        if (r34.hasNext() == false) goto L77;
        r33.add(((k) r34.next()).f3410a);
        goto L75
    L77:
        Set r35 = CollectionsKt.toSet(r33);
        HashSet r36 = r27.f3392b;
        ArrayList r37 = new ArrayList(CollectionsKt.h(r36));
        Iterator r38 = r36.iterator();
    L79:
        if (r38.hasNext() == false) goto L81;
        r37.add(((k) r38.next()).f3410a);
        goto L79
    L81:
        Set r39 = CollectionsKt.toSet(r37);
        Set r40 = CollectionsKt.intersect(r35, r39);
        Set r41 = CollectionsKt.union(r35, r39);
        if (r41.isEmpty() == false) goto L84;
        final double r42 = 0.0d;
    L85:
        Intrinsics.checkNotNullParameter(r27, "other");
        Map r43 = GroupingKt.eachCount(new g8.g(r31.f3392b, 3));
        LinkedHashMap r44 = new LinkedHashMap(MapsKt.mapCapacity(r43.size()));
        Iterator r45 = r43.entrySet().iterator();
    L87:
        if (r45.hasNext() == false) goto L89;
        Map.Entry r46 = (Map.Entry) r45.next();
        Object r111 = r46.getKey();
        String r112 = (String) r46.getKey();
        r44.put(r111, Double.valueOf(((double) ((Number) r46.getValue()).intValue()) * 1.0d));
        r45 = r45;
        r10 = r10;
        goto L87
    L89:
        Integer r113 = r10;
        Map r47 = GroupingKt.eachCount(new jg.k(r27.f3392b, 3));
        LinkedHashMap r48 = new LinkedHashMap(MapsKt.mapCapacity(r47.size()));
        Iterator r49 = r47.entrySet().iterator();
    L91:
        if (r49.hasNext() == false) goto L93;
        Map.Entry r50 = (Map.Entry) r49.next();
        Object r114 = r50.getKey();
        String r210 = (String) r50.getKey();
        r48.put(r114, Double.valueOf(((double) ((Number) r50.getValue()).intValue()) * 1.0d));
        r49 = r49;
        r11 = r11;
        goto L91
    L93:
        final j r211 = r11;
        Iterator r51 = r44.entrySet().iterator();
        double r115 = 0.0d;
        double r212 = 0.0d;
    L95:
        if (r51.hasNext() == false) goto L101;
        Map.Entry r52 = (Map.Entry) r51.next();
        String r53 = (String) r52.getKey();
        double r213 = ((Number) r52.getValue()).doubleValue();
        Double r54 = (Double) r48.get(r53);
        if (r54 == null) goto L99;
        double r214 = r54.doubleValue();
    L100:
        r212 = (r214 * r213) + r212;
        r115 = (r213 * r213) + r115;
        goto L95
    L99:
        r214 = 0.0d;
        goto L100
    L101:
        Iterator r55 = r48.values().iterator();
        double r56 = 0.0d;
    L103:
        if (r55.hasNext() == false) goto L106;
        double r215 = ((Number) r55.next()).doubleValue();
        r56 = (r215 * r215) + r56;
        goto L103
    L106:
        if (r115 != 0.0d) goto L109;
    L110:
        final double r57 = 0.0d;
    L112:
        Function0<String> r58 = new SceneManager$handleSceneFingerprint$2$1(r42, r57);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r58, "message");
        com.lynx.tasm.utils.g.f(3, r58);
        if (r42 < ((Number) com.bytedance.android.anniex.scene.settings.a.f3451i.getValue()).doubleValue()) goto L115;
    L118:
        Function0<String> r59 = new SceneManager$handleSceneFingerprint$2$2(r27, r211);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r59, "message");
        com.lynx.tasm.utils.g.f(3, r59);
        return;
    L115:
        if (r57 >= ((Number) com.bytedance.android.anniex.scene.settings.a.f3452j.getValue()).doubleValue()) goto L118;
        final j r60 = r211;
    L120:
        b r61 = (b) r60.f3404h.getValue();
        r61.getClass();
        Intrinsics.checkNotNullParameter(r27, "scene");
        String r62 = r27.f3391a;
        LinkedHashMap r63 = r61.f3383a;
        r63.put(r62, Integer.valueOf(((Number) r63.getOrDefault(r62, r113)).intValue() + 1));
        String r64 = "📊 行为模型记录场景：" + r62 + " 次数=" + r63.get(r62);
        PrintStream r65 = System.out;
        r65.println(r64);
        final Ref.ObjectRef r66 = new Ref.ObjectRef();
        if (((e) r60.f3402b.getValue()).size() <= 0) goto L136;
        e r67 = (e) r60.f3402b.getValue();
        String r68 = r67.f3390a;
        if (r68 == null) goto L125;
        final f r69 = (f) r67.get(r68);
    L126:
        if (r69 == null) goto L141;
        final long r70 = r27.f3393c - r69.f3393c;
        b r116 = (b) r60.f3404h.getValue();
        String r117 = r69.f3391a;
        String r71 = r27.f3391a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "from");
        Intrinsics.checkNotNullParameter(r71, "to");
        LinkedHashMap r118 = r116.f3384b;
        Object r119 = r118.get(r117);
        if (r119 != null) goto L130;
        r119 = new LinkedHashMap();
        r118.put(r117, r119);
    L130:
        Map r120 = (Map) r119;
        r120.put(r71, Integer.valueOf(((Number) r120.getOrDefault(r71, r113)).intValue() + 1));
        StringBuilder r121 = new StringBuilder("🔁 行为模型记录跳转：");
        f8.b.e(r121, r117, " → ", r71, " 次数=");
        r121.append(r120.get(r71));
        r65.println(r121.toString());
        com.bytedance.android.anniex.scene.data.a r72 = (com.bytedance.android.anniex.scene.data.a) r60.f3405i.getValue();
        if (r72 == null) goto L133;
        T r122 = r72.b(r27, r69.f3391a, r70);
    L134:
        r66.element = r122;
        Function0<String> r73 = new SceneManager$handleSceneFingerprint$3$1(r69, r27, r70);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r73, "message");
        com.lynx.tasm.utils.g.f(3, r73);
        goto L141
    L133:
        r122 = 0;
    L141:
        com.bytedance.android.anniex.scene.data.b r74 = (com.bytedance.android.anniex.scene.data.b) r66.element;
        if (r74 == null) goto L147;
        com.bytedance.android.anniex.scene.connect.a.e(r27, r74);
        com.bytedance.android.anniex.scene.connect.a.f(r27, r74);
        g r75 = new g(r27, r74);
        g r76 = r60.e;
        if (r76 == null) goto L146;
        com.bytedance.android.anniex.scene.connect.a.c(r76.f3394a, r27, r76.f3395b);
    L146:
        r60.e = r75;
    L147:
        Function0<String> r77 = new SceneManager$handleSceneFingerprint$5(r27, r60);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r77, "message");
        com.lynx.tasm.utils.g.f(3, r77);
        Function0<String> r78 = new SceneManager$handleSceneFingerprint$6(r27, r66);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r78, "message");
        com.lynx.tasm.utils.g.f(3, r78);
        Function0<String> r79 = new SceneManager$handleSceneFingerprint$7(r66);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r79, "message");
        com.lynx.tasm.utils.g.f(3, r79);
        e r80 = (e) r60.f3402b.getValue();
        r80.getClass();
        Intrinsics.checkNotNullParameter(r27, "sceneFingerprint");
        String r81 = r27.f3391a;
        r80.f3390a = r81;
        r80.put(r81, r27);
        r60.d = r27;
        return;
    L125:
        r69 = null;
        goto L126
    L136:
        com.bytedance.android.anniex.scene.data.a r82 = (com.bytedance.android.anniex.scene.data.a) r60.f3405i.getValue();
        if (r82 == null) goto L139;
        T r123 = r82.b(r27, null, 0);
    L140:
        r66.element = r123;
        goto L141
    L139:
        r123 = 0;
        goto L140
    L109:
        if (r56 == 0.0d) goto L110;
        r57 = r212 / (Math.sqrt(r56) * Math.sqrt(r115));
        goto L112
    L84:
        r42 = ((double) r40.size()) / ((double) r41.size());
        goto L85
    L119:
        r113 = null;
        r60 = r11;
        goto L120
    L67:
        if (r29.get("") == null) goto L71;
        throw new ClassCastException();
    L59:
        r25 = "";
        goto L62
    L60:
        r22 = r21;
        goto L59
    L49:
        r110 = System.currentTimeMillis();
        goto L50
    L165:
        return;
    L164:
        return;
    L5:
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L162;
        j r83 = this.f3396a;
        r83.getClass();
        Application r84 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r84 != null) goto L11;
        return;
    L11:
        if (d4.a.f16589b != null) goto L13;
        d4.a.f16589b = new d4.a();
    L13:
        d4.a r85 = d4.a.f16589b;
        Intrinsics.checkNotNull(r85);
        r85.getClass();
        Intrinsics.checkNotNullParameter(r84, "application");
        if (r85.f16590a == true) goto L16;
        r84.registerActivityLifecycleCallbacks(r85);
    L16:
        r85.f16590a = true;
        r83.f3409m = true;
        return;
    L162:
        return;
    L18:
        j r86 = this.f3396a;
        d r87 = (d) r86.g.getValue();
        r87.getClass();
        long r124 = System.currentTimeMillis();
        long r88 = r87.f3388b;
        if (r88 > 0) goto L21;
        return;
    L21:
        if ((r124 - r88) < r87.f3389c) goto L159;
        d r89 = (d) r86.g.getValue();
        if (r89.f3387a.isEmpty() == false) goto L25;
        r89.f3387a.clear();
        r89.f3388b = 0;
        final c r125 = null;
    L26:
        if (r125 == null) goto L160;
        j.a();
        LinkedHashSet r90 = new LinkedHashSet();
        long r91 = r125.f3386b;
        SceneOrigin r126 = SceneOrigin.f3378b;
        Intrinsics.checkNotNullParameter(r90, "aViewUrls");
        Intrinsics.checkNotNullParameter(r126, "origin");
        Intrinsics.checkNotNullParameter("", "attachScene");
        new LinkedHashMap();
        String r92 = r125.f3385a;
        Intrinsics.checkNotNullParameter(r92, "eventName");
        Intrinsics.checkNotNullParameter(r92, "input");
        final f r93 = new f(r92, r90, r91, r126);
        r93.e = "";
        r93.f = 0;
        r86.d = null;
        Function0<String> r94 = new SceneManager$handleLifecycleResumeEvent$1(r125);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r94, "message");
        com.lynx.tasm.utils.g.f(3, r94);
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3448b.getValue()).booleanValue() == false) goto L161;
        com.bytedance.android.anniex.scene.data.a r95 = (com.bytedance.android.anniex.scene.data.a) r86.f3405i.getValue();
        if (r95 == null) goto L32;
        final com.bytedance.android.anniex.scene.data.b r127 = r95.b(r93, null, 0);
    L33:
        if (r127 == null) goto L38;
        com.bytedance.android.anniex.scene.connect.a.e(r93, r127);
        com.bytedance.android.anniex.scene.connect.a.f(r93, r127);
        g r96 = new g(r93, r127);
        g r97 = r86.e;
        if (r97 == null) goto L37;
        com.bytedance.android.anniex.scene.connect.a.c(r97.f3394a, r93, r97.f3395b);
    L37:
        r86.e = r96;
    L38:
        Function0<String> r98 = new SceneManager$handleLifecycleResumeEvent$3(r93, r127);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r98, "message");
        com.lynx.tasm.utils.g.f(3, r98);
        Function0<String> r99 = new SceneManager$handleLifecycleResumeEvent$4(r127);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r99, "message");
        com.lynx.tasm.utils.g.f(3, r99);
        e r100 = (e) r86.f3402b.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r93, "sceneFingerprint");
        r100.f3390a = r92;
        r100.put(r92, r93);
        return;
    L32:
        r127 = null;
        goto L33
    L161:
        return;
    L160:
        return;
    L25:
        r125 = (c) CollectionsKt.lastOrNull(r89.f3387a);
        r89.f3387a.clear();
        r89.f3388b = 0;
        goto L26
    }
}
