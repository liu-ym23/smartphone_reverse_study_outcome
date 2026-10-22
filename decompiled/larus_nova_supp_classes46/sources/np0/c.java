package np0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ RecyclerViewScrollReportHelper a;
    public final /* synthetic */ List b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L4
            RecyclerViewScrollReportHelper.a(r0.a, r0.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(RecyclerViewScrollReportHelper r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerViewScrollReportHelper r0 = this.a;     // Catch: Throwable -> L8
        if (r0.b == false) goto L5;
        r0.g.post(new a(this));     // Catch: Throwable -> L8
    L6:
        this.a.b = false;     // Catch: Throwable -> L8
        return;
    L5:
        RecyclerViewScrollReportHelper.a(r0, this.b);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
