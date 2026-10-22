package u2;

import com.bytedance.ai.applet.granting.GrantStatus;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GrantStatus.values().length];
            r0[GrantStatus.PENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GrantStatus.GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GrantStatus.DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GrantStatus.REVOKED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final int a(GrantStatus r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = a.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 != 3) goto L9;
        return 2;
    L9:
        if (r11 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
