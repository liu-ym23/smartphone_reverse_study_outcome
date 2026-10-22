package com.larus.dora.impl.settings.voiceprint;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.impl.DoraPreWakeUpTask;
import com.larus.dora.impl.databinding.LarusDoraActivityVoicePrintManagementBinding;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/settings/voiceprint/VoicePrintManagementActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraActivityVoicePrintManagementBinding;", "mac", "", "deviceName", "startFrom", "enrollLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initView", "refreshStatus", "showMoreMenu", "checkModelAndStartEnroll", "showLoadingAndRetry", "onDestroy", "startEnroll", "showDeleteConfirmDialog", "deleteVoicePrint", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoicePrintManagementActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int l = 0;
    public LarusDoraActivityVoicePrintManagementBinding g;
    public String h;
    public String i;
    public String j;
    public ActivityResultLauncher<Intent> k;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.impl.settings.voiceprint.e] */
    public final void N1() {
        if (PacificInterfaceManager.b == false) goto L5;
        O1();
        return;
    L5:
        LarusDoraActivityVoicePrintManagementBinding r0 = this.g;
        LarusDoraActivityVoicePrintManagementBinding r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        if (r0.d.getVisibility() != 0) goto L18;
        LarusDoraActivityVoicePrintManagementBinding r2 = this.g;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L13:
        e1.x(r2.f);
        LarusDoraActivityVoicePrintManagementBinding r3 = this.g;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        r1.b.setEnabled(false);
        goto L18
    L16:
        r1 = r3;
    L18:
        int r4 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.l();
        PacificInterfaceManager.e(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1() {
        Function1<? super Boolean, Unit> r0 = PacificInterfaceManager.a;
        String r1 = PacificInterfaceManager.f(this.h);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        boolean r2 = v19.h.a;
        ActivityResultLauncher<Intent> r3 = null;
        boolean r4 = v19.h.a(null);
        Intent r5 = new Intent("com.obric.sva.sdk.ACTION_START_ENROLL");
        r5.setClassName(getPackageName(), "com.enroll.audio.enroll.ui.VoicePrintEnrollActivity");
        r5.putExtra("IS_DARK_MODE", r4);
        r5.putExtra("start_from", this.j);
        boolean r6 = true;
        r5.putExtra("enroll_device_type", 1);
        if (r1.length() <= 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L12;
        r5.putExtra("device_sn", r1);
    L12:
        if (this.i.length() > 0) goto L15;
        r6 = false;
    L15:
        if (r6 == false) goto L17;
        r5.putExtra("device_name", this.i);
    L17:
        ActivityResultLauncher<Intent> r8 = this.k;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("enrollLauncher");
    L21:
        r3.launch(r5);
        return;
    L20:
        r3 = r8;
        goto L21
    L8:
        r7 = false;
        goto L9
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VoicePrintManagementActivity.class.getName()));
    L5:
        super.onDestroy();
        PacificInterfaceManager.e(null);
    }

    public VoicePrintManagementActivity() {
        this.h = "";
        this.i = "";
        this.j = "dora_device_management";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VoicePrintManagementActivity.class.getName()));
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

    public final void onResume() {
        super.onResume();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VoicePrintManagementActivity$refreshStatus$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        LarusDoraActivityVoicePrintManagementBinding r2 = null;
        ConstraintLayout r13 = getLayoutInflater().inflate(2131562140, null, false);
        int r0 = 2131364734;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131364734)) == null) goto L56;
        r0 = 2131364735;
        LinearLayoutCompat r5 = ViewBindings.findChildViewById(r13, 2131364735);
        if (r5 == null) goto L56;
        r0 = 2131366853;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r13, 2131366853);
        if (r6 == null) goto L56;
        r0 = 2131366880;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r13, 2131366880);
        if (r7 == null) goto L56;
        r0 = 2131376415;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r13, 2131376415);
        if (r8 == null) goto L56;
        r0 = 2131376724;
        if (((ImageView) ViewBindings.findChildViewById(r13, 2131376724)) == null) goto L56;
        r0 = 2131382053;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r13, 2131382053);
        if (r9 == null) goto L56;
        r0 = 2131388807;
        NovaTitleBarEx r10 = ViewBindings.findChildViewById(r13, 2131388807);
        if (r10 == null) goto L56;
        r0 = 2131391014;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131391014)) == null) goto L56;
        r0 = 2131391694;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131391694)) == null) goto L56;
        ConstraintLayout r14 = r13;
        this.g = new LarusDoraActivityVoicePrintManagementBinding(r14, r5, r6, r7, r8, r9, r10);
        setContentView(r14);
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.dora.impl.settings.voiceprint.a(this));
        String r15 = getIntent().getStringExtra("mac");
        String r1 = "";
        if (r15 != null) goto L33;
        r15 = "";
    L33:
        this.h = r15;
        String r16 = getIntent().getStringExtra("device_name");
        if (r16 == null) goto L37;
        r1 = r16;
    L37:
        this.i = r1;
        String r17 = getIntent().getStringExtra("start_from");
        if (r17 != null) goto L40;
        r17 = "dora_device_management";
    L40:
        this.j = r17;
        LarusDoraActivityVoicePrintManagementBinding r18 = this.g;
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L43:
        NovaTitleBarEx.Y5(r18.g, getString(2131904046), null, null, 6);
        LarusDoraActivityVoicePrintManagementBinding r110 = this.g;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L46:
        NovaTitleBarEx.b6(r110.g, 2131240517, false, null, null, new b(this), 14);
        LarusDoraActivityVoicePrintManagementBinding r111 = this.g;
        if (r111 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L49:
        e1.d(r111.e, new c(this));
        LarusDoraActivityVoicePrintManagementBinding r112 = this.g;
        if (r112 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L53:
        e1.d(r2.b, new d(this));
        return;
    L52:
        r2 = r112;
    L56:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
