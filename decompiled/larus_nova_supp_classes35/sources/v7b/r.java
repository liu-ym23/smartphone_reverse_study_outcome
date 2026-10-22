package v7b;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r {
    static {
    }

    public static String a(s r3, boolean r4) {
        StringBuilder r0 = new StringBuilder();
        if (r3 == null) goto L6;
        b(r3, BuildConfig.FLAVOR, true, r0, r4);
    L6:
        return r0.toString();
    }

    public static void b(s r2, String r3, boolean r4, StringBuilder r5, boolean r6) {
        StringBuilder r0 = new StringBuilder("\n");
        r0.append(r3);
        if (r4 == false) goto L5;
        String r1 = "└── ";
    L6:
        r0.append(r1);
        if (r6 == false) goto L9;
        String r7 = r2.toString();
        Intrinsics.checkNotNull(r7);
    L10:
        r0.append(r7);
        r5.append(r0.toString());
        s r8 = r2.e;
    L11:
        if (r8 == null) goto L21;
        StringBuilder r9 = new StringBuilder();
        r9.append(r3);
        if (r4 == false) goto L15;
        String r10 = "    ";
    L16:
        r9.append(r10);
        String r11 = r9.toString();
        if (r8.h != null) goto L19;
        boolean r12 = true;
    L20:
        b(r8, r11, r12, r5, r6);
        r8 = r8.h;
        goto L11
    L19:
        r12 = false;
        goto L20
    L15:
        r10 = "│   ";
        goto L16
    L21:
        return;
    L9:
        r7 = r2.getClass().getSimpleName();
        Intrinsics.checkNotNull(r7);
        goto L10
    L5:
        r1 = "├── ";
        goto L6
    }
}
