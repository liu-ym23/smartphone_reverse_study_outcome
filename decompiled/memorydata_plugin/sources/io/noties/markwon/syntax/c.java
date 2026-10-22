package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class c extends io.noties.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f16688b;
    private final SpannableStringBuilder c;

    c(String r3, d r4, SpannableStringBuilder r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.f16687a = r3;
        this.f16688b = r6;
        this.c = r5;
    }

    @Override // io.noties.a.a
    public void a(io.noties.a.h.d r7) {
        io.noties.a.h.d r2 = (io.noties.a.h.d) ZeusTransformUtils.wrapperContextForParams(r7, io.noties.a.h.d.class, "com.obric.memorydata.plugin");
        int r4 = this.c.length();
        a(r2.d());
        int r5 = this.c.length();
        if (r5 == r4) goto L6;
        this.f16688b.a(this.f16687a, r2, this.c, r4, r5);
        return;
    }

    @Override // io.noties.a.a
    public void a(io.noties.a.h.e r3) {
        io.noties.a.h.e r4 = (io.noties.a.h.e) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.a.h.e.class, "com.obric.memorydata.plugin");
        this.c.append(r4.c());
    }
}
