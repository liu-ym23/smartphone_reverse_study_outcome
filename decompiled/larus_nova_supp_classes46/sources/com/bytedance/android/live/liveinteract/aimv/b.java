package com.bytedance.android.live.liveinteract.aimv;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static List a() {
        ArrayList r0 = new ArrayList();
        Float r2 = Float.valueOf(0.0f);
        r0.add(new Pair(r2, r2));
        r0.add(new Pair(Float.valueOf(0.5f), r2));
        r0.add(new Pair(Float.valueOf(0.6f), Float.valueOf(0.8f)));
        Float r3 = Float.valueOf(0.7f);
        Float r4 = Float.valueOf(1.0f);
        r0.add(new Pair(r3, r4));
        r0.add(new Pair(r4, r4));
        return r0;
    }

    static {
    }

    public static boolean b(IRoom r2) {
        if (r2 == null) goto L9;
        Map r3 = r2.getAnchorABMap();
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("linkmic_order_sing_ai_mv");
        if (r4 == null) goto L9;
        int r5 = CastIntegerProtector.parseInt(r4);
    L11:
        if (r5 != 1) goto L14;
        return true;
    L14:
        return false;
    L9:
        r5 = 0;
        goto L11
    }
}
