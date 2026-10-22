package com.lynx.tasm.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.collection.ArrayMap;
import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.forest.model.m;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayMap f11161a;

    public static final int A(float r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0.0f) goto L6;
        return 0;
    L6:
        return MathKt.roundToInt(r5 * r10.getResources().getDisplayMetrics().density);
    }

    public static final int B(int r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        return A(r5, r10);
    }

    public static final int C(View r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != 0.0d) goto L6;
        return 0;
    L6:
        return A((float) r10, r5);
    }

    public static final float D(float r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(1, r5, r10.getResources().getDisplayMetrics());
    }

    public static final float E(int r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0) goto L6;
        return 0.0f;
    L6:
        return D(r5, r10);
    }

    public static final float F(View r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != 0.0d) goto L6;
        return 0.0f;
    L6:
        return D((float) r10, r5);
    }

    public static final float G(float r5, View r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(2, r5, r10.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static char a(Class r5) {
        if (f11161a != null) goto L6;
        ArrayMap r10 = new ArrayMap();
        f11161a = r10;
        r10.put(Byte.TYPE, 'b');
        f11161a.put(Byte.class, 'B');
        f11161a.put(Short.TYPE, 's');
        f11161a.put(Short.class, 'S');
        f11161a.put(Long.TYPE, 'l');
        f11161a.put(Long.class, 'L');
        f11161a.put(Character.TYPE, 'c');
        f11161a.put(Character.class, 'C');
        f11161a.put(Boolean.TYPE, 'z');
        f11161a.put(Boolean.class, 'Z');
        f11161a.put(Integer.TYPE, 'i');
        f11161a.put(Integer.class, 'I');
        f11161a.put(Double.TYPE, 'd');
        f11161a.put(Double.class, 'D');
        f11161a.put(Float.TYPE, 'f');
        f11161a.put(Float.class, 'F');
        f11161a.put(String.class, 'T');
    L6:
        if (f11161a.containsKey(r5) == true) goto L8;
        return 0;
    L8:
        return ((Character) f11161a.get(r5)).charValue();
    }

    public static float b(float r5) {
        if (r5 < (-3.4028235E38f)) goto L8;
        if (r5 > Float.MAX_VALUE) goto L8;
        return r5;
    L8:
        if (r5 >= (-3.4028235E38f)) goto L10;
    L23:
        return -3.4028235E38f;
    L10:
        if (r5 == Float.NEGATIVE_INFINITY) goto L23;
        if (r5 <= Float.MAX_VALUE) goto L15;
    L22:
        return Float.MAX_VALUE;
    L15:
        if (r5 == Float.POSITIVE_INFINITY) goto L22;
        if (Float.isNaN(r5) == false) goto L20;
        return 0.0f;
    L20:
        LynxLog.b(3, "lynx", "Invalid float property value: " + r5);
        return 0.0f;
    }

    public static m c(String r10, String r11) {
        if (r10.length() > 0) goto L5;
    L55:
        return null;
    L5:
        if (r11.length() <= 0) goto L55;
        int r5 = StringsKt.q(r10, '?', 0, 6);
        Integer r12 = Integer.valueOf(r5);
        if (r5 != (-1)) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        r10 = r10.substring(0, r12.intValue());
    L12:
        int r13 = StringsKt.q(r10, '#', 0, 6);
        Integer r14 = Integer.valueOf(r13);
        if (r13 != (-1)) goto L17;
        r14 = null;
    L17:
        if (r14 == null) goto L24;
        int r15 = r14.intValue();
        if (r10 == null) goto L22;
        r10 = r10.substring(0, r15);
        goto L24
    L22:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L24:
        if (android.text.TextUtils.isEmpty(StringsKt.trim(r11).toString()) == false) goto L27;
        r11 = null;
    L27:
        if (r11 == null) goto L55;
        if (StringsKt.j(r11, '/') == true) goto L31;
        r11 = r11.concat("/");
    L31:
        int r16 = StringsKt.r(r11, 0, 6, r10);
        Integer r17 = Integer.valueOf(r16);
        if (r16 != (-1)) goto L35;
        r17 = null;
    L35:
        if (r17 == null) goto L55;
        int r18 = r11.length() + r17.intValue();
        if (r10 == null) goto L54;
        String r19 = r10.substring(r18);
        int r20 = StringsKt.q(r19, '/', 0, 6);
        Integer r21 = Integer.valueOf(r20);
        if (r20 != (-1)) goto L42;
        r21 = null;
    L42:
        if (r21 == null) goto L55;
        int r22 = r21.intValue();
        if (r19 == null) goto L52;
        String r23 = r19.substring(0, r22);
        String r24 = r19.substring(r22 + 1);
        if (StringsKt.isBlank(r23) == true) goto L55;
        if (StringsKt.isBlank(r24) == true) goto L55;
        return new m("", r23, r24);
    L52:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L54:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static void e(com.bytedance.ies.bullet.core.e r5, rd.b r10) {
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        r5.g.getClass();
        Lazy r11 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r10, td.a.class);
        r5.g.getClass();
    }

    public static void f(id.c r5, String r10, String r11, id.a r12, String r13) {
        r12.a(r13, Long.valueOf(r5.f(r10, r11)));
    }

    public static void g(String r5, LinkedHashMap r10, c2.e r11, String r12, IHostNetworkDepend r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r5, "targetUrl");
        Intrinsics.checkNotNullParameter(r10, "headers");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r13, "hostNetworkDepend");
        c2.b r16 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r16.e = r10;
        r16.f1108a = r14;
        r16.f1109b = r15;
        Intrinsics.checkNotNullParameter(r13, "hostNetworkDepend");
        j(f0.m(RequestMethod.d, r16, r13), r11, r12);
    }

    public static void h(String r5, LinkedHashMap r10, String r11, Object r12, c2.e r13, String r14, IHostNetworkDepend r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r5, "targetUrl");
        Intrinsics.checkNotNullParameter(r10, "headers");
        Intrinsics.checkNotNullParameter(r11, "contentType");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        if ((r12 instanceof byte[]) == false) goto L6;
        c2.b r18 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r18.e = r10;
        Intrinsics.checkNotNullParameter(r11, "contentType");
        r18.d = r11;
        r18.f1108a = r16;
        r18.f1109b = r17;
        r18.f = (byte[]) r12;
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        j(f0.m(RequestMethod.f1874b, r18, r15), r13, r14);
        return;
    L6:
        boolean r19 = r12 instanceof Map;
        if (r19 == false) goto L17;
        if (Intrinsics.areEqual(r11, "application/json") == true) goto L17;
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = ((Map) r12).entrySet().iterator();
    L12:
        if (r21.hasNext() == false) goto L14;
        Map.Entry r22 = (Map.Entry) r21.next();
        r20.put(String.valueOf(r22.getKey()), String.valueOf(r22.getValue()));
        goto L12
    L14:
        c2.b r23 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r23.e = r10;
        Intrinsics.checkNotNullParameter(r20, LynxResourceModule.PARAMS_KEY);
        r23.f1108a = r16;
        r23.f1109b = r17;
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        j(f0.m(RequestMethod.f1874b, r23, r15), r13, r14);
        return;
    L17:
        if ((r12 instanceof String) == false) goto L20;
        byte[] r24 = ((String) r12).getBytes(Charsets.UTF_8);
    L25:
        c2.b r25 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r25.e = r10;
        Intrinsics.checkNotNullParameter(r11, "contentType");
        r25.d = r11;
        r25.f1108a = r16;
        r25.f1109b = r17;
        r25.f = r24;
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        j(f0.m(RequestMethod.f1874b, r25, r15), r13, r14);
        return;
    L20:
        if ((r12 instanceof List) == false) goto L22;
        r24 = new JSONArray((Collection) r12).toString().getBytes(Charsets.UTF_8);
        goto L25
    L22:
        if (r19 == false) goto L24;
        r24 = new JSONObject((Map) r12).toString().getBytes(Charsets.UTF_8);
        goto L25
    L24:
        r24 = new JSONObject().toString().getBytes(Charsets.UTF_8);
        goto L25
    }

    public static final void i(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        if (r10 == null) goto L13;
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L10
        if (r12 == null) goto L13;
    L8:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();     // Catch: Throwable -> L10
        r5.put(r13, r10.opt(r13));     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L14:
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L10
    L17:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L24;
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(androidx.room.jarjarred.org.antlr.runtime.a.x(r16, new StringBuilder("JsonUtils.wrap ")), LogLevel.d, "Monitor");
        return;
    L24:
        return;
    L13:
        r14 = null;
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(ug.d r11, c2.e r12, String r13) {
        int r5 = ((Ref.IntRef) r11.g).element;
        Ref.IntRef r10 = (Ref.IntRef) r11.f22358c;
        Integer r14 = Integer.valueOf(r10.element);
        LinkedHashMap r15 = (LinkedHashMap) r11.f22357b;
        String r16 = (String) ((Ref.ObjectRef) r11.e).element;
        Throwable r17 = (Throwable) ((Ref.ObjectRef) r11.f).element;
        String r18 = "";
        String r19 = null;
        byte[] r20 = null;
        if (r17 == null) goto L5;
    L60:
        if (r16 != null) goto L62;
    L68:
        if (r17 == null) goto L70;
        r19 = r17.getMessage();
    L70:
        if (r19 == null) goto L83;
        r18 = r19;
    L83:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L76
        if (r17 != null) goto L78;
        r17 = new Throwable(r18);     // Catch: Throwable -> L76
    L78:
        r12.a(r14, r15, r17, r5);     // Catch: Throwable -> L76
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L76
        return;
    L76:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L62:
        if (r16.length() > 0) goto L65;
        r16 = null;
    L65:
        if (r16 == null) goto L68;
        r18 = r16;
        goto L83
    L5:
        if (android.text.TextUtils.isEmpty(r16) == false) goto L60;
        fi.i r112 = (fi.i) ((Ref.ObjectRef) r11.d).element;
        Integer r21 = Integer.valueOf(r10.element);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L39
        if (r112 != null) goto L87;
    L10:
        String r23 = null;
    L18:
        if (r13 == null) goto L24;
        String r113 = StringsKt.trim(r13).toString();     // Catch: Throwable -> L22
        if (r113 == null) goto L24;
        String r114 = r113.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L22
    L26:
        if (Intrinsics.areEqual(r114, "string") == false) goto L31;
        if (r23 != null) goto L29;
        Object r24 = r18;
    L34:
        r12.c(r24, r15, r21, r5);     // Catch: Throwable -> L22
    L46:
        Object r115 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L49:
        Throwable r25 = Result.m127exceptionOrNullimpl(r115);
        if (r25 != null) goto L53;
        return;
    L53:
        if ((r112 instanceof fi.g) == false) goto L55;
        fi.g r116 = (fi.g) r112;
    L56:
        if (r116 == null) goto L58;
        r20 = r116.f16911b;
    L58:
        r12.b(Base64.encodeToString(r20, 2), r15, r25, r21, r5);
        return;
    L55:
        r116 = null;
        goto L56
    L22:
        th = move-exception;
        if ((r112 instanceof fi.g) == false) goto L41;
        fi.g r117 = (fi.g) r112;     // Catch: Throwable -> L39
    L42:
        if (r117 == null) goto L44;
        byte[] r118 = r117.f16911b;     // Catch: Throwable -> L39
    L45:
        r12.b(Base64.encodeToString(r118, 2), r15, th, r21, r5);     // Catch: Throwable -> L39
        goto L46
    L44:
        r118 = null;
        goto L45
    L41:
        r117 = null;
        goto L42
    L29:
        r24 = r23;
        goto L34
    L31:
        if (com.bytedance.ai.utils.c.l(r23) == false) goto L33;
        r24 = z0.a.a().fromJson(r23, Object.class);     // Catch: Throwable -> L22
        goto L34
    L33:
        r24 = null;
    L24:
        r114 = null;
        goto L26
    L87:
        if ((r112 instanceof fi.g) == false) goto L10;
        String r26 = "UTF-8";
        if (((fi.g) r112).f16910a == null) goto L17;
        r26 = fi.d.a(((fi.g) r112).f16910a);     // Catch: Throwable -> L82
    L17:
        r23 = new String(((fi.g) r112).f16911b, Charset.forName(r26));     // Catch: Throwable -> L82
    L39:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r115 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public static boolean k(float r5, float r10) {
        if (Float.isNaN(r5) == true) goto L12;
        if (Float.isNaN(r10) == true) goto L12;
        if (Math.abs(r10 - r5) >= 1.0E-5f) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (Float.isNaN(r5) == true) goto L14;
    L16:
        return false;
    L14:
        if (Float.isNaN(r10) == false) goto L16;
        return true;
    }

    public static void m(com.bytedance.ies.bullet.core.e r5, rd.b r10) {
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        r5.g.getClass();
        Lazy r11 = com.bytedance.ies.bullet.service.sdk.d.e;
        av.i.e().getClass();
        com.bytedance.ies.bullet.service.sdk.d.b(r10, td.c.class);
        r5.g.getClass();
    }

    public static void n(String r5, LinkedHashMap r10, c2.e r11, String r12, IHostNetworkDepend r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r5, "targetUrl");
        Intrinsics.checkNotNullParameter(r10, "headers");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r13, "hostNetworkDepend");
        c2.b r16 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r16.e = r10;
        r16.f1108a = r14;
        r16.f1109b = r15;
        Intrinsics.checkNotNullParameter(r13, "hostNetworkDepend");
        j(f0.m(RequestMethod.f1873a, r16, r13), r11, r12);
    }

    public static void o(String r5, LinkedHashMap r10, String r11, Object r12, c2.e r13, String r14, IHostNetworkDepend r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r5, "targetUrl");
        Intrinsics.checkNotNullParameter(r10, "headers");
        Intrinsics.checkNotNullParameter(r11, "contentType");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        if ((r12 instanceof byte[]) == false) goto L6;
        byte[] r18 = (byte[]) r12;
    L21:
        c2.b r19 = new c2.b(r5);
        Intrinsics.checkNotNullParameter(r10, "headers");
        r19.e = r10;
        Intrinsics.checkNotNullParameter(r11, "contentType");
        r19.d = r11;
        r19.f1108a = r16;
        r19.f1109b = r17;
        r19.f = r18;
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        j(f0.m(RequestMethod.f1875c, r19, r15), r13, r14);
        return;
    L6:
        if ((r12 instanceof String) == false) goto L9;
        r18 = ((String) r12).getBytes(Charsets.UTF_8);
        goto L21
    L9:
        if ((r12 instanceof JSONArray) == false) goto L12;
        r18 = ((JSONArray) r12).toString().getBytes(Charsets.UTF_8);
        goto L21
    L12:
        if ((r12 instanceof JSONObject) == false) goto L15;
        r18 = ((JSONObject) r12).toString().getBytes(Charsets.UTF_8);
        goto L21
    L15:
        if ((r12 instanceof List) == false) goto L18;
        r18 = new JSONArray((Collection) r12).toString().getBytes(Charsets.UTF_8);
        goto L21
    L18:
        if ((r12 instanceof Map) == false) goto L20;
        r18 = new JSONObject((Map) r12).toString().getBytes(Charsets.UTF_8);
        goto L21
    L20:
        r18 = new JSONObject().toString().getBytes(Charsets.UTF_8);
        goto L21
    }

    public static final int p(int r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        return q(r10, r5);
    }

    public static final int q(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != 0.0f) goto L6;
        return 0;
    L6:
        return MathKt.roundToInt(r10 * r5.getResources().getDisplayMetrics().density);
    }

    public static final float r(int r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r5 != 0) goto L6;
        return 0.0f;
    L6:
        return s(r10, r5);
    }

    public static final float s(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return TypedValue.applyDimension(1, r10, r5.getResources().getDisplayMetrics());
    }

    public static final float t(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return r10 * r5.getResources().getDisplayMetrics().density;
    }

    public static final int u(int r5) {
        return (int) ((r5 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final float v(float r5, float r10) {
        if (r5 != 0.0f) goto L6;
        return 0.0f;
    L6:
        return r5 * r10;
    }

    public static final int w(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DisplayMetrics r10 = r5.getResources().getDisplayMetrics();
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.heightPixels;
    }

    public static final int x(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DisplayMetrics r10 = r5.getResources().getDisplayMetrics();
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.widthPixels;
    }

    public static final int y(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return MathKt.roundToInt(r10 / r5.getResources().getDisplayMetrics().density);
    }

    public static final Object z(r r5, r r10, Function2 r11) {
    L5:
        th = move-exception;
        Object r12 = new v(false, th);
    L11:
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        Object r13 = r5.O(r12);
        if (r13 != j0.e) goto L17;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L17:
        if ((r13 instanceof v) == true) goto L21;
        return j0.k(r13);
    L21:
        throw ((v) r13).f19025a;
    L25:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L3:
        if ((r11 instanceof BaseContinuationImpl) == true) goto L7;
        r12 = IntrinsicsKt.wrapWithContinuationImpl(r11, r10, r5);     // Catch: Throwable -> L5
    L22:
        goto L11
    L7:
        r12 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, 2)).mo2invoke(r10, r5);     // Catch: Throwable -> L5
        goto L22
    }

    public abstract void d();

    public abstract void l();
}
