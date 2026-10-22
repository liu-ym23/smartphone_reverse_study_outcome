package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import nu.a0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/cache/CacheRequest;", "", "Lnu/a0;", "body", "()Lnu/a0;", "", "abort", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface CacheRequest {
    void abort();

    a0 body() throws IOException;
}
