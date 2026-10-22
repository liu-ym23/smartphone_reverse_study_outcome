package com.bytedance.frameworks.baselib.network.http.c.a.a;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f2371a;

    private a(Gson r2) {
        Objects.requireNonNull(r2, "gson == null");
        this.f2371a = r2;
    }

    public static a a() {
        return a(new Gson());
    }

    public static a a(Gson r1) {
        return new a(r1);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
        TypeAdapter r6 = this.f2371a.getAdapter(TypeToken.get(r5));
        return new b(this.f2371a, r6);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
        TypeAdapter r5 = this.f2371a.getAdapter(TypeToken.get(r4));
        return new c(this.f2371a, r5);
    }
}
