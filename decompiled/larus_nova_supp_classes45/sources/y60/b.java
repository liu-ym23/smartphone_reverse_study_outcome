package y60;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final Context a;
    public SharedPreferences b;
    public SharedPreferences c;
    public final String d;
    public Map<String, ? extends Object> e;
    public final AtomicInteger f;
    public final AtomicInteger g;
    public boolean h;
    public boolean i;
    public final ConcurrentHashMap<String, Integer> j;
    public final ConcurrentHashMap<String, Boolean> k;

    public final void f() {
        if (this.b != null) goto L11;
        Context r0 = this.a;
        if (r0 == null) goto L11;
        int r2 = x60.c.a;
        if (wa1.d.c.a == false) goto L9;
        this.b = new a(r0.getSharedPreferences(this.d, 0));
        goto L11
    L9:
        this.b = r0.getSharedPreferences(this.d, 0);
    L11:
        if (this.c != null) goto L21;
        int r1 = x60.c.a;
        x60.c.a r3 = wa1.d.c;
        if (r3.b == false) goto L22;
        Context r4 = this.a;
        if (r4 != null) goto L17;
        return;
    L17:
        if (r3.a == false) goto L19;
        this.c = new a(r4.getSharedPreferences("ttlive_sdk_shared_pref_cache_key", 0));
        return;
    L19:
        this.c = r4.getSharedPreferences("ttlive_sdk_shared_pref_cache_key", 0);
        return;
    L22:
        return;
    }

    public final SharedPreferences.Editor c() {
        f();
        SharedPreferences r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.edit();
    }

    public static boolean m(SharedPreferences.Editor r0) {
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.apply();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int d(String r11) {
        String r12 = "__origin_Type__" + r11;
        Integer r3 = null;
        Object r4 = null;
        r3 = null;
        if (this.i == true) goto L30;
        f();
        int r0 = x60.c.a;
        if (wa1.d.c.b == false) goto L12;
        SharedPreferences r1 = this.c;
        if (r1 == null) goto L10;
        Map r2 = r1.getAll();
        Map r5 = r2;
        if (r2 == null) goto L10;
    L11:
        this.e = r5;
    L29:
        this.i = true;
    L10:
        r5 = new HashMap();
        goto L11
    L12:
        SharedPreferences r6 = this.b;
        if (r6 == null) goto L16;
        Map r7 = r6.getAll();
        Map r8 = r7;
        if (r7 == null) goto L16;
    L17:
        this.e = r8;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r13 = r8.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L29;
        Map.Entry r14 = (Map.Entry) r13.next();
        boolean r15 = false;
        if (StringsKt.startsWith$default((String) r14.getKey(), "__origin_Type__", false, 2, null) == true) goto L23;
    L27:
        if (r15 == false) goto L19;
        r9.put(r14.getKey(), r14.getValue());
        goto L19
    L23:
        if (Intrinsics.areEqual(r14.getValue(), 4) == false) goto L25;
    L26:
        r15 = true;
        goto L27
    L25:
        if (Intrinsics.areEqual(r14.getValue(), 3) == false) goto L27;
    L16:
        r8 = new HashMap();
    L30:
        Map<String, ? extends Object> r16 = this.e;
        if (r16 != null) goto L33;
    L43:
        int r17 = x60.c.a;
        if (wa1.d.c.b == false) goto L48;
        SharedPreferences r18 = this.c;
        if (r18 == null) goto L51;
        r3 = Integer.valueOf(r18.getInt(r12, -1));
    L51:
        if (r3 != null) goto L53;
        return -1;
    L53:
        return r3.intValue();
    L48:
        SharedPreferences r19 = this.b;
        if (r19 == null) goto L51;
        r3 = Integer.valueOf(r19.getInt(r12, -1));
        goto L51
    L33:
        if (r16.containsKey(r12) != true) goto L43;
        Map<String, ? extends Object> r21 = this.e;
        if (r21 == null) goto L37;
        Object r110 = r21.get(r12);
    L39:
        if ((r110 instanceof Integer) == false) goto L42;
        r4 = r110;
    L42:
        r3 = (Integer) r4;
        goto L51
    L37:
        r110 = null;
        goto L39
    }

    public final boolean g(String r6) {
        f();
        SharedPreferences r0 = this.b;
        if (r0 != null) goto L5;
    L37:
        return true;
    L5:
        if (r0.contains(r6) != true) goto L37;
        SharedPreferences.Editor r1 = null;
        if (r6 != null) goto L9;
    L32:
        SharedPreferences.Editor r2 = c();
        if (r2 == null) goto L36;
        r1 = r2.remove(r6);
    L36:
        return m(r1);
    L9:
        if (StringsKt.startsWith$default(r6, "__origin_Type__", false, 2, null) == true) goto L32;
        String r3 = "__origin_Type__".concat(r6);
        int r4 = x60.c.a;
        if (wa1.d.c.b == false) goto L23;
        SharedPreferences r5 = this.c;
        if (r5 == null) goto L32;
        if (r5.contains(r3) != true) goto L32;
        SharedPreferences r7 = this.c;
        if (r7 == null) goto L21;
        SharedPreferences.Editor r8 = r7.edit();
        if (r8 == null) goto L21;
        SharedPreferences.Editor r9 = r8.remove(r3);
    L22:
        m(r9);
    L21:
        r9 = null;
        goto L22
    L23:
        SharedPreferences r11 = this.b;
        if (r11 == null) goto L32;
        if (r11.contains(r3) != true) goto L32;
        SharedPreferences.Editor r12 = c();
        if (r12 == null) goto L30;
        SharedPreferences.Editor r13 = r12.remove(r3);
    L31:
        m(r13);
        goto L32
    L30:
        r13 = null;
        goto L31
    }

    public b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        this.a = r2;
        this.d = r3;
        this.f = new AtomicInteger(0);
        this.g = new AtomicInteger(0);
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
    }

    public final Boolean a(String r2, boolean r3) {
        SharedPreferences r0 = this.b;
        if (r0 == null) goto L7;
        Map<String, ?> r1 = r0.getAll();
        if (r1 == null) goto L7;
        Object r4 = r1.get(r2);
    L8:
        if (r4 == null) goto L11;
        r3 = x60.a.a(r4, r3);
    L11:
        return Boolean.valueOf(r3);
    L7:
        r4 = null;
        goto L8
    }

    public final boolean b(Integer r5, String r6, boolean r7) {
        Long r0 = null;
        Boolean r1 = null;
        String r2 = null;
        if (r5 != null) goto L6;
    L12:
        if (r5 != null) goto L15;
    L21:
        if (r5 != null) goto L24;
        return r7;
    L24:
        if (r5.intValue() != 2) goto L40;
        SharedPreferences r8 = this.b;
        if (r8 == null) goto L28;
        r0 = Long.valueOf(r8.getLong(r6, -100));
    L28:
        if (r0 != null) goto L31;
    L33:
        if (r0 == null) goto L41;
        r0.longValue();
        return x60.a.a(r0, r7);
    L41:
        return r7;
    L31:
        if (r0.longValue() != (-100)) goto L33;
        return r7;
    L40:
        return r7;
    L15:
        if (r5.intValue() != 3) goto L21;
        SharedPreferences r9 = this.b;
        if (r9 == null) goto L19;
        r2 = r9.getString(r6, null);
    L19:
        if (r2 != null) goto L39;
        return r7;
    L39:
        return x60.a.a(r2, r7);
    L6:
        if (r5.intValue() != 4) goto L12;
        SharedPreferences r11 = this.b;
        if (r11 == null) goto L10;
        r1 = Boolean.valueOf(r11.getBoolean(r6, r7));
    L10:
        if (r1 == null) goto L36;
        r1.booleanValue();
        return x60.a.a(r1, r7);
    L36:
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r11v0, types: [T] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v33, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v34, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r11v35, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r11v36, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v37, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v68 */
    /* JADX WARN: Type inference failed for: r11v69 */
    /* JADX WARN: Type inference failed for: r11v70 */
    /* JADX WARN: Type inference failed for: r11v71 */
    /* JADX WARN: Type inference failed for: r12v43, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r9v0, types: [y60.b] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final <T> T e(String r11, T r12, Type r13) {
        f();
        if (r12 != 0) goto L14;
        SharedPreferences r14 = this.b;
        if (r14 == null) goto L9;
        Map<String, ?> r15 = r14.getAll();
        if (r15 == null) goto L9;
        Object r16 = r15.get(r11);
    L10:
        if (r16 == null) goto L239;
        this.f.incrementAndGet();
        Gson r17 = x60.b.a;
        return (T) x60.b.a(r16.toString(), r13);
    L239:
        return null;
    L9:
        r16 = null;
        goto L10
    L14:
        if ((r12 instanceof Boolean) == false) goto L80;
        r12 = ((Boolean) r12).booleanValue();
        int r18 = x60.c.a;
        if (wa1.d.c.d == false) goto L21;
        if (r11 == null) goto L21;
        if ((this.k.get(r11) instanceof Boolean) == false) goto L21;
        this.g.incrementAndGet();
        Object r19 = (Boolean) this.k.get(r11);
    L84:
        r12 = (T) r19;
    L218:
        if ((r12 instanceof Object) == true) goto L221;
        return null;
    L221:
        return (T) r12;
    L21:
        this.f.incrementAndGet();
        if (wa1.d.c.c == false) goto L61;
        String r110 = "__origin_Type__" + r11;
        Map<String, ? extends Object> r1 = this.e;
        if (r1 != null) goto L26;
    L54:
        r12 = a(r11, r12);
    L56:
        if ((((??[OBJECT, ARRAY]) r12) instanceof Boolean) == false) goto L218;
        if (wa1.d.c.d == false) goto L218;
        if (r11 == null) goto L218;
        this.k.put(r11, (Object) r12);
        goto L218
    L26:
        if (r1.containsKey(r110) != true) goto L54;
        Map<String, ? extends Object> r2 = this.e;
        if (r2 == null) goto L30;
        Object r111 = r2.get(r110);
    L32:
        if ((r111 instanceof Integer) == true) goto L34;
        r111 = null;
    L34:
        Integer r112 = (Integer) r111;
        if (r112 != null) goto L38;
    L53:
        r12 = (T) a(r11, r12);
        goto L56
    L38:
        if (r112.intValue() != 4) goto L53;
        if (wa1.d.c.a == false) goto L48;
        SharedPreferences r113 = this.b;
        if (r113 == null) goto L46;
        Map<String, ?> r114 = r113.getAll();
        if (r114 == null) goto L46;
        Object r115 = r114.get(r11);
    L47:
        r12 = (T) Boolean.valueOf(x60.a.a(r115, r12));
    L46:
        r115 = null;
        goto L47
    L48:
        ?? r116 = this.b;
        if (r116 == 0) goto L51;
        Boolean r117 = Boolean.valueOf(r116.getBoolean(r11, r12));
    L52:
        r12 = (T) Boolean.valueOf(x60.a.a(r117, r12));
        goto L56
    L51:
        r117 = null;
        goto L52
    L30:
        r111 = null;
        goto L32
    L61:
        SharedPreferences r118 = this.b;
        if (r118 != null) goto L64;
    L72:
        r12 = Boolean.valueOf(r12);
    L73:
        int r119 = x60.c.a;
        if (wa1.d.c.d == false) goto L218;
        if (r12 == 0) goto L218;
        boolean r120 = ((Boolean) r12).booleanValue();
        if (r11 == null) goto L218;
        this.k.put(r11, Boolean.valueOf(r120));
        goto L218
    L64:
        if (r118.contains(r11) != true) goto L72;
        int r121 = d(r11);     // Catch: Exception -> L70
        if (r121 != (-1)) goto L68;
        r12 = (T) a(r11, r12);
    L232:
        goto L73
    L68:
        r12 = Boolean.valueOf(b(Integer.valueOf(r121), r11, r12));     // Catch: Exception -> L70
    L70:
        e = move-exception;
        Map<String, Long> r3 = a70.b.a;
        a70.b.d("LiveSpStorageAction getBoolean read sp origin exception key = " + r11 + " ; error info = " + e);
        r12 = (T) a(r11, r12);
        goto L73
    L80:
        if ((r12 instanceof String) == false) goto L86;
        String r122 = (String) r12;
        SharedPreferences r123 = this.b;
        if (r123 == null) goto L128;
        r19 = r123.getString(r11, r122);
    L128:
        r12 = (T) null;
        goto L218
    L86:
        if ((r12 instanceof Integer) == false) goto L103;
        int r124 = ((Number) r12).intValue();
        long r4 = r124;
        SharedPreferences r125 = this.b;
        if (r125 == null) goto L90;
        Long r126 = Long.valueOf(r125.getLong(r11, r4));
    L91:
        if (r126 == null) goto L101;
        long r5 = r126.longValue();
        if (r5 <= 2147483647L) goto L95;
    L100:
        r19 = Integer.valueOf(r124);
        goto L84
    L95:
        if (r5 < (-2147483648L)) goto L100;
        r124 = CastIntegerProtector.parseInt(String.valueOf(r5));     // Catch: Exception -> L98
    L98:
        e = move-exception;
        d6.a("ConvertHelper", e);
        goto L100
    L101:
        r19 = Integer.valueOf(r124);
        goto L84
    L90:
        r126 = null;
        goto L91
    L103:
        if ((r12 instanceof Long) == false) goto L108;
        long r127 = ((Number) r12).longValue();
        SharedPreferences r6 = this.b;
        if (r6 == null) goto L128;
        r19 = Long.valueOf(r6.getLong(r11, r127));
        goto L84
    L108:
        if ((r12 instanceof Float) == false) goto L162;
        float r128 = ((Number) r12).floatValue();
        SharedPreferences r129 = this.b;
        if (r129 != null) goto L112;
    L160:
        r19 = Float.valueOf(r128);
        goto L84
    L112:
        if (r129.contains(r11) != true) goto L160;
        int r130 = d(r11);
        if (r130 != (-1)) goto L129;
        SharedPreferences r131 = this.b;
        if (r131 == null) goto L120;
        Map<String, ?> r132 = r131.getAll();
        if (r132 == null) goto L120;
        Object r133 = r132.get(r11);
    L121:
        if (r133 == null) goto L128;
        r128 = CastFloatProtector.parseFloat(r133.toString());     // Catch: Exception -> L125
    L127:
        r19 = Float.valueOf(r128);
    L125:
        e = move-exception;
        d6.a("ConvertHelper", e);
    L120:
        r133 = null;
        goto L121
    L129:
        Integer r134 = Integer.valueOf(r130);
        if (r134 != null) goto L133;
    L144:
        if (r134 != null) goto L147;
    L159:
        r19 = Float.valueOf(r128);
        goto L84
    L147:
        if (r134.intValue() != 2) goto L159;
        SharedPreferences r135 = this.b;
        if (r135 == null) goto L151;
        Long r136 = Long.valueOf(r135.getLong(r11, -100));
    L152:
        if (r136 == null) goto L158;
        r136.longValue();
        r128 = CastFloatProtector.parseFloat(String.valueOf(r136.longValue()));     // Catch: Exception -> L156
    L156:
        e = move-exception;
        d6.a("ConvertHelper", e);
    L158:
        r19 = Float.valueOf(r128);
        goto L84
    L151:
        r136 = null;
        goto L152
    L133:
        if (r134.intValue() != 3) goto L144;
        SharedPreferences r137 = this.b;
        if (r137 == null) goto L137;
        String r138 = r137.getString(r11, null);
    L138:
        if (r138 != null) goto L230;
    L143:
        r19 = Float.valueOf(r128);
        goto L84
    L230:
        r128 = CastFloatProtector.parseFloat(r138);     // Catch: Exception -> L141
    L141:
        e = move-exception;
        d6.a("ConvertHelper", e);
        goto L143
    L137:
        r138 = null;
        goto L138
    L162:
        if ((r12 instanceof Double) == false) goto L210;
        double r139 = ((Number) r12).doubleValue();
        SharedPreferences r7 = this.b;
        if (r7 != null) goto L166;
    L209:
        r19 = Double.valueOf(r139);
        goto L84
    L166:
        if (r7.contains(r11) != true) goto L209;
        int r8 = d(r11);
        if (r8 != (-1)) goto L178;
        String r9 = String.valueOf(r139);
        SharedPreferences r21 = this.b;
        if (r21 == null) goto L172;
        String r140 = r21.getString(r11, r9);
    L235:
        r139 = CastDoubleProtector.parseDouble(r140);     // Catch: Exception -> L175
    L177:
        r19 = Double.valueOf(r139);
    L175:
        e = move-exception;
        d6.a("ConvertHelper", e);
        goto L177
    L172:
        r140 = null;
        goto L235
    L178:
        Integer r22 = Integer.valueOf(r8);
        if (r22 != null) goto L182;
    L193:
        if (r22 != null) goto L196;
    L208:
        r19 = Double.valueOf(r139);
        goto L84
    L196:
        if (r22.intValue() != 2) goto L208;
        SharedPreferences r23 = this.b;
        if (r23 == null) goto L200;
        Long r141 = Long.valueOf(r23.getLong(r11, -100));
    L201:
        if (r141 == null) goto L207;
        r141.longValue();
        r139 = CastDoubleProtector.parseDouble(String.valueOf(r141.longValue()));     // Catch: Exception -> L205
    L205:
        e = move-exception;
        d6.a("ConvertHelper", e);
    L207:
        r19 = Double.valueOf(r139);
        goto L84
    L200:
        r141 = null;
        goto L201
    L182:
        if (r22.intValue() != 3) goto L193;
        SharedPreferences r24 = this.b;
        if (r24 == null) goto L186;
        String r142 = r24.getString(r11, null);
    L187:
        if (r142 != null) goto L228;
    L192:
        r19 = Double.valueOf(r139);
        goto L84
    L228:
        r139 = CastDoubleProtector.parseDouble(r142);     // Catch: Exception -> L190
    L190:
        e = move-exception;
        d6.a("ConvertHelper", e);
        goto L192
    L186:
        r142 = null;
        goto L187
    L210:
        SharedPreferences r25 = this.b;
        if (r25 == null) goto L213;
        String r143 = r25.getString(r11, null);
    L214:
        if (r143 == null) goto L218;
        r12 = (T) GsonProtectorUtils.fromJson(x60.b.a, r143, r13);
        goto L218
    L213:
        r143 = null;
        goto L214
    }

    public final boolean h(String r1, boolean r2, SharedPreferences.Editor r3) {
        if (r3 != null) goto L9;
        SharedPreferences.Editor r4 = c();
        if (r4 == null) goto L6;
        SharedPreferences.Editor r5 = r4.putBoolean(r1, r2);
    L13:
        return m(r5);
    L6:
        r5 = null;
        goto L13
    L9:
        if (r3.putBoolean(r1, r2) == null) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean i(String r1, int r2, SharedPreferences.Editor r3) {
        if (r3 != null) goto L9;
        SharedPreferences.Editor r4 = c();
        if (r4 == null) goto L6;
        SharedPreferences.Editor r5 = r4.putInt(r1, r2);
    L13:
        return m(r5);
    L6:
        r5 = null;
        goto L13
    L9:
        if (r3.putInt(r1, r2) == null) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean j(String r1, int r2, boolean r3) {
        f();
        if (r3 == false) goto L12;
        SharedPreferences r4 = this.c;
        if (r4 == null) goto L9;
        SharedPreferences.Editor r5 = r4.edit();
        if (r5 == null) goto L9;
        SharedPreferences.Editor r6 = r5.putInt(r1, r2);
    L11:
        return m(r6);
    L9:
        r6 = null;
        goto L11
    L12:
        if (r1 == null) goto L15;
        this.j.put(r1, Integer.valueOf(r2));
        return true;
    L15:
        return false;
    }

    public final boolean k(String r1, long r2, SharedPreferences.Editor r4) {
        if (r4 != null) goto L9;
        SharedPreferences.Editor r5 = c();
        if (r5 == null) goto L6;
        SharedPreferences.Editor r3 = r5.putLong(r1, r2);
    L13:
        return m(r3);
    L6:
        r3 = null;
        goto L13
    L9:
        if (r4.putLong(r1, r2) == null) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean l(String r1, String r2, SharedPreferences.Editor r3) {
        if (r3 != null) goto L9;
        SharedPreferences.Editor r4 = c();
        if (r4 == null) goto L6;
        SharedPreferences.Editor r5 = r4.putString(r1, r2);
    L13:
        return m(r5);
    L6:
        r5 = null;
        goto L13
    L9:
        if (r3.putString(r1, r2) == null) goto L11;
        return true;
    L11:
        return false;
    }
}
