package b4;

import android.util.Pair;
import com.bytedance.ai.bridge.method.net.core.IHostNetworkRuntimeApi;
import com.bytedance.ai.bridge.method.net.core.RequestMethod;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RequestMethod.values().length];
            r0[RequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[RequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[RequestMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[RequestMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    public static Triple a(f r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        Pair r11 = UrlUtils.parseUrl(new UrlBuilder(r10.a).build(), r0);
        return new Triple((String) r11.first, (String) r11.second, r0);
    }

    public static List b(f r10) {
        ArrayList r0 = new ArrayList();
        Map<String, String> r1 = r10.b;
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, String>> r11 = r1.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<String, String> r12 = r11.next();
        r0.add(new Header(r12.getKey(), r12.getValue()));
    L8:
        String r13 = r10.f;
        if (r13 == null) goto L11;
        r0.add(new Header("Content-Type", r13));
    L11:
        return r0;
    }

    public static int c(String r14) {
        if (r14 != null) goto L13;
        return 0;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        int r10 = StringsKt.lastIndexOf$default(r14, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L7
        return CastIntegerProtector.parseInt(r14.substring(r10 + 18, StringsKt.indexOf$default(r14, ',', r10, false, 4, null)));
    L7:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r15) == false) goto L12;
        r15 = 0;
    L12:
        return ((Number) r15).intValue();
    }

    public static TypedByteArray d(f r10) {
        byte[] r0 = r10.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new TypedByteArray(r10.f, r0, new String[0]);
    }

    public static c e(RequestMethod r25, f r26, IHostNetworkDepend r27) {
        Intrinsics.checkNotNullParameter(r25, "method");
        Intrinsics.checkNotNullParameter(r26, "request");
        Intrinsics.checkNotNullParameter(r27, "hostNetworkDepend");
        LinkedHashMap r10 = new LinkedHashMap();
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = -1;
        Ref.IntRef r12 = new Ref.IntRef();
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = "";
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        Triple r17 = a(r26);     // Catch: Throwable -> L35
        String r18 = (String) r17.getFirst();     // Catch: Throwable -> L35
        String r19 = (String) r17.getSecond();     // Catch: Throwable -> L35
        Map<String, String> r20 = (Map) r17.getThird();     // Catch: Throwable -> L35
        List<Header> r21 = b(r26);     // Catch: Throwable -> L35
        RequestContext r110 = new RequestContext();     // Catch: Throwable -> L35
        ((BaseRequestContext) r110).timeout_connect = r26.g;     // Catch: Throwable -> L35
        ((BaseRequestContext) r110).timeout_read = r26.h;     // Catch: Throwable -> L35
        ((BaseRequestContext) r110).timeout_write = r26.i;     // Catch: Throwable -> L35
        ((BaseRequestContext) r110).force_handle_response = !r26.c;     // Catch: Throwable -> L35
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L35
        r22.put("isCustomizedCookie", Boolean.valueOf(r26.j));     // Catch: Throwable -> L35
        r22.put("needAddCommonParams", Boolean.valueOf(r26.c));     // Catch: Throwable -> L35
        IAppletRetrofit r1 = r27.createRetrofit(r18, false, r22);     // Catch: Throwable -> L35
        InputStream r23 = null;
        if (r1 == null) goto L6;
        IHostNetworkRuntimeApi r24 = (IHostNetworkRuntimeApi) r1.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L35
    L7:
        int r111 = a.a[r25.ordinal()];     // Catch: Throwable -> L35
        if (r111 != 1) goto L10;
        if (r24 == null) goto L18;
        Call<TypedInput> r0 = r24.streamGet(r26.c, -1, r19, r20, r21, r110);     // Catch: Throwable -> L35
    L19:
        if (r0 == null) goto L39;
        r11.element = 0;     // Catch: Throwable -> L35
        r16.element = new WeakReference(r0);     // Catch: Throwable -> L35
        SsResponse r28 = r0.execute();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        r11.element = r28.code();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        TypedInput r29 = (TypedInput) r28.body();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        if (r29 == null) goto L25;
        r23 = r29.in();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L25:
        r13.element = r23;     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        Iterator r30 = r28.headers().iterator();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L26:
        if (r30.hasNext() == false) goto L43;
        Header r31 = (Header) r30.next();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        String r32 = r31.getName();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        String r33 = r31.getValue();     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
        if (r33 != null) goto L31;
        r33 = "";
    L31:
        r10.put(r32, r33);     // Catch: CronetIOException -> L33 Throwable -> L35 HttpResponseException -> L37
    L43:
        return new c(r10, r11, r13, r14, r15, r12, r16);
    L37:
        e = move-exception;
        r14.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L35
        r11.element = e.getStatusCode();     // Catch: Throwable -> L35
        b r34 = a;     // Catch: Throwable -> L35
        String r35 = e.getMessage();     // Catch: Throwable -> L35
        r34.getClass();     // Catch: Throwable -> L35
        r12.element = c(r35);     // Catch: Throwable -> L35
        r15.element = e;     // Catch: Throwable -> L35
    L33:
        e = move-exception;
        r14.element = e.getClass() + ':' + e.getMessage() + ",-1";     // Catch: Throwable -> L35
        r11.element = e.getStatusCode();     // Catch: Throwable -> L35
        b r36 = a;     // Catch: Throwable -> L35
        String r37 = e.getMessage();     // Catch: Throwable -> L35
        r36.getClass();     // Catch: Throwable -> L35
        r12.element = c(r37);     // Catch: Throwable -> L35
        r15.element = e;     // Catch: Throwable -> L35
        goto L43
    L39:
        String r38 = "call is null, method is " + r25.name();     // Catch: Throwable -> L35
        r14.element = r38;     // Catch: Throwable -> L35
        Logger.d("HostNetworkDependImpl", r38);     // Catch: Throwable -> L35
    L18:
        r0 = null;
        goto L19
    L10:
        if (r111 != 2) goto L18;
        TypedByteArray r210 = d(r26);     // Catch: Throwable -> L35
        if (r210 == null) goto L18;
        if (r24 == null) goto L18;
        r0 = r24.streamPost(r26.c, -1, r19, r20, r21, r210, r110);     // Catch: Throwable -> L35
        goto L19
    L6:
        r24 = null;
    L35:
        th = move-exception;
        r14.element = "request for string cause exception";
        r15.element = th;
        Logger.e("HostNetworkDependImpl", (String) r14.element, th);
        goto L43
    }

    public static d f(RequestMethod r25, f r26, IHostNetworkDepend r27) {
        Intrinsics.checkNotNullParameter(r25, "method");
        Intrinsics.checkNotNullParameter(r26, "request");
        Intrinsics.checkNotNullParameter(r27, "hostNetworkDepend");
        LinkedHashMap r10 = new LinkedHashMap();
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = -1;
        Ref.IntRef r12 = new Ref.IntRef();
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = "";
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Triple r16 = a(r26);     // Catch: Throwable -> L60
        String r17 = (String) r16.getFirst();     // Catch: Throwable -> L60
        String r18 = (String) r16.getSecond();     // Catch: Throwable -> L60
        Map<String, String> r19 = (Map) r16.getThird();     // Catch: Throwable -> L60
        List<Header> r23 = b(r26);     // Catch: Throwable -> L60
        RequestContext r110 = new RequestContext();     // Catch: Throwable -> L60
        ((BaseRequestContext) r110).timeout_connect = r26.g;     // Catch: Throwable -> L60
        ((BaseRequestContext) r110).timeout_read = r26.h;     // Catch: Throwable -> L60
        ((BaseRequestContext) r110).timeout_write = r26.i;     // Catch: Throwable -> L60
        ((BaseRequestContext) r110).force_handle_response = !r26.c;     // Catch: Throwable -> L60
        LinkedHashMap r20 = new LinkedHashMap();     // Catch: Throwable -> L60
        r20.put("isCustomizedCookie", Boolean.valueOf(r26.j));     // Catch: Throwable -> L60
        r20.put("needAddCommonParams", Boolean.valueOf(r26.c));     // Catch: Throwable -> L60
        IAppletRetrofit r1 = r27.createRetrofit(r17, false, r20);     // Catch: Throwable -> L60
        if (r1 == null) goto L6;
        IHostNetworkRuntimeApi r21 = (IHostNetworkRuntimeApi) r1.create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L60
    L7:
        int r111 = a.a[r25.ordinal()];     // Catch: Throwable -> L60
        if (r111 == 1) goto L31;
        if (r111 != 2) goto L12;
        TypedByteArray r22 = d(r26);     // Catch: Throwable -> L60
        if (r22 == null) goto L28;
        if (r21 == null) goto L26;
        Call<TypedInput> r24 = r21.post(r26.c, r26.k, r18, r19, r23, r22, r110);     // Catch: Throwable -> L60
    L27:
        if (r24 == null) goto L28;
    L34:
        if (r24 == null) goto L66;
        r11.element = 0;     // Catch: Throwable -> L60
        SsResponse r28 = r24.execute();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r11.element = r28.code();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r13.element = r28.body();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        Iterator r29 = r28.headers().iterator();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L38:
        if (r29.hasNext() == false) goto L70;
        Header r30 = (Header) r29.next();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r26.j == false) goto L53;
        if (Intrinsics.areEqual(r30.getName(), "set-cookie") == true) goto L47;
        if (Intrinsics.areEqual(r30.getName(), "Set-Cookie") == false) goto L53;
    L47:
        if (r10.containsKey(r30.getName()) == true) goto L48;
        String r112 = r30.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        String r31 = r30.getValue();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r31 != null) goto L52;
        r31 = "";
    L52:
        r10.put(r112, r31);     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        goto L38
    L48:
        String r113 = r30.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        r10.put(r113, ((String) r10.get(r113)) + ", " + r30.getValue());     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L53:
        String r114 = r30.getName();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        String r32 = r30.getValue();     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
        if (r32 != null) goto L56;
        r32 = "";
    L56:
        r10.put(r114, r32);     // Catch: CronetIOException -> L58 Throwable -> L60 NetworkNotAvailabeException -> L62 HttpResponseException -> L64
    L70:
        return new d(r10, r11, r13, r14, r15, r12);
    L64:
        e = move-exception;
        r14.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L60
        b r33 = a;     // Catch: Throwable -> L60
        String r34 = e.getMessage();     // Catch: Throwable -> L60
        r33.getClass();     // Catch: Throwable -> L60
        r12.element = c(r34);     // Catch: Throwable -> L60
        r11.element = e.getStatusCode();     // Catch: Throwable -> L60
        r15.element = e;     // Catch: Throwable -> L60
    L62:
        e = move-exception;
        r14.element = e.getClass() + ':' + e.getMessage() + ",-1001";     // Catch: Throwable -> L60
        r11.element = -1001;     // Catch: Throwable -> L60
        r15.element = e;     // Catch: Throwable -> L60
    L58:
        e = move-exception;
        r14.element = e.getClass() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L60
        b r35 = a;     // Catch: Throwable -> L60
        String r36 = e.getMessage();     // Catch: Throwable -> L60
        r35.getClass();     // Catch: Throwable -> L60
        r12.element = c(r36);     // Catch: Throwable -> L60
        r11.element = e.getStatusCode();     // Catch: Throwable -> L60
        r15.element = e;     // Catch: Throwable -> L60
        goto L70
    L66:
        String r0 = "call is null, method is " + r25.name();     // Catch: Throwable -> L60
        r14.element = r0;     // Catch: Throwable -> L60
        Logger.d("HostNetworkDependImpl", r0);     // Catch: Throwable -> L60
        goto L70
    L26:
        r24 = null;
    L28:
        if (r21 == null) goto L33;
        r24 = r21.post(r26.c, r26.k, r18, r19, r23, r26.d, r110);     // Catch: Throwable -> L60
    L33:
        r24 = null;
        goto L34
    L12:
        if (r111 != 3) goto L14;
        TypedByteArray r210 = d(r26);     // Catch: Throwable -> L60
        if (r21 == null) goto L33;
        r24 = r21.put(r26.c, r26.k, r18, r23, r210, r110);     // Catch: Throwable -> L60
        goto L34
    L14:
        if (r111 != 4) goto L18;
        if (r21 == null) goto L33;
        r24 = r21.delete(r26.c, r26.k, r18, r23, r110);     // Catch: Throwable -> L60
        goto L34
    L18:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L60
    L31:
        if (r21 == null) goto L33;
        r24 = r21.get(r26.c, r26.k, r18, r19, r23, r110);     // Catch: Throwable -> L60
        goto L34
    L6:
        r21 = null;
    L60:
        th = move-exception;
        r14.element = "request for string cause exception";
        r15.element = th;
        Logger.e("HostNetworkDependImpl", (String) r14.element, th);
        goto L70
    }
}
