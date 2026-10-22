package kotlinx.serialization.json;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\u0010\u0004\n\u0002\b\u0006\u001a\u0015\u00108\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010:\u001a\u0012\u00108\u001a\u00020'2\b\u00109\u001a\u0004\u0018\u00010;H\u0007\u001a\u0010\u00108\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010<\u001a\u0010\u00108\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\t\u001a\u0018\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0001\u001a\u0014\u0010@\u001a\u00020;*\u00020#2\u0006\u0010A\u001a\u00020\tH\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\r*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u0014*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0015\u0010\u001a\u001a\u00020\u001b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u001b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0015\u0010!\u001a\u00020\"*\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0015\u0010&\u001a\u00020'*\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0015\u0010*\u001a\u00020+*\u00020#8F¢\u0006\u0006\u001a\u0004\b,\u0010-\"\u0015\u0010.\u001a\u00020\u0002*\u00020#8F¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0015\u00101\u001a\u000202*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b3\u00104\"\u0017\u00105\u001a\u0004\u0018\u000102*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006B"}, d2 = {TypedValues.Custom.S_BOOLEAN, "", "Lkotlinx/serialization/json/JsonPrimitive;", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "booleanOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "contentOrNull", "", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "double", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "doubleOrNull", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", TypedValues.Custom.S_FLOAT, "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "floatOrNull", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "int", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "intOrNull", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonNull", "Lkotlinx/serialization/json/JsonNull;", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonPrimitive", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "long", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "longOrNull", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "JsonPrimitive", EventBody.KEY_VALUE, "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "", "", "unexpectedJson", "key", "expected", "error", "element", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final int a(r r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Integer.parseInt(r1.b());
    }

    private static final Void a(g r3, String r4) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(r3.getClass()) + " is not a " + r4);
    }

    public static final r a(String r3) {
        if (r3 != null) goto L7;
        Object r4 = ZeusTransformUtils.preCheckCast(n.f17858a, r.class, "com.obric.memorydata.plugin");
    L6:
        return (r) r4;
    L7:
        r4 = ZeusTransformUtils.preCheckCast(new k(r3, true), r.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static final r a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, r.class) == false) goto L5;
        r r0 = (r) ZeusTransformUtils.preCheckCast(r2, r.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        a(r2, "JsonPrimitive");
        throw new KotlinNothingValueException();
    L5:
        r0 = null;
        goto L6
    }

    public static final long b(r r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Long.parseLong(r2.b());
    }

    public static final double c(r r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Double.parseDouble(r2.b());
    }

    public static final float d(r r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Float.parseFloat(r1.b());
    }

    public static final Boolean e(r r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return kotlinx.serialization.json.internal.t.a(r1.b());
    }

    public static final String f(r r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L6;
        return null;
    L6:
        return r1.b();
    }
}
