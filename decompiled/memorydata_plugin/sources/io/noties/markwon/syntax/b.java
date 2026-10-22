package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.a.h f16685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f16686b;
    private final String c;

    public b(io.noties.a.h r3, d r4, String r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.f16685a = r3;
        this.f16686b = r6;
        this.c = r5;
    }

    public static b a(io.noties.a.h r2, d r3, String r4) {
        return new b(r2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), r4);
    }

    public CharSequence a(String r1) {
        return r1;
    }

    public CharSequence a(String r4, io.noties.a.h.a r5, String r6) {
        io.noties.a.h.a r7 = (io.noties.a.h.a) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.a.h.a.class, "com.obric.memorydata.plugin");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        new c(r4, this.f16686b, r0).a(this.f16685a.a(r6, r7));
        return r0;
    }

    @Override // io.noties.markwon.syntax.f
    public CharSequence a(String r2, String r3) {
        if (r3.isEmpty() == false) goto L5;
        return r3;
    L5:
        if (r2 != null) goto L8;
        return a(r3);
    L8:
        return b(r2, r3);
    }

    public CharSequence b(String r3, String r4) {
        io.noties.a.h.a r0 = this.f16685a.a(r3);
        if (r0 == null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return r4;
    L9:
        return a(r3, r0, r4);
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L7;
        r3 = this.c;
        r0 = this.f16685a.a(r3);
        goto L7
    }
}
