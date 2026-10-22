package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f18979a = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int r5 = kotlinx.coroutines.internal.u.f18952a;
        String r10 = System.getProperty("kotlinx.coroutines.main.delay");     // Catch: SecurityException -> L5
    L6:
        if (r10 == null) goto L8;
        boolean r11 = Boolean.parseBoolean(r10);
    L9:
        if (r11 == true) goto L11;
        o0 r12 = k0.f18973h;
    L15:
        f18979a = r12;
        return;
    L11:
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        r13.getImmediate();
        if ((r13 instanceof o0) == true) goto L14;
        r12 = k0.f18973h;
        goto L15
    L14:
        r12 = (o0) r13;
        goto L15
    L8:
        r11 = false;
    L5:
        r10 = null;
        goto L6
    }
}
