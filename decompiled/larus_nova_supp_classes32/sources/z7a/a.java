package z7a;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;

    public a() {
    }

    public static int a(HashMap r0, String r1, int r2) {
        if (r0 != null) goto L4;
        return r2;
    L4:
        Object r3 = r0.get(r1);
        if (r3 != null) goto L8;
        return r2;
    L8:
        if ((r3 instanceof String) == false) goto L13;
        return CastIntegerProtector.parseInt(((String) r3).trim());
    L21:
        return r2;
    L13:
        if ((r3 instanceof Number) == true) goto L15;
        return r2;
    L15:
        return ((Number) r3).intValue();
    }
}
