package com.bytedance.android.ec.adapter.impl.adapters;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.ec.adapter.api.e {
    public static final a a = null;

    public a() {
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void a(ECBaseDialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onActivityCreated(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroy(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroyView(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDismiss(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onPause(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onResume(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStart(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStop(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onViewCreated(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    static {
        a = new a();
    }
}
