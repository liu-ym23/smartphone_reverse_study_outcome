package b4;

import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends m {
    public final /* synthetic */ Map<String, String> a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.ObjectRef<TypedInput> c;
    public final /* synthetic */ Ref.ObjectRef<String> d;
    public final /* synthetic */ Ref.ObjectRef<Throwable> e;
    public final /* synthetic */ Ref.IntRef f;

    @Override // b4.m
    public final int a() {
        return this.f.element;
    }

    @Override // b4.m
    public final String b() {
        return (String) this.d.element;
    }

    @Override // b4.m
    public final Throwable c() {
        return (Throwable) this.e.element;
    }

    @Override // b4.m
    public final TypedInput d() {
        return (TypedInput) this.c.element;
    }

    @Override // b4.m
    public final Integer e() {
        return Integer.valueOf(this.b.element);
    }

    @Override // b4.m
    public final Map<String, String> f() {
        return this.a;
    }

    public d(Map<String, String> r1, Ref.IntRef r10, Ref.ObjectRef<TypedInput> r11, Ref.ObjectRef<String> r12, Ref.ObjectRef<Throwable> r13, Ref.IntRef r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
