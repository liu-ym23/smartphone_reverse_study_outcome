package com.bytedance.android.live.core.tetris.layer.core.element.widget.merge;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/widget/merge/MergeServiceWidgetElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/service/ServiceElement;", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MergeServiceWidgetElement extends ServiceElement<AbsMergeWidget> {
    public AbsMergeWidget l;
    public final a m;
    public final n70.a n;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Object i() {
        AbsMergeWidget r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        AbsMergeWidget r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r0 instanceof o70.a) == false) goto L14;
        o70.a r1 = this.l;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        a r0 = this.m;
        AbsMergeWidget r1 = this.l;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r0.ME(r1);
        b r2 = this.c;
        if (r2 == null) goto L12;
        AbsMergeWidget r3 = this.l;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r2.e(this, r3);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement
    public final void l() {
        this.n.j();
        Class<? extends AbsMergeWidget> r0 = this.n.c();
        Intrinsics.checkNotNull(r0);
        AbsMergeWidget r1 = r0.newInstance();
        this.l = r1;
        b r2 = this.c;
        if (r2 == null) goto L7;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        r2.d(this, r1);
    L7:
        b r3 = this.c;
        if (r3 == null) goto L13;
        AbsMergeWidget r4 = this.l;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L12:
        r3.c(this, r4);
    L13:
        a r5 = this.m;
        AbsMergeWidget r6 = this.l;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L16:
        r5.fW(r6);
    }

    public MergeServiceWidgetElement(a r2, n70.a r3, h70.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        Intrinsics.checkNotNullParameter(r3, "widgetAttribute");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.m = r2;
        this.n = r3;
    }
}
