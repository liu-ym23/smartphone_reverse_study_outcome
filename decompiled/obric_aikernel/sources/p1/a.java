package p1;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.mime.c;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import n4.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends e {
    public a() {
    }

    private static List<b> h(Map<String, String> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, String> r13 = r12.next();
        r11.add(new b(r13.getKey(), r13.getValue()));
        goto L7
    L9:
        return r11;
    }

    private static Pair<String, String> i(String r10) {
        Uri r11 = Uri.parse(r10);
        StringBuilder r12 = new StringBuilder();
        String r13 = r11.getScheme();
        String r14 = r11.getHost();
        int r15 = r11.getPort();
        if (r14 == null) goto L9;
        if (r13 == null) goto L6;
        r12.append(r13);
        r12.append("://");
    L6:
        r12.append(r14);
        if (r15 <= 0) goto L9;
        r12.append(':');
        r12.append(r15);
    L9:
        String r16 = r12.toString();
        String r17 = r11.getPath();
        String r18 = r11.getQuery();
        if (r18 == null) goto L13;
        r17 = r17 + "?" + r18;
    L13:
        return new Pair(r16, r17);
    }

    @Override // com.bytedance.common.utility.e
    public String a(String r10, Map<String, String> r11, e.a r12) {
        Pair<String, String> r13 = i(r10);
        String r14 = (String) r13.first;
        String r15 = (String) r13.second;
        ICommonApi r16 = (ICommonApi) RetrofitUtils.g(r14, ICommonApi.class);
        List<b> r17 = h(r11);
        if (r12 == null) goto L5;
        boolean r18 = r12.f1270a;
    L7:
        return r16.get(-1, r15, r17, r18).execute().a();
    L5:
        r18 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.e
    public String d(String r10, List<Pair<String, String>> r11, Map<String, String> r12, e.a r13) {
        Pair<String, String> r14 = i(r10);     // Catch: Exception -> L14
        String r15 = (String) r14.first;     // Catch: Exception -> L14
        String r16 = (String) r14.second;     // Catch: Exception -> L14
        ICommonApi r17 = (ICommonApi) RetrofitUtils.g(r15, ICommonApi.class);     // Catch: Exception -> L14
        List<b> r18 = h(r12);     // Catch: Exception -> L14
        LinkedHashMap r19 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r11 == null) goto L9;
        Iterator<Pair<String, String>> r20 = r11.iterator();     // Catch: Exception -> L14
    L7:
        if (r20.hasNext() == false) goto L9;
        Pair<String, String> r21 = r20.next();     // Catch: Exception -> L14
        r19.put(r21.first, r21.second);     // Catch: Exception -> L14
    L9:
        if (r13 == null) goto L11;
        boolean r22 = r13.f1270a;     // Catch: Exception -> L14
    L12:
        return r17.postForm(-1, r16, r19, r18, r22).execute().a();
    L11:
        r22 = false;
    L14:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L20;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.e
    public String e(String r10, byte[] r11, Map<String, String> r12, e.a r13) {
        Pair<String, String> r14 = i(r10);     // Catch: Exception -> L12
        String r15 = (String) r14.first;     // Catch: Exception -> L12
        String r16 = (String) r14.second;     // Catch: Exception -> L12
        ICommonApi r17 = (ICommonApi) RetrofitUtils.g(r15, ICommonApi.class);     // Catch: Exception -> L12
        String r18 = null;
        if (r12 == null) goto L6;
        String r19 = r12.get(NetConst.KEY_CONTENT_TYPE);     // Catch: Exception -> L12
        r12.remove(NetConst.KEY_CONTENT_TYPE);     // Catch: Exception -> L12
        r18 = r19;
    L6:
        List<b> r20 = h(r12);     // Catch: Exception -> L12
        if (r13 == null) goto L9;
        boolean r21 = r13.f1270a;     // Catch: Exception -> L12
    L10:
        return r17.postData(-1, r16, new c(r18, r11, new String[0]), r20, r21).execute().a();
    L9:
        r21 = false;
    L12:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L18;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L18:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.e
    public byte[] f(String r10, byte[] r11, Map<String, String> r12, e.a r13) {
        InputStream r14 = null;
        Pair<String, String> r15 = i(r10);     // Catch: Throwable -> L36 Exception -> L38
        String r16 = (String) r15.first;     // Catch: Throwable -> L36 Exception -> L38
        String r17 = (String) r15.second;     // Catch: Throwable -> L36 Exception -> L38
        ICommonApi r18 = (ICommonApi) RetrofitUtils.g(r16, ICommonApi.class);     // Catch: Throwable -> L36 Exception -> L38
        if (r12 == null) goto L6;
        String r19 = r12.get(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L36 Exception -> L38
        r12.remove(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L36 Exception -> L38
    L7:
        List<b> r20 = h(r12);     // Catch: Throwable -> L36 Exception -> L38
        if (r13 == null) goto L10;
        boolean r21 = r13.f1270a;     // Catch: Throwable -> L36 Exception -> L38
    L11:
        InputStream r110 = r18.postDataStream(-1, r17, new c(r19, r11, new String[0]), r20, r21).execute().a().c();     // Catch: Throwable -> L36 Exception -> L38
    L71:
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Throwable -> L32 Exception -> L34
    L69:
        byte[] r22 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L30
    L15:
        int r112 = r110.read(r22);     // Catch: Throwable -> L28 Exception -> L30
        if (r112 == (-1)) goto L18;
        r111.write(r22, 0, r112);     // Catch: Throwable -> L28 Exception -> L30
        goto L15
    L18:
        byte[] r23 = r111.toByteArray();     // Catch: Throwable -> L28 Exception -> L30
        r110.close();     // Catch: IOException -> L21
    L64:
        r111.close();     // Catch: IOException -> L25
    L27:
        return r23;
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L30:
        e = move-exception;
        e = e;
        r14 = r110;
    L66:
    L46:
        th = th;
    L47:
        if (r14 != null) goto L60;
    L52:
        if (r111 == null) goto L74;
        r111.close();     // Catch: IOException -> L55
        throw th;
    L55:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L60:
        r14.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L41:
        if ((e instanceof HttpResponseException) == false) goto L45;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L46
    L45:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L46
    L28:
        th = move-exception;
        th = th;
        r14 = r110;
    L34:
        e = move-exception;
        r111 = null;
        r14 = r110;
        e = e;
    L32:
        th = move-exception;
        r111 = null;
        r14 = r110;
        th = th;
        goto L47
    L10:
        r21 = false;
        goto L11
    L6:
        r19 = null;
    L38:
        e = e;
        r111 = null;
    L36:
        th = th;
        r111 = null;
        goto L47
    }
}
