package androidx.lifecycle;

import android.os.Bundle;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "consumeRestoredStateForKey", STGroup.DICT_KEY, "", "performRestore", "", "saveState", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n215#2,2:226\n1#3:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n*L\n146#1:226,2\n*E\n"})
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry r5, final ViewModelStoreOwner r10) {
        Intrinsics.checkNotNullParameter(r5, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(r10, "viewModelStoreOwner");
        this.savedStateRegistry = r5;
        this.viewModel$delegate = LazyKt.lazy(new SavedStateHandlesProvider$viewModel$2(r10));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        performRestore();
        Bundle r10 = this.restoredState;
        if (r10 == null) goto L5;
        Bundle r11 = r10.getBundle(r5);
    L6:
        Bundle r12 = this.restoredState;
        if (r12 == null) goto L9;
        r12.remove(r5);
    L9:
        Bundle r13 = this.restoredState;
        if (r13 != null) goto L12;
    L14:
        return r11;
    L12:
        if (r13.isEmpty() != true) goto L14;
        this.restoredState = null;
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    public final void performRestore() {
        if (this.restored == true) goto L11;
        Bundle r5 = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle r10 = new Bundle();
        Bundle r11 = this.restoredState;
        if (r11 == null) goto L7;
        r10.putAll(r11);
    L7:
        if (r5 == null) goto L9;
        r10.putAll(r5);
    L9:
        this.restoredState = r10;
        this.restored = true;
        getViewModel();
        return;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle r5 = new Bundle();
        Bundle r10 = this.restoredState;
        if (r10 == null) goto L5;
        r5.putAll(r10);
    L5:
        Iterator<Map.Entry<String, SavedStateHandle>> r11 = getViewModel().getHandles().entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<String, SavedStateHandle> r12 = r11.next();
        String r13 = r12.getKey();
        Bundle r14 = r12.getValue().savedStateProvider().saveState();
        if (Intrinsics.areEqual(r14, Bundle.EMPTY) == true) goto L7;
        r5.putBundle(r13, r14);
        goto L7
    L11:
        this.restored = false;
        return r5;
    }
}
