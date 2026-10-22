package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.ies.abmock.ConfigItem;
import com.bytedance.ies.abmock.SaveConfigType;
import com.bytedance.ies.abmock.datacenter.plugin.BaseConfigPlugin;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f2728a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonObject f2729b;
    private static a c;
    private static final CopyOnWriteArraySet<String> d = null;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.storage.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2730a = null;

        static {
            int[] r0 = new int[SaveConfigType.ConfigType.values().length];
            f2730a = r0;
            r0[SaveConfigType.ConfigType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f2730a[SaveConfigType.ConfigType.INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f2730a[SaveConfigType.ConfigType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f2730a[SaveConfigType.ConfigType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f2730a[SaveConfigType.ConfigType.FLOAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f2730a[SaveConfigType.ConfigType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f2730a[SaveConfigType.ConfigType.STRING_ARRAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f2730a[SaveConfigType.ConfigType.OBJECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public interface a {
        List<String> a();
    }

    static {
        d = new CopyOnWriteArraySet();
    }

    public static void a() {
        f2728a = true;     // Catch: Throwable -> L5
        i.f2723b.b("libra_config_center_saved", true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th);
    }

    public static void a(JsonObject r1, String r2) {
        JsonPrimitive r0 = null;
        JsonObject r3 = r1.getAsJsonObject(r2);     // Catch: Throwable -> L17
        if (r3 == null) goto L6;
        r0 = r3.getAsJsonPrimitive("val");     // Catch: Throwable -> L17
    L6:
        if (r0 != null) goto L8;
        a(r2);     // Catch: Throwable -> L17
        return;
    L8:
        if (r0.isBoolean() == false) goto L14;
        i r4 = i.f2723b;     // Catch: Throwable -> L17
        if (r0.getAsBoolean() == false) goto L12;
        int r5 = 1;
    L13:
        r4.b(r2, r5);     // Catch: Throwable -> L17
        return;
    L12:
        r5 = 0;
        goto L13
    L14:
        r4 = i.f2723b;     // Catch: Throwable -> L17
        r5 = r0.getAsInt();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r2);
    }

    private static void a(JsonObject r2, String r3, ConfigItem r4) {
        switch(AnonymousClass1.f2730a[r4.type.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        h(r2, r3);
    L13:
        if (r4.isLaunch == false) goto L16;
        i.f2723b.a(r3, r4.type);
        return;
    L16:
        return;
    L5:
        g(r2, r3);
        goto L13
    L6:
        c(r2, r3);
        goto L13
    L7:
        f(r2, r3);
        goto L13
    L8:
        e(r2, r3);
        goto L13
    L9:
        d(r2, r3);
        goto L13
    L10:
        a(r2, r3);
        goto L13
    L11:
        b(r2, r3);
        goto L13
    }

    public static void a(String r1) {
        i.f2723b.c(r1);
    }

    private static void a(List<String> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L10;
        d.addAll(r3);
        return;
    }

    public static boolean a(JsonObject r2, Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        f2729b = r2;
        c(r2, r4);
        d(r2, r4);
        b(r2, r4);
        a();
        return true;
    }

    public static JsonObject b(JsonObject r4, Set<String> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        JsonObject r7 = r4.deepCopy();
        Iterator<String> r8 = r7.keySet().iterator();
        Map<String, ConfigItem> r0 = com.bytedance.ies.abmock.c.a();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        if (r0.containsKey(r2) == false) goto L4;
        r8.remove();
        goto L4
    L10:
        p.f2737a.b(r7);
        if (n.d() == false) goto L15;
        return null;
    L15:
        return p.f2737a.a();
    }

    public static void b(JsonObject r1, String r2) {
        JsonPrimitive r0 = null;
        JsonObject r3 = r1.getAsJsonObject(r2);     // Catch: Throwable -> L17
        if (r3 == null) goto L6;
        r0 = r3.getAsJsonPrimitive("val");     // Catch: Throwable -> L17
    L6:
        if (r0 != null) goto L8;
        a(r2);     // Catch: Throwable -> L17
        return;
    L8:
        if (r0.isNumber() == false) goto L14;
        i r4 = i.f2723b;     // Catch: Throwable -> L17
        if (r0.getAsInt() == 0) goto L12;
        boolean r5 = true;
    L13:
        r4.b(r2, r5);     // Catch: Throwable -> L17
        return;
    L12:
        r5 = false;
        goto L13
    L14:
        r4 = i.f2723b;     // Catch: Throwable -> L17
        r5 = r0.getAsBoolean();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r2);
    }

    public static void c(JsonObject r3, String r4) {
        JsonObject r0 = r3.getAsJsonObject(r4);     // Catch: Throwable -> L15
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");     // Catch: Throwable -> L15
    L6:
        if (r1 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, JsonNull.class) == true) goto L11;
        i.f2723b.b(r4, r1.getAsString());     // Catch: Throwable -> L15
        return;
    L11:
        if (r3.has(r4) == false) goto L13;
        i.f2723b.b(r4, null);     // Catch: Throwable -> L15
        return;
    L13:
        a(r4);     // Catch: Throwable -> L15
        return;
    L5:
        r1 = null;
    L15:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r4);
    }

    private static void c(JsonObject r6, Set<String> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Map<String, ConfigItem> r0 = com.bytedance.ies.abmock.c.a();
        ArrayList r2 = new ArrayList();
        a r3 = c;
        if (r3 == null) goto L5;
        a(r3.a());
    L5:
        Iterator<Map.Entry<String, ConfigItem>> r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L14;
        if (r8.contains(r5) == false) goto L7;
    L14:
        if (d.contains(r5) == true) goto L15;
        a(r6, r5, (ConfigItem) ZeusTransformUtils.preCheckCast(r4.getValue(), ConfigItem.class, "com.obric.memorydata.plugin"));
        goto L7
    L15:
        r2.add(r4);
        goto L7
    L17:
        Iterator r9 = r2.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(r6, (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"), (ConfigItem) ZeusTransformUtils.preCheckCast(r10.getValue(), ConfigItem.class, "com.obric.memorydata.plugin"));
        goto L19
    }

    public static void d(JsonObject r2, String r3) {
        JsonElement r0 = null;
        JsonObject r4 = r2.getAsJsonObject(r3);     // Catch: Throwable -> L12
        if (r4 == null) goto L6;
        r0 = r4.get("val");     // Catch: Throwable -> L12
    L6:
        if (r0 != null) goto L8;
    L10:
        a(r3);     // Catch: Throwable -> L12
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, JsonNull.class) == true) goto L10;
        i.f2723b.b(r3, r0.getAsLong());     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r3);
    }

    private static void d(JsonObject r9, Set<String> r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Map<BaseConfigPlugin, Boolean> r0 = com.bytedance.ies.abmock.datacenter.plugin.a.a().b();
        Map<String, ConfigItem> r2 = com.bytedance.ies.abmock.c.a();
        Iterator<Map.Entry<BaseConfigPlugin, Boolean>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L35;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L4;
        Map<String, ConfigItem> r4 = ((BaseConfigPlugin) ZeusTransformUtils.preCheckCast(r3.getKey(), BaseConfigPlugin.class, "com.obric.memorydata.plugin")).getConfigMap();
        if (r4 == null) goto L4;
        Iterator<Map.Entry<String, ConfigItem>> r5 = r4.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L4;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        if (r2.containsKey(r7) == true) goto L12;
    L18:
        if (r11 == null) goto L23;
        if (r11.contains(r7) == false) goto L12;
    L23:
        switch(AnonymousClass1.f2730a[((ConfigItem) ZeusTransformUtils.preCheckCast(r6.getValue(), ConfigItem.class, "com.obric.memorydata.plugin")).type.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            default: goto L24;
        };
    L24:
        h(r9, r7);
    L33:
        if (((ConfigItem) ZeusTransformUtils.preCheckCast(r6.getValue(), ConfigItem.class, "com.obric.memorydata.plugin")).isLaunch == false) goto L12;
        i.f2723b.a(r7, ((ConfigItem) ZeusTransformUtils.preCheckCast(r6.getValue(), ConfigItem.class, "com.obric.memorydata.plugin")).type);
        goto L12
    L25:
        g(r9, r7);
        goto L33
    L26:
        c(r9, r7);
        goto L33
    L27:
        f(r9, r7);
        goto L33
    L28:
        e(r9, r7);
        goto L33
    L29:
        d(r9, r7);
        goto L33
    L30:
        a(r9, r7);
        goto L33
    L31:
        b(r9, r7);
        goto L33
    }

    public static void e(JsonObject r2, String r3) {
        JsonElement r0 = null;
        JsonObject r4 = r2.getAsJsonObject(r3);     // Catch: Throwable -> L12
        if (r4 == null) goto L6;
        r0 = r4.get("val");     // Catch: Throwable -> L12
    L6:
        if (r0 != null) goto L8;
    L10:
        a(r3);     // Catch: Throwable -> L12
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, JsonNull.class) == true) goto L10;
        i.f2723b.b(r3, r0.getAsDouble());     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r3);
    }

    public static void f(JsonObject r1, String r2) {
        JsonElement r0 = null;
        JsonObject r3 = r1.getAsJsonObject(r2);     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        r0 = r3.get("val");     // Catch: Throwable -> L12
    L6:
        if (r0 != null) goto L8;
    L10:
        a(r2);     // Catch: Throwable -> L12
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, JsonNull.class) == true) goto L10;
        i.f2723b.b(r2, r0.getAsFloat());     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r2);
    }

    public static void g(JsonObject r3, String r4) {
        JsonObject r0 = r3.getAsJsonObject(r4);     // Catch: Throwable -> L15
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");     // Catch: Throwable -> L15
    L6:
        if (r1 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, JsonNull.class) == true) goto L11;
        i.f2723b.a(r4, (String[]) ZeusTransformUtils.preCheckCast(i.f2723b.a().fromJson(r1, String[].class), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        return;
    L11:
        if (r3.has(r4) == false) goto L13;
        i.f2723b.a(r4, null);     // Catch: Throwable -> L15
        return;
    L13:
        a(r4);     // Catch: Throwable -> L15
        return;
    L5:
        r1 = null;
    L15:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r4);
    }

    public static void h(JsonObject r3, String r4) {
        JsonObject r0 = r3.getAsJsonObject(r4);     // Catch: Throwable -> L15
        if (r0 == null) goto L5;
        JsonElement r1 = r0.get("val");     // Catch: Throwable -> L15
    L6:
        if (r1 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, JsonNull.class) == true) goto L11;
        i.f2723b.b(r4, r1.toString());     // Catch: Throwable -> L15
        return;
    L11:
        if (r3.has(r4) == false) goto L13;
        i.f2723b.b(r4, null);     // Catch: Throwable -> L15
        return;
    L13:
        a(r4);     // Catch: Throwable -> L15
        return;
    L5:
        r1 = null;
    L15:
        th = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(th + "  , key: " + r4);
    }
}
