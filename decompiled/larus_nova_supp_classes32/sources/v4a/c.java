package v4a;

import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.xelement.webview.LynxUIWebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final JavaOnlyMap a;
    public final JavaOnlyMap b;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("PerfMetrics{");
        Iterator<Map.Entry<String, Object>> r1 = this.a.asHashMap().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, Object> r2 = r1.next();
        if (r2.getValue() == null) goto L4;
        r0.append(r2.getKey());
        r0.append("=");
        r0.append(r2.getValue());
        r0.append(",");
        goto L4
    L8:
        Iterator<Map.Entry<String, Object>> r3 = this.b.asHashMap().entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Map.Entry<String, Object> r4 = r3.next();
        if (r4.getValue() == null) goto L10;
        r0.append(r4.getKey());
        r0.append("=");
        r0.append(r4.getValue());
        r0.append(",");
        goto L10
    L14:
        r0.append("}");
        return r0.toString();
    }

    public c(ReadableMap r4, ReadableMap r5, Map<String, Object> r6, String r7) {
        if (r4 != null) goto L5;
        HashMap<String, Object> r8 = new HashMap();
    L6:
        if (r5 != null) goto L8;
        HashMap<String, Object> r9 = new HashMap();
    L9:
        Iterator<Map.Entry<String, Object>> r10 = r6.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L23;
        Map.Entry<String, Object> r0 = r10.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        if (r2 == null) goto L11;
        if ((r2 instanceof Number) == true) goto L17;
        if ((r2 instanceof String) == true) goto L22;
        if ((r2 instanceof Boolean) == false) goto L11;
    L22:
        r9.put(r1, r2);
        goto L11
    L17:
        r8.put(r1, r2);
        goto L11
    L23:
        if (r7 == null) goto L25;
        r9.put(LynxUIWebView.DEFAULT, r7);
    L25:
        this.a = JavaOnlyMap.from(r8);
        this.b = JavaOnlyMap.from(r9);
        return;
    L8:
        r9 = r5.asHashMap();
        goto L9
    L5:
        r8 = r4.asHashMap();
        goto L6
    }
}
