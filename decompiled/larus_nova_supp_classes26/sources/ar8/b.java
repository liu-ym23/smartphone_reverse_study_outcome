package ar8;

import androidx.fragment.app.Fragment;
import com.larus.trace.tracknode.TraceFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final Long b(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get("action_bar_template_id");
    L7:
        if ((r3 instanceof Long) == true) goto L9;
        return null;
    L9:
        return (Long) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final String c(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get("enter_method");
    L7:
        if ((r3 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final Integer d(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get("position");
    L7:
        if ((r3 instanceof Integer) == true) goto L9;
        return null;
    L9:
        return (Integer) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final String e(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.get("previous_page");
    L7:
        if ((r3 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final HashMap<String, Object> a(Map<String, ? extends Object> r3, Fragment r4) {
        HashMap<String, Object> r0 = new HashMap();
        if (r3 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r5 = r3.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r1 = r5.next();
        r0.put(r1.getKey(), r1.getValue());
    L8:
        String r2 = null;
        if ((r4 instanceof TraceFragment) == false) goto L11;
        TraceFragment r6 = (TraceFragment) r4;
    L12:
        if (r6 == null) goto L14;
        r2 = r6.k();
    L14:
        r0.put("previous_page", r2);
        return r0;
    L11:
        r6 = null;
        goto L12
    }
}
