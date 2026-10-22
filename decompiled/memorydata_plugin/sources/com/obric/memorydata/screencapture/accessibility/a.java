package com.obric.memorydata.screencapture.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.t;
import com.obric.memorydata.sdk.accessibility.AccessibilityCondition;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010'\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0006J\u0016\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006J\b\u0010,\u001a\u0004\u0018\u00010\u0011J\u0010\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0011J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0017H\u0002J\u0016\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u0002062\u0006\u00102\u001a\u00020\u0017H\u0002J\u001c\u00107\u001a\u00020$2\u0006\u00108\u001a\u0002062\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007J\b\u00109\u001a\u00020$H\u0007J\u0012\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010<H\u0007J\b\u0010=\u001a\u00020$H\u0002J\u0018\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0018\u0010@\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020\u0006H\u0002J\u0018\u0010C\u001a\u00020$2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u00108\u001a\u00020EH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006F"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleManager;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "Lcom/obric/memorydata/screencapture/monitor/UserInputDetector$ScreenTouchEventListener;", "<init>", "()V", "TAG", "", "rules", "", "Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "listener", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleMatchListener;", "accessibilityRuleStatusMap", "", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;", "accessibilityServiceRef", "Ljava/lang/ref/WeakReference;", "Landroid/accessibilityservice/AccessibilityService;", "DELAY_DISABLE_SERVICE", "", "lock", "", "MSG_POLL", "", "MSG_DISABLE_SERVICE", "MSG_RETRY_CHECK_APP", "POLL_INTERVAL", "RETRY_CHECK_DELAY", "handler", "com/obric/memorydata/screencapture/accessibility/AccessibilityRuleManager$handler$1", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleManager$handler$1;", "checkRuleExists", "", "ruleId", "checkRuleExists$screen_capture_obricRelease", "registerRule", "", "rule", "unregisterRule", "setRuleMatchListener", "ensureServiceForViewTree", InfoRequestQPSOptTraceLogger.REASON, "disableServiceForViewTreeIfNoAccessibilityRule", ObricMemoryConstants.KEY_PACKAGE_NAME, "getService", "setService", "service", "updateListenEventTypes", "oldEventTypes", "sendCustomEvent", "eventType", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "generateCustomEvent", "Landroid/view/accessibility/AccessibilityEvent;", "onAccessibilityEvent", "event", "printViewTree", "printNodeViewTree", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dumpViewTreeIfNeeded", "onAppOpen", "appName", "handleAppOpen", "processAppOpen", "curApp", "onAppClose", "onScreenTouchEvent", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.screencapture.monitor.e.b, af.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<AppAccessibilityEventRule> f12772b = null;
    private static b c;
    private static final Map<String, AccessibilityRuleStatus> d = null;
    private static WeakReference<AccessibilityService> e;
    private static final Object f = null;
    private static final HandlerC0688a g = null;

    /* JADX INFO: renamed from: com.obric.memorydata.screencapture.accessibility.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/screencapture/accessibility/AccessibilityRuleManager$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HandlerC0688a extends Handler {
        HandlerC0688a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r12) {
            Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(r12);
            String r1 = null;
            if (r12.what != 1) goto L40;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(a.b(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r13.iterator();
        L6:
            if (r14.hasNext() == false) goto L10;
            Object r4 = r14.next();
            if (((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r4, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPollCheck() == false) goto L6;
            r0.add(r4);
            goto L6
        L10:
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r15.iterator();
        L12:
            if (r16.hasNext() == false) goto L14;
            r2.add(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r16.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getId());
            goto L12
        L14:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
            sendEmptyMessageDelayed(1, 500);
        L17:
            Map r11 = a.c();
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r18 = r11.entrySet().iterator();
        L19:
            if (r18.hasNext() == false) goto L24;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (r17.contains(r5.getKey()) == false) goto L19;
            r3.put(r5.getKey(), r5.getValue());
            goto L19
        L24:
            if ((!r3.isEmpty()) == false) goto L83;
            AccessibilityEvent r19 = a.a(a.f12771a, 2048);
            Map r110 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r6 = r3.entrySet().iterator();
        L27:
            if (r6.hasNext() == false) goto L31;
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(((AccessibilityRuleStatus) ZeusTransformUtils.preCheckCast(r7.getValue(), AccessibilityRuleStatus.class, "com.obric.memorydata.plugin")).a().getPackageName(), r19.getPackageName()) == false) goto L27;
            r110.put(r7.getKey(), r7.getValue());
            goto L27
        L31:
            Iterator r111 = r110.entrySet().iterator();
        L33:
            if (r111.hasNext() == false) goto L86;
            AccessibilityRuleStatus r8 = (AccessibilityRuleStatus) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r111.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), AccessibilityRuleStatus.class, "com.obric.memorydata.plugin");
            WeakReference r9 = a.d();
            if (r9 == null) goto L37;
            AccessibilityService r10 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r9.get(), AccessibilityService.class, "com.obric.memorydata.plugin");
        L38:
            AccessibilityRuleStatus.a(r8, r10, r19, a.e(), null, 8, null);
            goto L33
        L37:
            r10 = null;
            goto L38
        L86:
            return;
        L83:
            return;
        L40:
            if (r12.what != 2) goto L49;
            if (com.obric.memorydata.middleware.api.a.a.f11599a.b() == false) goto L47;
            o r112 = (o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.middleware.api.logging.e r113 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            if (AppContext.INSTANCE.isDebug() == false) goto L82;
            g r20 = new g();
            Unit r21 = Unit.INSTANCE;
            r112.a("无障碍常开调试模式，跳过按需关闭", r113, r20.a());
            return;
        L82:
            return;
        L47:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "turnOffAccessibilityService", false, 4, null);
            c.f12773a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), false);
            return;
        L49:
            if (r12.what != 3) goto L85;
            Object r114 = r12.obj;
            if (ZeusTransformUtils.instanceOf(r114, String.class) == false) goto L53;
            r1 = (String) ZeusTransformUtils.preCheckCast(r114, String.class, "com.obric.memorydata.plugin");
        L53:
            if (r1 != null) goto L55;
            return;
        L55:
            ComponentName r115 = ba.a();
            if (r115 == null) goto L61;
            String r116 = r115.getPackageName();
            if (r116 == null) goto L61;
            r1 = r116;
        L61:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "Retry check: current app " + r1, false, 4, null);
            a.a(a.f12771a, r1);
            return;
        }
    }

    static {
        f12771a = new a();
        f12772b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        f = new Object();
        g = new HandlerC0688a(Looper.getMainLooper());
    }

    private a() {
    }

    private final int a(int r12) {
        Iterator r11 = SequencesKt.distinct(SequencesKt.map(SequencesKt.filter(SequencesKt.flatMapIterable(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$a$39IaUl19hCjjgVUMaRAx2PQbJw.INSTANCE), $$Lambda$a$dyslJo0uDcpUPTqknnWWkJVwgRg.INSTANCE), $$Lambda$a$WcVLsWmvbusseDFVAwG3pXVCgCU.INSTANCE)).iterator();
        boolean r0 = false;
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r2 = r2 | ((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        goto L4
    L6:
        int r13 = r2 | r12;
        if ((r13 & 1) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r13 & 2048) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r13 & 32) == 0) goto L17;
        r0 = true;
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "monitor events old=" + r12 + " new=" + r13 + " click=" + r3 + " content=" + r4 + " state=" + r0, false, 4, null);
        return r13;
    L13:
        r4 = false;
        goto L15
    L9:
        r3 = false;
        goto L11
    }

    public static final /* synthetic */ AccessibilityEvent a(a r0, int r1) {
        return r0.b(r1);
    }

    public static /* synthetic */ void a(a r0, AccessibilityEvent r1, TouchInfo r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.c(r1);
    }

    private static final boolean a(AccessibilityCondition r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return !com.obric.memorydata.sdk.accessibility.a.f12814a.a(r1.getEventType());
    }

    private static final boolean a(AppAccessibilityEventRule r1, AppAccessibilityEventRule r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.getId(), r1.getId());
    }

    private static final boolean a(String r1, AppAccessibilityEventRule r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.getId(), r1);
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final int b(AccessibilityCondition r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getEventType();
    }

    private final AccessibilityEvent b(int r5) {
        AccessibilityEvent r4 = new AccessibilityEvent();
        r4.setEventType(r5);
        ComponentName r6 = ba.a();
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getPackageName();
    L6:
        r4.setPackageName((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L9;
        r0 = r6.getClassName();
    L9:
        r4.setClassName((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    private static final Iterable b(AppAccessibilityEventRule r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r3.getConditions(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3.getResetConditions(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Set b() {
        return f12772b;
    }

    private static final void b(AccessibilityEvent r1, TouchInfo r2) {
        f12771a.a(r1, r2);
    }

    private static final boolean b(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static final /* synthetic */ Map c() {
        return d;
    }

    private final void c(String r12) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r1.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName(), r12) == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
    L18:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "enable accessibility service for " + r12, false, 4, null);
        g.removeMessages(2);
        c.f12773a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), true);
        Tracker r5 = Tracker.INSTANCE;
        JSONObject r6 = new JSONObject();
        r6.put("package_name", r12);
        String r7 = null;
        com.obric.memorydata.utils.c.a r8 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r12, null, 2, null);
        if (r8 == null) goto L24;
        r7 = r8.c();
    L24:
        r6.put("version", r7);
        Unit r9 = Unit.INSTANCE;
        r5.reportEvent("auto_memory_app_checker", r6);
    L26:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.iterator();
    L28:
        if (r13.hasNext() == false) goto L32;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r14, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName(), r12) == false) goto L28;
        r11.add(r14);
        goto L28
    L32:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L35;
    L37:
        Iterator r16 = r15.iterator();
    L39:
        if (r16.hasNext() == false) goto L36;
        AppAccessibilityEventRule r17 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r16.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17.getConditions(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L42:
        if (r20.hasNext() == false) goto L44;
        r19.add(Integer.valueOf(((AccessibilityCondition) ZeusTransformUtils.preCheckCast(r20.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin")).getEventType()));
        goto L42
    L44:
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r17.getResetConditions(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L46:
        if (r24.hasNext() == false) goto L48;
        r23.add(Integer.valueOf(((AccessibilityCondition) ZeusTransformUtils.preCheckCast(r24.next(), AccessibilityCondition.class, "com.obric.memorydata.plugin")).getEventType()));
        goto L46
    L48:
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r21, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r25, Collection.class) == true) goto L51;
    L53:
        Iterator r26 = r25.iterator();
    L55:
        if (r26.hasNext() == false) goto L52;
        if (com.obric.memorydata.sdk.accessibility.a.f12814a.b(((Number) ZeusTransformUtils.preCheckCast(r26.next(), Number.class, "com.obric.memorydata.plugin")).intValue()) == false) goto L55;
        boolean r27 = true;
    L59:
        if (r27 == false) goto L39;
    L60:
        if (r3 == false) goto L62;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "needTouchEvent: " + r3, false, 4, null);
        com.obric.memorydata.screencapture.d.f12797a.a().a().a((com.obric.memorydata.screencapture.monitor.e.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.monitor.e.b.class, "com.obric.memorydata.plugin"));
        return;
    L62:
        com.obric.memorydata.screencapture.d.f12797a.a().a().b((com.obric.memorydata.screencapture.monitor.e.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.monitor.e.b.class, "com.obric.memorydata.plugin"));
        return;
    L52:
        r27 = false;
        goto L59
    L51:
        if (((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L53;
    L36:
        r3 = false;
        goto L60
    L35:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L37;
    L25:
        g.sendEmptyMessageDelayed(2, 0);
        goto L26
    L15:
        if (com.obric.memorydata.screencapture.d.f12797a.a().c(r12) == true) goto L18;
        r4 = false;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public static final /* synthetic */ WeakReference d() {
        return e;
    }

    private final void d(String r10, String r11) {
        ComponentName r12 = ba.a();
        if (r12 == null) goto L6;
        String r13 = r12.getPackageName();
        if (r13 == null) goto L6;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "current app " + r13 + ", callback pkg: " + r11, false, 4, null);
        if (Intrinsics.areEqual(r13, r11) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "onAppOpen pkg mismatch! callback: " + r11 + ", topActivity: " + r13 + ". Retrying...", null, 4, null);
        HandlerC0688a r9 = g;
        Message r14 = r9.obtainMessage(3, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "obtainMessage(...)");
        r9.sendMessageDelayed(r14, 300);
        return;
    L10:
        c(r13);
        return;
    L6:
        r13 = r11;
        goto L7
    }

    public static final /* synthetic */ b e() {
        return c;
    }

    private final void f() {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r9.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getId(), "dump_view_tree") == false) goto L9;
        r2 = true;
    L13:
        if (r2 == false) goto L19;
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AccessibilityRuleManager$dumpViewTreeIfNeeded$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L19:
        return;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$39IaUl1-9hCjjgVUMaRAx2PQbJw, reason: not valid java name */
    public static /* synthetic */ Iterable m1166lambda$39IaUl19hCjjgVUMaRAx2PQbJw(AppAccessibilityEventRule r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$5iDSoe4J8RaA0g58GmfpuQ2Cm-k, reason: not valid java name */
    public static /* synthetic */ boolean m1167lambda$5iDSoe4J8RaA0g58GmfpuQ2Cmk(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8VZwfPFmhz6TnV0T-N7s-YYmhJw, reason: not valid java name */
    public static /* synthetic */ boolean m1168lambda$8VZwfPFmhz6TnV0TN7sYYmhJw(String r0, AppAccessibilityEventRule r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$LVTZoOiWiCb6y8vWh6rvFceIVnw(Function1 r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ void lambda$N9TlOyzGwn9j85vwx_25YM8hsY8(AccessibilityEvent r0, TouchInfo r1) {
        b(r0, r1);
    }

    public static /* synthetic */ int lambda$WcVLsWmvbusseDFVAwG3pXVCgCU(AccessibilityCondition r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$dyslJo0uDcpUPTqknnWWkJVwgRg(AccessibilityCondition r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$xct-PEnvFTAmj2b2k4XyQ6BQnuQ, reason: not valid java name */
    public static /* synthetic */ boolean m1169lambda$xctPEnvFTAmj2b2k4XyQ6BQnuQ(AppAccessibilityEventRule r0, AppAccessibilityEventRule r1) {
        return a(r0, r1);
    }

    public final void a() {
        WeakReference<AccessibilityService> r5 = e;
        if (r5 == null) goto L8;
        AccessibilityService r6 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r5.get(), AccessibilityService.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        ComponentName r0 = ba.a();
        RunLog.INSTANCE.debug("DumpViewTree", "   \n\n\n");
        RunLog.INSTANCE.debug("DumpViewTree", ">>>>>> START DUMP VIEW TREE for activity " + r0 + " <<<<<<");
        f12771a.a(r6.getRootInActiveWindow());
        RunLog.INSTANCE.debug("DumpViewTree", "====== END DUMP VIEW TREE ======\n\n");
        return;
    L9:
        return;
    }

    public final void a(int r2, final TouchInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "touchInfo");
        final AccessibilityEvent r1 = b(r2);
        g.post(new $$Lambda$a$N9TlOyzGwn9j85vwx_25YM8hsY8(r1, r3));
    }

    public final void a(AccessibilityService r9) {
        AccessibilityService r10 = (AccessibilityService) ZeusTransformUtils.wrapperContextForParams(r9, AccessibilityService.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "setService " + r10, false, 4, null);
        if (r10 != null) goto L5;
        e = null;
        return;
    L5:
        e = new WeakReference(r10);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r0.add(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r12.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L7
    L9:
        Set r13 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        WeakReference<AccessibilityService> r1 = e;
        if (r1 == null) goto L21;
        AccessibilityService r2 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r1.get(), AccessibilityService.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L21;
        AccessibilityServiceInfo r3 = r2.getServiceInfo();
        if (r3 == null) goto L21;
        if (r3.packageNames != null) goto L19;
        r3.packageNames = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L20:
        r3.eventTypes = f12771a.a(r3.eventTypes);
        r2.setServiceInfo(r3);
        goto L21
    L19:
        String[] r4 = r3.packageNames;
        Intrinsics.checkNotNullExpressionValue(r4, "packageNames");
        r3.packageNames = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(SetsKt.plus(r13, (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L21:
        f();
    }

    public final void a(AccessibilityEvent r6, TouchInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r2, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName(), r6.getPackageName()) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r1.add(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r10.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getId());
        goto L10
    L12:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Map<String, AccessibilityRuleStatus> r3 = d;
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, AccessibilityRuleStatus>> r12 = r3.entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r11.contains(r13.getKey()) == false) goto L14;
        r4.put(r13.getKey(), r13.getValue());
        goto L14
    L18:
        Iterator r14 = r4.entrySet().iterator();
    L20:
        if (r14.hasNext() == false) goto L26;
        AccessibilityRuleStatus r15 = (AccessibilityRuleStatus) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), AccessibilityRuleStatus.class, "com.obric.memorydata.plugin");
        WeakReference<AccessibilityService> r16 = e;
        if (r16 == null) goto L24;
        AccessibilityService r17 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r16.get(), AccessibilityService.class, "com.obric.memorydata.plugin");
    L25:
        r15.a(r17, r6, c, r7);
        goto L20
    L24:
        r17 = null;
        goto L25
    }

    public final void a(AccessibilityNodeInfo r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        CharSequence r0 = r9.getText();
        int r1 = 0;
        boolean r2 = true;
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L20;
        CharSequence r4 = r9.getContentDescription();
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L20;
    L52:
        int r6 = r9.getChildCount();
    L53:
        if (r1 >= r6) goto L55;
        a(r9.getChild(r1));
        r1 = r1 + 1;
        goto L53
    L55:
        return;
    L15:
        if (StringsKt.isBlank(r4) == true) goto L18;
        r5 = false;
    L20:
        Rect r7 = new Rect();
        r9.getBoundsInScreen(r7);
        StringBuilder r8 = new StringBuilder("view node info ");
        CharSequence r10 = r9.getText();
        if (r10 != null) goto L23;
    L26:
        boolean r11 = true;
    L28:
        if (r11 == true) goto L30;
        r8.append("text: <" + r9.getText() + "> ");
    L30:
        CharSequence r12 = r9.getContentDescription();
        if (r12 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == true) goto L39;
        r8.append("contentDescription: <" + r9.getContentDescription() + "> ");
    L39:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getViewIdResourceName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L42;
    L45:
        if (r2 == true) goto L47;
        String r15 = r9.getViewIdResourceName();
        Intrinsics.checkNotNullExpressionValue(r15, "getViewIdResourceName(...)");
        r8.append("viewIdResourceName: <" + StringsKt.substringAfter$default(r15, ":id/", null, 2, null) + "> ");
    L47:
        r8.append("\t\t" + r7 + ' ');
        if (r9.isVisibleToUser() == false) goto L50;
        String r16 = "visible";
    L51:
        r8.append(r16);
        RunLog r17 = RunLog.INSTANCE;
        String r18 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "toString(...)");
        r17.debug("DumpViewTree", r18);
        goto L52
    L50:
        r16 = "invisible";
        goto L51
    L42:
        if (r14.length() == 0) goto L45;
        r2 = false;
        goto L45
    L33:
        if (r12.length() == 0) goto L36;
        r13 = false;
        goto L37
    L23:
        if (r10.length() == 0) goto L26;
        r11 = false;
        goto L28
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r3 = false;
        goto L11
    }

    public final void a(b r2) {
        c = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.screencapture.monitor.e.b
    public void a(ScreenTouchEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.getAction() != ScreenTouchEvent.TouchAction.TAP) goto L6;
        a(SQLiteDatabase.CREATE_IF_NECESSARY, r3.getTouchInfo());
        return;
    }

    public final void a(final AppAccessibilityEventRule r10) {
        Intrinsics.checkNotNullParameter(r10, "rule");
        Object r9 = f;
        monitor-enter(r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "register rule id=" + r10.getId() + " pkg=" + r10.getPackageName() + " conditions=" + r10.getConditions().size() + " resets=" + r10.getResetConditions().size() + " poll=" + r10.getPollCheck(), false, 4, null);     // Catch: Throwable -> L34
        Set<AppAccessibilityEventRule> r0 = f12772b;     // Catch: Throwable -> L34
        if (r0.isEmpty() == false) goto L7;
        g.removeMessages(2);     // Catch: Throwable -> L34
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(f12771a, af.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L34
        c.f12773a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L34
    L7:
        final Function1 r1 = new $$Lambda$a$xctPEnvFTAmj2b2k4XyQ6BQnuQ(r10);     // Catch: Throwable -> L34
        if (r0.removeIf(new $$Lambda$a$5iDSoe4J8RaA0g58GmfpuQ2Cmk(r1)) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "repeat register rule: " + r10.getId(), null, 4, null);     // Catch: Throwable -> L34
    L10:
        r0.add(r10);     // Catch: Throwable -> L34
        d.put(r10.getId(), new AccessibilityRuleStatus(r10));     // Catch: Throwable -> L34
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L34
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r4.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName());     // Catch: Throwable -> L34
        goto L12
    L14:
        Set r5 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L34
        if (r10.getPollCheck() == false) goto L19;
        HandlerC0688a r11 = g;     // Catch: Throwable -> L34
        if (r11.hasMessages(1) == true) goto L19;
        r11.sendEmptyMessage(1);     // Catch: Throwable -> L34
    L19:
        WeakReference<AccessibilityService> r12 = e;     // Catch: Throwable -> L34
        if (r12 == null) goto L31;
        AccessibilityService r13 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r12.get(), AccessibilityService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r13 == null) goto L31;
        AccessibilityServiceInfo r6 = r13.getServiceInfo();     // Catch: Throwable -> L34
        if (r6 == null) goto L31;
        if (r6.packageNames != null) goto L29;
        r6.packageNames = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
    L30:
        r6.eventTypes = f12771a.a(r6.eventTypes);     // Catch: Throwable -> L34
        r13.setServiceInfo(r6);     // Catch: Throwable -> L34
        goto L31
    L29:
        String[] r7 = r6.packageNames;     // Catch: Throwable -> L34
        Intrinsics.checkNotNullExpressionValue(r7, "packageNames");     // Catch: Throwable -> L34
        r6.packageNames = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(SetsKt.plus(r5, (Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
    L31:
        f12771a.f();     // Catch: Throwable -> L34
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r9);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    public final void a(final String r11) {
        Intrinsics.checkNotNullParameter(r11, "ruleId");
        Object r10 = f;
        monitor-enter(r10);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L53
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r1 = r0.next();     // Catch: Throwable -> L53
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r1, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getId(), r11) == false) goto L6;
    L11:
        AppAccessibilityEventRule r2 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r1, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r2 != null) goto L15;
        monitor-exit(r10);
        return;
    L15:
        Set<AppAccessibilityEventRule> r3 = f12772b;     // Catch: Throwable -> L53
        final Function1 r4 = new $$Lambda$a$8VZwfPFmhz6TnV0TN7sYYmhJw(r11);     // Catch: Throwable -> L53
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "unregisterRule " + r11 + ' ' + r3.removeIf(new $$Lambda$a$LVTZoOiWiCb6y8vWh6rvFceIVnw(r4)), false, 4, null);     // Catch: Throwable -> L53
        d.remove(r11);     // Catch: Throwable -> L53
        if (r3.isEmpty() == false) goto L18;
        af.f13160a.b((af.a) ZeusTransformUtils.preCheckCast(f12771a, af.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
    L18:
        String r12 = r2.getPackageName();     // Catch: Throwable -> L53
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L21;
    L23:
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L53
    L25:
        if (r6.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r6.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName(), r12) == false) goto L25;
        boolean r7 = true;
    L30:
        if (r7 == true) goto L50;
        WeakReference<AccessibilityService> r8 = e;     // Catch: Throwable -> L53
        if (r8 == null) goto L50;
        AccessibilityService r9 = (AccessibilityService) ZeusTransformUtils.preCheckCast(r8.get(), AccessibilityService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r9 == null) goto L50;
        AccessibilityServiceInfo r13 = r9.getServiceInfo();     // Catch: Throwable -> L53
        if (r13 == null) goto L50;
        String[] r14 = r13.packageNames;     // Catch: Throwable -> L53
        if (r14 == null) goto L42;
        Set r15 = ArraysKt.toMutableSet(r14);     // Catch: Throwable -> L53
        if (r15 == null) goto L42;
    L44:
        if (r15.contains(r12) == true) goto L47;
        monitor-exit(r10);
        return;
    L47:
        r15.remove(r12);     // Catch: Throwable -> L53
        r13.packageNames = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        r9.setServiceInfo(r13);     // Catch: Throwable -> L53
        if (r15.isEmpty() == false) goto L50;
        g.sendEmptyMessageDelayed(2, 0);     // Catch: Throwable -> L53
    L42:
        r15 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
    L50:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r10);
        return;
    L29:
        r7 = false;
        goto L30
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L10:
        r1 = null;
    L53:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.utils.af.a
    public void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        d(r2, r3);
    }

    public final void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, InfoRequestQPSOptTraceLogger.REASON);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "viewtree service enable reason=" + r9, false, 4, null);
        g.removeMessages(2);
        c.f12773a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), true);
    }

    @Override // com.obric.memorydata.utils.af.a
    public void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "appName");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
    }

    public final void c(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        Object r6 = f;
        monitor-enter(r6);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f12772b, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L19
    L10:
        if (r1.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r1.next(), AppAccessibilityEventRule.class, "com.obric.memorydata.plugin")).getPackageName(), r7) == false) goto L10;
        r2 = true;
    L15:
        monitor-exit(r6);
        if (r2 == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AccessibilityRuleManager", "viewtree service disable reason=" + r8, false, 4, null);
        g.sendEmptyMessageDelayed(2, 0);
        return;
    L27:
        return;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L19:
        th = move-exception;
        throw th;
    }
}
