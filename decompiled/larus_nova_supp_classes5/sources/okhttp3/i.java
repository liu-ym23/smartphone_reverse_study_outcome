package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i {
    public static final i NONE = null;

    public static class a extends i {
        public a() {
        }
    }

    public static class b implements c {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        @Override // okhttp3.i.c
        public final i create(Call r1) {
            return this.a;
        }
    }

    public interface c {
        i create(Call r1);
    }

    public i() {
    }

    public void callEnd(Call r1) {
    }

    public void callFailed(Call r1, IOException r2) {
    }

    public void callInSecureRedirect(Call r1, JSONObject r2) {
    }

    public void callStart(Call r1) {
    }

    public void connectEnd(Call r1, InetSocketAddress r2, Proxy r3, @Nullable Protocol r4) {
    }

    public void connectFailed(Call r1, InetSocketAddress r2, Proxy r3, @Nullable Protocol r4, IOException r5) {
    }

    public void connectFailed(Call r1, InetSocketAddress r2, Proxy r3, @Nullable Protocol r4, IOException r5, String r6) {
    }

    public void connectStart(Call r1, InetSocketAddress r2, Proxy r3) {
    }

    public void connectionAcquired(Call r1, Connection r2) {
    }

    public void connectionReleased(Call r1, Connection r2) {
    }

    public void dnsEnd(Call r1, String r2, List<InetAddress> r3) {
    }

    public void dnsEnd(Call r1, String r2, List<InetAddress> r3, String r4) {
    }

    public void dnsStart(Call r1, String r2) {
    }

    public void requestBodyEnd(Call r1, long r2) {
    }

    public void requestBodyStart(Call r1) {
    }

    public void requestHeadersEnd(Call r1, Request r2) {
    }

    public void requestHeadersStart(Call r1) {
    }

    public void responseBodyEnd(Call r1, long r2) {
    }

    public void responseBodyStart(Call r1) {
    }

    public void responseHeadersEnd(Call r1, Response r2) {
    }

    public void responseHeadersStart(Call r1) {
    }

    public void secureConnectEnd(Call r1, @Nullable j r2) {
    }

    public void secureConnectStart(Call r1) {
    }

    static {
        NONE = new a();
    }

    public static c factory(i r1) {
        return new b(r1);
    }
}
