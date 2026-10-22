package com.bytedance.ies.abmock;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.ies.abmock.datacenter.storage.p;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fJ#\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u0002H\u001bH\u0002¢\u0006\u0002\u0010\u001cJI\u0010\u001d\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u0002H\u001b2#\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0006\u0012\u0004\u0018\u0001H\u001b0\u001fH\u0082\b¢\u0006\u0002\u0010#J'\u0010$\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u001b¢\u0006\u0002\u0010\u001cR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006%"}, d2 = {"Lcom/bytedance/ies/abmock/LibraABManager;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getBooleanValue", "", "key", "", "defaultValue", "getDoubleValue", "", "getIntValue", "", "getJsonValue", "Lcom/google/gson/JsonObject;", "getKey", "clazz", "Ljava/lang/Class;", "getLongValue", "", "getStringValue", "getUnregisteredValue", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "getExperimentValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "experimentKey", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getValueSafely", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f2743b = null;

    static {
        f2742a = new f();
        f2743b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(LibraABManager$gson$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private f() {
    }

    private final <T> T a(String r2, T r3) {
        T r1 = (T) p.f2737a.b(r2);
        if (ZeusTransformUtils.instanceOf(r1, JsonElement.class) == false) goto L24;
        com.bytedance.ies.abmock.datacenter.precise.c.f2698a.b(r2);
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L9;
        Object r4 = Boolean.valueOf(((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsBoolean());
    L23:
        return (T) ZeusTransformUtils.preCheckCast(r4, Object.class, "com.obric.memorydata.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L12;
        r4 = Integer.valueOf(((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsInt());
        goto L23
    L12:
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == false) goto L15;
        r4 = Long.valueOf(((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsLong());
        goto L23
    L15:
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L18;
        r4 = Double.valueOf(((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsDouble());
        goto L23
    L18:
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == false) goto L21;
        r4 = Float.valueOf(((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsFloat());
        goto L23
    L21:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L25;
        r4 = ((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin")).getAsString();
        goto L23
    L25:
        return r1;
    L24:
        return r3;
    }

    public final double a(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = Double.valueOf(r3);
        if (e.a(r2) == false) goto L6;
        r4 = Double.valueOf(TransformABManager.getInstance().getDoubleValue(r2));
    L9:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L6:
        if (p.f2737a.a(r2) == false) goto L9;
        r4 = a(r2, r4);
        goto L9
    }

    public final int a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = Integer.valueOf(r3);
        if (e.a(r2) == false) goto L6;
        r4 = Integer.valueOf(TransformABManager.getInstance().getIntValue(r2));
    L9:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
    L6:
        if (p.f2737a.a(r2) == false) goto L9;
        r4 = a(r2, r4);
        goto L9
    }

    public final long a(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = Long.valueOf(r3);
        if (e.a(r2) == false) goto L6;
        r4 = Long.valueOf(TransformABManager.getInstance().getLongValue(r2));
    L9:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
    L6:
        if (p.f2737a.a(r2) == false) goto L9;
        r4 = a(r2, r4);
        goto L9
    }

    public final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f2743b.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final JsonObject a(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        if (e.a(r2) == false) goto L12;
        Object r1 = TransformABManager.getInstance().getValue(r2);
        if (r1 == null) goto L7;
        Object r4 = f2742a.a().toJsonTree(r1).getAsJsonObject();
    L8:
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        return (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.memorydata.plugin");
    L7:
        r4 = r3;
        goto L8
    L12:
        if (p.f2737a.a(r2) == false) goto L15;
        r3 = a(r2, r3);
        goto L15
    }

    public final String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        if (e.a(r2) == false) goto L8;
        String r1 = TransformABManager.getInstance().getStringValue(r2);
        Object r4 = r3;
        if (r1 == null) goto L12;
        r4 = r1;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L8:
        r4 = r3;
        if (p.f2737a.a(r2) == false) goto L12;
        r4 = a(r2, r3);
        goto L12
    }

    public final boolean a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = Boolean.valueOf(r3);
        if (e.a(r2) == false) goto L6;
        r4 = Boolean.valueOf(TransformABManager.getInstance().getBooleanValue(r2));
    L9:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        if (p.f2737a.a(r2) == false) goto L9;
        r4 = a(r2, r4);
        goto L9
    }
}
