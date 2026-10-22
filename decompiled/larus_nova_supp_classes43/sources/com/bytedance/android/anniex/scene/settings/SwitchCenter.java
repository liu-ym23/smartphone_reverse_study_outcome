package com.bytedance.android.anniex.scene.settings;

import android.net.Uri;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SwitchCenter {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final Lazy C = null;
    public static final Lazy D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final Lazy G = null;
    public static final Lazy H = null;
    public static final Lazy I = null;
    public static final Lazy J = null;
    public static final Lazy K = null;
    public static final Lazy L = null;
    public static final Lazy M = null;
    public static final Lazy N = null;
    public static final Lazy O = null;
    public static final Lazy P = null;
    public static final Lazy Q = null;
    public static final Lazy R = null;
    public static final Lazy S = null;
    public static final Lazy T = null;
    public static final Lazy U = null;
    public static final Lazy V = null;
    public static final Lazy W = null;
    public static final Lazy X = null;
    public static final Lazy Y = null;
    public static final Lazy Z = null;
    public static final Lazy a = null;
    public static final Lazy a0 = null;
    public static final Lazy b = null;
    public static final Lazy b0 = null;
    public static final Lazy c = null;
    public static final Lazy c0 = null;
    public static final Lazy d = null;
    public static final Lazy d0 = null;
    public static final Lazy e = null;
    public static final Lazy e0 = null;
    public static final Lazy f = null;
    public static final Lazy f0 = null;
    public static final Lazy g = null;
    public static final Lazy g0 = null;
    public static final Lazy h = null;
    public static final Lazy h0 = null;
    public static final Lazy i = null;
    public static final Lazy i0 = null;
    public static final Lazy j = null;
    public static final Lazy j0 = null;
    public static final Lazy k = null;
    public static final Lazy k0 = null;
    public static final Lazy l = null;
    public static final Lazy l0 = null;
    public static final Lazy m = null;
    public static final Lazy m0 = null;
    public static final Lazy n = null;
    public static final Lazy n0 = null;
    public static final Lazy o = null;
    public static final Lazy o0 = null;
    public static final Lazy p = null;
    public static final Lazy p0 = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final Lazy w = null;
    public static final Lazy x = null;
    public static final Lazy y = null;
    public static final Lazy z = null;

    static {
        a = LazyKt.lazy(SwitchCenter$enableScene$2.INSTANCE);
        b = LazyKt.lazy(SwitchCenter$pageStackSubscribeDelay$2.INSTANCE);
        c = LazyKt.lazy(SwitchCenter$enableNaStackStore$2.INSTANCE);
        d = LazyKt.lazy(SwitchCenter$enableViewAttachWithoutSessionId$2.INSTANCE);
        e = LazyKt.lazy(SwitchCenter$enableSceneBcmChainInfo$2.INSTANCE);
        f = LazyKt.lazy(SwitchCenter$bcmChainLength$2.INSTANCE);
        g = LazyKt.lazy(SwitchCenter$domainStandard$2.INSTANCE);
        h = LazyKt.lazy(SwitchCenter$pageStackBlackList$2.INSTANCE);
        i = LazyKt.lazy(SwitchCenter$pageStackWhiteList$2.INSTANCE);
        j = LazyKt.lazy(SwitchCenter$hybridViewWindowDurationMs$2.INSTANCE);
        k = LazyKt.lazy(SwitchCenter$pageStackWindowDurationMs$2.INSTANCE);
        l = LazyKt.lazy(SwitchCenter$hotUrlCacheMaxSize$2.INSTANCE);
        m = LazyKt.lazy(SwitchCenter$sceneCountMapSize$2.INSTANCE);
        n = LazyKt.lazy(SwitchCenter$jaccardThreshold$2.INSTANCE);
        o = LazyKt.lazy(SwitchCenter$cosineThreshold$2.INSTANCE);
        p = LazyKt.lazy(SwitchCenter$recentSceneLruCacheMaxSize$2.INSTANCE);
        q = LazyKt.lazy(SwitchCenter$sceneTableMaxCount$2.INSTANCE);
        r = LazyKt.lazy(SwitchCenter$transitionTableMaxCount$2.INSTANCE);
        s = LazyKt.lazy(SwitchCenter$sqliteDataExpireMs$2.INSTANCE);
        t = LazyKt.lazy(SwitchCenter$sqliteCleanThreshold$2.INSTANCE);
        u = LazyKt.lazy(SwitchCenter$sqliteReportThreshold$2.INSTANCE);
        v = LazyKt.lazy(SwitchCenter$sqliteTransFlushThreshold$2.INSTANCE);
        w = LazyKt.lazy(SwitchCenter$enableUrlUsageTrack$2.INSTANCE);
        x = LazyKt.lazy(SwitchCenter$enableTopUsageUrlCodeCache$2.INSTANCE);
        y = LazyKt.lazy(SwitchCenter$enableTopUsageUrlCodeCacheTask$2.INSTANCE);
        z = LazyKt.lazy(SwitchCenter$urlUsageFlushInterval$2.INSTANCE);
        A = LazyKt.lazy(SwitchCenter$urlUsageQueryThreshold$2.INSTANCE);
        B = LazyKt.lazy(SwitchCenter$urlUsageFlushDelay$2.INSTANCE);
        C = LazyKt.lazy(SwitchCenter$urlUsageClearThreshold$2.INSTANCE);
        D = LazyKt.lazy(SwitchCenter$urlUsageDecayFactor$2.INSTANCE);
        E = LazyKt.lazy(SwitchCenter$urlRecordTableSize$2.INSTANCE);
        F = LazyKt.lazy(SwitchCenter$enableTopUsageUrlCodeCacheBlacklist$2.INSTANCE);
        G = LazyKt.lazy(SwitchCenter$topUsageCodeCacheMaxSize$2.INSTANCE);
        H = LazyKt.lazy(SwitchCenter$topUsageCodeCacheTargetSize$2.INSTANCE);
        I = LazyKt.lazy(SwitchCenter$codeCachePreloadInterval$2.INSTANCE);
        J = LazyKt.lazy(SwitchCenter$codeCachePreloadTaskRunInterval$2.INSTANCE);
        K = LazyKt.lazy(SwitchCenter$codeCachePreloadTaskInterval$2.INSTANCE);
        L = LazyKt.lazy(SwitchCenter$enableCodeCacheClear$2.INSTANCE);
        M = LazyKt.lazy(SwitchCenter$codeCacheClearInterval$2.INSTANCE);
        N = LazyKt.lazy(SwitchCenter$urlUsageQueryInterval$2.INSTANCE);
        O = LazyKt.lazy(SwitchCenter$codeCachePreloadByPv$2.INSTANCE);
        P = LazyKt.lazy(SwitchCenter$codeCachePreloadByScore$2.INSTANCE);
        Q = LazyKt.lazy(SwitchCenter$codeCachePreloadScoreModel$2.INSTANCE);
        R = LazyKt.lazy(SwitchCenter$usageDebugMonitorEnable$2.INSTANCE);
        S = LazyKt.lazy(SwitchCenter$codeCacheOnlyForDefault$2.INSTANCE);
        T = LazyKt.lazy(SwitchCenter$enableNextPredict$2.INSTANCE);
        U = LazyKt.lazy(SwitchCenter$enableFuzzyPredict$2.INSTANCE);
        V = LazyKt.lazy(SwitchCenter$enableRepeatPredict$2.INSTANCE);
        W = LazyKt.lazy(SwitchCenter$predictMinSceneAvgDuration$2.INSTANCE);
        X = LazyKt.lazy(SwitchCenter$predictMinIntervalMs$2.INSTANCE);
        Y = LazyKt.lazy(SwitchCenter$predictStatsReportInterval$2.INSTANCE);
        Z = LazyKt.lazy(SwitchCenter$enableThresholdStrategy$2.INSTANCE);
        a0 = LazyKt.lazy(SwitchCenter$commonStrategyThreshold$2.INSTANCE);
        b0 = LazyKt.lazy(SwitchCenter$repeatStrategyThreshold$2.INSTANCE);
        c0 = LazyKt.lazy(SwitchCenter$topNStrategyN$2.INSTANCE);
        d0 = LazyKt.lazy(SwitchCenter$nextPreloadLruSize$2.INSTANCE);
        e0 = LazyKt.lazy(SwitchCenter$enableBundlePreload$2.INSTANCE);
        f0 = LazyKt.lazy(SwitchCenter$sceneBundlePreloadSize$2.INSTANCE);
        g0 = LazyKt.lazy(SwitchCenter$enableWebPreConnect$2.INSTANCE);
        h0 = LazyKt.lazy(SwitchCenter$enableGetTemplateBundleByClientAI$2.INSTANCE);
        i0 = LazyKt.lazy(SwitchCenter$enableTimingQuery$2.INSTANCE);
        j0 = LazyKt.lazy(SwitchCenter$enableTimingPreloadTask$2.INSTANCE);
        k0 = LazyKt.lazy(SwitchCenter$fuzzyStrategyThreshold$2.INSTANCE);
        l0 = LazyKt.lazy(SwitchCenter$fuzzyExpansionFactor$2.INSTANCE);
        m0 = LazyKt.lazy(SwitchCenter$enablePerformanceReverse$2.INSTANCE);
        n0 = LazyKt.lazy(SwitchCenter$reverseDelayTime$2.INSTANCE);
        o0 = LazyKt.lazy(SwitchCenter$reverseAll$2.INSTANCE);
        p0 = LazyKt.lazy(SwitchCenter$reverseAllList$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) e0.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) R.getValue()).booleanValue();
    }

    public static boolean a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (((Boolean) m0.getValue()).booleanValue() == false) goto L20;
        String r11 = r10.toString();
        if (((Boolean) o0.getValue()).booleanValue() == true) goto L12;
        Iterator r0 = ((Collection) p0.getValue()).iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (StringsKt.contains$default(r11, (String) r0.next(), false, 2, null) == false) goto L9;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L21;
        return true;
    L21:
        return false;
    L12:
        r12 = true;
        goto L14
    L20:
        return false;
    }
}
