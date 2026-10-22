package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<VM extends ViewModel> implements Lazy<VM> {
    public VM a;
    public final KClass<VM> b;
    public final Function0<ViewModelStore> c;
    public final Function0<ViewModelProvider.Factory> d;

    public final Object getValue() {
        VM r0 = this.a;
        if (r0 != null) goto L6;
        ViewModelProvider.Factory r1 = (ViewModelProvider.Factory) this.d.invoke();
        VM r10 = (VM) new ViewModelProvider((ViewModelStore) this.c.invoke(), r1).get(JvmClassMappingKt.getJavaClass(this.b));
        this.a = r10;
        return r10;
    L6:
        return r0;
    }

    public final boolean isInitialized() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public c(KClass<VM> r10, Function0<? extends ViewModelStore> r11, Function0<? extends ViewModelProvider.Factory> r12) {
        Intrinsics.checkNotNullParameter(r10, "viewModelClass");
        Intrinsics.checkNotNullParameter(r11, "storeProducer");
        Intrinsics.checkNotNullParameter(r12, "factoryProducer");
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
