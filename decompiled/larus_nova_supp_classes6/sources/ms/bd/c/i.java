package ms.bd.c;

import android.app.Activity;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i implements Runnable {
    public final /* synthetic */ Activity a;

    public final void a() {
        Activity r1 = this.a;
        int r2 = n.a;
        if (Build.VERSION.SDK_INT >= 22) goto L11;
    L8:
        n.c(1);
        return;
    L11:
        Field r3 = n.a((String) p2.a(16777217, 0, 0, "ffca17", new byte[]{118, 106, 20, 7, 1, 41, 97, 9, 51, 33, 103, 42, 49, 22, 26, 41, 115, 78, 38, 40})).getDeclaredField((String) p2.a(16777217, 0, 0, "d50414", new byte[]{120, 5, 70, 70, 11, 49, 117, 17, 115}));     // Catch: Throwable -> L10
        r3.setAccessible(true);     // Catch: Throwable -> L10
        String r4 = r3.get(r1).toString();     // Catch: Throwable -> L10
        String r5 = r1.getComponentName().getClassName();     // Catch: Throwable -> L10
        if (r5.contains(r4) == true) goto L8;
        p2.a(16777222, 0, 0, r5 + ((String) p2.a(16777217, 0, 0, "a71127", new byte[]{43})) + r4, null);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(Activity r1) {
        this.a = r1;
    }
}
