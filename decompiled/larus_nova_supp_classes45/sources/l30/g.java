package l30;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r1, String r2, String r3) {
        HashMap r4 = (HashMap) r1;
        if (r4.containsKey(r2) == true) goto L5;
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r4.put(r2, r3);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) r4.get(r2)) == true) goto L6;
    }
}
