package com.bytedance.android.live.ktv.common.karaokestation.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final Map<String, y> a;
    public int b;
    public String c;
    public int d;

    public d() {
        this(0, 15);
    }

    public d(int r5, int r6) {
        String r1 = null;
        if ((r6 & 1) == 0) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
    L7:
        if ((r6 & 2) == 0) goto L9;
        int r2 = FirstLevelTab.Unknown.getValue();
    L11:
        if ((r6 & 4) == 0) goto L14;
        r1 = "";
    L14:
        if ((r6 & 8) == 0) goto L16;
        r5 = FirstLevelTab.Unknown.getValue();
    L16:
        Intrinsics.checkNotNullParameter(r0, "secondLevelTabDataMap");
        Intrinsics.checkNotNullParameter(r1, "defaultSecondLevelTab");
        this.a = r0;
        this.b = r2;
        this.c = r1;
        this.d = r5;
        return;
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
