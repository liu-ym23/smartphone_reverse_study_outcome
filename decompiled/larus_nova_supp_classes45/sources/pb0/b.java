package pb0;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static a a;

    public b() {
    }

    static {
    }

    public static void b(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "throwable");
        a r0 = a;
        if (r0 == null) goto L6;
        r0.g(r1, r2);
        return;
    }

    public static void c(MusicPanel r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "fromRequestType");
        Intrinsics.checkNotNullParameter(r8, "enterFrom");
        a r0 = a;
        if (r0 == null) goto L6;
        r0.t(r6, r7, r8, null, r9);
        return;
    }

    public static void a(String r12, String r13, String r14, long r15, String r17, String r18, Integer r19, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r12, "liveType");
        Intrinsics.checkNotNullParameter(r13, "roomType");
        Intrinsics.checkNotNullParameter(r14, "buttonActionType");
        Intrinsics.checkNotNullParameter(r17, "userType");
        a r1 = a;
        if (r1 == null) goto L6;
        r1.v(r12, r13, r14, r15, r17, r18, r19, r21, r22);
        return;
    }
}
