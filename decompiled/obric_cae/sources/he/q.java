package he;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public q() {
    }

    public static String a(f r8) {
        String r10 = r8.getClass().getGenericInterfaces()[0].toString();
        if (r10.startsWith("kotlin.jvm.functions.") == true) goto L5;
        return r10;
    L5:
        return r10.substring(21);
    }
}
