package com.larus.camera.impl.ui.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.base.BaseCameraActivity;
import com.larus.camera.impl.ui.base.BaseCameraFragment;
import com.larus.camera.impl.ui.fragment.CameraResultFragment;
import com.larus.camera.impl.utils.l;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gx8.b;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sx8.d;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/larus/camera/impl/ui/activity/CameraResultActivity;", "Lcom/larus/camera/impl/ui/base/BaseCameraActivity;", "<init>", "()V", "inputParam", "Lcom/larus/camera/api/params/InputParam;", "getInputParam", "()Lcom/larus/camera/api/params/InputParam;", "inputParam$delegate", "Lkotlin/Lazy;", "onCreateFragment", "Lcom/larus/camera/impl/ui/base/BaseCameraFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "reportOpenCameraPageCost", "applyOrientationPolicy", "onDestroy", "setAni", "finish", "onBackPressed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CameraResultActivity extends BaseCameraActivity {
    public static final /* synthetic */ int c = 0;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        BaseCameraFragment r0 = ((BaseCameraActivity) this).a;
        CameraResultFragment r2 = null;
        if ((r0 instanceof CameraResultFragment) == false) goto L5;
        CameraResultFragment r1 = (CameraResultFragment) r0;
    L6:
        if (r1 != null) goto L10;
        Fragment r3 = getSupportFragmentManager().findFragmentByTag("camera_fragment");
        if ((r3 instanceof CameraResultFragment) == false) goto L11;
        r2 = (CameraResultFragment) r3;
    L11:
        if (r2 == null) goto L15;
        boolean r4 = true;
        if (r2.V90().handleUnifiedResultEditBack() != true) goto L15;
    L16:
        if (r4 == false) goto L18;
        return;
    L18:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    L15:
        r4 = false;
        goto L16
    L10:
        r2 = r1;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        InputParam r0 = (InputParam) this.b.getValue();
        if (r0 != null) goto L8;
    L10:
        super.onDestroy();
        return;
    L8:
        if (Intrinsics.areEqual(r0.getScene(), "attach_photo_edit") == false) goto L10;
        l.a = false;
        goto L10
    }

    public final BaseCameraFragment<?> y1() {
        return new CameraResultFragment();
    }

    public CameraResultActivity() {
        this.b = LazyKt.lazy(new d(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:63:0x0134 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        InputParam r2 = (InputParam) this.b.getValue();
        if (r2 == null) goto L11;
        InputParamExtra r3 = r2.getExtra();
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("PHOTO_RESULT_SURE_PAGE_EXIT_FINISH_ANI");
        if (r4 == null) goto L11;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 == null) goto L11;
        int r6 = r5.intValue();
    L12:
        if (r6 <= 0) goto L15;
        overridePendingTransition(0, r6);
    L15:
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r7 = FLogger.a;
        r7.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r8 = SystemClock.uptimeMillis();
        Map r9 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r9);
        Long r10 = (Long) r9.get(this);     // Catch: Throwable -> L57
        if (r10 != null) goto L22;
    L25:
        r9.put(this, Long.valueOf(r8));     // Catch: Throwable -> L57
        monitor-exit(r9);     // Catch: Throwable -> L57
    L54:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L60:
        return;
    L28:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L31;
        r7.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L54
        goto L60
    L31:
        if (isFinishing() == true) goto L34;
        r7.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L54
        goto L60
    L34:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L37;
        r7.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L54
        goto L60
    L37:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L40;
        r7.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L54
        goto L60
    L40:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L43;
        r7.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L54
        goto L60
    L43:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L45;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L54
        goto L60
    L45:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L54
        if (r1 == null) goto L60;
        r1.addFlags(268435456);     // Catch: Throwable -> L54
        r1.addFlags(2097152);     // Catch: Throwable -> L54
        r7.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L54
        startActivity(r1);     // Catch: Throwable -> L51
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L54
        goto L60
    L22:
        if ((r8 - r10.longValue()) >= 800) goto L25;
        monitor-exit(r9);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    L56:
        return;
    L11:
        r6 = -1;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L76
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L76
    L8:
        z2.a.w3();
        super.onCreate(r13);
        InputParam r14 = (InputParam) this.b.getValue();
        Integer r0 = null;
        if (r14 == null) goto L15;
        InputParamExtra r15 = r14.getExtra();
        if (r15 == null) goto L15;
        String r16 = (String) r15.get("OPEN_CAMERA_PAGE_TRIGGER_TIME_MS");
        if (r16 == null) goto L15;
        Long r17 = StringsKt.toLongOrNull(r16);
    L16:
        InputParam r1 = (InputParam) this.b.getValue();
        if (r1 == null) goto L21;
        InputParamExtra r2 = r1.getExtra();
        if (r2 == null) goto L21;
        String r3 = (String) r2.get("OPEN_CAMERA_PAGE_PATH");
    L22:
        qx8.a r4 = qx8.a.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter("camera_result", "targetPage");
        boolean r5 = false;
        if (r17 != null) goto L25;
    L77:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L67
        InputParam r19 = (InputParam) this.b.getValue();     // Catch: Throwable -> L67
        int r6 = 2130772348;
        if (r19 == null) goto L64;
        InputParamExtra r7 = r19.getExtra();     // Catch: Throwable -> L67
        if (r7 == null) goto L44;
        String r8 = (String) r7.get("PHOTO_RESULT_SURE_PAGE_EXIT_ANI");     // Catch: Throwable -> L67
        if (r8 == null) goto L44;
        Integer r9 = StringsKt.toIntOrNull(r8);     // Catch: Throwable -> L67
        if (r9 == null) goto L44;
        int r10 = r9.intValue();     // Catch: Throwable -> L67
    L45:
        InputParamExtra r110 = r19.getExtra();     // Catch: Throwable -> L67
        if (r110 == null) goto L52;
        String r111 = (String) r110.get("PHOTO_RESULT_SURE_PAGE_ENTER_ANI");     // Catch: Throwable -> L67
        if (r111 == null) goto L52;
        Integer r112 = StringsKt.toIntOrNull(r111);     // Catch: Throwable -> L67
        if (r112 == null) goto L52;
        int r113 = r112.intValue();     // Catch: Throwable -> L67
    L53:
        if (r10 <= 0) goto L55;
        overridePendingTransition(r113, r10);     // Catch: Throwable -> L67
    L65:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L69:
        getTheme().applyStyle(2131953689, true);
        View r114 = getWindow().getDecorView();
        if (c.e == false) goto L74;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r11 = ThreadMethodProxy.currentThread();
        if (r11 == c.a) goto L74;
        c.a(r11, "getDecorView");
    L74:
        ViewCompat.setOnApplyWindowInsetsListener(r114, new sx8.c());
        return;
    L55:
        Integer r115 = Integer.valueOf(r113);     // Catch: Throwable -> L67
        if (r115.intValue() <= 0) goto L59;
        r5 = true;
    L59:
        if (Boolean.valueOf(r5).booleanValue() == false) goto L61;
        r0 = r115;
    L61:
        if (r0 == null) goto L63;
        r6 = r0.intValue();     // Catch: Throwable -> L67
    L63:
        overridePendingTransition(r6, 2130772347);     // Catch: Throwable -> L67
    L52:
        r113 = 0;
    L44:
        r10 = -1;
        goto L45
    L64:
        overridePendingTransition(2130772348, 2130772347);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L25:
        if (r17.longValue() <= 0) goto L77;
        if (r3 != null) goto L28;
    L31:
        boolean r20 = true;
    L32:
        if (r20 == true) goto L77;
        long r21 = System.currentTimeMillis();
        long r22 = RangesKt.coerceAtMost(r17.longValue(), r21);
        FLogger.a.i("CameraMonitor", "[onOpenCameraPage] openPath:" + r3 + ", targetPage:camera_result, duration:" + (r21 - r22));
        b r116 = r4.a;
        CameraEvent r23 = CameraEvent.OPEN_CAMERA_PAGE;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r23, "event");
        r116.b.put(r23.getUniqueKey(), Long.valueOf(r22));
        b r117 = r4.a;
        JSONObject r24 = new JSONObject();
        r24.put("open_type", r3);
        r24.put("target_page", "camera_result");
        Unit r25 = Unit.INSTANCE;
        r117.a(r23, r24);
        goto L77
    L28:
        if (r3.length() == 0) goto L31;
        r20 = false;
    L21:
        r3 = null;
    L15:
        r17 = null;
        goto L16
    }
}
