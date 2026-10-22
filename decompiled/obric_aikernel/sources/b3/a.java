package b3;

import com.bytedance.retrofit2.f;
import com.bytedance.retrofit2.t;
import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import r4.e;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f518a;

    private a(d r10) {
        Objects.requireNonNull(r10, "gson == null");
        this.f518a = r10;
    }

    public static a f() {
        return g(new d());
    }

    public static a g(d r10) {
        return new a(r10);
    }

    @Override // com.bytedance.retrofit2.f.a
    public f<?, r4.f> c(Type r10, Annotation[] r11, Annotation[] r12, t r13) {
        q r14 = this.f518a.m(TypeToken.get(r10));
        return new b(this.f518a, r14);
    }

    @Override // com.bytedance.retrofit2.f.a
    public f<e, ?> d(Type r10, Annotation[] r11, t r12) {
        q r13 = this.f518a.m(TypeToken.get(r10));
        return new c(this.f518a, r13);
    }
}
