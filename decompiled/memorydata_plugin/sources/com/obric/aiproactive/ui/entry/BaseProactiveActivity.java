package com.obric.aiproactive.ui.entry;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0004J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010)\u001a\u00020\u0016H\u0014J\b\u0010*\u001a\u00020\u0016H\u0014J\b\u0010+\u001a\u00020\u0016H\u0014J\b\u0010,\u001a\u00020\u0016H\u0014J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020\u0016H\u0014J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u00102\u001a\u00020\nH\u0014J\b\u00103\u001a\u00020\nH\u0014J\b\u00104\u001a\u00020\nH\u0014J\u0012\u00105\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0004J\b\u00106\u001a\u00020\u0016H\u0004J\u0012\u00107\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u00108\u001a\u00020\u0016H\u0014J\b\u00109\u001a\u00020\u0016H\u0014J\b\u0010:\u001a\u00020\u0016H\u0004J\b\u0010;\u001a\u00020\nH\u0004J\b\u0010<\u001a\u00020\nH\u0002J\u001c\u0010=\u001a\u00020\u00162\b\u0010>\u001a\u0004\u0018\u00010\f2\b\u0010?\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010@\u001a\u00020\u0016H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "hasDeduplicatedProactiveTasks", "", "createdUserId", "", "pendingForegroundLaunchReport", "floatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "startupLaunchReportGate", "Lcom/obric/aiproactive/ui/util/StartupLaunchReportGate;", "getCurrentFloatingTitleBar", "getCurrentFloatingTitleBarActionHost", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "registerFloatingTitleBar", "", "titleBar", "startActivityForResult", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "requestCode", "", "options", "Landroid/os/Bundle;", "attachBaseContext", "newBase", "Landroid/content/Context;", "getResources", "Landroid/content/res/Resources;", "applyOverrideConfiguration", "overrideConfiguration", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onStart", "onResume", "onStop", "onDestroy", "onConfigurationChanged", "newConfig", "onAppForeground", "onNewIntent", "isRequestingLogin", "needLoginCheckOnCreate", "needLoginCheckOnResume", "deferLoginCheckDispatch", "dispatchOnCreateLoginCheck", "dispatchOnResumeLoginCheck", "onCreateChecked", "onResumeChecked", "onResumeNotLogin", "requestLoginGuideOrFinish", "checkAgreePrivacyAndLogin", "isAiProactiveLabEnabled", "reportLaunchEvent", "rawEnterFrom", "startupInspirationId", "deduplicateLegacyProactiveTasksIfNeeded", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseProactiveActivity extends AppCompatActivity implements com.obric.memorydata.ui.b {
    public static final a Companion = null;
    private static final Set<String> PROACTIVE_ROOT_ACTIVITY_CLASS_NAMES = null;
    private static final String PROVIDER_COLUMN_STATUS = "status";
    private static final int PROVIDER_STATUS_ENABLED = 1;
    private static final String TAG = "BaseProactiveActivity";
    private static int activityStartCount;
    private String createdUserId;
    private OFloatingTitleBar floatingTitleBar;
    private boolean hasDeduplicatedProactiveTasks;
    private boolean isRequestingLogin;
    private final NavigationBarScheme navigationBarScheme;
    private boolean pendingForegroundLaunchReport;
    private final com.obric.aiproactive.ui.util.p startupLaunchReportGate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity$Companion;", "", "<init>", "()V", "activityStartCount", "", "TAG", "", "PROVIDER_STATUS_ENABLED", "PROVIDER_COLUMN_STATUS", "PROACTIVE_ROOT_ACTIVITY_CLASS_NAMES", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.BaseProactiveActivity$reportLaunchEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.BaseProactiveActivity$reportLaunchEvent$1", f = "BaseProactiveActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $launchPosition;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(String r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$launchPosition = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$launchPosition, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r9);
            al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            Integer r11 = null;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
            IProactiveService r1 = (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            boolean r2 = true;
            if (r1 != null) goto L8;
        L10:
            r2 = false;
        L11:
            if (r2 == false) goto L13;
            com.obric.aiproactive.api.aa r3 = r1.getAiRuleFollowupCounts();     // Catch: Throwable -> L16
        L14:
            Object r4 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L16
        L18:
            Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
            if (r5 == null) goto L22;
            RunLog.INSTANCE.warn(BaseProactiveActivity.TAG, "get ai rule followup counts failed", r5);
        L22:
            if (Result.m1427isFailureimpl(r4) == false) goto L24;
            r4 = null;
        L24:
            com.obric.aiproactive.api.aa r6 = (com.obric.aiproactive.api.aa) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.api.aa.class, "com.obric.memorydata.plugin");
            com.obric.aiproactive.ui.util.h r7 = com.obric.aiproactive.ui.util.h.f6884a;
            String r8 = this.$launchPosition;
            if (r6 == null) goto L27;
            Integer r12 = Boxing.boxInt(r6.a());
        L28:
            if (r6 == null) goto L30;
            Integer r13 = Boxing.boxInt(r6.b());
        L31:
            if (r6 == null) goto L33;
            r11 = Boxing.boxInt(r6.c());
        L33:
            r7.b(r8, r12, r13, r11);
            return Unit.INSTANCE;
        L30:
            r13 = null;
            goto L31
        L27:
            r12 = null;
            goto L28
        L13:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BaseProactiveActivity.TAG, "skip launch followup counts because ai proactive db is not ready", null, 4, null);     // Catch: Throwable -> L16
            r3 = null;
            goto L14
        L8:
            if (r1.isAiProactiveEntryReady() != true) goto L10;
        L16:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L18
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
        PROACTIVE_ROOT_ACTIVITY_CLASS_NAMES = SetsKt.setOf(new String[]{"com.obric.memorydata.plugin_api.stub.activity.ProactiveNowShortcutActivity", "com.obric.memorydata.plugin_api.stub.activity.ProactiveAgentActivity", "com.obric.aiproactive.ui.entry.ProactiveNowActivity", "com.obric.aiproactive.ui.entry.ProactiveV2Activity"});
    }

    public BaseProactiveActivity() {
        this.navigationBarScheme = NavigationBarScheme.B1;
        this.startupLaunchReportGate = new com.obric.aiproactive.ui.util.p(new $$Lambda$BaseProactiveActivity$Qb84iwOUTHUppfwwZ6Xf8rm3rA(this), (Function2) ZeusTransformUtils.preCheckCast(new BaseProactiveActivity$startupLaunchReportGate$2(this), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$reportLaunchEvent(BaseProactiveActivity r2, String r3, String r4) {
        ((BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseProactiveActivity.class, "com.obric.memorydata.plugin")).reportLaunchEvent(r3, r4);
    }

    private static final Unit checkAgreePrivacyAndLogin$lambda$7(Intent r2, boolean r3) {
        if (r3 == false) goto L5;
        r2.addFlags(268468224);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
    L5:
        return Unit.INSTANCE;
    }

    private final void deduplicateLegacyProactiveTasksIfNeeded() {
        if (this.hasDeduplicatedProactiveTasks == false) goto L5;
        return;
    L5:
        this.hasDeduplicatedProactiveTasks = true;
        Object r1 = getSystemService("activity");
        if (ZeusTransformUtils.instanceOf(r1, ActivityManager.class) == false) goto L8;
        ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(r1, ActivityManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        int r3 = getTaskId();
        List<ActivityManager.AppTask> r4 = r2.getAppTasks();
        Intrinsics.checkNotNullExpressionValue(r4, "getAppTasks(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r5.hasNext() == false) goto L43;
        ActivityManager.AppTask r6 = (ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r5.next(), ActivityManager.AppTask.class, "com.obric.memorydata.plugin");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L17
        BaseProactiveActivity r8 = (BaseProactiveActivity) ZeusTransformUtils.preCheckCast(this, BaseProactiveActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r9 = Result.m1421constructorimpl(r6.getTaskInfo());     // Catch: Throwable -> L17
    L20:
        if (Result.m1427isFailureimpl(r9) == false) goto L22;
        r9 = null;
    L22:
        ActivityManager.RecentTaskInfo r10 = (ActivityManager.RecentTaskInfo) ZeusTransformUtils.preCheckCast(r9, ActivityManager.RecentTaskInfo.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        if (r10.taskId == r3) goto L13;
        ComponentName r11 = r10.baseActivity;
        if (r11 == null) goto L13;
        String r12 = r11.getClassName();
        if (r12 == null) goto L13;
        if (PROACTIVE_ROOT_ACTIVITY_CLASS_NAMES.contains(r12) == false) goto L13;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
        BaseProactiveActivity r14 = (BaseProactiveActivity) ZeusTransformUtils.preCheckCast(this, BaseProactiveActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        r6.finishAndRemoveTask();     // Catch: Throwable -> L38
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L13;
        RunLog.INSTANCE.warn(TAG, "deduplicateLegacyProactiveTasksIfNeeded: finish duplicate task failed", r16);
    L38:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L43:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final boolean isAiProactiveLabEnabled() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        Cursor r11 = ZeusProviderTransform.query(((BaseProactiveActivity) ZeusTransformUtils.preCheckCast(this, BaseProactiveActivity.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent"), null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r11 == null) goto L26;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r3.moveToFirst() == true) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r5 = TAG;
        String r6 = "isAiProactiveLabEnabled emptyCursor";
    L10:
        IRunLog.a.a(r4, r5, r6, null, 4, null);     // Catch: Throwable -> L21
        boolean r7 = false;
    L19:
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L29
    L27:
        Object r13 = Result.m1421constructorimpl(Boolean.valueOf(r7));     // Catch: Throwable -> L29
    L31:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r13);
        if (r8 == null) goto L36;
        RunLog.INSTANCE.warn(TAG, "isAiProactiveLabEnabled query failed", r8);
        r13 = false;
    L36:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L11:
        int r9 = r3.getColumnIndex("status");     // Catch: Throwable -> L21
        if (r9 >= 0) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r5 = TAG;
        r6 = "isAiProactiveLabEnabled missingColumn=status";
        goto L10
    L14:
        int r10 = r3.getInt(r9);     // Catch: Throwable -> L21
        r7 = true;
        if (r10 == 1) goto L18;
        r7 = false;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isAiProactiveLabEnabled enabled=" + r7, false, 4, null);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        r7 = false;
    L29:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    /* JADX INFO: renamed from: lambda$2InXGfwb9h8wbsJM-iEp2dp-JaU, reason: not valid java name */
    public static /* synthetic */ Unit m259lambda$2InXGfwb9h8wbsJMiEp2dpJaU(BaseProactiveActivity r0, Function1 r1) {
        return onStart$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit lambda$GW1k71WSIC9i8X0Awo4VigBxwG0(Intent r0, boolean r1) {
        return checkAgreePrivacyAndLogin$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit lambda$I914yYQ0PINzbHwOsVgV36DL8uk(BaseProactiveActivity r0) {
        return onStart$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$Q-b84iwOUTHUppfwwZ6Xf8rm3rA, reason: not valid java name */
    public static /* synthetic */ Unit m260lambda$Qb84iwOUTHUppfwwZ6Xf8rm3rA(BaseProactiveActivity r0, long r1, Function0 r3) {
        return startupLaunchReportGate$lambda$0(r0, r1, r3);
    }

    public static /* synthetic */ Unit lambda$czjhUTtW8bknh6ql3wCV8W4bVLQ(Intent r0) {
        return onStart$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$nD3S2RwshFKckZUzCM_xTBoDYhM(BaseProactiveActivity r0, boolean r1) {
        requestLoginGuideOrFinish$lambda$6$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$x_spRUTiL8dEtcG-z2WxnwhHQG4, reason: not valid java name */
    public static /* synthetic */ Unit m261lambda$x_spRUTiL8dEtcGz2WxnwhHQG4(BaseProactiveActivity r0, boolean r1) {
        return requestLoginGuideOrFinish$lambda$6(r0, r1);
    }

    private static final Unit onStart$lambda$2(BaseProactiveActivity r2) {
        ((BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseProactiveActivity.class, "com.obric.memorydata.plugin")).finishAffinity();
        return Unit.INSTANCE;
    }

    private static final Unit onStart$lambda$3(Intent r3) {
        r3.addFlags(268468224);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final Unit onStart$lambda$4(BaseProactiveActivity r3, Function1 r4) {
        BaseProactiveActivity r5 = (BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseProactiveActivity.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "callback");
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), r6);
        return Unit.INSTANCE;
    }

    private final void reportLaunchEvent(String r10, String r11) {
        String r12 = com.obric.aiproactive.ui.util.n.c(r10, r11);
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("report launch activity=").append(getClass().getSimpleName()).append(" launchPosition=").append(r12).append(" hasTarget=");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        IRunLog.a.a(r3, TAG, r0.append(!r14).toString(), false, 4, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r12, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r14 = false;
        goto L9
    }

    private static final Unit requestLoginGuideOrFinish$lambda$6(BaseProactiveActivity r2, final boolean r3) {
        final BaseProactiveActivity r4 = (BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseProactiveActivity.class, "com.obric.memorydata.plugin");
        r4.runOnUiThread(new $$Lambda$BaseProactiveActivity$nD3S2RwshFKckZUzCM_xTBoDYhM(r4, r3));
        return Unit.INSTANCE;
    }

    private static final void requestLoginGuideOrFinish$lambda$6$lambda$5(BaseProactiveActivity r2, boolean r3) {
        BaseProactiveActivity r4 = (BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseProactiveActivity.class, "com.obric.memorydata.plugin");
        r4.isRequestingLogin = false;
        if (r4.isFinishing() == false) goto L5;
        return;
    L5:
        if (r4.isDestroyed() == true) goto L13;
        if (r3 == false) goto L9;
        r4.onResumeChecked();
        return;
    L9:
        r4.finish();
        return;
    }

    private static final Unit startupLaunchReportGate$lambda$0(BaseProactiveActivity r8, long r9, Function0 r11) {
        BaseProactiveActivity r10 = (BaseProactiveActivity) ZeusTransformUtils.wrapperContextForParams(r8, BaseProactiveActivity.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "block");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r10, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseProactiveActivity$startupLaunchReportGate$1$1(r9, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    public void applyOverrideConfiguration(Configuration r2) {
        super.applyOverrideConfiguration(AiProactiveUiModeController.f6869a.a(r2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public void attachBaseContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "newBase");
        super.attachBaseContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AiProactiveUiModeController.f6869a.a(r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public final boolean checkAgreePrivacyAndLogin() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L10;
        final Intent r0 = getIntent();
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$BaseProactiveActivity$GW1k71WSIC9i8X0Awo4VigBxwG0(r0));
        if (isTaskRoot() == false) goto L7;
        finishAndRemoveTask();
        return false;
    L7:
        finish();
        return false;
    L10:
        return true;
    }

    public boolean deferLoginCheckDispatch() {
        return false;
    }

    public final void dispatchOnCreateLoginCheck(Bundle r2) {
        if (needLoginCheckOnCreate() == true) goto L5;
    L7:
        onCreateChecked(r2);
        return;
    L5:
        if (checkAgreePrivacyAndLogin() == true) goto L7;
    }

    public final void dispatchOnResumeLoginCheck() {
        if (needLoginCheckOnResume() == true) goto L7;
        onResumeChecked();
        return;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L9;
        onResumeChecked();
        return;
    L9:
        onResumeNotLogin();
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        return this.floatingTitleBar;
    }

    @Override // com.obric.memorydata.ui.b
    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        return null;
    }

    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public Resources getResources() {
        Resources r1 = super.getResources();
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Intrinsics.checkNotNull(r1);
        r0.a(r1);
        Intrinsics.checkNotNullExpressionValue(r1, "also(...)");
        return r1;
    }

    public boolean needLoginCheckOnCreate() {
        return false;
    }

    public boolean needLoginCheckOnResume() {
        return false;
    }

    public void onAppForeground() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        AiProactiveUiModeController r3 = AiProactiveUiModeController.f6869a;
        Resources r1 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "getResources(...)");
        r3.a(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r10) {
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Resources r1 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "getResources(...)");
        r0.a(r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "apply proactive ui mode=" + AiProactiveUiModeController.f6869a.a() + ", uiMode=" + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode, false, 4, null);
        super.onCreate(r10);
        Window r2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r2, "getWindow(...)");
        com.obric.memorydata.ui.g.a(r2, getNavigationBarScheme());
        if (isAiProactiveLabEnabled() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate ai proactive lab disabled, finish activity=" + getClass().getSimpleName(), false, 4, null);
        finish();
        return;
    L6:
        this.createdUserId = AppContext.INSTANCE.getUserId();
        if (deferLoginCheckDispatch() == true) goto L10;
        dispatchOnCreateLoginCheck(r10);
        return;
    }

    public void onCreateChecked(Bundle r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Resources r1 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "getResources(...)");
        r0.d(r1);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity
    public void onNewIntent(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        super.onNewIntent(r3);
        setIntent(r3);
        this.startupLaunchReportGate.b(r3.getStringExtra("enter_from"), r3.getStringExtra("inspirationId"));
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Resources r1 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "getResources(...)");
        r0.a(r1);
        super.onResume();
        if (this.pendingForegroundLaunchReport == false) goto L12;
        this.pendingForegroundLaunchReport = false;
        com.obric.aiproactive.ui.util.p r2 = this.startupLaunchReportGate;
        Intent r3 = getIntent();
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.getStringExtra("enter_from");
    L8:
        Intent r6 = getIntent();
        if (r6 == null) goto L11;
        r4 = r6.getStringExtra("inspirationId");
    L11:
        r2.a(r5, r4);
        goto L12
    L7:
        r5 = null;
    L12:
        String r7 = AppContext.INSTANCE.getUserId();
        if (deferLoginCheckDispatch() == true) goto L15;
        dispatchOnResumeLoginCheck();
    L15:
        String r8 = this.createdUserId;
        if (r8 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r8, r7) == true) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Account changed from " + this.createdUserId + " to " + r7 + ", restarting activity", false, 4, null);
        Intent r9 = new Intent(getIntent());
        r9.addFlags(268468224);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, "com.obric.memorydata.plugin");
        finishAffinity();
        return;
    }

    public void onResumeChecked() {
    }

    public void onResumeNotLogin() {
        if (isTaskRoot() == false) goto L5;
        requestLoginGuideOrFinish();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Resources r1 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "getResources(...)");
        r0.b(r1);
        super.onStart();
        final Intent r2 = new Intent(getIntent());
        if (v.a(UserSettings.INSTANCE.hasAgreePrivacyAndLogin(), new $$Lambda$BaseProactiveActivity$I914yYQ0PINzbHwOsVgV36DL8uk(this), new $$Lambda$BaseProactiveActivity$czjhUTtW8bknh6ql3wCV8W4bVLQ(r2), new $$Lambda$BaseProactiveActivity$2InXGfwb9h8wbsJMiEp2dpJaU(this)) == true) goto L5;
        return;
    L5:
        deduplicateLegacyProactiveTasksIfNeeded();
        if (activityStartCount != 0) goto L8;
        this.pendingForegroundLaunchReport = true;
        onAppForeground();
    L8:
        activityStartCount++;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        activityStartCount--;
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Resources r2 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(r2, "getResources(...)");
        r0.c(r2);
    }

    public final void registerFloatingTitleBar(OFloatingTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "titleBar");
        this.floatingTitleBar = r2;
        r2.setFloatingTransitionEnabled(true);
    }

    public final void requestLoginGuideOrFinish() {
        if (this.isRequestingLogin == false) goto L5;
        return;
    L5:
        this.isRequestingLogin = true;
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$BaseProactiveActivity$x_spRUTiL8dEtcGz2WxnwhHQG4(this));
    }

    @Override // androidx.activity.ComponentActivity
    public void startActivityForResult(Intent r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        com.obric.memorydata.ui.c.f12990a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r4);
        super.startActivityForResult(r4, r5, r6);
    }
}
