package com.bytedance.android.ec.adapter.api;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e {
    void a(ECBaseDialogFragment r1);

    void onActivityCreated(DialogFragment r1);

    void onDestroy(DialogFragment r1);

    void onDestroyView(DialogFragment r1, FrameLayout r10);

    void onDismiss(DialogFragment r1, FrameLayout r10);

    void onPause(DialogFragment r1, FrameLayout r10);

    void onResume(DialogFragment r1, FrameLayout r10);

    void onStart(DialogFragment r1, FrameLayout r10);

    void onStop(DialogFragment r1, FrameLayout r10);

    void onViewCreated(DialogFragment r1, FrameLayout r10);
}
