package com.bytedance.android.anniex.detect;

import android.os.Build;
import android.view.View;
import com.bytedance.android.anniex.ability.service.AnnieXPitayaProvider;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep;
import com.bytedance.android.anniex.detect.detection.PureColorDetectionStep;
import com.bytedance.android.anniex.detect.snapshot.PixelCopyStep;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXBlankDetectorManager {
    public static final AnnieXBlankDetectorManager$lastViewHashCodes$1 a = null;
    public static final AnnieXBlankDetectorManager$urlLruCache$1 b = null;
    public static final Map<String, String> c = null;
    public static final Lazy d = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$lastViewHashCodes$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$urlLruCache$1] */
    static {
        a = new AnnieXBlankDetectorManager$lastViewHashCodes$1();
        b = new AnnieXBlankDetectorManager$urlLruCache$1();
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L7;
        com.bytedance.ies.bullet.base.settings.j r10 = (com.bytedance.ies.bullet.base.settings.j) r1.n0(com.bytedance.ies.bullet.base.settings.j.class);
        if (r10 == null) goto L7;
        Map<String, String> r11 = r10.a();
    L8:
        c = r11;
        d = LazyKt.lazy(AnnieXBlankDetectorManager$blankDetectorConfig$2.INSTANCE);
        return;
    L7:
        r11 = null;
        goto L8
    }

    public static d b() {
        return (d) d.getValue();
    }

    public static e a(t36.d r10) {
        if (r10 != null) goto L7;
        HybridLogger.m("AnnieXBlankDetect", "view  or schemaData is null", null, null, 12);
        return null;
    L7:
        if (b().a == true) goto L11;
        HybridLogger.m("AnnieXBlankDetect", "总开关关闭，无需白屏检测", null, null, 12);
        return null;
    L11:
        if (b().c == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        if (r11 == false) goto L19;
        AnnieXServiceCenter.a.getClass();
        AnnieXPitayaProvider r12 = (AnnieXPitayaProvider) AnnieXServiceCenter.d("default_bid", AnnieXPitayaProvider.class);
        HybridLogger.m("AnnieXBlankDetect", "Pitaya 没有 Ready 时不开启，无需白屏检测", null, null, 12);
        return null;
    L19:
        Lazy r0 = SchemaService.f;
        SchemaService.a.a().getClass();
        ma.a r1 = (ma.a) SchemaService.d(r10, ma.a.class);
        String r13 = (String) r10.c().get(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r13 == null) goto L50;
        a36.a r14 = new a36.a(UriProtector.parse(r13));
        String r15 = r14.b();
        if (r1 == null) goto L29;
        y36.i r16 = r1.a;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("enableBlankDetect");
        r16 = null;
    L27:
        if (r16 == null) goto L29;
        boolean r17 = Intrinsics.areEqual(Boolean.TRUE, r16.b);
    L30:
        if (r17 == false) goto L38;
        y36.i r18 = r1.b;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("bdhmBid");
        r18 = null;
    L35:
        String r19 = (String) r18.b;
        if (r19 == null) goto L38;
        return new e(r19, r15, r14, r10.getOriginUrl());
    L38:
        Map<String, String> r20 = c;
        if (r20 == null) goto L52;
        Iterator<Map.Entry<String, String>> r21 = r20.entrySet().iterator();
    L42:
        if (r21.hasNext() == false) goto L53;
        Map.Entry<String, String> r22 = r21.next();
        if (StringsKt.contains$default(r15, r22.getKey(), false, 2, null) == false) goto L42;
        return new e(r22.getValue(), r15, r14, r10.getOriginUrl());
    L53:
        return null;
    L52:
        return null;
    L29:
        r17 = false;
        goto L30
    L50:
        return null;
    L13:
        if (b().b == true) goto L15;
        r11 = true;
        goto L16
    }

    public static void c(View r13, t36.d r14) {
        e r15 = a(r14);
        if (r15 != null) goto L5;
        return;
    L5:
        AnnieXBlankDetectorManager$urlLruCache$1 r1 = b;
        monitor-enter(r1);
        Long r10 = r1.get(r15.b);     // Catch: Throwable -> L31
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (r10 != null) goto L10;
    L14:
        r1.put(r15.b, Long.valueOf(r11));     // Catch: Throwable -> L31
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r1);
        if (r13 == null) goto L35;
        int r12 = r13.hashCode();
        AnnieXBlankDetectorManager$lastViewHashCodes$1 r16 = a;
        if (r16.containsKey(Integer.valueOf(r12)) == false) goto L21;
        HybridLogger.m("AnnieXBlankDetect", "View 已检测过，无需重复检测", null, null, 12);
        return;
    L21:
        r16.put(Integer.valueOf(r12), Boolean.TRUE);
        if (Build.VERSION.SDK_INT < 26) goto L36;
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.f("AnnieXBlankDetect", "开启白屏检测, config: " + r15, null, 12);
        List r18 = CollectionsKt.listOf(new PixelCopyStep(b().e, b().f));
        ArrayList r19 = new ArrayList();
        if (b().b == false) goto L27;
        r19.add(new PureColorDetectionStep(b().h, b().g));
    L27:
        if (b().c == false) goto L29;
        r19.add(new PartialBlankDetectionStep(b().i, new AnnieXBlankDetectorManager$getBlankDetections$1(null)));
    L29:
        SnapshotPipeline r20 = new SnapshotPipeline(r18);
        int r21 = i.a;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnnieXBlankDetectorManager$observeAViewResult$1(new b(r20, new DetectionPipeline(r19, InterruptStrategies$interruptOnHighConfidence$1.INSTANCE)), r13, r15, null), 3, null);
        return;
    L36:
        return;
    L35:
        return;
    L10:
        if ((r11 - r10.longValue()) >= b().j) goto L14;
        HybridLogger r110 = HybridLogger.a;     // Catch: Throwable -> L31
        HybridLogger.f("AnnieXBlankDetect", "URL 检测过于频繁，跳过：" + r15 + ".urlBase", null, 12);     // Catch: Throwable -> L31
        monitor-exit(r1);
        return;
    L31:
        th = move-exception;
        throw th;
    }
}
