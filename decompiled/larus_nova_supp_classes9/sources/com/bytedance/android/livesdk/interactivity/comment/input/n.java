package com.bytedance.android.livesdk.interactivity.comment.input;

import android.widget.EditText;
import com.bytedance.android.livesdk.utils.t2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements Runnable {
    public final /* synthetic */ VideoCommentSearchFragment a;

    public n(VideoCommentSearchFragment r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        if (this.a.getContext() == null) goto L19;
        EditText r0 = this.a.h;
        if (r0 == null) goto L10;
        r0.setFocusableInTouchMode(true);
    L10:
        EditText r1 = this.a.h;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.requestFocusFromTouch() != true) goto L18;
        t2.b(this.a.getContext(), this.a.h);
        return;
    L18:
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
}
