package l52;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o;
import com.bytedance.android.livesdk.interactivity.square.j;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements o<d> {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o
    public final void a(d r10) {
        d r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "updateInfo");
        com.bytedance.android.livesdk.interactivity.square.c r1 = ((j) this.a).i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "updateInfo");
        ArrayList r0 = new ArrayList();
        int r13 = r11.a;
        if (r13 <= 0) goto L19;
        int r2 = 0;
    L5:
        if (r2 >= r13) goto L19;
        h52.c r3 = (h52.c) ((ArrayDeque) r1.a).poll();
        if (r3 == null) goto L18;
        if ((System.currentTimeMillis() - r3.d()) >= r1.c) goto L11;
        r0.add(r3);
        goto L18
    L11:
        Iterator r4 = ((ArrayDeque) r1.a).iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        h52.c r5 = (h52.c) r4.next();
        if ((System.currentTimeMillis() - r5.d()) < r1.c) goto L18;
        r4.remove();
    L18:
        r2 = r2 + 1;
    L19:
        Iterator r14 = r0.iterator();
    L21:
        if (r14.hasNext() == false) goto L23;
        h52.c r6 = (h52.c) r14.next();
        m52.b r7 = this.a.d;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        ((LinkedList) r7.a).add(r6);
        goto L21
    L23:
        m52.b r15 = this.a.d;
        if (r15.a.isEmpty() == false) goto L27;
        return;
    L27:
        if (r15.c == null) goto L32;
        HandlerThread r8 = r15.d;
        if (r8 == null) goto L32;
        if (ThreadMethodProxy.isAlive(r8) != true) goto L32;
    L33:
        Message.obtain(r15.c, 17234, new LinkedList(r15.a)).sendToTarget();
        ((LinkedList) r15.a).clear();
        return;
    L32:
        HandlerThread r9 = zb2.a.a();
        r15.d = r9;
        r15.c = new WeakHandler(r9.getLooper(), r15.b);
        goto L33
    }
}
