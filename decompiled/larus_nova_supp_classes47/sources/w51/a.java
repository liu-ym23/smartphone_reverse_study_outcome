package w51;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: w51.a$a, reason: collision with other inner class name */
    public static final class C0337a {
        public static void a(String r2) {
            Intrinsics.checkNotNullParameter("VipRepository", "tag");
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
            ALogger.d("VipRepository", r2);
        }

        public static void b(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "tag");
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
            ALogger.e(r1, r2);
        }
    }

    static {
    }
}
