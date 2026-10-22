package xr9;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements wr9.e {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // wr9.e
    public final long a() {
        return SystemClock.elapsedRealtime();
    }
}
