package com.bytedance.android.annie.service.network;

import android.text.TextUtils;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static final n a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ j a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ Throwable c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;

        public a(j r1, Integer r10, Throwable r11, String r12, int r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r0 = this.a;     // Catch: Throwable -> L11
            Integer r1 = this.b;     // Catch: Throwable -> L11
            Throwable r10 = this.c;     // Catch: Throwable -> L11
            String r11 = this.d;     // Catch: Throwable -> L11
            int r12 = this.e;     // Catch: Throwable -> L11
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
            if (r10 != null) goto L6;
            r10 = new Throwable(r11);     // Catch: Throwable -> L8
        L6:
            r0.c(r1, r10, r12);     // Catch: Throwable -> L8
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L19:
            return;
        L8:
            th = move-exception;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
            Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public n() {
    }

    static {
        a = new n();
    }

    public static Map a(Map r10) {
        if (r10 == null) goto L8;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r10.size()));
        Iterator r11 = r10.entrySet().iterator();
    L5:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r11.next();
        Object r12 = r1.getKey();
        a.getClass();
        r0.put(r12, e(r1));
        goto L5
    L10:
        return r0;
    L8:
        return MapsKt.emptyMap();
    }

    public static LinkedHashMap b(Map r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10 == null) goto L13;
        Iterator r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r11.next();
        n r12 = a;
        Object r13 = r1.getValue();
        r12.getClass();
        String r14 = e(r13);
        if (r14.length() <= 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L6;
        r0.put(r1.getKey(), r14);
        goto L6
    L10:
        r15 = false;
    L13:
        return r0;
    }

    public static String e(Object r1) {
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

    public static boolean c(Integer r10, String r11, Throwable r12, int r13, j r14) {
        boolean r0 = false;
        if (r12 == null) goto L5;
    L8:
        String r15 = null;
        if (r11 != null) goto L11;
    L17:
        if (r12 == null) goto L19;
        r15 = r12.getMessage();
    L19:
        if (r15 != null) goto L22;
        r11 = "";
    L21:
        String r16 = r11;
    L23:
        ThreadUtils.a().post(new a(r14, r10, r12, r16, r13));
        return true;
    L22:
        r16 = r15;
        goto L23
    L11:
        if (r11.length() <= 0) goto L13;
        r0 = true;
    L13:
        if (r0 == true) goto L16;
        r11 = null;
    L16:
        if (r11 != null) goto L21;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return false;
    }

    public static void d(String r26, LinkedHashMap r27, LinkedHashMap r28, Map r29, j r30, e r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r26, "targetUrl");
        Intrinsics.checkNotNullParameter(r27, "headers");
        Intrinsics.checkNotNullParameter(r28, "postFilePart");
        Intrinsics.checkNotNullParameter(r29, "params");
        Intrinsics.checkNotNullParameter(r30, "callback");
        Intrinsics.checkNotNullParameter(r31, "hostNetworkDepend");
        g r10 = new g(r26);
        Intrinsics.checkNotNullParameter(r27, "headers");
        r10.b = r27;
        Intrinsics.checkNotNullParameter(r28, "postFilePart");
        r10.e = r28;
        Intrinsics.checkNotNullParameter(r29, "params");
        r10.d = r29;
        r10.c = r32;
        Intrinsics.checkNotNullParameter(r31, "hostNetworkDepend");
        p r0 = p.a;
        RequestMethod r1 = RequestMethod.POST;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "method");
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r31, "hostNetworkDepend");
        LinkedHashMap r11 = new LinkedHashMap();
        Ref.IntRef r12 = new Ref.IntRef();
        r12.element = -1;
        Ref.IntRef r13 = new Ref.IntRef();
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = "";
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        Triple r17 = p.a(r10);     // Catch: Throwable -> L85
        String r18 = (String) r17.getFirst();     // Catch: Throwable -> L85
        String r19 = (String) r17.getSecond();     // Catch: Throwable -> L85
        LinkedHashMap r110 = (LinkedHashMap) r17.getThird();     // Catch: Throwable -> L85
        List<Header> r25 = p.b(r10);     // Catch: Throwable -> L85
        RequestContext r20 = new RequestContext();     // Catch: Throwable -> L85
        ((BaseRequestContext) r20).timeout_connect = 0;     // Catch: Throwable -> L83
        ((BaseRequestContext) r20).timeout_read = 0;     // Catch: Throwable -> L83
        ((BaseRequestContext) r20).timeout_write = 0;     // Catch: Throwable -> L83
        ((BaseRequestContext) r20).force_handle_response = !r10.c;     // Catch: Throwable -> L83
        IHostNetworkRuntimeApi r21 = (IHostNetworkRuntimeApi) ((e.a) r31.createRetrofit(r18, false)).create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L83
        int r111 = p.a.a[r1.ordinal()];     // Catch: Throwable -> L83
        if (r111 != 1) goto L8;
        if (r21 == null) goto L32;
        Call<String> r22 = r21.doGetForString(r10.c, -1, r19, r110, r25, r20);     // Catch: Throwable -> L83
    L122:
        if (r22 != null) goto L124;
        r14 = r14;
    L79:
        r15.element = "call is null, method is " + r1.name();     // Catch: Throwable -> L81
    L88:
        r r23 = new r(r11, r12, r14, r15, r16, r13);
        String r24 = r23.b();
        if (r24 != null) goto L91;
    L96:
        r24 = null;
    L97:
        Integer r33 = r23.a();
        if (r24 != null) goto L110;
        Integer r34 = Integer.valueOf(r12.element);
        String r35 = (String) r15.element;
        Throwable r36 = (Throwable) r16.element;
        if (r33 == null) goto L102;
        int r112 = r33.intValue();
    L104:
        if (c(r34, r35, r36, r112, r30) == true) goto L135;
        Integer r37 = Integer.valueOf(r12.element);
        if (r33 == null) goto L108;
        int r38 = r33.intValue();
    L109:
        ThreadUtils.a().post(new o(r24, r11, r30, r37, r38));
        return;
    L108:
        r38 = 0;
        goto L109
    L135:
        return;
    L102:
        r112 = 0;
        goto L104
    L110:
        Integer r39 = Integer.valueOf(r12.element);
        String r40 = (String) r15.element;
        Throwable r41 = (Throwable) r16.element;
        if (r33 == null) goto L113;
        int r113 = r33.intValue();
    L115:
        if (c(r39, r40, r41, r113, r30) == true) goto L137;
        Integer r42 = Integer.valueOf(r12.element);
        if (r33 == null) goto L119;
        int r43 = r33.intValue();
    L120:
        ThreadUtils.a().post(new o(r24, r11, r30, r42, r43));
        return;
    L119:
        r43 = 0;
        goto L120
    L137:
        return;
    L113:
        r113 = 0;
        goto L115
    L91:
        if (r24.length() <= 0) goto L93;
        boolean r114 = true;
    L94:
        if (r114 == false) goto L96;
    L93:
        r114 = false;
        goto L94
    L124:
        r12.element = 0;     // Catch: Throwable -> L76
        SsResponse r44 = r22.execute();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        if (r44 == null) goto L63;
        r12.element = r44.code();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        String r115 = (String) r44.body();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        if (r115 != null) goto L45;
        int r116 = l.a;     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        TypedInput r117 = r44.errorBody();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
        if (r117 != null) goto L44;
        r117 = r44.raw().getBody();     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
    L44:
        r115 = l.a(r117);     // Catch: CronetIOException -> L65 NetworkNotAvailabeException -> L68 HttpResponseException -> L71 Throwable -> L76
    L45:
        r14 = r14;
        r14.element = r115;     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        List r45 = r44.headers();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        if (r45 == null) goto L64;
        Iterator r46 = r45.iterator();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
    L50:
        if (r46.hasNext() == false) goto L55;
        Header r118 = (Header) r46.next();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        String r119 = r118.getName();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        String r120 = r118.getValue();     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        if (r120 != null) goto L54;
        r120 = "";
    L54:
        r11.put(r119, r120);     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
        goto L50
    L55:
        Unit r47 = Unit.INSTANCE;     // Catch: CronetIOException -> L57 NetworkNotAvailabeException -> L59 HttpResponseException -> L61 Throwable -> L81
    L74:
        if (r47 != null) goto L88;
    L64:
        r47 = null;
    L57:
        e = e;
    L67:
        r15.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L81
        p r48 = p.a;     // Catch: Throwable -> L81
        String r121 = e.getMessage();     // Catch: Throwable -> L81
        r48.getClass();     // Catch: Throwable -> L81
        r13.element = p.c(r121);     // Catch: Throwable -> L81
        r12.element = e.getStatusCode();     // Catch: Throwable -> L81
        r16.element = e;     // Catch: Throwable -> L81
        r47 = Unit.INSTANCE;     // Catch: Throwable -> L81
    L59:
        e = e;
    L70:
        r15.element = e.getClass().toString() + ':' + e.getMessage() + ",-1001";     // Catch: Throwable -> L81
        r12.element = -1001;     // Catch: Throwable -> L81
        r16.element = e;     // Catch: Throwable -> L81
        r47 = Unit.INSTANCE;     // Catch: Throwable -> L81
    L61:
        e = e;
    L73:
        r15.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L81
        p r49 = p.a;     // Catch: Throwable -> L81
        String r122 = e.getMessage();     // Catch: Throwable -> L81
        r49.getClass();     // Catch: Throwable -> L81
        r13.element = p.c(r122);     // Catch: Throwable -> L81
        r12.element = e.getStatusCode();     // Catch: Throwable -> L81
        r16.element = e;     // Catch: Throwable -> L81
        r47 = Unit.INSTANCE;     // Catch: Throwable -> L81
        goto L74
    L63:
        r14 = r14;
    L65:
        e = e;
        r14 = r14;
    L68:
        e = e;
        r14 = r14;
    L71:
        e = e;
        r14 = r14;
    L76:
        th = th;
        r14 = r14;
    L87:
        r15.element = "request for string cause exception";
        r16.element = th;
        b8.a r50 = b8.a.a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, (String) r15.element), true);
    L81:
        th = th;
    L32:
        r22 = null;
        goto L122
    L8:
        if (r111 != 2) goto L10;
        TypedOutput r210 = p.d(r10);     // Catch: Throwable -> L83
        if (r210 == null) goto L27;
        if (r21 == null) goto L23;
        Call<String> r123 = r21.doPostForString(r10.c, -1, r19, r110, r25, r210, r20);     // Catch: Throwable -> L83
    L24:
        if (r123 == null) goto L27;
        r22 = r123;
        goto L122
    L23:
        r123 = null;
    L27:
        if (r21 == null) goto L32;
        r22 = r21.doPostForString(r10.c, -1, r19, r110, r25, r10.d, r20);     // Catch: Throwable -> L83
        goto L122
    L10:
        if (r111 != 3) goto L12;
        TypedOutput r211 = p.d(r10);     // Catch: Throwable -> L83
        if (r21 == null) goto L32;
        r22 = r21.doPutForString(r10.c, -1, r19, r25, r211, r20);     // Catch: Throwable -> L83
        goto L122
    L12:
        if (r111 != 4) goto L32;
        if (r21 == null) goto L32;
        r22 = r21.doDeleteForString(r10.c, -1, r19, r25, r20);     // Catch: Throwable -> L83
    L83:
        th = th;
        r14 = r14;
    L85:
        th = th;
        goto L87
    }
}
