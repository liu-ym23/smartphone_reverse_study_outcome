package org.koin.androidx.viewmodel.ext.android;

import androidx.activity.ComponentActivity;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nFragmentActivityVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentActivityVMKt$activityViewModel$2\n+ 2 FragmentActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentActivityVMKt\n*L\n1#1,80:1\n71#2,8:81\n*S KotlinDebug\n*F\n+ 1 FragmentActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentActivityVMKt$activityViewModel$2\n*L\n52#1:81,8\n*E\n"})
public final class FragmentActivityVMKt$activityViewModel$2 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ Function0<CreationExtras> $extrasProducer;
    final /* synthetic */ Function0<ViewModelStoreOwner> $ownerProducer;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ Fragment $this_activityViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentActivityVMKt$activityViewModel$2(Fragment r5, wu.a r10, Function0<? extends ViewModelStoreOwner> r11, Function0<? extends CreationExtras> r12, Function0<? extends vu.a> r13) {
        this.$this_activityViewModel = r5;
        this.$qualifier = r10;
        this.$ownerProducer = r11;
        this.$extrasProducer = r12;
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
        Fragment r5 = this.$this_activityViewModel;
        wu.a r10 = this.$qualifier;
        Function0<ViewModelStoreOwner> r11 = this.$ownerProducer;
        Function0<CreationExtras> r12 = this.$extrasProducer;
        Function0<vu.a> r13 = this.$parameters;
        ViewModelStoreOwner r14 = r11.invoke();
        ViewModelStore r15 = r14.getViewModelStore();
        if (r12 == null) goto L8;
        CreationExtras r16 = r12.invoke();
        if (r16 == null) goto L8;
        CreationExtras r17 = r16;
    L17:
        org.koin.core.scope.a r18 = u8.a.v(r5);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return org.koin.androidx.viewmodel.a.a(Reflection.getOrCreateKotlinClass(ViewModel.class), r15, null, r17, r10, r18, r13);
    L8:
        CreationExtras r19 = null;
        if ((r14 instanceof ComponentActivity) == false) goto L11;
        ComponentActivity r20 = (ComponentActivity) r14;
    L12:
        if (r20 == null) goto L14;
        r19 = r20.getDefaultViewModelCreationExtras();
    L14:
        if (r19 != null) goto L16;
        r17 = r5.getDefaultViewModelCreationExtras();
        goto L17
    L16:
        r17 = r19;
        goto L17
    L11:
        r20 = null;
        goto L12
    }
}
