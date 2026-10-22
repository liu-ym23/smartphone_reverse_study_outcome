package uzb;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static void a(Activity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        View r0 = r2.findViewById(R.id.content);
        if (r0 == null) goto L10;
        InputMethodManager r3 = (InputMethodManager) r2.getSystemService("input_method");
        if (r3.isActive() == false) goto L11;
        r3.hideSoftInputFromWindow(r0.getWindowToken(), 0);
        return;
    L11:
        return;
    }

    public static void b(Context r0) {
        Activity r1 = ViewUtils.getActivityByContext(r0);
        if (r1 != null) goto L5;
        return;
    L5:
        a(Contexts.requireActivity(r1));
    }

    public static boolean c(Context r2) {
        Activity r3 = ViewUtils.getActivityByContext(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        return d.b.b(r3);
    L11:
        return e.a.b(r3);
    }
}
