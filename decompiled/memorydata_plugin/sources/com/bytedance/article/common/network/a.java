package com.bytedance.article.common.network;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.f;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends f {
    public a() {
    }

    private static Pair<String, String> a(String r4) {
        Uri r5 = Uri.parse(r4);
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getScheme();
        String r2 = r5.getHost();
        int r3 = r5.getPort();
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
        String r6 = r0.toString();
        String r7 = r5.getPath();
        String r8 = r5.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + "?" + r8;
    L13:
        return new Pair(r6, r7);
    }

    private static List<Header> a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.add(new Header((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        return r0;
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r9, List<Pair<String, String>> r10, Map<String, String> r11, f.a r12) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Pair<String, String> r14 = a(r9);     // Catch: Exception -> L14
        String r1 = (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        ICommonApi r2 = (ICommonApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r1, ICommonApi.class), ICommonApi.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        List<Header> r6 = a(r13);     // Catch: Exception -> L14
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r8 == null) goto L9;
        Iterator r15 = r8.iterator();     // Catch: Exception -> L14
    L7:
        if (r15.hasNext() == false) goto L9;
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        r5.put(r16.first, r16.second);     // Catch: Exception -> L14
    L9:
        if (r12 == null) goto L11;
        boolean r7 = r12.f1986a;     // Catch: Exception -> L14
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r2.postForm(-1, r4, r5, r6, r7).execute().body(), String.class, "com.obric.memorydata.plugin");
    L11:
        r7 = false;
    L14:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, HttpResponseException.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(e, CronetIOException.class) == false) goto L22;
        throw new CommonHttpException(((CronetIOException) ZeusTransformUtils.preCheckCast(e, CronetIOException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());
    L22:
        throw new CommonHttpException(0, e.getMessage());
    L24:
        throw new CommonHttpException(((HttpResponseException) ZeusTransformUtils.preCheckCast(e, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r3, Map<String, String> r4, f.a r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Pair<String, String> r6 = a(r3);
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.first, String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.second, String.class, "com.obric.memorydata.plugin");
        ICommonApi r9 = (ICommonApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r7, ICommonApi.class), ICommonApi.class, "com.obric.memorydata.plugin");
        List<Header> r10 = a(r2);
        if (r5 == null) goto L5;
        boolean r11 = r5.f1986a;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r9.get(-1, r8, r10, r11).execute().body(), String.class, "com.obric.memorydata.plugin");
    L5:
        r11 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.f
    public String a(String r9, byte[] r10, Map<String, String> r11, f.a r12) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Pair<String, String> r13 = a(r9);     // Catch: Exception -> L12
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.first, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        String r4 = (String) ZeusTransformUtils.preCheckCast(r13.second, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        ICommonApi r2 = (ICommonApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r1, ICommonApi.class), ICommonApi.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        String r14 = null;
        if (r8 == null) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.get(NetConst.KEY_CONTENT_TYPE), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        r8.remove(NetConst.KEY_CONTENT_TYPE);     // Catch: Exception -> L12
        r14 = r3;
    L6:
        List<Header> r6 = a(r8);     // Catch: Exception -> L12
        if (r12 == null) goto L9;
        boolean r7 = r12.f1986a;     // Catch: Exception -> L12
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r2.postData(-1, r4, new TypedByteArray(r14, r10, new String[0]), r6, r7).execute().body(), String.class, "com.obric.memorydata.plugin");
    L9:
        r7 = false;
    L12:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, HttpResponseException.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(e, CronetIOException.class) == false) goto L20;
        throw new CommonHttpException(((CronetIOException) ZeusTransformUtils.preCheckCast(e, CronetIOException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    L22:
        throw new CommonHttpException(((HttpResponseException) ZeusTransformUtils.preCheckCast(e, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.f
    public byte[] b(String r11, byte[] r12, Map<String, String> r13, f.a r14) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        InputStream r15 = null;
        Pair<String, String> r16 = a(r11);     // Catch: Throwable -> L37 Exception -> L39
        String r2 = (String) ZeusTransformUtils.preCheckCast(r16.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 Exception -> L39
        String r5 = (String) ZeusTransformUtils.preCheckCast(r16.second, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 Exception -> L39
        ICommonApi r3 = (ICommonApi) ZeusTransformUtils.preCheckCast(RetrofitUtils.a(r2, ICommonApi.class), ICommonApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 Exception -> L39
        if (r10 == null) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.get(NetConst.KEY_CONTENT_TYPE), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 Exception -> L39
        r10.remove(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L37 Exception -> L39
    L7:
        List<Header> r7 = a(r10);     // Catch: Throwable -> L37 Exception -> L39
        if (r14 == null) goto L10;
        boolean r8 = r14.f1986a;     // Catch: Throwable -> L37 Exception -> L39
    L11:
        InputStream r17 = ((TypedInput) ZeusTransformUtils.preCheckCast(r3.postDataStream(-1, r5, new TypedByteArray(r4, r12, new String[0]), r7, r8).execute().body(), TypedInput.class, "com.obric.memorydata.plugin")).in();     // Catch: Throwable -> L37 Exception -> L39
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: Throwable -> L33 Exception -> L35
    L76:
        byte[] r19 = new byte[1024];     // Catch: Throwable -> L29 Exception -> L31
    L15:
        int r110 = r17.read(r19);     // Catch: Throwable -> L29 Exception -> L31
        if (r110 == (-1)) goto L18;
        r18.write(r19, 0, r110);     // Catch: Throwable -> L29 Exception -> L31
        goto L15
    L18:
        byte[] r111 = r18.toByteArray();     // Catch: Throwable -> L29 Exception -> L31
        if (r17 != null) goto L67;
    L63:
        r18.close();     // Catch: IOException -> L26
    L28:
        return r111;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L67:
        r17.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L31:
        e = move-exception;
        r15 = r17;
        e = e;
    L71:
    L51:
        th = th;
    L52:
        if (r15 != null) goto L65;
    L57:
        if (r18 == null) goto L79;
        r18.close();     // Catch: IOException -> L60
        throw th;
    L60:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L79:
        throw th;
    L65:
        r15.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L42:
        if (ZeusTransformUtils.instanceOf(e, HttpResponseException.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, CronetIOException.class) == false) goto L48;
        throw new CommonHttpException(((CronetIOException) ZeusTransformUtils.preCheckCast(e, CronetIOException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());     // Catch: Throwable -> L51
    L48:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L51
    L50:
        throw new CommonHttpException(((HttpResponseException) ZeusTransformUtils.preCheckCast(e, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode(), e.getMessage());     // Catch: Throwable -> L51
    L29:
        th = move-exception;
        r15 = r17;
        th = th;
    L35:
        e = move-exception;
        r15 = r17;
        e = e;
        r18 = null;
    L33:
        th = move-exception;
        r15 = r17;
        th = th;
        r18 = null;
        goto L52
    L10:
        r8 = false;
        goto L11
    L6:
        r4 = null;
    L39:
        e = e;
        r18 = null;
    L37:
        th = th;
        r18 = null;
        goto L52
    }
}
