package g12;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.m2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final h1 a(m2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getGift");
        b r2 = (b) r1.castToOrNull(b.class);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getGift();
    }
}
