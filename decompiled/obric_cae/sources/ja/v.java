package ja;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class v extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8811c;

    public v(Object r8, Method r10) {
        this.f8810b = r10;
        this.f8811c = r8;
    }

    @Override // ja.z
    public final <T> T b(Class<T> r8) {
        z.a(r8);
        Method r10 = this.f8810b;
        Object r11 = this.f8811c;
        return (T) r10.invoke(r11, new Object[]{r8});
    }
}
