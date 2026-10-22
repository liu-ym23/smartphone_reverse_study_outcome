package we;

import com.bytedance.retrofit2.HttpMethodContrants;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f13337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f13338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f13340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final z f13341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, Object> f13342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public volatile c f13343g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public r f13344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final r f13345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public q.a f13347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public z f13348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<Class<?>, Object> f13349f;

        public a() {
            this.f13349f = Collections.emptyMap();
            this.f13346c = HttpMethodContrants.GET;
            this.f13347d = new q.a();
        }

        public final y a() {
            if (this.f13344a == null) goto L7;
            return new y(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public final void b(String r8, String r10) {
            this.f13347d.d(r8, r10);
        }

        public final void c(@Nullable z r8, String r10) {
            if (r10 == null) goto L35;
            if (r10.length() == 0) goto L33;
            if (r8 != null) goto L8;
        L12:
            if (r8 == null) goto L14;
        L30:
            this.f13346c = r10;
            this.f13348e = r8;
            return;
        L14:
            if (r10.equals(HttpMethodContrants.POST) == false) goto L16;
        L25:
            boolean r11 = true;
        L26:
            if (r11 == false) goto L30;
            throw new IllegalArgumentException(defpackage.b.d("method ", r10, " must have a request body."));
        L16:
            if (r10.equals(HttpMethodContrants.PUT) == true) goto L25;
            if (r10.equals(HttpMethodContrants.PATCH) == true) goto L25;
            if (r10.equals("PROPPATCH") == true) goto L25;
            if (r10.equals("REPORT") == true) goto L25;
            r11 = false;
            goto L26
        L8:
            if (defpackage.c.b0(r10) == true) goto L12;
            throw new IllegalArgumentException(defpackage.b.d("method ", r10, " must not have a request body."));
        L33:
            throw new IllegalArgumentException("method.length() == 0");
        L35:
            throw new NullPointerException("method == null");
        }

        public final void d(String r8) {
            this.f13347d.c(r8);
        }

        public final void e(String r10) {
            if (r10 == null) goto L13;
            if (r10.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            StringBuilder r8 = new StringBuilder("http:");
            int r11 = 3;
        L9:
            r8.append(r10.substring(r11));
            r10 = r8.toString();
        L10:
            r.a r12 = new r.a();
            r12.b(null, r10);
            f(r12.a());
            return;
        L7:
            if (r10.regionMatches(true, 0, "wss:", 0, 4) == false) goto L10;
            r8 = new StringBuilder("https:");
            r11 = 4;
            goto L9
        L13:
            throw new NullPointerException("url == null");
        }

        public final void f(r r8) {
            if (r8 == null) goto L6;
            this.f13344a = r8;
            return;
        L6:
            throw new NullPointerException("url == null");
        }

        public a(y r8) {
            this.f13349f = Collections.emptyMap();
            this.f13344a = r8.f13337a;
            this.f13346c = r8.f13339c;
            this.f13348e = r8.f13341e;
            Map<Class<?>, Object> r10 = r8.f13342f;
            if (r10.isEmpty() == false) goto L5;
            Map<Class<?>, Object> r11 = Collections.emptyMap();
        L6:
            this.f13349f = r11;
            this.f13347d = r8.f13340d.g();
            this.f13345b = r8.f13338b;
            return;
        L5:
            r11 = new LinkedHashMap(r10);
            goto L6
        }
    }

    public y(a r8) {
        this.f13337a = r8.f13344a;
        this.f13338b = r8.f13345b;
        this.f13339c = r8.f13346c;
        q.a r10 = r8.f13347d;
        r10.getClass();
        this.f13340d = new q(r10);
        this.f13341e = r8.f13348e;
        Map<Class<?>, Object> r11 = r8.f13349f;
        byte[] r12 = xe.c.f13880a;
        if (r11.isEmpty() == false) goto L5;
        Map<Class<?>, Object> r13 = Collections.emptyMap();
    L6:
        this.f13342f = r13;
        return;
    L5:
        r13 = Collections.unmodifiableMap(new LinkedHashMap(r11));
        goto L6
    }

    @Nullable
    public final z a() {
        return this.f13341e;
    }

    @Nullable
    public final String b(String r8) {
        return this.f13340d.d(r8);
    }

    public final q c() {
        return this.f13340d;
    }

    public final String d() {
        return this.f13339c;
    }

    public final String toString() {
        return "Request{method=" + this.f13339c + ", url=" + this.f13337a + ", tags=" + this.f13342f + '}';
    }
}
