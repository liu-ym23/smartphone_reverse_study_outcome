package com.larus.dora.impl.device.settings.lab.env.timer;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveTimerDialogBinding;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.ReelPicker$HeightMode;
import com.larus.dora.impl.device.settings.lab.env.y;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\rJ\"\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$J(\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/TimerDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveTimerDialogBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/env/EnvObserveViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mType", "", "startHour", "", "startMin", "endHour", "endMin", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "getTheme", "onViewCreated", "view", "setFrom", "type", "setTimer", "startTime", "", "endTimer", "buildPicker", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/Picker;", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/pickers/ReelPickerTimeLength$TimeLength;", "context", "Landroid/content/Context;", "listener", "Ljava/util/function/Consumer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimerDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraGEnvObserveTimerDialogBinding d;
    public final Lazy e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ TimerDialogFragment a;

        public b(TimerDialogFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            y r13 = (y) r11;
            if ((r13 instanceof y.a) == true) goto L10;
            if ((r13 instanceof y.b) == false) goto L8;
            y.b r14 = (y.b) r13;
            List r0 = StringsKt.split$default(r14.c, new String[]{":"}, false, 0, 6, null);
            this.a.g = CastIntegerProtector.parseInt((String) ListProtector.get(r0, 0));
            this.a.h = CastIntegerProtector.parseInt((String) ListProtector.get(r0, 1));
            List r15 = StringsKt.split$default(r14.d, new String[]{":"}, false, 0, 6, null);
            this.a.i = CastIntegerProtector.parseInt((String) ListProtector.get(r15, 0));
            this.a.j = CastIntegerProtector.parseInt((String) ListProtector.get(r15, 1));
            g49.d.d("TimerDialogFragment", "env observe new time state: " + this.a.g + ':' + this.a.h + " - " + this.a.i + ':' + this.a.j);
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951934;
    }

    public TimerDialogFragment() {
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvObserveViewModel.class), new TimerDialogFragment$special$$inlined$activityViewModels$default$1(this), new TimerDialogFragment$special$$inlined$activityViewModels$default$2(this));
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        r0.findViewById(2131389274).setOnClickListener(new e(this));
        return;
    }

    public static void S90(TimerDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        BottomSheetDialog r11 = getDialog();
        if ((r11 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r12 = r11;
    L6:
        if (r12 == null) goto L8;
        View r13 = r12.findViewById(2131368870);
    L9:
        int r14 = m0.a;
        int r15 = m0.a(getContext());
        i0.a.getClass();
        int r16 = ((r15 - i0.g()) - i0.e()) - i5.c0();
        if (r13 == null) goto L12;
        r13.setLayoutParams(r13.getLayoutParams());
        BottomSheetBehavior r1 = BottomSheetBehavior.from(r13);
        r13.setBackgroundResource(R.color.transparent);
        r1.setState(3);
        r1.setPeekHeight(r16);
    L12:
        LarusDoraGEnvObserveTimerDialogBinding r17 = this.d;
        if (r17 == null) goto L21;
        AppCompatTextView r18 = r17.e;
        if (r18 == null) goto L21;
        if (Intrinsics.areEqual(this.f, EnvObserveViewModel.START_TIME_SET) == false) goto L19;
        CharSequence r2 = getString(2131902557);
    L20:
        r18.setText(r2);
        goto L21
    L19:
        r2 = getString(2131902554);
    L21:
        Context r20 = getContext();
        Consumer<u49.a.b> r3 = new com.larus.dora.impl.device.settings.lab.env.timer.b(this);
        if (r20 != null) goto L25;
        u49.a r21 = null;
    L29:
        LarusDoraGEnvObserveTimerDialogBinding r110 = this.d;
        if (r110 == null) goto L37;
        LinearLayout r111 = r110.f;
        if (r111 == null) goto L37;
        if (r21 == null) goto L35;
        ConstraintLayout r22 = r21.asView();
    L36:
        r111.addView(r22);
        goto L37
    L35:
        r22 = null;
    L37:
        LarusDoraGEnvObserveTimerDialogBinding r23 = this.d;
        if (r23 == null) goto L42;
        AppCompatTextView r24 = r23.b;
        if (r24 == null) goto L42;
        r24.setOnClickListener(new c(this));
    L42:
        LarusDoraGEnvObserveTimerDialogBinding r25 = this.d;
        if (r25 == null) goto L47;
        AppCompatTextView r26 = r25.c;
        if (r26 == null) goto L47;
        r26.setOnClickListener(new d(this));
    L47:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TimerDialogFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L25:
        if (Intrinsics.areEqual(this.f, EnvObserveViewModel.START_TIME_SET) == false) goto L27;
        int r112 = this.g;
        int r4 = this.h;
    L28:
        u49.a.C0142a r5 = new u49.a.C0142a();
        r5.a = true;
        u49.a.b r6 = r5.f;
        r6.a = r112;
        u49.a.b r113 = r5.h;
        r113.a = 23;
        u49.a.b r7 = r5.g;
        r7.a = 0;
        r5.b = true;
        r6.b = r4;
        r113.b = 59;
        r7.b = 0;
        r5.c = false;
        r6.c = 0;
        r113.c = 59;
        r7.c = 0;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r5.d = r3;
        ReelPicker$HeightMode r114 = ReelPicker$HeightMode.FIVE_LINES;
        Intrinsics.checkNotNullParameter(r114, "heightMode");
        r5.e = r114;
        r21 = r5.a(r20, null, 0);
        goto L29
    L27:
        r112 = this.i;
        r4 = this.j;
        goto L28
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraGEnvObserveTimerDialogBinding r4 = LarusDoraGEnvObserveTimerDialogBinding.a(r1, r2);
        this.d = r4;
        return r4.a;
    }
}
