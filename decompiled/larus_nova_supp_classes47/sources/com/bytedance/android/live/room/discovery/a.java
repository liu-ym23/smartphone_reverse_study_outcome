package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.di;
import com.bytedance.android.livesdk.config.ei;
import com.bytedance.android.livesdk.config.fi;
import com.bytedance.android.livesdk.config.gi;
import com.bytedance.android.livesdk.config.hi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final List<Integer> a = null;
    public static final HashMap<Integer, Integer> b = null;

    static {
        a = new ArrayList();
        b = new HashMap();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        StringBuilder r0 = new StringBuilder("MAX_SIZE=");
        hi r1 = hi.a;
        r0.append((((Number) r1.getValue()).intValue() * 3) / 2);
        r0.append(", COUNT_THRESHOLD=");
        r0.append((Integer) r1.getValue());
        r0.append(", POOR_THRESHOLD=");
        r0.append((Float) fi.a.getValue());
        r0.append(", BAD_THRESHOLD=");
        r0.append((Float) di.a.getValue());
        r0.append(", RISK_THRESHOLD=");
        r0.append((Float) gi.a.getValue());
        r0.append(", GOOD_THRESHOLD=");
        r0.append((Float) ei.a.getValue());
        ALogger.i("AnchorStableMode", r0.toString());
        return;
    }
}
