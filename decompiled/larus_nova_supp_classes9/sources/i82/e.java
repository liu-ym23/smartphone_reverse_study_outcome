package i82;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ VSMsgBoardDress b;
    public final /* synthetic */ View c;

    public e(f r1, VSMsgBoardDress r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        CopyOnWriteArrayList<String> r0 = this.a.b;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<String> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        if (String.valueOf(this.b.getDressId()).equals(r2) == false) goto L9;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L28;
        CopyOnWriteArrayList<String> r4 = this.a.b;
        VSMsgBoardDress r5 = this.b;
        if (r5 == null) goto L18;
        Long r6 = Long.valueOf(r5.getDressId());
    L19:
        r4.add(String.valueOf(r6.longValue()));
        f r7 = this.a;     // Catch: Exception -> L22
        View r8 = this.c;     // Catch: Exception -> L22
        VSMsgBoardDress r9 = this.b;     // Catch: Exception -> L22
        r7.h(r9);     // Catch: Exception -> L22
        r7.i(r8, r9);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L18:
        r6 = null;
        goto L19
    L28:
        return;
    L13:
        r3 = false;
        goto L14
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
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
}
