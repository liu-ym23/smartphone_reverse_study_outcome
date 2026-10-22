package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = null;

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    DefaultCallAdapterFactory() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
        if (getRawType(r4) == Call.class) goto L6;
        return null;
    L6:
        final Type r5 = Utils.getCallResponseType(r4);
        return new AnonymousClass1(this, r5);
    }
}
