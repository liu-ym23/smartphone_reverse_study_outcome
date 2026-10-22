package com.bytedance.android.live.core.tetris.layer.core.element.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import h70.b;
import j70.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o70.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/view/ViewElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Landroid/view/View;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewElement extends Element<View> {
    public View l;
    public final m m;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View i() {
        View r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final a j() {
        View r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r0 instanceof a) == false) goto L15;
        KeyEvent.Callback r1 = this.l;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L10:
        if (r1 == null) goto L14;
        return (a) r1;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r1) {
        if (r1 == null) goto L5;
        this.l = r1;
        return;
    }

    public ViewElement(b r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        Intrinsics.checkNotNullParameter(r3, "viewElementAttribute");
        super(r2);
        this.m = r3;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r0 = this.m.getView(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.m.getLayoutId();
        Integer r1 = 0;
        if (r1.intValue() == 0) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L15;
        return null;
    L15:
        return LayoutInflater.from(r5).inflate(r1.intValue(), r6, false);
    L8:
        r2 = false;
        goto L10
    }
}
