package evc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import cvc.c;
import java.io.IOException;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.g;
import okhttp3.h;
import okhttp3.internal.Version;
import okio.Okio;
import okio.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements Interceptor {
    public final h a;

    public a(h r1) {
        this.a = r1;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r15) throws IOException {
        Request r0 = r15.request();
        Request.Builder r1 = r0.newBuilder();
        RequestBody r2 = r0.body();
        if (r2 == null) goto L11;
        MediaType r7 = r2.contentType();
        if (r7 == null) goto L7;
        r1.header(DownloadHelper.CONTENT_TYPE, r7.toString());
    L7:
        long r8 = r2.contentLength();
        if (r8 == (-1)) goto L10;
        r1.header(DownloadUtils.CONTENT_LENGTH, Long.toString(r8));
        r1.removeHeader(DownloadHelper.TRANSFER_ENCODING);
        goto L11
    L10:
        r1.header(DownloadHelper.TRANSFER_ENCODING, DownloadHelper.VALUE_CHUNKED);
        r1.removeHeader(DownloadUtils.CONTENT_LENGTH);
    L11:
        int r9 = 0;
        if (r0.header(DownloadConstants.HOST) != null) goto L15;
        r1.header(DownloadConstants.HOST, c.m(r0.url(), false));
    L15:
        if (r0.header("Connection") != null) goto L18;
        r1.header("Connection", "Keep-Alive");
    L18:
        if (r0.header(DownloadHelper.ACCEPT_ENCODING) == null) goto L20;
    L22:
        boolean r3 = false;
    L23:
        List<g> r10 = this.a.a(r0.url());
        if (r10.isEmpty() == true) goto L32;
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.size();
    L26:
        if (r9 >= r12) goto L30;
        if (r9 <= 0) goto L29;
        r11.append("; ");
    L29:
        g r13 = (g) ListProtector.get(r10, r9);
        r11.append(r13.a);
        r11.append('=');
        r11.append(r13.b);
        r9 = r9 + 1;
        goto L26
    L30:
        r1.header("Cookie", r11.toString());
    L32:
        if (r0.header(DownloadConstants.USER_AGENT) != null) goto L34;
        r1.header(DownloadConstants.USER_AGENT, Version.userAgent());
    L34:
        Response r16 = r15.proceed(r1.build());
        e.e(this.a, r0.url(), r16.headers());
        Response.Builder r4 = r16.newBuilder().request(r0);
        if (r3 == false) goto L42;
        if (DownloadHelper.GZIP.equalsIgnoreCase(r16.header(DownloadHelper.CONTENT_ENCODING)) == false) goto L42;
        if (e.b(r16) == false) goto L42;
        q r5 = new q(r16.body().source());
        r4.headers(r16.headers().newBuilder().removeAll(DownloadHelper.CONTENT_ENCODING).removeAll(DownloadUtils.CONTENT_LENGTH).build());
        r4.body(new g(r16.header(DownloadHelper.CONTENT_TYPE), -1, Okio.buffer(r5)));
    L42:
        return r4.build();
    L20:
        if (r0.header("Range") != null) goto L22;
        r1.header(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);
        r3 = true;
        goto L23
    }
}
