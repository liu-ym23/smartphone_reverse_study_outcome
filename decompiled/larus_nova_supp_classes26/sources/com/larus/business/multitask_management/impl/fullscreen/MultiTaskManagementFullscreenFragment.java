package com.larus.business.multitask_management.impl.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.databinding.LarusFragmentMultitaskManagementFullscreenBinding;
import com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent;
import com.larus.platform.service.z2;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import k1a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.h2;
import xw8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/business/multitask_management/impl/fullscreen/MultiTaskManagementFullscreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusFragmentMultitaskManagementFullscreenBinding;", "enterTime", "", "hasReportedLeave", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupBackground", "setupTitleBar", "attachTaskCenterComponents", "onFirstEnterTab", "previousPage", "", "onEnterTab", "onLeaveTab", "onNewIntent", "bundle", "onDestroyView", "reportLeave", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementFullscreenFragment extends Fragment implements z {
    public static final /* synthetic */ int g = 0;
    public LarusFragmentMultitaskManagementFullscreenBinding d;
    public long e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e == 0) goto L10;
        h2.b("navigation_tab_click", "click_navigation", Long.valueOf(SystemClock.elapsedRealtime() - this.e));
        this.f = true;
        return;
    }

    public final void T90() {
        Bundle r0 = getArguments();
        String r1 = getString(2131907691);
        Intrinsics.checkNotNullParameter(r1, "fallback");
        if (r0 == null) goto L17;
        String r2 = r0.getString("navigation_title");
        if (r2 == null) goto L17;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L17;
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L17;
        String r7 = r3;
    L18:
        LarusFragmentMultitaskManagementFullscreenBinding r5 = this.d;
        if (r5 == null) goto L24;
        NovaTitleBarEx r6 = r5.b;
        if (r6 == null) goto L25;
        NovaTitleBarEx.Y5(r6, r7, null, null, 6);
        NovaTitleBarEx.b6(r6, 2131242079, false, null, r7, new c(this), 6);
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r4 = false;
    L17:
        r7 = r1;
        goto L18
    }

    public final void onDestroyView() {
        S90();
        this.d = null;
        super.onDestroyView();
    }

    public MultiTaskManagementFullscreenFragment() {
    }

    public final void t1() {
        S90();
    }

    public final void a2(Bundle r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Bundle r0 = getArguments();
        Intrinsics.checkNotNullParameter(r3, "incoming");
        if (r0 != null) goto L7;
        Bundle r1 = new Bundle();
    L8:
        r1.putAll(r3);
        if (r0 != null) goto L11;
        setArguments(r1);
    L11:
        T90();
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.e = SystemClock.elapsedRealtime();
    }

    public final void pp(String r3) {
        this.e = SystemClock.elapsedRealtime();
        this.f = false;
    }

    public final void y2(String r3) {
        this.e = SystemClock.elapsedRealtime();
        this.f = false;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        LarusFragmentMultitaskManagementFullscreenBinding r12 = this.d;
        if (r12 == null) goto L8;
        ConstraintLayout r13 = r12.a;
        if (r13 == null) goto L8;
        Context r14 = r13.getContext();
        r13.setBackground(new xw8.a(ContextCompat.getColor(r14, v19.c.b(2130970529, r14, 2131102529)), ContextCompat.getColor(r14, v19.c.b(2130970531, r14, 2131102535))));
    L8:
        T90();
        final PinnedServicesFeature r5 = new PinnedServicesFeature();
        if ((!z2.a.getMultiTaskEntranceConfig().a()) == false) goto L11;
        OngoingTasksFeature r15 = new OngoingTasksFeature();
    L12:
        final OngoingTasksFeature r4 = r15;
        final RecentServicesFeature r6 = new RecentServicesFeature();
        final DiscoverServicesFeature r7 = new DiscoverServicesFeature();
        final MultiTaskManagementSheetComponent r8 = new MultiTaskManagementSheetComponent(false, true);
        b.a(this, new xw8.b(this, r4, r5, r6, r7, r8));
        LarusFragmentMultitaskManagementFullscreenBinding r16 = this.d;
        if (r16 == null) goto L18;
        ConstraintLayout r17 = r16.a;
        if (r17 == null) goto L19;
        i0.a.getClass();
        int r18 = i0.g();
        int r0 = u.b(getActivity());
        int r1 = r17.getPaddingStart();
        int r2 = r17.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r17.getClass().getSimpleName() + ",source:,start:" + r1 + ",top:" + r18 + ",end:" + r2 + ",bottom:" + r0);
        r17.setPaddingRelative(r1, r18, r2, r0);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r15 = null;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562414, r3, false);
        int r6 = 2131380383;
        if (ViewBindings.findChildViewById(r5, 2131380383) == null) goto L11;
        r6 = 2131380395;
        if (ViewBindings.findChildViewById(r5, 2131380395) == null) goto L11;
        r6 = 2131380412;
        NovaTitleBarEx r7 = (NovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131380412);
        if (r7 == null) goto L11;
        ConstraintLayout r8 = r5;
        this.d = new LarusFragmentMultitaskManagementFullscreenBinding(r8, r7);
        return r8;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
