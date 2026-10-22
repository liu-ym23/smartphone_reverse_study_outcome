package ntb;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.LevelTypes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface o extends com.ss.android.lark.officesdk.di.core.b {

    public interface a {
        com.ss.android.lark.officesdk.utils.di.k a(String r1);

        com.ss.android.lark.officesdk.utils.di.k b();

        void flush();
    }

    public interface b {
    }

    public interface c {
        public static final a a = null;

        public static final class a {
            public static final /* synthetic */ a a = null;
            public static final e b = null;
            public static final e c = null;
            public static final e d = null;

            public a() {
            }

            static {
                a = new a();
                b = new e("NORMAL", 1);
                c = new e(LevelTypes.TYPE_WARN, 2);
                d = new e(LevelTypes.TYPE_ERROR, 3);
            }
        }

        static {
            a = a.a;
        }
    }

    public static abstract class d implements b {
        public d(String r1, e r2) {
            Intrinsics.checkNotNullParameter(r1, "module");
        }
    }

    public static final class e implements c {
        public final String b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c;
        }

        public final String toString() {
            return "SimpleMonitorLevel(name=" + this.b + ", level=" + this.c + ')';
        }

        public e(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            this.b = r2;
            this.c = r3;
        }
    }

    String T();

    a d();

    String k0();
}
