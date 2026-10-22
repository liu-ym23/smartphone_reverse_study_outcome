package m52;

import android.os.Message;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements WeakHandler.IHandler {
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: m52.a$a, reason: collision with other inner class name */
    public static final class RunnableC0247a implements Runnable {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ LinkedList b;

        public RunnableC0247a(Function1 r1, LinkedList r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(this.b);     // Catch: Throwable -> L4
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
        if (r5.what != 17234) goto L18;
        Object r6 = r5.obj;
        if (r6 == null) goto L15;
        LinkedList r7 = (LinkedList) r6;
        Iterator r0 = r7.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        h52.c r1 = (h52.c) r0.next();
        b r2 = this.a;
        r2.g.a(r1, r2.e);
        goto L9
    L11:
        b r3 = this.a;
        Function1<? super List<? extends h52.c>, Unit> r4 = r3.h;
        if (r4 == null) goto L19;
        r3.f.post(new RunnableC0247a(r4, r7));
        return;
    L19:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.IPublicScreenMessageModel>");
    }
}
