package com.larus.community.impl.publish;

import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.facebook.common.references.CloseableReference;
import com.larus.community.impl.publish.viewmodel.CreationPublishSetState;
import com.larus.community.impl.publish.viewmodel.CreationPublishSetViewModel;
import com.larus.community.impl.publish.viewmodel.CreationPublishShowImageState;
import com.larus.community.impl.publish.viewmodel.CreationPublishShowImageViewModel;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishShowImageComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "publishViewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getPublishViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "publishViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishShowImageViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "setVieModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetViewModel;", "getSetVieModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetViewModel;", "setVieModel$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishShowImageComponent extends BaseContentWidget {
    public static final /* synthetic */ int p = 0;
    public final Lazy m;
    public final com.larus.ui.arch.vm.internal.l n;
    public final com.larus.ui.arch.vm.internal.l o;

    public static final class a implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public a(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class b implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.c(this.a);
        }
    }

    public static final class c implements Function0<ViewModelProvider.Factory> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class d implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public e(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.c(this.a);
        }
    }

    public static final class f implements Function0<ViewModelProvider.Factory> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$1", f = "CreationPublishShowImageComponent.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationPublishShowImageComponent this$0;

        /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/publish/viewmodel/PublishCreationState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$1$1", f = "CreationPublishShowImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00201 extends SuspendLambda implements Function2<com.larus.community.impl.publish.viewmodel.h, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CreationPublishShowImageComponent this$0;

            public C00201(CreationPublishShowImageComponent r1, Continuation<? super C00201> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00201 r0 = new C00201(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(com.larus.community.impl.publish.viewmodel.h r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((com.larus.community.impl.publish.viewmodel.h) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r3);
                com.larus.community.impl.publish.viewmodel.h r4 = (com.larus.community.impl.publish.viewmodel.h) this.L$0;
                if (r4 == null) goto L7;
                PublisherCreation r0 = r4.a;
            L8:
                if (r0 == null) goto L11;
                CreationPublishShowImageComponent r1 = this.this$0;
                int r2 = CreationPublishShowImageComponent.p;
                r1.Y2().initImageData(r4.a);
            L11:
                return Unit.INSTANCE;
            L7:
                r0 = null;
                goto L8
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(CreationPublishShowImageComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            i1<com.larus.community.impl.publish.viewmodel.h> r7 = ((CreationPublishViewModel) this.this$0.m.getValue()).getPublisherCreationFlow();
            C00201 r2 = new C00201(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$3", f = "CreationPublishShowImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ CreationPublishShowImageComponent this$0;

        public AnonymousClass3(CreationPublishShowImageComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            boolean r4 = this.Z$0;
            CreationPublishShowImageComponent r0 = this.this$0;
            int r1 = CreationPublishShowImageComponent.p;
            r0.Y2().updateChecked(r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "imageUrl", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$5", f = "CreationPublishShowImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationPublishShowImageComponent this$0;

        public AnonymousClass5(CreationPublishShowImageComponent r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass5 r0 = new AnonymousClass5(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r10);
            String r11 = (String) this.L$0;
            Object r0 = this.this$0.F2();
            if ((r0 instanceof ImageAdjustView) == false) goto L7;
            ImageAdjustView r1 = (ImageAdjustView) r0;
        L8:
            if (r1 == null) goto L14;
            CreationPublishShowImageComponent r2 = this.this$0;
            if (r11 != null) goto L12;
            r11 = "";
        L12:
            LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
            boolean r4 = ((CreationPublishShowImageState) r2.Y2().getState()).getShowVideoIcon();
            Intrinsics.checkNotNullParameter(r11, "imageUrl");
            Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
            BuildersKt.launch$default(r3, null, null, new ImageAdjustView$bindImageUrl$1(r1, r11, r4, null), 3, null);
        L14:
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "refImageUrls", "", "Lcom/larus/ugc/community/adapter/RefData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishShowImageComponent$onViewCreated$7", f = "CreationPublishShowImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<List<? extends f0a.a>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationPublishShowImageComponent this$0;

        public AnonymousClass7(CreationPublishShowImageComponent r1, Continuation<? super AnonymousClass7> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass7 r0 = new AnonymousClass7(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<f0a.a> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r5);
            List r6 = (List) this.L$0;
            Object r0 = this.this$0.F2();
            if ((r0 instanceof ImageAdjustView) == false) goto L7;
            ImageAdjustView r1 = (ImageAdjustView) r0;
        L8:
            if (r1 == null) goto L22;
            ArrayList r2 = new ArrayList();
            Iterator r7 = r6.iterator();
        L11:
            if (r7.hasNext() == false) goto L18;
            Image r3 = ((f0a.a) r7.next()).b;
            if (r3 == null) goto L15;
            String r4 = r3.a;
        L16:
            if (r4 == null) goto L11;
            r2.add(r4);
            goto L11
        L15:
            r4 = null;
            goto L16
        L18:
            Intrinsics.checkNotNullParameter(r2, "refImageUrls");
            String r8 = (String) CollectionsKt.firstOrNull(r2);
            if (r8 == null) goto L22;
            ImageLoaderKt.u(r1.a.c, r8, "ImageAdjustView");
        L22:
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final CreationPublishShowImageViewModel Y2() {
        return (CreationPublishShowImageViewModel) this.n.getValue();
    }

    public CreationPublishShowImageComponent() {
        this.m = LazyKt.lazy(new t(this));
        this.n = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishShowImageViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishShowImageState.class), new a(this), new b(this), c.a);
        this.o = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationPublishSetViewModel.class), Reflection.getOrCreateKotlinClass(CreationPublishSetState.class), new d(this), new e(this), f.a);
    }

    public final void onDestroy() {
        Object r0 = F2();
        if ((r0 instanceof ImageAdjustView) == false) goto L5;
        ImageAdjustView r1 = (ImageAdjustView) r0;
    L6:
        if (r1 == null) goto L9;
        CloseableReference.closeSafely(r1.c);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        ComponentViewModel.onEach$default((CreationPublishSetViewModel) this.o.getValue(), AnonymousClass2.INSTANCE, null, new AnonymousClass3(this, null), 2, null);
        ComponentViewModel.onEach$default(Y2(), AnonymousClass4.INSTANCE, null, new AnonymousClass5(this, null), 2, null);
        ComponentViewModel.onEach$default(Y2(), AnonymousClass6.INSTANCE, null, new AnonymousClass7(this, null), 2, null);
    }
}
