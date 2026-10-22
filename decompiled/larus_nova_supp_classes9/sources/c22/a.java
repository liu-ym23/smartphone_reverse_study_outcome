package c22;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final boolean a(NormalGiftMessage r3, NormalGiftMessage r4) {
        Intrinsics.checkNotNullParameter(r4, "newMsg");
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = r3.u();
        if (r1 == null) goto L11;
        if (r1.equals(r4.u()) == true) goto L11;
        return false;
    L11:
        if (r3.p == false) goto L13;
    L17:
        return false;
    L13:
        if (r4.p == true) goto L17;
        return true;
    }
}
