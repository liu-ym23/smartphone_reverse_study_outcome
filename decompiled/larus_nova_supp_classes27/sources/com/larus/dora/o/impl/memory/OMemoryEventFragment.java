package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.gson.Gson;
import com.larus.common_ui.refresh.RefreshHeaderLayout;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.o.impl.databinding.DoraOFragmentMemoryEventBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryEventFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentMemoryEventBinding;", "viewModel", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/o/impl/memory/OMemoryEventAdapter;", "deletePopover", "Lcom/obric/oui/popover/v2/OPopover;", "detailLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "gson", "Lcom/google/gson/Gson;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupList", "setupRefresh", "observeViewModel", "renderState", "state", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel$ListState;", "openDetail", "event", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "showDeleteMenu", "anchor", "confirmDelete", "onDestroyView", "autoLogEnterPage", "", "getCurrentPageName", "", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryEventFragment extends TraceFragment {
    public static final /* synthetic */ int k = 0;
    public DoraOFragmentMemoryEventBinding e;
    public final Lazy f;
    public OMemoryEventAdapter g;
    public com.obric.oui.popover.v2.c h;
    public ActivityResultLauncher<Intent> i;
    public final Gson j;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_g_event_list";
    }

    public final OMemoryEventViewModel U90() {
        return (OMemoryEventViewModel) this.f.getValue();
    }

    public OMemoryEventFragment() {
        final Function0<Fragment> r0 = new OMemoryEventFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OMemoryEventViewModel.class), new OMemoryEventFragment$special$$inlined$viewModels$default$2(r0), new OMemoryEventFragment$special$$inlined$viewModels$default$3(r0, this));
        this.j = new Gson();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        com.obric.oui.popover.v2.c r0 = this.h;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.h = null;
        this.g = null;
        this.e = null;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new v(this));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.o.impl.memory.s] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.dora.o.impl.memory.t] */
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        DoraOFragmentMemoryEventBinding r15 = this.e;
        if (r15 == null) goto L6;
        this.g = new OMemoryEventAdapter(new s(this), new t(this));
        U90().setTodayGroupTitle(getString(2131902906));
        U90().setMonthDayGroupTitleProvider(new u(this));
        r15.c.setLayoutManager(new LinearLayoutManager(getContext()));
        r15.c.setAdapter(this.g);
        r15.c.addOnScrollListener(new OMemoryEventFragment$setupList$4(this));
    L6:
        DoraOFragmentMemoryEventBinding r16 = this.e;
        if (r16 == null) goto L13;
        Context r17 = getContext();
        if (r17 == null) goto L13;
        r16.e.setRefreshHeader(new RefreshHeaderLayout(r17));
        r16.e.setOnRefreshListener(new q(this));
        r16.f.setOnClickListener(new r(this));
    L13:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$3(this, null), 3, null);
        U90().refresh();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131560147, r9, false);
        int r12 = 2131379865;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131379865);
        if (r2 == null) goto L15;
        r12 = 2131379867;
        RecyclerView r3 = ViewBindings.findChildViewById(r11, 2131379867);
        if (r3 == null) goto L15;
        r12 = 2131379868;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131379868);
        if (r4 == null) goto L15;
        r12 = 2131379869;
        SuperSwipeRefreshLayout r5 = (SuperSwipeRefreshLayout) ViewBindings.findChildViewById(r11, 2131379869);
        if (r5 == null) goto L15;
        r12 = 2131379870;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131379870);
        if (r6 == null) goto L15;
        OViewPager2FixLayout r13 = (OViewPager2FixLayout) r11;
        this.e = new DoraOFragmentMemoryEventBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
