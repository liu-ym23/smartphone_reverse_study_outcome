package com.larus.uaigc.spring.component;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.uaigc.spring.viewmodel.TransparentState;
import com.larus.uaigc.spring.viewmodel.TransparentViewModel;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0017J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/spring/component/TransparentMaskComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/larus/uaigc/spring/viewmodel/TransparentViewModel;", "getViewModel", "()Lcom/larus/uaigc/spring/viewmodel/TransparentViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "rootView", "Landroid/view/View;", "onViewCreated", "", "view", "onDestroy", "observeImeChange", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TransparentMaskComponent extends BaseContentWidget {
    public static final /* synthetic */ int p = 0;
    public final Lazy m;
    public final com.larus.ui.arch.vm.internal.l n;
    public View o;

    public static final class a implements ChatConstraintLayout.b {
        public a() {
        }

        public final void a() {
        }

        public final void b() {
        }

        public final void onUpdate(int r1) {
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

    /* JADX INFO: renamed from: com.larus.uaigc.spring.component.TransparentMaskComponent$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/uaigc/spring/viewmodel/TransparentState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.spring.component.TransparentMaskComponent$onViewCreated$2", f = "TransparentMaskComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<TransparentState, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $view;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(View r1, Continuation<? super AnonymousClass2> r2) {
            this.$view = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$view, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(TransparentState r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((TransparentState) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r3);
            TransparentState r4 = (TransparentState) this.L$0;
            if (r4.getHasShowIme() == false) goto L7;
        L12:
            View r5 = this.$view.findViewById(2131372779);
            if (r5 == null) goto L16;
            e1.x(r5);
        L16:
            return Unit.INSTANCE;
        L7:
            if (r4.getHasShowMenu() == true) goto L12;
            View r6 = this.$view.findViewById(2131372779);
            if (r6 == null) goto L16;
            e1.o(r6);
            goto L16
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onDestroy() {
        ICoreInputAbility r0 = (ICoreInputAbility) this.m.getValue();
        if (r0 == null) goto L5;
        r0.uG();
    L5:
        View r1 = this.o;
        ChatConstraintLayout r2 = null;
        if (r1 == null) goto L8;
        View r3 = r1.findViewById(2131365588);
    L10:
        if ((r3 instanceof ChatConstraintLayout) == false) goto L12;
        r2 = (ChatConstraintLayout) r3;
    L12:
        if (r2 == null) goto L15;
        r2.setOnBottomInsetUpdateListener(new a());
        return;
    L15:
        return;
    L8:
        r3 = null;
        goto L10
    }

    public TransparentMaskComponent() {
        this.m = LazyKt.lazy(new d0(this));
        this.n = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(TransparentViewModel.class), Reflection.getOrCreateKotlinClass(TransparentState.class), new b(this), new c(this), d.a);
    }

    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r8, "view");
        this.o = r8;
        View r0 = r8.findViewById(2131372779);
        if (r0 == null) goto L5;
        r0.setOnClickListener(new e0(this));
    L5:
        ChatConstraintLayout r1 = null;
        ComponentViewModel.onEach$default((TransparentViewModel) this.n.getValue(), null, null, new AnonymousClass2(r8, null), 3, null);
        View r9 = this.o;
        if (r9 == null) goto L8;
        final View r10 = r9.findViewById(2131365588);
    L9:
        ICoreInputAbility r2 = (ICoreInputAbility) this.m.getValue();
        if (r2 == null) goto L13;
        r2.uw(new f0(this));
    L13:
        if ((r10 instanceof ChatConstraintLayout) == false) goto L15;
        r1 = (ChatConstraintLayout) r10;
    L15:
        if (r1 == null) goto L18;
        r1.setOnBottomInsetUpdateListener(new TransparentMaskComponent$observeImeChange$2(this, r10));
        return;
    L18:
        return;
    L8:
        r10 = null;
        goto L9
    }
}
