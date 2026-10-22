package he;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f8065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final le.b[] f8066b = null;

    static {
        q r8 = null;
        r8 = (q) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();     // Catch: Throwable -> L10
    L5:
        if (r8 != null) goto L8;
        r8 = new q();
    L8:
        f8065a = r8;
        f8066b = new le.b[0];
    }

    public static d a(Class r8) {
        f8065a.getClass();
        return new d(r8);
    }
}
