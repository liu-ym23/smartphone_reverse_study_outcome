package zd0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements yd0.a {
    public boolean a;
    public final DataCenter b;

    public e(DataCenter r1) {
        this.b = r1;
    }

    @Override // yd0.a
    public final boolean a(wd0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "renderContext");
        return !this.a;
    }
}
