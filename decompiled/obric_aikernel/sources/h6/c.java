package h6;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
class c extends q<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r f9188b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q<Date> f9189a;

    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            a r12 = null;
            if (r11.getRawType() == Timestamp.class) goto L5;
            return null;
        L5:
            return new c(r10.n(Date.class), r12);
        }
    }

    static {
        f9188b = new a();
    }

    private c(q<Date> r10) {
        this.f9189a = r10;
    }

    /* synthetic */ c(q r10, a r11) {
        this(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ Timestamp b(i6.a r10) {
        return e(r10);
    }

    @Override // com.google.gson.q
    public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Timestamp r11) {
        f(r10, r11);
    }

    public Timestamp e(i6.a r10) {
        Date r11 = this.f9189a.b(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r11.getTime());
    }

    public void f(com.google.gson.stream.a r10, Timestamp r11) {
        this.f9189a.d(r10, r11);
    }
}
