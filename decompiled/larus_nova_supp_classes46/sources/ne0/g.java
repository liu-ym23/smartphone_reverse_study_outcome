package ne0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final <T> T a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        T r0 = (T) this.a.a.get(r3);
        if (r0 != null) goto L11;
        e r1 = this.a.f;
        if (r1 == null) goto L12;
        g r2 = r1.b;
        if (r2 != null) goto L13;
        return null;
    L13:
        return (T) r2.a(r3);
    L12:
        return r0;
    L11:
        return r0;
    }

    public final DataCenter b(String r2, Observer<KVData> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.a.observe(r2, r3);
    }
}
