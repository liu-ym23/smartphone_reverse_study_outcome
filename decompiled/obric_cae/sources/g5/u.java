package g5;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class u implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f7690b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f7691c = null;

    static {
        Class<?> r8 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L4
        f7690b = r8;     // Catch: Exception -> L4
        f7689a = r8.newInstance();     // Catch: Exception -> L4
        f7691c = r8.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.getMessage();
        int r10 = x4.r.f13543a;
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        m.a r10 = new m.a();     // Catch: Exception -> L13
        Method r11 = f7691c;     // Catch: Exception -> L13
        Object r12 = f7689a;     // Catch: Exception -> L13
        if (r12 == null) goto L10;
        if (r11 == null) goto L10;
        Object r13 = r11.invoke(r12, new Object[]{r8});     // Catch: Exception -> L16
        if (r13 == null) goto L10;
        String r14 = (String) r13;     // Catch: Exception -> L16
    L11:
        r10.f7667a = r14;     // Catch: Exception -> L13
        return r10;
    L10:
        r14 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        if (f7690b != null) goto L5;
    L9:
        return false;
    L5:
        if (f7689a == null) goto L9;
        if (f7691c == null) goto L9;
        return true;
    }

    @Override // g5.m
    public final String getName() {
        return "Xiaomi";
    }
}
