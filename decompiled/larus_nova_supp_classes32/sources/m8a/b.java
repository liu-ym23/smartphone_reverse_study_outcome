package m8a;

import android.content.Context;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ d.a c;
    public final /* synthetic */ d d;

    public final void a() {
        String r0 = this.a.f;     // Catch: Throwable -> L15
        if (r0 != null) goto L5;
    L9:
        d.c r1 = d.b(this.d, this.a);     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        d r2 = this.d;     // Catch: Throwable -> L15
        r2.c.post(new a(r2, r1));     // Catch: Throwable -> L15
        return;
    L13:
        d.c(this.d, this.b, this.c);     // Catch: Throwable -> L15
        return;
    L5:
        if (r0.startsWith("asset") == false) goto L9;
        d.c r3 = d.a(this.d, this.b, this.a);     // Catch: Throwable -> L15
        if (r3 == null) goto L19;
        d r4 = this.d;     // Catch: Throwable -> L15
        r4.c.post(new a(r4, r3));     // Catch: Throwable -> L15
        return;
    L19:
        return;
    L15:
        th = move-exception;
        LLog.e("BigImageDrawingHelper", "loadOriginBitmap failed: " + th.toString());
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

    public b(d r1, d.a r2, Context r3, ImageRequest r4, d.a r5) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
