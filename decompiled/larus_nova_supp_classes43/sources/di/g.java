package di;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Ldi/g;", "", "", "downlinkThroughput", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setDownlinkThroughput", "(Ljava/lang/Integer;)V", "effectiveNetType", "b", "setEffectiveNetType", "httpRtt", "c", "setHttpRtt", "tcpRtt", "e", "setTcpRtt", "realNetType", "d", "setRealNetType", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("downlink_throughput")
    private Integer downlinkThroughput;

    @SerializedName("effective_net_type")
    private Integer effectiveNetType;

    @SerializedName("http_rtt")
    private Integer httpRtt;

    @SerializedName("real_net_type")
    private Integer realNetType;

    @SerializedName("tcp_rtt")
    private Integer tcpRtt;

    public g() {
    }

    public final Integer a() {
        return this.downlinkThroughput;
    }

    public final Integer b() {
        return this.effectiveNetType;
    }

    public final Integer c() {
        return this.httpRtt;
    }

    public final Integer d() {
        return this.realNetType;
    }

    public final Integer e() {
        return this.tcpRtt;
    }
}
