package jg;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
    }

    public final Activity getActivity(View r10) {
        if (r10 == null) goto L5;
        Context r11 = r10.getContext();
    L6:
        if (r11 == null) goto L15;
        if ((r11 instanceof Activity) == true) goto L10;
        if ((r11 instanceof ContextWrapper) == false) goto L14;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L6
    L14:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r11);
        goto L15
    L10:
        return (Activity) r11;
    L15:
        return null;
    L5:
        r11 = null;
        goto L6
    }

    public final Activity getActivity(Context r10) {
    L3:
        if (r10 == null) goto L12;
        if ((r10 instanceof Activity) == true) goto L7;
        if ((r10 instanceof ContextWrapper) == false) goto L11;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L11:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r10);
        goto L12
    L7:
        return (Activity) r10;
    L12:
        return null;
    }
}
