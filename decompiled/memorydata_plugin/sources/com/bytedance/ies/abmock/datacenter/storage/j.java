package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.ies.abmock.ConfigItem;
import com.bytedance.ies.abmock.SaveConfigType;
import com.bytedance.ies.abmock.datacenter.plugin.BaseConfigPlugin;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2725a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JsonObject f2726b;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.storage.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2727a = null;

        static {
            int[] r0 = new int[SaveConfigType.ConfigType.values().length];
            f2727a = r0;
            r0[SaveConfigType.ConfigType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f2727a[SaveConfigType.ConfigType.INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f2727a[SaveConfigType.ConfigType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f2727a[SaveConfigType.ConfigType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f2727a[SaveConfigType.ConfigType.FLOAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f2727a[SaveConfigType.ConfigType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f2727a[SaveConfigType.ConfigType.STRING_ARRAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f2727a[SaveConfigType.ConfigType.OBJECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
    }

    public static void a() {
        if (f2726b == null) goto L6;
        b(f2726b);
        return;
    }

    public static void a(JsonObject r5) {
        JsonObject r6 = r5.deepCopy();
        Iterator<String> r0 = r6.keySet().iterator();
        Map<String, ConfigItem> r1 = com.bytedance.ies.abmock.c.a();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (r1.containsKey(r2) == false) goto L4;
        r0.remove();
        goto L4
    L10:
        p.f2737a.a(r6);
    }

    private static void a(JsonObject r3, String r4) {
        JsonPrimitive r5 = r3.getAsJsonPrimitive(r4);     // Catch: Throwable -> L14
        if (r5 != null) goto L5;
        a.f2706b.d(r4);     // Catch: Throwable -> L14
        return;
    L5:
        if (r5.isBoolean() == false) goto L11;
        a r0 = a.f2706b;     // Catch: Throwable -> L14
        if (r5.getAsBoolean() == false) goto L9;
        int r6 = 1;
    L10:
        r0.b(r4, r6);     // Catch: Throwable -> L14
        return;
    L9:
        r6 = 0;
        goto L10
    L11:
        r0 = a.f2706b;     // Catch: Throwable -> L14
        r6 = r5.getAsInt();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void b(JsonObject r8) {
        Map<BaseConfigPlugin, Boolean> r0 = com.bytedance.ies.abmock.datacenter.plugin.a.a().b();
        Map<String, ConfigItem> r1 = com.bytedance.ies.abmock.c.a();
        Iterator<Map.Entry<BaseConfigPlugin, Boolean>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L28;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L4;
        Map<String, ConfigItem> r4 = ((BaseConfigPlugin) ZeusTransformUtils.preCheckCast(r3.getKey(), BaseConfigPlugin.class, "com.obric.memorydata.plugin")).getConfigMap();
        if (r4 == null) goto L4;
        Iterator<Map.Entry<String, ConfigItem>> r5 = r4.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L4;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L19;
        if (r1.containsKey(r7) == true) goto L12;
    L19:
        switch(AnonymousClass1.f2727a[((ConfigItem) ZeusTransformUtils.preCheckCast(r6.getValue(), ConfigItem.class, "com.obric.memorydata.plugin")).type.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            default: goto L20;
        };
    L21:
        g(r8, r7);
        goto L12
    L22:
        c(r8, r7);
        goto L12
    L23:
        f(r8, r7);
        goto L12
    L24:
        e(r8, r7);
        goto L12
    L25:
        d(r8, r7);
        goto L12
    L26:
        a(r8, r7);
        goto L12
    L27:
        b(r8, r7);
        goto L12
    L20:
        h(r8, r7);
        goto L12
    }

    private static void b(JsonObject r3, String r4) {
        JsonPrimitive r5 = r3.getAsJsonPrimitive(r4);     // Catch: Throwable -> L14
        if (r5 != null) goto L5;
        a.f2706b.d(r4);     // Catch: Throwable -> L14
        return;
    L5:
        if (r5.isNumber() == false) goto L11;
        a r0 = a.f2706b;     // Catch: Throwable -> L14
        if (r5.getAsInt() == 0) goto L9;
        boolean r6 = true;
    L10:
        r0.b(r4, r6);     // Catch: Throwable -> L14
        return;
    L9:
        r6 = false;
        goto L10
    L11:
        r0 = a.f2706b;     // Catch: Throwable -> L14
        r6 = r5.getAsBoolean();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    public static boolean b() {
        return f2725a;
    }

    private static void c(JsonObject r3, String r4) {
        JsonElement r0 = r3.get(r4);     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        a.f2706b.b(r4, r0.getAsString());     // Catch: Throwable -> L10
    L13:
        return;
    L6:
        if (r3.has(r4) == false) goto L8;
        a.f2706b.b(r4, null);     // Catch: Throwable -> L10
        goto L13
    L8:
        a.f2706b.d(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void d(JsonObject r3, String r4) {
        JsonElement r5 = r3.get(r4);     // Catch: Throwable -> L7
        if (r5 == null) goto L5;
        a.f2706b.b(r4, r5.getAsLong());     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        a.f2706b.d(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void e(JsonObject r3, String r4) {
        JsonElement r5 = r3.get(r4);     // Catch: Throwable -> L7
        if (r5 == null) goto L5;
        a.f2706b.b(r4, r5.getAsDouble());     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        a.f2706b.d(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void f(JsonObject r3, String r4) {
        JsonElement r5 = r3.get(r4);     // Catch: Throwable -> L7
        if (r5 == null) goto L5;
        a.f2706b.b(r4, r5.getAsFloat());     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        a.f2706b.d(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void g(JsonObject r3, String r4) {
        JsonElement r0 = r3.get(r4);     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        a.f2706b.a(r4, (String[]) ZeusTransformUtils.preCheckCast(a.f2706b.a().fromJson(r0, String[].class), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L13:
        return;
    L6:
        if (r3.has(r4) == false) goto L8;
        a.f2706b.a(r4, null);     // Catch: Throwable -> L10
        goto L13
    L8:
        a.f2706b.d(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }

    private static void h(JsonObject r3, String r4) {
        JsonElement r0 = r3.get(r4);     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        a.f2706b.b(r4, r0.toString());     // Catch: Throwable -> L10
    L13:
        return;
    L6:
        if (r3.has(r4) == false) goto L8;
        a.f2706b.b(r4, null);     // Catch: Throwable -> L10
        goto L13
    L8:
        a.f2706b.d(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.ies.abmock.datacenter.event.a.a(new Throwable(th + ": key:" + r4, th), "SaveConfigValue");
    }
}
