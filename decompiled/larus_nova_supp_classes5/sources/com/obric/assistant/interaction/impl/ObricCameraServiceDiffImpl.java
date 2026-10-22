package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.contract.ICameraServiceDiff;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.utils.c;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApi;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApiKt;
import com.obric.assistant.interaction.api.service.IObricShowOnLockedService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\r\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J \u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricCameraServiceDiffImpl;", "Lcom/larus/camera/contract/ICameraServiceDiff;", "<init>", "()V", "cameraCaptureActivityClassNames", "", "", "getCameraCaptureActivityClassNames", "()Ljava/util/List;", "cameraCaptureActivityClassNames$delegate", "Lkotlin/Lazy;", "startupReadyBoundActivities", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "init", "", "pendingActions", "", "Ljava/lang/Runnable;", "doAfterDestroy", "activity", "action", "checkExecutePendingAction", "isHideAlbumCover", "", "()Ljava/lang/Boolean;", "isHideSlideAlbumEntrance", "doAfterPreCameraRelease", "intent", "Landroid/content/Intent;", "Lkotlin/Function0;", "finishActivitiesBeforeCaptureFirstLaunch", "canRetryOpenCamera", "maxRetryOpenCameraTimeMS", "", "isLocked", "isCameraCaptureActivity", "bindCameraStartupReadyIfNeeded", "resolveCameraStartupAttemptId", "removeCameraReadyListener", "observer", "Landroid/view/ViewTreeObserver;", "listener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "checkCreationActivityIntentForShowOnLocked", "Companion", "o_camera_extension_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCameraServiceDiffImpl implements ICameraServiceDiff {
    public static final Companion Companion = null;
    private static final long MAX_CAMERA_READY_BIND_DURATION_MS = 15000;
    private static final int MAX_CAMERA_READY_REPORT_ATTEMPTS = 3;
    private static final String TAG = "ObricCameraServiceImpl";
    private final Lazy cameraCaptureActivityClassNames$delegate;
    private final WeakHashMap<Activity, List<Runnable>> pendingActions;
    private final WeakHashMap<Activity, String> startupReadyBoundActivities;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricCameraServiceDiffImpl r0, Activity r1, String r2, ViewTreeObserver r3, bindCameraStartupReadyIfNeeded.listener.1 r4) {
        bindCameraStartupReadyIfNeeded$lambda$13(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(List r0, Activity r1) {
        checkExecutePendingAction$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ String c(String r0) {
        return bindCameraStartupReadyIfNeeded$lambda$12(r0);
    }

    public static /* synthetic */ boolean d(ObricCameraServiceDiffImpl r0, Intent r1) {
        return init$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ String e(String r0) {
        return bindCameraStartupReadyIfNeeded$lambda$11(r0);
    }

    public static /* synthetic */ void f(Function0 r0) {
        doAfterPreCameraRelease$lambda$10(r0);
    }

    public static /* synthetic */ List g() {
        return cameraCaptureActivityClassNames_delegate$lambda$0();
    }

    public boolean canRetryOpenCamera() {
        return true;
    }

    public int maxRetryOpenCameraTimeMS() {
        return 1500;
    }

    private static final List cameraCaptureActivityClassNames_delegate$lambda$0() {
        IFlowCamera r0 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r0 == null) goto L5;
        List r1 = r0.i();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    private final List<String> getCameraCaptureActivityClassNames() {
        return (List) this.cameraCaptureActivityClassNames$delegate.getValue();
    }

    public void init() {
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(new init.1(this));
        IObricShowOnLockedService r0 = (IObricShowOnLockedService) ServiceManager.get().getService(IObricShowOnLockedService.class);
        if (r0 == null) goto L11;
        Iterator<T> r7 = getCameraCaptureActivityClassNames().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        IObricShowOnLockedService.DefaultImpls.addShowOnLockedClazz$default(r0, (String) r7.next(), true, null, 4, null);
        goto L6
    L8:
        IObricShowOnLockedService.DefaultImpls.addShowOnLockedClazz$default(r0, "com.larus.camera.impl.ui.activity.CameraResultActivity", true, null, 4, null);
        IObricShowOnLockedService.DefaultImpls.addShowOnLockedClazz$default(r0, "com.larus.camera.impl.ui.activity.CameraResultFirstActivity", true, null, 4, null);
        r0.addShowOnLockedClazz("com.larus.uaigc.createpage.CreationActivity", true, new n(this));
        return;
    }

    public ObricCameraServiceDiffImpl() {
        this.cameraCaptureActivityClassNames$delegate = LazyKt.lazy(new l());
        this.startupReadyBoundActivities = new WeakHashMap();
        this.pendingActions = new WeakHashMap();
    }

    private final boolean isLocked() {
        return IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
    }

    public void finishActivitiesBeforeCaptureFirstLaunch() {
        IActivityResultHelperApi r0 = IActivityResultHelperApiKt.getActivityResultHelper();
        if (r0 == null) goto L6;
        r0.finishActivitiesExceptChatWindow();
        return;
    }

    public Boolean isHideAlbumCover() {
        return Boolean.valueOf(isLocked());
    }

    public Boolean isHideSlideAlbumEntrance() {
        return Boolean.valueOf(isLocked());
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricCameraServiceDiffImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ WeakHashMap access$getStartupReadyBoundActivities$p(ObricCameraServiceDiffImpl r0) {
        return r0.startupReadyBoundActivities;
    }

    private final void bindCameraStartupReadyIfNeeded(Activity r12) {
        String r6 = resolveCameraStartupAttemptId(r12);
        if (r6 != null) goto L6;
        return;
    L6:
        if (uga.c.b(r6) == true) goto L10;
        FLogger.a.g(TAG, new i(r6));
        return;
    L10:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("camera_content_ready"), r6) == true) goto L14;
        FLogger.a.g(TAG, new j(r6));
        uga.c.a(r6);
        return;
    L14:
        if (Intrinsics.areEqual(this.startupReadyBoundActivities.get(r12), r6) == false) goto L16;
        return;
    L16:
        Window r0 = r12.getWindow();
        if (r0 == null) goto L26;
        View r7 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricCameraServiceDiffImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0);
        if (r7 == null) goto L27;
        ViewTreeObserver r8 = r7.getViewTreeObserver();
        if (r8.isAlive() == true) goto L24;
        return;
    L24:
        this.startupReadyBoundActivities.put(r12, r6);
        bindCameraStartupReadyIfNeeded.listener.1 r9 = new bindCameraStartupReadyIfNeeded.listener.1(r6, this, r8, r7, new Ref$IntRef());
        r8.addOnPreDrawListener(r9);
        r7.postInvalidateOnAnimation();
        r7.postDelayed(new k(this, r12, r6, r8, r9), MAX_CAMERA_READY_BIND_DURATION_MS);
        return;
    L27:
        return;
    }

    private static final String bindCameraStartupReadyIfNeeded$lambda$11(String r2) {
        return "ignore camera startup frame for unmatched attemptId=" + r2;
    }

    private static final String bindCameraStartupReadyIfNeeded$lambda$12(String r2) {
        return "ignore camera startup frame for inactive attemptId=" + r2;
    }

    private final boolean checkCreationActivityIntentForShowOnLocked(Intent r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        r r6 = ((z0) new Gson().fromJson(r5.getStringExtra("custom_action_bar_item"), z0.class)).q;     // Catch: Throwable -> L23
        if (r6 == null) goto L5;
        Integer r7 = r6.a;     // Catch: Throwable -> L23
    L6:
        if (r7 != null) goto L9;
    L10:
        if (r7 != null) goto L13;
    L14:
        if (r7 != null) goto L17;
    L19:
        boolean r8 = false;
    L21:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r8));     // Catch: Throwable -> L23
    L25:
        Throwable r1 = Result.exceptionOrNull-impl(r9);
        if (r1 == null) goto L28;
        FLogger.a.w(TAG, "checkCreationActivityIntentForShowOnLocked failed: " + r1.getMessage(), r1);
    L28:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L32;
        r9 = r2;
    L32:
        return ((Boolean) r9).booleanValue();
    L17:
        if (r7.intValue() != 16) goto L19;
    L20:
        r8 = true;
        goto L21
    L13:
        if (r7.intValue() == 18) goto L20;
    L9:
        if (r7.intValue() == 4) goto L20;
    L5:
        r7 = null;
    L23:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    private final synchronized void checkExecutePendingAction(Activity r4) {
        monitor-enter(this);
        List<Runnable> r0 = this.pendingActions.remove(r4);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        t0.a.post(new h(r0, r4));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final void doAfterPreCameraRelease$lambda$10(Function0 r0) {
        r0.invoke();
    }

    private final boolean isCameraCaptureActivity(Activity r2) {
        return getCameraCaptureActivityClassNames().contains(r2.getClass().getName());
    }

    private final String resolveCameraStartupAttemptId(Activity r9) {
        Intent r10 = r9.getIntent();
        Object r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        AtomicReference r1 = uga.c.a;
        Bundle r2 = r10.getExtras();
        if (r2 == null) goto L8;
        Set<String> r3 = r2.keySet();
    L9:
        if (r3 != null) goto L11;
        r3 = SetsKt.emptySet();
    L11:
        Set<String> r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "keys");
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L25;
        String r6 = (String) r5.next();
        String r7 = StringsKt.removePrefix(r6, "obric_camera_startup_attempt:");
        if (StringsKt.startsWith$default(r6, "obric_camera_startup_attempt:", false, 2, null) == true) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L13;
    L26:
        InputParam r11 = r10.getSerializableExtra("CAMERA_INPUT_PARAM");
        if ((r11 instanceof InputParam) == false) goto L29;
        InputParam r12 = r11;
    L30:
        if (r12 == null) goto L40;
        ICameraEventExt r13 = r12.getEventExt();
        if (r13 == null) goto L40;
        JSONObject r14 = r13.getExtraParams();
        if (r14 == null) goto L40;
        String r15 = r14.optString("obric_startup_attempt_id");
        if (r15 == null) goto L40;
        if ((!StringsKt.isBlank(r15)) == false) goto L40;
    L41:
        Sequence r16 = SequencesKt.filterNotNull(SequencesKt.sequenceOf(new String[]{r7, r15}));
        AtomicReference r17 = uga.c.a;
        Iterator r18 = r16.iterator();
    L43:
        if (r18.hasNext() == false) goto L48;
        Object r19 = r18.next();
        if (uga.c.b((String) r19) == false) goto L43;
        r0 = r19;
    L48:
        return (String) r0;
    L40:
        r15 = null;
        goto L41
    L29:
        r12 = null;
        goto L30
    L17:
        if ((!StringsKt.isBlank(r7)) == false) goto L19;
        r8 = true;
        goto L20
    L25:
        r7 = null;
        goto L26
    L8:
        r3 = null;
        goto L9
    }

    public static final /* synthetic */ void access$bindCameraStartupReadyIfNeeded(ObricCameraServiceDiffImpl r0, Activity r1) {
        r0.bindCameraStartupReadyIfNeeded(r1);
    }

    public static final /* synthetic */ void access$checkExecutePendingAction(ObricCameraServiceDiffImpl r0, Activity r1) {
        r0.checkExecutePendingAction(r1);
    }

    public static final /* synthetic */ boolean access$isCameraCaptureActivity(ObricCameraServiceDiffImpl r0, Activity r1) {
        return r0.isCameraCaptureActivity(r1);
    }

    private static final void checkExecutePendingAction$lambda$8$lambda$7(List r4, Activity r5) {
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Runnable r0 = (Runnable) r6.next();
        FLogger.a.i(TAG, "doAfterDestroy: execute " + r5 + ", " + r0);
        r0.run();
        goto L4
    }

    private static final boolean init$lambda$3$lambda$2(ObricCameraServiceDiffImpl r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return r1.checkCreationActivityIntentForShowOnLocked(r2);
    }

    private final void removeCameraReadyListener(ViewTreeObserver r2, ViewTreeObserver.OnPreDrawListener r3) {
        if (r2.isAlive() == false) goto L6;
        r2.removeOnPreDrawListener(r3);
        return;
    }

    public final synchronized void doAfterDestroy(Activity r6, Runnable r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "activity");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r7, "action");     // Catch: Throwable -> L21
        if (r6.isDestroyed() == false) goto L9;
        r7.run();     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L9:
        WeakHashMap<Activity, List<Runnable>> r1 = this.pendingActions;     // Catch: Throwable -> L21
        monitor-enter(r1);     // Catch: Throwable -> L21
        WeakHashMap<Activity, List<Runnable>> r2 = this.pendingActions;     // Catch: Throwable -> L18
        List<Runnable> r3 = r2.get(r6);     // Catch: Throwable -> L18
        if (r3 != null) goto L14;
        r3 = new ArrayList();     // Catch: Throwable -> L18
        r2.put(r6, r3);     // Catch: Throwable -> L18
    L14:
        r3.add(r7);     // Catch: Throwable -> L18
        FLogger.a.i(TAG, "doAfterDestroy: " + r6 + ", " + r7);     // Catch: Throwable -> L18
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public void doAfterPreCameraRelease(Intent r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L3:
        boolean r2 = false;
        if (r1.hasPrevious() == false) goto L14;
        Object r3 = r1.previous();
        Activity r4 = (Activity) r3;
        if (isCameraCaptureActivity(r4) == false) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L3;
    L15:
        Activity r8 = (Activity) r3;
        if (r6 == null) goto L18;
        r2 = r6.getBooleanExtra("obric_is_top_rtc_video", false);
    L18:
        FLogger r9 = FLogger.a;
        r9.i(TAG, "doAfterPreCameraRelease: cameraActivity = " + r8 + ", isTopRtcVideo = " + r2);
        if (r8 != null) goto L21;
    L26:
        r9.i(TAG, "doAfterPreCameraRelease: no camera activity, invoke action directly");
        r7.invoke();
        return;
    L21:
        if (r8.isDestroyed() == true) goto L26;
        r9.i(TAG, "doAfterPreCameraRelease: wait destroy " + r8);
        if (r8.isFinishing() == true) goto L25;
        r8.finish();
    L25:
        doAfterDestroy(r8, new m(r7));
        return;
    L8:
        if (ObricRealtimeCallServiceDelegate.b.s(r4) == true) goto L11;
        r5 = false;
        goto L12
    L14:
        r3 = null;
        goto L15
    }

    public static final /* synthetic */ void access$removeCameraReadyListener(ObricCameraServiceDiffImpl r0, ViewTreeObserver r1, ViewTreeObserver.OnPreDrawListener r2) {
        r0.removeCameraReadyListener(r1, r2);
    }

    private static final void bindCameraStartupReadyIfNeeded$lambda$13(ObricCameraServiceDiffImpl r1, Activity r2, String r3, ViewTreeObserver r4, bindCameraStartupReadyIfNeeded.listener.1 r5) {
        if (Intrinsics.areEqual(r1.startupReadyBoundActivities.get(r2), r3) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r4);
        r1.removeCameraReadyListener(r4, r5);
        r1.startupReadyBoundActivities.remove(r2);
        if (r2.isChangingConfigurations() == true) goto L9;
        uga.c.a(r3);
        return;
    }
}
