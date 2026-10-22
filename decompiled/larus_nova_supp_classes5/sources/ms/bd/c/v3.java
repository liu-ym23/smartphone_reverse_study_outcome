package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v3 {
    public static volatile v3 d;
    public static final JSONObject e = null;
    public final Context a;
    public boolean b;
    public s3 c;

    public final synchronized void b() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.b = true;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT >= 35) goto L13;
        monitor-exit(this);
        return;
    L13:
        c();     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
        if (this.b == false) goto L10;
        Context r0 = this.a;     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        if (Build.VERSION.SDK_INT < 35) goto L10;
        this.c = new s3();     // Catch: Throwable -> L12
        ((WindowManager) r0.getSystemService((String) p2.a(16777217, 0, 0, "d87c2f", new byte[]{98, 51, 74, 19, 2, 102}))).addScreenRecordingCallback(this.a.getMainExecutor(), this.c);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final void finalize() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.b == true) goto L6;
    L11:
        monitor-exit(this);
        super.finalize();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 35) goto L11;
        if (this.c == null) goto L10;
        ((WindowManager) this.a.getSystemService((String) p2.a(16777217, 0, 0, "d54e11", new byte[]{98, 62, 73, 21, 1, 49}))).removeScreenRecordingCallback(this.c);     // Catch: Throwable -> L14
    L10:
        this.b = false;     // Catch: Throwable -> L14
        goto L11
    }

    static {
        e = new JSONObject();
    }

    public v3(Context r2) {
        this.b = false;
        this.a = r2.getApplicationContext();
    }

    public static v3 a(Context r2) {
        if (d != null) goto L15;
        monitor-enter(v3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new v3(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(v3.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }
}
