package ee;

import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class a extends de.a {

    /* JADX INFO: renamed from: ee.a$a, reason: collision with other inner class name */
    public static final class C0069a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f7231a = null;

        static {
            Integer r8 = null;
            Object r10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if ((r10 instanceof Integer) == false) goto L7;
            Integer r11 = (Integer) r10;     // Catch: Throwable -> L17
        L8:
            if (r11 != null) goto L10;
        L15:
            f7231a = r8;
            return;
        L10:
            if (r11.intValue() <= 0) goto L12;
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            r8 = r11;
            goto L15
        L12:
            r12 = false;
        L7:
            r11 = null;
            goto L8
        }
    }

    public a() {
    }

    @Override // de.a
    public final void a(Throwable r8, Throwable r10) {
        i.f(r8, "cause");
        i.f(r10, "exception");
        Integer r11 = C0069a.f7231a;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        r8.addSuppressed(r10);
        return;
    L11:
        super.a(r8, r10);
        return;
    L5:
        if (r11.intValue() >= 19) goto L8;
        r12 = false;
        goto L9
    }
}
