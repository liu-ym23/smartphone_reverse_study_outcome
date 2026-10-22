package z70;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("ttlive_template_logger", r1);
    }
}
