package com.larus.business.multitask_management.impl.pad;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.databinding.LarusFragmentMultitaskManagementBinding;
import com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import k1a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import tx9.a1;
import tx9.h2;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/business/multitask_management/impl/pad/MultiTaskManagementPadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusFragmentMultitaskManagementBinding;", "enterTime", "", "Ljava/lang/Long;", "leaveMethod", "", "hasReportedLeave", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "updateWindowSize", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementPadDialogFragment extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentMultitaskManagementBinding d;
    public Long e;
    public String f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final void U90() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L19;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L20;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        S90(r1).setBackgroundColor(0);
        Resources r2 = getResources();
        DisplayMetrics r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics());
        int r4 = r3.widthPixels;
        int r5 = r3.heightPixels;
        float r6 = Math.min(r4, r5);
        WindowInsetsCompat r7 = ViewCompat.getRootWindowInsets(S90(r1));
        if (r7 == null) goto L10;
        Insets r8 = r7.getInsets(WindowInsetsCompat.Type.systemBars());
    L11:
        if (r8 == null) goto L13;
        int r9 = r8.top;
    L14:
        if (r8 == null) goto L16;
        int r10 = r8.bottom;
    L17:
        int r11 = RangesKt.coerceAtLeast(Math.min(Math.min(MathKt.roundToInt(r6 * 0.85f), ((r5 - r9) - r10) - c7.b(96)), c7.b(800)), 0);
        r1.setLayout(RangesKt.coerceAtLeast(MathKt.roundToInt(r11 / 1.25f), 0), r11);
        r1.setGravity(17);
        return;
    L16:
        r10 = 0;
        goto L17
    L13:
        r9 = 0;
        goto L14
    L10:
        r8 = null;
        goto L11
    L20:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        U90();
    }

    public MultiTaskManagementPadDialogFragment() {
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void T90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        super.onDismiss(r6);
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
        super.onCancel(r2);
        if (this.f != null) goto L6;
        this.f = "cancel";
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        U90();
    }

    public final void onCreate(Bundle r57) {
        super.onCreate(r57);
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
        T90(r2);     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusFragmentMultitaskManagementBinding r10 = this.d;
        if (r10 == null) goto L7;
        ConstraintLayout r11 = r10.c;
        if (r11 == null) goto L7;
        r11.setBackgroundResource(2131243064);
    L7:
        LarusFragmentMultitaskManagementBinding r12 = this.d;
        if (r12 == null) goto L12;
        View r13 = r12.b;
        if (r13 == null) goto L12;
        r13.setVisibility(8);
    L12:
        final PinnedServicesFeature r3 = new PinnedServicesFeature();
        if ((!z2.a.getMultiTaskEntranceConfig().a()) == false) goto L15;
        OngoingTasksFeature r14 = new OngoingTasksFeature();
    L16:
        final OngoingTasksFeature r2 = r14;
        final RecentServicesFeature r4 = new RecentServicesFeature();
        final DiscoverServicesFeature r5 = new DiscoverServicesFeature();
        final MultiTaskManagementSheetComponent r6 = new MultiTaskManagementSheetComponent(0);
        b.a(this, new yw8.a(this, r2, r3, r4, r5, r6));
        return;
    L15:
        r14 = null;
        goto L16
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentMultitaskManagementBinding r4 = LarusFragmentMultitaskManagementBinding.a(r1, r2);
        this.d = r4;
        return r4.a;
    }
}
