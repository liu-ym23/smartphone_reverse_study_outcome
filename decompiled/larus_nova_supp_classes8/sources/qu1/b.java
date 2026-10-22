package qu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru1.c;
import tu1.d;
import tu1.e;
import tu1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final HashMap<String, c> a = null;

    static {
        a = new HashMap();
    }

    @JvmStatic
    public static final Object a(String r22, Map<String, ? extends Object> r23) {
        Intrinsics.checkNotNullParameter(r22, "expressString");
        Intrinsics.checkNotNullParameter(r23, "context");
        c r4 = a.get(r22);
        if (r4 != null) goto L182;
        Intrinsics.checkNotNullParameter(r22, "expressString");
        Set<String> r2 = d.a.keySet();
        int r5 = f.a;
        Intrinsics.checkNotNullParameter(r22, "content");
        Intrinsics.checkNotNullParameter(r2, "keywords");
        ArrayList r8 = new ArrayList();
        int r10 = 0;
        int r11 = 0;
    L6:
        if (r10 >= r22.length()) goto L31;
        if (r22.charAt(r10) == ' ') goto L9;
        Iterator<T> r12 = r2.iterator();
    L14:
        if (r12.hasNext() == false) goto L23;
        Object r13 = r12.next();
        String r14 = (String) r13;
        if ((r14.length() + r10) <= r22.length()) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L14;
    L24:
        String r15 = (String) r13;
        if (r15 != null) goto L26;
        r10 = r10 + 1;
        goto L6
    L26:
        if (r10 == r11) goto L28;
        r8.add(new e(r22.substring(r11, r10)));
    L28:
        r8.add(new e(r15));
        r11 = r15.length() + r10;
    L29:
        r10 = r11;
        goto L6
    L18:
        if (Intrinsics.areEqual(r22.substring(r10, r14.length() + r10), r14) == false) goto L20;
        r6 = true;
        goto L21
    L23:
        r13 = null;
        goto L24
    L9:
        if (r10 == r11) goto L11;
        r8.add(new e(r22.substring(r11, r10)));
    L11:
        r11 = r10 + 1;
        goto L29
    L31:
        if (r10 == r11) goto L33;
        r8.add(new e(r22.substring(r11, r10)));
    L33:
        Map<String, ExpressNodeType> r3 = d.a;
        int r7 = tu1.a.a;
        Intrinsics.checkNotNullParameter(r8, "words");
        Intrinsics.checkNotNullParameter(r3, "keywords");
        ArrayList r9 = new ArrayList();
        Iterator r16 = r8.iterator();
    L35:
        if (r16.hasNext() == false) goto L84;
        e r17 = (e) r16.next();
        char r18 = r17.a.charAt(0);
        if ('0' <= r18) goto L40;
    L60:
        tu1.b r19 = null;
    L61:
        if (r19 != null) goto L62;
        String r110 = r17.a;
        int r111 = r110.hashCode();
        if (r111 == 3569038) goto L72;
        if (r111 == 97196323) goto L69;
    L74:
        tu1.b r112 = null;
    L75:
        if (r112 != null) goto L76;
        ExpressNodeType r113 = r3.get(r17.a);
        if (r113 == null) goto L80;
        tu1.b r114 = new tu1.b(r113, r17.a);
    L81:
        if (r114 != null) goto L82;
        r9.add(new tu1.b(ExpressNodeType.PARAM, r17.a));
        goto L35
    L82:
        r9.add(r114);
        goto L35
    L80:
        r114 = null;
        goto L81
    L76:
        r9.add(r112);
        goto L35
    L69:
        if (r110.equals("false") == false) goto L74;
        r112 = new tu1.b(ExpressNodeType.CONST_BOOLEAN, Boolean.FALSE);
        goto L75
    L72:
        if (r110.equals("true") == false) goto L74;
        r112 = new tu1.b(ExpressNodeType.CONST_BOOLEAN, Boolean.TRUE);
        goto L75
    L62:
        r9.add(r19);
        goto L35
    L40:
        if ('9' < r18) goto L60;
        String r115 = r17.a;
        char r116 = r115.charAt(r115.length() - 1);
        if (r116 != 'l') goto L45;
        r19 = new tu1.b(ExpressNodeType.CONST_LONG, Long.valueOf(CastLongProtector.parseLong(r17.a)));
        goto L61
    L45:
        if (r116 != 'd') goto L48;
        r19 = new tu1.b(ExpressNodeType.CONST_DOUBLE, Double.valueOf(CastDoubleProtector.parseDouble(r17.a)));
        goto L61
    L48:
        if (r116 != 'f') goto L51;
        r19 = new tu1.b(ExpressNodeType.CONST_FLOAT, Float.valueOf(CastFloatProtector.parseFloat(r17.a)));
        goto L61
    L51:
        if (StringsKt.indexOf$default(r17.a, '.', 0, false, 6, null) <= 0) goto L53;
        r19 = new tu1.b(ExpressNodeType.CONST_FLOAT, Float.valueOf(CastFloatProtector.parseFloat(r17.a)));
        goto L61
    L53:
        long r117 = CastLongProtector.parseLong(r17.a);
        if (r117 >= Integer.MIN_VALUE) goto L56;
    L58:
        tu1.b r118 = new tu1.b(ExpressNodeType.CONST_LONG, Long.valueOf(r117));
    L59:
        r19 = r118;
        goto L61
    L56:
        if (r117 > Integer.MAX_VALUE) goto L58;
        r118 = new tu1.b(ExpressNodeType.CONST_INT, Integer.valueOf((int) r117));
        goto L59
    L84:
        int r20 = tu1.c.a;
        Intrinsics.checkNotNullParameter(r9, "nodes");
        tu1.c.a r21 = new tu1.c.a();
        Iterator r24 = r9.iterator();
    L86:
        if (r24.hasNext() == false) goto L171;
        tu1.b r25 = (tu1.b) r24.next();
        if (r21.a.isEmpty() == false) goto L90;
        tu1.b r26 = null;
    L92:
        if (r25.c() == true) goto L93;
        if (r25.b() == true) goto L114;
        ExpressNodeType r27 = r25.a;
        if (r27 != ExpressNodeType.LEFT_BRACKET) goto L157;
        boolean r28 = true;
    L158:
        if (r28 == true) goto L159;
        if (r27 != ExpressNodeType.RIGHT_BRACKET) goto L163;
        boolean r29 = true;
    L164:
        if (r29 == false) goto L86;
        if (((LinkedList) r21.a).removeFirstOccurrence(tu1.c.a.b) == false) goto L169;
        r21.a();
        goto L86
    L169:
        throw new SimpleExpressException("express parse failed, remove barrage error", null, 2, null);
    L163:
        r29 = false;
        goto L164
    L159:
        ((LinkedList) r21.a).push(tu1.c.a.b);
        goto L86
    L157:
        r28 = false;
        goto L158
    L114:
        if (r26 == null) goto L118;
        if (r26.c() == false) goto L118;
        r21.b(r25);
    L118:
        if (r26 == null) goto L153;
        if (r26.b() == false) goto L153;
        ExpressNodeType r30 = r26.a;
        ExpressNodeType r119 = ExpressNodeType.OPERATOR_COMPARE;
        if (r30 != r119) goto L125;
        char r31 = 2;
    L131:
        ExpressNodeType r120 = r25.a;
        if (r120 != r119) goto L135;
        char r121 = 2;
    L141:
        if (r31 >= r121) goto L142;
        Intrinsics.checkNotNullParameter(r25, "node");
        tu1.b r32 = (tu1.b) ((LinkedList) r21.a).peek();
        if (r32 == null) goto L151;
        tu1.b r122 = r32.d;
        if (r122 == null) goto L149;
        r25.c = r122;
        r32.d = null;
        ((LinkedList) r21.a).push(r25);
        goto L86
    L149:
        throw new SimpleExpressException("express parse failed, rob not full node", null, 2, null);
    L151:
        throw new SimpleExpressException("express parse failed, rob null node", null, 2, null);
    L142:
        r21.b(r25);
        goto L86
    L135:
        if (r120 != ExpressNodeType.OPERATOR_AND) goto L137;
    L140:
        r121 = 1;
        goto L141
    L137:
        if (r120 == ExpressNodeType.OPERATOR_OR) goto L140;
        r121 = 0;
        goto L141
    L125:
        if (r30 != ExpressNodeType.OPERATOR_AND) goto L127;
    L130:
        r31 = 1;
        goto L131
    L127:
        if (r30 == ExpressNodeType.OPERATOR_OR) goto L130;
        r31 = 0;
    L153:
        throw new SimpleExpressException("express parse failed, error node is " + r25 + ", last node is " + r26, null, 2, null);
    L93:
        if (r26 == null) goto L105;
        if (r26.b() == false) goto L105;
        Intrinsics.checkNotNullParameter(r25, "node");
        tu1.b r33 = (tu1.b) ((LinkedList) r21.a).peek();
        if (r33 == null) goto L104;
        if (r33.d != null) goto L102;
        r33.d = r25;
        r21.a();
        goto L86
    L102:
        throw new SimpleExpressException("express parse failed, hang full node", null, 2, null);
    L104:
        throw new SimpleExpressException("express parse failed, hang null node", null, 2, null);
    L105:
        if (r26 != null) goto L107;
    L111:
        Intrinsics.checkNotNullParameter(r25, "node");
        ((LinkedList) r21.a).push(r25);
        goto L86
    L107:
        if (r26.c() == false) goto L111;
        throw new SimpleExpressException("express parse failed, error node is " + r25 + ", last node is " + r26, null, 2, null);
    L90:
        r26 = (tu1.b) ((LinkedList) r21.a).peek();
        goto L92
    L171:
        if (((LinkedList) r21.a).size() != 1) goto L181;
        if (r21.a.isEmpty() == false) goto L175;
        tu1.b r34 = null;
    L176:
        if (r34 == null) goto L179;
        int r35 = ru1.b.a;
        Intrinsics.checkNotNullParameter(r34, "root");
        ArrayList r36 = new ArrayList();
        ru1.b.a(r34, r36);
        c r37 = new c(r36);
        a.put(r22, r37);
        r4 = r37;
        goto L182
    L179:
        throw new SimpleExpressException("express parse failed, stack root is null", null, 2, null);
    L175:
        r34 = (tu1.b) ((LinkedList) r21.a).peek();
        goto L176
    L181:
        throw new SimpleExpressException("express parse failed, result stack size is " + ((LinkedList) r21.a).size(), null, 2, null);
    L182:
        Intrinsics.checkNotNullParameter(r4, "operationSet");
        Intrinsics.checkNotNullParameter(r23, "context");
        a r0 = new a();
        Intrinsics.checkNotNullParameter(r0, "runEnvironment");
        Intrinsics.checkNotNullParameter(r23, "context");
        Iterator<T> r38 = r4.a.iterator();
    L184:
        if (r38.hasNext() == false) goto L187;
        ((su1.e) r38.next()).a(r0, r23);
        goto L184
    L187:
        if (((LinkedList) r0.a).size() != 1) goto L191;
        return ((LinkedList) r0.a).peek();
    L191:
        throw new SimpleExpressException("express execute failed, stack size is " + ((LinkedList) r0.a).size(), null, 2, null);
    }
}
