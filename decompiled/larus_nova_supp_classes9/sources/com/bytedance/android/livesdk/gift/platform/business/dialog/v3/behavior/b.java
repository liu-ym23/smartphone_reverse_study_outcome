package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior;

import android.view.MotionEvent;
import com.bytedance.android.live.ai.api.IAiService;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public HashMap<String, String> a;
    public final int b;
    public final int c;
    public final IAiService d;
    public final ArrayList<com.bytedance.android.livesdk.behavior.a> e;

    public b(int r4) {
        this.a = new HashMap();
        this.b = 1;
        IAiService r0 = k.f(IAiService.class);
        this.d = r0;
        if (r0 == null) goto L5;
        r0.getHarService();
    L5:
        if (r0 == null) goto L7;
        r0.getOhrService();
    L7:
        this.b = 3;
        this.c = r4;
        this.a.put("scene", String.valueOf(3));
        this.a.put("touchSlop", String.valueOf(r4));
        this.a.put("har", "0");
        this.a.put("ohr", "0");
        this.e = new ArrayList();
    }

    public final void setResult(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final com.bytedance.android.livesdk.behavior.a a(MotionEvent r8, int r9, String r10, int r11, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        Intrinsics.checkNotNullParameter(r10, "roomId");
        Intrinsics.checkNotNullParameter(r14, "eventType");
        this.a.put("roomId", r10);
        this.a.put("position", String.valueOf(r9));
        this.a.put("eventType", r14);
        this.a.put(sz1.a.KEY_WIDTH, String.valueOf(r11));
        this.a.put(sz1.a.KEY_HEIGHT, String.valueOf(r13));
        com.bytedance.android.livesdk.behavior.a r15 = new com.bytedance.android.livesdk.behavior.a(r8, r9, this.c, r11, r13);
        this.e.add(r15);
        return r15;
    }
}
