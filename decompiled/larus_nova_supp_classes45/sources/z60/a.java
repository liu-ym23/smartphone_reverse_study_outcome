package z60;

import android.content.SharedPreferences;
import android.os.Handler;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements c {

    /* JADX INFO: renamed from: z60.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"z60/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class C0298a extends TypeToken<HashMap<String, Object>> {
        public C0298a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"z60/a$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, Object>> {
        public b() {
        }
    }

    public a() {
    }

    public void a(Map<String, ? extends Object> r1, Map<String, ? extends Object> r2) {
    }

    public final boolean update(Map<String, ? extends Object> r9, Map<String, ? extends Object> r11) {
        a70.b.f("ColdStrategy_update_sp");
        a(r9, r11);
        LinkedHashMap r2 = null;
        if (r9 == null) goto L15;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r12 = r9.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r5 = r12.next();
        if (r5.getKey() != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
        r4.put(r5.getKey(), r5.getValue());
        goto L6
    L10:
        if (r5.getValue() == null) goto L12;
        r6 = true;
    L16:
        if (r11 == null) goto L28;
        r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r13 = r11.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L28;
        Map.Entry<String, ? extends Object> r14 = r13.next();
        if (r14.getKey() != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L19;
        r2.put(r14.getKey(), r14.getValue());
        goto L19
    L23:
        if (r14.getValue() == null) goto L25;
        r7 = true;
    L28:
        if (r4 == null) goto L30;
        boolean r15 = SettingIncStrategy.a.update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.MINUS, r4);
    L31:
        if (r2 == null) goto L33;
        boolean r16 = SettingIncStrategy.a.update(ICacheManger.CacheType.LOCAL_CACHE, ICacheManger.Operation.PLUS, r2);
    L34:
        a70.b.a("ColdStrategy_update_sp");
        a70.b.f("ColdStrategy_clear_not_sp_cache");
        if (r2 == null) goto L37;
        w60.b r8 = SettingIncStrategy.a;
        ICacheManger.CacheType r17 = ICacheManger.CacheType.OBJECT;
        ICacheManger.Operation r18 = ICacheManger.Operation.MINUS;
        r8.update(r17, r18, r2);
        r8.update(ICacheManger.CacheType.TRANSIENT, r18, r2);
        r8.update(ICacheManger.CacheType.PRELOAD_CACHE, r18, r2);
    L37:
        if (r4 == null) goto L39;
        w60.b r3 = SettingIncStrategy.a;
        ICacheManger.CacheType r19 = ICacheManger.CacheType.OBJECT;
        ICacheManger.Operation r21 = ICacheManger.Operation.MINUS;
        r3.update(r19, r21, r4);
        r3.update(ICacheManger.CacheType.TRANSIENT, r21, r4);
        r3.update(ICacheManger.CacheType.PRELOAD_CACHE, r21, r4);
    L39:
        a70.b.a("ColdStrategy_clear_not_sp_cache");
        if (r16 == false) goto L43;
        if (r15 == false) goto L43;
        return true;
    L43:
        return false;
    L33:
        r16 = true;
        goto L34
    L30:
        r15 = true;
        goto L31
    L15:
        r4 = null;
        goto L16
    }

    @Override // z60.c
    public boolean update(JsonObject r6, JsonObject r7, c70.a r8) {
        a70.b.f("ColdStrategy_gson");
        String r0 = null;
        if (r7 == null) goto L7;
        JsonElement r1 = r7.get("setting_update_mode");
        if (r1 == null) goto L7;
        String r2 = r1.getAsString();
    L8:
        boolean r3 = Intrinsics.areEqual(r2, "full");
        if (r3 == false) goto L27;
        w60.b r4 = SettingIncStrategy.a;
        r4.b.clear();
        r4.d.clear();
        r4.e.clear();
        y60.d r5 = r4.a;
        r5.c = false;
        r5.g = false;
        Handler r9 = r5.e;
        if (r9 == null) goto L13;
        r9.removeCallbacks(r5.h);
    L13:
        r5.d = null;
        y60.b r11 = r5.a;
        r11.f();
        int r12 = x60.c.a;
        if (wa1.d.c.b == false) goto L22;
        SharedPreferences r13 = r11.c;
        if (r13 == null) goto L22;
        SharedPreferences.Editor r14 = r13.edit();
        if (r14 == null) goto L22;
        SharedPreferences.Editor r15 = r14.clear();
        if (r15 == null) goto L22;
        r15.commit();
    L22:
        SharedPreferences.Editor r16 = r11.c();
        if (r16 == null) goto L27;
        SharedPreferences.Editor r17 = r16.clear();
        if (r17 == null) goto L27;
        r17.commit();
    L27:
        Map<String, ? extends Object> r18 = new LinkedHashMap();
        Map<String, ? extends Object> r19 = new LinkedHashMap();
        if (r6 == null) goto L30;
        r18 = (Map) GsonProtectorUtils.fromJson(x60.b.a, r6.toString(), new C0298a().getType());
        r18.remove("_setting_extra");
    L30:
        if (r7 == null) goto L36;
        JsonObject r21 = r7.getAsJsonObject("to_delete_keys");
        if (r21 == null) goto L34;
        r0 = r21.toString();
    L34:
        if (r0 == null) goto L36;
        r19 = (Map) GsonProtectorUtils.fromJson(x60.b.a, r0, new b().getType());
    L36:
        a70.b.a("ColdStrategy_gson");
        boolean r22 = update(r19, r18);
        b(r22, r3, r19, r18);
        return r22;
    L7:
        r2 = null;
        goto L8
    }

    public void b(boolean r9, boolean r11, Map<String, ? extends Object> r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "deleteMap");
        Intrinsics.checkNotNullParameter(r13, "updateOrAdd");
        int r1 = !r9 ? 1 : 0;
        if (r11 == false) goto L5;
        String r14 = "full";
    L6:
        a70.c.a(r1, r14, "clod", a70.b.b(), r13.size(), r12.size(), "update数据");
        return;
    L5:
        r14 = "incr";
        goto L6
    }
}
