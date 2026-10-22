package f2a;

import com.larus.utils.logger.FLogger;
import com.larus.utils.logger.LogLevel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final h a;
    public final LogLevel b;
    public final g c;

    public static String g(String r15) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r15, "<", "", false, 4, null), ">", "", false, 4, null), "\"", "\\\"", false, 4, null);
    }

    public final void a(List r2) {
        this.c.b = r2;
    }

    public final void d(Map r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        g r0 = this.c;
        Map<f, Object> r1 = r0.g;
        if (r1 != null) goto L7;
        r0.g = new HashMap(r3);
        return;
    L7:
        Intrinsics.checkNotNull(r1);
        r1.putAll(r3);
    }

    public final void e(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        LinkedHashMap r0 = new LinkedHashMap();
        r2.invoke(r0);
        d(r0);
    }

    public final void f(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        LinkedHashMap r0 = new LinkedHashMap();
        r5.invoke(r0);
        ArrayList r6 = new ArrayList(r0.size());
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r6.add(TuplesKt.to(new f((String) r2.getKey()), r2.getValue()));
        goto L4
    L6:
        d(MapsKt.toMap(r6));
    }

    public c(h r2, LogLevel r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Intrinsics.checkNotNullParameter(r3, "level");
        Intrinsics.checkNotNullParameter(r4, "what");
        this.a = r2;
        this.b = r3;
        this.c = new g(r4);
    }

    public static /* synthetic */ void c(c r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r5 & 2) == 0) goto L9;
        r4 = "";
    L9:
        int r2 = 0;
        if ((r5 & 4) == 0) goto L12;
        int r1 = -1;
    L14:
        if ((r5 & 8) == 0) goto L16;
        r2 = 4;
    L16:
        r3.b(r0, r4, r1, r2);
        return;
    L12:
        r1 = 0;
        goto L14
    L5:
        r0 = null;
        goto L7
    }

    public final void b(String r26, String r27, int r28, int r29) {
        Intrinsics.checkNotNullParameter(r26, "file");
        Intrinsics.checkNotNullParameter(r27, "function");
        StackTraceElement[] r5 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r5.length < (r29 + 1)) goto L5;
        StackTraceElement r6 = r5[r29];
    L6:
        if (r6 == null) goto L11;
        String r7 = r6.getFileName();
        if (r7 == null) goto L11;
        String r9 = r7;
    L12:
        if (r6 == null) goto L15;
        String r2 = r6.getMethodName();
        if (r2 == null) goto L15;
    L16:
        if (r6 == null) goto L18;
        int r4 = r6.getLineNumber();
    L19:
        g r8 = this.c;
        ArrayList r10 = new ArrayList();
        r10.add("<What=" + g(r8.a) + '>');
        Map<f, Object> r11 = r8.g;
        if (r11 != null) goto L22;
    L38:
        String r12 = r8.e;
        if (r12 == null) goto L41;
        r10.add("<Who=" + g(r12) + '>');
    L41:
        String r13 = r8.d;
        if (r13 == null) goto L44;
        r10.add("<Where=" + g(r13) + '>');
    L44:
        String r14 = r8.c;
        if (r14 == null) goto L47;
        r10.add("<EventType=" + g(r14) + '>');
    L47:
        List<String> r15 = r8.b;
        if (r15 == null) goto L56;
        if ((!r15.isEmpty()) == true) goto L53;
        r15 = null;
    L53:
        if (r15 == null) goto L56;
        r10.add("<LinkID=" + CollectionsKt.joinToString$default(r15, ",", null, null, 0, null, new b(this), 30, null) + '>');
    L56:
        String r16 = r8.f;
        if (r16 == null) goto L59;
        r10.add("<Source=" + g(r16) + '>');
    L59:
        String r17 = CollectionsKt.joinToString$default(r10, "", null, null, 0, null, null, 62, null);
        h r18 = this.a;
        LogLevel r19 = this.b;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "level");
        Intrinsics.checkNotNullParameter(r17, "content");
        Intrinsics.checkNotNullParameter(r9, "file");
        Intrinsics.checkNotNullParameter(r2, "function");
        String r1 = r17 + " [" + (((String) CollectionsKt.last(StringsKt.split$default(r9, new String[]{"/"}, false, 0, 6, null))) + ',' + r2 + ',' + r4) + ']';
        int r3 = h$a.a[r19.ordinal()];
        if (r3 != 1) goto L62;
        FLogger.a.d(r18.a, r1);
        return;
    L62:
        if (r3 != 2) goto L64;
        FLogger.a.i(r18.a, r1);
        return;
    L64:
        if (r3 != 3) goto L66;
        FLogger.a.w(r18.a, r1);
        return;
    L66:
        if (r3 != 4) goto L69;
        FLogger.a.e(r18.a, r1);
        return;
    L69:
        throw new NoWhenBranchMatchedException();
    L22:
        if ((!r11.isEmpty()) == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L38;
        StringBuilder r110 = new StringBuilder("<Params=");
        ArrayList r111 = new ArrayList(r11.size());
        Iterator<Map.Entry<f, Object>> r20 = r11.entrySet().iterator();
    L28:
        if (r20.hasNext() == false) goto L37;
        Map.Entry<f, Object> r112 = r20.next();
        f r113 = r112.getKey();
        Object r114 = r112.getValue();
        String r21 = "\"" + g(r113.a) + '\"';
        if ((r114 instanceof String) == false) goto L33;
        String r22 = "\"" + g((String) r114) + '\"';
    L36:
        r111.add(r21 + ':' + r22);
        goto L28
    L33:
        if ((r114 instanceof Number) == false) goto L35;
        r22 = r114.toString();
        goto L36
    L35:
        r22 = "\"" + g(r114.toString()) + '\"';
        goto L36
    L37:
        r110.append("{" + CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, null, 62, null) + '}');
        r110.append('>');
        r10.add(r110.toString());
        goto L38
    L18:
        r4 = r28;
    L15:
        r2 = r27;
    L11:
        r9 = r26;
        goto L12
    L5:
        r6 = null;
        goto L6
    }
}
