package s01;

import ca0.s;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements s {
    public final g50.b a;

    public a(g50.b r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    public final void j(f r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        this.a.a(new g50.a(r4.a, r4.c));
    }
}
