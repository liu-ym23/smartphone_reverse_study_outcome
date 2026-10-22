package f0c;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends b {
    public a(Scene r2, UserState r3, lzb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "initState");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(null, new h(r3, r2, r4));
    }
}
