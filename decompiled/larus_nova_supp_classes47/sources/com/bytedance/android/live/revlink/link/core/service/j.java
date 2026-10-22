package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IAnchorUpdateLayoutContent.UpdateAnchorLayoutType c;
    public final /* synthetic */ long d;

    public j(l r1, String r2, IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        ExtraResponse r13 = (ExtraResponse) r12;
        l r14 = this.a;
        int r0 = 0;
        r14.b = false;
        v r15 = r14.getContext().getMultiLinkMonitor();
        String r1 = this.b;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r2 = this.c;
        i97.a r3 = i97.a.a;
        long r4 = System.currentTimeMillis() - this.d;
        Object r5 = o51.g.b(this.a.c.e);
        int r6 = this.a.c.e.c.ordinal();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r2, "updateType");
        LinkedHashMap r7 = new LinkedHashMap();
        if (r5 != null) goto L5;
        r5 = 0L;
    L5:
        r7.put("current_update_user_id", r5);
        com.bytedance.android.live.revlink.impl.global.c r8 = r15.d;
        if (r8 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r9 = r8.Cg();
    L9:
        if (r9 == null) goto L13;
        UILayout r10 = r9.getUILayout();
        if (r10 == null) goto L13;
        r0 = r10.ordinal();
    L13:
        r7.put("current_ui_layout", Integer.valueOf(r0));
        r7.put("current_range", Integer.valueOf(r6));
        if (r1 != null) goto L16;
        r1 = "";
    L16:
        r7.put("update_user_id", r1);
        r7.put("update_type", Integer.valueOf(r2.ordinal()));
        r7.put(Constants.Keys.duration, Long.valueOf(r4));
        r15.H("anchor_update_layout_success", r7);
        return;
    L8:
        r9 = null;
        goto L9
    }
}
