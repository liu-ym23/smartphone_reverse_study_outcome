package mx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class h extends a {
    public View.OnClickListener l;

    public h(String r9, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r11, "description");
        super(r9, r11, false, r12, false, null, 240);
    }
}
