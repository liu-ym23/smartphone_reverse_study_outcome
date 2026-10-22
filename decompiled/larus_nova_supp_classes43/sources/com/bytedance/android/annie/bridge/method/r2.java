package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.UploadFileResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r2 implements Runnable {
    public final /* synthetic */ com.bytedance.android.annie.bridge.u a;
    public final /* synthetic */ t2 b;
    public final /* synthetic */ CallContext c;
    public final /* synthetic */ LinkedHashMap<String, File> d;
    public final /* synthetic */ q2 e;

    public static final class a implements com.bytedance.android.annie.service.network.j {
        public final /* synthetic */ q2 a;

        public a(q2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.service.network.j
        public final void c(Integer r10, Throwable r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            if ((r11 instanceof NetworkNotAvailabeException) == false) goto L5;
            UploadFileResultModel.Code r0 = UploadFileResultModel.Code.NetworkUnreachable;
        L6:
            q2 r1 = this.a;
            String r13 = r11.getMessage();
            if (r13 != null) goto L9;
            r13 = "";
        L9:
            UploadFileResultModel r14 = new UploadFileResultModel();
            int r15 = -408;
            if (r10 == null) goto L12;
            Integer r16 = r10;
        L13:
            r14.c(r16);
            r14.a(Integer.valueOf(r12));
            LinkedHashMap r17 = new LinkedHashMap();
            if (r10 == null) goto L16;
            r15 = r10.intValue();
        L16:
            r17.put("errCode", Integer.valueOf(r15));
            String r18 = r11.getMessage();
            if (r18 != null) goto L19;
            r18 = "";
        L19:
            r17.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r18);
            r17.put("prompts", "");
            r14.e(r17);
            Unit r19 = Unit.INSTANCE;
            r1.b(r0, r13, r14);
            return;
        L12:
            r16 = -408;
            goto L13
        L5:
            r0 = UploadFileResultModel.Code.Failed;
            goto L6
        }

        @Override // com.bytedance.android.annie.service.network.j
        public final void a(JSONObject r10, LinkedHashMap<String, String> r11, Integer r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "body");
            Intrinsics.checkNotNullParameter(r11, "responseHeader");
            if (r12 != null) goto L27;
            int r14 = -1;
        L8:
            Gson r0 = com.bytedance.android.annie.api.data.subscribe.d.a;     // Catch: Throwable -> L5
            c r1 = ((u2) com.bytedance.android.annie.api.data.subscribe.d.a(r10.toString(), u2.class)).a();     // Catch: Throwable -> L5
            if (r1 == null) goto L12;
            List<String> r15 = r1.a();     // Catch: Throwable -> L5
            if (r15 == null) goto L12;
        L13:
            q2 r16 = this.a;     // Catch: Throwable -> L5
            UploadFileResultModel r17 = new UploadFileResultModel();     // Catch: Throwable -> L5
            if ((!r15.isEmpty()) == true) goto L17;
            String r18 = "";
        L19:
            r17.f(r18);     // Catch: Throwable -> L5
            r17.c(Integer.valueOf(r14));     // Catch: Throwable -> L5
            r17.a(Integer.valueOf(r13));     // Catch: Throwable -> L5
            LinkedHashMap r19 = new LinkedHashMap();     // Catch: Throwable -> L5
            Iterator<String> r20 = r10.keys();     // Catch: Throwable -> L5
        L21:
            if (r20.hasNext() == false) goto L23;
            String r21 = r20.next();     // Catch: Throwable -> L5
            r19.put(r21, r10.get(r21));     // Catch: Throwable -> L5
            goto L21
        L23:
            r17.e(r19);     // Catch: Throwable -> L5
            r16.a(r17, "");     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.a.b(UploadFileResultModel.Code.Failed, "parse post response body failed", null);
            b8.a r22 = b8.a.a;
            b8.a.a(new b8.b("[ReportALogMethod]", LogLevel.ERROR, th, "parse post response body failed"), true);
            return;
        L17:
            r18 = (String) ListProtector.get(r15, 0);     // Catch: Throwable -> L5
        L12:
            r15 = new ArrayList();     // Catch: Throwable -> L5
            goto L13
        L27:
            r14 = r12.intValue();     // Catch: Throwable -> L5
            goto L8
        }

        @Override // com.bytedance.android.annie.service.network.j
        public final void b(JSONObject r1, LinkedHashMap r10, String r11, Throwable r12, Integer r13, int r14) {
            Intrinsics.checkNotNullParameter(r1, "body");
            Intrinsics.checkNotNullParameter(r10, "responseHeader");
            Intrinsics.checkNotNullParameter(r11, "rawResponse");
            Intrinsics.checkNotNullParameter(r12, "throwable");
        }
    }

    public r2(com.bytedance.android.annie.bridge.u r1, t2 r10, CallContext r11, LinkedHashMap r12, s2 r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a() {
        com.bytedance.android.annie.service.network.n r0 = com.bytedance.android.annie.service.network.n.a;
        Map<String, Object> r1 = this.a.b();
        r0.getClass();
        LinkedHashMap r10 = com.bytedance.android.annie.service.network.n.b(r1);
        Map r11 = com.bytedance.android.annie.service.network.n.a(this.a.d());
        t2 r12 = this.b;
        CallContext r13 = this.c;
        r12.getClass();
        Set r14 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        String r15 = SecurityContextUtils.b(r13);
        if (r15.length() <= 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L8;
        r10.put("x-security-argus", r15);
    L8:
        a r17 = new a(this.e);
        String r18 = this.a.e();
        LinkedHashMap<String, File> r19 = this.d;
        this.b.getClass();
        com.bytedance.android.annie.service.network.e r20 = new com.bytedance.android.annie.service.network.e();
        Boolean r21 = this.a.c();
        if (r21 == null) goto L11;
        boolean r22 = r21.booleanValue();
    L12:
        com.bytedance.android.annie.service.network.n.d(r18, r10, r19, r11, r17, r20, r22);
        return;
    L11:
        r22 = true;
        goto L12
    L5:
        r16 = false;
        goto L6
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
