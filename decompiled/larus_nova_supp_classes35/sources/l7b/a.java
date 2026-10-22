package l7b;

import android.app.Dialog;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Map<Integer, WeakReference<Dialog>> a = null;
    public static final Map<Integer, WeakReference<PopupWindow>> b = null;

    static {
        a = new HashMap(8);
        b = new HashMap(8);
    }

    public static void a(Dialog r3) {
        if (r3 == null) goto L12;
        Map<Integer, WeakReference<Dialog>> r0 = a;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r3.hashCode()), new WeakReference(r3));
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r2 = r1.entrySet().iterator();
    L5:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r2.next();
        if (((WeakReference) r5.getValue()).get() == null) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L5;
        r4.put(r5.getKey(), r5.getValue());
        goto L5
    L9:
        r6 = false;
        goto L10
    L18:
        return;
    }
}
