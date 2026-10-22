package f0c;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f extends b {
    public final g c;

    @Override // f0c.b
    public final g a() {
        return this.c;
    }

    public f(g r3, Scene r4, lzb.a r5) {
        Intrinsics.checkNotNullParameter(r3, "userPayload");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r3, new h(UserState.ONLINE, r4, r5));
        this.c = r3;
    }
}
