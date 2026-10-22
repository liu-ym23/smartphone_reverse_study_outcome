package x21;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b {
    public final String a;

    public static final class a extends b {
        public a() {
            super("ShowLink");
        }
    }

    /* JADX INFO: renamed from: x21.b$b, reason: collision with other inner class name */
    public static final class C0343b extends b {
        public final c3 b;

        public C0343b(c3 r2) {
            Intrinsics.checkNotNullParameter(r2, "meta");
            super("ShowPenal");
            this.b = r2;
        }
    }

    public static final class c extends b {
        public final c5 b;
        public final c3 c;

        public c() {
            this(null, null, 3);
        }

        public c(c5 r3, c3 r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            super("ShowPk");
            this.b = r3;
            this.c = r4;
        }
    }

    public b(String r1) {
        this.a = r1;
    }
}
