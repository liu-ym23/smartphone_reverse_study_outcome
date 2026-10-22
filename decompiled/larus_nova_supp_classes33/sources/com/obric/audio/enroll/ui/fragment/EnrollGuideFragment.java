package com.obric.audio.enroll.ui.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.base.BaseFragment;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollGuideFragmentBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollGuideFragment;", "Lcom/obric/audio/enroll/base/BaseFragment;", "<init>", "()V", "_realBinding", "Lcom/obric/audio/impl/databinding/SvaEnrollGuideFragmentBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "binding", "getBinding", "()Lcom/obric/audio/impl/databinding/SvaEnrollGuideFragmentBinding;", "drawable", "Landroid/graphics/drawable/Drawable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "onViewCreated", "view", "onDestroyView", "updateRecordButtonEnabled", "enabled", "", "getDrawableFromPackage", "packageName", "", "resourceName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollGuideFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public SvaEnrollGuideFragmentBinding e;
    public EnrollViewModel f;
    public Drawable g;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.i("EnrollGuideFragment", "onDestroyView ..");
        this.e = null;
    }

    public EnrollGuideFragment() {
    }

    @Override // com.obric.audio.enroll.base.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = (EnrollViewModel) new ViewModelProvider(requireActivity()).get(EnrollViewModel.class);
    }

    public final Drawable T90(String r4, String r5) {
        Context r0 = requireContext().createPackageContext(r4, 2);     // Catch: Exception -> L6
        int r6 = r0.getResources().getIdentifier(r5, "drawable", r4);     // Catch: Exception -> L6
        if (r6 == 0) goto L8;
        Configuration r1 = new Configuration(r0.getResources().getConfiguration());     // Catch: Exception -> L6
        r1.uiMode = requireContext().getResources().getConfiguration().uiMode;     // Catch: Exception -> L6
        Context r2 = r0.createConfigurationContext(r1);     // Catch: Exception -> L6
        NewMiraResourcesManager.getInstance().install(r2);     // Catch: Exception -> L6
        return r2.getDrawable(r6);
    L8:
        return null;
    L6:
        e = move-exception;
        FLogger.a.e("EnrollGuideFragment", "Failed to get drawable from ".concat(r4), e);
        goto L8
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        if (ObricEnrollInteropDelegate.b.g() == false) goto L5;
        Drawable r5 = T90("com.android.settings", "obric_guide_voice_enroll_n1");
    L6:
        this.g = r5;
        SvaEnrollGuideFragmentBinding r6 = this.e;
        Intrinsics.checkNotNull(r6);
        r6.d.setImageDrawable(this.g);
        SvaEnrollGuideFragmentBinding r7 = this.e;
        Intrinsics.checkNotNull(r7);
        r7.b.setChecked(false);
        SvaEnrollGuideFragmentBinding r8 = this.e;
        Intrinsics.checkNotNull(r8);
        OButton r9 = r8.i;
        r9.setEnabled(true);
        r9.setAlpha(0.3f);
        SvaEnrollGuideFragmentBinding r10 = this.e;
        Intrinsics.checkNotNull(r10);
        r10.b.setOnCheckedChangeListener(new com.obric.audio.enroll.ui.fragment.a(this));
        SvaEnrollGuideFragmentBinding r11 = this.e;
        Intrinsics.checkNotNull(r11);
        r11.j.setOnClickListener(new b(this));
        SvaEnrollGuideFragmentBinding r12 = this.e;
        Intrinsics.checkNotNull(r12);
        r12.k.setOnClickListener(new c(this));
        SvaEnrollGuideFragmentBinding r13 = this.e;
        Intrinsics.checkNotNull(r13);
        r13.i.setOnClickListener(new d(this));
        SvaEnrollGuideFragmentBinding r14 = this.e;
        Intrinsics.checkNotNull(r14);
        r14.g.setOnClickListener(new e(this));
        FLogger.a.i("EnrollGuideFragment", "onViewCreated..");
        int r15 = com.obric.audio.enroll.f.a;
        SvaEnrollGuideFragmentBinding r16 = this.e;
        Intrinsics.checkNotNull(r16);
        com.obric.audio.enroll.f.a(r16.i, new f());
        SvaEnrollGuideFragmentBinding r17 = this.e;
        Intrinsics.checkNotNull(r17);
        OFloatingTitleBar.i(r17.h, 2131244127, new g(this));
        EnrollViewModel r18 = this.f;
        EnrollViewModel r19 = null;
        if (r18 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L10:
        if (r18.getEnrollDeviceType().getValue() == VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT.getValue()) goto L17;
        SvaEnrollGuideFragmentBinding r20 = this.e;
        Intrinsics.checkNotNull(r20);
        r20.c.setImageResource(2131248324);
        SvaEnrollGuideFragmentBinding r21 = this.e;
        Intrinsics.checkNotNull(r21);
        r21.f.setText(2131914197);
        SvaEnrollGuideFragmentBinding r22 = this.e;
        Intrinsics.checkNotNull(r22);
        TextView r23 = r22.e;
        EnrollViewModel r1 = this.f;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r23.setText(r19.getEnrollDeviceName());
        SvaEnrollGuideFragmentBinding r24 = this.e;
        Intrinsics.checkNotNull(r24);
        r24.i.setText(2131914234);
        SvaEnrollGuideFragmentBinding r25 = this.e;
        Intrinsics.checkNotNull(r25);
        r25.g.setVisibility(4);
        return;
    L14:
        r19 = r1;
        goto L15
    L17:
        return;
    L5:
        r5 = T90("com.larus.nova", "obric_guide_voice_enroll_o");
        goto L6
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        FLogger.a.i("EnrollGuideFragment", "onCreateView ..");
        ConstraintLayout r16 = r13.inflate(2131564912, r14, false);
        int r17 = 2131365658;
        OCheckBoxLayout r2 = (OCheckBoxLayout) ViewBindings.findChildViewById(r16, 2131365658);
        if (r2 == null) goto L33;
        r17 = 2131371675;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r16, 2131371675);
        if (r3 == null) goto L33;
        r17 = 2131371676;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r16, 2131371676);
        if (r4 == null) goto L33;
        r17 = 2131371677;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r16, 2131371677);
        if (r5 == null) goto L33;
        r17 = 2131371678;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r16, 2131371678);
        if (r6 == null) goto L33;
        r17 = 2131373138;
        if (ViewBindings.findChildViewById(r16, 2131373138) == null) goto L33;
        r17 = 2131374360;
        if (ViewBindings.findChildViewById(r16, 2131374360) == null) goto L33;
        r17 = 2131380090;
        if (ViewBindings.findChildViewById(r16, 2131380090) == null) goto L33;
        r17 = 2131386025;
        OButton r7 = (OButton) ViewBindings.findChildViewById(r16, 2131386025);
        if (r7 == null) goto L33;
        r17 = 2131388807;
        OFloatingTitleBar r8 = ViewBindings.findChildViewById(r16, 2131388807);
        if (r8 == null) goto L33;
        r17 = 2131389245;
        if (ViewBindings.findChildViewById(r16, 2131389245) == null) goto L33;
        r17 = 2131392719;
        OButton r9 = (OButton) ViewBindings.findChildViewById(r16, 2131392719);
        if (r9 == null) goto L33;
        r17 = 2131392775;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131392775);
        if (r10 == null) goto L33;
        r17 = 2131392776;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r16, 2131392776);
        if (r11 == null) goto L33;
        this.e = new SvaEnrollGuideFragmentBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        getLifecycle().addObserver(new AnonymousClass1());
        SvaEnrollGuideFragmentBinding r18 = this.e;
        Intrinsics.checkNotNull(r18);
        return r18.a;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
