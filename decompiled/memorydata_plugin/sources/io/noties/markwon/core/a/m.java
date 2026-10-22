package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.u;
import io.noties.markwon.t;
import io.noties.markwon.w;

/* JADX INFO: loaded from: classes6.dex */
public class m implements w {
    public m() {
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r2, t r3) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        return new u(r2.a());
    }
}
