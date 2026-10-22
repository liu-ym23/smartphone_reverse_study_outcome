package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i9;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(h9 r5, Map r6) {
        if (r5 == null) goto L20;
        List r0 = r5.getGiftIds();
        Map r2 = null;
        if ((!r0.isEmpty()) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L11;
        Long r1 = (Long) ListProtector.get(r0, 0);
        if (r1 == null) goto L11;
        long r3 = r1.longValue();
    L12:
        r6.put("focus_gift_id", String.valueOf(r3));
        Map r7 = r5.getGiftMap();
        if ((!r7.isEmpty()) == false) goto L15;
        r2 = r7;
    L15:
        if (r2 == null) goto L21;
        i9 r8 = (i9) r2.get(Long.valueOf(r3));
        if (r8 == null) goto L22;
        r6.put("focus_gift_name", r8.getGiftName());
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r3 = 0;
        goto L12
    }
}
