package com.obric.sva.sdk.network;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001aX\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001aX\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"TAG", "", "streamByGet", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "addCommonParams", "", "maxLength", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "streamByPostJson", "body", "", "", "streamByPostForm", "convertParams", "Lcom/obric/sva/sdk/network/Params;", "libs_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class NetworkProxyKt {
    private static final String TAG = "NetworkProxy";

    public static final Params convertParams(String r4) throws UrlConvertException {
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L8
        Pair r1 = UrlUtils.parseUrl(r4, r0);     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return new Params((String) r1.first, (String) r1.second, r0);
    L7:
        throw new UrlConvertException(r4);     // Catch: Exception -> L8
    L9:
        throw new UrlConvertException(r4);
    }

    public static final SsResponse<TypedInput> streamByGet(String r7, boolean r8, int r9, List<Header> r10) throws Exception {
        Params r11 = convertParams(r7);     // Catch: Exception -> L8
        Call<TypedInput> r12 = ((INetworkProxyApi) RetrofitUtils.createSsService(r11.getBaseUrl(), INetworkProxyApi.class)).get(r8, r9, r11.getRelativePath(), r11.getQueryMap(), r10);     // Catch: Exception -> L8
        if (r12 == null) goto L6;
        return r12.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByGet error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static final SsResponse<TypedInput> streamByPostForm(String r8, boolean r9, int r10, Map<String, ? extends Object> r11, List<Header> r12) throws Exception {
        Params r13 = convertParams(r8);     // Catch: Exception -> L8
        Call<TypedInput> r14 = ((INetworkProxyApi) RetrofitUtils.createSsService(r13.getBaseUrl(), INetworkProxyApi.class)).postByForm(r9, r10, r13.getRelativePath(), r13.getQueryMap(), r11, r12);     // Catch: Exception -> L8
        if (r14 == null) goto L6;
        return r14.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByPostForm error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static final SsResponse<TypedInput> streamByPostJson(String r8, boolean r9, int r10, Map<String, ? extends Object> r11, List<Header> r12) throws Exception {
        Params r13 = convertParams(r8);     // Catch: Exception -> L8
        Call<TypedInput> r14 = ((INetworkProxyApi) RetrofitUtils.createSsService(r13.getBaseUrl(), INetworkProxyApi.class)).postByJson(r9, r10, r13.getRelativePath(), r13.getQueryMap(), r11, r12);     // Catch: Exception -> L8
        if (r14 == null) goto L6;
        return r14.execute();
    L6:
        return null;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "streamByPostJson error:" + e.getMessage(), new Object[0]);
        throw e;
    }

    public static /* synthetic */ SsResponse streamByGet$default(String r0, boolean r1, int r2, List r3, int r4, Object r5) throws Exception {
        if ((r4 & 2) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r2 = -1;
    L9:
        if ((r4 & 8) == 0) goto L12;
        r3 = null;
    L12:
        return streamByGet(r0, r1, r2, r3);
    }

    public static /* synthetic */ SsResponse streamByPostForm$default(String r0, boolean r1, int r2, Map r3, List r4, int r5, Object r6) throws Exception {
        if ((r5 & 2) == 0) goto L6;
        r1 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = -1;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = null;
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = CollectionsKt.emptyList();
    L15:
        return streamByPostForm(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SsResponse streamByPostJson$default(String r1, boolean r2, int r3, Map r4, List r5, int r6, Object r7) throws Exception {
        if ((r6 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 16) == 0) goto L15;
        r5 = null;
    L15:
        return streamByPostJson(r1, r2, r3, r4, r5);
    }
}
