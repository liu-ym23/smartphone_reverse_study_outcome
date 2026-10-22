package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nInitializerViewModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,115:1\n13579#2,2:116\n*S KotlinDebug\n*F\n+ 1 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactory\n*L\n105#1:116,2\n*E\n"})
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... r10) {
        Intrinsics.checkNotNullParameter(r10, "initializers");
        this.initializers = r10;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r10, CreationExtras r11) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        Intrinsics.checkNotNullParameter(r11, "extras");
        ViewModelInitializer<?>[] r12 = this.initializers;
        int r13 = r12.length;
        int r14 = 0;
        T r15 = null;
    L3:
        if (r14 >= r13) goto L11;
        ViewModelInitializer<?> r16 = r12[r14];
        if (Intrinsics.areEqual(r16.getClazz$lifecycle_viewmodel_release(), r10) == false) goto L10;
        T r17 = r16.getInitializer$lifecycle_viewmodel_release().invoke(r11);
        if ((r17 instanceof ViewModel) == false) goto L9;
        r15 = r17;
        goto L10
    L9:
        r15 = null;
    L10:
        r14 = r14 + 1;
        goto L3
    L11:
        if (r15 == null) goto L14;
        return r15;
    L14:
        throw new IllegalArgumentException("No initializer set for given class " + r10.getName());
    }
}
