package bc2;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (v.a() == false) goto L6;
        b0.o().getClass();
        g.i("LiveMessageTracer", r3);
        return;
    }

    @JvmStatic
    public static final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        b0.o().getClass();
        g.i("LiveMessageTracer", r3);
    }

    @JvmStatic
    public static final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        b("fetch message failed with http, reason: " + r2);
    }

    @JvmStatic
    public static final void f(f r3) {
        Intrinsics.checkNotNullParameter(r3, "payloadItem");
        b("host ws packet received, payload type is " + r3.c + ", logId: " + r3.g);
    }

    @JvmStatic
    public static final void c(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        b("decode message: " + r2 + ", method: " + r4 + " but base message is null");
    }

    @JvmStatic
    public static final void d(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        b("try decode message: " + r2 + ", method: " + r4 + " but payload is null");
    }
}
