package k31;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static final boolean b(Context r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        Activity r2 = ContextUtil.contextToActivity(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        if ((r2.getWindow().getAttributes().flags & 1024) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static final int a(Context r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(b03.a.a, "$this$getAppContentHeightCompact");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r5 == false) goto L5;
        int r6 = StatusBarUtil.getDesiredTopSpaceHeight();
    L7:
        return b03.c.a(r3, r4, r6);
    L5:
        r6 = 0;
        goto L7
    }

    public static final boolean c(boolean r1, boolean r2, boolean r3) {
        return ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo468getMultiAnchorService().c().a(r1, r2, r3);
    }
}
