package kfc;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.push.utils.f;
import com.ss.android.newmedia.redbadge.RedBadgerException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class b implements a {
    public abstract int d(Context r1, ComponentName r2) throws RedBadgerException;

    public boolean e(int r1) {
        return true;
    }

    public b() {
    }

    public boolean c(Context r3, ComponentName r4, int r5) {
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        if (r5 > 0) goto L19;
        f.b("CnHomeBadger", "count must bigger than 0");
        return false;
    L19:
        int r0 = d(r3, r4);     // Catch: RedBadgerException -> L14
        if (r0 < 0) goto L16;
        a(r3, r4, r0 + r5);     // Catch: RedBadgerException -> L14
        return true;
    L16:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        f.b("CnHomeBadger", "args is null");
        return false;
    }

    public boolean f(Context r6, ComponentName r7, int r8) {
        if (r6 == null) goto L19;
        if (r7 == null) goto L19;
        if (r8 > 0) goto L21;
        f.b("CnHomeBadger", "count must bigger than 0");
        return false;
    L21:
        int r3 = d(r6, r7);     // Catch: RedBadgerException -> L16
        int r4 = r3 - r8;     // Catch: RedBadgerException -> L16
        if (r4 >= 0) goto L13;
        f.b("CnHomeBadger", "cur badge number is " + r3 + " but try to reduce " + r8 + ", can't do it");     // Catch: RedBadgerException -> L16
        return false;
    L13:
        a(r6, r7, r4);     // Catch: RedBadgerException -> L16
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        f.b("CnHomeBadger", "args is null");
        return false;
    }
}
