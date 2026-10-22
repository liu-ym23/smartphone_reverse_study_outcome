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
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke", "()Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class FragmentSharedStateVMKt$sharedStateViewModel$4 extends Lambda implements Function0<ViewModel> {
    final /* synthetic */ KClass<ViewModel> $clazz;
    final /* synthetic */ Function0<ViewModelStoreOwner> $owner;
    final /* synthetic */ Function0<vu.a> $parameters;
    final /* synthetic */ wu.a $qualifier;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ Fragment $this_sharedStateViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentSharedStateVMKt$sharedStateViewModel$4(Fragment r5, wu.a r10, Function0<Bundle> r11, Function0<? extends ViewModelStoreOwner> r12, KClass<ViewModel> r13, Function0<? extends vu.a> r14) {
        this.$this_sharedStateViewModel = r5;
        this.$qualifier = r10;
        this.$state = r11;
        this.$owner = r12;
        this.$clazz = r13;
        this.$parameters = r14;
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
        KClass<ViewModel> r13 = this.$clazz;
        Function0<vu.a> r14 = this.$parameters;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r12, "owner");
        Intrinsics.checkNotNullParameter(r13, "clazz");
        ViewModelStore r15 = r12.invoke().getViewModelStore();
        CreationExtras r16 = a.a(r11.invoke(), r5);
        if (r16 != null) goto L6;
        r16 = r5.getDefaultViewModelCreationExtras();
    L6:
        return org.koin.androidx.viewmodel.a.a(r13, r15, null, r16, r10, u8.a.v(r5), r14);
    }
}
