package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements com.bytedance.android.scope.o {
    public final ConcurrentHashMap<String, Integer> a;
    public final ResourceRecordService b;
    public final c c;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j d;

    public final void onStart() {
        this.c.c = true;
    }

    public final void onStop() {
        this.b.E();
        c r0 = this.c;
        r0.c = false;
        if (r0.b.getEnable() == false) goto L9;
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((a) r1.next()).leaveRoom();
    L9:
        this.d.yj();
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "md5");
        Integer r0 = this.a.get(r4);
        if (r0 == null) goto L5;
        this.a.put(r4, Integer.valueOf(r0.intValue() + 1));
        return;
    L5:
        this.a.put(r4, 1);
    }

    public w(ResourceRecordService r2, c r3, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r4) {
        Intrinsics.checkNotNullParameter(r2, "recordService");
        Intrinsics.checkNotNullParameter(r3, "assetCleanGlobalManageService");
        Intrinsics.checkNotNullParameter(r4, "assetsService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ConcurrentHashMap();
    }
}
