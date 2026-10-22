package u01;

import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements qc0.e {
    public final InteractFeedActionCaller a;

    public final void onCouplePkEnd() {
        this.a.onCouplePkEnd();
    }

    public final void onPkToNormal() {
        this.a.onPkToNormal();
    }

    public k(InteractFeedActionCaller r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }
}
