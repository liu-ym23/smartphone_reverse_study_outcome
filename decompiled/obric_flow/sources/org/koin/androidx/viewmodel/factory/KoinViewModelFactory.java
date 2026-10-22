package org.koin.androidx.viewmodel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lorg/koin/androidx/viewmodel/factory/KoinViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KoinViewModelFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f20996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f20997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wu.a f20998c;
    public final Function0 d;

    public KoinViewModelFactory(KClass r5, a r10, wu.a r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.f20996a = r5;
        this.f20997b = r10;
        this.f20998c = r11;
        this.d = r12;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class r5, CreationExtras r10) {
        Intrinsics.checkNotNullParameter(r5, "modelClass");
        Intrinsics.checkNotNullParameter(r10, "extras");
        final org.koin.androidx.viewmodel.parameter.a r11 = new org.koin.androidx.viewmodel.parameter.a(this.d, r10);
        Function0<vu.a> r12 = new AnonymousClass1(r11);
        return (ViewModel) this.f20997b.b(r12, this.f20996a, this.f20998c);
    }
}
