package okhttp3.ttnet;

import java.net.InetAddress;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TTNetDnsResult {
    private final String dnsInfoJson;
    private final List<InetAddress> inetAddressList;

    /* JADX WARN: Multi-variable type inference failed */
    public TTNetDnsResult(List<? extends InetAddress> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "inetAddressList");
        Intrinsics.checkNotNullParameter(r11, "dnsInfoJson");
        this.inetAddressList = r10;
        this.dnsInfoJson = r11;
    }

    public final String getDnsInfoJson() {
        return this.dnsInfoJson;
    }

    public final List<InetAddress> getInetAddressList() {
        return this.inetAddressList;
    }
}
