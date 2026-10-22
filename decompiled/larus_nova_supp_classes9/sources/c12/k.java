package c12;

import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements IDownloadHttpService {
    public com.bytedance.android.livesdk.revenue.network.c<com.bytedance.android.livesdk.revenue.network.b> a;
    public com.bytedance.android.livesdk.revenue.network.b b;

    public class a implements TypedInput {
        public final /* synthetic */ k a;

        public final InputStream in() throws IOException {
            return new ByteArrayInputStream(this.a.b.getBody());
        }

        public final long length() throws IOException {
            return this.a.b.getBody().length;
        }

        public final String mimeType() {
            return this.a.b.getMimeType();
        }

        public a(k r1) {
            this.a = r1;
        }
    }

    public class b implements IDownloadHttpConnection {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ Response b;
        public final /* synthetic */ k c;

        public final void end() {
        }

        public final void cancel() {
            com.bytedance.android.livesdk.revenue.network.c<com.bytedance.android.livesdk.revenue.network.b> r0 = this.c.a;
            if (r0 == null) goto L11;
            r0.cancel();     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public final int getResponseCode() throws IOException {
            return this.b.getStatus();
        }

        public final InputStream getInputStream() throws IOException {
            return this.a;
        }

        public final String getResponseHeaderField(String r4) {
            k r0 = this.c;
            List r1 = this.b.getHeaders();
            r0.getClass();
            if (r1 != null) goto L5;
        L12:
            return null;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L12;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            Header r3 = (Header) r2.next();
            if (r4.equalsIgnoreCase(r3.getName()) == false) goto L8;
            return r3.getValue();
        }

        public b(k r1, InputStream r2, Response r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public k() {
    }

    public final IDownloadHttpConnection downloadWithConnection(int r7, String r8, List<HttpHeader> r9) throws IOException {
        HashMap r0 = new HashMap();
        if (r9 == null) goto L8;
        Iterator<HttpHeader> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        HttpHeader r1 = r10.next();
        r0.put(r1.getName(), r1.getValue());
    L8:
        r0.put("Accept-Encoding", "identity");
        com.bytedance.android.livesdk.revenue.network.i r11 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.network.a.class).di(r7, r8, r0);
        this.a = r11;
        com.bytedance.android.livesdk.revenue.network.b r13 = (com.bytedance.android.livesdk.revenue.network.b) r11.a();
        this.b = r13;
        if (r13 != null) goto L12;
        return null;
    L12:
        ArrayList r4 = new ArrayList();
        if (this.b.getHeaders() == null) goto L18;
        Iterator r14 = this.b.getHeaders().keySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        String r15 = (String) r14.next();
        r4.add(new Header(r15, (String) this.b.getHeaders().get(r15)));
    L18:
        Response r16 = new Response(r8, this.b.getStatusCode(), this.b.getReason(), r4, new a(this));
        return new b(this, new ByteArrayInputStream(this.b.getBody()), r16);
    }
}
