package com.larus.asr;

import android.view.View;
import java.util.Set;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j1 implements Runnable {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ j1(ChatBottomSpeakerComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomSpeakerComponent r0 = this.a;
        boolean r1 = this.b;
        Set r2 = ChatBottomSpeakerComponent.F2;
        if (a.e(r0) == false) goto L8;
        View r3 = a.c(r0).getView();
        if (r3 == null) goto L9;
        r3.setKeepScreenOn(r1);
        return;
    L9:
        return;
    }
}
