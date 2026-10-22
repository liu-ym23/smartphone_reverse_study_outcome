package com.larus.business.multitask_management.impl.sheet;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.databinding.LarusFragmentMultitaskManagementBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tx9.a1;
import tx9.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0010H\u0002J\u001a\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MultiTaskManagementDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusFragmentMultitaskManagementBinding;", "enterTime", "", "Ljava/lang/Long;", "leaveMethod", "", "hasReportedLeave", "", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupNestedScroll", "onStart", "setupTransparentNavigationBar", "window", "Landroid/view/Window;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setupLandscape", "isTouchInsideView", "event", "Landroid/view/MotionEvent;", "targetView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentMultitaskManagementBinding d;
    public Long e;
    public String f;
    public boolean g;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ MultiTaskManagementDialogFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(MultiTaskManagementDialogFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 5) goto L16;
            MultiTaskManagementDialogFragment r4 = this.a;
            if (r4.f != null) goto L14;
            r4.f = "swipe_down";
        L14:
            r4.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L17;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L17:
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954355;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        final BottomSheetDialog r1 = r0;
    L7:
        if (r1 == null) goto L9;
        r1.setCanceledOnTouchOutside(true);
    L9:
        if (r1 == null) goto L24;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L24;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L17:
        WindowCompat.setDecorFitsSystemWindows(r3, false);
        r3.clearFlags(134217728);
        r3.addFlags(Integer.MIN_VALUE);
        r3.setNavigationBarColor(0);
        int r6 = Build.VERSION.SDK_INT;
        if (r6 < 28) goto L21;
        r3.setNavigationBarDividerColor(0);
    L21:
        if (r6 < 29) goto L23;
        r3.setNavigationBarContrastEnforced(false);
    L23:
        r4.setSystemUiVisibility((r4.getSystemUiVisibility() | 512) | 256);
    L24:
        if (r1 == null) goto L26;
        final View r7 = r1.findViewById(2131368870);
    L27:
        if (r1 == null) goto L29;
        View r8 = r1.findViewById(2131367728);
    L30:
        if (r8 == null) goto L32;
        ViewCompat.setOnApplyWindowInsetsListener(r8, new j());
        ViewCompat.requestApplyInsets(r8);
    L32:
        final Ref.BooleanRef r9 = new Ref.BooleanRef();
        if (r8 == null) goto L35;
        r8.setOnTouchListener(new k(r9, this, r7, r1));
    L35:
        if (r7 == null) goto L40;
        BottomSheetBehavior r10 = BottomSheetBehavior.from(r7);
        r10.setState(3);
        r10.setSkipCollapsed(true);
        r10.setHideable(true);
        r10.setBottomSheetCallback(new b(this));
        ViewGroup.LayoutParams r2 = r7.getLayoutParams();
        if (r2 == null) goto L39;
        r2.height = -1;
    L39:
        r7.setLayoutParams(r2);
    L40:
        if (r1 == null) goto L42;
        View r11 = r1.findViewById(2131367947);
    L43:
        if (r11 == null) goto L53;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L47;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
    L48:
        int r14 = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        if (r13 == null) goto L51;
        r13.topMargin = r14;
    L51:
        r11.setLayoutParams(r13);
        return;
    L47:
        r13 = null;
        goto L48
    L53:
        return;
    L42:
        r11 = null;
        goto L43
    L29:
        r8 = null;
        goto L30
    L26:
        r7 = null;
        goto L27
    L5:
        r1 = null;
        goto L7
    }

    public MultiTaskManagementDialogFragment() {
    }

    public final void S90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r6);
        if (this.g == false) goto L5;
        return;
    L5:
        Bundle r7 = getArguments();
        String r0 = "";
        if (r7 == null) goto L9;
        String r8 = r7.getString("enter_from");
        if (r8 == null) goto L9;
    L10:
        String r1 = this.f;
        if (r1 == null) goto L14;
        r0 = r1;
    L14:
        Long r2 = this.e;
        if (r2 == null) goto L17;
        long r3 = r2.longValue();
        long r4 = SystemClock.elapsedRealtime() - r3;
    L18:
        h2.b(r8, r0, Long.valueOf(r4));
        this.g = true;
        return;
    L17:
        r4 = 0;
    L9:
        r8 = "";
        goto L10
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        if (this.f != null) goto L6;
        this.f = "swipe_right";
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        if (r3.orientation != 2) goto L20;
        BottomSheetDialog r4 = getDialog();
        View r1 = null;
        if ((r4 instanceof BottomSheetDialog) == false) goto L7;
        BottomSheetDialog r5 = r4;
    L8:
        if (r5 == null) goto L10;
        r1 = r5.findViewById(2131368870);
    L10:
        if (r1 == null) goto L21;
        BottomSheetBehavior r6 = BottomSheetBehavior.from(r1);
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.getState() != 4) goto L17;
        r6.setState(3);
    L17:
        if (r6.getSkipCollapsed() == true) goto L23;
        r6.setSkipCollapsed(true);
        return;
    L23:
        return;
    L21:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void onCreate(Bundle r57) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r57);
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("enter_from");
        if (r1 == null) goto L6;
    L7:
        String r17 = r1;
        a1.c(null, null, null, null, null, "multi_task_manage", null, null, r17, null, null, null, null, null, null, null, r17, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -1, 7);
        this.e = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        final PinnedServicesFeature r4 = new PinnedServicesFeature();
        if ((!z2.a.getMultiTaskEntranceConfig().a()) == false) goto L5;
        OngoingTasksFeature r11 = new OngoingTasksFeature();
    L6:
        final OngoingTasksFeature r3 = r11;
        final RecentServicesFeature r5 = new RecentServicesFeature();
        final DiscoverServicesFeature r6 = new DiscoverServicesFeature();
        final MultiTaskManagementSheetComponent r7 = new MultiTaskManagementSheetComponent(0);
        k1a.b.a(this, new i(this, r3, r4, r5, r6, r7));
        LarusFragmentMultitaskManagementBinding r12 = this.d;
        if (r12 == null) goto L12;
        final RecyclerView r13 = r12.d;
        if (r13 == null) goto L13;
        r13.setNestedScrollingEnabled(true);
        final int r14 = ViewConfiguration.get(r13.getContext()).getScaledTouchSlop();
        final Ref.FloatRef r0 = new Ref.FloatRef();
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        r13.setOnTouchListener(new l(r0, r13, r1, r14));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentMultitaskManagementBinding r4 = LarusFragmentMultitaskManagementBinding.a(r1, r2);
        this.d = r4;
        return r4.a;
    }
}
