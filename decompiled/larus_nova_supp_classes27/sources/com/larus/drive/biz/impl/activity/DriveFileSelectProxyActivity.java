package com.larus.drive.biz.impl.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.drive.biz.impl.file.DriveLocalFileSelector;
import com.larus.drive.biz.impl.file.t;
import com.larus.home.impl.utils.c;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hq9.c2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/drive/biz/impl/activity/DriveFileSelectProxyActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "reqCodeInternal", "", "pickSDKLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileSelectProxyActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public int g;
    public ActivityResultLauncher<Intent> h;

    public static final class a {
        @JvmStatic
        public static void a(Activity r3, int r4, long r5) {
            Intrinsics.checkNotNullParameter(r3, "caller");
            Intrinsics.checkNotNullParameter("*/*", "mimeType");
            Intent r0 = new Intent(r3, DriveFileSelectProxyActivity.class);
            r0.putExtra("DriveFileSelectProxyActivity.EXTRA_MIME_TYPE", "*/*");
            r0.putExtra("DriveFileSelectProxyActivity.EXTRA_REQ_CODE", r4);
            r0.putExtra("DriveFileSelectProxyActivity.EXTRA_ALLOW_MULTIPLE", true);
            r0.putExtra("DriveFileSelectProxyActivity.EXTRA_TIME_STAMP", r5);
            r3.startActivity(r0);
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DriveFileSelectProxyActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public DriveFileSelectProxyActivity() {
        this.g = 41702;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DriveFileSelectProxyActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r6);
        Intent r7 = getIntent();
        if (r7 == null) goto L14;
        String r8 = r7.getStringExtra("DriveFileSelectProxyActivity.EXTRA_MIME_TYPE");
        if (r8 == null) goto L14;
    L15:
        Intent r0 = getIntent();
        int r1 = 41702;
        if (r0 == null) goto L18;
        r1 = r0.getIntExtra("DriveFileSelectProxyActivity.EXTRA_REQ_CODE", 41702);
    L18:
        Intent r2 = getIntent();
        int r3 = 0;
        if (r2 == null) goto L21;
        boolean r4 = r2.getBooleanExtra("DriveFileSelectProxyActivity.EXTRA_ALLOW_MULTIPLE", false);
    L22:
        this.g = r1;
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j79.a(this));
        if (r1 != 41701) goto L28;
        Lazy r9 = t.a;
        int r10 = ((c2) t.b.getValue()).j();
        Map r5 = (Map) t.f.getValue();
        if (r5 == null) goto L27;
        r3 = r5.size();
    L27:
        int r11 = RangesKt.coerceAtLeast(r10 - r3, 1);
        AlbumSettingConfig.a r12 = new AlbumSettingConfig.a();
        r12.d = r11;
        r12.i = true;
        r12.f = "ai_space_list";
        r12.c = true;
        AlbumSettingConfig r13 = r12.a();
        k2.a.h(this, this.h, r13);
        return;
    L28:
        Intent r14 = new Intent("android.intent.action.OPEN_DOCUMENT");
        r14.addCategory("android.intent.category.OPENABLE");
        r14.setType(r8);
        r14.putExtra("android.intent.extra.ALLOW_MULTIPLE", r4);
        r14.addFlags(65);
        startActivityForResult(r14, r1);
        return;
    L21:
        r4 = false;
    L14:
        r8 = "*/*";
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        Intent r0 = getIntent();
        long r1 = 0;
        if (r0 == null) goto L5;
        r1 = r0.getLongExtra("DriveFileSelectProxyActivity.EXTRA_TIME_STAMP", 0);
    L5:
        DriveLocalFileSelector.a.getClass();
        DriveLocalFileSelector.f(this, r10, r11, r12, r1);
        finish();
    }
}
