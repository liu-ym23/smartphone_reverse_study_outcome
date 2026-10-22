package n8a;

import android.graphics.RenderNode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public final void a() {
        TraceEvent.beginSection("BlurView.reBlur");
    L15:
        th = move-exception;
        TraceEvent.endSection("BlurView.reBlur");
        throw th;
    L4:
        if (this.a.u == true) goto L13;
        a r1 = this.a;     // Catch: Throwable -> L15
        if (r1.y == false) goto L13;
        r1.e();     // Catch: Throwable -> L15
        a r2 = this.a;     // Catch: Throwable -> L15
        RenderNode r3 = r2.a;     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
    L12:
        a r4 = this.a;     // Catch: Throwable -> L15
        r4.y = false;     // Catch: Throwable -> L15
        r4.invalidate();     // Catch: Throwable -> L15
        goto L13
    L10:
        if (r2.f == null) goto L12;
        r3.beginRecording().drawBitmap(this.a.f, 0.0f, 0.0f, null);     // Catch: Throwable -> L15
        this.a.a.endRecording();     // Catch: Throwable -> L15
    L13:
        TraceEvent.endSection("BlurView.reBlur");
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

    public b(a r1) {
        this.a = r1;
    }
}
