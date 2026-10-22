package j52;

import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import h52.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements l52.c.a {
    public final LimitedSizeHashMap a;

    public c() {
        this.a = new LimitedSizeHashMap(512);
    }

    @Override // l52.c.a
    public final boolean a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        long r0 = r4.e();
        if (this.a.containsKey(Long.valueOf(r0)) == false) goto L6;
        return true;
    L6:
        this.a.put(Long.valueOf(r0), null);
        return false;
    }
}
