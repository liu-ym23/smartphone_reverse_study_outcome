package org.koin.androidx.viewmodel.ext.android;

import androidx.activity.ComponentActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nActivityVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityVMKt$viewModel$1\n+ 2 ActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityVMKt\n*L\n1#1,74:1\n66#2,5:75\n64#2,6:80\n*S KotlinDebug\n*F\n+ 1 ActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityVMKt$viewModel$1\n*L\n47#1:75,5\n47#1:80,6\n*E\n"})
public final class ActivityVMKt$viewModel$1 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ Function0<CreationExtras> $extrasProducer;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ ComponentActivity $this_viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityVMKt$viewModel$1(ComponentActivity r5, wu.a r10, Function0<? extends CreationExtras> r11, Function0<? extends vu.a> r12) {
        this.$this_viewModel = r5;
        this.$qualifier = r10;
        this.$extrasProducer = r11;
        this.$parameters = r12;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModel invoke() {
        ComponentActivity r5 = this.$this_viewModel;
        wu.a r10 = this.$qualifier;
        Function0<CreationExtras> r11 = this.$extrasProducer;
        Function0<vu.a> r12 = this.$parameters;
        ViewModelStore r13 = r5.getViewModelStore();
        if (r11 == null) goto L8;
        CreationExtras r14 = r11.invoke();
        if (r14 == null) goto L8;
    L7:
        CreationExtras r15 = r14;
        org.koin.core.scope.a r16 = u8.a.v(r5);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass r17 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        Intrinsics.checkNotNull(r13);
        return org.koin.androidx.viewmodel.a.a(r17, r13, null, r15, r10, r16, r12);
    L8:
        r14 = r5.getDefaultViewModelCreationExtras();
        goto L7
    }
}
