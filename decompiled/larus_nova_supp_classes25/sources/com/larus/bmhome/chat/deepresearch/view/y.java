package com.larus.bmhome.chat.deepresearch.view;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.model.MarkDownSelectorSettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y implements Runnable {
    public int a;
    public CustomMarkdownTextView b;
    public final /* synthetic */ a0 c;

    public final void a() {
        int r0 = this.a;
        boolean r2 = true;
        if (r0 != 1) goto L6;
        this.c.getClass();
        zh8.a.a.getReceiver().c().i6("MarkdownClickProcessor performSingleClick", true);
    L16:
        this.a = 0;
        return;
    L6:
        if (r0 != 2) goto L9;
        a0 r1 = this.c;
        r1.m = SystemClock.elapsedRealtime();
        this.c.b(this.b, false);
        goto L16
    L9:
        if (r0 != 3) goto L16;
        if (((MarkDownSelectorSettings) this.c.l.getValue()).getTripleClickStrategy() > 0) goto L14;
        r2 = false;
    L14:
        if (r2 == false) goto L16;
        a0 r3 = this.c;
        r3.n = SystemClock.elapsedRealtime();
        this.c.c(this.b, false);
        goto L16
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

    public y(a0 r1) {
        this.c = r1;
    }
}
