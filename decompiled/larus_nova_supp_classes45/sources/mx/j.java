package mx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class j extends a {
    public View.OnClickListener l;

    public j(String r9, String r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r11 = "";
    L5:
        String r2 = r11;
        if ((r13 & 8) == 0) goto L8;
        boolean r4 = false;
    L9:
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r2, "description");
        super(r9, r2, false, r4, false, null, 240);
        return;
    L8:
        r4 = r12;
        goto L9
    }
}
