package com.lynx.tasm.utils;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace$TYPE;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f11162a;

    public static ProtocolMessage a(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl((ProtocolMessage) z0.a.a().fromJson(r5, ProtocolMessage.class));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        String r13 = "deserializer json to ProtocolMessage error " + r12.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a1.a.f43a.e("ai_bridge", r13, null);
    L11:
        if (Result.m130isFailureimpl(r11) == false) goto L14;
        r11 = null;
    L14:
        return (ProtocolMessage) r11;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static ProtocolMessage b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl((ProtocolMessage) z0.a.a().fromJson(r5, ProtocolMessage.class));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        String r13 = "deserializer string to ProtocolMessage error " + r12.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a1.a.f43a.e("ai_bridge", r13, null);
    L11:
        if (Result.m130isFailureimpl(r11) == false) goto L14;
        r11 = null;
    L14:
        return (ProtocolMessage) r11;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static JsonObject c(ProtocolMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "protocolMessage");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r5, "value");     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(z0.a.a().toJsonTree(r5).getAsJsonObject());     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        String r13 = "serializer ProtocolMessage error " + r12.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a1.a.f43a.e("ai_bridge", r13, null);
    L11:
        if (Result.m130isFailureimpl(r11) == false) goto L14;
        r11 = null;
    L14:
        return (JsonObject) r11;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static JavaOnlyArray d(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonArray");
        JavaOnlyArray r5 = new JavaOnlyArray();
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L44;
        Object r13 = r10.get(r12);
        if (r13 == null) goto L43;
        if ((r13 instanceof Float) == false) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L13;
        r5.pushDouble(r10.getDouble(r12));
        goto L43
    L13:
        if ((r13 instanceof Long) == false) goto L26;
        ConcurrentHashMap r15 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r16 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r16 == null) goto L21;
        xc.d r17 = (xc.d) r16.a(xc.d.class);
        if (r17 == null) goto L21;
        Boolean r18 = r17.f();
        if (r18 == null) goto L21;
        boolean r19 = r18.booleanValue();
    L22:
        if (r19 == false) goto L24;
        r5.pushLong(r10.getLong(r12));
        goto L43
    L24:
        r5.pushDouble(r10.getLong(r12));
    L21:
        r19 = true;
        goto L22
    L26:
        if ((r13 instanceof Number) == false) goto L29;
        r5.pushInt(r10.getInt(r12));
        goto L43
    L29:
        if ((r13 instanceof String) == false) goto L32;
        r5.pushString(r10.getString(r12));
        goto L43
    L32:
        if ((r13 instanceof Boolean) == false) goto L35;
        r5.pushBoolean(r10.getBoolean(r12));
        goto L43
    L35:
        if ((r13 instanceof JSONObject) == false) goto L38;
        r5.pushMap(e(r10.getJSONObject(r12)));
        goto L43
    L38:
        if ((r13 instanceof JSONArray) == false) goto L41;
        r5.pushArray(d(r10.getJSONArray(r12)));
        goto L43
    L41:
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == false) goto L43;
        r5.pushNull();
        goto L43
    L9:
        r14 = r13 instanceof Double;
    L43:
        r12 = r12 + 1;
        goto L3
    L44:
        return r5;
    }

    public static JavaOnlyMap e(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        JavaOnlyMap r5 = new JavaOnlyMap();
        Iterator<String> r11 = r10.keys();
    L4:
        if (r11.hasNext() == false) goto L41;
        String r12 = r11.next();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.String");
        String r13 = r12;
        Object r14 = r10.get(r13);
        boolean r15 = true;
        if ((r14 instanceof Float) == false) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == true) goto L10;
        if ((r14 instanceof Long) == true) goto L13;
        if ((r14 instanceof Number) == true) goto L25;
        if ((r14 instanceof String) == true) goto L28;
        if ((r14 instanceof Boolean) == true) goto L31;
        if ((r14 instanceof JSONObject) == true) goto L34;
        if ((r14 instanceof JSONArray) == true) goto L37;
        if (Intrinsics.areEqual(r14, JSONObject.NULL) == false) goto L4;
        r5.putNull(r13);
        goto L4
    L37:
        r5.putArray(r13, d(r10.getJSONArray(r13)));
        goto L4
    L34:
        r5.putMap(r13, e(r10.getJSONObject(r13)));
        goto L4
    L31:
        r5.putBoolean(r13, r10.getBoolean(r13));
        goto L4
    L28:
        r5.putString(r13, r10.getString(r13));
        goto L4
    L25:
        r5.putInt(r13, r10.getInt(r13));
        goto L4
    L13:
        ConcurrentHashMap r17 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r18 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r18 == null) goto L20;
        xc.d r19 = (xc.d) r18.a(xc.d.class);
        if (r19 == null) goto L20;
        Boolean r20 = r19.f();
        if (r20 == null) goto L20;
        r15 = r20.booleanValue();
    L20:
        if (r15 == true) goto L21;
        r5.putDouble(r13, r10.getLong(r13));
        goto L4
    L21:
        r5.putLong(r13, r10.getLong(r13));
        goto L4
    L10:
        r5.putDouble(r13, r10.getDouble(r13));
        goto L4
    L8:
        r16 = r14 instanceof Double;
        goto L9
    L41:
        return r5;
    }

    public static com.lynx.tasm.fontface.a f(LynxContext r12, String r13) {
        String r14 = h(r13);
        if (r14 != null) goto L6;
        n(r12, "Font-family is empty", "");
        return null;
    L6:
        HashMap r5 = r12.f;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (r12.f.containsKey(r14) == false) goto L13;
        ReadableMap r15 = (ReadableMap) r12.f.get(r14);     // Catch: Throwable -> L11
    L14:
        if (r15 == null) goto L18;
        HashMap<String, Object> r16 = r15.asHashMap();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
    L20:
        if (r16 != null) goto L22;
        return null;
    L22:
        com.lynx.tasm.fontface.a r10 = new com.lynx.tasm.fontface.a();
        Iterator<Object> r17 = r16.values().iterator();
        boolean r11 = false;
    L24:
        if (r17.hasNext() == false) goto L91;
        Object r18 = r17.next();
        if ((r18 instanceof String) == false) goto L27;
        String r19 = (String) r18;
        int r20 = r19.length();
        int r21 = 0;
    L29:
        if (r21 >= r20) goto L87;
        int r22 = r19.indexOf("url(", r21);
        int r23 = r19.indexOf("local(", r21);
        if (r22 != (-1)) goto L35;
        if (r23 == (-1)) goto L87;
    L35:
        if (r22 == (-1)) goto L62;
        if (r23 == (-1)) goto L62;
        if (r22 >= r23) goto L50;
        int r24 = r19.indexOf(")", r22);
        if (r24 == (-1)) goto L86;
        int r25 = r24 + 2;
        String r26 = o(r19.substring(r22 + 4, r24));
        if (r26 == null) goto L86;
        if (r26.endsWith(".woff") == true) goto L49;
        if (r26.endsWith(".woff2") == true) goto L49;
        r10.f10853a.add(new Pair(FontFace$TYPE.f10850a, r26));
    L61:
        r21 = r25;
    L49:
        r21 = r25;
        r11 = true;
    L86:
        n(r12, "Src format error", r19);
        goto L87
    L50:
        int r27 = r19.indexOf(")", r23);
        if (r27 == (-1)) goto L86;
        r25 = r27 + 2;
        String r28 = o(r19.substring(r23 + 6, r27));
        if (r28 == null) goto L86;
        if (r28.endsWith(".woff") == true) goto L49;
        if (r28.endsWith(".woff2") == true) goto L49;
        r10.f10853a.add(new Pair(FontFace$TYPE.f10851b, r28));
    L62:
        if (r22 == (-1)) goto L75;
        int r29 = r19.indexOf(")", r22);
        if (r29 == (-1)) goto L86;
        r25 = r29 + 2;
        String r30 = o(r19.substring(r22 + 4, r29));
        if (r30 == null) goto L86;
        if (r30.endsWith(".woff") == true) goto L49;
        if (r30.endsWith(".woff2") == true) goto L49;
        r10.f10853a.add(new Pair(FontFace$TYPE.f10850a, r30));
        goto L61
    L75:
        int r31 = r19.indexOf(")", r23);
        if (r31 == (-1)) goto L86;
        r25 = r31 + 2;
        String r32 = o(r19.substring(r23 + 6, r31));
        if (r32 == null) goto L86;
        if (r32.endsWith(".woff") == true) goto L49;
        if (r32.endsWith(".woff2") == true) goto L49;
        r10.f10853a.add(new Pair(FontFace$TYPE.f10851b, r32));
    L87:
        if (r11 == false) goto L24;
        if (r10.f10853a.isEmpty() == false) goto L24;
        r12.f(r19, "font", new LynxError(30204, "The woff file format is not supported on Android", "", "error"));
        LynxLog.b(4, "FontFaceParser", "The woff file format is not supported on Android,src:".concat(r19));
        goto L24
    L27:
        n(r12, "Src is not string", r18.toString());
        goto L24
    L91:
        return r10;
    L18:
        monitor-exit(r5);     // Catch: Throwable -> L11
        r16 = null;
        goto L20
    L13:
        r15 = null;
        goto L14
    }

    public static final String g(Uri r5, String r10) {
        return r5.getQueryParameter(r10);
    L4:
        return null;
    }

    public static String h(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r5 = 0;
    L7:
        if (r5 >= r10.length()) goto L16;
        if (r10.charAt(r5) == ' ') goto L14;
        if (r10.charAt(r5) == '\"') goto L14;
        if (r10.charAt(r5) != '\'') goto L16;
    L14:
        r5 = r5 + 1;
    L16:
        if (r5 < r10.length()) goto L18;
        return null;
    L18:
        int r11 = r10.length() - 1;
    L19:
        if (r11 <= r5) goto L28;
        if (r10.charAt(r11) == ' ') goto L26;
        if (r10.charAt(r11) == '\"') goto L26;
        if (r10.charAt(r11) != '\'') goto L28;
    L26:
        r11 = r11 - 1;
    L28:
        return r10.substring(r5, r11 + 1);
    }

    public static String i(String r5, String r10) {
        if (r10 != null) goto L7;
        r5 = URLEncoder.encode(r5, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L4
    L10:
        Intrinsics.checkNotNull(r5);     // Catch: UnsupportedEncodingException -> L4
        return r5;
    L7:
        if (Intrinsics.areEqual(r10, "null_encoding") == true) goto L10;
        r5 = URLEncoder.encode(r5, r10);     // Catch: UnsupportedEncodingException -> L4
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String j(String r5, String r10, String r11, String r12) {
        return androidx.constraintlayout.motion.widget.a.p(r5, r10, r11, r12);
    }

    public static final LinkedHashMap k(Uri r10) {
        String[] r5 = {"x-use-ppe", "x-use-boe", "x-tt-env"};
        ArrayList r11 = new ArrayList(3);
        int r12 = 0;
    L3:
        if (r12 >= 3) goto L5;
        String r13 = r5[r12];
        r11.add(TuplesKt.to(r13, g(r10, r13)));
        r12 = r12 + 1;
        goto L3
    L5:
        Map r14 = MapsKt.toMap(r11);
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r16 = r14.entrySet().iterator();
    L7:
        if (r16.hasNext() == false) goto L11;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (android.text.TextUtils.isEmpty((CharSequence) r17.getValue()) == true) goto L7;
        r15.put(r17.getKey(), r17.getValue());
        goto L7
    L11:
        return r15;
    }

    public static JSONArray l(ReadableArray r11) {
        Intrinsics.checkNotNullParameter(r11, "readableArray");
        JSONArray r5 = new JSONArray();
        int r10 = r11.size();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L57;
        ReadableType r13 = r11.getType(r12);
        if (r13 != null) goto L7;
        int r14 = -1;
    L8:
        switch(r14) {
            case 1: goto L55;
            case 2: goto L60;
            case 3: goto L56;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L56;
        };
    L10:
        r5.put(JSONObject.NULL);
        goto L56
    L11:
        r5.put(l(r11.getArray(r12)));
        goto L56
    L12:
        r5.put(m(r11.getMap(r12)));
        goto L56
    L13:
        r5.put(r11.getString(r12));
        goto L56
    L14:
        r5.put(r11.getLong(r12));
        goto L56
    L55:
        r5.put(r11.getBoolean(r12));
        goto L56
    L60:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        Object r16 = Result.m124constructorimpl(Integer.valueOf(r11.getInt(r12)));     // Catch: Throwable -> L17
    L19:
        Object r17 = null;
        if (Result.m130isFailureimpl(r16) == false) goto L22;
        r16 = null;
    L22:
        Integer r18 = (Integer) r16;
        if (r18 == null) goto L25;
        int r19 = r18.intValue();
    L58:
        Object r20 = Result.m124constructorimpl(Double.valueOf(r11.getDouble(r12)));     // Catch: Throwable -> L28
    L31:
        if (Result.m130isFailureimpl(r20) == true) goto L34;
        r17 = r20;
    L34:
        Double r21 = (Double) r17;
        if (r21 == null) goto L37;
        double r22 = r21.doubleValue();
    L39:
        if (Double.compare(r19, r22) != 0) goto L41;
        Number r23 = Integer.valueOf(r19);
    L46:
        if ((r23 instanceof Double) == false) goto L49;
        r5.put(r23.doubleValue());
        goto L56
    L49:
        if ((r23 instanceof Long) == false) goto L52;
        r5.put(r23.longValue());
        goto L56
    L52:
        if ((r23 instanceof Integer) == false) goto L54;
        r5.put(r23.intValue());
        goto L56
    L54:
        Unit r24 = Unit.INSTANCE;
        goto L56
    L41:
        long r25 = (long) r22;
        if (Double.compare(r22, r25) != 0) goto L44;
        r23 = Long.valueOf(r25);
        goto L46
    L44:
        r23 = Double.valueOf(r22);
        goto L46
    L37:
        r22 = 0.0d;
    L28:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L31
    L25:
        r19 = 0;
    L17:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L56:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = mc.b.f20058a[r13.ordinal()];
        goto L8
    L57:
        return r5;
    }

    public static JSONObject m(ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r10, "readableMap");
        JSONObject r5 = new JSONObject();
        ReadableMapKeySetIterator r11 = r10.keySetIterator();
    L4:
        if (r11.hasNextKey() == false) goto L58;
        String r12 = r11.nextKey();
        ReadableType r13 = r10.getType(r12);
        if (r13 != null) goto L8;
        int r14 = -1;
    L9:
        switch(r14) {
            case 1: goto L57;
            case 2: goto L59;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L4;
        };
    L59:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        Object r16 = Result.m124constructorimpl(Integer.valueOf(r10.getInt(r12)));     // Catch: Throwable -> L19
    L21:
        Object r17 = null;
        if (Result.m130isFailureimpl(r16) == false) goto L24;
        r16 = null;
    L24:
        Integer r18 = (Integer) r16;
        if (r18 == null) goto L27;
        int r19 = r18.intValue();
    L61:
        Object r20 = Result.m124constructorimpl(Double.valueOf(r10.getDouble(r12)));     // Catch: Throwable -> L30
    L33:
        if (Result.m130isFailureimpl(r20) == true) goto L36;
        r17 = r20;
    L36:
        Double r21 = (Double) r17;
        if (r21 == null) goto L39;
        double r22 = r21.doubleValue();
    L41:
        if (Double.compare(r19, r22) != 0) goto L43;
        Number r23 = Integer.valueOf(r19);
    L48:
        if ((r23 instanceof Double) == true) goto L49;
        if ((r23 instanceof Long) == true) goto L52;
        if ((r23 instanceof Integer) == true) goto L55;
        Unit r24 = Unit.INSTANCE;
        goto L4
    L55:
        r5.put(r12, r23.intValue());
        goto L4
    L52:
        r5.put(r12, r23.longValue());
        goto L4
    L49:
        r5.put(r12, r23.doubleValue());
        goto L4
    L43:
        long r25 = (long) r22;
        if (Double.compare(r22, r25) != 0) goto L46;
        r23 = Long.valueOf(r25);
        goto L48
    L46:
        r23 = Double.valueOf(r22);
        goto L48
    L39:
        r22 = 0.0d;
    L30:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L33
    L27:
        r19 = 0;
    L19:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    L11:
        r5.put(r12, JSONObject.NULL);
        goto L4
    L12:
        r5.put(r12, l(r10.getArray(r12)));
        goto L4
    L13:
        r5.put(r12, m(r10.getMap(r12)));
        goto L4
    L14:
        r5.put(r12, r10.getString(r12));
        goto L4
    L15:
        r5.put(r12, r10.getLong(r12));
        goto L4
    L16:
        r5.put(r12, r10.getInt(r12));
        goto L4
    L57:
        r5.put(r12, r10.getBoolean(r12));
        goto L4
    L8:
        r14 = mc.b.f20058a[r13.ordinal()];
        goto L9
    L58:
        return r5;
    }

    public static void n(LynxContext r5, String r10, String r11) {
        r5.f(r11, "font", new LynxError(30201, r10, "", "error"));
        LynxLog.b(4, "FontFaceParser", r10 + ",src:" + r11);
    }

    public static String o(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.length();
        if (r5.startsWith("'") == false) goto L8;
    L11:
        int r11 = 1;
    L13:
        if (r5.endsWith("'") == false) goto L15;
    L16:
        r10 = r10 - 1;
    L17:
        if (r11 <= r10) goto L20;
        return null;
    L20:
        return r5.substring(r11, r10);
    L15:
        if (r5.endsWith("\"") == false) goto L17;
    L8:
        if (r5.startsWith("\"") == true) goto L11;
        r11 = 0;
        goto L13
    }

    public static uu.a p(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "moduleDeclaration");
        uu.a r10 = new uu.a(false);
        r5.invoke(r10);
        return r10;
    }

    public static final void q(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNullParameter("OUILogger", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.i("OUILogger", r5);
    }
}
