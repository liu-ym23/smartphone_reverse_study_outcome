package ln0;

import android.content.Context;
import androidx.core.util.Preconditions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final String b;
    public final pn0.b c;
    public final nn0.b d;
    public final nn0.a e;

    public static final class a {
        public static final /* synthetic */ int g = 0;
        public String a;
        public String b;
        public pn0.b c;
        public nn0.b d;
        public nn0.a e;
        public final Context f;

        /* JADX INFO: renamed from: ln0.b$a$a, reason: collision with other inner class name */
        public static final class C0235a {
        }

        static {
        }

        public final Context getContext() {
            return this.f;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.f = r2;
        }
    }

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Context r0 = (Context) Preconditions.checkNotNull(r2.getContext());
        this.a = (String) Preconditions.checkNotNull(r2.b);
        this.b = (String) Preconditions.checkNotNull(r2.a);
        this.c = (pn0.b) Preconditions.checkNotNull(r2.c);
        this.d = (nn0.b) Preconditions.checkNotNull(r2.d);
        this.e = (nn0.a) Preconditions.checkNotNull(r2.e);
    }
}
