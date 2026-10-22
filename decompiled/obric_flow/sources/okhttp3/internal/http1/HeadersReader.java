package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.l;
import okhttp3.b0;
import okhttp3.c0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http1/HeadersReader;", "", "Lnu/l;", "source", "<init>", "(Lnu/l;)V", "", "readLine", "()Ljava/lang/String;", "Lokhttp3/c0;", "readHeaders", "()Lokhttp3/c0;", "", "headerLimit", "J", "Lnu/l;", "getSource", "()Lnu/l;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HeadersReader {
    public static final Companion Companion = null;
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final l source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http1/HeadersReader$Companion;", "", "()V", "HEADER_LIMIT", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HeadersReader(l r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        this.source = r5;
        this.headerLimit = 262144;
    }

    public final l getSource() {
        return this.source;
    }

    public final c0 readHeaders() {
        b0 r5 = new b0();
    L3:
        String r10 = readLine();
        if (r10.length() == 0) goto L6;
        r5.b(r10);
        goto L3
    L6:
        return r5.d();
    }

    public final String readLine() {
        String r5 = this.source.c(this.headerLimit);
        this.headerLimit -= (long) r5.length();
        return r5;
    }
}
