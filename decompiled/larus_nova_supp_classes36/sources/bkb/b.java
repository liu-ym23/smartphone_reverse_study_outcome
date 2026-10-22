package bkb;

import android.util.Pair;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b {
    public final Object a;
    public final Object b;
    public final boolean c;

    public b(boolean r7) {
        this.c = r7;
        if (r7 == false) goto L5;
        OkHttpClient.Builder r8 = new OkHttpClient.Builder();
        TimeUnit r4 = TimeUnit.SECONDS;
        this.a = r8.connectTimeout(10, r4).readTimeout(10, r4).writeTimeout(10, r4).build();
        this.b = new OkHttpClient.Builder().connectTimeout(10, r4).readTimeout(30, r4).writeTimeout(30, r4).build();
        return;
    L5:
        x18.b.a r9 = new x18.b.a();
        TimeUnit r5 = TimeUnit.SECONDS;
        r9.d = 10;
        r9.e = r5;
        r9.f = 10;
        r9.g = r5;
        r9.h = 10;
        r9.i = r5;
        this.a = new x18.d(r9);
        x18.b.a r10 = new x18.b.a();
        r10.d = 10;
        r10.e = r5;
        r10.f = 30;
        r10.g = r5;
        r10.h = 30;
        r10.i = r5;
        this.b = new x18.d(r10);
    }

    public final Request.Builder b(String r4) {
        Request.Builder r0 = new Request.Builder();
        if (this.c == false) goto L6;
        r4 = r4.replace("https://", "http://");
    L6:
        return r0.url(r4).addHeader(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "identity");
    }

    public final wy5.e doGet(String r3) throws Exception {
        String r0 = "doGet, " + r3;
        Log.i("LarkGeckoClient", r0);
        Request r4 = b(r3).get().build();
        if (this.c == false) goto L5;
        Call r5 = ((OkHttpClient) this.a).newCall(r4);
    L7:
        return c(r0, r5.execute());
    L5:
        r5 = ((x18.b) this.a).newCall(r4);
        goto L7
    }

    public final wy5.e c(String r7, Response r8) throws IOException {
        Headers r0 = r8.headers();
        String r1 = null;
        if (r0 != null) goto L5;
        HashMap r2 = null;
    L13:
        if (r8.code() != 200) goto L17;
        ResponseBody r3 = r8.body();
        if (r3 == null) goto L17;
        r1 = r3.string();
    L17:
        int r4 = r8.code();
        String r9 = r8.message();
        Log.i("LarkGeckoClient", "request: " + r7 + ", response: response.headers() = " + r2 + ", body = " + r1 + ", response.code() = " + r4 + ", response.message() = " + r9);
        return new wy5.e(r2, r1, r4, r9);
    L5:
        r2 = new HashMap();
        if (this.c == false) goto L8;
        r2.put("X-TT-ENV", "prod");
    L8:
        Iterator r5 = r0.names().iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        String r6 = (String) r5.next();
        r2.put(r6, r0.get(r6));
        goto L10
    }

    public final wy5.e doPost(String r5, List<Pair<String, String>> r6) throws Exception {
        StringBuilder r0 = new StringBuilder("doPost, url = ");
        r0.append(r5);
        r0.append(", params = ");
        if (r6 != null) goto L5;
        String r1 = "null";
    L6:
        r0.append(r1);
        String r2 = r0.toString();
        Log.i("LarkGeckoClient", r2);
        FormBody.Builder r3 = new FormBody.Builder();
        if (r6 == null) goto L12;
        Iterator<Pair<String, String>> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        Pair<String, String> r4 = r7.next();
        r3.add((String) r4.first, (String) r4.second);
    L12:
        Request r8 = b(r5).post(r3.build()).build();
        if (this.c == false) goto L15;
        Call r9 = ((OkHttpClient) this.a).newCall(r8);
    L17:
        return c(r2, r9.execute());
    L15:
        r9 = ((x18.b) this.a).newCall(r8);
        goto L17
    L5:
        r1 = r6.toString();
        goto L6
    }

    public final wy5.e doPost(String r3, String r4) throws Exception {
        String r0 = "doPost, url = " + r3 + ", json = " + r4;
        Log.i("LarkGeckoClient", r0);
        Request r5 = b(r3).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r4)).build();
        if (this.c == false) goto L5;
        Call r6 = ((OkHttpClient) this.a).newCall(r5);
    L7:
        return c(r0, r6.execute());
    L5:
        r6 = ((x18.b) this.a).newCall(r5);
        goto L7
    }
}
