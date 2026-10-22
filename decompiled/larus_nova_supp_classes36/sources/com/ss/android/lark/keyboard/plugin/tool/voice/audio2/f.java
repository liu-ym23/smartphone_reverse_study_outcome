package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ AudioKBPlugin a;

    public f(AudioKBPlugin r1, MotionEvent r2) {
        this.a = r1;
    }

    public final void a() {
        this.a.J().e(null);
        throw null;
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
