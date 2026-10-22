package d7;

import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import we.a0;
import we.c0;

/* JADX INFO: loaded from: classes.dex */
public final class r implements TypedInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f6931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f6932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f6933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p.b f6934d;

    public r(p.b r8, c0 r10, TreeMap r11, boolean r12) {
        this.f6934d = r8;
        this.f6931a = r10;
        this.f6932b = r11;
        this.f6933c = r12;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final InputStream in() {
        p.b r8 = this.f6934d;
        InputStream r10 = this.f6931a.k().p0();     // Catch: Throwable -> L9
        boolean r11 = this.f6933c;     // Catch: Throwable -> L9
        RetrofitMetrics r12 = r8.f6926s;     // Catch: Throwable -> L9
        int r13 = h7.c.f7920a;     // Catch: Throwable -> L9
        if (r11 == false) goto L6;
        r10 = new GZIPInputStream(r10);     // Catch: Throwable -> L9
    L7:
        return new w6.d(r10, r8);
    L6:
        w6.e.d r14 = w6.e.f13020a;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        a0 r15 = r8.f6924q;
        if (r15 == null) goto L18;
        StringBuilder r16 = new StringBuilder("reason = ");
        String r17 = r15.f13117n;
        if (r17 != null) goto L15;
        r17 = "";
    L15:
        r16.append(r17);
        r16.append("  exception = ");
        r16.append(th.getMessage());
        String r18 = r16.toString();
        throw new b7.b(r8.f6924q.f13116m, r18);
    L18:
        throw new IOException(th);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final long length() {
        return this.f6931a.a();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public final String mimeType() {
        we.t r8 = this.f6931a.i();
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.f13260a;
    }
}
