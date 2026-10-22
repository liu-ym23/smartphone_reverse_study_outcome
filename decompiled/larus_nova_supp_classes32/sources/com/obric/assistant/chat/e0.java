package com.obric.assistant.chat;

import android.view.View;
import com.larus.utils.logger.FLogger;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e0 implements Runnable {
    public final /* synthetic */ ObricChatUIServiceImpl a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ e0(ObricChatUIServiceImpl r1, View r2) {
        this.a = r1;
        this.b = r2;
        this.c = 2131389063;
        this.d = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricChatUIServiceImpl r0 = this.a;
        View r1 = this.b;
        int r2 = this.c;
        boolean r3 = this.d;
        Set r4 = ObricChatUIServiceImpl.g;
        r0.getClass();
        View r5 = r1.findViewById(r2);
        if (r5 != null) goto L5;
        FLogger.a.i("ObricChatUIServiceImpl", "ensureToolbarBottomSafeInset skip, toolbarLayout not found, id=" + r2);
    L5:
        if (r5 == null) goto L8;
        ObricChatUIServiceImpl.Q(r5, r3);
        return;
    }
}
