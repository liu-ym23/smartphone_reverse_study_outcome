package com.larus.dora.obric.device_management.setting.common.name;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000201H\u0002J\b\u00105\u001a\u000201H\u0002J\b\u00106\u001a\u000201H\u0002J\f\u00107\u001a\u000201*\u000201H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/common/name/DoraObricDeviceNameViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "inputLayout", "Lcom/obric/oui/forms/OInputLayout;", "tipsView", "Lcom/obric/oui/text/OTextView;", "pageMaskView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "setupTitleBar", "buildContentView", "buildTitleBar", "buildBodyContent", "buildInputCard", "Lcom/obric/oui/lisitem/OCardListItem;", "buildInputLayout", "setupInput", "setupBackPressed", "onBackPressed", "observeActions", "currentInputText", "showLengthConfirmDialogOrToast", "useEarbudsNameStyle", "", "showWarningToast", "textResId", "", "tintTextAction", "color", "resolveBackgroundColor", "resolvePrimaryColor", "resolveTipsColor", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceNameFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public OFloatingTitleBar g;
    public OInputLayout h;
    public OTextView i;
    public View j;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "device_management_name";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final DoraObricDeviceNameViewModel X90() {
        return (DoraObricDeviceNameViewModel) this.f.getValue();
    }

    public DoraObricDeviceNameFragment() {
        final Function0<Fragment> r0 = new DoraObricDeviceNameFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricDeviceNameViewModel.class), new DoraObricDeviceNameFragment$special$$inlined$viewModels$default$2(r0), new DoraObricDeviceNameFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onBackPressed() {
        if (((i) X90().getUiState().getValue()).c == false) goto L7;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L17;
        r0.finish();
        return;
    L17:
        return;
    L7:
        DoraObricDeviceNameViewModel r1 = X90();
        OInputLayout r2 = this.h;
        if (r2 == null) goto L12;
        CharSequence r3 = r2.getText();
        if (r3 == null) goto L12;
        String r4 = r3.toString();
    L13:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r1.onBackClicked(r4);
        return;
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.j;
    }

    public final int W90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static void Y90(View r3, int r4) {
        if ((r3 instanceof TextView) == false) goto L6;
        ((TextView) r3).setTextColor(r4);
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L10;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        Y90(r5.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        X90().initialize(getArguments());
        OFloatingTitleBar r10 = this.g;
        int r1 = 0;
        if (r10 == null) goto L7;
        r10.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r10.setCenterTitle(getString(2131902445));
        r10.R(false);
        OFloatingTitleBar.k(r10, new b(this), 2);
        if (((i) X90().getUiState().getValue()).c == false) goto L7;
        String r2 = getString(2131903980);
        View.OnClickListener r3 = new c(this);
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r2, "text");
        int r5 = k.a.i;
        Intrinsics.checkNotNullParameter(r2, "text");
        k.a r4 = new k.a(2, 0, r2, r3);
        int r6 = OFloatingTitleBar.C(r10.P.d, -1);
        List r7 = r10.P.d;
        List r11 = CollectionsKt.toMutableList(r7);
        ListProtector.add(r11, OFloatingTitleBar.C(r7, -1), r4);
        Y90((View) ListProtector.get(OFloatingTitleBar.V(r10, null, r11, false, 7).d, r6), v19.c.a(2130972123, requireContext(), 2131103203));
    L7:
        i r12 = (i) X90().getUiState().getValue();
        OTextView r13 = this.i;
        if (r13 != null) goto L10;
    L14:
        final OInputLayout r14 = this.h;
        if (r14 == null) goto L24;
        OEditText r15 = r14.getVInput();
        if (r12.c == false) goto L19;
        com.larus.dora.impl.device.settings.rename.a[] r0 = {new com.larus.dora.impl.device.settings.rename.a()};
    L20:
        r15.setFilters(r0);
        r14.setText(r12.a);
        OEditText r16 = r14.getVInput();
        CharSequence r17 = r14.getText();
        if (r17 == null) goto L23;
        r1 = r17.length();
    L23:
        r16.setSelection(r1);
        r14.post(new e(r14, this));
        goto L24
    L19:
        r0 = new InputFilter[]{new com.larus.dora.impl.device.settings.rename.a(), new InputFilter.LengthFilter(20)};
    L24:
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new d(this), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceNameFragment$observeActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L10:
        if (r12.c == false) goto L12;
        int r18 = 2131902507;
    L13:
        r13.setText(r18);
        goto L14
    L12:
        r18 = 2131903981;
        goto L13
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Context r13 = requireContext();
        OFloatingTitleBar r14 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        this.g = r14;
        LinearLayout r15 = new LinearLayout(requireContext());
        r15.setOrientation(1);
        r15.setPadding(0, W90(16), 0, 0);
        View r4 = new OCardListItem(requireContext(), null, 6, 0);
        OCardListItem.h(r4, 0);
        r4.setCardType(2);
        OInputLayout r6 = new OInputLayout(requireContext(), null, 6, 0);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, W90(48)));
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        r6.setPadding(0, 0, 0, 0);
        r6.setType(0);
        r6.o = true;
        r6.h();
        r6.f.setBackgroundColor(0);
        r6.g(false);
        r6.setMaxLines(1);
        this.h = r6;
        r4.setCustomStartView(r6);
        r4.n(true);
        r4.o(false);
        r15.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        OTextView r1 = new OTextView(r15.getContext(), null, 0, 14);
        r1.setTextAlignment(5);
        r1.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r1.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        r0.setMarginStart(W90(32));
        r0.setMarginEnd(W90(32));
        r0.topMargin = W90(8);
        Unit r2 = Unit.INSTANCE;
        r15.addView(r1, r0);
        this.i = r1;
        return com.larus.dora.obric.utils.c.c(r13, r14, r15, v19.c.a(2130970531, requireContext(), 2131102535), new g(this));
    }
}
