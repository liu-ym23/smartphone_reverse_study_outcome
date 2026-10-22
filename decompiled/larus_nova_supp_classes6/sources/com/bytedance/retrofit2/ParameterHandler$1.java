package com.bytedance.retrofit2;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ParameterHandler$1<T> extends ParameterHandler<Iterable<T>> {
    final /* synthetic */ ParameterHandler this$0;

    public ParameterHandler$1(ParameterHandler r1) {
        this.this$0 = r1;
    }

    public void apply(RequestBuilder r3, @Nullable Iterable<T> r4) throws IOException {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        T r0 = r5.next();
        this.this$0.apply(r3, r0);
        goto L6
    }

    public /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
        apply(r1, (Iterable) r2);
    }
}
