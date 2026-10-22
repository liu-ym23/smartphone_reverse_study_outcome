package com.larus.dora.o.impl.memory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.o.impl.databinding.DoraOFragmentMemoryPersonalBinding;
import com.larus.trace.tracknode.TraceFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryPersonalFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentMemoryPersonalBinding;", "viewModel", "Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/o/impl/memory/OMemoryPersonalAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "observeViewModel", "renderState", "state", "Lcom/larus/dora/o/impl/memory/OMemoryPersonalViewModel$ListState;", "openAddSheet", "openEditSheet", "entry", "Lcom/larus/dora/o/impl/memory/OPersonalMemoryEntry;", "confirmDelete", "onDestroyView", "autoLogEnterPage", "", "getCurrentPageName", "", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryPersonalFragment extends TraceFragment {
    public static final /* synthetic */ int h = 0;
    public DoraOFragmentMemoryPersonalBinding e;
    public final Lazy f;
    public OMemoryPersonalAdapter g;

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "personal_memory_fragment";
    }

    public final OMemoryPersonalViewModel U90() {
        return (OMemoryPersonalViewModel) this.f.getValue();
    }

    public OMemoryPersonalFragment() {
        final Function0<Fragment> r0 = new OMemoryPersonalFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OMemoryPersonalViewModel.class), new OMemoryPersonalFragment$special$$inlined$viewModels$default$2(r0), new OMemoryPersonalFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        if ((U90().getListState().getValue() instanceof OMemoryPersonalViewModel.a.b) == false) goto L6;
        U90().loadData();
        return;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.dora.o.impl.memory.g0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.dora.o.impl.memory.h0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.o.impl.memory.i0] */
    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r21, r22);
        DoraOFragmentMemoryPersonalBinding r1 = this.e;
        if (r1 != null) goto L5;
        return;
    L5:
        OMemoryPersonalAdapter r2 = new OMemoryPersonalAdapter(new g0(this), new h0(this), new i0(this));
        List<String> r3 = CollectionsKt.listOf(getString(2131903464));
        Intrinsics.checkNotNullParameter(r3, "texts");
        r2.e = r3;
        this.g = r2;
        r1.d.setLayoutManager(new LinearLayoutManager(getContext()));
        r1.d.setAdapter(this.g);
        r1.f.setOnClickListener(new j0(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryPersonalFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryPersonalFragment$observeViewModel$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryPersonalFragment$observeViewModel$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryPersonalFragment$observeViewModel$4(this, null), 3, null);
        U90().loadData();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131560148, r9, false);
        int r12 = 2131379881;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131379881);
        if (r2 == null) goto L15;
        r12 = 2131379883;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131379883);
        if (r3 == null) goto L15;
        r12 = 2131379884;
        RecyclerView r4 = ViewBindings.findChildViewById(r11, 2131379884);
        if (r4 == null) goto L15;
        r12 = 2131379885;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131379885);
        if (r5 == null) goto L15;
        r12 = 2131379886;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131379886);
        if (r6 == null) goto L15;
        OViewPager2FixLayout r13 = (OViewPager2FixLayout) r11;
        this.e = new DoraOFragmentMemoryPersonalBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
