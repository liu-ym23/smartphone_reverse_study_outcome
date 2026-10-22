package com.bytedance.android.ec.adapter.impl.adapters;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdkapi.CommerceFragmentDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.android.ec.adapter.api.e {
    public static final CommerceFragmentDispatcher a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        a = CommerceFragmentDispatcher.INSTANCE;
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void a(ECBaseDialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        a.onCreate(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onActivityCreated(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        a.onActivityCreated(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroy(DialogFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        a.onDestroy(r10);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroyView(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onDestroyView(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDismiss(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onDismiss(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onPause(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onPause(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onResume(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onResume(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStart(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onStart(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStop(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onStop(r10, r11);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onViewCreated(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        a.onViewCreated(r10, r11);
    }
}
