package androidx.activity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActivityViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass1(ComponentActivity r3) {
            this.$this_viewModels = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.memorydata.plugin");
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(r1, "viewModelStore");
            return r1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass2(ComponentActivity r3) {
            this.$this_viewModels = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.memorydata.plugin");
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras r1 = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(r1, "this.defaultViewModelCreationExtras");
            return r1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass3(ComponentActivity r3) {
            this.$this_viewModels = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.memorydata.plugin");
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore r1 = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(r1, "viewModelStore");
            return r1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass4(Function0<? extends CreationExtras> r3, ComponentActivity r4) {
            Function0<CreationExtras> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            ComponentActivity r6 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r4, ComponentActivity.class, "com.obric.memorydata.plugin");
            this.$extrasProducer = r5;
            this.$this_viewModels = r6;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            Function0<CreationExtras> r0 = this.$extrasProducer;
            if (r0 == null) goto L6;
            CreationExtras r1 = (CreationExtras) ZeusTransformUtils.preCheckCast(r0.invoke(), CreationExtras.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            CreationExtras r2 = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(r2, "this.defaultViewModelCreationExtras");
            return r2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CreationExtras invoke() {
            return invoke();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity r5, Function0<? extends ViewModelProvider.Factory> r6) {
        ComponentActivity r7 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r5, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r8 != null) goto L5;
        r8 = (Function0) ZeusTransformUtils.preCheckCast(new ActivityViewModelLazyKt$viewModels$factoryPromise$1(r7), Function0.class, "com.obric.memorydata.plugin");
    L5:
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), Function0.class, "com.obric.memorydata.plugin"), r8, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r7), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity r5, Function0<? extends CreationExtras> r6, Function0<? extends ViewModelProvider.Factory> r7) {
        ComponentActivity r8 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r5, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r10 != null) goto L5;
        r10 = (Function0) ZeusTransformUtils.preCheckCast(new ActivityViewModelLazyKt$viewModels$factoryPromise$2(r8), Function0.class, "com.obric.memorydata.plugin");
    L5:
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r8), Function0.class, "com.obric.memorydata.plugin"), r10, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r9, r8), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity r3, Function0 r4, int r5, Object r6) {
        ComponentActivity r7 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r8 != null) goto L8;
        r8 = (Function0) ZeusTransformUtils.preCheckCast(new ActivityViewModelLazyKt$viewModels$factoryPromise$1(r7), Function0.class, "com.obric.memorydata.plugin");
    L8:
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), Function0.class, "com.obric.memorydata.plugin"), r8, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r7), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity r3, Function0 r4, Function0 r5, int r6, Object r7) {
        ComponentActivity r8 = (ComponentActivity) ZeusTransformUtils.wrapperContextForParams(r3, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r10 = null;
    L8:
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r10 != null) goto L11;
        r10 = (Function0) ZeusTransformUtils.preCheckCast(new ActivityViewModelLazyKt$viewModels$factoryPromise$2(r8), Function0.class, "com.obric.memorydata.plugin");
    L11:
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r8), Function0.class, "com.obric.memorydata.plugin"), r10, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r9, r8), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }
}
