package h6;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
final class a extends q<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r f9184b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f9185a;

    /* JADX INFO: renamed from: h6.a$a, reason: collision with other inner class name */
    class C0177a implements r {
        C0177a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Class<? super T> r12 = r11.getRawType();
            C0177a r13 = null;
            if (r12 == Date.class) goto L5;
            return null;
        L5:
            return new a(r13);
        }
    }

    static {
        f9184b = new C0177a();
    }

    private a() {
        this.f9185a = new SimpleDateFormat("MMM d, yyyy");
    }

    /* synthetic */ a(C0177a r10) {
        this();
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ Date b(i6.a r10) {
        return e(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Date r11) {
        f(r10, r11);
    }

    public Date e(i6.a r10) {
        if (r10.Q() != JsonToken.NULL) goto L6;
        r10.K();
        return null;
    L6:
        String r11 = r10.N();
        monitor-enter(this);     // Catch: ParseException -> L15
        java.util.Date r12 = this.f9185a.parse(r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L11:
        return new Date(r12.getTime());
    L12:
        th = move-exception;
        throw th;     // Catch: ParseException -> L15
    L15:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r11 + "' as SQL Date; at path " + r10.s(), e);
    }

    public void f(com.google.gson.stream.a r10, Date r11) {
        if (r11 != null) goto L5;
        r10.B();
        return;
    L5:
        monitor-enter(this);
        String r12 = this.f9185a.format(r11);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r10.a0(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
