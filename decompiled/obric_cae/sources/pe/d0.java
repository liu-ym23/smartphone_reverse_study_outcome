package pe;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements c4.a {
    public /* synthetic */ d0() {
    }

    public static final String c(Object r8) {
        return Integer.toHexString(System.identityHashCode(r8));
    }

    public static final String d(ae.d r8) {
        if ((r8 instanceof ue.g) == false) goto L16;
        return r8.toString();
    L16:
        Object r10 = r8 + '@' + c(r8);     // Catch: Throwable -> L8
    L11:
        if (xd.e.a(r10) == null) goto L15;
        r10 = r8.getClass().getName() + '@' + c(r8);
    L15:
        return (String) r10;
    L8:
        th = move-exception;
        r10 = defpackage.c.D(th);
        goto L11
    }

    @Override // c4.a
    public final void a(String r8, ge.a r10) {
    }

    public void b(float r8, float r10, aa.m r11) {
        throw null;
    }
}
