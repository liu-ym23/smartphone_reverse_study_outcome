package com.larus.agents.impl.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceEditorBinding;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\"\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\u001a\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020\u0019H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u00061"}, d2 = {"Lcom/larus/agents/impl/ui/WorkExperienceEditorFragment;", "Lcom/larus/agents/impl/ui/ExpandedTaskBottomSheetFragment;", "<init>", "()V", "binding", "Lcom/larus/agents/impl/databinding/LarusFragmentWorkExperienceEditorBinding;", "repository", "Lcom/larus/agents/impl/network/WorkExperienceRepository;", "isBusy", "", "isSaving", "autoOptimize", "experienceId", "", "getExperienceId", "()Ljava/lang/String;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "fitDetailsFieldToViewport", "panelBinding", "bindRequiredLabels", "bindRequiredLabel", "textView", "Landroid/widget/TextView;", "labelRes", "", "showRequiredMark", "loadDetail", "bindDetail", "detail", "Lcom/larus/agents/impl/experience/WorkExperienceDetail;", "save", "setBusy", "busy", "preventDismiss", "updateSaveEnabled", "updateFieldsEditable", "editable", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkExperienceEditorFragment extends ExpandedTaskBottomSheetFragment {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentWorkExperienceEditorBinding f;
    public final CachedWorkExperienceRepository g;
    public boolean h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ WorkExperienceEditorFragment a;
        public final /* synthetic */ LarusFragmentWorkExperienceEditorBinding b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            WorkExperienceEditorFragment r0 = this.a;
            TextView r1 = this.b.i;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            int r2 = WorkExperienceEditorFragment.k;
            r0.Y90(r1, 2131907643, r5);
            this.a.ba0();
            return;
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r5 = false;
            goto L9
        }

        public b(WorkExperienceEditorFragment r1, LarusFragmentWorkExperienceEditorBinding r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ WorkExperienceEditorFragment a;
        public final /* synthetic */ LarusFragmentWorkExperienceEditorBinding b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            WorkExperienceEditorFragment r0 = this.a;
            TextView r1 = this.b.d;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            int r2 = WorkExperienceEditorFragment.k;
            r0.Y90(r1, 2131907638, r5);
            this.a.ba0();
            return;
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r5 = false;
            goto L9
        }

        public c(WorkExperienceEditorFragment r1, LarusFragmentWorkExperienceEditorBinding r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ WorkExperienceEditorFragment a;
        public final /* synthetic */ LarusFragmentWorkExperienceEditorBinding b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            WorkExperienceEditorFragment r0 = this.a;
            TextView r1 = this.b.f;
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            int r2 = WorkExperienceEditorFragment.k;
            r0.Y90(r1, 2131907639, r5);
            this.a.ba0();
            return;
        L5:
            if (StringsKt.isBlank(r4) == true) goto L8;
            r5 = false;
            goto L9
        }

        public d(WorkExperienceEditorFragment r1, LarusFragmentWorkExperienceEditorBinding r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.larus.agents.impl.ui.ExpandedTaskBottomSheetFragment
    public final void onDestroyView() {
        this.h = false;
        this.i = false;
        this.f = null;
        super.onDestroyView();
    }

    public final void ba0() {
        LarusFragmentWorkExperienceEditorBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (this.h == false) goto L8;
    L34:
        r0.j.setEnabled(r2);
        AppCompatImageView r1 = r0.j;
        if (r2 == false) goto L37;
        float r3 = 1.0f;
    L38:
        r1.setAlpha(r3);
        return;
    L37:
        r3 = 0.4f;
        goto L38
    L8:
        if (this.i == true) goto L34;
        Editable r4 = r0.h.getText();
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L34;
        Editable r6 = r0.c.getText();
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L34;
        Editable r8 = r0.e.getText();
        if (r8 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == true) goto L34;
        r2 = true;
        goto L34
    L28:
        if (StringsKt.isBlank(r8) == true) goto L31;
        r9 = false;
        goto L32
    L20:
        if (StringsKt.isBlank(r6) == true) goto L23;
        r7 = false;
        goto L24
    L12:
        if (StringsKt.isBlank(r4) == true) goto L15;
        r5 = false;
        goto L16
    }

    public WorkExperienceEditorFragment() {
        this.g = new CachedWorkExperienceRepository(null);
    }

    public final String Z90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("experience_id");
    }

    public final void aa0(boolean r4, boolean r5) {
        this.h = r4;
        setCancelable(!r5);
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.setCanceledOnTouchOutside(!r5);
    L5:
        LarusFragmentWorkExperienceEditorBinding r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        ProgressBar r2 = r1.g;
        if (r4 == false) goto L11;
        int r3 = 0;
    L12:
        r2.setVisibility(r3);
        r1.b.setEnabled(!r5);
        boolean r6 = !r4;
        LarusFragmentWorkExperienceEditorBinding r7 = this.f;
        if (r7 == null) goto L16;
        r7.h.setEnabled(r6);
        r7.c.setEnabled(r6);
        r7.e.setEnabled(r6);
    L16:
        ba0();
        return;
    L11:
        r3 = 8;
        goto L12
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        Dialog r13 = getDialog();
        if (r13 == null) goto L5;
        r13.setOnShowListener(new com.larus.agents.impl.ui.b(this));
    L5:
        LarusFragmentWorkExperienceEditorBinding r14 = this.f;
        if (r14 != null) goto L8;
        return;
    L8:
        TextView r15 = r14.i;
        Editable r0 = r14.h.getText();
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        Y90(r15, 2131907643, r1);
        TextView r16 = r14.d;
        Editable r2 = r14.c.getText();
        if (r2 != null) goto L18;
    L21:
        boolean r3 = true;
    L22:
        Y90(r16, 2131907638, r3);
        TextView r17 = r14.f;
        Editable r4 = r14.e.getText();
        if (r4 != null) goto L25;
    L28:
        boolean r5 = true;
    L29:
        Y90(r17, 2131907639, r5);
        NestedScrollView r19 = r14.k;
        if (r19.isLaidOut() == true) goto L32;
    L42:
        r19.addOnLayoutChangeListener(new o(r14));
    L43:
        TextView r110 = r14.l;
        if (Z90() != null) goto L46;
        int r6 = 2131907636;
    L47:
        r110.setText(r6);
        r14.b.setOnClickListener(new m(this));
        r14.j.setOnClickListener(new n(this));
        r14.h.addTextChangedListener(new b(this, r14));
        r14.c.addTextChangedListener(new c(this, r14));
        r14.e.addTextChangedListener(new d(this, r14));
        if (Z90() != null) goto L50;
        aa0(false, false);
        return;
    L50:
        aa0(true, false);
        String r111 = Z90();
        if (r111 == null) goto L56;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new WorkExperienceEditorFragment$loadDetail$1(this, r111, null), 3, null);
        return;
    L56:
        return;
    L46:
        r6 = 2131907640;
        goto L47
    L32:
        if (r19.isLayoutRequested() == true) goto L42;
        AppCompatEditText r7 = r14.e;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L36;
        ViewGroup r9 = (ViewGroup) r8;
    L37:
        if (r9 == null) goto L43;
        int r112 = (r19.getHeight() - r7.getTop()) - r9.getPaddingBottom();
        if (r112 <= r7.getMinimumHeight()) goto L43;
        r7.setMinimumHeight(r112);
        goto L43
    L36:
        r9 = null;
        goto L37
    L25:
        if (StringsKt.isBlank(r4) == true) goto L28;
        r5 = false;
        goto L29
    L18:
        if (StringsKt.isBlank(r2) == true) goto L21;
        r3 = false;
        goto L22
    L11:
        if (StringsKt.isBlank(r0) == true) goto L14;
        r1 = false;
        goto L15
    }

    public static final void X90(WorkExperienceEditorFragment r2, LarusFragmentWorkExperienceEditorBinding r3, com.larus.agents.impl.experience.n r4) {
        r2.getClass();
        r3.h.setText(r4.a.b);
        r3.c.setText(r4.a.c);
        r3.e.setText(r4.b);
        r2.j = r4.a.h;
    }

    public final void Y90(TextView r5, int r6, boolean r7) {
        String r8 = getString(r6);
        if (r7 == true) goto L6;
        r5.setText(r8);
        return;
    L6:
        SpannableStringBuilder r9 = new SpannableStringBuilder(r8);
        r9.append("*");
        r9.setSpan(new ForegroundColorSpan(v19.c.a(2130970996, requireContext(), 2131102650)), r8.length(), r9.length(), 33);
        r5.setText(r9);
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r110, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        View r1 = r19.inflate(2131562440, r110, false);
        int r2 = 2131393326;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r1, 2131393326);
        if (r6 == null) goto L27;
        r2 = 2131393327;
        AppCompatEditText r7 = ViewBindings.findChildViewById(r1, 2131393327);
        if (r7 == null) goto L27;
        r2 = 2131393328;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r1, 2131393328);
        if (r8 == null) goto L27;
        r2 = 2131393329;
        AppCompatEditText r9 = ViewBindings.findChildViewById(r1, 2131393329);
        if (r9 == null) goto L27;
        r2 = 2131393330;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r1, 2131393330);
        if (r10 == null) goto L27;
        r2 = 2131393331;
        ProgressBar r11 = (ProgressBar) ViewBindings.findChildViewById(r1, 2131393331);
        if (r11 == null) goto L27;
        r2 = 2131393332;
        AppCompatEditText r12 = ViewBindings.findChildViewById(r1, 2131393332);
        if (r12 == null) goto L27;
        r2 = 2131393333;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r1, 2131393333);
        if (r13 == null) goto L27;
        r2 = 2131393334;
        AppCompatImageView r14 = ViewBindings.findChildViewById(r1, 2131393334);
        if (r14 == null) goto L27;
        r2 = 2131393335;
        OfficeTaskPreferenceScrollView r15 = (OfficeTaskPreferenceScrollView) ViewBindings.findChildViewById(r1, 2131393335);
        if (r15 == null) goto L27;
        r2 = 2131393336;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r1, 2131393336);
        if (r16 == null) goto L27;
        FrameLayout r3 = (FrameLayout) r1;
        this.f = new LarusFragmentWorkExperienceEditorBinding(r3, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return W90(r3);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
