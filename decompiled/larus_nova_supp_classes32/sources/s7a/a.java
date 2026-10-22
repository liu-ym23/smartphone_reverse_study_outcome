package s7a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final int a;
    public final int b;
    public final List<String> c;
    public final Map<String, List<Integer>> d;
    public final ReadableMap e;

    public static Map<Integer, a> a(ReadableArray r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        int r2 = 0;
    L7:
        if (r2 >= r14.size()) goto L38;
        ReadableMap r3 = r14.getMap(r2);
        int r4 = r3.getInt("id");
        int r7 = r3.getInt("type");
        ReadableArray r5 = r3.getArray("callbackNames");
        ArrayList r8 = new ArrayList();
        if (r5 == null) goto L14;
        int r6 = 0;
    L12:
        if (r6 >= r5.size()) goto L14;
        r8.add(r5.getString(r6));
        r6 = r6 + 1;
    L14:
        HashMap r9 = new HashMap();
        ReadableMap r10 = r3.getMap("relationMap");
        if (r10 == null) goto L37;
        ReadableArray r11 = r10.getArray("simultaneous");
        if (r11 == null) goto L23;
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L20:
        if (r13 >= r11.size()) goto L22;
        r12.add(Integer.valueOf(r11.getInt(r13)));
        r13 = r13 + 1;
        goto L20
    L22:
        r9.put("simultaneous", r12);
    L23:
        ReadableArray r15 = r10.getArray("waitFor");
        if (r15 == null) goto L30;
        ArrayList r16 = new ArrayList();
        int r17 = 0;
    L27:
        if (r17 >= r15.size()) goto L29;
        r16.add(Integer.valueOf(r15.getInt(r17)));
        r17 = r17 + 1;
        goto L27
    L29:
        r9.put("waitFor", r16);
    L30:
        ReadableArray r18 = r10.getArray("continueWith");
        if (r18 == null) goto L37;
        ArrayList r19 = new ArrayList();
        int r110 = 0;
    L34:
        if (r110 >= r18.size()) goto L36;
        r19.add(Integer.valueOf(r18.getInt(r110)));
        r110 = r110 + 1;
        goto L34
    L36:
        r9.put("continueWith", r19);
    L37:
        a r20 = new a(r4, r7, r8, r9, r3.getMap("configMap"));
        r0.put(Integer.valueOf(r4), r20);
        r2 = r2 + 1;
        goto L7
    L38:
        return r0;
    }

    public a(int r1, int r2, List<String> r3, Map<String, List<Integer>> r4, ReadableMap r5) {
        this.a = r1;
        this.b = r2;
        this.c = new ArrayList(r3);
        this.d = new HashMap(r4);
        this.e = r5;
    }
}
