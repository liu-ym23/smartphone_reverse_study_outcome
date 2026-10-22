package m0c;

import com.ss.android.lark.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LogLevel.values().length];
            r0[LogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[LogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[LogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[LogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final void b(com.ss.android.lark.log.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter("n_action_cm_global_manager_impl", "tag");
        r2.i("n_action_cm_global_manager_impl", r3);
    }

    public static void a(com.ss.android.lark.log.c r2, String r3, String r4) {
        LogLevel r0 = LogLevel.INFO;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r0, "level");
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        r2.d(r3, r4);
        return;
    L5:
        if (r1 != 2) goto L7;
        r2.i(r3, r4);
        return;
    L7:
        if (r1 != 3) goto L9;
        r2.w(r3, r4);
        return;
    L9:
        if (r1 == 4) goto L11;
        r2.v(r3, r4);
        return;
    L11:
        r2.e(r3, r4);
    }
}
