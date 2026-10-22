package gy7;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public final loa.a a;

    public p(loa.a r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_USER);
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r12, "sessionKey");
        this.a = r10;
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r12, "sessionKey");
    }
}
