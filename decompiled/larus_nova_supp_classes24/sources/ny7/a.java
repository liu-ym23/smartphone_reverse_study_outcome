package ny7;

import android.text.Layout;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean a(UDButton r3) {
        if (r3.getVisibility() == 8) goto L16;
        Layout r4 = r3.getLayout();
        if (r4 == null) goto L13;
        int r0 = r4.getLineCount();
        if (r0 > 0) goto L10;
        return false;
    L10:
        if (r4.getEllipsisCount(r0 - 1) <= 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L16:
        return false;
    }
}
