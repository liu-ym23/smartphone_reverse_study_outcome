package com.larus.dora.impl.onboarding.g.v2.config;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2;
import com.larus.dora.impl.util.u;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0004¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingBaseNoSkipFragment;", "Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingBaseFragmentV2;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onKeyState", "event", "", "pos", "onWearState", "state", "", "onLinkState", "onCallState", "gotoNextConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraGOnboardingBaseNoSkipFragment extends DoraGOnboardingBaseFragmentV2 {
    @Override // e69.a
    public final void Ir(int r1, int r2) {
    }

    @Override // e69.a
    public final void S30(boolean r1) {
    }

    @Override // e69.a
    public void bO(boolean r1) {
    }

    @Override // e69.a
    public void jL(boolean r1) {
    }

    public final void ja0() {
        DoraOnboardingDevice r0 = ga0().getDoraOnboardingDevice();
        if (r0 == null) goto L6;
        String r1 = r0.b;
        if (r1 == null) goto L6;
    L11:
        if ((this instanceof DoraGOnboardingEnvAuthFragment) == false) goto L28;
        if (ca0() == true) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L22;
        DoraGOnboardingWiFiSettingsFragment r3 = new DoraGOnboardingWiFiSettingsFragment();
        r3.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r3);
        return;
    L22:
        if (ca0() == false) goto L25;
        DoraGOnboardingKeepAliveFragmentV2 r4 = new DoraGOnboardingKeepAliveFragmentV2();
        r4.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r4);
        return;
    L25:
        if (r1 == null) goto L37;
        W90(r1);
        return;
    L37:
        return;
    L15:
        if (ga0().hasConfigWiFi() == true) goto L17;
        r2 = true;
        goto L18
    L28:
        if ((this instanceof DoraGOnboardingWiFiSettingsFragment) == true) goto L30;
        boolean r5 = this instanceof DoraGOnboardingKeepAliveFragmentV2;
        return;
    L30:
        if (ca0() == false) goto L33;
        DoraGOnboardingKeepAliveFragmentV2 r6 = new DoraGOnboardingKeepAliveFragmentV2();
        r6.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("mac", r1)}));
        Z90(r6);
        return;
    L33:
        if (r1 == null) goto L39;
        W90(r1);
        return;
    L39:
        return;
    L6:
        Bundle r7 = getArguments();
        if (r7 == null) goto L9;
        r1 = r7.getString("mac");
        goto L11
    L9:
        r1 = null;
        goto L11
    }

    public DoraGOnboardingBaseNoSkipFragment() {
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        TextView r6 = this.j;
        if (r6 == null) goto L5;
        e1.o(r6);
    L5:
        ga0().exitOnboarding();
        TextView r7 = (TextView) r4.findViewById(2131369594);
        if (r7 == null) goto L9;
        r7.setTextColor(ContextCompat.getColor(r7.getContext(), v19.c.b(2130972312, r7.getContext(), 2131103298)));
        r7.setBackgroundResource(u.a.a("larus_dora_g_onboarding_next_btn_bg"));
        return;
    }
}
