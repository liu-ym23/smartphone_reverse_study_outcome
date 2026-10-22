package s72;

import android.os.Message;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements WeakHandler.IHandler {
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: s72.a$a, reason: collision with other inner class name */
    public static final class RunnableC0276a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ k32.a b;

        public RunnableC0276a(a r1, k32.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.f.invoke(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(b r1) {
        this.a = r1;
    }

    public final void handleMsg(Message r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.what != 12345) goto L14;
        Object r4 = r3.obj;
        if ((r4 instanceof va) == true) goto L8;
        r4 = null;
    L8:
        va r5 = (va) r4;
        if (r5 != null) goto L11;
        return;
    L11:
        k32.a r6 = (k32.a) this.a.e.invoke(r5);
        this.a.d.post(new RunnableC0276a(this, r6));
        return;
    }
}
