package w72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.m;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static boolean a;
    public static final b b = null;
    public static final b c = null;

    static {
        b = new b(true, 62);
        c = new b(false, 62);
    }

    public static void a(List r7, b r8) {
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L35;
        m r0 = (m) r9.next();
        if (r0.b() == null) goto L4;
        if (r0.d() == null) goto L13;
        if (r0.d().longValue() <= 0) goto L13;
        r8.b.put(r0.b(), r0.d());
    L13:
        if (r0.c() == null) goto L18;
        if (r0.c().longValue() <= 0) goto L18;
        r8.c.put(r0.b(), r0.c());
    L18:
        if (r0.a() == null) goto L21;
        r8.d.put(r0.b(), r0.a());
    L21:
        if (r0.e() == null) goto L4;
        Iterator<n> r1 = r0.e().iterator();
    L24:
        if (r1.hasNext() == false) goto L4;
        n r2 = r1.next();
        if (r2.b() == null) goto L24;
        if (r2.c() == null) goto L33;
        if (r2.c().longValue() <= 0) goto L33;
        r8.e.put(r2.b(), r2.c());
    L33:
        if (r2.a() == null) goto L24;
        r8.f.put(r2.b(), r2.a());
        goto L24
    }
}
