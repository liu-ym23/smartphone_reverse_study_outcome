package mx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b extends a {
    public View.OnClickListener l;

    public b(String r9, String r11) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r11, "description");
        super(r9, r11, false, false, false, null, 240);
    }
}
