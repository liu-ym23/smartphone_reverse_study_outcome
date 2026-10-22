package ja;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class o implements t<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Constructor f8769a;

    public o(Constructor r8) {
        this.f8769a = r8;
    }

    @Override // ja.t
    public final Object b() {
        Constructor r8 = this.f8769a;
        return r8.newInstance(new Object[0]);
    L5:
        e = move-exception;
        ma.a.AbstractC0115a r10 = ma.a.f9316a;
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to invoke constructor '" + ma.a.b(r8) + "' with no args", e);
    L8:
        e = move-exception;
        throw new RuntimeException("Failed to invoke constructor '" + ma.a.b(r8) + "' with no args", e.getCause());
    }
}
