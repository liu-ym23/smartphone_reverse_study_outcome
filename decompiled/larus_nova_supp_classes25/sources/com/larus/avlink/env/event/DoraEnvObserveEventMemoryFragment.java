package com.larus.avlink.env.event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.env.event.detail.DoraEnvObserveEventDetailActivity;
import com.larus.avlink.env.event.model.EnvObserveMemoryEvent;
import com.larus.avlink.impl.databinding.FragmentDoraEnvObserveEventListBinding;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.refresh.RefreshHeaderLayout;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0016\u0010!\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J0\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter$OnItemClickListener;", "<init>", "()V", "viewModel", "Lcom/larus/avlink/env/event/DoraEnvObserveEventViewModel;", "getViewModel", "()Lcom/larus/avlink/env/event/DoraEnvObserveEventViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "listAdapter", "Lcom/larus/avlink/env/event/DoraEnvObserveEventMemoryListAdapter;", "binding", "Lcom/larus/avlink/impl/databinding/FragmentDoraEnvObserveEventListBinding;", "detailLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupView", "setupRefresh", "observeViewModel", "updateEmptyState", "items", "", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryItem;", "updateLoadingOrRetryState", "loadingOrRetry", "Lcom/larus/avlink/record/ui/RecordMinutesLoadingOrRetryView;", "isLoading", "", "hasError", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "", "onEventClick", "event", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "onDeleteClick", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveEventMemoryFragment extends TraceFragment implements DoraEnvObserveEventMemoryListAdapter.a {
    public static final /* synthetic */ int i = 0;
    public final Lazy e;
    public DoraEnvObserveEventMemoryListAdapter f;
    public FragmentDoraEnvObserveEventListBinding g;
    public ActivityResultLauncher<Intent> h;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ EnvObserveMemoryEvent a;
        public final /* synthetic */ DoraEnvObserveEventMemoryFragment b;

        public final void confirm() {
            String r0 = this.a.getId();
            if (r0 == null) goto L6;
            DoraEnvObserveEventMemoryFragment r1 = this.b;
            int r2 = DoraEnvObserveEventMemoryFragment.i;
            r1.U90().deleteMemory(r0);
            return;
        }

        public b(EnvObserveMemoryEvent r1, DoraEnvObserveEventMemoryFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public c() {
        }

        public final void cancel() {
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
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

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_g_event_list";
    }

    public final DoraEnvObserveEventViewModel U90() {
        return (DoraEnvObserveEventViewModel) this.e.getValue();
    }

    public DoraEnvObserveEventMemoryFragment() {
        final Function0<Fragment> r0 = new DoraEnvObserveEventMemoryFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveEventViewModel.class), new DoraEnvObserveEventMemoryFragment$special$$inlined$viewModels$default$2(r0), new DoraEnvObserveEventMemoryFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.g = null;
    }

    public final void V90(List<? extends o98.c> r5) {
        FragmentDoraEnvObserveEventListBinding r0 = this.g;
        int r1 = 0;
        if (r0 == null) goto L9;
        ConstraintLayout r2 = r0.e;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L23;
        FragmentDoraEnvObserveEventListBinding r6 = this.g;
        if (r6 == null) goto L17;
        RecyclerView r7 = r6.b;
        if (r7 == null) goto L17;
        r7.setVisibility(8);
    L17:
        FragmentDoraEnvObserveEventListBinding r8 = this.g;
        if (r8 == null) goto L40;
        TextView r9 = r8.d;
        if (r9 == null) goto L41;
        r9.setVisibility(8);
        return;
    L41:
        return;
    L40:
        return;
    L23:
        boolean r10 = r5.isEmpty();
        FragmentDoraEnvObserveEventListBinding r4 = this.g;
        if (r4 == null) goto L31;
        RecyclerView r11 = r4.b;
        if (r11 == null) goto L31;
        if (r10 == false) goto L29;
        int r12 = 8;
    L30:
        r11.setVisibility(r12);
        goto L31
    L29:
        r12 = 0;
    L31:
        FragmentDoraEnvObserveEventListBinding r13 = this.g;
        if (r13 == null) goto L42;
        TextView r14 = r13.d;
        if (r14 == null) goto L43;
        if (r10 == true) goto L38;
        r1 = 8;
    L38:
        r14.setVisibility(r1);
        return;
    L43:
        return;
    L42:
        return;
    L9:
        r3 = false;
        goto L11
    }

    @Override // com.larus.avlink.env.event.DoraEnvObserveEventMemoryListAdapter.a
    public final void fF(EnvObserveMemoryEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        String r0 = getString(2131903879);
        String r1 = getString(2131901647);
        String r2 = getString(2131901590);
        String r3 = getString(2131901595);
        FragmentManager r4 = getChildFragmentManager();
        CommonDialog.a r5 = new CommonDialog.a();
        r5.i(r0);
        r5.g(r1);
        CommonDialog.a.f(r5, new b(r7, this), r3, false, 12);
        CommonDialog.a.e(r5, new c(), r2, 4);
        CommonDialog r8 = r5.a();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, null, r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r8, r6) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r8.show(r4, null);
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(this));
    }

    @Override // com.larus.avlink.env.event.DoraEnvObserveEventMemoryListAdapter.a
    public void onEventClick(EnvObserveMemoryEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intent r0 = new Intent(getContext(), DoraEnvObserveEventDetailActivity.class);
        r0.putExtra("event_data", r4);
        Bundle r5 = getArguments();
        int r1 = 16;
        if (r5 == null) goto L5;
        r1 = r5.getInt("product_id", 16);
    L5:
        r0.putExtra("product_id", r1);
        by7.h.i(r0, this);
        ActivityResultLauncher<Intent> r6 = this.h;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("detailLauncher");
        r6 = null;
    L8:
        r6.launch(r0);
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        DoraEnvObserveEventViewModel r11 = U90();
        Bundle r12 = getArguments();
        DoraEnvObserveEventMemoryListAdapter r0 = null;
        if (r12 == null) goto L5;
        Integer r13 = Integer.valueOf(r12.getInt("product_id", 16));
    L6:
        r11.setProductId(r13);
        Bundle r14 = getArguments();
        boolean r15 = false;
        if (r14 == null) goto L9;
        r15 = r14.getBoolean("arg_hide_title", false);
    L9:
        if (r15 == false) goto L15;
        FragmentDoraEnvObserveEventListBinding r16 = this.g;
        if (r16 == null) goto L20;
        NovaTitleBarEx r17 = r16.f;
        if (r17 == null) goto L20;
        r17.setVisibility(8);
    L20:
        this.f = new DoraEnvObserveEventMemoryListAdapter(this);
        FragmentDoraEnvObserveEventListBinding r18 = this.g;
        if (r18 == null) goto L29;
        RecyclerView r19 = r18.b;
        if (r19 == null) goto L29;
        r19.setLayoutManager(new LinearLayoutManager(r19.getContext()));
        DoraEnvObserveEventMemoryListAdapter r110 = this.f;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L28:
        r19.setAdapter(r0);
        r19.addOnScrollListener(new DoraEnvObserveEventMemoryFragment$setupView$2$1(this));
        goto L29
    L27:
        r0 = r110;
    L29:
        Context r20 = getContext();
        if (r20 == null) goto L36;
        FragmentDoraEnvObserveEventListBinding r111 = this.g;
        if (r111 == null) goto L36;
        SuperSwipeRefreshLayout r112 = r111.c;
        if (r112 == null) goto L36;
        r112.setRefreshHeader(new RefreshHeaderLayout(r20));
        r112.setOnRefreshListener(new h(this));
    L36:
        FragmentDoraEnvObserveEventListBinding r21 = this.g;
        if (r21 == null) goto L41;
        RecordMinutesLoadingOrRetryView r22 = r21.e;
        if (r22 == null) goto L41;
        r22.setOnRetryClick(new i(this));
    L41:
        U90().getEventList().observe(getViewLifecycleOwner(), new d(new com.larus.avlink.env.event.a(this)));
        U90().isLoadDataLoading().observe(getViewLifecycleOwner(), new d(new com.larus.avlink.env.event.b(this)));
        U90().getError().observe(getViewLifecycleOwner(), new d(new com.larus.avlink.env.event.c(this)));
        U90().isRefreshing().observe(getViewLifecycleOwner(), new d(new com.larus.avlink.env.event.d(this)));
        U90().getDeleteSuccess().observe(getViewLifecycleOwner(), new d(new e(this)));
        U90().refresh();
        return;
    L15:
        FragmentDoraEnvObserveEventListBinding r23 = this.g;
        if (r23 == null) goto L20;
        NovaTitleBarEx r1 = r23.f;
        if (r1 == null) goto L20;
        NovaTitleBarEx.Y5(r1, getString(2131903340), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new g(this), 14);
        goto L20
    L5:
        r13 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        LinearLayoutCompat r11 = r8.inflate(2131561189, r9, false);
        int r12 = 2131369535;
        RecyclerView r2 = ViewBindings.findChildViewById(r11, 2131369535);
        if (r2 == null) goto L18;
        r12 = 2131369536;
        SuperSwipeRefreshLayout r3 = ViewBindings.findChildViewById(r11, 2131369536);
        if (r3 == null) goto L18;
        r12 = 2131371823;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131371823);
        if (r4 == null) goto L18;
        r12 = 2131379049;
        RecordMinutesLoadingOrRetryView r5 = (RecordMinutesLoadingOrRetryView) ViewBindings.findChildViewById(r11, 2131379049);
        if (r5 == null) goto L18;
        r12 = 2131388772;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L18;
        LinearLayoutCompat r13 = r11;
        this.g = new FragmentDoraEnvObserveEventListBinding(r13, r2, r3, r4, r5, r6);
        if (r13 == null) goto L16;
        return r13;
    L16:
        return new View(getContext());
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W90(RecordMinutesLoadingOrRetryView r3, boolean r4, boolean r5, List<? extends o98.c> r6) {
        if (r6.isEmpty() == false) goto L7;
        if (r4 == true) goto L6;
        if (r5 == false) goto L7;
    L6:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L14;
        if (r3 == 0) goto L12;
        r3.setVisibility(8);
    L12:
        V90(r6);
        return;
    L14:
        if (r3 == 0) goto L16;
        r3.setVisibility(0);
    L16:
        if (r5 == false) goto L19;
        if (r3 == 0) goto L21;
        r3.S5();
    L21:
        FragmentDoraEnvObserveEventListBinding r8 = this.g;
        if (r8 == null) goto L26;
        RecyclerView r9 = r8.b;
        if (r9 == null) goto L26;
        r9.setVisibility(8);
    L26:
        FragmentDoraEnvObserveEventListBinding r10 = this.g;
        if (r10 == null) goto L32;
        TextView r11 = r10.d;
        if (r11 == null) goto L33;
        r11.setVisibility(8);
        return;
    L33:
        return;
    L32:
        return;
    L19:
        if (r3 == 0) goto L21;
        r3.R5();
    L7:
        r7 = false;
        goto L9
    }
}
