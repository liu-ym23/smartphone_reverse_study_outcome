package com.obric.assistant.settings.memory;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.impl.databinding.ObricFragmentPersonalContextSettingBinding;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001aH\u0002J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u000eH\u0002J\b\u00108\u001a\u00020$H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentPersonalContextSettingBinding;", "viewModel", "Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isObricOS", "", "adapter", "Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter;", "getAdapter", "()Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingAdapter;", "adapter$delegate", "hasSyncedCloudConfig", "syncCloudConfigJob", "Lkotlinx/coroutines/Job;", "lastNetworkErrorToastElapsed", "", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "syncCloudConfigIfNeeded", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "", "initRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observeUiState", "initTopBar", "topBar", "handleSwitchChanged", "row", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;", "isChecked", "handleSwitchResult", WindowEvent.WindowOpenPerfResult.SUCCESS, "showNetworkErrorToast", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReferenceMemorySettingFragment extends TraceFragment implements com.obric.assistant.settings.t {
    public static final /* synthetic */ int l = 0;
    public ObricFragmentPersonalContextSettingBinding e;
    public final Lazy f;
    public final boolean g;
    public final Lazy h;
    public boolean i;
    public Job j;
    public long k;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_reference_memory_setting";
    }

    public final ObricReferenceMemorySettingViewModel V90() {
        return (ObricReferenceMemorySettingViewModel) this.f.getValue();
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.g == true) goto L5;
        return null;
    L5:
        ObricFragmentPersonalContextSettingBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.c;
    }

    public final void onDestroyView() {
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.j = null;
        ObricFragmentPersonalContextSettingBinding r1 = this.e;
        if (r1 == null) goto L10;
        RecyclerView r2 = r1.b;
        if (r2 == null) goto L10;
        r2.setAdapter(null);
    L10:
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public ObricReferenceMemorySettingFragment() {
        final Function0<Fragment> r0 = new ObricReferenceMemorySettingFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricReferenceMemorySettingViewModel.class), new ObricReferenceMemorySettingFragment$special$$inlined$viewModels$default$2(r0), new ObricReferenceMemorySettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = t9a.b.a().b();
        this.h = LazyKt.lazy(new d0(this));
    }

    public final void onResume() {
        super.onResume();
        V90().refresh();
        if (this.i == true) goto L14;
        Job r0 = this.j;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L15;
        this.i = true;
        this.j = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricReferenceMemorySettingFragment$syncCloudConfigIfNeeded$1(this, null), 3, null);
        return;
    L15:
        return;
    L7:
        if (r0.isActive() != true) goto L9;
        r1 = true;
        goto L10
    }

    public static final void U90(ObricReferenceMemorySettingFragment r6, boolean r7) {
        r6.getClass();
        if (r7 == true) goto L11;
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - r6.k) < 3000) goto L13;
        r6.k = r0;
        FragmentActivity r8 = r6.getActivity();
        if (r8 == null) goto L12;
        Handler r1 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r8, r6.getString(2131908080));
        return;
    L12:
        return;
    L13:
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        ObricFragmentPersonalContextSettingBinding r12 = this.e;
        if (r12 == null) goto L22;
        OFloatingTitleBar r13 = r12.c;
        if (r13 != null) goto L8;
        return;
    L8:
        if (this.g == true) goto L10;
        NovaTitleBarEx r2 = rda.a.b(r13);
        NovaTitleBarEx.Y5(r2, getString(2131912558), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new b0(this), 14);
    L11:
        ObricFragmentPersonalContextSettingBinding r14 = this.e;
        if (r14 == null) goto L23;
        RecyclerView r15 = r14.b;
        if (r15 == null) goto L25;
        final Context r16 = requireContext();
        r15.setLayoutManager(new ObricReferenceMemorySettingFragment$initRecyclerView$1(r16));
        r15.setAdapter((ObricReferenceMemorySettingAdapter) this.h.getValue());
        if (this.g == true) goto L19;
        int r1 = i5.A();
    L20:
        r15.addItemDecoration(new g0(r1));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricReferenceMemorySettingFragment$observeUiState$1(this, null), 3, null);
        return;
    L19:
        r1 = i5.q();
        goto L20
    L25:
        return;
    L23:
        return;
    L10:
        r13.setCenterTitle(2131912558);
        OFloatingTitleBar.k(r13, new c0(this), 2);
        goto L11
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ObricFragmentPersonalContextSettingBinding r4 = ObricFragmentPersonalContextSettingBinding.a(r1, r2);
        this.e = r4;
        ConstraintLayout r5 = r4.a;
        Intrinsics.checkNotNull(r5);
        r5.setTag(2131377847, this);
        return r5;
    }
}
