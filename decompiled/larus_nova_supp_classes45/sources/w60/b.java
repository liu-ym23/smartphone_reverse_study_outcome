package w60;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import x60.c;
import y60.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements ICacheManger {
    public final d a;
    public final ConcurrentHashMap<String, Object> b;
    public final ConcurrentHashMap<String, Object> c;
    public final ConcurrentHashMap<String, Object> d;
    public final ConcurrentHashMap<String, Object> e;

    public final Map<String, Object> b() {
        y60.b r0 = this.a.a;
        r0.f();
        int r1 = c.a;
        if (wa1.d.c.b == false) goto L9;
        SharedPreferences r2 = r0.c;
        if (r2 == null) goto L8;
        Map<String, ?> r3 = r2.getAll();
        if (r3 == null) goto L8;
    L15:
        if (wa1.d.c.b == true) goto L17;
        return r3;
    L17:
        if (r3.isEmpty() == true) goto L19;
        return r3;
    L19:
        if (r0.h == true) goto L56;
        r0.h = true;
        SharedPreferences r4 = r0.b;
        if (r4 == null) goto L25;
        Map<String, ?> r5 = r4.getAll();
        if (r5 == null) goto L25;
    L26:
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> r7 = r5.entrySet().iterator();
    L27:
        SharedPreferences.Editor r8 = null;
        if (r7.hasNext() == false) goto L32;
        Map.Entry<String, ?> r9 = r7.next();
        if (StringsKt.startsWith$default(r9.getKey(), "__origin_Type__", false, 2, null) == false) goto L27;
        r6.put(r9.getKey(), r9.getValue());
        goto L27
    L32:
        SharedPreferences r11 = r0.c;
        if (r11 == null) goto L35;
        r8 = r11.edit();
    L35:
        if (r8 == null) goto L57;
        Iterator r12 = r6.entrySet().iterator();
    L38:
        if (r12.hasNext() == false) goto L42;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Object r15 = r13.getValue();
        if ((r15 instanceof Integer) == false) goto L38;
        r8.putInt(r14, ((Number) r15).intValue());
        goto L38
    L42:
        r8.apply();
        return r5;
    L57:
        return r5;
    L25:
        r5 = new HashMap();
        goto L26
    L56:
        return new HashMap();
    L8:
        r3 = new HashMap();
        goto L15
    L9:
        SharedPreferences r16 = r0.b;
        if (r16 == null) goto L13;
        r3 = r16.getAll();
        if (r3 != null) goto L15;
    L13:
        r3 = new HashMap();
        goto L15
    }

    public final Map<String, Object> c() {
        y60.b r0 = this.a.a;
        r0.f();
        SharedPreferences r1 = r0.b;
        if (r1 == null) goto L7;
        Map<String, ?> r2 = r1.getAll();
        if (r2 == null) goto L7;
        return r2;
    L7:
        return new HashMap();
    }

    public b() {
        this.a = new d();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        d r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "key");
        r1.a();
        y60.b r0 = r1.b;
        if (r0 == null) goto L13;
        r0.f();
        SharedPreferences r2 = r0.b;
        if (r2 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r2.contains(r4) != true) goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }

    public final void d(Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "keyCacheMap");
        y60.b r0 = this.a.a;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r9.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<String, ? extends Object> r2 = r11.next();
        boolean r6 = false;
        if (StringsKt.startsWith$default(r2.getKey(), "__origin_Type__", false, 2, null) == true) goto L8;
    L12:
        if (r6 == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L8:
        if (Intrinsics.areEqual(r2.getValue(), 4) == false) goto L10;
    L11:
        r6 = true;
        goto L12
    L10:
        if (Intrinsics.areEqual(r2.getValue(), 3) == false) goto L12;
    L14:
        r0.e = r1;
    }

    public final boolean e(ICacheManger.Operation r17, Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r17, "operation");
        Intrinsics.checkNotNullParameter(r18, "map");
        d r5 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r17, "operation");
        Intrinsics.checkNotNullParameter(r18, "map");
        r5.a();
        int r0 = y60.c.b[r17.ordinal()];
        boolean r3 = true;
        if (r0 == 1) goto L21;
        if (r0 != 2) goto L20;
        Iterator r1 = ((LinkedHashMap) r18).entrySet().iterator();
        int r6 = 0;
    L7:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r9 = (Map.Entry) r1.next();
        y60.b r11 = r5.b;
        if (r11 == null) goto L11;
        Boolean r12 = Boolean.valueOf(r11.g((String) r9.getKey()));
    L13:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L7;
        r6 = r6 + 1;
        goto L7
    L11:
        r12 = null;
        goto L13
    L15:
        a70.b.e("_MAIN", "SP minus： 本次Test总共数据条数：" + r18.size() + ", minus成功条数 " + r6);
        if (r6 != r18.size()) goto L85;
    L84:
        return true;
    L85:
        return false;
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        Iterator r2 = ((LinkedHashMap) r18).entrySet().iterator();
        int r13 = 0;
    L23:
        if (r2.hasNext() == false) goto L82;
        Map.Entry r14 = (Map.Entry) r2.next();
        y60.b r15 = r5.b;
        if (r15 == null) goto L77;
        String r16 = (String) r14.getKey();
        Object r19 = r14.getValue();
        r15.f();
        int r110 = c.a;
        boolean r111 = wa1.d.c.b;
        if ((r19 instanceof Boolean) == false) goto L37;
        r15.h(r16, ((Boolean) r19).booleanValue(), null);
        if (wa1.d.c.d == false) goto L33;
        if (r16 == null) goto L33;
        r15.k.put(r16, (Boolean) r19);
    L33:
        if (r111 == false) goto L35;
        boolean r112 = r15.j("__origin_Type__" + r16, 4, r3);
    L76:
        Boolean r4 = Boolean.valueOf(r112);
    L79:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L81;
        r13 = r13 + 1;
    L81:
        r3 = true;
        goto L23
    L35:
        r112 = r15.i("__origin_Type__" + r16, 4, null);
        goto L76
    L37:
        if ((r19 instanceof String) == false) goto L44;
        r15.l(r16, (String) r19, null);
        if (r111 == false) goto L41;
        r112 = r15.j("__origin_Type__" + r16, 3, r3);
        goto L76
    L41:
        boolean r7 = r15.i("__origin_Type__" + r16, 3, null);
    L42:
        r112 = r7;
        goto L76
    L44:
        if ((r19 instanceof Integer) == false) goto L50;
        r15.k(r16, ((Number) r19).intValue(), null);
        if (r111 == false) goto L48;
        r112 = r15.j("__origin_Type__" + r16, 2, true);
        goto L76
    L48:
        r7 = r15.i("__origin_Type__" + r16, 2, null);
        goto L42
    L50:
        if ((r19 instanceof Long) == false) goto L57;
        r15.k(r16, ((Number) r19).longValue(), null);
        if (r111 == false) goto L54;
        r112 = r15.j("__origin_Type__" + r16, 2, true);
        goto L76
    L54:
        r112 = r15.i("__origin_Type__" + r16, 2, null);
        goto L76
    L57:
        if ((r19 instanceof Float) == false) goto L63;
        r15.l(r16, r19.toString(), null);
        if (r111 == false) goto L61;
        r7 = r15.j("__origin_Type__" + r16, 3, true);
        goto L42
    L61:
        r7 = r15.i("__origin_Type__" + r16, 3, null);
        goto L42
    L63:
        if ((r19 instanceof LinkedTreeMap) == false) goto L70;
        r15.l(r16, GsonProtectorUtils.toJson(x60.b.a, r19), null);
        if (r111 == false) goto L67;
        r112 = r15.j("__origin_Type__" + r16, 0, true);
        goto L76
    L67:
        r112 = r15.i("__origin_Type__" + r16, 0, null);
        goto L76
    L70:
        if ((r19 instanceof ArrayList) == false) goto L75;
        r15.l(r16, GsonProtectorUtils.toJson(x60.b.a, r19), null);
        if (r111 == false) goto L74;
        r112 = r15.j("__origin_Type__" + r16, 1, true);
        goto L76
    L74:
        r112 = r15.i("__origin_Type__" + r16, 1, null);
        goto L76
    L75:
        r112 = r15.l(r16, GsonProtectorUtils.toJson(x60.b.a, r19), null);
        goto L76
    L77:
        r4 = null;
        goto L79
    L82:
        a70.b.e("_MAIN", "SP plus：本次Test总共数据条数：" + r18.size() + ", plus成功条数 " + r13);
        if (r13 != r18.size()) goto L85;
        goto L84
    }

    @Override // com.bytedance.android.live.core.setting.v2.cache.ICacheManger
    public boolean update(ICacheManger.CacheType r4, ICacheManger.Operation r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "operation");
        Intrinsics.checkNotNullParameter(r6, "map");
        int r7 = a.a[r4.ordinal()];
        if (r7 == 1) goto L55;
        if (r7 != 2) goto L7;
        int r8 = a.d[r5.ordinal()];
        if (r8 == 1) goto L50;
        if (r8 != 2) goto L49;
        this.c.putAll(r6);
        return true;
    L49:
        throw new NoWhenBranchMatchedException();
    L50:
        Iterator<Map.Entry<String, ? extends Object>> r9 = r6.entrySet().iterator();
    L52:
        if (r9.hasNext() == false) goto L67;
        Map.Entry<String, ? extends Object> r11 = r9.next();
        this.c.remove(r11.getKey());
        goto L52
    L67:
        return true;
    L7:
        if (r7 != 3) goto L9;
        int r12 = a.e[r5.ordinal()];
        if (r12 == 1) goto L40;
        if (r12 != 2) goto L39;
        this.b.putAll(r6);
        return true;
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        Iterator<Map.Entry<String, ? extends Object>> r13 = r6.entrySet().iterator();
    L42:
        if (r13.hasNext() == false) goto L66;
        Map.Entry<String, ? extends Object> r14 = r13.next();
        this.b.remove(r14.getKey());
        goto L42
    L66:
        return true;
    L9:
        if (r7 != 4) goto L11;
        int r15 = a.f[r5.ordinal()];
        if (r15 == 1) goto L30;
        if (r15 != 2) goto L29;
        this.d.putAll(r6);
        return true;
    L29:
        throw new NoWhenBranchMatchedException();
    L30:
        Iterator<Map.Entry<String, ? extends Object>> r16 = r6.entrySet().iterator();
    L32:
        if (r16.hasNext() == false) goto L65;
        Map.Entry<String, ? extends Object> r17 = r16.next();
        this.d.remove(r17.getKey());
        goto L32
    L65:
        return true;
    L11:
        if (r7 != 5) goto L23;
        int r18 = a.g[r5.ordinal()];
        if (r18 == 1) goto L18;
        if (r18 != 2) goto L17;
        this.e.putAll(r6);
        return true;
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        Iterator<Map.Entry<String, ? extends Object>> r19 = r6.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L64;
        Map.Entry<String, ? extends Object> r21 = r19.next();
        this.e.remove(r21.getKey());
        goto L20
    L64:
        return true;
    L23:
        throw new NoWhenBranchMatchedException();
    L55:
        return this.a.update(r5, r6);
    }
}
