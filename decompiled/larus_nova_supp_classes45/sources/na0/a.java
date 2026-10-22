package na0;

import com.bytedance.android.live.impl.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements sb1.a {
    public a() {
    }

    public final boolean a(Object r11, Object r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "currentCharacter");
        if (r12 == null) goto L286;
        if (r13 == null) goto L286;
        switch(r13.hashCode()) {
            case -913705004: goto L285;
            case -567445985: goto L269;
            case -83901120: goto L244;
            case 60: goto L224;
            case 62: goto L204;
            case 1084: goto L182;
            case 1921: goto L162;
            case 1952: goto L140;
            case 1983: goto L120;
            case 3365: goto L67;
            case 35078: goto L13;
            case 96673: goto L10;
            default: goto L286;
        };
    L285:
        r13.equals("all not");
        goto L286
    L10:
        if (r13.equals("all") == false) goto L286;
        return true;
    L13:
        if (r13.equals("!in") == false) goto L286;
        if ((r12 instanceof ArrayList) == false) goto L65;
        ArrayList r14 = (ArrayList) r12;
        if (r14.size() == 2) goto L19;
        return false;
    L19:
        Object r15 = ListProtector.get(r14, 0);
        if ((r15 instanceof Integer) == false) goto L35;
        int r16 = b.c(r11);
        Object r1 = ListProtector.get(r14, 0);
        if (r1 == null) goto L33;
        if (r16 < ((Integer) r1).intValue()) goto L62;
        int r17 = b.c(r11);
        Object r18 = ListProtector.get(r14, 1);
        if (r18 == null) goto L31;
        if (r17 > ((Integer) r18).intValue()) goto L62;
        return false;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L62:
        return true;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L35:
        if ((r15 instanceof Double) == false) goto L50;
        double r3 = b.b(r11);
        Object r19 = ListProtector.get(r14, 0);
        if (r19 == null) goto L48;
        if (r3 < ((Double) r19).doubleValue()) goto L62;
        double r4 = b.b(r11);
        Object r110 = ListProtector.get(r14, 1);
        if (r110 == null) goto L46;
        if (r4 > ((Double) r110).doubleValue()) goto L62;
        return false;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L48:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L50:
        if ((r15 instanceof Long) == false) goto L289;
        long r5 = b.d(r11);
        Object r111 = ListProtector.get(r14, 0);
        if (r111 == null) goto L64;
        if (r5 < ((Long) r111).longValue()) goto L62;
        long r6 = b.d(r11);
        Object r112 = ListProtector.get(r14, 1);
        if (r112 == null) goto L61;
        if (r6 > ((Long) r112).longValue()) goto L62;
        return false;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L289:
        return false;
    L65:
        return false;
    L67:
        if (r13.equals("in") == false) goto L286;
        if ((r12 instanceof ArrayList) == false) goto L118;
        ArrayList r113 = (ArrayList) r12;
        if (r113.size() == 2) goto L73;
        return false;
    L73:
        Object r114 = ListProtector.get(r113, 0);
        if ((r114 instanceof Integer) == false) goto L89;
        int r115 = b.c(r11);
        Object r2 = ListProtector.get(r113, 0);
        if (r2 == null) goto L87;
        if (r115 < ((Integer) r2).intValue()) goto L292;
        int r116 = b.c(r11);
        Object r117 = ListProtector.get(r113, 1);
        if (r117 == null) goto L85;
        if (r116 > ((Integer) r117).intValue()) goto L293;
    L113:
        return true;
    L293:
        return false;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L292:
        return false;
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L89:
        if ((r114 instanceof Double) == false) goto L104;
        double r7 = b.b(r11);
        Object r118 = ListProtector.get(r113, 0);
        if (r118 == null) goto L102;
        if (r7 < ((Double) r118).doubleValue()) goto L294;
        double r8 = b.b(r11);
        Object r119 = ListProtector.get(r113, 1);
        if (r119 == null) goto L100;
        if (r8 <= ((Double) r119).doubleValue()) goto L113;
        return false;
    L100:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L294:
        return false;
    L102:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L104:
        if ((r114 instanceof Long) == false) goto L296;
        long r9 = b.d(r11);
        Object r120 = ListProtector.get(r113, 0);
        if (r120 == null) goto L117;
        if (r9 < ((Long) r120).longValue()) goto L297;
        long r21 = b.d(r11);
        Object r121 = ListProtector.get(r113, 1);
        if (r121 == null) goto L115;
        if (r21 <= ((Long) r121).longValue()) goto L113;
        return false;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L297:
        return false;
    L117:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L296:
        return false;
    L118:
        return false;
    L120:
        if (r13.equals(">=") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L128;
        if (b.c(r11) < ((Integer) r12).intValue()) goto L300;
        return true;
    L300:
        return false;
    L128:
        if ((r12 instanceof Double) == false) goto L134;
        if (b.b(r11) < ((Double) r12).doubleValue()) goto L301;
        return true;
    L301:
        return false;
    L134:
        if ((r12 instanceof Long) == true) goto L136;
        return false;
    L136:
        if (b.d(r11) < ((Long) r12).longValue()) goto L303;
        return true;
    L303:
        return false;
    L140:
        if (r13.equals("==") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L148;
        if (b.c(r11) != ((Integer) r12).intValue()) goto L304;
        return true;
    L304:
        return false;
    L148:
        if ((r12 instanceof Double) == false) goto L154;
        if (b.b(r11) != ((Double) r12).doubleValue()) goto L305;
        return true;
    L305:
        return false;
    L154:
        if ((r12 instanceof Long) == false) goto L160;
        if (b.d(r11) != ((Long) r12).longValue()) goto L306;
        return true;
    L306:
        return false;
    L160:
        return Intrinsics.areEqual(r11, r12);
    L162:
        if (r13.equals("<=") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L170;
        if (b.c(r11) > ((Integer) r12).intValue()) goto L307;
        return true;
    L307:
        return false;
    L170:
        if ((r12 instanceof Double) == false) goto L176;
        if (b.b(r11) > ((Double) r12).doubleValue()) goto L308;
        return true;
    L308:
        return false;
    L176:
        if ((r12 instanceof Long) == true) goto L178;
        return false;
    L178:
        if (b.d(r11) > ((Long) r12).longValue()) goto L310;
        return true;
    L310:
        return false;
    L182:
        if (r13.equals("!=") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L190;
        if (b.c(r11) == ((Integer) r12).intValue()) goto L311;
        return true;
    L311:
        return false;
    L190:
        if ((r12 instanceof Double) == false) goto L196;
        if (b.b(r11) == ((Double) r12).doubleValue()) goto L312;
        return true;
    L312:
        return false;
    L196:
        if ((r12 instanceof Long) == false) goto L202;
        if (b.d(r11) == ((Long) r12).longValue()) goto L313;
        return true;
    L313:
        return false;
    L202:
        return !Intrinsics.areEqual(r11, r12);
    L204:
        if (r13.equals(">") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L212;
        if (b.c(r11) <= ((Integer) r12).intValue()) goto L314;
        return true;
    L314:
        return false;
    L212:
        if ((r12 instanceof Double) == false) goto L218;
        if (b.b(r11) <= ((Double) r12).doubleValue()) goto L315;
        return true;
    L315:
        return false;
    L218:
        if ((r12 instanceof Long) == true) goto L220;
        return false;
    L220:
        if (b.d(r11) <= ((Long) r12).longValue()) goto L317;
        return true;
    L317:
        return false;
    L224:
        if (r13.equals("<") == false) goto L286;
        if ((r12 instanceof Integer) == false) goto L232;
        if (b.c(r11) >= ((Integer) r12).intValue()) goto L318;
        return true;
    L318:
        return false;
    L232:
        if ((r12 instanceof Double) == false) goto L238;
        if (b.b(r11) >= ((Double) r12).doubleValue()) goto L319;
        return true;
    L319:
        return false;
    L238:
        if ((r12 instanceof Long) == true) goto L240;
        return false;
    L240:
        if (b.d(r11) >= ((Long) r12).longValue()) goto L321;
        return true;
    L321:
        return false;
    L244:
        if (r13.equals("!contains") == false) goto L286;
        if ((r12 instanceof ArrayList) == false) goto L322;
        ArrayList r122 = (ArrayList) r12;
        Object r123 = ListProtector.get(r122, 0);
        if ((r123 instanceof Integer) == false) goto L253;
        if (CollectionsKt.contains(r122, Integer.valueOf(b.c(r11))) == true) goto L323;
    L266:
        return true;
    L323:
        return false;
    L253:
        if ((r123 instanceof Double) == false) goto L258;
        if (CollectionsKt.contains(r122, Double.valueOf(b.b(r11))) == false) goto L266;
        return false;
    L258:
        if ((r123 instanceof Long) == false) goto L263;
        if (CollectionsKt.contains(r122, Long.valueOf(b.d(r11))) == false) goto L266;
        return false;
    L263:
        if ((r123 instanceof String) == true) goto L265;
        return false;
    L265:
        if (CollectionsKt.contains(r122, b.e(r11)) == false) goto L266;
        return false;
    L322:
        return false;
    L269:
        if (r13.equals("contains") == false) goto L286;
        if ((r12 instanceof ArrayList) == false) goto L328;
        ArrayList r124 = (ArrayList) r12;
        Object r125 = ListProtector.get(r124, 0);
        if ((r125 instanceof Integer) == false) goto L276;
        return CollectionsKt.contains(r124, Integer.valueOf(b.c(r11)));
    L276:
        if ((r125 instanceof Double) == false) goto L279;
        return CollectionsKt.contains(r124, Double.valueOf(b.b(r11)));
    L279:
        if ((r125 instanceof Long) == false) goto L282;
        return CollectionsKt.contains(r124, Long.valueOf(b.d(r11)));
    L282:
        if ((r125 instanceof String) == true) goto L284;
        return false;
    L284:
        return CollectionsKt.contains(r124, b.e(r11));
    L328:
        return false;
    L286:
        return false;
    }
}
