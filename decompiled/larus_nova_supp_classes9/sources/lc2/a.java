package lc2;

import android.os.Message;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements WeakHandler.IHandler {
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: lc2.a$a, reason: collision with other inner class name */
    public static final class RunnableC0244a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ LinkedList b;

        public RunnableC0244a(a r1, LinkedList r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.i.invoke(this.b);     // Catch: Throwable -> L4
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

    public final void handleMsg(Message r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.what != 10086) goto L16;
        Object r6 = r5.obj;
        if (r6 == null) goto L13;
        LinkedList r7 = (LinkedList) r6;
        Iterator r0 = r7.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        f<?> r1 = (f) r0.next();
        b r2 = this.a;
        r2.h.a(r1, r2.f);
        goto L9
    L11:
        this.a.g.post(new RunnableC0244a(this, r7));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.bytedance.android.livesdk.interactivity.api.entity.AbsTextMessage<out com.bytedance.android.live.base.model.message.IBaseLiveMessage?>>");
    }
}
