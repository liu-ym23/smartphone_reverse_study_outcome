package com.bytedance.pia.core.utils;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.android.agilelogger.ALog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static final void A(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        y(r5, null);
    }

    public static final void B(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter("PiaCore", "tag");
        StringBuilder r10 = sk.a.a(v(r5));
        r10.append(Log.getStackTraceString(null));
        ALog.v("PiaCore", r10.toString());
    }

    public static final void C(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter("PiaCore", "tag");
        StringBuilder r11 = sk.a.a(v(r5));
        r11.append(Log.getStackTraceString(r10));
        ALog.w("PiaCore", r11.toString());
    }

    public static final int a(WebView r5) {
        Intrinsics.areEqual(((Handler) m.f7157c.getValue()).getLooper(), Looper.myLooper());
        if (r5 == null) goto L7;
        WebSettings r10 = r5.getSettings();
        if (r10 == null) goto L7;
        String r11 = r10.getUserAgentString();
    L9:
        if (r11 != null) goto L20;
        return -1;
    L20:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        Object r13 = Result.m124constructorimpl(Integer.valueOf(Integer.parseInt(StringsKt.X(StringsKt.S(r11.toLowerCase(Locale.getDefault()), "chrome/"), "."))));     // Catch: Throwable -> L13
    L16:
        if (Result.m130isFailureimpl(r13) == false) goto L19;
        r13 = -1;
    L19:
        return ((Number) r13).intValue();
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L7:
        r11 = null;
        goto L9
    }

    public static final Uri b(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Lazy r10 = Settings.B;
        if (com.lynx.tasm.p.a().u() == false) goto L16;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Object r12 = Result.m124constructorimpl(r5.buildUpon().appendQueryParameter("_pia_", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST).build());     // Catch: Throwable -> L6
    L8:
        Object r13 = r5;
        if (Result.m130isFailureimpl(r12) == true) goto L13;
        r13 = r12;
    L13:
        return (Uri) r13;
    L6:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    L16:
        return r5;
    }

    public static final WebResourceResponse c(dh.f r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new WebResourceResponse(r10.e(), r10.d(), r10.getStatusCode(), r10.c(), r10.b(), r10.getData());
    }

    public static final JavaOnlyArray d(JsonArray r5) {
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
        r10.add(d((JsonArray) r12));
        goto L4
    L10:
        r10.add(e((JsonObject) r12));
        goto L4
    L7:
        r10.add(null);
        goto L4
    L28:
        return r10;
    }

    public static final JavaOnlyMap e(JsonObject r10) {
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
        r5.put(r12, d((JsonArray) r13));
        goto L4
    L10:
        r5.put(r12, e((JsonObject) r13));
        goto L4
    L7:
        r5.put(r12, null);
        goto L4
    L28:
        return r5;
    }

    public static final JsonArray f(ReadableArray r5) {
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
        r10.add(f(r5.getArray(r12)));
        goto L18
    L11:
        r10.add(g(r5.getMap(r12)));
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
        r14 = o.f7160a[r13.ordinal()];
        goto L8
    L19:
        return r10;
    }

    public static final JsonObject g(final ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        final JsonObject r10 = new JsonObject();
        Function1<String, Unit> r11 = new WorkerUtils$toJson$1$1(r5, r10);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        ReadableMapKeySetIterator r12 = r5.keySetIterator();
    L4:
        if (r12.hasNextKey() == false) goto L11;
        String r13 = r12.nextKey();
        if (r13 == null) goto L4;
        if (StringsKt.isBlank(r13) == true) goto L4;
        r11.invoke(r13);
        goto L4
    L11:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    public static JsonObject h(InputStream r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r11 = "";
    L5:
        Lazy r13 = Settings.B;
        Application r14 = zg.b.f23438a;
        ManifestUtils$State r15 = ManifestUtils$State.f7128a;
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        StringBuilder r16 = new StringBuilder();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L19
        Sequence r18 = SequencesKt.sequence(new StreamUtils$asSequence$1$1(new InputStreamReader(r10, n(r11)), null));     // Catch: Throwable -> L66
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L19
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L19
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L19
    L10:
        if (r20.hasNext() == false) goto L64;
        char[] r21 = (char[]) r20.next();     // Catch: Throwable -> L19
        int r22 = 0;
        int r23 = Math.max(0, r19.length() - 32);     // Catch: Throwable -> L19
        r19.append(r21);     // Catch: Throwable -> L19
        r16.append(r21);     // Catch: Throwable -> L19
        if (ManifestUtils$State.f7128a != r15) goto L22;
        int r24 = r19.indexOf("<script pia-manifest", r23);     // Catch: Throwable -> L19
        Integer r25 = Integer.valueOf(r24);     // Catch: Throwable -> L19
        if (r24 != (-1)) goto L17;
        r25 = null;
    L17:
        if (r25 == null) goto L22;
        int r110 = r25.intValue();     // Catch: Throwable -> L19
        ManifestUtils$State r26 = ManifestUtils$State.f7129b;     // Catch: Throwable -> L19
        r19.delete(0, r110 + 20);     // Catch: Throwable -> L19
        r15 = r26;
        r23 = 0;
    L22:
        if (ManifestUtils$State.f7129b != r15) goto L29;
        int r27 = r19.indexOf("type=\"application/json\">", r23);     // Catch: Throwable -> L19
        Integer r28 = Integer.valueOf(r27);     // Catch: Throwable -> L19
        if (r27 != (-1)) goto L27;
        r28 = null;
    L27:
        if (r28 == null) goto L29;
        int r111 = r28.intValue();     // Catch: Throwable -> L19
        ManifestUtils$State r29 = ManifestUtils$State.f7130c;     // Catch: Throwable -> L19
        r19.delete(0, r111 + 24);     // Catch: Throwable -> L19
        r15 = r29;
    L31:
        if (ManifestUtils$State.f7130c != r15) goto L47;
        int r30 = r19.indexOf("</script>", r22);     // Catch: Throwable -> L19
        Integer r31 = Integer.valueOf(r30);     // Catch: Throwable -> L19
        if (r30 != (-1)) goto L36;
        r31 = null;
    L36:
        if (r31 == null) goto L47;
        r19.delete(r31.intValue(), r19.length());     // Catch: Throwable -> L19
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L40
        Object r113 = Result.m124constructorimpl(i.f7152b.parse(r19.toString()).getAsJsonObject());     // Catch: Throwable -> L40
    L42:
        boolean r32 = Result.m130isFailureimpl(r113);     // Catch: Throwable -> L19
        T r114 = r113;
        if (r32 == false) goto L45;
        r114 = 0;
    L45:
        r5.element = r114;     // Catch: Throwable -> L19
        r15 = ManifestUtils$State.d;     // Catch: Throwable -> L19
        goto L47
    L40:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L19
        r113 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L47:
        if (r16.indexOf("</head>", r22) == (-1)) goto L10;
        JsonObject r34 = i(r16.toString());     // Catch: Throwable -> L19
        if (r5.element != 0) goto L56;
        if (r34.size() <= 0) goto L84;
        ?? r35 = new JsonObject();     // Catch: Throwable -> L19
        r5.element = r35;     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r35);     // Catch: Throwable -> L19
        r35.add("resources", r34);     // Catch: Throwable -> L19
        JsonObject r36 = (JsonObject) r5.element;     // Catch: Throwable -> L19
    L85:
        return r36;
    L84:
        return null;
    L56:
        if (r34.size() <= 0) goto L63;
        T r37 = r5.element;     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r37);     // Catch: Throwable -> L19
        JsonElement r38 = ((JsonObject) r37).get("resources");     // Catch: Throwable -> L19
        if (r38 != null) goto L60;
    L62:
        T r39 = r5.element;     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r39);     // Catch: Throwable -> L19
        ((JsonObject) r39).add("resources", r34);     // Catch: Throwable -> L19
        goto L63
    L60:
        if (r38.isJsonObject() == false) goto L62;
        p(r38.getAsJsonObject(), r34);     // Catch: Throwable -> L19
    L63:
        r36 = (JsonObject) r5.element;     // Catch: Throwable -> L19
    L29:
        r22 = r23;
        goto L31
    L64:
        Result.m124constructorimpl(r19);     // Catch: Throwable -> L19
    L73:
        return (JsonObject) r5.element;
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L73
    }

    public static JsonObject i(String r10) {
        JsonObject r5 = new JsonObject();
        int r11 = 0;
    L3:
        int r12 = StringsKt.r("<link", r11, 4, r10);
        if (r12 == (-1)) goto L29;
        int r13 = StringsKt.r(">", r12, 4, r10);
        if (r13 == (-1)) goto L29;
        int r14 = r13 + 1;
        if (r10 == null) goto L28;
        String r15 = r10.substring(r12, r14);
        if (StringsKt.g(r15, "rel=\"preload\"") == false) goto L26;
        int r16 = StringsKt.r("as=\"", 0, 6, r15);
        if (r16 == (-1)) goto L26;
        int r17 = r16 + 4;
        int r18 = StringsKt.q(r15, Typography.quote, r17, 4);
        if (r18 == (-1)) goto L26;
        String r19 = r10.substring(r17 + r12, r18 + r12);
        if (StringsKt.l(r19, "style") == false) goto L18;
        r19 = "css";
    L18:
        int r20 = StringsKt.r("href=\"", 0, 6, r15);
        if (r20 == (-1)) goto L26;
        int r21 = r20 + 6;
        int r22 = StringsKt.q(r15, Typography.quote, r21, 4);
        if (r22 == (-1)) goto L26;
        String r23 = r10.substring(r21 + r12, r22 + r12);
        if (r5.has(r19) == true) goto L25;
        r5.add(r19, new JsonArray());
    L25:
        r5.getAsJsonArray(r19).add(r23);
    L26:
        r11 = r12 + 1;
        goto L3
    L28:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L29:
        return r5;
    }

    public static Class j(Object r10, Class r11, int r12) {
        if (r12 >= 0) goto L6;
        return null;
    L6:
        if (r11.isInstance(r10) == true) goto L31;
        return null;
    L31:
        Type[] r5 = r10.getClass().getGenericInterfaces();     // Catch: Throwable -> L30
        int r13 = r5.length;     // Catch: Throwable -> L30
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L16;
        Type r15 = r5[r14];     // Catch: Throwable -> L30
        if ((r15 instanceof ParameterizedType) == false) goto L15;
        if (((ParameterizedType) r15).getRawType() != r11) goto L15;
        ParameterizedType r16 = (ParameterizedType) r15;     // Catch: Throwable -> L30
    L17:
        if (r16 != null) goto L23;
        Type r17 = r10.getClass().getGenericSuperclass();     // Catch: Throwable -> L30
        if ((r17 instanceof ParameterizedType) == false) goto L23;
        if (((ParameterizedType) r17).getRawType() != r11) goto L23;
        r16 = (ParameterizedType) r17;     // Catch: Throwable -> L30
    L23:
        if (r16 != null) goto L25;
        return null;
    L25:
        Type[] r18 = r16.getActualTypeArguments();     // Catch: Throwable -> L30
        if (r12 >= r18.length) goto L29;
        return (Class) r18[r12];
    L15:
        r14 = r14 + 1;     // Catch: Throwable -> L30
        goto L9
    L16:
        r16 = null;
    L29:
        return null;
    }

    public static final String k(Uri r10, List r11) {
        ArrayList r5 = null;
        if (r10 != null) goto L5;
    L46:
        return null;
    L5:
        if (z(r10) == false) goto L46;
        StringBuffer r12 = new StringBuffer();
        r12.append(r10.getAuthority());
        r12.append(r10.getPath());
        LinkedHashSet r13 = new LinkedHashSet();
        String r14 = r10.getQueryParameter("_pia_vary_");
        if (r14 == null) goto L20;
        List r15 = StringsKt.J(r14, new char[]{','}, 0, 6);
        if (r15 == null) goto L20;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L13:
        if (r17.hasNext() == false) goto L19;
        String r18 = (String) r17.next();
        if (r18 == null) goto L18;
        r16.add(StringsKt.trim(r18).toString());
        goto L13
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        r13.addAll(r16);
    L20:
        if (r11 == null) goto L22;
        r13.addAll(r11);
    L22:
        List r19 = CollectionsKt.sorted(r13);
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L24:
        if (r21.hasNext() == false) goto L35;
        String r22 = (String) r21.next();
        String r23 = r10.getQueryParameter(r22);
        if (r23 != null) goto L28;
    L31:
        Pair r24 = null;
    L32:
        if (r24 == null) goto L24;
        r20.add(r24);
        goto L24
    L28:
        if (StringsKt.isBlank(r23) == true) goto L31;
        r24 = TuplesKt.to(r22, r23);
        goto L32
    L35:
        if (r20.isEmpty() == true) goto L37;
        r5 = r20;
    L37:
        if (r5 == null) goto L45;
        Pair r25 = (Pair) CollectionsKt.first(r5);
        r12.append("?");
        r12.append(((String) r25.getFirst()) + '=' + ((String) r25.getSecond()));
        List r26 = CollectionsKt.i(r5, 1);
        if (r26 == null) goto L45;
        Iterator r27 = r26.iterator();
    L42:
        if (r27.hasNext() == false) goto L45;
        Pair r28 = (Pair) r27.next();
        String r29 = (String) r28.component1();
        String r30 = (String) r28.component2();
        r12.append("&");
        r12.append(r29 + '=' + r30);
    L45:
        return r12.toString();
    }

    public static final String l(dh.f r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        String r11 = r5.d();     // Catch: Throwable -> L6
    L9:
        Object r12 = Result.m124constructorimpl(r11);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r12) == false) goto L15;
        r12 = null;
    L15:
        String r13 = (String) r12;
        if (r5 == null) goto L23;
        InputStream r14 = r5.getData();
        if (r14 != null) goto L20;
        return null;
    L20:
        return m(r14, r13);
    L23:
        return null;
    L8:
        r11 = null;
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final String m(InputStream r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r11 = TextStreamsKt.readText(new InputStreamReader(r5, n(r10)));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r5, null);
        return r11;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    public static Charset n(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Result.m124constructorimpl(Charset.forName(r5));     // Catch: Throwable -> L4
    L6:
        Charset r12 = Charset.defaultCharset();
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = r12;
    L10:
        return (Charset) r11;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final void o(WebView r5, String r10, mh.i r11) {
        Intrinsics.checkNotNullParameter(r10, "script");
        if (r5 == null) goto L6;
        r5.evaluateJavascript(r10, new n(r11, 0));
        return;
    }

    public static void p(JsonObject r5, JsonObject r10) {
        Iterator<T> r11 = r10.entrySet().iterator();     // Catch: Exception -> L15
    L3:
        if (r11.hasNext() == false) goto L35;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Exception -> L15
        String r13 = (String) r12.getKey();     // Catch: Exception -> L15
        Object r14 = (JsonElement) r12.getValue();     // Catch: Exception -> L15
        if ((r14 instanceof JsonArray) == false) goto L3;
        if (r5.has(r13) == true) goto L9;
        r5.add(r13, ((JsonArray) r14).deepCopy());     // Catch: Exception -> L15
        goto L3
    L9:
        JsonArray r15 = r5.getAsJsonArray(r13);     // Catch: Exception -> L15
        Iterator r16 = ((Iterable) r14).iterator();     // Catch: Exception -> L15
    L11:
        if (r16.hasNext() == false) goto L3;
        JsonElement r17 = (JsonElement) r16.next();     // Catch: Exception -> L15
        if (r15.contains(r17) == true) goto L11;
        r15.add(r17);     // Catch: Exception -> L15
        goto L11
    L35:
        return;
    L15:
        e = move-exception;
        x("mergeJsonObjectsError", e);
    }

    public static final void q(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter("PiaCore", "tag");
        StringBuilder r11 = sk.a.a(v(r5));
        r11.append(Log.getStackTraceString(r10));
        ALog.d("PiaCore", r11.toString());
    }

    public static final void r(StringBuilder r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        if (r10 != null) goto L5;
        return;
    L5:
        r5.append("(\"");
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L26;
        char r12 = r10.charAt(r11);
        if (r12 != '\r') goto L11;
        r5.append("\\r");
    L25:
        r11 = r11 + 1;
        goto L7
    L11:
        if (r12 != '\"') goto L13;
        r5.append("\\\"");
        goto L25
    L13:
        if (r12 != '\'') goto L15;
        r5.append("\\'");
        goto L25
    L15:
        if (r12 == '\\') goto L21;
        switch(r12) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        r5.append(r12);
        goto L25
    L18:
        r5.append("\\n");
        goto L25
    L19:
        r5.append("\\t");
        goto L25
    L20:
        r5.append("\\b");
        goto L25
    L21:
        r5.append("\\\\");
        goto L25
    L26:
        r5.append("\")");
    }

    public static final void s(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        w(6, r5, null);
    }

    public static final JsonObject t(String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        return h(new ByteArrayInputStream(r5.getBytes(Charsets.UTF_8)), null, 3);
    }

    public static final String u(Uri r5) {
        String r10 = null;
        if (r5 != null) goto L5;
    L10:
        if (r10 != null) goto L13;
        return "";
    L13:
        return r10;
    L5:
        if (z(r5) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r10 = (String) StringsKt.J(r5.getScheme() + ':' + r5.getEncodedSchemeSpecificPart(), new char[]{'?'}, 0, 6).get(0);
        goto L10
    }

    public static String v(String r5) {
        if (StringsKt.P(r5, "[PIA]") == false) goto L6;
        return r5;
    L6:
        return td.d.b("[PIA] ", r5);
    }

    public static /* synthetic */ void w(int r5, String r10, Throwable r11) {
        if ((r5 & 2) == 0) goto L5;
        r11 = null;
    L5:
        x(r10, r11);
    }

    public static final void x(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter("PiaCore", "tag");
        StringBuilder r11 = sk.a.a(v(r5));
        r11.append(Log.getStackTraceString(r10));
        ALog.e("PiaCore", r11.toString());
    }

    public static final void y(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter("PiaCore", "tag");
        StringBuilder r11 = sk.a.a(v(r5));
        r11.append(Log.getStackTraceString(r10));
        ALog.i("PiaCore", r11.toString());
    }

    public static final boolean z(Uri r5) {
        List r10 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA});
        if (r5 == null) goto L5;
        String r11 = r5.getScheme();
    L7:
        return CollectionsKt.contains(r10, r11);
    L5:
        r11 = null;
        goto L7
    }
}
