package u10;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements lx5.b {
    public final OkHttpClient a;

    public final class a extends com.bytedance.android.live.network.impl.utils.a {
        public final Call a;
        public final String b;
        public final Request c;

        public final void cancel() {
            this.a.cancel();
        }

        public final Response execute() {
            okhttp3.Response r0 = this.a.execute();
            String r2 = this.b;
            int r3 = r0.code();
            String r4 = r0.message();
            Headers r1 = r0.headers();
            ArrayList r5 = new ArrayList();
            int r6 = r1.size();
            int r9 = 0;
        L3:
            if (r9 >= r6) goto L5;
            ListProtector.add(r5, r9, new Header(r1.name(r9), r1.value(r9)));
            r9 = r9 + 1;
            goto L3
        L5:
            String r7 = r0.header("Content-Type");
            ResponseBody r8 = r0.body();
            if (r8 == null) goto L9;
            byte[] r11 = r8.bytes();
            if (r11 == null) goto L9;
        L11:
            return new Response(r2, r3, r4, r5, new TypedByteArray(r7, r11, new String[0]));
        L9:
            r11 = "".getBytes(Charsets.UTF_8);
            goto L11
        }

        public final Request getRequest() {
            return this.c;
        }

        public a(j r6, Request r7) {
            Intrinsics.checkNotNullParameter(r7, "retrofitRequest");
            this.c = r7;
            String r0 = r7.getUrl();
            this.b = r0;
            okhttp3.Request.Builder r1 = new okhttp3.Request.Builder().url(r0);
            if (evc.f.b(r7.getMethod()) == true) goto L5;
            okhttp3.Request.Builder r2 = r1.method(r7.getMethod(), null);
        L10:
            Iterator r8 = r7.getHeaders().iterator();
        L12:
            if (r8.hasNext() == false) goto L14;
            Header r3 = (Header) r8.next();
            r2.addHeader(r3.getName(), r3.getValue());
            goto L12
        L14:
            okhttp3.Request r9 = r2.build();
            this.a = r6.a.newCall(r9);
            return;
        L5:
            String r4 = r7.getMethod();
            TypedOutput r5 = r7.getBody();
            if (r5 != null) goto L8;
            RequestBody r11 = RequestBody.create(null, "body=null");
        L9:
            r2 = r1.method(r4, r11);
            goto L10
        L8:
            Ref.ObjectRef r12 = new Ref.ObjectRef();
            r12.element = MediaType.parse(r5.mimeType());
            r11 = new i(r12, r5);
            goto L9
        }
    }

    public j() {
        OkHttpClient.Builder r0 = new OkHttpClient().newBuilder();
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        this.a = r0.connectTimeout(60000, r1).readTimeout(60000, r1).writeTimeout(60000, r1).followRedirects(false).followSslRedirects(false).build();
    }

    public final SsCall newSsCall(Request r2) {
        if (r2 == null) goto L6;
        return new a(this, r2);
    L6:
        throw new RuntimeException("request is null");
    }
}
