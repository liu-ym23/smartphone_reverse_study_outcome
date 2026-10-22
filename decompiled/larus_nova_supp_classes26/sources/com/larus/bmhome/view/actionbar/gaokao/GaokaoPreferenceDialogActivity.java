package com.larus.bmhome.view.actionbar.gaokao;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoType;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceConfResponse;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceList;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoTypeList;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoPreferenceDialogActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "dialog", "Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoPreferenceDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getBackgroundResource", "", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "onBackPressed", "finish", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceDialogActivity extends FlowCommonAppCompatActivity {
    public static WeakReference<Function1<String, Unit>> h;
    public static WeakReference<Function0<Unit>> i;
    public final GaokaoPreferenceDialog g;

    public static final class a {
        public static void a(Context r2, GaokaoProvinceConfResponse r3, Function1 r4, Function0 r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r3 == null) goto L40;
            WeakReference<Function1<String, Unit>> r0 = GaokaoPreferenceDialogActivity.h;
            Activity r1 = null;
            if (r0 == null) goto L7;
            Function1<String, Unit> r6 = r0.get();
        L8:
            if (r6 != null) goto L41;
            if (r4 == null) goto L43;
            GaokaoPreferenceDialogActivity.h = new WeakReference(r4);
            if (r5 == null) goto L14;
            GaokaoPreferenceDialogActivity.i = new WeakReference(r5);
        L14:
            Intent r7 = new Intent(r2, GaokaoPreferenceDialogActivity.class);
            GaokaoProvinceList r8 = r3.getProvinceList();
            if (r8 == null) goto L20;
            List<GaokaoProvince> r9 = r8.getList();
            if (r9 == null) goto L20;
            List r10 = CollectionsKt.filterNotNull(r9);
            if (r10 == null) goto L20;
        L21:
            r7.putParcelableArrayListExtra("province_list", new ArrayList(r10));
            GaokaoTypeList r11 = r3.getTypeList();
            if (r11 == null) goto L27;
            List<GaokaoType> r12 = r11.getList();
            if (r12 == null) goto L27;
            List r13 = CollectionsKt.filterNotNull(r12);
            if (r13 == null) goto L27;
        L28:
            r7.putParcelableArrayListExtra("type_list", new ArrayList(r13));
            List<String> r14 = r3.getPreferencesAfterGraduation();
            if (r14 == null) goto L33;
            List r15 = CollectionsKt.filterNotNull(r14);
            if (r15 == null) goto L33;
        L34:
            r7.putStringArrayListExtra("post_grad_preference_list", new ArrayList(r15));
            r7.putExtra("current_province_key", r3.getCurrentProvinceKey());
            r7.putExtra("current_province_name", r3.getCurrentProvinceName());
            r2.startActivity(r7);
            if ((r2 instanceof Activity) == false) goto L37;
            r1 = (Activity) r2;
        L37:
            if (r1 == null) goto L42;
            r1.overridePendingTransition(2130772381, 0);
            return;
        L42:
            return;
        L33:
            r15 = CollectionsKt.emptyList();
        L27:
            r13 = CollectionsKt.emptyList();
        L20:
            r10 = CollectionsKt.emptyList();
            goto L21
        L43:
            return;
        L41:
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    static {
    }

    public final int C1() {
        return 2131103293;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onBackPressed() {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(GaokaoPreferenceDialogActivity.class.getName()));
    L5:
        super.onDestroy();
        h = null;
        i = null;
    }

    public GaokaoPreferenceDialogActivity() {
        this.g = new GaokaoPreferenceDialog();
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0115 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        WeakReference<Function0<Unit>> r2 = i;
        if (r2 == null) goto L7;
        Function0<Unit> r3 = r2.get();
        if (r3 == null) goto L7;
        r3.invoke();
    L7:
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L49;
        FLogger r4 = FLogger.a;
        r4.i("ActivityLancet", "finish ".concat(GaokaoPreferenceDialogActivity.class.getName()));
        long r5 = SystemClock.uptimeMillis();
        Map r6 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r6);
        Long r7 = (Long) r6.get(this);     // Catch: Throwable -> L50
        if (r7 != null) goto L15;
    L18:
        r6.put(this, Long.valueOf(r5));     // Catch: Throwable -> L50
        monitor-exit(r6);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L21:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L24;
        r4.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        goto L53
    L24:
        if (isFinishing() == true) goto L27;
        r4.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        goto L53
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L30;
        r4.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        goto L53
    L30:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L33;
        r4.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        goto L53
    L33:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L36;
        r4.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        goto L53
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        goto L53
    L38:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L47
        if (r1 == null) goto L53;
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r4.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L47
        startActivity(r1);     // Catch: Throwable -> L44
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        goto L53
    L15:
        if ((r5 - r7.longValue()) >= 800) goto L18;
        monitor-exit(r6);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
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
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        setContentView(2131561788);
        this.g.setArguments(getIntent().getExtras());
        FragmentTransaction r6 = getSupportFragmentManager().beginTransaction();
        GaokaoPreferenceDialog r0 = this.g;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L14;
        r6 = r6.replace(2131373275, r0);
    L14:
        r6.commit();
        i0 r7 = i0.a;
        WeakReference r1 = new WeakReference(this);
        r7.getClass();
        i0.i(r1);
    }
}
