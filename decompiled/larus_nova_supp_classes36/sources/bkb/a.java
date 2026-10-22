package bkb;

import com.bytedance.lark.pb.tool.v1.OnFetchResponse;
import com.bytedance.lark.sdk.LarkResponse;
import com.ss.android.lark.log.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.concurrent.CountDownLatch;
import se6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements j {
    public final /* synthetic */ String a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ py5.b d;

    public final void b(OnFetchResponse.OnProgressResponse r1) {
    }

    public final void a(OnFetchResponse.OnErrorResponse r2) {
        this.b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onErrorResponse called: " + this.a);
    }

    public final void c(OnFetchResponse.OnSuccessResponse r2) {
        this.b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onSuccessResponse called: " + this.a);
    }

    public final void d(LarkResponse r2) {
        this.b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onFetchResponse called: " + this.a);
    }

    public final void e(OnFetchResponse.OnHeaderResponse r2) {
        Log.i("LarkGeckoClient", "downloadFile, onHeaderResponse called: " + this.a);
    }

    public final void f(OnFetchResponse.OnBodyResponse r6) {
        int[] r0 = this.c;
        r0[0] = r0[0] + 1;
        BufferedInputStream r7 = new BufferedInputStream(new ByteArrayInputStream(r6.body.toByteArray()));
        byte[] r2 = new byte[2048];     // Catch: Throwable -> L10 Exception -> L12
    L4:
        int r3 = r7.read(r2, 0, 2048);     // Catch: Throwable -> L10 Exception -> L12
        if (r3 == (-1)) goto L8;
        this.d.write(r2, 0, r3);     // Catch: Throwable -> L10 Exception -> L12
    L8:
        ez5.b.a(r7);
        return;
    L12:
        e = move-exception;
        throw new RuntimeException("LarkGeckoClient, downloadFile failed, url:" + this.a + ", caused by:" + e.getMessage(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ez5.b.a(r7);
        throw th;
    }

    public final void g(OnFetchResponse.OnCancelResponse r2) {
        this.b.countDown();
        Log.i("LarkGeckoClient", "downloadFile, onCancelResponse called: " + this.a);
    }

    public a(String r1, CountDownLatch r2, int[] r3, py5.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
