package j4a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Activity getActivity(WeakReference<Context> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Context r4 = r3.get();
    L6:
        if (r4 == null) goto L14;
        if ((r4 instanceof Activity) == true) goto L10;
        if ((r4 instanceof ContextWrapper) == false) goto L14;
        r4 = ((ContextWrapper) r4).getBaseContext();
        goto L6
    L10:
        return (Activity) r4;
    L14:
        return null;
    }

    public final Activity getActivity(Context r3) {
    L3:
        if (r3 == null) goto L11;
        if ((r3 instanceof Activity) == true) goto L7;
        if ((r3 instanceof ContextWrapper) == false) goto L11;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L3
    L7:
        return (Activity) r3;
    L11:
        return null;
    }
}
