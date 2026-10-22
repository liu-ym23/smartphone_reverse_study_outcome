package com.larus.bmhome.view;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ ChatConstraintLayout a;

    public /* synthetic */ s(ChatConstraintLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatConstraintLayout r0 = this.a;
        int r1 = ChatConstraintLayout.H;
        ViewCompat.requestApplyInsets(r0);
    }
}
