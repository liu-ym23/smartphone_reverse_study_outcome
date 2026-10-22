package com.larus.dora.obric.device_management.explore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\fH\u0002J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020%H\u0002J\u0018\u00103\u001a\u00020\f2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u00020%H\u0002J\u0018\u00104\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\b\u00106\u001a\u00020\u0012H\u0002J\u0010\u00107\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u00020%H\u0002J\u001c\u00109\u001a\u0004\u0018\u00010\f2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\u001aH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u000201H\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010\f2\u0006\u0010?\u001a\u00020\fH\u0002J\f\u0010@\u001a\u00020\u001a*\u00020-H\u0002J\f\u0010A\u001a\u00020\u001a*\u00020-H\u0002J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020%H\u0002J\b\u0010E\u001a\u00020%H\u0002J\u0012\u0010F\u001a\u00020%2\b\b\u0001\u0010G\u001a\u00020%H\u0002J\f\u0010H\u001a\u00020%*\u00020%H\u0002J\f\u0010I\u001a\u00020%*\u00020JH\u0002J\u0014\u0010K\u001a\u00020\u001a*\u00020L2\u0006\u0010M\u001a\u00020%H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricExploreFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/explore/DoraObricExploreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "reportedItems", "", "", "scrollView", "Landroidx/core/widget/NestedScrollView;", "contentContainer", "Landroid/widget/LinearLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "autoLogEnterPage", "", "buildContentView", "buildTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "buildScrollView", "updateContentTopPadding", "insetTop", "", "observeState", "renderState", "state", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreState;", "buildSectionTitle", "title", "buildExploreCard", "Lcom/obric/oui/lisitem/OCardListItem;", "section", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreSection;", "item", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreItem;", "itemIndex", "buildExposureTag", "buildCardImage", "buildCardOverlay", "buildNewTag", "buildCardTextItem", "openDetail", "getRouteQuery", "url", "key", "checkExposure", "getCardContentType", "getCardContentTypeByTag", "tag", "applyExploreCardStyle", "resetCardContainerMargins", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolveNewTagBackgroundColor", "color", "resId", "dp", "sp", "", "setSansSerifFontWeight", "Landroid/widget/TextView;", "weight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricExploreFragment extends DoraBaseFragment {
    public static final /* synthetic */ int j = 0;
    public final Lazy f;
    public final Set<String> g;
    public ONestedScrollView h;
    public LinearLayout i;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "explore_home";
    }

    public final void W90() {
        NestedScrollView r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        LinearLayout r1 = this.i;
        if (r1 != null) goto L8;
        return;
    L8:
        Rect r2 = new Rect();
        r0.getHitRect(r2);
        int r3 = r1.getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L24;
        View r5 = r1.getChildAt(r4);
        if (r5.getLocalVisibleRect(r2) == false) goto L23;
        Object r6 = r5.getTag();
        if ((r6 instanceof String) == false) goto L15;
        String r7 = (String) r6;
    L16:
        if (r7 == null) goto L23;
        if (this.g.add(r7) == false) goto L23;
        String r8 = Z90(r7);
        if (r8 == null) goto L23;
        com.larus.dora.impl.device.manage.b.b("feature_introduction", r8);
        goto L23
    L15:
        r7 = null;
    L23:
        r4 = r4 + 1;
        goto L9
    }

    public DoraObricExploreFragment() {
        final Function0<Fragment> r0 = new DoraObricExploreFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricExploreViewModel.class), new DoraObricExploreFragment$special$$inlined$viewModels$default$2(r0), new DoraObricExploreFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = new LinkedHashSet();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final boolean S90() {
        Bundle r0 = getArguments();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.getBoolean("embedded_device_home") != true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    public final int X90(int r2) {
        return ContextCompat.getColor(requireContext(), r2);
    }

    public final int Y90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final String Z90(String r6) {
        if (StringsKt.contains$default(r6, "diary", false, 2, null) == false) goto L6;
        return "diary";
    L6:
        if (StringsKt.contains$default(r6, "record_minutes", false, 2, null) == false) goto L9;
        return "record_minutes";
    L9:
        if (StringsKt.contains$default(r6, "note", false, 2, null) == false) goto L11;
        return "note";
    L11:
        if (StringsKt.contains$default(r6, "quick_note", false, 2, null) == false) goto L14;
        return "note";
    L14:
        if (StringsKt.contains$default(r6, "podcast", false, 2, null) == false) goto L17;
        return "podcast";
    L17:
        if (StringsKt.contains$default(r6, "natural_awaken", false, 2, null) == false) goto L20;
        return "natural_awaken";
    L20:
        if (StringsKt.contains$default(r6, "interpretation", false, 2, null) == false) goto L23;
        return "interpretation";
    L23:
        return null;
    }

    public final void aa0(OCardListItem r3) {
        ViewGroup.LayoutParams r0 = r3.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r3.getCardContainer().setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricExploreFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
        ((DoraObricExploreViewModel) this.f.getValue()).load();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View, android.widget.FrameLayout, androidx.core.widget.NestedScrollView, com.obric.oui.bouncelayout.ONestedScrollView] */
    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Context r11 = requireContext();
        ?? r12 = new ONestedScrollView(requireContext(), null, 6, 0);
        this.h = r12;
        r12.setFillViewport(true);
        r12.setClipChildren(true);
        r12.setClipToPadding(false);
        r12.setPadding(Y90(12), Y90(88), Y90(12), Y90(128));
        LinearLayout r3 = new LinearLayout(r12.getContext());
        r3.setOrientation(1);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        this.i = r3;
        r12.addView(r3, new ViewGroup.LayoutParams(-1, -2));
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        final OFloatingTitleBar r13 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setStartTitle(getString(2131902572));
        r13.setMaskBlurRadius(8.0f);
        ViewCompat.setOnApplyWindowInsetsListener(r13, new j(r13, this));
        ConstraintLayout r0 = new ConstraintLayout(r11);
        r0.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, 0);
        r14.startToStart = 0;
        r14.endToEnd = 0;
        r14.topToTop = 0;
        r14.bottomToBottom = 0;
        Unit r1 = Unit.INSTANCE;
        r0.addView(r12, r14);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(0, -2);
        r15.startToStart = 0;
        r15.endToEnd = 0;
        r15.topToTop = 0;
        r0.addView(r13, r15);
        return r0;
    }
}
