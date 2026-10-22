package com.bytedance.android.livesdk.chatroom.ui;

import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class j9 implements Runnable {
    public final /* synthetic */ SimpleInputDialogFragment a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ j9(SimpleInputDialogFragment r1, long r2, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleInputDialogFragment r1 = this.a;
        long r6 = this.b;
        int r0 = this.c;
        int r5 = this.d;
        int r2 = SimpleInputDialogFragment.p;
        if (r1.isResumed() == true) goto L5;
        return;
    L5:
        if (r1.e == false) goto L15;
        com.bytedance.android.livesdk.utils.t2.b(r1.getContext(), r1.h);
        int r4 = r0 + 1;
        EditText r8 = r1.h;
        if (r8 == null) goto L14;
        if (r4 > r5) goto L16;
        r8.postDelayed(new j9(r1, r6, r4, r5), r6);
        return;
    L16:
        return;
    L14:
        return;
    }
}
