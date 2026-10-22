package bkb;

import com.bytedance.geckox.net.INetWork;
import com.bytedance.lark.sdk.LarkRequest;
import com.ss.android.lark.log.Log;
import java.io.BufferedInputStream;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends b implements INetWork {
    public e(boolean r1) {
        super(r1);
    }

    public final void downloadFile(String r9, long r10, py5.b r12) {
        Log.i("LarkGeckoClient", "downloadFile: " + r9);
        int r0 = 0;
        if (this.c == false) goto L36;
        Log.i("LarkGeckoClient", "isBoe, use downloadFileUseSendHttp");
        Log.i("LarkGeckoClient", "downloadFileUseSendHttp start: " + r9);
        Request r3 = b(r9).get().build();     // Catch: Throwable -> L28 Exception -> L30
        if (this.c == false) goto L8;
        Call r4 = ((OkHttpClient) this.b).newCall(r3);     // Catch: Throwable -> L28 Exception -> L30
    L9:
        Response r5 = r4.execute();     // Catch: Throwable -> L28 Exception -> L30
        int r6 = r5.code();     // Catch: Throwable -> L28 Exception -> L30
        if (r6 != 200) goto L25;
        BufferedInputStream r7 = new BufferedInputStream(r5.body().byteStream());     // Catch: Exception -> L26 Throwable -> L28
        byte[] r8 = new byte[2048];     // Catch: Throwable -> L20 Exception -> L22
    L15:
        int r11 = r7.read(r8, 0, 2048);     // Catch: Throwable -> L20 Exception -> L22
        if (r11 == (-1)) goto L19;
        r12.write(r8, 0, r11);     // Catch: Throwable -> L20 Exception -> L22
    L19:
        ez5.b.a(r7);
        Log.i("LarkGeckoClient", "downloadFileUseSendHttp finish: " + r9);
        return;
    L22:
        e = e;
        r0 = r6;
    L32:
        throw new RuntimeException("downloadFile failed, code: " + r0 + ", url:" + r9 + ", caused by:" + e.getMessage(), e);     // Catch: Throwable -> L28
    L20:
        th = th;
    L34:
        ez5.b.a(r7);
        throw th;
    L25:
        throw new RuntimeException("downloadFile failed, code: " + r6 + ", url:" + r9);     // Catch: Exception -> L26 Throwable -> L28
    L26:
        e = e;
        r0 = r6;
        goto L32
    L8:
        r4 = ((x18.b) this.b).newCall(r3);     // Catch: Throwable -> L28 Exception -> L30
    L28:
        th = th;
        r7 = null;
    L30:
        e = e;
        goto L32
    L36:
        Log.i("LarkGeckoClient", "downloadFileUseFetchAsync start: " + r9);
        CountDownLatch r1 = new CountDownLatch(1);
        LarkRequest.a r13 = new LarkRequest.a();
        int[] r14 = {0};
        a r15 = new a(r9, r1, r14, r12);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r13.a = r9;
        LarkRequest r16 = new LarkRequest(r13);
        Intrinsics.checkNotNullParameter(r16, "request");
        Intrinsics.checkNotNullParameter(r15, "listener");
        com.bytedance.lark.sdk.b.e(r16, r15, true);
        r1.await();     // Catch: InterruptedException -> L39
    L41:
        Log.i("LarkGeckoClient", "downloadFileUseFetchAsync finish, onBodyResponseCallNum: " + r14[0] + ", url = " + r9);
        return;
    L39:
        e = move-exception;
        Log.e("LarkGeckoClient", "latch.await failed, e: " + e.getMessage() + ", url = " + r9, e);
        goto L41
    }
}
