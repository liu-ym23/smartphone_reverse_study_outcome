package com.bytedance.ies.abmock.datacenter;

import com.bytedance.ies.abmock.SaveConfigType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/OverrideValuePool;", "", "()V", "needRefresh", "", "overrideValue", "", "", "Lcom/google/gson/JsonElement;", "providerInterceptors", "Ljava/util/LinkedList;", "Lcom/bytedance/ies/abmock/datacenter/IDataProviderInterceptor;", "addDataInterceptor", "", "interceptor", "getOverrideValue", "key", "configType", "Lcom/bytedance/ies/abmock/SaveConfigType$ConfigType;", "targetClass", "Ljava/lang/Class;", "notifyNeedRefresh", "refresh", "removeDataInterceptor", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, JsonElement> f2689b;
    private static final LinkedList<i> c = null;
    private static volatile boolean d;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2690a = null;

        static {
            int[] r0 = new int[SaveConfigType.ConfigType.values().length];
            r0[SaveConfigType.ConfigType.BOOLEAN.ordinal()] = 1;
            r0[SaveConfigType.ConfigType.INT.ordinal()] = 2;
            r0[SaveConfigType.ConfigType.LONG.ordinal()] = 3;
            r0[SaveConfigType.ConfigType.DOUBLE.ordinal()] = 4;
            r0[SaveConfigType.ConfigType.FLOAT.ordinal()] = 5;
            r0[SaveConfigType.ConfigType.STRING.ordinal()] = 6;
            r0[SaveConfigType.ConfigType.STRING_ARRAY.ordinal()] = 7;
            r0[SaveConfigType.ConfigType.OBJECT.ordinal()] = 8;
            f2690a = r0;
        }
    }

    static {
        f2688a = new j();
        f2689b = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = new LinkedList();
    }

    private j() {
    }

    private final JsonElement a(String r2) {
        if (d == false) goto L6;
        b();
        d = false;
    L6:
        return (JsonElement) ZeusTransformUtils.preCheckCast(f2689b.get(r2), JsonElement.class, "com.obric.memorydata.plugin");
    }

    private static final Object b(String r5, SaveConfigType.ConfigType r6, Class r7) {
        Intrinsics.checkNotNullParameter(r5, "$key");
        Intrinsics.checkNotNullParameter(r6, "$configType");
        JsonElement r0 = f2688a.a(r5);
        if (r0 != null) goto L5;
        return null;
    L5:
        boolean r2 = true;
        int r3 = 1;
        boolean r4 = false;
        switch(a.f2690a[r6.ordinal()]) {
            case 1: goto L45;
            case 2: goto L35;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L8;
            default: goto L66;
        };
    L8:
        JsonObject r8 = d.a().a(r5);
        JsonPrimitive r9 = r0.getAsJsonObject().getAsJsonPrimitive("_replace");
        if (r9 == null) goto L14;
        if (r9.isBoolean() == false) goto L14;
        r4 = r9.getAsBoolean();
    L14:
        if (r8 == null) goto L21;
        if (r4 == true) goto L21;
        Set<Map.Entry<String, JsonElement>> r1 = r0.getAsJsonObject().entrySet();
        Intrinsics.checkNotNullExpressionValue(r1, "jsonElement.asJsonObject.entrySet()");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.add((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(r11.getValue(), JsonElement.class, "com.obric.memorydata.plugin"));
    L22:
        JsonObject r12 = r8;
        if (r7 != null) goto L25;
        return r12;
    L25:
        if (Intrinsics.areEqual(r7, String[].class) == false) goto L27;
        return r12;
    L27:
        if (Intrinsics.areEqual(r0.getClass(), r7) == false) goto L59;
        return r12;
    L59:
        return d.a().f2674a.fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.memorydata.plugin"), r7);
    L21:
        r8 = r0.getAsJsonObject();
        goto L22
    L66:
        return null;
    L60:
        return com.bytedance.ies.abmock.datacenter.storage.a.f2706b.a().fromJson(r0, String[].class);
    L61:
        return r0.getAsString();
    L62:
        return Float.valueOf(r0.getAsFloat());
    L63:
        return Double.valueOf(r0.getAsDouble());
    L64:
        return Long.valueOf(r0.getAsLong());
    L35:
        if (r0.isJsonPrimitive() == true) goto L37;
    L42:
        r3 = r0.getAsInt();
    L65:
        return Integer.valueOf(r3);
    L37:
        if (r0.getAsJsonPrimitive().isBoolean() == false) goto L42;
        if (r0.getAsBoolean() == true) goto L65;
        r3 = 0;
        goto L65
    L45:
        if (r0.isJsonPrimitive() == true) goto L47;
    L52:
        r2 = r0.getAsBoolean();
    L54:
        return Boolean.valueOf(r2);
    L47:
        if (r0.getAsJsonPrimitive().isNumber() == false) goto L52;
        if (r0.getAsInt() != 0) goto L54;
        r2 = false;
        goto L54
    }

    private final void b() {
        LinkedList<i> r4 = c;
        if (r4.size() != 0) goto L5;
        return;
    L5:
        Map<String, JsonElement> r0 = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<i> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map<String, JsonElement> r1 = ((i) ZeusTransformUtils.preCheckCast(r5.next(), i.class, "com.obric.memorydata.plugin")).a();
        Intrinsics.checkNotNullExpressionValue(r1, "interceptor.allValue");
        r0.putAll(r1);
        goto L7
    L9:
        f2689b = r0;
    }

    /* JADX INFO: renamed from: lambda$AXNM-mkpS-CxGKtAMPklGfL0Vso, reason: not valid java name */
    public static /* synthetic */ Object m108lambda$AXNMmkpSCxGKtAMPklGfL0Vso(String r0, SaveConfigType.ConfigType r1, Class r2) {
        return b(r0, r1, r2);
    }

    public final Object a(final String r3, final SaveConfigType.ConfigType r4, final Class<?> r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "configType");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r2 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r0 = "getOverrideValue key: " + r3;
        return new $$Lambda$j$AXNMmkpSCxGKtAMPklGfL0Vso(r3, r4, r5).call();
    L5:
        th = move-exception;
        r2.a(new Throwable("cause: " + th + "--message: " + r0, th), "");
        return null;
    }

    public final void a() {
        if (c.size() != 0) goto L5;
        return;
    L5:
        d = true;
    }
}
