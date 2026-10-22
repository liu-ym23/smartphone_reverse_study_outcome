package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @JvmName(name = "get")
    public static final LifecycleOwner get(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (LifecycleOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r10, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }

    @JvmName(name = "set")
    public static final void set(View r10, LifecycleOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setTag(R.id.view_tree_lifecycle_owner, r11);
    }
}
