package na;

import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9481a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9482b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9483c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final na.a.C0121a f9484d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final na.b.a f9485e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c.a f9486f = null;

    public class a extends ka.d.a<Date> {
        public a() {
            super(Date.class);
        }

        @Override // ka.d.a
        public final java.util.Date a(java.util.Date r8) {
            return new Date(r8.getTime());
        }
    }

    public class b extends ka.d.a<Timestamp> {
        public b() {
            super(Timestamp.class);
        }

        @Override // ka.d.a
        public final java.util.Date a(java.util.Date r8) {
            return new Timestamp(r8.getTime());
        }
    }

    static {
        Class.forName("java.sql.Date");     // Catch: ClassNotFoundException -> L4
        boolean r8 = true;
    L5:
        f9481a = r8;
        if (r8 == false) goto L8;
        f9482b = new a();
        f9483c = new b();
        f9484d = na.a.f9475b;
        f9485e = na.b.f9477b;
        c.a r10 = c.f9479b;
    L9:
        f9486f = r10;
        return;
    L8:
        r10 = null;
        f9482b = null;
        f9483c = null;
        f9484d = null;
        f9485e = null;
    L4:
        r8 = false;
        goto L5
    }
}
