package a31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import x21.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final PlayMode a(FeedMultiPlayMode r1) {
        if (r1 == null) goto L16;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L16;
        return PlayMode.TEAM_PK;
    L15:
        return PlayMode.PERSONAL_PK;
    L16:
        return PlayMode.PERSONAL_PK;
    }

    public static final int b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLynxPkState");
        if ((r1 instanceof d.C0344d) == false) goto L6;
        return 0;
    L6:
        if ((r1 instanceof d.c) == false) goto L9;
        return 1;
    L9:
        if ((r1 instanceof d.b) == false) goto L12;
        return 2;
    L12:
        if ((r1 instanceof d.a) == false) goto L16;
        return 3;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
