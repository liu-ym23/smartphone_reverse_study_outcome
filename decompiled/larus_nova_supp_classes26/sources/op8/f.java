package op8;

import android.net.Uri;
import android.view.View;
import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface f {

    public static abstract class a {

        /* JADX INFO: renamed from: op8.f$a$a, reason: collision with other inner class name */
        public static final class C0125a extends a {
            public static final C0125a a = null;

            static {
                a = new C0125a();
            }

            public C0125a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "StreamResult(text=" + this.a + ')';
            }

            public d(String r2) {
                Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
                this.a = r2;
            }
        }

        public static final class e extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Succeed(text=" + this.a + ')';
            }

            public e(String r2) {
                Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
                this.a = r2;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: op8.f$b$b, reason: collision with other inner class name */
        public static final class C0126b extends b {
            public static final C0126b a = null;

            static {
                a = new C0126b();
            }

            public C0126b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    void A3(List<String> r1);

    void M7(View r1, String r2);

    void a(String r1);

    void b(int r1, long r2);

    boolean c(String r1);

    void d(int r1);

    void e(a r1);

    void f(b r1);

    void f4(View r1);

    boolean g();

    Map<String, String> getEventInfo();

    void h(boolean r1);

    void h0(Uri r1);
}
