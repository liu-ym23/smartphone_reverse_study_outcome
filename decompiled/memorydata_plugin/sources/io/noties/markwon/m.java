package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends Node>, w> f16646a;

    static class a implements l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<? extends Node>, w> f16647a;

        a() {
            this.f16647a = new HashMap(3);
        }

        @Override // io.noties.markwon.l.a
        public <N extends Node> l.a a(Class<N> r3, w r4) {
            w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            this.f16647a.remove(r3);
        L6:
            return this;
        L5:
            this.f16647a.put(r3, r5);
            goto L6
        }

        @Override // io.noties.markwon.l.a
        public l a() {
            return new m(Collections.unmodifiableMap(this.f16647a));
        }
    }

    m(Map<Class<? extends Node>, w> r3) {
        this.f16646a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.l
    public <N extends Node> w a(Class<N> r2) {
        return (w) ZeusTransformUtils.preCheckCast(this.f16646a.get(r2), w.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.l
    public <N extends Node> w b(Class<N> r1) {
        w r0 = a(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException(r1.getName());
    }
}
