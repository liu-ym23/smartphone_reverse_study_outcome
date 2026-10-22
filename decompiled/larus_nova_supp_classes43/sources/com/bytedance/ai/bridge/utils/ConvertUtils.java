package com.bytedance.ai.bridge.utils;

import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import s4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u000bH\u0007J\f\u0010\f\u001a\u00020\r*\u00020\tH\u0007J\f\u0010\f\u001a\u00020\u000e*\u00020\u000fH\u0007J\f\u0010\u0010\u001a\u00020\u0011*\u00020\rH\u0007J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u000eH\u0007J\f\u0010\u0014\u001a\u00020\u0015*\u00020\rH\u0007J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u000eH\u0007J\u0016\u0010\u0018\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0019J\f\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u001bJ\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0006\u0010\u001d\u001a\u00020\tJ\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u001f\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010!H\u0007J\u001e\u0010\"\u001a\u00020\u00112\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0007J\u001e\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0006\u0010,\u001a\u00020\u0011H\u0007J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010!2\u0006\u0010/\u001a\u00020\u0013H\u0003J\u0010\u00100\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0013H\u0003J\u000e\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020*J\u0012\u00103\u001a\u00020\u00132\n\u00104\u001a\u0006\u0012\u0002\b\u00030!J\u0016\u00105\u001a\u00020\u00112\u000e\u0010,\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0019J\u0010\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020'H\u0002J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/ai/bridge/utils/ConvertUtils;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "forEachKey", "", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "block", "Lkotlin/Function1;", "toJson", "Lcom/google/gson/JsonObject;", "Lcom/google/gson/JsonArray;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;", "toJavaOnlyMap", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "toJavaOnlyArray", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "toReactLynxJavaOnlyMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", "toReactLynxJavaOnlyArray", "Lcom/lynx/react/bridge/JavaOnlyArray;", "mapToReadableMap", "", "getValue", "Lcom/bytedance/vmsdk/jsbridge/utils/Dynamic;", "readableToMap", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "readableToStringMap", "convertArrayToJavaOnlyArray", "sourceArray", "", "convertMapToJavaOnlyMap", "source", "convertJsonToJavaOnlyArray", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableArray;", "jsonArray", "Lorg/json/JSONArray;", "convertJsonToJavaOnlyMap", "jsonObject", "Lorg/json/JSONObject;", "convertJavaOnlyMapToJson", "map", "convertJavaOnlyMapToMap", "convertJavaOnlyArrayToList", "array", "convertJavaOnlyArrayToJson", "convertJSONObject2JavaOnlyMap", "obj", "convertList2JavaOnlyArray", com.bytedance.android.ec.core.event.a.KEY_LIST, "convertMap2JavaOnlyMap", "convertJSONArray2JavaOnlyArray", "arrays", "getNumber", "", "rawNumber", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = null;
    private static final String TAG = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    private ConvertUtils() {
    }

    public static /* synthetic */ Unit a(ReadableMap r0, JsonObject r1, String r10) {
        return toJson$lambda$2$lambda$1(r0, r1, r10);
    }

    static {
        ConvertUtils r0 = new ConvertUtils();
        INSTANCE = r0;
        TAG = r0.getClass().getSimpleName();
    }

    @JvmStatic
    public static final JavaOnlyArray convertArrayToJavaOnlyArray(List<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "sourceArray");
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L32;
        Object r12 = ListProtector.get(r10, r11);
        if ((r12 instanceof Map) == false) goto L9;
        r0.pushMap(convertMapToJavaOnlyMap((Map) r12));     // Catch: Exception -> L33
    L31:
        r11 = r11 + 1;
        goto L3
    L9:
        if ((r12 instanceof List) == false) goto L13;
        r0.pushArray(convertArrayToJavaOnlyArray((List) r12));     // Catch: Exception -> L33
        goto L31
    L13:
        if ((r12 instanceof Boolean) == false) goto L16;
        r0.pushBoolean(((Boolean) r12).booleanValue());
        goto L31
    L16:
        if ((r12 instanceof Integer) == false) goto L19;
        r0.pushInt(((Number) r12).intValue());
        goto L31
    L19:
        if ((r12 instanceof Long) == false) goto L22;
        r0.pushDouble(((Number) r12).longValue());
        goto L31
    L22:
        if ((r12 instanceof Float) == false) goto L25;
        r0.pushDouble(((Number) r12).floatValue());
        goto L31
    L25:
        if ((r12 instanceof Double) == false) goto L28;
        r0.pushDouble(((Number) r12).doubleValue());
        goto L31
    L28:
        if ((r12 instanceof String) == false) goto L30;
        r0.pushString((String) r12);
        goto L31
    L30:
        r0.pushString(r12.toString());
        goto L31
    L32:
        return r0;
    }

    private final JavaOnlyArray convertJSONArray2JavaOnlyArray(JSONArray r10) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L12;
        Object r12 = r10.opt(r11);
        if ((r12 instanceof JSONArray) == false) goto L8;
        r0.add(convertJSONArray2JavaOnlyArray((JSONArray) r12));
    L11:
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof JSONObject) == false) goto L10;
        r0.add(convertJSONObject2JavaOnlyMap((JSONObject) r12));
        goto L11
    L10:
        r0.add(r12);
        goto L11
    L12:
        return r0;
    }

    @JvmStatic
    private static final JSONArray convertJavaOnlyArrayToJson(JavaOnlyArray r10) {
        JSONArray r0 = new JSONArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L23;
        Object r12 = r10.get(r11);
        ReadableType r13 = r10.getType(r11);     // Catch: Throwable -> L20
        if (r13 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 5) goto L12;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        r0.put(INSTANCE.getNumber((Number) r12));     // Catch: Throwable -> L20
    L22:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r14 != 7) goto L14;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L20
        r0.put(convertJavaOnlyMapToJson((JavaOnlyMap) r12));     // Catch: Throwable -> L20
        goto L22
    L14:
        if (r14 == 8) goto L16;
        r0.put(r12);     // Catch: Throwable -> L20
        goto L22
    L16:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L20
        r0.put(convertJavaOnlyArrayToJson((JavaOnlyArray) r12));     // Catch: Throwable -> L20
        goto L22
    L8:
        r14 = a.a[r13.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        g.a.e(TAG, "revertJavaOnlyArray2JSONArray " + th);
        Unit r15 = Unit.INSTANCE;
        goto L22
    L23:
        return r0;
    }

    @JvmStatic
    private static final List<Object> convertJavaOnlyArrayToList(JavaOnlyArray r10) {
        ArrayList r0 = new ArrayList();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L23;
        Object r12 = r10.get(r11);
        ReadableType r13 = r10.getType(r11);     // Catch: Throwable -> L20
        if (r13 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 5) goto L12;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        r0.add(INSTANCE.getNumber((Number) r12));     // Catch: Throwable -> L20
    L22:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r14 != 7) goto L14;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L20
        r0.add(convertJavaOnlyMapToMap((JavaOnlyMap) r12));     // Catch: Throwable -> L20
        goto L22
    L14:
        if (r14 == 8) goto L16;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        r0.add(r12);     // Catch: Throwable -> L20
        goto L22
    L16:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L20
        r0.add(convertJavaOnlyArrayToList((JavaOnlyArray) r12));     // Catch: Throwable -> L20
        goto L22
    L8:
        r14 = a.a[r13.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        g.a.e(TAG, "convertJavaOnlyArrayToList " + th);
        Unit r15 = Unit.INSTANCE;
        goto L22
    L23:
        return r0;
    }

    @JvmStatic
    public static final JSONObject convertJavaOnlyMapToJson(JavaOnlyMap r10) {
        JSONObject r0 = new JSONObject();
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r0;
    L11:
        ReadableMapKeySetIterator r11 = r10.keySetIterator();
    L13:
        if (r11.hasNextKey() == false) goto L32;
        String r12 = r11.nextKey();
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L30
        if (r14 != null) goto L18;
        int r15 = -1;
    L20:
        if (r15 != 5) goto L22;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L30
        r0.put(r12, INSTANCE.getNumber((Number) r13));     // Catch: Throwable -> L30
        goto L13
    L22:
        if (r15 != 7) goto L24;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L30
        r0.putOpt(r12, convertJavaOnlyMapToJson((JavaOnlyMap) r13));     // Catch: Throwable -> L30
        goto L13
    L24:
        if (r15 != 8) goto L25;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L30
        r0.putOpt(r12, convertJavaOnlyArrayToJson((JavaOnlyArray) r13));     // Catch: Throwable -> L30
        goto L13
    L25:
        r0.putOpt(r12, r13);     // Catch: Throwable -> L30
        goto L13
    L18:
        r15 = a.a[r14.ordinal()];     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        g.a.e(TAG, "revertJavaOnlyMap2JSONObject " + th);
        goto L13
    L32:
        return r0;
    L5:
        if (r10.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final Map<String, Object> convertJavaOnlyMapToMap(JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10.isEmpty() == false) goto L5;
        return r0;
    L5:
        ReadableMapKeySetIterator r1 = r10.keySetIterator();
    L7:
        if (r1.hasNextKey() == false) goto L26;
        String r11 = r1.nextKey();
        Object r12 = r10.get(r11);
        ReadableType r13 = r10.getType(r11);     // Catch: Throwable -> L24
        if (r13 != null) goto L12;
        int r14 = -1;
    L14:
        if (r14 != 5) goto L16;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L24
        r0.put(r11, INSTANCE.getNumber((Number) r12));     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r14 != 7) goto L18;
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L24
        r0.put(r11, convertJavaOnlyMapToMap((JavaOnlyMap) r12));     // Catch: Throwable -> L24
        goto L7
    L18:
        if (r14 != 8) goto L19;
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L24
        r0.put(r11, convertJavaOnlyArrayToList((JavaOnlyArray) r12));     // Catch: Throwable -> L24
        goto L7
    L19:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L24
        r0.put(r11, r12);     // Catch: Throwable -> L24
        goto L7
    L12:
        r14 = a.a[r13.ordinal()];     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        g.a.e(TAG, "convertJavaOnlyMapToMap " + th);
        goto L7
    L26:
        return r0;
    }

    @JvmStatic
    public static final WritableArray convertJsonToJavaOnlyArray(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonArray");
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L30;
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == false) goto L8;
        r0.pushMap(convertJsonToJavaOnlyMap((JSONObject) r12));
    L29:
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof JSONArray) == false) goto L11;
        r0.pushArray(convertJsonToJavaOnlyArray((JSONArray) r12));
        goto L29
    L11:
        if ((r12 instanceof Boolean) == false) goto L14;
        r0.pushBoolean(((Boolean) r12).booleanValue());
        goto L29
    L14:
        if ((r12 instanceof Integer) == false) goto L17;
        r0.pushInt(((Number) r12).intValue());
        goto L29
    L17:
        if ((r12 instanceof Long) == false) goto L20;
        r0.pushDouble(((Number) r12).longValue());
        goto L29
    L20:
        if ((r12 instanceof Float) == false) goto L23;
        r0.pushDouble(((Number) r12).floatValue());
        goto L29
    L23:
        if ((r12 instanceof Double) == false) goto L26;
        r0.pushDouble(((Number) r12).doubleValue());
        goto L29
    L26:
        if ((r12 instanceof String) == false) goto L28;
        r0.pushString((String) r12);
        goto L29
    L28:
        r0.pushString(r12.toString());
        goto L29
    L30:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyMap convertJsonToJavaOnlyMap(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L33;
        String r11 = r1.next();
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == true) goto L10;
        if ((r12 instanceof JSONArray) == true) goto L13;
        if ((r12 instanceof Boolean) == true) goto L16;
        if ((r12 instanceof Integer) == true) goto L19;
        if ((r12 instanceof Long) == true) goto L22;
        if ((r12 instanceof Float) == true) goto L25;
        if ((r12 instanceof Double) == true) goto L28;
        if ((r12 instanceof String) == true) goto L31;
        r0.putString(r11, r12.toString());
        goto L4
    L31:
        r0.putString(r11, (String) r12);
        goto L4
    L28:
        r0.putDouble(r11, ((Number) r12).doubleValue());
        goto L4
    L25:
        r0.putDouble(r11, ((Number) r12).floatValue());
        goto L4
    L22:
        r0.putDouble(r11, ((Number) r12).longValue());
        goto L4
    L19:
        r0.putInt(r11, ((Number) r12).intValue());
        goto L4
    L16:
        r0.putBoolean(r11, ((Boolean) r12).booleanValue());
        goto L4
    L13:
        r0.putArray(r11, convertJsonToJavaOnlyArray((JSONArray) r12));
        goto L4
    L10:
        r0.putMap(r11, null);
        goto L4
    L7:
        r0.putMap(r11, convertJsonToJavaOnlyMap((JSONObject) r12));
        goto L4
    L33:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyMap convertMapToJavaOnlyMap(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L44;
        Map.Entry<String, ? extends Object> r1 = r11.next();
        String r12 = r1.getKey();
        Object r13 = r1.getValue();
        if ((r13 instanceof Map) == false) goto L11;
        r0.putMap(r12, convertMapToJavaOnlyMap((Map) r13));     // Catch: Exception -> L9
        goto L4
    L11:
        if ((r13 instanceof List) == true) goto L12;
        if ((r13 instanceof Boolean) == true) goto L16;
        if ((r13 instanceof Integer) == true) goto L19;
        if ((r13 instanceof Long) == true) goto L22;
        if ((r13 instanceof Float) == true) goto L25;
        if ((r13 instanceof Double) == true) goto L28;
        if ((r13 instanceof String) == true) goto L31;
        if ((r13 instanceof JSONObject) == true) goto L34;
        if ((r13 instanceof JSONArray) == true) goto L37;
        if (r13 == null) goto L43;
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == true) goto L43;
        r0.putString(r12, r13.toString());
    L43:
        r0.putNull(r12);
        goto L4
    L37:
        r0.putArray(r12, convertJsonToJavaOnlyArray((JSONArray) r13));
        goto L4
    L34:
        r0.putMap(r12, convertJsonToJavaOnlyMap((JSONObject) r13));
        goto L4
    L31:
        r0.putString(r12, (String) r13);
        goto L4
    L28:
        r0.putDouble(r12, ((Number) r13).doubleValue());
        goto L4
    L25:
        r0.putDouble(r12, ((Number) r13).floatValue());
        goto L4
    L22:
        r0.putDouble(r12, ((Number) r13).longValue());
        goto L4
    L19:
        r0.putInt(r12, ((Number) r13).intValue());
        goto L4
    L16:
        r0.putBoolean(r12, ((Boolean) r13).booleanValue());
        goto L4
    L12:
        r0.putArray(r12, convertArrayToJavaOnlyArray((List) r13));     // Catch: Exception -> L9
        goto L4
    L44:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyArray toJavaOnlyArray(JsonArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonPrimitive r1 = (JsonElement) r11.next();
        if ((r1 instanceof JsonNull) == true) goto L7;
        if ((r1 instanceof JsonObject) == true) goto L10;
        if ((r1 instanceof JsonArray) == true) goto L13;
        if ((r1 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r12 = r1;
        if (r12.isBoolean() == true) goto L18;
        if (r12.isString() == true) goto L21;
        if (r12.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r12.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.add(Long.valueOf(r12.getAsNumber().longValue()));
        goto L4
    L26:
        r0.add(Double.valueOf(r12.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.add(r12.getAsString());
        goto L4
    L18:
        r0.add(Boolean.valueOf(r12.getAsBoolean()));
        goto L4
    L13:
        r0.add(toJavaOnlyArray((JsonArray) r1));
        goto L4
    L10:
        r0.add(toJavaOnlyMap((JsonObject) r1));
        goto L4
    L7:
        r0.add(null);
        goto L4
    L28:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyMap toJavaOnlyMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator r1 = r10.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r11 = (String) r1.next();
        JsonPrimitive r12 = r10.get(r11);
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r13.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.put(r11, Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r0.put(r11, Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.put(r11, r13.getAsString());
        goto L4
    L18:
        r0.put(r11, Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r0.put(r11, toJavaOnlyArray((JsonArray) r12));
        goto L4
    L10:
        r0.put(r11, toJavaOnlyMap((JsonObject) r12));
        goto L4
    L7:
        r0.put(r11, null);
        goto L4
    L28:
        return r0;
    }

    @JvmStatic
    public static final JsonArray toJson(ReadableArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JsonArray r0 = new JsonArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L19;
        ReadableType r12 = r10.getType(r11);
        if (r12 != null) goto L7;
        int r13 = -1;
    L8:
        switch(r13) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r0.add(toJson(r10.getArray(r11)));
        goto L18
    L11:
        r0.add(toJson(r10.getMap(r11)));
        goto L18
    L12:
        r0.add(r10.getString(r11));
        goto L18
    L13:
        r0.add(Double.valueOf(r10.getDouble(r11)));
        goto L18
    L14:
        r0.add(Long.valueOf(r10.getLong(r11)));
        goto L18
    L15:
        r0.add(Integer.valueOf(r10.getInt(r11)));
        goto L18
    L16:
        r0.add(Boolean.valueOf(r10.getBoolean(r11)));
        goto L18
    L17:
        r0.add(JsonNull.INSTANCE);
    L18:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = a.a[r12.ordinal()];
        goto L8
    L19:
        return r0;
    }

    @JvmStatic
    public static final com.lynx.react.bridge.JavaOnlyArray toReactLynxJavaOnlyArray(JsonArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.lynx.react.bridge.JavaOnlyArray r0 = new com.lynx.react.bridge.JavaOnlyArray();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonPrimitive r1 = (JsonElement) r11.next();
        if ((r1 instanceof JsonNull) == true) goto L7;
        if ((r1 instanceof JsonObject) == true) goto L10;
        if ((r1 instanceof JsonArray) == true) goto L13;
        if ((r1 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r12 = r1;
        if (r12.isBoolean() == true) goto L18;
        if (r12.isString() == true) goto L21;
        if (r12.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r12.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.add(Long.valueOf(r12.getAsNumber().longValue()));
        goto L4
    L26:
        r0.add(Double.valueOf(r12.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.add(r12.getAsString());
        goto L4
    L18:
        r0.add(Boolean.valueOf(r12.getAsBoolean()));
        goto L4
    L13:
        r0.add(toReactLynxJavaOnlyArray((JsonArray) r1));
        goto L4
    L10:
        r0.add(toReactLynxJavaOnlyMap((JsonObject) r1));
        goto L4
    L7:
        r0.add(null);
        goto L4
    L28:
        return r0;
    }

    @JvmStatic
    public static final com.lynx.react.bridge.JavaOnlyMap toReactLynxJavaOnlyMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.lynx.react.bridge.JavaOnlyMap r0 = new com.lynx.react.bridge.JavaOnlyMap();
        Iterator r1 = r10.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r11 = (String) r1.next();
        JsonPrimitive r12 = r10.get(r11);
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r13.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.put(r11, Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r0.put(r11, Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.put(r11, r13.getAsString());
        goto L4
    L18:
        r0.put(r11, Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r0.put(r11, toReactLynxJavaOnlyArray((JsonArray) r12));
        goto L4
    L10:
        r0.put(r11, toReactLynxJavaOnlyMap((JsonObject) r12));
        goto L4
    L7:
        r0.put(r11, null);
        goto L4
    L28:
        return r0;
    }

    public final JavaOnlyMap convertJSONObject2JavaOnlyMap(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "obj");
        Iterator<String> r0 = r10.keys();
        JavaOnlyMap r1 = new JavaOnlyMap();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r11 = r0.next();
        Object r12 = r10.opt(r11);
        if ((r12 instanceof JSONObject) == true) goto L7;
        if ((r12 instanceof JSONArray) == true) goto L10;
        r1.put(r11, r12);
        goto L4
    L10:
        r1.put(r11, convertJSONArray2JavaOnlyArray((JSONArray) r12));
        goto L4
    L7:
        r1.put(r11, convertJSONObject2JavaOnlyMap((JSONObject) r12));
        goto L4
    L12:
        return r1;
    }

    public final JavaOnlyArray convertList2JavaOnlyArray(List<?> r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LIST);
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r1 = r11.next();
        if ((r1 instanceof Map) == true) goto L7;
        if ((r1 instanceof List) == true) goto L10;
        r0.add(r1);
        goto L4
    L10:
        r0.addAll(INSTANCE.convertList2JavaOnlyArray((List) r1));
        goto L4
    L7:
        r0.add(INSTANCE.convertMap2JavaOnlyMap((Map) r1));
        goto L4
    L12:
        return r0;
    }

    public final JavaOnlyMap convertMap2JavaOnlyMap(Map<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<Map.Entry<?, ?>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<?, ?> r1 = r11.next();
        Object r12 = r1.getKey();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        String r13 = (String) r12;
        Object r14 = r1.getValue();
        if ((r14 instanceof Map) == true) goto L7;
        if ((r14 instanceof List) == true) goto L10;
        r0.put(r13, r14);
        goto L4
    L10:
        r0.put(r13, INSTANCE.convertList2JavaOnlyArray((List) r14));
        goto L4
    L7:
        r0.put(r13, INSTANCE.convertMap2JavaOnlyMap((Map) r14));
        goto L4
    L12:
        return r0;
    }

    public final Number getNumber(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "rawNumber");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Integer.valueOf(r10.intValue()));     // Catch: Throwable -> L5
    L7:
        Object r11 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        Integer r12 = (Integer) r1;
        if (r12 == null) goto L13;
        int r13 = r12.intValue();
    L38:
        Object r14 = Result.constructor-impl(Double.valueOf(r10.doubleValue()));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r14) == true) goto L22;
        r11 = r14;
    L22:
        Double r15 = (Double) r11;
        if (r15 == null) goto L25;
        double r16 = r15.doubleValue();
    L27:
        if (Double.compare(r13, r16) == 0) goto L29;
        long r17 = (long) r16;
        if (Double.compare(r16, r17) != 0) goto L35;
        return Long.valueOf(r17);
    L35:
        return Double.valueOf(r16);
    L29:
        return Integer.valueOf(r13);
    L25:
        r16 = 0.0d;
    L16:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L13:
        r13 = 0;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object getValue(sp7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ReadableType r0 = r10.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        return null;
    L9:
        if (r1 == 2) goto L25;
        if (r1 == 5) goto L23;
        if (r1 == 6) goto L29;
        if (r1 == 7) goto L28;
        if (r1 == 8) goto L27;
        return null;
    L27:
        return r10.asArray();
    L28:
        return r10.asMap();
    L29:
        return r10.asString();
    L23:
        return getNumber(Double.valueOf(r10.asDouble()));
    L25:
        return Boolean.valueOf(r10.asBoolean());
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }

    public final ReadableMap mapToReadableMap(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r11.next();
        r0.putString(r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    public final Map<String, Object> readableToMap(ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        ReadableMapKeySetIterator r0 = r10.keySetIterator();
        HashMap r1 = new HashMap();
    L4:
        if (r0.hasNextKey() == false) goto L6;
        String r11 = r0.nextKey();
        r1.put(r11, getValue(getValue(r10.getDynamic(r11))));
        goto L4
    L6:
        return r1;
    }

    public final Map<String, String> readableToStringMap(ReadableMap r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ReadableMapKeySetIterator r0 = r10.keySetIterator();
        HashMap r1 = new HashMap();
    L7:
        if (r0.hasNextKey() == false) goto L11;
        String r11 = r0.nextKey();
        Object r12 = getValue(getValue(r10.getDynamic(r11)));
        if (r12 == null) goto L7;
        r1.put(r11, r12.toString());
        goto L7
    L11:
        return r1;
    }

    @JvmStatic
    public static final JsonObject toJson(final ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        final JsonObject r0 = new JsonObject();
        forEachKey(r10, new e(r10, r0));
        return r0;
    }

    public final Object getValue(Object r10) {
        if ((r10 instanceof ReadableArray) == false) goto L9;
        ReadableArray r11 = (ReadableArray) r10;
        int r0 = r11.size();
        ArrayList r1 = new ArrayList();
        int r12 = 0;
    L5:
        if (r12 >= r0) goto L16;
        r1.add(getValue(getValue(r11.getDynamic(r12))));
        r12 = r12 + 1;
        goto L5
    L16:
        return r1;
    L9:
        if ((r10 instanceof ReadableMap) == false) goto L12;
        return readableToMap((ReadableMap) r10);
    L12:
        if ((r10 instanceof Number) == true) goto L14;
        return r10;
    L14:
        return getNumber((Number) r10);
    }

    @JvmStatic
    public static final void forEachKey(ReadableMap r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ReadableMapKeySetIterator r12 = r10.keySetIterator();
    L4:
        if (r12.hasNextKey() == false) goto L14;
        String r0 = r12.nextKey();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L4;
        r11.invoke(r0);
        goto L4
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r1 = false;
        goto L12
    }

    private static final Unit toJson$lambda$2$lambda$1(ReadableMap r10, JsonObject r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "key");
        ReadableType r0 = r10.getType(r12);
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        switch(r1) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L17;
        };
    L8:
        r11.add(r12, toJson(r10.getArray(r12)));
        goto L17
    L9:
        r11.add(r12, toJson(r10.getMap(r12)));
        goto L17
    L10:
        r11.addProperty(r12, r10.getString(r12));
        goto L17
    L11:
        r11.addProperty(r12, Double.valueOf(r10.getDouble(r12)));
        goto L17
    L12:
        r11.addProperty(r12, Long.valueOf(r10.getLong(r12)));
        goto L17
    L13:
        r11.addProperty(r12, Integer.valueOf(r10.getInt(r12)));
        goto L17
    L14:
        r11.addProperty(r12, Boolean.valueOf(r10.getBoolean(r12)));
        goto L17
    L15:
        r11.add(r12, JsonNull.INSTANCE);
    L17:
        return Unit.INSTANCE;
    L5:
        r1 = a.a[r0.ordinal()];
        goto L6
    }
}
