package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.t;
import io.noties.markwon.w;

/* JADX INFO: loaded from: classes6.dex */
public class g implements w {
    public g() {
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r3, t r4) {
        t r2 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        return new io.noties.markwon.core.spans.k(r3.a(), ((Integer) ZeusTransformUtils.preCheckCast(CoreProps.f.b(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
    }
}
