package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ViewModelProviderGetKt")
public final class ViewModelProviderGetKt {
    public static final CreationExtras defaultCreationExtras(ViewModelStoreOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        if ((r10 instanceof HasDefaultViewModelProviderFactory) == false) goto L6;
        return ((HasDefaultViewModelProviderFactory) r10).getDefaultViewModelCreationExtras();
    L6:
        return CreationExtras.Empty.INSTANCE;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (VM) r10.get(ViewModel.class);
    }
}
