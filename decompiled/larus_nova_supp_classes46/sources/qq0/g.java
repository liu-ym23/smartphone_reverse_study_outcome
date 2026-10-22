package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public final /* synthetic */ AudienceShelfDisplayDialog a;
    public final /* synthetic */ List b;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudienceShelfDisplayDialog.ba0(this.a.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(AudienceShelfDisplayDialog r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudienceShelfDisplayDialog r0 = this.a;     // Catch: Throwable -> L8
        if (r0.m == false) goto L5;
        r0.T90(2131386216).post(new a(this));     // Catch: Throwable -> L8
    L6:
        this.a.m = false;     // Catch: Throwable -> L8
        return;
    L5:
        AudienceShelfDisplayDialog.ba0(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
