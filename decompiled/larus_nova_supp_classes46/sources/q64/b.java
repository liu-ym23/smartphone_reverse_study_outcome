package q64;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final int a;
    public final String b;
    public final String c;
    public final c d;
    public final e e;
    public final Throwable f;

    public final String toString() {
        return "BdpHostResponse(code=" + this.a + ", message='" + this.b + "', headers=" + this.d + ",body=" + this.e + ", throwable=" + this.f + ')';
    }

    public b(int r2, String r3, String r4, c r5, e r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "headers");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
