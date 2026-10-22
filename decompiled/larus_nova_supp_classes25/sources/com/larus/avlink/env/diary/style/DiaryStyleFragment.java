package com.larus.avlink.env.diary.style;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusFragmentDiaryStyleBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "TAG", "", "viewModel", "Lcom/larus/avlink/env/diary/style/DiaryStyleViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/style/DiaryStyleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentDiaryStyleBinding;", "adapter", "Lcom/larus/avlink/env/diary/style/DiaryStyleAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "setupView", "setupRefresh", "observeViewModel", "showStyleMenu", "itemView", "styleItem", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "showAddStyleDialog", "showEditStyleDialog", "showDeleteConfirmDialog", "autoLogEnterPage", "", "getCurrentPageName", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryStyleFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public final String e;
    public final Lazy f;
    public LarusFragmentDiaryStyleBinding g;
    public DiaryStyleAdapter h;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
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
        return "dora_g_diary_style";
    }

    public final DiaryStyleViewModel V90() {
        return (DiaryStyleViewModel) this.f.getValue();
    }

    public DiaryStyleFragment() {
        this.e = "DiaryStyleFragment";
        final Function0<Fragment> r0 = new DiaryStyleFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DiaryStyleViewModel.class), new DiaryStyleFragment$special$$inlined$viewModels$default$2(r0), new DiaryStyleFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.larus.avlink.env.diary.style.o] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.avlink.env.diary.style.p] */
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        FLogger.a.i(this.e, "onViewCreated");
        DiaryStyleViewModel r11 = V90();
        Bundle r12 = getArguments();
        RecyclerView.Adapter r0 = null;
        if (r12 == null) goto L5;
        Integer r13 = Integer.valueOf(r12.getInt("product_id", 16));
    L6:
        r11.setProductId(r13);
        LarusFragmentDiaryStyleBinding r14 = this.g;
        if (r14 == null) goto L11;
        NovaTitleBarEx r1 = r14.d;
        if (r1 == null) goto L11;
        NovaTitleBarEx.Y5(r1, getString(2131903869), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new n(this), 14);
    L11:
        this.h = new DiaryStyleAdapter(new o(this), new p(this));
        LarusFragmentDiaryStyleBinding r15 = this.g;
        if (r15 == null) goto L20;
        RecyclerView r16 = r15.b;
        if (r16 == null) goto L20;
        r16.setLayoutManager(new LinearLayoutManager(r16.getContext()));
        RecyclerView.Adapter r17 = this.h;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L19:
        r16.setAdapter(r0);
        r16.addItemDecoration(new DiaryStyleItemDecoration(c7.b(18)));
        goto L20
    L18:
        r0 = r17;
    L20:
        LarusFragmentDiaryStyleBinding r18 = this.g;
        if (r18 == null) goto L25;
        SwipeRefreshLayout r19 = r18.c;
        if (r19 == null) goto L25;
        r19.setOnRefreshListener(new m(this));
    L25:
        V90().getStyleListData().observe(getViewLifecycleOwner(), new a(new e(this)));
        V90().getScrollToBottom().observe(getViewLifecycleOwner(), new a(new j(this)));
        V90().isRefreshing().observe(getViewLifecycleOwner(), new a(new k(this)));
        V90().isLoading().observe(getViewLifecycleOwner(), new a(new l(this)));
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static void U90(DiaryStyleInputDialog r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562377, r4, false);
        int r7 = 2131369067;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131369067);
        if (r8 == null) goto L14;
        r7 = 2131369072;
        SwipeRefreshLayout r0 = ViewBindings.findChildViewById(r6, 2131369072);
        if (r0 == null) goto L14;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L14;
        ConstraintLayout r9 = r6;
        this.g = new LarusFragmentDiaryStyleBinding(r9, r8, r0, r1);
        if (r9 == null) goto L12;
        return r9;
    L12:
        return new View(getContext());
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
