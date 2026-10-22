package tyb;

import android.app.Activity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements f {
    public final /* synthetic */ tyb.a a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ qb4.b c;

    public static final class a implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ qb4.b b;

        public a(Activity r1, qb4.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L3:
            if (this.a.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.a.isDestroyed() == true) goto L18;
            qb4.b r0 = this.b;     // Catch: Throwable -> L11
            if (r0.b == false) goto L19;
            r0.c.dismissVerifyDialog();     // Catch: Throwable -> L11
            return;
        L19:
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ qb4.b b;

        public b(Activity r1, qb4.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L3:
            if (this.a.isFinishing() == false) goto L5;
            return;
        L5:
            if (this.a.isDestroyed() == true) goto L18;
            qb4.b r0 = this.b;     // Catch: Throwable -> L11
            if (r0.b == false) goto L19;
            r0.c.dismissVerifyDialog();     // Catch: Throwable -> L11
            return;
        L19:
            return;
        }
    }

    public final void onFail(int r2, JSONObject r3) {
        PassportLog.d("n_action_bdturing", "verify failed, code: " + r2);
        tyb.a.a(this.a, "fail");
        UICallbackExecutor.execute(new a(this.b, this.c));
    }

    public final void onSuccess(int r2, JSONObject r3) {
        PassportLog.d("n_action_bdturing", "verify success, code: " + r2);
        tyb.a.a(this.a, "succ");
        UICallbackExecutor.execute(new b(this.b, this.c));
    }

    public d(tyb.a r1, Activity r2, qb4.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
