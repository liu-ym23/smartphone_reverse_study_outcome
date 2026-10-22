package com.bytedance.android.live.saas.middleware.applog;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.network.ICommonApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010%\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J3\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\n\u001a\u00020\bH\u0002J<\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016JN\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\u001a\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f\u0018\u00010\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/applog/DefaultNetworkClient;", "Lcom/bytedance/common/utility/NetworkClient;", "()V", "convertHeaders", "", "Lcom/bytedance/retrofit2/client/Header;", "headers", "", "", "get", "url", "requestHeaders", "ctx", "Lcom/bytedance/common/utility/NetworkClient$ReqContext;", "parseUrl", "Landroid/util/Pair;", "post", Constants.Keys.DATA, "", "", "params", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultNetworkClient extends NetworkClient {
    public DefaultNetworkClient() {
    }

    private final List<Header> convertHeaders(Map<String, String> r5) {
        HashMap r0 = new HashMap();
        if (r5 == null) goto L6;
        r0.putAll(r5);
    L6:
        if (Intrinsics.areEqual(BDLiveSdk.getAppInfo().channel(), "local_test") == false) goto L13;
        r0.put("x-app-id", "4207");
        IAppLog r6 = BDLiveSdk.appLog();
        if (r6 == null) goto L11;
        String r7 = r6.getDid();
        if (r7 == null) goto L11;
    L12:
        r0.put("x-device-id", r7);
    L11:
        r7 = "";
    L13:
        ArrayList r8 = new ArrayList();
        Iterator r1 = r0.entrySet().iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r1.next();
        r8.add(new Header((String) r2.getKey(), (String) r2.getValue()));
        goto L15
    L17:
        return r8;
    }

    private final Pair<String, String> parseUrl(String r5) {
        Uri r6 = UriProtector.parse(r5);
        StringBuilder r0 = new StringBuilder();
        String r1 = r6.getScheme();
        String r2 = r6.getHost();
        int r3 = r6.getPort();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        String r4 = r0.toString();
        String r7 = r6.getPath();
        String r8 = r6.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + '?' + r8;
    L13:
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        return new Pair(r4, r7);
    }

    public String get(String r3, Map<String, String> r4, NetworkClient.ReqContext r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Pair<String, String> r6 = parseUrl(r3);
        String r0 = (String) r6.first;
        String r7 = (String) r6.second;
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);
        List<Header> r8 = convertHeaders(r4);
        if (r5 != null) goto L5;
    L7:
        boolean r9 = false;
    L9:
        return (String) r1.get(-1, r7, r8, r9).execute().body();
    L5:
        if (r5.addCommonParams == false) goto L7;
        r9 = true;
        goto L9
    }

    public String post(String r9, List<? extends Pair<String, String>> r10, Map<String, String> r12, NetworkClient.ReqContext r13) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Pair<String, String> r14 = parseUrl(r9);     // Catch: Exception -> L16
        String r1 = (String) r14.first;     // Catch: Exception -> L16
        String r4 = (String) r14.second;     // Catch: Exception -> L16
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Exception -> L16
        List<Header> r6 = convertHeaders(r12);     // Catch: Exception -> L16
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L16
        if (r10 == null) goto L9;
        Iterator<? extends Pair<String, String>> r15 = r10.iterator();     // Catch: Exception -> L16
    L7:
        if (r15.hasNext() == false) goto L9;
        Pair<String, String> r16 = r15.next();     // Catch: Exception -> L16
        r5.put(r16.first, r16.second);     // Catch: Exception -> L16
    L9:
        if (r13 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        return (String) r2.postForm(-1, r4, r5, r6, r7).execute().body();
    L11:
        if (r13.addCommonParams == false) goto L13;
        r7 = true;
    L16:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L26;
        if ((e instanceof CronetIOException) == false) goto L24;
        throw new CommonHttpException(e.getStatusCode(), e.getMessage());
    L24:
        throw new CommonHttpException(0, e.getMessage());
    L26:
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    }

    public String post(String r9, byte[] r10, Map<String, String> r12, NetworkClient.ReqContext r13) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Pair<String, String> r14 = parseUrl(r9);     // Catch: Exception -> L15
        String r1 = (String) r14.first;     // Catch: Exception -> L15
        String r4 = (String) r14.second;     // Catch: Exception -> L15
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Exception -> L15
        if (r12 == null) goto L6;
        String r3 = r12.get("Content-Type");     // Catch: Exception -> L15
        r12.remove("Content-Type");     // Catch: Exception -> L15
    L7:
        List<Header> r6 = convertHeaders(r12);     // Catch: Exception -> L15
        if (r13 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        return (String) r2.postData(-1, r4, new TypedByteArray(r3, r10, new String[0]), r6, r7).execute().body();
    L10:
        if (r13.addCommonParams == false) goto L12;
        r7 = true;
        goto L13
    L6:
        r3 = null;
    L15:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L25;
        if ((e instanceof CronetIOException) == false) goto L23;
        throw new CommonHttpException(e.getStatusCode(), e.getMessage());
    L23:
        throw new CommonHttpException(0, e.getMessage());
    L25:
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    }
}
