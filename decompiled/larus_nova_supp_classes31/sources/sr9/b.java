package sr9;

import com.larus.platform.spi.IAIChatService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements d {
    public static final b b = null;
    public final /* synthetic */ d a;

    public static final class a implements d {
        public a() {
        }

        @Override // sr9.d
        public final String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return "";
        }

        @Override // sr9.d
        public final Pair<Integer, Integer> b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return null;
        }

        @Override // sr9.d
        public final String c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return "";
        }

        @Override // sr9.d
        public final void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "uri");
            Intrinsics.checkNotNullParameter("upload", "contentSource");
        }

        @Override // sr9.d
        public final void e(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "uri");
            Intrinsics.checkNotNullParameter("album", "previousPage");
        }

        @Override // sr9.d
        public final String f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return "";
        }

        @Override // sr9.d
        public final boolean g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return false;
        }

        @Override // sr9.d
        public final String h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return "";
        }
    }

    static {
        b = new b();
    }

    @Override // sr9.d
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.a(r2);
    }

    @Override // sr9.d
    public final Pair<Integer, Integer> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.b(r2);
    }

    @Override // sr9.d
    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.c(r2);
    }

    @Override // sr9.d
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter("upload", "contentSource");
        this.a.d(r2, "upload");
    }

    @Override // sr9.d
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter("album", "previousPage");
        this.a.e(r2, "album");
    }

    @Override // sr9.d
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.f(r2);
    }

    @Override // sr9.d
    public final boolean g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.g(r2);
    }

    @Override // sr9.d
    public final String h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return this.a.h(r2);
    }

    public b() {
        IAIChatService r0 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r0 == null) goto L6;
        d r1 = r0.v7();
        if (r1 == null) goto L6;
    L7:
        this.a = r1;
        return;
    L6:
        r1 = new a();
        goto L7
    }
}
