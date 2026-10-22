package ka;

import ha.c0;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d<T extends Date> extends c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f8991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8992b;

    public static abstract class a<T extends Date> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0108a f8993b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f8994a;

        /* JADX INFO: renamed from: ka.d$a$a, reason: collision with other inner class name */
        public class C0108a extends a<Date> {
            public C0108a() {
                super(Date.class);
            }

            @Override // ka.d.a
            public final Date a(Date r8) {
                return r8;
            }
        }

        static {
            f8993b = new C0108a();
        }

        public a(Class<T> r8) {
            this.f8994a = r8;
        }

        public abstract T a(Date r8);
    }

    public d(a r8, int r10, int r11) {
        ArrayList r12 = new ArrayList();
        this.f8992b = r12;
        Objects.requireNonNull(r8);
        this.f8991a = r8;
        Locale r13 = Locale.US;
        r12.add(DateFormat.getDateTimeInstance(r10, r11, r13));
        if (Locale.getDefault().equals(r13) == true) goto L6;
        r12.add(DateFormat.getDateTimeInstance(r10, r11));
    L6:
        if (ja.q.f8782a < 9) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L12;
        r12.add(l6.a.T(r10, r11));
        return;
    L12:
        return;
    L8:
        r14 = false;
        goto L9
    }

    @Override // ha.c0
    public final Object a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L5;
        r8.V();
        return null;
    L5:
        String r10 = r8.e0();
        ArrayList r11 = this.f8992b;
        monitor-enter(r11);
        Iterator r12 = this.f8992b.iterator();     // Catch: Throwable -> L21
    L9:
        if (r12.hasNext() == false) goto L14;
        Date r13 = ((DateFormat) r12.next()).parse(r10);     // Catch: ParseException -> L24 Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
    L17:
        return this.f8991a.a(r13);
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L21
        r13 = la.a.b(r10, new ParsePosition(0));     // Catch: ParseException -> L18
    L18:
        e = move-exception;
        StringBuilder r14 = defpackage.b.h("Failed parsing '", r10, "' as Date; at path ");
        r14.append(r8.A());
        throw new ha.q(r14.toString(), e);
    L21:
        th = move-exception;
        throw th;
    }

    @Override // ha.c0
    public final void b(pa.c r8, Object r10) {
        Date r11 = (Date) r10;
        if (r11 != null) goto L5;
        r8.z();
        return;
    L5:
        DateFormat r12 = (DateFormat) this.f8992b.get(0);
        ArrayList r13 = this.f8992b;
        monitor-enter(r13);
        String r14 = r12.format(r11);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        r8.H(r14);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        DateFormat r8 = (DateFormat) this.f8992b.get(0);
        if ((r8 instanceof SimpleDateFormat) == false) goto L5;
        StringBuilder r10 = new StringBuilder("DefaultDateTypeAdapter(");
        String r11 = ((SimpleDateFormat) r8).toPattern();
    L6:
        r10.append(r11);
        r10.append(')');
        return r10.toString();
    L5:
        r10 = new StringBuilder("DefaultDateTypeAdapter(");
        r11 = r8.getClass().getSimpleName();
        goto L6
    }
}
