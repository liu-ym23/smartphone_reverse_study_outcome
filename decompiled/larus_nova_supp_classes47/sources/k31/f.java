package k31;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public n0 a;
    public p0 b;
    public String c;

    public f() {
    }

    public final long a() {
        p0 r0 = this.b;
        if (r0 == null) goto L11;
        String r1 = r0.getChannelId();
        if (r1 == null) goto L13;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 != null) goto L10;
        return 0;
    L10:
        return r2.longValue();
    L13:
        return 0;
    L11:
        return 0;
    }
}
