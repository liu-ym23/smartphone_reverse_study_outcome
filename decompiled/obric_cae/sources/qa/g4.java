package qa;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g4 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10478b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f10479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f10480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f10481o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10482p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10483q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f10484r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, List<String>> f10485s;

    public g4(String r17) {
        super(r17);
        this.f10477a = "未知的错误";
        this.f10478b = "";
        this.f10479m = "";
        this.f10480n = "1900";
        this.f10481o = "UnknownError";
        this.f10482p = -1;
        this.f10483q = -1;
        this.f10484r = false;
        this.f10477a = r17;
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L7;
        this.f10482p = 21;
        this.f10480n = "1902";
        String r8 = "IOException";
    L5:
        this.f10481o = r8;
    L79:
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L83;
        this.f10483q = 7;
        return;
    L83:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L87;
        this.f10483q = 6;
        return;
    L87:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L91;
        this.f10483q = 2;
        return;
    L91:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L93;
    L102:
        this.f10483q = 9;
        return;
    L93:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L97;
        this.f10483q = 6;
        return;
    L97:
        if ("未知的错误".equals(r17) == true) goto L102;
        if ("DNS解析失败".equals(r17) == false) goto L102;
        this.f10483q = 3;
        return;
    L7:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L11;
        int r10 = 22;
    L9:
        this.f10482p = r10;
        goto L79
    L11:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L14;
        this.f10482p = 23;
        this.f10480n = "1802";
        r8 = "SocketTimeoutException";
        goto L5
    L14:
        if ("无效的参数 - IllegalArgumentException".equals(r17) == false) goto L17;
        this.f10482p = 24;
        this.f10480n = "1901";
        r8 = "IllegalArgumentException";
        goto L5
    L17:
        if ("空指针异常 - NullPointException".equals(r17) == false) goto L20;
        this.f10482p = 25;
        this.f10480n = "1903";
        r8 = "NullPointException";
        goto L5
    L20:
        if ("url异常 - MalformedURLException".equals(r17) == false) goto L23;
        this.f10482p = 26;
        this.f10480n = "1803";
        r8 = "MalformedURLException";
        goto L5
    L23:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L26;
        this.f10482p = 27;
        this.f10480n = "1804";
        r8 = "UnknownHostException";
        goto L5
    L26:
        if ("服务器连接失败 - UnknownServiceException".equals(r17) == false) goto L29;
        this.f10482p = 28;
        this.f10480n = "1805";
        r8 = "CannotConnectToHostException";
        goto L5
    L29:
        if ("协议解析错误 - ProtocolException".equals(r17) == false) goto L32;
        this.f10482p = 29;
        this.f10480n = "1801";
        r8 = "ProtocolException";
        goto L5
    L32:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L36;
        this.f10482p = 30;
        String r11 = "1806";
    L34:
        this.f10480n = r11;
        this.f10481o = "ConnectionException";
        goto L79
    L36:
        if ("服务QPS超限".equalsIgnoreCase(r17) == false) goto L39;
        this.f10482p = 30;
        r11 = "2001";
        goto L34
    L39:
        if ("未知的错误".equals(r17) == false) goto L42;
        r10 = 31;
        goto L9
    L42:
        if ("key鉴权失败".equals(r17) == false) goto L45;
        r10 = 32;
        goto L9
    L45:
        if ("限制访问的接口".equals(r17) == false) goto L48;
        r10 = 33;
        goto L9
    L48:
        if ("requeust is null".equals(r17) == false) goto L51;
        r10 = 1;
        goto L9
    L51:
        if ("request url is empty".equals(r17) == false) goto L54;
        this.f10482p = 2;
        goto L79
    L54:
        if ("response is null".equals(r17) == false) goto L57;
    L55:
        this.f10482p = 3;
        goto L79
    L57:
        if ("thread pool has exception".equals(r17) == false) goto L60;
        r10 = 4;
        goto L9
    L60:
        if ("sdk name is invalid".equals(r17) == false) goto L63;
        r10 = 5;
        goto L9
    L63:
        if ("sdk info is null".equals(r17) == false) goto L66;
        this.f10482p = 6;
        goto L79
    L66:
        if ("sdk packages is null".equals(r17) == false) goto L69;
        this.f10482p = 7;
        goto L79
    L69:
        if ("线程池为空".equals(r17) == false) goto L72;
        r10 = 8;
        goto L9
    L72:
        if ("获取对象错误".equals(r17) == false) goto L75;
        r10 = 101;
        goto L9
    L75:
        if ("DNS解析失败".equals(r17) == true) goto L55;
        r10 = -1;
        goto L9
    }

    public g4(String r8, String r10, String r11) {
        this(r8);
        this.f10478b = r10;
        this.f10479m = r11;
    }
}
