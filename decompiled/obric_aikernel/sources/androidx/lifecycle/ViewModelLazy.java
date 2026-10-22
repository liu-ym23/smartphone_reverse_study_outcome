package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    @JvmOverloads
    public ViewModelLazy(KClass<VM> r10, Function0<? extends ViewModelStore> r11, Function0<? extends ViewModelProvider.Factory> r12) {
        Intrinsics.checkNotNullParameter(r10, "viewModelClass");
        Intrinsics.checkNotNullParameter(r11, "storeProducer");
        Intrinsics.checkNotNullParameter(r12, "factoryProducer");
        this(r10, r11, r12, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ViewModelLazy(KClass<VM> r10, Function0<? extends ViewModelStore> r11, Function0<? extends ViewModelProvider.Factory> r12, Function0<? extends CreationExtras> r13) {
        Intrinsics.checkNotNullParameter(r10, "viewModelClass");
        Intrinsics.checkNotNullParameter(r11, "storeProducer");
        Intrinsics.checkNotNullParameter(r12, "factoryProducer");
        Intrinsics.checkNotNullParameter(r13, "extrasProducer");
        this.viewModelClass = r10;
        this.storeProducer = r11;
        this.factoryProducer = r12;
        this.extrasProducer = r13;
    }

    public /* synthetic */ ViewModelLazy(KClass r10, Function0 r11, Function0 r12, Function0 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = AnonymousClass1.INSTANCE;
    L5:
        this(r10, r11, r12, r13);
    }

    @Override // kotlin.Lazy
    public VM getValue() {
        VM r10 = this.cached;
        if (r10 != null) goto L6;
        ViewModelProvider.Factory r11 = this.factoryProducer.invoke();
        VM r12 = (VM) new ViewModelProvider(this.storeProducer.invoke(), r11, this.extrasProducer.invoke()).get(JvmClassMappingKt.getJavaClass(this.viewModelClass));
        this.cached = r12;
        return r12;
    L6:
        return r10;
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
