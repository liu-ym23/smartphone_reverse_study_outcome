package l8;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.frameworks.baselib.network.http.cronet.b;
import com.bytedance.ies.bullet.service.base.c;
import com.bytedance.sdk.xbridge.cn.auth.g;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Random;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.n0;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f19548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f19550c;
    public Call d;
    public long e;
    public boolean f;

    static {
        Collections.singletonList(Protocol.HTTP_1_1);
    }

    public a(Request r5, Random r10) {
        new ArrayDeque();
        this.f19550c = new ArrayDeque();
        if ("GET".equals(r5.method()) == false) goto L7;
        this.f19548a = r5;
        byte[] r11 = new byte[16];
        r10.nextBytes(r11);
        this.f19549b = ByteString.of(r11).base64();
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r5.method());
    }

    public final synchronized void a(int r5, String r10) {
        monitor-enter(this);
        if (r5 >= 1000) goto L6;
    L20:
        String r11 = com.lynx.jsbridge.a.d(r5, "Code must be in range [1000,5000): ");     // Catch: Throwable -> L17
    L21:
        if (r11 != null) goto L37;
        if (r10 == null) goto L29;
        if (ByteString.encodeUtf8(r10).size() <= 123) goto L29;
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r10));     // Catch: Throwable -> L17
    L29:
        if (this.f == false) goto L33;
        monitor-exit(this);
        return;
    L33:
        this.f = true;     // Catch: Throwable -> L17
        this.f19550c.add(new c(12));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L37:
        throw new IllegalArgumentException(r11);     // Catch: Throwable -> L17
    L6:
        if (r5 >= 5000) goto L20;
        if (r5 < 1004) goto L13;
        if (r5 > 1006) goto L13;
    L16:
        r11 = "Code " + r5 + " is reserved and may not be used.";     // Catch: Throwable -> L17
    L13:
        if (r5 >= 1012) goto L15;
    L19:
        r11 = null;
        goto L21
    L15:
        if (r5 > 2999) goto L19;
    L17:
        th = move-exception;
        throw th;
    }

    public final void b(OkHttpClient r5) {
        n0 r10 = this.f19548a.newBuilder();
        r10.c(Constant.UPDATE_PATH, "websocket");
        r10.c("Connection", Constant.UPDATE_PATH);
        r10.c("Sec-WebSocket-Key", this.f19549b);
        r10.c("Sec-WebSocket-Version", "13");
        Request r11 = r10.b();
        Call r12 = Internal.instance.newWebSocketCall(r5, r11);
        this.d = r12;
        r12.enqueue(new b(12));
    }

    public final synchronized boolean c(ByteString r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if ((this.e + ((long) r10.size())) <= 16777216) goto L15;
        a(1001, null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L15:
        this.e += (long) r10.size();     // Catch: Throwable -> L13
        this.f19550c.add(new g(12));     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }
}
