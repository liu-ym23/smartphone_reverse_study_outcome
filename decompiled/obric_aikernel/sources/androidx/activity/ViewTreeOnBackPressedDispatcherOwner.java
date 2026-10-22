package androidx.activity;

import android.view.View;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ViewTreeOnBackPressedDispatcherOwner")
public final class ViewTreeOnBackPressedDispatcherOwner {
    @JvmName(name = "get")
    public static final OnBackPressedDispatcherOwner get(View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (OnBackPressedDispatcherOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r10, ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE), ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE));
    }

    @JvmName(name = "set")
    public static final void set(View r10, OnBackPressedDispatcherOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onBackPressedDispatcherOwner");
        r10.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, r11);
    }
}
