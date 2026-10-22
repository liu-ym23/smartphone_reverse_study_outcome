package q11;

import com.bytedance.android.live.link.data.RevPkResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: q11.a$a, reason: collision with other inner class name */
    public static final class C0294a extends a {
        public static final C0294a a = null;

        static {
            a = new C0294a();
        }

        public C0294a() {
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
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public final RevPkResult a() {
        if (Intrinsics.areEqual(this, d.a) == false) goto L6;
        return RevPkResult.UNFINISHED;
    L6:
        if (Intrinsics.areEqual(this, b.a) == false) goto L9;
        return RevPkResult.LEFT_WON;
    L9:
        if (Intrinsics.areEqual(this, c.a) == false) goto L12;
        return RevPkResult.RIGHT_WON;
    L12:
        if (Intrinsics.areEqual(this, C0294a.a) == false) goto L16;
        return RevPkResult.EVEN;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public a() {
    }
}
