package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ViewModelLazyKt$viewModelForClass$1 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ KClass<ViewModel> $clazz;
    final /* synthetic */ String $key;
    final /* synthetic */ ViewModelStoreOwner $owner;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ ComponentActivity $this_viewModelForClass;
    final /* synthetic */ ViewModelStore $viewModelStore;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazyKt$viewModelForClass$1(Function0<Bundle> r5, ViewModelStoreOwner r10, ComponentActivity r11, KClass<ViewModel> r12, ViewModelStore r13, String r14, wu.a r15, Function0<? extends vu.a> r16) {
        this.$state = r5;
        this.$owner = r10;
        this.$this_viewModelForClass = r11;
        this.$clazz = r12;
        this.$viewModelStore = r13;
        this.$key = r14;
        this.$qualifier = r15;
        this.$parameters = r16;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModel invoke() {
        Function0<Bundle> r5 = this.$state;
        if (r5 == null) goto L10;
        Bundle r10 = r5.invoke();
        if (r10 == null) goto L10;
        CreationExtras r11 = a.a(r10, this.$owner);
        if (r11 == null) goto L10;
    L9:
        CreationExtras r12 = r11;
        org.koin.core.scope.a r13 = u8.a.v(this.$this_viewModelForClass);
        return org.koin.androidx.viewmodel.a.a(this.$clazz, this.$viewModelStore, this.$key, r12, this.$qualifier, r13, this.$parameters);
    L10:
        r11 = CreationExtras.Empty.INSTANCE;
        goto L9
    }
}
