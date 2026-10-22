package ja;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class w extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f8812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8813c;

    public w(int r8, Method r10) {
        this.f8812b = r10;
        this.f8813c = r8;
    }

    @Override // ja.z
    public final <T> T b(Class<T> r8) {
        z.a(r8);
        Object[] r10 = {r8, Integer.valueOf(this.f8813c)};
        return (T) this.f8812b.invoke(null, r10);
    }
}
