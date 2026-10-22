package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.LinkSpan;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class i implements w {
    public i() {
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r5, t r6) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r6, t.class, "com.obric.memorydata.plugin");
        return new LinkSpan(r5.a(), (String) ZeusTransformUtils.preCheckCast(CoreProps.g.b(r4), String.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(CoreProps.h.a(r4), Map.class, "com.obric.memorydata.plugin"), r5.d());
    }
}
