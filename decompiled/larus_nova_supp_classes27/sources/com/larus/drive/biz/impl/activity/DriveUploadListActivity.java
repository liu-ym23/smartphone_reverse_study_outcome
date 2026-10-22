package com.larus.drive.biz.impl.activity;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.drive.biz.impl.adapter.DriveUploadListAdapter;
import com.larus.drive.biz.impl.databinding.LarusPageDriveUploadListBinding;
import com.larus.drive.biz.impl.file.t;
import com.larus.drive.biz.impl.viewmodel.DriveUploadListViewModel;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j79.j;
import j79.k;
import j79.l;
import j79.m;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import v19.f;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/drive/biz/impl/activity/DriveUploadListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusPageDriveUploadListBinding;", "adapter", "Lcom/larus/drive/biz/impl/adapter/DriveUploadListAdapter;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveUploadListViewModel;", "hasPlayedEnterAnimation", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupRecycler", "setupViewModel", "observeData", "setupClickListeners", "syncNavigationBarColor", "playEnterAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveUploadListActivity extends AppCompatActivity {
    public static final /* synthetic */ int e = 0;
    public LarusPageDriveUploadListBinding a;
    public DriveUploadListAdapter b;
    public DriveUploadListViewModel c;
    public boolean d;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(m r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DriveUploadListActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DriveUploadListActivity.class.getName()));
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
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public DriveUploadListActivity() {
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [j79.m] */
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r11);
        WindowInsetsControllerCompat r12 = WindowCompat.getInsetsController(getWindow(), y1(getWindow()));
        boolean r0 = h.a;
        ConstraintLayout.LayoutParams r1 = null;
        boolean r2 = !h.a(null);
        r12.setAppearanceLightStatusBars(r2);
        r12.setAppearanceLightNavigationBars(r2);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ConstraintLayout r13 = getLayoutInflater().inflate(2131563043, null, false);
        int r3 = 2131377321;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r13, 2131377321);
        if (r5 == null) goto L59;
        r3 = 2131377322;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, 2131377322);
        if (r6 == null) goto L59;
        r3 = 2131377323;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r13, 2131377323);
        if (r7 == null) goto L59;
        r3 = 2131377324;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131377324);
        if (r8 == null) goto L59;
        r3 = 2131377325;
        RecyclerView r9 = ViewBindings.findChildViewById(r13, 2131377325);
        if (r9 == null) goto L59;
        ConstraintLayout r14 = r13;
        this.a = new LarusPageDriveUploadListBinding(r14, r5, r6, r7, r8, r9);
        if (r14 == null) goto L23;
        int r4 = u.b(this);
        int r10 = r14.getPaddingStart();
        int r15 = r14.getPaddingTop();
        int r16 = r14.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r14.getClass().getSimpleName() + ",source:,start:" + r10 + ",top:" + r15 + ",end:" + r16 + ",bottom:" + r4);
        r14.setPaddingRelative(r10, r15, r16, r4);
    L23:
        LarusPageDriveUploadListBinding r17 = this.a;
        if (r17 == null) goto L26;
        ConstraintLayout r18 = r17.a;
    L27:
        setContentView(r18);
        this.c = (DriveUploadListViewModel) new ViewModelProvider(this).get(DriveUploadListViewModel.class);
        DriveUploadListViewModel r20 = this.c;
        if (r20 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r20 = null;
    L30:
        this.b = new DriveUploadListAdapter(r20);
        LarusPageDriveUploadListBinding r110 = this.a;
        if (r110 == null) goto L39;
        RecyclerView r111 = r110.f;
        if (r111 == null) goto L39;
        r111.setLayoutManager(new LinearLayoutManager(this));
        r111.setAdapter(this.b);
        Resources r21 = getResources();
        int r22 = (int) (WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()).heightPixels * 0.8f);
        ConstraintLayout.LayoutParams r23 = r111.getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == false) goto L37;
        r1 = r23;
    L37:
        if (r1 == null) goto L39;
        r1.matchConstraintMaxHeight = r22;
        r111.setLayoutParams(r1);
        r111.requestLayout();
    L39:
        t.f.observe(this, new b(new m(this)));
        LarusPageDriveUploadListBinding r112 = this.a;
        if (r112 == null) goto L44;
        ConstraintLayout r113 = r112.a;
        if (r113 == null) goto L44;
        r113.setOnClickListener(new k(this));
    L44:
        LarusPageDriveUploadListBinding r114 = this.a;
        if (r114 == null) goto L49;
        ImageView r115 = r114.c;
        if (r115 == null) goto L49;
        r115.setOnClickListener(new l(this));
    L49:
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, v19.c.b(2130970532, this, 2131102539)));
        if (this.d == true) goto L64;
        LarusPageDriveUploadListBinding r116 = this.a;
        if (r116 == null) goto L62;
        ConstraintLayout r117 = r116.a;
        if (r117 == null) goto L63;
        r117.post(new j(this));
        return;
    L63:
        return;
    L62:
        return;
    L64:
        return;
    L26:
        r18 = null;
    L59:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r3)));
    }
}
