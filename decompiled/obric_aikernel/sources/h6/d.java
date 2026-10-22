package h6;

import com.google.gson.r;
import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9190a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f9191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f9192c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f9193d = null;

    class a extends e6.d<Date> {
        a(Class r10) {
            super(r10);
        }
    }

    class b extends e6.d<Timestamp> {
        b(Class r10) {
            super(r10);
        }
    }

    static {
        Class.forName("java.sql.Date");     // Catch: ClassNotFoundException -> L4
        boolean r10 = true;
    L5:
        f9190a = r10;
        if (r10 == false) goto L8;
        new a(Date.class);
        new b(Timestamp.class);
        f9191b = h6.a.f9184b;
        f9192c = h6.b.f9186b;
        r r11 = c.f9188b;
    L9:
        f9193d = r11;
        return;
    L8:
        r11 = null;
        f9191b = null;
        f9192c = null;
    L4:
        r10 = false;
        goto L5
    }
}
