package fe;

import ie.b;
import ie.c;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ee.a {

    /* JADX INFO: renamed from: fe.a$a, reason: collision with other inner class name */
    public static final class C0075a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f7425a = null;

        static {
            Integer r8 = null;
            Object r10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if ((r10 instanceof Integer) == false) goto L7;
            Integer r11 = (Integer) r10;     // Catch: Throwable -> L17
        L8:
            if (r11 != null) goto L10;
        L15:
            f7425a = r8;
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
    public final c b() {
        Integer r8 = C0075a.f7425a;
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        return new je.a();
    L12:
        return new b();
    L5:
        if (r8.intValue() >= 34) goto L8;
        r10 = false;
        goto L9
    }
}
