package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    public DefaultCallAdapterFactory() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?> get(Type r8, Annotation[] r10, Retrofit r11) {
        if (CallAdapter.Factory.getRawType(r8) == Call.class) goto L6;
        return null;
    L6:
        final Type r12 = Utils.getCallResponseType(r8);
        return new AnonymousClass1(this, r12);
    }
}
