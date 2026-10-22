package mqa;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.message.util.ToolUtils;
import java.util.List;
import uqa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static volatile d e;
    public final a a;
    public final Application b;
    public final boolean c;
    public c d;

    public d(Context r6) {
        f r0 = new f();
        new Handler(Looper.getMainLooper());
        if ((r6 instanceof Application) == false) goto L5;
        this.b = (Application) r6;
    L6:
        Application r7 = this.b;
    L21:
        th = move-exception;
        th.printStackTrace();
        boolean r8 = false;
        r0.b = false;
    L23:
        this.c = r8;
        a r1 = new a(this.b, r8);
        this.a = r1;
        if (r8 == true) goto L31;
    L29:
        Application r2 = r1.a;
        a.C0031a r9 = new a.C0031a(r1, r2);
        r1.b = r9;
        r2.registerActivityLifecycleCallbacks(r9);
        return;
    L31:
        r1.c.delete();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L8:
        if (r0.a == false) goto L10;
        r8 = r0.b;     // Catch: Throwable -> L21
        goto L23
    L10:
        r0.a = true;     // Catch: Throwable -> L21
        PolarisFileWrapper r3 = new PolarisFileWrapper(r7.getFilesDir(), "process.lock");     // Catch: Throwable -> L21
        if (r3.isDirectory() == false) goto L14;
        r3.delete();     // Catch: Throwable -> L21
    L14:
        if (r3.exists() == true) goto L16;
        r3.createNewFile();     // Catch: Throwable -> L21
    L16:
        r0.b = r0.a(r3);     // Catch: Throwable -> L21
        if (com.bytedance.push.utils.f.a == false) goto L19;
        StringBuilder r4 = new StringBuilder("isFirstLockFile: sIsFirst = ");     // Catch: Throwable -> L21
        r4.append(r0.b);     // Catch: Throwable -> L21
        r4.append("  process = ");     // Catch: Throwable -> L21
        List r5 = vqa.a.a;     // Catch: Throwable -> L21
        r4.append(ToolUtils.getCurProcessName(r7));     // Catch: Throwable -> L21
        r4.append(r3.getPath());     // Catch: Throwable -> L21
        com.bytedance.push.utils.f.b("ExclusiveFileLock", r4.toString());     // Catch: Throwable -> L21
    L19:
        r8 = r0.b;     // Catch: Throwable -> L21
        goto L23
    L5:
        this.b = (Application) r6.getApplicationContext();
        goto L6
    }

    public static d a(Context r2) {
        if (e != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }
}
