package a7;

import android.content.Context;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d implements TypedInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HttpURLConnection f79a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f80b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f81c;

    public d(e r8, HttpURLConnection r10, boolean r11) {
        this.f81c = r8;
        this.f79a = r10;
        this.f80b = r11;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final InputStream in() {
        e r8 = this.f81c;
        HttpURLConnection r10 = this.f79a;
        InputStream r11 = r10.getInputStream();     // Catch: Exception -> L9
        r10.getHeaderFields();     // Catch: Exception -> L9
        boolean r12 = this.f80b;     // Catch: Exception -> L9
        RetrofitMetrics r13 = r8.f90q;     // Catch: Exception -> L9
        int r14 = h7.c.f7920a;     // Catch: Exception -> L9
        if (r12 == false) goto L6;
        r11 = new GZIPInputStream(r11);     // Catch: Exception -> L9
    L8:
        return new w6.d(r11, r8);
    L6:
        w6.e.d r15 = w6.e.f13020a;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        w6.a r16 = r8.f85b;
        Context r17 = i.f110a;
        String r18 = r10.getResponseMessage();
        StringBuilder r19 = new StringBuilder("reason = ");
        if (r18 != null) goto L13;
        r18 = "";
    L13:
        r19.append(r18);
        r19.append("  exception = ");
        r19.append(e.getMessage());
        String r20 = r19.toString();
        throw new b7.b(r10.getResponseCode(), r20);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final long length() {
        return this.f79a.getContentLength();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final String mimeType() {
        return i.i("Content-Type", this.f79a);
    }
}
