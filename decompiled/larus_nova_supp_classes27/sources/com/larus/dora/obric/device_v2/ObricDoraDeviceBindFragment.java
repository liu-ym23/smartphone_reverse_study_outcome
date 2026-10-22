package com.larus.dora.obric.device_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.ObricDoraDeviceBindPageBinding;
import com.larus.dora.impl.device_v2.DoraDeviceBindFragment;
import com.larus.utils.e1;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/obric/device_v2/ObricDoraDeviceBindFragment;", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment;", "<init>", "()V", "onboardingDialogCallbacks", "com/larus/dora/obric/device_v2/ObricDoraDeviceBindFragment$onboardingDialogCallbacks$1", "Lcom/larus/dora/obric/device_v2/ObricDoraDeviceBindFragment$onboardingDialogCallbacks$1;", "createPageBinding", "Lcom/larus/dora/impl/device_v2/DoraDeviceBindFragment$DeviceBindPageBinding;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "isObricGProduct", "", "Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingDialogFragmentV2;", "Companion", "ObricDeviceBindPageBinding", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraDeviceBindFragment extends DoraDeviceBindFragment {
    public static final /* synthetic */ int v = 0;
    public final ObricDoraDeviceBindFragment$onboardingDialogCallbacks$1 u;

    public static final class a {
    }

    public static final class b implements DoraDeviceBindFragment.c {
        public final ObricDoraDeviceBindPageBinding a;

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView b() {
            return this.a.f;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final SimpleDraweeView d() {
            return this.a.e;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final TextView e() {
            return this.a.g;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View f() {
            return this.a.c;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final View getRoot() {
            return this.a.a;
        }

        public b(ObricDoraDeviceBindPageBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            this.a = r2;
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.c.setText(r2);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void c(final com.larus.dora.impl.device_v2.j r3) {
            Intrinsics.checkNotNullParameter(r3, "onBackClick");
            this.a.d.setVisibility(0);
            OFloatingTitleBar.k(this.a.d, new com.larus.dora.obric.device_v2.a(r3), 2);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void g(final com.larus.dora.impl.device_v2.s r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            e1.d(this.a.b, new c(r3));
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.b.setText(r2);
        }

        @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment.c
        public final void i(final com.larus.dora.impl.device_v2.t r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            e1.d(this.a.c, new com.larus.dora.obric.device_v2.b(r3));
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.obric.device_v2.ObricDoraDeviceBindFragment$onboardingDialogCallbacks$1] */
    public ObricDoraDeviceBindFragment() {
        this.u = new ObricDoraDeviceBindFragment$onboardingDialogCallbacks$1(this);
    }

    @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment
    public final void onDestroyView() {
        getParentFragmentManager().unregisterFragmentLifecycleCallbacks(this.u);
        super.onDestroyView();
    }

    @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment
    public final DoraDeviceBindFragment.c X90(LayoutInflater r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r13 = r11.inflate(2131563983, r12, false);
        int r14 = 2131364656;
        OButton r4 = ViewBindings.findChildViewById(r13, 2131364656);
        if (r4 == null) goto L17;
        r14 = 2131364665;
        OButton r5 = ViewBindings.findChildViewById(r13, 2131364665);
        if (r5 == null) goto L17;
        r14 = 2131368926;
        OFloatingTitleBar r6 = ViewBindings.findChildViewById(r13, 2131368926);
        if (r6 == null) goto L17;
        r14 = 2131376390;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r13, 2131376390);
        if (r7 == null) goto L17;
        r14 = 2131390487;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131390487);
        if (r8 == null) goto L17;
        r14 = 2131391606;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, 2131391606);
        if (r9 == null) goto L17;
        return new b(new ObricDoraDeviceBindPageBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    @Override // com.larus.dora.impl.device_v2.DoraDeviceBindFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.u, false);
        super.onViewCreated(r4, r5);
    }
}
