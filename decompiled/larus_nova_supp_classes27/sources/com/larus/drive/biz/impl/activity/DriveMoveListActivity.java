package com.larus.drive.biz.impl.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.drive.biz.impl.databinding.LarusPageDriveMoveListBinding;
import com.larus.drive.biz.impl.view.DriveMoveListFragment;
import com.larus.drive.biz.impl.viewmodel.DriveMoveViewModel;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.i;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j79.d;
import j79.e;
import j79.g;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.f;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/drive/biz/impl/activity/DriveMoveListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusPageDriveMoveListBinding;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveMoveViewModel;", "hasPlayedEnterAnimation", "", "fileToken", "", "driveObjType", "", "driveToken", "parentFolderToken", "refreshMark", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewModel", "setupContainer", "setupFragment", "setupObservers", "setupClickListeners", "setupBackNavigationUI", "syncNavigationBarColor", "playEnterAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMoveListActivity extends AppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public LarusPageDriveMoveListBinding a;
    public DriveMoveViewModel b;
    public boolean c;
    public String d;
    public int e;
    public String f;
    public String g;

    public static final class a {
        public static void a(Context r2, String r3, String r4, int r5, String r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r3, "fileToken");
            if (r2 != null) goto L5;
            return;
        L5:
            Intent r0 = new Intent(r2, DriveMoveListActivity.class);
            r0.putExtra("arg_file_token", r3);
            r0.putExtra("arg_drive_token", r4);
            r0.putExtra("arg_drive_obj_type", r5);
            r0.putExtra("arg_parent_folder_token", r6);
            r0.putExtra("arg_parent_folder_drive_token", r7);
            r0.putExtra("refresh_mark", r8);
            r2.startActivity(r0);
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(g r2) {
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DriveMoveListActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public DriveMoveListActivity() {
        this.e = -1;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DriveMoveListActivity.class.getName()));
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
    /* JADX WARN: Type inference failed for: r5v17, types: [j79.g] */
    public final void onCreate(Bundle r18) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r18);
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(getWindow(), y1(getWindow()));
        boolean r2 = h.a;
        boolean r4 = true;
        boolean r3 = !h.a(null);
        r1.setAppearanceLightStatusBars(r3);
        r1.setAppearanceLightNavigationBars(r3);
        int r5 = 0;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ConstraintLayout r6 = getLayoutInflater().inflate(2131563040, null, false);
        int r7 = 2131377293;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131377293);
        if (r9 == null) goto L106;
        r7 = 2131377294;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r6, 2131377294);
        if (r10 == null) goto L106;
        r7 = 2131377296;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131377296);
        if (r11 == null) goto L106;
        r7 = 2131377297;
        ConstraintLayout r12 = ViewBindings.findChildViewById(r6, 2131377297);
        if (r12 == null) goto L106;
        r7 = 2131377298;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r6, 2131377298);
        if (r13 == null) goto L106;
        r7 = 2131377299;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r6, 2131377299);
        if (r14 == null) goto L106;
        r7 = 2131377300;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r6, 2131377300);
        if (r15 == null) goto L106;
        r7 = 2131377301;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r6, 2131377301);
        if (r16 == null) goto L106;
        ConstraintLayout r8 = r6;
        this.a = new LarusPageDriveMoveListBinding(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        if (r8 == null) goto L30;
        int r17 = u.b(this);
        int r20 = r8.getPaddingStart();
        int r21 = r8.getPaddingTop();
        int r22 = r8.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r8.getClass().getSimpleName() + ",source:,start:" + r20 + ",top:" + r21 + ",end:" + r22 + ",bottom:" + r17);
        r8.setPaddingRelative(r20, r21, r22, r17);
    L30:
        LarusPageDriveMoveListBinding r23 = this.a;
        if (r23 == null) goto L33;
        ConstraintLayout r24 = r23.a;
    L34:
        setContentView(r24);
        String r25 = getIntent().getStringExtra("arg_file_token");
        if (r25 != null) goto L37;
        finish();
        return;
    L37:
        this.d = r25;
        this.e = getIntent().getIntExtra("arg_drive_obj_type", -1);
        String r26 = getIntent().getStringExtra("arg_drive_token");
        if (r26 != null) goto L40;
        finish();
        return;
    L40:
        this.f = r26;
        getIntent().getStringExtra("arg_parent_folder_token");
        this.g = getIntent().getStringExtra("refresh_mark");
        DriveMoveViewModel r27 = (DriveMoveViewModel) new ViewModelProvider(this).get(DriveMoveViewModel.class);
        this.b = r27;
        if (r27 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r27 = null;
    L43:
        r27.getSelectedFolder().observe(this, new b(new g(this)));
        LarusPageDriveMoveListBinding r28 = this.a;
        if (r28 == null) goto L53;
        FrameLayout r30 = r28.d;
        if (r30 == null) goto L53;
        int r31 = RangesKt.coerceAtLeast((int) (((i.b(this) * 0.9f) - i5.l0()) - i5.h0()), 0);
        ViewGroup.LayoutParams r32 = r30.getLayoutParams();
        if ((r32 instanceof ConstraintLayout.LayoutParams) == false) goto L50;
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
    L51:
        if (r33 == null) goto L53;
        ((ViewGroup.MarginLayoutParams) r33).height = r31;
        r30.setLayoutParams(r33);
        r30.requestLayout();
        goto L53
    L50:
        r33 = null;
    L53:
        LarusPageDriveMoveListBinding r34 = this.a;
        if (r34 == null) goto L76;
        FrameLayout r35 = r34.d;
        if (r35 == null) goto L76;
        int r36 = r35.getId();
        if (getSupportFragmentManager().findFragmentById(r36) != null) goto L76;
        int r37 = DriveMoveListFragment.H;
        DriveMoveListFragment r38 = DriveMoveListFragment.a.a(r36, null, null, null, true, this.f);
        FragmentTransaction r40 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r40, r38, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r36) == true) goto L64;
        r40.replace(r36, r38);
    L64:
        r40.commit();
        getSupportFragmentManager().addOnBackStackChangedListener(new j79.h(this));
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) goto L68;
        r4 = false;
    L68:
        LarusPageDriveMoveListBinding r41 = this.a;
        if (r41 == null) goto L76;
        ImageView r42 = r41.f;
        if (r42 == null) goto L76;
        if (r4 == true) goto L75;
        r5 = 4;
    L75:
        r42.setVisibility(r5);
    L76:
        LarusPageDriveMoveListBinding r43 = this.a;
        if (r43 == null) goto L81;
        ConstraintLayout r44 = r43.a;
        if (r44 == null) goto L81;
        r44.setOnClickListener(new j79.b(this));
    L81:
        LarusPageDriveMoveListBinding r45 = this.a;
        if (r45 == null) goto L86;
        ImageView r46 = r45.g;
        if (r46 == null) goto L86;
        r46.setOnClickListener(new j79.c(this));
    L86:
        LarusPageDriveMoveListBinding r47 = this.a;
        if (r47 == null) goto L91;
        ImageView r48 = r47.f;
        if (r48 == null) goto L91;
        r48.setOnClickListener(new d(this));
    L91:
        LarusPageDriveMoveListBinding r50 = this.a;
        if (r50 == null) goto L96;
        TextView r51 = r50.c;
        if (r51 == null) goto L96;
        r51.setOnClickListener(new e(this));
    L96:
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, v19.c.b(2130970532, this, 2131102539)));
        if (this.c == true) goto L113;
        LarusPageDriveMoveListBinding r52 = this.a;
        if (r52 == null) goto L111;
        ConstraintLayout r53 = r52.a;
        if (r53 == null) goto L112;
        r53.post(new j79.f(this));
        return;
    L112:
        return;
    L111:
        return;
    L113:
        return;
    L33:
        r24 = null;
    L106:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
