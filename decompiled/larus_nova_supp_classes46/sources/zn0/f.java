package zn0;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedInput;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<R> extends com.bytedance.frameworks.baselib.netx.chunk.d {
    public final TypedInput d;
    public final Converter<TypedInput, R> e;

    public f(TypedInput r2, Converter<TypedInput, R> r3) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "originalConverter");
        super(r2);
        this.d = r2;
        this.e = r3;
    }
}
