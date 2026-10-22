package nc;

import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11356d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f11357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f11358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f11359c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final h a() {
            Method r10 = null;
            Class<?> r11 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
            Method r12 = r11.getMethod("get", new Class[0]);     // Catch: Exception -> L5
            Method r13 = r11.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r14 = r11.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
            r10 = r12;
        L7:
            return new h(r10, r13, r14);
        L5:
            r14 = null;
            r13 = null;
            goto L7
        }
    }

    static {
        f11356d = new a(null);
    }

    public h(Method r10, Method r11, Method r12) {
        this.f11357a = r10;
        this.f11358b = r11;
        this.f11359c = r12;
    }

    public final Object a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "closer");
        Method r11 = this.f11357a;
        if (r11 != null) goto L9;
    L7:
        return null;
    L9:
        Object r12 = r11.invoke(null, new Object[0]);     // Catch: Exception -> L8
        Method r13 = this.f11358b;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L8
        r13.invoke(r12, new Object[]{r10});     // Catch: Exception -> L8
        return r12;
    }

    public final boolean b(Object r10) {
        if (r10 == null) goto L10;
        Method r11 = this.f11359c;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L7
        r11.invoke(r10, new Object[0]);     // Catch: Exception -> L7
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
