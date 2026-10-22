package kn;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.writer.DaoWriter;
import com.bytedance.ies.bullet.core.h;
import com.lynx.react.bridge.ReadableMap;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import l4.f;
import ym.m;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public static int a(int r5, int r10, boolean r11) {
        return androidx.room.jarjarred.org.antlr.runtime.a.d(r5, r10, r11);
    }

    public static DisplayMetrics b() {
        Application r5 = h.g.f5316b;
        if (r5 == null) goto L9;
        Context r10 = r5.getApplicationContext();
        if (r10 == null) goto L9;
        Resources r11 = r10.getResources();
        if (r11 == null) goto L9;
        DisplayMetrics r12 = r11.getDisplayMetrics();
    L10:
        if (r12 == null) goto L12;
        return r12;
    L12:
        return Resources.getSystem().getDisplayMetrics();
    L9:
        r12 = null;
        goto L10
    }

    public static Object c(f r13) {
        Intrinsics.checkNotNullParameter(r13, "option");
        if (Intrinsics.areEqual(r13.d(), "op") == false) goto L186;
        List r5 = r13.c();
        if (r5 == null) goto L7;
        boolean r10 = false;
        if (Intrinsics.areEqual(r13.a(), XPath.NOT) == false) goto L18;
        if (r5.isEmpty() == false) goto L13;
    L14:
        r10 = true;
    L16:
        return Boolean.valueOf(r10);
    L13:
        if (m.l(r5.get(0)) == true) goto L16;
    L18:
        if (Intrinsics.areEqual(r13.a(), "&&") == false) goto L36;
        if (r5.isEmpty() == false) goto L24;
        return Boolean.FALSE;
    L24:
        if (r5.isEmpty() == true) goto L32;
        Iterator r14 = r5.iterator();
    L28:
        if (r14.hasNext() == false) goto L32;
        if (m.l(r14.next()) == true) goto L28;
    L34:
        return Boolean.valueOf(r10);
    L32:
        r10 = true;
        goto L34
    L36:
        if (Intrinsics.areEqual(r13.a(), "||") == false) goto L53;
        if (r5.isEmpty() == false) goto L42;
        return Boolean.FALSE;
    L42:
        if (r5.isEmpty() == true) goto L51;
        Iterator r15 = r5.iterator();
    L46:
        if (r15.hasNext() == false) goto L51;
        if (m.l(r15.next()) == false) goto L46;
        r10 = true;
    L51:
        return Boolean.valueOf(r10);
    L53:
        if (r5.size() >= 2) goto L57;
        int r16 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_CalcExecutor", "error: size less then 2, " + r5, null, 12);
        return new Object();
    L57:
        if (Intrinsics.areEqual(r13.a(), "t") == false) goto L67;
        if (r5.size() >= 3) goto L62;
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_CalcExecutor", "error: size less then 3, " + r5, null, 12);
        return new Object();
    L62:
        boolean r18 = m.l(r5.get(0));
        Object r11 = r5.get(1);
        Object r12 = r5.get(2);
        if (r18 == false) goto L65;
        return r11;
    L65:
        return r12;
    L67:
        if ((r5.get(0) instanceof Number) == true) goto L69;
    L154:
        Object r19 = r5.get(0);
        Object r20 = r5.get(1);
        String r110 = r13.a();
        if (r110 == null) goto L184;
        int r21 = r110.hashCode();
        if (r21 == 43) goto L172;
        if (r21 == 61) goto L168;
        if (r21 != 1084) goto L184;
        if (r110.equals("!=") == false) goto L184;
        return Boolean.valueOf(!Intrinsics.areEqual(r19, r20));
    L168:
        if (r110.equals("=") == false) goto L184;
        return Boolean.valueOf(Intrinsics.areEqual(r19, r20));
    L172:
        if (r110.equals("+") == false) goto L184;
        if ((r19 instanceof String) == false) goto L177;
    L181:
        StringBuilder r111 = new StringBuilder();
        r111.append(r19);
        r111.append(r20);
        return r111.toString();
    L177:
        if ((r20 instanceof String) == true) goto L181;
        return new Object();
    L184:
        return Boolean.FALSE;
    L69:
        if ((r5.get(1) instanceof Number) == false) goto L154;
        Object r22 = r5.get(0);
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Number");
        double r112 = ((Number) r22).doubleValue();
        Object r23 = r5.get(1);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Number");
        double r24 = ((Number) r23).doubleValue();
        String r113 = r13.a();
        if (r113 == null) goto L186;
        int r25 = r113.hashCode();
        if (r25 == 42) goto L150;
        if (r25 == 43) goto L145;
        if (r25 == 45) goto L140;
        if (r25 == 47) goto L135;
        if (r25 == 1084) goto L127;
        if (r25 == 1921) goto L119;
        if (r25 == 1983) goto L111;
        switch(r25) {
            case 60: goto L103;
            case 61: goto L95;
            case 62: goto L87;
            default: goto L186;
        };
    L87:
        if (r113.equals(">") == false) goto L186;
        if (r112 <= r24) goto L93;
        r10 = true;
    L93:
        return Boolean.valueOf(r10);
    L95:
        if (r113.equals("=") == false) goto L186;
        if (r112 != r24) goto L101;
        r10 = true;
    L101:
        return Boolean.valueOf(r10);
    L103:
        if (r113.equals("<") == false) goto L186;
        if (r112 >= r24) goto L109;
        r10 = true;
    L109:
        return Boolean.valueOf(r10);
    L111:
        if (r113.equals(">=") == false) goto L186;
        if (r112 < r24) goto L117;
        r10 = true;
    L117:
        return Boolean.valueOf(r10);
    L119:
        if (r113.equals("<=") == false) goto L186;
        if (r112 > r24) goto L125;
        r10 = true;
    L125:
        return Boolean.valueOf(r10);
    L127:
        if (r113.equals("!=") == false) goto L186;
        if (r112 != r24) goto L133;
        r10 = true;
    L133:
        return Boolean.valueOf(!r10);
    L135:
        if (r113.equals("/") == false) goto L186;
        return Double.valueOf(r112 / r24);
    L140:
        if (r113.equals(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L186;
        return Double.valueOf(r112 - r24);
    L145:
        if (r113.equals("+") == false) goto L186;
        return Double.valueOf(r112 + r24);
    L150:
        if (r113.equals(XPath.WILDCARD) == false) goto L186;
        return Double.valueOf(r112 * r24);
    L7:
        return new Object();
    L186:
        return new Object();
    }

    public static HashMap d(ReadableMap r10) {
        HashMap r5 = new HashMap();
        HashMap<String, Object> r11 = r10.asHashMap();
        Iterator<String> r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        String r13 = r12.next();
        Object r14 = r11.get(r13);
        if ((r14 instanceof List) == true) goto L7;
        if ((r14 instanceof Number) == true) goto L10;
        if (r14 == null) goto L4;
        r5.put(r13, r14.toString());
        goto L4
    L10:
        double r15 = ((Number) r14).doubleValue();
        DecimalFormat r16 = t.f23539a;
        if (r15 < 9.223372036854776E18d) goto L13;
    L17:
        String r17 = t.f23539a.format(r15);
    L18:
        r5.put(r13, r17);
        goto L4
    L13:
        if (r15 <= (-9.223372036854776E18d)) goto L17;
        long r18 = (long) Math.floor(r15);
        if (r15 != r18) goto L17;
        r17 = String.valueOf(r18);
        goto L18
    L7:
        r5.put(r13, TextUtils.join(",", (Iterable) r14));
        goto L4
    L21:
        return r5;
    }

    public static void e() {
        com.bytedance.crash.m.checkInnerSoFile("npth_logcat", "1.0.0-ttp");
    }

    public static obric.flow.thermal.a f() {
        Object r5 = obric.flow.thermal.a.f20538i;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (obric.flow.thermal.a.f20537h != null) goto L9;
        obric.flow.thermal.a.f20537h = new obric.flow.thermal.a();     // Catch: Throwable -> L7
    L9:
        obric.flow.thermal.a r10 = obric.flow.thermal.a.f20537h;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    }

    public static boolean g() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
