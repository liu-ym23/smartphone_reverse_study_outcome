package com.larus.project;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.flowskill.impl.databinding.LarusFragmentProjectBinding;
import com.larus.flowskill.impl.databinding.LarusItemTaskProjectBinding;
import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0003(+.\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001e\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0012\u0010=\u001a\u0002012\b\b\u0002\u0010>\u001a\u00020\u0005H\u0002J\b\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020\u0005H\u0002J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0012H\u0002J\u0010\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u000201H\u0002J\b\u0010J\u001a\u000201H\u0002J\u0018\u0010K\u001a\u0002012\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0MH\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J \u0010V\u001a\u0002012\u0006\u0010T\u001a\u00020U2\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0002J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u001c\u0010Z\u001a\u0002012\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\u001c\u0010[\u001a\u0002012\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\b\u0010\\\u001a\u000201H\u0002J$\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020\u001a2\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\u0018\u0010_\u001a\u0002012\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\b\u0010a\u001a\u000201H\u0002J\b\u0010b\u001a\u000201H\u0002J\u0010\u0010c\u001a\u0002012\u0006\u0010P\u001a\u00020&H\u0002J\b\u0010d\u001a\u000201H\u0002J(\u0010e\u001a\u0002012\u0006\u0010P\u001a\u00020&2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010h\u001a\u000201H\u0016J\b\u0010i\u001a\u000201H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006k"}, d2 = {"Lcom/larus/project/TaskProjectFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentProjectBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderController;", "stateController", "Lcom/larus/bmhome/taskskill/ui/TaskSkillStateController;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheetView", "adapter", "Lcom/larus/project/TaskProjectAdapter;", "selectedDeviceId", "", "selectedProjectId", "hasMore", "", "isRequesting", "isSelectingProject", "hasReachedExpandedState", "projectSectionBaseBottomMargin", "projectSectionContentHeight", "onlineDeviceIds", "", "pcVersionsByDeviceId", "", "projects", "", "Lcom/larus/project/TaskProject;", "behaviorCallback", "com/larus/project/TaskProjectFragment$behaviorCallback$1", "Lcom/larus/project/TaskProjectFragment$behaviorCallback$1;", "pagingScrollListener", "com/larus/project/TaskProjectFragment$pagingScrollListener$1", "Lcom/larus/project/TaskProjectFragment$pagingScrollListener$1;", "stopFlingOnTouchListener", "com/larus/project/TaskProjectFragment$stopFlingOnTouchListener$1", "Lcom/larus/project/TaskProjectFragment$stopFlingOnTouchListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onRoundedBottomSheetReady", "bottomSheet", "updatePanelLayout", "listItemCount", "projectItemHeightPx", "panelHeaderHeightPx", "adaptiveDimenPx", "attr", "fallbackDimen", "currentExpandedPanelHeight", "projectItemHeight", "currentVisibleSheetHeight", "updateProjectSectionHeight", "visibleSheetHeight", "bindFixedActions", "observeDeviceStatus", "updateOnlineDevices", "devices", "", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "withProjectUiState", SlashMentionConfig.SLASH_CONTENT_PROJECT, "loadNextPage", "showInitialProjectSnapshot", "visibleProjectCount", "snapshot", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "showProjectSnapshot", "anchorToTop", "autoLoadWhenUnderfilled", "shouldDisplayProject", "showLoading", "showProjects", "showLoadError", "submitProjects", "showPagingLoading", "onProjectItemsCommitted", "adapterItemCount", "onCreateProjectClick", "publishClearProjectSelection", "onProjectClick", "showDeviceOfflineToast", "publishProjectSelected", "resolvedDeviceName", "resolvedDeviceType", "onStart", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TaskProjectFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int w = 0;
    public LarusFragmentProjectBinding d;
    public com.larus.bmhome.taskskill.ui.q e;
    public BottomSheetBehavior<View> f;
    public View g;
    public TaskProjectAdapter h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public Set<String> q;
    public Map<String, String> r;
    public final List<i> s;
    public final b t;
    public final TaskProjectFragment$pagingScrollListener$1 u;
    public final TaskProjectFragment$stopFlingOnTouchListener$1 v;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ TaskProjectFragment a;

        public b(TaskProjectFragment r1) {
            this.a = r1;
        }

        public final void onSlide(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            TaskProjectFragment r4 = this.a;
            int r0 = TaskProjectFragment.w;
            r4.ha0(r4.Y90(r2));
        }

        public final void onStateChanged(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "bottomSheet");
            boolean r1 = true;
            if (r5 != 3) goto L5;
            TaskProjectFragment r6 = this.a;
            r6.n = true;
            BottomSheetBehavior<View> r7 = r6.f;
            if (r7 == null) goto L34;
            r7.setSkipCollapsed(true);
        L34:
            TaskProjectFragment r8 = this.a;
            r8.ha0(r8.Y90(r4));
            return;
        L5:
            if (r5 == 4) goto L15;
            if (r5 == 5) goto L36;
            TaskProjectFragment r9 = this.a;
            int r0 = TaskProjectFragment.w;
            r9.ha0(r9.Y90(r4));
            return;
        L36:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L39;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L39:
            return;
        L15:
            BottomSheetBehavior<View> r11 = this.a.f;
            if (r11 == null) goto L26;
            Integer r12 = Integer.valueOf(r11.getPeekHeight());
            if (r12.intValue() > 0) goto L21;
            r1 = false;
        L21:
            if (r1 == true) goto L24;
            r12 = null;
        L24:
            if (r12 == null) goto L26;
            this.a.ha0(r12.intValue());
        L26:
            TaskProjectFragment r13 = this.a;
            if (r13.n == false) goto L41;
            BottomSheetBehavior<View> r14 = r13.f;
            if (r14 == null) goto L42;
            r14.setState(5);
            return;
        L42:
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ TaskProjectFragment a;

        public c(TaskProjectFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            TaskProjectFragment r10 = this.a;
            TaskProjectAdapter r11 = r10.h;
            if (r11 == null) goto L5;
            int r12 = r11.getItemCount();
        L6:
            r10.ga0(r12);
            return;
        L5:
            r12 = 0;
            goto L6
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(p r2) {
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

    public final int S90() {
        return 2131239799;
    }

    public final void Z90() {
        if (this.l == false) goto L5;
        return;
    L5:
        if (this.k == false) goto L18;
        IProjectListDataSource r0 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r0 != null) goto L11;
        FLogger.a.w("TaskProjectFragment", "IProjectListDataSource not found");
        ca0();
        return;
    L11:
        this.l = true;
        if (((ArrayList) this.s).isEmpty() == false) goto L14;
        da0(false, false);
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$loadNextPage$1(r0, this, null), 3, null);
        return;
    L14:
        ea0(true, false, false);
        goto L15
    }

    public final void ca0() {
        if (((ArrayList) this.s).isEmpty() == false) goto L13;
        LarusFragmentProjectBinding r0 = this.d;
        if (r0 == null) goto L9;
        RecyclerView r1 = r0.i;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        com.larus.bmhome.taskskill.ui.q r2 = this.e;
        if (r2 == null) goto L12;
        r2.c();
    L12:
        ga0(0);
    L14:
        Context r3 = getContext();
        if (r3 == null) goto L18;
        t19.s r4 = t19.s.a;
        String r5 = r3.getString(2131906830);
        r4.getClass();
        t19.s.t(r3, r5);
        return;
    L18:
        return;
    L13:
        ea0(false, false, false);
        goto L14
    }

    public final void onDestroyView() {
        LarusFragmentProjectBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.i;
        if (r1 == null) goto L7;
        r1.removeOnScrollListener(this.u);
    L7:
        LarusFragmentProjectBinding r2 = this.d;
        if (r2 == null) goto L12;
        RecyclerView r3 = r2.i;
        if (r3 == null) goto L12;
        r3.removeOnItemTouchListener(this.v);
    L12:
        TaskProjectAdapter r4 = this.h;
        if (r4 == null) goto L15;
        r4.a = null;
    L15:
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.r = MapsKt.emptyMap();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.project.TaskProjectFragment$pagingScrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.project.TaskProjectFragment$stopFlingOnTouchListener$1] */
    public TaskProjectFragment() {
        this.k = true;
        this.q = SetsKt.emptySet();
        this.r = MapsKt.emptyMap();
        this.s = new ArrayList();
        this.t = new b(this);
        this.u = new TaskProjectFragment$pagingScrollListener$1(this);
        this.v = new TaskProjectFragment$stopFlingOnTouchListener$1();
    }

    public final int U90() {
        return i5.E();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        m7.a(r1);
        return;
    L9:
        return;
    }

    public final int Y90(View r4) {
        Object r0 = r4.getParent();
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return RangesKt.coerceIn(r1.getHeight() - r4.getTop(), 0, r1.getHeight());
    L5:
        r1 = null;
        goto L7
    }

    public final boolean ba0(i r4) {
        if (r4.c == false) goto L5;
        return true;
    L5:
        String r0 = this.i;
        if (r0 != null) goto L8;
    L15:
        return true;
    L8:
        if ((!StringsKt.isBlank(r0)) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        return Intrinsics.areEqual(r4.f, r0);
    }

    public final void fa0(List<PcDevice> r9) {
        List<PcDevice> r10 = r9;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r10.iterator();
    L3:
        boolean r3 = false;
        String r5 = null;
        if (r1.hasNext() == false) goto L18;
        PcDevice r2 = (PcDevice) r1.next();
        if (r2 == null) goto L16;
        String r6 = r2.getDeviceId();
        if (r6 == null) goto L16;
        if (Intrinsics.areEqual(r2.r(), Boolean.TRUE) == true) goto L12;
    L14:
        if (r3 == false) goto L16;
        r5 = r6;
        goto L16
    L12:
        if ((!StringsKt.isBlank(r6)) == false) goto L14;
        r3 = true;
    L16:
        if (r5 == null) goto L3;
        r0.add(r5);
        goto L3
    L18:
        Set<String> r4 = CollectionsKt.toSet(r0);
        ArrayList r7 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L34;
        PcDevice r8 = (PcDevice) r11.next();
        if (r8 == null) goto L31;
        String r12 = r8.getDeviceId();
        if (r12 == null) goto L31;
        if ((!StringsKt.isBlank(r12)) == true) goto L29;
        r12 = null;
    L29:
        if (r12 == null) goto L31;
        Pair r13 = TuplesKt.to(r12, r8.o());
    L32:
        if (r13 == null) goto L20;
        r7.add(r13);
    L31:
        r13 = null;
        goto L32
    L34:
        Map<String, String> r14 = MapsKt.toMap(r7);
        if (Intrinsics.areEqual(this.q, r4) == true) goto L37;
    L39:
        this.q = r4;
        this.r = r14;
        IntIterator r15 = CollectionsKt.getIndices(this.s).iterator();
        boolean r16 = false;
    L41:
        if (r15.hasNext() == false) goto L45;
        int r17 = r15.nextInt();
        i r18 = (i) ListProtector.get(this.s, r17);
        i r19 = ia0(r18);
        if (Intrinsics.areEqual(r18, r19) == true) goto L41;
        ListProtector.set(this.s, r17, r19);
        r16 = true;
        goto L41
    L45:
        if (r16 == false) goto L63;
        ea0(this.l, false, false);
        return;
    L63:
        return;
    L37:
        if (Intrinsics.areEqual(this.r, r14) == false) goto L39;
    }

    public final void ga0(final int r3) {
        LarusFragmentProjectBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a.post(new n(this, r3));
    }

    public final void ha0(int r8) {
        if (r8 > 0) goto L4;
        return;
    L4:
        if (this.p <= 0) goto L30;
        LarusFragmentProjectBinding r0 = this.d;
        if (r0 != null) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r1 = r0.g.getLayoutParams();
        Integer r3 = null;
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L13:
        if (r2 != null) goto L15;
        return;
    L15:
        Integer r4 = Integer.valueOf(r0.e.a.getMeasuredHeight());
        if (r4.intValue() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        r3 = r4;
    L21:
        if (r3 == null) goto L23;
        int r6 = r3.intValue();
    L24:
        int r9 = Math.min(this.p, RangesKt.coerceAtLeast(((r8 - r6) - r2.topMargin) - this.o, 0));
        if (r2.height != r9) goto L27;
        return;
    L27:
        r2.height = r9;
        r0.g.setLayoutParams(r2);
        return;
    L23:
        r6 = getResources().getDimensionPixelSize(v19.c.b(2130971505, getContext(), 2131167379));
        goto L24
    L18:
        r5 = false;
        goto L19
    L12:
        r2 = null;
        goto L13
    }

    public final i ia0(i r18) {
        String r2 = r18.f;
        String r3 = null;
        if (r2 != null) goto L5;
    L7:
        r2 = null;
    L8:
        boolean r14 = CollectionsKt.contains(this.q, r2);
        if (r2 == null) goto L13;
        if (r14 == true) goto L13;
        boolean r6 = false;
    L14:
        if (r2 == null) goto L16;
        r3 = this.r.get(r2);
    L16:
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
    L27:
        boolean r5 = true;
    L28:
        boolean r15 = Intrinsics.areEqual(r18.a, this.j);
        if (r6 == false) goto L32;
        if (r5 == false) goto L32;
        boolean r16 = true;
    L33:
        String r7 = r18.a;
        String r8 = r18.b;
        boolean r9 = r18.c;
        String r10 = r18.d;
        String r11 = r18.e;
        String r12 = r18.f;
        String r13 = r18.g;
        Intrinsics.checkNotNullParameter(r7, "projectId");
        Intrinsics.checkNotNullParameter(r8, "name");
        return new i(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L32:
        r16 = false;
        goto L33
    L24:
        if (l2.b(r3) == true) goto L27;
        r5 = false;
        goto L28
    L18:
        if (StringsKt.isBlank(r3) == true) goto L21;
        r4 = false;
    L13:
        r6 = true;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        goto L7
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getString("selected_device_id");
    L6:
        this.i = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        r0 = r6.getString("selected_project_id");
    L9:
        this.j = r0;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void W90(TaskProjectFragment r9, i r10) {
        if (r9.m == false) goto L6;
        return;
    L6:
        if (r10.c == false) goto L8;
        r9.aa0(r10, null, null);
        return;
    L8:
        String r0 = r10.f;
        if (r0 != null) goto L11;
    L13:
        r0 = null;
    L14:
        if (r0 != null) goto L18;
        Context r11 = r9.getContext();
        if (r11 == null) goto L21;
        t19.s.a.getClass();
        t19.s.s(r11, 2131906239);
        return;
    L21:
        return;
    L18:
        r9.m = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.getViewLifecycleOwner()), null, null, new TaskProjectFragment$onProjectClick$1(r9, r10, r0, null), 3, null);
        return;
    L11:
        if ((!StringsKt.isBlank(r0)) == false) goto L13;
        goto L13
    }

    public final void V90(View r7, BottomSheetBehavior<View> r8) {
        Intrinsics.checkNotNullParameter(r7, "bottomSheet");
        Intrinsics.checkNotNullParameter(r8, "behavior");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 == null) goto L5;
        r0.height = -1;
    L6:
        r7.setLayoutParams(r0);
        Object r1 = r7.getParent();
        if ((r1 instanceof View) == false) goto L9;
        View r2 = (View) r1;
    L10:
        if (r2 == null) goto L18;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L15:
        if (r4 == null) goto L17;
        r4.topMargin = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
    L17:
        r2.setLayoutParams(r4);
        goto L18
    L14:
        r4 = null;
    L18:
        this.f = r8;
        this.g = r7;
        int r5 = 0;
        r8.setSkipCollapsed(false);
        r8.setHideable(true);
        r8.setFitToContents(true);
        r8.setBottomSheetCallback(this.t);
        r8.setState(4);
        if (r7.isLaidOut() == true) goto L21;
    L27:
        r7.addOnLayoutChangeListener(new c(this));
    L28:
        TaskProjectAdapter r9 = this.h;
        if (r9 == null) goto L31;
        r5 = r9.getItemCount();
    L31:
        ga0(r5);
        return;
    L21:
        if (r7.isLayoutRequested() == true) goto L27;
        TaskProjectAdapter r10 = this.h;
        if (r10 == null) goto L25;
        int r11 = r10.getItemCount();
    L26:
        ga0(r11);
        goto L28
    L25:
        r11 = 0;
        goto L26
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public final void da0(final boolean r4, final boolean r5) {
        LarusFragmentProjectBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.i;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        com.larus.bmhome.taskskill.ui.q r2 = this.e;
        if (r2 == null) goto L10;
        r2.a();
    L10:
        final List r3 = CollectionsKt.listOf(w.a.a);
        TaskProjectAdapter r6 = this.h;
        if (r6 == null) goto L14;
        r6.submitList(r3, new k(this, r3, r4, r5));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.project.p] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusFragmentProjectBinding r10 = this.d;
        if (r10 == null) goto L26;
        LarusLayoutBottomSheetHeaderBinding r1 = r10.e;
        Intrinsics.checkNotNullParameter(r1, "binding");
        r1.d.setText(2131906940);
        AppCompatImageView r2 = r1.b;
        ConstraintLayout.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L25;
        ConstraintLayout.LayoutParams r4 = r3;
        r4.startToStart = -1;
        r4.endToEnd = 0;
        r2.setLayoutParams(r4);
        r1.b.setOnClickListener(new l(this));
        this.e = new com.larus.bmhome.taskskill.ui.q(r10.h, new m(this));
        TaskProjectAdapter r5 = new TaskProjectAdapter();
        r5.a = new TaskProjectFragment$onViewCreated$1$3$1(this);
        r10.i.setLayoutManager(new LinearLayoutManager(requireContext()));
        r10.i.setAdapter(r5);
        r10.i.addOnScrollListener(this.u);
        r10.i.addOnItemTouchListener(this.v);
        this.h = r5;
        ViewGroup.LayoutParams r11 = r10.g.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L10:
        if (r12 == null) goto L12;
        int r13 = r12.bottomMargin;
    L13:
        this.o = r13;
        LarusFragmentProjectBinding r14 = this.d;
        if (r14 == null) goto L18;
        LarusItemTaskProjectBinding r15 = r14.c;
        if (r15 == null) goto L18;
        AppCompatImageView r6 = r15.e;
        r6.setImageResource(v19.c.b(2130971855, r6.getContext(), 2131242094));
        r15.f.setText(2131906209);
        r15.d.setVisibility(8);
        r15.g.setVisibility(8);
        r15.c.setVisibility(0);
        r15.a.setOnClickListener(new r(this));
    L18:
        LarusFragmentProjectBinding r16 = this.d;
        if (r16 == null) goto L23;
        LarusItemTaskProjectBinding r17 = r16.b;
        if (r17 == null) goto L23;
        AppCompatImageView r7 = r17.e;
        r7.setImageResource(v19.c.b(2130971856, r7.getContext(), 2131242097));
        r17.f.setText(2131906917);
        r17.d.setVisibility(8);
        r17.g.setVisibility(8);
        r17.c.setVisibility(8);
        r17.a.setOnClickListener(new s(this));
    L23:
        this.p = getResources().getDimensionPixelSize(v19.c.b(2130971512, getContext(), 2131167393)) * 2;
        goto L26
    L12:
        r13 = 0;
        goto L13
    L9:
        r12 = null;
        goto L10
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L26:
        GetAllDevicesRepo r18 = GetAllDevicesRepo.a;
        GetAllDevicesRepo.g();
        GetAllDevicesRepo.o.observe(getViewLifecycleOwner(), new d(new p(this)));
        AllDeviceResponse r19 = GetAllDevicesRepo.d();
        if (r19 == null) goto L29;
        List<PcDevice> r20 = r19.getDevices();
    L30:
        if (r20 != null) goto L32;
        r20 = CollectionsKt.emptyList();
    L32:
        fa0(r20);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$observeDeviceStatus$2(this, null), 3, null);
        IProjectListDataSource r21 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r21 != null) goto L35;
        FLogger.a.w("TaskProjectFragment", "IProjectListDataSource not found");
        ca0();
        return;
    L35:
        this.l = true;
        da0(false, false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$showInitialProjectSnapshot$1(r21, this, null), 3, null);
        return;
    L29:
        r20 = null;
        goto L30
    }

    public final void aa0(i r5, String r6, String r7) {
        FragmentManager r0 = getParentFragmentManager();
        Pair[] r1 = new Pair[8];
        r1[0] = TuplesKt.to("project_id", r5.a);
        r1[1] = TuplesKt.to("project_name", r5.b);
        r1[2] = TuplesKt.to("is_cloud_project", Boolean.valueOf(r5.c));
        r1[3] = TuplesKt.to("folder_name", r5.d);
        r1[4] = TuplesKt.to("workspace", r5.e);
        r1[5] = TuplesKt.to("device_id", r5.f);
        if (r6 != null) goto L5;
        r6 = r5.g;
    L5:
        r1[6] = TuplesKt.to("device_name", r6);
        r1[7] = TuplesKt.to("device_type", r7);
        r0.setFragmentResult("task_project_panel_result", BundleKt.bundleOf(r1));
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L15;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ea0(boolean r6, final boolean r7, final boolean r8) {
        List r0 = CollectionsKt.createListBuilder();
        List<i> r1 = this.s;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(new w.b((i) r3.next()));
        goto L4
    L6:
        r0.addAll(r2);
        if (r6 == false) goto L9;
        r0.add(w.a.a);
    L9:
        final List r9 = CollectionsKt.build(r0);
        TaskProjectAdapter r4 = this.h;
        if (r4 == null) goto L14;
        r4.submitList(r9, new o(this, r9, r7, r8));
        return;
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562426, r12, false);
        int r15 = 2131366944;
        View r16 = ViewBindings.findChildViewById(r14, 2131366944);
        if (r16 == null) goto L21;
        LarusItemTaskProjectBinding r2 = LarusItemTaskProjectBinding.a(r16);
        r15 = 2131368204;
        View r17 = ViewBindings.findChildViewById(r14, 2131368204);
        if (r17 == null) goto L21;
        LarusItemTaskProjectBinding r3 = LarusItemTaskProjectBinding.a(r17);
        r15 = 2131383348;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131383348);
        if (r4 == null) goto L21;
        r15 = 2131383350;
        View r18 = ViewBindings.findChildViewById(r14, 2131383350);
        if (r18 == null) goto L21;
        LarusLayoutBottomSheetHeaderBinding r5 = LarusLayoutBottomSheetHeaderBinding.a(r18);
        r15 = 2131383351;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131383351);
        if (r6 == null) goto L21;
        r15 = 2131383357;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r14, 2131383357);
        if (r7 == null) goto L21;
        r15 = 2131383361;
        View r19 = ViewBindings.findChildViewById(r14, 2131383361);
        if (r19 == null) goto L21;
        LarusLayoutTaskSkillStateBinding r8 = LarusLayoutTaskSkillStateBinding.a(r19);
        r15 = 2131384991;
        RecyclerView r9 = ViewBindings.findChildViewById(r14, 2131384991);
        if (r9 == null) goto L21;
        ConstraintLayout r110 = r14;
        this.d = new LarusFragmentProjectBinding(r110, r2, r3, r4, r5, r6, r7, r8, r9);
        return r110;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public static final void X90(TaskProjectFragment r5, com.larus.bmhome.taskskill.service.i r6, boolean r7, boolean r8) {
        r5.getClass();
        r5.k = r6.b;
        ((ArrayList) r5.s).clear();
        List<i> r0 = r5.s;
        List r1 = r6.a;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        i r4 = x.a(((com.larus.bmhome.taskskill.service.h) r3.next()).a);
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r2.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        Object r11 = r10.next();
        if (r5.ba0((i) r11) == false) goto L10;
        r9.add(r11);
        goto L10
    L14:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r13 = r9.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        r12.add(r5.ia0((i) r13.next()));
        goto L16
    L18:
        CollectionsKt.addAll(r0, r12);
        if (r6.c == false) goto L21;
    L23:
        LarusFragmentProjectBinding r14 = r5.d;
        if (r14 == null) goto L28;
        RecyclerView r15 = r14.i;
        if (r15 == null) goto L28;
        r15.setVisibility(0);
    L28:
        com.larus.bmhome.taskskill.ui.q r16 = r5.e;
        if (r16 == null) goto L31;
        r16.a();
    L31:
        r5.ea0(false, r7, r8);
        return;
    L21:
        if (((ArrayList) r5.s).isEmpty() == false) goto L23;
        r5.da0(r7, r8);
    }
}
