package m70;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.view.ViewElement;
import j70.e;
import j70.m;
import k70.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends b<m> {
    public a() {
    }

    @Override // k70.b
    public final Element a(e r3) {
        m r4 = (m) r3;
        Intrinsics.checkNotNullParameter(r4, "attribute");
        return new ViewElement(b(), r4);
    }
}
