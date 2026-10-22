package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Runnable {
    public final /* synthetic */ e.c a;

    public f(e.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmojiEditView r0 = this.a.f;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.requestFocus();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
