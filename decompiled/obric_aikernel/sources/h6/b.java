package h6;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
final class b extends q<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r f9186b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f9187a;

    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Class<? super T> r12 = r11.getRawType();
            a r13 = null;
            if (r12 == Time.class) goto L5;
            return null;
        L5:
            return new b(r13);
        }
    }

    static {
        f9186b = new a();
    }

    private b() {
        this.f9187a = new SimpleDateFormat("hh:mm:ss a");
    }

    /* synthetic */ b(a r10) {
        this();
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ Time b(i6.a r10) {
        return e(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Time r11) {
        f(r10, r11);
    }

    public Time e(i6.a r10) {
        if (r10.Q() != JsonToken.NULL) goto L6;
        r10.K();
        return null;
    L6:
        String r11 = r10.N();
        monitor-enter(this);     // Catch: ParseException -> L14
        Time r12 = new Time(this.f9187a.parse(r11).getTime());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r11 + "' as SQL Time; at path " + r10.s(), e);
    }

    public void f(com.google.gson.stream.a r10, Time r11) {
        if (r11 != null) goto L5;
        r10.B();
        return;
    L5:
        monitor-enter(this);
        String r12 = this.f9187a.format(r11);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r10.a0(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
