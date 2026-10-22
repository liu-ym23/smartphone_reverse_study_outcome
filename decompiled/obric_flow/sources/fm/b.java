package fm;

import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyMap f16925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaOnlyMap f16926b;

    public b(ReadableMap r5, ReadableMap r10, HashMap r11, String r12) {
        if (r5 != null) goto L5;
        HashMap<String, Object> r13 = new HashMap();
    L6:
        if (r10 != null) goto L8;
        HashMap<String, Object> r14 = new HashMap();
    L9:
        Iterator r15 = r11.entrySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L23;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        Object r18 = r16.getValue();
        if (r18 == null) goto L11;
        if ((r18 instanceof Number) == true) goto L17;
        if ((r18 instanceof String) == true) goto L22;
        if ((r18 instanceof Boolean) == false) goto L11;
    L22:
        r14.put(r17, r18);
        goto L11
    L17:
        r13.put(r17, r18);
        goto L11
    L23:
        r14.put("default", r12);
        this.f16925a = new JavaOnlyMap(r13);
        this.f16926b = new JavaOnlyMap(r14);
        return;
    L8:
        r14 = r10.asHashMap();
        goto L9
    L5:
        r13 = r5.asHashMap();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PerfMetrics{");
        JavaOnlyMap r10 = this.f16925a;
        r10.getClass();
        Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, Object> r12 = r11.next();
        if (r12.getValue() == null) goto L4;
        r5.append(r12.getKey());
        r5.append("=");
        r5.append(r12.getValue());
        r5.append(",");
        goto L4
    L8:
        JavaOnlyMap r13 = this.f16926b;
        r13.getClass();
        Iterator<Map.Entry<String, Object>> r14 = r13.entrySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, Object> r15 = r14.next();
        if (r15.getValue() == null) goto L10;
        r5.append(r15.getKey());
        r5.append("=");
        r5.append(r15.getValue());
        r5.append(",");
        goto L10
    L14:
        r5.append("}");
        return r5.toString();
    }
}
