package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
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
@SourceDebugExtension({"SMAP\nActivityStateVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityStateVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityStateVMKt$stateViewModel$1\n+ 2 ActivityStateVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityStateVMKt\n*L\n1#1,63:1\n56#2,5:64\n54#2,6:69\n*S KotlinDebug\n*F\n+ 1 ActivityStateVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityStateVMKt$stateViewModel$1\n*L\n42#1:64,5\n42#1:69,6\n*E\n"})
public final class ActivityStateVMKt$stateViewModel$1 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ ComponentActivity $this_stateViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStateVMKt$stateViewModel$1(ComponentActivity r5, wu.a r10, Function0<Bundle> r11, Function0<? extends vu.a> r12) {
        this.$this_stateViewModel = r5;
        this.$qualifier = r10;
        this.$state = r11;
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
        ComponentActivity r5 = this.$this_stateViewModel;
        wu.a r10 = this.$qualifier;
        Function0<Bundle> r11 = this.$state;
        Function0<vu.a> r12 = this.$parameters;
        ViewModelStore r13 = r5.getViewModelStore();
        CreationExtras r14 = a.a(r11.invoke(), r5);
        if (r14 != null) goto L5;
        r14 = r5.getDefaultViewModelCreationExtras();
    L5:
        org.koin.core.scope.a r15 = u8.a.v(r5);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass r16 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        Intrinsics.checkNotNull(r13);
        return org.koin.androidx.viewmodel.a.a(r16, r13, null, r14, r10, r15, r12);
    }
}
