package com.larus.bmhome.taskskill.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFragmentTaskSkillPanelBinding;
import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\u001e\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0.H\u0014J\b\u0010/\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020\u0016H\u0002J\b\u00102\u001a\u00020\u0016H\u0002J\u0016\u00103\u001a\u00020\u00162\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u000206H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006<"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/TaskSkillPanelFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentTaskSkillPanelBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderController;", "adapter", "Lcom/larus/bmhome/taskskill/ui/TaskSkillListAdapter;", "stateController", "Lcom/larus/bmhome/taskskill/ui/TaskSkillStateController;", "pcDeviceId", "", "folderWorkspace", "isRequesting", "", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "paneAwareController", "Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "getPaneAwareController", "()Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "paneAwareController$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "initViews", "loadSkills", "loadRecommendSkills", "showLoading", "showList", "skills", "", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "showEmpty", "showError", "publishSelection", "skill", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkillPanelFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusFragmentTaskSkillPanelBinding d;
    public TaskSkillListAdapter e;
    public q f;
    public String g;
    public String h;
    public boolean i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final int S90() {
        return 2131239798;
    }

    public final void X90() {
        if (this.i == false) goto L6;
        FLogger.a.i("TaskSkillPanelFragment", "[loadSkills] skip, reason=requestInProgress");
        return;
    L6:
        FLogger.a.i("TaskSkillPanelFragment", "[loadSkills] start");
        this.i = true;
        LarusFragmentTaskSkillPanelBinding r0 = this.d;
        if (r0 == null) goto L9;
        r0.d.setVisibility(0);
        r0.c.setVisibility(8);
    L9:
        q r1 = this.f;
        if (r1 == null) goto L12;
        r1.a();
    L12:
        TaskSkillListAdapter r2 = this.e;
        if (r2 == null) goto L19;
        IntRange r3 = RangesKt.until(0, 9);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        IntIterator r5 = r3.iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.add(new r.a(r5.nextInt()));
        goto L16
    L18:
        r2.submitList(r4);
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskSkillPanelFragment$loadRecommendSkills$1(this, null), 3, null);
    }

    public final void onDestroyView() {
        FLogger.a.i("TaskSkillPanelFragment", "[onDestroyView] isRequesting=" + this.i);
        this.i = false;
        LarusFragmentTaskSkillPanelBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.d;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.e = null;
        this.f = null;
        this.d = null;
        ((PaneAwareBottomSheetController) this.j.getValue()).e();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public TaskSkillPanelFragment() {
        this.j = LazyKt.lazy(new l(this));
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[onStart] dialogShowing=");
        Dialog r2 = getDialog();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.isShowing() != true) goto L7;
    L8:
        r1.append(r3);
        r1.append(", viewShown=");
        View r4 = getView();
        if (r4 == null) goto L11;
        Boolean r5 = Boolean.valueOf(r4.isShown());
    L12:
        r1.append(r5);
        r1.append(", state=");
        r1.append(getLifecycle().getCurrentState());
        r0.i("TaskSkillPanelFragment", r1.toString());
        Dialog r6 = getDialog();
        if (r6 == null) goto L18;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L19;
        m7.a(r7);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r5 = null;
    L7:
        r3 = false;
        goto L8
    }

    public static final void W90(TaskSkillPanelFragment r3) {
        LarusFragmentTaskSkillPanelBinding r0 = r3.d;
        if (r0 == null) goto L5;
        r0.d.setVisibility(8);
        r0.c.setVisibility(8);
    L5:
        q r1 = r3.f;
        if (r1 == null) goto L14;
        Context r2 = r3.getContext();
        if (r2 == null) goto L10;
        String r4 = r2.getString(2131901728);
    L11:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        int r5 = q.b;
        r1.b(2131242112, r4);
        goto L14
    L10:
        r4 = null;
    L14:
        TaskSkillListAdapter r6 = r3.e;
        if (r6 == null) goto L18;
        r6.submitList(CollectionsKt.emptyList());
        return;
    }

    public final void onCreate(Bundle r5) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r5);
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("arg_pc_device_id");
    L6:
        this.g = r2;
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        r1 = r3.getString("arg_folder_workspace");
    L9:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        this.h = r1;
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[onCreate] hasSavedState=");
        boolean r7 = false;
        if (r5 == null) goto L14;
        boolean r8 = true;
    L15:
        r6.append(r8);
        r6.append(", hasPcDeviceId=");
        String r9 = this.g;
        if (r9 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        r6.append(!r10);
        r6.append(", hasFolderWorkspace=");
        String r11 = this.h;
        if (r11 != null) goto L25;
    L27:
        r6.append(r7);
        r4.i("TaskSkillPanelFragment", r6.toString());
        return;
    L25:
        if ((!StringsKt.isBlank(r11)) != true) goto L27;
        r7 = true;
        goto L27
    L18:
        if (StringsKt.isBlank(r9) == true) goto L21;
        r10 = false;
        goto L22
    L14:
        r8 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r1) {
        return ((PaneAwareBottomSheetController) this.j.getValue()).b();
    }

    public final void V90(View r6, BottomSheetBehavior<View> r7) {
        Intrinsics.checkNotNullParameter(r6, "bottomSheet");
        Intrinsics.checkNotNullParameter(r7, "behavior");
        FLogger.a.i("TaskSkillPanelFragment", "[onRoundedBottomSheetReady] bottomSheetSize=" + r6.getWidth() + 'x' + r6.getHeight() + ", bottomSheetShown=" + r6.isShown());
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = -1;
    L5:
        r6.setLayoutParams(r0);
        Object r8 = r6.getParent();
        if ((r8 instanceof View) == false) goto L8;
        View r9 = (View) r8;
    L9:
        if (r9 == null) goto L18;
        ViewGroup.LayoutParams r1 = r9.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L14:
        int r3 = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        if (r2 == null) goto L17;
        r2.topMargin = r3;
    L17:
        r9.setLayoutParams(r2);
        goto L18
    L13:
        r2 = null;
    L18:
        r7.setSkipCollapsed(true);
        r7.setState(3);
        return;
    L8:
        r9 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.bmhome.taskskill.ui.o] */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("[onViewCreated] dialog=");
        if (getDialog() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", viewShown=");
        r0.append(r5.isShown());
        r7.i("TaskSkillPanelFragment", r0.toString());
        Dialog r8 = getDialog();
        if (r8 == null) goto L9;
        r8.setOnShowListener(new k(this));
    L9:
        LarusFragmentTaskSkillPanelBinding r9 = this.d;
        if (r9 == null) goto L15;
        LarusLayoutBottomSheetHeaderBinding r10 = r9.b;
        Intrinsics.checkNotNullParameter(r10, "binding");
        r10.d.setText(2131906941);
        AppCompatImageView r2 = r10.b;
        ConstraintLayout.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L18;
        ConstraintLayout.LayoutParams r4 = r3;
        r4.startToStart = -1;
        r4.endToEnd = 0;
        r2.setLayoutParams(r4);
        View.OnClickListener r11 = new m(this);
        r10.b.setOnClickListener(r11);
        this.f = new q(r9.e, new n(this));
        this.e = new TaskSkillListAdapter(new o(this));
        r9.d.setLayoutManager(new LinearLayoutManager(getContext()));
        r9.d.setAdapter(this.e);
        goto L15
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L15:
        X90();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562437, r9, false);
        int r12 = 2131388271;
        View r0 = ViewBindings.findChildViewById(r11, 2131388271);
        if (r0 == null) goto L13;
        LarusLayoutBottomSheetHeaderBinding r3 = LarusLayoutBottomSheetHeaderBinding.a(r0);
        r12 = 2131388272;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131388272);
        if (r4 == null) goto L13;
        r12 = 2131388273;
        RecyclerView r5 = ViewBindings.findChildViewById(r11, 2131388273);
        if (r5 == null) goto L13;
        r12 = 2131388274;
        View r1 = ViewBindings.findChildViewById(r11, 2131388274);
        if (r1 == null) goto L13;
        LinearLayout r13 = (LinearLayout) r11;
        this.d = new LarusFragmentTaskSkillPanelBinding(r13, r3, r4, r5, LarusLayoutTaskSkillStateBinding.a(r1));
        return ((PaneAwareBottomSheetController) this.j.getValue()).f(r8.getContext(), r13);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
