package r0c;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements d {
    public final Context a;
    public final boolean b;
    public final String c;
    public final boolean d;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L7
            if (r0.d == false) goto L5;
            e.a(r0.a, "key_result_forwarded_image", r0.c);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            q0c.b r1 = p0c.a.a();     // Catch: Throwable -> L7
            c r2 = this.a;     // Catch: Throwable -> L7
            r1.goImageForwardSelectPage(r2.a, r2.c, 16);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.a, 2131891907);
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        return this.b;
    }

    public c(Context r1, boolean r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
