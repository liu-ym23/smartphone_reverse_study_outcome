package com.lynx.tasm.behavior;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10214a;

    public c(Map r5) {
        if (r5 != null) goto L6;
        this.f10214a = new HashMap();
        return;
    L6:
        this.f10214a = new HashMap(r5);
    }

    public final a a(String r5) {
        a r10 = (a) this.f10214a.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new RuntimeException(td.d.b("No BehaviorController defined for class ", r5));
    }

    public final void b(a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        HashMap r10 = this.f10214a;
        String r11 = r5.f10172a;
        a r12 = (a) r10.get(r11);
        if (r12 == null) goto L7;
        Log.d("LynxError", "Duplicated Behavior For Name: " + r11 + ", " + r12 + " will be override");
    L7:
        r10.put(r11, r5);
    }
}
