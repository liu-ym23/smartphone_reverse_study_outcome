package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IAnchorUpdateLayoutContent.UpdateAnchorLayoutType c;
    public final /* synthetic */ long d;

    public k(l r1, String r2, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        Throwable r13 = (Throwable) r12;
        l r0 = this.a;
        int r1 = 0;
        r0.b = false;
        v r2 = r0.getContext().getMultiLinkMonitor();
        String r3 = this.b;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r4 = this.c;
        i97.a r5 = i97.a.a;
        long r6 = System.currentTimeMillis() - this.d;
        Object r7 = o51.g.b(this.a.c.e);
        int r8 = this.a.c.e.c.ordinal();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "updateType");
        Intrinsics.checkNotNullParameter(r13, "it");
        LinkedHashMap r9 = new LinkedHashMap();
        if (r7 != null) goto L5;
        r7 = 0L;
    L5:
        r9.put("current_update_user_id", r7);
        com.bytedance.android.live.revlink.impl.global.c r10 = r2.d;
        if (r10 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r14 = r10.Cg();
    L9:
        if (r14 == null) goto L13;
        UILayout r15 = r14.getUILayout();
        if (r15 == null) goto L13;
        r1 = r15.ordinal();
    L13:
        r9.put("current_ui_layout", Integer.valueOf(r1));
        r9.put("current_range", Integer.valueOf(r8));
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r9.put("update_user_id", r3);
        r9.put("update_type", Integer.valueOf(r4.ordinal()));
        r9.put("exception", r13);
        r9.put(Constants.Keys.duration, Long.valueOf(r6));
        r2.H("anchor_update_layout_failed", r9);
        com.bytedance.android.live.revenue.common.k.c(r13);
        return;
    L8:
        r14 = null;
        goto L9
    }
}
