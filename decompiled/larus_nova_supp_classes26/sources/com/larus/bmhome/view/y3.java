package com.larus.bmhome.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y3 implements Runnable {
    public final WeakReference<ChatMessageList> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public Function0<Unit> f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        ChatMessageList r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == true) goto L7;
        return;
    L7:
        if (this.c == false) goto L23;
        int r1 = this.e;
        if (r1 < 30) goto L24;
        this.e = r1 - 3;
        if (this.d == false) goto L13;
        r0.scrollBy(0, 30);
    L14:
        Function0<Unit> r2 = this.f;
        if (r2 == null) goto L17;
        r2.invoke();
    L17:
        r0.postDelayed(r0.getAutoPollTask(), 100);
        if (this.e > 0) goto L25;
        c("maxScrollY is zero, stop directly");
        return;
    L25:
        return;
    L13:
        r0.scrollBy(0, -30);
        goto L14
    L24:
        return;
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

    public y3(ChatMessageList r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = new WeakReference(r2);
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        FLogger.a.i("RecyclerViewAutoScrollTask", r3);
        this.b = false;
        ChatMessageList r4 = this.a.get();
        if (r4 == null) goto L6;
        r4.removeCallbacks(r4.getAutoPollTask());
        return;
    }

    public final void b(boolean r2, int r3, Function0<Unit> r4) {
        if (this.b == false) goto L5;
        c("is moving when start, so stop first");
    L5:
        int r5 = Math.abs(r3);
        this.e = r5;
        if (r5 != 0) goto L8;
        return;
    L8:
        this.f = r4;
        this.c = true;
        this.b = true;
        this.d = r2;
        run();
    }
}
