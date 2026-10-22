package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    public DefaultCallAdapterFactory() {
    }

    public CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3) {
        if (CallAdapter.Factory.getRawType(r1) == Call.class) goto L7;
        return null;
    L7:
        return new 1(this, Utils.getCallResponseType(r1));
    }
}
