package com.larus.avlink.env.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.env.diary.calendar.DoraEnvObserveDiaryCalendarViewModel;
import com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailActivity;
import com.larus.avlink.impl.databinding.FragmentDoraEnvObserveDiaryListBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020\u001aH\u0003J\u0016\u00100\u001a\u00020\u001a2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0015H\u0016J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u000203H\u0016J\u0018\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010:\u001a\u000203H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryListFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter$OnItemClickListener;", "<init>", "()V", "viewModel", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calendarViewModel", "Lcom/larus/avlink/env/diary/calendar/DoraEnvObserveDiaryCalendarViewModel;", "getCalendarViewModel", "()Lcom/larus/avlink/env/diary/calendar/DoraEnvObserveDiaryCalendarViewModel;", "calendarViewModel$delegate", "binding", "Lcom/larus/avlink/impl/databinding/FragmentDoraEnvObserveDiaryListBinding;", "adapter", "Lcom/larus/avlink/env/diary/DoraEnvObserveDiaryAdapter;", "TAG", "", "detailLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onDestroyView", "setupView", "showCalendarDialogInternal", "updateCardAlpha", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "setupRefresh", "observeViewModel", "updateEmptyState", "diaries", "", "Lcom/larus/avlink/env/diary/model/DiaryItem;", "autoLogEnterPage", "", "getCurrentPageName", "currentProductId", "", "onItemClick", "diaryItem", "onItemLongClick", "itemView", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryListFragment extends TraceFragment implements DoraEnvObserveDiaryAdapter.a {
    public static final /* synthetic */ int k = 0;
    public final Lazy e;
    public final Lazy f;
    public FragmentDoraEnvObserveDiaryListBinding g;
    public DoraEnvObserveDiaryAdapter h;
    public final String i;
    public ActivityResultLauncher<Intent> j;

    public static final class a implements p0 {
        public final /* synthetic */ Ref.ObjectRef<CommonDialog> a;
        public final /* synthetic */ DoraEnvObserveDiaryListFragment b;
        public final /* synthetic */ l98.a c;

        public final void confirm() {
            CommonDialog r0 = (CommonDialog) this.a.element;
            if (r0 != null) goto L14;
        L10:
            FLogger.a.i(this.b.i, "onConfirm: delete diary " + this.c.e());
            String r1 = this.c.e();
            if (r1 == null) goto L16;
            DoraEnvObserveDiaryListFragment r2 = this.b;
            r2.V90().deleteDiary(r2.getContext(), CollectionsKt.listOf(r1));
            return;
        L16:
            return;
        L14:
            r0.dismiss();     // Catch: Exception -> L6
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L10;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }

        public a(Ref.ObjectRef<CommonDialog> r1, DoraEnvObserveDiaryListFragment r2, l98.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b implements u {
        public final /* synthetic */ Ref.ObjectRef<CommonDialog> a;

        public final void cancel() {
            CommonDialog r0 = (CommonDialog) this.a.element;
            if (r0 == null) goto L13;
            r0.dismiss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r1 = DialogFragmentLancet.sLastShowStack;
            if (r1 == null) goto L14;
            com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }

        public b(Ref.ObjectRef<CommonDialog> r1) {
            this.a = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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
        return "dora_g_diary_list";
    }

    public final DoraEnvObserveDiaryViewModel V90() {
        return (DoraEnvObserveDiaryViewModel) this.e.getValue();
    }

    public DoraEnvObserveDiaryListFragment() {
        final Function0<Fragment> r0 = new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryViewModel.class), new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$2(r0), new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$4(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryCalendarViewModel.class), new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$5(r1), new DoraEnvObserveDiaryListFragment$special$$inlined$viewModels$default$6(r1, this));
        this.i = "DoraEnvObserveDiary";
    }

    public final int U90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return 16;
    L5:
        return r0.getInt("product_id", 16);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
    }

    public final void onResume() {
        super.onResume();
        FragmentDoraEnvObserveDiaryListBinding r0 = this.g;
        if (r0 == null) goto L16;
        ConstraintLayout r1 = r0.g;
        if (r1 == null) goto L16;
        int r2 = 0;
        if (z2.a.t3() == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L15;
        r2 = 8;
    L15:
        r1.setVisibility(r2);
        goto L16
    L9:
        if (V90().isEnvObserveEnable() == true) goto L11;
        r3 = true;
    L16:
        V90().refresh();
    }

    public final void W90(List<l98.a> r5) {
        boolean r6 = r5.isEmpty();
        FragmentDoraEnvObserveDiaryListBinding r0 = this.g;
        int r1 = 0;
        if (r0 == null) goto L10;
        TextView r2 = r0.b;
        if (r2 == null) goto L10;
        if (r6 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        goto L10
    L8:
        r3 = 8;
    L10:
        FragmentDoraEnvObserveDiaryListBinding r4 = this.g;
        if (r4 == null) goto L20;
        RecyclerView r7 = r4.i;
        if (r7 != null) goto L15;
        return;
    L15:
        if ((!r6) == true) goto L18;
        r1 = 8;
    L18:
        r7.setVisibility(r1);
        return;
    }

    @Override // com.larus.avlink.env.diary.DoraEnvObserveDiaryAdapter.a
    public final void Zx(l98.a r4) {
        Intrinsics.checkNotNullParameter(r4, "diaryItem");
        Intent r0 = new Intent(getContext(), DoraEnvObserveDiaryDetailActivity.class);
        r0.putExtra("diary_id", r4.e());
        r0.putExtra("product_id", U90());
        by7.h.i(r0, this);
        ActivityResultLauncher<Intent> r5 = this.j;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("detailLauncher");
        r5 = null;
    L5:
        r5.launch(r0);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n(this));
    }

    @Override // com.larus.avlink.env.diary.DoraEnvObserveDiaryAdapter.a
    public final void FO(final View r54, final l98.a r55) {
        Intrinsics.checkNotNullParameter(r54, "itemView");
        Intrinsics.checkNotNullParameter(r55, "diaryItem");
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        View r2 = CreateMenu.f(new CreateMenu(requireContext()), CollectionsKt.listOf(new l0(2131902471, 2131902471, null, null, null, 2131102650, null, 2131241933, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)), 0, false, null, null, null, null, new p(r10, r55, r54, this), 510);
        Balloon r0 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r54, r2, false, null, null, null, null, 124);
        r10.element = r0;
        r0.v(r54, i5.m0(), i5.t0());
    }

    public final void onViewCreated(View r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r19, r20);
        FLogger.a.i(this.i, "onViewCreated, calendarViewModel hash: " + ((DoraEnvObserveDiaryCalendarViewModel) this.f.getValue()).hashCode());
        V90().setJumpProductId(Integer.valueOf(U90()));
        ((DoraEnvObserveDiaryCalendarViewModel) this.f.getValue()).setJumpProductId(Integer.valueOf(U90()));
        FragmentDoraEnvObserveDiaryListBinding r1 = this.g;
        if (r1 == null) goto L7;
        NovaTitleBarEx r2 = r1.k;
        if (r2 == null) goto L7;
        NovaTitleBarEx.Y5(r2, getString(2131903336), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new g(this), 14);
        NovaTitleBarEx.i6(r2, 2131242049, null, null, new h(this), 14);
        NovaTitleBarEx.k6(r2, 2131241181, 0.0f, null, null, new i(this), 30);
    L7:
        this.h = new DoraEnvObserveDiaryAdapter(this);
        FragmentDoraEnvObserveDiaryListBinding r3 = this.g;
        if (r3 == null) goto L12;
        RecyclerView r4 = r3.i;
        if (r4 == null) goto L12;
        r4.setLayoutManager(new LinearLayoutManager(getContext()));
    L12:
        FragmentDoraEnvObserveDiaryListBinding r5 = this.g;
        if (r5 == null) goto L20;
        RecyclerView r6 = r5.i;
        if (r6 == null) goto L20;
        RecyclerView.Adapter r7 = this.h;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r7 = null;
    L19:
        r6.setAdapter(r7);
    L20:
        FragmentDoraEnvObserveDiaryListBinding r8 = this.g;
        if (r8 == null) goto L25;
        RecyclerView r9 = r8.i;
        if (r9 == null) goto L25;
        r9.setClipToPadding(false);
    L25:
        FragmentDoraEnvObserveDiaryListBinding r10 = this.g;
        if (r10 == null) goto L30;
        RecyclerView r11 = r10.i;
        if (r11 == null) goto L30;
        r11.addItemDecoration(new DoraEnvObserveDiaryListFragment$setupView$2());
    L30:
        TopPagerSnapHelper r12 = new TopPagerSnapHelper();
        FragmentDoraEnvObserveDiaryListBinding r13 = this.g;
        if (r13 == null) goto L33;
        RecyclerView r14 = r13.i;
    L34:
        r12.attachToRecyclerView(r14);
        FragmentDoraEnvObserveDiaryListBinding r15 = this.g;
        if (r15 == null) goto L39;
        RecyclerView r16 = r15.i;
        if (r16 == null) goto L39;
        r16.addOnScrollListener(new DoraEnvObserveDiaryListFragment$setupView$3(this));
    L39:
        FragmentDoraEnvObserveDiaryListBinding r17 = this.g;
        if (r17 == null) goto L44;
        TextView r18 = r17.h;
        if (r18 == null) goto L44;
        r18.setOnClickListener(new q(this));
    L44:
        FragmentDoraEnvObserveDiaryListBinding r21 = this.g;
        if (r21 == null) goto L49;
        SwipeRefreshLayout r22 = r21.j;
        if (r22 == null) goto L49;
        r22.setOnRefreshListener(new j(this));
    L49:
        V90().getDiaries().observe(getViewLifecycleOwner(), new c(new k(this)));
        V90().isRefreshing().observe(getViewLifecycleOwner(), new c(new l(this)));
        V90().isLoading().observe(getViewLifecycleOwner(), new c(new m(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraEnvObserveDiaryListFragment$observeViewModel$4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraEnvObserveDiaryListFragment$observeViewModel$5(this, null), 3, null);
        ((DoraEnvObserveDiaryCalendarViewModel) this.f.getValue()).loadCalendarEmotions();
        return;
    L33:
        r14 = null;
        goto L34
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        LinearLayoutCompat r16 = r13.inflate(2131561187, r14, false);
        int r17 = 2131369040;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r16, 2131369040);
        if (r2 == null) goto L30;
        r17 = 2131369043;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r16, 2131369043);
        if (r3 == null) goto L30;
        r17 = 2131369045;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131369045);
        if (r4 == null) goto L30;
        r17 = 2131369046;
        LottieAdapterView r5 = ViewBindings.findChildViewById(r16, 2131369046);
        if (r5 == null) goto L30;
        r17 = 2131369078;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r16, 2131369078);
        if (r6 == null) goto L30;
        r17 = 2131369515;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r16, 2131369515);
        if (r7 == null) goto L30;
        r17 = 2131369516;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r16, 2131369516);
        if (r8 == null) goto L30;
        r17 = 2131369517;
        if (((TextView) ViewBindings.findChildViewById(r16, 2131369517)) == null) goto L30;
        r17 = 2131369533;
        RecyclerView r9 = ViewBindings.findChildViewById(r16, 2131369533);
        if (r9 == null) goto L30;
        r17 = 2131369534;
        SwipeRefreshLayout r10 = ViewBindings.findChildViewById(r16, 2131369534);
        if (r10 == null) goto L30;
        r17 = 2131388772;
        NovaTitleBarEx r11 = ViewBindings.findChildViewById(r16, 2131388772);
        if (r11 == null) goto L30;
        LinearLayoutCompat r18 = r16;
        this.g = new FragmentDoraEnvObserveDiaryListBinding(r18, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        if (r18 == null) goto L28;
        return r18;
    L28:
        return new View(getContext());
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
