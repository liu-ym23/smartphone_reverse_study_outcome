package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r6 implements Runnable {
    public final /* synthetic */ EditText a;

    public /* synthetic */ r6(EditText r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r0 = this.a;
        int r1 = CoreInputComponent.d3;
        r0.scrollTo(0, 0);
    }
}
