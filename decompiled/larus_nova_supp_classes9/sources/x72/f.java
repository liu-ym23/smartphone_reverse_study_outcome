package x72;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements o0.b {
    public final /* synthetic */ b.a a;
    public final /* synthetic */ k32.a b;
    public final /* synthetic */ h c;

    public final void a() {
        ALogger.e("TextParseInterceptor", "download image failed");
        h.b(this.c, this.a, this.b);
    }

    public final void b() {
        ALogger.e("TextParseInterceptor", "download image timeout");
        h.b(this.c, this.a, this.b);
    }

    public final void c() {
        ALogger.d("TextParseInterceptor", "download image success");
        h.b(this.c, this.a, this.b);
    }

    public f(h r1, a r2, k32.a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
