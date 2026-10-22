package com.larksuite.framework.utils;

import com.ss.android.lark.log.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h0 {
    public final HashMap<String, Object> a;

    public static class a {
        public static final h0 a = null;

        static {
            a = new h0();
        }
    }

    public h0() {
        this.a = new HashMap();
    }

    public final Object a(String r2) {
        return this.a.remove(r2);
    }

    public final void b(String r3, Object r4) {
        this.a.put(r3, r4);
        int r5 = this.a.size();
        if (r5 <= 10) goto L6;
        Log.e("TransmitHelper", "Transmit Too Many items: " + r5);
        return;
    L6:
        if (r5 <= 1) goto L10;
        Log.w("TransmitHelper", "Transmit over ONE item: " + r5);
        return;
    }
}
