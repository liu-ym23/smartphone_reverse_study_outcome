package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5612b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private volatile boolean h;
    private String i;
    private Map<String, List<String>> j;

    public l(String r17) {
        super(r17);
        this.f5611a = "未知的错误";
        this.f5612b = "";
        this.c = "";
        this.d = "1900";
        this.e = "UnknownError";
        this.f = -1;
        this.g = -1;
        this.h = false;
        this.f5611a = r17;
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L7;
        this.f = 21;
        this.d = "1902";
        String r3 = "IOException";
    L5:
        this.e = r3;
    L79:
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L83;
        this.g = 7;
        return;
    L83:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L87;
        this.g = 6;
        return;
    L87:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L91;
        this.g = 2;
        return;
    L91:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L93;
    L102:
        this.g = 9;
        return;
    L93:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L97;
        this.g = 6;
        return;
    L97:
        if ("未知的错误".equals(r17) == true) goto L102;
        if ("DNS解析失败".equals(r17) == false) goto L102;
        this.g = 3;
        return;
    L7:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L11;
        int r4 = 22;
    L9:
        this.f = r4;
        goto L79
    L11:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L14;
        this.f = 23;
        this.d = "1802";
        r3 = "SocketTimeoutException";
        goto L5
    L14:
        if ("无效的参数 - IllegalArgumentException".equals(r17) == false) goto L17;
        this.f = 24;
        this.d = "1901";
        r3 = "IllegalArgumentException";
        goto L5
    L17:
        if ("空指针异常 - NullPointException".equals(r17) == false) goto L20;
        this.f = 25;
        this.d = "1903";
        r3 = "NullPointException";
        goto L5
    L20:
        if ("url异常 - MalformedURLException".equals(r17) == false) goto L23;
        this.f = 26;
        this.d = "1803";
        r3 = "MalformedURLException";
        goto L5
    L23:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L26;
        this.f = 27;
        this.d = "1804";
        r3 = "UnknownHostException";
        goto L5
    L26:
        if ("服务器连接失败 - UnknownServiceException".equals(r17) == false) goto L29;
        this.f = 28;
        this.d = "1805";
        r3 = "CannotConnectToHostException";
        goto L5
    L29:
        if ("协议解析错误 - ProtocolException".equals(r17) == false) goto L32;
        this.f = 29;
        this.d = "1801";
        r3 = "ProtocolException";
        goto L5
    L32:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L36;
        this.f = 30;
        String r5 = "1806";
    L34:
        this.d = r5;
        this.e = "ConnectionException";
        goto L79
    L36:
        if ("服务QPS超限".equalsIgnoreCase(r17) == false) goto L39;
        this.f = 30;
        r5 = "2001";
        goto L34
    L39:
        if ("未知的错误".equals(r17) == false) goto L42;
        r4 = 31;
        goto L9
    L42:
        if ("key鉴权失败".equals(r17) == false) goto L45;
        r4 = 32;
        goto L9
    L45:
        if ("限制访问的接口".equals(r17) == false) goto L48;
        r4 = 33;
        goto L9
    L48:
        if ("requeust is null".equals(r17) == false) goto L51;
        r4 = 1;
        goto L9
    L51:
        if ("request url is empty".equals(r17) == false) goto L54;
        this.f = 2;
        goto L79
    L54:
        if ("response is null".equals(r17) == false) goto L57;
    L55:
        this.f = 3;
        goto L79
    L57:
        if ("thread pool has exception".equals(r17) == false) goto L60;
        r4 = 4;
        goto L9
    L60:
        if ("sdk name is invalid".equals(r17) == false) goto L63;
        r4 = 5;
        goto L9
    L63:
        if ("sdk info is null".equals(r17) == false) goto L66;
        this.f = 6;
        goto L79
    L66:
        if ("sdk packages is null".equals(r17) == false) goto L69;
        this.f = 7;
        goto L79
    L69:
        if ("线程池为空".equals(r17) == false) goto L72;
        r4 = 8;
        goto L9
    L72:
        if ("获取对象错误".equals(r17) == false) goto L75;
        r4 = 101;
        goto L9
    L75:
        if ("DNS解析失败".equals(r17) == true) goto L55;
        r4 = -1;
        goto L9
    }

    public l(String r1, String r2, String r3) {
        this(r1);
        this.f5612b = r2;
        this.c = r3;
    }

    public final String a() {
        return this.f5611a;
    }

    public final void a(String r1) {
        this.i = r1;
    }

    public final void a(Map<String, List<String>> r3) {
        this.j = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.f5612b;
    }

    public final String e() {
        return this.c;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        this.g = 10;
        return 10;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() {
        this.h = true;
    }
}
