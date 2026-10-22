package v60;

import a70.c;
import android.content.SharedPreferences;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w60.b;
import y60.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static Map c() {
        return SettingIncStrategy.a.c();
    }

    public static Object e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (StringsKt.startsWith$default(r4, "__origin_Type__", false, 2, null) == false) goto L6;
        return SettingIncStrategy.a.b().get(r4);
    L6:
        return c().get(r4);
    }

    public static Object g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        b r1 = SettingIncStrategy.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        d r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        r3.a();
        y60.b r0 = r3.b;
        if (r0 == null) goto L9;
        r0.f();
        SharedPreferences r4 = r0.b;
        if (r4 == null) goto L9;
        Map<String, ?> r5 = r4.getAll();
        if (r5 == null) goto L9;
        return r5.get(r2);
    L9:
        return null;
    }

    public static boolean a(String r2, ICacheManger.CacheType r3) {
        b r0 = SettingIncStrategy.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "valueCacheType");
        int r4 = w60.a.c[r3.ordinal()];
        if (r4 == 1) goto L15;
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L18;
        if (r4 == 4) goto L17;
        return false;
    L17:
        return r0.e.containsKey(r2);
    L18:
        return r0.d.containsKey(r2);
    L19:
        return r0.c.containsKey(r2);
    L15:
        return r0.b.containsKey(r2);
    }

    public static boolean b(String r2, boolean r3, Type r4) {
        Object r5 = j(r2, Boolean.valueOf(r3), r4, ICacheManger.CacheType.LOCAL_CACHE);
        if (r5 != null) goto L5;
        return r3;
    L5:
        if ((r5 instanceof Unit) == false) goto L8;
        Map<String, Long> r6 = a70.b.a;
        a70.b.d("SettingCacheV2 getBooleanError,value is kotlin.Unit,return defValue,key=" + r2 + ", defValue=" + r3);
        return r3;
    L8:
        return x60.a.a(r5, r3);
    }

    public static String f(String r1, String r2, Type r3) {
        Object r4 = j(r1, r2, r3, ICacheManger.CacheType.LOCAL_CACHE);
        if ((r4 instanceof String) == true) goto L9;
        if (r4 == null) goto L8;
        a70.b.e("_MAIN", "SettingCacheV2 getStringError, value is not String，key=" + r1 + ", value=" + r4);
        r2 = GsonProtectorUtils.toJson(x60.b.a, r4);
    L8:
        return r2;
    L9:
        return (String) r4;
    }

    public static Object h(String r4, Object r5, Type r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        b r1 = SettingIncStrategy.a;     // Catch: Exception -> L17
        Object r3 = null;
        if (r1.a(r4) == false) goto L16;
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Exception -> L17
        d r2 = r1.a;     // Catch: Exception -> L17
        r2.getClass();     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Exception -> L17
        r2.a();     // Catch: Exception -> L17
        y60.b r0 = r2.b;     // Catch: Exception -> L17
        if (r0 == null) goto L8;
        Object r7 = r0.e(r4, r5, r6);     // Catch: Exception -> L17
    L9:
        if ((r7 instanceof Object) == false) goto L13;
        r3 = r7;
    L13:
        if (r3 != null) goto L16;
        return r5;
    L8:
        r7 = null;
    L16:
        return r3;
    L17:
        e = move-exception;
        Map<String, Long> r8 = a70.b.a;
        a70.b.d("key = " + r4 + e.getLocalizedMessage());
        return r5;
    }

    public static Object i(String r4, Type r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r6 == true) goto L5;
    L11:
        ICacheManger.CacheType r7 = ICacheManger.CacheType.TRANSIENT;
        if (a(r4, r7) == false) goto L18;
        Object r8 = j(r4, null, r5, r7);
        if (r8 != null) goto L16;
        return null;
    L16:
        return x60.b.a(r8, r5);
    L18:
        if (c().containsKey(r4) == true) goto L20;
        return null;
    L20:
        Object r1 = c().get(r4);
        if (r1 == null) goto L24;
        a r0 = a;
        ICacheManger.Operation r2 = ICacheManger.Operation.PLUS;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put(r4, r1);
        Unit r9 = Unit.INSTANCE;
        r0.update(r7, r2, r3);
        return x60.b.a(r1, r5);
    L24:
        return null;
    L5:
        if (SettingIncStrategy.a.a(r4) == false) goto L11;
        Object r11 = h(r4, null, r5);
        a70.b.e("_TEST", "getValue 从test开始获取值，key=" + r4 + ", value = " + r11);
        if ((r11 instanceof Object) == true) goto L10;
        return null;
    L10:
        return r11;
    }

    public static boolean l(String r4, String r5, Type r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        b r7 = SettingIncStrategy.a;
        ICacheManger.Operation r8 = ICacheManger.Operation.MINUS;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(r4, "");
        Unit r9 = Unit.INSTANCE;
        return r7.e(r8, r1);
    L12:
        b r2 = SettingIncStrategy.a;
        ICacheManger.Operation r3 = ICacheManger.Operation.PLUS;
        LinkedHashMap r11 = new LinkedHashMap();
        if (Intrinsics.areEqual(r6, Boolean.class) == false) goto L15;
    L34:
        Object r12 = Boolean.valueOf(Boolean.parseBoolean(r5));
    L35:
        r11.put(r4, r12);
        Unit r13 = Unit.INSTANCE;
        return r2.e(r3, r11);
    L15:
        if (Intrinsics.areEqual(r6, Boolean.TYPE) == true) goto L34;
        if (Intrinsics.areEqual(r6, Integer.class) == false) goto L20;
    L33:
        r12 = Integer.valueOf(CastIntegerProtector.parseInt(r5));
        goto L35
    L20:
        if (Intrinsics.areEqual(r6, Integer.TYPE) == true) goto L33;
        if (Intrinsics.areEqual(r6, Float.class) == false) goto L25;
    L32:
        r12 = Float.valueOf(CastFloatProtector.parseFloat(r5));
        goto L35
    L25:
        if (Intrinsics.areEqual(r6, Float.TYPE) == true) goto L32;
        if (Intrinsics.areEqual(r6, Long.class) == true) goto L31;
        r12 = r5;
        if (Intrinsics.areEqual(r6, Long.TYPE) == false) goto L35;
    L31:
        r12 = Long.valueOf(CastLongProtector.parseLong(r5));
        goto L35
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    private final Object update(ICacheManger.CacheType r2, ICacheManger.Operation r3, Map<String, ? extends Object> r4) {
        b r0 = SettingIncStrategy.a;
        return Boolean.valueOf(SettingIncStrategy.a.update(r2, r3, r4));
    }

    public final <T> T d(String r5, T r6, Type r7) {
        ICacheManger.CacheType r0 = ICacheManger.CacheType.OBJECT;
        if (a(r5, r0) == false) goto L14;
        T r1 = (T) j(r5, r6, r7, r0);
        if ((r7 instanceof Class) == true) goto L7;
        Type r2 = null;
    L8:
        Class<?> r3 = (Class) r2;
        if (r3 == null) goto L14;
        if (r1 == null) goto L14;
        if (r1.getClass().isAssignableFrom(r3) == false) goto L14;
        return r1;
    L7:
        r2 = r7;
    L14:
        Object r8 = j(r5, r6, r7, ICacheManger.CacheType.LOCAL_CACHE);
        if (r8 == null) goto L18;
        r6 = (T) r8;
    L18:
        if (r6 != null) goto L20;
        ICacheManger.Operation r9 = ICacheManger.Operation.MINUS;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put(r5, "");
        Unit r11 = Unit.INSTANCE;
        update(r0, r9, r4);
    L21:
        return r6;
    L20:
        ICacheManger.Operation r12 = ICacheManger.Operation.PLUS;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put(r5, r6);
        Unit r14 = Unit.INSTANCE;
        update(r0, r12, r13);
        goto L21
    }

    public static Object j(String r3, Object r4, Type r5, ICacheManger.CacheType r6) {
        b r0 = SettingIncStrategy.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r6, "valueCacheType");
        int r7 = w60.a.b[r6.ordinal()];     // Catch: Exception -> L21
        if (r7 != 1) goto L6;
        d r8 = r0.a;     // Catch: Exception -> L21
        r8.getClass();     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Exception -> L21
        return r8.a.e(r3, r4, r5);
    L6:
        if (r7 == 2) goto L28;
        if (r7 == 3) goto L27;
        if (r7 == 4) goto L26;
        if (r7 != 5) goto L15;
        return r0.e.get(r3);
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L21
    L26:
        return r0.d.get(r3);
    L27:
        return r0.b.get(r3);
    L28:
        return r0.c.get(r3);
    L21:
        e = move-exception;
        a70.b.e("_MAIN", "CacheManger getValue exception，key=" + r3 + " , error info = " + e.getStackTrace());
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r10v54 */
    /* JADX WARN: Type inference failed for: r10v55 */
    /* JADX WARN: Type inference failed for: r10v56 */
    /* JADX WARN: Type inference failed for: r10v57 */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final <T> T k(String r6, T r7, Type r8, boolean r9, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Object r1 = null;
        if (r11 == true) goto L96;
    L8:
        if (r7 == 0) goto L10;
        if (r9 == false) goto L22;
        ICacheManger.CacheType r13 = ICacheManger.CacheType.STICKY;     // Catch: Exception -> L51
        if (a(r6, r13) == false) goto L22;
        Object r14 = j(r6, r7, r8, r13);     // Catch: Exception -> L51
        if ((r14 instanceof Object) == false) goto L18;
        r1 = r14;
    L18:
        if (r1 != null) goto L21;
        return r7;
    L21:
        return (T) r1;
    L22:
        if (r12 == false) goto L34;
        ICacheManger.CacheType r15 = ICacheManger.CacheType.PRELOAD_CACHE;     // Catch: Exception -> L51
        if (a(r6, r15) == false) goto L34;
        Object r16 = j(r6, r7, r8, r15);     // Catch: Exception -> L51
        if ((r16 instanceof Object) == false) goto L29;
        r1 = r16;
    L29:
        if (r1 != null) goto L32;
        return r7;
    L32:
        return (T) r1;
    L34:
        if (Intrinsics.areEqual(r8, Boolean.class) == false) goto L37;
        ?? r17 = Boolean.valueOf(b(r6, ((Boolean) r7).booleanValue(), r8));     // Catch: Exception -> L51
    L70:
        boolean r2 = r17 instanceof Object;     // Catch: Exception -> L51
        ?? r18 = r17;
        if (r2 == true) goto L73;
        r18 = 0;
    L73:
        if (r9 == false) goto L76;
        if (r18 == 0) goto L76;
        ICacheManger.CacheType r19 = ICacheManger.CacheType.STICKY;     // Catch: Exception -> L51
        ICacheManger.Operation r3 = ICacheManger.Operation.PLUS;     // Catch: Exception -> L51
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L51
        r4.put(r6, r18);     // Catch: Exception -> L51
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L51
        update(r19, r3, r4);     // Catch: Exception -> L51
    L76:
        if (r12 == false) goto L79;
        if (r18 == 0) goto L79;
        ICacheManger.CacheType r21 = ICacheManger.CacheType.PRELOAD_CACHE;     // Catch: Exception -> L51
        ICacheManger.Operation r110 = ICacheManger.Operation.PLUS;     // Catch: Exception -> L51
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Exception -> L51
        r22.put(r6, r18);     // Catch: Exception -> L51
        Unit r23 = Unit.INSTANCE;     // Catch: Exception -> L51
        update(r21, r110, r22);     // Catch: Exception -> L51
    L79:
        if (r18 != 0) goto L82;
        return r7;
    L82:
        return (T) r18;
    L37:
        if (Intrinsics.areEqual(r8, String.class) == false) goto L40;
        r17 = f(r6, (String) r7, r8);     // Catch: Exception -> L51
        goto L70
    L40:
        if (Intrinsics.areEqual(r8, Integer.class) == false) goto L54;
        Object r111 = j(r6, r7, r8, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        ?? r112 = r111;
        if (r111 != null) goto L45;
        r112 = r7;
    L45:
        if ((r112 instanceof Long) == true) goto L47;
        ?? r24 = 0;
    L48:
        Long r25 = (Long) r24;     // Catch: Exception -> L51
        r17 = r112;
        if (r25 == null) goto L70;
        r17 = Integer.valueOf((int) r25.longValue());     // Catch: Exception -> L51
        goto L70
    L47:
        r24 = r112;
        goto L48
    L54:
        if (Intrinsics.areEqual(r8, Float.class) == false) goto L65;
        Object r113 = j(r6, r7, r8, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        ?? r114 = r113;
        if (r113 != null) goto L58;
        r114 = r7;
    L58:
        String r115 = r114.toString();     // Catch: Exception -> L51
        float r26 = ((Float) r7).floatValue();     // Catch: Exception -> L51
        r26 = CastFloatProtector.parseFloat(r115);     // Catch: Exception -> L61
    L63:
        r17 = Float.valueOf(r26);     // Catch: Exception -> L51
        goto L70
    L61:
        e = move-exception;
        d6.a("ConvertHelper", e);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        d6.a("SettingCacheV2", e);
        int r116 = c.a;
        if (r8 == null) goto L86;
        String r27 = r8.toString();
    L87:
        if (r7 == 0) goto L89;
        String r117 = r7.toString();
    L90:
        Object r118 = e(r6);
        if (r118 == null) goto L93;
        String r119 = r118.toString();
    L94:
        String r28 = e.getMessage();
        JSONObject r29 = new JSONObject();
        r29.put("status_code", 1);
        r29.put("key", r6);
        JSONObject r0 = new JSONObject();
        r0.put("default_value", r117);
        r0.put("origin_value", r119);
        r0.put("type", r27);
        r0.put("msg", r28);
        d6.d("ttlive_setting_get_local_value_exception", r29, null, r0);
        a70.b.e("_SLADAR", "statusCode = 1, key = " + r6 + ", msg = " + r28 + ", origin_value=" + r119);
        return r7;
    L93:
        r119 = null;
        goto L94
    L89:
        r117 = null;
        goto L90
    L86:
        r27 = null;
        goto L87
    L65:
        if (Intrinsics.areEqual(r8, Long.class) == false) goto L69;
        Object r120 = j(r6, r7, r8, ICacheManger.CacheType.LOCAL_CACHE);     // Catch: Exception -> L51
        r17 = r120;
        if (r120 != null) goto L70;
        r17 = r7;
        goto L70
    L69:
        r17 = d(r6, r7, r8);     // Catch: Exception -> L51
        goto L70
    L10:
        return (T) i(r6, r8, r11);
    L96:
        if (SettingIncStrategy.a.a(r6) == false) goto L8;
        return (T) h(r6, r7, r8);
    }
}
