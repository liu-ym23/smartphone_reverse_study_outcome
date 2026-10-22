package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.gamecp.base.network.exception.NetworkErrorException;
import com.bytedance.android.gamecp.host_api.model.network.NameValuePair;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u implements yv.b {
    public static final /* synthetic */ int b = 0;
    public final IGameCpApi a;

    public static final class a {
    }

    public static final class b implements zv.a<xv.a> {
        public final boolean a;
        public final Call<TypedInput> b;

        public final void cancel() {
            Call<TypedInput> r0 = this.b;
            if (r0 == null) goto L6;
            r0.cancel();
            return;
        }

        public final xv.a execute() {
            Call<TypedInput> r0 = this.b;     // Catch: Exception -> L52
            List r1 = null;
            if (r0 == null) goto L5;
            SsResponse r2 = r0.execute();     // Catch: Exception -> L52
        L6:
            if (r2 == null) goto L8;
            TypedInput r3 = (TypedInput) r2.body();     // Catch: Exception -> L52
        L9:
            if (r3 == null) goto L11;
            TypedInput r4 = (TypedInput) r2.body();     // Catch: Exception -> L52
        L17:
            if (r4 != null) goto L19;
            byte[] r5 = null;
            InputStream r6 = null;
        L33:
            String r7 = "";
            if (r2 == null) goto L36;
            Response r8 = r2.raw();     // Catch: Exception -> L52
        L37:
            if (r8 == null) goto L39;
            String r9 = r2.raw().getReason();     // Catch: Exception -> L52
            String r10 = r9;
            r7 = r2.raw().getUrl();     // Catch: Exception -> L52
        L40:
            if (r2 == null) goto L42;
            r1 = r2.headers();     // Catch: Exception -> L52
        L42:
            ArrayList r11 = new ArrayList();     // Catch: Exception -> L52
            if (r1 == null) goto L48;
            Iterator r12 = r1.iterator();     // Catch: Exception -> L52
        L46:
            if (r12.hasNext() == false) goto L48;
            Header r13 = (Header) r12.next();     // Catch: Exception -> L52
            r11.add(new NameValuePair(r13.getName(), r13.getValue()));     // Catch: Exception -> L52
        L48:
            xv.a r14 = new xv.a();     // Catch: Exception -> L52
            r14.a = r7;     // Catch: Exception -> L52
            Intrinsics.checkNotNull(r2);     // Catch: Exception -> L52
            r14.b = r2.code();     // Catch: Exception -> L52
            r14.g = r10;     // Catch: Exception -> L52
            r14.c = r11;     // Catch: Exception -> L52
            r14.e = r5;     // Catch: Exception -> L52
            r14.f = r6;     // Catch: Exception -> L52
            if (r4 == null) goto L51;
            r14.d = r4.mimeType();     // Catch: Exception -> L52
        L51:
            return r14;
        L39:
            r10 = "no reason";
            goto L40
        L36:
            r8 = null;
            goto L37
        L19:
            if (this.a == false) goto L22;
            r6 = r4.in();     // Catch: Exception -> L52
            r5 = null;
            goto L33
        L22:
            if ((r4 instanceof TypedByteArray) == false) goto L24;
            r5 = ((TypedByteArray) r4).getBytes();     // Catch: Exception -> L52
        L31:
            r6 = null;
            goto L33
        L24:
            int r15 = u.b;     // Catch: Exception -> L52
            InputStream r16 = r4.in();     // Catch: Exception -> L52
            ByteArrayOutputStream r17 = new ByteArrayOutputStream();     // Catch: Exception -> L52
            if (r16 == null) goto L30;
            byte[] r18 = new byte[4096];     // Catch: Exception -> L52
        L27:
            int r19 = r16.read(r18);     // Catch: Exception -> L52
            if (r19 == (-1)) goto L30;
            r17.write(r18, 0, r19);     // Catch: Exception -> L52
        L30:
            r5 = r17.toByteArray();     // Catch: Exception -> L52
            goto L31
        L11:
            if (r2 == null) goto L13;
            TypedInput r20 = r2.errorBody();     // Catch: Exception -> L52
        L14:
            if (r20 == null) goto L16;
            r4 = (TypedInput) r2.body();     // Catch: Exception -> L52
            goto L17
        L16:
            r4 = null;
            goto L17
        L13:
            r20 = null;
            goto L14
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
        L52:
            e = move-exception;
            if ((e instanceof CronetIOException) == true) goto L61;
            if ((e instanceof IOException) == false) goto L59;
            throw e;
        L59:
            throw new IOException(e);
        L61:
            throw new NetworkErrorException(e.getStatusCode(), e.getMessage());
        }

        public b(Call<TypedInput> r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class c implements TypedOutput {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ String d;

        public final String fileName() {
            return null;
        }

        public final String md5Stub() {
            String r0 = this.d;
            Intrinsics.checkNotNull(r0);
            return r0;
        }

        public final String mimeType() {
            String r0 = this.a;
            Intrinsics.checkNotNull(r0);
            return r0;
        }

        public final long length() {
            return this.b;
        }

        public final void writeTo(OutputStream r2) throws IOException {
            Intrinsics.checkNotNullParameter(r2, "out");
            r2.write(this.c);
        }

        public c(String r1, long r2, byte[] r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public u() {
        this.a = (IGameCpApi) RetrofitUtils.createSsService("https://" + getHostDomain(), IGameCpApi.class);
    }

    public final String getHostDomain() {
        return BDLiveSdk.getAppInfo().apiHost();
    }

    public static Map d(List r3) {
        HashMap r0 = new HashMap();
        if (r3 == null) goto L8;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        NameValuePair r1 = (NameValuePair) r4.next();
        r0.put(r1.getName(), r1.getValue());
    L8:
        return r0;
    }

    public final zv.a P1(String r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Map<String, String> r4 = d(r8);
        IGameCpApi r0 = this.a;
        if (r0 == null) goto L5;
        Call<TypedInput> r9 = r0.downloadFile(false, Integer.MAX_VALUE, r7, r4, null);
    L7:
        return new b(r9, true);
    L5:
        r9 = null;
        goto L7
    }

    public final zv.a<xv.a> get(String r2, List<NameValuePair> r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Map<String, String> r4 = d(r3);
        IGameCpApi r0 = this.a;
        if (r0 == null) goto L5;
        Call<TypedInput> r5 = r0.get(r2, r4);
    L7:
        return new b(r5, false);
    L5:
        r5 = null;
        goto L7
    }

    public final zv.a<xv.a> post(String r5, List<NameValuePair> r6, String r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Map<String, String> r9 = d(r6);
        IGameCpApi r0 = this.a;
        if (r0 == null) goto L5;
        Call<TypedInput> r10 = r0.post(r5, new TypedByteArray(r7, r8, new String[0]), r9);
    L7:
        return new b(r10, false);
    L5:
        r10 = null;
        goto L7
    }

    public final zv.a<xv.a> uploadFile(int r12, String r13, List<NameValuePair> r14, String r15, byte[] r16, long r17, String r19) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Map<String, String> r1 = d(r14);
        IGameCpApi r3 = this.a;
        if (r3 == null) goto L5;
        Call<TypedInput> r0 = r3.postMultiPart(r12, r13, r1, new c(r15, r17, r16, r19));
    L7:
        return new b(r0, false);
    L5:
        r0 = null;
        goto L7
    }
}
