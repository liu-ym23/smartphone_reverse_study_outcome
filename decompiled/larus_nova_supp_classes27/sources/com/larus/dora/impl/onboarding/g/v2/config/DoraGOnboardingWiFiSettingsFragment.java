package com.larus.dora.impl.onboarding.g.v2.config;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraPageWifiSettingsBinding;
import com.larus.dora.impl.wlan.wifi.DoraWifiHeaderAdapter;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingWiFiSettingsFragment;", "Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingBaseNoSkipFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageWifiSettingsBinding;", "wifiScanLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "getCurrentPageName", "", "onLinkState", "state", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingWiFiSettingsFragment extends DoraGOnboardingBaseNoSkipFragment {
    public static final /* synthetic */ int u = 0;
    public LarusDoraPageWifiSettingsBinding s;
    public ActivityResultLauncher<Intent> t;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "join_wifi";
    }

    public DoraGOnboardingWiFiSettingsFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingBaseNoSkipFragment, e69.a
    public final void jL(boolean r10) {
        Job r0 = this.o;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == true) goto L7;
        this.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGOnboardingWiFiSettingsFragment$onLinkState$1(this, null), 3, null);
        return;
    L7:
        ea0();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.t = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g(this));
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingBaseNoSkipFragment, com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        LarusDoraPageWifiSettingsBinding r7 = this.s;
        if (r7 == null) goto L6;
        e1.q(r7.f);
        e1.o(r7.d);
        RecyclerView r8 = r7.e;
        r8.setAdapter(new ConcatAdapter(new RecyclerView.Adapter[]{new DoraWifiHeaderAdapter()}));
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext()));
        LarusDoraGOnboardingBottomBtnLayoutBinding r9 = r7.b;
        e1.x(r9.c);
        e1.o(r9.f);
        e1.x(r9.e);
        e1.d(r9.b, new e(this));
        AppCompatTextView r10 = r9.d;
        int r0 = j0.a;
        r10.setText(j0.d(2131904070));
        e1.d(r7.b.d, new f(this));
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraPageWifiSettingsBinding r4 = LarusDoraPageWifiSettingsBinding.a(r1, r2);
        this.s = r4;
        return r4.a;
    }
}
