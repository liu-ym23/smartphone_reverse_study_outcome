package com.bytedance.frameworks.baselib.network.http.c.a.a;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.rpc.internal.RpcUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
final class c<T> implements Converter<TypedInput, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f2374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter<T> f2375b;

    c(Gson r1, TypeAdapter<T> r2) {
        this.f2374a = r1;
        this.f2375b = r2;
    }

    public T a(TypedInput r3) {
        TypedInput r4 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r3, TypedInput.class, "com.obric.memorydata.plugin");
        String r0 = r4.mimeType();
        String r1 = RpcUtils.CHARSET_UTF8;
        if (r0 == null) goto L5;
        r1 = MimeUtil.parseCharset(r4.mimeType(), RpcUtils.CHARSET_UTF8);
    L5:
        InputStreamReader r2 = new InputStreamReader(r4.in(), r1);
        JsonReader r5 = this.f2374a.newJsonReader(r2);
        T r6 = this.f2375b.read(r5);     // Catch: Throwable -> L9
        r2.close();     // Catch: IOException -> L12
    L8:
        return r6;
    L9:
        th = move-exception;
        r2.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }

    @Override // com.bytedance.retrofit2.Converter
    public /* synthetic */ Object convert(TypedInput r3) {
        return a((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
    }
}
