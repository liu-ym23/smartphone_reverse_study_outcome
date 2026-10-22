package com.bytedance.retrofit2;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$Tag<T> extends ParameterHandler<T> {
    final Class<T> cls;

    public ParameterHandler$Tag(Class<T> r1) {
        this.cls = r1;
    }

    public void apply(RequestBuilder r2, @Nullable T r3) {
        r2.addTag(this.cls, r3);
    }
}
