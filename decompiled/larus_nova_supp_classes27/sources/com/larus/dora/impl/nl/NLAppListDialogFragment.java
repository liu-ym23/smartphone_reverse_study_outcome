package com.larus.dora.impl.nl;

import android.R;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraDialogNlApplistBinding;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/NLAppListViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/NLAppListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogNlApplistBinding;", "appListAdapter", "Lcom/larus/dora/impl/nl/NLAppListAdapter;", "isSearching", "", "enterPageTraced", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "cancelSearch", "hideKeyboard", "onResume", "onDestroy", "traceEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NLAppListDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy d;
    public LarusDoraDialogNlApplistBinding e;
    public NLAppListAdapter f;
    public boolean g;
    public boolean h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ NLAppListDialogFragment a;

        public b(NLAppListDialogFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            List<? extends AppListItem> r6 = (List) r4;
            NLAppListAdapter r7 = this.a.f;
            if (r7 == null) goto L6;
            Intrinsics.checkNotNullParameter(r6, "data");
            DiffUtil.DiffResult r0 = DiffUtil.calculateDiff(new NLAppListAdapter.AppListDiffCallback(r7.b, r6));
            r7.b = r6;
            r0.dispatchUpdatesTo(r7);
        L6:
            if (r6.isEmpty() == false) goto L19;
            NLAppListDialogFragment r8 = this.a;
            if (r8.g == false) goto L19;
            LarusDoraDialogNlApplistBinding r9 = r8.e;
            if (r9 == null) goto L14;
            AppCompatTextView r10 = r9.b;
            if (r10 == null) goto L14;
            r10.setText(r8.getString(2131902236, new Object[]{r8.T90().getQuery()}));
        L14:
            LarusDoraDialogNlApplistBinding r11 = this.a.e;
            if (r11 == null) goto L25;
            LinearLayout r12 = r11.c;
            if (r12 == null) goto L25;
            r12.setVisibility(0);
        L25:
            return Unit.INSTANCE;
        L19:
            LarusDoraDialogNlApplistBinding r13 = this.a.e;
            if (r13 == null) goto L25;
            LinearLayout r14 = r13.c;
            if (r14 == null) goto L25;
            r14.setVisibility(8);
            goto L25
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951932;
    }

    public final void S90() {
        LarusDoraDialogNlApplistBinding r0 = this.e;
        if (r0 == null) goto L9;
        EditText r1 = r0.f;
        if (r1 == null) goto L9;
        Editable r2 = r1.getText();
        if (r2 == null) goto L9;
        r2.clear();
    L9:
        T90().onSearchQueryChanged("");
        hideKeyboard();
        LarusDoraDialogNlApplistBinding r3 = this.e;
        if (r3 == null) goto L14;
        AppCompatTextView r4 = r3.e;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
    L14:
        this.g = false;
    }

    public final NLAppListViewModel T90() {
        return (NLAppListViewModel) this.d.getValue();
    }

    public NLAppListDialogFragment() {
        final Function0<Fragment> r0 = new NLAppListDialogFragment$special$$inlined$viewModels$default$1(this);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NLAppListViewModel.class), new NLAppListDialogFragment$special$$inlined$viewModels$default$2(r0), new NLAppListDialogFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void hideKeyboard() {
        Object r0 = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r1 = (InputMethodManager) r0;
        View r2 = getView();
        if (r2 == null) goto L5;
        IBinder r3 = r2.getWindowToken();
    L6:
        r1.hideSoftInputFromWindow(r3, 0);
        LarusDoraDialogNlApplistBinding r4 = this.e;
        if (r4 == null) goto L12;
        EditText r5 = r4.f;
        if (r5 == null) goto L13;
        r5.clearFocus();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        hideKeyboard();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.h == true) goto L25;
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getString("arg_current_page");
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        int r3 = j49.a.a;
        j49.a.e();
    L23:
        this.h = true;
        return;
    L17:
        DoraBuryPointManager r5 = DoraBuryPointManager.a;
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("current_page", r2);
        Bundle r7 = getArguments();
        if (r7 == null) goto L20;
        r1 = r7.getString("arg_previous_page");
    L20:
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        r6[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1);
        r5.L("enter_page", MapsKt.mapOf(r6));
        goto L23
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setCanceledOnTouchOutside(false);
    L5:
        BottomSheetDialog r12 = getDialog();
        if ((r12 instanceof BottomSheetDialog) == false) goto L8;
        BottomSheetDialog r13 = r12;
    L9:
        if (r13 == null) goto L11;
        View r14 = r13.findViewById(2131368870);
    L12:
        if (r14 == null) goto L18;
        int r0 = com.larus.utils.m0.a;
        int r1 = com.larus.utils.m0.a(r14.getContext());
        com.larus.utils.i0.a.getClass();
        int r2 = (r1 - com.larus.utils.i0.e()) - ((Number) i5.t0.getValue()).intValue();
        ViewGroup.LayoutParams r3 = r14.getLayoutParams();
        if (r3 == null) goto L16;
        r3.height = r2;
    L17:
        r14.setLayoutParams(r3);
        r14.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior r15 = BottomSheetBehavior.from(r14);
        r15.setState(3);
        r15.setPeekHeight(r2);
        r15.setHideable(false);
        goto L18
    L16:
        r3 = null;
    L18:
        final LarusDoraDialogNlApplistBinding r16 = this.e;
        if (r16 == null) goto L21;
        NovaTitleBarEx r4 = r16.g;
        NovaTitleBarEx.Y5(r4, getString(2131902206), null, null, 6);
        NovaTitleBarEx.o6(r4, getString(2131899222), new f(this));
        r4.c6(getString(2131899221), null, new g(this));
        r4.getBinding().h.setTypeface(Typeface.DEFAULT, 0);
        r4.getBinding().j.setTypeface(Typeface.DEFAULT, 1);
        RecyclerView r17 = r16.d;
        r17.setLayoutManager(new LinearLayoutManager(r17.getContext()));
        r17.setItemAnimator(null);
        NLAppListAdapter r5 = new NLAppListAdapter();
        r5.a = new h(this);
        this.f = r5;
        r17.setAdapter(r5);
        r17.addOnScrollListener(new NLAppListDialogFragment$setupUI$2$2$2(this, r16));
        r16.f.addTextChangedListener(new j(this));
        e1.d(r16.e, new i(this));
    L21:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NLAppListDialogFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.view.View, com.larus.common_ui.widget.roundlayout.RoundConstraintLayout] */
    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562164, r10, false);
        int r13 = 2131363089;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r12, 2131363089);
        if (r2 == null) goto L21;
        r13 = 2131363090;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131363090);
        if (r3 == null) goto L21;
        r13 = 2131363101;
        RecyclerView r4 = ViewBindings.findChildViewById(r12, 2131363101);
        if (r4 == null) goto L21;
        r13 = 2131385326;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131385326)) == null) goto L21;
        r13 = 2131385327;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r12, 2131385327);
        if (r5 == null) goto L21;
        r13 = 2131385505;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131385505)) == null) goto L21;
        r13 = 2131385509;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r12, 2131385509);
        if (r6 == null) goto L21;
        r13 = 2131388772;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L21;
        ?? r14 = (RoundConstraintLayout) r12;
        this.e = new LarusDoraDialogNlApplistBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
