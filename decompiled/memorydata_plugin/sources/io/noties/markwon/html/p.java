package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class p extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, u> f16602b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, u> f16607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16608b;
        private boolean c;

        a() {
            this.f16607a = Collections.emptyMap();
        }

        private void b() {
            if (this.c == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Builder has been already built");
        }

        public o a() {
            b();
            this.c = true;
            if (this.f16607a.size() <= 0) goto L6;
            return new p(this.f16608b, this.f16607a);
        L6:
            return new q();
        }

        a a(Map<String, u> r3) {
            Map<String, u> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            b();
            this.f16607a = r4;
            return this;
        }
    }

    p(boolean r3, Map<String, u> r4) {
        Map<String, u> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.f16601a = r3;
        this.f16602b = r5;
    }

    @Override // io.noties.markwon.html.o
    public u a(String r2) {
        return (u) ZeusTransformUtils.preCheckCast(this.f16602b.get(r2), u.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.html.o
    public void a(io.noties.markwon.n r3, m r4) {
        final io.noties.markwon.n r5 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        if (this.f16601a == true) goto L5;
        int r0 = -1;
    L6:
        r4.a(r0, new AnonymousClass1(this, r5));
        r4.b(r0, new AnonymousClass2(this, r5));
        r4.a();
        return;
    L5:
        r0 = r5.f();
        goto L6
    }
}
