package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public DataCenter a;
    public final Map<Integer, Boolean> b;

    public h() {
        Boolean r3 = Boolean.TRUE;
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, r3), TuplesKt.to(1, r3), TuplesKt.to(2, r3), TuplesKt.to(3, r3), TuplesKt.to(6, r3), TuplesKt.to(4, r3), TuplesKt.to(5, r3), TuplesKt.to(7, r3), TuplesKt.to(8, r3), TuplesKt.to(9, r3)});
    }

    public final void a(View r6, int r7, boolean r8) {
        if (this.b.containsKey(Integer.valueOf(r7)) == true) goto L5;
        return;
    L5:
        int r0 = 0;
        boolean r2 = true;
        switch(r7) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L18;
            case 9: goto L8;
            default: goto L18;
        };
    L8:
        this.b.put(9, Boolean.valueOf(r8));
        goto L18
    L9:
        this.b.put(0, Boolean.valueOf(!r8));
        goto L18
    L10:
        this.b.put(6, Boolean.valueOf(!r8));
        goto L18
    L11:
        this.b.put(5, Boolean.valueOf(r8));
        goto L18
    L12:
        this.b.put(4, Boolean.valueOf(!r8));
        goto L18
    L13:
        this.b.put(3, Boolean.valueOf(!r8));
        goto L18
    L14:
        this.b.put(2, Boolean.valueOf(!r8));
        goto L18
    L15:
        this.b.put(1, Boolean.valueOf(!r8));
        goto L18
    L16:
        this.b.put(0, Boolean.valueOf(r8));
    L18:
        if (r7 != 8) goto L24;
        if (r6 == null) goto L47;
        if (r8 == false) goto L22;
        float r9 = 0.0f;
    L23:
        r6.setAlpha(r9);
        return;
    L22:
        r9 = 1.0f;
        goto L23
    L47:
        return;
    L24:
        Iterator<Map.Entry<Integer, Boolean>> r10 = this.b.entrySet().iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        Map.Entry<Integer, Boolean> r11 = r10.next();
        int r3 = r11.getKey().intValue();
        if (r11.getValue().booleanValue() == true) goto L26;
        ALogger.i("EnterAnimWidget", "hide. key=" + r3);
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        int r13 = 0;
    L33:
        if (r6 != null) goto L35;
    L39:
        if (r2 == true) goto L42;
        r0 = 8;
    L42:
        UIUtils.setViewVisibility(r6, r0);
        return;
    L35:
        if (r6.getVisibility() == r13) goto L39;
        DataCenter r14 = this.a;
        if (r14 == null) goto L39;
        r14.put("data_enter_anim_visiable", Boolean.valueOf(r2));
        goto L39
    L32:
        r13 = 8;
        goto L33
    }
}
