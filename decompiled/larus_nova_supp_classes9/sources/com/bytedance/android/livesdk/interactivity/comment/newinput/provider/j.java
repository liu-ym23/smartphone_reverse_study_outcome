package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.livesdk.widget.EmojiEditView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Runnable {
    public final /* synthetic */ e.c a;
    public final /* synthetic */ CharSequence b;

    public j(e.c r1, CharSequence r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        EmojiEditView r0 = this.a.f;
        if (r0 == null) goto L5;
        r0.setText(this.b);
    L5:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r1 = this.a.b.V();
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r2 = r1.g;
        if (r2 == null) goto L12;
        com.bytedance.android.live.base.model.data.activityemoji.b r3 = r2.k;
        if (r3 == null) goto L12;
        this.a.b.C(r3);
    L12:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r4 = this.a.b.V();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r5 = r4.g;
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.api.emoji.a r6 = r5.l;
        if (r6 == null) goto L19;
        this.a.b.g(r6);
    L19:
        this.a.b.c();
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
