package com.bytedance.android.ec.adapter.impl.adapters;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.ec.adapter.api.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements j {
    public static final b a = null;

    public b() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void a(DialogFragment r10, FrameLayout r11, com.bytedance.android.ec.adapter.api.a r12) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
        Intrinsics.checkNotNullParameter(r12, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void c(Activity r10, com.bytedance.android.ec.adapter.api.a r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean checkWindowConflict() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void d(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void e(Activity r1, com.bytedance.android.ec.adapter.api.a r10) {
        Intrinsics.checkNotNullParameter(r10, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void g(DialogFragment r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean isFloatWindowShowing() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void setFloatWindowBottomMargin(int r1) {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloat() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloatInNextLifecycle() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowNow() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void toggleLiveAudio(boolean r1) {
    }

    static {
        a = new b();
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final Object f(com.bytedance.android.ec.model.j r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        return new Object();
    }
}
