package com.bytedance.android.live.liveinteract.voicechat.emoji;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ InteractEmojiPanel a;

    public c(InteractEmojiPanel r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((TextView) this.a.findViewById(2131388939)).setMaxWidth((s1.y() - ((TextView) this.a.findViewById(2131385960)).getWidth()) - s1.f(48.0f));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
