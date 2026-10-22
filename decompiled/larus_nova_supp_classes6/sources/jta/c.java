package jta;

import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.common.utility.io.IOUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public final void a() {
        ArrayList r2 = new ArrayList();
    L12:
        th = move-exception;
        th.printStackTrace();
    L15:
        if (this.a.b == false) goto L42;
    L27:
        Iterator r0 = r2.iterator();
    L29:
        if (r0.hasNext() == false) goto L35;
        IOUtils.deletePath((String) r0.next());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L35:
        return;
    L42:
        r2.add(Environment.getExternalStorageDirectory().getPath() + nta.d.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L18
    L36:
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L25
        r3.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L25
        r3.append("/");     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(nta.d.a) == false) goto L23;
        nta.d.a = nta.d.a("Ynl0ZWRhbmNl");     // Catch: Throwable -> L25
    L23:
        r3.append(nta.d.a);     // Catch: Throwable -> L25
        r2.add(r3.toString());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L4:
        if (this.a.b == false) goto L7;
        String r4 = "device_id";
    L10:
        r2.add(this.a.a.getExternalCacheDir().getParent() + "/" + r4);     // Catch: Throwable -> L12
        goto L15
    L7:
        if (TextUtils.isEmpty(nta.d.a) == false) goto L9;
        nta.d.a = nta.d.a("Ynl0ZWRhbmNl");     // Catch: Throwable -> L12
    L9:
        r4 = nta.d.a;     // Catch: Throwable -> L12
        goto L10
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

    public c(d r1) {
        this.a = r1;
    }
}
