package id;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends Converter.Factory {
    public final Gson a;
    public final com.bytedance.android.chunkstreamprediction.network.e b;

    public final Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r10, Annotation[] r11, Retrofit r12) {
        return null;
    }

    public a(Gson r1, com.bytedance.android.chunkstreamprediction.network.e r10) {
        if (r1 == null) goto L7;
        this.a = r1;
        this.b = r10;
        return;
    L7:
        throw new NullPointerException("gson == null");
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r10, Annotation[] r11, Retrofit r12) {
        if ((r10 instanceof ParameterizedType) == true) goto L5;
        return null;
    L5:
        ParameterizedType r13 = (ParameterizedType) r10;
        Type r14 = r13.getRawType();
        if ((r14 instanceof Class) == true) goto L9;
        return null;
    L9:
        if (com.bytedance.android.chunkstreamprediction.network.b.class.isAssignableFrom((Class) r14) == true) goto L11;
        return null;
    L11:
        Type[] r15 = r13.getActualTypeArguments();
        if (r15.length != 1) goto L16;
        Type r16 = r15[0];
        TypeAdapter r17 = this.a.getAdapter(TypeToken.get(r16));
        Gson r0 = this.a;
        this.b.getClass();
        return new c(r0, r17, null);
    L16:
        throw new RuntimeException("ChunkBundle should have one generic type.");
    }
}
