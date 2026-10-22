package o32;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveHighlight", r3);
    }

    @JvmStatic
    public static final void b(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("LiveHighlight", r3, r4);
    }
}
