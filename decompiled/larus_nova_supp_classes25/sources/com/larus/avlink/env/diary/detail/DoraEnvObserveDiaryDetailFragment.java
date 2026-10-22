package com.larus.avlink.env.diary.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.env.diary.feedback.model.DiaryFeedbackToastType;
import com.larus.avlink.impl.databinding.FragmentDoraEnvObserveDiaryDetailBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020 H\u0016J\u0017\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/FragmentDoraEnvObserveDiaryDetailBinding;", "viewModel", "Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/detail/DoraEnvObserveDiaryDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "menu", "Lcom/skydoves/balloon/Balloon;", "currentDiary", "Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "latestToastEffectId", "", "Ljava/lang/Long;", "adapter", "Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter;", "TAG", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateRecyclerViewData", "detail", "(Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFeedbackBottomSheetIfNeeded", "handleFeedbackEntryAction", "action", "Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$FeedbackEntryAction;", "showMoreMenu", "onDestroyView", "calculateDaysSinceCreation", "", "createTime", "(Ljava/lang/Long;)I", "autoLogEnterPage", "", "getCurrentPageName", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveDiaryDetailFragment extends TraceFragment {
    public static final /* synthetic */ int k = 0;
    public FragmentDoraEnvObserveDiaryDetailBinding e;
    public final Lazy f;
    public i98.a g;
    public Long h;
    public DiaryDetailAdapter i;
    public final String j;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DiaryFeedbackToastType.values().length];
            r0[DiaryFeedbackToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DiaryFeedbackToastType.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DiaryFeedbackToastType.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<DiaryDetailAdapter.b, Unit> {
        public AnonymousClass2(Object r8) {
            super(1, r8, DoraEnvObserveDiaryDetailFragment.class, "handleFeedbackEntryAction", "handleFeedbackEntryAction(Lcom/larus/avlink/env/diary/detail/DiaryDetailAdapter$FeedbackEntryAction;)V", 0);
        }

        public final void invoke(DiaryDetailAdapter.b r4) {
            Intrinsics.checkNotNullParameter(r4, "p0");
            DoraEnvObserveDiaryDetailFragment r0 = (DoraEnvObserveDiaryDetailFragment) ((CallableReference) this).receiver;
            int r1 = DoraEnvObserveDiaryDetailFragment.k;
            r0.getClass();
            if (Intrinsics.areEqual(r4, DiaryDetailAdapter.b.a.a) == false) goto L6;
            r0.U90().previewFeedbackActionType(0);
            r0.U90().cancelFeedback();
            return;
        L6:
            if ((r4 instanceof DiaryDetailAdapter.b.C0006b) == false) goto L10;
            DiaryDetailAdapter.b.C0006b r5 = (DiaryDetailAdapter.b.C0006b) r4;
            r0.U90().previewFeedbackActionType(r5.a);
            r0.U90().openFeedbackSheet(r5.a, r5.b);
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((DiaryDetailAdapter.b) r1);
            return Unit.INSTANCE;
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_g_diary_detail";
    }

    public final DoraEnvObserveDiaryDetailViewModel U90() {
        return (DoraEnvObserveDiaryDetailViewModel) this.f.getValue();
    }

    public DoraEnvObserveDiaryDetailFragment() {
        final Function0<Fragment> r0 = new DoraEnvObserveDiaryDetailFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryDetailViewModel.class), new DoraEnvObserveDiaryDetailFragment$special$$inlined$viewModels$default$2(r0), new DoraEnvObserveDiaryDetailFragment$special$$inlined$viewModels$default$3(r0, this));
        this.j = "DoraEnvObserveDiary";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        FragmentDoraEnvObserveDiaryDetailBinding r12 = this.e;
        String r13 = null;
        if (r12 == null) goto L7;
        NovaTitleBarEx r14 = r12.d;
        if (r14 == null) goto L7;
        NovaTitleBarEx.Y5(r14, "", null, null, 6);
        NovaTitleBarEx.b6(r14, 2131241477, false, null, null, new c0(this), 14);
        NovaTitleBarEx.i6(r14, 2131240955, null, null, new d0(this), 14);
    L7:
        this.i = new DiaryDetailAdapter(requireContext(), this, new AnonymousClass2(this));
        FragmentDoraEnvObserveDiaryDetailBinding r15 = this.e;
        if (r15 == null) goto L15;
        RecyclerView r16 = r15.b;
        if (r16 == null) goto L15;
        r16.setLayoutManager(new LinearLayoutManager(r16.getContext()));
        RecyclerView.Adapter r0 = this.i;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L14:
        r16.setAdapter(r0);
    L15:
        U90().isLoading$dora_avlink_impl_release().observe(getViewLifecycleOwner(), new b(new e0(this)));
        U90().getDiaryDetailLiveData().observe(getViewLifecycleOwner(), new b(new f0(this)));
        U90().getToastEffect().observe(getViewLifecycleOwner(), new b(new g0(this)));
        U90().getFeedbackSheetState().observe(getViewLifecycleOwner(), new b(new h0(this)));
        Bundle r17 = getArguments();
        if (r17 == null) goto L18;
        r13 = r17.getString("diary_id");
    L18:
        if (r13 == null) goto L20;
        FLogger.a.d(this.j, "Fetching diary detail for id: ".concat(r13));
        U90().fetchDiaryDetail(r13);
        return;
    L20:
        FLogger.a.e(this.j, "diary_id is null");
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        LinearLayoutCompat r6 = r3.inflate(2131561186, r4, false);
        int r7 = 2131368905;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131368905);
        if (r8 == null) goto L14;
        r7 = 2131378977;
        ProgressBar r0 = (ProgressBar) ViewBindings.findChildViewById(r6, 2131378977);
        if (r0 == null) goto L14;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L14;
        LinearLayoutCompat r9 = r6;
        this.e = new FragmentDoraEnvObserveDiaryDetailBinding(r9, r8, r0, r1);
        if (r9 == null) goto L12;
        return r9;
    L12:
        return new View(getContext());
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
