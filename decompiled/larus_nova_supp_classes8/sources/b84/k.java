package b84;

import android.os.Environment;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t;
import com.bytedance.common.utility.io.IOUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import i84.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements Runnable {
    public final o0 a;

    public final void a() {
        ArrayList r1 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.a.F == false) goto L30;
    L21:
        Iterator r0 = r1.iterator();
    L23:
        if (r0.hasNext() == false) goto L29;
        String r2 = (String) r0.next();
        IOUtils.deletePath(r2);     // Catch: Throwable -> L27
        t.d("dt " + r2);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L30:
        r1.add(Environment.getExternalStorageDirectory().getPath() + s.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L36:
        r1.add(Environment.getExternalStorageDirectory().getPath() + "/" + s.d());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L4:
        if (this.a.F == false) goto L6;
        String r3 = "device_id";
    L7:
        r1.add(this.a.getContext().getExternalCacheDir().getParent() + "/" + r3);     // Catch: Throwable -> L9
        goto L12
    L6:
        r3 = s.d();     // Catch: Throwable -> L9
        goto L7
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

    public k(o0 r1) {
        this.a = r1;
    }
}
