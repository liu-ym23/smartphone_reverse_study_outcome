package com.obric.assistant.settings.autogui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "isObricOS", "", "viewModel", "Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/autogui/ObricAutoExecuteAuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "topBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "doubaoTitleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "adapter", "Lcom/obric/assistant/settings/autogui/AuthorizationAdapter;", "getAdapter", "()Lcom/obric/assistant/settings/autogui/AuthorizationAdapter;", "adapter$delegate", "getFloatingTitleBar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initRecyclerView", "initTopBar", "observeUiState", "updateTitle", "title", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoExecuteAuthFragment extends Fragment implements com.obric.assistant.settings.t {
    public static final /* synthetic */ int i = 0;
    public final boolean d;
    public final Lazy e;
    public OFloatingTitleBar f;
    public NovaTitleBarEx g;
    public final Lazy h;

    public final void onDestroyView() {
        this.f = null;
        this.g = null;
        super.onDestroyView();
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.d == true) goto L7;
        return null;
    L7:
        return this.f;
    }

    public ObricAutoExecuteAuthFragment() {
        this.d = t9a.b.a().b();
        final Function0<Fragment> r0 = new ObricAutoExecuteAuthFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricAutoExecuteAuthViewModel.class), new ObricAutoExecuteAuthFragment$special$$inlined$viewModels$default$2(r0), new ObricAutoExecuteAuthFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = LazyKt.lazy(new g(this));
    }

    public final void onResume() {
        super.onResume();
        ((ObricAutoExecuteAuthViewModel) this.e.getValue()).refresh();
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        this.f = r10.findViewById(2131389118);
        RecyclerView r12 = r10.findViewById(2131384076);
        if (r12 == null) goto L6;
        r12.setAdapter((AuthorizationAdapter) this.h.getValue());
    L6:
        OFloatingTitleBar r13 = this.f;
        if (r13 != null) goto L10;
    L13:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricAutoExecuteAuthFragment$observeUiState$1(this, null), 3, null);
        return;
    L10:
        if (this.d == false) goto L12;
        r13.setVisibility(0);
        r13.setCenterTitle(getString(2131912438));
        OFloatingTitleBar.k(r13, new e(this), 2);
        goto L13
    L12:
        NovaTitleBarEx r14 = rda.a.b(r13);
        r14.setVisibility(0);
        NovaTitleBarEx.Y5(r14, getString(2131912438), null, null, 6);
        NovaTitleBarEx.b6(r14, 2131241477, false, null, null, new f(this), 14);
        this.g = r14;
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563995, r3, false);
    }
}
