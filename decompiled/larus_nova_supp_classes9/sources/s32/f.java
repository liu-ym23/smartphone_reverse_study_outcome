package s32;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.e("ImageRecognition", r1);
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("ImageRecognition", r1);
    }
}
