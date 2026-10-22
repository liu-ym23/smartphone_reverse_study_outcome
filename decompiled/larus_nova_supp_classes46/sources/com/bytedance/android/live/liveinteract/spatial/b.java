package com.bytedance.android.live.liveinteract.spatial;

import ch0.e;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final List<ILinkPlayerInfoBridge> b(List<e> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<e> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next().a);
        goto L7
    L9:
        return r0;
    }

    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "content");
        ALogger.i("SpatialAudio_".concat(r1), r2);
    }
}
