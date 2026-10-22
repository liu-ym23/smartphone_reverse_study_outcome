package m8a;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static volatile i b;
    public final Map<String, Integer> a;

    public i() {
        this.a = new HashMap();
    }

    public final int a(Context r3, String r4) {
        if (r4 != null) goto L4;
        return 0;
    L4:
        if (r4.isEmpty() == true) goto L26;
        String r5 = r4.toLowerCase().replace("-", "_");
        return CastIntegerProtector.parseInt(r5);
    L9:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (((HashMap) this.a).containsKey(r5) == true) goto L14;
        int r6 = r3.getResources().getIdentifier(r5, "drawable", r3.getPackageName());     // Catch: Throwable -> L18
        Map<String, Integer> r0 = this.a;     // Catch: Throwable -> L18
        HashMap r1 = (HashMap) r0;     // Catch: Throwable -> L18
        r1.put(r5, Integer.valueOf(r6));     // Catch: Throwable -> L18
        return r6;
    L14:
        return ((Integer) ((HashMap) this.a).get(r5)).intValue();
    L26:
        return 0;
    }
}
