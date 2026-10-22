package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import j70.e;
import j70.o;
import k70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends b<o> {
    public final RecyclableWidgetManager b;

    public a(RecyclableWidgetManager r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        this.b = r2;
    }

    @Override // k70.b
    public final Element a(e r4) {
        o r5 = (o) r4;
        Intrinsics.checkNotNullParameter(r5, "attribute");
        if (r5.i() == false) goto L6;
        return new ServiceWidgetElement(this.b, r5, b());
    L6:
        return new WidgetElement(this.b, r5, b());
    }
}
