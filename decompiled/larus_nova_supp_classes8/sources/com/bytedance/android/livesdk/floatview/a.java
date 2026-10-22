package com.bytedance.android.livesdk.floatview;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a implements IDialogFragmentLifecycle {
    public a() {
    }

    public final void onActivityCreated(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public final void onCreate(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public void onDestroy(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    public final void onDestroyView(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public final void onDismiss(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public void onPause(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public void onResume(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public void onStart(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public void onStop(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }

    public final void onViewCreated(DialogFragment r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
    }
}
