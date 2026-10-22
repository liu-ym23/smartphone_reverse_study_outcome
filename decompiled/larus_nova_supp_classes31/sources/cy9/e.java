package cy9;

import android.os.Bundle;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static UserCreation a;
    public static long b;
    public static String c;

    static {
    }

    public static void a(Bundle r3) {
        if (r3 == null) goto L6;
        UserCreation r1 = (UserCreation) r3.getParcelable("ai_creation_applet_pending_user_creation");
        if (r1 == null) goto L6;
    L8:
        if (r1 == null) goto L10;
        String r2 = r1.a;
    L11:
        c = r2;
        if (r3 == null) goto L14;
        r3.remove("ai_creation_applet_pending_user_creation");
    L14:
        a = null;
        b = 0;
        return;
    L10:
        r2 = null;
    L6:
        r1 = a;
        goto L8
    }

    public static UserCreation b(Bundle r6) {
        if (a != null) goto L5;
    L7:
        if (r6 == null) goto L11;
        UserCreation r7 = (UserCreation) r6.getParcelable("ai_creation_applet_pending_user_creation");
        if (r7 == null) goto L11;
        return r7;
    L11:
        UserCreation r8 = a;
        if (r8 == null) goto L27;
        String r0 = r8.a;
        if (r0 != null) goto L17;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == true) goto L26;
        if (Intrinsics.areEqual(r0, c) == false) goto L26;
        return null;
    L26:
        return r8;
    L17:
        if (r0.length() == 0) goto L20;
        r2 = false;
        goto L21
    L27:
        return null;
    L5:
        if ((System.currentTimeMillis() - b) <= 1800000) goto L7;
        a = null;
        b = 0;
        goto L7
    }
}
