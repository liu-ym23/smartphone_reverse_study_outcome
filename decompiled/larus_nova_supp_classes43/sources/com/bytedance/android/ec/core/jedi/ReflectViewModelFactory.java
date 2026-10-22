package com.bytedance.android.ec.core.jedi;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReflectViewModelFactory implements ViewModelProvider.Factory {
    public ReflectViewModelFactory() {
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r10) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r10);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r10) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r10);
    }

    public final <T extends ViewModel> T create(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        T r11 = r10.newInstance();
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
