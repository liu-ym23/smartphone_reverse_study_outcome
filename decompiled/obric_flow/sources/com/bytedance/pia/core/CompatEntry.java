package com.bytedance.pia.core;

import androidx.annotation.Keep;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.nsr.bridge.d;
import gh.a;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import mh.c;
import nh.i;
import yh.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class CompatEntry {
    public CompatEntry() {
    }

    @Keep
    public static void initialize() {
        Intrinsics.checkNotNullParameter("Initialize PIA-Core-Compat.", "message");
        j.y("Initialize PIA-Core-Compat.", null);
        c r5 = new c(0);
        i r10 = i.f20260b;
        i r11 = r10.f20262a;
        if (r11 != null) goto L5;
        r10.f20262a = r5;
    L10:
        HashMap r12 = a.f17093b;
        r12.put("pia.nsr", d.f7180a);
        r12.put("pia.saveSnapshot", g.f23280a);
        r12.put("pia.removeSnapshot", yh.d.f23274a);
        r12.put("pia.postWorkerMessage", wh.d.f22866a);
        return;
    L5:
        i r13 = r11.f20262a;
    L6:
        i r14 = r11;
        r11 = r13;
        if (r11 == null) goto L9;
        r13 = r11.f20262a;
        goto L6
    L9:
        r14.f20262a = r5;
        goto L10
    }
}
