package na;

import ha.c0;
import ha.d0;
import ha.j;
import ha.q;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c0<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9477b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f9478a;

    public class a implements d0 {
        @Override // ha.d0
        public final <T> c0<T> a(j r8, oa.a<T> r10) {
            if (r10.getRawType() == Time.class) goto L7;
            return null;
        L7:
            return new b();
        }
    }

    static {
        f9477b = new a();
    }

    public b() {
        this.f9478a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // ha.c0
    public final Time a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L5;
        r8.V();
        return null;
    L5:
        String r10 = r8.e0();
        monitor-enter(this);     // Catch: ParseException -> L14
        Time r11 = new Time(this.f9478a.parse(r10).getTime());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L10:
        return r11;
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        StringBuilder r12 = defpackage.b.h("Failed parsing '", r10, "' as SQL Time; at path ");
        r12.append(r8.A());
        throw new q(r12.toString(), e);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Time r10) {
        Time r11 = r10;
        if (r11 != null) goto L5;
        r8.z();
        return;
    L5:
        monitor-enter(this);
        String r12 = this.f9478a.format(r11);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r8.H(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
