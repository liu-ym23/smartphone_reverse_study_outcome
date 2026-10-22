package na;

import ha.c0;
import ha.d0;
import ha.j;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class c extends c0<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9479b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<Date> f9480a;

    public class a implements d0 {
        @Override // ha.d0
        public final <T> c0<T> a(j r8, oa.a<T> r10) {
            if (r10.getRawType() != Timestamp.class) goto L6;
            r8.getClass();
            return new c(r8.f(oa.a.get(Date.class)));
        L6:
            return null;
        }
    }

    static {
        f9479b = new a();
    }

    public c(c0 r8) {
        this.f9480a = r8;
    }

    @Override // ha.c0
    public final Timestamp a(pa.a r8) {
        Date r10 = this.f9480a.a(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r10.getTime());
    }

    @Override // ha.c0
    public final void b(pa.c r8, Timestamp r10) {
        c0<Date> r11 = this.f9480a;
        r11.b(r8, r10);
    }
}
