package hq9;

import com.larus.platform.model.LarkSocialFeedPresentationMode;
import com.larus.platform.model.LarkSocialSnapshotState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static r2 a(r2 r2, m2 r3) {
        Intrinsics.checkNotNullParameter(r2, "previous");
        Intrinsics.checkNotNullParameter(r3, "capability");
        v2 r4 = r2.b;
        if (r4 != null) goto L5;
    L7:
        r4 = null;
    L9:
        if (r3.c == false) goto L16;
        v2 r0 = r3.b;
        if (r0 == null) goto L16;
        if (Intrinsics.areEqual(r3.h, r0) == false) goto L16;
        r4 = r3.b;
    L16:
        if (r3.a == LarkSocialSnapshotState.READY) goto L18;
    L27:
        LarkSocialFeedPresentationMode r5 = LarkSocialFeedPresentationMode.NATIVE;
    L29:
        return new r2(r5, r4);
    L18:
        if (r3.c == false) goto L27;
        if (Intrinsics.areEqual(r4, r3.b) == false) goto L24;
        r5 = LarkSocialFeedPresentationMode.NATIVE;
        goto L29
    L24:
        if (r3.d == false) goto L26;
        r5 = LarkSocialFeedPresentationMode.MIXED_ACTIVE;
        goto L29
    L26:
        r5 = LarkSocialFeedPresentationMode.MIXED_PENDING;
        goto L29
    L5:
        if (Intrinsics.areEqual(r4, r3.b) == false) goto L7;
        goto L7
    }
}
