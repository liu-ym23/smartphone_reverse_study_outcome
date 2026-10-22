package com.obric.memorydata.memory;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.utils.LocaleRegionRefreshManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.sdk.accessibility.AccessibilityCondition;
import com.obric.memorydata.sdk.screencapture.ScreenCaptureManager;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.event.AppAccessibilityEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0017\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0010J\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%H\u0002J\u0016\u0010&\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%H\u0002J7\u0010'\u001a\u00020\u00102%\b\u0002\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u001d\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020\u0010J5\u0010.\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00102#\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u001d\u0018\u00010)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/MemoryRuleRegistry;", "", "<init>", "()V", "TAG", "", "APP_AUTO_MEMORY_SETTING_KEY", "COMPILE_EXTRACT_VOCAB_PACKAGE", "KEY_USE_CLOUD_MODEL", "KEY_TYPE", "KEY_PAGE_CONTEXT_CAPTURE_DISABLED", "enableApps", "", "vocabRecompileTrigger", "Lcom/obric/memorydata/memory/observation/VocabRecompileTrigger;", "ENABLE_LOCAL_TEST", "", "_appAutoMemoryConfig", "Lcom/obric/memorydata/memory/AutoMemoryConfig$AppAutoMemoryConfig;", "appAutoMemoryConfig", "getAppAutoMemoryConfig", "()Lcom/obric/memorydata/memory/AutoMemoryConfig$AppAutoMemoryConfig;", "accessibilityRuleListener", "com/obric/memorydata/memory/MemoryRuleRegistry$accessibilityRuleListener$1", "Lcom/obric/memorydata/memory/MemoryRuleRegistry$accessibilityRuleListener$1;", "settingsChangeListener", "com/obric/memorydata/memory/MemoryRuleRegistry$settingsChangeListener$1", "Lcom/obric/memorydata/memory/MemoryRuleRegistry$settingsChangeListener$1;", "listenEnableAppsChanged", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "first", "initLocaleRegionRefresh", "refreshForLocaleRegionChanged", "disable", "registerApps", "packageNames", "", "unregisterApps", "updateRuleConfig", "changeCb", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "changed", "forceChanged", "notifyRulesChanged", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f11594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<String> f11595b;
    private static final com.obric.memorydata.memory.d.a c = null;
    private static AutoMemoryConfig.AppAutoMemoryConfig d;
    private static final a e = null;
    private static final b f = null;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/memory/MemoryRuleRegistry$accessibilityRuleListener$1", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.sdk.screencapture.b {
        a() {
        }

        private static final Unit a(int r1, String r2, com.obric.memorydata.middleware.api.logging.g r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$errorTrace");
            r3.a("error_code", Integer.valueOf(r1));
            r3.a("error_msg", r2);
            return Unit.INSTANCE;
        }

        private static final Unit a(ScreenEvent r2, com.obric.memorydata.middleware.api.logging.g r3) {
            Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
            r3.a("rule_id", ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r2, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getId());
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$_REEnPZS55G_c7a305wJXWO6AK8(int r0, String r1, com.obric.memorydata.middleware.api.logging.g r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$uoRUkytIhlhSdBvZwqrsoAe1KDM(ScreenEvent r0, com.obric.memorydata.middleware.api.logging.g r1) {
            return a(r0, r1);
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(final int r11, final String r12) {
            Intrinsics.checkNotNullParameter(r12, "errorMessage");
            com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆规则执行失败", "rule_failed", String.valueOf(r11), null, new com.obric.memorydata.middleware.api.logging.e(null, UUID.randomUUID().toString(), "trigger", 1, null), new $$Lambda$y$a$_REEnPZS55G_c7a305wJXWO6AK8(r11, r12), 8, null);
        }

        @Override // com.obric.memorydata.sdk.screencapture.b
        public void a(final ScreenEvent r26, ScreenData r27) {
            Intrinsics.checkNotNullParameter(r26, "event");
            Intrinsics.checkNotNullParameter(r27, "data");
            if (ZeusTransformUtils.instanceOf(r26, AppAccessibilityEvent.class) == true) goto L5;
            return;
        L5:
            com.obric.memorydata.middleware.api.logging.e r12 = new com.obric.memorydata.middleware.api.logging.e(null, null, "trigger", 3, null);
            com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆规则已命中", "rule_hit", r12, new $$Lambda$y$a$uoRUkytIhlhSdBvZwqrsoAe1KDM(r26), null, 16, null);
            com.obric.memorydata.utils.c.a r0 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r26.getPackageName(), null, 2, null);
            if (r0 == null) goto L8;
            String r2 = r0.a();
        L10:
            if (r2 != null) goto L12;
            r2 = "";
        L12:
            MemoryEventTracker r6 = MemoryEventTracker.f10515a;
            String r15 = ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r26, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getId();
            String r17 = r26.getPackageName();
            if (r0 == null) goto L15;
            String r1 = r0.c();
        L16:
            if (r1 != null) goto L18;
            String r18 = "";
        L19:
            List<AccessibilityCondition> r3 = ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r26, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getConditions();
            ListIterator<AccessibilityCondition> r4 = r3.listIterator(r3.size());
        L21:
            if (r4.hasPrevious() == false) goto L25;
            AccessibilityCondition r7 = r4.previous();
            if (((AccessibilityCondition) ZeusTransformUtils.preCheckCast(r7, AccessibilityCondition.class, "com.obric.memorydata.plugin")).getMatched() == false) goto L21;
        L26:
            AccessibilityCondition r5 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r7, AccessibilityCondition.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L29;
            String r8 = r5.getActivityName();
        L30:
            if (r8 != null) goto L32;
            String r22 = "";
        L33:
            r6.a(new MemoryEventTracker.AutoMemoryRuleHitParams(r15, r2, r17, r18, "", "", "accessibility", r22, "", "create"));
            if (r27.getScreenshot() != null) goto L37;
            com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆截图获取失败", "input_prepare_failed", "screenshot_unavailable", null, r12, null, 40, null);
            return;
        L37:
            JSONObject r9 = ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r26, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getExtras();
            if (r9 == null) goto L40;
            String r10 = r9.optString("type");
        L41:
            CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L44;
        L47:
            boolean r13 = true;
        L48:
            if (r13 == false) goto L50;
            com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆规则缺少类型", "rule_invalid", "rule_type_missing", null, r12, null, 40, null);
            throw new IllegalArgumentException("type is null, must set extras for rule");
        L50:
            if (com.obric.memorydata.memory.b.f10076a.b(r26.getPackageName()) == true) goto L52;
            return;
        L52:
            JSONObject r14 = ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r26, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getExtras();
            if (r14 == null) goto L55;
            boolean r16 = r14.optBoolean("use_cloud_model", false);
        L56:
            JSONObject r19 = ((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r26, AppAccessibilityEvent.class, "com.obric.memorydata.plugin")).getAccessibilityRule().getExtras();
            if (r19 == null) goto L59;
            boolean r20 = r19.optBoolean("deep_capture_disabled", false);
        L60:
            kotlinx.coroutines.i.a(com.obric.memorydata.utils.j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleRegistry$accessibilityRuleListener$1$onEvent$3(r26, r2, r27, r10, r16, r20, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L59:
            r20 = false;
            goto L60
        L55:
            r16 = false;
            goto L56
        L44:
            if (r11.length() == 0) goto L47;
            r13 = false;
            goto L48
        L40:
            r10 = null;
            goto L41
        L32:
            r22 = r8;
            goto L33
        L29:
            r8 = null;
            goto L30
        L25:
            r7 = null;
            goto L26
        L18:
            r18 = r1;
            goto L19
        L15:
            r1 = null;
            goto L16
        L8:
            r2 = null;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/MemoryRuleRegistry$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements SettingsChangeListener {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r15) {
            Intrinsics.checkNotNullParameter(r15, "key");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "settings " + r15 + " update", false, 4, null);
            kotlinx.coroutines.i.a(com.obric.memorydata.utils.j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleRegistry$settingsChangeListener$1$onSettingsChanged$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }
    }

    static {
        f11594a = new y();
        f11595b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        c = new com.obric.memorydata.memory.d.a($$Lambda$y$5ktudU0C1cHTH6FzbU8vns7dyQ0.INSTANCE);
        e = new a();
        f = new b();
    }

    private y() {
    }

    private static final CharSequence a(AutoMemoryConfig.SmartMemoryPackage r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getPackageName() + ':' + r2.getAppName() + '/' + r2.getDescription(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final void a(LocaleRegionRefreshManager.b r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        f11594a.c();
    }

    public static final /* synthetic */ void a(y r2, Set r3) {
        r2.b((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(Set r2) {
        f11595b = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
    }

    private final void a(boolean r2, Function1<? super Boolean, Unit> r3) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        r1.invoke(Boolean.valueOf(r2));
    L5:
        c.a(r2);
    }

    public static /* synthetic */ boolean a(y r1, Function1 r2, boolean r3, int r4, Object r5) {
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = false;
    L9:
        return r1.a(r6, r3);
    }

    public static final /* synthetic */ void b(y r2, Set r3) {
        r2.c((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    private final void b(Set<String> r10) {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.b r0 = com.obric.memorydata.memory.b.f10076a;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r3 = r12.next();
        if (r0.b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "registerAppsReal " + r13, false, 4, null);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(a().getRules(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r9.iterator();
    L10:
        if (r14.hasNext() == false) goto L20;
        Object r4 = r14.next();
        ScreenEventReaction r5 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r4, ScreenEventReaction.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        ScreenEventRule r7 = r5.getRule();
        String r8 = null;
        if (ZeusTransformUtils.instanceOf(r7, AppAccessibilityEventRule.class) == false) goto L14;
        AppAccessibilityEventRule r15 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r7, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");
    L15:
        if (r15 == null) goto L18;
        r8 = r15.getPackageName();
    L18:
        if (CollectionsKt.contains(r6, r8) == false) goto L10;
        r1.add(r4);
        goto L10
    L14:
        r15 = null;
        goto L15
    L20:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        ScreenCaptureManager.register$default(ScreenCaptureManager.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r16.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.preCheckCast(e, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin"), 0, 8, null);
        goto L22
    }

    private final void c(Set<String> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "unregisterApps " + r10, false, 4, null);
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(a().getRules(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        Object r2 = r11.next();
        ScreenEventReaction r3 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r2, ScreenEventReaction.class, "com.obric.memorydata.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        ScreenEventRule r5 = r3.getRule();
        String r6 = null;
        if (ZeusTransformUtils.instanceOf(r5, AppAccessibilityEventRule.class) == false) goto L8;
        AppAccessibilityEventRule r7 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r5, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");
    L9:
        if (r7 == null) goto L12;
        r6 = r7.getPackageName();
    L12:
        if (CollectionsKt.contains(r4, r6) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r7 = null;
        goto L9
    L14:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        ScreenCaptureManager.INSTANCE.unregister(((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r12.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin")).getId());
        goto L16
    }

    public static final /* synthetic */ Set e() {
        return f11595b;
    }

    private final void f() {
        kotlinx.coroutines.i.a(com.obric.memorydata.utils.j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleRegistry$listenEnableAppsChanged$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit g() {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$5ktudU0C1cHTH6FzbU8vns7dyQ0() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$Io0otCw-8rOtkT8InqnAjnteKXs, reason: not valid java name */
    public static /* synthetic */ CharSequence m1007lambda$Io0otCw8rOtkT8InqnAjnteKXs(AutoMemoryConfig.SmartMemoryPackage r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$o5p0fsOrQq1FJ0zL2Z256NytFmQ(LocaleRegionRefreshManager.b r0) {
        a(r0);
    }

    public final AutoMemoryConfig.AppAutoMemoryConfig a() {
        if (d != null) goto L5;
        a(this, null, false, 3, null);
    L5:
        AutoMemoryConfig.AppAutoMemoryConfig r3 = d;
        if (r3 == null) goto L22;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L28;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r3.getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L20;
        Object r4 = r10.next();
        if (((AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r4, AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin")).getModel() != 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        r0.add(r4);
        goto L12
    L16:
        r5 = false;
        goto L17
    L20:
        return AutoMemoryConfig.AppAutoMemoryConfig.copy$default(r3, (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    L28:
        return r3;
    L22:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void a(boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "init, first = " + r10, false, 4, null);
        if (r10 == false) goto L5;
        SettingsManager.INSTANCE.registerChangeListener("app_auto_memory_config", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(f, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        b();
        f();
    L5:
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        a(this, null, false, 3, null);
        if (r0 == true) goto L8;
        return;
    L8:
        if (r10 == true) goto L11;
        b((Set) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final boolean a(Function1<? super Boolean, Unit> r18, boolean r19) {
        Function1<? super Boolean, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        String r3 = SettingsManager.INSTANCE.getSettingsStr("app_auto_memory_config");
        AutoMemoryConfig.AppAutoMemoryConfig r4 = (AutoMemoryConfig.AppAutoMemoryConfig) ZeusTransformUtils.preCheckCast(ScreenEventRule.Companion.a().fromJson(r3, AutoMemoryConfig.AppAutoMemoryConfig.class), AutoMemoryConfig.AppAutoMemoryConfig.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (r4 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "getRuleConfig from memory_settings package, config id = " + r4.getId(), false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "getRuleConfig apps = " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r4.getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin"), 3), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$y$Io0otCw8rOtkT8InqnAjnteKXs.INSTANCE, 31, null) + ", ruleSize = " + r4.getRules().size(), false, 4, null);
        if (r19 == true) goto L17;
        AutoMemoryConfig.AppAutoMemoryConfig r2 = d;
        if (r2 == null) goto L14;
        String r6 = r2.getId();
    L16:
        if (Intrinsics.areEqual(r6, r4.getId()) == false) goto L17;
    L18:
        a(r5, r1);
        d = r4;
        return r5;
    L14:
        r6 = null;
    L17:
        r5 = true;
        goto L18
    L20:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "invalid config: " + r3, null, 4, null);
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "getRuleConfig use local config, size = " + AutoMemoryConfig.f10038a.b().getRules().size(), null, 4, null);
        a(true, r1);
        d = AutoMemoryConfig.f10038a.b();
        return true;
    L5:
        if (r4.isValid() != true) goto L7;
        r7 = true;
        goto L8
    }

    public final void b() {
        LocaleRegionRefreshManager.f11524a.a("app_auto_memory_config", $$Lambda$y$o5p0fsOrQq1FJ0zL2Z256NytFmQ.INSTANCE);
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "refreshForLocaleRegionChanged", false, 4, null);
        kotlinx.coroutines.i.a(com.obric.memorydata.utils.j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryRuleRegistry$refreshForLocaleRegionChanged$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void d() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryRuleRegistry", "disable", false, 4, null);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(a().getRules(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        ScreenEventReaction r0 = (ScreenEventReaction) ZeusTransformUtils.preCheckCast(r9.next(), ScreenEventReaction.class, "com.obric.memorydata.plugin");
        ScreenCaptureManager.INSTANCE.unregister(r0.getId());
        goto L4
    }
}
