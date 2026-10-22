package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder r10, Function1<? super CreationExtras, ? extends VM> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "initializer");
        Intrinsics.reifiedOperationMarker(4, "VM");
        r10.addInitializer(Reflection.getOrCreateKotlinClass(ViewModel.class), r11);
    }

    public static final ViewModelProvider.Factory viewModelFactory(Function1<? super InitializerViewModelFactoryBuilder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        InitializerViewModelFactoryBuilder r11 = new InitializerViewModelFactoryBuilder();
        r10.invoke(r11);
        return r11.build();
    }
}
