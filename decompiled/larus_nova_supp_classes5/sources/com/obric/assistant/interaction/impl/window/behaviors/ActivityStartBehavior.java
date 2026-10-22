package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.home.api.main.IHomeApi;
import com.larus.im.b;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.activityresult.ActivityResultProxyActivity;
import com.obric.assistant.interaction.impl.hook.ObricInstrumentation;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001\u001c\b\u0007\u0018\u0000 82\u00020\u0001:\u000389:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J,\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u0018H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\fH\u0002J\u001c\u0010,\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u00100\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u00101\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\bH\u0002J\u0010\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\bH\u0002J\n\u00106\u001a\u00020\u0018*\u00020\bJ\f\u00107\u001a\u00020\u0018*\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006;"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "pendingInternalActivityRecord", "Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$PendingInternalActivityRecord;", "deferredWindowStashActivities", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "deferredWindowStashTimeout", "Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$DeferredWindowStashTimeout;", "obricChatClassName", "", "execStartActivityListener", "Lcom/obric/assistant/interaction/impl/hook/ObricInstrumentation$OnExecStartActivityListener;", "maybeHandleWindowStartActivity", "Landroid/os/Bundle;", "who", "Landroid/content/Context;", "options", "originalOptions", "notifySystemUI", "", "isProblematicActivityOptionsForWindowStart", "", "stripTransitionsFromActivityOptions", "finishExistedHelperActivityTaskIfNeeded", "activityLifecycleCallback", "com/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$activityLifecycleCallback$1", "Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$activityLifecycleCallback$1;", "init", "onWindowShow", "onWindowPreOpenClear", "onWindowDismiss", "recordPendingInternalActivity", "intent", "Landroid/content/Intent;", "deferWindowStashUntilResumed", "allowNonWindowCaller", "findDeferredInternalActivityRecordForCaller", "scheduleDeferredWindowStashTimeout", "record", "cancelDeferredWindowStashTimeout", "reason", "clearDeferredWindowStashState", "preserveChainToken", "resolveInternalTargetActivityClassName", "maybeAddExtraFlags", "maybeAddClearTaskFlag", "maybeAddClearTopFlag", "consumePendingInternalActivity", "activity", "cleanupActivitiesInSameTask", "startedActivity", "isInDefaultTask", "isAliveForCleanup", "Companion", "PendingInternalActivityRecord", "DeferredWindowStashTimeout", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityStartBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final long DEFERRED_WINDOW_STASH_TIMEOUT_MS = 2000;
    private static final String EXTRA_INTERNAL_ACTIVITY_CONSUMED = "obric_internal_activity_consumed";
    private static final String EXTRA_PENDING_INTERNAL_ACTIVITY_TOKEN = "obric_pending_internal_activity_token";
    private static final int INVOCATION_TYPE_NOTIFY_SYSTEMUI_STARTING_ACTIVITY = -104;
    private static final String KEY_ACTIVITY_OPTIONS_ANIM_TYPE = "android:activity.animType";
    private static final String KEY_ACTIVITY_OPTIONS_LAUNCH_DISPLAY_ID = "android.activity.launchDisplayId";
    private static final String TAG = "ActivityStartBehavior";
    private static ActivityStartBehavior activeInstance;
    private final ActivityStartBehavior$activityLifecycleCallback$1 activityLifecycleCallback;
    private final WeakHashMap<Activity, PendingInternalActivityRecord> deferredWindowStashActivities;
    private DeferredWindowStashTimeout deferredWindowStashTimeout;
    private final ObricInstrumentation.OnExecStartActivityListener execStartActivityListener;
    private final String obricChatClassName;
    private PendingInternalActivityRecord pendingInternalActivityRecord;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ActivityStartBehavior r0, PendingInternalActivityRecord r1) {
        scheduleDeferredWindowStashTimeout$lambda$12(r0, r1);
    }

    public static /* synthetic */ boolean b(String r0, Map.Entry r1) {
        return clearDeferredWindowStashState$lambda$14(r0, r1);
    }

    public static /* synthetic */ Bundle c(ActivityStartBehavior r0, Context r1, Intent r2, Bundle r3) {
        return execStartActivityListener$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void d(ActivityStartBehavior r0, Activity r1) {
        finishExistedHelperActivityTaskIfNeeded$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean e(PendingInternalActivityRecord r0, Map.Entry r1) {
        return scheduleDeferredWindowStashTimeout$lambda$12$lambda$11(r0, r1);
    }

    @JvmStatic
    public static final boolean isInternalActivityConsumed(Activity r1) {
        return Companion.isInternalActivityConsumed(r1);
    }

    @JvmStatic
    public static final boolean isWaitingDeferredWindowStash() {
        return Companion.isWaitingDeferredWindowStash();
    }

    public void onWindowDismiss() {
        clearDeferredWindowStashState$default(this, "window_dismiss", null, 2, null);
    }

    public void onWindowPreOpenClear() {
        clearDeferredWindowStashState$default(this, "window_open", null, 2, null);
    }

    public void onWindowShow() {
    }

    private final void finishExistedHelperActivityTaskIfNeeded() {
        Iterator r0 = AppHost.a.a().g().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Activity r1 = (Activity) r0.next();
        if (ChatWindowServiceDelegate.b.c(r1) == false) goto L4;
        FLogger.a.i(TAG, "finish existed helper activity " + r1);
        t0.b(new d(this, r1), 200);
        goto L4
    }

    private final void notifySystemUI() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Object r0 = AppHost.a.getApplication().getSystemService("search");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager r1 = (SearchManager) r0;
        Method r2 = r1.getClass().getMethod("launchAssist", new Class[]{Bundle.class});
        Bundle r3 = new Bundle();
        r3.putInt("custom_show_flags", 0);
        r3.putInt("invocation_type", INVOCATION_TYPE_NOTIFY_SYSTEMUI_STARTING_ACTIVITY);
        Unit r4 = Unit.INSTANCE;
        r2.invoke(r1, new Object[]{r3});
        return;
    L5:
        FLogger.a.w(TAG, "notifySystemUI not support");
    }

    public void init() {
        activeInstance = this;
        ObricInstrumentation.setOnExecStartActivityListener(this.execStartActivityListener);
        AppHost.a.a().e(this.activityLifecycleCallback);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior$activityLifecycleCallback$1] */
    public ActivityStartBehavior() {
        this.deferredWindowStashActivities = new WeakHashMap();
        IHomeApi r0 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r0 == null) goto L5;
        String r1 = r0.r();
    L6:
        this.obricChatClassName = r1;
        this.execStartActivityListener = new a(this);
        this.activityLifecycleCallback = new ActivityStartBehavior$activityLifecycleCallback$1(this);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ ActivityStartBehavior access$getActiveInstance$cp() {
        return activeInstance;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public static final /* synthetic */ WeakHashMap access$getDeferredWindowStashActivities$p(ActivityStartBehavior r0) {
        return r0.deferredWindowStashActivities;
    }

    public static final /* synthetic */ DeferredWindowStashTimeout access$getDeferredWindowStashTimeout$p(ActivityStartBehavior r0) {
        return r0.deferredWindowStashTimeout;
    }

    public static final /* synthetic */ PendingInternalActivityRecord access$getPendingInternalActivityRecord$p(ActivityStartBehavior r0) {
        return r0.pendingInternalActivityRecord;
    }

    private final void cleanupActivitiesInSameTask(Activity r12) {
        List r0 = AppHost.a.a().g();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        if (((Activity) r4).getTaskId() != r12.getTaskId()) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L10:
        List r5 = CollectionsKt.asReversed(r1);
        int r6 = r5.indexOf(r12);
        if (r6 >= 0) goto L13;
        return;
    L13:
        int r7 = r6 + 1;
        List r8 = CollectionsKt.drop(r5, r7);
        if (r8.isEmpty() == false) goto L16;
        return;
    L16:
        List r9 = r8;
        Iterator r10 = r9.iterator();
    L17:
        Object r11 = null;
        if (r10.hasNext() == false) goto L27;
        Object r13 = r10.next();
        Activity r14 = (Activity) r13;
        if (isAliveForCleanup(r14) == true) goto L22;
    L24:
        boolean r15 = false;
    L25:
        if (r15 == false) goto L17;
    L28:
        Activity r16 = (Activity) r13;
        if (r16 == null) goto L31;
        r8 = r5.subList(r7, r5.indexOf(r16));
    L46:
        if (r8.isEmpty() == false) goto L48;
        return;
    L48:
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("cleanup same task activities, started=");
        r18.append(r12.getClass().getName());
        r18.append(", targets=");
        List r19 = r8;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r20 = r19.iterator();
    L50:
        if (r20.hasNext() == false) goto L52;
        r110.add(((Activity) r20.next()).getClass().getName());
        goto L50
    L52:
        r18.append(r110);
        r17.i(TAG, r18.toString());
        Iterator r111 = r19.iterator();
    L54:
        if (r111.hasNext() == false) goto L60;
        Activity r21 = (Activity) r111.next();
        if (r21.isFinishing() == true) goto L54;
        if (r21.isDestroyed() == true) goto L54;
        r21.finish();
        goto L54
    L60:
        return;
    L31:
        String r22 = HomeServiceV2.a.a();
        Iterator r23 = r9.iterator();
    L33:
        if (r23.hasNext() == false) goto L42;
        Object r24 = r23.next();
        Activity r25 = (Activity) r24;
        if (isAliveForCleanup(r25) == true) goto L37;
    L39:
        boolean r26 = false;
    L40:
        if (r26 == false) goto L33;
        r11 = r24;
        goto L42
    L37:
        if (Intrinsics.areEqual(r25.getClass().getName(), r22) == false) goto L39;
        r26 = true;
    L42:
        Activity r27 = (Activity) r11;
        if (r27 == null) goto L46;
        r8 = r5.subList(r7, r5.indexOf(r27));
        goto L46
    L22:
        if (ObricChatContextServiceDelegate.b.e(r14) == false) goto L24;
        r15 = true;
        goto L25
    L27:
        r13 = null;
        goto L28
    }

    private final boolean consumePendingInternalActivity(Activity r12) {
        PendingInternalActivityRecord r0 = this.pendingInternalActivityRecord;
        if (r0 != null) goto L5;
        return false;
    L5:
        Intent r2 = r12.getIntent();
        if (r2 == null) goto L8;
        String r5 = r2.getStringExtra(EXTRA_PENDING_INTERNAL_ACTIVITY_TOKEN);
    L10:
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L30;
        if (Intrinsics.areEqual(r0.getToken(), r5) == false) goto L30;
        this.pendingInternalActivityRecord = null;
        r2.removeExtra(EXTRA_PENDING_INTERNAL_ACTIVITY_TOKEN);
        if (Intrinsics.areEqual(r0.getTargetActivityClassName(), r12.getClass().getName()) == true) goto L25;
        FLogger.a.w(TAG, "pending internal activity mismatch, expected=" + r0.getTargetActivityClassName() + ", actual=" + r12.getClass().getName() + ", token=" + r5);
        return false;
    L25:
        if (r0.getDeferWindowStashUntilResumed() == false) goto L27;
        this.deferredWindowStashActivities.put(r12, r0);
    L27:
        FLogger.a.i(TAG, "consume pending internal activity=" + r12.getClass().getName() + ", token=" + r5);
        return true;
    L30:
        if (Intrinsics.areEqual(r0.getTargetActivityClassName(), r12.getClass().getName()) == false) goto L36;
        this.pendingInternalActivityRecord = null;
        if (r0.getDeferWindowStashUntilResumed() == false) goto L34;
        this.deferredWindowStashActivities.put(r12, r0);
    L34:
        FLogger.a.i(TAG, "consume pending internal activity by class=" + r12.getClass().getName() + ", token=" + r0.getToken());
        return true;
    L36:
        FLogger.a.i(TAG, "skip unrelated activity, expected=" + r0.getTargetActivityClassName() + ", actual=" + r12.getClass().getName() + ", token=" + r0.getToken());
        return false;
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
        goto L17
    L8:
        r5 = null;
        goto L10
    }

    private final PendingInternalActivityRecord findDeferredInternalActivityRecordForCaller(Context r5) {
        PendingInternalActivityRecord r1 = null;
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r6 = (Activity) r5;
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        PendingInternalActivityRecord r0 = this.pendingInternalActivityRecord;
        if (r0 == null) goto L16;
        if (Intrinsics.areEqual(r0.getTargetActivityClassName(), r6.getClass().getName()) == false) goto L13;
        r1 = r0;
    L13:
        if (r1 == null) goto L16;
        return r1;
    L16:
        return this.deferredWindowStashActivities.get(r6);
    L5:
        r6 = null;
        goto L6
    }

    private final boolean isAliveForCleanup(Activity r2) {
        if (r2.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.isDestroyed() == true) goto L7;
        return true;
    }

    private final boolean isProblematicActivityOptionsForWindowStart(Bundle r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = -1;
        r1 = r7.getInt(KEY_ACTIVITY_OPTIONS_ANIM_TYPE, -1);     // Catch: Throwable -> L8
    L10:
        if (r1 <= 0) goto L12;
        return true;
    L12:
        Set<String> r8 = r7.keySet();
        if (r8 == null) goto L46;
        Set<String> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L18;
        String r2 = (String) r10.next();
        Intrinsics.checkNotNull(r2);
        if (StringsKt.startsWith$default(r2, "android:activity.", false, 2, null) == true) goto L25;
    L33:
        boolean r3 = false;
    L34:
        if (r3 == false) goto L21;
        boolean r11 = true;
    L36:
        if (r11 != true) goto L47;
        return true;
    L47:
        return false;
    L25:
        if (StringsKt.contains(r2, "sharedElement", true) == false) goto L27;
    L32:
        r3 = true;
        goto L34
    L27:
        if (StringsKt.contains(r2, "transition", true) == true) goto L32;
        if (StringsKt.contains(r2, "remoteAnimation", true) == true) goto L32;
        if (StringsKt.contains(r2, "anim", true) == false) goto L33;
    L18:
        r11 = false;
        goto L36
    L17:
        if (r9.isEmpty() == false) goto L19;
    L46:
        return false;
    }

    private final String resolveInternalTargetActivityClassName(Intent r8) {
        i r0 = b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r1 = r0.getApplication();
        ActivityInfo r9 = r8.resolveActivityInfo(r1.getPackageManager(), 65536);
        if (r9 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r9.packageName, r1.getPackageName()) == true) goto L8;
        return null;
    L8:
        ApplicationInfo r2 = r1.getApplicationInfo();
        if (r2 == null) goto L12;
        String r3 = r2.processName;
        if (r3 == null) goto L12;
    L13:
        String r4 = r9.processName;
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        r4 = r3;
    L26:
        if (Intrinsics.areEqual(r4, r3) == true) goto L29;
        FLogger.a.i(TAG, "skip deferred stash for non-main process activity=" + r9.name + ", process=" + r4);
        return null;
    L29:
        String r6 = r9.targetActivity;
        if (r6 == null) goto L32;
        return r6;
    L32:
        return r9.name;
    L23:
        if (StringsKt.startsWith$default(r4, ":", false, 2, null) == false) goto L26;
        r4 = r1.getPackageName() + r4;
        goto L26
    L16:
        if (r4.length() == 0) goto L19;
        r5 = false;
    L12:
        r3 = r1.getPackageName();
        goto L13
    }

    private final void scheduleDeferredWindowStashTimeout(PendingInternalActivityRecord r5) {
        clearDeferredWindowStashState("start_replaced", r5.getChainToken());
        this.pendingInternalActivityRecord = r5;
        Runnable r0 = new b(this, r5);
        this.deferredWindowStashTimeout = new DeferredWindowStashTimeout(r5.getToken(), r5.getChainToken(), r0);
        t0.a.postDelayed(r0, DEFERRED_WINDOW_STASH_TIMEOUT_MS);
        FLogger.a.i(TAG, "schedule stash timeout, activity=" + r5.getTargetActivityClassName() + ", token=" + r5.getToken() + ", chainToken=" + r5.getChainToken() + ", timeoutMs=2000");
    }

    private final Bundle stripTransitionsFromActivityOptions(Bundle r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        Bundle r1 = new Bundle(r7);
        Set<String> r8 = r1.keySet();
        if (r8 == null) goto L30;
        List r9 = CollectionsKt.toList(r8);
        if (r9 == null) goto L30;
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L30;
        String r2 = (String) r10.next();
        if (Intrinsics.areEqual(r2, KEY_ACTIVITY_OPTIONS_LAUNCH_DISPLAY_ID) == true) goto L11;
        if (Intrinsics.areEqual(r2, KEY_ACTIVITY_OPTIONS_ANIM_TYPE) == true) goto L17;
        Intrinsics.checkNotNull(r2);
        if (StringsKt.startsWith$default(r2, "android:activity.", false, 2, null) == false) goto L11;
        if (StringsKt.contains(r2, "sharedElement", true) == true) goto L28;
        if (StringsKt.contains(r2, "transition", true) == true) goto L28;
        if (StringsKt.contains(r2, "remoteAnimation", true) == true) goto L28;
        if (StringsKt.contains(r2, "anim", true) == false) goto L11;
    L28:
        r1.remove(r2);
        goto L11
    L17:
        r1.remove(r2);
    L30:
        if (r1.isEmpty() == false) goto L33;
        return null;
    L33:
        return r1;
    }

    public final boolean isInDefaultTask(Activity r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Object r0 = r6.getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.AppTask> r1 = ((ActivityManager) r0).getAppTasks();
        if (r1 != null) goto L5;
        return false;
    L5:
        Iterator<ActivityManager.AppTask> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L35;
        ActivityManager.RecentTaskInfo r3 = r2.next().getTaskInfo();
        if (Build.VERSION.SDK_INT < 29) goto L11;
        int r4 = r3.taskId;
    L13:
        if (r4 != r6.getTaskId()) goto L7;
        Intent r7 = r3.baseIntent;
        if (r7 != null) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r7.getAction(), "android.intent.action.MAIN") == true) goto L20;
    L22:
        boolean r5 = false;
    L24:
        if ((r7.getFlags() & 134217728) == 0) goto L26;
        boolean r8 = true;
    L27:
        if (r5 == true) goto L29;
        if (r8 == false) goto L29;
        return false;
    L29:
        return true;
    L26:
        r8 = false;
        goto L27
    L20:
        if (r7.hasCategory("android.intent.category.LAUNCHER") == false) goto L22;
        r5 = true;
        goto L24
    L11:
        r4 = r3.id;
        goto L13
    L35:
        return false;
    }

    public static final /* synthetic */ void access$cleanupActivitiesInSameTask(ActivityStartBehavior r0, Activity r1) {
        r0.cleanupActivitiesInSameTask(r1);
    }

    public static final /* synthetic */ boolean access$consumePendingInternalActivity(ActivityStartBehavior r0, Activity r1) {
        return r0.consumePendingInternalActivity(r1);
    }

    public static final /* synthetic */ void access$setPendingInternalActivityRecord$p(ActivityStartBehavior r0, PendingInternalActivityRecord r1) {
        r0.pendingInternalActivityRecord = r1;
    }

    private final void cancelDeferredWindowStashTimeout(PendingInternalActivityRecord r7, String r8) {
        DeferredWindowStashTimeout r0 = this.deferredWindowStashTimeout;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0.getChainToken(), r7.getChainToken()) == true) goto L9;
        FLogger.a.w(TAG, "skip cancel stash timeout, reason=" + r8 + ", expected=" + r0.getChainToken() + ", actual=" + r7.getChainToken() + ", token=" + r7.getToken());
        return;
    L9:
        this.deferredWindowStashTimeout = null;
        t0.a.removeCallbacks(r0.getRunnable());
        FLogger.a.i(TAG, "cancel stash timeout, reason=" + r8 + ", token=" + r7.getToken() + ", chainToken=" + r7.getChainToken() + ", timeoutToken=" + r0.getToken());
    }

    private final void clearDeferredWindowStashState(String r5, String r6) {
        DeferredWindowStashTimeout r0 = this.deferredWindowStashTimeout;
        if (r0 == null) goto L5;
        t0.a.removeCallbacks(r0.getRunnable());
        FLogger.a.i(TAG, "clear stash timeout, reason=" + r5 + ", token=" + r0.getToken() + ", chainToken=" + r0.getChainToken() + ", preserveChainToken=" + r6);
    L5:
        this.deferredWindowStashTimeout = null;
        PendingInternalActivityRecord r1 = this.pendingInternalActivityRecord;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L18;
        PendingInternalActivityRecord r3 = this.pendingInternalActivityRecord;
        if (r3 == null) goto L14;
        String r4 = r3.getChainToken();
    L16:
        if (Intrinsics.areEqual(r4, r6) == true) goto L18;
        this.pendingInternalActivityRecord = null;
        goto L18
    L14:
        r4 = null;
    L18:
        CollectionsKt.removeAll(this.deferredWindowStashActivities.entrySet(), new e(r6));
        return;
    L8:
        if (r1.getDeferWindowStashUntilResumed() != true) goto L10;
        r2 = true;
        goto L10
    }

    private static final boolean clearDeferredWindowStashState$lambda$14(String r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !Intrinsics.areEqual(((PendingInternalActivityRecord) r2.getValue()).getChainToken(), r1);
    }

    private static final void finishExistedHelperActivityTaskIfNeeded$lambda$8$lambda$7(ActivityStartBehavior r2, Activity r3) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L4
        r3.finishAndRemoveTask();     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.e(TAG, "finishAndRemoveTask failed", r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void maybeAddClearTaskFlag(Context r2, Intent r3) {
        if ((r2 instanceof Activity) == false) goto L8;
        if ((r2 instanceof ChatWindowActivity) == true) goto L8;
        return;
    L8:
        if ((r3.getFlags() & 134217728) == 0) goto L10;
        return;
    L10:
        r3.addFlags(32768);
    }

    private final void maybeAddClearTopFlag(Context r4, Intent r5) {
        if ((r4 instanceof Activity) == false) goto L6;
        return;
    L6:
        if ((r5.getFlags() & 134217728) == 0) goto L8;
        return;
    L8:
        String r6 = resolveInternalTargetActivityClassName(r5);
        if (r6 != null) goto L11;
        return;
    L11:
        List r0 = AppHost.a.a().g();
        boolean r2 = false;
        if ((r0 instanceof Collection) == true) goto L14;
    L16:
        Iterator r1 = r0.iterator();
    L18:
        if (r1.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((Activity) r1.next()).getClass().getName(), r6) == false) goto L18;
        r2 = true;
    L22:
        if (r2 == true) goto L25;
        return;
    L25:
        if ((r5.getFlags() & 67108864) != 0) goto L31;
        r5.addFlags(67108864);
        FLogger.a.i(TAG, "add FLAG_ACTIVITY_CLEAR_TOP for existing activity=".concat(r6));
        return;
    L31:
        return;
    L14:
        if (r0.isEmpty() == false) goto L16;
        goto L16
    }

    private final void maybeAddExtraFlags(Context r2, Intent r3) {
        if (IWindowContextKt.isWindowContext(r2) == true) goto L6;
        return;
    L6:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L8;
        maybeAddClearTaskFlag(r2, r3);
        return;
    L8:
        maybeAddClearTopFlag(r2, r3);
    }

    private static final void scheduleDeferredWindowStashTimeout$lambda$12(ActivityStartBehavior r5, PendingInternalActivityRecord r6) {
        DeferredWindowStashTimeout r0 = r5.deferredWindowStashTimeout;
        if (r0 == null) goto L5;
        String r1 = r0.getToken();
    L7:
        if (Intrinsics.areEqual(r1, r6.getToken()) == true) goto L9;
        return;
    L9:
        r5.deferredWindowStashTimeout = null;
        PendingInternalActivityRecord r2 = r5.pendingInternalActivityRecord;
        if (r2 == null) goto L12;
        String r3 = r2.getToken();
    L14:
        if (Intrinsics.areEqual(r3, r6.getToken()) == false) goto L16;
        r5.pendingInternalActivityRecord = null;
    L16:
        CollectionsKt.removeAll(r5.deferredWindowStashActivities.entrySet(), new c(r6));
        WindowHost r7 = WindowHost.INSTANCE;
        if (r7.isShowing() == true) goto L20;
        FLogger.a.i(TAG, "skip stash timeout because window hidden, activity=" + r6.getTargetActivityClassName() + ", token=" + r6.getToken());
        return;
    L20:
        FLogger.a.w(TAG, "stash timeout, activity=" + r6.getTargetActivityClassName() + ", token=" + r6.getToken() + ", chainToken=" + r6.getChainToken() + ", timeoutMs=2000");
        r7.stash(WindowAnimationType.Slide);
        return;
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    private static final boolean scheduleDeferredWindowStashTimeout$lambda$12$lambda$11(PendingInternalActivityRecord r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(((PendingInternalActivityRecord) r2.getValue()).getChainToken(), r1.getChainToken());
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }

    public static final /* synthetic */ void access$cancelDeferredWindowStashTimeout(ActivityStartBehavior r0, PendingInternalActivityRecord r1, String r2) {
        r0.cancelDeferredWindowStashTimeout(r1, r2);
    }

    private final Bundle maybeHandleWindowStartActivity(Context r4, Bundle r5, Bundle r6) {
        boolean r1 = false;
        if (IWindowContextKt.isWindowContext(r4) == false) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
    L13:
        if (r1 == false) goto L19;
        r5 = stripTransitionsFromActivityOptions(r5);
        FLogger r8 = FLogger.a;
        StringBuilder r0 = new StringBuilder("strip ActivityOptions for window start, keys=");
        if (r6 == null) goto L17;
        Set<String> r9 = r6.keySet();
    L18:
        r0.append(r9);
        r8.i(TAG, r0.toString());
        goto L19
    L17:
        r9 = null;
    L19:
        return r5;
    L11:
        if (isProblematicActivityOptionsForWindowStart(r5) == false) goto L13;
        r1 = true;
        goto L13
    L5:
        if ((r4 instanceof ChatWindowActivity) == true) goto L8;
        r7 = false;
        goto L9
    }

    private static final Bundle execStartActivityListener$lambda$1(ActivityStartBehavior r19, Context r20, Intent r21, Bundle r22) {
        if (r21 == null) goto L7;
        ComponentName r0 = r21.getComponent();
        if (r0 == null) goto L7;
        String r1 = r0.getClassName();
    L8:
        boolean r13 = true;
        if (Intrinsics.areEqual(r1, ActivityResultProxyActivity.class.getName()) == true) goto L11;
        String r2 = KeyguardService.a.getHelperActivityName();
        if (r2 == null) goto L29;
        if (r21 == null) goto L26;
        ComponentName r3 = r21.getComponent();
        if (r3 == null) goto L26;
        String r4 = r3.getClassName();
        if (r4 == null) goto L26;
        if (StringsKt.endsWith$default(r4, r2, false, 2, null) != true) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L29;
        return r22;
    L26:
        r5 = false;
    L29:
        WindowHost r15 = WindowHost.INSTANCE;
        boolean r6 = r15.isShowing();
        FLogger r7 = FLogger.a;
        r7.i(TAG, "onExecStartActivity isShowing = " + r6 + ", intent = " + r21);
        if (r6 == false) goto L32;
    L35:
        if (r6 == true) goto L37;
    L47:
        Bundle r8 = r22;
    L48:
        r19.finishExistedHelperActivityTaskIfNeeded();
        Intrinsics.checkNotNull(r20);
        Intrinsics.checkNotNull(r21);
        r19.maybeAddExtraFlags(r20, r21);
        PendingInternalActivityRecord r9 = recordPendingInternalActivity$default(r19, r20, r21, r6, false, 8, null);
        Bundle r10 = r19.maybeHandleWindowStartActivity(r20, r8, r22);
        if (r6 == false) goto L70;
        r7.i(TAG, "Window is showing, stash before activity start");
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L53;
        r19.notifySystemUI();
    L53:
        ComponentName r11 = r21.getComponent();
        if (r11 == null) goto L56;
        String r12 = r11.getClassName();
    L58:
        if (Intrinsics.areEqual(r12, r19.obricChatClassName) == false) goto L60;
        r7.i(TAG, "stash with transition overlay animation");
        r15.stashWithTransitionOverlayAnimation();
        return r10;
    L60:
        if (r9 != null) goto L62;
    L64:
        r13 = false;
    L65:
        if (r13 == false) goto L67;
        r7.i(TAG, "defer window stash until resumed, activity=" + r9.getTargetActivityClassName() + ", token=" + r9.getToken());
        r19.scheduleDeferredWindowStashTimeout(r9);
        return r10;
    L67:
        r7.i(TAG, "stash");
        r15.stash(WindowAnimationType.Slide);
        return r10;
    L62:
        if (r9.getDeferWindowStashUntilResumed() != true) goto L64;
    L56:
        r12 = null;
        goto L58
    L70:
        return r10;
    L37:
        if (r22 != null) goto L39;
    L41:
        boolean r14 = false;
    L42:
        if (r14 == true) goto L47;
        if (r22 != null) goto L45;
        Bundle r16 = new Bundle();
    L46:
        r16.putInt(KEY_ACTIVITY_OPTIONS_LAUNCH_DISPLAY_ID, 0);
        r8 = r16;
        goto L48
    L45:
        r16 = r22;
        goto L46
    L39:
        if (r22.containsKey(KEY_ACTIVITY_OPTIONS_LAUNCH_DISPLAY_ID) != true) goto L41;
        r14 = true;
        goto L42
    L32:
        if (LockscreenBehavior.Companion.getStashedByDismissKeyguard() == true) goto L35;
        return r22;
    L11:
        if (WindowHost.INSTANCE.isShowing() == false) goto L15;
        Intrinsics.checkNotNull(r20);
        PendingInternalActivityRecord r17 = r19.recordPendingInternalActivity(r20, r21, true, true);
        if (r17 == null) goto L15;
        FLogger.a.i(TAG, "record ActivityResultProxyActivity as launch bridge, token=" + r17.getToken());
    L15:
        return r22;
    L7:
        r1 = null;
        goto L8
    }

    private final PendingInternalActivityRecord recordPendingInternalActivity(Context r8, Intent r9, boolean r10, boolean r11) {
        PendingInternalActivityRecord r0 = findDeferredInternalActivityRecordForCaller(r8);
        if (r11 == false) goto L5;
    L8:
        String r12 = resolveInternalTargetActivityClassName(r9);
        if (r12 != null) goto L11;
        return null;
    L11:
        String r2 = UUID.randomUUID().toString();
        if (r0 == null) goto L15;
        String r4 = r0.getChainToken();
        if (r4 == null) goto L15;
    L16:
        boolean r5 = true;
        if (r10 == true) goto L19;
    L21:
        boolean r13 = false;
    L22:
        PendingInternalActivityRecord r3 = new PendingInternalActivityRecord(r12, r2, r4, r13);
        if (r0 != null) goto L25;
    L27:
        if (r0 != null) goto L29;
    L31:
        this.pendingInternalActivityRecord = r3;
        r9.putExtra(EXTRA_PENDING_INTERNAL_ACTIVITY_TOKEN, r2);
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("record pending internal activity=");
        r15.append(r12);
        r15.append(", token=");
        r15.append(r2);
        r15.append(", chainToken=");
        r15.append(r3.getChainToken());
        r15.append(", transferred=");
        if (r0 != null) goto L35;
        r5 = false;
    L35:
        r15.append(r5);
        r15.append(", defer=");
        r15.append(r3.getDeferWindowStashUntilResumed());
        r14.i(TAG, r15.toString());
        return r3;
    L29:
        if (r3.getDeferWindowStashUntilResumed() == true) goto L31;
        clearDeferredWindowStashState$default(this, "activity_launch_transferred", null, 2, null);
        goto L31
    L25:
        if ((r8 instanceof Activity) == false) goto L27;
        this.deferredWindowStashActivities.put(r8, r0);
        goto L27
    L19:
        if (Intrinsics.areEqual(r12, this.obricChatClassName) == true) goto L21;
        r13 = true;
    L15:
        r4 = r2;
        goto L16
    L5:
        if (IWindowContextKt.isWindowContext(r8) == true) goto L8;
        if (r0 != null) goto L8;
        return null;
    }

    public static /* synthetic */ void clearDeferredWindowStashState$default(ActivityStartBehavior r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.clearDeferredWindowStashState(r1, r2);
    }

    public static /* synthetic */ PendingInternalActivityRecord recordPendingInternalActivity$default(ActivityStartBehavior r0, Context r1, Intent r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.recordPendingInternalActivity(r1, r2, r3, r4);
    }
}
