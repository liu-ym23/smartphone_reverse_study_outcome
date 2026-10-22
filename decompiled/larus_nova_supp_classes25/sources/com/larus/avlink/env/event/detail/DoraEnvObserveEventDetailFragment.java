package com.larus.avlink.env.event.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.env.event.DoraEnvObserveEventViewModel;
import com.larus.avlink.env.event.model.EnvObserveMemoryEvent;
import com.larus.avlink.impl.databinding.FragmentDoraEnvObserveEventDetailBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.s0;
import com.skydoves.balloon.Balloon;
import java.io.Serializable;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/avlink/env/event/detail/DoraEnvObserveEventDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/FragmentDoraEnvObserveEventDetailBinding;", "viewModel", "Lcom/larus/avlink/env/event/DoraEnvObserveEventViewModel;", "getViewModel", "()Lcom/larus/avlink/env/event/DoraEnvObserveEventViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "currentEvent", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "menu", "Lcom/skydoves/balloon/Balloon;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupTitleBar", "observeViewModel", "updateUI", "detail", "showMoreMenu", "onDestroyView", "autoLogEnterPage", "", "getCurrentPageName", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveEventDetailFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public FragmentDoraEnvObserveEventDetailBinding e;
    public final Lazy f;
    public EnvObserveMemoryEvent g;
    public Balloon h;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(c r2) {
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
        return "dora_g_event_detail";
    }

    public DoraEnvObserveEventDetailFragment() {
        final Function0<Fragment> r0 = new DoraEnvObserveEventDetailFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveEventViewModel.class), new DoraEnvObserveEventDetailFragment$special$$inlined$viewModels$default$2(r0), new DoraEnvObserveEventDetailFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Balloon r0 = this.h;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.e = null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.avlink.env.event.detail.c] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        FragmentDoraEnvObserveEventDetailBinding r13 = this.e;
        EnvObserveMemoryEvent r14 = null;
        if (r13 == null) goto L7;
        NovaTitleBarEx r15 = r13.g;
        if (r15 == null) goto L7;
        NovaTitleBarEx.Y5(r15, "", null, null, 6);
        NovaTitleBarEx.b6(r15, 2131241477, false, null, null, new com.larus.avlink.env.event.detail.a(this), 14);
        NovaTitleBarEx.i6(r15, 2131240955, null, null, new b(this), 14);
    L7:
        DoraEnvObserveEventViewModel r16 = (DoraEnvObserveEventViewModel) this.f.getValue();
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        Integer r1 = Integer.valueOf(r0.getInt("product_id", 16));
    L11:
        r16.setProductId(r1);
        ((DoraEnvObserveEventViewModel) this.f.getValue()).getDeleteSuccess().observe(getViewLifecycleOwner(), new a(new c(this)));
        Bundle r17 = getArguments();
        if (r17 == null) goto L14;
        Serializable r18 = r17.getSerializable("event_data");
    L16:
        if ((r18 instanceof EnvObserveMemoryEvent) == false) goto L18;
        r14 = (EnvObserveMemoryEvent) r18;
    L18:
        if (r14 == null) goto L52;
        this.g = r14;
        FragmentDoraEnvObserveEventDetailBinding r19 = this.e;
        if (r19 == null) goto L24;
        TextView r110 = r19.e;
        if (r110 == null) goto L24;
        r110.setText(r14.getTitle());
    L24:
        FragmentDoraEnvObserveEventDetailBinding r111 = this.e;
        if (r111 == null) goto L29;
        TextView r112 = r111.f;
        if (r112 == null) goto L29;
        s0.b(r112, r14.getType());
    L29:
        Long r113 = r14.getStartTime();
        long r2 = 0;
        if (r113 == null) goto L32;
        long r3 = r113.longValue();
    L33:
        long r4 = 1000;
        long r5 = r3 * r4;
        Long r114 = r14.getEndTime();
        if (r114 == null) goto L36;
        r2 = r114.longValue();
    L36:
        long r6 = r2 * r4;
        FragmentDoraEnvObserveEventDetailBinding r115 = this.e;
        if (r115 == null) goto L41;
        TextView r116 = r115.c;
        if (r116 == null) goto L41;
        s0.b(r116, ia8.d.b(r5));
    L41:
        FragmentDoraEnvObserveEventDetailBinding r117 = this.e;
        if (r117 == null) goto L46;
        TextView r118 = r117.d;
        if (r118 == null) goto L46;
        s0.b(r118, ia8.d.c(r5) + " - " + ia8.d.c(r6));
    L46:
        FragmentDoraEnvObserveEventDetailBinding r119 = this.e;
        if (r119 == null) goto L53;
        TextView r120 = r119.b;
        if (r120 == null) goto L54;
        r120.setText(r14.getContent());
        return;
    L54:
        return;
    L53:
        return;
    L32:
        r3 = 0;
        goto L33
    L52:
        return;
    L14:
        r18 = null;
        goto L16
    L10:
        r1 = null;
        goto L11
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        LinearLayoutCompat r12 = r9.inflate(2131561188, r10, false);
        int r13 = 2131371821;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r12, 2131371821);
        if (r2 == null) goto L20;
        r13 = 2131371822;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r12, 2131371822);
        if (r3 == null) goto L20;
        r13 = 2131371824;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131371824);
        if (r4 == null) goto L20;
        r13 = 2131371825;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131371825);
        if (r5 == null) goto L20;
        r13 = 2131371826;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, 2131371826);
        if (r6 == null) goto L20;
        r13 = 2131388772;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L20;
        LinearLayoutCompat r14 = r12;
        this.e = new FragmentDoraEnvObserveEventDetailBinding(r14, r2, r3, r4, r5, r6, r7);
        if (r14 == null) goto L18;
        return r14;
    L18:
        return new View(getContext());
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
