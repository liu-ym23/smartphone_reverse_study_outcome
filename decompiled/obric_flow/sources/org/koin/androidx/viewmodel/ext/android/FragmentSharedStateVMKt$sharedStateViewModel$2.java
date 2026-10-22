package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
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
@SourceDebugExtension({"SMAP\nFragmentSharedStateVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentSharedStateVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentSharedStateVMKt$sharedStateViewModel$2\n+ 2 FragmentSharedStateVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentSharedStateVMKt\n*L\n1#1,101:1\n75#2,5:102\n73#2,6:107\n*S KotlinDebug\n*F\n+ 1 FragmentSharedStateVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentSharedStateVMKt$sharedStateViewModel$2\n*L\n46#1:102,5\n46#1:107,6\n*E\n"})
public final class FragmentSharedStateVMKt$sharedStateViewModel$2 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ Function0<ViewModelStoreOwner> $owner;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ Fragment $this_sharedStateViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentSharedStateVMKt$sharedStateViewModel$2(Fragment r5, wu.a r10, Function0<Bundle> r11, Function0<? extends ViewModelStoreOwner> r12, Function0<? extends vu.a> r13) {
        this.$this_sharedStateViewModel = r5;
        this.$qualifier = r10;
        this.$state = r11;
        this.$owner = r12;
        this.$parameters = r13;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModel invoke() {
        Fragment r5 = this.$this_sharedStateViewModel;
        wu.a r10 = this.$qualifier;
        Function0<Bundle> r11 = this.$state;
        Function0<ViewModelStoreOwner> r12 = this.$owner;
        Function0<vu.a> r13 = this.$parameters;
        ViewModelStore r14 = r12.invoke().getViewModelStore();
        CreationExtras r15 = a.a(r11.invoke(), r5);
        if (r15 != null) goto L5;
        r15 = r5.getDefaultViewModelCreationExtras();
    L5:
        org.koin.core.scope.a r16 = u8.a.v(r5);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass r17 = Reflection.getOrCreateKotlinClass(ViewModel.class);
        return org.koin.androidx.viewmodel.a.a(r17, r14, null, r15, r10, r16, r13);
    }
}
