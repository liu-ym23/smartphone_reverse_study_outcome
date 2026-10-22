package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final o51.e a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$defaultUILayout");
        boolean r0 = ((Boolean) l51.a.q.getValue(null, l51.a.a[16])).booleanValue();
        if (((CopyOnWriteArrayList) r5.getAnchorLinkUserCenter().a).size() <= 2) goto L6;
        return o51.e.f.e;
    L6:
        if (IRoomKtKt.getStreamType(r5.getRoom()) != LiveMode.SCREEN_RECORD) goto L14;
        String r3 = r5.eg();
        com.bytedance.android.livesdk.link.model.p r6 = r5.getAnchorLinkUserCenter().getGuestInfo(r5.eg(), null);
        if (r6 == null) goto L11;
        String r7 = r6.getInteractId();
        if (r7 == null) goto L11;
    L16:
        return new o51.e.C0283e(r0, r3, r7);
    L11:
        r7 = "";
        goto L16
    L14:
        return o51.e.g.e;
    }

    public static final r b(com.bytedance.android.livesdk.link.model.m r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$toLocal");
        return new r(r8.getUiLayout(), r8.getRange(), IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal(), r8.isOrientation(), r8.getBigAnchorId(), new o(r8.getLayoutDetails()));
    }
}
