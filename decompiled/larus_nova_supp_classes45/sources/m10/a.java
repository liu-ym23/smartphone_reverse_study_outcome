package m10;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "subTag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("LiveCloudGame", r1 + " -> " + r2);
    }
}
