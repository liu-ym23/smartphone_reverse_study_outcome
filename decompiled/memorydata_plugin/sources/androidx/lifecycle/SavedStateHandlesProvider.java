package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "consumeRestoredStateForKey", "key", "", "performRestore", "", "saveState", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry r3, ViewModelStoreOwner r4) {
        final ViewModelStoreOwner r5 = (ViewModelStoreOwner) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(r5, "viewModelStoreOwner");
        this.savedStateRegistry = r3;
        this.viewModel$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new SavedStateHandlesProvider$viewModel$2(r5), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), SavedStateHandlesVM.class, "com.obric.memorydata.plugin");
    }

    public final Bundle consumeRestoredStateForKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        performRestore();
        Bundle r0 = this.restoredState;
        if (r0 == null) goto L5;
        Bundle r1 = r0.getBundle(r5);
    L6:
        Bundle r2 = this.restoredState;
        if (r2 == null) goto L9;
        r2.remove(r5);
    L9:
        Bundle r6 = this.restoredState;
        boolean r3 = true;
        if (r6 != null) goto L12;
    L14:
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        this.restoredState = null;
    L17:
        return r1;
    L12:
        if (r6.isEmpty() != true) goto L14;
    L5:
        r1 = null;
        goto L6
    }

    public final void performRestore() {
        if (this.restored == true) goto L11;
        Bundle r0 = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle r1 = new Bundle();
        Bundle r2 = this.restoredState;
        if (r2 == null) goto L7;
        r1.putAll(r2);
    L7:
        if (r0 == null) goto L9;
        r1.putAll(r0);
    L9:
        this.restoredState = r1;
        this.restored = true;
        getViewModel();
        return;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle r0 = new Bundle();
        Bundle r1 = this.restoredState;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        Iterator<Map.Entry<String, SavedStateHandle>> r2 = getViewModel().getHandles().entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        Bundle r5 = ((SavedStateHandle) ZeusTransformUtils.preCheckCast(r3.getValue(), SavedStateHandle.class, "com.obric.memorydata.plugin")).savedStateProvider().saveState();
        if (Intrinsics.areEqual(r5, Bundle.EMPTY) == true) goto L7;
        r0.putBundle(r4, r5);
        goto L7
    L11:
        this.restored = false;
        return r0;
    }
}
