package okhttp3;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu.x f20623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiskLruCache.Snapshot f20624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20625c;
    public final String d;

    public d(DiskLruCache.Snapshot r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        this.f20624b = r5;
        this.f20625c = r10;
        this.d = r11;
        this.f20623a = f4.b.e(new c(this, r5.getSource(1)));
    }

    @Override // okhttp3.w0
    public final long contentLength() {
        String r5 = this.d;
        if (r5 != null) goto L5;
        return -1;
    L5:
        return Util.toLongOrDefault(r5, -1);
    }

    @Override // okhttp3.w0
    public final h0 contentType() {
        String r5 = this.f20625c;
        if (r5 == null) goto L5;
        Pattern r10 = h0.e;
        return z.j(r5);
    L5:
        return null;
    }

    @Override // okhttp3.w0
    public final nu.l source() {
        return this.f20623a;
    }
}
