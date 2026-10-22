package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CellFormatCondition {
    private static final Map<String, Integer> TESTS = null;

    static {
        HashMap r0 = new HashMap();
        TESTS = r0;
        r0.put("<", 0);
        r0.put("<=", 1);
        r0.put(">", 2);
        r0.put(">=", 3);
        r0.put("=", 4);
        r0.put("==", 4);
        r0.put("!=", 5);
        r0.put("<>", 5);
    }

    public CellFormatCondition() {
    }

    public static CellFormatCondition getInstance(String r3, String r4) {
        Map<String, Integer> r0 = TESTS;
        if (r0.containsKey(r3) == false) goto L31;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
        final double r2 = Double.parseDouble(r4);
        if (r1 == 0) goto L29;
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L23;
        if (r1 == 4) goto L21;
        if (r1 != 5) goto L19;
        return new AnonymousClass6(r2);
    L19:
        throw new IllegalArgumentException("Cannot create for test number " + r1 + "(\"" + r3 + "\")");
    L21:
        return new AnonymousClass5(r2);
    L23:
        return new AnonymousClass4(r2);
    L25:
        return new AnonymousClass3(r2);
    L27:
        return new AnonymousClass2(r2);
    L29:
        return new AnonymousClass1(r2);
    L31:
        throw new IllegalArgumentException("Unknown test: " + r3);
    }

    public abstract boolean pass(double r1);
}
