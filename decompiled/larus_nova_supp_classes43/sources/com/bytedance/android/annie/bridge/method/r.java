package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.service.network.IHostNetworkRuntimeApi;
import com.bytedance.android.annie.service.network.RequestMethod;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements Runnable {
    public final /* synthetic */ DownloadFileMethod.a a;
    public final /* synthetic */ DownloadFileMethod b;
    public final /* synthetic */ CallContext c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;

    public static final class a {
        public final /* synthetic */ String a;
        public final /* synthetic */ DownloadFileMethod.a b;
        public final /* synthetic */ DownloadFileMethod c;
        public final /* synthetic */ Context d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v12 */
        public final void a(com.bytedance.android.annie.service.network.q r24) {
            com.bytedance.android.annie.service.network.q r10 = r24;
            String r0 = r24.c();
            if (r0.length() <= 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == true) goto L9;
            r0 = null;
        L9:
            if (r0 != null) goto L21;
            Throwable r1 = r24.d();
            if (r1 == null) goto L20;
            r0 = r1.getMessage();
            if (r0 == null) goto L20;
            if (r0.length() <= 0) goto L17;
            boolean r12 = true;
        L18:
            if (r12 == false) goto L20;
        L17:
            r12 = false;
        L20:
            r0 = null;
        L21:
            InputStream r13 = r24.e();
            int r14 = r10.b.element;
            Integer r15 = r24.b();
            if (r13 != null) goto L25;
            ThreadUtils.a().post(new m(this.c, r0, r14, r15));
            return;
        L25:
            LinkedHashMap<String, String> r16 = r10.a;
            BufferedInputStream r17 = new BufferedInputStream(r13);     // Catch: Throwable -> L182 Exception -> L185
            BufferedOutputStream r18 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.a));     // Catch: Throwable -> L178 Exception -> L180
        L232:
            Ref.IntRef r19 = new Ref.IntRef();     // Catch: Throwable -> L172 Exception -> L175
            byte[] r20 = new byte[4096];     // Catch: Throwable -> L172 Exception -> L175
        L29:
            int r21 = r17.read(r20);     // Catch: Throwable -> L172 Exception -> L175
            r19.element = r21;     // Catch: Throwable -> L172 Exception -> L175
            if (r21 == (-1)) goto L38;
            r18.write(r20, 0, r21);     // Catch: Throwable -> L34 Exception -> L36
        L36:
            e = e;
            BufferedOutputStream r110 = r18;
            BufferedInputStream r22 = r17;
            Integer r23 = r15;
        L215:
            ThreadUtils.a().post(new p(this.c, e, r14, r23));     // Catch: Throwable -> L198
            r24.a();     // Catch: IOException -> L195
            if (r22 == null) goto L192;
            r22.close();     // Catch: IOException -> L195
        L192:
            if (r110 == null) goto L239;
            r110.close();     // Catch: IOException -> L195
            return;
        L239:
            return;
        L198:
            th = move-exception;
            Throwable r25 = th;
        L213:
            r24.a();     // Catch: IOException -> L206
            if (r22 == null) goto L203;
            r22.close();     // Catch: IOException -> L206
        L203:
            if (r110 == null) goto L242;
            r110.close();     // Catch: IOException -> L206
            throw r25;
        L242:
            throw r25;
        L206:
            e = move-exception;
            e.printStackTrace();
            throw r25;
        L34:
            th = move-exception;
            r25 = th;
            r110 = r18;
            r22 = r17;
            goto L213
        L38:
            r18.flush();     // Catch: Throwable -> L172 Exception -> L175
            if (this.b.e() == null) goto L165;
            Ref.ObjectRef r26 = new Ref.ObjectRef();     // Catch: Throwable -> L172 Exception -> L175
            IHybridComponent r27 = this.c.a;     // Catch: Throwable -> L172 Exception -> L175
            if ((r27 instanceof com.bytedance.android.annie.container.fragment.o) == false) goto L43;
            com.bytedance.android.annie.container.fragment.o r28 = (com.bytedance.android.annie.container.fragment.o) r27;     // Catch: Throwable -> L34 Exception -> L36
        L44:
            if (r28 == null) goto L60;
            c7.a r29 = r28.getAnnieContext();     // Catch: Throwable -> L34 Exception -> L36
            if (r29 == null) goto L60;
            DownloadFileMethod r30 = this.c;     // Catch: Throwable -> L34 Exception -> L36
            WeakReference<HybridFragment> r31 = AnnieFragmentManager.b(r29.getUuid());     // Catch: Throwable -> L34 Exception -> L36
            if (r31 == null) goto L50;
            Object r32 = (HybridFragment) r31.get();     // Catch: Throwable -> L34 Exception -> L36
        L52:
            if ((r32 instanceof com.bytedance.android.annie.container.fragment.q) == false) goto L54;
            com.bytedance.android.annie.container.fragment.q r33 = (com.bytedance.android.annie.container.fragment.q) r32;     // Catch: Throwable -> L34 Exception -> L36
        L55:
            if (r33 != null) goto L57;
            r33 = r30.b;     // Catch: Throwable -> L34 Exception -> L36
        L57:
            r26.element = r33;     // Catch: Throwable -> L34 Exception -> L36
            goto L60
        L54:
            r33 = null;
            goto L55
        L50:
            r32 = null;
        L60:
            if (com.bytedance.android.annie.util.d.e() == false) goto L65;
            int r34 = com.bytedance.android.annie.util.k.a;     // Catch: Throwable -> L34 Exception -> L36
            Context r35 = this.d;     // Catch: Throwable -> L34 Exception -> L36
            String r36 = this.a;     // Catch: Throwable -> L34 Exception -> L36
            String r111 = this.b.e();     // Catch: Throwable -> L34 Exception -> L36
            Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L34 Exception -> L36
            Pair r37 = com.bytedance.android.annie.util.k.b(r35, r36, Intrinsics.areEqual(r111, "image"));     // Catch: Throwable -> L34 Exception -> L36
            BufferedOutputStream r210 = r18;
            BufferedInputStream r112 = r17;
            Integer r211 = r15;
            int r38 = -1;
        L68:
            if (r37 == null) goto L72;
            Uri r39 = (Uri) r37.getFirst();     // Catch: Exception -> L70 Throwable -> L168
        L73:
            if (r37 == null) goto L75;
            Integer r40 = (Integer) r37.getSecond();     // Catch: Exception -> L70 Throwable -> L168
        L76:
            if (r39 == null) goto L78;
            boolean r41 = true;
        L79:
            if (r39 != null) goto L85;
            if (r40 == null) goto L85;
            if (r40.intValue() != r38) goto L85;
            boolean r42 = true;
        L87:
            if (ContextCompat.checkSelfPermission(this.d, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L89;
            boolean r113 = true;
        L90:
            DownloadFileMethod.DownloadFileResModel r43 = new DownloadFileMethod.DownloadFileResModel();     // Catch: Exception -> L70 Throwable -> L168
            if (r41 == false) goto L110;
            r43.b(DownloadFileMethod.DownloadFileResModel.Code.Success);     // Catch: Exception -> L70 Throwable -> L168
            r43.f("Success");     // Catch: Exception -> L70 Throwable -> L168
            Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L95
            Object r45 = Result.constructor-impl(Integer.valueOf(r14));     // Catch: Throwable -> L95
        L98:
            if (Result.isFailure-impl(r45) == false) goto L100;
            r45 = 0;
        L100:
            r43.e((Integer) r45);     // Catch: Exception -> L70 Throwable -> L168
            Object r46 = Result.constructor-impl(r211);     // Catch: Throwable -> L103
        L107:
            if (Result.isFailure-impl(r46) == false) goto L109;
            r46 = 0;
        L109:
            r43.a((Integer) r46);     // Catch: Exception -> L70 Throwable -> L168
            r43.d(r16);     // Catch: Exception -> L70 Throwable -> L168
            r43.c(String.valueOf(r39));     // Catch: Exception -> L70 Throwable -> L168
        L156:
            if (r41 == true) goto L158;
            if (r42 == false) goto L158;
        L222:
            r24.a();     // Catch: IOException -> L161
            r112.close();     // Catch: IOException -> L161
            r210.close();     // Catch: IOException -> L161
            return;
        L161:
            e = move-exception;
            e.printStackTrace();
            return;
        L158:
            ThreadUtils.a().post(new n(this.c, r43));     // Catch: Throwable -> L168 Exception -> L170
        L103:
            th = move-exception;
            Result.Companion r47 = Result.Companion;     // Catch: Exception -> L70 Throwable -> L168
            r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L70 Throwable -> L168
        L95:
            th = move-exception;
            Result.Companion r48 = Result.Companion;     // Catch: Exception -> L70 Throwable -> L168
            r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L70 Throwable -> L168
            goto L98
        L110:
            if (r113 == false) goto L133;
            r43.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);     // Catch: Exception -> L70 Throwable -> L168
            r43.f("Failed");     // Catch: Exception -> L70 Throwable -> L168
            Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L114
            Object r50 = Result.constructor-impl(Integer.valueOf(r14));     // Catch: Throwable -> L114
        L117:
            if (Result.isFailure-impl(r50) == false) goto L119;
            r50 = 0;
        L119:
            r43.e((Integer) r50);     // Catch: Exception -> L70 Throwable -> L168
            Integer r51 = r211;
            if (r51 != null) goto L211;
            Integer r52 = null;
        L126:
            Object r53 = Result.constructor-impl(r52);     // Catch: Throwable -> L123
        L130:
            if (Result.isFailure-impl(r53) == false) goto L132;
            r53 = 0;
        L132:
            r43.a((Integer) r53);     // Catch: Throwable -> L168 Exception -> L170
        L123:
            th = move-exception;
            Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L168 Exception -> L170
            r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L168 Exception -> L170
            goto L130
        L211:
            r52 = Integer.valueOf(r51.intValue());     // Catch: Throwable -> L123
        L114:
            th = move-exception;
            Result.Companion r55 = Result.Companion;     // Catch: Exception -> L70 Throwable -> L168
            r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L70 Throwable -> L168
            goto L117
        L133:
            Integer r56 = r211;
            if (r42 == true) goto L156;
            r43.b(DownloadFileMethod.DownloadFileResModel.Code.FailedPermissionRejected);     // Catch: Throwable -> L168 Exception -> L170
            r43.f("Failed for no permission");     // Catch: Throwable -> L168 Exception -> L170
            Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L138
            Object r58 = Result.constructor-impl(Integer.valueOf(r14));     // Catch: Throwable -> L138
        L141:
            if (Result.isFailure-impl(r58) == false) goto L143;
            r58 = 0;
        L143:
            r43.e((Integer) r58);     // Catch: Throwable -> L168 Exception -> L170
            if (r56 != null) goto L217;
            Integer r59 = null;
        L149:
            Object r60 = Result.constructor-impl(r59);     // Catch: Throwable -> L146
        L153:
            if (Result.isFailure-impl(r60) == false) goto L155;
            r60 = 0;
        L155:
            r43.a((Integer) r60);     // Catch: Throwable -> L168 Exception -> L170
        L146:
            th = move-exception;
            Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L168 Exception -> L170
            r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L168 Exception -> L170
            goto L153
        L217:
            r59 = Integer.valueOf(r56.intValue());     // Catch: Throwable -> L146
        L138:
            th = move-exception;
            Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L168 Exception -> L170
            r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L168 Exception -> L170
            goto L141
        L89:
            r113 = false;
        L85:
            r42 = false;
            goto L87
        L78:
            r41 = false;
            goto L79
        L75:
            r40 = null;
            goto L76
        L72:
            r39 = null;
            goto L73
        L65:
            int r63 = com.bytedance.android.annie.util.k.a;     // Catch: Throwable -> L172 Exception -> L175
            Context r114 = this.d;     // Catch: Throwable -> L172 Exception -> L175
            String r115 = this.a;     // Catch: Throwable -> L172 Exception -> L175
            String r64 = this.b.e();     // Catch: Throwable -> L172 Exception -> L175
            Intrinsics.checkNotNull(r64);     // Catch: Throwable -> L172 Exception -> L175
            r210 = r18;
            r38 = -1;
            r112 = r17;
            Integer r212 = r15;
            r37 = com.bytedance.android.annie.util.k.a(r114, r115, Intrinsics.areEqual(r64, "image"), (com.bytedance.android.annie.container.fragment.q) r26.element, new q(this.d, this.a, this.b, r16, r14, r15, this.c));     // Catch: Exception -> L70 Throwable -> L168
            r211 = r212;
        L70:
            e = e;
            r10 = r212;
        L177:
            r22 = r112;
            r110 = r210;
            r23 = r10;
            goto L215
        L43:
            r28 = null;
            goto L44
        L165:
            ThreadUtils.a().post(new o(this.c, r16, this.a, r14, r15));     // Catch: Throwable -> L168 Exception -> L170
            r24.a();     // Catch: IOException -> L195
            r17.close();     // Catch: IOException -> L195
            r18.close();     // Catch: IOException -> L195
            return;
        L170:
            e = e;
        L168:
            th = th;
        L174:
            r25 = th;
            r22 = r17;
            r110 = r18;
        L175:
            e = e;
            r210 = r18;
            r112 = r17;
            r10 = r15;
        L172:
            th = th;
        L180:
            e = e;
            r22 = r17;
        L187:
            r110 = null;
            r23 = r15;
        L178:
            th = move-exception;
            r25 = th;
            r22 = r17;
        L184:
            r110 = null;
            goto L213
        L195:
            e = move-exception;
            e.printStackTrace();
            return;
        L185:
            e = e;
            r22 = null;
        L182:
            th = move-exception;
            r25 = th;
            r22 = null;
            goto L184
        L5:
            r11 = false;
            goto L6
        }

        public a(String r1, DownloadFileMethod.a r10, DownloadFileMethod r11, Context r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public r(DownloadFileMethod.a r1, DownloadFileMethod r10, CallContext r11, String r12, Context r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a() {
        com.bytedance.android.annie.service.network.n r0 = com.bytedance.android.annie.service.network.n.a;
        String r10 = this.a.f();
        Intrinsics.checkNotNull(r10);
        Map<String, Object> r11 = this.a.d();
        IHybridComponent r12 = this.b.a;
        if (r12 == null) goto L6;
        IHybridComponent.HybridType r13 = r12.hybridType();
        if (r13 == null) goto L6;
    L7:
        Boolean r14 = this.a.c();
        Intrinsics.checkNotNull(r14);
        boolean r15 = r14.booleanValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "type");
        com.bytedance.android.annie.service.network.h r1 = new com.bytedance.android.annie.service.network.h(r10);
        if (r11 == null) goto L13;
        Iterator<Map.Entry<String, Object>> r16 = r11.entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        Map.Entry<String, Object> r17 = r16.next();
        String r18 = r17.getKey();
        Object r19 = r17.getValue();
        com.bytedance.android.annie.service.network.n.a.getClass();
        String r20 = com.bytedance.android.annie.service.network.n.e(r19);
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r20, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r1.a.put(r18, r20);
    L13:
        Ref.ObjectRef r21 = "";
        if (r15 == true) goto L16;
    L23:
        r1.a();
        String r22 = r1.a();
        com.bytedance.android.annie.service.network.n r23 = com.bytedance.android.annie.service.network.n.a;
        Map<String, Object> r24 = this.a.b();
        r23.getClass();
        LinkedHashMap<String, String> r25 = com.bytedance.android.annie.service.network.n.b(r24);
        te7.e r26 = te7.e.a;
        CallContext r27 = this.c;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r27, "callContext");
        Set r28 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r27, "<this>");
        te7.e.g(r25, SecurityContextUtils.b(r27));
        String r29 = this.d;
        DownloadFileMethod.a r30 = this.a;
        DownloadFileMethod r31 = this.b;
        a r32 = new a(r29, r30, r31, this.e);
        r31.getClass();
        com.bytedance.android.annie.service.network.e r33 = new com.bytedance.android.annie.service.network.e();
        Boolean r34 = this.a.c();
        if (r34 == null) goto L26;
        boolean r35 = r34.booleanValue();
    L27:
        Intrinsics.checkNotNullParameter(r22, "targetUrl");
        Intrinsics.checkNotNullParameter(r25, "headers");
        Intrinsics.checkNotNullParameter(r32, "callback");
        Intrinsics.checkNotNullParameter(r33, "hostNetworkDepend");
        com.bytedance.android.annie.service.network.g r110 = new com.bytedance.android.annie.service.network.g(r22);
        Intrinsics.checkNotNullParameter(r25, "headers");
        r110.b = r25;
        r110.c = r35;
        Intrinsics.checkNotNullParameter(r33, "hostNetworkDepend");
        com.bytedance.android.annie.service.network.p r36 = com.bytedance.android.annie.service.network.p.a;
        RequestMethod r37 = RequestMethod.DOWNLOAD;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "method");
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r33, "hostNetworkDepend");
        LinkedHashMap r111 = new LinkedHashMap();
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = -1;
        Ref.IntRef r38 = new Ref.IntRef();
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = "";
        Ref.ObjectRef r39 = new Ref.ObjectRef();
        Ref.ObjectRef r40 = new Ref.ObjectRef();
        Triple r41 = com.bytedance.android.annie.service.network.p.a(r110);     // Catch: Throwable -> L77
        String r115 = (String) r41.getFirst();     // Catch: Throwable -> L77
        String r210 = (String) r41.getSecond();     // Catch: Throwable -> L77
        LinkedHashMap r211 = (LinkedHashMap) r41.getThird();     // Catch: Throwable -> L77
        List<Header> r212 = com.bytedance.android.annie.service.network.p.b(r110);     // Catch: Throwable -> L77
        RequestContext r42 = new RequestContext();     // Catch: Throwable -> L77
        ((BaseRequestContext) r42).timeout_connect = 0;     // Catch: Throwable -> L75
        ((BaseRequestContext) r42).timeout_read = 0;     // Catch: Throwable -> L75
        ((BaseRequestContext) r42).timeout_write = 0;     // Catch: Throwable -> L75
        ((BaseRequestContext) r42).force_handle_response = !r110.c;     // Catch: Throwable -> L75
        IHostNetworkRuntimeApi r116 = (IHostNetworkRuntimeApi) ((com.bytedance.android.annie.service.network.e.a) r33.createRetrofit(r115, false)).create(IHostNetworkRuntimeApi.class);     // Catch: Throwable -> L75
        int r43 = com.bytedance.android.annie.service.network.p.a.a[r37.ordinal()];     // Catch: Throwable -> L75
        Unit r117 = null;
        if (r43 != 2) goto L33;
        TypedOutput r213 = com.bytedance.android.annie.service.network.p.d(r110);     // Catch: Throwable -> L75
        if (r213 == null) goto L41;
        if (r116 == null) goto L41;
        Call<TypedInput> r44 = r116.doPostForStream(r110.c, -1, r210, r211, r212, r213, r42);     // Catch: Throwable -> L75
    L82:
        if (r44 == null) goto L70;
        r112.element = 0;     // Catch: Throwable -> L75
        r40.element = new WeakReference(r44);     // Catch: Throwable -> L75
        SsResponse r45 = r44.execute();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        if (r45 == null) goto L61;
        r112.element = r45.code();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        TypedInput r46 = (TypedInput) r45.body();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        if (r46 == null) goto L50;
        InputStream r47 = r46.in();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
    L51:
        r113.element = r47;     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        List r48 = r45.headers();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        if (r48 == null) goto L61;
        Iterator r49 = r48.iterator();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
    L55:
        if (r49.hasNext() == false) goto L60;
        Header r50 = (Header) r49.next();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        String r51 = r50.getName();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        String r52 = r50.getValue();     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        if (r52 != null) goto L59;
        r52 = "";
    L59:
        r111.put(r51, r52);     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
        goto L55
    L60:
        r117 = Unit.INSTANCE;     // Catch: CronetIOException -> L62 HttpResponseException -> L66 Throwable -> L75
    L50:
        r47 = null;
    L61:
        r21 = r39;
    L68:
        if (r117 == null) goto L71;
    L80:
        r32.a(new com.bytedance.android.annie.service.network.q(r111, r112, r113, r114, r21, r38, r40));
        return;
    L71:
        r114.element = "call is null, method is " + r37.name();     // Catch: Throwable -> L73
    L62:
        e = move-exception;
        r114.element = e.getClass().toString() + ':' + e.getMessage() + ",-1";     // Catch: Throwable -> L75
        r112.element = e.getStatusCode();     // Catch: Throwable -> L75
        com.bytedance.android.annie.service.network.p r53 = com.bytedance.android.annie.service.network.p.a;     // Catch: Throwable -> L75
        String r54 = e.getMessage();     // Catch: Throwable -> L75
        r53.getClass();     // Catch: Throwable -> L75
        r38.element = com.bytedance.android.annie.service.network.p.c(r54);     // Catch: Throwable -> L75
        r21 = r39;
        r21.element = e;     // Catch: Throwable -> L73
        r117 = Unit.INSTANCE;     // Catch: Throwable -> L73
    L66:
        e = move-exception;
        r21 = r39;
        r114.element = e.getClass().toString() + ':' + e.getMessage() + ',' + e.getStatusCode();     // Catch: Throwable -> L73
        r112.element = e.getStatusCode();     // Catch: Throwable -> L73
        com.bytedance.android.annie.service.network.p r55 = com.bytedance.android.annie.service.network.p.a;     // Catch: Throwable -> L73
        String r56 = e.getMessage();     // Catch: Throwable -> L73
        r55.getClass();     // Catch: Throwable -> L73
        r38.element = com.bytedance.android.annie.service.network.p.c(r56);     // Catch: Throwable -> L73
        r21.element = e;     // Catch: Throwable -> L73
        r117 = Unit.INSTANCE;     // Catch: Throwable -> L73
        goto L68
    L70:
        r21 = r39;
    L73:
        th = th;
    L79:
        r114.element = "request for string cause exception";
        r21.element = th;
        b8.a r57 = b8.a.a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, (String) r114.element), true);
    L41:
        r44 = null;
        goto L82
    L33:
        if (r43 != 5) goto L41;
        if (r116 == null) goto L41;
        r44 = r116.downloadFile(r110.c, -1, r210, r211, r212, r42);     // Catch: Throwable -> L75
    L75:
        th = th;
        r21 = r39;
    L77:
        th = th;
        r21 = r39;
        goto L79
    L26:
        r35 = true;
        goto L27
    L16:
        if (r13 != IHybridComponent.HybridType.H5) goto L19;
        String r58 = "h5";
    L22:
        Intrinsics.checkNotNullParameter("request_tag_from", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r58, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r1.a.put("request_tag_from", r58);
        goto L23
    L19:
        if (r13 != IHybridComponent.HybridType.LYNX) goto L21;
        r58 = "lynx";
        goto L22
    L21:
        r58 = "";
    L6:
        r13 = IHybridComponent.HybridType.H5;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
