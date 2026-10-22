package bwb;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static String c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        return r2.getClass().getSimpleName() + '@' + Integer.toString(System.identityHashCode(r2), CharsKt.checkRadix(36));
    }

    public static String e(String r2, String r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        String r5 = "[" + r2 + ']';
    L13:
        if (StringsKt.isBlank(r3) == false) goto L16;
        return r5;
    L16:
        return r5 + ' ' + r3;
    L11:
        r5 = r4 + " [" + r2 + ']';
        goto L13
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L9
    }

    public static void a(MmUiLogScene r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        Intrinsics.checkNotNullParameter(r3, "message");
        lvb.a.a(r1.getTag(), e(r2, r3, r4));
    }

    public static void d(MmUiLogScene r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        Intrinsics.checkNotNullParameter(r3, "message");
        lvb.a.b(r1.getTag(), e(r2, r3, r4));
    }

    public static void f(MmUiLogScene r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        Intrinsics.checkNotNullParameter(r3, "message");
        lvb.a.e(r1.getTag(), e(r2, r3, r4));
    }

    public static void h(MmUiLogScene r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r2, "functionName");
        Intrinsics.checkNotNullParameter(r3, "message");
        lvb.a.h(r1.getTag(), e(r2, r3, r4));
    }

    public static /* synthetic */ void b(MmUiLogScene r1, String r2, String r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        a(r1, r2, r3, r4);
    }

    public static /* synthetic */ void g(MmUiLogScene r1, String r2, String r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        f(r1, r2, r3, r4);
    }
}
