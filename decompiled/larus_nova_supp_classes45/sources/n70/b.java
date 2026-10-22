package n70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.merge.MergeServiceWidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.merge.MergeWidgetElement;
import j70.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends k70.b<a> {
    public final com.bytedance.livesdk.preview.merge.a b;

    public b() {
        Intrinsics.checkNotNullParameter(null, "widgetManager");
        this.b = null;
    }

    @Override // k70.b
    public final Element a(e r4) {
        a r5 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "attribute");
        if (r5.i() == false) goto L6;
        return new MergeServiceWidgetElement(this.b, r5, b());
    L6:
        return new MergeWidgetElement(this.b, r5, b());
    }
}
