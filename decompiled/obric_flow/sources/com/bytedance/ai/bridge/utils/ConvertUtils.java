package com.bytedance.ai.bridge.utils;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.widgets.d;
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
import ki.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import l2.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0004\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u0007*\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\f\u001a\u00020\u000f*\u00020\u000eH\u0007¢\u0006\u0004\b\f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u000bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\u00020\u00112\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\u0019\u0010/\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b/\u00100J%\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010.\u001a\u00020\u0011H\u0007¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u00103\u001a\u00020\u0014H\u0003¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020%2\u0006\u00103\u001a\u00020\u0014H\u0003¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00142\u0006\u00108\u001a\u00020%H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010;\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0004\b;\u0010<J\u0013\u0010>\u001a\u0004\u0018\u00010\u0001*\u00020=¢\u0006\u0004\b>\u0010?J#\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010!2\b\u0010@\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bC\u0010BJ\u0019\u0010>\u001a\u0004\u0018\u00010\u00012\b\u0010@\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b>\u0010DJ\u0015\u0010F\u001a\u00020\u00112\u0006\u0010E\u001a\u00020*¢\u0006\u0004\bF\u0010-J\u0019\u0010H\u001a\u00020\u00142\n\u0010G\u001a\u0006\u0012\u0002\b\u00030\u001d¢\u0006\u0004\bH\u0010 J\u001d\u0010I\u001a\u00020\u00112\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!¢\u0006\u0004\bI\u0010$J\u0015\u0010L\u001a\u00020J2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MR\u001c\u0010O\u001a\n N*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/bytedance/ai/bridge/utils/ConvertUtils;", "", "<init>", "()V", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "Lkotlin/Function1;", "", "", "block", "forEachKey", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Lkotlin/jvm/functions/Function1;)V", "Lcom/google/gson/JsonObject;", "toJson", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)Lcom/google/gson/JsonObject;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;", "Lcom/google/gson/JsonArray;", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableArray;)Lcom/google/gson/JsonArray;", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "toJavaOnlyMap", "(Lcom/google/gson/JsonObject;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "toJavaOnlyArray", "(Lcom/google/gson/JsonArray;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "Lcom/lynx/react/bridge/JavaOnlyMap;", "toReactLynxJavaOnlyMap", "(Lcom/google/gson/JsonObject;)Lcom/lynx/react/bridge/JavaOnlyMap;", "Lcom/lynx/react/bridge/JavaOnlyArray;", "toReactLynxJavaOnlyArray", "(Lcom/google/gson/JsonArray;)Lcom/lynx/react/bridge/JavaOnlyArray;", "", "sourceArray", "convertArrayToJavaOnlyArray", "(Ljava/util/List;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "", "source", "convertMapToJavaOnlyMap", "(Ljava/util/Map;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "Lorg/json/JSONArray;", "jsonArray", "Lcom/bytedance/vmsdk/jsbridge/utils/WritableArray;", "convertJsonToJavaOnlyArray", "(Lorg/json/JSONArray;)Lcom/bytedance/vmsdk/jsbridge/utils/WritableArray;", "Lorg/json/JSONObject;", "jsonObject", "convertJsonToJavaOnlyMap", "(Lorg/json/JSONObject;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "map", "convertJavaOnlyMapToJson", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;)Lorg/json/JSONObject;", "convertJavaOnlyMapToMap", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;)Ljava/util/Map;", "array", "convertJavaOnlyArrayToList", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;)Ljava/util/List;", "convertJavaOnlyArrayToJson", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;)Lorg/json/JSONArray;", "arrays", "convertJSONArray2JavaOnlyArray", "(Lorg/json/JSONArray;)Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyArray;", "mapToReadableMap", "(Ljava/util/Map;)Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "Lfk/a;", "getValue", "(Lfk/a;)Ljava/lang/Object;", "value", "readableToMap", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)Ljava/util/Map;", "readableToStringMap", "(Ljava/lang/Object;)Ljava/lang/Object;", "obj", "convertJSONObject2JavaOnlyMap", "list", "convertList2JavaOnlyArray", "convertMap2JavaOnlyMap", "", "rawNumber", "getNumber", "(Ljava/lang/Number;)Ljava/lang/Number;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConvertUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertUtils.kt\ncom/bytedance/ai/bridge/utils/ConvertUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,661:1\n1863#2,2:662\n1863#2,2:664\n1863#2,2:666\n1863#2,2:668\n1863#2,2:674\n216#3,2:670\n216#3,2:672\n216#3,2:676\n1#4:678\n*S KotlinDebug\n*F\n+ 1 ConvertUtils.kt\ncom/bytedance/ai/bridge/utils/ConvertUtils\n*L\n92#1:662,2\n121#1:664,2\n143#1:666,2\n165#1:668,2\n593#1:674,2\n187#1:670,2\n315#1:672,2\n611#1:676,2\n*E\n"})
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = null;
    private static final String TAG = null;

    static {
        INSTANCE = new ConvertUtils();
        TAG = "ConvertUtils";
    }

    private ConvertUtils() {
    }

    public static /* synthetic */ Unit a(ReadableMap r5, JsonObject r10, String r11) {
        return toJson$lambda$2$lambda$1(r5, r10, r11);
    }

    @JvmStatic
    public static final JavaOnlyArray convertArrayToJavaOnlyArray(List<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "sourceArray");
        JavaOnlyArray r10 = new JavaOnlyArray();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L32;
        Object r13 = r5.get(r12);
        if ((r13 instanceof Map) == false) goto L9;
        r10.pushMap(convertMapToJavaOnlyMap((Map) r13));     // Catch: Exception -> L33
    L31:
        r12 = r12 + 1;
        goto L3
    L9:
        if ((r13 instanceof List) == false) goto L13;
        r10.pushArray(convertArrayToJavaOnlyArray((List) r13));     // Catch: Exception -> L33
        goto L31
    L13:
        if ((r13 instanceof Boolean) == false) goto L16;
        r10.pushBoolean(((Boolean) r13).booleanValue());
        goto L31
    L16:
        if ((r13 instanceof Integer) == false) goto L19;
        r10.pushInt(((Number) r13).intValue());
        goto L31
    L19:
        if ((r13 instanceof Long) == false) goto L22;
        r10.pushDouble(((Number) r13).longValue());
        goto L31
    L22:
        if ((r13 instanceof Float) == false) goto L25;
        r10.pushDouble(((Number) r13).floatValue());
        goto L31
    L25:
        if ((r13 instanceof Double) == false) goto L28;
        r10.pushDouble(((Number) r13).doubleValue());
        goto L31
    L28:
        if ((r13 instanceof String) == false) goto L30;
        r10.pushString((String) r13);
        goto L31
    L30:
        r10.pushString(r13.toString());
        goto L31
    L32:
        return r10;
    }

    private final JavaOnlyArray convertJSONArray2JavaOnlyArray(JSONArray r10) {
        JavaOnlyArray r5 = new JavaOnlyArray();
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        Object r13 = r10.opt(r12);
        if ((r13 instanceof JSONArray) == false) goto L8;
        r5.add(convertJSONArray2JavaOnlyArray((JSONArray) r13));
    L11:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof JSONObject) == false) goto L10;
        r5.add(convertJSONObject2JavaOnlyMap((JSONObject) r13));
        goto L11
    L10:
        r5.add(r13);
        goto L11
    L12:
        return r5;
    }

    @JvmStatic
    private static final JSONArray convertJavaOnlyArrayToJson(JavaOnlyArray r10) {
        JSONArray r5 = new JSONArray();
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L24;
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L16
        if (r14 != null) goto L8;
        int r15 = -1;
    L10:
        if (r15 != 5) goto L12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L16
        r5.put(INSTANCE.getNumber((Number) r13));     // Catch: Throwable -> L16
    L23:
        r12 = r12 + 1;
        goto L3
    L12:
        if (r15 != 7) goto L14;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L16
        r5.put(convertJavaOnlyMapToJson((JavaOnlyMap) r13));     // Catch: Throwable -> L16
        goto L23
    L14:
        if (r15 == 8) goto L18;
        r5.put(r13);     // Catch: Throwable -> L16
        goto L23
    L18:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L16
        r5.put(convertJavaOnlyArrayToJson((JavaOnlyArray) r13));     // Catch: Throwable -> L16
        goto L23
    L8:
        r15 = b.f19514a[r14.ordinal()];     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        a.a("revertJavaOnlyArray2JSONArray " + th);
        Unit r16 = Unit.INSTANCE;
        goto L23
    L24:
        return r5;
    }

    @JvmStatic
    private static final List<Object> convertJavaOnlyArrayToList(JavaOnlyArray r10) {
        ArrayList r5 = new ArrayList();
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L24;
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L16
        if (r14 != null) goto L8;
        int r15 = -1;
    L10:
        if (r15 != 5) goto L12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L16
        r5.add(INSTANCE.getNumber((Number) r13));     // Catch: Throwable -> L16
    L23:
        r12 = r12 + 1;
        goto L3
    L12:
        if (r15 != 7) goto L14;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L16
        r5.add(convertJavaOnlyMapToMap((JavaOnlyMap) r13));     // Catch: Throwable -> L16
        goto L23
    L14:
        if (r15 == 8) goto L18;
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L16
        r5.add(r13);     // Catch: Throwable -> L16
        goto L23
    L18:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L16
        r5.add(convertJavaOnlyArrayToList((JavaOnlyArray) r13));     // Catch: Throwable -> L16
        goto L23
    L8:
        r15 = b.f19514a[r14.ordinal()];     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        a.a("convertJavaOnlyArrayToList " + th);
        Unit r16 = Unit.INSTANCE;
        goto L23
    L24:
        return r5;
    }

    @JvmStatic
    public static final JSONObject convertJavaOnlyMapToJson(JavaOnlyMap r10) {
        JSONObject r5 = new JSONObject();
        if (r10 != null) goto L5;
    L29:
        return r5;
    L5:
        if (r10.isEmpty() == true) goto L29;
        ReadableMapKeySetIterator r11 = r10.keySetIterator();
    L9:
        if (r11.hasNextKey() == false) goto L29;
        String r12 = r11.nextKey();
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L22
        if (r14 != null) goto L14;
        int r15 = -1;
    L16:
        if (r15 != 5) goto L18;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L22
        r5.put(r12, INSTANCE.getNumber((Number) r13));     // Catch: Throwable -> L22
        goto L9
    L18:
        if (r15 != 7) goto L20;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L22
        r5.putOpt(r12, convertJavaOnlyMapToJson((JavaOnlyMap) r13));     // Catch: Throwable -> L22
        goto L9
    L20:
        if (r15 != 8) goto L21;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L22
        r5.putOpt(r12, convertJavaOnlyArrayToJson((JavaOnlyArray) r13));     // Catch: Throwable -> L22
        goto L9
    L21:
        r5.putOpt(r12, r13);     // Catch: Throwable -> L22
        goto L9
    L14:
        r15 = b.f19514a[r14.ordinal()];     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        a.a("revertJavaOnlyMap2JSONObject " + th);
        goto L9
    }

    @JvmStatic
    public static final Map<String, Object> convertJavaOnlyMapToMap(JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        LinkedHashMap r5 = new LinkedHashMap();
        if (r10.isEmpty() == true) goto L27;
        ReadableMapKeySetIterator r11 = r10.keySetIterator();
    L7:
        if (r11.hasNextKey() == false) goto L27;
        String r12 = r11.nextKey();
        Object r13 = r10.get(r12);
        ReadableType r14 = r10.getType(r12);     // Catch: Throwable -> L20
        if (r14 != null) goto L12;
        int r15 = -1;
    L14:
        if (r15 != 5) goto L16;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        r5.put(r12, INSTANCE.getNumber((Number) r13));     // Catch: Throwable -> L20
        goto L7
    L16:
        if (r15 != 7) goto L18;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L20
        r5.put(r12, convertJavaOnlyMapToMap((JavaOnlyMap) r13));     // Catch: Throwable -> L20
        goto L7
    L18:
        if (r15 != 8) goto L19;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L20
        r5.put(r12, convertJavaOnlyArrayToList((JavaOnlyArray) r13));     // Catch: Throwable -> L20
        goto L7
    L19:
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L20
        r5.put(r12, r13);     // Catch: Throwable -> L20
        goto L7
    L12:
        r15 = b.f19514a[r14.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        a.a("convertJavaOnlyMapToMap " + th);
    L27:
        return r5;
    }

    @JvmStatic
    public static final WritableArray convertJsonToJavaOnlyArray(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonArray");
        JavaOnlyArray r10 = new JavaOnlyArray();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L30;
        Object r13 = r5.get(r12);
        if ((r13 instanceof JSONObject) == false) goto L8;
        r10.pushMap(convertJsonToJavaOnlyMap((JSONObject) r13));
    L29:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof JSONArray) == false) goto L11;
        r10.pushArray(convertJsonToJavaOnlyArray((JSONArray) r13));
        goto L29
    L11:
        if ((r13 instanceof Boolean) == false) goto L14;
        r10.pushBoolean(((Boolean) r13).booleanValue());
        goto L29
    L14:
        if ((r13 instanceof Integer) == false) goto L17;
        r10.pushInt(((Number) r13).intValue());
        goto L29
    L17:
        if ((r13 instanceof Long) == false) goto L20;
        r10.pushDouble(((Number) r13).longValue());
        goto L29
    L20:
        if ((r13 instanceof Float) == false) goto L23;
        r10.pushDouble(((Number) r13).floatValue());
        goto L29
    L23:
        if ((r13 instanceof Double) == false) goto L26;
        r10.pushDouble(((Number) r13).doubleValue());
        goto L29
    L26:
        if ((r13 instanceof String) == false) goto L28;
        r10.pushString((String) r13);
        goto L29
    L28:
        r10.pushString(r13.toString());
        goto L29
    L30:
        return r10;
    }

    @JvmStatic
    public static final JavaOnlyMap convertJsonToJavaOnlyMap(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L33;
        String r12 = r11.next();
        Object r13 = r5.get(r12);
        if ((r13 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == true) goto L10;
        if ((r13 instanceof JSONArray) == true) goto L13;
        if ((r13 instanceof Boolean) == true) goto L16;
        if ((r13 instanceof Integer) == true) goto L19;
        if ((r13 instanceof Long) == true) goto L22;
        if ((r13 instanceof Float) == true) goto L25;
        if ((r13 instanceof Double) == true) goto L28;
        if ((r13 instanceof String) == true) goto L31;
        r10.putString(r12, r13.toString());
        goto L4
    L31:
        r10.putString(r12, (String) r13);
        goto L4
    L28:
        r10.putDouble(r12, ((Number) r13).doubleValue());
        goto L4
    L25:
        r10.putDouble(r12, ((Number) r13).floatValue());
        goto L4
    L22:
        r10.putDouble(r12, ((Number) r13).longValue());
        goto L4
    L19:
        r10.putInt(r12, ((Number) r13).intValue());
        goto L4
    L16:
        r10.putBoolean(r12, ((Boolean) r13).booleanValue());
        goto L4
    L13:
        r10.putArray(r12, convertJsonToJavaOnlyArray((JSONArray) r13));
        goto L4
    L10:
        r10.putMap(r12, null);
        goto L4
    L7:
        r10.putMap(r12, convertJsonToJavaOnlyMap((JSONObject) r13));
        goto L4
    L33:
        return r10;
    }

    @JvmStatic
    public static final JavaOnlyMap convertMapToJavaOnlyMap(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L43;
        Map.Entry<String, ? extends Object> r12 = r11.next();
        String r13 = r12.getKey();
        Object r14 = r12.getValue();
        if ((r14 instanceof Map) == false) goto L10;
        r10.putMap(r13, convertMapToJavaOnlyMap((Map) r14));     // Catch: Exception -> L44
        goto L4
    L10:
        if ((r14 instanceof List) == true) goto L11;
        if ((r14 instanceof Boolean) == true) goto L15;
        if ((r14 instanceof Integer) == true) goto L18;
        if ((r14 instanceof Long) == true) goto L21;
        if ((r14 instanceof Float) == true) goto L24;
        if ((r14 instanceof Double) == true) goto L27;
        if ((r14 instanceof String) == true) goto L30;
        if ((r14 instanceof JSONObject) == true) goto L33;
        if ((r14 instanceof JSONArray) == true) goto L36;
        if (r14 == null) goto L42;
        if (Intrinsics.areEqual(r14, JSONObject.NULL) == true) goto L42;
        r10.putString(r13, r14.toString());
    L42:
        r10.putNull(r13);
        goto L4
    L36:
        r10.putArray(r13, convertJsonToJavaOnlyArray((JSONArray) r14));
        goto L4
    L33:
        r10.putMap(r13, convertJsonToJavaOnlyMap((JSONObject) r14));
        goto L4
    L30:
        r10.putString(r13, (String) r14);
        goto L4
    L27:
        r10.putDouble(r13, ((Number) r14).doubleValue());
        goto L4
    L24:
        r10.putDouble(r13, ((Number) r14).floatValue());
        goto L4
    L21:
        r10.putDouble(r13, ((Number) r14).longValue());
        goto L4
    L18:
        r10.putInt(r13, ((Number) r14).intValue());
        goto L4
    L15:
        r10.putBoolean(r13, ((Boolean) r14).booleanValue());
        goto L4
    L11:
        r10.putArray(r13, convertArrayToJavaOnlyArray((List) r14));     // Catch: Exception -> L44
        goto L4
    L43:
        return r10;
    }

    @JvmStatic
    public static final void forEachKey(ReadableMap r5, Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "block");
        ReadableMapKeySetIterator r11 = r5.keySetIterator();
    L4:
        if (r11.hasNextKey() == false) goto L11;
        String r12 = r11.nextKey();
        if (r12 == null) goto L4;
        if (StringsKt.isBlank(r12) == true) goto L4;
        r10.invoke(r12);
        goto L4
    }

    @JvmStatic
    public static final JavaOnlyArray toJavaOnlyArray(JsonArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JavaOnlyArray r10 = new JavaOnlyArray();
        Iterator<JsonElement> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonElement r12 = r11.next();
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = (JsonPrimitive) r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.f(r13.getAsNumber().toString(), '.') == true) goto L26;
        r10.add(Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r10.add(Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r10.add(r13.getAsString());
        goto L4
    L18:
        r10.add(Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r10.add(toJavaOnlyArray((JsonArray) r12));
        goto L4
    L10:
        r10.add(toJavaOnlyMap((JsonObject) r12));
        goto L4
    L7:
        r10.add(null);
        goto L4
    L28:
        return r10;
    }

    @JvmStatic
    public static final JavaOnlyMap toJavaOnlyMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyMap r5 = new JavaOnlyMap();
        Iterator<T> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        String r12 = (String) r11.next();
        JsonElement r13 = r10.get(r12);
        if ((r13 instanceof JsonNull) == true) goto L7;
        if ((r13 instanceof JsonObject) == true) goto L10;
        if ((r13 instanceof JsonArray) == true) goto L13;
        if ((r13 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r14 = (JsonPrimitive) r13;
        if (r14.isBoolean() == true) goto L18;
        if (r14.isString() == true) goto L21;
        if (r14.isNumber() == false) goto L4;
        if (StringsKt.f(r14.getAsNumber().toString(), '.') == true) goto L26;
        r5.put(r12, Long.valueOf(r14.getAsNumber().longValue()));
        goto L4
    L26:
        r5.put(r12, Double.valueOf(r14.getAsNumber().doubleValue()));
        goto L4
    L21:
        r5.put(r12, r14.getAsString());
        goto L4
    L18:
        r5.put(r12, Boolean.valueOf(r14.getAsBoolean()));
        goto L4
    L13:
        r5.put(r12, toJavaOnlyArray((JsonArray) r13));
        goto L4
    L10:
        r5.put(r12, toJavaOnlyMap((JsonObject) r13));
        goto L4
    L7:
        r5.put(r12, null);
        goto L4
    L28:
        return r5;
    }

    @JvmStatic
    public static final JsonObject toJson(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JsonObject r10 = new JsonObject();
        forEachKey(r5, new d(11, r5, r10));
        return r10;
    }

    private static final Unit toJson$lambda$2$lambda$1(ReadableMap r5, JsonObject r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        ReadableType r12 = r5.getType(r11);
        if (r12 != null) goto L5;
        int r13 = -1;
    L6:
        switch(r13) {
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
        r10.add(r11, toJson(r5.getArray(r11)));
        goto L17
    L9:
        r10.add(r11, toJson(r5.getMap(r11)));
        goto L17
    L10:
        r10.addProperty(r11, r5.getString(r11));
        goto L17
    L11:
        r10.addProperty(r11, Double.valueOf(r5.getDouble(r11)));
        goto L17
    L12:
        r10.addProperty(r11, Long.valueOf(r5.getLong(r11)));
        goto L17
    L13:
        r10.addProperty(r11, Integer.valueOf(r5.getInt(r11)));
        goto L17
    L14:
        r10.addProperty(r11, Boolean.valueOf(r5.getBoolean(r11)));
        goto L17
    L15:
        r10.add(r11, JsonNull.INSTANCE);
    L17:
        return Unit.INSTANCE;
    L5:
        r13 = b.f19514a[r12.ordinal()];
        goto L6
    }

    @JvmStatic
    public static final com.lynx.react.bridge.JavaOnlyArray toReactLynxJavaOnlyArray(JsonArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.lynx.react.bridge.JavaOnlyArray r10 = new com.lynx.react.bridge.JavaOnlyArray();
        Iterator<JsonElement> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonElement r12 = r11.next();
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = (JsonPrimitive) r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.f(r13.getAsNumber().toString(), '.') == true) goto L26;
        r10.add(Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r10.add(Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r10.add(r13.getAsString());
        goto L4
    L18:
        r10.add(Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r10.add(toReactLynxJavaOnlyArray((JsonArray) r12));
        goto L4
    L10:
        r10.add(toReactLynxJavaOnlyMap((JsonObject) r12));
        goto L4
    L7:
        r10.add(null);
        goto L4
    L28:
        return r10;
    }

    @JvmStatic
    public static final com.lynx.react.bridge.JavaOnlyMap toReactLynxJavaOnlyMap(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        com.lynx.react.bridge.JavaOnlyMap r5 = new com.lynx.react.bridge.JavaOnlyMap();
        Iterator<T> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        String r12 = (String) r11.next();
        JsonElement r13 = r10.get(r12);
        if ((r13 instanceof JsonNull) == true) goto L7;
        if ((r13 instanceof JsonObject) == true) goto L10;
        if ((r13 instanceof JsonArray) == true) goto L13;
        if ((r13 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r14 = (JsonPrimitive) r13;
        if (r14.isBoolean() == true) goto L18;
        if (r14.isString() == true) goto L21;
        if (r14.isNumber() == false) goto L4;
        if (StringsKt.f(r14.getAsNumber().toString(), '.') == true) goto L26;
        r5.put(r12, Long.valueOf(r14.getAsNumber().longValue()));
        goto L4
    L26:
        r5.put(r12, Double.valueOf(r14.getAsNumber().doubleValue()));
        goto L4
    L21:
        r5.put(r12, r14.getAsString());
        goto L4
    L18:
        r5.put(r12, Boolean.valueOf(r14.getAsBoolean()));
        goto L4
    L13:
        r5.put(r12, toReactLynxJavaOnlyArray((JsonArray) r13));
        goto L4
    L10:
        r5.put(r12, toReactLynxJavaOnlyMap((JsonObject) r13));
        goto L4
    L7:
        r5.put(r12, null);
        goto L4
    L28:
        return r5;
    }

    public final JavaOnlyMap convertJSONObject2JavaOnlyMap(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "obj");
        Iterator<String> r5 = r10.keys();
        JavaOnlyMap r11 = new JavaOnlyMap();
    L4:
        if (r5.hasNext() == false) goto L12;
        String r12 = r5.next();
        Object r13 = r10.opt(r12);
        if ((r13 instanceof JSONObject) == true) goto L7;
        if ((r13 instanceof JSONArray) == true) goto L10;
        r11.put(r12, r13);
        goto L4
    L10:
        r11.put(r12, convertJSONArray2JavaOnlyArray((JSONArray) r13));
        goto L4
    L7:
        r11.put(r12, convertJSONObject2JavaOnlyMap((JSONObject) r13));
        goto L4
    L12:
        return r11;
    }

    public final JavaOnlyArray convertList2JavaOnlyArray(List<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        JavaOnlyArray r10 = new JavaOnlyArray();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r12 = r11.next();
        if ((r12 instanceof Map) == true) goto L7;
        if ((r12 instanceof List) == true) goto L10;
        r10.add(r12);
        goto L4
    L10:
        r10.addAll(INSTANCE.convertList2JavaOnlyArray((List) r12));
        goto L4
    L7:
        r10.add(INSTANCE.convertMap2JavaOnlyMap((Map) r12));
        goto L4
    L12:
        return r10;
    }

    public final JavaOnlyMap convertMap2JavaOnlyMap(Map<?, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator<Map.Entry<?, ?>> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<?, ?> r12 = r11.next();
        Object r13 = r12.getKey();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) r13;
        Object r15 = r12.getValue();
        if ((r15 instanceof Map) == true) goto L7;
        if ((r15 instanceof List) == true) goto L10;
        r10.put(r14, r15);
        goto L4
    L10:
        r10.put(r14, INSTANCE.convertList2JavaOnlyArray((List) r15));
        goto L4
    L7:
        r10.put(r14, INSTANCE.convertMap2JavaOnlyMap((Map) r15));
        goto L4
    L12:
        return r10;
    }

    public final Number getNumber(Number r5) {
        Intrinsics.checkNotNullParameter(r5, "rawNumber");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Integer.valueOf(r5.intValue()));     // Catch: Throwable -> L5
    L7:
        Object r12 = null;
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        Integer r13 = (Integer) r11;
        if (r13 == null) goto L13;
        int r14 = r13.intValue();
    L38:
        Object r15 = Result.m124constructorimpl(Double.valueOf(r5.doubleValue()));     // Catch: Throwable -> L16
    L19:
        if (Result.m130isFailureimpl(r15) == true) goto L22;
        r12 = r15;
    L22:
        Double r16 = (Double) r12;
        if (r16 == null) goto L25;
        double r17 = r16.doubleValue();
    L27:
        if (Double.compare(r14, r17) == 0) goto L29;
        long r18 = (long) r17;
        if (Double.compare(r17, r18) != 0) goto L35;
        return Long.valueOf(r18);
    L35:
        return Double.valueOf(r17);
    L29:
        return Integer.valueOf(r14);
    L25:
        r17 = 0.0d;
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L13:
        r14 = 0;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object getValue(fk.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 == 2) goto L27;
        if (r11 == 5) goto L25;
        if (r11 == 6) goto L23;
        if (r11 == 7) goto L21;
        if (r11 == 8) goto L19;
        return null;
    L19:
        return r5.asArray();
    L21:
        return r5.asMap();
    L23:
        return r5.asString();
    L25:
        return getNumber(Double.valueOf(r5.asDouble()));
    L27:
        return Boolean.valueOf(r5.asBoolean());
    L5:
        r11 = b.f19514a[r10.ordinal()];
        goto L7
    }

    public final ReadableMap mapToReadableMap(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JavaOnlyMap r10 = new JavaOnlyMap();
        Iterator<Map.Entry<String, String>> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, String> r12 = r11.next();
        r10.putString(r12.getKey(), r12.getValue());
        goto L4
    L6:
        return r10;
    }

    public final Map<String, Object> readableToMap(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        ReadableMapKeySetIterator r10 = r5.keySetIterator();
        HashMap r11 = new HashMap();
    L4:
        if (r10.hasNextKey() == false) goto L6;
        String r12 = r10.nextKey();
        r11.put(r12, getValue(getValue(r5.getDynamic(r12))));
        goto L4
    L6:
        return r11;
    }

    public final Map<String, String> readableToStringMap(ReadableMap r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ReadableMapKeySetIterator r10 = r5.keySetIterator();
        HashMap r11 = new HashMap();
    L7:
        if (r10.hasNextKey() == false) goto L11;
        String r12 = r10.nextKey();
        Object r13 = getValue(getValue(r5.getDynamic(r12)));
        if (r13 == null) goto L7;
        r11.put(r12, r13.toString());
        goto L7
    L11:
        return r11;
    }

    @JvmStatic
    public static final JsonArray toJson(ReadableArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JsonArray r10 = new JsonArray();
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L19;
        ReadableType r13 = r5.getType(r12);
        if (r13 != null) goto L7;
        int r14 = -1;
    L8:
        switch(r14) {
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
        r10.add(toJson(r5.getArray(r12)));
        goto L18
    L11:
        r10.add(toJson(r5.getMap(r12)));
        goto L18
    L12:
        r10.add(r5.getString(r12));
        goto L18
    L13:
        r10.add(Double.valueOf(r5.getDouble(r12)));
        goto L18
    L14:
        r10.add(Long.valueOf(r5.getLong(r12)));
        goto L18
    L15:
        r10.add(Integer.valueOf(r5.getInt(r12)));
        goto L18
    L16:
        r10.add(Boolean.valueOf(r5.getBoolean(r12)));
        goto L18
    L17:
        r10.add(JsonNull.INSTANCE);
    L18:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = b.f19514a[r13.ordinal()];
        goto L8
    L19:
        return r10;
    }

    public final Object getValue(Object r5) {
        if ((r5 instanceof ReadableArray) == false) goto L9;
        ReadableArray r10 = (ReadableArray) r5;
        int r11 = r10.size();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L7;
        r12.add(getValue(getValue(r10.getDynamic(r13))));
        r13 = r13 + 1;
        goto L5
    L7:
        return r12;
    L9:
        if ((r5 instanceof ReadableMap) == false) goto L13;
        return readableToMap((ReadableMap) r5);
    L13:
        if ((r5 instanceof Number) == true) goto L15;
        return r5;
    L15:
        return getNumber((Number) r5);
    }
}
