package oyb;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKProtocol {

    /* JADX INFO: renamed from: oyb.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0174a {

        /* JADX INFO: renamed from: oyb.a$a$a, reason: collision with other inner class name */
        public static final class C0175a extends AbstractC0174a {
            public static final C0175a a = null;

            static {
                a = new C0175a();
            }

            public C0175a() {
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$b */
        public static final class b extends AbstractC0174a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$c */
        public static final class c extends AbstractC0174a {
            public final String a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                String r1 = this.b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Failure(code=" + this.a + ", message=" + this.b + ')';
            }

            public c(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "code");
                this.a = r2;
                this.b = r3;
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$d */
        public static final class d extends AbstractC0174a {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public AbstractC0174a() {
        }
    }

    void R(Function2 r1);

    void q();

    void s1(Map<String, String> r1, Function1<? super AbstractC0174a, Unit> r2);
}
