package yg0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements nn0.a {
    public c() {
    }

    @Override // nn0.a
    public final void a(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "subTag");
        Intrinsics.checkNotNullParameter(r5, "content");
        if (r6 == false) goto L5;
        ALogger.e("LayoutConfigV2", "8-14[" + r4 + "]: " + r5);
        return;
    L5:
        ALogger.i("LayoutConfigV2", "8-14[" + r4 + "]: " + r5);
    }
}
