package org.koin.androidx.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class GetViewModelKt$lazyResolveViewModel$1 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ Function0<CreationExtras> $extras;
    final /* synthetic */ String $key;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ org.koin.core.scope.a $scope;
    final /* synthetic */ Function0<ViewModelStore> $viewModelStore;
    final /* synthetic */ KClass<ViewModel> $vmClass;

    /* JADX WARN: Multi-variable type inference failed */
    public GetViewModelKt$lazyResolveViewModel$1(KClass<ViewModel> r5, Function0<? extends ViewModelStore> r10, String r11, Function0<? extends CreationExtras> r12, wu.a r13, org.koin.core.scope.a r14, Function0<? extends vu.a> r15) {
        this.$vmClass = r5;
        this.$viewModelStore = r10;
        this.$key = r11;
        this.$extras = r12;
        this.$qualifier = r13;
        this.$scope = r14;
        this.$parameters = r15;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModel invoke() {
        return a.a(this.$vmClass, this.$viewModelStore.invoke(), this.$key, this.$extras.invoke(), this.$qualifier, this.$scope, this.$parameters);
    }
}
