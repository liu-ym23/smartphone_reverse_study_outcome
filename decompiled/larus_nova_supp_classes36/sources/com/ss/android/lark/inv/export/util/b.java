package com.ss.android.lark.inv.export.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b implements View.OnClickListener {
    public static boolean c = true;
    public static final a d = null;
    public final long a;
    public final boolean b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.c = true;     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    static {
        d = new a();
    }

    public b() {
        this.b = false;
        this.a = 1000;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        boolean r1 = false;
        if (this.b == true) goto L5;
        long r2 = this.a;
        Map r0 = h9b.e.a;
        String r3 = String.valueOf(r11.hashCode());
        if (TextUtils.isEmpty(r3) == false) goto L11;
        Log.e("InvDebouncingUtils", "The key is null.");
    L27:
        if (r1 == false) goto L37;
        ((com.ss.android.lark.inv.export.util.a) this).e.onClick(r11);
        return;
    L37:
        return;
    L11:
        if (r2 >= 0) goto L13;
        Log.e("InvDebouncingUtils", "The duration is less than 0.");
        goto L27
    L13:
        long r4 = SystemClock.elapsedRealtime();
        ConcurrentHashMap r6 = (ConcurrentHashMap) h9b.e.a;
        if (r6.size() < 64) goto L22;
        Iterator r7 = r6.entrySet().iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        if (r4 < ((Long) ((Map.Entry) r7.next()).getValue()).longValue()) goto L18;
        r7.remove();
    L22:
        ConcurrentHashMap r8 = (ConcurrentHashMap) h9b.e.a;
        Long r9 = (Long) r8.get(r3);
        if (r9 != null) goto L25;
    L26:
        r8.put(r3, Long.valueOf(r4 + r2));
        r1 = true;
        goto L27
    L25:
        if (r4 < r9.longValue()) goto L27;
    L5:
        if (c == false) goto L35;
        c = false;
        r11.postDelayed(d, this.a);
        ((com.ss.android.lark.inv.export.util.a) this).e.onClick(r11);
        return;
    }
}
