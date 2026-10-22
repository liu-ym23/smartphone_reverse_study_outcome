package lu1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements iu1.b {
    public final PropertyOwner<ju1.n> a;
    public final ju1.h b;

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        return this.b;
    }

    public o(ju1.h r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        this.b = r4;
        this.a = new PropertyOwner(new ju1.n(r4.a(), true));
    }

    @Override // iu1.b
    public final void a(ju1.n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.a(r2);
    }

    @Override // iu1.b
    public final void b(ju1.n r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.a(r2);
    }
}
