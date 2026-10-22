package okhttp3;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f20761a = null;

    static {
        f20761a = new u();
    }

    public void a(Call r5, InetSocketAddress r10, Proxy r11, Protocol r12) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r11, "proxy");
    }

    public void b(Call r5, RealConnection r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
    }

    public void c(Call r5, n r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
    }

    public void d(RealCall r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
    }
}
