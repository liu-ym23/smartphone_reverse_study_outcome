package c60;

import a60.c;
import a60.d;
import b60.b;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Map<String, c> a;
    public final Random b;

    /* JADX INFO: renamed from: c60.a$a, reason: collision with other inner class name */
    public static final class C0005a {
    }

    static {
    }

    public a() {
        this.a = new ConcurrentHashMap();
        this.b = RandomKt.Random(System.currentTimeMillis());
    }

    public static String c(e r2) {
        return "productId=" + r2.e + " businessType=" + r2.b + " eventType=" + r2.a + " traceId=" + r2.c + " step=" + r2.f + " logId=" + r2.d;
    }

    public final boolean b(d r13, b r14) {
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r14, "context");
        e r15 = r13.a;
        String r0 = r15.e;
        if (r0 != null) goto L5;
        r0 = "null";
    L5:
        String r1 = r0 + '-' + r15.b;
        String r3 = r1 + '-' + r15.a;
        if (r15.f != null) goto L8;
        String[] r2 = {r3, r1, r0};
    L9:
        List<c> r16 = r14.getConfig().g();
        if (r16 != null) goto L12;
        r16 = CollectionsKt.emptyList();
    L12:
        Iterator<c> r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L21;
        c r4 = r17.next();
        int r5 = r2.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L14;
        if (a(r4, r15, r2[r6]) == false) goto L19;
        r6 = r6 + 1;
        goto L16
    L19:
        return false;
    L21:
        int r18 = r2.length;
        int r7 = 0;
    L22:
        if (r7 >= r18) goto L35;
        String r8 = r2[r7];
        c r9 = (c) ((ConcurrentHashMap) this.a).get(r8);
        c r11 = null;
        if (r9 != null) goto L27;
    L30:
        if (r11 == null) goto L34;
        if (a(r11, r15, r8) == true) goto L34;
        return false;
    L34:
        r7 = r7 + 1;
        goto L22
    L27:
        if (System.currentTimeMillis() < r9.a) goto L29;
        r9 = null;
    L29:
        r11 = r9;
        goto L30
    L35:
        return true;
    L8:
        r2 = new String[]{r3, r1, r3 + '-' + r15.f, r0};
        goto L9
    }

    public final boolean a(c r7, e r8, String r9) {
        if (Intrinsics.areEqual(r9, r7.a()) == true) goto L5;
    L12:
        return true;
    L5:
        if (r7.b() > 0) goto L9;
        ALogger.i("FuseEventFilter", "filter " + c(r8) + " with key " + r7.a());
        return false;
    L9:
        if ((this.b.nextInt(100) + 1) <= r7.b()) goto L12;
        ALogger.i("FuseEventFilter", "filter " + c(r8) + " with key " + r7.a() + " and rate " + r7.b());
        return false;
    }
}
