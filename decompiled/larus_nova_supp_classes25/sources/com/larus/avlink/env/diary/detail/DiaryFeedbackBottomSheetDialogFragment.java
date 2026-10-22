package com.larus.avlink.env.diary.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.ChipGroup;
import com.larus.avlink.impl.databinding.LarusDialogDiaryFeedbackBottomSheetBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DiaryFeedbackBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogDiaryFeedbackBottomSheetBinding;", "viewModel", "Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "latestRenderedActionType", "", "latestRenderedSessionId", "", "Ljava/lang/Long;", "textWatcher", "Landroid/text/TextWatcher;", "getTheme", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "setupDialogBehavior", "setupViews", "observeViewModel", "renderState", "state", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackSheetUiState;", "renderChips", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryFeedbackBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDialogDiaryFeedbackBottomSheetBinding d;
    public final Lazy e;
    public Long f;
    public p g;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(i r2) {
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

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final DoraEnvObserveDiaryDetailViewModel S90() {
        return (DoraEnvObserveDiaryDetailViewModel) this.e.getValue();
    }

    public final void onDestroyView() {
        LarusDialogDiaryFeedbackBottomSheetBinding r0 = this.d;
        if (r0 == null) goto L7;
        EditText r1 = r0.c;
        if (r1 == null) goto L7;
        r1.removeTextChangedListener(this.g);
    L7:
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public DiaryFeedbackBottomSheetDialogFragment() {
        final Function0 r0 = new h(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryDetailViewModel.class), new DiaryFeedbackBottomSheetDialogFragment$special$$inlined$viewModels$default$1(r0), new DiaryFeedbackBottomSheetDialogFragment$special$$inlined$viewModels$default$2(r0, this));
    }

    public final Dialog onCreateDialog(Bundle r3) {
        BottomSheetDialog r4 = super.onCreateDialog(r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetDialog r5 = r4;
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(18);
    L5:
        return r5;
    }

    public final void onDismiss(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r4);     // Catch: Throwable -> L7
        Long r5 = this.f;     // Catch: Throwable -> L7
        if (r5 == null) goto L5;
        S90().onFeedbackSheetDismissed(r5.longValue());     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.env.diary.detail.i] */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L5;
        r5.setOnShowListener(new j());
    L5:
        LarusDialogDiaryFeedbackBottomSheetBinding r6 = this.d;
        if (r6 == null) goto L10;
        ImageView r7 = r6.b;
        if (r7 == null) goto L10;
        r7.setOnClickListener(new k(this));
    L10:
        LarusDialogDiaryFeedbackBottomSheetBinding r8 = this.d;
        if (r8 == null) goto L15;
        TextView r9 = r8.e;
        if (r9 == null) goto L15;
        r9.setOnClickListener(new l(this));
    L15:
        p r10 = new p(this);
        this.g = r10;
        LarusDialogDiaryFeedbackBottomSheetBinding r11 = this.d;
        if (r11 == null) goto L20;
        EditText r12 = r11.c;
        if (r12 == null) goto L20;
        r12.addTextChangedListener(r10);
    L20:
        LarusDialogDiaryFeedbackBottomSheetBinding r13 = this.d;
        if (r13 == null) goto L25;
        EditText r14 = r13.c;
        if (r14 == null) goto L25;
        r14.setOnTouchListener(new m());
    L25:
        S90().getFeedbackSheetState().observe(getViewLifecycleOwner(), new b(new i(this)));
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562056, r9, false);
        int r12 = 2131369547;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131369547);
        if (r2 == null) goto L15;
        r12 = 2131369548;
        EditText r3 = (EditText) ViewBindings.findChildViewById(r11, 2131369548);
        if (r3 == null) goto L15;
        r12 = 2131369549;
        ChipGroup r4 = ViewBindings.findChildViewById(r11, 2131369549);
        if (r4 == null) goto L15;
        r12 = 2131369550;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131369550);
        if (r5 == null) goto L15;
        r12 = 2131369551;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131369551);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        LarusDialogDiaryFeedbackBottomSheetBinding r14 = new LarusDialogDiaryFeedbackBottomSheetBinding(r13, r2, r3, r4, r5, r6);
        this.d = r14;
        Intrinsics.checkNotNull(r14);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
