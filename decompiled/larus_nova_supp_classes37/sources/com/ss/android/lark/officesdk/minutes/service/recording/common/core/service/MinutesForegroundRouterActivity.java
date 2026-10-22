package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.EntryPoints;
import iub.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J'\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundRouterActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getRecordingCapacity", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/IMmRecordingCapacity;", "openD1204DevicePage", "getOfficeSDKUserService", "T", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKCapacity;", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MinutesForegroundRouterActivity extends Activity {

    public static final class a {
    }

    public static final class b implements iub.a<j, MmRecordingError> {
        public b() {
        }

        @Override // iub.a
        public final void a(MmRecordingError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            lvb.a.b("MinutesForegroundRouterActivity", "openRecordingPage failed: " + r3);
        }

        @Override // iub.a
        public final void onSuccess(j r3) {
            j r4 = r3;
            Intrinsics.checkNotNullParameter(r4, "data");
            lvb.a.e("MinutesForegroundRouterActivity", "openRecordingPage success: " + r4);
        }
    }

    static {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public final void a() {
        com.ss.android.lark.officesdk.minutes.api.hardware.a r0 = (com.ss.android.lark.officesdk.minutes.api.hardware.a) ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(com.ss.android.lark.officesdk.minutes.api.hardware.a.class);
        if (r0 == null) goto L5;
        r0.Kc(this, MmRecordingUILaunchMode.WITH_FEISHU_UI);
    L5:
        lvb.a.e("MinutesForegroundRouterActivity", "openD1204DevicePage result=false");
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(MinutesForegroundRouterActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public MinutesForegroundRouterActivity() {
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r4);
        Intent r5 = getIntent();
        String r0 = null;
        if (r5 == null) goto L13;
        String r6 = r5.getStringExtra("extra_notification_owner");
    L14:
        Intent r1 = getIntent();
        if (r1 == null) goto L46;
        r0 = r1.getStringExtra("extra_notification_target");
    L46:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L39
        if (Intrinsics.areEqual(r0, "D1204_DEVICE") == false) goto L20;
        a();     // Catch: Throwable -> L39
    L37:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L44;
        lvb.a.b("MinutesForegroundRouterActivity", "openRecordingPage failed: " + r8);
    L44:
        finish();
        return;
    L20:
        if (r0 == null) goto L22;
    L26:
        hub.a r9 = (hub.a) ((OfficeSDKUserEntryPoint) EntryPoints.get(OfficeSDKManager.getOfficeSDKUserComponent(), OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(hub.a.class);     // Catch: Throwable -> L39
        if (r9 == null) goto L37;
        String r3 = r9.u0();     // Catch: Throwable -> L39
        if (r3 != null) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == true) goto L37;
        r9.qd(this, r3, MmRecordingPageOpenSource.OUTER_PUSH, new b());     // Catch: Throwable -> L39
        goto L37
    L31:
        if (r3.length() == 0) goto L34;
        r10 = false;
        goto L35
    L22:
        if (Intrinsics.areEqual(r6, "FILE_UPLOAD") == false) goto L24;
    L25:
        a();     // Catch: Throwable -> L39
        goto L37
    L24:
        if (Intrinsics.areEqual(r6, "HARDWARE_FILE_SYNC") == false) goto L26;
    L39:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L13:
        r6 = null;
        goto L14
    }
}
