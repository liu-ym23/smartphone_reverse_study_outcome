package t2;

import android.content.Context;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final String a(Context r1) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L7;
        boolean r10 = r0.v(r1);
        boolean r11 = true;
        if (r10 != true) goto L7;
    L8:
        if (r11 == false) goto L10;
        return "dark";
    L10:
        return "light";
    L7:
        r11 = false;
        goto L8
    }

    public static final boolean b(Context r1) {
        if (r1 == null) goto L8;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L6;
        Boolean r10 = Boolean.valueOf(r0.o(r1));
    L10:
        return Intrinsics.areEqual(r10, Boolean.TRUE);
    L6:
        r10 = null;
        goto L10
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final int c(Context r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        TypedValue r0 = new TypedValue();     // Catch: Exception -> L11
        if (r10.getTheme().resolveAttribute(r11, r0, true) == false) goto L9;
        int r13 = r0.resourceId;     // Catch: Exception -> L11
        if (r13 == 0) goto L8;
        r10 = ContextCompat.getColor(r10, r13);     // Catch: Exception -> L11
    L13:
        return r10;
    L8:
        r10 = r0.data;     // Catch: Exception -> L11
        goto L13
    L9:
        r10 = ContextCompat.getColor(r10, r12);     // Catch: Exception -> L11
    L16:
        return ContextCompat.getColor(r10, r12);
    }
}
