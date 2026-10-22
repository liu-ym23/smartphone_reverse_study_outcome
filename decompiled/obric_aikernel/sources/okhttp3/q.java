package okhttp3;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final q f12021a = null;

    public static final class a extends q {
        a() {
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface c {
        q a(e r10);
    }

    static {
        new b(null);
        f12021a = new a();
    }

    public q() {
    }

    public void A(e r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "ioe");
    }

    public void B(e r10, z r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "response");
    }

    public void C(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void D(e r10, z r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "response");
    }

    public void E(e r10, Handshake r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void F(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void a(e r10, z r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "cachedResponse");
    }

    public void b(e r10, z r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "response");
    }

    public void c(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void d(e r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "ioe");
    }

    public void e(e r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "jsonObject");
    }

    public s f(e r10, s r11, String r12, s r13) {
        return null;
    }

    public void g(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void h(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void i(e r10, InetSocketAddress r11, Proxy r12, Protocol r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r12, "proxy");
    }

    public void j(e r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r12, "proxy");
        Intrinsics.checkNotNullParameter(r14, "ioe");
    }

    public void k(e r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r12, "proxy");
        Intrinsics.checkNotNullParameter(r14, "ioe");
    }

    public void l(e r10, InetSocketAddress r11, Proxy r12) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r12, "proxy");
    }

    public void m(e r10, i r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
    }

    public void n(e r10, i r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION);
    }

    public void o(e r10, String r11, List<InetAddress> r12) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "domainName");
        Intrinsics.checkNotNullParameter(r12, "inetAddressList");
    }

    public void p(e r10, String r11, List<InetAddress> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "domainName");
    }

    public void q(e r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "domainName");
    }

    public void r(e r10, s r11, List<Proxy> r12) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "proxies");
    }

    public void s(e r10, s r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "url");
    }

    public void t(e r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void u(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void v(e r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "ioe");
    }

    public void w(e r10, x r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "request");
    }

    public void x(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void y(e r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }

    public void z(e r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
    }
}
