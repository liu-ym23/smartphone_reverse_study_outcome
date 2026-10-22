package com.obric.memorydata.realtimecontext;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.ActionRecommendScene;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneActivity;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneApp;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneSettings;
import com.obric.memorydata.middleware.api.settings.ActionRecommendSceneVersion;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJD\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0013J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0013J\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u0011*\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J*\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u001e\u0010%\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\f\u0010'\u001a\u00020\u001c*\u00020(H\u0002J\u001a\u0010)\u001a\u00020**\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010+H\u0002¨\u0006-"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneRuleMatcher;", "", "<init>", "()V", "needsViewTree", "", "settings", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneSettings;", MemoryInfoSectionEditActivity.KIND_SCENE, "", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "versionCode", "", LBSLightLocationTraceLogger.PREPARE, "Lcom/obric/memorydata/realtimecontext/ActionRecommendScenePreparedRule;", "match", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneMatchResult;", "viewNodesProvider", "Lkotlin/Function0;", "", "Lcom/obric/memorydata/realtimecontext/ActionRecommendViewNodeInfo;", "preparedRule", "assistStructure", "Landroid/app/assist/AssistStructure;", "preCheckResult", "matchAssistStructure", "rule", "Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;", "visitViewNode", "node", "Landroid/app/assist/AssistStructure$ViewNode;", "windowWidth", "", "windowHeight", "state", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneRuleMatcher$StreamingMatchState;", "matchNodes", "nodes", "toCompiledRule", "Lcom/obric/memorydata/middleware/api/settings/ActionRecommendSceneActivity;", "toCompiledConditionGroup", "Lcom/obric/memorydata/realtimecontext/CompiledSceneConditionGroup;", "", "StreamingMatchState", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12463a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneRuleMatcher$StreamingMatchState;", "", "rule", "Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;", "<init>", "(Lcom/obric/memorydata/realtimecontext/CompiledActionRecommendSceneRule;)V", "whiteListMatched", "", EventBody.KEY_VALUE, "", "nodeCount", "getNodeCount", "()I", "onNode", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneMatchResult;", "node", "Lcom/obric/memorydata/realtimecontext/ActionRecommendViewNodeInfo;", "finish", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f12464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12465b;
        private int c;

        public a(k r2) {
            Intrinsics.checkNotNullParameter(r2, "rule");
            this.f12464a = r2;
            this.f12465b = r2.a().isEmpty();
        }

        public final int a() {
            return this.c;
        }

        public final com.obric.memorydata.realtimecontext.a a(h r7) {
            Intrinsics.checkNotNullParameter(r7, "node");
            this.c++;
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f12464a.b(), Iterable.class, "com.obric.memorydata.plugin");
            boolean r4 = false;
            if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
        L7:
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L6;
            if (((m) ZeusTransformUtils.preCheckCast(r1.next(), m.class, "com.obric.memorydata.plugin")).a(r7) == false) goto L9;
            boolean r2 = true;
        L13:
            if (r2 == false) goto L17;
            return new com.obric.memorydata.realtimecontext.a(false, "scene rule skipped, blackList hit", this.c);
        L17:
            if (this.f12465b == true) goto L34;
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f12464a.a(), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L21;
        L23:
            Iterator r5 = r3.iterator();
        L25:
            if (r5.hasNext() == false) goto L29;
            if (((m) ZeusTransformUtils.preCheckCast(r5.next(), m.class, "com.obric.memorydata.plugin")).a(r7) == false) goto L25;
            r4 = true;
        L29:
            if (r4 == false) goto L42;
            this.f12465b = true;
            if (this.f12464a.b().isEmpty() == true) goto L33;
            return null;
        L33:
            return new com.obric.memorydata.realtimecontext.a(true, "scene rule matched", this.c);
        L42:
            return null;
        L21:
            if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
        L34:
            return null;
        L6:
            r2 = false;
            goto L13
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
            goto L6
        }

        public final com.obric.memorydata.realtimecontext.a b() {
            if (this.f12465b == true) goto L7;
            return new com.obric.memorydata.realtimecontext.a(false, "scene rule skipped, whiteList missed", this.c);
        L7:
            return new com.obric.memorydata.realtimecontext.a(true, "scene rule matched", this.c);
        }
    }

    static {
        f12463a = new f();
    }

    private f() {
    }

    private final com.obric.memorydata.realtimecontext.a a(AssistStructure.ViewNode r28, int r29, int r30, a r31) {
        String r2 = r28.getIdEntry();
        CharSequence r1 = r28.getText();
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        CharSequence r4 = r28.getContentDescription();
        if (r4 == null) goto L9;
        String r5 = r4.toString();
    L10:
        String r6 = r28.getClassName();
        Integer r7 = Integer.valueOf(r28.getLeft());
        Integer r8 = Integer.valueOf(r28.getTop());
        Integer r9 = Integer.valueOf(r28.getWidth());
        Integer r10 = Integer.valueOf(r28.getHeight());
        Integer r11 = Integer.valueOf(r29);
        Integer r12 = Integer.valueOf(r30);
        Integer r13 = Integer.valueOf(r28.getVisibility());
        Bundle r14 = r28.getExtras();
        if (r14 != null) goto L13;
    L18:
        Boolean r15 = null;
    L19:
        com.obric.memorydata.realtimecontext.a r16 = r31.a(new h(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, Boolean.valueOf(r28.isEnabled()), Boolean.valueOf(r28.isClickable()), Boolean.valueOf(r28.isLongClickable()), Boolean.valueOf(r28.isContextClickable()), Boolean.valueOf(r28.isFocusable()), Boolean.valueOf(r28.isFocused()), Boolean.valueOf(r28.isAccessibilityFocused()), Boolean.valueOf(r28.isSelected()), Boolean.valueOf(r28.isActivated()), Boolean.valueOf(r28.isCheckable()), Boolean.valueOf(r28.isChecked())));
        if (r16 == null) goto L22;
        return r16;
    L22:
        int r17 = 0;
        int r18 = r28.getChildCount();
    L23:
        if (r17 >= r18) goto L28;
        AssistStructure.ViewNode r19 = r28.getChildAt(r17);
        Intrinsics.checkNotNullExpressionValue(r19, "getChildAt(...)");
        com.obric.memorydata.realtimecontext.a r20 = a(r19, r29, r30, r31);
        if (r20 != null) goto L26;
        r17 = r17 + 1;
        goto L23
    L26:
        return r20;
    L28:
        return null;
    L13:
        if (r14.containsKey("android.view.ViewStructure.extra.VISIBLE_TO_USER") == true) goto L16;
        r14 = null;
    L16:
        if (r14 == null) goto L18;
        r15 = Boolean.valueOf(r14.getBoolean("android.view.ViewStructure.extra.VISIBLE_TO_USER"));
        goto L19
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final com.obric.memorydata.realtimecontext.a a(b r7) {
        if (r7.e() != null) goto L5;
        return null;
    L5:
        return new com.obric.memorydata.realtimecontext.a(false, r7.e(), 0, 4, null);
    }

    private final com.obric.memorydata.realtimecontext.a a(k r10, AssistStructure r11) {
        a r1 = new a(r10);
        int r2 = r11.getWindowNodeCount();     // Catch: Throwable -> L14
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L10;
        AssistStructure.WindowNode r4 = r11.getWindowNodeAt(r3);     // Catch: Throwable -> L14
        AssistStructure.ViewNode r5 = r4.getRootViewNode();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r5, "getRootViewNode(...)");     // Catch: Throwable -> L14
        com.obric.memorydata.realtimecontext.a r6 = a(r5, r4.getWidth(), r4.getHeight(), r1);     // Catch: Throwable -> L14
        if (r6 != null) goto L7;
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L4
    L7:
        return r6;
    L10:
        if (r1.a() != 0) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActionRecommendSceneRule", "collect viewTree empty, windowCount=" + r2, false, 4, null);     // Catch: Throwable -> L14
    L12:
        return r1.b();
    L14:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ActionRecommendSceneRule", "match viewTree failed: " + th.getClass().getSimpleName(), null, 4, null);
        return new com.obric.memorydata.realtimecontext.a(false, "scene rule skipped, viewTree match failed", r1.a());
    }

    private final k a(ActionRecommendSceneActivity r6) {
        List<Map<String, Object>> r5 = r6.getWhiteList();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Map<String, ? extends Object> r3 = (Map) ZeusTransformUtils.preCheckCast(r8.next(), Map.class, "com.obric.memorydata.plugin");
        r0.add(f12463a.a(r3));
        goto L7
    L9:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        List<Map<String, Object>> r1 = r6.getBlackList();
        if (r1 != null) goto L12;
        r1 = CollectionsKt.emptyList();
    L12:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r2.iterator();
    L14:
        if (r10.hasNext() == false) goto L17;
        Map<String, ? extends Object> r11 = (Map) ZeusTransformUtils.preCheckCast(r10.next(), Map.class, "com.obric.memorydata.plugin");
        r4.add(f12463a.a(r11));
        goto L14
    L17:
        return new k(r6, r9, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
    }

    private final m a(Map<String, ? extends Object> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r1.getValue();
        r6.add(l.f12475a.a(r2, r3));
        goto L4
    L7:
        return new m((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"));
    }

    public final com.obric.memorydata.realtimecontext.a a(b r14, AssistStructure r15) {
        Intrinsics.checkNotNullParameter(r14, "preparedRule");
        com.obric.memorydata.realtimecontext.a r0 = a(r14);
        if (r0 == null) goto L5;
        return r0;
    L5:
        k r16 = r14.d();
        if (r16 != null) goto L10;
        return new com.obric.memorydata.realtimecontext.a(true, "scene rule matched", 0, 4, null);
    L10:
        if (r16.c() == false) goto L12;
        if (r15 != null) goto L17;
        return new com.obric.memorydata.realtimecontext.a(false, "scene rule skipped, assistStructure is null", 0, 4, null);
    L17:
        return a(r16, r15);
    L12:
        return new com.obric.memorydata.realtimecontext.a(true, "scene rule matched", 0, 4, null);
    }

    public final b a(ActionRecommendSceneSettings r14, String r15, String r16, String r17, long r18) {
        Intrinsics.checkNotNullParameter(r14, "settings");
        Intrinsics.checkNotNullParameter(r15, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r17, "activityName");
        if (r14.getEnabled() == true) goto L7;
        b.a r0 = b.f12443a;
        String r6 = "scene rule disabled";
    L6:
        return r0.a(r15, r16, r17, r18, r6);
    L7:
        List<ActionRecommendScene> r1 = r14.getScenes();
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        Object r7 = null;
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((ActionRecommendScene) ZeusTransformUtils.preCheckCast(r4, ActionRecommendScene.class, "com.obric.memorydata.plugin")).getScene(), r15) == false) goto L11;
    L17:
        ActionRecommendScene r3 = (ActionRecommendScene) ZeusTransformUtils.preCheckCast(r4, ActionRecommendScene.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L20;
        r0 = b.f12443a;
        r6 = "scene rule missing";
        goto L6
    L20:
        List<ActionRecommendSceneApp> r5 = r3.getApps();
        if (r5 != null) goto L23;
        r5 = CollectionsKt.emptyList();
    L23:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((ActionRecommendSceneApp) ZeusTransformUtils.preCheckCast(r9, ActionRecommendSceneApp.class, "com.obric.memorydata.plugin")).getPackageName(), r16) == false) goto L25;
    L30:
        ActionRecommendSceneApp r10 = (ActionRecommendSceneApp) ZeusTransformUtils.preCheckCast(r9, ActionRecommendSceneApp.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L33;
        r0 = b.f12443a;
        r6 = "scene app rule missing";
        goto L6
    L33:
        List<ActionRecommendSceneVersion> r11 = r10.getVersions();
        if (r11 != null) goto L36;
        r11 = CollectionsKt.emptyList();
    L36:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r12.iterator();
    L38:
        if (r19.hasNext() == false) goto L45;
        Object r20 = r19.next();
        if (r18 < ((ActionRecommendSceneVersion) ZeusTransformUtils.preCheckCast(r20, ActionRecommendSceneVersion.class, "com.obric.memorydata.plugin")).getMinVersion()) goto L42;
        boolean r21 = true;
    L43:
        if (r21 == false) goto L38;
        r13.add(r20);
        goto L38
    L42:
        r21 = false;
        goto L43
    L45:
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r22.hasNext() == true) goto L48;
        Object r23 = null;
    L57:
        ActionRecommendSceneVersion r24 = (ActionRecommendSceneVersion) ZeusTransformUtils.preCheckCast(r23, ActionRecommendSceneVersion.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L60;
        List<ActionRecommendSceneActivity> r25 = r24.getActivities();
    L61:
        if (r25 != null) goto L63;
        r25 = CollectionsKt.emptyList();
    L63:
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L65:
        if (r26.hasNext() == false) goto L69;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((ActionRecommendSceneActivity) ZeusTransformUtils.preCheckCast(r27, ActionRecommendSceneActivity.class, "com.obric.memorydata.plugin")).getActivity(), r17) == false) goto L65;
        r7 = r27;
    L69:
        ActionRecommendSceneActivity r28 = (ActionRecommendSceneActivity) ZeusTransformUtils.preCheckCast(r7, ActionRecommendSceneActivity.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L73;
        r0 = b.f12443a;
        r6 = "scene activity rule missing";
        goto L6
    L73:
        return new b(r15, r16, r17, r18, r28, a(r28), null, 64, null);
    L60:
        r25 = null;
        goto L61
    L48:
        r23 = r22.next();
        if (r22.hasNext() == false) goto L57;
        long r29 = ((ActionRecommendSceneVersion) ZeusTransformUtils.preCheckCast(r23, ActionRecommendSceneVersion.class, "com.obric.memorydata.plugin")).getMinVersion();
    L52:
        Object r30 = r22.next();
        long r110 = ((ActionRecommendSceneVersion) ZeusTransformUtils.preCheckCast(r30, ActionRecommendSceneVersion.class, "com.obric.memorydata.plugin")).getMinVersion();
        if (r29 >= r110) goto L56;
        r23 = r30;
        r29 = r110;
    L56:
        if (r22.hasNext() == true) goto L52;
    L29:
        r9 = null;
        goto L30
    L16:
        r4 = null;
        goto L17
    }
}
