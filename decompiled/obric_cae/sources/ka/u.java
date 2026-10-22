package ka;

import ha.c0;
import ha.d0;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public final class u implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f9089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f9090b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c0 f9091m;

    public u(r.C0109r r8) {
        this.f9089a = Calendar.class;
        this.f9090b = GregorianCalendar.class;
        this.f9091m = r8;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        Class<? super T> r11 = r10.getRawType();
        if (r11 == this.f9089a) goto L9;
        if (r11 == this.f9090b) goto L9;
        return null;
    L9:
        return this.f9091m;
    }

    public final String toString() {
        return "Factory[type=" + this.f9089a.getName() + "+" + this.f9090b.getName() + ",adapter=" + this.f9091m + "]";
    }
}
