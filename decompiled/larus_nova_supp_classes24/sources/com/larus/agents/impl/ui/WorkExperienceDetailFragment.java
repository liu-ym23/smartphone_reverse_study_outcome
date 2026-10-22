package com.larus.agents.impl.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceDetailBinding;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J \u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/agents/impl/ui/WorkExperienceDetailFragment;", "Lcom/larus/agents/impl/ui/ExpandedTaskBottomSheetFragment;", "<init>", "()V", "binding", "Lcom/larus/agents/impl/databinding/LarusFragmentWorkExperienceDetailBinding;", "repository", "Lcom/larus/agents/impl/network/WorkExperienceRepository;", "detail", "Lcom/larus/agents/impl/experience/WorkExperienceDetail;", "applyingToggle", "", "isMutating", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "loadDetail", "bindDetail", "panelBinding", "loadedDetail", "enableToggle", "updateAutoOptimize", "enabled", "showMutationFailure", "result", "Lcom/larus/agents/impl/experience/WorkExperienceMutationResult;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkExperienceDetailFragment extends ExpandedTaskBottomSheetFragment {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentWorkExperienceDetailBinding f;
    public final CachedWorkExperienceRepository g;
    public com.larus.agents.impl.experience.n h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.agents.impl.ui.ExpandedTaskBottomSheetFragment
    public final int S90() {
        return 2131239959;
    }

    @Override // com.larus.agents.impl.ui.ExpandedTaskBottomSheetFragment
    public final void onDestroyView() {
        this.j = false;
        this.f = null;
        super.onDestroyView();
    }

    public WorkExperienceDetailFragment() {
        this.g = new CachedWorkExperienceRepository(null);
    }

    public final int U90() {
        return i5.E();
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Dialog r10 = getDialog();
        if (r10 == null) goto L5;
        r10.setOnShowListener(new b(this));
    L5:
        LarusFragmentWorkExperienceDetailBinding r11 = this.f;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.d.setOnClickListener(new k(this));
        boolean r0 = false;
        r11.b.getToggleView().setEnabled(false);
        r11.b.getToggleView().setOnCheckedChangeListener(new l(this));
        Bundle r12 = getArguments();
        if (r12 == null) goto L11;
        String r13 = r12.getString("experience_id");
    L12:
        if (r13 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L25;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new WorkExperienceDetailFragment$loadDetail$1(this, r13, null), 3, null);
        return;
    L25:
        dismissAllowingStateLoss();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L27;
        com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L27:
        return;
    L14:
        if (StringsKt.isBlank(r13) == false) goto L16;
    L11:
        r13 = null;
        goto L12
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562439, r9, false);
        int r12 = 2131393319;
        ItemTextToggle r2 = ViewBindings.findChildViewById(r11, 2131393319);
        if (r2 == null) goto L17;
        r12 = 2131393320;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131393320);
        if (r3 == null) goto L17;
        r12 = 2131393321;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r11, 2131393321);
        if (r4 == null) goto L17;
        r12 = 2131393322;
        if (((Space) ViewBindings.findChildViewById(r11, 2131393322)) == null) goto L17;
        r12 = 2131393323;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131393323);
        if (r5 == null) goto L17;
        r12 = 2131393324;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131393324);
        if (r6 == null) goto L17;
        FrameLayout r13 = (FrameLayout) r11;
        this.f = new LarusFragmentWorkExperienceDetailBinding(r13, r2, r3, r4, r5, r6);
        return W90(r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public static final void X90(WorkExperienceDetailFragment r2, LarusFragmentWorkExperienceDetailBinding r3, com.larus.agents.impl.experience.n r4, boolean r5) {
        r2.h = r4;
        r3.f.setText(r4.a.b);
        r3.c.setText(r4.c);
        r2.i = true;
        r3.b.getToggleView().setChecked(r4.a.h);
        r2.i = false;
        r3.b.getToggleView().setEnabled(r5);
    }
}
