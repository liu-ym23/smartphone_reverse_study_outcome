package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ViewTreeViewModelStoreOwner")
public final class ViewTreeViewModelStoreOwner {
    @JvmName(name = "get")
    public static final ViewModelStoreOwner get(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (ViewModelStoreOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r10, ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE), ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE));
    }

    @JvmName(name = "set")
    public static final void set(View r10, ViewModelStoreOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setTag(R.id.view_tree_view_model_store_owner, r11);
    }
}
