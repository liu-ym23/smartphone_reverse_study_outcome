package b4;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
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
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final e a = null;
    public static final String b = null;

    public e() {
    }

    static {
        a = new e();
        b = e.class.getSimpleName();
    }

    @JvmStatic
    public static final String a(TypedInput r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof TypedByteArray) == false) goto L17;
        String r11 = "UTF-8";
        if (((TypedByteArray) r10).mimeType() == null) goto L11;
        r11 = MimeUtil.parseCharset(((TypedByteArray) r10).mimeType(), "UTF-8");     // Catch: Throwable -> L14
    L11:
        return new String(((TypedByteArray) r10).getBytes(), Charset.forName(r11));
    L18:
        return null;
    L17:
        return null;
    }

    public static Map c(Map r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 == null) goto L15;
        Iterator r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r11.next();
        e r12 = a;
        Object r13 = r1.getValue();
        r12.getClass();
        String r14 = h(r13);
        if (com.bytedance.ai.utils.f.g((String) r1.getKey()) == false) goto L6;
        if (r14.length() <= 0) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L6;
        r0.put(r1.getKey(), r14);
        goto L6
    L12:
        r15 = false;
    L15:
        return r0;
    }

    public static String h(Object r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if ((r1 instanceof Map) == false) goto L9;
        return new JSONObject((Map) r1).toString();
    L9:
        if ((r1 instanceof List) == false) goto L12;
        return new JSONArray((Collection) r1).toString();
    L12:
        return r1.toString();
    }

    public static void e(m r11, h r12, String r13) {
        int r10 = r11.a();
        Integer r0 = r11.e();
        Map<String, String> r1 = r11.f();
        String r14 = r11.b();
        Throwable r15 = r11.c();
        Object r16 = "";
        byte[] r17 = null;
        boolean r18 = false;
        if (r15 != null) goto L7;
        if (TextUtils.isEmpty(r14) == false) goto L7;
    L28:
        if (r18 == true) goto L79;
        TypedByteArray r19 = r11.d();
        Map<String, String> r20 = r11.f();
        Integer r110 = r11.e();
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L60
        String r22 = a(r19);     // Catch: Throwable -> L48
        if (r13 == null) goto L36;
        String r111 = StringsKt.trim(r13).toString();     // Catch: Throwable -> L48
        if (r111 == null) goto L36;
        String r112 = r111.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L48
    L38:
        if (Intrinsics.areEqual(r112, "string") == false) goto L43;
        if (r22 == null) goto L46;
        r16 = r22;
    L46:
        r12.b(r16, r20, r110, r10);     // Catch: Throwable -> L48
    L58:
        Object r113 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r23 = Result.exceptionOrNull-impl(r113);
        if (r23 != null) goto L66;
        return;
    L66:
        if ((r19 instanceof TypedByteArray) == false) goto L68;
        TypedByteArray r24 = r19;
    L69:
        if (r24 == null) goto L71;
        r17 = r24.getBytes();
    L71:
        r12.a(Base64.encodeToString(r17, 2), r20, r23, r110, r10);
        return;
    L68:
        r24 = null;
        goto L69
    L43:
        if (com.bytedance.ai.utils.f.g(r22) == false) goto L45;
        Lazy r114 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L48
        r16 = com.bytedance.ai.applet.base.gson.e.a(r22, Object.class);     // Catch: Throwable -> L48
        goto L46
    L45:
        r16 = null;
    L36:
        r112 = null;
    L48:
        th = move-exception;
        if ((r19 instanceof TypedByteArray) == false) goto L53;
        TypedByteArray r115 = r19;     // Catch: Throwable -> L60
    L54:
        if (r115 == null) goto L56;
        byte[] r116 = r115.getBytes();     // Catch: Throwable -> L60
    L57:
        r12.a(Base64.encodeToString(r116, 2), r20, th, r110, r10);     // Catch: Throwable -> L60
        goto L58
    L56:
        r116 = null;
        goto L57
    L53:
        r115 = null;
    L60:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L79:
        return;
    L7:
        if (r14 != null) goto L9;
    L15:
        if (r15 == null) goto L17;
        r14 = r15.getMessage();
    L18:
        if (r14 != null) goto L77;
        r14 = "";
    L77:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L25
        if (r15 != null) goto L23;
        r15 = new Throwable(r14);     // Catch: Throwable -> L25
    L23:
        r12.c(r0, r1, r15, r10);     // Catch: Throwable -> L25
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        r18 = true;
    L25:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L17:
        r14 = null;
        goto L18
    L9:
        if (r14.length() <= 0) goto L11;
        r18 = true;
    L11:
        if (r18 == true) goto L14;
        r14 = null;
    L14:
        if (r14 != null) goto L77;
        goto L15
    }

    public static /* synthetic */ void b(e r10, String r11, Map r12, h r13, String r14, IHostNetworkDepend r15, boolean r16, boolean r17) {
        r10.delete(r11, r12, r13, r14, r15, r16, r17, -1);
    }

    public static void d(e r10, String r11, Map r12, h r13, String r14, IHostNetworkDepend r15, boolean r16, boolean r17) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "targetUrl");
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        f r1 = new f(r11);
        Intrinsics.checkNotNullParameter(r12, "headers");
        r1.b = r12;
        r1.c = r16;
        r1.j = r17;
        r1.k = -1;
        Intrinsics.checkNotNullParameter(r15, "hostNetworkDepend");
        b r18 = b.a;
        RequestMethod r19 = RequestMethod.GET;
        r18.getClass();
        e(b.f(r19, r1, r15), r13, r14);
    }

    public final void delete(String r10, Map<String, String> r11, h r12, String r13, IHostNetworkDepend r14, boolean r15, boolean r16, int r17) {
        Intrinsics.checkNotNullParameter(r10, "targetUrl");
        Intrinsics.checkNotNullParameter(r11, "headers");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r14, "hostNetworkDepend");
        f r1 = new f(r10);
        Intrinsics.checkNotNullParameter(r11, "headers");
        r1.b = r11;
        r1.c = r15;
        r1.j = r16;
        r1.k = r17;
        e(r1.delete(r14), r12, r13);
    }

    public static void f(e r10, String r11, Map r12, String r13, Object r14, h r15, String r16, IHostNetworkDepend r17, boolean r18, boolean r19) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "targetUrl");
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "contentType");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        if ((r14 instanceof byte[]) == false) goto L5;
        f r20 = new f(r11);
        Intrinsics.checkNotNullParameter(r12, "headers");
        r20.b = r12;
        Intrinsics.checkNotNullParameter(r13, "contentType");
        r20.f = r13;
        r20.c = r18;
        r20.j = r19;
        r20.e = (byte[]) r14;
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        b r21 = b.a;
        RequestMethod r22 = RequestMethod.POST;
        r21.getClass();
        e(b.f(r22, r20, r17), r15, r16);
        return;
    L5:
        boolean r23 = r14 instanceof Map;
        if (r23 == false) goto L15;
        if (Intrinsics.areEqual(r13, "application/json") == true) goto L15;
        LinkedHashMap r24 = new LinkedHashMap();
        Iterator r25 = ((Map) r14).entrySet().iterator();
    L11:
        if (r25.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) r25.next();
        r24.put(String.valueOf(r0.getKey()), String.valueOf(r0.getValue()));
        goto L11
    L13:
        f r26 = new f(r11);
        Intrinsics.checkNotNullParameter(r12, "headers");
        r26.b = r12;
        Intrinsics.checkNotNullParameter(r24, "params");
        r26.d = r24;
        r26.c = r18;
        r26.j = r19;
        r26.k = -1;
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        b r27 = b.a;
        RequestMethod r28 = RequestMethod.POST;
        r27.getClass();
        e(b.f(r28, r26, r17), r15, r16);
        return;
    L15:
        if ((r14 instanceof String) == false) goto L18;
        byte[] r29 = ((String) r14).getBytes(Charsets.UTF_8);
    L23:
        f r30 = new f(r11);
        Intrinsics.checkNotNullParameter(r12, "headers");
        r30.b = r12;
        Intrinsics.checkNotNullParameter(r13, "contentType");
        r30.f = r13;
        r30.c = r18;
        r30.j = r19;
        r30.e = r29;
        r30.k = -1;
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        b r31 = b.a;
        RequestMethod r32 = RequestMethod.POST;
        r31.getClass();
        e(b.f(r32, r30, r17), r15, r16);
        return;
    L18:
        if ((r14 instanceof List) == false) goto L20;
        r29 = new JSONArray((Collection) r14).toString().getBytes(Charsets.UTF_8);
        goto L23
    L20:
        if (r23 == false) goto L22;
        r29 = new JSONObject((Map) r14).toString().getBytes(Charsets.UTF_8);
        goto L23
    L22:
        r29 = new JSONObject().toString().getBytes(Charsets.UTF_8);
        goto L23
    }

    public static void g(e r10, String r11, Map r12, String r13, Object r14, h r15, String r16, IHostNetworkDepend r17, boolean r18, boolean r19) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "targetUrl");
        Intrinsics.checkNotNullParameter(r12, "headers");
        Intrinsics.checkNotNullParameter(r13, "contentType");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        if ((r14 instanceof byte[]) == false) goto L6;
        byte[] r20 = (byte[]) r14;
    L21:
        f r21 = new f(r11);
        Intrinsics.checkNotNullParameter(r12, "headers");
        r21.b = r12;
        Intrinsics.checkNotNullParameter(r13, "contentType");
        r21.f = r13;
        r21.c = r18;
        r21.j = r19;
        r21.e = r20;
        r21.k = -1;
        Intrinsics.checkNotNullParameter(r17, "hostNetworkDepend");
        b r22 = b.a;
        RequestMethod r23 = RequestMethod.PUT;
        r22.getClass();
        e(b.f(r23, r21, r17), r15, r16);
        return;
    L6:
        if ((r14 instanceof String) == false) goto L9;
        r20 = ((String) r14).getBytes(Charsets.UTF_8);
        goto L21
    L9:
        if ((r14 instanceof JSONArray) == false) goto L12;
        r20 = ((JSONArray) r14).toString().getBytes(Charsets.UTF_8);
        goto L21
    L12:
        if ((r14 instanceof JSONObject) == false) goto L15;
        r20 = ((JSONObject) r14).toString().getBytes(Charsets.UTF_8);
        goto L21
    L15:
        if ((r14 instanceof List) == false) goto L18;
        r20 = new JSONArray((Collection) r14).toString().getBytes(Charsets.UTF_8);
        goto L21
    L18:
        if ((r14 instanceof Map) == false) goto L20;
        r20 = new JSONObject((Map) r14).toString().getBytes(Charsets.UTF_8);
        goto L21
    L20:
        r20 = new JSONObject().toString().getBytes(Charsets.UTF_8);
        goto L21
    }
}
