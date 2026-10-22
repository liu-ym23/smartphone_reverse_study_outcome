package ka;

import ha.c0;
import ha.d0;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c extends c0<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8989b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8990a;

    public class a implements d0 {
        @Override // ha.d0
        public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
            if (r10.getRawType() == Date.class) goto L7;
            return null;
        L7:
            return new c();
        }
    }

    static {
        f8989b = new a();
    }

    public c() {
        ArrayList r8 = new ArrayList();
        this.f8990a = r8;
        Locale r10 = Locale.US;
        r8.add(DateFormat.getDateTimeInstance(2, 2, r10));
        if (Locale.getDefault().equals(r10) == true) goto L6;
        r8.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (ja.q.f8782a < 9) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        r8.add(l6.a.T(2, 2));
        return;
    L12:
        return;
    L8:
        r11 = false;
        goto L9
    }

    @Override // ha.c0
    public final Date a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L5;
        r8.V();
        return null;
    L5:
        String r10 = r8.e0();
        ArrayList r11 = this.f8990a;
        monitor-enter(r11);
        Iterator r12 = this.f8990a.iterator();     // Catch: Throwable -> L20
    L9:
        if (r12.hasNext() == false) goto L14;
        Date r13 = ((DateFormat) r12.next()).parse(r10);     // Catch: ParseException -> L23 Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
    L24:
        return r13;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L20
        r13 = la.a.b(r10, new ParsePosition(0));     // Catch: ParseException -> L17
    L17:
        e = move-exception;
        StringBuilder r14 = defpackage.b.h("Failed parsing '", r10, "' as Date; at path ");
        r14.append(r8.A());
        throw new ha.q(r14.toString(), e);
    L20:
        th = move-exception;
        throw th;
    }

    @Override // ha.c0
    public final void b(pa.c r8, Date r10) {
        Date r11 = r10;
        if (r11 != null) goto L5;
        r8.z();
        return;
    L5:
        DateFormat r12 = (DateFormat) this.f8990a.get(0);
        ArrayList r13 = this.f8990a;
        monitor-enter(r13);
        String r14 = r12.format(r11);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        r8.H(r14);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
