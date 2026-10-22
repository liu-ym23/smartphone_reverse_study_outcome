package com.bytedance.frameworks.baselib.network.http.c.a.a;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.rpc.internal.RpcUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class b<T> implements Converter<T, TypedOutput> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f2372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f2373b;
    private final TypeAdapter<T> c;

    static {
        f2372a = Charset.forName(RpcUtils.CHARSET_UTF8);
    }

    b(Gson r1, TypeAdapter<T> r2) {
        this.f2373b = r1;
        this.c = r2;
    }

    public TypedOutput a(T r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r1 = new OutputStreamWriter(r0, f2372a);
        JsonWriter r2 = this.f2373b.newJsonWriter(r1);
        this.c.write(r2, r4);
        r2.close();
        return new TypedByteArray("application/json; charset=UTF-8", r0.toByteArray(), new String[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.Converter
    public /* synthetic */ TypedOutput convert(Object r1) {
        return a(r1);
    }
}
