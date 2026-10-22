package x18;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b {
    public static final TimeUnit a = null;

    public static final class a {
        public Context a;
        public final List<y18.b> b;
        public boolean c;
        public long d;
        public TimeUnit e;
        public long f;
        public TimeUnit g;
        public long h;
        public TimeUnit i;

        public a() {
            this.b = new ArrayList();
            this.d = 10000;
            TimeUnit r2 = b.a;
            this.e = r2;
            this.f = 10000;
            this.g = r2;
            this.h = 10000;
            this.i = r2;
        }
    }

    List<a28.a> a(String r1);

    void b(String r1, List<a28.a> r2);

    com.larksuite.framework.http.call.b c(z18.a r1);

    b28.b newCall(Request r1);

    static {
        a = TimeUnit.MILLISECONDS;
    }
}
