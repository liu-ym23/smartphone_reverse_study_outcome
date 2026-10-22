package zn0;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedInput;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final e<Object> a;
    public final Converter<TypedInput, ?> b;

    public final void a() {
        this.a.onComplete();
    }

    public final void b(com.bytedance.frameworks.baselib.netx.chunk.b r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "chunk");
        r3.getClass();
        throw null;
    }

    public final void c(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.onFailed(r2);
    }

    public final void d(com.bytedance.frameworks.baselib.netx.chunk.b r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "chunk");
        r3.getClass();
        throw null;
    }

    public a(e<Object> r2, Converter<TypedInput, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "converter");
        this.a = r2;
        this.b = r3;
    }
}
