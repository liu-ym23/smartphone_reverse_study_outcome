package org.koin.androidx.viewmodel.ext.android;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/FragmentActivity;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nFragmentSharedStateVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentSharedStateVM.kt\norg/koin/androidx/viewmodel/ext/android/FragmentSharedStateVMKt$sharedStateViewModel$1\n*L\n1#1,101:1\n*E\n"})
public final class FragmentSharedStateVMKt$sharedStateViewModel$1 extends Lambda implements Function0<FragmentActivity> {
    final /* synthetic */ Fragment $this_sharedStateViewModel;

    public FragmentSharedStateVMKt$sharedStateViewModel$1(Fragment r5) {
        this.$this_sharedStateViewModel = r5;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FragmentActivity invoke() {
        return this.$this_sharedStateViewModel.requireActivity();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FragmentActivity invoke() {
        return invoke();
    }
}
