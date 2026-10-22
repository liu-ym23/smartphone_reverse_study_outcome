package j7;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import ha.j;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f8738a;

    public a(j r8) {
        this.f8738a = r8;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<?, TypedOutput> requestBodyConverter(Type r8, Annotation[] r10, Annotation[] r11, Retrofit r12) {
        oa.a<?> r13 = oa.a.get(r8);
        j r14 = this.f8738a;
        return new b(r14, r14.f(r13));
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public final Converter<TypedInput, ?> responseBodyConverter(Type r8, Annotation[] r10, Retrofit r11) {
        oa.a<?> r12 = oa.a.get(r8);
        j r13 = this.f8738a;
        return new c(r13, r13.f(r12));
    }
}
