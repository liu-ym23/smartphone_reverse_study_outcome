package com.bytedance.android.ec.core.widget;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class d implements View.OnClickListener {
    public static final Map<String, Long> e = null;
    public static final long f = 0;
    public final long a;
    public long b;
    public final long c;
    public final String d;

    public static final class a {
    }

    public abstract void a(View r1);

    static {
        e = new LinkedHashMap();
        f = ECSettingKeys.r();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r17) {
        String r1 = this.d;
        if (r1 != null) goto L5;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L20;
        return;
    L20:
        long r11 = SystemClock.uptimeMillis();
        long r12 = r11 - this.b;
        dm.a.a("FreqLimitClickListener").a("canClick nowTime=" + r11 + ", lastClickTime=" + this.b + ", duration=" + r12 + ", clickDisableDuration=" + this.a);
        if (r12 <= this.a) goto L23;
        this.b = r11;
        boolean r13 = true;
    L24:
        if (r13 == true) goto L26;
        return;
    L26:
        if (r17 == null) goto L29;
        dm.a.a("FreqLimitClickListener").a("doClick");
        a(r17);
        return;
    L29:
        return;
    L23:
        r13 = false;
        goto L24
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L17;
        long r14 = SystemClock.uptimeMillis();
        Map<String, Long> r15 = e;
        Long r16 = (Long) ((LinkedHashMap) r15).get(r1);
        if (r16 == null) goto L12;
        long r18 = r16.longValue();
    L13:
        long r19 = r14 - r18;
        dm.a.a("FreqLimitClickListener").a("canBindClick bindKey=" + this.d + ", nowTime=" + r14 + ", lastClickTime=" + r18 + ", duration=" + r19 + ", bindKeyClickDisableDuration=" + this.c);
        if (r19 <= this.c) goto L16;
        r15.put(r1, Long.valueOf(r14));
        goto L17
    L16:
        r10 = false;
        goto L18
    L12:
        r18 = 0;
        goto L13
    }

    public d(Long r10, String r11) {
        this.d = r11;
        if (r10 == null) goto L5;
        long r0 = r10.longValue();
    L6:
        this.a = r0;
        if (r10 == null) goto L9;
        long r12 = r10.longValue();
    L10:
        this.c = r12;
        return;
    L9:
        r12 = f;
        goto L10
    L5:
        r0 = f;
        goto L6
    }

    public /* synthetic */ d(Long r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
