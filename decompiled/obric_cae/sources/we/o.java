package we;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static final o NONE = null;

    public static class a extends o {
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f13233a;

        public b(o r8) {
            this.f13233a = r8;
        }
    }

    public interface c {
    }

    static {
        NONE = new a();
    }

    public o() {
    }

    public static c factory(o r8) {
        return new b(r8);
    }

    public void callEnd(d r8) {
    }

    public void callFailed(d r8, IOException r10) {
    }

    public void callInSecureRedirect(d r8, JSONObject r10) {
    }

    public void callStart(d r8) {
    }

    public void connectEnd(d r8, InetSocketAddress r10, Proxy r11, @Nullable w r12) {
    }

    public void connectFailed(d r8, InetSocketAddress r10, Proxy r11, @Nullable w r12, IOException r13) {
    }

    public void connectStart(d r8, InetSocketAddress r10, Proxy r11) {
    }

    public void connectionAcquired(d r8, h r10) {
    }

    public void connectionReleased(d r8, h r10) {
    }

    public void dnsEnd(d r8, String r10, List<InetAddress> r11) {
    }

    public void dnsStart(d r8, String r10) {
    }

    public void requestBodyEnd(d r8, long r10) {
    }

    public void requestBodyStart(d r8) {
    }

    public void requestHeadersEnd(d r8, y r10) {
    }

    public void requestHeadersStart(d r8) {
    }

    public void responseBodyEnd(d r8, long r10) {
    }

    public void responseBodyStart(d r8) {
    }

    public void responseHeadersEnd(d r8, a0 r10) {
    }

    public void responseHeadersStart(d r8) {
    }

    public void secureConnectEnd(d r8, @Nullable p r10) {
    }

    public void secureConnectStart(d r8) {
    }

    public void connectFailed(d r8, InetSocketAddress r10, Proxy r11, @Nullable w r12, IOException r13, String r14) {
    }

    public void dnsEnd(d r8, String r10, List<InetAddress> r11, String r12) {
    }
}
