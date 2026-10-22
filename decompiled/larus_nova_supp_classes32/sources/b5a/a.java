package b5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICoreCode;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public static final ExecutorService d = null;
    public final String a;
    public final b b;
    public final ByteArrayOutputStream c;

    static {
        d = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("DevToolDownloader"));
    }

    public final void b() {
        HttpURLConnection r2 = (HttpURLConnection) a(new URL(this.a));     // Catch: Exception -> L26
        r2.setConnectTimeout(1440);     // Catch: Exception -> L26
        r2.setReadTimeout(SAMICoreCode.SAMI_EXTRACTOR_BASE);     // Catch: Exception -> L26
        r2.setDoOutput(false);     // Catch: Exception -> L26
        r2.setDoInput(true);     // Catch: Exception -> L26
        r2.connect();     // Catch: Exception -> L26
        r2.setInstanceFollowRedirects(true);     // Catch: Exception -> L26
        int r4 = r2.getResponseCode();     // Catch: Exception -> L26
        if (r4 <= 299) goto L9;
        r2.disconnect();     // Catch: Exception -> L26
        String r0 = "Download connection failed and the response code is " + r4;     // Catch: Exception -> L26
        b r1 = this.b;     // Catch: Exception -> L26
        if (r1 == null) goto L33;
        r1.onFailure(r0);     // Catch: Exception -> L26
        return;
    L33:
        return;
    L9:
        int r3 = r2.getContentLength();     // Catch: Exception -> L26
        b r5 = this.b;     // Catch: Exception -> L26
        if (r5 == null) goto L12;
        r5.onResponse(r4, r3);     // Catch: Exception -> L26
    L12:
        Runtime r6 = Runtime.getRuntime();     // Catch: Exception -> L26
        long r7 = ((r6.maxMemory() - r6.totalMemory()) + r6.freeMemory()) / 10;     // Catch: Exception -> L26
        if (r3 <= r7) goto L18;
        r2.disconnect();     // Catch: Exception -> L26
        String r8 = "The size of the downloaded data has exceeded the maximum safe memory size, which may pose a risk of OOM. Currently, the content size is " + r3 + " byte, and the safe memory available for use is " + r7;     // Catch: Exception -> L26
        b r9 = this.b;     // Catch: Exception -> L26
        if (r9 == null) goto L34;
        r9.onFailure(r8);     // Catch: Exception -> L26
        return;
    L34:
        return;
    L18:
        InputStream r10 = r2.getInputStream();     // Catch: Exception -> L26
        byte[] r11 = new byte[8192];     // Catch: Exception -> L26
    L19:
        int r12 = r10.read(r11);     // Catch: Exception -> L26
        if (r12 == (-1)) goto L21;
        this.c.write(r11, 0, r12);     // Catch: Exception -> L26
        goto L19
    L21:
        byte[] r13 = this.c.toByteArray();     // Catch: Exception -> L26
        int r14 = this.c.size();     // Catch: Exception -> L26
        b r15 = this.b;     // Catch: Exception -> L26
        if (r15 == null) goto L35;
        r15.onData(r13, r14);     // Catch: Exception -> L26
        return;
    L35:
        return;
    L26:
        e = move-exception;
        String r16 = "An exception occurred when download: " + e.getMessage();
        b r17 = this.b;
        if (r17 == null) goto L37;
        r17.onFailure(r16);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public a(String r1, b r2) {
        this.a = r1;
        this.b = r2;
        this.c = new ByteArrayOutputStream();
        d.execute(this);
    }
}
