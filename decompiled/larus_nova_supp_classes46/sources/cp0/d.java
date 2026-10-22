package cp0;

import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static a a;
    public static b b;
    public static final d c = null;

    public static final class a {
        public final String a;
        public final int b;
        public final int c;

        public a(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "appId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public IOpenPlatformAnchorService.a a;
        public IOpenPlatformAnchorService.a b;
        public final String c;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            this.c = r2;
        }
    }

    public d() {
    }

    static {
        c = new d();
    }

    @JvmStatic
    public static final synchronized boolean a() {
        monitor-enter(d.class);
        if (b == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(d.class);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
