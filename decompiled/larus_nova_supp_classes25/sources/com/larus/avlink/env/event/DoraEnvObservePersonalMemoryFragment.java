package com.larus.avlink.env.event;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter$OnItemClickListener;", "<init>", "()V", "adapter", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryListAdapter;", "viewModel", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "getViewModel", "()Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onAddClick", "onEditClick", "item", "Lcom/larus/avlink/env/event/api/UserProfileEntry;", "onDeleteClick", "autoLogEnterPage", "", "getCurrentPageName", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObservePersonalMemoryFragment extends TraceFragment implements DoraEnvObservePersonalMemoryListAdapter.b {
    public static final /* synthetic */ int g = 0;
    public DoraEnvObservePersonalMemoryListAdapter e;
    public final Lazy f;

    public static final class a implements p0 {
        public final /* synthetic */ n98.e a;
        public final /* synthetic */ DoraEnvObservePersonalMemoryFragment b;

        public final void confirm() {
            Long r0 = this.a.b();
            if (r0 == null) goto L6;
            DoraEnvObservePersonalMemoryFragment r1 = this.b;
            long r2 = r0.longValue();
            int r3 = DoraEnvObservePersonalMemoryFragment.g;
            r1.V90().deleteMemory(r2);
            return;
        }

        public a(n98.e r1, DoraEnvObservePersonalMemoryFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        public final void cancel() {
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
        return "personal_memory_fragment";
    }

    public final DoraEnvObservePersonalMemoryViewModel V90() {
        return (DoraEnvObservePersonalMemoryViewModel) this.f.getValue();
    }

    public DoraEnvObservePersonalMemoryFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObservePersonalMemoryViewModel.class), new DoraEnvObservePersonalMemoryFragment$special$$inlined$activityViewModels$default$1(this), new DoraEnvObservePersonalMemoryFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        if (V90().getError().getValue() == null) goto L6;
        V90().loadData();
        return;
    }

    @Override // com.larus.avlink.env.event.DoraEnvObservePersonalMemoryListAdapter.b
    public final void r2() {
        List r0 = (List) V90().getEntries().getValue();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        e10 r2 = e10.a;
        int r3 = e10.O();
        if (r1 < r3) goto L15;
        Context r4 = getContext();
        if (r4 == null) goto L12;
        String r5 = r4.getString(2131902528, new Object[]{Integer.valueOf(r3)});
        if (r5 == null) goto L12;
    L13:
        t19.s.j(t19.s.a, getContext(), r5, null, false, 28);
        return;
    L12:
        r5 = "";
        goto L13
    L15:
        U90(new DoraEnvObservePersonalMemoryEditDialog(), getChildFragmentManager());
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.larus.avlink.env.event.DoraEnvObservePersonalMemoryListAdapter.b
    public final void L50(n98.e r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        int r0 = DoraEnvObservePersonalMemoryEditDialog.k;
        Long r1 = r7.b();
        String r8 = r7.a();
        DoraEnvObservePersonalMemoryEditDialog r2 = new DoraEnvObservePersonalMemoryEditDialog();
        Bundle r3 = new Bundle();
        if (r1 == null) goto L5;
        r3.putLong("arg_entry_id", r1.longValue());
    L5:
        if (r8 == null) goto L7;
        r3.putString("arg_content", r8);
    L7:
        r2.setArguments(r3);
        U90(r2, getChildFragmentManager());
    }

    @Override // com.larus.avlink.env.event.DoraEnvObservePersonalMemoryListAdapter.b
    public final void Lx(n98.e r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Context r0 = getContext();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getString(2131902097);
        if (r2 == null) goto L6;
    L7:
        Context r3 = getContext();
        if (r3 == null) goto L11;
        String r4 = r3.getString(2131901598);
        if (r4 == null) goto L11;
    L12:
        Context r5 = getContext();
        if (r5 == null) goto L16;
        String r6 = r5.getString(2131907330);
        if (r6 == null) goto L16;
    L17:
        Context r7 = getContext();
        if (r7 == null) goto L23;
        String r9 = r7.getString(2131902168);
        if (r9 == null) goto L23;
        r1 = r9;
    L23:
        FragmentManager r10 = getChildFragmentManager();
        CommonDialog.a r11 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r2, "title");
        r11.a = r2;
        Intrinsics.checkNotNullParameter(r4, "message");
        r11.i = r4;
        CommonDialog.a.f(r11, new a(r8, this), r1, false, 12);
        CommonDialog.a.e(r11, new b(), r6, 4);
        CommonDialog r12 = r11.a();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r12, r13) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L27:
        r12.show(r10, null);
        return;
    L32:
        return;
    L16:
        r6 = "";
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    public static void U90(DoraEnvObservePersonalMemoryEditDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PersonalMemoryEditDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "PersonalMemoryEditDialog");
    }

    public final void onViewCreated(final View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        DoraEnvObservePersonalMemoryViewModel r8 = V90();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getInt("product_id", 16));
    L6:
        r8.setProductId(r1);
        RecyclerView r9 = r6.findViewById(2131384987);
        final RecordMinutesLoadingOrRetryView r2 = (RecordMinutesLoadingOrRetryView) r6.findViewById(2131379049);
        final LinearLayout r3 = (LinearLayout) r6.findViewById(2131378645);
        r9.setLayoutManager(new LinearLayoutManager(getContext()));
        DoraEnvObservePersonalMemoryListAdapter r4 = new DoraEnvObservePersonalMemoryListAdapter(this);
        this.e = r4;
        r9.setAdapter(r4);
        r2.setOnRetryClick(new v(this));
        r9.addOnScrollListener(new AnonymousClass2(this));
        V90().isLoadDataLoading().observe(getViewLifecycleOwner(), new c(new w(r2, r3, this)));
        V90().getError().observe(getViewLifecycleOwner(), new c(new x(r2, r3)));
        V90().getEntries().observe(getViewLifecycleOwner(), new c(new y(this, r6)));
        V90().getDeleteSuccess().observe(getViewLifecycleOwner(), new c(new z(this)));
        V90().loadData();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562422, r3, false);
    }
}
