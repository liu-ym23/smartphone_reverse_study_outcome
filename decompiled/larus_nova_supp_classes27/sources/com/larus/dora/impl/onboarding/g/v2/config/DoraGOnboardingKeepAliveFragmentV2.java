package com.larus.dora.impl.onboarding.g.v2.config;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingKeepAliveV2Binding;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingKeepAliveFragmentV2;", "Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingBaseNoSkipFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingKeepAliveV2Binding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "getCurrentPageName", "", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingKeepAliveFragmentV2 extends DoraGOnboardingBaseNoSkipFragment {
    public static final /* synthetic */ int t = 0;
    public LarusDoraGOnboardingKeepAliveV2Binding s;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "launch_cdm";
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.s = null;
    }

    public DoraGOnboardingKeepAliveFragmentV2() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    @Override // com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingBaseNoSkipFragment, com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LarusDoraGOnboardingKeepAliveV2Binding r4 = this.s;
        if (r4 == null) goto L6;
        LarusDoraGOnboardingBottomBtnLayoutBinding r5 = r4.b;
        e1.x(r5.c);
        final ?? r6 = r5.d;
        int r0 = j0.a;
        r6.setText(j0.d(2131903738));
        e1.d(r6, new c(r6, this));
        e1.o(r5.f);
        e1.x(r5.e);
        e1.d(r5.b, new d(this));
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562198, r4, false);
        ConstraintLayout r7 = r6;
        int r8 = 2131369595;
        View r0 = ViewBindings.findChildViewById(r6, 2131369595);
        if (r0 == null) goto L10;
        LarusDoraGOnboardingBottomBtnLayoutBinding r9 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r0);
        if (((ScrollView) ViewBindings.findChildViewById(r6, 2131369899)) == null) goto L8;
        this.s = new LarusDoraGOnboardingKeepAliveV2Binding(r7, r9);
        return r7;
    L8:
        r8 = 2131369899;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r8)));
    }
}
