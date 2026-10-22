package com.larus.dora.impl.device.settings.lab.env;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.env.timer.TimerDialogFragment;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mEnvObserveCheckListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mEnvObserveTimerCheckListener", "mEnvObserveLightCheckListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleState", "envState", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState;", "showDialog", "type", "", "timeText", "state", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveState$State;", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvObserveFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraGEnvObserveBinding f;
    public final Lazy g;
    public t h;
    public u i;
    public w j;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ EnvObserveFragment a;

        public b(EnvObserveFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            y r8 = (y) r6;
            final EnvObserveFragment r9 = this.a;
            int r0 = EnvObserveFragment.k;
            r9.getClass();
            if (Intrinsics.areEqual(r8, y.a.a) == false) goto L5;
            g49.d.d("EnvObserveFragment", "env observe state is empty, return");
        L77:
            return Unit.INSTANCE;
        L5:
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.env.EnvObserveState.State");
            y.b r10 = (y.b) r8;
            g49.d.d("EnvObserveFragment", "env enable: " + r10.a + ", time enable: " + r10.b + ", start time: " + r10.c + ", end time: " + r10.d);
            LarusDoraGEnvObserveBinding r1 = r9.f;
            if (r1 == null) goto L10;
            ItemGroupTitle r2 = r1.e;
            if (r2 == null) goto L10;
            e1.y(r2, r10.a);
        L10:
            LarusDoraGEnvObserveBinding r3 = r9.f;
            if (r3 == null) goto L15;
            ItemGroup r4 = r3.d;
            if (r4 == null) goto L15;
            e1.y(r4, r10.a);
        L15:
            LarusDoraGEnvObserveBinding r5 = r9.f;
            if (r5 == null) goto L20;
            ItemGroupTitle r11 = r5.b;
            if (r11 == null) goto L20;
            e1.y(r11, r10.a);
        L20:
            LarusDoraGEnvObserveBinding r12 = r9.f;
            if (r12 == null) goto L25;
            ItemTextToggle r13 = r12.c;
            if (r13 == null) goto L25;
            e1.y(r13, r10.a);
        L25:
            LarusDoraGEnvObserveBinding r14 = r9.f;
            if (r14 == null) goto L30;
            ItemTextArrow r15 = r14.g;
            if (r15 == null) goto L30;
            e1.y(r15, r10.b);
        L30:
            LarusDoraGEnvObserveBinding r16 = r9.f;
            if (r16 == null) goto L36;
            ItemTextArrow r17 = r16.f;
            if (r17 == null) goto L36;
            e1.y(r17, r10.b);
        L36:
            if (r10.b == false) goto L52;
            LarusDoraGEnvObserveBinding r18 = r9.f;
            if (r18 == null) goto L47;
            ItemTextArrow r20 = r18.g;
            if (r20 == null) goto L47;
            r20.setOnClickListener(new q(r9));
            r20.getSubTextView().setText(r9.Y90(EnvObserveViewModel.START_TIME_SET, r10));
            LarusDoraGEnvObserveBinding r21 = r9.f;
            if (r21 == null) goto L46;
            ItemTextArrow r22 = r21.f;
            if (r22 == null) goto L46;
            r22.getSubTextView().setText(r9.Y90(EnvObserveViewModel.END_TIME_SET, r10));
        L46:
            r20.setVisible(true);
        L47:
            LarusDoraGEnvObserveBinding r23 = r9.f;
            if (r23 == null) goto L52;
            ItemTextArrow r24 = r23.f;
            if (r24 == null) goto L52;
            r24.setOnClickListener(new r(r9));
            r24.getSubTextView().setText(r9.Y90(EnvObserveViewModel.END_TIME_SET, r10));
            r24.setVisible(true);
        L52:
            LarusDoraGEnvObserveBinding r25 = r9.f;
            if (r25 == null) goto L59;
            ItemTextToggle r26 = r25.i;
            if (r26 == null) goto L59;
            CustomSwitchCompat r27 = r26.getToggleView();
            if (r27 == null) goto L59;
            r27.setOnCheckedChangeListener(null);
            r27.setChecked(r10.a);
            r27.setOnCheckedChangeListener(r9.h);
        L59:
            LarusDoraGEnvObserveBinding r28 = r9.f;
            if (r28 == null) goto L66;
            ItemTextToggle r30 = r28.h;
            if (r30 == null) goto L66;
            CustomSwitchCompat r31 = r30.getToggleView();
            if (r31 == null) goto L66;
            r31.setOnCheckedChangeListener(null);
            r31.setChecked(r10.b);
            r31.setOnCheckedChangeListener(r9.i);
        L66:
            LarusDoraGEnvObserveBinding r32 = r9.f;
            if (r32 == null) goto L74;
            ItemTextToggle r33 = r32.c;
            if (r33 == null) goto L74;
            CustomSwitchCompat r34 = r33.getToggleView();
            if (r34 == null) goto L74;
            r34.setOnCheckedChangeListener(null);
            r34.setChecked(r10.e);
            r34.setOnCheckedChangeListener(r9.j);
        L74:
            if (r10.f == true) goto L77;
            t19.s r35 = t19.s.a;
            Context r36 = r9.getContext();
            String r37 = r9.getString(2131903992);
            r35.getClass();
            t19.s.c(r36, r37);
            goto L77
        }
    }

    static {
    }

    public final String k() {
        return "env_observe";
    }

    public final EnvObserveViewModel W90() {
        return (EnvObserveViewModel) this.g.getValue();
    }

    public EnvObserveFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvObserveViewModel.class), new EnvObserveFragment$special$$inlined$activityViewModels$default$1(this), new EnvObserveFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void X90(String r7) {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L13;
        TimerDialogFragment r1 = new TimerDialogFragment();
        Intrinsics.checkNotNullParameter(r7, "type");
        r1.f = r7;
        List<Integer> r2 = W90().startTimerInt();
        List<Integer> r3 = W90().endTimerInt();
        Intrinsics.checkNotNullParameter(r2, "startTime");
        Intrinsics.checkNotNullParameter(r3, "endTimer");
        r1.g = ((Number) ListProtector.get(r2, 0)).intValue();
        r1.h = ((Number) ListProtector.get(r2, 1)).intValue();
        r1.i = ((Number) ListProtector.get(r3, 0)).intValue();
        r1.j = ((Number) ListProtector.get(r3, 1)).intValue();
        FragmentManager r4 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r7, r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r1, r5) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        r1.show(r4, r7);
        return;
    L14:
        return;
    }

    public final String Y90(String r9, y.b r10) {
        if (Intrinsics.areEqual(r9, EnvObserveViewModel.START_TIME_SET) == true) goto L14;
        List r1 = StringsKt.split$default(r10.c, new String[]{":"}, false, 0, 6, null);
        List r11 = StringsKt.split$default(r10.d, new String[]{":"}, false, 0, 6, null);
        String r2 = getString(2131902555);
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r11, 0)) <= CastIntegerProtector.parseInt((String) ListProtector.get(r1, 0))) goto L8;
    L11:
        r2 = getString(2131902556);
    L13:
        return r2 + ' ' + r10.d;
    L8:
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r11, 0)) != CastIntegerProtector.parseInt((String) ListProtector.get(r1, 0))) goto L13;
        if (CastIntegerProtector.parseInt((String) ListProtector.get(r11, 1)) <= CastIntegerProtector.parseInt((String) ListProtector.get(r1, 1))) goto L13;
    L14:
        return getString(2131902553) + ' ' + r10.c;
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.dora.impl.device.settings.lab.env.t] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.larus.dora.impl.device.settings.lab.env.u] */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.larus.dora.impl.device.settings.lab.env.w] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraGEnvObserveBinding r10 = this.f;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.k;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131903342), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new s(this), 14);
    L7:
        EnvObserveViewModel r11 = W90();
        Bundle r1 = getArguments();
        if (r1 == null) goto L10;
        String r2 = r1.getString("mac");
    L11:
        r11.updateCurrentDoraDeviceMac(r2);
        this.h = new t(this);
        this.i = new u(this);
        LarusDoraGEnvObserveBinding r12 = this.f;
        if (r12 == null) goto L16;
        final ItemTextArrow r13 = r12.j;
        if (r13 == null) goto L16;
        e1.d(r13, new v(r13));
    L16:
        this.j = new w(this);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new EnvObserveFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131562188, r14, false);
        int r17 = 2131369568;
        ItemGroupTitle r2 = ViewBindings.findChildViewById(r16, 2131369568);
        if (r2 == null) goto L27;
        r17 = 2131369569;
        ItemTextToggle r3 = ViewBindings.findChildViewById(r16, 2131369569);
        if (r3 == null) goto L27;
        r17 = 2131369570;
        ItemGroup r4 = ViewBindings.findChildViewById(r16, 2131369570);
        if (r4 == null) goto L27;
        r17 = 2131369571;
        ItemGroupTitle r5 = ViewBindings.findChildViewById(r16, 2131369571);
        if (r5 == null) goto L27;
        r17 = 2131369572;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r16, 2131369572);
        if (r6 == null) goto L27;
        r17 = 2131369573;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r16, 2131369573);
        if (r7 == null) goto L27;
        r17 = 2131369574;
        ItemTextToggle r8 = ViewBindings.findChildViewById(r16, 2131369574);
        if (r8 == null) goto L27;
        r17 = 2131369579;
        ItemTextToggle r9 = ViewBindings.findChildViewById(r16, 2131369579);
        if (r9 == null) goto L27;
        r17 = 2131369580;
        if (ViewBindings.findChildViewById(r16, 2131369580) == null) goto L27;
        r17 = 2131369587;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r16, 2131369587);
        if (r10 == null) goto L27;
        r17 = 2131388772;
        NovaTitleBarEx r11 = ViewBindings.findChildViewById(r16, 2131388772);
        if (r11 == null) goto L27;
        ConstraintLayout r18 = r16;
        this.f = new LarusDoraGEnvObserveBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return r18;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
