package v72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final Map<Long, Long> a;
    public final Map<String, Integer> b;
    public final Map<String, d> c;
    public final Map<String, Integer> d;
    public final Map<String, d> e;
    public final w72.b f;

    public static final class a {
    }

    static {
    }

    public e(w72.b r1) {
        this.f = r1;
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    public static d a(o r8, d r9) {
        if (r8.a() != null) goto L5;
    L17:
        return null;
    L5:
        if (r8.b() == null) goto L17;
        if (r9 == null) goto L10;
        long r1 = System.currentTimeMillis();
        if ((r1 - r9.a) <= r8.b().longValue()) goto L15;
        return new d(r1, 1);
    L15:
        if (r9.b >= r8.a().longValue()) goto L17;
        return new d(r9.a, r9.b + 1);
    L10:
        return new d(System.currentTimeMillis(), 1);
    }

    public static boolean b(String r7, Map r8, Map r9) {
        Long r10 = (Long) r9.get(r7);
        HashMap r11 = (HashMap) r8;
        Integer r0 = (Integer) r11.get(r7);
        if (r10 == null) goto L12;
        int r2 = 0;
        if (r0 != null) goto L7;
    L9:
        if (r0 == null) goto L11;
        r2 = r0.intValue();
    L11:
        r11.put(r7, Integer.valueOf(r2 + 1));
        goto L12
    L7:
        if (r0.intValue() <= r10.longValue()) goto L9;
        return false;
    L12:
        return true;
    }
}
