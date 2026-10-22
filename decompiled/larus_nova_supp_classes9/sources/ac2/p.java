package ac2;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class p<T> {

    public static final class a<T> extends p<T> {
        public static final Charset c = null;
        public final Converter<T, TypedOutput> a;
        public final Type b;

        static {
            c = Charset.forName("UTF-8");
        }

        public a(Converter r1, Type r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // ac2.p
        public final void a(w r2, final T r3) {
            if (r3 == null) goto L6;
            r2.c = "application/json; charset=UTF-8";
            r2.g = new o(this, r3);
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class b<T> extends p<T> {
        public final String a;
        public final Converter<T, String> b;
        public final boolean c;

        @Override // ac2.p
        public final void a(w r3, T r4) throws IOException {
            if (r4 != null) goto L4;
            return;
        L4:
            r3.a(this.a, (String) this.b.convert(r4), this.c);
        }

        public b(String r1, Converter<T, String> r2, boolean r3) {
            if (r1 == null) goto L7;
            this.a = r1;
            this.b = r2;
            this.c = r3;
            return;
        L7:
            throw new NullPointerException("name == null");
        }
    }

    public static final class c<T> extends p<Map<String, T>> {
        public final Converter<T, String> a;
        public final boolean b;

        public c(Converter<T, String> r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // ac2.p
        public final void a(w r4, Object r5) throws IOException {
            Map r6 = (Map) r5;
            if (r6 == null) goto L18;
            Iterator r7 = r6.entrySet().iterator();
        L6:
            if (r7.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) r7.next();
            String r1 = (String) r0.getKey();
            if (r1 == null) goto L15;
            Object r2 = r0.getValue();
            if (r2 == null) goto L13;
            r4.a(r1, (String) this.a.convert(r2), this.b);
            goto L6
        L13:
            throw new IllegalArgumentException("Field map contained null value for key '" + r1 + "'.");
        L15:
            throw new IllegalArgumentException("Field map contained null key.");
        L16:
            return;
        L18:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class d<T> extends p<T> {
        public final String a;
        public final Converter<T, String> b;

        public d(String r1, Converter<T, String> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // ac2.p
        public final void a(w r3, T r4) throws IOException {
            String r0 = this.a;
            if (r0 == null) goto L8;
            if (r4 == null) goto L9;
            r3.b(r0, (String) this.b.convert(r4));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> extends p<T> {
        public final String a;
        public final Converter<T, String> b;
        public final boolean c;

        @Override // ac2.p
        public final void a(w r3, T r4) throws IOException {
            if (r4 != null) goto L4;
            return;
        L4:
            r3.c(this.a, (String) this.b.convert(r4), this.c);
        }

        public e(String r1, Converter<T, String> r2, boolean r3) {
            if (r1 == null) goto L7;
            this.a = r1;
            this.b = r2;
            this.c = r3;
            return;
        L7:
            throw new NullPointerException("name == null");
        }
    }

    public static final class f<T> extends p<Map<String, T>> {
        public final Converter<T, String> a;
        public final boolean b;

        public f(Converter<T, String> r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // ac2.p
        public final void a(w r4, Object r5) throws IOException {
            Map r6 = (Map) r5;
            if (r6 == null) goto L16;
            Iterator r7 = r6.entrySet().iterator();
        L7:
            if (r7.hasNext() == false) goto L23;
            Map.Entry r0 = (Map.Entry) r7.next();
            String r1 = (String) r0.getKey();
            if (r1 == null) goto L15;
            Object r2 = r0.getValue();
            if (r2 == null) goto L7;
            r4.c(r1, (String) this.a.convert(r2), this.b);
            goto L7
        L15:
            throw new IllegalArgumentException("Query map contained null key.");
        L23:
            return;
        }
    }

    public static final class g extends p<Object> {
        public g() {
        }

        @Override // ac2.p
        public final void a(w r1, Object r2) {
            String r3 = r2.toString();
            if (r3 == null) goto L7;
            r1.a = r3.toString();
            return;
        L7:
            throw new NullPointerException("@Url parameter is null.");
        }
    }

    public static final class h extends p<RequestBody> {
        public h() {
        }

        @Override // ac2.p
        public final void a(final w r2, RequestBody r3) throws IOException {
            final RequestBody r4 = r3;
            r2.g = new q(r4, r2);
        }
    }

    public p() {
    }

    public abstract void a(w r1, T r2) throws IOException;
}
