package com.obric.assistant.settings.lockeduse;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.impl.databinding.ObricFragmentLockedUseManagementBinding;
import com.obric.assistant.settings.t;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010!\u001a\u00020\u001fH\u0017J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u001fH\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "autoLogEnterPage", "", "getCurrentPageName", "", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentLockedUseManagementBinding;", "viewModel", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isObricOS", "adapter", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initTopBar", "topBar", "observeUiState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLockedUseManagementFragment extends TraceFragment implements t {
    public static final /* synthetic */ int i = 0;
    public ObricFragmentLockedUseManagementBinding e;
    public final Lazy f;
    public final boolean g;
    public final ObricLockedUseManagementAdapter h;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_locked_use_management_fragment";
    }

    public final void onDestroyView() {
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.g == true) goto L5;
        return null;
    L5:
        ObricFragmentLockedUseManagementBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.c;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.settings.lockeduse.h] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.settings.lockeduse.i] */
    public ObricLockedUseManagementFragment() {
        final Function0<Fragment> r0 = new ObricLockedUseManagementFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricLockedUseManagementViewModel.class), new ObricLockedUseManagementFragment$special$$inlined$viewModels$default$2(r0), new ObricLockedUseManagementFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = t9a.b.a().b();
        this.h = new ObricLockedUseManagementAdapter(new h(this), new i(this));
    }

    public final void onResume() {
        super.onResume();
        ((ObricLockedUseManagementViewModel) this.f.getValue()).refresh();
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ObricFragmentLockedUseManagementBinding r12 = this.e;
        if (r12 != null) goto L5;
        return;
    L5:
        RecyclerView r13 = r12.b;
        final Context r0 = requireContext();
        r13.setLayoutManager(new AnonymousClass1(r0));
        r12.b.setAdapter(this.h);
        RecyclerView r14 = r12.b;
        if (this.g == true) goto L8;
        int r1 = i5.A();
    L9:
        r14.addItemDecoration(new n(r1));
        OFloatingTitleBar r15 = r12.c;
        if (this.g == true) goto L12;
        NovaTitleBarEx r2 = rda.a.b(r15);
        NovaTitleBarEx.Y5(r2, getString(2131912564), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new j(this), 14);
    L13:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricLockedUseManagementFragment$observeUiState$1(this, null), 3, null);
        return;
    L12:
        r15.setCenterTitle(2131912564);
        OFloatingTitleBar.k(r15, new k(this), 2);
        goto L13
    L8:
        r1 = i5.q();
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131564002, r3, false);
        int r6 = 2131384076;
        RecyclerView r7 = ViewBindings.findChildViewById(r5, 2131384076);
        if (r7 == null) goto L9;
        r6 = 2131389118;
        OFloatingTitleBar r0 = ViewBindings.findChildViewById(r5, 2131389118);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.e = new ObricFragmentLockedUseManagementBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
