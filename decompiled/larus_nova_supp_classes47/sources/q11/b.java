package q11;

import com.bytedance.android.live.link.data.RevPkState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {
    public final String a;

    public static final class a extends b {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("DISABLE");
        }
    }

    /* JADX INFO: renamed from: q11.b$b, reason: collision with other inner class name */
    public static final class C0295b extends b {
        public static final C0295b b = null;

        static {
            b = new C0295b();
        }

        public C0295b() {
            super("FINISHED");
        }
    }

    public static final class c extends b {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("PENAL");
        }
    }

    public static final class d extends b {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("PK");
        }
    }

    public final RevPkState a() {
        if (Intrinsics.areEqual(this, a.b) == false) goto L6;
        return RevPkState.DISABLE;
    L6:
        if (Intrinsics.areEqual(this, d.b) == false) goto L9;
        return RevPkState.PK;
    L9:
        if (Intrinsics.areEqual(this, c.b) == false) goto L12;
        return RevPkState.PENAL;
    L12:
        if (Intrinsics.areEqual(this, C0295b.b) == false) goto L16;
        return RevPkState.FINISHED;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final String toString() {
        return this.a;
    }

    public b(String r1) {
        this.a = r1;
    }
}
