package di;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b9\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\b¨\u0006E"}, d2 = {"Ldi/j;", "", "", "beforeStream", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setBeforeStream", "(Ljava/lang/Integer;)V", "bodyRecv", "b", "setBodyRecv", "", "cdnCache", "Ljava/lang/String;", "getCdnCache", "()Ljava/lang/String;", "setCdnCache", "(Ljava/lang/String;)V", "connectDelay", "c", "setConnectDelay", "createStream", "d", "setCreateStream", "dispatch", "e", "setDispatch", "dns", "f", "setDns", "edge", "g", "setEdge", "headerRecv", "h", "setHeaderRecv", "inner", "i", "setInner", "origin", "j", "setOrigin", "proxy", "k", "setProxy", "rtt", "l", "setRtt", "securityCallback", "m", "setSecurityCallback", "send", "n", "setSend", "ssl", "o", "setSsl", "tcp", "p", "setTcp", "ttfb", "r", "setTtfb", "ttAgw", "q", "setTtAgw", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("before_stream")
    private Integer beforeStream;

    @SerializedName("body_recv")
    private Integer bodyRecv;

    @SerializedName("cdn-cache")
    private String cdnCache;

    @SerializedName("connect_delay")
    private Integer connectDelay;

    @SerializedName("create_stream")
    private Integer createStream;

    @SerializedName("dispatch")
    private Integer dispatch;

    @SerializedName("dns")
    private Integer dns;

    @SerializedName("edge")
    private Integer edge;

    @SerializedName("header_recv")
    private Integer headerRecv;

    @SerializedName("inner")
    private Integer inner;

    @SerializedName("origin")
    private Integer origin;

    @SerializedName("proxy")
    private Integer proxy;

    @SerializedName("rtt")
    private Integer rtt;

    @SerializedName("security_callback")
    private Integer securityCallback;

    @SerializedName("send")
    private Integer send;

    @SerializedName("ssl")
    private Integer ssl;

    @SerializedName("tcp")
    private Integer tcp;

    @SerializedName("tt_agw")
    private Integer ttAgw;

    @SerializedName("ttfb")
    private Integer ttfb;

    public j() {
    }

    public final Integer a() {
        return this.beforeStream;
    }

    public final Integer b() {
        return this.bodyRecv;
    }

    public final Integer c() {
        return this.connectDelay;
    }

    public final Integer d() {
        return this.createStream;
    }

    public final Integer e() {
        return this.dispatch;
    }

    public final Integer f() {
        return this.dns;
    }

    public final Integer g() {
        return this.edge;
    }

    public final Integer h() {
        return this.headerRecv;
    }

    public final Integer i() {
        return this.inner;
    }

    public final Integer j() {
        return this.origin;
    }

    public final Integer k() {
        return this.proxy;
    }

    public final Integer l() {
        return this.rtt;
    }

    public final Integer m() {
        return this.securityCallback;
    }

    public final Integer n() {
        return this.send;
    }

    public final Integer o() {
        return this.ssl;
    }

    public final Integer p() {
        return this.tcp;
    }

    public final Integer q() {
        return this.ttAgw;
    }

    public final Integer r() {
        return this.ttfb;
    }
}
