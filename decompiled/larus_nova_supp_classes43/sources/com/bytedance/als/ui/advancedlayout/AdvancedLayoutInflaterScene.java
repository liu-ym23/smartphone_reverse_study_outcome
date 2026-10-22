package com.bytedance.als.ui.advancedlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.scene.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/ui/advancedlayout/AdvancedLayoutInflaterScene;", "Lcom/bytedance/scene/Scene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class AdvancedLayoutInflaterScene extends Scene {
    public final void a0() {
        ((Scene) this).m = true;
    }

    public final void b0() {
        ((Scene) this).m = true;
    }

    public abstract int l0();

    public final void onDestroy() {
        ((Scene) this).m = true;
    }

    public final void onPause() {
        ((Scene) this).m = true;
    }

    public final void onStart() {
        ((Scene) this).m = true;
    }

    public AdvancedLayoutInflaterScene() {
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onStop() {
        super.onStop();
    }

    public final void T(Bundle r1) {
        super.T(r1);
    }

    public final void g0(View r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
        ((Scene) this).m = true;
    }

    public final View Z(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Intrinsics.checkNotNullParameter(r11, "container");
        View r13 = r10.inflate(l0(), r11, false);
        if ((r13 instanceof ViewGroup) == true) goto L5;
        r13 = null;
    L5:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L9;
        return r14;
    L9:
        throw new IllegalArgumentException("AsyncLayoutUIScene getLayoutId() view must be ViewGroup");
    }
}
