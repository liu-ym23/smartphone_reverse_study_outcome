package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatInputMentionPanelController b;
    public final /* synthetic */ MentionFilePickerType c;

    public o(View r1, ChatInputMentionPanelController r2, MentionFilePickerType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.isAttachedToWindow() == false) goto L9;
        this.b.a.u.invoke(this.c);     // Catch: Throwable -> L6
        return;
    }
}
