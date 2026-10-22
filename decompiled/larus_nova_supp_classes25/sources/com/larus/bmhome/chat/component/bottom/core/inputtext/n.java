package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ChatInputMentionPanelController c;
    public final /* synthetic */ MentionFilePickerType d;

    public n(View r1, View r2, ChatInputMentionPanelController r3, MentionFilePickerType r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.b;     // Catch: Throwable -> L4
        r0.post(new o(r0, this.c, this.d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
