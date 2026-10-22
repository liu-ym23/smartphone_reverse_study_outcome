package com.larus.community.impl.publish;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.community.impl.publish.viewmodel.CreationPublishTitleState;
import com.larus.community.impl.publish.viewmodel.CreationPublishTitleViewModel;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishTitleViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "fragmentViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getFragmentViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "fragmentViewModel$delegate", "Lkotlin/Lazy;", "titleLayout", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onViewCreated", "", "view", "Landroid/view/View;", "initView", "adjustTitleRight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishTitleComponent extends BaseContentWidget {
    public static final /* synthetic */ int p = 0;
    public final com.larus.ui.arch.vm.internal.l m;
    public final Lazy n;
    public NovaTitleBarEx o;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(v r2) {
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

    public static final class b implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelProvider.Factory> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public CreationPublishTitleComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishTitleViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishTitleState.class), new b(this), new c(this), d.a);
        this.n = LazyKt.lazy(new w(this));
    }

    public static final void Y2(CreationPublishTitleComponent r1) {
        r1.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (s1a.a.getActivity(r1).isFinishing() == true) goto L6;
        boolean r2 = ViewExtKt.h(r1.F2());     // Catch: Throwable -> L8
        ((CreationPublishTitleViewModel) r1.m.getValue()).setShowPublish(r2);     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.community.impl.publish.v] */
    public final void onViewCreated(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        NovaTitleBarEx r0 = F2().findViewById(2131388881);
        this.o = r0;
        if (r0 == null) goto L5;
        NovaTitleBarEx.Y5(r0, r0.getContext().getString(2131900629), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new u(this), 14);
    L5:
        MutableLiveData<Boolean> r1 = ((CreationPublishViewModel) this.n.getValue()).getPublishLiveState();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r1.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new a(new v(this)));
        ComponentViewModel.onEach$default((CreationPublishTitleViewModel) this.m.getValue(), CreationPublishTitleComponent$initView$3.INSTANCE, CreationPublishTitleComponent$initView$4.INSTANCE, null, new CreationPublishTitleComponent$initView$5(this, null), 4, null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r11 == null) goto L11;
        ChatConstraintLayout r12 = r11.findViewById(2131365523);
        if (r12 == null) goto L12;
        r12.setOnBottomInsetUpdateListener(new y(this));
        return;
    L12:
        return;
    }
}
