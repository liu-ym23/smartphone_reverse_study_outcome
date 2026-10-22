package okhttp3.internal.http;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu.l;
import okhttp3.h0;
import okhttp3.w0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/RealResponseBody;", "Lokhttp3/w0;", "", "contentTypeString", "", "contentLength", "Lnu/l;", "source", "<init>", "(Ljava/lang/String;JLnu/l;)V", "()J", "Lokhttp3/h0;", "contentType", "()Lokhttp3/h0;", "()Lnu/l;", "Ljava/lang/String;", "J", "Lnu/l;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealResponseBody extends w0 {
    private final long contentLength;
    private final String contentTypeString;
    private final l source;

    public RealResponseBody(String r5, long r10, l r11) {
        Intrinsics.checkNotNullParameter(r11, "source");
        this.contentTypeString = r5;
        this.contentLength = r10;
        this.source = r11;
    }

    @Override // okhttp3.w0
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.w0
    public h0 contentType() {
        String r5 = this.contentTypeString;
        if (r5 == null) goto L5;
        Pattern r10 = h0.e;
        return z.j(r5);
    L5:
        return null;
    }

    @Override // okhttp3.w0
    public l source() {
        return this.source;
    }
}
