package androidx.savedstate;

import android.view.View;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ViewTreeSavedStateRegistryOwner")
public final class ViewTreeSavedStateRegistryOwner {
    @JvmName(name = "get")
    public static final SavedStateRegistryOwner get(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SavedStateRegistryOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r10, ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1.INSTANCE), ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2.INSTANCE));
    }

    @JvmName(name = "set")
    public static final void set(View r10, SavedStateRegistryOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setTag(R.id.view_tree_saved_state_registry_owner, r11);
    }
}
