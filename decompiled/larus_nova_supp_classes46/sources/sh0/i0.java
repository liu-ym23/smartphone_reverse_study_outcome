package sh0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 extends ne0.e {
    @Override // ne0.e
    public final void f() {
        DataCenter r0 = this.a;
        int r1 = h0.a;
        r0.put("dynamic_biz_state", new LinkedHashMap());
    }

    public final boolean g() {
        ne0.g r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = h0.a;
        Boolean r2 = (Boolean) r0.a("is_danmu_game_on");
    L7:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L5:
        r2 = null;
        goto L7
    }

    public final boolean h() {
        ne0.g r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = h0.a;
        Boolean r2 = (Boolean) r0.a("is_mic_seat_fold");
    L7:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L5:
        r2 = null;
        goto L7
    }

    public i0(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super(r2);
    }
}
