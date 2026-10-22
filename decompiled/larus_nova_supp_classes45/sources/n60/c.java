package n60;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements d {
    public c() {
    }

    @Override // n60.d
    public final boolean a(Context r1, String r2) {
        if (PermissionChecker.checkSelfPermission(r1, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
