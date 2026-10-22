package io.noties.markwon.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.t;
import io.noties.markwon.w;

/* JADX INFO: loaded from: classes6.dex */
public class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16416b;

    public b() {
        this(0, 0);
    }

    public b(int r1, int r2) {
        this.f16415a = r1;
        this.f16416b = r2;
    }

    @Override // io.noties.markwon.w
    public Object a(io.noties.markwon.i r3, t r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        return new io.noties.markwon.core.spans.b(r3.a(), this.f16415a, this.f16416b);
    }
}
