package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", EventBody.KEY_VALUE, "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    public ViewModelLazy(KClass<VM> r10, Function0<? extends ViewModelStore> r11, Function0<? extends ViewModelProvider.Factory> r12) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r10, KClass.class, "com.obric.memorydata.plugin");
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "viewModelClass");
        Intrinsics.checkNotNullParameter(r4, "storeProducer");
        Intrinsics.checkNotNullParameter(r5, "factoryProducer");
        this(r3, r4, r5, null, 8, null);
    }

    public ViewModelLazy(KClass<VM> r3, Function0<? extends ViewModelStore> r4, Function0<? extends ViewModelProvider.Factory> r5, Function0<? extends CreationExtras> r6) {
        KClass<VM> r7 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        Function0<ViewModelStore> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<ViewModelProvider.Factory> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<CreationExtras> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "viewModelClass");
        Intrinsics.checkNotNullParameter(r8, "storeProducer");
        Intrinsics.checkNotNullParameter(r9, "factoryProducer");
        Intrinsics.checkNotNullParameter(r10, "extrasProducer");
        this.viewModelClass = r7;
        this.storeProducer = r8;
        this.factoryProducer = r9;
        this.extrasProducer = r10;
    }

    public /* synthetic */ ViewModelLazy(KClass r2, Function0 r3, Function0 r4, Function0 r5, int r6, DefaultConstructorMarker r7) {
        KClass r8 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        this(r8, r9, r10, r11);
    }

    @Override // kotlin.Lazy
    public VM getValue() {
        VM r0 = this.cached;
        if (r0 != null) goto L6;
        ViewModelProvider.Factory r1 = (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(this.factoryProducer.invoke(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
        VM r2 = (VM) new ViewModelProvider((ViewModelStore) ZeusTransformUtils.preCheckCast(this.storeProducer.invoke(), ViewModelStore.class, "com.obric.memorydata.plugin"), r1, (CreationExtras) ZeusTransformUtils.preCheckCast(this.extrasProducer.invoke(), CreationExtras.class, "com.obric.memorydata.plugin")).get(JvmClassMappingKt.getJavaClass(this.viewModelClass));
        this.cached = r2;
        return r2;
    L6:
        return r0;
    }

    @Override // kotlin.Lazy
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.cached == null) goto L5;
        return true;
    L5:
        return false;
    }
}
