package com.bytedance.als.ui.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/ui/group/SceneEnvironmentContainerGroupScene;", "Lcom/bytedance/scene/group/GroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class SceneEnvironmentContainerGroupScene extends GroupScene {
    public final int u;

    public SceneEnvironmentContainerGroupScene() {
        this.u = ViewCompat.generateViewId();
    }

    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r1, ViewGroup r10, Bundle r11) {
        return t0(r1, r10, r11);
    }

    public final ViewGroup t0(LayoutInflater r1, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        Intrinsics.checkNotNullParameter(r10, "container");
        FrameLayout r12 = new FrameLayout(j0());
        r12.setId(this.u);
        return r12;
    }
}
