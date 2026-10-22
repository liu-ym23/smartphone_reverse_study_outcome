package ud0;

import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d {

    public static final class a extends d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {
        public final sd0.d a;

        public b(sd0.d r2) {
            Intrinsics.checkNotNullParameter(r2, "tabRequestResponse");
            this.a = r2;
        }
    }

    public static final class c extends d {
        public final Throwable a;

        public c(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: ud0.d$d, reason: collision with other inner class name */
    public static final class C0277d extends d {
        public final t5 a;

        public C0277d(t5 r2) {
            Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
            this.a = r2;
        }
    }

    public static final class e extends d {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends d {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public static final class g extends d {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }

    public d() {
    }
}
