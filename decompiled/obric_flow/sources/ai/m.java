package ai;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f280a;

    public m(Executor r5) {
        this.f280a = r5;
    }

    @Override // ai.d
    public final e a(Type r5) {
        if (w0.g(r5) == c.class) goto L7;
        return null;
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L11;
        int r10 = 1;
        return new q7.a(r10, this, w0.f(0, (ParameterizedType) r5));
    L11:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
