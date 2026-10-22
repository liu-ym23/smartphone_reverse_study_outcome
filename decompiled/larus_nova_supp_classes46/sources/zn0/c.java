package zn0;

import com.bytedance.android.live.network.impl.factory.MultiTypeRequestConverterFactory;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends com.bytedance.frameworks.baselib.netx.chunk.c {
    public final Converter.Factory a;

    public static final class a<F, T> implements Converter {
        public final /* synthetic */ Converter a;

        public a(Converter r1) {
            this.a = r1;
        }

        public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
            return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
        }

        public final /* synthetic */ boolean needRequestBuilder() {
            return Converter.-CC.$default$needRequestBuilder(this);
        }

        public final Object convert(Object r3) {
            return new f((TypedInput) r3, this.a);
        }
    }

    public c(MultiTypeRequestConverterFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "originalConverterFactory");
        this.a = r2;
    }

    public final Converter<?, Header> headerConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.headerConverter(r2, r3, r4);
    }

    public final Converter<?, Object> objectConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.objectConverter(r2, r3, r4);
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r4, Annotation[] r5, Retrofit r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Intrinsics.checkNotNullParameter(r6, "retrofit");
        if ((r4 instanceof ParameterizedType) == false) goto L17;
        ParameterizedType r0 = (ParameterizedType) r4;
        if ((r0.getRawType() instanceof Class) == false) goto L17;
        Type r2 = r0.getRawType();
        if (r2 == null) goto L15;
        if (f.class.isAssignableFrom((Class) r2) == false) goto L17;
        Converter r7 = this.a.responseBodyConverter(r0.getActualTypeArguments()[0], r5, r6);
        if (r7 != null) goto L18;
        return null;
    L18:
        return new a(r7);
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L17:
        return this.a.responseBodyConverter(r4, r5, r6);
    }

    public final Converter<?, String> stringConverter(Type r2, Annotation[] r3, Retrofit r4) {
        return this.a.stringConverter(r2, r3, r4);
    }

    public final Converter<?, TypedOutput> requestBodyConverter(Type r2, Annotation[] r3, Annotation[] r4, Retrofit r5) {
        return this.a.requestBodyConverter(r2, r3, r4, r5);
    }
}
