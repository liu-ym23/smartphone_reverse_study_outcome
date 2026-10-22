package v19;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a7 {
    static {
    }

    public static void a(Activity r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        if (Build.VERSION.SDK_INT < 35) goto L21;
        StringBuilder r1 = new StringBuilder("<");
        if (r5 == null) goto L7;
        String r2 = r5.getClass().getSimpleName();
    L8:
        r1.append(r2);
        r1.append('-');
        r1.append(r6);
        r1.append('>');
        String r7 = r1.toString();
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L16
        if (r5 == null) goto L14;
        Resources.Theme r8 = r5.getTheme();     // Catch: Exception -> L16
        if (r8 == null) goto L14;
        r8.applyStyle(2131954373, true);     // Catch: Exception -> L16
    L14:
        long r4 = System.currentTimeMillis() - r3;     // Catch: Exception -> L16
        FLogger.a.d("Target35Compat", r7 + ", applyStyle success, duration:" + r4 + "ms");     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        FLogger.a.e("Target35Compat", r7 + ", applyStyle error:" + e.getMessage());
        return;
    L7:
        r2 = null;
        goto L8
    }
}
