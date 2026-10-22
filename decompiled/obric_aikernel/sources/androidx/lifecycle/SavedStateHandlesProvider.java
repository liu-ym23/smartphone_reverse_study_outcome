package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n215#2,2:226\n1#3:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n*L\n146#1:226,2\n*E\n"})
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry r10, final ViewModelStoreOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(r11, "viewModelStoreOwner");
        this.savedStateRegistry = r10;
        this.viewModel$delegate = LazyKt.lazy(new SavedStateHandlesProvider$viewModel$2(r11));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        performRestore();
        Bundle r11 = this.restoredState;
        if (r11 == null) goto L5;
        Bundle r12 = r11.getBundle(r10);
    L6:
        Bundle r13 = this.restoredState;
        if (r13 == null) goto L9;
        r13.remove(r10);
    L9:
        Bundle r14 = this.restoredState;
        boolean r15 = true;
        if (r14 != null) goto L12;
    L14:
        r15 = false;
    L15:
        if (r15 == false) goto L17;
        this.restoredState = null;
    L17:
        return r12;
    L12:
        if (r14.isEmpty() != true) goto L14;
    L5:
        r12 = null;
        goto L6
    }

    public final void performRestore() {
        if (this.restored == true) goto L11;
        Bundle r10 = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle r11 = new Bundle();
        Bundle r12 = this.restoredState;
        if (r12 == null) goto L7;
        r11.putAll(r12);
    L7:
        if (r10 == null) goto L9;
        r11.putAll(r10);
    L9:
        this.restoredState = r11;
        this.restored = true;
        getViewModel();
        return;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle r10 = new Bundle();
        Bundle r11 = this.restoredState;
        if (r11 == null) goto L5;
        r10.putAll(r11);
    L5:
        Iterator<Map.Entry<String, SavedStateHandle>> r12 = getViewModel().getHandles().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<String, SavedStateHandle> r13 = r12.next();
        String r14 = r13.getKey();
        Bundle r15 = r13.getValue().savedStateProvider().saveState();
        if (Intrinsics.areEqual(r15, Bundle.EMPTY) == true) goto L7;
        r10.putBundle(r14, r15);
        goto L7
    L11:
        this.restored = false;
        return r10;
    }
}
