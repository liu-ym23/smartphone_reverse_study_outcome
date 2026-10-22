package id;

import com.bytedance.android.chunkstreamprediction.network.h;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> implements Converter<TypedInput, com.bytedance.android.chunkstreamprediction.network.b<T>> {
    public final Gson a;
    public final TypeAdapter<T> b;
    public final h c;

    public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r10) {
        return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r10);
    }

    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.-CC.$default$needRequestBuilder(this);
    }

    public final Object convert(Object r10) throws IOException {
        TypedInput r11 = (TypedInput) r10;
        e r0 = new e(r11.in());
        String r12 = "UTF-8";
        if (r11.mimeType() == null) goto L5;
        r12 = MimeUtil.parseCharset(r11.mimeType(), "UTF-8");
    L5:
        com.bytedance.android.chunkstreamprediction.network.b r13 = new com.bytedance.android.chunkstreamprediction.network.b(new b(this, new com.bytedance.android.chunkstreamprediction.network.c(), r0, r12));
        r0.b = r13.a;
        return r13;
    }

    public c(Gson r1, TypeAdapter<T> r10, h r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
