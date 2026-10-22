package com.larus.avlink.env.diary.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusFragmentDoraEnvObserveDiarySettingsBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/avlink/env/diary/settings/DoraEnvObserveDiarySettingsFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentDoraEnvObserveDiarySettingsBinding;", "viewModel", "Lcom/larus/avlink/env/diary/settings/DoraEnvObserveDiarySettingsViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/settings/DoraEnvObserveDiarySettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "TAG", "", "loadStyleJob", "Lkotlinx/coroutines/Job;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitleBar", "setupViews", "observeViewModel", "loadDiaryStyle", "onResume", "onDestroyView", "autoLogEnterPage", "", "getCurrentPageName", "currentProductId", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiarySettingsFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusFragmentDoraEnvObserveDiarySettingsBinding e;
    public final Lazy f;
    public final String g;
    public Job h;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_g_diary_settings";
    }

    public DoraEnvObserveDiarySettingsFragment() {
        final Function0<Fragment> r0 = new DoraEnvObserveDiarySettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiarySettingsViewModel.class), new DoraEnvObserveDiarySettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraEnvObserveDiarySettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = "DiarySettings";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        ((DoraEnvObserveDiarySettingsViewModel) this.f.getValue()).loadSettings();
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1(this, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.env.diary.settings.b] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusFragmentDoraEnvObserveDiarySettingsBinding r10 = this.e;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.d;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131903912), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new e(this), 14);
    L7:
        LarusFragmentDoraEnvObserveDiarySettingsBinding r11 = this.e;
        if (r11 == null) goto L12;
        ItemTextToggle r12 = r11.b;
        if (r12 == null) goto L12;
        r12.setBackgroundResource(2131239210);
    L12:
        LarusFragmentDoraEnvObserveDiarySettingsBinding r13 = this.e;
        if (r13 == null) goto L17;
        ItemTextArrow r14 = r13.c;
        if (r14 == null) goto L17;
        r14.setBackgroundResource(2131239210);
    L17:
        LarusFragmentDoraEnvObserveDiarySettingsBinding r15 = this.e;
        if (r15 == null) goto L24;
        ItemTextToggle r16 = r15.b;
        if (r16 == null) goto L24;
        CustomSwitchCompat r17 = r16.getToggleView();
        if (r17 == null) goto L24;
        r17.setOnCheckedChangeListener(new c(this));
    L24:
        LarusFragmentDoraEnvObserveDiarySettingsBinding r18 = this.e;
        if (r18 == null) goto L29;
        ItemTextArrow r19 = r18.c;
        if (r19 == null) goto L29;
        r19.setOnClickListener(new d(this));
    L29:
        ((DoraEnvObserveDiarySettingsViewModel) this.f.getValue()).getInsertPhotoEnabled().observe(getViewLifecycleOwner(), new a(new b(this)));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        LinearLayoutCompat r6 = r3.inflate(2131562378, r4, false);
        int r7 = 2131369050;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369050)) == null) goto L24;
        r7 = 2131369051;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131369051)) == null) goto L24;
        r7 = 2131369052;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369052)) == null) goto L24;
        r7 = 2131369053;
        ItemTextToggle r8 = ViewBindings.findChildViewById(r6, 2131369053);
        if (r8 == null) goto L24;
        r7 = 2131369054;
        if (ViewBindings.findChildViewById(r6, 2131369054) == null) goto L24;
        r7 = 2131369055;
        if (ViewBindings.findChildViewById(r6, 2131369055) == null) goto L24;
        r7 = 2131369056;
        ItemTextArrow r0 = ViewBindings.findChildViewById(r6, 2131369056);
        if (r0 == null) goto L24;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L24;
        LinearLayoutCompat r9 = r6;
        this.e = new LarusFragmentDoraEnvObserveDiarySettingsBinding(r9, r8, r0, r1);
        if (r9 == null) goto L22;
        return r9;
    L22:
        return new View(getContext());
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
