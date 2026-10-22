package ja;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class x extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f8814b;

    public x(Method r8) {
        this.f8814b = r8;
    }

    @Override // ja.z
    public final <T> T b(Class<T> r8) {
        z.a(r8);
        Method r10 = this.f8814b;
        return (T) r10.invoke(null, new Object[]{r8, Object.class});
    }
}
