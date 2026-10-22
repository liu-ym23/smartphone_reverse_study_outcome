package x21;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.u1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final IBaseBattleSetting a(b.c r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setting");
        c5 r0 = r2.b;
        c3 r3 = r2.c;
        if (r0 == null) goto L8;
        u1 r4 = r0.getBattleSetting();
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4;
    L8:
        if (r3 == null) goto L14;
        c1 r5 = r3.getBattleSetting();
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5;
    L14:
        return null;
    }
}
