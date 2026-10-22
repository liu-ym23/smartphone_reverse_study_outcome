package com.obric.audio.enroll.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.base.BaseFragment;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollTimeoutFragmentBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollTimeoutFragment;", "Lcom/obric/audio/enroll/base/BaseFragment;", "<init>", "()V", "_realBinding", "Lcom/obric/audio/impl/databinding/SvaEnrollTimeoutFragmentBinding;", "binding", "getBinding", "()Lcom/obric/audio/impl/databinding/SvaEnrollTimeoutFragmentBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollTimeoutFragment extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public SvaEnrollTimeoutFragmentBinding e;
    public EnrollViewModel f;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.i("EnrollTimeoutFragment", "onDestroyView ..");
        this.e = null;
    }

    public EnrollTimeoutFragment() {
    }

    @Override // com.obric.audio.enroll.base.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = (EnrollViewModel) new ViewModelProvider(requireActivity()).get(EnrollViewModel.class);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.obric.audio.enroll.ui.fragment.p] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        final ?? r10 = new p(this);
        if (t9a.b.a().b() == true) goto L11;
        EnrollViewModel r11 = this.f;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L8:
        if (Intrinsics.areEqual(r11.getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L11;
        int r12 = rda.a.a;
        SvaEnrollTimeoutFragmentBinding r13 = this.e;
        Intrinsics.checkNotNull(r13);
        NovaTitleBarEx.b6(rda.a.b(r13.c), 2131241477, false, null, null, new r(r10), 14);
    L12:
        SvaEnrollTimeoutFragmentBinding r14 = this.e;
        Intrinsics.checkNotNull(r14);
        r14.b.setOnClickListener(new s(this));
        return;
    L11:
        SvaEnrollTimeoutFragmentBinding r15 = this.e;
        Intrinsics.checkNotNull(r15);
        OFloatingTitleBar.i(r15.c, 2131244127, new q(r10));
        goto L12
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        FLogger.a.i("EnrollTimeoutFragment", "onCreateView ..");
        View r6 = r3.inflate(2131564915, r4, false);
        int r7 = 2131367802;
        if (ViewBindings.findChildViewById(r6, 2131367802) == null) goto L19;
        r7 = 2131367823;
        if (ViewBindings.findChildViewById(r6, 2131367823) == null) goto L19;
        r7 = 2131374718;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131374718)) == null) goto L19;
        r7 = 2131379448;
        if (ViewBindings.findChildViewById(r6, 2131379448) == null) goto L19;
        r7 = 2131384466;
        AppCompatButton r8 = ViewBindings.findChildViewById(r6, 2131384466);
        if (r8 == null) goto L19;
        r7 = 2131388691;
        if (ViewBindings.findChildViewById(r6, 2131388691) == null) goto L19;
        r7 = 2131388807;
        OFloatingTitleBar r0 = ViewBindings.findChildViewById(r6, 2131388807);
        if (r0 == null) goto L19;
        this.e = new SvaEnrollTimeoutFragmentBinding((LinearLayout) r6, r8, r0);
        getLifecycle().addObserver(new AnonymousClass1());
        SvaEnrollTimeoutFragmentBinding r9 = this.e;
        Intrinsics.checkNotNull(r9);
        return r9.a;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
