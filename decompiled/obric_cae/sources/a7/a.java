package a7;

import android.content.Context;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class a implements TypedInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HttpURLConnection f58a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f59b;

    public a(b r8, HttpURLConnection r10) {
        this.f59b = r8;
        this.f58a = r10;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final InputStream in() {
        b r8 = this.f59b;
        HttpURLConnection r10 = this.f58a;
        InputStream r11 = r10.getInputStream();     // Catch: Exception -> L6
        r10.getHeaderFields();     // Catch: Exception -> L6
        RetrofitMetrics r12 = r8.f60a;     // Catch: Exception -> L6
        int r13 = h7.c.f7920a;     // Catch: Exception -> L6
        w6.e.d r14 = w6.e.f13020a;     // Catch: Exception -> L6
        return new w6.d(r11, r8);
    L6:
        e = move-exception;
        w6.a r15 = r8.f67r;
        Context r16 = i.f110a;
        String r17 = r10.getResponseMessage();
        StringBuilder r18 = new StringBuilder("reason = ");
        if (r17 != null) goto L10;
        r17 = "";
    L10:
        r18.append(r17);
        r18.append("  exception = ");
        r18.append(e.getMessage());
        String r19 = r18.toString();
        throw new b7.b(r10.getResponseCode(), r19);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final long length() {
        return this.f58a.getContentLength();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final String mimeType() {
        return i.i("Content-Type", this.f58a);
    }
}
