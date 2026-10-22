package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements v {
    public final SsResponse<TypedInput> a;
    public InputStream b;

    @Override // com.larus.agents.impl.webfetch.v
    public final InputStream C4() {
        TypedInput r0 = (TypedInput) this.a.body();
        if (r0 != null) goto L5;
        r0 = this.a.errorBody();
    L5:
        if (r0 == null) goto L9;
        InputStream r1 = r0.in();
        if (r1 == null) goto L9;
        this.b = r1;
        return r1;
    L9:
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r0 = this.b;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // com.larus.agents.impl.webfetch.v
    public final int getStatus() {
        return this.a.code();
    }

    public e(SsResponse<TypedInput> r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        this.a = r2;
    }

    @Override // com.larus.agents.impl.webfetch.v
    public final String header(String r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        Iterator r0 = this.a.headers().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (StringsKt.equals(((Header) r1).getName(), r6, true) == false) goto L4;
    L9:
        Header r2 = (Header) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getValue();
    L8:
        r1 = null;
        goto L9
    }
}
