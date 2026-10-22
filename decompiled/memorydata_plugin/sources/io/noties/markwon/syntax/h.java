package io.noties.markwon.syntax;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.i;

/* JADX INFO: loaded from: classes6.dex */
public class h extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.a.h f16690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f16691b;
    private final String c;

    public h(io.noties.a.h r3, d r4, String r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.f16690a = r3;
        this.f16691b = r6;
        this.c = r5;
    }

    public static h a(io.noties.a.h r2, d r3, String r4) {
        return new h(r2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.core.c.a r2) {
        r2.j(this.f16691b.b()).l(this.f16691b.a());
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(i.a r3) {
        r3.a(b.a(this.f16690a, this.f16691b, this.c));
    }
}
