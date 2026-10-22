package fb;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gb.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: fb.a$a, reason: collision with other inner class name */
    public static final class C0157a {
    }

    static {
    }

    public a() {
    }

    public static Object a(gb.d r13) {
        Intrinsics.checkNotNullParameter(r13, "option");
        if (Intrinsics.areEqual(r13.getType(), "op") == false) goto L197;
        List<Object> r0 = r13.c();
        if (r0 == null) goto L7;
        boolean r10 = true;
        boolean r11 = false;
        if (Intrinsics.areEqual(r13.b(), "!") == false) goto L19;
        if (r0.isEmpty() == true) goto L17;
        if (e.a(ListProtector.get(r0, 0)) == false) goto L17;
        r10 = false;
    L17:
        return Boolean.valueOf(r10);
    L19:
        if (Intrinsics.areEqual(r13.b(), "&&") == false) goto L38;
        if (r0.isEmpty() == true) goto L23;
        List<Object> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r14 = r1.iterator();
    L31:
        if (r14.hasNext() == false) goto L36;
        if (e.a(r14.next()) == true) goto L31;
        r10 = false;
    L36:
        return Boolean.valueOf(r10);
    L27:
        if (r1.isEmpty() == false) goto L29;
    L23:
        return Boolean.FALSE;
    L38:
        if (Intrinsics.areEqual(r13.b(), "||") == false) goto L58;
        if (r0.isEmpty() == true) goto L42;
        List<Object> r12 = r0;
        if ((r12 instanceof Collection) == true) goto L46;
    L48:
        Iterator<T> r15 = r12.iterator();
    L50:
        if (r15.hasNext() == false) goto L54;
        if (e.a(r15.next()) == false) goto L50;
    L56:
        return Boolean.valueOf(r10);
    L54:
        r10 = false;
        goto L56
    L46:
        if (r12.isEmpty() == false) goto L48;
    L42:
        return Boolean.FALSE;
    L58:
        if (r0.size() >= 2) goto L62;
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.i("AirSolution_CalcExecutor", "error: size less then 2, " + r0, null, 12);
        return new Object();
    L62:
        if (Intrinsics.areEqual(r13.b(), "t") == false) goto L73;
        if (r0.size() >= 3) goto L67;
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.i("AirSolution_CalcExecutor", "error: size less then 3, " + r0, null, 12);
        return new Object();
    L67:
        boolean r18 = e.a(ListProtector.get(r0, 0));
        Object r19 = ListProtector.get(r0, 1);
        Object r20 = ListProtector.get(r0, 2);
        if (r18 == false) goto L71;
        return r19;
    L71:
        return r20;
    L73:
        if ((ListProtector.get(r0, 0) instanceof Number) == true) goto L75;
    L165:
        Object r21 = ListProtector.get(r0, 0);
        Object r22 = ListProtector.get(r0, 1);
        String r110 = r13.b();
        if (r110 == null) goto L195;
        int r23 = r110.hashCode();
        if (r23 == 43) goto L183;
        if (r23 == 61) goto L179;
        if (r23 != 1084) goto L195;
        if (r110.equals("!=") == false) goto L195;
        return Boolean.valueOf(!Intrinsics.areEqual(r21, r22));
    L179:
        if (r110.equals("=") == false) goto L195;
        return Boolean.valueOf(Intrinsics.areEqual(r21, r22));
    L183:
        if (r110.equals("+") == false) goto L195;
        if ((r21 instanceof String) == false) goto L188;
    L192:
        StringBuilder r111 = new StringBuilder();
        r111.append(r21);
        r111.append(r22);
        return r111.toString();
    L188:
        if ((r22 instanceof String) == true) goto L192;
        return new Object();
    L195:
        return Boolean.FALSE;
    L75:
        if ((ListProtector.get(r0, 1) instanceof Number) == false) goto L165;
        Object r24 = ListProtector.get(r0, 0);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.Number");
        double r112 = ((Number) r24).doubleValue();
        Object r25 = ListProtector.get(r0, 1);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Number");
        double r26 = ((Number) r25).doubleValue();
        String r113 = r13.b();
        if (r113 == null) goto L197;
        int r27 = r113.hashCode();
        if (r27 == 42) goto L161;
        if (r27 == 43) goto L156;
        if (r27 == 45) goto L151;
        if (r27 == 47) goto L146;
        if (r27 == 1084) goto L138;
        if (r27 == 1921) goto L129;
        if (r27 == 1983) goto L120;
        switch(r27) {
            case 60: goto L111;
            case 61: goto L102;
            case 62: goto L93;
            default: goto L197;
        };
    L93:
        if (r113.equals(">") == false) goto L197;
        if (r112 > r26) goto L100;
        r10 = false;
    L100:
        return Boolean.valueOf(r10);
    L102:
        if (r113.equals("=") == false) goto L197;
        if (r112 == r26) goto L109;
        r10 = false;
    L109:
        return Boolean.valueOf(r10);
    L111:
        if (r113.equals("<") == false) goto L197;
        if (r112 < r26) goto L118;
        r10 = false;
    L118:
        return Boolean.valueOf(r10);
    L120:
        if (r113.equals(">=") == false) goto L197;
        if (r112 >= r26) goto L127;
        r10 = false;
    L127:
        return Boolean.valueOf(r10);
    L129:
        if (r113.equals("<=") == false) goto L197;
        if (r112 <= r26) goto L136;
        r10 = false;
    L136:
        return Boolean.valueOf(r10);
    L138:
        if (r113.equals("!=") == false) goto L197;
        if (r112 != r26) goto L144;
        r11 = true;
    L144:
        return Boolean.valueOf(!r11);
    L146:
        if (r113.equals("/") == false) goto L197;
        return Double.valueOf(r112 / r26);
    L151:
        if (r113.equals("-") == false) goto L197;
        return Double.valueOf(r112 - r26);
    L156:
        if (r113.equals("+") == false) goto L197;
        return Double.valueOf(r112 + r26);
    L161:
        if (r113.equals("*") == false) goto L197;
        return Double.valueOf(r112 * r26);
    L7:
        return new Object();
    L197:
        return new Object();
    }
}
