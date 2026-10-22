package e6;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends q<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f8644b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f8645a;

    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            if (r11.getRawType() == Date.class) goto L7;
            return null;
        L7:
            return new c();
        }
    }

    static {
        f8644b = new a();
    }

    public c() {
        ArrayList r10 = new ArrayList();
        this.f8645a = r10;
        Locale r11 = Locale.US;
        r10.add(DateFormat.getDateTimeInstance(2, 2, r11));
        if (Locale.getDefault().equals(r11) == true) goto L6;
        r10.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (com.google.gson.internal.d.d() == false) goto L9;
        r10.add(com.google.gson.internal.g.c(2, 2));
        return;
    }

    private Date e(i6.a r10) {
        String r11 = r10.N();
        List<DateFormat> r12 = this.f8645a;
        monitor-enter(r12);
        Iterator<DateFormat> r13 = this.f8645a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r13.hasNext() == false) goto L11;
        Date r14 = r13.next().parse(r11);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r14;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L17
        return f6.a.c(r11, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r11 + "' as Date; at path " + r10.s(), e);
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ Date b(i6.a r10) {
        return f(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Date r11) {
        g(r10, r11);
    }

    public Date f(i6.a r10) {
        if (r10.Q() != JsonToken.NULL) goto L7;
        r10.K();
        return null;
    L7:
        return e(r10);
    }

    public void g(com.google.gson.stream.a r10, Date r11) {
        if (r11 != null) goto L5;
        r10.B();
        return;
    L5:
        DateFormat r12 = this.f8645a.get(0);
        List<DateFormat> r13 = this.f8645a;
        monitor-enter(r13);
        String r14 = r12.format(r11);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        r10.a0(r14);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
