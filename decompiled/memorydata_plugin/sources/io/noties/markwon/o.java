package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class o {
    o() {
    }

    static o a(n.b r2, final i r3) {
        final n.b r4 = (n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r4, r3);
    }

    abstract n a();
}
