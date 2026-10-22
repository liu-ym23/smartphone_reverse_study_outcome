package com.larus.dora.impl.onboarding.othersmart.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveOldBinding;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/archive/DoraExternalOnboardingKeepAliveFragmentOld;", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingV2KeepAliveOldBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "shouldShowSkipButton", "", "getCurrentPageName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraExternalOnboardingKeepAliveFragmentOld extends DoraLiteOnboardingBaseFragment {
    public static final /* synthetic */ int p = 0;
    public LarusDoraOnboardingV2KeepAliveOldBinding o;

    @Override // com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    public final String k() {
        return "keep_active";
    }

    public DoraExternalOnboardingKeepAliveFragmentOld() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ca0().exitOnboardingMode();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        final TextView r4 = this.h;
        if (r4 == null) goto L5;
        e1.x(r4);
        r4.setText(2131903738);
        e1.d(r4, new a(this, r4));
    L5:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L10;
        View r6 = r5.findViewById(2131369901);
        if (r6 == null) goto L10;
        e1.x(r6);
        e1.d(r6, new b(this));
    L10:
        LarusDoraOnboardingV2KeepAliveOldBinding r7 = this.o;
        if (r7 == null) goto L16;
        DoraUrlSpanTextView r8 = r7.b;
        if (r8 == null) goto L17;
        int r9 = j0.a;
        r8.setUrlSpannedText(j0.d(2131903752));
        return;
    L17:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraOnboardingV2KeepAliveOldBinding r4 = LarusDoraOnboardingV2KeepAliveOldBinding.a(r1, r2);
        this.o = r4;
        return r4.a;
    }
}
