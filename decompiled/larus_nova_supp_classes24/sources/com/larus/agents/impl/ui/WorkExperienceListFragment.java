package com.larus.agents.impl.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceListBinding;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.screenmenu.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020 H\u0002J \u0010'\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u000eH\u0002J*\u0010.\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\nH\u0002J\u0012\u00104\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u00105\u001a\u00020 2\u0006\u00103\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0018H\u0002J\u0018\u00107\u001a\u0002082\u0006\u00103\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020 2\u0006\u00103\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/agents/impl/ui/WorkExperienceListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/agents/impl/databinding/LarusFragmentWorkExperienceListBinding;", "repository", "Lcom/larus/agents/impl/network/WorkExperienceRepository;", "items", "", "Lcom/larus/agents/impl/experience/WorkExperienceSummary;", "loadJob", "Lkotlinx/coroutines/Job;", "isLoadingPage", "", "hasMore", "nextPageToken", "", "applyingToggle", "adapter", "Lcom/larus/agents/impl/ui/WorkExperienceAdapter;", "screenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitle", "panelBinding", "setupList", "setupToggle", "loadEnabled", "applyEnabled", "enabled", "interactive", "updateEnabled", "refresh", "loadPage", "reset", "applyPage", "page", "Lcom/larus/agents/impl/experience/WorkExperiencePage;", "allowPagination", "openDetail", "item", "openEditor", "showActions", "anchor", "createFocusBitmap", "Landroid/graphics/Bitmap;", "delete", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WorkExperienceListFragment extends Fragment {
    public static final /* synthetic */ int n = 0;
    public LarusFragmentWorkExperienceListBinding d;
    public final CachedWorkExperienceRepository e;
    public final List<com.larus.agents.impl.experience.t> f;
    public Job g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;
    public WorkExperienceAdapter l;
    public final x0 m;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.ui.WorkExperienceListFragment$delete$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceListFragment$delete$1", f = "WorkExperienceListFragment.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.agents.impl.experience.t $item;
        int label;
        final /* synthetic */ WorkExperienceListFragment this$0;

        /* JADX INFO: renamed from: com.larus.agents.impl.ui.WorkExperienceListFragment$delete$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[WorkExperienceMutationResult.values().length];
                r0[WorkExperienceMutationResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[WorkExperienceMutationResult.SECURITY_RISK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[WorkExperienceMutationResult.DUPLICATE_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[WorkExperienceMutationResult.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public AnonymousClass1(WorkExperienceListFragment r1, com.larus.agents.impl.experience.t r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$item, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            int r5 = a.a[((WorkExperienceMutationResult) r4).ordinal()];
            if (r5 != 1) goto L14;
            List<com.larus.agents.impl.experience.t> r6 = this.this$0.f;
            final com.larus.agents.impl.experience.t r2 = this.$item;
            CollectionsKt.removeAll(r6, new z(r2));
            WorkExperienceAdapter r7 = this.this$0.l;
            if (r7 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r7 = null;
        L26:
            r7.submitList(CollectionsKt.toList(this.this$0.f));
            WorkExperienceListFragment r8 = this.this$0;
            LarusFragmentWorkExperienceListBinding r3 = r8.d;
            if (r3 == null) goto L35;
            TextView r9 = r3.b;
            if (r9 == null) goto L35;
            if (((ArrayList) r8.f).isEmpty() == false) goto L33;
            int r10 = 0;
        L34:
            r9.setVisibility(r10);
            goto L35
        L33:
            r10 = 8;
        L35:
            t19.s r11 = t19.s.a;
            Context r12 = this.this$0.getContext();
            r11.getClass();
            t19.s.o(r12, 2131899713, false);
        L37:
            return Unit.INSTANCE;
        L14:
            if (r5 != 2) goto L16;
        L22:
            t19.s r13 = t19.s.a;
            Context r14 = this.this$0.getContext();
            r13.getClass();
            t19.s.s(r14, 2131902015);
            goto L37
        L16:
            if (r5 == 3) goto L22;
            if (r5 == 4) goto L22;
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CachedWorkExperienceRepository r15 = this.this$0.e;
            String r16 = this.$item.a;
            this.label = 1;
            r4 = r15.delete(r16, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public final void onDestroyView() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = false;
        this.d = null;
        super.onDestroyView();
    }

    public WorkExperienceListFragment() {
        this.e = new CachedWorkExperienceRepository(null);
        this.f = new ArrayList();
        this.m = new x0();
    }

    private final void delete(com.larus.agents.impl.experience.t r8) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void U90(boolean r9) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (r9 == false) goto L7;
    L9:
        this.h = true;
        if (r9 == false) goto L25;
        this.j = null;
        int r1 = 0;
        this.i = false;
        LarusFragmentWorkExperienceListBinding r2 = this.d;
        if (r2 == null) goto L20;
        ProgressBar r3 = r2.e;
        if (r3 == null) goto L20;
        if (((ArrayList) this.f).isEmpty() == true) goto L19;
        r1 = 8;
    L19:
        r3.setVisibility(r1);
    L20:
        LarusFragmentWorkExperienceListBinding r4 = this.d;
        if (r4 == null) goto L25;
        TextView r5 = r4.b;
        if (r5 == null) goto L25;
        r5.setVisibility(8);
    L25:
        this.g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new WorkExperienceListFragment$loadPage$1(r9, this, null), 3, null);
        return;
    L7:
        if (this.i == true) goto L9;
    }

    public final void V90(com.larus.agents.impl.experience.t r4) {
        int r0 = WorkExperienceEditorFragment.k;
        if (r4 == null) goto L5;
        String r5 = r4.a;
    L6:
        WorkExperienceEditorFragment r1 = new WorkExperienceEditorFragment();
        Bundle r2 = new Bundle();
        if (r5 == null) goto L9;
        r2.putString("experience_id", r5);
    L9:
        r1.setArguments(r2);
        FragmentManager r6 = getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "WorkExperienceEditorFragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r1, r3) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r1.show(r6, "WorkExperienceEditorFragment");
        return;
    L18:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        LarusFragmentWorkExperienceListBinding r12 = this.d;
        if (r12 != null) goto L5;
        return;
    L5:
        Context r13 = requireContext();
        NovaTitleBarEx r7 = r12.f;
        NovaTitleBarEx.Y5(r7, getString(2131907637), null, null, 6);
        NovaTitleBarEx.b6(r7, v19.c.b(2130971749, r13, 2131241477), false, null, getString(2131898805), new v(this), 6);
        NovaTitleBarEx.i6(r7, 2131242372, ImageView.ScaleType.CENTER_INSIDE, getString(2131897548), new w(this), 2);
        int r14 = c7.b(10);
        r7.getRightImg().setPadding(r14, r14, r14, r14);
        this.l = new WorkExperienceAdapter(new WorkExperienceListFragment$setupList$1(this), new WorkExperienceListFragment$setupList$2(this));
        r12.d.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView r15 = r12.d;
        RecyclerView.Adapter r0 = this.l;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L8:
        r15.setAdapter(r0);
        r12.d.addOnScrollListener(new WorkExperienceListFragment$setupList$3(this));
        r12.b.setOnClickListener(new x(this));
        r12.c.getToggleView().setEnabled(false);
        r12.c.getToggleView().setOnCheckedChangeListener(new y(this));
        this.m.d(this);
        getChildFragmentManager().setFragmentResultListener("work_experience_changed", getViewLifecycleOwner(), new p(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new WorkExperienceListFragment$loadEnabled$1(this, null), 3, null);
        U90(true);
    }

    public static Unit S90(WorkExperienceListFragment r1, com.larus.agents.impl.experience.t r2, int r3) {
        r1.m.c();
        if (r3 != 1) goto L5;
        r1.V90(r2);
    L10:
        return Unit.INSTANCE;
    L5:
        if (r3 != 2) goto L10;
        r1.delete(r2);
        goto L10
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562441, r9, false);
        int r12 = 2131393337;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131393337);
        if (r2 == null) goto L15;
        r12 = 2131393338;
        ItemTextToggle r3 = ViewBindings.findChildViewById(r11, 2131393338);
        if (r3 == null) goto L15;
        r12 = 2131393339;
        RecyclerView r4 = ViewBindings.findChildViewById(r11, 2131393339);
        if (r4 == null) goto L15;
        r12 = 2131393340;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r11, 2131393340);
        if (r5 == null) goto L15;
        r12 = 2131393342;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131393342);
        if (r6 == null) goto L15;
        LinearLayout r13 = (LinearLayout) r11;
        this.d = new LarusFragmentWorkExperienceListBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public final void T90(LarusFragmentWorkExperienceListBinding r4, com.larus.agents.impl.experience.s r5, boolean r6, boolean r7) {
        if (r6 == false) goto L4;
        ((ArrayList) this.f).clear();
    L4:
        Set r8 = SequencesKt.toMutableSet(SequencesKt.map(CollectionsKt.asSequence(this.f), new u()));
        Iterator<T> r0 = r5.a.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        com.larus.agents.impl.experience.t r1 = (com.larus.agents.impl.experience.t) r0.next();
        if (r8.add(r1.a) == false) goto L6;
        ((ArrayList) this.f).add(r1);
        goto L6
    L10:
        String r9 = r5.b;
        WorkExperienceAdapter r2 = null;
        if (r7 == false) goto L13;
        String r3 = r9;
    L14:
        this.j = r3;
        int r10 = 0;
        if (r7 == true) goto L17;
    L20:
        boolean r11 = false;
    L21:
        this.i = r11;
        WorkExperienceAdapter r12 = this.l;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L25:
        r2.submitList(CollectionsKt.toList(this.f));
        TextView r13 = r4.b;
        r13.setText(getString(2131898021));
        Intrinsics.checkNotNull(r13);
        if (((ArrayList) this.f).isEmpty() == true) goto L29;
        r10 = 8;
    L29:
        r13.setVisibility(r10);
        return;
    L24:
        r2 = r12;
        goto L25
    L17:
        if (r5.c == false) goto L20;
        if (r9 == null) goto L20;
        r11 = true;
        goto L21
    L13:
        r3 = null;
        goto L14
    }
}
