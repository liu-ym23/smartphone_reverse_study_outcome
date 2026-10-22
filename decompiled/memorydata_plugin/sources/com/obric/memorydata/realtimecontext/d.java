package com.obric.memorydata.realtimecontext;

import android.app.assist.AssistStructure;
import android.content.ComponentName;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneSettings;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0018J\u001f\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u001aJ\u001f\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u001cJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u001eJ\u001f\u0010\u000e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\u0018J\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0002J\u001d\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001fH\u0000¢\u0006\u0002\b(J\u0012\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0014H\u0002J.\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\u001c\u00101\u001a\u00020\u0017*\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneRuleManager;", "", "<init>", "()V", "TAG", "", "cacheLock", "cachedSettingsText", "cachedSettings", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneSettings;", "preparedRuleCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneRuleCacheKey;", "Lcom/obric/memorydata/realtimecontext/ActionRecommendScenePreparedRule;", "match", "", MemoryInfoSectionEditActivity.KIND_SCENE, "componentName", "Landroid/content/ComponentName;", "assistStructure", "Landroid/app/assist/AssistStructure;", "viewNodes", "", "Lcom/obric/memorydata/realtimecontext/ActionRecommendViewNodeInfo;", "match$realtime_context_obricRelease", LBSLightLocationTraceLogger.PREPARE, "prepare$realtime_context_obricRelease", "shouldCollectViewNodes", "shouldCollectViewNodes$realtime_context_obricRelease", "hasRuleComponent", "hasRuleComponent$realtime_context_obricRelease", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneMatchResult;", "preparedRule", "collectViewNodes", "collectViewNodes$realtime_context_obricRelease", "getCachedSettingsSnapshot", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneSettingsSnapshot;", "logMatchResult", "", "result", "logMatchResult$realtime_context_obricRelease", "collectViewNode", "node", "Landroid/app/assist/AssistStructure$ViewNode;", "nodes", "", "windowWidth", "", "windowHeight", "toActionRecommendViewNodeInfo", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f12462b = null;
    private static String c;
    private static ActionRecommendSceneSettings d;
    private static final ConcurrentHashMap<c, b> e = null;

    static {
        f12461a = new d();
        f12462b = new Object();
        d = new ActionRecommendSceneSettings(false, null, 3, null);
        e = new ConcurrentHashMap();
    }

    private d() {
    }

    private final g a() {
        String r10 = SettingsManager.INSTANCE.getSettingsStr(SettingsManager.KEY_ACTION_RECOMMEND_SCENE_RULES);
        Object r0 = f12462b;
        monitor-enter(r0);
        int r2 = 0;
        if (Intrinsics.areEqual(r10, c) == true) goto L17;
        c = r10;     // Catch: Throwable -> L23
        if (r10 != null) goto L26;
    L15:
        ActionRecommendSceneSettings r11 = new ActionRecommendSceneSettings(false, null, 3, null);     // Catch: Throwable -> L23
    L16:
        d = r11;     // Catch: Throwable -> L23
        e.clear();     // Catch: Throwable -> L23
        goto L17
    L26:
        Object r12 = SettingsManager.INSTANCE.getGSON().fromJson(r10, ActionRecommendSceneSettings.class);     // Catch: Exception -> L11 Throwable -> L23
    L13:
        r11 = (ActionRecommendSceneSettings) ZeusTransformUtils.preCheckCast(r12, ActionRecommendSceneSettings.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r11 != null) goto L16;
    L11:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);     // Catch: Throwable -> L23
        r12 = null;
    L17:
        ActionRecommendSceneSettings r1 = d;     // Catch: Throwable -> L23
        String r3 = c;     // Catch: Throwable -> L23
        if (r3 == null) goto L20;
        r2 = r3.hashCode();     // Catch: Throwable -> L23
    L20:
        g r13 = new g(r1, r2);     // Catch: Throwable -> L23
        monitor-exit(r0);
        return r13;
    L23:
        th = move-exception;
        throw th;
    }

    public final a a(b r1, AssistStructure r2) {
        Intrinsics.checkNotNullParameter(r1, "preparedRule");
        return f.f12463a.a(r1, r2);
    }

    public final b a(String r17, ComponentName r18) {
        Intrinsics.checkNotNullParameter(r17, MemoryInfoSectionEditActivity.KIND_SCENE);
        if (r18 == null) goto L5;
        g r0 = a();
        com.obric.memorydata.utils.c r1 = com.obric.memorydata.utils.c.f13193a;
        String r2 = r18.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r2, "getPackageName(...)");
        com.obric.memorydata.utils.c.a r3 = com.obric.memorydata.utils.c.a(r1, r2, null, 2, null);
        if (r3 == null) goto L9;
        long r4 = r3.b();
    L10:
        long r10 = r4;
        String r5 = r18.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r5, "getPackageName(...)");
        String r6 = r18.getClassName();
        Intrinsics.checkNotNullExpressionValue(r6, "getClassName(...)");
        c r12 = new c(r17, r5, r6, r10, r0.b());
        ConcurrentMap r15 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(e, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r7 = r15.get(r12);
        if (r7 != null) goto L15;
        f r8 = f.f12463a;
        ActionRecommendSceneSettings r9 = r0.a();
        String r11 = r18.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r11, "getPackageName(...)");
        String r13 = r18.getClassName();
        Intrinsics.checkNotNullExpressionValue(r13, "getClassName(...)");
        b r14 = r8.a(r9, r17, r11, r13, r10);
        r7 = r15.putIfAbsent(r12, r14);
        if (r7 != null) goto L15;
        r7 = r14;
    L15:
        Intrinsics.checkNotNullExpressionValue(r7, "getOrPut(...)");
        return (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
    L9:
        r4 = -1;
        goto L10
    L5:
        return b.f12443a.a(r17, "", "", -1, "scene component missing");
    }

    public final void a(b r7, a r8) {
        Intrinsics.checkNotNullParameter(r7, "preparedRule");
        Intrinsics.checkNotNullParameter(r8, "result");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActionRecommendSceneRule", r8.b() + ", scene=" + r7.a() + ", componentName=" + r7.b() + '/' + r7.c() + ", nodes=" + r8.c(), false, 4, null);
    }

    public final boolean b(String r2, ComponentName r3) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.KIND_SCENE);
        return a(r2, r3).f();
    }
}
