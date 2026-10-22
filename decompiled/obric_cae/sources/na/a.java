package na;

import ha.c0;
import ha.d0;
import ha.j;
import ha.q;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c0<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0121a f9475b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f9476a;

    /* JADX INFO: renamed from: na.a$a, reason: collision with other inner class name */
    public class C0121a implements d0 {
        @Override // ha.d0
        public final <T> c0<T> a(j r8, oa.a<T> r10) {
            if (r10.getRawType() == Date.class) goto L7;
            return null;
        L7:
            return new a();
        }
    }

    static {
        f9475b = new C0121a();
    }

    public a() {
        this.f9476a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // ha.c0
    public final Date a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L5;
        r8.V();
        return null;
    L5:
        String r10 = r8.e0();
        monitor-enter(this);     // Catch: ParseException -> L14
        java.util.Date r11 = this.f9476a.parse(r10);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L10:
        return new Date(r11.getTime());
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        StringBuilder r12 = defpackage.b.h("Failed parsing '", r10, "' as SQL Date; at path ");
        r12.append(r8.A());
        throw new q(r12.toString(), e);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Date r10) {
        Date r11 = r10;
        if (r11 != null) goto L5;
        r8.z();
        return;
    L5:
        monitor-enter(this);
        String r12 = this.f9476a.format(r11);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r8.H(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
