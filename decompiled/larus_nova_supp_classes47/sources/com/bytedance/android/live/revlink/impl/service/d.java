package com.bytedance.android.live.revlink.impl.service;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.utils.i0;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kc0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements l {
    public d() {
    }

    public final int a() {
        int r0 = i0.a;
        return (int) (((double) ((Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext())) * 16) / 9)) * e31.b.a);
    }

    public final int getVideoHeight() {
        int r0 = i0.a;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r1 == null) goto L9;
        i11.b r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L9;
        List<p> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L11:
        if (r4 <= 2) goto L13;
        double r5 = (Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext())) * 16) / 9;
        double r6 = 0.49583333333333335d;
    L15:
        return (int) (r5 * r6);
    L13:
        r5 = (Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext())) * 16) / 9;
        r6 = 0.40286458333333336d;
    L9:
        r4 = 0;
        goto L11
    }

    public final int getVideoWidth() {
        int r0 = i0.a;
        return (int) (((double) Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext()))) * 0.49583333333333335d);
    }
}
