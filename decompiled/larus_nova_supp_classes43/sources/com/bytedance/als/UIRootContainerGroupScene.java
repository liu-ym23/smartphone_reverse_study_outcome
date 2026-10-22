package com.bytedance.als;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.scene.group.GroupScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/als/UIRootContainerGroupScene;", "Lcom/bytedance/scene/group/GroupScene;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class UIRootContainerGroupScene extends GroupScene {
    public final void u0() {
    }

    public final void v0() {
    }

    public final void w0() {
    }

    public UIRootContainerGroupScene() {
    }

    public final void T(Bundle r1) {
        super/*com.bytedance.scene.Scene*/.T(r1);
    }

    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r1, ViewGroup r10, Bundle r11) {
        return t0(r1, r10, r11);
    }

    public final ViewGroup t0(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Intrinsics.checkNotNullParameter(r11, "container");
        View r13 = r10.inflate(i0().getInt("layoutId"), r11, false);
        if (r13 == null) goto L7;
        return (ViewGroup) r13;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
