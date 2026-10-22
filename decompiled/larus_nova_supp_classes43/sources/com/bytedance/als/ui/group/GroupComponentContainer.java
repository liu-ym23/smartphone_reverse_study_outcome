package com.bytedance.als.ui.group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.GroupScene;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/als/ui/group/GroupComponentContainer;", "Lcom/bytedance/scene/group/GroupScene;", "als_release"}, k = 1, mv = {1, 4, 1})
public final class GroupComponentContainer extends GroupScene {
    public final void W(Bundle r10) {
        super.W(r10);
        Iterator r11 = CollectionsKt.toList(((GroupScene) this).q.g()).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        y0((Scene) r11.next());
        goto L4
    }

    public final /* bridge */ /* synthetic */ View Z(LayoutInflater r1, ViewGroup r10, Bundle r11) {
        return t0(r1, r10, r11);
    }

    public final ViewGroup t0(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        Intrinsics.checkNotNullParameter(r11, "container");
        View r13 = r10.inflate(0, r11, false);
        if (r13 == null) goto L7;
        return (ViewGroup) r13;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
