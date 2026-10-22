package com.larksuite.component.card.plugin;

import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final com.larksuite.component.card.cardcontainer.c a(LKEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r3 = r2.h;
        Object r1 = null;
        if ((r3 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r4 = (ILynxBridgeContext) r3;
    L6:
        if (r4 == null) goto L12;
        ILynxContainerContext r5 = r4.getContainerContext();
        if (r5 == null) goto L12;
        Map r6 = r5.getBizExtra();
        if (r6 == null) goto L12;
        Object r7 = r6.get("card_share_data");
    L14:
        if ((r7 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L18;
        r1 = r7;
    L18:
        return (com.larksuite.component.card.cardcontainer.c) r1;
    L12:
        r7 = null;
        goto L14
    L5:
        r4 = null;
        goto L6
    }
}
