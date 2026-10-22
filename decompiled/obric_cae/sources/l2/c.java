package l2;

import android.content.SharedPreferences;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class c implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9129a = -1;

    public static SharedPreferences a() {
        if (f9129a != (-1)) goto L8;
        throw null;     // Catch: Exception -> L6
    L6:
        f9129a = -1;
    L8:
        if (f9129a != Process.myPid()) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L13;
        throw null;
    L13:
        throw null;
    L10:
        r8 = false;
        goto L11
    }
}
