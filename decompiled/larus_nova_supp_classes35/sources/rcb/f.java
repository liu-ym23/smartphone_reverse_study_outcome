package rcb;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import com.ss.android.lark.utils.i0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static Configuration a;

    static {
    }

    public static boolean b() {
        Configuration r0 = a;
        if (r0 == null) goto L18;
        String r1 = r0.toString();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r1, "mWindowingMode=freeform", false, 2, null) == false) goto L9;
    L16:
        return true;
    L9:
        if (StringsKt.contains$default(r1, "mWindowingMode=hwMultiwindow-freeform", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r1, "mWindowingMode=100", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r1, "mScenario= 2", false, 2, null) == true) goto L15;
        return false;
    L15:
        if (com.ss.android.lark.base.embedded.b.e() == true) goto L16;
        return false;
    L18:
        return false;
    }

    public static boolean a(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (Build.VERSION.SDK_INT < 24) goto L21;
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (r5.isInMultiWindowMode() == true) goto L7;
    L8:
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (i0.b() == true) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L18;
    L17:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        return true;
    L18:
        r7 = false;
        goto L19
    L11:
        if (r5.isInMultiWindowMode() == false) goto L15;
        if (i0.a(r5) == true) goto L15;
        r6 = true;
        goto L16
    L7:
        if (i0.b() == false) goto L17;
    L21:
        if (com.ss.android.lark.base.embedded.b.e() == true) goto L23;
    L25:
        return false;
    L23:
        if (b() == false) goto L25;
        return true;
    }
}
